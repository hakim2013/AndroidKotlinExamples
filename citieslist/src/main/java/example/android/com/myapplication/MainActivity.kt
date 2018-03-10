package example.android.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.android.com.myapplication.entity.City
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cityAdapter = CityAdapter(this,loadData())
        listcities.adapter = cityAdapter
        listcities.setOnItemClickListener { adapterView, view, i, l ->
            // send the position to the detail activity
            startActivity(intentFor<DetailActivity>("pos" to i))
        }
    }

    fun loadData():List<City> {

        val imagesTab = arrayOf(R.drawable.paris_list,R.drawable.london_list,R.drawable.barcelona_list,R.drawable.istanbul_list,R.drawable.roma_list)
        val namesTab = resources.getStringArray(R.array.cities)
        val touristsTab = resources.getStringArray(R.array.tourists)
        val list = mutableListOf<City>()
        for (i in 0..imagesTab.size-1) {
            list.add(City(listImage = imagesTab[i], name = namesTab[i], touristNumber = touristsTab[i]))

        }

        return  list
    }
}
