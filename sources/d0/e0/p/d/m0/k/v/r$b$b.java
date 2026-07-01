package d0.e0.p.d.m0.k.v;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r$b$b extends r$b {
    public final f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r$b$b(f fVar) {
        super(null);
        d0.z.d.m.checkNotNullParameter(fVar, "value");
        this.a = fVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r$b$b) && d0.z.d.m.areEqual(this.a, ((r$b$b) obj).a);
    }

    public final int getArrayDimensions() {
        return this.a.getArrayNestedness();
    }

    public final d0.e0.p.d.m0.g.a getClassId() {
        return this.a.getClassId();
    }

    public final f getValue() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("NormalClass(value=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
