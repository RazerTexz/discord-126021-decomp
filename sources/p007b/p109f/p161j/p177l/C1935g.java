package p007b.p109f.p161j.p177l;

import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import java.util.LinkedList;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.j.l.g */
/* JADX INFO: compiled from: BucketMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1935g<T> {

    /* JADX INFO: renamed from: a */
    public final SparseArray<b<T>> f3931a = new SparseArray<>();

    /* JADX INFO: renamed from: b */
    @VisibleForTesting
    public b<T> f3932b;

    /* JADX INFO: renamed from: c */
    @VisibleForTesting
    public b<T> f3933c;

    /* JADX INFO: renamed from: b.f.j.l.g$b */
    /* JADX INFO: compiled from: BucketMap.java */
    @VisibleForTesting
    public static class b<I> {

        /* JADX INFO: renamed from: b */
        public int f3935b;

        /* JADX INFO: renamed from: c */
        public LinkedList<I> f3936c;

        /* JADX INFO: renamed from: a */
        public b<I> f3934a = null;

        /* JADX INFO: renamed from: d */
        public b<I> f3937d = null;

        public b(b bVar, int i, LinkedList linkedList, b bVar2, a aVar) {
            this.f3935b = i;
            this.f3936c = linkedList;
        }

        public String toString() {
            return C1643a.m814B(C1643a.m833U("LinkedEntry(key: "), this.f3935b, ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final void m1380a(b<T> bVar) {
        if (this.f3932b == bVar) {
            return;
        }
        m1381b(bVar);
        b<T> bVar2 = this.f3932b;
        if (bVar2 == 0) {
            this.f3932b = bVar;
            this.f3933c = bVar;
        } else {
            bVar.f3937d = bVar2;
            bVar2.f3934a = bVar;
            this.f3932b = bVar;
        }
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m1381b(b<T> bVar) {
        b bVar2 = (b<T>) bVar.f3934a;
        b bVar3 = (b<T>) bVar.f3937d;
        if (bVar2 != null) {
            bVar2.f3937d = bVar3;
        }
        if (bVar3 != null) {
            bVar3.f3934a = bVar2;
        }
        bVar.f3934a = null;
        bVar.f3937d = null;
        if (bVar == this.f3932b) {
            this.f3932b = bVar3;
        }
        if (bVar == this.f3933c) {
            this.f3933c = bVar2;
        }
    }
}
