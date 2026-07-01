package b.i.a.f.e.k;

import android.accounts.Account;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zzi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T extends IInterface> {
    public static final Feature[] a = new Feature[0];
    public v0 c;
    public final Context d;
    public final b.i.a.f.e.k.e e;
    public final b.i.a.f.e.c f;
    public final Handler g;

    @Nullable
    public i j;

    @RecentlyNonNull
    public c k;

    @Nullable
    public T l;

    @Nullable
    public k0 n;

    @Nullable
    public final a p;

    @Nullable
    public final InterfaceC0037b q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final String f1379s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile String f1378b = null;
    public final Object h = new Object();
    public final Object i = new Object();
    public final ArrayList<i0<?>> m = new ArrayList<>();
    public int o = 1;

    @Nullable
    public ConnectionResult t = null;
    public boolean u = false;

    @Nullable
    public volatile zzi v = null;

    @RecentlyNonNull
    public AtomicInteger w = new AtomicInteger(0);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface a {
        void c(int i);

        void i(@Nullable Bundle bundle);
    }

    /* JADX INFO: renamed from: b.i.a.f.e.k.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface InterfaceC0037b {
        void g(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface c {
        void a(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public class d implements c {
        public d() {
        }

        @Override // b.i.a.f.e.k.b.c
        public final void a(@RecentlyNonNull ConnectionResult connectionResult) {
            if (connectionResult.x0()) {
                b bVar = b.this;
                bVar.b(null, bVar.v());
            } else {
                InterfaceC0037b interfaceC0037b = b.this.q;
                if (interfaceC0037b != null) {
                    interfaceC0037b.g(connectionResult);
                }
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface e {
    }

    public b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull b.i.a.f.e.k.e eVar, @RecentlyNonNull b.i.a.f.e.c cVar, int i, @Nullable a aVar, @Nullable InterfaceC0037b interfaceC0037b, @Nullable String str) {
        AnimatableValueParser.z(context, "Context must not be null");
        this.d = context;
        AnimatableValueParser.z(looper, "Looper must not be null");
        AnimatableValueParser.z(eVar, "Supervisor must not be null");
        this.e = eVar;
        AnimatableValueParser.z(cVar, "API availability must not be null");
        this.f = cVar;
        this.g = new h0(this, looper);
        this.r = i;
        this.p = aVar;
        this.q = interfaceC0037b;
        this.f1379s = str;
    }

    public static /* synthetic */ void C(b bVar, int i) {
        int i2;
        int i3;
        synchronized (bVar.h) {
            i2 = bVar.o;
        }
        if (i2 == 3) {
            bVar.u = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = bVar.g;
        handler.sendMessage(handler.obtainMessage(i3, bVar.w.get(), 16));
    }

    public static /* synthetic */ boolean D(b bVar) {
        if (bVar.u || TextUtils.isEmpty(bVar.x()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(bVar.x());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean E(b bVar, int i, int i2, IInterface iInterface) {
        synchronized (bVar.h) {
            if (bVar.o != i) {
                return false;
            }
            bVar.F(i2, iInterface);
            return true;
        }
    }

    @CallSuper
    public void A(int i) {
        System.currentTimeMillis();
    }

    @RecentlyNonNull
    public final String B() {
        String str = this.f1379s;
        return str == null ? this.d.getClass().getName() : str;
    }

    public final void F(int i, @Nullable T t) {
        v0 v0Var;
        AnimatableValueParser.l((i == 4) == (t != null));
        synchronized (this.h) {
            try {
                this.o = i;
                this.l = t;
                if (i == 1) {
                    k0 k0Var = this.n;
                    if (k0Var != null) {
                        b.i.a.f.e.k.e eVar = this.e;
                        String str = this.c.a;
                        Objects.requireNonNull(str, "null reference");
                        Objects.requireNonNull(this.c);
                        String strB = B();
                        Objects.requireNonNull(this.c);
                        eVar.b(str, "com.google.android.gms", 4225, k0Var, strB, false);
                        this.n = null;
                    }
                } else if (i == 2 || i == 3) {
                    k0 k0Var2 = this.n;
                    if (k0Var2 != null && (v0Var = this.c) != null) {
                        String str2 = v0Var.a;
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 70 + "com.google.android.gms".length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str2);
                        sb.append(" on ");
                        sb.append("com.google.android.gms");
                        Log.e("GmsClient", sb.toString());
                        b.i.a.f.e.k.e eVar2 = this.e;
                        String str3 = this.c.a;
                        Objects.requireNonNull(str3, "null reference");
                        Objects.requireNonNull(this.c);
                        String strB2 = B();
                        Objects.requireNonNull(this.c);
                        eVar2.b(str3, "com.google.android.gms", 4225, k0Var2, strB2, false);
                        this.w.incrementAndGet();
                    }
                    k0 k0Var3 = new k0(this, this.w.get());
                    this.n = k0Var3;
                    String strY = y();
                    Object obj = b.i.a.f.e.k.e.a;
                    this.c = new v0("com.google.android.gms", strY, 4225, false);
                    b.i.a.f.e.k.e eVar3 = this.e;
                    Objects.requireNonNull(strY, "null reference");
                    Objects.requireNonNull(this.c);
                    String strB3 = B();
                    Objects.requireNonNull(this.c);
                    if (!eVar3.c(new q0(strY, "com.google.android.gms", 4225, false), k0Var3, strB3)) {
                        String str4 = this.c.a;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str4).length() + 34 + "com.google.android.gms".length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str4);
                        sb2.append(" on ");
                        sb2.append("com.google.android.gms");
                        Log.e("GmsClient", sb2.toString());
                        int i2 = this.w.get();
                        Handler handler = this.g;
                        handler.sendMessage(handler.obtainMessage(7, i2, -1, new m0(this, 16)));
                    }
                } else if (i == 4) {
                    Objects.requireNonNull(t, "null reference");
                    z(t);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public void b(@Nullable g gVar, @RecentlyNonNull Set<Scope> set) {
        Bundle bundleU = u();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.r, null);
        getServiceRequest.m = this.d.getPackageName();
        getServiceRequest.p = bundleU;
        if (set != null) {
            getServiceRequest.o = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (o()) {
            Account accountS = s();
            if (accountS == null) {
                accountS = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.q = accountS;
            if (gVar != null) {
                getServiceRequest.n = gVar.asBinder();
            }
        }
        getServiceRequest.r = a;
        getServiceRequest.f3005s = t();
        try {
            synchronized (this.i) {
                i iVar = this.j;
                if (iVar != null) {
                    iVar.w(new j0(this, this.w.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Handler handler = this.g;
            handler.sendMessage(handler.obtainMessage(6, this.w.get(), 3));
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i = this.w.get();
            Handler handler2 = this.g;
            handler2.sendMessage(handler2.obtainMessage(1, i, -1, new l0(this, 8, null, null)));
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i2 = this.w.get();
            Handler handler3 = this.g;
            handler3.sendMessage(handler3.obtainMessage(1, i2, -1, new l0(this, 8, null, null)));
        }
    }

    public void c(@RecentlyNonNull String str) {
        this.f1378b = str;
        h();
    }

    public boolean e() {
        boolean z2;
        synchronized (this.h) {
            int i = this.o;
            z2 = true;
            if (i != 2 && i != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    @RecentlyNonNull
    public String f() {
        if (!j() || this.c == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return "com.google.android.gms";
    }

    public void g(@RecentlyNonNull c cVar) {
        AnimatableValueParser.z(cVar, "Connection progress callbacks cannot be null.");
        this.k = cVar;
        F(2, null);
    }

    public void h() {
        this.w.incrementAndGet();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                i0<?> i0Var = this.m.get(i);
                synchronized (i0Var) {
                    i0Var.a = null;
                }
            }
            this.m.clear();
        }
        synchronized (this.i) {
            this.j = null;
        }
        F(1, null);
    }

    public void i(@RecentlyNonNull e eVar) {
        b.i.a.f.e.h.j.x xVar = (b.i.a.f.e.h.j.x) eVar;
        b.i.a.f.e.h.j.g.this.f1359x.post(new b.i.a.f.e.h.j.w(xVar));
    }

    public boolean j() {
        boolean z2;
        synchronized (this.h) {
            z2 = this.o == 4;
        }
        return z2;
    }

    public boolean k() {
        return true;
    }

    public int l() {
        return b.i.a.f.e.c.a;
    }

    @RecentlyNullable
    public final Feature[] m() {
        zzi zziVar = this.v;
        if (zziVar == null) {
            return null;
        }
        return zziVar.k;
    }

    @RecentlyNullable
    public String n() {
        return this.f1378b;
    }

    public boolean o() {
        return false;
    }

    public void q() throws PackageManager.NameNotFoundException {
        int iB = this.f.b(this.d, l());
        if (iB == 0) {
            g(new d());
            return;
        }
        F(1, null);
        d dVar = new d();
        AnimatableValueParser.z(dVar, "Connection progress callbacks cannot be null.");
        this.k = dVar;
        Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(3, this.w.get(), iB, null));
    }

    @RecentlyNullable
    public abstract T r(@RecentlyNonNull IBinder iBinder);

    @RecentlyNullable
    public Account s() {
        return null;
    }

    @RecentlyNonNull
    public Feature[] t() {
        return a;
    }

    @RecentlyNonNull
    public Bundle u() {
        return new Bundle();
    }

    @RecentlyNonNull
    public Set<Scope> v() {
        return Collections.emptySet();
    }

    @RecentlyNonNull
    public final T w() throws DeadObjectException {
        T t;
        synchronized (this.h) {
            try {
                if (this.o == 5) {
                    throw new DeadObjectException();
                }
                if (!j()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                t = this.l;
                AnimatableValueParser.z(t, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    @NonNull
    public abstract String x();

    @NonNull
    public abstract String y();

    @CallSuper
    public void z(@RecentlyNonNull T t) {
        System.currentTimeMillis();
    }
}
