## /User

```text
暂无描述
```

#### 公共Header参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Query参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Body参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /User/发货人登录

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/User/shipper/login

#### 请求方式

> POST

#### Content-Type

> urlencoded

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| phonenumber | 12345678910 | String | 是 | 手机号 |
| username | fbteh | String | 是 | 用户名 |
| password | 738ye731 | String | 是 | 密码 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /User/发货人注册

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/User/shipper/register

#### 请求方式

> POST

#### Content-Type

> urlencoded

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| username | jjeklw | String | 是 | 用户名 |
| password | wqdygi8o213 | String | 是 | 密码 |
| phonenumber | 12345678910 | String | 是 | 手机号 |
| type | 1-发货人 2-承运人 | Integer | 是 | 用户类别 |
| shipper_id | - | String | 是 | 发货人ID号 |
| id | - | String | 是 | ID号 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /User/承运人登录

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/User/client/login

#### 请求方式

> POST

#### Content-Type

> urlencoded

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| phonenumber | 12345678910 | String | 是 | 手机号 |
| username | fbteh | String | 是 | 用户名 |
| password | 738ye731 | String | 是 | 密码 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /User/承运人注册

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/User/client/register

#### 请求方式

> POST

#### Content-Type

> urlencoded

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| username | jjeklw | String | 是 | 用户名 |
| password | wqdygi8o213 | String | 是 | 密码 |
| phonenumber | 12345678910 | String | 是 | 手机号 |
| client_id | - | String | 是 | 承运人ID号 |
| id | - | String | 是 | ID号 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Administrators

```text
暂无描述
```

#### 公共Header参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Query参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Body参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Administrators/删除订单信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/Administrators/order/{order_id}

#### 请求方式

> POST

#### Content-Type

> none

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| order_id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Administrators/获取发货人账户

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/Administrators/user/{shipper_id}

#### 请求方式

> GET

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| shipper_id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Administrators/修改用户信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/Administrators/user/{id}

#### 请求方式

> PUT

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| id | - | - |

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| username | fw83d | String | 是 | 用户名 |
| phonenumber | 10987654321 | String | 是 | 手机号 |
| password | 12uhd | String | 是 | 密码 |
| type | 1-发货人 2-承运人 | String | 是 | 用户类别 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Administrators/获取承运人账户

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/Administrators/user/{client_id}

#### 请求方式

> GET

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| client_id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Administrators/删除用户信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/Administrators/user/{id}

#### 请求方式

> DELETE

#### Content-Type

> none

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Administrators/获取订单信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/Administrators/order/:order_id

#### 请求方式

> GET

#### Content-Type

> none

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| order_id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Shipper

```text
发货人
```

#### 公共Header参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Query参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Body参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Shipper/修改账号信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/shipper/{shipper_id}/

#### 请求方式

> PUT

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| shipper_id | - | - |

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| username | fw83d | String | 是 | 用户名 |
| phonenumber | 10987654321 | String | 是 | 手机号 |
| password | 12uhd | String | 是 | 密码 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Shipper/新建订单信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/shipper/{shipper_id}/order/

#### 请求方式

> POST

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| shipper_id | - | - |

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| order_id | - | String | 是 | 订单号 |
| name | - | String | 是 | 商品名 |
| weight | - | String | 是 | 重量 |
| price | - | String | 是 | 运费 |
| phonenumber | - | String | 是 | 手机号 |
| ship_address | - | String | 是 | 发货地址 |
| deli_address | - | String | 是 | 收货地址 |
| client_id | - | String | 是 | 承运商id |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Shipper/修改订单

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/shipper/{shipper_id}/order/{order_id}

#### 请求方式

> PUT

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| shipper_id | - | - |
| order_id | - | - |

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| name | - | String | 是 | 商品名 |
| weight | - | String | 是 | 重量 |
| price | - | String | 是 | 运费 |
| phonenumber | - | String | 是 | 手机号 |
| ship_address | - | String | 是 | 发货地址 |
| deli_address | - | String | 是 | 收货地址 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Shipper/删除订单

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/shipper/{shipper_id}/order/{order_id}

#### 请求方式

> DELETE

#### Content-Type

> none

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| shipper_id | - | - |
| order_id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Shipper/获取订单

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/shipper/{shipper_id}/order/

#### 请求方式

> GET

#### Content-Type

> none

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| shipper_id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Client

```text
承运人
```

#### 公共Header参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Query参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Body参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Client/修改账号信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/client/{client_id}/

#### 请求方式

> PUT

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| client_id | - | - |

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| username | fw83d | String | 是 | 用户名 |
| phonenumber | 10987654321 | String | 是 | 手机号 |
| password | 12uhd | String | 是 | 密码 |
| type | 1-发货人 2-承运人 | String | 是 | 用户类别 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Client/修改订单

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/client/{client_id}/order/{order_id}

#### 请求方式

> PUT

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| client_id | - | - |
| order_id | - | - |

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| name | - | String | 是 | 商品名 |
| weight | - | String | 是 | 重量 |
| price | - | String | 是 | 运费 |
| phonenumber | - | String | 是 | 手机号 |
| ship_address | - | String | 是 | 发货地址 |
| deli_address | - | String | 是 | 收货地址 |
| client_id | - | String | 是 | 承运商id |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Client/获取订单

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/client/{client_id}/order/

#### 请求方式

> GET

#### Content-Type

> none

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| client_id | - | - |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Order

```text
订单
```

#### 公共Header参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Query参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 公共Body参数

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| 暂无参数 |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```

## /Order/订单状态获取

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口URL

> localhost:8080/order/{order}/

#### 请求方式

> POST

#### Content-Type

> urlencoded

#### 路径变量

| 参数名 | 示例值 | 参数描述 |
| --- | --- | ---- |
| order | - | - |

#### 请求Body参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| --- | --- | ---- | ---- | ---- |
| order_id | - | String | 是 | 订单号 |
| name | - | String | 是 | 商品名 |
| weight | - | String | 是 | 重量 |
| price | - | String | 是 | 运费 |
| phonenumber | - | String | 是 | 手机号 |
| ship_address | - | String | 是 | 发货地址 |
| deli_address | - | String | 是 | 收货地址 |
| client_id | - | String | 是 | 承运商id |

#### 预执行脚本

```javascript
暂无预执行脚本
```

#### 后执行脚本

```javascript
暂无后执行脚本
```
