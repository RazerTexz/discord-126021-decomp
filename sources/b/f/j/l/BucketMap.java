package b.f.j.l;

import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import java.util.LinkedList;

/* JADX INFO: renamed from: b.f.j.l.g, reason: use source file name */
/* JADX INFO: compiled from: BucketMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class BucketMap<T> {
    public final SparseArray<b<T>> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public b<T> f595b;

    @VisibleForTesting
    public b<T> c;

    /* JADX INFO: renamed from: b.f.j.l.g$b */
    /* JADX INFO: compiled from: BucketMap.java */
    @VisibleForTesting
    public static class b<I> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f596b;
        public LinkedList<I> c;
        public b<I> a = null;
        public b<I> d = null;

        public b(b bVar, int i, LinkedList linkedList, b bVar2, a aVar) {
            this.f596b = i;
            this.c = linkedList;
        }

        public String toString() {
            return outline.B(outline.U("LinkedEntry(key: "), this.f596b, ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(b<T> bVar) {
        if (this.f595b == bVar) {
            return;
        }
        b(bVar);
        b<T> bVar2 = this.f595b;
        if (bVar2 == 0) {
            this.f595b = bVar;
            this.c = bVar;
        } else {
            bVar.d = bVar2;
            bVar2.a = bVar;
            this.f595b = bVar;
        }
    }

    public final synchronized void b(b<T> bVar) {
        b bVar2 = (b<T>) bVar.a;
        b bVar3 = (b<T>) bVar.d;
        if (bVar2 != null) {
            bVar2.d = bVar3;
        }
        if (bVar3 != null) {
            bVar3.a = bVar2;
        }
        bVar.a = null;
        bVar.d = null;
        if (bVar == this.f595b) {
            this.f595b = bVar3;
        }
        if (bVar == this.c) {
            this.c = bVar2;
        }
    }
}
