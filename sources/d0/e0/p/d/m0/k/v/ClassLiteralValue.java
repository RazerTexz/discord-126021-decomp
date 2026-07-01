package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.g.ClassId;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.f, reason: use source file name */
/* JADX INFO: compiled from: ClassLiteralValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassLiteralValue {
    public final ClassId a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3472b;

    public ClassLiteralValue(ClassId classId, int i) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        this.a = classId;
        this.f3472b = i;
    }

    public final ClassId component1() {
        return this.a;
    }

    public final int component2() {
        return this.f3472b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
        return Intrinsics3.areEqual(this.a, classLiteralValue.a) && this.f3472b == classLiteralValue.f3472b;
    }

    public final int getArrayNestedness() {
        return this.f3472b;
    }

    public final ClassId getClassId() {
        return this.a;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f3472b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int arrayNestedness = getArrayNestedness();
        for (int i = 0; i < arrayNestedness; i++) {
            sb.append("kotlin/Array<");
        }
        sb.append(getClassId());
        int arrayNestedness2 = getArrayNestedness();
        for (int i2 = 0; i2 < arrayNestedness2; i2++) {
            sb.append(">");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
