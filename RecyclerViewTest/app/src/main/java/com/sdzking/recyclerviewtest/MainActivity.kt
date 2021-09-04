package com.sdzking.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sdzking.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()
    private val fruitListStag = ArrayList<Fruit>()

    private var fruitAdapter : FruitAdapter? = null
    private lateinit var fruitAdapter2: FruitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initFruits()

        val layoutManager = LinearLayoutManager(this)
        //纵向列表
        viewBinding.fruilListView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        viewBinding.fruilListView.adapter = adapter

        //横向列表
        val layoutManagerH = LinearLayoutManager(this)
        layoutManagerH.orientation = LinearLayoutManager.HORIZONTAL
        viewBinding.fruilListViewHorizontal.layoutManager = layoutManagerH
        val hAdapter = FruitAdapterHorizontal(fruitList)
        viewBinding.fruilListViewHorizontal.adapter = hAdapter
        //网格列表
        val layoutManagerG = GridLayoutManager(this, 2)
        viewBinding.fruilListViewGrid.layoutManager = layoutManagerG
        val gAdapter = FruitAdapter(fruitList)
        viewBinding.fruilListViewGrid.adapter = gAdapter

        //瀑布流列表
        initFruitsStaggered()
        val layoutManagerStag = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.fruilListViewStaggered.layoutManager = layoutManagerStag
        val stAdapter = FruitAdapterStaggered(fruitListStag)
        viewBinding.fruilListViewStaggered.adapter = stAdapter

        if (!::fruitAdapter2.isInitialized) {
            fruitAdapter2 = FruitAdapter(fruitList)
        }
    }

    private fun initFruitsStaggered() {
        repeat(2) {
            with(fruitListStag) {
                add(Fruit(getRandomLengthString("Apple"), R.drawable.icon_apple))
                add(Fruit(getRandomLengthString("Banana"), R.drawable.icon_banana))
                add(Fruit(getRandomLengthString("Orange"), R.drawable.icon_orange))
                add(Fruit(getRandomLengthString("Watermelon"), R.drawable.icon_watermelon))
                add(Fruit(getRandomLengthString("Pear"), R.drawable.icon_pear))
                add(Fruit(getRandomLengthString("Grape"), R.drawable.icon_grapes))
                add(Fruit(getRandomLengthString("Pineapple"), R.drawable.icon_pineapple))
                add(Fruit(getRandomLengthString("Strawberry"), R.drawable.icon_strawberry))
                add(Fruit(getRandomLengthString("Cherry"), R.drawable.icon_cherry))
                add(Fruit(getRandomLengthString("Mango"), R.drawable.icon_mango))
            }
        }
    }

    private fun getRandomLengthString(str: String): String {

        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
//    private fun getRandomLengthString(str: String) = str * (1..20).random()

    private fun initFruits() {
        repeat(2) {
            with(fruitList) {
                add(Fruit("Apple", R.drawable.icon_apple))
                add(Fruit("Banana", R.drawable.icon_banana))
                add(Fruit("Orange", R.drawable.icon_orange))
                add(Fruit("Watermelon", R.drawable.icon_watermelon))
                add(Fruit("Pear", R.drawable.icon_pear))
                add(Fruit("Grape", R.drawable.icon_grapes))
                add(Fruit("Pineapple", R.drawable.icon_pineapple))
                add(Fruit("Strawberry", R.drawable.icon_strawberry))
                add(Fruit("Cherry", R.drawable.icon_cherry))
                add(Fruit("Mango", R.drawable.icon_mango))
            }
        }
    }
}