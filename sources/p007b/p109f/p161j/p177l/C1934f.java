package p007b.p109f.p161j.p177l;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.j.l.f */
/* JADX INFO: compiled from: Bucket.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class C1934f<V> {

    /* JADX INFO: renamed from: a */
    public final int f3926a;

    /* JADX INFO: renamed from: b */
    public final int f3927b;

    /* JADX INFO: renamed from: c */
    public final Queue f3928c;

    /* JADX INFO: renamed from: d */
    public final boolean f3929d;

    /* JADX INFO: renamed from: e */
    public int f3930e;

    public C1934f(int i, int i2, int i3, boolean z2) {
        C1460d.m419B(i > 0);
        C1460d.m419B(i2 >= 0);
        C1460d.m419B(i3 >= 0);
        this.f3926a = i;
        this.f3927b = i2;
        this.f3928c = new LinkedList();
        this.f3930e = i3;
        this.f3929d = z2;
    }

    /* JADX INFO: renamed from: a */
    public void m1376a(V v) {
        this.f3928c.add(v);
    }

    /* JADX INFO: renamed from: b */
    public void m1377b() {
        C1460d.m419B(this.f3930e > 0);
        this.f3930e--;
    }

    /* JADX INFO: renamed from: c */
    public V m1378c() {
        return (V) this.f3928c.poll();
    }

    /* JADX INFO: renamed from: d */
    public void m1379d(V v) {
        if (this.f3929d) {
            C1460d.m419B(this.f3930e > 0);
            this.f3930e--;
            m1376a(v);
            return;
        }
        int i = this.f3930e;
        if (i > 0) {
            this.f3930e = i - 1;
            m1376a(v);
        } else {
            Object[] objArr = {v};
            int i2 = C1691a.f3102a;
            Log.println(6, "unknown:BUCKET", C1691a.m979g("Tried to release value %s from an empty bucket!", objArr));
        }
    }
}
