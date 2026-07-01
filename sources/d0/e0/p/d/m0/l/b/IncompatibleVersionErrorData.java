package d0.e0.p.d.m0.l.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.g.ClassId;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.r, reason: use source file name */
/* JADX INFO: compiled from: IncompatibleVersionErrorData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IncompatibleVersionErrorData<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f3507b;
    public final String c;
    public final ClassId d;

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId) {
        Intrinsics3.checkNotNullParameter(str, "filePath");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        this.a = t;
        this.f3507b = t2;
        this.c = str;
        this.d = classId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics3.areEqual(this.a, incompatibleVersionErrorData.a) && Intrinsics3.areEqual(this.f3507b, incompatibleVersionErrorData.f3507b) && Intrinsics3.areEqual(this.c, incompatibleVersionErrorData.c) && Intrinsics3.areEqual(this.d, incompatibleVersionErrorData.d);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f3507b;
        return this.d.hashCode() + outline.m(this.c, (iHashCode + (t2 != null ? t2.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("IncompatibleVersionErrorData(actualVersion=");
        sbU.append(this.a);
        sbU.append(", expectedVersion=");
        sbU.append(this.f3507b);
        sbU.append(", filePath=");
        sbU.append(this.c);
        sbU.append(", classId=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }
}
