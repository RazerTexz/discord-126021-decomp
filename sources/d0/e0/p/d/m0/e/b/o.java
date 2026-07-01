package d0.e0.p.d.m0.e.b;

/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final p findKotlinClass(n nVar, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        n$a n_aFindKotlinClassOrContent = nVar.findKotlinClassOrContent(aVar);
        if (n_aFindKotlinClassOrContent == null) {
            return null;
        }
        return n_aFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }

    public static final p findKotlinClass(n nVar, d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "<this>");
        d0.z.d.m.checkNotNullParameter(gVar, "javaClass");
        n$a n_aFindKotlinClassOrContent = nVar.findKotlinClassOrContent(gVar);
        if (n_aFindKotlinClassOrContent == null) {
            return null;
        }
        return n_aFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }
}
