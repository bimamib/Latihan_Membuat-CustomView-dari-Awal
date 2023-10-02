package com.bima.ticketingapps

import android.content.Context
import android.util.AttributeSet
import android.view.View

class SeatsView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    data class Seat(
        val id: Int,
        var x: Float? = 0F,
        var y: Float? = 0F,
        var name: String,
        var isBooked: Boolean
    )

    private val seats: ArrayList<Seat> = arrayListOf(
        Seat(id = 1, name = "A1", isBooked = false),
        Seat(id = 2, name = "A2", isBooked = false),
        Seat(id = 3, name = "B1", isBooked = false),
        Seat(id = 4, name = "A4", isBooked = false),
        Seat(id = 5, name = "C1", isBooked = false),
        Seat(id = 6, name = "C2", isBooked = false),
        Seat(id = 7, name = "D1", isBooked = false),
        Seat(id = 8, name = "D2", isBooked = false),
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width: getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val height: getDefaultSize(suggestedMinimumHeightm, heightMeasureSpec)

        val halOfHeight = height / 2
        val halOfWidth = width / 2
        var value = -600F

        for (i in 0..7) {
            if (i.mod(2) == 0) {
                seats[i].apply {
                    x = halOfWidth - 300F
                    y = halOfWidth + value
                }
            } else {
                seats[i].apply {
                    x = halOfWidth + 100F
                    y = halOfHeight + value
                }
                value += 300F
            }
        }
    }
}