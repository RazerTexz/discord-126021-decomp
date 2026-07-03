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
import com.github.mmin18.realtimeblurview.C10679R;
import p007b.p222h.p223a.p224a.C2398a;
import p007b.p222h.p223a.p224a.C2399b;
import p007b.p222h.p223a.p224a.C2401d;
import p007b.p222h.p223a.p224a.C2402e;
import p007b.p222h.p223a.p224a.InterfaceC2400c;

/* JADX INFO: loaded from: classes3.dex */
public class RealtimeBlurView extends View {

    /* JADX INFO: renamed from: j */
    public static int f19673j;

    /* JADX INFO: renamed from: k */
    public static int f19674k;

    /* JADX INFO: renamed from: l */
    public static C10681b f19675l = new C10681b(null);

    /* JADX INFO: renamed from: A */
    public final ViewTreeObserver.OnPreDrawListener f19676A;

    /* JADX INFO: renamed from: m */
    public float f19677m;

    /* JADX INFO: renamed from: n */
    public int f19678n;

    /* JADX INFO: renamed from: o */
    public float f19679o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC2400c f19680p;

    /* JADX INFO: renamed from: q */
    public boolean f19681q;

    /* JADX INFO: renamed from: r */
    public Bitmap f19682r;

    /* JADX INFO: renamed from: s */
    public Bitmap f19683s;

    /* JADX INFO: renamed from: t */
    public Canvas f19684t;

    /* JADX INFO: renamed from: u */
    public boolean f19685u;

    /* JADX INFO: renamed from: v */
    public Paint f19686v;

    /* JADX INFO: renamed from: w */
    public final Rect f19687w;

    /* JADX INFO: renamed from: x */
    public final Rect f19688x;

    /* JADX INFO: renamed from: y */
    public View f19689y;

    /* JADX INFO: renamed from: z */
    public boolean f19690z;

    /* JADX INFO: renamed from: com.github.mmin18.widget.RealtimeBlurView$a */
    public class ViewTreeObserverOnPreDrawListenerC10680a implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC10680a() {
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
            Bitmap bitmap2 = realtimeBlurView2.f19683s;
            View view = realtimeBlurView2.f19689y;
            if (view != null && realtimeBlurView2.isShown()) {
                RealtimeBlurView realtimeBlurView3 = RealtimeBlurView.this;
                float f = realtimeBlurView3.f19679o;
                if (f == 0.0f) {
                    realtimeBlurView3.m8751b();
                } else {
                    float f2 = realtimeBlurView3.f19677m;
                    float f3 = f / f2;
                    if (f3 > 25.0f) {
                        f2 = (f2 * f3) / 25.0f;
                        f3 = 25.0f;
                    }
                    int width = realtimeBlurView3.getWidth();
                    int height = realtimeBlurView3.getHeight();
                    int iMax = Math.max(1, (int) (width / f2));
                    int iMax2 = Math.max(1, (int) (height / f2));
                    boolean z4 = realtimeBlurView3.f19681q;
                    if (realtimeBlurView3.f19684t == null || (bitmap = realtimeBlurView3.f19683s) == null || bitmap.getWidth() != iMax || realtimeBlurView3.f19683s.getHeight() != iMax2) {
                        realtimeBlurView3.m8752c();
                        try {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                            realtimeBlurView3.f19682r = bitmapCreateBitmap;
                            if (bitmapCreateBitmap != null) {
                                realtimeBlurView3.f19684t = new Canvas(realtimeBlurView3.f19682r);
                                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                                realtimeBlurView3.f19683s = bitmapCreateBitmap2;
                                if (bitmapCreateBitmap2 != null) {
                                    z4 = true;
                                    if (z4) {
                                        if (realtimeBlurView3.f19680p.mo2285b(realtimeBlurView3.getContext(), realtimeBlurView3.f19682r, f3)) {
                                            realtimeBlurView3.f19681q = false;
                                        }
                                    }
                                    z2 = true;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        realtimeBlurView3.m8751b();
                    } else {
                        if (z4) {
                            if (realtimeBlurView3.f19680p.mo2285b(realtimeBlurView3.getContext(), realtimeBlurView3.f19682r, f3)) {
                                realtimeBlurView3.f19681q = false;
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        if (RealtimeBlurView.this.f19683s != bitmap2) {
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
                        realtimeBlurView4.f19682r.eraseColor(realtimeBlurView4.f19678n & ViewCompat.MEASURED_SIZE_MASK);
                        int iSave = RealtimeBlurView.this.f19684t.save();
                        RealtimeBlurView realtimeBlurView5 = RealtimeBlurView.this;
                        realtimeBlurView5.f19685u = true;
                        RealtimeBlurView.f19673j++;
                        try {
                            realtimeBlurView5.f19684t.scale((realtimeBlurView5.f19682r.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.f19682r.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                            RealtimeBlurView.this.f19684t.translate(-i3, -i4);
                            if (view.getBackground() != null) {
                                view.getBackground().draw(RealtimeBlurView.this.f19684t);
                            }
                            view.draw(RealtimeBlurView.this.f19684t);
                            RealtimeBlurView.this.f19685u = false;
                            RealtimeBlurView.m8750a();
                            realtimeBlurView = RealtimeBlurView.this;
                        } catch (C10681b unused2) {
                            RealtimeBlurView.this.f19685u = false;
                            RealtimeBlurView.m8750a();
                            realtimeBlurView = RealtimeBlurView.this;
                        } catch (Throwable th) {
                            RealtimeBlurView.this.f19685u = false;
                            RealtimeBlurView.m8750a();
                            RealtimeBlurView.this.f19684t.restoreToCount(iSave);
                            throw th;
                        }
                        realtimeBlurView.f19684t.restoreToCount(iSave);
                        RealtimeBlurView realtimeBlurView6 = RealtimeBlurView.this;
                        realtimeBlurView6.f19680p.mo2284a(realtimeBlurView6.f19682r, realtimeBlurView6.f19683s);
                        if (z3 || RealtimeBlurView.this.f19690z) {
                            RealtimeBlurView.this.invalidate();
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    if (RealtimeBlurView.this.f19683s != bitmap2) {
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
                    realtimeBlurView7.f19682r.eraseColor(realtimeBlurView7.f19678n & ViewCompat.MEASURED_SIZE_MASK);
                    int iSave2 = RealtimeBlurView.this.f19684t.save();
                    RealtimeBlurView realtimeBlurView8 = RealtimeBlurView.this;
                    realtimeBlurView8.f19685u = true;
                    RealtimeBlurView.f19673j++;
                    realtimeBlurView8.f19684t.scale((realtimeBlurView8.f19682r.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.f19682r.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                    RealtimeBlurView.this.f19684t.translate(-i7, -i8);
                    if (view.getBackground() != null) {
                        view.getBackground().draw(RealtimeBlurView.this.f19684t);
                    }
                    view.draw(RealtimeBlurView.this.f19684t);
                    RealtimeBlurView.this.f19685u = false;
                    RealtimeBlurView.m8750a();
                    realtimeBlurView = RealtimeBlurView.this;
                    realtimeBlurView.f19684t.restoreToCount(iSave2);
                    RealtimeBlurView realtimeBlurView9 = RealtimeBlurView.this;
                    realtimeBlurView9.f19680p.mo2284a(realtimeBlurView9.f19682r, realtimeBlurView9.f19683s);
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

    /* JADX INFO: renamed from: com.github.mmin18.widget.RealtimeBlurView$b */
    public static class C10681b extends RuntimeException {
        public C10681b(ViewTreeObserverOnPreDrawListenerC10680a viewTreeObserverOnPreDrawListenerC10680a) {
        }
    }

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.f19687w = new Rect();
        this.f19688x = new Rect();
        this.f19676A = new ViewTreeObserverOnPreDrawListenerC10680a();
        this.f19680p = getBlurImpl();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, C10679R.a.RealtimeBlurView);
        this.f19679o = typedArrayObtainStyledAttributes.getDimension(C10679R.a.RealtimeBlurView_realtimeBlurRadius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.f19677m = typedArrayObtainStyledAttributes.getFloat(C10679R.a.RealtimeBlurView_realtimeDownsampleFactor, 4.0f);
        this.f19678n = typedArrayObtainStyledAttributes.getColor(C10679R.a.RealtimeBlurView_realtimeOverlayColor, -1426063361);
        typedArrayObtainStyledAttributes.recycle();
        this.f19686v = new Paint();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ int m8750a() {
        int i = f19673j;
        f19673j = i - 1;
        return i;
    }

    /* JADX INFO: renamed from: b */
    public void m8751b() {
        m8752c();
        this.f19680p.release();
    }

    /* JADX INFO: renamed from: c */
    public final void m8752c() {
        Bitmap bitmap = this.f19682r;
        if (bitmap != null) {
            bitmap.recycle();
            this.f19682r = null;
        }
        Bitmap bitmap2 = this.f19683s;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f19683s = null;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f19685u) {
            throw f19675l;
        }
        if (f19673j > 0) {
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

    public InterfaceC2400c getBlurImpl() {
        if (f19674k == 0) {
            try {
                C2398a c2398a = new C2398a();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                c2398a.mo2285b(getContext(), bitmapCreateBitmap, 4.0f);
                c2398a.release();
                bitmapCreateBitmap.recycle();
                f19674k = 3;
            } catch (Throwable unused) {
            }
        }
        if (f19674k == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                C2399b c2399b = new C2399b();
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                c2399b.mo2285b(getContext(), bitmapCreateBitmap2, 4.0f);
                c2399b.release();
                bitmapCreateBitmap2.recycle();
                f19674k = 1;
            } catch (Throwable unused2) {
            }
        }
        if (f19674k == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                C2402e c2402e = new C2402e();
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                c2402e.mo2285b(getContext(), bitmapCreateBitmap3, 4.0f);
                c2402e.release();
                bitmapCreateBitmap3.recycle();
                f19674k = 2;
            } catch (Throwable unused3) {
            }
        }
        if (f19674k == 0) {
            f19674k = -1;
        }
        int i = f19674k;
        if (i == 1) {
            return new C2399b();
        }
        if (i != 2) {
            return i != 3 ? new C2401d() : new C2398a();
        }
        return new C2402e();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.f19689y = activityDecorView;
        if (activityDecorView == null) {
            this.f19690z = false;
            return;
        }
        activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.f19676A);
        boolean z2 = this.f19689y.getRootView() != getRootView();
        this.f19690z = z2;
        if (z2) {
            this.f19689y.postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        View view = this.f19689y;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.f19676A);
        }
        m8751b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f19683s;
        int i = this.f19678n;
        if (bitmap != null) {
            this.f19687w.right = bitmap.getWidth();
            this.f19687w.bottom = bitmap.getHeight();
            this.f19688x.right = getWidth();
            this.f19688x.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.f19687w, this.f19688x, (Paint) null);
        }
        this.f19686v.setColor(i);
        canvas.drawRect(this.f19688x, this.f19686v);
    }

    public void setBlurRadius(float f) {
        if (this.f19679o != f) {
            this.f19679o = f;
            this.f19681q = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
        if (this.f19677m != f) {
            this.f19677m = f;
            this.f19681q = true;
            m8752c();
            invalidate();
        }
    }

    public void setOverlayColor(int i) {
        if (this.f19678n != i) {
            this.f19678n = i;
            invalidate();
        }
    }
}
