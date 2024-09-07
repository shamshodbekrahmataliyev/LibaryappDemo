package itcenter.dangara.libaryappdemo

import android.graphics.Color
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import itcenter.dangara.libaryappdemo.Fragment.CategoryFragment
import itcenter.dangara.libaryappdemo.Fragment.FavoriteFragment
import itcenter.dangara.libaryappdemo.Fragment.HomeFragment
import itcenter.dangara.libaryappdemo.Fragment.ProfileFragment
import itcenter.dangara.libaryappdemo.Fragment.SettingsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)

        bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Settings",R.drawable.settings)
        )

        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Favorite",R.drawable.favorite)
        )

        bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"Home",R.drawable.home)
        )

        bottomNavigation.add(
            CurvedBottomNavigation.Model(4,"Category",R.drawable.category)
        )

        bottomNavigation.add(
            CurvedBottomNavigation.Model(5,"Profile",R.drawable.profile)
        )

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(SettingsFragment())
                }
                2 -> {
                    replaceFragment(FavoriteFragment())}
                3 -> {
                    replaceFragment(HomeFragment())}
                4 -> {
                    replaceFragment(CategoryFragment())}
                5 -> {
                    replaceFragment(ProfileFragment())}
            }
        }
        replaceFragment(HomeFragment())
        bottomNavigation.show(2)

    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}
