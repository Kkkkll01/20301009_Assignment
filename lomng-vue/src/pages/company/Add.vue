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
                <a-form-model-item label="物流公司名称" prop="name">
                    <a-input placeholder="请输入" v-model="form.name"/>
                </a-form-model-item>
                <a-form-model-item label="联系人姓名" prop="contactPerson">
                    <a-input placeholder="请输入" v-model="form.contactPerson"/>
                </a-form-model-item>
                <a-form-model-item label="物流公司地址" prop="address">
                    <a-input placeholder="请输入" v-model="form.address"/>
                </a-form-model-item>
                <a-form-model-item label="物流公司电话号码" prop="phoneNumber">
                    <a-input placeholder="请输入" v-model="form.phoneNumber"/>
                </a-form-model-item>
                <a-form-model-item label="联系人电话号码" prop="contactPhoneNumber">
                    <a-input placeholder="请输入" v-model="form.contactPhoneNumber"/>
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
                    name: null,
                    contactPerson: null,
                    address: null,
                    phoneNumber: null,
                    contactPhoneNumber: null,
                },

            };
        },
        created() {
        },
        methods: {
            showModal() {
                this.visible = true;
            },
            handleOk: function () {
                this.$req.addCompany(this.form).then(res => {
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

        },
    };
</script>


