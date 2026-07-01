package b.i.a.f.e.h.j;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.c;
import b.i.a.f.e.h.j.k;
import b.i.a.f.e.k.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g implements Handler.Callback {
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
    public final Map<b.i.a.f.e.h.j.b<?>, a<?>> t = new ConcurrentHashMap(5, 0.75f, 1);

    @Nullable
    public a1 u = null;
    public final Set<b.i.a.f.e.h.j.b<?>> v = new ArraySet();
    public final Set<b.i.a.f.e.h.j.b<?>> w = new ArraySet();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public class a<O extends a.d> implements c.a, c.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotOnlyInitialized
        public final a.f f1361b;
        public final a.b c;
        public final b.i.a.f.e.h.j.b<O> d;
        public final x0 e;
        public final int h;

        @Nullable
        public final g0 i;
        public boolean j;
        public final Queue<s> a = new LinkedList();
        public final Set<r0> f = new HashSet();
        public final Map<k.a<?>, d0> g = new HashMap();
        public final List<c> k = new ArrayList();

        @Nullable
        public ConnectionResult l = null;

        @WorkerThread
        public a(b.i.a.f.e.h.b<O> bVar) {
            Looper looper = g.this.f1359x.getLooper();
            b.i.a.f.e.k.c cVarA = bVar.a().a();
            b.i.a.f.e.h.a<O> aVar = bVar.f1351b;
            AnimatableValueParser.G(aVar.a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
            a.AbstractC0035a<?, O> abstractC0035a = aVar.a;
            Objects.requireNonNull(abstractC0035a, "null reference");
            a.f fVarA = abstractC0035a.a(bVar.a, looper, cVarA, bVar.c, this, this);
            this.f1361b = fVarA;
            if (fVarA instanceof b.i.a.f.e.k.y) {
                throw new NoSuchMethodError();
            }
            this.c = fVarA;
            this.d = bVar.d;
            this.e = new x0();
            this.h = bVar.f;
            if (fVarA.o()) {
                this.i = new g0(g.this.o, g.this.f1359x, bVar.a().a());
            } else {
                this.i = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        @WorkerThread
        public final Feature a(@Nullable Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] featureArrM = this.f1361b.m();
                if (featureArrM == null) {
                    featureArrM = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(featureArrM.length);
                for (Feature feature : featureArrM) {
                    arrayMap.put(feature.j, Long.valueOf(feature.w0()));
                }
                for (Feature feature2 : featureArr) {
                    Long l = (Long) arrayMap.get(feature2.j);
                    if (l == null || l.longValue() < feature2.w0()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        @WorkerThread
        public final void b() {
            AnimatableValueParser.s(g.this.f1359x);
            Status status = g.j;
            f(status);
            x0 x0Var = this.e;
            Objects.requireNonNull(x0Var);
            x0Var.a(false, status);
            for (k.a aVar : (k.a[]) this.g.keySet().toArray(new k.a[0])) {
                j(new p0(aVar, new TaskCompletionSource()));
            }
            n(new ConnectionResult(4));
            if (this.f1361b.j()) {
                this.f1361b.i(new x(this));
            }
        }

        @Override // b.i.a.f.e.h.j.f
        public final void c(int i) {
            if (Looper.myLooper() == g.this.f1359x.getLooper()) {
                d(i);
            } else {
                g.this.f1359x.post(new v(this, i));
            }
        }

        @WorkerThread
        public final void d(int i) {
            q();
            this.j = true;
            x0 x0Var = this.e;
            String strN = this.f1361b.n();
            Objects.requireNonNull(x0Var);
            StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
            if (i == 1) {
                sb.append(" due to service disconnection.");
            } else if (i == 3) {
                sb.append(" due to dead object exception.");
            }
            if (strN != null) {
                sb.append(" Last reason for disconnect: ");
                sb.append(strN);
            }
            x0Var.a(true, new Status(20, sb.toString()));
            Handler handler = g.this.f1359x;
            Message messageObtain = Message.obtain(handler, 9, this.d);
            Objects.requireNonNull(g.this);
            handler.sendMessageDelayed(messageObtain, 5000L);
            Handler handler2 = g.this.f1359x;
            Message messageObtain2 = Message.obtain(handler2, 11, this.d);
            Objects.requireNonNull(g.this);
            handler2.sendMessageDelayed(messageObtain2, 120000L);
            g.this.q.a.clear();
            Iterator<d0> it = this.g.values().iterator();
            while (it.hasNext()) {
                it.next().c.run();
            }
        }

        @WorkerThread
        public final void e(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
            b.i.a.f.l.f fVar;
            AnimatableValueParser.s(g.this.f1359x);
            g0 g0Var = this.i;
            if (g0Var != null && (fVar = g0Var.g) != null) {
                fVar.h();
            }
            q();
            g.this.q.a.clear();
            n(connectionResult);
            if (connectionResult.l == 4) {
                f(g.k);
                return;
            }
            if (this.a.isEmpty()) {
                this.l = connectionResult;
                return;
            }
            if (exc != null) {
                AnimatableValueParser.s(g.this.f1359x);
                h(null, exc, false);
                return;
            }
            if (!g.this.f1360y) {
                Status statusP = p(connectionResult);
                AnimatableValueParser.s(g.this.f1359x);
                h(statusP, null, false);
                return;
            }
            h(p(connectionResult), null, true);
            if (this.a.isEmpty() || l(connectionResult) || g.this.c(connectionResult, this.h)) {
                return;
            }
            if (connectionResult.l == 18) {
                this.j = true;
            }
            if (!this.j) {
                Status statusP2 = p(connectionResult);
                AnimatableValueParser.s(g.this.f1359x);
                h(statusP2, null, false);
            } else {
                Handler handler = g.this.f1359x;
                Message messageObtain = Message.obtain(handler, 9, this.d);
                Objects.requireNonNull(g.this);
                handler.sendMessageDelayed(messageObtain, 5000L);
            }
        }

        @WorkerThread
        public final void f(Status status) {
            AnimatableValueParser.s(g.this.f1359x);
            h(status, null, false);
        }

        @Override // b.i.a.f.e.h.j.l
        @WorkerThread
        public final void g(@NonNull ConnectionResult connectionResult) {
            e(connectionResult, null);
        }

        @WorkerThread
        public final void h(@Nullable Status status, @Nullable Exception exc, boolean z2) {
            AnimatableValueParser.s(g.this.f1359x);
            if ((status == null) == (exc == null)) {
                throw new IllegalArgumentException("Status XOR exception should be null");
            }
            Iterator<s> it = this.a.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z2 || next.a == 2) {
                    if (status != null) {
                        next.b(status);
                    } else {
                        next.e(exc);
                    }
                    it.remove();
                }
            }
        }

        @Override // b.i.a.f.e.h.j.f
        public final void i(@Nullable Bundle bundle) {
            if (Looper.myLooper() == g.this.f1359x.getLooper()) {
                t();
            } else {
                g.this.f1359x.post(new u(this));
            }
        }

        @WorkerThread
        public final void j(s sVar) {
            AnimatableValueParser.s(g.this.f1359x);
            if (this.f1361b.j()) {
                if (m(sVar)) {
                    w();
                    return;
                } else {
                    this.a.add(sVar);
                    return;
                }
            }
            this.a.add(sVar);
            ConnectionResult connectionResult = this.l;
            if (connectionResult == null || !connectionResult.w0()) {
                r();
            } else {
                e(this.l, null);
            }
        }

        @WorkerThread
        public final boolean k(boolean z2) {
            AnimatableValueParser.s(g.this.f1359x);
            if (!this.f1361b.j() || this.g.size() != 0) {
                return false;
            }
            x0 x0Var = this.e;
            if (!((x0Var.a.isEmpty() && x0Var.f1374b.isEmpty()) ? false : true)) {
                this.f1361b.c("Timing out service connection.");
                return true;
            }
            if (z2) {
                w();
            }
            return false;
        }

        @WorkerThread
        public final boolean l(@NonNull ConnectionResult connectionResult) {
            synchronized (g.l) {
                g gVar = g.this;
                if (gVar.u == null || !gVar.v.contains(this.d)) {
                    return false;
                }
                g.this.u.n(connectionResult, this.h);
                return true;
            }
        }

        @WorkerThread
        public final boolean m(s sVar) {
            if (!(sVar instanceof m0)) {
                o(sVar);
                return true;
            }
            m0 m0Var = (m0) sVar;
            Feature featureA = a(m0Var.f(this));
            if (featureA == null) {
                o(sVar);
                return true;
            }
            String name = this.c.getClass().getName();
            String str = featureA.j;
            long jW0 = featureA.w0();
            StringBuilder sbS = outline.S(outline.b(str, name.length() + 77), name, " could not execute call because it requires feature (", str, ", ");
            sbS.append(jW0);
            sbS.append(").");
            Log.w("GoogleApiManager", sbS.toString());
            if (!g.this.f1360y || !m0Var.g(this)) {
                m0Var.e(new UnsupportedApiCallException(featureA));
                return true;
            }
            c cVar = new c(this.d, featureA, null);
            int iIndexOf = this.k.indexOf(cVar);
            if (iIndexOf >= 0) {
                c cVar2 = this.k.get(iIndexOf);
                g.this.f1359x.removeMessages(15, cVar2);
                Handler handler = g.this.f1359x;
                Message messageObtain = Message.obtain(handler, 15, cVar2);
                Objects.requireNonNull(g.this);
                handler.sendMessageDelayed(messageObtain, 5000L);
                return false;
            }
            this.k.add(cVar);
            Handler handler2 = g.this.f1359x;
            Message messageObtain2 = Message.obtain(handler2, 15, cVar);
            Objects.requireNonNull(g.this);
            handler2.sendMessageDelayed(messageObtain2, 5000L);
            Handler handler3 = g.this.f1359x;
            Message messageObtain3 = Message.obtain(handler3, 16, cVar);
            Objects.requireNonNull(g.this);
            handler3.sendMessageDelayed(messageObtain3, 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (l(connectionResult)) {
                return false;
            }
            g.this.c(connectionResult, this.h);
            return false;
        }

        @WorkerThread
        public final void n(ConnectionResult connectionResult) {
            Iterator<r0> it = this.f.iterator();
            if (!it.hasNext()) {
                this.f.clear();
                return;
            }
            r0 next = it.next();
            if (AnimatableValueParser.h0(connectionResult, ConnectionResult.j)) {
                this.f1361b.f();
            }
            Objects.requireNonNull(next);
            throw null;
        }

        @WorkerThread
        public final void o(s sVar) {
            sVar.d(this.e, s());
            try {
                sVar.c(this);
            } catch (DeadObjectException unused) {
                c(1);
                this.f1361b.c("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.c.getClass().getName()), th);
            }
        }

        public final Status p(ConnectionResult connectionResult) {
            String str = this.d.f1354b.c;
            String strValueOf = String.valueOf(connectionResult);
            return new Status(17, outline.l(strValueOf.length() + outline.b(str, 63), "API: ", str, " is not available on this device. Connection failed with: ", strValueOf));
        }

        @WorkerThread
        public final void q() {
            AnimatableValueParser.s(g.this.f1359x);
            this.l = null;
        }

        @WorkerThread
        public final void r() {
            AnimatableValueParser.s(g.this.f1359x);
            if (this.f1361b.j() || this.f1361b.e()) {
                return;
            }
            try {
                g gVar = g.this;
                int iA = gVar.q.a(gVar.o, this.f1361b);
                if (iA != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(iA, null);
                    String name = this.c.getClass().getName();
                    String strValueOf = String.valueOf(connectionResult);
                    StringBuilder sb = new StringBuilder(name.length() + 35 + strValueOf.length());
                    sb.append("The service for ");
                    sb.append(name);
                    sb.append(" is not available: ");
                    sb.append(strValueOf);
                    Log.w("GoogleApiManager", sb.toString());
                    e(connectionResult, null);
                    return;
                }
                g gVar2 = g.this;
                a.f fVar = this.f1361b;
                b bVar = gVar2.new b(fVar, this.d);
                if (fVar.o()) {
                    g0 g0Var = this.i;
                    Objects.requireNonNull(g0Var, "null reference");
                    b.i.a.f.l.f fVar2 = g0Var.g;
                    if (fVar2 != null) {
                        fVar2.h();
                    }
                    g0Var.f.h = Integer.valueOf(System.identityHashCode(g0Var));
                    a.AbstractC0035a<? extends b.i.a.f.l.f, b.i.a.f.l.a> abstractC0035a = g0Var.d;
                    Context context = g0Var.f1364b;
                    Looper looper = g0Var.c.getLooper();
                    b.i.a.f.e.k.c cVar = g0Var.f;
                    g0Var.g = (b.i.a.f.l.f) abstractC0035a.a(context, looper, cVar, cVar.g, g0Var, g0Var);
                    g0Var.h = bVar;
                    Set<Scope> set = g0Var.e;
                    if (set == null || set.isEmpty()) {
                        g0Var.c.post(new f0(g0Var));
                    } else {
                        g0Var.g.p();
                    }
                }
                try {
                    this.f1361b.g(bVar);
                } catch (SecurityException e) {
                    e(new ConnectionResult(10), e);
                }
            } catch (IllegalStateException e2) {
                e(new ConnectionResult(10), e2);
            }
        }

        public final boolean s() {
            return this.f1361b.o();
        }

        @WorkerThread
        public final void t() {
            q();
            n(ConnectionResult.j);
            v();
            Iterator<d0> it = this.g.values().iterator();
            while (it.hasNext()) {
                d0 next = it.next();
                Objects.requireNonNull(next.a);
                if (a(null) != null) {
                    it.remove();
                } else {
                    try {
                        m<a.b, ?> mVar = next.a;
                        a.b bVar = this.c;
                        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                        b.i.a.f.j.b.e.v vVar = (b.i.a.f.j.b.e.v) mVar;
                        Objects.requireNonNull(vVar);
                        vVar.f1586b.a((b.i.a.f.j.b.e.f) bVar, b.i.a.f.j.b.e.i.j(vVar.c, taskCompletionSource));
                    } catch (DeadObjectException unused) {
                        c(3);
                        this.f1361b.c("DeadObjectException thrown while calling register listener method.");
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            u();
            w();
        }

        @WorkerThread
        public final void u() {
            ArrayList arrayList = new ArrayList(this.a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                s sVar = (s) obj;
                if (!this.f1361b.j()) {
                    return;
                }
                if (m(sVar)) {
                    this.a.remove(sVar);
                }
            }
        }

        @WorkerThread
        public final void v() {
            if (this.j) {
                g.this.f1359x.removeMessages(11, this.d);
                g.this.f1359x.removeMessages(9, this.d);
                this.j = false;
            }
        }

        public final void w() {
            g.this.f1359x.removeMessages(12, this.d);
            Handler handler = g.this.f1359x;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.d), g.this.n);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public class b implements h0, b.c {
        public final a.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b.i.a.f.e.h.j.b<?> f1362b;

        @Nullable
        public b.i.a.f.e.k.g c = null;

        @Nullable
        public Set<Scope> d = null;
        public boolean e = false;

        public b(a.f fVar, b.i.a.f.e.h.j.b<?> bVar) {
            this.a = fVar;
            this.f1362b = bVar;
        }

        @Override // b.i.a.f.e.k.b.c
        public final void a(@NonNull ConnectionResult connectionResult) {
            g.this.f1359x.post(new z(this, connectionResult));
        }

        @WorkerThread
        public final void b(ConnectionResult connectionResult) {
            a<?> aVar = g.this.t.get(this.f1362b);
            if (aVar != null) {
                AnimatableValueParser.s(g.this.f1359x);
                a.f fVar = aVar.f1361b;
                String name = aVar.c.getClass().getName();
                String strValueOf = String.valueOf(connectionResult);
                fVar.c(outline.l(strValueOf.length() + name.length() + 25, "onSignInFailed for ", name, " with ", strValueOf));
                aVar.e(connectionResult, null);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class c {
        public final b.i.a.f.e.h.j.b<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Feature f1363b;

        public c(b.i.a.f.e.h.j.b bVar, Feature feature, t tVar) {
            this.a = bVar;
            this.f1363b = feature;
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                if (AnimatableValueParser.h0(this.a, cVar.a) && AnimatableValueParser.h0(this.f1363b, cVar.f1363b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.f1363b});
        }

        public final String toString() {
            b.i.a.f.e.k.j jVar = new b.i.a.f.e.k.j(this);
            jVar.a("key", this.a);
            jVar.a("feature", this.f1363b);
            return jVar.toString();
        }
    }

    public g(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f1360y = true;
        this.o = context;
        b.i.a.f.h.e.c cVar = new b.i.a.f.h.e.c(looper, this);
        this.f1359x = cVar;
        this.p = googleApiAvailability;
        this.q = new b.i.a.f.e.k.r(googleApiAvailability);
        PackageManager packageManager = context.getPackageManager();
        if (AnimatableValueParser.f == null) {
            AnimatableValueParser.f = Boolean.valueOf(b.i.a.f.e.o.f.A0() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (AnimatableValueParser.f.booleanValue()) {
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
    public final a<?> d(b.i.a.f.e.h.b<?> bVar) {
        b.i.a.f.e.h.j.b<O> bVar2 = bVar.d;
        a<?> aVar = this.t.get(bVar2);
        if (aVar == null) {
            aVar = new a<>(bVar);
            this.t.put((b.i.a.f.e.h.j.b<?>) bVar2, aVar);
        }
        if (aVar.s()) {
            this.w.add((b.i.a.f.e.h.j.b<?>) bVar2);
        }
        aVar.r();
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:98:0x023a  */
    /* JADX WARN: Code duplicated, block: B:99:0x026e  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v5 b.i.a.f.e.h.j.g$a<?>, still in use, count: 2, list:
          (r4v5 b.i.a.f.e.h.j.g$a<?>) from 0x0232: IGET (r4v5 b.i.a.f.e.h.j.g$a<?>) A[WRAPPED] (LINE:102) b.i.a.f.e.h.j.g.a.h int
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
    @Override // android.os.Handler.Callback
    @androidx.annotation.WorkerThread
    public boolean handleMessage(android.os.Message r11) {
        /*
            Method dump skipped, instruction units count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.f.e.h.j.g.handleMessage(android.os.Message):boolean");
    }
}
