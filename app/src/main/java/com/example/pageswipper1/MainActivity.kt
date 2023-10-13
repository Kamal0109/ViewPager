package com.example.pageswipper1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {



    private val introSliderAdapter = introSlideAdapter(
        listOf(
            introSlide(
                "Society",
                "Smart Society App",
                R.drawable.societyimg
            ),

            introSlide(
                "Driver",
                "Drivers are Available",
                R.drawable.driverimg
            ),
            introSlide(
                "HoseHelper",
                "House Helper are Available",
                R.drawable.househelperimg
            ),
            introSlide(
                "Grocery Store",
                "Grocery Store is Available",
                R.drawable.grocerystoreimg
            ),
            introSlide(
                "Maid",
                "Mayank Sharma is Maid",
                R.drawable.maisimg
            ),
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val introSliderViewPager: ViewPager2 = findViewById(R.id.introSliderPager)

        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        introSliderViewPager.registerOnPageChangeCallback(object :
           ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
           })
    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)

        val indicatorsContainer = findViewById<LinearLayout>(R.id.indicatorsContainer)

        for(i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
                this?.layoutParams = layoutParams
            }
           indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index : Int){
        val indicatorsContainer = findViewById<LinearLayout>(R.id.indicatorsContainer)
        val childCount = indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView = indicatorsContainer[i] as ImageView
            if(i==index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

}