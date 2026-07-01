package d0.e0.p.d.m0.k.v;

/* JADX INFO: compiled from: ClassLiteralValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public final d0.e0.p.d.m0.g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3472b;

    public f(d0.e0.p.d.m0.g.a aVar, int i) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        this.a = aVar;
        this.f3472b = i;
    }

    public final d0.e0.p.d.m0.g.a component1() {
        return this.a;
    }

    public final int component2() {
        return this.f3472b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return d0.z.d.m.areEqual(this.a, fVar.a) && this.f3472b == fVar.f3472b;
    }

    public final int getArrayNestedness() {
        return this.f3472b;
    }

    public final d0.e0.p.d.m0.g.a getClassId() {
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
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
