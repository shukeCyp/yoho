package com.example.homepage



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


/**
 *   @Author:YaPeng
 *   @Date:2021/7/30
 *   @Email:3536815334@qq.com
 */
class HomePageGridAdapter(var list: MutableList<Int>,var tvlist : MutableList<String>) : BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        var holder: ViewHolder? = null
        if (convertView == null) {
            //解析布局
            convertView = LayoutInflater.from(parent.context).inflate(R.layout.homepage_gridview_item, null)
            //创建ViewHolder持有类
            holder = ViewHolder()
            //将每个控件的对象保存到持有类中
            holder.imageView = convertView!!.findViewById<View>(R.id.homepage_grid_item_image) as ImageView
            holder.textView = convertView.findViewById<View>(R.id.homepage_grid_item_text) as TextView
            //将每个convertView对象中设置这个持有类对象
            convertView.setTag(holder)
        }
        //每次需要使用的时候都会拿到这个持有类
        holder = convertView!!.tag as ViewHolder
        //然后可以直接使用这个类中的控件，对控件进行操作，而不用重复去findViewById了
        Glide.with(holder.imageView).load(list.get(position)).circleCrop().into(holder.imageView)
        holder.textView.setText(tvlist.get(position))
        return convertView
    }

    class ViewHolder{
       lateinit var imageView:ImageView
       lateinit var textView : TextView
    }


}