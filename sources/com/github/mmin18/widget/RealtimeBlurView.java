package com.github.mmin18.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import b.h.a.a.AndroidStockBlurImpl;
import b.h.a.a.AndroidXBlurImpl;
import b.h.a.a.BlurImpl;
import b.h.a.a.EmptyBlurImpl;
import b.h.a.a.SupportLibraryBlurImpl;
import com.github.mmin18.realtimeblurview.R;

/* JADX INFO: loaded from: classes3.dex */
public class RealtimeBlurView extends View {
    public static int j;
    public static int k;
    public static b l = new b(null);
    public final ViewTreeObserver.OnPreDrawListener A;
    public float m;
    public int n;
    public float o;
    public final BlurImpl p;
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

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0083  */
        /* JADX WARN: Code duplicated, block: B:32:0x0091  */
        /* JADX WARN: Code duplicated, block: B:36:0x009b  */
        /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:43:0x0112 A[Catch: all -> 0x012e, b -> 0x013e, TryCatch #3 {b -> 0x013e, all -> 0x012e, blocks: (B:41:0x00d6, B:43:0x0112, B:44:0x011d), top: B:59:0x00d6 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x015f  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            boolean z2;
            Bitmap bitmap;
            boolean z3;
            RealtimeBlurView realtimeBlurView;
            int[] iArr = new int[2];
            RealtimeBlurView realtimeBlurView2 = RealtimeBlurView.this;
            Bitmap bitmap2 = realtimeBlurView2.f2910s;
            View view = realtimeBlurView2.f2912y;
            if (view != null && realtimeBlurView2.isShown()) {
                RealtimeBlurView realtimeBlurView3 = RealtimeBlurView.this;
                float f = realtimeBlurView3.o;
                if (f == 0.0f) {
                    realtimeBlurView3.b();
                } else {
                    float f2 = realtimeBlurView3.m;
                    float f3 = f / f2;
                    if (f3 > 25.0f) {
                        f2 = (f2 * f3) / 25.0f;
                        f3 = 25.0f;
                    }
                    int width = realtimeBlurView3.getWidth();
                    int height = realtimeBlurView3.getHeight();
                    int iMax = Math.max(1, (int) (width / f2));
                    int iMax2 = Math.max(1, (int) (height / f2));
                    boolean z4 = realtimeBlurView3.q;
                    if (realtimeBlurView3.t == null || (bitmap = realtimeBlurView3.f2910s) == null || bitmap.getWidth() != iMax || realtimeBlurView3.f2910s.getHeight() != iMax2) {
                        realtimeBlurView3.c();
                        try {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                            realtimeBlurView3.r = bitmapCreateBitmap;
                            if (bitmapCreateBitmap != null) {
                                realtimeBlurView3.t = new Canvas(realtimeBlurView3.r);
                                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                                realtimeBlurView3.f2910s = bitmapCreateBitmap2;
                                if (bitmapCreateBitmap2 != null) {
                                    z4 = true;
                                    if (z4) {
                                        if (realtimeBlurView3.p.b(realtimeBlurView3.getContext(), realtimeBlurView3.r, f3)) {
                                            realtimeBlurView3.q = false;
                                        }
                                    }
                                    z2 = true;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        realtimeBlurView3.b();
                    } else {
                        if (z4) {
                            if (realtimeBlurView3.p.b(realtimeBlurView3.getContext(), realtimeBlurView3.r, f3)) {
                                realtimeBlurView3.q = false;
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        if (RealtimeBlurView.this.f2910s != bitmap2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        view.getLocationOnScreen(iArr);
                        int i = -iArr[0];
                        int i2 = -iArr[1];
                        RealtimeBlurView.this.getLocationOnScreen(iArr);
                        int i3 = i + iArr[0];
                        int i4 = i2 + iArr[1];
                        RealtimeBlurView realtimeBlurView4 = RealtimeBlurView.this;
                        realtimeBlurView4.r.eraseColor(realtimeBlurView4.n & ViewCompat.MEASURED_SIZE_MASK);
                        int iSave = RealtimeBlurView.this.t.save();
                        RealtimeBlurView realtimeBlurView5 = RealtimeBlurView.this;
                        realtimeBlurView5.u = true;
                        RealtimeBlurView.j++;
                        try {
                            realtimeBlurView5.t.scale((realtimeBlurView5.r.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.r.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                            RealtimeBlurView.this.t.translate(-i3, -i4);
                            if (view.getBackground() != null) {
                                view.getBackground().draw(RealtimeBlurView.this.t);
                            }
                            view.draw(RealtimeBlurView.this.t);
                            RealtimeBlurView.this.u = false;
                            RealtimeBlurView.a();
                            realtimeBlurView = RealtimeBlurView.this;
                        } catch (b unused2) {
                            RealtimeBlurView.this.u = false;
                            RealtimeBlurView.a();
                            realtimeBlurView = RealtimeBlurView.this;
                        } catch (Throwable th) {
                            RealtimeBlurView.this.u = false;
                            RealtimeBlurView.a();
                            RealtimeBlurView.this.t.restoreToCount(iSave);
                            throw th;
                        }
                        realtimeBlurView.t.restoreToCount(iSave);
                        RealtimeBlurView realtimeBlurView6 = RealtimeBlurView.this;
                        realtimeBlurView6.p.a(realtimeBlurView6.r, realtimeBlurView6.f2910s);
                        if (z3 || RealtimeBlurView.this.f2913z) {
                            RealtimeBlurView.this.invalidate();
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    if (RealtimeBlurView.this.f2910s != bitmap2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    view.getLocationOnScreen(iArr);
                    int i5 = -iArr[0];
                    int i6 = -iArr[1];
                    RealtimeBlurView.this.getLocationOnScreen(iArr);
                    int i7 = i5 + iArr[0];
                    int i8 = i6 + iArr[1];
                    RealtimeBlurView realtimeBlurView7 = RealtimeBlurView.this;
                    realtimeBlurView7.r.eraseColor(realtimeBlurView7.n & ViewCompat.MEASURED_SIZE_MASK);
                    int iSave2 = RealtimeBlurView.this.t.save();
                    RealtimeBlurView realtimeBlurView8 = RealtimeBlurView.this;
                    realtimeBlurView8.u = true;
                    RealtimeBlurView.j++;
                    realtimeBlurView8.t.scale((realtimeBlurView8.r.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.r.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                    RealtimeBlurView.this.t.translate(-i7, -i8);
                    if (view.getBackground() != null) {
                        view.getBackground().draw(RealtimeBlurView.this.t);
                    }
                    view.draw(RealtimeBlurView.this.t);
                    RealtimeBlurView.this.u = false;
                    RealtimeBlurView.a();
                    realtimeBlurView = RealtimeBlurView.this;
                    realtimeBlurView.t.restoreToCount(iSave2);
                    RealtimeBlurView realtimeBlurView9 = RealtimeBlurView.this;
                    realtimeBlurView9.p.a(realtimeBlurView9.r, realtimeBlurView9.f2910s);
                    if (z3) {
                        RealtimeBlurView.this.invalidate();
                    } else {
                        RealtimeBlurView.this.invalidate();
                    }
                }
            }
            return true;
        }
    }

    public static class b extends RuntimeException {
        public b(a aVar) {
        }
    }

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.w = new Rect();
        this.f2911x = new Rect();
        this.A = new a();
        this.p = getBlurImpl();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.a.RealtimeBlurView);
        this.o = typedArrayObtainStyledAttributes.getDimension(R.a.RealtimeBlurView_realtimeBlurRadius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.m = typedArrayObtainStyledAttributes.getFloat(R.a.RealtimeBlurView_realtimeDownsampleFactor, 4.0f);
        this.n = typedArrayObtainStyledAttributes.getColor(R.a.RealtimeBlurView_realtimeOverlayColor, -1426063361);
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

    public BlurImpl getBlurImpl() {
        if (k == 0) {
            try {
                AndroidStockBlurImpl androidStockBlurImpl = new AndroidStockBlurImpl();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                androidStockBlurImpl.b(getContext(), bitmapCreateBitmap, 4.0f);
                androidStockBlurImpl.release();
                bitmapCreateBitmap.recycle();
                k = 3;
            } catch (Throwable unused) {
            }
        }
        if (k == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                AndroidXBlurImpl androidXBlurImpl = new AndroidXBlurImpl();
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                androidXBlurImpl.b(getContext(), bitmapCreateBitmap2, 4.0f);
                androidXBlurImpl.release();
                bitmapCreateBitmap2.recycle();
                k = 1;
            } catch (Throwable unused2) {
            }
        }
        if (k == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                SupportLibraryBlurImpl supportLibraryBlurImpl = new SupportLibraryBlurImpl();
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                supportLibraryBlurImpl.b(getContext(), bitmapCreateBitmap3, 4.0f);
                supportLibraryBlurImpl.release();
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
            return new AndroidXBlurImpl();
        }
        if (i != 2) {
            return i != 3 ? new EmptyBlurImpl() : new AndroidStockBlurImpl();
        }
        return new SupportLibraryBlurImpl();
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
