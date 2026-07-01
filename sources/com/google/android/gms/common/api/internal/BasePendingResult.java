package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.c;
import b.i.a.f.e.h.d;
import b.i.a.f.e.h.d$a;
import b.i.a.f.e.h.f;
import b.i.a.f.e.h.h;
import b.i.a.f.e.h.j.l0;
import b.i.a.f.e.h.j.w0;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepName
public abstract class BasePendingResult<R extends h> extends d<R> {
    public static final ThreadLocal<Boolean> a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3004b;
    public final BasePendingResult$a<R> c;
    public final CountDownLatch d;
    public final ArrayList<d$a> e;
    public final AtomicReference<l0> f;

    @Nullable
    public R g;
    public Status h;
    public volatile boolean i;
    public boolean j;
    public boolean k;

    @KeepName
    public BasePendingResult$b mResultGuardian;

    @Deprecated
    public BasePendingResult() {
        this.f3004b = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.k = false;
        this.c = new BasePendingResult$a<>(Looper.getMainLooper());
        new WeakReference(null);
    }

    public static void h(@Nullable h hVar) {
        if (hVar instanceof f) {
            try {
                ((f) hVar).release();
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(hVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(strValueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    public /* bridge */ /* synthetic */ void b(Object obj) {
        g((h) obj);
    }

    @Override // b.i.a.f.e.h.d
    public final void c(d$a d_a) {
        b.c.a.a0.d.o(true, "Callback cannot be null.");
        synchronized (this.f3004b) {
            if (f()) {
                d_a.a(this.h);
            } else {
                this.e.add(d_a);
            }
        }
    }

    @NonNull
    public abstract R d(Status status);

    @Deprecated
    public final void e(Status status) {
        synchronized (this.f3004b) {
            if (!f()) {
                g(d(status));
                this.j = true;
            }
        }
    }

    public final boolean f() {
        return this.d.getCount() == 0;
    }

    public final void g(R r) {
        synchronized (this.f3004b) {
            if (this.j) {
                h(r);
                return;
            }
            f();
            boolean z2 = true;
            b.c.a.a0.d.G(!f(), "Results have already been set");
            if (this.i) {
                z2 = false;
            }
            b.c.a.a0.d.G(z2, "Result has already been consumed");
            i(r);
        }
    }

    public final void i(R r) {
        this.g = r;
        this.h = r.b0();
        this.d.countDown();
        if (this.g instanceof f) {
            this.mResultGuardian = new BasePendingResult$b(this, null);
        }
        ArrayList<d$a> arrayList = this.e;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            d$a d_a = arrayList.get(i);
            i++;
            d_a.a(this.h);
        }
        this.e.clear();
    }

    public final R j() {
        R r;
        synchronized (this.f3004b) {
            b.c.a.a0.d.G(!this.i, "Result has already been consumed.");
            b.c.a.a0.d.G(f(), "Result is not ready.");
            r = this.g;
            this.g = null;
            this.i = true;
        }
        l0 andSet = this.f.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        Objects.requireNonNull(r, "null reference");
        return r;
    }

    public BasePendingResult(@Nullable c cVar) {
        this.f3004b = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.k = false;
        this.c = new BasePendingResult$a<>(cVar != null ? cVar.c() : Looper.getMainLooper());
        new WeakReference(cVar);
    }
}
