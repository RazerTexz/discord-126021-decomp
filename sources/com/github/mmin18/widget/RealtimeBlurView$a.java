package com.github.mmin18.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class RealtimeBlurView$a implements ViewTreeObserver$OnPreDrawListener {
    public final /* synthetic */ RealtimeBlurView j;

    public RealtimeBlurView$a(RealtimeBlurView realtimeBlurView) {
        this.j = realtimeBlurView;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0083  */
    /* JADX WARN: Code duplicated, block: B:32:0x0091  */
    /* JADX WARN: Code duplicated, block: B:36:0x009b  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:43:0x0112 A[Catch: all -> 0x012e, RealtimeBlurView$b -> 0x013e, TryCatch #3 {RealtimeBlurView$b -> 0x013e, all -> 0x012e, blocks: (B:41:0x00d6, B:43:0x0112, B:44:0x011d), top: B:59:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x015f  */
    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        boolean z2;
        Bitmap bitmap;
        boolean z3;
        RealtimeBlurView realtimeBlurView;
        int[] iArr = new int[2];
        RealtimeBlurView realtimeBlurView2 = this.j;
        Bitmap bitmap2 = realtimeBlurView2.f2910s;
        View view = realtimeBlurView2.f2912y;
        if (view != null && realtimeBlurView2.isShown()) {
            RealtimeBlurView realtimeBlurView3 = this.j;
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
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap$Config.ARGB_8888);
                        realtimeBlurView3.r = bitmapCreateBitmap;
                        if (bitmapCreateBitmap != null) {
                            realtimeBlurView3.t = new Canvas(realtimeBlurView3.r);
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMax, iMax2, Bitmap$Config.ARGB_8888);
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
                    if (this.j.f2910s != bitmap2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    view.getLocationOnScreen(iArr);
                    int i = -iArr[0];
                    int i2 = -iArr[1];
                    this.j.getLocationOnScreen(iArr);
                    int i3 = i + iArr[0];
                    int i4 = i2 + iArr[1];
                    RealtimeBlurView realtimeBlurView4 = this.j;
                    realtimeBlurView4.r.eraseColor(realtimeBlurView4.n & ViewCompat.MEASURED_SIZE_MASK);
                    int iSave = this.j.t.save();
                    RealtimeBlurView realtimeBlurView5 = this.j;
                    realtimeBlurView5.u = true;
                    RealtimeBlurView.j++;
                    try {
                        realtimeBlurView5.t.scale((realtimeBlurView5.r.getWidth() * 1.0f) / this.j.getWidth(), (this.j.r.getHeight() * 1.0f) / this.j.getHeight());
                        this.j.t.translate(-i3, -i4);
                        if (view.getBackground() != null) {
                            view.getBackground().draw(this.j.t);
                        }
                        view.draw(this.j.t);
                        this.j.u = false;
                        RealtimeBlurView.a();
                        realtimeBlurView = this.j;
                    } catch (RealtimeBlurView$b unused2) {
                        this.j.u = false;
                        RealtimeBlurView.a();
                        realtimeBlurView = this.j;
                    } catch (Throwable th) {
                        this.j.u = false;
                        RealtimeBlurView.a();
                        this.j.t.restoreToCount(iSave);
                        throw th;
                    }
                    realtimeBlurView.t.restoreToCount(iSave);
                    RealtimeBlurView realtimeBlurView6 = this.j;
                    realtimeBlurView6.p.a(realtimeBlurView6.r, realtimeBlurView6.f2910s);
                    if (z3 || this.j.f2913z) {
                        this.j.invalidate();
                    }
                }
            }
            z2 = false;
            if (z2) {
                if (this.j.f2910s != bitmap2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                view.getLocationOnScreen(iArr);
                int i5 = -iArr[0];
                int i6 = -iArr[1];
                this.j.getLocationOnScreen(iArr);
                int i7 = i5 + iArr[0];
                int i8 = i6 + iArr[1];
                RealtimeBlurView realtimeBlurView7 = this.j;
                realtimeBlurView7.r.eraseColor(realtimeBlurView7.n & ViewCompat.MEASURED_SIZE_MASK);
                int iSave2 = this.j.t.save();
                RealtimeBlurView realtimeBlurView8 = this.j;
                realtimeBlurView8.u = true;
                RealtimeBlurView.j++;
                realtimeBlurView8.t.scale((realtimeBlurView8.r.getWidth() * 1.0f) / this.j.getWidth(), (this.j.r.getHeight() * 1.0f) / this.j.getHeight());
                this.j.t.translate(-i7, -i8);
                if (view.getBackground() != null) {
                    view.getBackground().draw(this.j.t);
                }
                view.draw(this.j.t);
                this.j.u = false;
                RealtimeBlurView.a();
                realtimeBlurView = this.j;
                realtimeBlurView.t.restoreToCount(iSave2);
                RealtimeBlurView realtimeBlurView9 = this.j;
                realtimeBlurView9.p.a(realtimeBlurView9.r, realtimeBlurView9.f2910s);
                if (z3) {
                    this.j.invalidate();
                } else {
                    this.j.invalidate();
                }
            }
        }
        return true;
    }
}
