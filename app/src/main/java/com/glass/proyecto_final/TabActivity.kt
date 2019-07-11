package com.glass.proyecto_final

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.glass.proyecto_final.dummy.DummyContent
import com.glass.proyecto_final.ui.main.SectionsPagerAdapter

class TabActivity : AppCompatActivity(),movieFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Compra boletos", Snackbar.LENGTH_LONG)
                .setAction("Aceptar", null).show()
        }

        tabs.getTabAt(0)?.setIcon(R.drawable.busqueda_icono)
        tabs.getTabAt(1)?.setIcon(R.drawable.contacto_icono)
        tabs.getTabAt(2)?.setIcon(R.drawable.ubicacion_icono)
    }
}