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
import d0.g0.c;
import d0.z.d.m;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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
    public RLottieDrawable$PlaybackMode w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2767x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f2768y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f2769z;
    public static final RLottieDrawable$Companion o = new RLottieDrawable$Companion(null);
    public static final Handler j = new Handler(Looper.getMainLooper());
    public static byte[] k = new byte[65536];
    public static final byte[] l = new byte[4096];
    public static final ExecutorService m = Executors.newCachedThreadPool();

    public RLottieDrawable(File file, int i, int i2, boolean z2, boolean z3, float f, int[] iArr, int i3) {
        m.checkParameterIsNotNull(file, "file");
        int[] iArr2 = new int[3];
        this.r = iArr2;
        this.u = new HashMap<>();
        this.v = new HashMap<>();
        this.w = RLottieDrawable$PlaybackMode.LOOP;
        this.K = 60.0f;
        this.L = 1.0f;
        this.M = 1.0f;
        this.O = new Rect();
        this.R = new ArrayList<>();
        this.S = new RLottieDrawable$a(6, this);
        this.T = new RLottieDrawable$a(2, this);
        this.U = new RLottieDrawable$a(1, this);
        this.V = new RLottieDrawable$a(4, this);
        this.W = new RLottieDrawable$a(3, this);
        this.X = new RLottieDrawable$a(0, this);
        this.p = i;
        this.q = i2;
        this.J = z3;
        this.K = f;
        Paint paint = getPaint();
        m.checkExpressionValueIsNotNull(paint, "paint");
        paint.setFlags(2);
        RLottieDrawable$Companion rLottieDrawable$Companion = o;
        String absolutePath = file.getAbsolutePath();
        m.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
        this.Q = rLottieDrawable$Companion.create(absolutePath, i, i2, iArr2, z2, null, this.J);
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
                m.throwNpe();
            }
            bitmap.recycle();
            rLottieDrawable.C = null;
        }
        if (rLottieDrawable.E != null) {
            Bitmap bitmap2 = rLottieDrawable.E;
            if (bitmap2 == null) {
                m.throwNpe();
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
        m.checkParameterIsNotNull(canvas, "canvas");
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
                    m.throwNpe();
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

    public final void f(RLottieDrawable$PlaybackMode rLottieDrawable$PlaybackMode) {
        m.checkParameterIsNotNull(rLottieDrawable$PlaybackMode, "value");
        if (this.w == RLottieDrawable$PlaybackMode.ONCE && rLottieDrawable$PlaybackMode == RLottieDrawable$PlaybackMode.FREEZE && this.I != 0) {
            return;
        }
        this.w = rLottieDrawable$PlaybackMode;
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
        m.checkParameterIsNotNull(rect, "bounds");
        super.onBoundsChange(rect);
        this.N = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.P) {
            return;
        }
        if (this.w.compareTo(RLottieDrawable$PlaybackMode.ONCE) < 0 || this.f2767x == 0) {
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
        m.checkParameterIsNotNull(context, "context");
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.r = new int[3];
        this.u = new HashMap<>();
        this.v = new HashMap<>();
        this.w = RLottieDrawable$PlaybackMode.LOOP;
        this.K = 60.0f;
        this.L = 1.0f;
        this.M = 1.0f;
        this.O = new Rect();
        this.R = new ArrayList<>();
        this.S = new RLottieDrawable$a(6, this);
        this.T = new RLottieDrawable$a(2, this);
        this.U = new RLottieDrawable$a(1, this);
        this.V = new RLottieDrawable$a(4, this);
        this.W = new RLottieDrawable$a(3, this);
        this.X = new RLottieDrawable$a(0, this);
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            m.checkExpressionValueIsNotNull(inputStreamOpenRawResource, "context.resources.openRawResource(rawRes)");
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
            String str2 = new String(k, 0, i4, c.a);
            inputStreamOpenRawResource.close();
            this.p = i2;
            this.q = i3;
            this.K = f;
            Paint paint = getPaint();
            m.checkExpressionValueIsNotNull(paint, "paint");
            paint.setFlags(2);
            this.Q = o.createWithJson(str2, str, this.r, iArr);
            this.f2766s = Math.max(16, (int) (1000.0f / this.r[1]));
            this.w = RLottieDrawable$PlaybackMode.LOOP;
            if (z2) {
                e(true);
            }
        } catch (Throwable th) {
            Log.e("RLottieDrawable", "Error Constructing", th);
        }
    }
}
