package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3260e;
import p007b.p225i.p226a.p288f.p299e.C3262f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3644ea;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;

/* JADX INFO: renamed from: b.i.a.f.i.b.z4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC4257z4 extends AbstractBinderC4102l3 {

    /* JADX INFO: renamed from: a */
    public final C4097k9 f11390a;

    /* JADX INFO: renamed from: b */
    public Boolean f11391b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public String f11392c;

    public BinderC4257z4(C4097k9 c4097k9) {
        Objects.requireNonNull(c4097k9, "null reference");
        this.f11390a = c4097k9;
        this.f11392c = null;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: A */
    public final String mo5666A(zzn zznVar) {
        m5978u0(zznVar);
        C4097k9 c4097k9 = this.f11390a;
        try {
            return (String) ((FutureTask) c4097k9.f10906k.mo5725f().m5850t(new CallableC4141o9(c4097k9, zznVar))).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            c4097k9.f10906k.mo5726g().f11141f.m5862c("Failed to get app instance id. appId", C4157q3.m5788s(zznVar.f20683j), e);
            return null;
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: G */
    public final void mo5667G(long j, String str, String str2, String str3) {
        m5976i(new RunnableC4148p5(this, str2, str3, str, j));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: I */
    public final void mo5668I(zzn zznVar) {
        m5977t0(zznVar.f20683j, false);
        m5976i(new RunnableC4058h5(this, zznVar));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: J */
    public final List<zzz> mo5669J(String str, String str2, String str3) {
        m5977t0(str, true);
        try {
            return (List) ((FutureTask) this.f11390a.mo5725f().m5850t(new CallableC4070i5(this, str, str2, str3))).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f11390a.mo5726g().f11141f.m5861b("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: K */
    public final List<zzz> mo5670K(String str, String str2, zzn zznVar) {
        m5978u0(zznVar);
        try {
            return (List) ((FutureTask) this.f11390a.mo5725f().m5850t(new CallableC4034f5(this, zznVar, str, str2))).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f11390a.mo5726g().f11141f.m5861b("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: R */
    public final List<zzku> mo5671R(String str, String str2, boolean z2, zzn zznVar) {
        m5978u0(zznVar);
        try {
            List<C4207u9> list = (List) ((FutureTask) this.f11390a.mo5725f().m5850t(new CallableC4010d5(this, zznVar, str, str2))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C4207u9 c4207u9 : list) {
                if (z2 || !C4196t9.m5885r0(c4207u9.f11292c)) {
                    arrayList.add(new zzku(c4207u9));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f11390a.mo5726g().f11141f.m5862c("Failed to query user properties. appId", C4157q3.m5788s(zznVar.f20683j), e);
            return Collections.emptyList();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: T */
    public final void mo5672T(zzn zznVar) {
        m5978u0(zznVar);
        m5976i(new RunnableC4159q5(this, zznVar));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: d0 */
    public final void mo5673d0(zzn zznVar) {
        m5978u0(zznVar);
        m5976i(new RunnableC3998c5(this, zznVar));
    }

    @BinderThread
    /* JADX INFO: renamed from: g */
    public final void m5975g(zzz zzzVar) {
        Objects.requireNonNull(zzzVar, "null reference");
        Objects.requireNonNull(zzzVar.f20702l, "null reference");
        m5977t0(zzzVar.f20700j, true);
        m5976i(new RunnableC4022e5(this, new zzz(zzzVar)));
    }

    /* JADX INFO: renamed from: i */
    public final void m5976i(Runnable runnable) {
        if (this.f11390a.mo5725f().m5855y()) {
            runnable.run();
        } else {
            this.f11390a.mo5725f().m5852v(runnable);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: j */
    public final byte[] mo5674j(zzaq zzaqVar, String str) {
        C1460d.m583w(str);
        Objects.requireNonNull(zzaqVar, "null reference");
        m5977t0(str, true);
        this.f11390a.mo5726g().f11148m.m5861b("Log and bundle. event", this.f11390a.m5714O().m5766u(zzaqVar.f20666j));
        Objects.requireNonNull((C3401c) this.f11390a.f10906k.f11267o);
        long jNanoTime = System.nanoTime() / 1000000;
        C4169r4 c4169r4Mo5725f = this.f11390a.mo5725f();
        CallableC4104l5 callableC4104l5 = new CallableC4104l5(this, zzaqVar, str);
        c4169r4Mo5725f.m5857o();
        C4180s4<?> c4180s4 = new C4180s4<>(c4169r4Mo5725f, (Callable<?>) callableC4104l5, true, "Task exception on worker thread");
        if (Thread.currentThread() == c4169r4Mo5725f.f11168d) {
            c4180s4.run();
        } else {
            c4169r4Mo5725f.m5851u(c4180s4);
        }
        try {
            byte[] bArr = (byte[]) c4180s4.get();
            if (bArr == null) {
                this.f11390a.mo5726g().f11141f.m5861b("Log and bundle returned null. appId", C4157q3.m5788s(str));
                bArr = new byte[0];
            }
            Objects.requireNonNull((C3401c) this.f11390a.f10906k.f11267o);
            this.f11390a.mo5726g().f11148m.m5863d("Log and bundle processed. event, size, time_ms", this.f11390a.m5714O().m5766u(zzaqVar.f20666j), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.f11390a.mo5726g().f11141f.m5863d("Failed to log and bundle. appId, event, error", C4157q3.m5788s(str), this.f11390a.m5714O().m5766u(zzaqVar.f20666j), e);
            return null;
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: l0 */
    public final void mo5675l0(zzaq zzaqVar, zzn zznVar) {
        Objects.requireNonNull(zzaqVar, "null reference");
        m5978u0(zznVar);
        m5976i(new RunnableC4082j5(this, zzaqVar, zznVar));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: m */
    public final void mo5676m(zzn zznVar) {
        if (C3842t8.m5293b() && this.f11390a.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
            C1460d.m583w(zznVar.f20683j);
            Objects.requireNonNull(zznVar.f20682F, "null reference");
            RunnableC4093k5 runnableC4093k5 = new RunnableC4093k5(this, zznVar);
            if (this.f11390a.mo5725f().m5855y()) {
                runnableC4093k5.run();
            } else {
                this.f11390a.mo5725f().m5853w(runnableC4093k5);
            }
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: m0 */
    public final void mo5677m0(final Bundle bundle, final zzn zznVar) {
        if (C3644ea.m4872b() && this.f11390a.f10906k.f11260h.m5526o(C4142p.f11021A0)) {
            m5978u0(zznVar);
            m5976i(new Runnable(this, zznVar, bundle) { // from class: b.i.a.f.i.b.y4

                /* JADX INFO: renamed from: j */
                public final BinderC4257z4 f11367j;

                /* JADX INFO: renamed from: k */
                public final zzn f11368k;

                /* JADX INFO: renamed from: l */
                public final Bundle f11369l;

                {
                    this.f11367j = this;
                    this.f11368k = zznVar;
                    this.f11369l = bundle;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzap zzapVar;
                    BinderC4257z4 binderC4257z4 = this.f11367j;
                    zzn zznVar2 = this.f11368k;
                    Bundle bundle2 = this.f11369l;
                    C4040g c4040gM5710K = binderC4257z4.f11390a.m5710K();
                    String str = zznVar2.f20683j;
                    c4040gM5710K.mo5848b();
                    c4040gM5710K.m5684n();
                    C4202u4 c4202u4 = c4040gM5710K.f11202a;
                    C1460d.m583w(str);
                    C1460d.m583w("dep");
                    TextUtils.isEmpty("");
                    if (bundle2 == null || bundle2.isEmpty()) {
                        zzapVar = new zzap(new Bundle());
                    } else {
                        Bundle bundle3 = new Bundle(bundle2);
                        Iterator<String> it = bundle3.keySet().iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next == null) {
                                c4202u4.mo5726g().f11141f.m5860a("Param name can't be null");
                                it.remove();
                            } else {
                                Object objM5892D = c4202u4.m5949t().m5892D(next, bundle3.get(next));
                                if (objM5892D == null) {
                                    c4202u4.mo5726g().f11144i.m5861b("Param value can't be null", c4202u4.m5950u().m5768x(next));
                                    it.remove();
                                } else {
                                    c4202u4.m5949t().m5895I(bundle3, next, objM5892D);
                                }
                            }
                        }
                        zzapVar = new zzap(bundle3);
                    }
                    C4163q9 c4163q9M5683m = c4040gM5710K.m5683m();
                    C3579a1.a aVarM4526M = C3579a1.m4526M();
                    if (aVarM4526M.f10348l) {
                        aVarM4526M.m5318n();
                        aVarM4526M.f10348l = false;
                    }
                    C3579a1.m4525E((C3579a1) aVarM4526M.f10347k, 0L);
                    for (String str2 : zzapVar.f20665j.keySet()) {
                        C3607c1.a aVarM4578Q = C3607c1.m4578Q();
                        aVarM4578Q.m4600s(str2);
                        c4163q9M5683m.m5834F(aVarM4578Q, zzapVar.m9113w0(str2));
                        aVarM4526M.m4547s(aVarM4578Q);
                    }
                    byte[] bArrM5052d = ((C3579a1) ((AbstractC3851u4) aVarM4526M.m5320p())).m5052d();
                    c4040gM5710K.mo5726g().f11149n.m5862c("Saving default event parameters, appId, data size", c4040gM5710K.m5865d().m5766u(str), Integer.valueOf(bArrM5052d.length));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("parameters", bArrM5052d);
                    try {
                        if (c4040gM5710K.m5640t().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                            c4040gM5710K.mo5726g().f11141f.m5861b("Failed to insert default event parameters (got -1). appId", C4157q3.m5788s(str));
                        }
                    } catch (SQLiteException e) {
                        c4040gM5710K.mo5726g().f11141f.m5862c("Error storing default event parameters. appId", C4157q3.m5788s(str), e);
                    }
                }
            });
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: p0 */
    public final void mo5678p0(zzku zzkuVar, zzn zznVar) {
        Objects.requireNonNull(zzkuVar, "null reference");
        m5978u0(zznVar);
        m5976i(new RunnableC4137o5(this, zzkuVar, zznVar));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: q0 */
    public final void mo5679q0(zzz zzzVar, zzn zznVar) {
        Objects.requireNonNull(zzzVar, "null reference");
        Objects.requireNonNull(zzzVar.f20702l, "null reference");
        m5978u0(zznVar);
        zzz zzzVar2 = new zzz(zzzVar);
        zzzVar2.f20700j = zznVar.f20683j;
        m5976i(new RunnableC3986b5(this, zzzVar2, zznVar));
    }

    @BinderThread
    /* JADX INFO: renamed from: t0 */
    public final void m5977t0(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.f11390a.mo5726g().f11141f.m5860a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z2) {
            try {
                if (this.f11391b == null) {
                    this.f11391b = Boolean.valueOf("com.google.android.gms".equals(this.f11392c) || C3404f.m4199D0(this.f11390a.f10906k.f11254b, Binder.getCallingUid()) || C3262f.m4021a(this.f11390a.f10906k.f11254b).m4024b(Binder.getCallingUid()));
                }
                if (this.f11391b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.f11390a.mo5726g().f11141f.m5861b("Measurement Service called with invalid calling package. appId", C4157q3.m5788s(str));
                throw e;
            }
        }
        if (this.f11392c == null) {
            Context context = this.f11390a.f10906k.f11254b;
            int callingUid = Binder.getCallingUid();
            AtomicBoolean atomicBoolean = C3260e.f9309a;
            if (C3404f.m4368z1(context, callingUid, str)) {
                this.f11392c = str;
            }
        }
        if (str.equals(this.f11392c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    @BinderThread
    /* JADX INFO: renamed from: u */
    public final List<zzku> mo5680u(String str, String str2, String str3, boolean z2) {
        m5977t0(str, true);
        try {
            List<C4207u9> list = (List) ((FutureTask) this.f11390a.mo5725f().m5850t(new CallableC4046g5(this, str, str2, str3))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C4207u9 c4207u9 : list) {
                if (z2 || !C4196t9.m5885r0(c4207u9.f11292c)) {
                    arrayList.add(new zzku(c4207u9));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f11390a.mo5726g().f11141f.m5862c("Failed to get user properties as. appId", C4157q3.m5788s(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    /* JADX INFO: renamed from: u0 */
    public final void m5978u0(zzn zznVar) {
        Objects.requireNonNull(zznVar, "null reference");
        m5977t0(zznVar.f20683j, false);
        this.f11390a.f10906k.m5949t().m5911c0(zznVar.f20684k, zznVar.f20677A, zznVar.f20681E);
    }
}
