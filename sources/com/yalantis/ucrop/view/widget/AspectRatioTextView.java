package com.yalantis.ucrop.view.widget;

import android.R$attr;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R$a;
import com.yalantis.ucrop.R$b;
import com.yalantis.ucrop.R$h;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class AspectRatioTextView extends AppCompatTextView {
    public final Rect j;
    public Paint k;
    public int l;
    public float m;
    public String n;
    public float o;
    public float p;

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.j = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$h.ucrop_AspectRatioTextView);
        setGravity(1);
        this.n = typedArrayObtainStyledAttributes.getString(R$h.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.o = typedArrayObtainStyledAttributes.getFloat(R$h.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f = typedArrayObtainStyledAttributes.getFloat(R$h.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.p = f;
        float f2 = this.o;
        if (f2 == 0.0f || f == 0.0f) {
            this.m = 0.0f;
        } else {
            this.m = f2 / f;
        }
        this.l = getContext().getResources().getDimensionPixelSize(R$b.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.k = paint;
        paint.setStyle(Paint$Style.FILL);
        b();
        a(getResources().getColor(R$a.ucrop_color_widget_active));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(@ColorInt int i) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R$attr.state_selected}, new int[]{0}}, new int[]{i, ContextCompat.getColor(getContext(), R$a.ucrop_color_widget)}));
    }

    public final void b() {
        if (TextUtils.isEmpty(this.n)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.o), Integer.valueOf((int) this.p)));
        } else {
            setText(this.n);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.j);
            Rect rect = this.j;
            float f = (rect.right - rect.left) / 2.0f;
            float f2 = rect.bottom - (rect.top / 2.0f);
            int i = this.l;
            canvas.drawCircle(f, f2 - (i * 1.5f), i / 2.0f, this.k);
        }
    }

    public void setActiveColor(@ColorInt int i) {
        a(i);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.n = aspectRatio.j;
        float f = aspectRatio.k;
        this.o = f;
        float f2 = aspectRatio.l;
        this.p = f2;
        if (f == 0.0f || f2 == 0.0f) {
            this.m = 0.0f;
        } else {
            this.m = f / f2;
        }
        b();
    }
}
