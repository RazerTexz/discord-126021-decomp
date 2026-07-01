package b.f.j.l;

import b.f.j.l.BucketMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.l.q, reason: use source file name */
/* JADX INFO: compiled from: LruBucketsPoolBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LruBucketsPoolBackend<T> {
    public final Set<T> a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BucketMap<T> f598b = new BucketMap<>();

    public abstract T a(int i);

    public abstract int b(T t);

    public T c() {
        T t;
        BucketMap<T> bucketMap = this.f598b;
        synchronized (bucketMap) {
            BucketMap.b<T> bVar = bucketMap.c;
            if (bVar == null) {
                t = null;
            } else {
                T tPollLast = bVar.c.pollLast();
                if (bVar.c.isEmpty()) {
                    bucketMap.b(bVar);
                    bucketMap.a.remove(bVar.f596b);
                }
                t = tPollLast;
            }
        }
        if (t != null) {
            synchronized (this) {
                this.a.remove(t);
            }
        }
        return t;
    }
}
