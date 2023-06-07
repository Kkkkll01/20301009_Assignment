import {request, METHOD} from '@/utils/request'

function getAllCompany(company, pn = 1, size = 5) {
    return request("/ord/company/list", METHOD.GET, {
        ...company,
        current: pn,
        size: size,
    })
}

function addCompany(company) {
    return request("/ord/company", METHOD.POST, company)
}

function delCompany(id) {
    return request("/ord/company", METHOD.DELETE, {
        id: id
    })
}

function getCompany(id) {
    return request("/ord/company", METHOD.GET, {
        id: id
    })
}

function editCompany(company) {
    return request("/ord/company", METHOD.PUT, company)
}

export default {
    getAllCompany,
    addCompany,
    delCompany,
    getCompany,
    editCompany
}
