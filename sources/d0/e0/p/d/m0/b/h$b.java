package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.n.j0;
import java.util.EnumMap;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KotlinBuiltIns.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$b implements Function0<h$e> {
    public final /* synthetic */ h j;

    public h$b(h hVar) {
        this.j = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ h$e invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public h$e invoke() {
        EnumMap enumMap = new EnumMap(i.class);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        i[] iVarArrValuesCustom = i.valuesCustom();
        for (int i = 0; i < 8; i++) {
            i iVar = iVarArrValuesCustom[i];
            j0 j0VarB = h.b(this.j, iVar.getTypeName().asString());
            j0 j0VarB2 = h.b(this.j, iVar.getArrayTypeName().asString());
            enumMap.put(iVar, j0VarB2);
            map.put(j0VarB, j0VarB2);
            map2.put(j0VarB2, j0VarB);
        }
        return new h$e(enumMap, map, map2, null);
    }
}
