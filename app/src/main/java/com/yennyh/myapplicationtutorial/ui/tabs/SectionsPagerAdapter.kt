package com.yennyh.myapplicationtutorial.ui.tabs

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.ui.actualizar.actualizarFragment
import com.yennyh.myapplicationtutorial.ui.borrar.borrar_Fragment
import com.yennyh.myapplicationtutorial.ui.buscar.BuscarFragment
import com.yennyh.myapplicationtutorial.ui.crear.CrearFragment


private val TAB_TITLES = arrayOf(
    R.string.crear,
    R.string.buscar,
    R.string.actualizar,
    R.string.borrar
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return CrearFragment()
            1 -> return actualizarFragment()
            2 -> return BuscarFragment()
            else -> return borrar_Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}