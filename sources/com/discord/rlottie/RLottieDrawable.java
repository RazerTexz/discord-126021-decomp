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
import p507d0.p579g0.C12086c;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RLottieDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
public class RLottieDrawable extends BitmapDrawable implements Animatable {

    /* JADX INFO: renamed from: n */
    public static ThreadPoolExecutor f18694n;

    /* JADX INFO: renamed from: A */
    public Runnable f18696A;

    /* JADX INFO: renamed from: B */
    public Runnable f18697B;

    /* JADX INFO: renamed from: C */
    public volatile Bitmap f18698C;

    /* JADX INFO: renamed from: D */
    public volatile Bitmap f18699D;

    /* JADX INFO: renamed from: E */
    public volatile Bitmap f18700E;

    /* JADX INFO: renamed from: F */
    public boolean f18701F;

    /* JADX INFO: renamed from: G */
    public boolean f18702G;

    /* JADX INFO: renamed from: H */
    public boolean f18703H;

    /* JADX INFO: renamed from: I */
    public int f18704I;

    /* JADX INFO: renamed from: J */
    public boolean f18705J;

    /* JADX INFO: renamed from: K */
    public float f18706K;

    /* JADX INFO: renamed from: L */
    public float f18707L;

    /* JADX INFO: renamed from: M */
    public float f18708M;

    /* JADX INFO: renamed from: N */
    public boolean f18709N;

    /* JADX INFO: renamed from: O */
    public final Rect f18710O;

    /* JADX INFO: renamed from: P */
    public volatile boolean f18711P;

    /* JADX INFO: renamed from: Q */
    public volatile long f18712Q;

    /* JADX INFO: renamed from: R */
    public final ArrayList<WeakReference<View>> f18713R;

    /* JADX INFO: renamed from: S */
    public final Runnable f18714S;

    /* JADX INFO: renamed from: T */
    public final Runnable f18715T;

    /* JADX INFO: renamed from: U */
    public final Runnable f18716U;

    /* JADX INFO: renamed from: V */
    public final Runnable f18717V;

    /* JADX INFO: renamed from: W */
    public final Runnable f18718W;

    /* JADX INFO: renamed from: X */
    public final Runnable f18719X;

    /* JADX INFO: renamed from: p */
    public int f18720p;

    /* JADX INFO: renamed from: q */
    public int f18721q;

    /* JADX INFO: renamed from: r */
    public final int[] f18722r;

    /* JADX INFO: renamed from: s */
    public int f18723s;

    /* JADX INFO: renamed from: t */
    public Integer[] f18724t;

    /* JADX INFO: renamed from: u */
    public final HashMap<String, Integer> f18725u;

    /* JADX INFO: renamed from: v */
    public volatile HashMap<String, Integer> f18726v;

    /* JADX INFO: renamed from: w */
    public PlaybackMode f18727w;

    /* JADX INFO: renamed from: x */
    public int f18728x;

    /* JADX INFO: renamed from: y */
    public long f18729y;

    /* JADX INFO: renamed from: z */
    public volatile boolean f18730z;

    /* JADX INFO: renamed from: o */
    public static final Companion f18695o = new Companion(null);

    /* JADX INFO: renamed from: j */
    public static final Handler f18690j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k */
    public static byte[] f18691k = new byte[65536];

    /* JADX INFO: renamed from: l */
    public static final byte[] f18692l = new byte[4096];

    /* JADX INFO: renamed from: m */
    public static final ExecutorService f18693m = Executors.newCachedThreadPool();

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

    /* JADX INFO: renamed from: com.discord.rlottie.RLottieDrawable$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class RunnableC5598a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f18731j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f18732k;

        public RunnableC5598a(int i, Object obj) {
            this.f18731j = i;
            this.f18732k = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ThreadPoolExecutor threadPoolExecutor;
            switch (this.f18731j) {
                case 0:
                    Objects.requireNonNull((RLottieDrawable) this.f18732k);
                    if (((RLottieDrawable) this.f18732k).f18712Q == 0) {
                        RLottieDrawable.f18690j.post(((RLottieDrawable) this.f18732k).f18714S);
                        return;
                    }
                    if (((RLottieDrawable) this.f18732k).f18700E == null) {
                        try {
                            RLottieDrawable rLottieDrawable = (RLottieDrawable) this.f18732k;
                            rLottieDrawable.f18700E = Bitmap.createBitmap(rLottieDrawable.f18720p, rLottieDrawable.f18721q, Bitmap.Config.ARGB_8888);
                        } catch (Throwable th) {
                            Log.e("RLottieDrawable", "Error Loading Frame in Runnable", th);
                        }
                        break;
                    }
                    if (((RLottieDrawable) this.f18732k).f18700E != null) {
                        try {
                            if (!((RLottieDrawable) this.f18732k).f18726v.isEmpty()) {
                                for (Map.Entry<String, Integer> entry : ((RLottieDrawable) this.f18732k).f18726v.entrySet()) {
                                    RLottieDrawable.f18695o.setLayerColor(((RLottieDrawable) this.f18732k).f18712Q, entry.getKey(), entry.getValue().intValue());
                                }
                                ((RLottieDrawable) this.f18732k).f18726v.clear();
                            }
                            break;
                        } catch (Exception unused) {
                        }
                        RLottieDrawable rLottieDrawable2 = (RLottieDrawable) this.f18732k;
                        Integer[] numArr = rLottieDrawable2.f18724t;
                        if (numArr != null) {
                            RLottieDrawable.f18695o.replaceColors(rLottieDrawable2.f18712Q, C12141k.toIntArray(numArr));
                        }
                        RLottieDrawable rLottieDrawable3 = (RLottieDrawable) this.f18732k;
                        rLottieDrawable3.f18724t = null;
                        try {
                            Companion companion = RLottieDrawable.f18695o;
                            long j = rLottieDrawable3.f18712Q;
                            RLottieDrawable rLottieDrawable4 = (RLottieDrawable) this.f18732k;
                            int i = rLottieDrawable4.f18704I;
                            Bitmap bitmap = rLottieDrawable4.f18700E;
                            if (bitmap == null) {
                                C12238m.throwNpe();
                            }
                            RLottieDrawable rLottieDrawable5 = (RLottieDrawable) this.f18732k;
                            int i2 = rLottieDrawable5.f18720p;
                            int i3 = rLottieDrawable5.f18721q;
                            Bitmap bitmap2 = rLottieDrawable5.f18700E;
                            if (bitmap2 == null) {
                                C12238m.throwNpe();
                            }
                            if (companion.getFrame(j, i, bitmap, i2, i3, bitmap2.getRowBytes(), true) == -1) {
                                RLottieDrawable.f18690j.post(((RLottieDrawable) this.f18732k).f18714S);
                                return;
                            }
                            RLottieDrawable rLottieDrawable6 = (RLottieDrawable) this.f18732k;
                            int i4 = 2;
                            if (rLottieDrawable6.f18722r[2] != 0) {
                                RLottieDrawable.f18690j.post(rLottieDrawable6.f18718W);
                                ((RLottieDrawable) this.f18732k).f18722r[2] = 0;
                            }
                            RLottieDrawable rLottieDrawable7 = (RLottieDrawable) this.f18732k;
                            rLottieDrawable7.f18699D = rLottieDrawable7.f18700E;
                            RLottieDrawable rLottieDrawable8 = (RLottieDrawable) this.f18732k;
                            if (!rLottieDrawable8.f18705J) {
                                i4 = 1;
                            }
                            int i5 = rLottieDrawable8.f18704I + i4;
                            if (i5 >= rLottieDrawable8.f18722r[0]) {
                                PlaybackMode playbackMode = rLottieDrawable8.f18727w;
                                if (playbackMode == PlaybackMode.LOOP) {
                                    rLottieDrawable8.f18704I = 0;
                                    rLottieDrawable8.f18730z = false;
                                } else if (playbackMode == PlaybackMode.ONCE) {
                                    rLottieDrawable8.f18704I = 0;
                                    rLottieDrawable8.f18730z = true;
                                    ((RLottieDrawable) this.f18732k).f18728x++;
                                } else {
                                    rLottieDrawable8.f18730z = true;
                                }
                            } else if (rLottieDrawable8.f18727w == PlaybackMode.FREEZE) {
                                rLottieDrawable8.f18730z = true;
                                ((RLottieDrawable) this.f18732k).f18728x++;
                            } else {
                                rLottieDrawable8.f18704I = i5;
                                rLottieDrawable8.f18730z = false;
                            }
                        } catch (Exception e) {
                            Log.e("RLottieDrawable", "Error loading frame", e);
                        }
                    }
                    RLottieDrawable.f18690j.post(((RLottieDrawable) this.f18732k).f18716U);
                    return;
                case 1:
                    RLottieDrawable rLottieDrawable9 = (RLottieDrawable) this.f18732k;
                    rLottieDrawable9.f18702G = true;
                    rLottieDrawable9.m8444c();
                    RLottieDrawable.m8442a((RLottieDrawable) this.f18732k);
                    return;
                case 2:
                    RLottieDrawable rLottieDrawable10 = (RLottieDrawable) this.f18732k;
                    rLottieDrawable10.f18696A = null;
                    RLottieDrawable.m8442a(rLottieDrawable10);
                    return;
                case 3:
                    Objects.requireNonNull((RLottieDrawable) this.f18732k);
                    Objects.requireNonNull((RLottieDrawable) this.f18732k);
                    if (((RLottieDrawable) this.f18732k).f18712Q != 0 && (threadPoolExecutor = RLottieDrawable.f18694n) != null) {
                        RLottieDrawable rLottieDrawable11 = (RLottieDrawable) this.f18732k;
                        Runnable runnable = rLottieDrawable11.f18717V;
                        rLottieDrawable11.f18696A = runnable;
                        threadPoolExecutor.execute(runnable);
                    }
                    RLottieDrawable.m8442a((RLottieDrawable) this.f18732k);
                    return;
                case 4:
                    RLottieDrawable rLottieDrawable12 = (RLottieDrawable) this.f18732k;
                    if (rLottieDrawable12.f18696A != null) {
                        Companion companion2 = RLottieDrawable.f18695o;
                        long j2 = rLottieDrawable12.f18712Q;
                        RLottieDrawable rLottieDrawable13 = (RLottieDrawable) this.f18732k;
                        companion2.createCache(j2, rLottieDrawable13.f18720p, rLottieDrawable13.f18721q);
                        RLottieDrawable.f18690j.post(((RLottieDrawable) this.f18732k).f18715T);
                        return;
                    }
                    return;
                case 5:
                    throw null;
                case 6:
                    RLottieDrawable rLottieDrawable14 = (RLottieDrawable) this.f18732k;
                    rLottieDrawable14.f18697B = null;
                    RLottieDrawable.m8442a(rLottieDrawable14);
                    return;
                default:
                    throw null;
            }
        }
    }

    public RLottieDrawable(File file, int i, int i2, boolean z2, boolean z3, float f, int[] iArr, int i3) {
        C12238m.checkParameterIsNotNull(file, "file");
        int[] iArr2 = new int[3];
        this.f18722r = iArr2;
        this.f18725u = new HashMap<>();
        this.f18726v = new HashMap<>();
        this.f18727w = PlaybackMode.LOOP;
        this.f18706K = 60.0f;
        this.f18707L = 1.0f;
        this.f18708M = 1.0f;
        this.f18710O = new Rect();
        this.f18713R = new ArrayList<>();
        this.f18714S = new RunnableC5598a(6, this);
        this.f18715T = new RunnableC5598a(2, this);
        this.f18716U = new RunnableC5598a(1, this);
        this.f18717V = new RunnableC5598a(4, this);
        this.f18718W = new RunnableC5598a(3, this);
        this.f18719X = new RunnableC5598a(0, this);
        this.f18720p = i;
        this.f18721q = i2;
        this.f18705J = z3;
        this.f18706K = f;
        Paint paint = getPaint();
        C12238m.checkExpressionValueIsNotNull(paint, "paint");
        paint.setFlags(2);
        Companion companion = f18695o;
        String absolutePath = file.getAbsolutePath();
        C12238m.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
        this.f18712Q = companion.create(absolutePath, i, i2, iArr2, z2, null, this.f18705J);
        if (z2 && f18694n == null) {
            f18694n = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
        if (this.f18712Q == 0) {
            file.delete();
        }
        if (this.f18705J && iArr2[1] < 60) {
            this.f18705J = false;
        }
        this.f18723s = Math.max(this.f18705J ? 33 : 16, (int) (1000.0f / iArr2[1]));
    }

    /* JADX INFO: renamed from: a */
    public static final void m8442a(RLottieDrawable rLottieDrawable) {
        if (rLottieDrawable.f18712Q != 0) {
            if (!rLottieDrawable.m8443b()) {
                rLottieDrawable.f18711P = false;
            }
            rLottieDrawable.m8445d();
            return;
        }
        if (rLottieDrawable.f18698C != null) {
            Bitmap bitmap = rLottieDrawable.f18698C;
            if (bitmap == null) {
                C12238m.throwNpe();
            }
            bitmap.recycle();
            rLottieDrawable.f18698C = null;
        }
        if (rLottieDrawable.f18700E != null) {
            Bitmap bitmap2 = rLottieDrawable.f18700E;
            if (bitmap2 == null) {
                C12238m.throwNpe();
            }
            bitmap2.recycle();
            rLottieDrawable.f18700E = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8443b() {
        if (getCallback() != null) {
            return true;
        }
        for (int size = this.f18713R.size(); size > 0; size--) {
            if (this.f18713R.get(0).get() != null) {
                return true;
            }
            this.f18713R.remove(0);
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public final void m8444c() {
        int size = this.f18713R.size();
        int i = 0;
        while (i < size) {
            View view = this.f18713R.get(i).get();
            if (view != null) {
                view.invalidate();
            } else {
                this.f18713R.remove(i);
                size--;
                i--;
            }
            i++;
        }
        if (getCallback() != null) {
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m8445d() {
        if (this.f18697B != null || this.f18699D != null || this.f18712Q == 0) {
            return false;
        }
        if (!this.f18711P) {
            boolean z2 = this.f18701F;
            if (!z2) {
                return false;
            }
            if (z2 && this.f18702G) {
                return false;
            }
        }
        if (!this.f18725u.isEmpty()) {
            this.f18726v.putAll(this.f18725u);
            this.f18725u.clear();
        }
        ExecutorService executorService = f18693m;
        Runnable runnable = this.f18719X;
        this.f18697B = runnable;
        executorService.execute(runnable);
        return true;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        C12238m.checkParameterIsNotNull(canvas, "canvas");
        if (this.f18712Q != 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - this.f18729y);
            float f = 60;
            int i = this.f18706K <= f ? this.f18723s - 6 : this.f18723s;
            if (this.f18711P) {
                if (this.f18698C == null && this.f18699D == null) {
                    m8445d();
                } else if (this.f18699D != null && (this.f18698C == null || jAbs >= i)) {
                    if (getCallback() == null) {
                        int size = this.f18713R.size();
                        while (true) {
                            if (size > 0) {
                                if (this.f18713R.get(0).get() != null) {
                                    if (this.f18713R.get(0).get() != null) {
                                        z2 = false;
                                        break;
                                    }
                                    break;
                                }
                                this.f18713R.remove(0);
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
                        this.f18700E = this.f18698C;
                        this.f18698C = this.f18699D;
                        if (this.f18730z) {
                            this.f18711P = false;
                        }
                        this.f18697B = null;
                        this.f18702G = true;
                        this.f18699D = null;
                        if (this.f18706K > f) {
                            jElapsedRealtime -= Math.min(16L, jAbs - ((long) i));
                        }
                        this.f18729y = jElapsedRealtime;
                        m8445d();
                    }
                }
            } else if ((this.f18703H || (this.f18701F && jAbs >= i)) && this.f18699D != null) {
                this.f18700E = this.f18698C;
                this.f18698C = this.f18699D;
                this.f18697B = null;
                this.f18702G = true;
                this.f18699D = null;
                if (this.f18706K > f) {
                    jElapsedRealtime -= Math.min(16L, jAbs - ((long) i));
                }
                this.f18729y = jElapsedRealtime;
                if (this.f18703H) {
                    this.f18702G = false;
                    this.f18703H = false;
                }
                m8445d();
            }
            if (this.f18698C != null) {
                if (this.f18709N) {
                    this.f18710O.set(getBounds());
                    this.f18707L = this.f18710O.width() / this.f18720p;
                    this.f18708M = this.f18710O.height() / this.f18721q;
                    this.f18709N = false;
                }
                canvas.save();
                Rect rect = this.f18710O;
                canvas.translate(rect.left, rect.top);
                canvas.scale(this.f18707L, this.f18708M);
                Bitmap bitmap = this.f18698C;
                if (bitmap == null) {
                    C12238m.throwNpe();
                }
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, getPaint());
                if (this.f18711P) {
                    m8444c();
                }
                canvas.restore();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m8446e(boolean z2) {
        this.f18701F = z2;
        if (z2) {
            m8445d();
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m8447f(PlaybackMode playbackMode) {
        C12238m.checkParameterIsNotNull(playbackMode, "value");
        if (this.f18727w == PlaybackMode.ONCE && playbackMode == PlaybackMode.FREEZE && this.f18704I != 0) {
            return;
        }
        this.f18727w = playbackMode;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18721q;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18720p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f18721q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f18720p;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f18711P;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        C12238m.checkParameterIsNotNull(rect, "bounds");
        super.onBoundsChange(rect);
        this.f18709N = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f18711P) {
            return;
        }
        if (this.f18727w.compareTo(PlaybackMode.ONCE) < 0 || this.f18728x == 0) {
            this.f18711P = true;
            m8445d();
            m8444c();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f18711P = false;
    }

    public RLottieDrawable(Context context, @RawRes int i, String str, int i2, int i3, float f, boolean z2, int[] iArr) {
        C12238m.checkParameterIsNotNull(context, "context");
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f18722r = new int[3];
        this.f18725u = new HashMap<>();
        this.f18726v = new HashMap<>();
        this.f18727w = PlaybackMode.LOOP;
        this.f18706K = 60.0f;
        this.f18707L = 1.0f;
        this.f18708M = 1.0f;
        this.f18710O = new Rect();
        this.f18713R = new ArrayList<>();
        this.f18714S = new RunnableC5598a(6, this);
        this.f18715T = new RunnableC5598a(2, this);
        this.f18716U = new RunnableC5598a(1, this);
        this.f18717V = new RunnableC5598a(4, this);
        this.f18718W = new RunnableC5598a(3, this);
        this.f18719X = new RunnableC5598a(0, this);
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            C12238m.checkExpressionValueIsNotNull(inputStreamOpenRawResource, "context.resources.openRawResource(rawRes)");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            int i4 = 0;
            while (true) {
                byte[] bArr = f18692l;
                int i5 = inputStreamOpenRawResource.read(bArr, 0, bArr.length);
                ref$IntRef.element = i5;
                if (i5 <= 0) {
                    break;
                }
                byte[] bArr2 = f18691k;
                if (bArr2.length < i5 + i4) {
                    byte[] bArr3 = new byte[bArr2.length * 2];
                    System.arraycopy(bArr2, 0, bArr3, 0, i4);
                    f18691k = bArr3;
                }
                System.arraycopy(bArr, 0, f18691k, i4, ref$IntRef.element);
                i4 += ref$IntRef.element;
            }
            String str2 = new String(f18691k, 0, i4, C12086c.f25136a);
            inputStreamOpenRawResource.close();
            this.f18720p = i2;
            this.f18721q = i3;
            this.f18706K = f;
            Paint paint = getPaint();
            C12238m.checkExpressionValueIsNotNull(paint, "paint");
            paint.setFlags(2);
            this.f18712Q = f18695o.createWithJson(str2, str, this.f18722r, iArr);
            this.f18723s = Math.max(16, (int) (1000.0f / this.f18722r[1]));
            this.f18727w = PlaybackMode.LOOP;
            if (z2) {
                m8446e(true);
            }
        } catch (Throwable th) {
            Log.e("RLottieDrawable", "Error Constructing", th);
        }
    }
}
