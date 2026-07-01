package com.github.mmin18.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import b.h.a.a.a;
import b.h.a.a.b;
import b.h.a.a.c;
import b.h.a.a.d;
import b.h.a.a.e;
import com.github.mmin18.realtimeblurview.R$a;

/* JADX INFO: loaded from: classes3.dex */
public class RealtimeBlurView extends View {
    public static int j;
    public static int k;
    public static RealtimeBlurView$b l = new RealtimeBlurView$b(null);
    public final ViewTreeObserver$OnPreDrawListener A;
    public float m;
    public int n;
    public float o;
    public final c p;
    public boolean q;
    public Bitmap r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Bitmap f2910s;
    public Canvas t;
    public boolean u;
    public Paint v;
    public final Rect w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f2911x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f2912y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2913z;

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.w = new Rect();
        this.f2911x = new Rect();
        this.A = new RealtimeBlurView$a(this);
        this.p = getBlurImpl();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$a.RealtimeBlurView);
        this.o = typedArrayObtainStyledAttributes.getDimension(R$a.RealtimeBlurView_realtimeBlurRadius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.m = typedArrayObtainStyledAttributes.getFloat(R$a.RealtimeBlurView_realtimeDownsampleFactor, 4.0f);
        this.n = typedArrayObtainStyledAttributes.getColor(R$a.RealtimeBlurView_realtimeOverlayColor, -1426063361);
        typedArrayObtainStyledAttributes.recycle();
        this.v = new Paint();
    }

    public static /* synthetic */ int a() {
        int i = j;
        j = i - 1;
        return i;
    }

    public void b() {
        c();
        this.p.release();
    }

    public final void c() {
        Bitmap bitmap = this.r;
        if (bitmap != null) {
            bitmap.recycle();
            this.r = null;
        }
        Bitmap bitmap2 = this.f2910s;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f2910s = null;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.u) {
            throw l;
        }
        if (j > 0) {
            return;
        }
        super.draw(canvas);
    }

    public View getActivityDecorView() {
        Context context = getContext();
        for (int i = 0; i < 4 && context != null && !(context instanceof Activity) && (context instanceof ContextWrapper); i++) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        return null;
    }

    public c getBlurImpl() {
        if (k == 0) {
            try {
                a aVar = new a();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(4, 4, Bitmap$Config.ARGB_8888);
                aVar.b(getContext(), bitmapCreateBitmap, 4.0f);
                aVar.release();
                bitmapCreateBitmap.recycle();
                k = 3;
            } catch (Throwable unused) {
            }
        }
        if (k == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                b bVar = new b();
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(4, 4, Bitmap$Config.ARGB_8888);
                bVar.b(getContext(), bitmapCreateBitmap2, 4.0f);
                bVar.release();
                bitmapCreateBitmap2.recycle();
                k = 1;
            } catch (Throwable unused2) {
            }
        }
        if (k == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                e eVar = new e();
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(4, 4, Bitmap$Config.ARGB_8888);
                eVar.b(getContext(), bitmapCreateBitmap3, 4.0f);
                eVar.release();
                bitmapCreateBitmap3.recycle();
                k = 2;
            } catch (Throwable unused3) {
            }
        }
        if (k == 0) {
            k = -1;
        }
        int i = k;
        if (i == 1) {
            return new b();
        }
        if (i != 2) {
            return i != 3 ? new d() : new a();
        }
        return new e();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.f2912y = activityDecorView;
        if (activityDecorView == null) {
            this.f2913z = false;
            return;
        }
        activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.A);
        boolean z2 = this.f2912y.getRootView() != getRootView();
        this.f2913z = z2;
        if (z2) {
            this.f2912y.postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        View view = this.f2912y;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.A);
        }
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f2910s;
        int i = this.n;
        if (bitmap != null) {
            this.w.right = bitmap.getWidth();
            this.w.bottom = bitmap.getHeight();
            this.f2911x.right = getWidth();
            this.f2911x.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.w, this.f2911x, (Paint) null);
        }
        this.v.setColor(i);
        canvas.drawRect(this.f2911x, this.v);
    }

    public void setBlurRadius(float f) {
        if (this.o != f) {
            this.o = f;
            this.q = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
        if (this.m != f) {
            this.m = f;
            this.q = true;
            c();
            invalidate();
        }
    }

    public void setOverlayColor(int i) {
        if (this.n != i) {
            this.n = i;
            invalidate();
        }
    }
}
