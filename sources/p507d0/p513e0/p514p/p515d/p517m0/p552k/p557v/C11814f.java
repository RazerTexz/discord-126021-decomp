package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.f */
/* JADX INFO: compiled from: ClassLiteralValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11814f {

    /* JADX INFO: renamed from: a */
    public final C11712a f24436a;

    /* JADX INFO: renamed from: b */
    public final int f24437b;

    public C11814f(C11712a c11712a, int i) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        this.f24436a = c11712a;
        this.f24437b = i;
    }

    public final C11712a component1() {
        return this.f24436a;
    }

    public final int component2() {
        return this.f24437b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11814f)) {
            return false;
        }
        C11814f c11814f = (C11814f) obj;
        return C12238m.areEqual(this.f24436a, c11814f.f24436a) && this.f24437b == c11814f.f24437b;
    }

    public final int getArrayNestedness() {
        return this.f24437b;
    }

    public final C11712a getClassId() {
        return this.f24436a;
    }

    public int hashCode() {
        return (this.f24436a.hashCode() * 31) + this.f24437b;
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
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
