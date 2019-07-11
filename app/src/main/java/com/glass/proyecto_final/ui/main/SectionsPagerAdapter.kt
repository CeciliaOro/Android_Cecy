package com.glass.proyecto_final.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.glass.proyecto_final.*
import com.glass.proyecto_final.dummy.DummyContent

private val TAB_TITLES = arrayOf(
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
         return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0->  return movieFragment.newInstance(2)
            1 -> return  FragmentTwo.newInstance()
            2 -> return FragmentThree.newInstance()
            else -> return FragmentThree.newInstance()

        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0-> return "Movies"
            1 -> return  "Trailers"
            2 -> return  "Ubicaciones"
            else -> return "Movies"

        }
    }
}
        /*// getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}*/