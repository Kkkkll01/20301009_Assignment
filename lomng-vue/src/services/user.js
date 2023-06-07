import {request, METHOD, removeAuthorization} from '@/utils/request'

/**
 * 登录服务
 * @param name 账户名
 * @param password 账户密码
 * @returns {Promise<AxiosResponse<T>>}
 */
export async function login(name, password) {
  return request('/usr/login', METHOD.POST, {
    account: name,
    password: password
  })
}
/**
 * 退出登录
 */
export function logout() {
  localStorage.removeItem(process.env.VUE_APP_ROUTES_KEY)
  localStorage.removeItem(process.env.VUE_APP_PERMISSIONS_KEY)
  localStorage.removeItem(process.env.VUE_APP_ROLES_KEY)
  removeAuthorization()
}

function getAllUser(user, pn = 1, size = 5) {
  return request("/usr/list", METHOD.GET, {
    ...user,
    current: pn,
    size: size,
  })
}

function addUser(user) {
  return request("/usr", METHOD.POST, user)
}

function delUser(id) {
  return request("/usr", METHOD.DELETE, {
    id: id
  })
}

function getUser(id) {
  return request("/usr", METHOD.GET, {
    id: id
  })
}

function editUser(user) {
  return request("/usr", METHOD.PUT, user)
}

export default {
  login,
  logout,
  getAllUser,
  addUser,
  delUser,
  getUser,
  editUser
}
