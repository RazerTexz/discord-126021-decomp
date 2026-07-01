package d0.e0.p.d.m0.e.a;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final d0.e0.p.d.m0.g.b access$child(d0.e0.p.d.m0.g.b bVar, String str) {
        d0.e0.p.d.m0.g.b bVarChild = bVar.child(d0.e0.p.d.m0.g.e.identifier(str));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild, "child(Name.identifier(name))");
        return bVarChild;
    }

    public static final d0.e0.p.d.m0.g.b access$childSafe(d0.e0.p.d.m0.g.c cVar, String str) {
        d0.e0.p.d.m0.g.b safe = cVar.child(d0.e0.p.d.m0.g.e.identifier(str)).toSafe();
        d0.z.d.m.checkNotNullExpressionValue(safe, "child(Name.identifier(name)).toSafe()");
        return safe;
    }
}
