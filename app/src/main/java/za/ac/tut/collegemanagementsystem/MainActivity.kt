package za.ac.tut.collegemanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import za.ac.tut.collegemanagementsystem.fragments.AboutFragment
import za.ac.tut.collegemanagementsystem.fragments.HomeFragment
import za.ac.tut.collegemanagementsystem.fragments.NoticeFragment
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val aboutFragment = AboutFragment()
    private val noticeFragment = NoticeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}
        replaceFragment(homeFragment)
        
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_info -> replaceFragment(aboutFragment)
                R.id.ic_notifications -> replaceFragment(noticeFragment)
                R.id.ic_dashboard -> replaceFragment(homeFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout,fragment)
            transaction.commit()
        }
    }
}