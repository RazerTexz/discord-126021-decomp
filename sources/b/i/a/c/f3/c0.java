package b.i.a.c.f3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* JADX INFO: compiled from: TimedValueQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0<V> {
    public long[] a = new long[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public V[] f965b = (V[]) new Object[10];
    public int c;
    public int d;

    public synchronized void a(long j, V v) {
        int i = this.d;
        if (i > 0) {
            if (j <= this.a[((this.c + i) - 1) % this.f965b.length]) {
                b();
            }
        }
        c();
        int i2 = this.c;
        int i3 = this.d;
        V[] vArr = this.f965b;
        int length = (i2 + i3) % vArr.length;
        this.a[length] = j;
        vArr[length] = v;
        this.d = i3 + 1;
    }

    public synchronized void b() {
        this.c = 0;
        this.d = 0;
        Arrays.fill(this.f965b, (Object) null);
    }

    public final void c() {
        int length = this.f965b.length;
        if (this.d < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        V[] vArr = (V[]) new Object[i];
        int i2 = this.c;
        int i3 = length - i2;
        System.arraycopy(this.a, i2, jArr, 0, i3);
        System.arraycopy(this.f965b, this.c, vArr, 0, i3);
        int i4 = this.c;
        if (i4 > 0) {
            System.arraycopy(this.a, 0, jArr, i3, i4);
            System.arraycopy(this.f965b, 0, vArr, i3, this.c);
        }
        this.a = jArr;
        this.f965b = vArr;
        this.c = 0;
    }

    @Nullable
    public final V d(long j, boolean z2) {
        V vF = null;
        long j2 = RecyclerView.FOREVER_NS;
        while (this.d > 0) {
            long j3 = j - this.a[this.c];
            if (j3 < 0 && (z2 || (-j3) >= j2)) {
                break;
            }
            vF = f();
            j2 = j3;
        }
        return vF;
    }

    @Nullable
    public synchronized V e(long j) {
        return d(j, true);
    }

    @Nullable
    public final V f() {
        b.c.a.a0.d.D(this.d > 0);
        V[] vArr = this.f965b;
        int i = this.c;
        V v = vArr[i];
        vArr[i] = null;
        this.c = (i + 1) % vArr.length;
        this.d--;
        return v;
    }
}
