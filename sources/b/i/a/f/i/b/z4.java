package b.i.a.f.i.b;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class z4 extends l3 {
    public final k9 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f1581b;

    @Nullable
    public String c;

    public z4(k9 k9Var) {
        Objects.requireNonNull(k9Var, "null reference");
        this.a = k9Var;
        this.c = null;
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final String A(zzn zznVar) {
        u0(zznVar);
        k9 k9Var = this.a;
        try {
            return (String) ((FutureTask) k9Var.k.f().t(new o9(k9Var, zznVar))).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            k9Var.k.g().f.c("Failed to get app instance id. appId", q3.s(zznVar.j), e);
            return null;
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void G(long j, String str, String str2, String str3) {
        i(new p5(this, str2, str3, str, j));
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void I(zzn zznVar) {
        t0(zznVar.j, false);
        i(new h5(this, zznVar));
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final List<zzz> J(String str, String str2, String str3) {
        t0(str, true);
        try {
            return (List) ((FutureTask) this.a.f().t(new i5(this, str, str2, str3))).get();
        } catch (InterruptedException | ExecutionException e) {
            this.a.g().f.b("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final List<zzz> K(String str, String str2, zzn zznVar) {
        u0(zznVar);
        try {
            return (List) ((FutureTask) this.a.f().t(new f5(this, zznVar, str, str2))).get();
        } catch (InterruptedException | ExecutionException e) {
            this.a.g().f.b("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final List<zzku> R(String str, String str2, boolean z2, zzn zznVar) {
        u0(zznVar);
        try {
            List<u9> list = (List) ((FutureTask) this.a.f().t(new d5(this, zznVar, str, str2))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (u9 u9Var : list) {
                if (z2 || !t9.r0(u9Var.c)) {
                    arrayList.add(new zzku(u9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.a.g().f.c("Failed to query user properties. appId", q3.s(zznVar.j), e);
            return Collections.emptyList();
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void T(zzn zznVar) {
        u0(zznVar);
        i(new q5(this, zznVar));
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void d0(zzn zznVar) {
        u0(zznVar);
        i(new c5(this, zznVar));
    }

    @BinderThread
    public final void g(zzz zzzVar) {
        Objects.requireNonNull(zzzVar, "null reference");
        Objects.requireNonNull(zzzVar.l, "null reference");
        t0(zzzVar.j, true);
        i(new e5(this, new zzz(zzzVar)));
    }

    public final void i(Runnable runnable) {
        if (this.a.f().y()) {
            runnable.run();
        } else {
            this.a.f().v(runnable);
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final byte[] j(zzaq zzaqVar, String str) {
        b.c.a.a0.d.w(str);
        Objects.requireNonNull(zzaqVar, "null reference");
        t0(str, true);
        this.a.g().m.b("Log and bundle. event", this.a.O().u(zzaqVar.j));
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.k.o);
        long jNanoTime = System.nanoTime() / 1000000;
        r4 r4VarF = this.a.f();
        l5 l5Var = new l5(this, zzaqVar, str);
        r4VarF.o();
        s4<?> s4Var = new s4<>(r4VarF, (Callable<?>) l5Var, true, "Task exception on worker thread");
        if (Thread.currentThread() == r4VarF.d) {
            s4Var.run();
        } else {
            r4VarF.u(s4Var);
        }
        try {
            byte[] bArr = (byte[]) s4Var.get();
            if (bArr == null) {
                this.a.g().f.b("Log and bundle returned null. appId", q3.s(str));
                bArr = new byte[0];
            }
            Objects.requireNonNull((b.i.a.f.e.o.c) this.a.k.o);
            this.a.g().m.d("Log and bundle processed. event, size, time_ms", this.a.O().u(zzaqVar.j), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.a.g().f.d("Failed to log and bundle. appId, event, error", q3.s(str), this.a.O().u(zzaqVar.j), e);
            return null;
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void l0(zzaq zzaqVar, zzn zznVar) {
        Objects.requireNonNull(zzaqVar, "null reference");
        u0(zznVar);
        i(new j5(this, zzaqVar, zznVar));
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void m(zzn zznVar) {
        if (b.i.a.f.h.l.t8.b() && this.a.k.h.o(p.J0)) {
            b.c.a.a0.d.w(zznVar.j);
            Objects.requireNonNull(zznVar.F, "null reference");
            k5 k5Var = new k5(this, zznVar);
            if (this.a.f().y()) {
                k5Var.run();
            } else {
                this.a.f().w(k5Var);
            }
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void m0(Bundle bundle, zzn zznVar) {
        if (b.i.a.f.h.l.ea.b() && this.a.k.h.o(p.A0)) {
            u0(zznVar);
            i(new y4(this, zznVar, bundle));
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void p0(zzku zzkuVar, zzn zznVar) {
        Objects.requireNonNull(zzkuVar, "null reference");
        u0(zznVar);
        i(new o5(this, zzkuVar, zznVar));
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final void q0(zzz zzzVar, zzn zznVar) {
        Objects.requireNonNull(zzzVar, "null reference");
        Objects.requireNonNull(zzzVar.l, "null reference");
        u0(zznVar);
        zzz zzzVar2 = new zzz(zzzVar);
        zzzVar2.j = zznVar.j;
        i(new b5(this, zzzVar2, zznVar));
    }

    @BinderThread
    public final void t0(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.a.g().f.a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z2) {
            try {
                if (this.f1581b == null) {
                    this.f1581b = Boolean.valueOf("com.google.android.gms".equals(this.c) || b.i.a.f.e.o.f.D0(this.a.k.f1570b, Binder.getCallingUid()) || b.i.a.f.e.f.a(this.a.k.f1570b).b(Binder.getCallingUid()));
                }
                if (this.f1581b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.a.g().f.b("Measurement Service called with invalid calling package. appId", q3.s(str));
                throw e;
            }
        }
        if (this.c == null) {
            Context context = this.a.k.f1570b;
            int callingUid = Binder.getCallingUid();
            AtomicBoolean atomicBoolean = b.i.a.f.e.e.a;
            if (b.i.a.f.e.o.f.z1(context, callingUid, str)) {
                this.c = str;
            }
        }
        if (str.equals(this.c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // b.i.a.f.i.b.i3
    @BinderThread
    public final List<zzku> u(String str, String str2, String str3, boolean z2) {
        t0(str, true);
        try {
            List<u9> list = (List) ((FutureTask) this.a.f().t(new g5(this, str, str2, str3))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (u9 u9Var : list) {
                if (z2 || !t9.r0(u9Var.c)) {
                    arrayList.add(new zzku(u9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.a.g().f.c("Failed to get user properties as. appId", q3.s(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void u0(zzn zznVar) {
        Objects.requireNonNull(zznVar, "null reference");
        t0(zznVar.j, false);
        this.a.k.t().c0(zznVar.k, zznVar.A, zznVar.E);
    }
}
