package b.f.j.l;

import androidx.annotation.VisibleForTesting;
import java.util.LinkedList;

/* JADX INFO: compiled from: BucketMap.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class g$b<I> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f596b;
    public LinkedList<I> c;
    public g$b<I> a = null;
    public g$b<I> d = null;

    public g$b(g$b g_b, int i, LinkedList linkedList, g$b g_b2, g$a g_a) {
        this.f596b = i;
        this.c = linkedList;
    }

    public String toString() {
        return b.d.b.a.a.B(b.d.b.a.a.U("LinkedEntry(key: "), this.f596b, ")");
    }
}
