import {request, METHOD} from '@/utils/request'

function getAllTransportOrderItem(transportOrderItem, pn = 1, size = 5) {
    return request("/ord/transportOrderItem/list", METHOD.GET, {
        ...transportOrderItem,
        current: pn,
        size: size,
    })
}

function addTransportOrderItem(transportOrderItem) {
    return request("/ord/transportOrderItem", METHOD.POST, transportOrderItem)
}

function delTransportOrderItem(id) {
    return request("/ord/transportOrderItem", METHOD.DELETE, {
        id: id
    })
}

function getTransportOrderItem(id) {
    return request("/ord/transportOrderItem", METHOD.GET, {
        id: id
    })
}

function editTransportOrderItem(transportOrderItem) {
    return request("/ord/transportOrderItem", METHOD.PUT, transportOrderItem)
}

export default {
    getAllTransportOrderItem,
    addTransportOrderItem,
    delTransportOrderItem,
    getTransportOrderItem,
    editTransportOrderItem
}
