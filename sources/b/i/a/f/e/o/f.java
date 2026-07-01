package b.i.a.f.e.o;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera$Parameters;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Binder;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.WorkerThread;
import androidx.media.AudioAttributesCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.h.l.a3;
import b.i.a.f.h.l.b5;
import b.i.a.f.h.l.b7;
import b.i.a.f.h.l.c3;
import b.i.a.f.h.l.c6;
import b.i.a.f.h.l.c7;
import b.i.a.f.h.l.d2;
import b.i.a.f.h.l.e6;
import b.i.a.f.h.l.k7;
import b.i.a.f.h.l.q6;
import b.i.a.f.h.l.s3;
import b.i.a.f.h.l.t3;
import b.i.a.f.h.l.u4;
import b.i.a.f.h.l.u4$d;
import b.i.a.f.h.l.w4;
import b.i.a.f.h.l.x4;
import b.i.a.f.h.l.z2;
import b.i.a.f.h.l.z3;
import b.i.a.f.i.b.ga;
import b.i.a.f.i.b.q3;
import b.i.a.f.n.c0;
import b.i.a.f.n.d0;
import b.i.a.f.n.j;
import b.i.b.b.h$a;
import b.i.b.b.n0;
import b.i.c.l.o;
import b.i.c.m.d.k.s0;
import b.i.c.m.d.k.t0;
import b.o.a.x.k;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.android.gms.common.R$a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.appindexing.FirebaseAppIndexingException;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException;
import com.google.firebase.appindexing.zza;
import com.google.firebase.appindexing.zzb;
import com.google.firebase.appindexing.zzc;
import com.google.firebase.appindexing.zzd;
import com.google.firebase.appindexing.zze;
import com.google.firebase.appindexing.zzf;
import com.google.firebase.appindexing.zzg;
import com.google.firebase.appindexing.zzh;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.g0.t;
import d0.k$a;
import d0.w.d$b;
import d0.z.d.e0;
import d0.z.d.m;
import g0.n;
import g0.p;
import g0.u;
import g0.v;
import g0.x;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor$DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler$a;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.objectweb.asm.Opcodes;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.OnErrorThrowable;
import s.a.a.r;
import s.a.b0;
import s.a.c2.q;
import s.a.c2.s;
import s.a.d$a;
import s.a.f0;
import s.a.f1;
import s.a.g0;
import s.a.h0;
import s.a.i0;
import s.a.i1;
import s.a.j0;
import s.a.j1;
import s.a.k0;
import s.a.k1;
import s.a.l;
import s.a.m0;
import s.a.t1;
import s.a.u1;
import s.a.w;
import s.a.z;
import s.a.z1;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static Boolean f1397b;
    public static ga c;

    @CanIgnoreReturnValue
    public static int A(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static boolean A0() {
        return Build$VERSION.SDK_INT >= 26;
    }

    public static boolean A1(long j) {
        if (j >= 0) {
            return j != 0;
        }
        throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 required but it was ", j));
    }

    public static final void B(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final boolean B0(int i) {
        return i == 1 || i == 2;
    }

    @NonNull
    public static Task<Void> B1(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return Z(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next(), "null tasks are not accepted");
        }
        c0 c0Var = new c0();
        j jVar = new j(collection.size(), c0Var);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            p2(it2.next(), jVar);
        }
        return c0Var;
    }

    @CanIgnoreReturnValue
    public static int C(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m(i, i2, "index"));
        }
        return i;
    }

    public static boolean C0(Camera camera) {
        List<String> supportedFlashModes;
        if (camera != null) {
            Camera$Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && (supportedFlashModes.size() != 1 || !supportedFlashModes.get(0).equals("off"))) {
                return true;
            }
        }
        return false;
    }

    public static final <T> Object C1(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        boolean z2;
        Object objA;
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextPlus = context.plus(coroutineContext);
        Job job = (Job) coroutineContextPlus.get(Job.h);
        if (job != null && !job.a()) {
            throw job.q();
        }
        if (coroutineContextPlus == context) {
            r rVar = new r(coroutineContextPlus, continuation);
            objA = g1(rVar, rVar, function2);
        } else {
            int i = d0.w.d.e;
            d$b d_b = d$b.a;
            if (m.areEqual((d0.w.d) coroutineContextPlus.get(d_b), (d0.w.d) context.get(d_b))) {
                z1 z1Var = new z1(coroutineContextPlus, continuation);
                Object objB = s.a.a.a.b(coroutineContextPlus, null);
                try {
                    Object objG1 = g1(z1Var, z1Var, function2);
                    s.a.a.a.a(coroutineContextPlus, objB);
                    objA = objG1;
                } catch (Throwable th) {
                    s.a.a.a.a(coroutineContextPlus, objB);
                    throw th;
                }
            } else {
                i0 i0Var = new i0(coroutineContextPlus, continuation);
                i0Var.f0();
                f1(function2, i0Var, i0Var, null, 4);
                while (true) {
                    int i2 = i0Var._decision;
                    z2 = false;
                    if (i2 != 0) {
                        if (i2 == 2) {
                            break;
                        }
                        throw new IllegalStateException("Already suspended".toString());
                    }
                    if (i0.n.compareAndSet(i0Var, 0, 1)) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    objA = d0.w.h.c.getCOROUTINE_SUSPENDED();
                } else {
                    objA = i1.a(i0Var.M());
                    if (objA instanceof w) {
                        throw ((w) objA).f3846b;
                    }
                }
            }
        }
        if (objA == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
            d0.w.i.a.g.probeCoroutineSuspended(continuation);
        }
        return objA;
    }

    public static void D(int i, int i2, int i3) {
        String strM;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strM = m(i, i3, "start index");
            } else {
                strM = (i2 < 0 || i2 > i3) ? m(i2, i3, "end index") : I0("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strM);
        }
    }

    public static boolean D0(@RecentlyNonNull Context context, int i) {
        if (!z1(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            b.i.a.f.e.f fVarA = b.i.a.f.e.f.a(context);
            Objects.requireNonNull(fVarA);
            if (packageInfo == null) {
                return false;
            }
            if (!b.i.a.f.e.f.d(packageInfo, false)) {
                if (!b.i.a.f.e.f.d(packageInfo, true)) {
                    return false;
                }
                if (!b.i.a.f.e.e.a(fVarA.f1348b)) {
                    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                    return false;
                }
            }
            return true;
        } catch (PackageManager$NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @NonNull
    public static b.o.a.x.c D1(@NonNull b.o.a.x.j jVar) {
        return new k(jVar, null);
    }

    public static void E(boolean z2) {
        if (!z2) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    public static synchronized boolean E0(@RecentlyNonNull Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = a;
        if (context2 != null && (bool = f1397b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f1397b = null;
        if (A0()) {
            f1397b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f1397b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f1397b = Boolean.FALSE;
            }
        }
        a = applicationContext;
        return f1397b.booleanValue();
    }

    public static <T> Class<T> E1(Class<T> cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        return cls == Void.TYPE ? Void.class : cls;
    }

    public static void F(boolean z2, @NullableDecl String str, int i) {
        if (!z2) {
            throw new IllegalStateException(I0(str, Integer.valueOf(i)));
        }
    }

    public static final boolean F0(g0.e eVar) {
        m.checkParameterIsNotNull(eVar, "$this$isProbablyUtf8");
        try {
            g0.e eVar2 = new g0.e();
            eVar.n(eVar2, 0L, d0.d0.f.coerceAtMost(eVar.k, 64L));
            for (int i = 0; i < 16 && !eVar2.w(); i++) {
                int I = eVar2.I();
                if (Character.isISOControl(I) && !Character.isWhitespace(I)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static int F1(int i, int i2, @NullableDecl String str) {
        String strL2;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strL2 = l2("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.g(26, "negative size: ", i2));
            }
            strL2 = l2("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strL2);
    }

    public static void G(boolean z2, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(I0(str, obj));
        }
    }

    public static final Job G0(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        CoroutineContext coroutineContextA = z.a(coroutineScope, coroutineContext);
        Objects.requireNonNull(coroutineStart);
        s.a.b k1Var = coroutineStart == CoroutineStart.LAZY ? new k1(coroutineContextA, function2) : new t1(coroutineContextA, true);
        k1Var.j0(coroutineStart, k1Var, function2);
        return k1Var;
    }

    public static int G1(int i, byte[] bArr, int i2, int i3, s3 s3Var) throws zzij {
        if ((i >>> 3) == 0) {
            throw zzij.c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return n2(bArr, i2, s3Var);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return O1(bArr, i2, s3Var) + s3Var.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzij.c();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = O1(bArr, i2, s3Var);
            i6 = s3Var.a;
            if (i6 == i5) {
                break;
            }
            i2 = G1(i6, bArr, i2, i3, s3Var);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzij.d();
        }
        return i2;
    }

    public static int H(long j) {
        int i = (int) j;
        if (((long) i) == j) {
            return i;
        }
        throw new IllegalArgumentException(I0("Out of range: %s", Long.valueOf(j)));
    }

    public static /* synthetic */ Job H0(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = d0.w.f.j;
        }
        return G0(coroutineScope, coroutineContext, (i & 2) != 0 ? CoroutineStart.DEFAULT : null, function2);
    }

    public static int H1(int i, byte[] bArr, int i2, int i3, b5<?> b5Var, s3 s3Var) {
        x4 x4Var = (x4) b5Var;
        int iO1 = O1(bArr, i2, s3Var);
        x4Var.g(s3Var.a);
        while (iO1 < i3) {
            int iO2 = O1(bArr, iO1, s3Var);
            if (i != s3Var.a) {
                break;
            }
            iO1 = O1(bArr, iO2, s3Var);
            x4Var.g(s3Var.a);
        }
        return iO1;
    }

    public static /* synthetic */ boolean I(s sVar, Throwable th, int i, Object obj) {
        int i2 = i & 1;
        return sVar.j(null);
    }

    public static String I0(@NullableDecl String str, @NullableDecl Object... objArr) {
        int iIndexOf;
        String strValueOf;
        String strValueOf2 = String.valueOf(str);
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            try {
                strValueOf = String.valueOf(obj);
            } catch (Exception e) {
                String str2 = obj.getClass().getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(obj));
                Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e);
                strValueOf = "<" + str2 + " threw " + e.getClass().getName() + ">";
            }
            objArr[i2] = strValueOf;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf2.length());
        int i3 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf2.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) strValueOf2, i3, iIndexOf);
            sb.append(objArr[i]);
            i3 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) strValueOf2, i3, strValueOf2.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static int I1(int i, byte[] bArr, int i2, int i3, c7 c7Var, s3 s3Var) throws zzij {
        if ((i >>> 3) == 0) {
            throw zzij.c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iN2 = n2(bArr, i2, s3Var);
            c7Var.a(i, Long.valueOf(s3Var.f1493b));
            return iN2;
        }
        if (i4 == 1) {
            c7Var.a(i, Long.valueOf(o2(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iO1 = O1(bArr, i2, s3Var);
            int i5 = s3Var.a;
            if (i5 < 0) {
                throw zzij.b();
            }
            if (i5 > bArr.length - iO1) {
                throw zzij.a();
            }
            if (i5 == 0) {
                c7Var.a(i, t3.j);
            } else {
                c7Var.a(i, t3.h(bArr, iO1, i5));
            }
            return iO1 + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzij.c();
            }
            c7Var.a(i, Integer.valueOf(N1(bArr, i2)));
            return i2 + 4;
        }
        c7 c7VarC = c7.c();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i3) {
            int iO2 = O1(bArr, i2, s3Var);
            int i8 = s3Var.a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iO2;
                break;
            }
            i7 = i8;
            i2 = I1(i8, bArr, iO2, i3, c7VarC, s3Var);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzij.d();
        }
        c7Var.a(i, c7VarC);
        return i2;
    }

    public static int J(int i, int i2) {
        int i3 = i - i2;
        if (i3 > i2) {
            i3 = i2;
            i2 = i3;
        }
        int i4 = 1;
        int i5 = 1;
        while (i > i2) {
            i4 *= i;
            if (i5 <= i3) {
                i4 /= i5;
                i5++;
            }
            i--;
        }
        while (i5 <= i3) {
            i4 /= i5;
            i5++;
        }
        return i4;
    }

    public static final float[] J0(float[] fArr) {
        m.checkNotNullParameter(fArr, "matrix");
        return (float[]) fArr.clone();
    }

    public static int J1(int i, byte[] bArr, int i2, s3 s3Var) {
        int i3 = i & Opcodes.LAND;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            s3Var.a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & 127) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            s3Var.a = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            s3Var.a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            s3Var.a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                s3Var.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static final byte[] K(String str) {
        int i;
        int i2;
        char cCharAt;
        m.checkParameterIsNotNull(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 >= 128) {
                int length2 = str.length();
                int i4 = i3;
                while (i3 < length2) {
                    char cCharAt3 = str.charAt(i3);
                    if (cCharAt3 < 128) {
                        int i5 = i4 + 1;
                        bArr[i4] = (byte) cCharAt3;
                        i3++;
                        while (i3 < length2 && str.charAt(i3) < 128) {
                            bArr[i5] = (byte) str.charAt(i3);
                            i3++;
                            i5++;
                        }
                        i4 = i5;
                    } else {
                        if (cCharAt3 < 2048) {
                            int i6 = i4 + 1;
                            bArr[i4] = (byte) ((cCharAt3 >> 6) | Opcodes.CHECKCAST);
                            byte b2 = (byte) ((cCharAt3 & '?') | 128);
                            i = i6 + 1;
                            bArr[i6] = b2;
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            int i7 = i4 + 1;
                            bArr[i4] = (byte) ((cCharAt3 >> '\f') | 224);
                            int i8 = i7 + 1;
                            bArr[i7] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((cCharAt3 & '?') | 128);
                            i = i8 + 1;
                            bArr[i8] = b3;
                        } else {
                            if (cCharAt3 > 56319 || length2 <= (i2 = i3 + 1) || 56320 > (cCharAt = str.charAt(i2)) || 57343 < cCharAt) {
                                i = i4 + 1;
                                bArr[i4] = 63;
                            } else {
                                int iCharAt = (str.charAt(i2) + (cCharAt3 << '\n')) - 56613888;
                                int i9 = i4 + 1;
                                bArr[i4] = (byte) ((iCharAt >> 18) | 240);
                                int i10 = i9 + 1;
                                bArr[i9] = (byte) (((iCharAt >> 12) & 63) | 128);
                                int i11 = i10 + 1;
                                bArr[i10] = (byte) (((iCharAt >> 6) & 63) | 128);
                                i = i11 + 1;
                                bArr[i11] = (byte) ((iCharAt & 63) | 128);
                                i3 += 2;
                            }
                            i4 = i;
                        }
                        i3++;
                        i4 = i;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i4);
                m.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i3] = (byte) cCharAt2;
            i3++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        m.checkExpressionValueIsNotNull(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    @NonNull
    public static b.o.a.x.c K0(int i) {
        return D1(new f$c(i));
    }

    public static int K1(q6<?> q6Var, int i, byte[] bArr, int i2, int i3, b5<?> b5Var, s3 s3Var) throws IOException {
        int iM1 = M1(q6Var, bArr, i2, i3, s3Var);
        b5Var.add(s3Var.c);
        while (iM1 < i3) {
            int iO1 = O1(bArr, iM1, s3Var);
            if (i != s3Var.a) {
                break;
            }
            iM1 = M1(q6Var, bArr, iO1, i3, s3Var);
            b5Var.add(s3Var.c);
        }
        return iM1;
    }

    @NonNull
    public static Rect L(@NonNull b.o.a.x.b bVar, @NonNull b.o.a.x.a aVar) {
        int iRound;
        int i = bVar.j;
        int i2 = bVar.k;
        int i3 = 0;
        if (Math.abs(aVar.i() - b.o.a.x.a.f(bVar.j, bVar.k).i()) <= 5.0E-4f) {
            return new Rect(0, 0, i, i2);
        }
        if (b.o.a.x.a.f(i, i2).i() > aVar.i()) {
            int iRound2 = Math.round(aVar.i() * i2);
            int iRound3 = Math.round((i - iRound2) / 2.0f);
            i = iRound2;
            i3 = iRound3;
            iRound = 0;
        } else {
            int iRound4 = Math.round(i / aVar.i());
            iRound = Math.round((i2 - iRound4) / 2.0f);
            i2 = iRound4;
        }
        return new Rect(i3, iRound, i + i3, i2 + iRound);
    }

    @NonNull
    public static b.o.a.x.c L0(int i) {
        return D1(new f$a(i));
    }

    public static int L1(q6 q6Var, byte[] bArr, int i, int i2, int i3, s3 s3Var) throws IOException {
        e6 e6Var = (e6) q6Var;
        Object objB = e6Var.m.b(e6Var.g);
        int iM = e6Var.m(objB, bArr, i, i2, i3, s3Var);
        e6Var.d(objB);
        s3Var.c = objB;
        return iM;
    }

    public static final <R> Object M(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        r rVar = new r(continuation.getContext(), continuation);
        Object objG1 = g1(rVar, rVar, function2);
        if (objG1 == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
            d0.w.i.a.g.probeCoroutineSuspended(continuation);
        }
        return objG1;
    }

    @NonNull
    public static b.o.a.x.c M0(int i) {
        return D1(new f$d(i));
    }

    public static int M1(q6 q6Var, byte[] bArr, int i, int i2, s3 s3Var) throws IOException {
        int iJ1 = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iJ1 = J1(i3, bArr, iJ1, s3Var);
            i3 = s3Var.a;
        }
        int i4 = iJ1;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzij.a();
        }
        Object objA = q6Var.a();
        int i5 = i3 + i4;
        q6Var.h(objA, bArr, i4, i5, s3Var);
        q6Var.d(objA);
        s3Var.c = objA;
        return i5;
    }

    public static b.i.c.l.d<?> N(String str, String str2) {
        b.i.c.x.a aVar = new b.i.c.x.a(str, str2);
        b.i.c.l.d$b d_bA = b.i.c.l.d.a(b.i.c.x.e.class);
        d_bA.d = 1;
        d_bA.c(new b.i.c.l.c(aVar));
        return d_bA.b();
    }

    @NonNull
    public static b.o.a.x.c N0(int i) {
        return D1(new f$b(i));
    }

    public static int N1(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a3 A[LOOP:2: B:24:0x006a->B:49:0x00a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c9 A[LOOP:1: B:60:0x00bc->B:64:0x00c9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:86:0x00cf A[EDGE_INSN: B:86:0x00cf->B:65:0x00cf BREAK  A[LOOP:1: B:60:0x00bc->B:64:0x00c9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x009e A[SYNTHETIC] */
    public static final InetAddress O(String str, int i, int i2) {
        boolean z2;
        int i3;
        int i4;
        char cCharAt;
        int i5;
        int i6;
        int iR;
        byte[] bArr = new byte[16];
        int i7 = i;
        int i8 = 0;
        int i9 = -1;
        int i10 = -1;
        while (i7 < i2) {
            if (i8 == 16) {
                return null;
            }
            int i11 = i7 + 2;
            if (i11 <= i2 && t.startsWith$default(str, "::", i7, false, 4, null)) {
                if (i9 != -1) {
                    return null;
                }
                i8 += 2;
                if (i11 == i2) {
                    i9 = i8;
                    break;
                }
                i10 = i11;
                i9 = i8;
                i7 = i10;
                i5 = 0;
                while (i7 < i2) {
                    iR = f0.e0.c.r(str.charAt(i7));
                    if (iR == -1) {
                        break;
                        break;
                    }
                    i5 = (i5 << 4) + iR;
                    i7++;
                }
                i6 = i7 - i10;
                if (i6 != 0) {
                }
                return null;
            }
            if (i8 != 0) {
                if (!t.startsWith$default(str, ":", i7, false, 4, null)) {
                    if (!t.startsWith$default(str, ".", i7, false, 4, null)) {
                        return null;
                    }
                    int i12 = i8 - 2;
                    int i13 = i12;
                    loop2: while (true) {
                        if (i10 >= i2) {
                            if (i13 == i12 + 4) {
                                z2 = true;
                                break;
                            }
                        } else if (i13 != 16) {
                            if (i13 == i12) {
                                i3 = i10;
                                i4 = 0;
                                while (true) {
                                    if (i3 >= i2) {
                                        cCharAt = str.charAt(i3);
                                        if (cCharAt < '0' && cCharAt <= '9') {
                                            if ((i4 != 0 || i10 == i3) && (i4 = ((i4 * 10) + cCharAt) - 48) <= 255) {
                                                i3++;
                                            }
                                        }
                                    }
                                    if (i3 - i10 == 0) {
                                        bArr[i13] = (byte) i4;
                                        i10 = i3;
                                        i13++;
                                    }
                                }
                            } else if (str.charAt(i10) == '.') {
                                i10++;
                                i3 = i10;
                                i4 = 0;
                                while (true) {
                                    if (i3 >= i2) {
                                        cCharAt = str.charAt(i3);
                                        if (cCharAt < '0') {
                                        }
                                    }
                                    if (i3 - i10 == 0) {
                                        bArr[i13] = (byte) i4;
                                        i10 = i3;
                                        i13++;
                                    }
                                    i3++;
                                }
                            }
                        }
                        z2 = false;
                        break loop2;
                    }
                    if (!z2) {
                        return null;
                    }
                    i8 += 2;
                    break;
                }
                i7++;
            }
            i10 = i7;
            i7 = i10;
            i5 = 0;
            while (i7 < i2) {
                iR = f0.e0.c.r(str.charAt(i7));
                if (iR == -1) {
                    break;
                }
                i5 = (i5 << 4) + iR;
                i7++;
            }
            i6 = i7 - i10;
            if (i6 != 0 || i6 > 4) {
                return null;
            }
            int i14 = i8 + 1;
            bArr[i8] = (byte) ((i5 >>> 8) & 255);
            i8 = i14 + 1;
            bArr[i14] = (byte) (i5 & 255);
        }
        if (i8 != 16) {
            if (i9 == -1) {
                return null;
            }
            int i15 = i8 - i9;
            System.arraycopy(bArr, i9, bArr, 16 - i15, i15);
            Arrays.fill(bArr, i9, (16 - i8) + i9, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static /* synthetic */ void O0(FlexInputViewModel flexInputViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        flexInputViewModel.onContentDialogDismissed(z2);
    }

    public static int O1(byte[] bArr, int i, s3 s3Var) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return J1(b2, bArr, i2, s3Var);
        }
        s3Var.a = b2;
        return i2;
    }

    public static final Object P(long j, Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.a;
        }
        l lVar = new l(d0.w.h.b.intercepted(continuation), 1);
        lVar.A();
        if (j < RecyclerView.FOREVER_NS) {
            i0(lVar.o).c(j, lVar);
        }
        Object objU = lVar.u();
        if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
            d0.w.i.a.g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static /* synthetic */ void P0(FlexInputViewModel flexInputViewModel, String str, Boolean bool, int i, Object obj) {
        int i2 = i & 2;
        flexInputViewModel.onInputTextChanged(str, null);
    }

    public static int P1(byte[] bArr, int i, b5<?> b5Var, s3 s3Var) throws IOException {
        x4 x4Var = (x4) b5Var;
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a + iO1;
        while (iO1 < i2) {
            iO1 = O1(bArr, iO1, s3Var);
            x4Var.g(s3Var.a);
        }
        if (iO1 == i2) {
            return iO1;
        }
        throw zzij.a();
    }

    public static float Q(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((f6 * f6) + (f5 * f5));
    }

    @NonNull
    public static b.o.a.x.c Q0(b.o.a.x.c... cVarArr) {
        return new b.o.a.x.l(cVarArr, null);
    }

    public static <T> z2<T> Q1(z2<T> z2Var) {
        if ((z2Var instanceof c3) || (z2Var instanceof a3)) {
            return z2Var;
        }
        return z2Var instanceof Serializable ? new a3(z2Var) : new c3(z2Var);
    }

    public static float R(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return (float) Math.sqrt((i6 * i6) + (i5 * i5));
    }

    public static int R0(int i) {
        if (i >= 200 && i <= 299) {
            return 0;
        }
        if (i >= 300 && i <= 399) {
            return 1;
        }
        if (i >= 400 && i <= 499) {
            return 0;
        }
        if (i >= 500) {
        }
        return 1;
    }

    public static FirebaseAppIndexingException R1(@NonNull Status status, String str) {
        String str2 = status.q;
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        int i = status.p;
        if (i == 17510) {
            return new FirebaseAppIndexingInvalidArgumentException(str);
        }
        if (i == 17511) {
            return new FirebaseAppIndexingTooManyArgumentsException(str);
        }
        if (i == 17602) {
            return new zzh(str);
        }
        switch (i) {
            case 17513:
                return new zzb(str);
            case 17514:
                return new zza(str);
            case 17515:
                return new zzg(str);
            case 17516:
                return new zze(str);
            case 17517:
                return new zzf(str);
            case 17518:
                return new zzd(str);
            case 17519:
                return new zzc(str);
            default:
                return new FirebaseAppIndexingException(str);
        }
    }

    public static int S(Context context, float f) {
        float fApplyDimension = TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        int i = (int) (((double) fApplyDimension) + 0.5d);
        if (i != 0 || fApplyDimension <= 0.0f) {
            return i;
        }
        return 1;
    }

    public static JsonElement S0(JsonReader jsonReader) throws JsonParseException {
        boolean z2;
        try {
            try {
                jsonReader.N();
                z2 = false;
                try {
                    return TypeAdapters.X.read(jsonReader);
                } catch (EOFException e) {
                    e = e;
                    if (z2) {
                        return b.i.d.j.a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e2) {
                e = e2;
                z2 = true;
            }
        } catch (MalformedJsonException e3) {
            throw new JsonSyntaxException(e3);
        } catch (IOException e4) {
            throw new JsonIOException(e4);
        } catch (NumberFormatException e5) {
            throw new JsonSyntaxException(e5);
        }
    }

    public static <T> T S1(@NonNull Bundle bundle, String str, Class<T> cls, T t) {
        T t2 = (T) bundle.get(str);
        if (t2 == null) {
            return t;
        }
        if (cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", str, cls.getCanonicalName(), t2.getClass().getCanonicalName()));
    }

    public static float T(float f, float f2, float f3, float f4) {
        float f5 = f / (f4 / 2.0f);
        float f6 = f3 / 2.0f;
        if (f5 < 1.0f) {
            return (f6 * f5 * f5 * f5) + f2;
        }
        float f7 = f5 - 2.0f;
        return (((f7 * f7 * f7) + 2.0f) * f6) + f2;
    }

    public static final Object T0(Object obj, E e) {
        if (obj == null) {
            return e;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return arrayList;
    }

    public static <V> V T1(d2<V> d2Var) {
        try {
            return d2Var.a();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return d2Var.a();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0076 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:0x0082 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0086 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x008e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0094 A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0095 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a1 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a5 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b8 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1, types: [s.a.c2.o] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b5 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final <T> java.lang.Object U(s.a.d2.e<? super T> r8, s.a.c2.o<? extends T> r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.f.e.o.f.U(s.a.d2.e, s.a.c2.o, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static long U0(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == RecyclerView.FOREVER_NS) {
                return RecyclerView.FOREVER_NS;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                throw new IllegalStateException(b.d.b.a.a.t("More produced than requested: ", j3));
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static <TResult> TResult U1(@NonNull Task<TResult> task) throws ExecutionException {
        if (task.p()) {
            return task.l();
        }
        if (task.n()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.k());
    }

    public static boolean V(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static RuntimeException V0(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    public static String V1(Context context, String str) {
        try {
            Objects.requireNonNull(context, "null reference");
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, "string", resources.getResourcePackageName(R$a.common_google_play_services_unknown_issue));
            if (identifier != 0) {
                return resources.getString(identifier);
            }
        } catch (Resources$NotFoundException unused) {
        }
        return null;
    }

    public static <T> T W(@NullableDecl T t, @NullableDecl T t2) {
        if (t != null) {
            return t;
        }
        Objects.requireNonNull(t2, "Both parameters are null");
        return t2;
    }

    public static void W0(int i, h0.a.a.c cVar) {
        int i2 = i >>> 24;
        if (i2 != 0 && i2 != 1) {
            switch (i2) {
                case 16:
                case 17:
                case 18:
                case 23:
                    break;
                case 19:
                case 20:
                case 21:
                    cVar.g(i2);
                    return;
                case 22:
                    break;
                default:
                    switch (i2) {
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            cVar.i(i);
                            return;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
            cVar.e(i2, (i & 16776960) >> 8);
            return;
        }
        cVar.j(i >>> 16);
    }

    public static String W1(t3 t3Var) {
        b7 b7Var = new b7(t3Var);
        StringBuilder sb = new StringBuilder(t3Var.d());
        for (int i = 0; i < b7Var.a.d(); i++) {
            byte bC = b7Var.a.c(i);
            if (bC == 34) {
                sb.append("\\\"");
            } else if (bC == 39) {
                sb.append("\\'");
            } else if (bC != 92) {
                switch (bC) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bC < 32 || bC > 126) {
                            sb.append('\\');
                            sb.append((char) (((bC >>> 6) & 3) + 48));
                            sb.append((char) (((bC >>> 3) & 7) + 48));
                            sb.append((char) ((bC & 7) + 48));
                        } else {
                            sb.append((char) bC);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static final FloatBuffer X(int i) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i * 4 * 1).order(ByteOrder.nativeOrder());
        byteBufferOrder.limit(byteBufferOrder.capacity());
        m.checkNotNullExpressionValue(byteBufferOrder, "allocateDirect(size * Egloo.SIZE_OF_BYTE)\n        .order(ByteOrder.nativeOrder())\n        .also { it.limit(it.capacity()) }");
        FloatBuffer floatBufferAsFloatBuffer = byteBufferOrder.asFloatBuffer();
        m.checkNotNullExpressionValue(floatBufferAsFloatBuffer, "byteBuffer(size * Egloo.SIZE_OF_FLOAT).asFloatBuffer()");
        return floatBufferAsFloatBuffer;
    }

    public static final <T> Object X0(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof w) {
            k$a k_a = d0.k.j;
            return d0.k.m97constructorimpl(d0.l.createFailure(((w) obj).f3846b));
        }
        k$a k_a2 = d0.k.j;
        return d0.k.m97constructorimpl(obj);
    }

    public static final String X1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    @NonNull
    public static <TResult> Task<TResult> Y(@RecentlyNonNull Exception exc) {
        c0 c0Var = new c0();
        c0Var.t(exc);
        return c0Var;
    }

    public static final <T> void Y0(j0<? super T> j0Var, Continuation<? super T> continuation, boolean z2) {
        Object objJ;
        Object objM = j0Var.m();
        Throwable thE = j0Var.e(objM);
        if (thE != null) {
            k$a k_a = d0.k.j;
            objJ = d0.l.createFailure(thE);
        } else {
            k$a k_a2 = d0.k.j;
            objJ = j0Var.j(objM);
        }
        Object objM97constructorimpl = d0.k.m97constructorimpl(objJ);
        if (!z2) {
            continuation.resumeWith(objM97constructorimpl);
            return;
        }
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        s.a.a.g gVar = (s.a.a.g) continuation;
        CoroutineContext context = gVar.getContext();
        Object objB = s.a.a.a.b(context, gVar.p);
        try {
            gVar.r.resumeWith(objM97constructorimpl);
        } finally {
            s.a.a.a.a(context, objB);
        }
    }

    @Nullable
    public static String Y1(String str, String[] strArr, String[] strArr2) {
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i];
            }
        }
        return null;
    }

    @NonNull
    public static <TResult> Task<TResult> Z(@RecentlyNonNull TResult tresult) {
        c0 c0Var = new c0();
        c0Var.s(tresult);
        return c0Var;
    }

    public static int Z0(float f) {
        return (int) (f + (f < 0.0f ? -0.5f : 0.5f));
    }

    @WorkerThread
    public static Set<String> Z1(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(b.d.b.a.a.k(b.d.b.a.a.b(str, 22), "SELECT * FROM ", str, " LIMIT 0"), null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static final String a0(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j <= -999500) {
            str = ((j - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j <= 0) {
            str = ((j - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500) {
            str = ((j + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500000) {
            str = ((j + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    public static final int a1(u uVar, int i) {
        int i2;
        m.checkParameterIsNotNull(uVar, "$this$segment");
        int[] iArr = uVar.o;
        int i3 = i + 1;
        int length = uVar.n.length;
        m.checkParameterIsNotNull(iArr, "$this$binarySearch");
        int i4 = length - 1;
        int i5 = 0;
        while (i5 <= i4) {
            i2 = (i5 + i4) >>> 1;
            int i6 = iArr[i2];
            if (i6 < i3) {
                i5 = i2 + 1;
            } else {
                if (i6 <= i3) {
                    if (i2 >= 0) {
                        return i2;
                    }
                    return ~i2;
                }
                i4 = i2 - 1;
            }
        }
        i2 = (-i5) - 1;
        if (i2 >= 0) {
            return i2;
        }
        return ~i2;
    }

    public static void a2(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzij {
        if (!w2(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !w2(b4) && !w2(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & AudioAttributesCompat.FLAG_ALL) + 56320);
                return;
            }
        }
        throw zzij.e();
    }

    public static s.a.c2.f b(int i, s.a.c2.e eVar, Function1 function1, int i2) {
        s.a.c2.e eVar2 = s.a.c2.e.SUSPEND;
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            eVar = eVar2;
        }
        int i3 = i2 & 4;
        int i4 = 1;
        if (i == -2) {
            if (eVar == eVar2) {
                Objects.requireNonNull(s.a.c2.f.i);
                i4 = s.a.c2.f$a.a;
            }
            return new s.a.c2.d(i4, eVar, null);
        }
        if (i == -1) {
            if (eVar == eVar2) {
                return new s.a.c2.j(null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i == 0) {
            return eVar == eVar2 ? new q(null) : new s.a.c2.d(1, eVar, null);
        }
        if (i != Integer.MAX_VALUE) {
            return (i == 1 && eVar == s.a.c2.e.DROP_OLDEST) ? new s.a.c2.j(null) : new s.a.c2.d(i, eVar, null);
        }
        return new s.a.c2.k(null);
    }

    public static b.i.c.l.d<?> b0(String str, b.i.c.x.g<Context> gVar) {
        b.i.c.l.d$b d_bA = b.i.c.l.d.a(b.i.c.x.e.class);
        d_bA.d = 1;
        d_bA.a(new o(Context.class, 1, 0));
        d_bA.c(new b.i.c.x.f(str, gVar));
        return d_bA.b();
    }

    public static final v b1(Socket socket) throws IOException {
        m.checkParameterIsNotNull(socket, "$this$sink");
        g0.w wVar = new g0.w(socket);
        OutputStream outputStream = socket.getOutputStream();
        m.checkExpressionValueIsNotNull(outputStream, "getOutputStream()");
        p pVar = new p(outputStream, wVar);
        m.checkParameterIsNotNull(pVar, "sink");
        return new g0.c(wVar, pVar);
    }

    public static void b2(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzij {
        if (w2(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || w2(b4)))) {
            throw zzij.e();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static final CoroutineScope c(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.h) == null) {
            coroutineContext = coroutineContext.plus(new f1(null));
        }
        return new s.a.a.f(coroutineContext);
    }

    public static long c0(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, f(j2, j)));
        return j2;
    }

    public static int c1(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static void c2(byte b2, byte b3, char[] cArr, int i) throws zzij {
        if (b2 < -62 || w2(b3)) {
            throw zzij.e();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static s.a.u d(Job job, int i) {
        int i2 = i & 1;
        return new u1(null);
    }

    public static float[] d0(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static final x d1(Socket socket) throws IOException {
        m.checkParameterIsNotNull(socket, "$this$source");
        g0.w wVar = new g0.w(socket);
        InputStream inputStream = socket.getInputStream();
        m.checkExpressionValueIsNotNull(inputStream, "getInputStream()");
        n nVar = new n(inputStream, wVar);
        m.checkParameterIsNotNull(nVar, "source");
        return new g0.d(wVar, nVar);
    }

    public static void d2(@NonNull Bundle bundle, @NonNull Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }

    public static final void e(f0.e0.f.a aVar, f0.e0.f.c cVar, String str) {
        f0.e0.f.d$b d_b = f0.e0.f.d.c;
        Logger logger = f0.e0.f.d.f3611b;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f);
        sb.append(' ');
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(aVar.c);
        logger.fine(sb.toString());
    }

    public static final String e0(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final void e1(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation continuationIntercepted = d0.w.h.b.intercepted(continuation);
            k$a k_a = d0.k.j;
            s.a.a.h.b(continuationIntercepted, d0.k.m97constructorimpl(Unit.a), null, 2);
        } catch (Throwable th) {
            k$a k_a2 = d0.k.j;
            ((s.a.b) continuation2).resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(th)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x024a  */
    /* JADX WARN: Code duplicated, block: B:116:0x024c  */
    public static void e2(c6 c6Var, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : c6Var.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            boolean zBooleanValue = true;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String strValueOf = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf2 = String.valueOf(strSubstring.substring(1, strSubstring.length() - 4));
                String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    h2(sb, i, X1(strConcat), u4.q(method2, c6Var, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strValueOf3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf4 = String.valueOf(strSubstring.substring(1, strSubstring.length() - 3));
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    h2(sb, i, X1(strConcat2), u4.q(method3, c6Var, new Object[0]));
                }
            }
            if (((Method) map2.get(strSubstring.length() != 0 ? "set".concat(strSubstring) : new String("set"))) != null) {
                if (strSubstring.endsWith("Bytes")) {
                    String strValueOf5 = String.valueOf(strSubstring.substring(0, strSubstring.length() - 5));
                    if (!map.containsKey(strValueOf5.length() != 0 ? "get".concat(strValueOf5) : new String("get"))) {
                    }
                }
                String strValueOf6 = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf7 = String.valueOf(strSubstring.substring(1));
                String strConcat3 = strValueOf7.length() != 0 ? strValueOf6.concat(strValueOf7) : new String(strValueOf6);
                Method method4 = (Method) map.get(strSubstring.length() != 0 ? "get".concat(strSubstring) : new String("get"));
                Method method5 = (Method) map.get(strSubstring.length() != 0 ? "has".concat(strSubstring) : new String("has"));
                if (method4 != null) {
                    Object objQ = u4.q(method4, c6Var, new Object[0]);
                    if (method5 == null) {
                        if (objQ instanceof Boolean) {
                            if (((Boolean) objQ).booleanValue()) {
                                zEquals = false;
                            } else {
                                zEquals = true;
                            }
                        } else if (objQ instanceof Integer) {
                            if (((Integer) objQ).intValue() == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objQ instanceof Float) {
                            if (((Float) objQ).floatValue() == 0.0f) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objQ instanceof Double) {
                            if (((Double) objQ).doubleValue() == 0.0d) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objQ instanceof String) {
                            zEquals = objQ.equals("");
                        } else if (objQ instanceof t3) {
                            zEquals = objQ.equals(t3.j);
                        } else if (!(objQ instanceof c6) ? !((objQ instanceof Enum) && ((Enum) objQ).ordinal() == 0) : objQ != ((c6) objQ).k()) {
                            zEquals = false;
                        } else {
                            zEquals = true;
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) u4.q(method5, c6Var, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        h2(sb, i, X1(strConcat3), objQ);
                    }
                }
            }
        }
        if (c6Var instanceof u4$d) {
            Iterator<Map$Entry<T, Object>> itL = ((u4$d) c6Var).zzc.l();
            if (itL.hasNext()) {
                throw new NoSuchMethodError();
            }
        }
        c7 c7Var = ((u4) c6Var).zzb;
        if (c7Var != null) {
            for (int i2 = 0; i2 < c7Var.f1438b; i2++) {
                h2(sb, i, String.valueOf(c7Var.c[i2] >>> 3), c7Var.d[i2]);
            }
        }
    }

    public static long f(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? RecyclerView.FOREVER_NS : j3;
    }

    public static float[] f0(RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        return new float[]{f, f2, f3, f2, f3, f4, f, f4};
    }

    public static void f1(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i) {
        int i2 = i & 4;
        try {
            Continuation continuationIntercepted = d0.w.h.b.intercepted(d0.w.h.b.createCoroutineUnintercepted(function2, obj, continuation));
            k$a k_a = d0.k.j;
            s.a.a.h.a(continuationIntercepted, d0.k.m97constructorimpl(Unit.a), null);
        } catch (Throwable th) {
            k$a k_a2 = d0.k.j;
            continuation.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(th)));
        }
    }

    public static void f2(q3 q3Var, SQLiteDatabase sQLiteDatabase) {
        if (q3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            q3Var.i.a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            q3Var.i.a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            q3Var.i.a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        q3Var.i.a("Failed to turn on database write permission for owner");
    }

    @NonNull
    public static b.o.a.x.c g(b.o.a.x.c... cVarArr) {
        return new b.o.a.x.i(cVarArr, null);
    }

    public static String g0(long j) {
        return h0(j, null);
    }

    public static final <T, R> Object g1(r<? super T> rVar, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object wVar;
        Object objR;
        rVar.f0();
        try {
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            wVar = ((Function2) e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, rVar);
            if (wVar != d0.w.h.c.getCOROUTINE_SUSPENDED() && (objR = rVar.R(wVar)) != i1.f3841b) {
                if (objR instanceof w) {
                    throw ((w) objR).f3846b;
                }
                return i1.a(objR);
            }
            return d0.w.h.c.getCOROUTINE_SUSPENDED();
        } catch (Throwable th) {
            wVar = new w(th, false, 2);
        }
    }

    @WorkerThread
    public static void g2(q3 q3Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        boolean zMoveToFirst;
        if (q3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{ModelAuditLogEntry.CHANGE_KEY_NAME}, "name=?", new String[]{str}, null, null, null);
                zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e) {
            q3Var.i.c("Error querying for table", str, e);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            zMoveToFirst = false;
        }
        if (!zMoveToFirst) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set<String> setZ1 = Z1(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!((HashSet) setZ1).remove(str4)) {
                    StringBuilder sb = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                    sb.append("Table ");
                    sb.append(str);
                    sb.append(" is missing required column: ");
                    sb.append(str4);
                    throw new SQLiteException(sb.toString());
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!((HashSet) setZ1).remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (((HashSet) setZ1).isEmpty()) {
                return;
            }
            q3Var.i.c("Table has extra columns. table, columns", str, TextUtils.join(", ", setZ1));
        } catch (SQLiteException e2) {
            q3Var.f.b("Failed to verify columns on table that was just created", str);
            throw e2;
        }
    }

    public static final boolean h(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        m.checkParameterIsNotNull(bArr, "a");
        m.checkParameterIsNotNull(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static String h0(long j, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar calendarH = b.i.a.g.d.l.h();
        Calendar calendarI = b.i.a.g.d.l.i();
        calendarI.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        return calendarH.get(1) == calendarI.get(1) ? n0(j, Locale.getDefault()) : s0(j, Locale.getDefault());
    }

    public static int h1(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static final void h2(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                h2(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                h2(sb, i, str, (Map$Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            t3 t3Var = t3.j;
            sb.append(W1(new z3(((String) obj).getBytes(w4.a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof t3) {
            sb.append(": \"");
            sb.append(W1((t3) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof u4) {
            sb.append(" {");
            e2((u4) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map$Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map$Entry map$Entry = (Map$Entry) obj;
        int i4 = i + 2;
        h2(sb, i4, "key", map$Entry.getKey());
        h2(sb, i4, "value", map$Entry.getValue());
        sb.append("\n");
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    public static f0 i(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        d0.w.f fVar = (i & 1) != 0 ? d0.w.f.j : null;
        CoroutineStart coroutineStart2 = (i & 2) != 0 ? CoroutineStart.DEFAULT : null;
        CoroutineContext coroutineContextA = z.a(coroutineScope, fVar);
        Objects.requireNonNull(coroutineStart2);
        g0 j1Var = coroutineStart2 == CoroutineStart.LAZY ? new j1(coroutineContextA, function2) : new g0(coroutineContextA, true);
        j1Var.j0(coroutineStart2, j1Var, function2);
        return j1Var;
    }

    public static final h0 i0(CoroutineContext coroutineContext) {
        int i = d0.w.d.e;
        CoroutineContext$Element coroutineContext$Element = coroutineContext.get(d$b.a);
        if (!(coroutineContext$Element instanceof h0)) {
            coroutineContext$Element = null;
        }
        h0 h0Var = (h0) coroutineContext$Element;
        return h0Var != null ? h0Var : s.a.e0.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object i1(Exception exc, Continuation<?> continuation) {
        f$h f_h;
        if (continuation instanceof f$h) {
            f_h = (f$h) continuation;
            int i = f_h.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                f_h.label = i - Integer.MIN_VALUE;
            } else {
                f_h = new f$h(continuation);
            }
        } else {
            f_h = new f$h(continuation);
        }
        Object obj = f_h.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = f_h.label;
        if (i2 == 0) {
            d0.l.throwOnFailure(obj);
            f_h.L$0 = exc;
            f_h.label = 1;
            k0.a.dispatch(f_h.getContext(), new f$g(f_h, exc));
            Object coroutine_suspended2 = d0.w.h.c.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended2 == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                d0.w.i.a.g.probeCoroutineSuspended(f_h);
            }
            if (coroutine_suspended2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0.l.throwOnFailure(obj);
        }
        return Unit.a;
    }

    public static boolean i2(byte b2) {
        return b2 >= 0;
    }

    @RecentlyNonNull
    public static <TResult> TResult j(@RecentlyNonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        b.c.a.a0.d.x("Must not be called on the main application thread");
        b.c.a.a0.d.z(task, "Task must not be null");
        if (task.o()) {
            return (TResult) U1(task);
        }
        b.i.a.f.n.h hVar = new b.i.a.f.n.h(null);
        p2(task, hVar);
        hVar.a.await();
        return (TResult) U1(task);
    }

    public static final int j0(b.p.a.b bVar, @DimenRes int i) {
        m.checkNotNullParameter(bVar, "$this$getDimenPixelSize");
        return bVar.getResources().getDimensionPixelSize(i);
    }

    public static final long j1(String str, long j, long j2, long j3) {
        String strK1 = k1(str);
        if (strK1 == null) {
            return j;
        }
        Long longOrNull = d0.g0.s.toLongOrNull(strK1);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strK1 + '\'').toString());
        }
        long jLongValue = longOrNull.longValue();
        if (j2 <= jLongValue && j3 >= jLongValue) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    public static boolean j2(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @RecentlyNonNull
    public static <TResult> TResult k(@RecentlyNonNull Task<TResult> task, long j, @RecentlyNonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        b.c.a.a0.d.x("Must not be called on the main application thread");
        b.c.a.a0.d.z(task, "Task must not be null");
        b.c.a.a0.d.z(timeUnit, "TimeUnit must not be null");
        if (task.o()) {
            return (TResult) U1(task);
        }
        b.i.a.f.n.h hVar = new b.i.a.f.n.h(null);
        p2(task, hVar);
        if (hVar.a.await(j, timeUnit)) {
            return (TResult) U1(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NullableDecl
    public static <T> T k0(Iterable<? extends T> iterable, @NullableDecl T t) {
        n0 n0Var = new n0((h$a) iterable);
        return n0Var.hasNext() ? (T) n0Var.next() : t;
    }

    public static final String k1(String str) {
        int i = s.a.a.u.a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static int k2(int i) {
        int[] iArr = {1, 2, 3, 4, 5};
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 == i) {
                return i3;
            }
        }
        return 1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object l(f0<? extends T>[] f0VarArr, Continuation<? super List<? extends T>> continuation) {
        f$e f_e;
        if (continuation instanceof f$e) {
            f_e = (f$e) continuation;
            int i = f_e.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                f_e.label = i - Integer.MIN_VALUE;
            } else {
                f_e = new f$e(continuation);
            }
        } else {
            f_e = new f$e(continuation);
        }
        Object objU = f_e.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = f_e.label;
        if (i2 == 0) {
            d0.l.throwOnFailure(objU);
            if (f0VarArr.length == 0) {
                return d0.t.n.emptyList();
            }
            s.a.d dVar = new s.a.d(f0VarArr);
            f_e.L$0 = f0VarArr;
            f_e.label = 1;
            l lVar = new l(d0.w.h.b.intercepted(f_e), 1);
            lVar.A();
            int length = f0VarArr.length;
            d$a[] d_aArr = new d$a[length];
            for (int i3 = 0; i3 < length; i3++) {
                f0<T> f0Var = dVar.f3836b[d0.w.i.a.b.boxInt(i3).intValue()];
                f0Var.start();
                d$a d_a = new d$a(dVar, lVar, f0Var);
                d_a.n = f0Var.u(d_a);
                d_aArr[i3] = d_a;
            }
            s.a.d$b d_b = new s.a.d$b(dVar, d_aArr);
            for (int i4 = 0; i4 < length; i4++) {
                d_aArr[i4]._disposer = d_b;
            }
            if (lVar.v()) {
                d_b.b();
            } else {
                lVar.f(d_b);
            }
            objU = lVar.u();
            if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                d0.w.i.a.g.probeCoroutineSuspended(f_e);
            }
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0.l.throwOnFailure(objU);
        }
        return (List) objU;
    }

    public static final String l0(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static int l1(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) j1(str, i, i2, i3);
    }

    public static String l2(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append(MentionUtilsKt.MENTIONS_CHAR);
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(string2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e);
                    String name2 = e.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(string2).length() + 9 + name2.length());
                    b.d.b.a.a.s0(sb2, "<", string2, " threw ", name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i2] = string;
            i2++;
        }
        StringBuilder sb3 = new StringBuilder((length * 16) + str.length());
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i3, iIndexOf);
            sb3.append(objArr[i]);
            i3 = iIndexOf + 2;
            i++;
        }
        sb3.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb3.append(" [");
            sb3.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb3.append(", ");
                sb3.append(objArr[i4]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static String m(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return I0("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return I0("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(b.d.b.a.a.q("negative size: ", i2));
    }

    @TargetApi(17)
    public static int m0() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        int[] iArr = new int[2];
        EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0) {
            return 0;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext);
        int[] iArr3 = new int[1];
        GLES20.glGetIntegerv(3379, iArr3, 0);
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
        EGL14.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
        EGL14.eglTerminate(eGLDisplayEglGetDisplay);
        return iArr3[0];
    }

    public static /* synthetic */ long m1(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = RecyclerView.FOREVER_NS;
        }
        return j1(str, j, j4, j3);
    }

    public static boolean m2(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static ExecutorService n(String str) {
        ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new s0(str, new AtomicLong(1L)), new ThreadPoolExecutor$DiscardPolicy()));
        Runtime.getRuntime().addShutdownHook(new Thread(new t0(str, executorServiceUnconfigurableExecutorService, 2L, TimeUnit.SECONDS), b.d.b.a.a.w("Crashlytics Shutdown Hook for ", str)));
        return executorServiceUnconfigurableExecutorService;
    }

    public static String n0(long j, Locale locale) {
        if (Build$VERSION.SDK_INT >= 24) {
            return b.i.a.g.d.l.c("MMMd", locale).format(new Date(j));
        }
        AtomicReference<b.i.a.g.d.k> atomicReference = b.i.a.g.d.l.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(b.i.a.g.d.l.g());
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
        String pattern = simpleDateFormat.toPattern();
        int iB = b.i.a.g.d.l.b(pattern, "yY", 1, 0);
        if (iB < pattern.length()) {
            int iB2 = b.i.a.g.d.l.b(pattern, "EMd", 1, iB);
            pattern = pattern.replace(pattern.substring(b.i.a.g.d.l.b(pattern, iB2 < pattern.length() ? "EMd," : "EMd", -1, iB) + 1, iB2), " ").trim();
        }
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(new Date(j));
    }

    public static void n1(List<? extends Throwable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new CompositeException(list);
        }
        Throwable th = list.get(0);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static int n2(byte[] bArr, int i, s3 s3Var) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            s3Var.f1493b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & 127)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & 127)) << i4;
            b2 = b3;
            i3 = i5;
        }
        s3Var.f1493b = j2;
        return i3;
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> o(@RecentlyNonNull Executor executor, @RecentlyNonNull Callable<TResult> callable) {
        b.c.a.a0.d.z(executor, "Executor must not be null");
        b.c.a.a0.d.z(callable, "Callback must not be null");
        c0 c0Var = new c0();
        executor.execute(new d0(c0Var, callable));
        return c0Var;
    }

    public static final <T> l<T> o0(Continuation<? super T> continuation) {
        l<T> lVar;
        if (!(continuation instanceof s.a.a.g)) {
            return new l<>(continuation, 2);
        }
        s.a.a.g gVar = (s.a.a.g) continuation;
        while (true) {
            Object obj = gVar._reusableCancellableContinuation;
            if (obj == null) {
                gVar._reusableCancellableContinuation = s.a.a.h.f3827b;
                lVar = null;
                break;
            }
            if (!(obj instanceof l)) {
                throw new IllegalStateException(b.d.b.a.a.v("Inconsistent state ", obj).toString());
            }
            if (s.a.a.g.m.compareAndSet(gVar, obj, s.a.a.h.f3827b)) {
                lVar = (l) obj;
                break;
            }
        }
        if (lVar != null) {
            Object obj2 = lVar._state;
            boolean z2 = false;
            if (!(obj2 instanceof s.a.v) || ((s.a.v) obj2).d == null) {
                lVar._decision = 0;
                lVar._state = s.a.c.j;
                z2 = true;
            } else {
                lVar.q();
            }
            l<T> lVar2 = z2 ? lVar : null;
            if (lVar2 != null) {
                return lVar2;
            }
        }
        return new l<>(continuation, 2);
    }

    public static void o1(Throwable th) {
        if (th instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th);
        }
        if (th instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th);
        }
        if (th instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static long o2(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException p(Function1<? super E, Unit> function1, E e, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException(b.d.b.a.a.v("Exception in undelivered element handler for ", e), th);
            }
            d0.b.addSuppressed(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    public static int p0(int[] iArr, int i, boolean z2) {
        int[] iArr2 = iArr;
        int i2 = 0;
        for (int i3 : iArr2) {
            i2 += i3;
        }
        int length = iArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = length - 1;
            if (i4 >= i7) {
                return i5;
            }
            int i8 = 1 << i4;
            i6 |= i8;
            int i9 = 1;
            while (i9 < iArr2[i4]) {
                int i10 = i2 - i9;
                int i11 = length - i4;
                int i12 = i11 - 2;
                int iJ = J(i10 - 1, i12);
                if (z2 && i6 == 0) {
                    int i13 = i11 - 1;
                    if (i10 - i13 >= i13) {
                        iJ -= J(i10 - i11, i12);
                    }
                }
                if (i11 - 1 > 1) {
                    int iJ2 = 0;
                    for (int i14 = i10 - i12; i14 > i; i14--) {
                        iJ2 += J((i10 - i14) - 1, i11 - 3);
                    }
                    iJ -= (i7 - i4) * iJ2;
                } else if (i10 > i) {
                    iJ--;
                }
                i5 += iJ;
                i9++;
                i6 &= ~i8;
                iArr2 = iArr;
            }
            i2 -= i9;
            i4++;
            iArr2 = iArr;
        }
    }

    public static void p1(Throwable th, j0.g<?> gVar, Object obj) {
        o1(th);
        gVar.onError(OnErrorThrowable.a(th, obj));
    }

    public static <T> void p2(Task<T> task, b.i.a.f.n.i<? super T> iVar) {
        Executor executor = b.i.a.f.n.g.f1593b;
        task.g(executor, iVar);
        task.e(executor, iVar);
        task.a(executor, iVar);
    }

    public static /* synthetic */ UndeliveredElementException q(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i) {
        int i2 = i & 2;
        return p(function1, obj, null);
    }

    public static int q0(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            return 3;
        }
        return defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 2;
    }

    public static int[] q1(Collection<? extends Number> collection) {
        if (collection instanceof b.i.b.c.a) {
            b.i.b.c.a aVar = (b.i.b.c.a) collection;
            return Arrays.copyOfRange(aVar.array, aVar.start, aVar.end);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            Objects.requireNonNull(obj);
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static void q2(boolean z2, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static final void r(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.h);
        if (job != null) {
            job.b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static DateFormat r0(int i, int i2) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            str = "EEEE, MMMM d, yyyy";
        } else if (i == 1) {
            str = "MMMM d, yyyy";
        } else if (i == 2) {
            str = "MMM d, yyyy";
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(b.d.b.a.a.q("Unknown DateFormat style: ", i));
            }
            str = "M/d/yy";
        }
        sb.append(str);
        sb.append(" ");
        if (i2 == 0 || i2 == 1) {
            str2 = "h:mm:ss a z";
        } else if (i2 == 2) {
            str2 = "h:mm:ss a";
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException(b.d.b.a.a.q("Unknown DateFormat style: ", i2));
            }
            str2 = "h:mm a";
        }
        sb.append(str2);
        return new SimpleDateFormat(sb.toString(), Locale.US);
    }

    public static final String r1(String str) {
        int i;
        m.checkParameterIsNotNull(str, "$this$toCanonicalHost");
        int i2 = 0;
        int i3 = -1;
        if (!d0.g0.w.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            try {
                String ascii = IDN.toASCII(str);
                m.checkExpressionValueIsNotNull(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                m.checkExpressionValueIsNotNull(locale, "Locale.US");
                if (ascii == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                while (i < length) {
                    char cCharAt = lowerCase.charAt(i);
                    i = (cCharAt > 31 && cCharAt < 127 && d0.g0.w.indexOf$default((CharSequence) " #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) == -1) ? i + 1 : 0;
                    i2 = 1;
                    break;
                }
                if (i2 != 0) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressO = (t.startsWith$default(str, "[", false, 2, null) && t.endsWith$default(str, "]", false, 2, null)) ? O(str, 1, str.length() - 1) : O(str, 0, str.length());
        if (inetAddressO == null) {
            return null;
        }
        byte[] address = inetAddressO.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressO.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        m.checkExpressionValueIsNotNull(address, "address");
        int i4 = 0;
        int i5 = 0;
        while (i4 < address.length) {
            int i6 = i4;
            while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        g0.e eVar = new g0.e();
        while (i2 < address.length) {
            if (i2 == i3) {
                eVar.T(58);
                i2 += i5;
                if (i2 == 16) {
                    eVar.T(58);
                }
            } else {
                if (i2 > 0) {
                    eVar.T(58);
                }
                byte b2 = address[i2];
                byte[] bArr = f0.e0.c.a;
                eVar.V(((b2 & 255) << 8) | (address[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return eVar.D();
    }

    public static int r2(byte[] bArr, int i, s3 s3Var) throws zzij {
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a;
        if (i2 < 0) {
            throw zzij.b();
        }
        if (i2 == 0) {
            s3Var.c = "";
            return iO1;
        }
        s3Var.c = new String(bArr, iO1, i2, w4.a);
        return iO1 + i2;
    }

    public static void s(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        Job job = (Job) coroutineContext.get(Job.h);
        if (job != null) {
            job.b(null);
        }
    }

    public static String s0(long j, Locale locale) {
        if (Build$VERSION.SDK_INT >= 24) {
            return b.i.a.g.d.l.c("yMMMd", locale).format(new Date(j));
        }
        AtomicReference<b.i.a.g.d.k> atomicReference = b.i.a.g.d.l.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(b.i.a.g.d.l.g());
        return dateInstance.format(new Date(j));
    }

    public static final String s1(Continuation<?> continuation) {
        Object objM97constructorimpl;
        if (continuation instanceof s.a.a.g) {
            return continuation.toString();
        }
        try {
            k$a k_a = d0.k.j;
            objM97constructorimpl = d0.k.m97constructorimpl(continuation + MentionUtilsKt.MENTIONS_CHAR + l0(continuation));
        } catch (Throwable th) {
            k$a k_a2 = d0.k.j;
            objM97constructorimpl = d0.k.m97constructorimpl(d0.l.createFailure(th));
        }
        if (d0.k.m99exceptionOrNullimpl(objM97constructorimpl) != null) {
            objM97constructorimpl = continuation.getClass().getName() + MentionUtilsKt.MENTIONS_CHAR + l0(continuation);
        }
        return (String) objM97constructorimpl;
    }

    public static void s2(int i, int i2, int i3) {
        String strU2;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strU2 = u2(i, i3, "start index");
            } else {
                strU2 = (i2 < 0 || i2 > i3) ? u2(i2, i3, "end index") : l2("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strU2);
        }
    }

    public static /* synthetic */ void t(Job job, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        job.b(null);
    }

    public static void t0(@Nullable InputStream inputStream, @NonNull File file) throws Throwable {
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        gZIPOutputStream2.finish();
                        b.i.c.m.d.k.h.d(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    b.i.c.m.d.k.h.d(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final String t1(byte b2) {
        char[] cArr = g0.z.b.a;
        return new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]});
    }

    public static int t2(byte[] bArr, int i, s3 s3Var) throws zzij {
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a;
        if (i2 < 0) {
            throw zzij.b();
        }
        if (i2 == 0) {
            s3Var.c = "";
            return iO1;
        }
        s3Var.c = k7.a.c(bArr, iO1, i2);
        return iO1 + i2;
    }

    public static final void u(s.a.c2.o<?> oVar, Throwable th) {
        CancellationException cancellationExceptionA = null;
        if (th != null) {
            cancellationExceptionA = (CancellationException) (th instanceof CancellationException ? th : null);
            if (cancellationExceptionA == null) {
                cancellationExceptionA = a("Channel was consumed, consumer had failed", th);
            }
        }
        oVar.b(cancellationExceptionA);
    }

    public static final void u0(CoroutineContext coroutineContext, Throwable th) {
        try {
            int i = CoroutineExceptionHandler.g;
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler$a.a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                b0.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                d0.b.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            b0.a(coroutineContext, th);
        }
    }

    public static String u1(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (c2 >= 'A' && c2 <= 'Z') {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String u2(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return l2("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return l2("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(b.d.b.a.a.g(26, "negative size: ", i2));
    }

    public static void v(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static int v0(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static final <T> Object v1(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable thM99exceptionOrNullimpl = d0.k.m99exceptionOrNullimpl(obj);
        if (thM99exceptionOrNullimpl == null) {
            return function1 != null ? new s.a.x(obj, function1) : obj;
        }
        return new w(thM99exceptionOrNullimpl, false, 2);
    }

    public static int v2(byte[] bArr, int i, s3 s3Var) throws zzij {
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a;
        if (i2 < 0) {
            throw zzij.b();
        }
        if (i2 > bArr.length - iO1) {
            throw zzij.a();
        }
        if (i2 == 0) {
            s3Var.c = t3.j;
            return iO1;
        }
        s3Var.c = t3.h(bArr, iO1, i2);
        return iO1 + i2;
    }

    public static void w(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static /* synthetic */ m0 w0(Job job, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return job.n(z2, z3, function1);
    }

    public static String w1(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (c2 >= 'a' && c2 <= 'z') {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static boolean w2(byte b2) {
        return b2 > -65;
    }

    @CanIgnoreReturnValue
    public static int x(int i, int i2) {
        String strI0;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strI0 = I0("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.q("negative size: ", i2));
            }
            strI0 = I0("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strI0);
    }

    public static m0 x0(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return s.a.e0.a.x(j, runnable, coroutineContext);
    }

    @NonNull
    public static b.o.a.n.o.e x1(@NonNull b.o.a.n.o.e... eVarArr) {
        return new b.o.a.n.o.j(Arrays.asList(eVarArr));
    }

    public static int x2(String str) {
        if (Log.isLoggable("FirebaseAppIndex", 3) ? true : Log.isLoggable("FirebaseAppIndex", 3)) {
            return Log.d("FirebaseAppIndex", str);
        }
        return 0;
    }

    @CanIgnoreReturnValue
    public static Object y(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(b.d.b.a.a.q("at index ", i));
    }

    public static final boolean y0(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.h);
        if (job != null) {
            return job.a();
        }
        return true;
    }

    public static RectF y1(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float fRound = Math.round(fArr[i - 1] * 10.0f) / 10.0f;
            float fRound2 = Math.round(fArr[i] * 10.0f) / 10.0f;
            float f = rectF.left;
            if (fRound < f) {
                f = fRound;
            }
            rectF.left = f;
            float f2 = rectF.top;
            if (fRound2 < f2) {
                f2 = fRound2;
            }
            rectF.top = f2;
            float f3 = rectF.right;
            if (fRound <= f3) {
                fRound = f3;
            }
            rectF.right = fRound;
            float f4 = rectF.bottom;
            if (fRound2 <= f4) {
                fRound2 = f4;
            }
            rectF.bottom = fRound2;
        }
        rectF.sort();
        return rectF;
    }

    public static void z(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(b.d.b.a.a.v("null key in entry: null=", obj2));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static final boolean z0(AssertionError assertionError) {
        m.checkParameterIsNotNull(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? d0.g0.w.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    @TargetApi(19)
    public static boolean z1(@RecentlyNonNull Context context, int i, @RecentlyNonNull String str) {
        b.i.a.f.e.p.a aVarA = b.i.a.f.e.p.b.a(context);
        Objects.requireNonNull(aVarA);
        try {
            AppOpsManager appOpsManager = (AppOpsManager) aVarA.a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
