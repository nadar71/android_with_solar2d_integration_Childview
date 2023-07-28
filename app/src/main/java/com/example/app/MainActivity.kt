package com.example.app

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ansca.corona.CoronaView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, PlaceholderFragment())
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return id == R.id.action_settings || super.onOptionsItemSelected(item)
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {
        var mBigCoronaView: CoronaView? = null
        var mSmallCoronaView: CoronaView? = null
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val rootView = inflater.inflate(R.layout.fragment_main, container, false)
            mBigCoronaView = rootView.findViewById<View>(R.id.view_outer) as CoronaView
            mSmallCoronaView = rootView.findViewById<View>(R.id.view_inner) as CoronaView
            mBigCoronaView!!.init("Fishies/")
            mSmallCoronaView!!.init("Fishies/")
            mBigCoronaView!!.setZOrderMediaOverlay(false)
            mSmallCoronaView!!.setZOrderMediaOverlay(true)
            return rootView
        }

        override fun onResume() {
            super.onResume()
            mSmallCoronaView!!.resume()
            mBigCoronaView!!.resume()
        }

        override fun onPause() {
            super.onPause()
            mSmallCoronaView!!.pause()
            mBigCoronaView!!.pause()
        }

        override fun onDestroy() {
            super.onDestroy()
            mSmallCoronaView!!.destroy()
            mBigCoronaView!!.destroy()
        }
    }
}