package p007b.p225i.p226a.p288f.p299e.p304k;

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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3327x;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.RunnableC3325w;

/* JADX INFO: renamed from: b.i.a.f.e.k.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3345b<T extends IInterface> {

    /* JADX INFO: renamed from: a */
    public static final Feature[] f9476a = new Feature[0];

    /* JADX INFO: renamed from: c */
    public C3386v0 f9478c;

    /* JADX INFO: renamed from: d */
    public final Context f9479d;

    /* JADX INFO: renamed from: e */
    public final AbstractC3351e f9480e;

    /* JADX INFO: renamed from: f */
    public final C3256c f9481f;

    /* JADX INFO: renamed from: g */
    public final Handler f9482g;

    /* JADX INFO: renamed from: j */
    @Nullable
    public InterfaceC3359i f9485j;

    /* JADX INFO: renamed from: k */
    @RecentlyNonNull
    public c f9486k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public T f9487l;

    /* JADX INFO: renamed from: n */
    @Nullable
    public ServiceConnectionC3364k0 f9489n;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final a f9491p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public final b f9492q;

    /* JADX INFO: renamed from: r */
    public final int f9493r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public final String f9494s;

    /* JADX INFO: renamed from: b */
    @Nullable
    public volatile String f9477b = null;

    /* JADX INFO: renamed from: h */
    public final Object f9483h = new Object();

    /* JADX INFO: renamed from: i */
    public final Object f9484i = new Object();

    /* JADX INFO: renamed from: m */
    public final ArrayList<AbstractC3360i0<?>> f9488m = new ArrayList<>();

    /* JADX INFO: renamed from: o */
    public int f9490o = 1;

    /* JADX INFO: renamed from: t */
    @Nullable
    public ConnectionResult f9495t = null;

    /* JADX INFO: renamed from: u */
    public boolean f9496u = false;

    /* JADX INFO: renamed from: v */
    @Nullable
    public volatile zzi f9497v = null;

    /* JADX INFO: renamed from: w */
    @RecentlyNonNull
    public AtomicInteger f9498w = new AtomicInteger(0);

    /* JADX INFO: renamed from: b.i.a.f.e.k.b$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface a {
        /* JADX INFO: renamed from: c */
        void mo4144c(int i);

        /* JADX INFO: renamed from: i */
        void mo4145i(@Nullable Bundle bundle);
    }

    /* JADX INFO: renamed from: b.i.a.f.e.k.b$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface b {
        /* JADX INFO: renamed from: g */
        void mo4146g(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* JADX INFO: renamed from: b.i.a.f.e.k.b$c */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface c {
        /* JADX INFO: renamed from: a */
        void mo4103a(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* JADX INFO: renamed from: b.i.a.f.e.k.b$d */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public class d implements c {
        public d() {
        }

        @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b.c
        /* JADX INFO: renamed from: a */
        public final void mo4103a(@RecentlyNonNull ConnectionResult connectionResult) {
            if (connectionResult.m9020x0()) {
                AbstractC3345b abstractC3345b = AbstractC3345b.this;
                abstractC3345b.m4128b(null, abstractC3345b.mo4141v());
            } else {
                b bVar = AbstractC3345b.this.f9492q;
                if (bVar != null) {
                    bVar.mo4146g(connectionResult);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.k.b$e */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface e {
    }

    public AbstractC3345b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull AbstractC3351e abstractC3351e, @RecentlyNonNull C3256c c3256c, int i, @Nullable a aVar, @Nullable b bVar, @Nullable String str) {
        C1460d.m595z(context, "Context must not be null");
        this.f9479d = context;
        C1460d.m595z(looper, "Looper must not be null");
        C1460d.m595z(abstractC3351e, "Supervisor must not be null");
        this.f9480e = abstractC3351e;
        C1460d.m595z(c3256c, "API availability must not be null");
        this.f9481f = c3256c;
        this.f9482g = new HandlerC3358h0(this, looper);
        this.f9493r = i;
        this.f9491p = aVar;
        this.f9492q = bVar;
        this.f9494s = str;
    }

    /* JADX INFO: renamed from: C */
    public static /* synthetic */ void m4122C(AbstractC3345b abstractC3345b, int i) {
        int i2;
        int i3;
        synchronized (abstractC3345b.f9483h) {
            i2 = abstractC3345b.f9490o;
        }
        if (i2 == 3) {
            abstractC3345b.f9496u = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = abstractC3345b.f9482g;
        handler.sendMessage(handler.obtainMessage(i3, abstractC3345b.f9498w.get(), 16));
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ boolean m4123D(AbstractC3345b abstractC3345b) {
        if (abstractC3345b.f9496u || TextUtils.isEmpty(abstractC3345b.mo3984x()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(abstractC3345b.mo3984x());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: E */
    public static /* synthetic */ boolean m4124E(AbstractC3345b abstractC3345b, int i, int i2, IInterface iInterface) {
        synchronized (abstractC3345b.f9483h) {
            if (abstractC3345b.f9490o != i) {
                return false;
            }
            abstractC3345b.m4127F(i2, iInterface);
            return true;
        }
    }

    @CallSuper
    /* JADX INFO: renamed from: A */
    public void m4125A(int i) {
        System.currentTimeMillis();
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: B */
    public final String m4126B() {
        String str = this.f9494s;
        return str == null ? this.f9479d.getClass().getName() : str;
    }

    /* JADX INFO: renamed from: F */
    public final void m4127F(int i, @Nullable T t) {
        C3386v0 c3386v0;
        C1460d.m539l((i == 4) == (t != null));
        synchronized (this.f9483h) {
            try {
                this.f9490o = i;
                this.f9487l = t;
                if (i == 1) {
                    ServiceConnectionC3364k0 serviceConnectionC3364k0 = this.f9489n;
                    if (serviceConnectionC3364k0 != null) {
                        AbstractC3351e abstractC3351e = this.f9480e;
                        String str = this.f9478c.f9572a;
                        Objects.requireNonNull(str, "null reference");
                        Objects.requireNonNull(this.f9478c);
                        String strM4126B = m4126B();
                        Objects.requireNonNull(this.f9478c);
                        abstractC3351e.m4153b(str, "com.google.android.gms", 4225, serviceConnectionC3364k0, strM4126B, false);
                        this.f9489n = null;
                    }
                } else if (i == 2 || i == 3) {
                    ServiceConnectionC3364k0 serviceConnectionC3364k1 = this.f9489n;
                    if (serviceConnectionC3364k1 != null && (c3386v0 = this.f9478c) != null) {
                        String str2 = c3386v0.f9572a;
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 70 + "com.google.android.gms".length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str2);
                        sb.append(" on ");
                        sb.append("com.google.android.gms");
                        Log.e("GmsClient", sb.toString());
                        AbstractC3351e abstractC3351e2 = this.f9480e;
                        String str3 = this.f9478c.f9572a;
                        Objects.requireNonNull(str3, "null reference");
                        Objects.requireNonNull(this.f9478c);
                        String strM4126B2 = m4126B();
                        Objects.requireNonNull(this.f9478c);
                        abstractC3351e2.m4153b(str3, "com.google.android.gms", 4225, serviceConnectionC3364k1, strM4126B2, false);
                        this.f9498w.incrementAndGet();
                    }
                    ServiceConnectionC3364k0 serviceConnectionC3364k2 = new ServiceConnectionC3364k0(this, this.f9498w.get());
                    this.f9489n = serviceConnectionC3364k2;
                    String strMo3985y = mo3985y();
                    Object obj = AbstractC3351e.f9517a;
                    this.f9478c = new C3386v0("com.google.android.gms", strMo3985y, 4225, false);
                    AbstractC3351e abstractC3351e3 = this.f9480e;
                    Objects.requireNonNull(strMo3985y, "null reference");
                    Objects.requireNonNull(this.f9478c);
                    String strM4126B3 = m4126B();
                    Objects.requireNonNull(this.f9478c);
                    if (!abstractC3351e3.mo4154c(new C3376q0(strMo3985y, "com.google.android.gms", 4225, false), serviceConnectionC3364k2, strM4126B3)) {
                        String str4 = this.f9478c.f9572a;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str4).length() + 34 + "com.google.android.gms".length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str4);
                        sb2.append(" on ");
                        sb2.append("com.google.android.gms");
                        Log.e("GmsClient", sb2.toString());
                        int i2 = this.f9498w.get();
                        Handler handler = this.f9482g;
                        handler.sendMessage(handler.obtainMessage(7, i2, -1, new C3368m0(this, 16)));
                    }
                } else if (i == 4) {
                    Objects.requireNonNull(t, "null reference");
                    m4143z(t);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public void m4128b(@Nullable InterfaceC3355g interfaceC3355g, @RecentlyNonNull Set<Scope> set) {
        Bundle bundleMo4140u = mo4140u();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.f9493r, null);
        getServiceRequest.f20530m = this.f9479d.getPackageName();
        getServiceRequest.f20533p = bundleMo4140u;
        if (set != null) {
            getServiceRequest.f20532o = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (mo4042o()) {
            Account accountMo4138s = mo4138s();
            if (accountMo4138s == null) {
                accountMo4138s = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.f20534q = accountMo4138s;
            if (interfaceC3355g != null) {
                getServiceRequest.f20531n = interfaceC3355g.asBinder();
            }
        }
        getServiceRequest.f20535r = f9476a;
        getServiceRequest.f20536s = mo4139t();
        try {
            synchronized (this.f9484i) {
                InterfaceC3359i interfaceC3359i = this.f9485j;
                if (interfaceC3359i != null) {
                    interfaceC3359i.mo4147w(new BinderC3362j0(this, this.f9498w.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Handler handler = this.f9482g;
            handler.sendMessage(handler.obtainMessage(6, this.f9498w.get(), 3));
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i = this.f9498w.get();
            Handler handler2 = this.f9482g;
            handler2.sendMessage(handler2.obtainMessage(1, i, -1, new C3366l0(this, 8, null, null)));
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i2 = this.f9498w.get();
            Handler handler3 = this.f9482g;
            handler3.sendMessage(handler3.obtainMessage(1, i2, -1, new C3366l0(this, 8, null, null)));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m4129c(@RecentlyNonNull String str) {
        this.f9477b = str;
        mo4036h();
    }

    /* JADX INFO: renamed from: e */
    public boolean m4130e() {
        boolean z2;
        synchronized (this.f9483h) {
            int i = this.f9490o;
            z2 = true;
            if (i != 2 && i != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: f */
    public String m4131f() {
        if (!m4134j() || this.f9478c == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return "com.google.android.gms";
    }

    /* JADX INFO: renamed from: g */
    public void m4132g(@RecentlyNonNull c cVar) {
        C1460d.m595z(cVar, "Connection progress callbacks cannot be null.");
        this.f9486k = cVar;
        m4127F(2, null);
    }

    /* JADX INFO: renamed from: h */
    public void mo4036h() {
        this.f9498w.incrementAndGet();
        synchronized (this.f9488m) {
            int size = this.f9488m.size();
            for (int i = 0; i < size; i++) {
                AbstractC3360i0<?> abstractC3360i0 = this.f9488m.get(i);
                synchronized (abstractC3360i0) {
                    abstractC3360i0.f9524a = null;
                }
            }
            this.f9488m.clear();
        }
        synchronized (this.f9484i) {
            this.f9485j = null;
        }
        m4127F(1, null);
    }

    /* JADX INFO: renamed from: i */
    public void m4133i(@RecentlyNonNull e eVar) {
        C3327x c3327x = (C3327x) eVar;
        C3293g.this.f9390x.post(new RunnableC3325w(c3327x));
    }

    /* JADX INFO: renamed from: j */
    public boolean m4134j() {
        boolean z2;
        synchronized (this.f9483h) {
            z2 = this.f9490o == 4;
        }
        return z2;
    }

    /* JADX INFO: renamed from: k */
    public boolean mo4039k() {
        return true;
    }

    /* JADX INFO: renamed from: l */
    public int mo3982l() {
        return C3256c.f9306a;
    }

    @RecentlyNullable
    /* JADX INFO: renamed from: m */
    public final Feature[] m4135m() {
        zzi zziVar = this.f9497v;
        if (zziVar == null) {
            return null;
        }
        return zziVar.f20556k;
    }

    @RecentlyNullable
    /* JADX INFO: renamed from: n */
    public String m4136n() {
        return this.f9477b;
    }

    /* JADX INFO: renamed from: o */
    public boolean mo4042o() {
        return false;
    }

    /* JADX INFO: renamed from: q */
    public void m4137q() throws PackageManager.NameNotFoundException {
        int iMo4018b = this.f9481f.mo4018b(this.f9479d, mo3982l());
        if (iMo4018b == 0) {
            m4132g(new d());
            return;
        }
        m4127F(1, null);
        d dVar = new d();
        C1460d.m595z(dVar, "Connection progress callbacks cannot be null.");
        this.f9486k = dVar;
        Handler handler = this.f9482g;
        handler.sendMessage(handler.obtainMessage(3, this.f9498w.get(), iMo4018b, null));
    }

    @RecentlyNullable
    /* JADX INFO: renamed from: r */
    public abstract T mo3983r(@RecentlyNonNull IBinder iBinder);

    @RecentlyNullable
    /* JADX INFO: renamed from: s */
    public Account mo4138s() {
        return null;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: t */
    public Feature[] mo4139t() {
        return f9476a;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: u */
    public Bundle mo4140u() {
        return new Bundle();
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: v */
    public Set<Scope> mo4141v() {
        return Collections.emptySet();
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: w */
    public final T m4142w() throws DeadObjectException {
        T t;
        synchronized (this.f9483h) {
            try {
                if (this.f9490o == 5) {
                    throw new DeadObjectException();
                }
                if (!m4134j()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                t = this.f9487l;
                C1460d.m595z(t, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    @NonNull
    /* JADX INFO: renamed from: x */
    public abstract String mo3984x();

    @NonNull
    /* JADX INFO: renamed from: y */
    public abstract String mo3985y();

    @CallSuper
    /* JADX INFO: renamed from: z */
    public void m4143z(@RecentlyNonNull T t) {
        System.currentTimeMillis();
    }
}
