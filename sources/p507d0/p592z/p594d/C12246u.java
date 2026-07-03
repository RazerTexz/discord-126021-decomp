package p507d0.p592z.p594d;

/* JADX INFO: renamed from: d0.z.d.u */
/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12246u implements InterfaceC12223e {

    /* JADX INFO: renamed from: j */
    public final Class<?> f25292j;

    public C12246u(Class<?> cls, String str) {
        C12238m.checkNotNullParameter(cls, "jClass");
        C12238m.checkNotNullParameter(str, "moduleName");
        this.f25292j = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C12246u) && C12238m.areEqual(getJClass(), ((C12246u) obj).getJClass());
    }

    @Override // p507d0.p592z.p594d.InterfaceC12223e
    public Class<?> getJClass() {
        return this.f25292j;
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
