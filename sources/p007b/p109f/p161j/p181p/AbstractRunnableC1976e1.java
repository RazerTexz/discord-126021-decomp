package p007b.p109f.p161j.p181p;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.f.j.p.e1 */
/* JADX INFO: compiled from: StatefulProducerRunnable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRunnableC1976e1<T> implements Runnable {

    /* JADX INFO: renamed from: j */
    public final AtomicInteger f4041j = new AtomicInteger(0);

    /* JADX INFO: renamed from: k */
    public final InterfaceC1995l<T> f4042k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC2024z0 f4043l;

    /* JADX INFO: renamed from: m */
    public final String f4044m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC2020x0 f4045n;

    public AbstractRunnableC1976e1(InterfaceC1995l<T> interfaceC1995l, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, String str) {
        this.f4042k = interfaceC1995l;
        this.f4043l = interfaceC2024z0;
        this.f4044m = str;
        this.f4045n = interfaceC2020x0;
        interfaceC2024z0.mo1358e(interfaceC2020x0, str);
    }

    /* JADX INFO: renamed from: a */
    public void m1464a() {
        if (this.f4041j.compareAndSet(0, 2)) {
            mo1468e();
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo1465b(T t);

    /* JADX INFO: renamed from: c */
    public Map<String, String> mo1466c(T t) {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public abstract T mo1467d() throws Exception;

    /* JADX INFO: renamed from: e */
    public void mo1468e() {
        InterfaceC2024z0 interfaceC2024z0 = this.f4043l;
        InterfaceC2020x0 interfaceC2020x0 = this.f4045n;
        String str = this.f4044m;
        interfaceC2024z0.mo1360g(interfaceC2020x0, str);
        interfaceC2024z0.mo1357d(interfaceC2020x0, str, null);
        this.f4042k.mo1426d();
    }

    /* JADX INFO: renamed from: f */
    public void mo1469f(Exception exc) {
        InterfaceC2024z0 interfaceC2024z0 = this.f4043l;
        InterfaceC2020x0 interfaceC2020x0 = this.f4045n;
        String str = this.f4044m;
        interfaceC2024z0.mo1360g(interfaceC2020x0, str);
        interfaceC2024z0.mo1364k(interfaceC2020x0, str, exc, null);
        this.f4042k.mo1425c(exc);
    }

    /* JADX INFO: renamed from: g */
    public void mo1470g(T t) {
        InterfaceC2024z0 interfaceC2024z0 = this.f4043l;
        InterfaceC2020x0 interfaceC2020x0 = this.f4045n;
        String str = this.f4044m;
        interfaceC2024z0.mo1363j(interfaceC2020x0, str, interfaceC2024z0.mo1360g(interfaceC2020x0, str) ? mo1466c(t) : null);
        this.f4042k.mo1424b(t, 1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4041j.compareAndSet(0, 1)) {
            try {
                T tMo1467d = mo1467d();
                this.f4041j.set(3);
                try {
                    mo1470g(tMo1467d);
                } finally {
                    mo1465b(tMo1467d);
                }
            } catch (Exception e) {
                this.f4041j.set(4);
                mo1469f(e);
            }
        }
    }
}
