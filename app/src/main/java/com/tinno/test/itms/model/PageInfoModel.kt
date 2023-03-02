package com.tinno.test.itms.model

/**
 * @Author:Fizzer
 * @Email: qianqian.ma@tinno.com
 * @Date: 2023/3/2
 * @Descript: 首页项目数据结构的PageInfo
 */
data class PageInfoModel(
    val total: Int,
    val page: Int,
    val limit: Int,
    val pages: Int
)