package com.tinno.test.itms.model

/**
 * @Author:Fizzer
 * @Email: qianqian.ma@tinno.com
 * @Date: 2023/3/3
 * @Descript: 项目模型
 */
data class ProjectModel(
    val id: String,
    /**
     * 任务类型
     */
    val taskType: String,
    /**
     * 任务名字
     */
    val name: String,

    val testsuiteId: String,
    /**
     * 项目名
     */
    val project: String,
    /**
     * 项目Key
     */
    val projectKey: String,
    val leaderId: String,
    val startTime: String,
    val endTime: String,
    val status: Int,
    /**
     * 更新人ID
     */
    val updatemanId: String,
    /**
     * 创建人ID
     */
    val createmanId: String,
    val createTime: String,
    val updateTime: String,
    /**
     * 测试准备项
     */
    val taskPreparation: String,

    /**
     * 测试策略
     */
    val taskStrategy: String,
    /**
     * 任务修改信息
     */
    val taskModification: String,
    /**
     * 测试风险
     */
    val taskRisk: String,
    val taskSwpath: String,
    /**
     * 描述
     */
    val description: String,
    val mailto: String,
    val mailcc: String,
    /**
     * 项目ID
     */
    val projectId: String,
    /**
     * leader名字
     */
    val leaderName: String,
    /**
     * 创建人名字
     */
    val createmanName: String,
    /**
     * 是否超时
     */
    val isTimeOut: Boolean,
    val participants: String,
    val isSysLead: Boolean,
)