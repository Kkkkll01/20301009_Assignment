<template>
    <a-card>
        <div :class="advanced ? 'search' : null">
            <a-form-model :model="form" layout="horizontal" ref="queryForm">
                <div :class="advanced ? null: 'fold'">
                    <a-row>
                        <a-col :md="8" :sm="24">
                            <a-form-model-item
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}"
                                    label="订单号"
                                    prop="orderNumber"
                            >
                                <a-input placeholder="请输入" v-model="form.orderNumberLike"/>
                            </a-form-model-item>
                        </a-col>

                        <a-col :md="8" :sm="24">
                            <a-form-model-item
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}"
                                    label="用户"
                                    prop="userId"
                            >
                                <a-select v-model="form.userId" placeholder="请选择">
                                    <a-select-option v-for="(item, index) in userList" :key="index" :value="item.id">{{item.username}}</a-select-option>
                                </a-select>
                            </a-form-model-item>

                        </a-col>
                        <a-col :md="8" :sm="24">
                            <a-form-model-item
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}"
                                    label="公司"
                                    prop="companyId"
                            >
                                <a-select v-model="form.companyId" placeholder="请选择">
                                    <a-select-option v-for="(item, index) in companyList" :key="index" :value="item.id">{{item.name}}</a-select-option>
                                </a-select>
                            </a-form-model-item>
                        </a-col>
                    </a-row>
                    <a-row v-if="advanced">
                    </a-row>
                </div>
                <span style="float: right; margin-top: 3px;">
          <a-button @click="query" type="primary">查询</a-button>
          <a-button @click="reset" style="margin-left: 8px">重置</a-button>
          <a @click="toggleAdvanced" style="margin-left: 8px">
            {{advanced ? '收起' : '展开'}}
            <a-icon :type="advanced ? 'up' : 'down'"/>
          </a>
        </span>
            </a-form-model>
        </div>
        <div>
            <a-space class="operator">
                <a-button @click="addNew" type="primary">新建</a-button>
                <a-button @click="flush">刷新</a-button>
            </a-space>
            <standard-table
                    :columns="columns"
                    :dataSource="dataSource"
                    :pagination="{...pagination, onChange: onPageChange}"
                    rowKey="id"
            >
                <div slot="action" slot-scope="{text, record}">
                    <a-button size="small" style="margin-right: 5px" type="primary">
                        <router-link :to="`/orderDetail?id=${record.id}`">详情</router-link>
                    </a-button>
                    <a-button @click="edit(record)" size="small" style="margin-right: 5px" v-if="record.status != '已送达' && roles == 'ADMIN'">
                        <a-icon type="edit"/>
                        更新物流
                    </a-button>
                    <a-button @click="finish(record)" size="small" style="margin-right: 5px" v-if="record.status != '已送达'  && roles == 'ADMIN'">
                        送达
                    </a-button>
<!--                    <a-popconfirm-->
<!--                            @confirm="deleteRecord(record)"-->
<!--                            cancel-text="取消"-->
<!--                            ok-text="确认"-->
<!--                            title="是否要删除?"-->
<!--                    >-->
<!--                        <a-button size="small" style="margin-right: 5px" type="danger">-->
<!--                            <a-icon type="delete"/>-->
<!--                            删除-->
<!--                        </a-button>-->
<!--                    </a-popconfirm>-->
                </div>
            </standard-table>
        </div>

        <add @confirm="flush" ref="add"/>
        <ItemAdd @confirm="flush" ref="edit"/>
    </a-card>
</template>

<script>
    import StandardTable from '@/components/table/StandardTable'
    import Add from "./Add";
    import ItemAdd from "./item/Add";
    import {mapGetters} from "vuex";

    const columns = [
        {
            title: '订单号',
            dataIndex: 'orderNumber'
        },
        {
            title: '用户名',
            dataIndex: 'username'
        },
        {
            title: '公司名称',
            dataIndex: 'companyName'
        },
        {
            title: '创建时间',
            dataIndex: 'createTime'
        },
        {
            title: '状态',
            dataIndex: 'status'
        },
        {
            title: '操作',
            width: 300,
            scopedSlots: {customRender: 'action'}
        }
    ]
    const form = {
        orderNumberLike: null,
        orderNumber: null,
        userId: null,
        username: null,
        companyId: null,
        companyName: null,
        status: null,
        createTime: null,
        shipperName: null,
        shipperPhoneNumber: null,
        shipperAddress: null,
        receiverName: null,
        receiverPhoneNumber: null,
        receiverAddress: null,
        remark: null,
    }
    export default {
        name: 'transportOrderList',
        components: {
            Add,
            StandardTable,
            ItemAdd
        },
        computed: {
            ...mapGetters('account', ['roles']),
        },
        data() {
            return {
                tableName: 'transportOrder',
                advanced: false,
                columns: columns,
                dataSource: [],
                form: form,
                pagination: {
                    current: 1,
                    pageSize: 5,
                    total: 0
                },
                userList: [],
                companyList: []
            }
        },
        created() {
            this.getList()
            this.searchUser()
            this.searchCompany()
        },

        methods: {
            getList() {
                this.$req.getAllTransportOrder().then(res => {
                    this.dataSource = res.data.data.records
                    this.pagination.current = res.data.data.current
                    this.pagination.pageSize = res.data.data.size
                    this.pagination.total = res.data.data.total
                })
            },
            query() {
                this.$req.getAllTransportOrder(this.form,
                    this.pagination.current, this.pagination.pageSize).then(res => {
                    this.dataSource = res.data.data.records
                    this.pagination.current = res.data.data.current
                    this.pagination.pageSize = res.data.data.size
                    this.pagination.total = res.data.data.total
                })
            },
            addNew() {
                this.$refs.add.showModal()
            },
            flush() {
                this.getList()
            },
            edit(key) {
                this.$refs.edit.showModal(key.id)

                key.status = '运输中'
                this.$req.editTransportOrder(key)
            },
            reset() {
                this.$refs.queryForm.resetFields()
            },
            deleteRecord(key) {
                this.$req.delTransportOrder(key.id).then(res => {
                    this.$message.success(res.data.message, 2)
                    this.flush()
                })
            },
            toggleAdvanced() {
                this.advanced = !this.advanced
            },
            onPageChange(page, pageSize) {
                this.pagination.current = page
                this.pagination.pageSize = pageSize
                this.query(this.form, page, pageSize)
            },
            searchUser(value) {
                this.$req.getAllUser({username: value}, 1, 100).then(res => {
                    this.userList = res.data.data.records
                })
            },
            fillUser(value) {
                const item = this.userList.find(_ => _.id == value)
                this.form.username = item.username
            },
            searchCompany(value) {
                this.$req.getAllCompany({name: value}, 1, 100).then(res => {
                    this.companyList = res.data.data.records
                })
            },
            fillCompany(value) {
                const item = this.companyList.find(_ => _.id == value)
                this.form.companyName = item.name
            },
            finish(record) {
                record.status = '已送达'
                this.$req.editTransportOrder(record)
            }
        }
    }
</script>

<style lang="less" scoped>
    .search {
        margin-bottom: 54px;
    }

    .fold {
        width: calc(100% - 216px);
        display: inline-block
    }

    .operator {
        margin-bottom: 18px;
    }

    @media screen and (max-width: 900px) {
        .fold {
            width: 100%;
        }
    }
</style>


