package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;

/* JADX INFO: renamed from: b.o.a.x.a */
/* JADX INFO: compiled from: AspectRatio.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5235a implements Comparable<C5235a> {

    /* JADX INFO: renamed from: j */
    @VisibleForTesting
    public static final HashMap<String, C5235a> f14248j = new HashMap<>(16);

    /* JADX INFO: renamed from: k */
    public final int f14249k;

    /* JADX INFO: renamed from: l */
    public final int f14250l;

    public C5235a(int i, int i2) {
        this.f14249k = i;
        this.f14250l = i2;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static C5235a m7447f(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 != 0) {
            int i5 = i3 % i4;
            i3 = i4;
            i4 = i5;
        }
        if (i3 > 0) {
            i /= i3;
        }
        if (i3 > 0) {
            i2 /= i3;
        }
        String str = i + ":" + i2;
        HashMap<String, C5235a> map = f14248j;
        C5235a c5235a = map.get(str);
        if (c5235a != null) {
            return c5235a;
        }
        C5235a c5235a2 = new C5235a(i, i2);
        map.put(str, c5235a2);
        return c5235a2;
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public static C5235a m7448g(@NonNull C5236b c5236b) {
        return m7447f(c5236b.f14251j, c5236b.f14252k);
    }

    @NonNull
    /* JADX INFO: renamed from: h */
    public static C5235a m7449h(@NonNull String str) {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 2) {
            return m7447f(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull C5235a c5235a) {
        return Float.compare(m7450i(), c5235a.m7450i());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof C5235a) && m7450i() == ((C5235a) obj).m7450i();
    }

    public int hashCode() {
        return Float.floatToIntBits(m7450i());
    }

    /* JADX INFO: renamed from: i */
    public float m7450i() {
        return this.f14249k / this.f14250l;
    }

    @NonNull
    public String toString() {
        return this.f14249k + ":" + this.f14250l;
    }
}
