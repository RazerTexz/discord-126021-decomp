package b.o.a.x;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;

/* JADX INFO: compiled from: AspectRatio.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements Comparable<a> {

    @VisibleForTesting
    public static final HashMap<String, a> j = new HashMap<>(16);
    public final int k;
    public final int l;

    public a(int i, int i2) {
        this.k = i;
        this.l = i2;
    }

    @NonNull
    public static a f(int i, int i2) {
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
        HashMap<String, a> map = j;
        a aVar = map.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(i, i2);
        map.put(str, aVar2);
        return aVar2;
    }

    @NonNull
    public static a g(@NonNull b bVar) {
        return f(bVar.j, bVar.k);
    }

    @NonNull
    public static a h(@NonNull String str) {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 2) {
            return f(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull a aVar) {
        return Float.compare(i(), aVar.i());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && i() == ((a) obj).i();
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
