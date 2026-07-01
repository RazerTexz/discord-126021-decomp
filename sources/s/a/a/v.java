package s.a.a;

import java.lang.Comparable;
import java.util.Arrays;
import s.a.a.w;
import s.a.r0$c;

/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes3.dex */
public class v<T extends w & Comparable<? super T>> {
    public volatile int _size = 0;
    public T[] a;

    public final void a(T t) {
        r0$c r0_c = (r0$c) t;
        r0_c.g(this);
        T[] tArr = this.a;
        if (tArr == null) {
            tArr = (T[]) new w[4];
            this.a = tArr;
        } else if (this._size >= tArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(tArr, this._size * 2);
            d0.z.d.m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((w[]) objArrCopyOf);
            this.a = tArr;
        }
        int i = this._size;
        this._size = i + 1;
        tArr[i] = t;
        r0_c.k = i;
        d(i);
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    /* JADX WARN: Code duplicated, block: B:16:0x0059  */
    /* JADX WARN: Code duplicated, block: B:20:0x006d A[LOOP:0: B:9:0x0033->B:20:0x006d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0072 A[EDGE_INSN: B:23:0x0072->B:21:0x0072 BREAK  A[LOOP:0: B:9:0x0033->B:20:0x006d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0072 A[EDGE_INSN: B:24:0x0072->B:21:0x0072 BREAK  A[LOOP:0: B:9:0x0033->B:20:0x006d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:? A[SYNTHETIC] */
    public final T c(int i) {
        int i2;
        T[] tArr;
        int i3;
        T t;
        T t2;
        T t3;
        T t4;
        T[] tArr2 = this.a;
        d0.z.d.m.checkNotNull(tArr2);
        this._size--;
        if (i < this._size) {
            e(i, this._size);
            int i4 = (i - 1) / 2;
            if (i > 0) {
                T t5 = tArr2[i];
                d0.z.d.m.checkNotNull(t5);
                T t6 = tArr2[i4];
                d0.z.d.m.checkNotNull(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    e(i, i4);
                    d(i4);
                } else {
                    while (true) {
                        i2 = (i * 2) + 1;
                        if (i2 >= this._size) {
                            break;
                        }
                        tArr = this.a;
                        d0.z.d.m.checkNotNull(tArr);
                        i3 = i2 + 1;
                        if (i3 < this._size) {
                            t3 = tArr[i3];
                            d0.z.d.m.checkNotNull(t3);
                            t4 = tArr[i2];
                            d0.z.d.m.checkNotNull(t4);
                            if (((Comparable) t3).compareTo(t4) < 0) {
                                i2 = i3;
                            }
                        }
                        t = tArr[i];
                        d0.z.d.m.checkNotNull(t);
                        t2 = tArr[i2];
                        d0.z.d.m.checkNotNull(t2);
                        if (((Comparable) t).compareTo(t2) <= 0) {
                            break;
                        }
                        e(i, i2);
                        i = i2;
                    }
                }
            } else {
                while (true) {
                    i2 = (i * 2) + 1;
                    if (i2 >= this._size) {
                        break;
                        break;
                    }
                    tArr = this.a;
                    d0.z.d.m.checkNotNull(tArr);
                    i3 = i2 + 1;
                    if (i3 < this._size) {
                        t3 = tArr[i3];
                        d0.z.d.m.checkNotNull(t3);
                        t4 = tArr[i2];
                        d0.z.d.m.checkNotNull(t4);
                        if (((Comparable) t3).compareTo(t4) < 0) {
                            i2 = i3;
                        }
                    }
                    t = tArr[i];
                    d0.z.d.m.checkNotNull(t);
                    t2 = tArr[i2];
                    d0.z.d.m.checkNotNull(t2);
                    if (((Comparable) t).compareTo(t2) <= 0) {
                        break;
                        break;
                    }
                    e(i, i2);
                    i = i2;
                }
            }
        }
        T t7 = tArr2[this._size];
        d0.z.d.m.checkNotNull(t7);
        t7.g(null);
        t7.f(-1);
        tArr2[this._size] = null;
        return t7;
    }

    public final void d(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            d0.z.d.m.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            d0.z.d.m.checkNotNull(t);
            T t2 = tArr[i];
            d0.z.d.m.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            e(i, i2);
            i = i2;
        }
    }

    public final void e(int i, int i2) {
        T[] tArr = this.a;
        d0.z.d.m.checkNotNull(tArr);
        T t = tArr[i2];
        d0.z.d.m.checkNotNull(t);
        T t2 = tArr[i];
        d0.z.d.m.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.f(i);
        t2.f(i2);
    }
}
