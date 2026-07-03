package com.google.android.exoplayer2.p505ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: j */
    public final RunnableC10752c f20054j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public InterfaceC10751b f20055k;

    /* JADX INFO: renamed from: l */
    public float f20056l;

    /* JADX INFO: renamed from: m */
    public int f20057m;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$b */
    public interface InterfaceC10751b {
        /* JADX INFO: renamed from: a */
        void m8884a(float f, float f2, boolean z2);
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$c */
    public final class RunnableC10752c implements Runnable {

        /* JADX INFO: renamed from: j */
        public float f20058j;

        /* JADX INFO: renamed from: k */
        public float f20059k;

        /* JADX INFO: renamed from: l */
        public boolean f20060l;

        /* JADX INFO: renamed from: m */
        public boolean f20061m;

        public RunnableC10752c(C10750a c10750a) {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20061m = false;
            InterfaceC10751b interfaceC10751b = AspectRatioFrameLayout.this.f20055k;
            if (interfaceC10751b == null) {
                return;
            }
            interfaceC10751b.m8884a(this.f20058j, this.f20059k, this.f20060l);
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20057m = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10759R.g.AspectRatioFrameLayout, 0, 0);
            try {
                this.f20057m = typedArrayObtainStyledAttributes.getInt(C10759R.g.AspectRatioFrameLayout_resize_mode, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f20054j = new RunnableC10752c(null);
    }

    public int getResizeMode() {
        return this.f20057m;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.f20056l <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f3 = measuredWidth;
        float f4 = measuredHeight;
        float f5 = f3 / f4;
        float f6 = (this.f20056l / f5) - 1.0f;
        if (Math.abs(f6) <= 0.01f) {
            RunnableC10752c runnableC10752c = this.f20054j;
            runnableC10752c.f20058j = this.f20056l;
            runnableC10752c.f20059k = f5;
            runnableC10752c.f20060l = false;
            if (runnableC10752c.f20061m) {
                return;
            }
            runnableC10752c.f20061m = true;
            AspectRatioFrameLayout.this.post(runnableC10752c);
            return;
        }
        int i3 = this.f20057m;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f = this.f20056l;
                } else if (i3 == 4) {
                    if (f6 > 0.0f) {
                        f = this.f20056l;
                    } else {
                        f2 = this.f20056l;
                    }
                }
                measuredWidth = (int) (f4 * f);
            } else {
                f2 = this.f20056l;
            }
            measuredHeight = (int) (f3 / f2);
        } else if (f6 > 0.0f) {
            f2 = this.f20056l;
            measuredHeight = (int) (f3 / f2);
        } else {
            f = this.f20056l;
            measuredWidth = (int) (f4 * f);
        }
        RunnableC10752c runnableC10752c2 = this.f20054j;
        runnableC10752c2.f20058j = this.f20056l;
        runnableC10752c2.f20059k = f5;
        runnableC10752c2.f20060l = true;
        if (!runnableC10752c2.f20061m) {
            runnableC10752c2.f20061m = true;
            AspectRatioFrameLayout.this.post(runnableC10752c2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY));
    }

    public void setAspectRatio(float f) {
        if (this.f20056l != f) {
            this.f20056l = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable InterfaceC10751b interfaceC10751b) {
        this.f20055k = interfaceC10751b;
    }

    public void setResizeMode(int i) {
        if (this.f20057m != i) {
            this.f20057m = i;
            requestLayout();
        }
    }
}
