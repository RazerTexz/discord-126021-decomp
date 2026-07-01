package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    public final Integer compareTo(u uVar) {
        d0.z.d.m.checkNotNullParameter(uVar, "visibility");
        return getDelegate().compareTo(uVar.getDelegate());
    }

    public abstract f1 getDelegate();

    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar);

    public abstract u normalize();

    public final String toString() {
        return getDelegate().toString();
    }
}
