package p659s.p660a.p661a;

import java.lang.Comparable;
import java.util.Arrays;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.AbstractC13145r0;
import p659s.p660a.p661a.InterfaceC13040w;

/* JADX INFO: renamed from: s.a.a.v */
/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13039v<T extends InterfaceC13040w & Comparable<? super T>> {
    public volatile int _size = 0;

    /* JADX INFO: renamed from: a */
    public T[] f27707a;

    /* JADX INFO: renamed from: a */
    public final void m11174a(T t) {
        AbstractC13145r0.c cVar = (AbstractC13145r0.c) t;
        cVar.mo11180g(this);
        T[] tArr = this.f27707a;
        if (tArr == null) {
            tArr = (T[]) new InterfaceC13040w[4];
            this.f27707a = tArr;
        } else if (this._size >= tArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(tArr, this._size * 2);
            C12238m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((InterfaceC13040w[]) objArrCopyOf);
            this.f27707a = tArr;
        }
        int i = this._size;
        this._size = i + 1;
        tArr[i] = t;
        cVar.f27893k = i;
        m11177d(i);
    }

    /* JADX INFO: renamed from: b */
    public final T m11175b() {
        T[] tArr = this.f27707a;
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
    /* JADX INFO: renamed from: c */
    public final T m11176c(int i) {
        int i2;
        T[] tArr;
        int i3;
        T t;
        T t2;
        T t3;
        T t4;
        T[] tArr2 = this.f27707a;
        C12238m.checkNotNull(tArr2);
        this._size--;
        if (i < this._size) {
            m11178e(i, this._size);
            int i4 = (i - 1) / 2;
            if (i > 0) {
                T t5 = tArr2[i];
                C12238m.checkNotNull(t5);
                T t6 = tArr2[i4];
                C12238m.checkNotNull(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    m11178e(i, i4);
                    m11177d(i4);
                } else {
                    while (true) {
                        i2 = (i * 2) + 1;
                        if (i2 >= this._size) {
                            break;
                        }
                        tArr = this.f27707a;
                        C12238m.checkNotNull(tArr);
                        i3 = i2 + 1;
                        if (i3 < this._size) {
                            t3 = tArr[i3];
                            C12238m.checkNotNull(t3);
                            t4 = tArr[i2];
                            C12238m.checkNotNull(t4);
                            if (((Comparable) t3).compareTo(t4) < 0) {
                                i2 = i3;
                            }
                        }
                        t = tArr[i];
                        C12238m.checkNotNull(t);
                        t2 = tArr[i2];
                        C12238m.checkNotNull(t2);
                        if (((Comparable) t).compareTo(t2) <= 0) {
                            break;
                        }
                        m11178e(i, i2);
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
                    tArr = this.f27707a;
                    C12238m.checkNotNull(tArr);
                    i3 = i2 + 1;
                    if (i3 < this._size) {
                        t3 = tArr[i3];
                        C12238m.checkNotNull(t3);
                        t4 = tArr[i2];
                        C12238m.checkNotNull(t4);
                        if (((Comparable) t3).compareTo(t4) < 0) {
                            i2 = i3;
                        }
                    }
                    t = tArr[i];
                    C12238m.checkNotNull(t);
                    t2 = tArr[i2];
                    C12238m.checkNotNull(t2);
                    if (((Comparable) t).compareTo(t2) <= 0) {
                        break;
                        break;
                    }
                    m11178e(i, i2);
                    i = i2;
                }
            }
        }
        T t7 = tArr2[this._size];
        C12238m.checkNotNull(t7);
        t7.mo11180g(null);
        t7.mo11179f(-1);
        tArr2[this._size] = null;
        return t7;
    }

    /* JADX INFO: renamed from: d */
    public final void m11177d(int i) {
        while (i > 0) {
            T[] tArr = this.f27707a;
            C12238m.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            C12238m.checkNotNull(t);
            T t2 = tArr[i];
            C12238m.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m11178e(i, i2);
            i = i2;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m11178e(int i, int i2) {
        T[] tArr = this.f27707a;
        C12238m.checkNotNull(tArr);
        T t = tArr[i2];
        C12238m.checkNotNull(t);
        T t2 = tArr[i];
        C12238m.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.mo11179f(i);
        t2.mo11179f(i2);
    }
}
