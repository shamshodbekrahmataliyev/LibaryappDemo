package itcenter.dangara.libaryappdemo.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import itcenter.dangara.libaryappdemo.Fragment.BadiiyFragment
import itcenter.dangara.libaryappdemo.Fragment.ErtakFragment
import itcenter.dangara.libaryappdemo.Fragment.JahonFragment
import itcenter.dangara.libaryappdemo.Fragment.HikoyaFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BadiiyFragment()
            1 -> ErtakFragment()
            2 -> JahonFragment()
            3 -> HikoyaFragment()
            else -> BadiiyFragment()
        }
    }
}
