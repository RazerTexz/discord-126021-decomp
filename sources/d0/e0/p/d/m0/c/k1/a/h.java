package d0.e0.p.d.m0.c.k1.a;

import d0.g0.t;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final String access$toRuntimeFqName(d0.e0.p.d.m0.g.a aVar) {
        String strAsString = aVar.getRelativeClassName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "relativeClassName.asString()");
        String strReplace$default = t.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (aVar.getPackageFqName().isRoot()) {
            return strReplace$default;
        }
        return aVar.getPackageFqName() + '.' + strReplace$default;
    }
}
