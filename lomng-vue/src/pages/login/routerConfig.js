const routerConfig = {
    "ADMIN": [{
        router: 'root',                           //匹配 router.map.js 中注册名 registerName = root 的路由
        children: [                               //root 路由的子路由配置
            'user', 'company', 'order', 'orderDetail'
        ]
    }],
    "USER": [{
        router: 'root',                           //匹配 router.map.js 中注册名 registerName = root 的路由
        children: [                               //root 路由的子路由配置
           'order', 'orderDetail'
        ]
    }]
}
export default routerConfig
