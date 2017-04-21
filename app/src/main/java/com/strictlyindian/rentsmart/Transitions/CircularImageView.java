package com.strictlyindian.rentsmart.Transitions;

import android.content.Context;
import android.util.AttributeSet;

import com.strictlyindian.rentsmart.CustomUI.ForegroundImageView;
import com.strictlyindian.rentsmart.utils.ViewUtils;


/**
 * An extension to image view that has a circular outline.
 */
public class CircularImageView extends ForegroundImageView {

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOutlineProvider(ViewUtils.CIRCULAR_OUTLINE);
        setClipToOutline(true);
    }
}
