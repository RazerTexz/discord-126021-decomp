package d0.e0.p.d.m0.e.b;

/* JADX INFO: compiled from: methodSignatureBuildingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static final String signature(w wVar, d0.e0.p.d.m0.c.e eVar, String str) {
        d0.z.d.m.checkNotNullParameter(wVar, "<this>");
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        d0.z.d.m.checkNotNullParameter(str, "jvmDescriptor");
        return wVar.signature(u.getInternalName(eVar), str);
    }
}
