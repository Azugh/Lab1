package com.example.lab1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.*


private const val TAG = "CanvasLog"

class CanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val lnPaint = Paint()
    private val lgPaint = Paint()

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)

        Log.i(TAG, "height = $height")
        Log.i(TAG, "width = $width")

        val endY: Float = height - 300f
        val endX: Float = width - 100f
        Log.i(TAG, "endy = $endY")
        Log.i(TAG, "endx = $endX")

        paint.strokeWidth = 5F
        paint.color = Color.BLACK
        paint.textSize = 20F

        lnPaint.strokeWidth = 6f
        lnPaint.color = Color.RED

        lgPaint.strokeWidth = 6f
        lgPaint.color = Color.GREEN

        canvas?.drawLine(100f, 100f, 100f, endY + 100f, paint)

        var y = endY
        val partY: Float = (y - 200f) / 10
        for (i in 1..10) {

            y -= partY
            canvas?.drawLine(90f, y, 110f, y, paint)
            canvas?.drawText(i.toString(), 75f, y, paint)
        }

        canvas?.drawLine(0f, endY, endX, endY, paint)

        var x = 100f
        val partX: Float = (endX - 150f) / 10
        for (i in 1..10) {

            x += partX
            canvas?.drawLine(x, endY - 10, x, endY + 10, paint)
            canvas?.drawText((i / 10f).toString(), x, endY + 35, paint)
        }

        var fx = 0f

        while (fx < 100) {

            val fxln = round(100f + partX * fx)
            val fyln = (endY - partY * asin(1/(fx * fx)))

            val fxlg = round(100f + partX * fx)
            val fylg = (endY - partY * sin(fx))

            canvas?.drawPoint(fxlg, fylg, lgPaint)
            canvas?.drawPoint(fxln, fyln, lnPaint)

            fx += 0.001f
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.i(TAG, "widthMeasureSpec - $widthMeasureSpec")
        Log.i(TAG, "heightMeasureSpec - $heightMeasureSpec")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


}