package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.a */
/* JADX INFO: compiled from: BinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11702a {

    /* JADX INFO: renamed from: a */
    public final int[] f24012a;

    /* JADX INFO: renamed from: b */
    public final int f24013b;

    /* JADX INFO: renamed from: c */
    public final int f24014c;

    /* JADX INFO: renamed from: d */
    public final int f24015d;

    /* JADX INFO: renamed from: e */
    public final List<Integer> f24016e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.a$a */
    /* JADX INFO: compiled from: BinaryVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    public AbstractC11702a(int... iArr) {
        C12238m.checkNotNullParameter(iArr, "numbers");
        this.f24012a = iArr;
        Integer orNull = C12141k.getOrNull(iArr, 0);
        this.f24013b = orNull == null ? -1 : orNull.intValue();
        Integer orNull2 = C12141k.getOrNull(iArr, 1);
        this.f24014c = orNull2 == null ? -1 : orNull2.intValue();
        Integer orNull3 = C12141k.getOrNull(iArr, 2);
        this.f24015d = orNull3 != null ? orNull3.intValue() : -1;
        this.f24016e = iArr.length > 3 ? C12163u.toList(C12139j.asList(iArr).subList(3, iArr.length)) : C12147n.emptyList();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m9813a(AbstractC11702a abstractC11702a) {
        C12238m.checkNotNullParameter(abstractC11702a, "ourVersion");
        int i = this.f24013b;
        if (i == 0) {
            if (abstractC11702a.f24013b == 0 && this.f24014c == abstractC11702a.f24014c) {
                return true;
            }
        } else if (i == abstractC11702a.f24013b && this.f24014c <= abstractC11702a.f24014c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj != null && C12238m.areEqual(getClass(), obj.getClass())) {
            AbstractC11702a abstractC11702a = (AbstractC11702a) obj;
            if (this.f24013b == abstractC11702a.f24013b && this.f24014c == abstractC11702a.f24014c && this.f24015d == abstractC11702a.f24015d && C12238m.areEqual(this.f24016e, abstractC11702a.f24016e)) {
                return true;
            }
        }
        return false;
    }

    public final int getMajor() {
        return this.f24013b;
    }

    public final int getMinor() {
        return this.f24014c;
    }

    public int hashCode() {
        int i = this.f24013b;
        int i2 = (i * 31) + this.f24014c + i;
        int i3 = (i2 * 31) + this.f24015d + i2;
        return this.f24016e.hashCode() + (i3 * 31) + i3;
    }

    public final boolean isAtLeast(AbstractC11702a abstractC11702a) {
        C12238m.checkNotNullParameter(abstractC11702a, "version");
        return isAtLeast(abstractC11702a.f24013b, abstractC11702a.f24014c, abstractC11702a.f24015d);
    }

    public final boolean isAtMost(int i, int i2, int i3) {
        int i4 = this.f24013b;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.f24014c;
        if (i5 < i2) {
            return true;
        }
        return i5 <= i2 && this.f24015d <= i3;
    }

    public final int[] toArray() {
        return this.f24012a;
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
        return arrayList.isEmpty() ? EnvironmentCompat.MEDIA_UNKNOWN : C12163u.joinToString$default(arrayList, ".", null, null, 0, null, null, 62, null);
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.f24013b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.f24014c;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.f24015d >= i3;
    }
}
