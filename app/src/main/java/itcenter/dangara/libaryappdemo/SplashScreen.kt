package itcenter.dangara.libaryappdemo

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import itcenter.dangara.libaryappdemo.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nextImg: ImageView = findViewById(R.id.next_img)

        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        nextImg.startAnimation(rotateAnimation)

        binding.nextImg.postDelayed({
            startActivity(Intent(this@SplashScreen, SliderActivity::class.java))
            finish()
        },2000)

    }
}