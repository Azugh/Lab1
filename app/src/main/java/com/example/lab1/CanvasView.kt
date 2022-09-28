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

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)

        Log.i(TAG, "height = $height")
        Log.i(TAG, "width = $width")

        val endY: Float = height - 100f
        val endX: Float = width - 100f
        Log.i(TAG, "endy = $endY")
        Log.i(TAG, "endx = $endX")

        paint.strokeWidth = 5F
        paint.color = Color.BLACK
        paint.textSize = 20F

        canvas?.drawLine(100f, 100f, 100f, endY + 100f, paint)

        var y = endY
        val partY: Float = (y - 200) / 10
        for (i in 1..10) {

            y -= partY
            canvas?.drawLine(90f, y, 110f, y, paint)
            canvas?.drawText(i.toString(), 75f, y, paint)
        }

        canvas?.drawLine(0f, endY, endX, endY, paint)

        var x = 100f
        val partX: Float = (endX - 100f) / 10
        for (i in 1..10) {

            x += partX
            canvas?.drawLine(x, endY - 10, x, endY + 10, paint)
            canvas?.drawText((i / 10f).toString(), x, endY + 35, paint)
        }

        paint.color = Color.GREEN
        paint.strokeWidth = 7F

        var X = 0.1f

        while (X < 1) {

            val fxln = round(100f + partX * X * 10)
            val fyln = (endY - partY * ln(1 / X))
            val fxrn = round(100f + partX * (X + 0.1f) * 10)
            val fyrn = (endY - partY * ln(1 / (X + 0.1f)))
//            canvas?.drawPoint(fxln, fyln, paint)
            canvas?.drawLine(fxln, fyln, fxrn, fyrn, paint)
//            X += 0.1f
            X = ((X + 0.1f) * 100.0f).roundToInt() / 100.0f
        }

        X = 0.1f
        paint.color = Color.RED
        while (X < 1) {


            val fxlg = round(100f + partX * X * 10)
            val fylg = (endY - partY * log10(1 / X))
            val fxrg = round(100f + partX * (X + 0.1f) * 10)
            val fyrg = (endY - partY * log10(1 / (X + 0.1f)))
//            canvas?.drawPoint(fxlg, fylg, paint)
            canvas?.drawLine(fxlg, fylg, fxrg, fyrg, paint)
//            Log.i(TAG, "fx = $fxlg")
//            Log.i(TAG, "fy = $fylg")
            Log.i(TAG, "X $X")
            X = ((X + 0.1f) * 100.0f).roundToInt() / 100.0f
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.i(TAG, "widthMeasureSpec - $widthMeasureSpec")
        Log.i(TAG, "heightMeasureSpec - $heightMeasureSpec")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec + heightMeasureSpec % 500)
    }


}