<template>
    <div>
        <a-modal
                :confirm-loading="confirmLoading"
                :title="title"
                :visible="visible"
                :body-style="{
                  height: '100px',
                  overflow: 'hidden',
                  overflowY: 'auto',
                }"
                @cancel="handleCancel"
                @ok="handleOk"
        >
            <a-form-model :labelCol="{span:4}" :model="form" :wrapperCol="{span:16}" ref="addForm">
                <a-form-model-item label="站点" prop="location">
                    <a-input placeholder="请输入" v-model="form.location"/>
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
                title: '更新物流',
                confirmLoading: false,
                visible: false,
                form: {
                    transportOrderId: null,
                    status: "运输中",
                    location: null,
                },
            };
        },
        created() {

        },
        methods: {
            showModal(id) {
                this.form.transportOrderId = id
                this.visible = true;
            },
            handleOk: function () {
                this.$req.addTransportOrderItem(this.form).then(res => {
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


