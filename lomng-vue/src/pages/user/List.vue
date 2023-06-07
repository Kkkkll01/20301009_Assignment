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
                                    label="账号"
                                    prop="account"
                            >
                                <a-input placeholder="请输入" v-model="form.account"/>
                            </a-form-model-item>
                        </a-col>
                        <a-col :md="8" :sm="24">
                            <a-form-model-item
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}"
                                    label="状态"
                                    prop="status"
                            >
                                <a-select v-model="form.status">
                                    <a-select-option value="true">启用</a-select-option>
                                    <a-select-option value="false">禁用</a-select-option>
                                </a-select>
                            </a-form-model-item>
                        </a-col>
                        <a-col :md="8" :sm="24">
                            <a-form-model-item
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}"
                                    label="角色"
                                    prop="role"
                            >
                                <a-select v-model:value="form.role">
                                    <a-select-option v-for="(item, index) in role" :key="index" :value="item">{{item}}</a-select-option>
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
                <div slot="status" slot-scope="{text, record}">
                    <a-tag :color="record.status ? '#87d068' : '#f50'">
                        {{record.status ? '启用' : '禁用'}}
                    </a-tag>
                </div>
                <div slot="action" slot-scope="{text, record}">
<!--                    <a-button size="small" style="margin-right: 5px" type="primary">-->
<!--                        <router-link :to="`/${tableName}Detail?id=${record.id}`">详情</router-link>-->
<!--                    </a-button>-->
                    <a-button @click="edit(record)" size="small" style="margin-right: 5px">
                        <a-icon type="edit"/>
                        编辑
                    </a-button>
                    <a-popconfirm
                            @confirm="deleteRecord(record)"
                            cancel-text="取消"
                            ok-text="确认"
                            title="是否要删除?"
                    >
                        <a-button size="small" style="margin-right: 5px" type="danger">
                            <a-icon type="delete"/>
                            删除
                        </a-button>
                    </a-popconfirm>
                </div>
            </standard-table>
        </div>

        <add @confirm="flush" ref="add"/>
        <edit @confirm="flush" ref="edit"/>
    </a-card>
</template>

<script>
    import StandardTable from '@/components/table/StandardTable'
    import Add from "./Add";
    import Edit from "./Edit";
    import {role} from './user'

    const columns = [
        {
            title: '账号',
            dataIndex: 'account'
        },
        {
            title: '用户名',
            dataIndex: 'username'
        },
        {
            title: '电话',
            dataIndex: 'phone'
        },

        {
            title: '邮箱',
            dataIndex: 'email'
        },
        {
            title: '角色',
            dataIndex: 'role'
        },
        {
            title: '状态',
            dataIndex: 'status',
            scopedSlots: {customRender: 'status'}
        },
        {
            title: '操作',
            width: 300,
            scopedSlots: {customRender: 'action'}
        }
    ]
    const form = {
        account: null,
        username: null,
        password: null,
        phone: null,
        status: null,
        email: null,
        role: null,
    }
    export default {
        name: 'userList',
        components: {
            Add,
            StandardTable,
            Edit
        },
        data() {
            return {
                tableName: 'user',
                advanced: false,
                columns: columns,
                dataSource: [],
                form: form,
                role: role,
                pagination: {
                    current: 1,
                    pageSize: 5,
                    total: 0
                }
            }
        },
        created() {
            this.getList()
        },
        methods: {
            getList() {
                this.$req.getAllUser().then(res => {
                    this.dataSource = res.data.data.records
                    this.pagination.current = res.data.data.current
                    this.pagination.pageSize = res.data.data.size
                    this.pagination.total = res.data.data.total
                })
            },
            query() {
                this.$req.getAllUser(this.form).then(res => {
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
            },
            reset() {
                this.$refs.queryForm.resetFields()
            },
            deleteRecord(key) {
                this.$req.delUser(key.id).then(res => {
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


