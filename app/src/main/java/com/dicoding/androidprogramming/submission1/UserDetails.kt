package com.dicoding.androidprogramming.submission1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserDetails : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val imgAvatarDetail: CircleImageView = findViewById(R.id.img_avatar_detail)
        val tvUsernameDetail: TextView = findViewById(R.id.tv_username_detail)
        val tvNameDetail: TextView = findViewById(R.id.tv_name_detail)
        val tvLocationDetail: TextView = findViewById(R.id.tv_location_detail)
        val tvCompanyDetail: TextView = findViewById(R.id.tv_company_detail)
        val tvRepositoryDetail: TextView = findViewById(R.id.tv_repository_detail)
        val tvFollowersDetail: TextView = findViewById(R.id.tv_followers_detail)
        val tvFollowingDetail: TextView = findViewById(R.id.tv_following_detail)
        val btnShare: Button = findViewById(R.id.btn_share)

        val user = intent.getParcelableExtra<User>(EXTRA_DATA) as User

        user.avatar?.let { imgAvatarDetail.setImageResource(it) }
        tvUsernameDetail.text = user.username
        tvNameDetail.text = user.name
        tvLocationDetail.text = user.location
        tvCompanyDetail.text = user.company
        tvRepositoryDetail.text = user.repository
        tvFollowersDetail.text = user.followers
        tvFollowingDetail.text = user.following

        btnShare.setOnClickListener{
            val message = tvUsernameDetail.text
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to: "))
        }
    }
}