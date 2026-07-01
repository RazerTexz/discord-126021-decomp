package b.i.a.f.e.h.j;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.i.a.f.e.h.a$a;
import b.i.a.f.e.h.a$b;
import b.i.a.f.e.h.a$d;
import b.i.a.f.e.h.a$f;
import b.i.a.f.e.h.c$b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g$a<O extends a$d> implements b.i.a.f.e.h.c$a, c$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotOnlyInitialized
    public final a$f f1361b;
    public final a$b c;
    public final b<O> d;
    public final x0 e;
    public final int h;

    @Nullable
    public final g0 i;
    public boolean j;
    public final /* synthetic */ g m;
    public final Queue<s> a = new LinkedList();
    public final Set<r0> f = new HashSet();
    public final Map<k$a<?>, d0> g = new HashMap();
    public final List<g$c> k = new ArrayList();

    @Nullable
    public ConnectionResult l = null;

    @WorkerThread
    public g$a(g gVar, b.i.a.f.e.h.b<O> bVar) {
        this.m = gVar;
        Looper looper = gVar.f1359x.getLooper();
        b.i.a.f.e.k.c cVarA = bVar.a().a();
        b.i.a.f.e.h.a<O> aVar = bVar.f1351b;
        b.c.a.a0.d.G(aVar.a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        a$a<?, O> a_a = aVar.a;
        Objects.requireNonNull(a_a, "null reference");
        a$f a_fA = a_a.a(bVar.a, looper, cVarA, bVar.c, this, this);
        this.f1361b = a_fA;
        if (a_fA instanceof b.i.a.f.e.k.y) {
            throw new NoSuchMethodError();
        }
        this.c = a_fA;
        this.d = bVar.d;
        this.e = new x0();
        this.h = bVar.f;
        if (a_fA.o()) {
            this.i = new g0(gVar.o, gVar.f1359x, bVar.a().a());
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
    public final void b() throws PackageManager$NameNotFoundException {
        b.c.a.a0.d.s(this.m.f1359x);
        Status status = g.j;
        f(status);
        x0 x0Var = this.e;
        Objects.requireNonNull(x0Var);
        x0Var.a(false, status);
        for (k$a k_a : (k$a[]) this.g.keySet().toArray(new k$a[0])) {
            j(new p0(k_a, new TaskCompletionSource()));
        }
        n(new ConnectionResult(4));
        if (this.f1361b.j()) {
            this.f1361b.i(new x(this));
        }
    }

    @Override // b.i.a.f.e.h.j.f
    public final void c(int i) {
        if (Looper.myLooper() == this.m.f1359x.getLooper()) {
            d(i);
        } else {
            this.m.f1359x.post(new v(this, i));
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
        Handler handler = this.m.f1359x;
        Message messageObtain = Message.obtain(handler, 9, this.d);
        Objects.requireNonNull(this.m);
        handler.sendMessageDelayed(messageObtain, 5000L);
        Handler handler2 = this.m.f1359x;
        Message messageObtain2 = Message.obtain(handler2, 11, this.d);
        Objects.requireNonNull(this.m);
        handler2.sendMessageDelayed(messageObtain2, 120000L);
        this.m.q.a.clear();
        Iterator<d0> it = this.g.values().iterator();
        while (it.hasNext()) {
            it.next().c.run();
        }
    }

    @WorkerThread
    public final void e(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
        b.i.a.f.l.f fVar;
        b.c.a.a0.d.s(this.m.f1359x);
        g0 g0Var = this.i;
        if (g0Var != null && (fVar = g0Var.g) != null) {
            fVar.h();
        }
        q();
        this.m.q.a.clear();
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
            b.c.a.a0.d.s(this.m.f1359x);
            h(null, exc, false);
            return;
        }
        if (!this.m.f1360y) {
            Status statusP = p(connectionResult);
            b.c.a.a0.d.s(this.m.f1359x);
            h(statusP, null, false);
            return;
        }
        h(p(connectionResult), null, true);
        if (this.a.isEmpty() || l(connectionResult) || this.m.c(connectionResult, this.h)) {
            return;
        }
        if (connectionResult.l == 18) {
            this.j = true;
        }
        if (!this.j) {
            Status statusP2 = p(connectionResult);
            b.c.a.a0.d.s(this.m.f1359x);
            h(statusP2, null, false);
        } else {
            Handler handler = this.m.f1359x;
            Message messageObtain = Message.obtain(handler, 9, this.d);
            Objects.requireNonNull(this.m);
            handler.sendMessageDelayed(messageObtain, 5000L);
        }
    }

    @WorkerThread
    public final void f(Status status) {
        b.c.a.a0.d.s(this.m.f1359x);
        h(status, null, false);
    }

    @Override // b.i.a.f.e.h.j.l
    @WorkerThread
    public final void g(@NonNull ConnectionResult connectionResult) {
        e(connectionResult, null);
    }

    @WorkerThread
    public final void h(@Nullable Status status, @Nullable Exception exc, boolean z2) {
        b.c.a.a0.d.s(this.m.f1359x);
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
        if (Looper.myLooper() == this.m.f1359x.getLooper()) {
            t();
        } else {
            this.m.f1359x.post(new u(this));
        }
    }

    @WorkerThread
    public final void j(s sVar) throws PackageManager$NameNotFoundException {
        b.c.a.a0.d.s(this.m.f1359x);
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
        b.c.a.a0.d.s(this.m.f1359x);
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
            g gVar = this.m;
            if (gVar.u == null || !gVar.v.contains(this.d)) {
                return false;
            }
            this.m.u.n(connectionResult, this.h);
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
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str, name.length() + 77), name, " could not execute call because it requires feature (", str, ", ");
        sbS.append(jW0);
        sbS.append(").");
        Log.w("GoogleApiManager", sbS.toString());
        if (!this.m.f1360y || !m0Var.g(this)) {
            m0Var.e(new UnsupportedApiCallException(featureA));
            return true;
        }
        g$c g_c = new g$c(this.d, featureA, null);
        int iIndexOf = this.k.indexOf(g_c);
        if (iIndexOf >= 0) {
            g$c g_c2 = this.k.get(iIndexOf);
            this.m.f1359x.removeMessages(15, g_c2);
            Handler handler = this.m.f1359x;
            Message messageObtain = Message.obtain(handler, 15, g_c2);
            Objects.requireNonNull(this.m);
            handler.sendMessageDelayed(messageObtain, 5000L);
            return false;
        }
        this.k.add(g_c);
        Handler handler2 = this.m.f1359x;
        Message messageObtain2 = Message.obtain(handler2, 15, g_c);
        Objects.requireNonNull(this.m);
        handler2.sendMessageDelayed(messageObtain2, 5000L);
        Handler handler3 = this.m.f1359x;
        Message messageObtain3 = Message.obtain(handler3, 16, g_c);
        Objects.requireNonNull(this.m);
        handler3.sendMessageDelayed(messageObtain3, 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (l(connectionResult)) {
            return false;
        }
        this.m.c(connectionResult, this.h);
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
        if (b.c.a.a0.d.h0(connectionResult, ConnectionResult.j)) {
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
        return new Status(17, b.d.b.a.a.l(strValueOf.length() + b.d.b.a.a.b(str, 63), "API: ", str, " is not available on this device. Connection failed with: ", strValueOf));
    }

    @WorkerThread
    public final void q() {
        b.c.a.a0.d.s(this.m.f1359x);
        this.l = null;
    }

    @WorkerThread
    public final void r() throws PackageManager$NameNotFoundException {
        b.c.a.a0.d.s(this.m.f1359x);
        if (this.f1361b.j() || this.f1361b.e()) {
            return;
        }
        try {
            g gVar = this.m;
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
            g gVar2 = this.m;
            a$f a_f = this.f1361b;
            g$b g_b = new g$b(gVar2, a_f, this.d);
            if (a_f.o()) {
                g0 g0Var = this.i;
                Objects.requireNonNull(g0Var, "null reference");
                b.i.a.f.l.f fVar = g0Var.g;
                if (fVar != null) {
                    fVar.h();
                }
                g0Var.f.h = Integer.valueOf(System.identityHashCode(g0Var));
                a$a<? extends b.i.a.f.l.f, b.i.a.f.l.a> a_a = g0Var.d;
                Context context = g0Var.f1364b;
                Looper looper = g0Var.c.getLooper();
                b.i.a.f.e.k.c cVar = g0Var.f;
                g0Var.g = (b.i.a.f.l.f) a_a.a(context, looper, cVar, cVar.g, g0Var, g0Var);
                g0Var.h = g_b;
                Set<Scope> set = g0Var.e;
                if (set == null || set.isEmpty()) {
                    g0Var.c.post(new f0(g0Var));
                } else {
                    g0Var.g.p();
                }
            }
            try {
                this.f1361b.g(g_b);
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
                    m<a$b, ?> mVar = next.a;
                    a$b a_b = this.c;
                    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                    b.i.a.f.j.b.e.v vVar = (b.i.a.f.j.b.e.v) mVar;
                    Objects.requireNonNull(vVar);
                    vVar.f1586b.a((b.i.a.f.j.b.e.f) a_b, b.i.a.f.j.b.e.i.j(vVar.c, taskCompletionSource));
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
            this.m.f1359x.removeMessages(11, this.d);
            this.m.f1359x.removeMessages(9, this.d);
            this.j = false;
        }
    }

    public final void w() {
        this.m.f1359x.removeMessages(12, this.d);
        Handler handler = this.m.f1359x;
        handler.sendMessageDelayed(handler.obtainMessage(12, this.d), this.m.n);
    }
}
