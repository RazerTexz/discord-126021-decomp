package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3269d;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3271f;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3274i;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3326w0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3304l0;
import p007b.p225i.p226a.p288f.p313h.p318e.HandlerC3479c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepName
public abstract class BasePendingResult<R extends InterfaceC3273h> extends AbstractC3269d<R> {

    /* JADX INFO: renamed from: a */
    public static final ThreadLocal<Boolean> f20499a = new C3326w0();

    /* JADX INFO: renamed from: b */
    public final Object f20500b;

    /* JADX INFO: renamed from: c */
    public final HandlerC10801a<R> f20501c;

    /* JADX INFO: renamed from: d */
    public final CountDownLatch f20502d;

    /* JADX INFO: renamed from: e */
    public final ArrayList<AbstractC3269d.a> f20503e;

    /* JADX INFO: renamed from: f */
    public final AtomicReference<InterfaceC3304l0> f20504f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public R f20505g;

    /* JADX INFO: renamed from: h */
    public Status f20506h;

    /* JADX INFO: renamed from: i */
    public volatile boolean f20507i;

    /* JADX INFO: renamed from: j */
    public boolean f20508j;

    /* JADX INFO: renamed from: k */
    public boolean f20509k;

    @KeepName
    public C10802b mResultGuardian;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.BasePendingResult$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class HandlerC10801a<R extends InterfaceC3273h> extends HandlerC3479c {
        public HandlerC10801a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("BasePendingResult", C1643a.m851g(45, "Don't know how to handle message: ", i), new Exception());
                    return;
                } else {
                    ((BasePendingResult) message.obj).m9033e(Status.f20492m);
                    return;
                }
            }
            Pair pair = (Pair) message.obj;
            InterfaceC3274i interfaceC3274i = (InterfaceC3274i) pair.first;
            InterfaceC3273h interfaceC3273h = (InterfaceC3273h) pair.second;
            try {
                interfaceC3274i.m4054a(interfaceC3273h);
            } catch (RuntimeException e) {
                BasePendingResult.m9032h(interfaceC3273h);
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.BasePendingResult$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public final class C10802b {
        public C10802b(C3326w0 c3326w0) {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.m9032h(BasePendingResult.this.f20505g);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.f20500b = new Object();
        this.f20502d = new CountDownLatch(1);
        this.f20503e = new ArrayList<>();
        this.f20504f = new AtomicReference<>();
        this.f20509k = false;
        this.f20501c = new HandlerC10801a<>(Looper.getMainLooper());
        new WeakReference(null);
    }

    /* JADX INFO: renamed from: h */
    public static void m9032h(@Nullable InterfaceC3273h interfaceC3273h) {
        if (interfaceC3273h instanceof InterfaceC3271f) {
            try {
                ((InterfaceC3271f) interfaceC3273h).release();
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(interfaceC3273h);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(strValueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3269d
    /* JADX INFO: renamed from: c */
    public final void mo4051c(AbstractC3269d.a aVar) {
        C1460d.m551o(true, "Callback cannot be null.");
        synchronized (this.f20500b) {
            if (m9034f()) {
                aVar.mo4052a(this.f20506h);
            } else {
                this.f20503e.add(aVar);
            }
        }
    }

    @NonNull
    /* JADX INFO: renamed from: d */
    public abstract R mo3987d(Status status);

    @Deprecated
    /* JADX INFO: renamed from: e */
    public final void m9033e(Status status) {
        synchronized (this.f20500b) {
            if (!m9034f()) {
                mo3989b(mo3987d(status));
                this.f20508j = true;
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final boolean m9034f() {
        return this.f20502d.getCount() == 0;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void mo3989b(R r) {
        synchronized (this.f20500b) {
            if (this.f20508j) {
                m9032h(r);
                return;
            }
            m9034f();
            boolean z2 = true;
            C1460d.m435G(!m9034f(), "Results have already been set");
            if (this.f20507i) {
                z2 = false;
            }
            C1460d.m435G(z2, "Result has already been consumed");
            m9036i(r);
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m9036i(R r) {
        this.f20505g = r;
        this.f20506h = r.mo4053b0();
        this.f20502d.countDown();
        if (this.f20505g instanceof InterfaceC3271f) {
            this.mResultGuardian = new C10802b(null);
        }
        ArrayList<AbstractC3269d.a> arrayList = this.f20503e;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            AbstractC3269d.a aVar = arrayList.get(i);
            i++;
            aVar.mo4052a(this.f20506h);
        }
        this.f20503e.clear();
    }

    /* JADX INFO: renamed from: j */
    public final R m9037j() {
        R r;
        synchronized (this.f20500b) {
            C1460d.m435G(!this.f20507i, "Result has already been consumed.");
            C1460d.m435G(m9034f(), "Result is not ready.");
            r = this.f20505g;
            this.f20505g = null;
            this.f20507i = true;
        }
        InterfaceC3304l0 andSet = this.f20504f.getAndSet(null);
        if (andSet != null) {
            andSet.m4110a(this);
        }
        Objects.requireNonNull(r, "null reference");
        return r;
    }

    public BasePendingResult(@Nullable AbstractC3268c abstractC3268c) {
        this.f20500b = new Object();
        this.f20502d = new CountDownLatch(1);
        this.f20503e = new ArrayList<>();
        this.f20504f = new AtomicReference<>();
        this.f20509k = false;
        this.f20501c = new HandlerC10801a<>(abstractC3268c != null ? abstractC3268c.mo4050c() : Looper.getMainLooper());
        new WeakReference(abstractC3268c);
    }
}
