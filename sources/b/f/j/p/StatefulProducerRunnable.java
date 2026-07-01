package b.f.j.p;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.f.j.p.e1, reason: use source file name */
/* JADX INFO: compiled from: StatefulProducerRunnable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StatefulProducerRunnable<T> implements Runnable {
    public final AtomicInteger j = new AtomicInteger(0);
    public final Consumer2<T> k;
    public final ProducerListener2 l;
    public final String m;
    public final ProducerContext n;

    public StatefulProducerRunnable(Consumer2<T> consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        this.k = consumer2;
        this.l = producerListener2;
        this.m = str;
        this.n = producerContext;
        producerListener2.e(producerContext, str);
    }

    public void a() {
        if (this.j.compareAndSet(0, 2)) {
            e();
        }
    }

    public abstract void b(T t);

    public Map<String, String> c(T t) {
        return null;
    }

    public abstract T d() throws Exception;

    public void e() {
        ProducerListener2 producerListener2 = this.l;
        ProducerContext producerContext = this.n;
        String str = this.m;
        producerListener2.g(producerContext, str);
        producerListener2.d(producerContext, str, null);
        this.k.d();
    }

    public void f(Exception exc) {
        ProducerListener2 producerListener2 = this.l;
        ProducerContext producerContext = this.n;
        String str = this.m;
        producerListener2.g(producerContext, str);
        producerListener2.k(producerContext, str, exc, null);
        this.k.c(exc);
    }

    public void g(T t) {
        ProducerListener2 producerListener2 = this.l;
        ProducerContext producerContext = this.n;
        String str = this.m;
        producerListener2.j(producerContext, str, producerListener2.g(producerContext, str) ? c(t) : null);
        this.k.b(t, 1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.j.compareAndSet(0, 1)) {
            try {
                T tD = d();
                this.j.set(3);
                try {
                    g(tD);
                } finally {
                    b(tD);
                }
            } catch (Exception e) {
                this.j.set(4);
                f(e);
            }
        }
    }
}
