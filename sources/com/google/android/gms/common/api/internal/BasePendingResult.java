package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.h.d;
import b.i.a.f.e.h.f;
import b.i.a.f.e.h.h;
import b.i.a.f.e.h.i;
import b.i.a.f.e.h.j.l0;
import b.i.a.f.e.h.j.w0;
import b.i.a.f.h.e.c;
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
    public final a<R> c;
    public final CountDownLatch d;
    public final ArrayList<d.a> e;
    public final AtomicReference<l0> f;

    @Nullable
    public R g;
    public Status h;
    public volatile boolean i;
    public boolean j;
    public boolean k;

    @KeepName
    public b mResultGuardian;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class a<R extends h> extends c {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("BasePendingResult", outline.g(45, "Don't know how to handle message: ", i), new Exception());
                    return;
                } else {
                    ((BasePendingResult) message.obj).e(Status.m);
                    return;
                }
            }
            Pair pair = (Pair) message.obj;
            i iVar = (i) pair.first;
            h hVar = (h) pair.second;
            try {
                iVar.a(hVar);
            } catch (RuntimeException e) {
                BasePendingResult.h(hVar);
                throw e;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public final class b {
        public b(w0 w0Var) {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.h(BasePendingResult.this.g);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.f3004b = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.k = false;
        this.c = new a<>(Looper.getMainLooper());
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

    @Override // b.i.a.f.e.h.d
    public final void c(d.a aVar) {
        AnimatableValueParser.o(true, "Callback cannot be null.");
        synchronized (this.f3004b) {
            if (f()) {
                aVar.a(this.h);
            } else {
                this.e.add(aVar);
            }
        }
    }

    @NonNull
    public abstract R d(Status status);

    @Deprecated
    public final void e(Status status) {
        synchronized (this.f3004b) {
            if (!f()) {
                b(d(status));
                this.j = true;
            }
        }
    }

    public final boolean f() {
        return this.d.getCount() == 0;
    }

    @Override // b.i.a.f.e.h.j.e
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void b(R r) {
        synchronized (this.f3004b) {
            if (this.j) {
                h(r);
                return;
            }
            f();
            boolean z2 = true;
            AnimatableValueParser.G(!f(), "Results have already been set");
            if (this.i) {
                z2 = false;
            }
            AnimatableValueParser.G(z2, "Result has already been consumed");
            i(r);
        }
    }

    public final void i(R r) {
        this.g = r;
        this.h = r.b0();
        this.d.countDown();
        if (this.g instanceof f) {
            this.mResultGuardian = new b(null);
        }
        ArrayList<d.a> arrayList = this.e;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            d.a aVar = arrayList.get(i);
            i++;
            aVar.a(this.h);
        }
        this.e.clear();
    }

    public final R j() {
        R r;
        synchronized (this.f3004b) {
            AnimatableValueParser.G(!this.i, "Result has already been consumed.");
            AnimatableValueParser.G(f(), "Result is not ready.");
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

    public BasePendingResult(@Nullable b.i.a.f.e.h.c cVar) {
        this.f3004b = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.k = false;
        this.c = new a<>(cVar != null ? cVar.c() : Looper.getMainLooper());
        new WeakReference(cVar);
    }
}
