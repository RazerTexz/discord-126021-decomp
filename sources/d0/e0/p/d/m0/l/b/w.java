package d0.e0.p.d.m0.l.b;

/* JADX INFO: compiled from: NameResolverUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final d0.e0.p.d.m0.g.a getClassId(d0.e0.p.d.m0.f.z.c cVar, int i) {
        d0.z.d.m.checkNotNullParameter(cVar, "<this>");
        d0.e0.p.d.m0.g.a aVarFromString = d0.e0.p.d.m0.g.a.fromString(cVar.getQualifiedClassName(i), cVar.isLocalClassName(i));
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString, "fromString(getQualifiedClassName(index), isLocalClassName(index))");
        return aVarFromString;
    }

    public static final d0.e0.p.d.m0.g.e getName(d0.e0.p.d.m0.f.z.c cVar, int i) {
        d0.z.d.m.checkNotNullParameter(cVar, "<this>");
        d0.e0.p.d.m0.g.e eVarGuessByFirstCharacter = d0.e0.p.d.m0.g.e.guessByFirstCharacter(cVar.getString(i));
        d0.z.d.m.checkNotNullExpressionValue(eVarGuessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return eVarGuessByFirstCharacter;
    }
}
