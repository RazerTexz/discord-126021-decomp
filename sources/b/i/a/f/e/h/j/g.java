package b.i.a.f.e.h.j;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Handler;
import android.os.Handler$Callback;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g implements Handler$Callback {
    public static final Status j = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status k = new Status(4, "The user must be signed in to make this API call.");
    public static final Object l = new Object();

    @Nullable
    public static g m;
    public final Context o;
    public final GoogleApiAvailability p;
    public final b.i.a.f.e.k.r q;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotOnlyInitialized
    public final Handler f1359x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f1360y;
    public long n = 10000;
    public final AtomicInteger r = new AtomicInteger(1);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicInteger f1358s = new AtomicInteger(0);
    public final Map<b<?>, g$a<?>> t = new ConcurrentHashMap(5, 0.75f, 1);

    @Nullable
    public a1 u = null;
    public final Set<b<?>> v = new ArraySet();
    public final Set<b<?>> w = new ArraySet();

    public g(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f1360y = true;
        this.o = context;
        b.i.a.f.h.e.c cVar = new b.i.a.f.h.e.c(looper, this);
        this.f1359x = cVar;
        this.p = googleApiAvailability;
        this.q = new b.i.a.f.e.k.r(googleApiAvailability);
        PackageManager packageManager = context.getPackageManager();
        if (b.c.a.a0.d.f == null) {
            b.c.a.a0.d.f = Boolean.valueOf(b.i.a.f.e.o.f.A0() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (b.c.a.a0.d.f.booleanValue()) {
            this.f1360y = false;
        }
        cVar.sendMessage(cVar.obtainMessage(6));
    }

    public static g a(Context context) {
        g gVar;
        synchronized (l) {
            if (m == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = GoogleApiAvailability.c;
                m = new g(applicationContext, looper, GoogleApiAvailability.d);
            }
            gVar = m;
        }
        return gVar;
    }

    public final void b(@NonNull a1 a1Var) {
        synchronized (l) {
            if (this.u != a1Var) {
                this.u = a1Var;
                this.v.clear();
            }
            this.v.addAll(a1Var.o);
        }
    }

    public final boolean c(ConnectionResult connectionResult, int i) {
        PendingIntent activity;
        GoogleApiAvailability googleApiAvailability = this.p;
        Context context = this.o;
        Objects.requireNonNull(googleApiAvailability);
        if (connectionResult.w0()) {
            activity = connectionResult.m;
        } else {
            Intent intentA = googleApiAvailability.a(context, connectionResult.l, null);
            activity = intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 134217728);
        }
        if (activity == null) {
            return false;
        }
        int i2 = connectionResult.l;
        int i3 = GoogleApiActivity.j;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", activity);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", true);
        googleApiAvailability.i(context, i2, PendingIntent.getActivity(context, 0, intent, 134217728));
        return true;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @WorkerThread
    public final g$a<?> d(b.i.a.f.e.h.b<?> bVar) throws PackageManager$NameNotFoundException {
        b<O> bVar2 = bVar.d;
        g$a<?> g_a = this.t.get(bVar2);
        if (g_a == null) {
            g_a = new g$a<>(this, bVar);
            this.t.put((b<?>) bVar2, g_a);
        }
        if (g_a.s()) {
            this.w.add((b<?>) bVar2);
        }
        g_a.r();
        return g_a;
    }

    /* JADX WARN: Code duplicated, block: B:98:0x023a  */
    /* JADX WARN: Code duplicated, block: B:99:0x026e  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v5 b.i.a.f.e.h.j.g$a<?>, still in use, count: 2, list:
          (r4v5 b.i.a.f.e.h.j.g$a<?>) from 0x0232: IGET (r4v5 b.i.a.f.e.h.j.g$a<?>) A[WRAPPED] (LINE:102) b.i.a.f.e.h.j.g$a.h int
          (r4v5 b.i.a.f.e.h.j.g$a<?>) from 0x0238: PHI (r4 I:??) = (r4v2 b.i.a.f.e.h.j.g$a<?>), (r4v5 b.i.a.f.e.h.j.g$a<?>) binds: [B:96:0x0237, B:143:0x0238] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // android.os.Handler$Callback
    @androidx.annotation.WorkerThread
    public boolean handleMessage(android.os.Message r11) {
        /*
            Method dump skipped, instruction units count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.f.e.h.j.g.handleMessage(android.os.Message):boolean");
    }
}
