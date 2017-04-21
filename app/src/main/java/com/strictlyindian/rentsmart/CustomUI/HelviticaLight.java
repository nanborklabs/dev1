package com.strictlyindian.rentsmart.CustomUI;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.strictlyindian.rentsmart.utils.FontCache;

/**
 * Created by nandhu on 2/4/17.
 *
 */

public class HelviticaLight extends TextView {
    public HelviticaLight(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public HelviticaLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public HelviticaLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/grand_hotel.otf", context);
        setTypeface(customFont);
    }
}
