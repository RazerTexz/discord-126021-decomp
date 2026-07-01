package b.f.j.l;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: Bucket.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class f<V> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f594b;
    public final Queue c;
    public final boolean d;
    public int e;

    public f(int i, int i2, int i3, boolean z2) {
        b.c.a.a0.d.B(i > 0);
        b.c.a.a0.d.B(i2 >= 0);
        b.c.a.a0.d.B(i3 >= 0);
        this.a = i;
        this.f594b = i2;
        this.c = new LinkedList();
        this.e = i3;
        this.d = z2;
    }

    public void a(V v) {
        this.c.add(v);
    }

    public void b() {
        b.c.a.a0.d.B(this.e > 0);
        this.e--;
    }

    public V c() {
        return (V) this.c.poll();
    }

    public void d(V v) {
        if (this.d) {
            b.c.a.a0.d.B(this.e > 0);
            this.e--;
            a(v);
            return;
        }
        int i = this.e;
        if (i > 0) {
            this.e = i - 1;
            a(v);
        } else {
            Object[] objArr = {v};
            int i2 = b.f.d.e.a.a;
            Log.println(6, "unknown:BUCKET", b.f.d.e.a.g("Tried to release value %s from an empty bucket!", objArr));
        }
    }
}
