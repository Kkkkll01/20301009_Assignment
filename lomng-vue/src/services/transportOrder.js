import {request, METHOD} from '@/utils/request'

function getAllTransportOrder(transportOrder, pn = 1, size = 5) {
    return request("/ord/transportOrder/list", METHOD.GET, {
        ...transportOrder,
        current: pn,
        size: size,
    })
}

function addTransportOrder(transportOrder) {
    return request("/ord/transportOrder", METHOD.POST, transportOrder)
}

function delTransportOrder(id) {
    return request("/ord/transportOrder", METHOD.DELETE, {
        id: id
    })
}

function getTransportOrder(id) {
    return request("/ord/transportOrder", METHOD.GET, {
        id: id
    })
}

function editTransportOrder(transportOrder) {
    return request("/ord/transportOrder", METHOD.PUT, transportOrder)
}

export default {
    getAllTransportOrder,
    addTransportOrder,
    delTransportOrder,
    getTransportOrder,
    editTransportOrder
}
