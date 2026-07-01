package d0.z.d;

/* JADX INFO: renamed from: d0.z.d.u, reason: use source file name */
/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {
    public final Class<?> j;

    public PackageReference(Class<?> cls, String str) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        Intrinsics3.checkNotNullParameter(str, "moduleName");
        this.j = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PackageReference) && Intrinsics3.areEqual(getJClass(), ((PackageReference) obj).getJClass());
    }

    @Override // d0.z.d.ClassBasedDeclarationContainer
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
