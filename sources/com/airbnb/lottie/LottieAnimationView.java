package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import b.c.a.FontAssetDelegate;
import b.c.a.ImageAssetDelegate;
import b.c.a.L;
import b.c.a.LottieComposition;
import b.c.a.LottieCompositionFactory;
import b.c.a.LottieCompositionFactory2;
import b.c.a.LottieCompositionFactory3;
import b.c.a.LottieCompositionFactory4;
import b.c.a.LottieCompositionFactory5;
import b.c.a.LottieDrawable;
import b.c.a.LottieListener;
import b.c.a.LottieOnCompositionLoadedListener;
import b.c.a.LottieProperty;
import b.c.a.LottieTask2;
import b.c.a.PerformanceTracker;
import b.c.a.RenderMode;
import b.c.a.SimpleColorFilter;
import b.c.a.TextDelegate;
import b.c.a.b0.Logger2;
import b.c.a.b0.LottieValueAnimator;
import b.c.a.b0.Utils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.x.FontAssetManager;
import b.c.a.x.ImageAssetManager;
import b.c.a.y.KeyPath;
import b.d.b.a.outline;
import java.io.ByteArrayInputStream;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final String j = LottieAnimationView.class.getSimpleName();
    public static final LottieListener<Throwable> k = new a();
    public int A;

    @Nullable
    public LottieTask2<LottieComposition> B;

    @Nullable
    public LottieComposition C;
    public final LottieListener<LottieComposition> l;
    public final LottieListener<Throwable> m;

    @Nullable
    public LottieListener<Throwable> n;

    @DrawableRes
    public int o;
    public final LottieDrawable p;
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
    public RenderMode f1999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Set<LottieOnCompositionLoadedListener> f2000z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public String j;
        public int k;
        public float l;
        public boolean m;
        public String n;
        public int o;
        public int p;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.j);
            parcel.writeFloat(this.l);
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeString(this.n);
            parcel.writeInt(this.o);
            parcel.writeInt(this.p);
        }

        public SavedState(Parcel parcel, a aVar) {
            super(parcel);
            this.j = parcel.readString();
            this.l = parcel.readFloat();
            this.m = parcel.readInt() == 1;
            this.n = parcel.readString();
            this.o = parcel.readInt();
            this.p = parcel.readInt();
        }
    }

    public class a implements LottieListener<Throwable> {
        @Override // b.c.a.LottieListener
        public void a(Throwable th) {
            Throwable th2 = th;
            PathMeasure pathMeasure = Utils.a;
            if (!((th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException))) {
                throw new IllegalStateException("Unable to parse composition", th2);
            }
            Logger2.c("Unable to load composition.", th2);
        }
    }

    public class b implements LottieListener<LottieComposition> {
        public b() {
        }

        @Override // b.c.a.LottieListener
        public void a(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    }

    public class c implements LottieListener<Throwable> {
        public c() {
        }

        @Override // b.c.a.LottieListener
        public void a(Throwable th) {
            Throwable th2 = th;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i = lottieAnimationView.o;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            LottieListener<Throwable> lottieListener = LottieAnimationView.this.n;
            if (lottieListener == null) {
                String str = LottieAnimationView.j;
                lottieListener = LottieAnimationView.k;
            }
            lottieListener.a(th2);
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet);
        this.l = new b();
        this.m = new c();
        this.o = 0;
        LottieDrawable lottieDrawable = new LottieDrawable();
        this.p = lottieDrawable;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.f1998x = true;
        this.f1999y = RenderMode.AUTOMATIC;
        this.f2000z = new HashSet();
        this.A = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.b.LottieAnimationView, R.a.lottieAnimationViewStyle, 0);
        if (!isInEditMode()) {
            this.f1998x = typedArrayObtainStyledAttributes.getBoolean(R.b.LottieAnimationView_lottie_cacheComposition, true);
            int i = R.b.LottieAnimationView_lottie_rawRes;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i);
            int i2 = R.b.LottieAnimationView_lottie_fileName;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = R.b.LottieAnimationView_lottie_url;
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
            setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.b.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.b.LottieAnimationView_lottie_autoPlay, false)) {
            this.v = true;
            this.w = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.b.LottieAnimationView_lottie_loop, false)) {
            lottieDrawable.l.setRepeatCount(-1);
        }
        int i4 = R.b.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i4, 1));
        }
        int i5 = R.b.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i5, -1));
        }
        int i6 = R.b.LottieAnimationView_lottie_speed;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i6, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.b.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.b.LottieAnimationView_lottie_progress, 0.0f));
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.b.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        if (lottieDrawable.w != z2) {
            lottieDrawable.w = z2;
            if (lottieDrawable.k != null) {
                lottieDrawable.b();
            }
        }
        int i7 = R.b.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            lottieDrawable.a(new KeyPath("**"), LottieProperty.C, new LottieValueCallback(new SimpleColorFilter(typedArrayObtainStyledAttributes.getColor(i7, 0))));
        }
        int i8 = R.b.LottieAnimationView_lottie_scale;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            lottieDrawable.m = typedArrayObtainStyledAttributes.getFloat(i8, 1.0f);
            lottieDrawable.v();
        }
        int i9 = R.b.LottieAnimationView_lottie_renderMode;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            int i10 = typedArrayObtainStyledAttributes.getInt(i9, 0);
            RenderMode.values();
            setRenderMode(RenderMode.values()[i10 >= 3 ? 0 : i10]);
        }
        if (getScaleType() != null) {
            lottieDrawable.r = getScaleType();
        }
        typedArrayObtainStyledAttributes.recycle();
        Context context2 = getContext();
        PathMeasure pathMeasure = Utils.a;
        Boolean boolValueOf = Boolean.valueOf(Settings.Global.getFloat(context2.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f);
        Objects.requireNonNull(lottieDrawable);
        lottieDrawable.n = boolValueOf.booleanValue();
        b();
        this.q = true;
    }

    private void setCompositionTask(LottieTask2<LottieComposition> lottieTask2) {
        this.C = null;
        this.p.c();
        a();
        lottieTask2.b(this.l);
        lottieTask2.a(this.m);
        this.B = lottieTask2;
    }

    public final void a() {
        LottieTask2<LottieComposition> lottieTask2 = this.B;
        if (lottieTask2 != null) {
            LottieListener<LottieComposition> lottieListener = this.l;
            synchronized (lottieTask2) {
                lottieTask2.f374b.remove(lottieListener);
            }
            LottieTask2<LottieComposition> lottieTask3 = this.B;
            LottieListener<Throwable> lottieListener2 = this.m;
            synchronized (lottieTask3) {
                lottieTask3.c.remove(lottieListener2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:5:0x000c  */
    public final void b() {
        int iOrdinal = this.f1999y.ordinal();
        int i = 2;
        if (iOrdinal == 0) {
            LottieComposition lottieComposition = this.C;
            boolean z2 = false;
            if ((lottieComposition == null || !lottieComposition.n || Build.VERSION.SDK_INT >= 28) && (lottieComposition == null || lottieComposition.o <= 4)) {
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
            setRenderMode(RenderMode.HARDWARE);
        }
        this.A--;
        L.a("buildDrawingCache");
    }

    @MainThread
    public void c() {
        this.w = false;
        this.v = false;
        this.u = false;
        this.t = false;
        LottieDrawable lottieDrawable = this.p;
        lottieDrawable.p.clear();
        lottieDrawable.l.m();
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
    public LottieComposition getComposition() {
        return this.C;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.C;
        if (lottieComposition != null) {
            return (long) lottieComposition.b();
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
    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.p.k;
        if (lottieComposition != null) {
            return lottieComposition.a;
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

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.p;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
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
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.p.i()) {
            this.v = false;
            this.u = false;
            this.t = false;
            LottieDrawable lottieDrawable = this.p;
            lottieDrawable.p.clear();
            lottieDrawable.l.cancel();
            b();
            this.v = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.j;
        this.r = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.r);
        }
        int i = savedState.k;
        this.f1997s = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.l);
        if (savedState.m) {
            d();
        }
        this.p.t = savedState.n;
        setRepeatMode(savedState.o);
        setRepeatCount(savedState.p);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.j = this.r;
        savedState.k = this.f1997s;
        savedState.l = this.p.g();
        savedState.m = this.p.i() || (!ViewCompat.isAttachedToWindow(this) && this.v);
        LottieDrawable lottieDrawable = this.p;
        savedState.n = lottieDrawable.t;
        savedState.o = lottieDrawable.l.getRepeatMode();
        savedState.p = this.p.h();
        return savedState;
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
        LottieTask2<LottieComposition> lottieTask2A;
        this.f1997s = i;
        this.r = null;
        if (this.f1998x) {
            Context context = getContext();
            lottieTask2A = LottieCompositionFactory.a(LottieCompositionFactory.f(context, i), new LottieCompositionFactory4(new WeakReference(context), context.getApplicationContext(), i));
        } else {
            Context context2 = getContext();
            Map<String, LottieTask2<LottieComposition>> map = LottieCompositionFactory.a;
            lottieTask2A = LottieCompositionFactory.a(null, new LottieCompositionFactory4(new WeakReference(context2), context2.getApplicationContext(), i));
        }
        setCompositionTask(lottieTask2A);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setCompositionTask(LottieCompositionFactory.a(null, new LottieCompositionFactory5(new ByteArrayInputStream(str.getBytes()), null)));
    }

    public void setAnimationFromUrl(String str) {
        LottieTask2<LottieComposition> lottieTask2A;
        if (this.f1998x) {
            Context context = getContext();
            Map<String, LottieTask2<LottieComposition>> map = LottieCompositionFactory.a;
            String strW = outline.w("url_", str);
            lottieTask2A = LottieCompositionFactory.a(strW, new LottieCompositionFactory2(context, str, strW));
        } else {
            lottieTask2A = LottieCompositionFactory.a(null, new LottieCompositionFactory2(getContext(), str, null));
        }
        setCompositionTask(lottieTask2A);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.p.A = z2;
    }

    public void setCacheComposition(boolean z2) {
        this.f1998x = z2;
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        this.p.setCallback(this);
        this.C = lottieComposition;
        LottieDrawable lottieDrawable = this.p;
        boolean z2 = false;
        if (lottieDrawable.k != lottieComposition) {
            lottieDrawable.C = false;
            lottieDrawable.c();
            lottieDrawable.k = lottieComposition;
            lottieDrawable.b();
            LottieValueAnimator lottieValueAnimator = lottieDrawable.l;
            z2 = lottieValueAnimator.f344s == null;
            lottieValueAnimator.f344s = lottieComposition;
            if (z2) {
                lottieValueAnimator.o((int) Math.max(lottieValueAnimator.q, lottieComposition.k), (int) Math.min(lottieValueAnimator.r, lottieComposition.l));
            } else {
                lottieValueAnimator.o((int) lottieComposition.k, (int) lottieComposition.l);
            }
            float f = lottieValueAnimator.o;
            lottieValueAnimator.o = 0.0f;
            lottieValueAnimator.n((int) f);
            lottieValueAnimator.f();
            lottieDrawable.u(lottieDrawable.l.getAnimatedFraction());
            lottieDrawable.m = lottieDrawable.m;
            lottieDrawable.v();
            lottieDrawable.v();
            Iterator it = new ArrayList(lottieDrawable.p).iterator();
            while (it.hasNext()) {
                ((LottieDrawable.o) it.next()).a(lottieComposition);
                it.remove();
            }
            lottieDrawable.p.clear();
            lottieComposition.a.a = lottieDrawable.f355z;
            Drawable.Callback callback = lottieDrawable.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(lottieDrawable);
            }
            z2 = true;
        }
        b();
        if (getDrawable() != this.p || z2) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<LottieOnCompositionLoadedListener> it2 = this.f2000z.iterator();
            while (it2.hasNext()) {
                it2.next().a(lottieComposition);
            }
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.n = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.o = i;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        FontAssetManager fontAssetManager = this.p.v;
    }

    public void setFrame(int i) {
        this.p.l(i);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        LottieDrawable lottieDrawable = this.p;
        lottieDrawable.u = imageAssetDelegate;
        ImageAssetManager imageAssetManager = lottieDrawable.f352s;
        if (imageAssetManager != null) {
            imageAssetManager.d = imageAssetDelegate;
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
        LottieDrawable lottieDrawable = this.p;
        lottieDrawable.f355z = z2;
        LottieComposition lottieComposition = lottieDrawable.k;
        if (lottieComposition != null) {
            lottieComposition.a.a = z2;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.p.u(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f1999y = renderMode;
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
        LottieDrawable lottieDrawable = this.p;
        lottieDrawable.m = f;
        lottieDrawable.v();
        if (getDrawable() == this.p) {
            setImageDrawable(null);
            setImageDrawable(this.p);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        LottieDrawable lottieDrawable = this.p;
        if (lottieDrawable != null) {
            lottieDrawable.r = scaleType;
        }
    }

    public void setSpeed(float f) {
        this.p.l.l = f;
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        Objects.requireNonNull(this.p);
    }

    public void setMaxFrame(String str) {
        this.p.n(str);
    }

    public void setMinFrame(String str) {
        this.p.s(str);
    }

    public void setAnimation(String str) {
        LottieTask2<LottieComposition> lottieTask2A;
        this.r = str;
        this.f1997s = 0;
        if (this.f1998x) {
            Context context = getContext();
            Map<String, LottieTask2<LottieComposition>> map = LottieCompositionFactory.a;
            String strW = outline.w("asset_", str);
            lottieTask2A = LottieCompositionFactory.a(strW, new LottieCompositionFactory3(context.getApplicationContext(), str, strW));
        } else {
            Context context2 = getContext();
            Map<String, LottieTask2<LottieComposition>> map2 = LottieCompositionFactory.a;
            lottieTask2A = LottieCompositionFactory.a(null, new LottieCompositionFactory3(context2.getApplicationContext(), str, null));
        }
        setCompositionTask(lottieTask2A);
    }
}
