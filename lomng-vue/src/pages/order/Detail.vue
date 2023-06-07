<template>
    <page-layout :title="'单号：' + data.orderNumber" logo="https://gw.alipayobjects.com/zos/rmsportal/nxkuOJlFJuAUhzlMTCEe.png">
        <detail-list size="small" :col="2" slot="headerContent">
            <detail-list-item term="创建人">{{data.username}}</detail-list-item>
            <detail-list-item term="物流公司">{{data.companyName}}</detail-list-item>
            <detail-list-item term="创建时间">{{data.createTime}}</detail-list-item>
            <detail-list-item term="备注">{{data.remark}}</detail-list-item>
        </detail-list>
        <template slot="extra">
            <head-info title="状态" :content="data.status" />
        </template>
        <a-card :bordered="false" title="流程进度">
            <a-steps :current="itemList.length" progress-dot direction="vertical">
                <a-step :title="item.location" v-for="(item, index) in itemList" :key="index">
                    <a-step-item-group  slot="description">
                        <a-step-item :title="item.status"/>
                        <a-step-item :title="item.updateTime"/>
                    </a-step-item-group>
                </a-step>
                <
            </a-steps>
        </a-card>
        <a-card style="margin-top: 24px" :bordered="false" title="订单信息">
            <detail-list title="发货人信息">
                <detail-list-item term="发货人姓名">{{data.shipperName}}</detail-list-item>
                <detail-list-item term="发货人电话号码">{{data.shipperPhoneNumber}}</detail-list-item>
                <detail-list-item term="发货人地址">{{data.shipperAddress}}</detail-list-item>
            </detail-list>
            <detail-list title="收货人信息">
                <detail-list-item term="收货人姓名">{{data.receiverName}}</detail-list-item>
                <detail-list-item term="收货人电话号码">{{data.receiverPhoneNumber}}</detail-list-item>
                <detail-list-item term="收货人地址">{{data.receiverAddress}}</detail-list-item>
            </detail-list>
        </a-card>
        <a-divider style="margin-bottom: 32px"/>
    </page-layout>

</template>

<script>
    import PageLayout from '@/layouts/PageLayout'
    import DetailList from '@/components/tool/DetailList'
    import AStepItem from '@/components/tool/AStepItem'

    import HeadInfo from '@/components/tool/HeadInfo';

    const DetailListItem = DetailList.Item

    export default {
        name: 'BasicDetail',
        components: {DetailListItem, DetailList, PageLayout, HeadInfo, AStepItem},
        data() {
            return {
                data: {},
                itemList: []
            }
        },
        created() {
            const id = this.$route.query.id
            this.$req.getAllTransportOrderItem({transportOrderId: id}, 1, 1000).then(res => {
                this.itemList = res.data.data.records;
            })
            this.$req.getTransportOrder(id).then(res => {
                this.data = res.data.data
            })
        }
    }
</script>

<style lang="less" scoped>
    .title {
        color: @title-color;
        font-size: 16px;
        margin-bottom: 16px;
        font-weight: bold;
    }
</style>


