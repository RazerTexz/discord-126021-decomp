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
import p007b.p085c.p086a.C1453a;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.C1506e;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.C1519r;
import p007b.p085c.p086a.C1520s;
import p007b.p085c.p086a.C1522u;
import p007b.p085c.p086a.C1523v;
import p007b.p085c.p086a.CallableC1507f;
import p007b.p085c.p086a.CallableC1508g;
import p007b.p085c.p086a.CallableC1509h;
import p007b.p085c.p086a.CallableC1510i;
import p007b.p085c.p086a.EnumC1521t;
import p007b.p085c.p086a.InterfaceC1492b;
import p007b.p085c.p086a.InterfaceC1513l;
import p007b.p085c.p086a.InterfaceC1515n;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p089b0.ChoreographerFrameCallbackC1496d;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p094x.C1560a;
import p007b.p085c.p086a.p094x.C1561b;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: j */
    public static final String f14517j = LottieAnimationView.class.getSimpleName();

    /* JADX INFO: renamed from: k */
    public static final InterfaceC1513l<Throwable> f14518k = new C5407a();

    /* JADX INFO: renamed from: A */
    public int f14519A;

    /* JADX INFO: renamed from: B */
    @Nullable
    public C1519r<C1505d> f14520B;

    /* JADX INFO: renamed from: C */
    @Nullable
    public C1505d f14521C;

    /* JADX INFO: renamed from: l */
    public final InterfaceC1513l<C1505d> f14522l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC1513l<Throwable> f14523m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public InterfaceC1513l<Throwable> f14524n;

    /* JADX INFO: renamed from: o */
    @DrawableRes
    public int f14525o;

    /* JADX INFO: renamed from: p */
    public final C1511j f14526p;

    /* JADX INFO: renamed from: q */
    public boolean f14527q;

    /* JADX INFO: renamed from: r */
    public String f14528r;

    /* JADX INFO: renamed from: s */
    @RawRes
    public int f14529s;

    /* JADX INFO: renamed from: t */
    public boolean f14530t;

    /* JADX INFO: renamed from: u */
    public boolean f14531u;

    /* JADX INFO: renamed from: v */
    public boolean f14532v;

    /* JADX INFO: renamed from: w */
    public boolean f14533w;

    /* JADX INFO: renamed from: x */
    public boolean f14534x;

    /* JADX INFO: renamed from: y */
    public EnumC1521t f14535y;

    /* JADX INFO: renamed from: z */
    public Set<InterfaceC1515n> f14536z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C5406a();

        /* JADX INFO: renamed from: j */
        public String f14537j;

        /* JADX INFO: renamed from: k */
        public int f14538k;

        /* JADX INFO: renamed from: l */
        public float f14539l;

        /* JADX INFO: renamed from: m */
        public boolean f14540m;

        /* JADX INFO: renamed from: n */
        public String f14541n;

        /* JADX INFO: renamed from: o */
        public int f14542o;

        /* JADX INFO: renamed from: p */
        public int f14543p;

        /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$SavedState$a */
        public class C5406a implements Parcelable.Creator<SavedState> {
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
            parcel.writeString(this.f14537j);
            parcel.writeFloat(this.f14539l);
            parcel.writeInt(this.f14540m ? 1 : 0);
            parcel.writeString(this.f14541n);
            parcel.writeInt(this.f14542o);
            parcel.writeInt(this.f14543p);
        }

        public SavedState(Parcel parcel, C5407a c5407a) {
            super(parcel);
            this.f14537j = parcel.readString();
            this.f14539l = parcel.readFloat();
            this.f14540m = parcel.readInt() == 1;
            this.f14541n = parcel.readString();
            this.f14542o = parcel.readInt();
            this.f14543p = parcel.readInt();
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$a */
    public class C5407a implements InterfaceC1513l<Throwable> {
        @Override // p007b.p085c.p086a.InterfaceC1513l
        /* JADX INFO: renamed from: a */
        public void mo680a(Throwable th) {
            Throwable th2 = th;
            PathMeasure pathMeasure = C1499g.f2309a;
            if (!((th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException))) {
                throw new IllegalStateException("Unable to parse composition", th2);
            }
            C1495c.m641c("Unable to load composition.", th2);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$b */
    public class C5408b implements InterfaceC1513l<C1505d> {
        public C5408b() {
        }

        @Override // p007b.p085c.p086a.InterfaceC1513l
        /* JADX INFO: renamed from: a */
        public void mo680a(C1505d c1505d) {
            LottieAnimationView.this.setComposition(c1505d);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$c */
    public class C5409c implements InterfaceC1513l<Throwable> {
        public C5409c() {
        }

        @Override // p007b.p085c.p086a.InterfaceC1513l
        /* JADX INFO: renamed from: a */
        public void mo680a(Throwable th) {
            Throwable th2 = th;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i = lottieAnimationView.f14525o;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            InterfaceC1513l<Throwable> interfaceC1513l = LottieAnimationView.this.f14524n;
            if (interfaceC1513l == null) {
                String str = LottieAnimationView.f14517j;
                interfaceC1513l = LottieAnimationView.f14518k;
            }
            interfaceC1513l.mo680a(th2);
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet);
        this.f14522l = new C5408b();
        this.f14523m = new C5409c();
        this.f14525o = 0;
        C1511j c1511j = new C1511j();
        this.f14526p = c1511j;
        this.f14530t = false;
        this.f14531u = false;
        this.f14532v = false;
        this.f14533w = false;
        this.f14534x = true;
        this.f14535y = EnumC1521t.AUTOMATIC;
        this.f14536z = new HashSet();
        this.f14519A = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5410R.b.LottieAnimationView, C5410R.a.lottieAnimationViewStyle, 0);
        if (!isInEditMode()) {
            this.f14534x = typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_cacheComposition, true);
            int i = C5410R.b.LottieAnimationView_lottie_rawRes;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i);
            int i2 = C5410R.b.LottieAnimationView_lottie_fileName;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = C5410R.b.LottieAnimationView_lottie_url;
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
            setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(C5410R.b.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_autoPlay, false)) {
            this.f14532v = true;
            this.f14533w = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_loop, false)) {
            c1511j.f2371l.setRepeatCount(-1);
        }
        int i4 = C5410R.b.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i4, 1));
        }
        int i5 = C5410R.b.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i5, -1));
        }
        int i6 = C5410R.b.LottieAnimationView_lottie_speed;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i6, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(C5410R.b.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(C5410R.b.LottieAnimationView_lottie_progress, 0.0f));
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        if (c1511j.f2382w != z2) {
            c1511j.f2382w = z2;
            if (c1511j.f2370k != null) {
                c1511j.m682b();
            }
        }
        int i7 = C5410R.b.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            c1511j.m681a(new C1567f("**"), InterfaceC1516o.f2421C, new C1503c(new C1522u(typedArrayObtainStyledAttributes.getColor(i7, 0))));
        }
        int i8 = C5410R.b.LottieAnimationView_lottie_scale;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            c1511j.f2372m = typedArrayObtainStyledAttributes.getFloat(i8, 1.0f);
            c1511j.m702v();
        }
        int i9 = C5410R.b.LottieAnimationView_lottie_renderMode;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            int i10 = typedArrayObtainStyledAttributes.getInt(i9, 0);
            EnumC1521t.values();
            setRenderMode(EnumC1521t.values()[i10 >= 3 ? 0 : i10]);
        }
        if (getScaleType() != null) {
            c1511j.f2377r = getScaleType();
        }
        typedArrayObtainStyledAttributes.recycle();
        Context context2 = getContext();
        PathMeasure pathMeasure = C1499g.f2309a;
        Boolean boolValueOf = Boolean.valueOf(Settings.Global.getFloat(context2.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f);
        Objects.requireNonNull(c1511j);
        c1511j.f2373n = boolValueOf.booleanValue();
        m7492b();
        this.f14527q = true;
    }

    private void setCompositionTask(C1519r<C1505d> c1519r) {
        this.f14521C = null;
        this.f14526p.m683c();
        m7491a();
        c1519r.m706b(this.f14522l);
        c1519r.m705a(this.f14523m);
        this.f14520B = c1519r;
    }

    /* JADX INFO: renamed from: a */
    public final void m7491a() {
        C1519r<C1505d> c1519r = this.f14520B;
        if (c1519r != null) {
            InterfaceC1513l<C1505d> interfaceC1513l = this.f14522l;
            synchronized (c1519r) {
                c1519r.f2453b.remove(interfaceC1513l);
            }
            C1519r<C1505d> c1519r2 = this.f14520B;
            InterfaceC1513l<Throwable> interfaceC1513l2 = this.f14523m;
            synchronized (c1519r2) {
                c1519r2.f2454c.remove(interfaceC1513l2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:5:0x000c  */
    /* JADX INFO: renamed from: b */
    public final void m7492b() {
        int iOrdinal = this.f14535y.ordinal();
        int i = 2;
        if (iOrdinal == 0) {
            C1505d c1505d = this.f14521C;
            boolean z2 = false;
            if ((c1505d == null || !c1505d.f2349n || Build.VERSION.SDK_INT >= 28) && (c1505d == null || c1505d.f2350o <= 4)) {
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
        this.f14519A++;
        super.buildDrawingCache(z2);
        if (this.f14519A == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z2) == null) {
            setRenderMode(EnumC1521t.HARDWARE);
        }
        this.f14519A--;
        C1500c.m663a("buildDrawingCache");
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public void m7493c() {
        this.f14533w = false;
        this.f14532v = false;
        this.f14531u = false;
        this.f14530t = false;
        C1511j c1511j = this.f14526p;
        c1511j.f2375p.clear();
        c1511j.f2371l.m648m();
        m7492b();
    }

    @MainThread
    /* JADX INFO: renamed from: d */
    public void m7494d() {
        if (!isShown()) {
            this.f14530t = true;
        } else {
            this.f14526p.m690j();
            m7492b();
        }
    }

    @Nullable
    public C1505d getComposition() {
        return this.f14521C;
    }

    public long getDuration() {
        C1505d c1505d = this.f14521C;
        if (c1505d != null) {
            return (long) c1505d.m670b();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.f14526p.f2371l.f2300o;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f14526p.f2379t;
    }

    public float getMaxFrame() {
        return this.f14526p.m685e();
    }

    public float getMinFrame() {
        return this.f14526p.m686f();
    }

    @Nullable
    public C1520s getPerformanceTracker() {
        C1505d c1505d = this.f14526p.f2370k;
        if (c1505d != null) {
            return c1505d.f2336a;
        }
        return null;
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    public float getProgress() {
        return this.f14526p.m687g();
    }

    public int getRepeatCount() {
        return this.f14526p.m688h();
    }

    public int getRepeatMode() {
        return this.f14526p.f2371l.getRepeatMode();
    }

    public float getScale() {
        return this.f14526p.f2372m;
    }

    public float getSpeed() {
        return this.f14526p.f2371l.f2297l;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        C1511j c1511j = this.f14526p;
        if (drawable2 == c1511j) {
            super.invalidateDrawable(c1511j);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14533w || this.f14532v) {
            m7494d();
            this.f14533w = false;
            this.f14532v = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.f14526p.m689i()) {
            this.f14532v = false;
            this.f14531u = false;
            this.f14530t = false;
            C1511j c1511j = this.f14526p;
            c1511j.f2375p.clear();
            c1511j.f2371l.cancel();
            m7492b();
            this.f14532v = true;
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
        String str = savedState.f14537j;
        this.f14528r = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f14528r);
        }
        int i = savedState.f14538k;
        this.f14529s = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f14539l);
        if (savedState.f14540m) {
            m7494d();
        }
        this.f14526p.f2379t = savedState.f14541n;
        setRepeatMode(savedState.f14542o);
        setRepeatCount(savedState.f14543p);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14537j = this.f14528r;
        savedState.f14538k = this.f14529s;
        savedState.f14539l = this.f14526p.m687g();
        savedState.f14540m = this.f14526p.m689i() || (!ViewCompat.isAttachedToWindow(this) && this.f14532v);
        C1511j c1511j = this.f14526p;
        savedState.f14541n = c1511j.f2379t;
        savedState.f14542o = c1511j.f2371l.getRepeatMode();
        savedState.f14543p = this.f14526p.m688h();
        return savedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.f14527q) {
            if (!isShown()) {
                if (this.f14526p.m689i()) {
                    m7493c();
                    this.f14531u = true;
                    return;
                }
                return;
            }
            if (this.f14531u) {
                if (isShown()) {
                    this.f14526p.m691k();
                    m7492b();
                } else {
                    this.f14530t = false;
                    this.f14531u = true;
                }
            } else if (this.f14530t) {
                m7494d();
            }
            this.f14531u = false;
            this.f14530t = false;
        }
    }

    public void setAnimation(@RawRes int i) {
        C1519r<C1505d> c1519rM674a;
        this.f14529s = i;
        this.f14528r = null;
        if (this.f14534x) {
            Context context = getContext();
            c1519rM674a = C1506e.m674a(C1506e.m679f(context, i), new CallableC1509h(new WeakReference(context), context.getApplicationContext(), i));
        } else {
            Context context2 = getContext();
            Map<String, C1519r<C1505d>> map = C1506e.f2351a;
            c1519rM674a = C1506e.m674a(null, new CallableC1509h(new WeakReference(context2), context2.getApplicationContext(), i));
        }
        setCompositionTask(c1519rM674a);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setCompositionTask(C1506e.m674a(null, new CallableC1510i(new ByteArrayInputStream(str.getBytes()), null)));
    }

    public void setAnimationFromUrl(String str) {
        C1519r<C1505d> c1519rM674a;
        if (this.f14534x) {
            Context context = getContext();
            Map<String, C1519r<C1505d>> map = C1506e.f2351a;
            String strM883w = C1643a.m883w("url_", str);
            c1519rM674a = C1506e.m674a(strM883w, new CallableC1507f(context, str, strM883w));
        } else {
            c1519rM674a = C1506e.m674a(null, new CallableC1507f(getContext(), str, null));
        }
        setCompositionTask(c1519rM674a);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.f14526p.f2366A = z2;
    }

    public void setCacheComposition(boolean z2) {
        this.f14534x = z2;
    }

    public void setComposition(@NonNull C1505d c1505d) {
        this.f14526p.setCallback(this);
        this.f14521C = c1505d;
        C1511j c1511j = this.f14526p;
        boolean z2 = false;
        if (c1511j.f2370k != c1505d) {
            c1511j.f2368C = false;
            c1511j.m683c();
            c1511j.f2370k = c1505d;
            c1511j.m682b();
            ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = c1511j.f2371l;
            z2 = choreographerFrameCallbackC1496d.f2304s == null;
            choreographerFrameCallbackC1496d.f2304s = c1505d;
            if (z2) {
                choreographerFrameCallbackC1496d.m650o((int) Math.max(choreographerFrameCallbackC1496d.f2302q, c1505d.f2346k), (int) Math.min(choreographerFrameCallbackC1496d.f2303r, c1505d.f2347l));
            } else {
                choreographerFrameCallbackC1496d.m650o((int) c1505d.f2346k, (int) c1505d.f2347l);
            }
            float f = choreographerFrameCallbackC1496d.f2300o;
            choreographerFrameCallbackC1496d.f2300o = 0.0f;
            choreographerFrameCallbackC1496d.m649n((int) f);
            choreographerFrameCallbackC1496d.m638f();
            c1511j.m701u(c1511j.f2371l.getAnimatedFraction());
            c1511j.f2372m = c1511j.f2372m;
            c1511j.m702v();
            c1511j.m702v();
            Iterator it = new ArrayList(c1511j.f2375p).iterator();
            while (it.hasNext()) {
                ((C1511j.o) it.next()).mo703a(c1505d);
                it.remove();
            }
            c1511j.f2375p.clear();
            c1505d.f2336a.f2458a = c1511j.f2385z;
            Drawable.Callback callback = c1511j.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(c1511j);
            }
            z2 = true;
        }
        m7492b();
        if (getDrawable() != this.f14526p || z2) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<InterfaceC1515n> it2 = this.f14536z.iterator();
            while (it2.hasNext()) {
                it2.next().m704a(c1505d);
            }
        }
    }

    public void setFailureListener(@Nullable InterfaceC1513l<Throwable> interfaceC1513l) {
        this.f14524n = interfaceC1513l;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.f14525o = i;
    }

    public void setFontAssetDelegate(C1453a c1453a) {
        C1560a c1560a = this.f14526p.f2381v;
    }

    public void setFrame(int i) {
        this.f14526p.m692l(i);
    }

    public void setImageAssetDelegate(InterfaceC1492b interfaceC1492b) {
        C1511j c1511j = this.f14526p;
        c1511j.f2380u = interfaceC1492b;
        C1561b c1561b = c1511j.f2378s;
        if (c1561b != null) {
            c1561b.f2650d = interfaceC1492b;
        }
    }

    public void setImageAssetsFolder(String str) {
        this.f14526p.f2379t = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m7491a();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        m7491a();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        m7491a();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.f14526p.m693m(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        this.f14526p.m695o(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.f14526p.m697q(str);
    }

    public void setMinFrame(int i) {
        this.f14526p.m698r(i);
    }

    public void setMinProgress(float f) {
        this.f14526p.m700t(f);
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        C1511j c1511j = this.f14526p;
        c1511j.f2385z = z2;
        C1505d c1505d = c1511j.f2370k;
        if (c1505d != null) {
            c1505d.f2336a.f2458a = z2;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        this.f14526p.m701u(f);
    }

    public void setRenderMode(EnumC1521t enumC1521t) {
        this.f14535y = enumC1521t;
        m7492b();
    }

    public void setRepeatCount(int i) {
        this.f14526p.f2371l.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.f14526p.f2371l.setRepeatMode(i);
    }

    public void setSafeMode(boolean z2) {
        this.f14526p.f2374o = z2;
    }

    public void setScale(float f) {
        C1511j c1511j = this.f14526p;
        c1511j.f2372m = f;
        c1511j.m702v();
        if (getDrawable() == this.f14526p) {
            setImageDrawable(null);
            setImageDrawable(this.f14526p);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        C1511j c1511j = this.f14526p;
        if (c1511j != null) {
            c1511j.f2377r = scaleType;
        }
    }

    public void setSpeed(float f) {
        this.f14526p.f2371l.f2297l = f;
    }

    public void setTextDelegate(C1523v c1523v) {
        Objects.requireNonNull(this.f14526p);
    }

    public void setMaxFrame(String str) {
        this.f14526p.m694n(str);
    }

    public void setMinFrame(String str) {
        this.f14526p.m699s(str);
    }

    public void setAnimation(String str) {
        C1519r<C1505d> c1519rM674a;
        this.f14528r = str;
        this.f14529s = 0;
        if (this.f14534x) {
            Context context = getContext();
            Map<String, C1519r<C1505d>> map = C1506e.f2351a;
            String strM883w = C1643a.m883w("asset_", str);
            c1519rM674a = C1506e.m674a(strM883w, new CallableC1508g(context.getApplicationContext(), str, strM883w));
        } else {
            Context context2 = getContext();
            Map<String, C1519r<C1505d>> map2 = C1506e.f2351a;
            c1519rM674a = C1506e.m674a(null, new CallableC1508g(context2.getApplicationContext(), str, null));
        }
        setCompositionTask(c1519rM674a);
    }
}
