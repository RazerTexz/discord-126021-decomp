package p007b.p225i.p226a.p288f.p299e.p308o;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Binder;
import android.os.Build;
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
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.android.gms.common.C10800R;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.C3260e;
import p007b.p225i.p226a.p288f.p299e.C3262f;
import p007b.p225i.p226a.p288f.p299e.p310p.C3410a;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3581a3;
import p007b.p225i.p226a.p288f.p313h.p325l.C3599b7;
import p007b.p225i.p226a.p288f.p313h.p325l.C3609c3;
import p007b.p225i.p226a.p288f.p313h.p325l.C3613c7;
import p007b.p225i.p226a.p288f.p313h.p325l.C3640e6;
import p007b.p225i.p226a.p288f.p313h.p325l.C3724k7;
import p007b.p225i.p226a.p288f.p313h.p325l.C3824s3;
import p007b.p225i.p226a.p288f.p313h.p325l.C3877w4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3890x4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3915z3;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3622d2;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3914z2;
import p007b.p225i.p226a.p288f.p330i.p332b.C4051ga;
import p007b.p225i.p226a.p288f.p330i.p332b.C4157q3;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4363g;
import p007b.p225i.p226a.p288f.p340n.C4364h;
import p007b.p225i.p226a.p288f.p340n.C4366j;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4365i;
import p007b.p225i.p226a.p288f.p340n.RunnableC4360d0;
import p007b.p225i.p226a.p341g.p345d.C4400k;
import p007b.p225i.p226a.p341g.p345d.C4401l;
import p007b.p225i.p355b.p357b.C4507h;
import p007b.p225i.p355b.p357b.C4520n0;
import p007b.p225i.p355b.p358c.C4538a;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4574f;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p007b.p225i.p361c.p369m.p370d.p373k.C4656t0;
import p007b.p225i.p361c.p369m.p370d.p373k.ThreadFactoryC4654s0;
import p007b.p225i.p361c.p407x.AbstractC4893e;
import p007b.p225i.p361c.p407x.C4889a;
import p007b.p225i.p361c.p407x.InterfaceC4895g;
import p007b.p225i.p408d.C4906j;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.C5150j;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p453a.p473x.C5243i;
import p007b.p452o.p453a.p473x.C5245k;
import p007b.p452o.p453a.p473x.C5246l;
import p007b.p452o.p453a.p473x.InterfaceC5237c;
import p007b.p452o.p453a.p473x.InterfaceC5244j;
import p007b.p483p.p484a.ViewOnClickListenerC5272b;
import p507d0.C11211b;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p584w.C12179f;
import p507d0.p584w.InterfaceC12177d;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.C12185b;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.AbstractC12277a;
import p600f0.p601e0.p604f.C12279c;
import p600f0.p601e0.p604f.C12280d;
import p615g0.C12386c;
import p615g0.C12387d;
import p615g0.C12388e;
import p615g0.C12397n;
import p615g0.C12399p;
import p615g0.C12404u;
import p615g0.C12406w;
import p615g0.InterfaceC12405v;
import p615g0.InterfaceC12407x;
import p615g0.p616z.C12410b;
import p617h0.p618a.p619a.C12414c;
import p637j0.InterfaceC12581g;
import p658rx.exceptions.CompositeException;
import p658rx.exceptions.OnCompletedFailedException;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.exceptions.OnErrorThrowable;
import p659s.p660a.AbstractC13045b;
import p659s.p660a.AbstractC13121j0;
import p659s.p660a.C13046b0;
import p659s.p660a.C13051c;
import p659s.p660a.C13076d;
import p659s.p660a.C13093e0;
import p659s.p660a.C13110f1;
import p659s.p660a.C13112g0;
import p659s.p660a.C13118i0;
import p659s.p660a.C13119i1;
import p659s.p660a.C13122j1;
import p659s.p660a.C13124k0;
import p659s.p660a.C13125k1;
import p659s.p660a.C13126l;
import p659s.p660a.C13152t1;
import p659s.p660a.C13155u1;
import p659s.p660a.C13156v;
import p659s.p660a.C13159w;
import p659s.p660a.C13162x;
import p659s.p660a.C13168z;
import p659s.p660a.C13170z1;
import p659s.p660a.InterfaceC13109f0;
import p659s.p660a.InterfaceC13115h0;
import p659s.p660a.InterfaceC13130m0;
import p659s.p660a.InterfaceC13153u;
import p659s.p660a.p661a.C13018a;
import p659s.p660a.p661a.C13023f;
import p659s.p660a.p661a.C13024g;
import p659s.p660a.p661a.C13025h;
import p659s.p660a.p661a.C13035r;
import p659s.p660a.p661a.C13038u;
import p659s.p660a.p663c2.C13057d;
import p659s.p660a.p663c2.C13063j;
import p659s.p660a.p663c2.C13064k;
import p659s.p660a.p663c2.C13070q;
import p659s.p660a.p663c2.EnumC13058e;
import p659s.p660a.p663c2.InterfaceC13059f;
import p659s.p660a.p663c2.InterfaceC13068o;
import p659s.p660a.p663c2.InterfaceC13072s;

/* JADX INFO: renamed from: b.i.a.f.e.o.f */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3404f {

    /* JADX INFO: renamed from: a */
    public static Context f9587a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public static Boolean f9588b;

    /* JADX INFO: renamed from: c */
    public static C4051ga f9589c;

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$a */
    /* JADX INFO: compiled from: SizeSelectors.java */
    public class a implements InterfaceC5244j {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f9590a;

        public a(int i) {
            this.f9590a = i;
        }

        @Override // p007b.p452o.p453a.p473x.InterfaceC5244j
        /* JADX INFO: renamed from: a */
        public boolean mo4369a(@NonNull C5236b c5236b) {
            return c5236b.f14251j <= this.f9590a;
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$b */
    /* JADX INFO: compiled from: SizeSelectors.java */
    public class b implements InterfaceC5244j {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f9591a;

        public b(int i) {
            this.f9591a = i;
        }

        @Override // p007b.p452o.p453a.p473x.InterfaceC5244j
        /* JADX INFO: renamed from: a */
        public boolean mo4369a(@NonNull C5236b c5236b) {
            return c5236b.f14251j >= this.f9591a;
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$c */
    /* JADX INFO: compiled from: SizeSelectors.java */
    public class c implements InterfaceC5244j {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f9592a;

        public c(int i) {
            this.f9592a = i;
        }

        @Override // p007b.p452o.p453a.p473x.InterfaceC5244j
        /* JADX INFO: renamed from: a */
        public boolean mo4369a(@NonNull C5236b c5236b) {
            return c5236b.f14252k <= this.f9592a;
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$d */
    /* JADX INFO: compiled from: SizeSelectors.java */
    public class d implements InterfaceC5244j {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f9593a;

        public d(int i) {
            this.f9593a = i;
        }

        @Override // p007b.p452o.p453a.p473x.InterfaceC5244j
        /* JADX INFO: renamed from: a */
        public boolean mo4369a(@NonNull C5236b c5236b) {
            return c5236b.f14252k >= this.f9593a;
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$e */
    /* JADX INFO: compiled from: Await.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.AwaitKt", m10085f = "Await.kt", m10086l = {26}, m10087m = "awaitAll")
    public static final class e extends AbstractC12187d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public e(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C3404f.m4311l(null, this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$f */
    /* JADX INFO: compiled from: Channels.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", m10085f = "Channels.kt", m10086l = {50, 61}, m10087m = "emitAllImpl$FlowKt__ChannelsKt")
    public static final class f extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public f(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C3404f.m4249U(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$g */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    public static final class g implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Continuation f9594j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Exception f9595k;

        public g(Continuation continuation, Exception exc) {
            this.f9594j = continuation;
            this.f9595k = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Continuation continuationIntercepted = C12182b.intercepted(this.f9594j);
            Exception exc = this.f9595k;
            C12112k.a aVar = C12112k.f25169j;
            continuationIntercepted.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(exc)));
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.o.f$h */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    @InterfaceC12188e(m10084c = "retrofit2.KotlinExtensions", m10085f = "KotlinExtensions.kt", m10086l = {113}, m10087m = "suspendAndThrow")
    public static final class h extends AbstractC12187d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public h(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C3404f.m4301i1(null, this);
        }
    }

    @CanIgnoreReturnValue
    /* JADX INFO: renamed from: A */
    public static int m4189A(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    /* JADX INFO: renamed from: A0 */
    public static boolean m4190A0() {
        return Build.VERSION.SDK_INT >= 26;
    }

    /* JADX INFO: renamed from: A1 */
    public static boolean m4191A1(long j) {
        if (j >= 0) {
            return j != 0;
        }
        throw new IllegalArgumentException(C1643a.m877t("n >= 0 required but it was ", j));
    }

    /* JADX INFO: renamed from: B */
    public static final void m4192B(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    /* JADX INFO: renamed from: B0 */
    public static final boolean m4193B0(int i) {
        return i == 1 || i == 2;
    }

    @NonNull
    /* JADX INFO: renamed from: B1 */
    public static Task<Void> m4194B1(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return m4264Z(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next(), "null tasks are not accepted");
        }
        C4358c0 c4358c0 = new C4358c0();
        C4366j c4366j = new C4366j(collection.size(), c4358c0);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            m4330p2(it2.next(), c4366j);
        }
        return c4358c0;
    }

    @CanIgnoreReturnValue
    /* JADX INFO: renamed from: C */
    public static int m4195C(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m4315m(i, i2, "index"));
        }
        return i;
    }

    /* JADX INFO: renamed from: C0 */
    public static boolean m4196C0(Camera camera) {
        List<String> supportedFlashModes;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && (supportedFlashModes.size() != 1 || !supportedFlashModes.get(0).equals("off"))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: C1 */
    public static final <T> Object m4197C1(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        boolean z2;
        Object objM11314a;
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextPlus = context.plus(coroutineContext);
        Job job = (Job) coroutineContextPlus.get(Job.INSTANCE);
        if (job != null && !job.mo10910a()) {
            throw job.mo10914q();
        }
        if (coroutineContextPlus == context) {
            C13035r c13035r = new C13035r(coroutineContextPlus, continuation);
            objM11314a = m4293g1(c13035r, c13035r, function2);
        } else {
            int i = InterfaceC12177d.f25235e;
            InterfaceC12177d.b bVar = InterfaceC12177d.b.f25236a;
            if (C12238m.areEqual((InterfaceC12177d) coroutineContextPlus.get(bVar), (InterfaceC12177d) context.get(bVar))) {
                C13170z1 c13170z1 = new C13170z1(coroutineContextPlus, continuation);
                Object objM11141b = C13018a.m11141b(coroutineContextPlus, null);
                try {
                    Object objM4293g1 = m4293g1(c13170z1, c13170z1, function2);
                    C13018a.m11140a(coroutineContextPlus, objM11141b);
                    objM11314a = objM4293g1;
                } catch (Throwable th) {
                    C13018a.m11140a(coroutineContextPlus, objM11141b);
                    throw th;
                }
            } else {
                C13118i0 c13118i0 = new C13118i0(coroutineContextPlus, continuation);
                c13118i0.m11187f0();
                m4289f1(function2, c13118i0, c13118i0, null, 4);
                while (true) {
                    int i2 = c13118i0._decision;
                    z2 = false;
                    if (i2 != 0) {
                        if (i2 == 2) {
                            break;
                        }
                        throw new IllegalStateException("Already suspended".toString());
                    }
                    if (C13118i0.f27856n.compareAndSet(c13118i0, 0, 1)) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    objM11314a = C12183c.getCOROUTINE_SUSPENDED();
                } else {
                    objM11314a = C13119i1.m11314a(c13118i0.m11292M());
                    if (objM11314a instanceof C13159w) {
                        throw ((C13159w) objM11314a).f27913b;
                    }
                }
            }
        }
        if (objM11314a == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11314a;
    }

    /* JADX INFO: renamed from: D */
    public static void m4198D(int i, int i2, int i3) {
        String strM4315m;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strM4315m = m4315m(i, i3, "start index");
            } else {
                strM4315m = (i2 < 0 || i2 > i3) ? m4315m(i2, i3, "end index") : m4214I0("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strM4315m);
        }
    }

    /* JADX INFO: renamed from: D0 */
    public static boolean m4199D0(@RecentlyNonNull Context context, int i) {
        if (!m4368z1(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            C3262f c3262fM4021a = C3262f.m4021a(context);
            Objects.requireNonNull(c3262fM4021a);
            if (packageInfo == null) {
                return false;
            }
            if (!C3262f.m4023d(packageInfo, false)) {
                if (!C3262f.m4023d(packageInfo, true)) {
                    return false;
                }
                if (!C3260e.m4019a(c3262fM4021a.f9314b)) {
                    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @NonNull
    /* JADX INFO: renamed from: D1 */
    public static InterfaceC5237c m4200D1(@NonNull InterfaceC5244j interfaceC5244j) {
        return new C5245k(interfaceC5244j, null);
    }

    /* JADX INFO: renamed from: E */
    public static void m4201E(boolean z2) {
        if (!z2) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    /* JADX INFO: renamed from: E0 */
    public static synchronized boolean m4202E0(@RecentlyNonNull Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f9587a;
        if (context2 != null && (bool = f9588b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f9588b = null;
        if (m4190A0()) {
            f9588b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f9588b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f9588b = Boolean.FALSE;
            }
        }
        f9587a = applicationContext;
        return f9588b.booleanValue();
    }

    /* JADX INFO: renamed from: E1 */
    public static <T> Class<T> m4203E1(Class<T> cls) {
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

    /* JADX INFO: renamed from: F */
    public static void m4204F(boolean z2, @NullableDecl String str, int i) {
        if (!z2) {
            throw new IllegalStateException(m4214I0(str, Integer.valueOf(i)));
        }
    }

    /* JADX INFO: renamed from: F0 */
    public static final boolean m4205F0(C12388e c12388e) {
        C12238m.checkParameterIsNotNull(c12388e, "$this$isProbablyUtf8");
        try {
            C12388e c12388e2 = new C12388e();
            c12388e.m10460n(c12388e2, 0L, C11226f.coerceAtMost(c12388e.f26080k, 64L));
            for (int i = 0; i < 16 && !c12388e2.mo10472w(); i++) {
                int iM10434I = c12388e2.m10434I();
                if (Character.isISOControl(iM10434I) && !Character.isWhitespace(iM10434I)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: F1 */
    public static int m4206F1(int i, int i2, @NullableDecl String str) {
        String strM4314l2;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strM4314l2 = m4314l2("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(C1643a.m851g(26, "negative size: ", i2));
            }
            strM4314l2 = m4314l2("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strM4314l2);
    }

    /* JADX INFO: renamed from: G */
    public static void m4207G(boolean z2, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(m4214I0(str, obj));
        }
    }

    /* JADX INFO: renamed from: G0 */
    public static final Job m4208G0(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        CoroutineContext coroutineContextM11354a = C13168z.m11354a(coroutineScope, coroutineContext);
        Objects.requireNonNull(coroutineStart);
        AbstractC13045b c13125k1 = coroutineStart == CoroutineStart.LAZY ? new C13125k1(coroutineContextM11354a, function2) : new C13152t1(coroutineContextM11354a, true);
        c13125k1.m11191j0(coroutineStart, c13125k1, function2);
        return c13125k1;
    }

    /* JADX INFO: renamed from: G1 */
    public static int m4209G1(int i, byte[] bArr, int i2, int i3, C3824s3 c3824s3) throws zzij {
        if ((i >>> 3) == 0) {
            throw zzij.m9105c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return m4322n2(bArr, i2, c3824s3);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return m4233O1(bArr, i2, c3824s3) + c3824s3.f10307a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzij.m9105c();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = m4233O1(bArr, i2, c3824s3);
            i6 = c3824s3.f10307a;
            if (i6 == i5) {
                break;
            }
            i2 = m4209G1(i6, bArr, i2, i3, c3824s3);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzij.m9106d();
        }
        return i2;
    }

    /* JADX INFO: renamed from: H */
    public static int m4210H(long j) {
        int i = (int) j;
        if (((long) i) == j) {
            return i;
        }
        throw new IllegalArgumentException(m4214I0("Out of range: %s", Long.valueOf(j)));
    }

    /* JADX INFO: renamed from: H0 */
    public static /* synthetic */ Job m4211H0(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = C12179f.f25237j;
        }
        return m4208G0(coroutineScope, coroutineContext, (i & 2) != 0 ? CoroutineStart.DEFAULT : null, function2);
    }

    /* JADX INFO: renamed from: H1 */
    public static int m4212H1(int i, byte[] bArr, int i2, int i3, InterfaceC3597b5<?> interfaceC3597b5, C3824s3 c3824s3) {
        C3890x4 c3890x4 = (C3890x4) interfaceC3597b5;
        int iM4233O1 = m4233O1(bArr, i2, c3824s3);
        c3890x4.m5358g(c3824s3.f10307a);
        while (iM4233O1 < i3) {
            int iM4233O2 = m4233O1(bArr, iM4233O1, c3824s3);
            if (i != c3824s3.f10307a) {
                break;
            }
            iM4233O1 = m4233O1(bArr, iM4233O2, c3824s3);
            c3890x4.m5358g(c3824s3.f10307a);
        }
        return iM4233O1;
    }

    /* JADX INFO: renamed from: I */
    public static /* synthetic */ boolean m4213I(InterfaceC13072s interfaceC13072s, Throwable th, int i, Object obj) {
        int i2 = i & 1;
        return interfaceC13072s.mo11221j(null);
    }

    /* JADX INFO: renamed from: I0 */
    public static String m4214I0(@NullableDecl String str, @NullableDecl Object... objArr) {
        int iIndexOf;
        String strValueOf;
        String strValueOf2 = String.valueOf(str);
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            try {
                strValueOf = String.valueOf(obj);
            } catch (Exception e2) {
                String str2 = obj.getClass().getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(obj));
                Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e2);
                strValueOf = "<" + str2 + " threw " + e2.getClass().getName() + ">";
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

    /* JADX INFO: renamed from: I1 */
    public static int m4215I1(int i, byte[] bArr, int i2, int i3, C3613c7 c3613c7, C3824s3 c3824s3) throws zzij {
        if ((i >>> 3) == 0) {
            throw zzij.m9105c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iM4322n2 = m4322n2(bArr, i2, c3824s3);
            c3613c7.m4611a(i, Long.valueOf(c3824s3.f10308b));
            return iM4322n2;
        }
        if (i4 == 1) {
            c3613c7.m4611a(i, Long.valueOf(m4326o2(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iM4233O1 = m4233O1(bArr, i2, c3824s3);
            int i5 = c3824s3.f10307a;
            if (i5 < 0) {
                throw zzij.m9104b();
            }
            if (i5 > bArr.length - iM4233O1) {
                throw zzij.m9103a();
            }
            if (i5 == 0) {
                c3613c7.m4611a(i, AbstractC3837t3.f10322j);
            } else {
                c3613c7.m4611a(i, AbstractC3837t3.m5279h(bArr, iM4233O1, i5));
            }
            return iM4233O1 + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzij.m9105c();
            }
            c3613c7.m4611a(i, Integer.valueOf(m4230N1(bArr, i2)));
            return i2 + 4;
        }
        C3613c7 c3613c7M4610c = C3613c7.m4610c();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i3) {
            int iM4233O2 = m4233O1(bArr, i2, c3824s3);
            int i8 = c3824s3.f10307a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iM4233O2;
                break;
            }
            i7 = i8;
            i2 = m4215I1(i8, bArr, iM4233O2, i3, c3613c7M4610c, c3824s3);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzij.m9106d();
        }
        c3613c7.m4611a(i, c3613c7M4610c);
        return i2;
    }

    /* JADX INFO: renamed from: J */
    public static int m4216J(int i, int i2) {
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

    /* JADX INFO: renamed from: J0 */
    public static final float[] m4217J0(float[] fArr) {
        C12238m.checkNotNullParameter(fArr, "matrix");
        return (float[]) fArr.clone();
    }

    /* JADX INFO: renamed from: J1 */
    public static int m4218J1(int i, byte[] bArr, int i2, C3824s3 c3824s3) {
        int i3 = i & Opcodes.LAND;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            c3824s3.f10307a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & 127) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            c3824s3.f10307a = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            c3824s3.f10307a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            c3824s3.f10307a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c3824s3.f10307a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: renamed from: K */
    public static final byte[] m4219K(String str) {
        int i;
        int i2;
        char cCharAt;
        C12238m.checkParameterIsNotNull(str, "$this$commonAsUtf8ToByteArray");
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
                C12238m.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i3] = (byte) cCharAt2;
            i3++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        C12238m.checkExpressionValueIsNotNull(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    @NonNull
    /* JADX INFO: renamed from: K0 */
    public static InterfaceC5237c m4220K0(int i) {
        return m4200D1(new c(i));
    }

    /* JADX INFO: renamed from: K1 */
    public static int m4221K1(InterfaceC3801q6<?> interfaceC3801q6, int i, byte[] bArr, int i2, int i3, InterfaceC3597b5<?> interfaceC3597b5, C3824s3 c3824s3) throws IOException {
        int iM4227M1 = m4227M1(interfaceC3801q6, bArr, i2, i3, c3824s3);
        interfaceC3597b5.add(c3824s3.f10309c);
        while (iM4227M1 < i3) {
            int iM4233O1 = m4233O1(bArr, iM4227M1, c3824s3);
            if (i != c3824s3.f10307a) {
                break;
            }
            iM4227M1 = m4227M1(interfaceC3801q6, bArr, iM4233O1, i3, c3824s3);
            interfaceC3597b5.add(c3824s3.f10309c);
        }
        return iM4227M1;
    }

    @NonNull
    /* JADX INFO: renamed from: L */
    public static Rect m4222L(@NonNull C5236b c5236b, @NonNull C5235a c5235a) {
        int iRound;
        int i = c5236b.f14251j;
        int i2 = c5236b.f14252k;
        int i3 = 0;
        if (Math.abs(c5235a.m7450i() - C5235a.m7447f(c5236b.f14251j, c5236b.f14252k).m7450i()) <= 5.0E-4f) {
            return new Rect(0, 0, i, i2);
        }
        if (C5235a.m7447f(i, i2).m7450i() > c5235a.m7450i()) {
            int iRound2 = Math.round(c5235a.m7450i() * i2);
            int iRound3 = Math.round((i - iRound2) / 2.0f);
            i = iRound2;
            i3 = iRound3;
            iRound = 0;
        } else {
            int iRound4 = Math.round(i / c5235a.m7450i());
            iRound = Math.round((i2 - iRound4) / 2.0f);
            i2 = iRound4;
        }
        return new Rect(i3, iRound, i + i3, i2 + iRound);
    }

    @NonNull
    /* JADX INFO: renamed from: L0 */
    public static InterfaceC5237c m4223L0(int i) {
        return m4200D1(new a(i));
    }

    /* JADX INFO: renamed from: L1 */
    public static int m4224L1(InterfaceC3801q6 interfaceC3801q6, byte[] bArr, int i, int i2, int i3, C3824s3 c3824s3) throws IOException {
        C3640e6 c3640e6 = (C3640e6) interfaceC3801q6;
        Object objMo4937b = c3640e6.f9925m.mo4937b(c3640e6.f9919g);
        int iM4855m = c3640e6.m4855m(objMo4937b, bArr, i, i2, i3, c3824s3);
        c3640e6.mo4846d(objMo4937b);
        c3824s3.f10309c = objMo4937b;
        return iM4855m;
    }

    /* JADX INFO: renamed from: M */
    public static final <R> Object m4225M(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        C13035r c13035r = new C13035r(continuation.getContext(), continuation);
        Object objM4293g1 = m4293g1(c13035r, c13035r, function2);
        if (objM4293g1 == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM4293g1;
    }

    @NonNull
    /* JADX INFO: renamed from: M0 */
    public static InterfaceC5237c m4226M0(int i) {
        return m4200D1(new d(i));
    }

    /* JADX INFO: renamed from: M1 */
    public static int m4227M1(InterfaceC3801q6 interfaceC3801q6, byte[] bArr, int i, int i2, C3824s3 c3824s3) throws IOException {
        int iM4218J1 = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iM4218J1 = m4218J1(i3, bArr, iM4218J1, c3824s3);
            i3 = c3824s3.f10307a;
        }
        int i4 = iM4218J1;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzij.m9103a();
        }
        Object objMo4843a = interfaceC3801q6.mo4843a();
        int i5 = i3 + i4;
        interfaceC3801q6.mo4850h(objMo4843a, bArr, i4, i5, c3824s3);
        interfaceC3801q6.mo4846d(objMo4843a);
        c3824s3.f10309c = objMo4843a;
        return i5;
    }

    /* JADX INFO: renamed from: N */
    public static C4572d<?> m4228N(String str, String str2) {
        final C4889a c4889a = new C4889a(str, str2);
        C4572d.b bVarM6348a = C4572d.m6348a(AbstractC4893e.class);
        bVarM6348a.f12184d = 1;
        bVarM6348a.m6353c(new InterfaceC4574f(c4889a) { // from class: b.i.c.l.c

            /* JADX INFO: renamed from: a */
            public final Object f12174a;

            {
                this.f12174a = c4889a;
            }

            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                return this.f12174a;
            }
        });
        return bVarM6348a.m6352b();
    }

    @NonNull
    /* JADX INFO: renamed from: N0 */
    public static InterfaceC5237c m4229N0(int i) {
        return m4200D1(new b(i));
    }

    /* JADX INFO: renamed from: N1 */
    public static int m4230N1(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a3 A[LOOP:2: B:24:0x006a->B:49:0x00a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c9 A[LOOP:1: B:60:0x00bc->B:64:0x00c9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:86:0x00cf A[EDGE_INSN: B:86:0x00cf->B:65:0x00cf BREAK  A[LOOP:1: B:60:0x00bc->B:64:0x00c9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x009e A[SYNTHETIC] */
    /* JADX INFO: renamed from: O */
    public static final InetAddress m4231O(String str, int i, int i2) {
        boolean z2;
        int i3;
        int i4;
        char cCharAt;
        int i5;
        int i6;
        int iM10137r;
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
            if (i11 <= i2 && C12103t.startsWith$default(str, "::", i7, false, 4, null)) {
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
                    iM10137r = C12272c.m10137r(str.charAt(i7));
                    if (iM10137r == -1) {
                        break;
                        break;
                    }
                    i5 = (i5 << 4) + iM10137r;
                    i7++;
                }
                i6 = i7 - i10;
                if (i6 != 0) {
                }
                return null;
            }
            if (i8 != 0) {
                if (!C12103t.startsWith$default(str, ":", i7, false, 4, null)) {
                    if (!C12103t.startsWith$default(str, ".", i7, false, 4, null)) {
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
                iM10137r = C12272c.m10137r(str.charAt(i7));
                if (iM10137r == -1) {
                    break;
                }
                i5 = (i5 << 4) + iM10137r;
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

    /* JADX INFO: renamed from: O0 */
    public static /* synthetic */ void m4232O0(FlexInputViewModel flexInputViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        flexInputViewModel.onContentDialogDismissed(z2);
    }

    /* JADX INFO: renamed from: O1 */
    public static int m4233O1(byte[] bArr, int i, C3824s3 c3824s3) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return m4218J1(b2, bArr, i2, c3824s3);
        }
        c3824s3.f10307a = b2;
        return i2;
    }

    /* JADX INFO: renamed from: P */
    public static final Object m4234P(long j, Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.f27425a;
        }
        C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        c13126l.m11318A();
        if (j < RecyclerView.FOREVER_NS) {
            m4300i0(c13126l.f27871o).mo11195c(j, c13126l);
        }
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    /* JADX INFO: renamed from: P0 */
    public static /* synthetic */ void m4235P0(FlexInputViewModel flexInputViewModel, String str, Boolean bool, int i, Object obj) {
        int i2 = i & 2;
        flexInputViewModel.onInputTextChanged(str, null);
    }

    /* JADX INFO: renamed from: P1 */
    public static int m4236P1(byte[] bArr, int i, InterfaceC3597b5<?> interfaceC3597b5, C3824s3 c3824s3) throws IOException {
        C3890x4 c3890x4 = (C3890x4) interfaceC3597b5;
        int iM4233O1 = m4233O1(bArr, i, c3824s3);
        int i2 = c3824s3.f10307a + iM4233O1;
        while (iM4233O1 < i2) {
            iM4233O1 = m4233O1(bArr, iM4233O1, c3824s3);
            c3890x4.m5358g(c3824s3.f10307a);
        }
        if (iM4233O1 == i2) {
            return iM4233O1;
        }
        throw zzij.m9103a();
    }

    /* JADX INFO: renamed from: Q */
    public static float m4237Q(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((f7 * f7) + (f6 * f6));
    }

    @NonNull
    /* JADX INFO: renamed from: Q0 */
    public static InterfaceC5237c m4238Q0(InterfaceC5237c... interfaceC5237cArr) {
        return new C5246l(interfaceC5237cArr, null);
    }

    /* JADX INFO: renamed from: Q1 */
    public static <T> InterfaceC3914z2<T> m4239Q1(InterfaceC3914z2<T> interfaceC3914z2) {
        if ((interfaceC3914z2 instanceof C3609c3) || (interfaceC3914z2 instanceof C3581a3)) {
            return interfaceC3914z2;
        }
        return interfaceC3914z2 instanceof Serializable ? new C3581a3(interfaceC3914z2) : new C3609c3(interfaceC3914z2);
    }

    /* JADX INFO: renamed from: R */
    public static float m4240R(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return (float) Math.sqrt((i6 * i6) + (i5 * i5));
    }

    /* JADX INFO: renamed from: R0 */
    public static int m4241R0(int i) {
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

    /* JADX INFO: renamed from: R1 */
    public static FirebaseAppIndexingException m4242R1(@NonNull Status status, String str) {
        String str2 = status.f20496q;
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        int i = status.f20495p;
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

    /* JADX INFO: renamed from: S */
    public static int m4243S(Context context, float f2) {
        float fApplyDimension = TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
        int i = (int) (((double) fApplyDimension) + 0.5d);
        if (i != 0 || fApplyDimension <= 0.0f) {
            return i;
        }
        return 1;
    }

    /* JADX INFO: renamed from: S0 */
    public static JsonElement m4244S0(JsonReader jsonReader) throws JsonParseException {
        boolean z2;
        try {
            try {
                jsonReader.mo6878N();
                z2 = false;
                try {
                    return TypeAdapters.f21579X.read(jsonReader);
                } catch (EOFException e2) {
                    e = e2;
                    if (z2) {
                        return C4906j.f13106a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e3) {
                e = e3;
                z2 = true;
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    /* JADX INFO: renamed from: S1 */
    public static <T> T m4245S1(@NonNull Bundle bundle, String str, Class<T> cls, T t) {
        T t2 = (T) bundle.get(str);
        if (t2 == null) {
            return t;
        }
        if (cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", str, cls.getCanonicalName(), t2.getClass().getCanonicalName()));
    }

    /* JADX INFO: renamed from: T */
    public static float m4246T(float f2, float f3, float f4, float f5) {
        float f6 = f2 / (f5 / 2.0f);
        float f7 = f4 / 2.0f;
        if (f6 < 1.0f) {
            return (f7 * f6 * f6 * f6) + f3;
        }
        float f8 = f6 - 2.0f;
        return (((f8 * f8 * f8) + 2.0f) * f7) + f3;
    }

    /* JADX INFO: renamed from: T0 */
    public static final Object m4247T0(Object obj, E e2) {
        if (obj == null) {
            return e2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e2);
        return arrayList;
    }

    /* JADX INFO: renamed from: T1 */
    public static <V> V m4248T1(InterfaceC3622d2<V> interfaceC3622d2) {
        try {
            return interfaceC3622d2.mo4628a();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return interfaceC3622d2.mo4628a();
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
    /* JADX INFO: renamed from: U */
    public static final <T> java.lang.Object m4249U(p659s.p660a.p664d2.InterfaceC13083e<? super T> r8, p659s.p660a.p663c2.InterfaceC13068o<? extends T> r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p226a.p288f.p299e.p308o.C3404f.m4249U(s.a.d2.e, s.a.c2.o, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: U0 */
    public static long m4250U0(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == RecyclerView.FOREVER_NS) {
                return RecyclerView.FOREVER_NS;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                throw new IllegalStateException(C1643a.m877t("More produced than requested: ", j3));
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    /* JADX INFO: renamed from: U1 */
    public static <TResult> TResult m4251U1(@NonNull Task<TResult> task) throws ExecutionException {
        if (task.mo6021p()) {
            return task.mo6017l();
        }
        if (task.mo6019n()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.mo6016k());
    }

    /* JADX INFO: renamed from: V */
    public static boolean m4252V(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: V0 */
    public static RuntimeException m4253V0(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    /* JADX INFO: renamed from: V1 */
    public static String m4254V1(Context context, String str) {
        try {
            Objects.requireNonNull(context, "null reference");
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, "string", resources.getResourcePackageName(C10800R.a.common_google_play_services_unknown_issue));
            if (identifier != 0) {
                return resources.getString(identifier);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return null;
    }

    /* JADX INFO: renamed from: W */
    public static <T> T m4255W(@NullableDecl T t, @NullableDecl T t2) {
        if (t != null) {
            return t;
        }
        Objects.requireNonNull(t2, "Both parameters are null");
        return t2;
    }

    /* JADX INFO: renamed from: W0 */
    public static void m4256W0(int i, C12414c c12414c) {
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
                    c12414c.m10535g(i2);
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
                            c12414c.m10537i(i);
                            return;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
            c12414c.m10533e(i2, (i & 16776960) >> 8);
            return;
        }
        c12414c.m10538j(i >>> 16);
    }

    /* JADX INFO: renamed from: W1 */
    public static String m4257W1(AbstractC3837t3 abstractC3837t3) {
        C3599b7 c3599b7 = new C3599b7(abstractC3837t3);
        StringBuilder sb = new StringBuilder(abstractC3837t3.mo5282d());
        for (int i = 0; i < c3599b7.f9858a.mo5282d(); i++) {
            byte bMo5281c = c3599b7.f9858a.mo5281c(i);
            if (bMo5281c == 34) {
                sb.append("\\\"");
            } else if (bMo5281c == 39) {
                sb.append("\\'");
            } else if (bMo5281c != 92) {
                switch (bMo5281c) {
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
                        if (bMo5281c < 32 || bMo5281c > 126) {
                            sb.append('\\');
                            sb.append((char) (((bMo5281c >>> 6) & 3) + 48));
                            sb.append((char) (((bMo5281c >>> 3) & 7) + 48));
                            sb.append((char) ((bMo5281c & 7) + 48));
                        } else {
                            sb.append((char) bMo5281c);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: X */
    public static final FloatBuffer m4258X(int i) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i * 4 * 1).order(ByteOrder.nativeOrder());
        byteBufferOrder.limit(byteBufferOrder.capacity());
        C12238m.checkNotNullExpressionValue(byteBufferOrder, "allocateDirect(size * Egloo.SIZE_OF_BYTE)\n        .order(ByteOrder.nativeOrder())\n        .also { it.limit(it.capacity()) }");
        FloatBuffer floatBufferAsFloatBuffer = byteBufferOrder.asFloatBuffer();
        C12238m.checkNotNullExpressionValue(floatBufferAsFloatBuffer, "byteBuffer(size * Egloo.SIZE_OF_FLOAT).asFloatBuffer()");
        return floatBufferAsFloatBuffer;
    }

    /* JADX INFO: renamed from: X0 */
    public static final <T> Object m4259X0(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof C13159w) {
            C12112k.a aVar = C12112k.f25169j;
            return C12112k.m11474constructorimpl(C12113l.createFailure(((C13159w) obj).f27913b));
        }
        C12112k.a aVar2 = C12112k.f25169j;
        return C12112k.m11474constructorimpl(obj);
    }

    /* JADX INFO: renamed from: X1 */
    public static final String m4260X1(String str) {
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
    /* JADX INFO: renamed from: Y */
    public static <TResult> Task<TResult> m4261Y(@RecentlyNonNull Exception exc) {
        C4358c0 c4358c0 = new C4358c0();
        c4358c0.m6025t(exc);
        return c4358c0;
    }

    /* JADX INFO: renamed from: Y0 */
    public static final <T> void m4262Y0(AbstractC13121j0<? super T> abstractC13121j0, Continuation<? super T> continuation, boolean z2) {
        Object objMo11316j;
        Object objMo11147m = abstractC13121j0.mo11147m();
        Throwable thMo11315e = abstractC13121j0.mo11315e(objMo11147m);
        if (thMo11315e != null) {
            C12112k.a aVar = C12112k.f25169j;
            objMo11316j = C12113l.createFailure(thMo11315e);
        } else {
            C12112k.a aVar2 = C12112k.f25169j;
            objMo11316j = abstractC13121j0.mo11316j(objMo11147m);
        }
        Object objM11474constructorimpl = C12112k.m11474constructorimpl(objMo11316j);
        if (!z2) {
            continuation.resumeWith(objM11474constructorimpl);
            return;
        }
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        C13024g c13024g = (C13024g) continuation;
        CoroutineContext context = c13024g.getContext();
        Object objM11141b = C13018a.m11141b(context, c13024g.f27678p);
        try {
            c13024g.f27680r.resumeWith(objM11474constructorimpl);
        } finally {
            C13018a.m11140a(context, objM11141b);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: Y1 */
    public static String m4263Y1(String str, String[] strArr, String[] strArr2) {
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
    /* JADX INFO: renamed from: Z */
    public static <TResult> Task<TResult> m4264Z(@RecentlyNonNull TResult tresult) {
        C4358c0 c4358c0 = new C4358c0();
        c4358c0.m6024s(tresult);
        return c4358c0;
    }

    /* JADX INFO: renamed from: Z0 */
    public static int m4265Z0(float f2) {
        return (int) (f2 + (f2 < 0.0f ? -0.5f : 0.5f));
    }

    @WorkerThread
    /* JADX INFO: renamed from: Z1 */
    public static Set<String> m4266Z1(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(C1643a.m859k(C1643a.m841b(str, 22), "SELECT * FROM ", str, " LIMIT 0"), null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    /* JADX INFO: renamed from: a */
    public static final CancellationException m4267a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    /* JADX INFO: renamed from: a0 */
    public static final String m4268a0(long j) {
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
        C12238m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a1 */
    public static final int m4269a1(C12404u c12404u, int i) {
        int i2;
        C12238m.checkParameterIsNotNull(c12404u, "$this$segment");
        int[] iArr = c12404u.f26130o;
        int i3 = i + 1;
        int length = c12404u.f26129n.length;
        C12238m.checkParameterIsNotNull(iArr, "$this$binarySearch");
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

    /* JADX INFO: renamed from: a2 */
    public static void m4270a2(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzij {
        if (!m4358w2(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !m4358w2(b4) && !m4358w2(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & AudioAttributesCompat.FLAG_ALL) + 56320);
                return;
            }
        }
        throw zzij.m9107e();
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC13059f m4271b(int i, EnumC13058e enumC13058e, Function1 function1, int i2) {
        EnumC13058e enumC13058e2 = EnumC13058e.SUSPEND;
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            enumC13058e = enumC13058e2;
        }
        int i3 = i2 & 4;
        int i4 = 1;
        if (i == -2) {
            if (enumC13058e == enumC13058e2) {
                Objects.requireNonNull(InterfaceC13059f.f27759i);
                i4 = InterfaceC13059f.a.f27760a;
            }
            return new C13057d(i4, enumC13058e, null);
        }
        if (i == -1) {
            if (enumC13058e == enumC13058e2) {
                return new C13063j(null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i == 0) {
            return enumC13058e == enumC13058e2 ? new C13070q(null) : new C13057d(1, enumC13058e, null);
        }
        if (i != Integer.MAX_VALUE) {
            return (i == 1 && enumC13058e == EnumC13058e.DROP_OLDEST) ? new C13063j(null) : new C13057d(i, enumC13058e, null);
        }
        return new C13064k(null);
    }

    /* JADX INFO: renamed from: b0 */
    public static C4572d<?> m4272b0(final String str, final InterfaceC4895g<Context> interfaceC4895g) {
        C4572d.b bVarM6348a = C4572d.m6348a(AbstractC4893e.class);
        bVarM6348a.f12184d = 1;
        bVarM6348a.m6351a(new C4583o(Context.class, 1, 0));
        bVarM6348a.m6353c(new InterfaceC4574f(str, interfaceC4895g) { // from class: b.i.c.x.f

            /* JADX INFO: renamed from: a */
            public final String f13086a;

            /* JADX INFO: renamed from: b */
            public final InterfaceC4895g f13087b;

            {
                this.f13086a = str;
                this.f13087b = interfaceC4895g;
            }

            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                return new C4889a(this.f13086a, this.f13087b.mo6336a((Context) interfaceC4573e.mo6346a(Context.class)));
            }
        });
        return bVarM6348a.m6352b();
    }

    /* JADX INFO: renamed from: b1 */
    public static final InterfaceC12405v m4273b1(Socket socket) throws IOException {
        C12238m.checkParameterIsNotNull(socket, "$this$sink");
        C12406w c12406w = new C12406w(socket);
        OutputStream outputStream = socket.getOutputStream();
        C12238m.checkExpressionValueIsNotNull(outputStream, "getOutputStream()");
        C12399p c12399p = new C12399p(outputStream, c12406w);
        C12238m.checkParameterIsNotNull(c12399p, "sink");
        return new C12386c(c12406w, c12399p);
    }

    /* JADX INFO: renamed from: b2 */
    public static void m4274b2(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzij {
        if (m4358w2(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || m4358w2(b4)))) {
            throw zzij.m9107e();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    /* JADX INFO: renamed from: c */
    public static final CoroutineScope m4275c(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.INSTANCE) == null) {
            coroutineContext = coroutineContext.plus(new C13110f1(null));
        }
        return new C13023f(coroutineContext);
    }

    /* JADX INFO: renamed from: c0 */
    public static long m4276c0(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, m4287f(j2, j)));
        return j2;
    }

    /* JADX INFO: renamed from: c1 */
    public static int m4277c1(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    /* JADX INFO: renamed from: c2 */
    public static void m4278c2(byte b2, byte b3, char[] cArr, int i) throws zzij {
        if (b2 < -62 || m4358w2(b3)) {
            throw zzij.m9107e();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    /* JADX INFO: renamed from: d */
    public static InterfaceC13153u m4279d(Job job, int i) {
        int i2 = i & 1;
        return new C13155u1(null);
    }

    /* JADX INFO: renamed from: d0 */
    public static float[] m4280d0(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    /* JADX INFO: renamed from: d1 */
    public static final InterfaceC12407x m4281d1(Socket socket) throws IOException {
        C12238m.checkParameterIsNotNull(socket, "$this$source");
        C12406w c12406w = new C12406w(socket);
        InputStream inputStream = socket.getInputStream();
        C12238m.checkExpressionValueIsNotNull(inputStream, "getInputStream()");
        C12397n c12397n = new C12397n(inputStream, c12406w);
        C12238m.checkParameterIsNotNull(c12397n, "source");
        return new C12387d(c12406w, c12397n);
    }

    /* JADX INFO: renamed from: d2 */
    public static void m4282d2(@NonNull Bundle bundle, @NonNull Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }

    /* JADX INFO: renamed from: e */
    public static final void m4283e(AbstractC12277a abstractC12277a, C12279c c12279c, String str) {
        C12280d.b bVar = C12280d.f25422c;
        Logger logger = C12280d.f25421b;
        StringBuilder sb = new StringBuilder();
        sb.append(c12279c.f25419f);
        sb.append(' ');
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        C12238m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(abstractC12277a.f25411c);
        logger.fine(sb.toString());
    }

    /* JADX INFO: renamed from: e0 */
    public static final String m4284e0(Object obj) {
        return obj.getClass().getSimpleName();
    }

    /* JADX INFO: renamed from: e1 */
    public static final void m4285e1(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation continuationIntercepted = C12182b.intercepted(continuation);
            C12112k.a aVar = C12112k.f25169j;
            C13025h.m11149b(continuationIntercepted, C12112k.m11474constructorimpl(Unit.f27425a), null, 2);
        } catch (Throwable th) {
            C12112k.a aVar2 = C12112k.f25169j;
            ((AbstractC13045b) continuation2).resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(th)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x024a  */
    /* JADX WARN: Code duplicated, block: B:116:0x024c  */
    /* JADX INFO: renamed from: e2 */
    public static void m4286e2(InterfaceC3612c6 interfaceC3612c6, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : interfaceC3612c6.getClass().getDeclaredMethods()) {
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
                    m4298h2(sb, i, m4260X1(strConcat), AbstractC3851u4.m5312q(method2, interfaceC3612c6, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strValueOf3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf4 = String.valueOf(strSubstring.substring(1, strSubstring.length() - 3));
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    m4298h2(sb, i, m4260X1(strConcat2), AbstractC3851u4.m5312q(method3, interfaceC3612c6, new Object[0]));
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
                    Object objM5312q = AbstractC3851u4.m5312q(method4, interfaceC3612c6, new Object[0]);
                    if (method5 == null) {
                        if (objM5312q instanceof Boolean) {
                            if (((Boolean) objM5312q).booleanValue()) {
                                zEquals = false;
                            } else {
                                zEquals = true;
                            }
                        } else if (objM5312q instanceof Integer) {
                            if (((Integer) objM5312q).intValue() == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objM5312q instanceof Float) {
                            if (((Float) objM5312q).floatValue() == 0.0f) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objM5312q instanceof Double) {
                            if (((Double) objM5312q).doubleValue() == 0.0d) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objM5312q instanceof String) {
                            zEquals = objM5312q.equals("");
                        } else if (objM5312q instanceof AbstractC3837t3) {
                            zEquals = objM5312q.equals(AbstractC3837t3.f10322j);
                        } else if (!(objM5312q instanceof InterfaceC3612c6) ? !((objM5312q instanceof Enum) && ((Enum) objM5312q).ordinal() == 0) : objM5312q != ((InterfaceC3612c6) objM5312q).mo4633k()) {
                            zEquals = false;
                        } else {
                            zEquals = true;
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) AbstractC3851u4.m5312q(method5, interfaceC3612c6, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        m4298h2(sb, i, m4260X1(strConcat3), objM5312q);
                    }
                }
            }
        }
        if (interfaceC3612c6 instanceof AbstractC3851u4.d) {
            Iterator<Map.Entry<T, Object>> itM5135l = ((AbstractC3851u4.d) interfaceC3612c6).zzc.m5135l();
            if (itM5135l.hasNext()) {
                throw new NoSuchMethodError();
            }
        }
        C3613c7 c3613c7 = ((AbstractC3851u4) interfaceC3612c6).zzb;
        if (c3613c7 != null) {
            for (int i2 = 0; i2 < c3613c7.f9878b; i2++) {
                m4298h2(sb, i, String.valueOf(c3613c7.f9879c[i2] >>> 3), c3613c7.f9880d[i2]);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public static long m4287f(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? RecyclerView.FOREVER_NS : j3;
    }

    /* JADX INFO: renamed from: f0 */
    public static float[] m4288f0(RectF rectF) {
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.right;
        float f5 = rectF.bottom;
        return new float[]{f2, f3, f4, f3, f4, f5, f2, f5};
    }

    /* JADX INFO: renamed from: f1 */
    public static void m4289f1(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i) {
        int i2 = i & 4;
        try {
            Continuation continuationIntercepted = C12182b.intercepted(C12182b.createCoroutineUnintercepted(function2, obj, continuation));
            C12112k.a aVar = C12112k.f25169j;
            C13025h.m11148a(continuationIntercepted, C12112k.m11474constructorimpl(Unit.f27425a), null);
        } catch (Throwable th) {
            C12112k.a aVar2 = C12112k.f25169j;
            continuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(th)));
        }
    }

    /* JADX INFO: renamed from: f2 */
    public static void m4290f2(C4157q3 c4157q3, SQLiteDatabase sQLiteDatabase) {
        if (c4157q3 == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            c4157q3.f11144i.m5860a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            c4157q3.f11144i.m5860a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            c4157q3.f11144i.m5860a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        c4157q3.f11144i.m5860a("Failed to turn on database write permission for owner");
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public static InterfaceC5237c m4291g(InterfaceC5237c... interfaceC5237cArr) {
        return new C5243i(interfaceC5237cArr, null);
    }

    /* JADX INFO: renamed from: g0 */
    public static String m4292g0(long j) {
        return m4296h0(j, null);
    }

    /* JADX INFO: renamed from: g1 */
    public static final <T, R> Object m4293g1(C13035r<? super T> c13035r, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object c13159w;
        Object objM11295R;
        c13035r.m11187f0();
        try {
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            c13159w = ((Function2) C12224e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, c13035r);
            if (c13159w != C12183c.getCOROUTINE_SUSPENDED() && (objM11295R = c13035r.m11295R(c13159w)) != C13119i1.f27858b) {
                if (objM11295R instanceof C13159w) {
                    throw ((C13159w) objM11295R).f27913b;
                }
                return C13119i1.m11314a(objM11295R);
            }
            return C12183c.getCOROUTINE_SUSPENDED();
        } catch (Throwable th) {
            c13159w = new C13159w(th, false, 2);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: g2 */
    public static void m4294g2(C4157q3 c4157q3, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        boolean zMoveToFirst;
        if (c4157q3 == null) {
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
        } catch (SQLiteException e2) {
            c4157q3.f11144i.m5862c("Error querying for table", str, e2);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            zMoveToFirst = false;
        }
        if (!zMoveToFirst) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set<String> setM4266Z1 = m4266Z1(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!((HashSet) setM4266Z1).remove(str4)) {
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
                    if (!((HashSet) setM4266Z1).remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (((HashSet) setM4266Z1).isEmpty()) {
                return;
            }
            c4157q3.f11144i.m5862c("Table has extra columns. table, columns", str, TextUtils.join(", ", setM4266Z1));
        } catch (SQLiteException e3) {
            c4157q3.f11141f.m5861b("Failed to verify columns on table that was just created", str);
            throw e3;
        }
    }

    /* JADX INFO: renamed from: h */
    public static final boolean m4295h(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        C12238m.checkParameterIsNotNull(bArr, "a");
        C12238m.checkParameterIsNotNull(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: h0 */
    public static String m4296h0(long j, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar calendarM6075h = C4401l.m6075h();
        Calendar calendarM6076i = C4401l.m6076i();
        calendarM6076i.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        return calendarM6075h.get(1) == calendarM6076i.get(1) ? m4320n0(j, Locale.getDefault()) : m4340s0(j, Locale.getDefault());
    }

    /* JADX INFO: renamed from: h1 */
    public static int m4297h1(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    /* JADX INFO: renamed from: h2 */
    public static final void m4298h2(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                m4298h2(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m4298h2(sb, i, str, (Map.Entry) it2.next());
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
            AbstractC3837t3 abstractC3837t3 = AbstractC3837t3.f10322j;
            sb.append(m4257W1(new C3915z3(((String) obj).getBytes(C3877w4.f10379a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC3837t3) {
            sb.append(": \"");
            sb.append(m4257W1((AbstractC3837t3) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC3851u4) {
            sb.append(" {");
            m4286e2((AbstractC3851u4) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        m4298h2(sb, i4, "key", entry.getKey());
        m4298h2(sb, i4, "value", entry.getValue());
        sb.append("\n");
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    /* JADX INFO: renamed from: i */
    public static InterfaceC13109f0 m4299i(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        C12179f c12179f = (i & 1) != 0 ? C12179f.f25237j : null;
        CoroutineStart coroutineStart2 = (i & 2) != 0 ? CoroutineStart.DEFAULT : null;
        CoroutineContext coroutineContextM11354a = C13168z.m11354a(coroutineScope, c12179f);
        Objects.requireNonNull(coroutineStart2);
        C13112g0 c13122j1 = coroutineStart2 == CoroutineStart.LAZY ? new C13122j1(coroutineContextM11354a, function2) : new C13112g0(coroutineContextM11354a, true);
        c13122j1.m11191j0(coroutineStart2, c13122j1, function2);
        return c13122j1;
    }

    /* JADX INFO: renamed from: i0 */
    public static final InterfaceC13115h0 m4300i0(CoroutineContext coroutineContext) {
        int i = InterfaceC12177d.f25235e;
        CoroutineContext.Element element = coroutineContext.get(InterfaceC12177d.b.f25236a);
        if (!(element instanceof InterfaceC13115h0)) {
            element = null;
        }
        InterfaceC13115h0 interfaceC13115h0 = (InterfaceC13115h0) element;
        return interfaceC13115h0 != null ? interfaceC13115h0 : C13093e0.f27793a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: i1 */
    public static final Object m4301i1(Exception exc, Continuation<?> continuation) {
        h hVar;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i = hVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                hVar.label = i - Integer.MIN_VALUE;
            } else {
                hVar = new h(continuation);
            }
        } else {
            hVar = new h(continuation);
        }
        Object obj = hVar.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = hVar.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(obj);
            hVar.L$0 = exc;
            hVar.label = 1;
            C13124k0.f27866a.dispatch(hVar.getContext(), new g(hVar, exc));
            Object coroutine_suspended2 = C12183c.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended2 == C12183c.getCOROUTINE_SUSPENDED()) {
                C12190g.probeCoroutineSuspended(hVar);
            }
            if (coroutine_suspended2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
        }
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: i2 */
    public static boolean m4302i2(byte b2) {
        return b2 >= 0;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: j */
    public static <TResult> TResult m4303j(@RecentlyNonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        C1460d.m587x("Must not be called on the main application thread");
        C1460d.m595z(task, "Task must not be null");
        if (task.mo6020o()) {
            return (TResult) m4251U1(task);
        }
        C4364h c4364h = new C4364h(null);
        m4330p2(task, c4364h);
        c4364h.f11481a.await();
        return (TResult) m4251U1(task);
    }

    /* JADX INFO: renamed from: j0 */
    public static final int m4304j0(ViewOnClickListenerC5272b viewOnClickListenerC5272b, @DimenRes int i) {
        C12238m.checkNotNullParameter(viewOnClickListenerC5272b, "$this$getDimenPixelSize");
        return viewOnClickListenerC5272b.getResources().getDimensionPixelSize(i);
    }

    /* JADX INFO: renamed from: j1 */
    public static final long m4305j1(String str, long j, long j2, long j3) {
        String strM4309k1 = m4309k1(str);
        if (strM4309k1 == null) {
            return j;
        }
        Long longOrNull = C12102s.toLongOrNull(strM4309k1);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strM4309k1 + '\'').toString());
        }
        long jLongValue = longOrNull.longValue();
        if (j2 <= jLongValue && j3 >= jLongValue) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    /* JADX INFO: renamed from: j2 */
    public static boolean m4306j2(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: k */
    public static <TResult> TResult m4307k(@RecentlyNonNull Task<TResult> task, long j, @RecentlyNonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C1460d.m587x("Must not be called on the main application thread");
        C1460d.m595z(task, "Task must not be null");
        C1460d.m595z(timeUnit, "TimeUnit must not be null");
        if (task.mo6020o()) {
            return (TResult) m4251U1(task);
        }
        C4364h c4364h = new C4364h(null);
        m4330p2(task, c4364h);
        if (c4364h.f11481a.await(j, timeUnit)) {
            return (TResult) m4251U1(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NullableDecl
    /* JADX INFO: renamed from: k0 */
    public static <T> T m4308k0(Iterable<? extends T> iterable, @NullableDecl T t) {
        C4520n0 c4520n0 = new C4520n0((C4507h.a) iterable);
        return c4520n0.hasNext() ? (T) c4520n0.next() : t;
    }

    /* JADX INFO: renamed from: k1 */
    public static final String m4309k1(String str) {
        int i = C13038u.f27706a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: k2 */
    public static int m4310k2(int i) {
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
    /* JADX INFO: renamed from: l */
    public static final <T> Object m4311l(InterfaceC13109f0<? extends T>[] interfaceC13109f0Arr, Continuation<? super List<? extends T>> continuation) {
        e eVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.label = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        Object objM11326u = eVar.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = eVar.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(objM11326u);
            if (interfaceC13109f0Arr.length == 0) {
                return C12147n.emptyList();
            }
            C13076d c13076d = new C13076d(interfaceC13109f0Arr);
            eVar.L$0 = interfaceC13109f0Arr;
            eVar.label = 1;
            C13126l c13126l = new C13126l(C12182b.intercepted(eVar), 1);
            c13126l.m11318A();
            int length = interfaceC13109f0Arr.length;
            C13076d.a[] aVarArr = new C13076d.a[length];
            for (int i3 = 0; i3 < length; i3++) {
                InterfaceC13109f0<T> interfaceC13109f0 = c13076d.f27773b[C12185b.boxInt(i3).intValue()];
                interfaceC13109f0.start();
                C13076d.a aVar = new C13076d.a(c13126l, interfaceC13109f0);
                aVar.f27774n = interfaceC13109f0.mo10915u(aVar);
                aVarArr[i3] = aVar;
            }
            C13076d.b bVar = new C13076d.b(c13076d, aVarArr);
            for (int i4 = 0; i4 < length; i4++) {
                aVarArr[i4]._disposer = bVar;
            }
            if (c13126l.m11327v()) {
                bVar.m11242b();
            } else {
                c13126l.mo10902f(bVar);
            }
            objM11326u = c13126l.m11326u();
            if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                C12190g.probeCoroutineSuspended(eVar);
            }
            if (objM11326u == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(objM11326u);
        }
        return (List) objM11326u;
    }

    /* JADX INFO: renamed from: l0 */
    public static final String m4312l0(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* JADX INFO: renamed from: l1 */
    public static int m4313l1(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) m4305j1(str, i, i2, i3);
    }

    /* JADX INFO: renamed from: l2 */
    public static String m4314l2(String str, Object... objArr) {
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
                } catch (Exception e2) {
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
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(string2).length() + 9 + name2.length());
                    C1643a.m876s0(sb2, "<", string2, " threw ", name2);
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

    /* JADX INFO: renamed from: m */
    public static String m4315m(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return m4214I0("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return m4214I0("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(C1643a.m871q("negative size: ", i2));
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: m0 */
    public static int m4316m0() {
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

    /* JADX INFO: renamed from: m1 */
    public static /* synthetic */ long m4317m1(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = RecyclerView.FOREVER_NS;
        }
        return m4305j1(str, j, j4, j3);
    }

    /* JADX INFO: renamed from: m2 */
    public static boolean m4318m2(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: n */
    public static ExecutorService m4319n(String str) {
        ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC4654s0(str, new AtomicLong(1L)), new ThreadPoolExecutor.DiscardPolicy()));
        Runtime.getRuntime().addShutdownHook(new Thread(new C4656t0(str, executorServiceUnconfigurableExecutorService, 2L, TimeUnit.SECONDS), C1643a.m883w("Crashlytics Shutdown Hook for ", str)));
        return executorServiceUnconfigurableExecutorService;
    }

    /* JADX INFO: renamed from: n0 */
    public static String m4320n0(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C4401l.m6070c("MMMd", locale).format(new Date(j));
        }
        AtomicReference<C4400k> atomicReference = C4401l.f11617a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(C4401l.m6074g());
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
        String pattern = simpleDateFormat.toPattern();
        int iM6069b = C4401l.m6069b(pattern, "yY", 1, 0);
        if (iM6069b < pattern.length()) {
            int iM6069b2 = C4401l.m6069b(pattern, "EMd", 1, iM6069b);
            pattern = pattern.replace(pattern.substring(C4401l.m6069b(pattern, iM6069b2 < pattern.length() ? "EMd," : "EMd", -1, iM6069b) + 1, iM6069b2), " ").trim();
        }
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(new Date(j));
    }

    /* JADX INFO: renamed from: n1 */
    public static void m4321n1(List<? extends Throwable> list) {
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

    /* JADX INFO: renamed from: n2 */
    public static int m4322n2(byte[] bArr, int i, C3824s3 c3824s3) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c3824s3.f10308b = j;
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
        c3824s3.f10308b = j2;
        return i3;
    }

    @NonNull
    @Deprecated
    /* JADX INFO: renamed from: o */
    public static <TResult> Task<TResult> m4323o(@RecentlyNonNull Executor executor, @RecentlyNonNull Callable<TResult> callable) {
        C1460d.m595z(executor, "Executor must not be null");
        C1460d.m595z(callable, "Callback must not be null");
        C4358c0 c4358c0 = new C4358c0();
        executor.execute(new RunnableC4360d0(c4358c0, callable));
        return c4358c0;
    }

    /* JADX INFO: renamed from: o0 */
    public static final <T> C13126l<T> m4324o0(Continuation<? super T> continuation) {
        C13126l<T> c13126l;
        if (!(continuation instanceof C13024g)) {
            return new C13126l<>(continuation, 2);
        }
        C13024g c13024g = (C13024g) continuation;
        while (true) {
            Object obj = c13024g._reusableCancellableContinuation;
            if (obj == null) {
                c13024g._reusableCancellableContinuation = C13025h.f27682b;
                c13126l = null;
                break;
            }
            if (!(obj instanceof C13126l)) {
                throw new IllegalStateException(C1643a.m881v("Inconsistent state ", obj).toString());
            }
            if (C13024g.f27675m.compareAndSet(c13024g, obj, C13025h.f27682b)) {
                c13126l = (C13126l) obj;
                break;
            }
        }
        if (c13126l != null) {
            Object obj2 = c13126l._state;
            boolean z2 = false;
            if (!(obj2 instanceof C13156v) || ((C13156v) obj2).f27909d == null) {
                c13126l._decision = 0;
                c13126l._state = C13051c.f27726j;
                z2 = true;
            } else {
                c13126l.m11323q();
            }
            C13126l<T> c13126l2 = z2 ? c13126l : null;
            if (c13126l2 != null) {
                return c13126l2;
            }
        }
        return new C13126l<>(continuation, 2);
    }

    /* JADX INFO: renamed from: o1 */
    public static void m4325o1(Throwable th) {
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

    /* JADX INFO: renamed from: o2 */
    public static long m4326o2(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: p */
    public static final <E> UndeliveredElementException m4327p(Function1<? super E, Unit> function1, E e2, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e2);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException(C1643a.m881v("Exception in undelivered element handler for ", e2), th);
            }
            C11211b.addSuppressed(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    /* JADX INFO: renamed from: p0 */
    public static int m4328p0(int[] iArr, int i, boolean z2) {
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
                int iM4216J = m4216J(i10 - 1, i12);
                if (z2 && i6 == 0) {
                    int i13 = i11 - 1;
                    if (i10 - i13 >= i13) {
                        iM4216J -= m4216J(i10 - i11, i12);
                    }
                }
                if (i11 - 1 > 1) {
                    int iM4216J2 = 0;
                    for (int i14 = i10 - i12; i14 > i; i14--) {
                        iM4216J2 += m4216J((i10 - i14) - 1, i11 - 3);
                    }
                    iM4216J -= (i7 - i4) * iM4216J2;
                } else if (i10 > i) {
                    iM4216J--;
                }
                i5 += iM4216J;
                i9++;
                i6 &= ~i8;
                iArr2 = iArr;
            }
            i2 -= i9;
            i4++;
            iArr2 = iArr;
        }
    }

    /* JADX INFO: renamed from: p1 */
    public static void m4329p1(Throwable th, InterfaceC12581g<?> interfaceC12581g, Object obj) {
        m4325o1(th);
        interfaceC12581g.onError(OnErrorThrowable.m11126a(th, obj));
    }

    /* JADX INFO: renamed from: p2 */
    public static <T> void m4330p2(Task<T> task, InterfaceC4365i<? super T> interfaceC4365i) {
        Executor executor = C4363g.f11480b;
        task.mo6012g(executor, interfaceC4365i);
        task.mo6010e(executor, interfaceC4365i);
        task.mo6006a(executor, interfaceC4365i);
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ UndeliveredElementException m4331q(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i) {
        int i2 = i & 2;
        return m4327p(function1, obj, null);
    }

    /* JADX INFO: renamed from: q0 */
    public static int m4332q0(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            return 3;
        }
        return defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 2;
    }

    /* JADX INFO: renamed from: q1 */
    public static int[] m4333q1(Collection<? extends Number> collection) {
        if (collection instanceof C4538a) {
            C4538a c4538a = (C4538a) collection;
            return Arrays.copyOfRange(c4538a.array, c4538a.start, c4538a.end);
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

    /* JADX INFO: renamed from: q2 */
    public static void m4334q2(boolean z2, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: r */
    public static final void m4335r(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
        if (job != null) {
            job.mo10911b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    /* JADX INFO: renamed from: r0 */
    public static DateFormat m4336r0(int i, int i2) {
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
                throw new IllegalArgumentException(C1643a.m871q("Unknown DateFormat style: ", i));
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
                throw new IllegalArgumentException(C1643a.m871q("Unknown DateFormat style: ", i2));
            }
            str2 = "h:mm a";
        }
        sb.append(str2);
        return new SimpleDateFormat(sb.toString(), Locale.US);
    }

    /* JADX INFO: renamed from: r1 */
    public static final String m4337r1(String str) {
        int i;
        C12238m.checkParameterIsNotNull(str, "$this$toCanonicalHost");
        int i2 = 0;
        int i3 = -1;
        if (!C12106w.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            try {
                String ascii = IDN.toASCII(str);
                C12238m.checkExpressionValueIsNotNull(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                C12238m.checkExpressionValueIsNotNull(locale, "Locale.US");
                if (ascii == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                C12238m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                while (i < length) {
                    char cCharAt = lowerCase.charAt(i);
                    i = (cCharAt > 31 && cCharAt < 127 && C12106w.indexOf$default((CharSequence) " #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) == -1) ? i + 1 : 0;
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
        InetAddress inetAddressM4231O = (C12103t.startsWith$default(str, "[", false, 2, null) && C12103t.endsWith$default(str, "]", false, 2, null)) ? m4231O(str, 1, str.length() - 1) : m4231O(str, 0, str.length());
        if (inetAddressM4231O == null) {
            return null;
        }
        byte[] address = inetAddressM4231O.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressM4231O.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        C12238m.checkExpressionValueIsNotNull(address, "address");
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
        C12388e c12388e = new C12388e();
        while (i2 < address.length) {
            if (i2 == i3) {
                c12388e.m10444T(58);
                i2 += i5;
                if (i2 == 16) {
                    c12388e.m10444T(58);
                }
            } else {
                if (i2 > 0) {
                    c12388e.m10444T(58);
                }
                byte b2 = address[i2];
                byte[] bArr = C12272c.f25397a;
                c12388e.mo10441Q(((b2 & 255) << 8) | (address[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return c12388e.m10429D();
    }

    /* JADX INFO: renamed from: r2 */
    public static int m4338r2(byte[] bArr, int i, C3824s3 c3824s3) throws zzij {
        int iM4233O1 = m4233O1(bArr, i, c3824s3);
        int i2 = c3824s3.f10307a;
        if (i2 < 0) {
            throw zzij.m9104b();
        }
        if (i2 == 0) {
            c3824s3.f10309c = "";
            return iM4233O1;
        }
        c3824s3.f10309c = new String(bArr, iM4233O1, i2, C3877w4.f10379a);
        return iM4233O1 + i2;
    }

    /* JADX INFO: renamed from: s */
    public static void m4339s(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            job.mo10911b(null);
        }
    }

    /* JADX INFO: renamed from: s0 */
    public static String m4340s0(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C4401l.m6070c("yMMMd", locale).format(new Date(j));
        }
        AtomicReference<C4400k> atomicReference = C4401l.f11617a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(C4401l.m6074g());
        return dateInstance.format(new Date(j));
    }

    /* JADX INFO: renamed from: s1 */
    public static final String m4341s1(Continuation<?> continuation) {
        Object objM11474constructorimpl;
        if (continuation instanceof C13024g) {
            return continuation.toString();
        }
        try {
            C12112k.a aVar = C12112k.f25169j;
            objM11474constructorimpl = C12112k.m11474constructorimpl(continuation + MentionUtilsKt.MENTIONS_CHAR + m4312l0(continuation));
        } catch (Throwable th) {
            C12112k.a aVar2 = C12112k.f25169j;
            objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
        }
        if (C12112k.m11476exceptionOrNullimpl(objM11474constructorimpl) != null) {
            objM11474constructorimpl = continuation.getClass().getName() + MentionUtilsKt.MENTIONS_CHAR + m4312l0(continuation);
        }
        return (String) objM11474constructorimpl;
    }

    /* JADX INFO: renamed from: s2 */
    public static void m4342s2(int i, int i2, int i3) {
        String strM4350u2;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strM4350u2 = m4350u2(i, i3, "start index");
            } else {
                strM4350u2 = (i2 < 0 || i2 > i3) ? m4350u2(i2, i3, "end index") : m4314l2("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strM4350u2);
        }
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ void m4343t(Job job, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        job.mo10911b(null);
    }

    /* JADX INFO: renamed from: t0 */
    public static void m4344t0(@Nullable InputStream inputStream, @NonNull File file) throws Throwable {
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        gZIPOutputStream2.finish();
                        C4628h.m6410d(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    C4628h.m6410d(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: t1 */
    public static final String m4345t1(byte b2) {
        char[] cArr = C12410b.f26138a;
        return new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]});
    }

    /* JADX INFO: renamed from: t2 */
    public static int m4346t2(byte[] bArr, int i, C3824s3 c3824s3) throws zzij {
        int iM4233O1 = m4233O1(bArr, i, c3824s3);
        int i2 = c3824s3.f10307a;
        if (i2 < 0) {
            throw zzij.m9104b();
        }
        if (i2 == 0) {
            c3824s3.f10309c = "";
            return iM4233O1;
        }
        c3824s3.f10309c = C3724k7.f10058a.mo5057c(bArr, iM4233O1, i2);
        return iM4233O1 + i2;
    }

    /* JADX INFO: renamed from: u */
    public static final void m4347u(InterfaceC13068o<?> interfaceC13068o, Throwable th) {
        CancellationException cancellationExceptionM4267a = null;
        if (th != null) {
            cancellationExceptionM4267a = (CancellationException) (th instanceof CancellationException ? th : null);
            if (cancellationExceptionM4267a == null) {
                cancellationExceptionM4267a = m4267a("Channel was consumed, consumer had failed", th);
            }
        }
        interfaceC13068o.mo11199b(cancellationExceptionM4267a);
    }

    /* JADX INFO: renamed from: u0 */
    public static final void m4348u0(CoroutineContext coroutineContext, Throwable th) {
        try {
            int i = CoroutineExceptionHandler.f27455g;
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.C12804a.f27456a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                C13046b0.m11192a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                C11211b.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            C13046b0.m11192a(coroutineContext, th);
        }
    }

    /* JADX INFO: renamed from: u1 */
    public static String m4349u1(String str) {
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

    /* JADX INFO: renamed from: u2 */
    public static String m4350u2(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return m4314l2("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return m4314l2("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(C1643a.m851g(26, "negative size: ", i2));
    }

    /* JADX INFO: renamed from: v */
    public static void m4351v(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: v0 */
    public static int m4352v0(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: v1 */
    public static final <T> Object m4353v1(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable thM11476exceptionOrNullimpl = C12112k.m11476exceptionOrNullimpl(obj);
        if (thM11476exceptionOrNullimpl == null) {
            return function1 != null ? new C13162x(obj, function1) : obj;
        }
        return new C13159w(thM11476exceptionOrNullimpl, false, 2);
    }

    /* JADX INFO: renamed from: v2 */
    public static int m4354v2(byte[] bArr, int i, C3824s3 c3824s3) throws zzij {
        int iM4233O1 = m4233O1(bArr, i, c3824s3);
        int i2 = c3824s3.f10307a;
        if (i2 < 0) {
            throw zzij.m9104b();
        }
        if (i2 > bArr.length - iM4233O1) {
            throw zzij.m9103a();
        }
        if (i2 == 0) {
            c3824s3.f10309c = AbstractC3837t3.f10322j;
            return iM4233O1;
        }
        c3824s3.f10309c = AbstractC3837t3.m5279h(bArr, iM4233O1, i2);
        return iM4233O1 + i2;
    }

    /* JADX INFO: renamed from: w */
    public static void m4355w(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: w0 */
    public static /* synthetic */ InterfaceC13130m0 m4356w0(Job job, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return job.mo10913n(z2, z3, function1);
    }

    /* JADX INFO: renamed from: w1 */
    public static String m4357w1(String str) {
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

    /* JADX INFO: renamed from: w2 */
    public static boolean m4358w2(byte b2) {
        return b2 > -65;
    }

    @CanIgnoreReturnValue
    /* JADX INFO: renamed from: x */
    public static int m4359x(int i, int i2) {
        String strM4214I0;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strM4214I0 = m4214I0("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(C1643a.m871q("negative size: ", i2));
            }
            strM4214I0 = m4214I0("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strM4214I0);
    }

    /* JADX INFO: renamed from: x0 */
    public static InterfaceC13130m0 m4360x0(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return C13093e0.f27793a.mo11196x(j, runnable, coroutineContext);
    }

    @NonNull
    /* JADX INFO: renamed from: x1 */
    public static AbstractC5145e m4361x1(@NonNull AbstractC5145e... abstractC5145eArr) {
        return new C5150j(Arrays.asList(abstractC5145eArr));
    }

    /* JADX INFO: renamed from: x2 */
    public static int m4362x2(String str) {
        if (Log.isLoggable("FirebaseAppIndex", 3) ? true : Log.isLoggable("FirebaseAppIndex", 3)) {
            return Log.d("FirebaseAppIndex", str);
        }
        return 0;
    }

    @CanIgnoreReturnValue
    /* JADX INFO: renamed from: y */
    public static Object m4363y(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(C1643a.m871q("at index ", i));
    }

    /* JADX INFO: renamed from: y0 */
    public static final boolean m4364y0(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
        if (job != null) {
            return job.mo10910a();
        }
        return true;
    }

    /* JADX INFO: renamed from: y1 */
    public static RectF m4365y1(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float fRound = Math.round(fArr[i - 1] * 10.0f) / 10.0f;
            float fRound2 = Math.round(fArr[i] * 10.0f) / 10.0f;
            float f2 = rectF.left;
            if (fRound < f2) {
                f2 = fRound;
            }
            rectF.left = f2;
            float f3 = rectF.top;
            if (fRound2 < f3) {
                f3 = fRound2;
            }
            rectF.top = f3;
            float f4 = rectF.right;
            if (fRound <= f4) {
                fRound = f4;
            }
            rectF.right = fRound;
            float f5 = rectF.bottom;
            if (fRound2 <= f5) {
                fRound2 = f5;
            }
            rectF.bottom = fRound2;
        }
        rectF.sort();
        return rectF;
    }

    /* JADX INFO: renamed from: z */
    public static void m4366z(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(C1643a.m881v("null key in entry: null=", obj2));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    /* JADX INFO: renamed from: z0 */
    public static final boolean m4367z0(AssertionError assertionError) {
        C12238m.checkParameterIsNotNull(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? C12106w.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    @TargetApi(19)
    /* JADX INFO: renamed from: z1 */
    public static boolean m4368z1(@RecentlyNonNull Context context, int i, @RecentlyNonNull String str) {
        C3410a c3410aM4376a = C3411b.m4376a(context);
        Objects.requireNonNull(c3410aM4376a);
        try {
            AppOpsManager appOpsManager = (AppOpsManager) c3410aM4376a.f9605a.getSystemService("appops");
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
