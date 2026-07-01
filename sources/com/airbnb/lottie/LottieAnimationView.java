package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.provider.Settings$Global;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView$ScaleType;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import b.c.a.b;
import b.c.a.b0.g;
import b.c.a.c0.c;
import b.c.a.d;
import b.c.a.e;
import b.c.a.h;
import b.c.a.i;
import b.c.a.j;
import b.c.a.j$o;
import b.c.a.l;
import b.c.a.n;
import b.c.a.o;
import b.c.a.r;
import b.c.a.s;
import b.c.a.t;
import b.c.a.u;
import b.c.a.v;
import b.c.a.y.f;
import b.d.b.a.a;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final String j = LottieAnimationView.class.getSimpleName();
    public static final l<Throwable> k = new LottieAnimationView$a();
    public int A;

    @Nullable
    public r<d> B;

    @Nullable
    public d C;
    public final l<d> l;
    public final l<Throwable> m;

    @Nullable
    public l<Throwable> n;

    @DrawableRes
    public int o;
    public final j p;
    public boolean q;
    public String r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @RawRes
    public int f1997s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public t f1999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Set<n> f2000z;

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet);
        this.l = new LottieAnimationView$b(this);
        this.m = new LottieAnimationView$c(this);
        this.o = 0;
        j jVar = new j();
        this.p = jVar;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.f1998x = true;
        this.f1999y = t.AUTOMATIC;
        this.f2000z = new HashSet();
        this.A = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$b.LottieAnimationView, R$a.lottieAnimationViewStyle, 0);
        if (!isInEditMode()) {
            this.f1998x = typedArrayObtainStyledAttributes.getBoolean(R$b.LottieAnimationView_lottie_cacheComposition, true);
            int i = R$b.LottieAnimationView_lottie_rawRes;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i);
            int i2 = R$b.LottieAnimationView_lottie_fileName;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = R$b.LottieAnimationView_lottie_url;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i3);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(i, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(i2);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i3)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R$b.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$b.LottieAnimationView_lottie_autoPlay, false)) {
            this.v = true;
            this.w = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$b.LottieAnimationView_lottie_loop, false)) {
            jVar.l.setRepeatCount(-1);
        }
        int i4 = R$b.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i4, 1));
        }
        int i5 = R$b.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i5, -1));
        }
        int i6 = R$b.LottieAnimationView_lottie_speed;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i6, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R$b.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R$b.LottieAnimationView_lottie_progress, 0.0f));
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$b.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        if (jVar.w != z2) {
            jVar.w = z2;
            if (jVar.k != null) {
                jVar.b();
            }
        }
        int i7 = R$b.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            jVar.a(new f("**"), o.C, new c(new u(typedArrayObtainStyledAttributes.getColor(i7, 0))));
        }
        int i8 = R$b.LottieAnimationView_lottie_scale;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            jVar.m = typedArrayObtainStyledAttributes.getFloat(i8, 1.0f);
            jVar.v();
        }
        int i9 = R$b.LottieAnimationView_lottie_renderMode;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            int i10 = typedArrayObtainStyledAttributes.getInt(i9, 0);
            t.values();
            setRenderMode(t.values()[i10 >= 3 ? 0 : i10]);
        }
        if (getScaleType() != null) {
            jVar.r = getScaleType();
        }
        typedArrayObtainStyledAttributes.recycle();
        Context context2 = getContext();
        PathMeasure pathMeasure = g.a;
        Boolean boolValueOf = Boolean.valueOf(Settings$Global.getFloat(context2.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f);
        Objects.requireNonNull(jVar);
        jVar.n = boolValueOf.booleanValue();
        b();
        this.q = true;
    }

    private void setCompositionTask(r<d> rVar) {
        this.C = null;
        this.p.c();
        a();
        rVar.b(this.l);
        rVar.a(this.m);
        this.B = rVar;
    }

    public final void a() {
        r<d> rVar = this.B;
        if (rVar != null) {
            l<d> lVar = this.l;
            synchronized (rVar) {
                rVar.f374b.remove(lVar);
            }
            r<d> rVar2 = this.B;
            l<Throwable> lVar2 = this.m;
            synchronized (rVar2) {
                rVar2.c.remove(lVar2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:5:0x000c  */
    public final void b() {
        int iOrdinal = this.f1999y.ordinal();
        int i = 2;
        if (iOrdinal == 0) {
            d dVar = this.C;
            boolean z2 = false;
            if ((dVar == null || !dVar.n || Build$VERSION.SDK_INT >= 28) && (dVar == null || dVar.o <= 4)) {
                z2 = true;
            }
            if (!z2) {
                i = 1;
            }
        } else if (iOrdinal != 1) {
            i = 1;
        }
        if (i != getLayerType()) {
            setLayerType(i, null);
        }
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z2) {
        this.A++;
        super.buildDrawingCache(z2);
        if (this.A == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z2) == null) {
            setRenderMode(t.HARDWARE);
        }
        this.A--;
        b.c.a.c.a("buildDrawingCache");
    }

    @MainThread
    public void c() {
        this.w = false;
        this.v = false;
        this.u = false;
        this.t = false;
        j jVar = this.p;
        jVar.p.clear();
        jVar.l.m();
        b();
    }

    @MainThread
    public void d() {
        if (!isShown()) {
            this.t = true;
        } else {
            this.p.j();
            b();
        }
    }

    @Nullable
    public d getComposition() {
        return this.C;
    }

    public long getDuration() {
        d dVar = this.C;
        if (dVar != null) {
            return (long) dVar.b();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.p.l.o;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.p.t;
    }

    public float getMaxFrame() {
        return this.p.e();
    }

    public float getMinFrame() {
        return this.p.f();
    }

    @Nullable
    public s getPerformanceTracker() {
        d dVar = this.p.k;
        if (dVar != null) {
            return dVar.a;
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.p.g();
    }

    public int getRepeatCount() {
        return this.p.h();
    }

    public int getRepeatMode() {
        return this.p.l.getRepeatMode();
    }

    public float getScale() {
        return this.p.m;
    }

    public float getSpeed() {
        return this.p.l.l;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        j jVar = this.p;
        if (drawable2 == jVar) {
            super.invalidateDrawable(jVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.w || this.v) {
            d();
            this.w = false;
            this.v = false;
        }
        if (Build$VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.p.i()) {
            this.v = false;
            this.u = false;
            this.t = false;
            j jVar = this.p;
            jVar.p.clear();
            jVar.l.cancel();
            b();
            this.v = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof LottieAnimationView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        LottieAnimationView$SavedState lottieAnimationView$SavedState = (LottieAnimationView$SavedState) parcelable;
        super.onRestoreInstanceState(lottieAnimationView$SavedState.getSuperState());
        String str = lottieAnimationView$SavedState.j;
        this.r = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.r);
        }
        int i = lottieAnimationView$SavedState.k;
        this.f1997s = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(lottieAnimationView$SavedState.l);
        if (lottieAnimationView$SavedState.m) {
            d();
        }
        this.p.t = lottieAnimationView$SavedState.n;
        setRepeatMode(lottieAnimationView$SavedState.o);
        setRepeatCount(lottieAnimationView$SavedState.p);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        LottieAnimationView$SavedState lottieAnimationView$SavedState = new LottieAnimationView$SavedState(super.onSaveInstanceState());
        lottieAnimationView$SavedState.j = this.r;
        lottieAnimationView$SavedState.k = this.f1997s;
        lottieAnimationView$SavedState.l = this.p.g();
        lottieAnimationView$SavedState.m = this.p.i() || (!ViewCompat.isAttachedToWindow(this) && this.v);
        j jVar = this.p;
        lottieAnimationView$SavedState.n = jVar.t;
        lottieAnimationView$SavedState.o = jVar.l.getRepeatMode();
        lottieAnimationView$SavedState.p = this.p.h();
        return lottieAnimationView$SavedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.q) {
            if (!isShown()) {
                if (this.p.i()) {
                    c();
                    this.u = true;
                    return;
                }
                return;
            }
            if (this.u) {
                if (isShown()) {
                    this.p.k();
                    b();
                } else {
                    this.t = false;
                    this.u = true;
                }
            } else if (this.t) {
                d();
            }
            this.u = false;
            this.t = false;
        }
    }

    public void setAnimation(@RawRes int i) {
        r<d> rVarA;
        this.f1997s = i;
        this.r = null;
        if (this.f1998x) {
            Context context = getContext();
            rVarA = e.a(e.f(context, i), new h(new WeakReference(context), context.getApplicationContext(), i));
        } else {
            Context context2 = getContext();
            Map<String, r<d>> map = e.a;
            rVarA = e.a(null, new h(new WeakReference(context2), context2.getApplicationContext(), i));
        }
        setCompositionTask(rVarA);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setCompositionTask(e.a(null, new i(new ByteArrayInputStream(str.getBytes()), null)));
    }

    public void setAnimationFromUrl(String str) {
        r<d> rVarA;
        if (this.f1998x) {
            Context context = getContext();
            Map<String, r<d>> map = e.a;
            String strW = a.w("url_", str);
            rVarA = e.a(strW, new b.c.a.f(context, str, strW));
        } else {
            rVarA = e.a(null, new b.c.a.f(getContext(), str, null));
        }
        setCompositionTask(rVarA);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.p.A = z2;
    }

    public void setCacheComposition(boolean z2) {
        this.f1998x = z2;
    }

    public void setComposition(@NonNull d dVar) {
        this.p.setCallback(this);
        this.C = dVar;
        j jVar = this.p;
        boolean z2 = false;
        if (jVar.k != dVar) {
            jVar.C = false;
            jVar.c();
            jVar.k = dVar;
            jVar.b();
            b.c.a.b0.d dVar2 = jVar.l;
            z2 = dVar2.f344s == null;
            dVar2.f344s = dVar;
            if (z2) {
                dVar2.o((int) Math.max(dVar2.q, dVar.k), (int) Math.min(dVar2.r, dVar.l));
            } else {
                dVar2.o((int) dVar.k, (int) dVar.l);
            }
            float f = dVar2.o;
            dVar2.o = 0.0f;
            dVar2.n((int) f);
            dVar2.f();
            jVar.u(jVar.l.getAnimatedFraction());
            jVar.m = jVar.m;
            jVar.v();
            jVar.v();
            Iterator it = new ArrayList(jVar.p).iterator();
            while (it.hasNext()) {
                ((j$o) it.next()).a(dVar);
                it.remove();
            }
            jVar.p.clear();
            dVar.a.a = jVar.f355z;
            Drawable$Callback callback = jVar.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(jVar);
            }
            z2 = true;
        }
        b();
        if (getDrawable() != this.p || z2) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<n> it2 = this.f2000z.iterator();
            while (it2.hasNext()) {
                it2.next().a(dVar);
            }
        }
    }

    public void setFailureListener(@Nullable l<Throwable> lVar) {
        this.n = lVar;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.o = i;
    }

    public void setFontAssetDelegate(b.c.a.a aVar) {
        b.c.a.x.a aVar2 = this.p.v;
    }

    public void setFrame(int i) {
        this.p.l(i);
    }

    public void setImageAssetDelegate(b bVar) {
        j jVar = this.p;
        jVar.u = bVar;
        b.c.a.x.b bVar2 = jVar.f352s;
        if (bVar2 != null) {
            bVar2.d = bVar;
        }
    }

    public void setImageAssetsFolder(String str) {
        this.p.t = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        a();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        a();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        a();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.p.m(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.p.o(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.p.q(str);
    }

    public void setMinFrame(int i) {
        this.p.r(i);
    }

    public void setMinProgress(float f) {
        this.p.t(f);
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        j jVar = this.p;
        jVar.f355z = z2;
        d dVar = jVar.k;
        if (dVar != null) {
            dVar.a.a = z2;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.p.u(f);
    }

    public void setRenderMode(t tVar) {
        this.f1999y = tVar;
        b();
    }

    public void setRepeatCount(int i) {
        this.p.l.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.p.l.setRepeatMode(i);
    }

    public void setSafeMode(boolean z2) {
        this.p.o = z2;
    }

    public void setScale(float f) {
        j jVar = this.p;
        jVar.m = f;
        jVar.v();
        if (getDrawable() == this.p) {
            setImageDrawable(null);
            setImageDrawable(this.p);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView$ScaleType imageView$ScaleType) {
        super.setScaleType(imageView$ScaleType);
        j jVar = this.p;
        if (jVar != null) {
            jVar.r = imageView$ScaleType;
        }
    }

    public void setSpeed(float f) {
        this.p.l.l = f;
    }

    public void setTextDelegate(v vVar) {
        Objects.requireNonNull(this.p);
    }

    public void setMaxFrame(String str) {
        this.p.n(str);
    }

    public void setMinFrame(String str) {
        this.p.s(str);
    }

    public void setAnimation(String str) {
        r<d> rVarA;
        this.r = str;
        this.f1997s = 0;
        if (this.f1998x) {
            Context context = getContext();
            Map<String, r<d>> map = e.a;
            String strW = a.w("asset_", str);
            rVarA = e.a(strW, new b.c.a.g(context.getApplicationContext(), str, strW));
        } else {
            Context context2 = getContext();
            Map<String, r<d>> map2 = e.a;
            rVarA = e.a(null, new b.c.a.g(context2.getApplicationContext(), str, null));
        }
        setCompositionTask(rVarA);
    }
}
