package p007b.p225i.p226a.p242c.p259f3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.f3.c0 */
/* JADX INFO: compiled from: TimedValueQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2734c0<V> {

    /* JADX INFO: renamed from: a */
    public long[] f6695a = new long[10];

    /* JADX INFO: renamed from: b */
    public V[] f6696b = (V[]) new Object[10];

    /* JADX INFO: renamed from: c */
    public int f6697c;

    /* JADX INFO: renamed from: d */
    public int f6698d;

    /* JADX INFO: renamed from: a */
    public synchronized void m2966a(long j, V v) {
        int i = this.f6698d;
        if (i > 0) {
            if (j <= this.f6695a[((this.f6697c + i) - 1) % this.f6696b.length]) {
                m2967b();
            }
        }
        m2968c();
        int i2 = this.f6697c;
        int i3 = this.f6698d;
        V[] vArr = this.f6696b;
        int length = (i2 + i3) % vArr.length;
        this.f6695a[length] = j;
        vArr[length] = v;
        this.f6698d = i3 + 1;
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m2967b() {
        this.f6697c = 0;
        this.f6698d = 0;
        Arrays.fill(this.f6696b, (Object) null);
    }

    /* JADX INFO: renamed from: c */
    public final void m2968c() {
        int length = this.f6696b.length;
        if (this.f6698d < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        V[] vArr = (V[]) new Object[i];
        int i2 = this.f6697c;
        int i3 = length - i2;
        System.arraycopy(this.f6695a, i2, jArr, 0, i3);
        System.arraycopy(this.f6696b, this.f6697c, vArr, 0, i3);
        int i4 = this.f6697c;
        if (i4 > 0) {
            System.arraycopy(this.f6695a, 0, jArr, i3, i4);
            System.arraycopy(this.f6696b, 0, vArr, i3, this.f6697c);
        }
        this.f6695a = jArr;
        this.f6696b = vArr;
        this.f6697c = 0;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public final V m2969d(long j, boolean z2) {
        V vM2971f = null;
        long j2 = RecyclerView.FOREVER_NS;
        while (this.f6698d > 0) {
            long j3 = j - this.f6695a[this.f6697c];
            if (j3 < 0 && (z2 || (-j3) >= j2)) {
                break;
            }
            vM2971f = m2971f();
            j2 = j3;
        }
        return vM2971f;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public synchronized V m2970e(long j) {
        return m2969d(j, true);
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public final V m2971f() {
        C1460d.m426D(this.f6698d > 0);
        V[] vArr = this.f6696b;
        int i = this.f6697c;
        V v = vArr[i];
        vArr[i] = null;
        this.f6697c = (i + 1) % vArr.length;
        this.f6698d--;
        return v;
    }
}
