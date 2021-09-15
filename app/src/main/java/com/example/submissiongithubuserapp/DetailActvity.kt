package com.example.submissiongithubuserapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class DetailActvity : AppCompatActivity(){

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setActionBarTitle(title)

        val tvAvatar : CircleImageView = findViewById(R.id.avatar)
        val tvName : TextView = findViewById(R.id.user)
        val tvUsername : TextView = findViewById(R.id.username)
        val tvLocation : TextView = findViewById(R.id.location)
        val tvRepository : TextView = findViewById(R.id.repository)
        val tvCompany : TextView = findViewById(R.id.company)
        val tvFollowers : TextView = findViewById(R.id.followers)
        val tvFollowing : TextView = findViewById(R.id.following)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        val name = user?.name
        val repository = "Repository : ${user?.repository}"
        val username ="Username : ${user?.username}"
        val location = "Location : ${user?.location} "
        val company = "Company : ${user?.company}"
        val followers = "Followers : ${user?.followers}"
        val following = "Following : ${user?.following}"

        //Glide.with(this).load(user.avatar).into(tvAvatar)
        tvAvatar.setImageResource(user?.avatar!!)
        tvName.text =  name
        tvUsername.text = username
        tvLocation.text = location
        tvRepository.text = repository
        tvCompany.text = company
        tvFollowers.text = followers
        tvFollowing.text = following
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }
    private val title = "Detail User's"
}