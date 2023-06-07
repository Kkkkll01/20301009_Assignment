<template>
    <div>
        <a-modal
                :confirm-loading="confirmLoading"
                :title="title"
                :visible="visible"

                @cancel="handleCancel"
                @ok="handleOk"
        >
            <a-form-model :labelCol="{span:4}" :model="form" :wrapperCol="{span:16}" ref="addForm">
                <a-form-model-item label="账号" prop="account">
                    <a-input placeholder="请输入" v-model="form.account"/>
                </a-form-model-item>
                <a-form-model-item label="用户名" prop="username">
                    <a-input placeholder="请输入" v-model="form.username"/>
                </a-form-model-item>
                <a-form-model-item label="密码" prop="password">
                    <a-input placeholder="请输入" v-model="form.password" type="password"/>
                </a-form-model-item>
                <a-form-model-item label="电话" prop="phone">
                    <a-input placeholder="请输入" v-model="form.phone"/>
                </a-form-model-item>
                <a-form-model-item label="状态" prop="status">
                    <a-select v-model="form.status">
                        <a-select-option value="true">启用</a-select-option>
                        <a-select-option value="false">禁用</a-select-option>
                    </a-select>
                </a-form-model-item>
                <a-form-model-item label="邮箱" prop="email">
                    <a-input placeholder="请输入" v-model="form.email"/>
                </a-form-model-item>
                <a-form-model-item label="角色" prop="role">
                    <a-select v-model:value="form.role">
                        <a-select-option v-for="(item, index) in role" :key="index" :value="item">{{item}}</a-select-option>
                    </a-select>
                </a-form-model-item>
            </a-form-model>
        </a-modal>
    </div>
</template>
<script>
    import {role} from './user'
    export default {
        props: {},
        data() {
            return {
                title: '新增',
                confirmLoading: false,
                visible: false,
                form: {
                    account: null,
                    username: null,
                    password: null,
                    phone: null,
                    status: null,
                    email: null,
                    role: null,
                },
                role: role
            };
        },
        created() {
        },
        methods: {
            showModal() {
                this.visible = true;
            },
            handleOk: function () {
                this.$req.addUser(this.form).then(res => {
                    this.visible = false
                    this.$emit("confirm")
                    this.$message.success(res.data.message, 2)
                }).catch(err => {
                    this.$refs.addForm.resetFields()
                    this.$message.error(err.response.data.message, 2)
                })
            },
            handleCancel() {
                this.$refs.addForm.resetFields()
                this.visible = false;
            },
        },
    };
</script>


