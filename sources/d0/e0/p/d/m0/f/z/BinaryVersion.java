package d0.e0.p.d.m0.f.z;

import androidx.core.os.EnvironmentCompat;
import d0.t.Collections2;
import d0.t._Arrays;
import d0.t._ArraysJvm;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.a, reason: use source file name */
/* JADX INFO: compiled from: BinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BinaryVersion {
    public final int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3411b;
    public final int c;
    public final int d;
    public final List<Integer> e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.a$a */
    /* JADX INFO: compiled from: BinaryVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    public BinaryVersion(int... iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "numbers");
        this.a = iArr;
        Integer orNull = _Arrays.getOrNull(iArr, 0);
        this.f3411b = orNull == null ? -1 : orNull.intValue();
        Integer orNull2 = _Arrays.getOrNull(iArr, 1);
        this.c = orNull2 == null ? -1 : orNull2.intValue();
        Integer orNull3 = _Arrays.getOrNull(iArr, 2);
        this.d = orNull3 != null ? orNull3.intValue() : -1;
        this.e = iArr.length > 3 ? _Collections.toList(_ArraysJvm.asList(iArr).subList(3, iArr.length)) : Collections2.emptyList();
    }

    public final boolean a(BinaryVersion binaryVersion) {
        Intrinsics3.checkNotNullParameter(binaryVersion, "ourVersion");
        int i = this.f3411b;
        if (i == 0) {
            if (binaryVersion.f3411b == 0 && this.c == binaryVersion.c) {
                return true;
            }
        } else if (i == binaryVersion.f3411b && this.c <= binaryVersion.c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj != null && Intrinsics3.areEqual(getClass(), obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.f3411b == binaryVersion.f3411b && this.c == binaryVersion.c && this.d == binaryVersion.d && Intrinsics3.areEqual(this.e, binaryVersion.e)) {
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

    public final boolean isAtLeast(BinaryVersion binaryVersion) {
        Intrinsics3.checkNotNullParameter(binaryVersion, "version");
        return isAtLeast(binaryVersion.f3411b, binaryVersion.c, binaryVersion.d);
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
        return arrayList.isEmpty() ? EnvironmentCompat.MEDIA_UNKNOWN : _Collections.joinToString$default(arrayList, ".", null, null, 0, null, null, 62, null);
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
