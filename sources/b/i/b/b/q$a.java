package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class q$a<K, V> {
    public Object[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1648b = 0;
    public boolean c = false;

    public q$a(int i) {
        this.a = new Object[i * 2];
    }

    public q<K, V> a() {
        int i;
        this.c = true;
        int i2 = this.f1648b;
        Object[] objArr = this.a;
        if (i2 == 0) {
            return (i0) i0.m;
        }
        int[] iArr = null;
        if (i2 == 1) {
            b.i.a.f.e.o.f.z(objArr[0], objArr[1]);
            return new i0(null, objArr, 1);
        }
        b.i.a.f.e.o.f.C(i2, objArr.length >> 1);
        int iK = r.k(i2);
        if (i2 == 1) {
            b.i.a.f.e.o.f.z(objArr[0], objArr[1]);
        } else {
            int i3 = iK - 1;
            int[] iArr2 = new int[iK];
            Arrays.fill(iArr2, -1);
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i4 * 2;
                int i6 = i5 + 0;
                Object obj = objArr[i6];
                Object obj2 = objArr[i5 + 1];
                b.i.a.f.e.o.f.z(obj, obj2);
                int iC1 = b.i.a.f.e.o.f.c1(obj.hashCode());
                while (true) {
                    i = iC1 & i3;
                    int i7 = iArr2[i];
                    if (i7 == -1) {
                        break;
                    }
                    if (objArr[i7].equals(obj)) {
                        throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i7] + "=" + objArr[1 ^ i7]);
                    }
                    iC1 = i + 1;
                }
                iArr2[i] = i6;
            }
            iArr = iArr2;
        }
        return new i0(iArr, objArr, i2);
    }

    public final void b(int i) {
        int i2 = i * 2;
        Object[] objArr = this.a;
        if (i2 > objArr.length) {
            this.a = Arrays.copyOf(objArr, n$b.a(objArr.length, i2));
            this.c = false;
        }
    }

    @CanIgnoreReturnValue
    public q$a<K, V> c(K k, V v) {
        b(this.f1648b + 1);
        b.i.a.f.e.o.f.z(k, v);
        Object[] objArr = this.a;
        int i = this.f1648b;
        objArr[i * 2] = k;
        objArr[(i * 2) + 1] = v;
        this.f1648b = i + 1;
        return this;
    }
}
