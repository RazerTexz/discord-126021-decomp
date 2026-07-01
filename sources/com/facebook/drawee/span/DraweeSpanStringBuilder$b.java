package com.facebook.drawee.span;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import android.os.SystemClock;
import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DraweeSpanStringBuilder$b implements Drawable$Callback {
    public final /* synthetic */ DraweeSpanStringBuilder j;

    public DraweeSpanStringBuilder$b(DraweeSpanStringBuilder draweeSpanStringBuilder, DraweeSpanStringBuilder$a draweeSpanStringBuilder$a) {
        this.j = draweeSpanStringBuilder;
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(Drawable drawable) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        View view = draweeSpanStringBuilder.m;
        if (view != null) {
            view.invalidate();
        } else {
            Objects.requireNonNull(draweeSpanStringBuilder);
        }
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        if (draweeSpanStringBuilder.m == null) {
            Objects.requireNonNull(draweeSpanStringBuilder);
        } else {
            this.j.m.postDelayed(runnable, j - SystemClock.uptimeMillis());
        }
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        View view = draweeSpanStringBuilder.m;
        if (view != null) {
            view.removeCallbacks(runnable);
        } else {
            Objects.requireNonNull(draweeSpanStringBuilder);
        }
    }
}
