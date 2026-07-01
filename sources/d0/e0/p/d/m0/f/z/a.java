package d0.e0.p.d.m0.f.z;

import androidx.core.os.EnvironmentCompat;
import d0.t.k;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public final int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3411b;
    public final int c;
    public final int d;
    public final List<Integer> e;

    static {
        new a$a(null);
    }

    public a(int... iArr) {
        m.checkNotNullParameter(iArr, "numbers");
        this.a = iArr;
        Integer orNull = k.getOrNull(iArr, 0);
        this.f3411b = orNull == null ? -1 : orNull.intValue();
        Integer orNull2 = k.getOrNull(iArr, 1);
        this.c = orNull2 == null ? -1 : orNull2.intValue();
        Integer orNull3 = k.getOrNull(iArr, 2);
        this.d = orNull3 != null ? orNull3.intValue() : -1;
        this.e = iArr.length > 3 ? u.toList(d0.t.j.asList(iArr).subList(3, iArr.length)) : n.emptyList();
    }

    public final boolean a(a aVar) {
        m.checkNotNullParameter(aVar, "ourVersion");
        int i = this.f3411b;
        if (i == 0) {
            if (aVar.f3411b == 0 && this.c == aVar.c) {
                return true;
            }
        } else if (i == aVar.f3411b && this.c <= aVar.c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj != null && m.areEqual(getClass(), obj.getClass())) {
            a aVar = (a) obj;
            if (this.f3411b == aVar.f3411b && this.c == aVar.c && this.d == aVar.d && m.areEqual(this.e, aVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int getMajor() {
        return this.f3411b;
    }

    public final int getMinor() {
        return this.c;
    }

    public int hashCode() {
        int i = this.f3411b;
        int i2 = (i * 31) + this.c + i;
        int i3 = (i2 * 31) + this.d + i2;
        return this.e.hashCode() + (i3 * 31) + i3;
    }

    public final boolean isAtLeast(a aVar) {
        m.checkNotNullParameter(aVar, "version");
        return isAtLeast(aVar.f3411b, aVar.c, aVar.d);
    }

    public final boolean isAtMost(int i, int i2, int i3) {
        int i4 = this.f3411b;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.c;
        if (i5 < i2) {
            return true;
        }
        return i5 <= i2 && this.d <= i3;
    }

    public final int[] toArray() {
        return this.a;
    }

    public String toString() {
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int i2 = array[i];
            if (!(i2 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList.isEmpty() ? EnvironmentCompat.MEDIA_UNKNOWN : u.joinToString$default(arrayList, ".", null, null, 0, null, null, 62, null);
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.f3411b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.c;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.d >= i3;
    }
}
