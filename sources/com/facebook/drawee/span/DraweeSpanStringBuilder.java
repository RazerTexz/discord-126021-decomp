package com.facebook.drawee.span;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.view.View;
import b.f.g.b.DraweeEventTracker;
import b.f.g.c.BaseControllerListener;
import b.f.g.i.DraweeSpan;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DraweeSpanStringBuilder extends SpannableStringBuilder {
    public static final /* synthetic */ int j = 0;
    public final Set<DraweeSpan> k = new HashSet();
    public final b l = new b(null);
    public View m;

    public class b implements Drawable.Callback {
        public b(a aVar) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
            View view = draweeSpanStringBuilder.m;
            if (view != null) {
                view.invalidate();
            } else {
                Objects.requireNonNull(draweeSpanStringBuilder);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
            if (draweeSpanStringBuilder.m == null) {
                Objects.requireNonNull(draweeSpanStringBuilder);
            } else {
                DraweeSpanStringBuilder.this.m.postDelayed(runnable, j - SystemClock.uptimeMillis());
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
            View view = draweeSpanStringBuilder.m;
            if (view != null) {
                view.removeCallbacks(runnable);
            } else {
                Objects.requireNonNull(draweeSpanStringBuilder);
            }
        }
    }

    public class c extends BaseControllerListener<ImageInfo> {
        public final DraweeSpan a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2891b;
        public final int c;

        public c(DraweeSpan draweeSpan, boolean z2, int i) {
            this.a = draweeSpan;
            this.f2891b = z2;
            this.c = i;
        }

        @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            ImageInfo imageInfo = (ImageInfo) obj;
            if (!this.f2891b || imageInfo == null || this.a.p.d() == null) {
                return;
            }
            Drawable drawableD = this.a.p.d();
            Rect bounds = drawableD.getBounds();
            int i = this.c;
            if (i == -1) {
                if (bounds.width() == imageInfo.getWidth() && bounds.height() == imageInfo.getHeight()) {
                    return;
                }
                drawableD.setBounds(0, 0, imageInfo.getWidth(), imageInfo.getHeight());
                DraweeSpanStringBuilder draweeSpanStringBuilder = DraweeSpanStringBuilder.this;
                int i2 = DraweeSpanStringBuilder.j;
                Objects.requireNonNull(draweeSpanStringBuilder);
                return;
            }
            int height = (int) ((i / imageInfo.getHeight()) * imageInfo.getWidth());
            if (bounds.width() == height && bounds.height() == this.c) {
                return;
            }
            drawableD.setBounds(0, 0, height, this.c);
            DraweeSpanStringBuilder draweeSpanStringBuilder2 = DraweeSpanStringBuilder.this;
            int i3 = DraweeSpanStringBuilder.j;
            Objects.requireNonNull(draweeSpanStringBuilder2);
        }
    }

    public void a(View view) {
        View view2 = this.m;
        if (view2 != null && view2 == view2) {
            this.m = null;
        }
        this.m = view;
        Iterator<DraweeSpan> it = this.k.iterator();
        while (it.hasNext()) {
            DraweeHolder draweeHolder = it.next().p;
            draweeHolder.f.a(DraweeEventTracker.a.ON_HOLDER_ATTACH);
            draweeHolder.f2893b = true;
            draweeHolder.b();
        }
    }

    public void b(View view) {
        if (view == this.m) {
            this.m = null;
        }
        Iterator<DraweeSpan> it = this.k.iterator();
        while (it.hasNext()) {
            DraweeHolder draweeHolder = it.next().p;
            draweeHolder.f.a(DraweeEventTracker.a.ON_HOLDER_DETACH);
            draweeHolder.f2893b = false;
            draweeHolder.b();
        }
    }

    public void c(Context context, DraweeHierarchy draweeHierarchy, DraweeController draweeController, int i, int i2, int i3, int i4, boolean z2, int i5) {
        DraweeHolder draweeHolder = new DraweeHolder(draweeHierarchy);
        draweeHolder.g(draweeController);
        if (i2 >= length()) {
            return;
        }
        Drawable drawableD = draweeHolder.d();
        if (drawableD != null) {
            if (drawableD.getBounds().isEmpty()) {
                drawableD.setBounds(0, 0, i3, i4);
            }
            drawableD.setCallback(this.l);
        }
        DraweeSpan draweeSpan = new DraweeSpan(draweeHolder, i5);
        DraweeController draweeController2 = draweeHolder.e;
        if (draweeController2 instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController2).f(new c(draweeSpan, z2, i4));
        }
        this.k.add(draweeSpan);
        setSpan(draweeSpan, i, i2 + 1, 33);
    }
}
