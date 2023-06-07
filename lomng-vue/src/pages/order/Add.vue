<template>
    <div>
        <a-modal
                :confirm-loading="confirmLoading"
                :title="title"
                :visible="visible"
                :body-style="{
                  height: '480px',
                  overflow: 'hidden',
                  overflowY: 'auto',
                }"
                @cancel="handleCancel"
                @ok="handleOk"
        >
            <a-form-model :labelCol="{span:6}" :model="form" :wrapperCol="{span:16}" ref="addForm">
                <a-form-model-item

                        label="用户"
                        prop="userId"
                >
                    <a-select v-model="form.userId" placeholder="请选择" @change="fillUser">
                        <a-select-option v-for="(item, index) in userList" :key="index" :value="item.id">{{item.username}}</a-select-option>
                    </a-select>
                </a-form-model-item>

                <a-form-model-item
                        label="公司"
                        prop="companyId"
                >
                    <a-select v-model="form.companyId" placeholder="请选择" @change="fillCompany">
                        <a-select-option v-for="(item, index) in companyList" :key="index" :value="item.id">{{item.name}}</a-select-option>
                    </a-select>
                </a-form-model-item>
                <a-form-model-item label="发货人姓名" prop="shipperName">
                    <a-input placeholder="请输入" v-model="form.shipperName"/>
                </a-form-model-item>
                <a-form-model-item label="发货人电话号码" prop="shipperPhoneNumber">
                    <a-input placeholder="请输入" v-model="form.shipperPhoneNumber"/>
                </a-form-model-item>
                <a-form-model-item label="发货人地址" prop="shipperAddress">
                    <a-input placeholder="请输入" v-model="form.shipperAddress"/>
                </a-form-model-item>
                <a-form-model-item label="收货人姓名" prop="receiverName">
                    <a-input placeholder="请输入" v-model="form.receiverName"/>
                </a-form-model-item>
                <a-form-model-item label="收货人电话号码" prop="receiverPhoneNumber">
                    <a-input placeholder="请输入" v-model="form.receiverPhoneNumber"/>
                </a-form-model-item>
                <a-form-model-item label="收货人地址" prop="receiverAddress">
                    <a-input placeholder="请输入" v-model="form.receiverAddress"/>
                </a-form-model-item>
                <a-form-model-item label="备注" prop="remark">
                    <a-input placeholder="请输入" v-model="form.remark"/>
                </a-form-model-item>
            </a-form-model>
        </a-modal>
    </div>
</template>
<script>
    export default {
        props: {},
        data() {
            return {
                title: '新增',
                confirmLoading: false,
                visible: false,
                form: {
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
                },
                userList: [],
                companyList: []
            };
        },
        created() {
            this.searchUser()
            this.searchCompany()
        },
        methods: {
            showModal() {
                this.visible = true;
            },
            handleOk: function () {
                this.$req.addTransportOrder(this.form).then(res => {
                    this.visible = false
                    this.$emit("confirm")
                    this.$message.success(res.data.message, 2)
                }).catch(err => {
                    //this.$refs.addForm.resetFields()
                    this.$message.error(err.response.data.message, 2)
                })
            },
            handleCancel() {
                this.$refs.addForm.resetFields()
                this.visible = false;
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
        },
    };
</script>


