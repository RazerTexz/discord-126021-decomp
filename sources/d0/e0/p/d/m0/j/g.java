package d0.e0.p.d.m0.j;

import d0.t.u;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum g {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);

    public static final Set<g> j;
    public static final Set<g> k;
    private final boolean includeByDefault;

    static {
        new g$a(null);
        g[] gVarArrValuesCustom = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 14; i++) {
            g gVar = gVarArrValuesCustom[i];
            if (gVar.getIncludeByDefault()) {
                arrayList.add(gVar);
            }
        }
        j = u.toSet(arrayList);
        k = d0.t.k.toSet(valuesCustom());
    }

    g(boolean z2) {
        this.includeByDefault = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static g[] valuesCustom() {
        g[] gVarArrValuesCustom = values();
        g[] gVarArr = new g[gVarArrValuesCustom.length];
        System.arraycopy(gVarArrValuesCustom, 0, gVarArr, 0, gVarArrValuesCustom.length);
        return gVarArr;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
