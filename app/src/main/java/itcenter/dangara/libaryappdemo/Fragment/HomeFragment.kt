package itcenter.dangara.libaryappdemo.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import itcenter.dangara.libaryappdemo.Adapter.ImagePagerAdapter
import itcenter.dangara.libaryappdemo.Adapter.ViewPagerAdapter
import itcenter.dangara.libaryappdemo.R

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPager2: ViewPager2
    private lateinit var dotLayout: LinearLayout
    private lateinit var dots: Array<ImageView?>
    private lateinit var tabBadiiy: TextView
    private lateinit var tabErtak: TextView
    private lateinit var tabJahon: TextView
    private lateinit var tabHikoya: TextView
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0
    private val slideInterval = 2000L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize views
        viewPager = view.findViewById(R.id.viewPager)
        viewPager2 = view.findViewById(R.id.viewPager2)
        dotLayout = view.findViewById(R.id.dotLayout)
        tabBadiiy = view.findViewById(R.id.tab_badiiy)
        tabErtak = view.findViewById(R.id.tab_ertak)
        tabJahon = view.findViewById(R.id.tab_jahon)
        tabHikoya = view.findViewById(R.id.tab_hikoya)

        // Setup ViewPager for images
        setupImageViewPager()

        // Setup ViewPager2 for fragments
        setupTabViewPager()

        // Set up tab clicks
        setupTabClicks()

        return view
    }

    private fun setupImageViewPager() {
        val images = listOf(
            R.drawable.img_1,
            R.drawable.book_img2,
            R.drawable.splash_img
        )

        val adapter = ImagePagerAdapter(images)
        viewPager.adapter = adapter

        setupDots(images.size)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectDot(position)
                currentPage = position
            }
        })

        startAutoSlide()
    }

    private fun setupDots(size: Int) {
        dots = arrayOfNulls(size)
        for (i in 0 until size) {
            dots[i] = ImageView(requireContext()).apply {
                setImageResource(R.drawable.indicator_unselected)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(8, 0, 8, 0)
                layoutParams = params
            }
            dotLayout.addView(dots[i])
        }
        selectDot(0)
    }

    private fun selectDot(position: Int) {
        for (i in dots.indices) {
            val drawableId = if (i == position) R.drawable.indicator_selected else R.drawable.indicator_unselected
            dots[i]?.setImageResource(drawableId)
        }
    }

    private fun startAutoSlide() {
        val runnable = object : Runnable {
            override fun run() {
                val nextPage = if (currentPage == dots.size - 1) 0 else currentPage + 1
                viewPager.setCurrentItem(nextPage, true)
                handler.postDelayed(this, slideInterval)
            }
        }
        handler.postDelayed(runnable, slideInterval)
    }

    private fun setupTabViewPager() {
        val fragmentAdapter = ViewPagerAdapter(this)
        viewPager2.adapter = fragmentAdapter

        // Initially select the first tab
        selectTab(tabBadiiy)

        // Listen for page changes on ViewPager2
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Change the selected tab based on the current page
                when (position) {
                    0 -> selectTab(tabBadiiy)
                    1 -> selectTab(tabErtak)
                    2 -> selectTab(tabJahon)
                    3 -> selectTab(tabHikoya)
                }
            }
        })
    }

    private fun setupTabClicks() {
        val tabs = listOf(tabBadiiy, tabErtak, tabJahon, tabHikoya)
        tabs.forEachIndexed { index, textView ->
            textView.setOnClickListener {
                viewPager2.setCurrentItem(index, true)
                selectTab(textView)
            }
        }
    }

    private fun selectTab(selectedTab: TextView) {
        val tabs = listOf(tabBadiiy, tabErtak, tabJahon, tabHikoya)
        tabs.forEach { tab ->
            if (tab == selectedTab) {
                tab.setBackgroundResource(R.drawable.tab_selected_background)
                tab.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.white))
            } else {
                tab.setBackgroundResource(R.drawable.tab_unselected_background)
                tab.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null) // Stop the handler when the view is destroyed
    }
}
