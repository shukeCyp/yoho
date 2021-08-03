package com.example.mvpcore

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvpcore.annotation.MvpModel

/**
 *   @Author:YaPeng
 *   @Date:2021/7/22
 *   @Email:3536815334@qq.com
 *   DESC:数据仓库层
 */
abstract class BaseRepository<M : IModel> {
    /**
     * 1Repository-1Model
     */
//    protected lateinit var mModel : M
//    init {
//        mModel = createModel()
//    }
//    abstract fun createModel(): M
    /**
     * 1Repository-N个Model
     * 利用注解+反射
     */
    init {
        initModel()
    }


    private fun initModel(){
        //用于判断是否有MvpModel注解修饰的属性
        var hasModel:Boolean = false
        //拿到当前类的类型
        val thisType:Class<BaseRepository<M>> = this@BaseRepository::class.java as Class<BaseRepository<M>>
        /**
         * 获取到当前类型类中所有字段属性
         * ->declaredFields----->拿到当前类中用public修饰的字段和父类中public修饰的字段
         * ->fields --------->拿到当前类中所有字段属性
         */
        val declaredFields = thisType.declaredFields
        if (declaredFields.size > 0){
            for (field in declaredFields){
                //判断该字段是否带有MvpModel注解
                val annotation = field.getAnnotation(MvpModel::class.java)
                if (annotation != null){
                    //打开当前field的可访问性
                    field.isAccessible = true
                    //取到当前属性的类型名，通过类型名来获取反射
                    var name : String = ""
                    if (Build.VERSION.SDK_INT >= 28){
                        name = field.genericType.typeName
                    }else{
                        name = field.type.name
                    }
                    var typeName = Class.forName(name)
                    //实例化
                    var newInstance = typeName.newInstance()
                    field.set(this,newInstance)
                    hasModel = true
                }
            }
            //判断是否有MvpModel注解修饰的属性字段
            if (!hasModel){
                throw IllegalStateException("has not any Model")
            }
        }
        else{
            throw IllegalStateException("has not any field")
        }
    }
}