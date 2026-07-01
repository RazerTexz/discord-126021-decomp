package com.discord.rlottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.annotation.RawRes;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.Charsets2;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: RLottieDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
public class RLottieDrawable extends BitmapDrawable implements Animatable {
    public static ThreadPoolExecutor n;
    public Runnable A;
    public Runnable B;
    public volatile Bitmap C;
    public volatile Bitmap D;
    public volatile Bitmap E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    public float K;
    public float L;
    public float M;
    public boolean N;
    public final Rect O;
    public volatile boolean P;
    public volatile long Q;
    public final ArrayList<WeakReference<View>> R;
    public final Runnable S;
    public final Runnable T;
    public final Runnable U;
    public final Runnable V;
    public final Runnable W;
    public final Runnable X;
    public int p;
    public int q;
    public final int[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2766s;
    public Integer[] t;
    public final HashMap<String, Integer> u;
    public volatile HashMap<String, Integer> v;
    public PlaybackMode w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2767x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f2768y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f2769z;
    public static final Companion o = new Companion(null);
    public static final Handler j = new Handler(Looper.getMainLooper());
    public static byte[] k = new byte[65536];
    public static final byte[] l = new byte[4096];
    public static final ExecutorService m = Executors.newCachedThreadPool();

    /* JADX INFO: compiled from: RLottieDrawable.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final native long create(String str, int i, int i2, int[] iArr, boolean z2, int[] iArr2, boolean z3);

        public final native void createCache(long j, int i, int i2);

        public final native long createWithJson(String str, String str2, int[] iArr, int[] iArr2);

        public final native int getFrame(long j, int i, Bitmap bitmap, int i2, int i3, int i4, boolean z2);

        public final native void replaceColors(long j, int[] iArr);

        public final native void setLayerColor(long j, String str, int i);
    }

    /* JADX INFO: compiled from: RLottieDrawable.kt */
    public enum PlaybackMode {
        LOOP,
        ONCE,
        FREEZE
    }

    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements Runnable {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ThreadPoolExecutor threadPoolExecutor;
            switch (this.j) {
                case 0:
                    Objects.requireNonNull((RLottieDrawable) this.k);
                    if (((RLottieDrawable) this.k).Q == 0) {
                        RLottieDrawable.j.post(((RLottieDrawable) this.k).S);
                        return;
                    }
                    if (((RLottieDrawable) this.k).E == null) {
                        try {
                            RLottieDrawable rLottieDrawable = (RLottieDrawable) this.k;
                            rLottieDrawable.E = Bitmap.createBitmap(rLottieDrawable.p, rLottieDrawable.q, Bitmap.Config.ARGB_8888);
                        } catch (Throwable th) {
                            Log.e("RLottieDrawable", "Error Loading Frame in Runnable", th);
                        }
                        break;
                    }
                    if (((RLottieDrawable) this.k).E != null) {
                        try {
                            if (!((RLottieDrawable) this.k).v.isEmpty()) {
                                for (Map.Entry<String, Integer> entry : ((RLottieDrawable) this.k).v.entrySet()) {
                                    RLottieDrawable.o.setLayerColor(((RLottieDrawable) this.k).Q, entry.getKey(), entry.getValue().intValue());
                                }
                                ((RLottieDrawable) this.k).v.clear();
                            }
                            break;
                        } catch (Exception unused) {
                        }
                        RLottieDrawable rLottieDrawable2 = (RLottieDrawable) this.k;
                        Integer[] numArr = rLottieDrawable2.t;
                        if (numArr != null) {
                            RLottieDrawable.o.replaceColors(rLottieDrawable2.Q, _Arrays.toIntArray(numArr));
                        }
                        RLottieDrawable rLottieDrawable3 = (RLottieDrawable) this.k;
                        rLottieDrawable3.t = null;
                        try {
                            Companion companion = RLottieDrawable.o;
                            long j = rLottieDrawable3.Q;
                            RLottieDrawable rLottieDrawable4 = (RLottieDrawable) this.k;
                            int i = rLottieDrawable4.I;
                            Bitmap bitmap = rLottieDrawable4.E;
                            if (bitmap == null) {
                                Intrinsics3.throwNpe();
                            }
                            RLottieDrawable rLottieDrawable5 = (RLottieDrawable) this.k;
                            int i2 = rLottieDrawable5.p;
                            int i3 = rLottieDrawable5.q;
                            Bitmap bitmap2 = rLottieDrawable5.E;
                            if (bitmap2 == null) {
                                Intrinsics3.throwNpe();
                            }
                            if (companion.getFrame(j, i, bitmap, i2, i3, bitmap2.getRowBytes(), true) == -1) {
                                RLottieDrawable.j.post(((RLottieDrawable) this.k).S);
                                return;
                            }
                            RLottieDrawable rLottieDrawable6 = (RLottieDrawable) this.k;
                            int i4 = 2;
                            if (rLottieDrawable6.r[2] != 0) {
                                RLottieDrawable.j.post(rLottieDrawable6.W);
                                ((RLottieDrawable) this.k).r[2] = 0;
                            }
                            RLottieDrawable rLottieDrawable7 = (RLottieDrawable) this.k;
                            rLottieDrawable7.D = rLottieDrawable7.E;
                            RLottieDrawable rLottieDrawable8 = (RLottieDrawable) this.k;
                            if (!rLottieDrawable8.J) {
                                i4 = 1;
                            }
                            int i5 = rLottieDrawable8.I + i4;
                            if (i5 >= rLottieDrawable8.r[0]) {
                                PlaybackMode playbackMode = rLottieDrawable8.w;
                                if (playbackMode == PlaybackMode.LOOP) {
                                    rLottieDrawable8.I = 0;
                                    rLottieDrawable8.f2769z = false;
                                } else if (playbackMode == PlaybackMode.ONCE) {
                                    rLottieDrawable8.I = 0;
                                    rLottieDrawable8.f2769z = true;
                                    ((RLottieDrawable) this.k).f2767x++;
                                } else {
                                    rLottieDrawable8.f2769z = true;
                                }
                            } else if (rLottieDrawable8.w == PlaybackMode.FREEZE) {
                                rLottieDrawable8.f2769z = true;
                                ((RLottieDrawable) this.k).f2767x++;
                            } else {
                                rLottieDrawable8.I = i5;
                                rLottieDrawable8.f2769z = false;
                            }
                        } catch (Exception e) {
                            Log.e("RLottieDrawable", "Error loading frame", e);
                        }
                    }
                    RLottieDrawable.j.post(((RLottieDrawable) this.k).U);
                    return;
                case 1:
                    RLottieDrawable rLottieDrawable9 = (RLottieDrawable) this.k;
                    rLottieDrawable9.G = true;
                    rLottieDrawable9.c();
                    RLottieDrawable.a((RLottieDrawable) this.k);
                    return;
                case 2:
                    RLottieDrawable rLottieDrawable10 = (RLottieDrawable) this.k;
                    rLottieDrawable10.A = null;
                    RLottieDrawable.a(rLottieDrawable10);
                    return;
                case 3:
                    Objects.requireNonNull((RLottieDrawable) this.k);
                    Objects.requireNonNull((RLottieDrawable) this.k);
                    if (((RLottieDrawable) this.k).Q != 0 && (threadPoolExecutor = RLottieDrawable.n) != null) {
                        RLottieDrawable rLottieDrawable11 = (RLottieDrawable) this.k;
                        Runnable runnable = rLottieDrawable11.V;
                        rLottieDrawable11.A = runnable;
                        threadPoolExecutor.execute(runnable);
                    }
                    RLottieDrawable.a((RLottieDrawable) this.k);
                    return;
                case 4:
                    RLottieDrawable rLottieDrawable12 = (RLottieDrawable) this.k;
                    if (rLottieDrawable12.A != null) {
                        Companion companion2 = RLottieDrawable.o;
                        long j2 = rLottieDrawable12.Q;
                        RLottieDrawable rLottieDrawable13 = (RLottieDrawable) this.k;
                        companion2.createCache(j2, rLottieDrawable13.p, rLottieDrawable13.q);
                        RLottieDrawable.j.post(((RLottieDrawable) this.k).T);
                        return;
                    }
                    return;
                case 5:
                    throw null;
                case 6:
                    RLottieDrawable rLottieDrawable14 = (RLottieDrawable) this.k;
                    rLottieDrawable14.B = null;
                    RLottieDrawable.a(rLottieDrawable14);
                    return;
                default:
                    throw null;
            }
        }
    }

    public RLottieDrawable(File file, int i, int i2, boolean z2, boolean z3, float f, int[] iArr, int i3) {
        Intrinsics3.checkParameterIsNotNull(file, "file");
        int[] iArr2 = new int[3];
        this.r = iArr2;
        this.u = new HashMap<>();
        this.v = new HashMap<>();
        this.w = PlaybackMode.LOOP;
        this.K = 60.0f;
        this.L = 1.0f;
        this.M = 1.0f;
        this.O = new Rect();
        this.R = new ArrayList<>();
        this.S = new a(6, this);
        this.T = new a(2, this);
        this.U = new a(1, this);
        this.V = new a(4, this);
        this.W = new a(3, this);
        this.X = new a(0, this);
        this.p = i;
        this.q = i2;
        this.J = z3;
        this.K = f;
        Paint paint = getPaint();
        Intrinsics3.checkExpressionValueIsNotNull(paint, "paint");
        paint.setFlags(2);
        Companion companion = o;
        String absolutePath = file.getAbsolutePath();
        Intrinsics3.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
        this.Q = companion.create(absolutePath, i, i2, iArr2, z2, null, this.J);
        if (z2 && n == null) {
            n = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
        if (this.Q == 0) {
            file.delete();
        }
        if (this.J && iArr2[1] < 60) {
            this.J = false;
        }
        this.f2766s = Math.max(this.J ? 33 : 16, (int) (1000.0f / iArr2[1]));
    }

    public static final void a(RLottieDrawable rLottieDrawable) {
        if (rLottieDrawable.Q != 0) {
            if (!rLottieDrawable.b()) {
                rLottieDrawable.P = false;
            }
            rLottieDrawable.d();
            return;
        }
        if (rLottieDrawable.C != null) {
            Bitmap bitmap = rLottieDrawable.C;
            if (bitmap == null) {
                Intrinsics3.throwNpe();
            }
            bitmap.recycle();
            rLottieDrawable.C = null;
        }
        if (rLottieDrawable.E != null) {
            Bitmap bitmap2 = rLottieDrawable.E;
            if (bitmap2 == null) {
                Intrinsics3.throwNpe();
            }
            bitmap2.recycle();
            rLottieDrawable.E = null;
        }
    }

    public final boolean b() {
        if (getCallback() != null) {
            return true;
        }
        for (int size = this.R.size(); size > 0; size--) {
            if (this.R.get(0).get() != null) {
                return true;
            }
            this.R.remove(0);
        }
        return false;
    }

    public final void c() {
        int size = this.R.size();
        int i = 0;
        while (i < size) {
            View view = this.R.get(i).get();
            if (view != null) {
                view.invalidate();
            } else {
                this.R.remove(i);
                size--;
                i--;
            }
            i++;
        }
        if (getCallback() != null) {
            invalidateSelf();
        }
    }

    public final boolean d() {
        if (this.B != null || this.D != null || this.Q == 0) {
            return false;
        }
        if (!this.P) {
            boolean z2 = this.F;
            if (!z2) {
                return false;
            }
            if (z2 && this.G) {
                return false;
            }
        }
        if (!this.u.isEmpty()) {
            this.v.putAll(this.u);
            this.u.clear();
        }
        ExecutorService executorService = m;
        Runnable runnable = this.X;
        this.B = runnable;
        executorService.execute(runnable);
        return true;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        Intrinsics3.checkParameterIsNotNull(canvas, "canvas");
        if (this.Q != 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - this.f2768y);
            float f = 60;
            int i = this.K <= f ? this.f2766s - 6 : this.f2766s;
            if (this.P) {
                if (this.C == null && this.D == null) {
                    d();
                } else if (this.D != null && (this.C == null || jAbs >= i)) {
                    if (getCallback() == null) {
                        int size = this.R.size();
                        while (true) {
                            if (size > 0) {
                                if (this.R.get(0).get() != null) {
                                    if (this.R.get(0).get() != null) {
                                        z2 = false;
                                        break;
                                    }
                                    break;
                                }
                                this.R.remove(0);
                                size--;
                            }
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                    if (z2) {
                        this.E = this.C;
                        this.C = this.D;
                        if (this.f2769z) {
                            this.P = false;
                        }
                        this.B = null;
                        this.G = true;
                        this.D = null;
                        if (this.K > f) {
                            jElapsedRealtime -= Math.min(16L, jAbs - ((long) i));
                        }
                        this.f2768y = jElapsedRealtime;
                        d();
                    }
                }
            } else if ((this.H || (this.F && jAbs >= i)) && this.D != null) {
                this.E = this.C;
                this.C = this.D;
                this.B = null;
                this.G = true;
                this.D = null;
                if (this.K > f) {
                    jElapsedRealtime -= Math.min(16L, jAbs - ((long) i));
                }
                this.f2768y = jElapsedRealtime;
                if (this.H) {
                    this.G = false;
                    this.H = false;
                }
                d();
            }
            if (this.C != null) {
                if (this.N) {
                    this.O.set(getBounds());
                    this.L = this.O.width() / this.p;
                    this.M = this.O.height() / this.q;
                    this.N = false;
                }
                canvas.save();
                Rect rect = this.O;
                canvas.translate(rect.left, rect.top);
                canvas.scale(this.L, this.M);
                Bitmap bitmap = this.C;
                if (bitmap == null) {
                    Intrinsics3.throwNpe();
                }
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, getPaint());
                if (this.P) {
                    c();
                }
                canvas.restore();
            }
        }
    }

    public final void e(boolean z2) {
        this.F = z2;
        if (z2) {
            d();
        }
    }

    public final void f(PlaybackMode playbackMode) {
        Intrinsics3.checkParameterIsNotNull(playbackMode, "value");
        if (this.w == PlaybackMode.ONCE && playbackMode == PlaybackMode.FREEZE && this.I != 0) {
            return;
        }
        this.w = playbackMode;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.q;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.p;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.P;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Intrinsics3.checkParameterIsNotNull(rect, "bounds");
        super.onBoundsChange(rect);
        this.N = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.P) {
            return;
        }
        if (this.w.compareTo(PlaybackMode.ONCE) < 0 || this.f2767x == 0) {
            this.P = true;
            d();
            c();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.P = false;
    }

    public RLottieDrawable(Context context, @RawRes int i, String str, int i2, int i3, float f, boolean z2, int[] iArr) {
        Intrinsics3.checkParameterIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.r = new int[3];
        this.u = new HashMap<>();
        this.v = new HashMap<>();
        this.w = PlaybackMode.LOOP;
        this.K = 60.0f;
        this.L = 1.0f;
        this.M = 1.0f;
        this.O = new Rect();
        this.R = new ArrayList<>();
        this.S = new a(6, this);
        this.T = new a(2, this);
        this.U = new a(1, this);
        this.V = new a(4, this);
        this.W = new a(3, this);
        this.X = new a(0, this);
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            Intrinsics3.checkExpressionValueIsNotNull(inputStreamOpenRawResource, "context.resources.openRawResource(rawRes)");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            int i4 = 0;
            while (true) {
                byte[] bArr = l;
                int i5 = inputStreamOpenRawResource.read(bArr, 0, bArr.length);
                ref$IntRef.element = i5;
                if (i5 <= 0) {
                    break;
                }
                byte[] bArr2 = k;
                if (bArr2.length < i5 + i4) {
                    byte[] bArr3 = new byte[bArr2.length * 2];
                    System.arraycopy(bArr2, 0, bArr3, 0, i4);
                    k = bArr3;
                }
                System.arraycopy(bArr, 0, k, i4, ref$IntRef.element);
                i4 += ref$IntRef.element;
            }
            String str2 = new String(k, 0, i4, Charsets2.a);
            inputStreamOpenRawResource.close();
            this.p = i2;
            this.q = i3;
            this.K = f;
            Paint paint = getPaint();
            Intrinsics3.checkExpressionValueIsNotNull(paint, "paint");
            paint.setFlags(2);
            this.Q = o.createWithJson(str2, str, this.r, iArr);
            this.f2766s = Math.max(16, (int) (1000.0f / this.r[1]));
            this.w = PlaybackMode.LOOP;
            if (z2) {
                e(true);
            }
        } catch (Throwable th) {
            Log.e("RLottieDrawable", "Error Constructing", th);
        }
    }
}
