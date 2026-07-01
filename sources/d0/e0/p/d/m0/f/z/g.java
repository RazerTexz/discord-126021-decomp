package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.t;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TypeTable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final List<q> a;

    public g(t tVar) {
        m.checkNotNullParameter(tVar, "typeTable");
        List<q> typeList = tVar.getTypeList();
        if (tVar.hasFirstNullable()) {
            int firstNullable = tVar.getFirstNullable();
            List<q> typeList2 = tVar.getTypeList();
            m.checkNotNullExpressionValue(typeList2, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(typeList2, 10));
            int i = 0;
            for (Object obj : typeList2) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                q qVarBuild = (q) obj;
                if (i >= firstNullable) {
                    qVarBuild = qVarBuild.toBuilder().setNullable(true).build();
                }
                arrayList.add(qVarBuild);
                i = i2;
            }
            typeList = arrayList;
        }
        m.checkNotNullExpressionValue(typeList, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.a = typeList;
    }

    public final q get(int i) {
        return this.a.get(i);
    }
}
