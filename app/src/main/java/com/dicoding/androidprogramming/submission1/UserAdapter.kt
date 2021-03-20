package com.dicoding.androidprogramming.submission1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context: Context): BaseAdapter() {
    internal var users = arrayListOf<User>()
    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(i: Int): Any {
        return users[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View){
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_avatar)
        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvUsername: TextView = view.findViewById(R.id.tv_username)
        private val tvRepository: TextView = view.findViewById(R.id.tv_repository)
        private val tvFollowers: TextView = view.findViewById(R.id.tv_followers)
        private val tvFollowing: TextView = view.findViewById(R.id.tv_following)

        internal fun bind (user: User){
            tvName.text = user.name
            tvUsername.text = user.username
            tvRepository.text = user.repository
            tvFollowers.text = user.followers
            tvFollowing.text = user.following
            user.avatar?.let { imgAvatar.setImageResource(it) }
        }
    }
}