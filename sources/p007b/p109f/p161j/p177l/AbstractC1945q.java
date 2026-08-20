package p007b.p109f.p161j.p177l;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.l.q */
/* JADX INFO: compiled from: LruBucketsPoolBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1945q<T> {

    /* JADX INFO: renamed from: a */
    public final Set<T> f3950a = new HashSet();

    /* JADX INFO: renamed from: b */
    public final C1935g<T> f3951b = new C1935g<>();

    /* JADX INFO: renamed from: a */
    public abstract T mo1373a(int i);

    /* JADX INFO: renamed from: b */
    public abstract int mo1374b(T t);

    /* JADX INFO: renamed from: c */
    public T m1392c() {
        T t;
        C1935g<T> c1935g = this.f3951b;
        synchronized (c1935g) {
            C1935g.b<T> bVar = c1935g.f3933c;
            if (bVar == null) {
                t = null;
            } else {
                T tPollLast = bVar.f3936c.pollLast();
                if (bVar.f3936c.isEmpty()) {
                    c1935g.m1381b(bVar);
                    c1935g.f3931a.remove(bVar.f3935b);
                }
                t = tPollLast;
            }
        }
        if (t != null) {
            synchronized (this) {
                this.f3950a.remove(t);
            }
        }
        return t;
    }
}
