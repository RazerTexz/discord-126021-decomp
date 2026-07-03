package com.yalantis.ucrop.view.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.C11199R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class AspectRatioTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: j */
    public final Rect f22243j;

    /* JADX INFO: renamed from: k */
    public Paint f22244k;

    /* JADX INFO: renamed from: l */
    public int f22245l;

    /* JADX INFO: renamed from: m */
    public float f22246m;

    /* JADX INFO: renamed from: n */
    public String f22247n;

    /* JADX INFO: renamed from: o */
    public float f22248o;

    /* JADX INFO: renamed from: p */
    public float f22249p;

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f22243j = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11199R.h.ucrop_AspectRatioTextView);
        setGravity(1);
        this.f22247n = typedArrayObtainStyledAttributes.getString(C11199R.h.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.f22248o = typedArrayObtainStyledAttributes.getFloat(C11199R.h.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f = typedArrayObtainStyledAttributes.getFloat(C11199R.h.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.f22249p = f;
        float f2 = this.f22248o;
        if (f2 == 0.0f || f == 0.0f) {
            this.f22246m = 0.0f;
        } else {
            this.f22246m = f2 / f;
        }
        this.f22245l = getContext().getResources().getDimensionPixelSize(C11199R.b.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.f22244k = paint;
        paint.setStyle(Paint.Style.FILL);
        m9326b();
        m9325a(getResources().getColor(C11199R.a.ucrop_color_widget_active));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public final void m9325a(@ColorInt int i) {
        Paint paint = this.f22244k;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{i, ContextCompat.getColor(getContext(), C11199R.a.ucrop_color_widget)}));
    }

    /* JADX INFO: renamed from: b */
    public final void m9326b() {
        if (TextUtils.isEmpty(this.f22247n)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.f22248o), Integer.valueOf((int) this.f22249p)));
        } else {
            setText(this.f22247n);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f22243j);
            Rect rect = this.f22243j;
            float f = (rect.right - rect.left) / 2.0f;
            float f2 = rect.bottom - (rect.top / 2.0f);
            int i = this.f22245l;
            canvas.drawCircle(f, f2 - (i * 1.5f), i / 2.0f, this.f22244k);
        }
    }

    public void setActiveColor(@ColorInt int i) {
        m9325a(i);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.f22247n = aspectRatio.f22200j;
        float f = aspectRatio.f22201k;
        this.f22248o = f;
        float f2 = aspectRatio.f22202l;
        this.f22249p = f2;
        if (f == 0.0f || f2 == 0.0f) {
            this.f22246m = 0.0f;
        } else {
            this.f22246m = f / f2;
        }
        m9326b();
    }
}
