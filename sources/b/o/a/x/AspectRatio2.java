package b.o.a.x;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;

/* JADX INFO: renamed from: b.o.a.x.a, reason: use source file name */
/* JADX INFO: compiled from: AspectRatio.java */
/* JADX INFO: loaded from: classes3.dex */
public class AspectRatio2 implements Comparable<AspectRatio2> {

    @VisibleForTesting
    public static final HashMap<String, AspectRatio2> j = new HashMap<>(16);
    public final int k;
    public final int l;

    public AspectRatio2(int i, int i2) {
        this.k = i;
        this.l = i2;
    }

    @NonNull
    public static AspectRatio2 f(int i, int i2) {
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
        HashMap<String, AspectRatio2> map = j;
        AspectRatio2 aspectRatio2 = map.get(str);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        AspectRatio2 aspectRatio3 = new AspectRatio2(i, i2);
        map.put(str, aspectRatio3);
        return aspectRatio3;
    }

    @NonNull
    public static AspectRatio2 g(@NonNull Size3 size3) {
        return f(size3.j, size3.k);
    }

    @NonNull
    public static AspectRatio2 h(@NonNull String str) {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 2) {
            return f(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull AspectRatio2 aspectRatio2) {
        return Float.compare(i(), aspectRatio2.i());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof AspectRatio2) && i() == ((AspectRatio2) obj).i();
    }

    public int hashCode() {
        return Float.floatToIntBits(i());
    }

    public float i() {
        return this.k / this.l;
    }

    @NonNull
    public String toString() {
        return this.k + ":" + this.l;
    }
}
