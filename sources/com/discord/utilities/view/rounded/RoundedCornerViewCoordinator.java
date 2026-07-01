package com.discord.utilities.view.rounded;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.StyleableRes;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RoundedCornerViewCoordinator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoundedCornerViewCoordinator {
    private float bottomLeftRadius;
    private float bottomRightRadius;
    private Path path = new Path();
    private final float[] radii = new float[8];
    private float topLeftRadius;
    private float topRightRadius;

    public final void draw(Canvas canvas, Function1<? super Canvas, Unit> onDraw) {
        m.checkNotNullParameter(canvas, "canvas");
        m.checkNotNullParameter(onDraw, "onDraw");
        canvas.save();
        canvas.clipPath(this.path);
        onDraw.invoke(canvas);
        canvas.restore();
    }

    public final void initialize(View view, AttributeSet attrs, @StyleableRes int[] attrsIndexArray, @StyleableRes int attrsIndexTopLeftRadius, @StyleableRes int attrsIndexTopRightRadius, @StyleableRes int attrsIndexBottomLeftRadius, @StyleableRes int attrsIndexBottomRightRadius) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(attrsIndexArray, "attrsIndexArray");
        view.setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attrs, attrsIndexArray);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "view.context.obtainStyle…s(attrs, attrsIndexArray)");
        try {
            this.topLeftRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexTopLeftRadius, 0.0f);
            this.topRightRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexTopRightRadius, 0.0f);
            this.bottomLeftRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexBottomLeftRadius, 0.0f);
            this.bottomRightRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexBottomRightRadius, 0.0f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void onSizeChanged(int w, int h) {
        Path path = new Path();
        this.path = path;
        float[] fArr = this.radii;
        float f = this.topLeftRadius;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = this.topRightRadius;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = this.bottomRightRadius;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = this.bottomLeftRadius;
        fArr[6] = f4;
        fArr[7] = f4;
        path.addRoundRect(new RectF(0.0f, 0.0f, w, h), this.radii, Path$Direction.CW);
        this.path.close();
    }

    public final void updateRadius(View view, float radius, RoundedCornerViewCoordinator$Corner corner) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(corner, "corner");
        int iOrdinal = corner.ordinal();
        if (iOrdinal == 0) {
            this.topLeftRadius = radius;
        } else if (iOrdinal == 1) {
            this.topRightRadius = radius;
        } else if (iOrdinal == 2) {
            this.bottomLeftRadius = radius;
        } else if (iOrdinal == 3) {
            this.bottomRightRadius = radius;
        }
        view.invalidate();
    }
}
