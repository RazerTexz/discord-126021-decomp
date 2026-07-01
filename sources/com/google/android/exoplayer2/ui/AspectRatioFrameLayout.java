package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public final c j;

    @Nullable
    public b k;
    public float l;
    public int m;

    public interface b {
        void a(float f, float f2, boolean z2);
    }

    public final class c implements Runnable {
        public float j;
        public float k;
        public boolean l;
        public boolean m;

        public c(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m = false;
            b bVar = AspectRatioFrameLayout.this.k;
            if (bVar == null) {
                return;
            }
            bVar.a(this.j, this.k, this.l);
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.g.AspectRatioFrameLayout, 0, 0);
            try {
                this.m = typedArrayObtainStyledAttributes.getInt(R.g.AspectRatioFrameLayout_resize_mode, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.j = new c(null);
    }

    public int getResizeMode() {
        return this.m;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.l <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f3 = measuredWidth;
        float f4 = measuredHeight;
        float f5 = f3 / f4;
        float f6 = (this.l / f5) - 1.0f;
        if (Math.abs(f6) <= 0.01f) {
            c cVar = this.j;
            cVar.j = this.l;
            cVar.k = f5;
            cVar.l = false;
            if (cVar.m) {
                return;
            }
            cVar.m = true;
            AspectRatioFrameLayout.this.post(cVar);
            return;
        }
        int i3 = this.m;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f = this.l;
                } else if (i3 == 4) {
                    if (f6 > 0.0f) {
                        f = this.l;
                    } else {
                        f2 = this.l;
                    }
                }
                measuredWidth = (int) (f4 * f);
            } else {
                f2 = this.l;
            }
            measuredHeight = (int) (f3 / f2);
        } else if (f6 > 0.0f) {
            f2 = this.l;
            measuredHeight = (int) (f3 / f2);
        } else {
            f = this.l;
            measuredWidth = (int) (f4 * f);
        }
        c cVar2 = this.j;
        cVar2.j = this.l;
        cVar2.k = f5;
        cVar2.l = true;
        if (!cVar2.m) {
            cVar2.m = true;
            AspectRatioFrameLayout.this.post(cVar2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY));
    }

    public void setAspectRatio(float f) {
        if (this.l != f) {
            this.l = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable b bVar) {
        this.k = bVar;
    }

    public void setResizeMode(int i) {
        if (this.m != i) {
            this.m = i;
            requestLayout();
        }
    }
}
