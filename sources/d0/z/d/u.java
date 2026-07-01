package d0.z.d;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements e {
    public final Class<?> j;

    public u(Class<?> cls, String str) {
        m.checkNotNullParameter(cls, "jClass");
        m.checkNotNullParameter(str, "moduleName");
        this.j = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && m.areEqual(getJClass(), ((u) obj).getJClass());
    }

    @Override // d0.z.d.e
    public Class<?> getJClass() {
        return this.j;
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
