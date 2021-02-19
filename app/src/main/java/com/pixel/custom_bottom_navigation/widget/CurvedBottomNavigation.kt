package com.pixel.custom_bottom_navigation.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.jar.Attributes

class CurvedBottomNavigation @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr) {
  private var mPath: Path? = null
  private var mPain: Paint? = null
  //radius for float button
  private var radius: Int = 0
  // first curve
  private var mFirstCurveStartPoint = Point()
  private var mFirstCurveEndPoint = Point()
  private var mFirstCurveControlPoint1 = Point()
  private var mFirstCurveControlPoint2 = Point()

  // second curve
  private var mSecondCurveStartPoint = Point()
  private var mSecondCurveEndPoint = Point()
  private var mSecondCurveControlPoint1 = Point()
  private var mSecondCurveControlPoint2 = Point()

  private var mWidthScreen : Int = 0
  private var mHeightScreen : Int = 0

  init {
    radius = 256 /2
    mPath = Path()
    mPain = Paint()
    mPain?.apply {
      style = Paint.Style.FILL_AND_STROKE
      color = Color.WHITE
    }
    ///???
    setBackgroundColor(Color.TRANSPARENT)
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    //get dai va rong cua screen
    mWidthScreen = width
    mHeightScreen = height
    val paddingCurve : Int = radius /3
    val paddingFloatNavigationBar : Int = radius /4
    //P2(x,y) of the start point curve
    mFirstCurveStartPoint.set(mWidthScreen /2 - radius * 2 - paddingCurve, 0)
    //P3(x,y) of the end point curve
    mFirstCurveEndPoint.set(mWidthScreen /2 , radius + paddingFloatNavigationBar)

    //P4(x,y) start of the second curve
    mSecondCurveStartPoint = mFirstCurveEndPoint
    mSecondCurveEndPoint.set(mWidthScreen /2 + radius*2 + paddingCurve, 0)


    // ve diem




  }

  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)
  }

}