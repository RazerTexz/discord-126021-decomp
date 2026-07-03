package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.g */
/* JADX INFO: compiled from: TypeTable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11708g {

    /* JADX INFO: renamed from: a */
    public final List<C11692q> f24061a;

    public C11708g(C11695t c11695t) {
        C12238m.checkNotNullParameter(c11695t, "typeTable");
        List<C11692q> typeList = c11695t.getTypeList();
        if (c11695t.hasFirstNullable()) {
            int firstNullable = c11695t.getFirstNullable();
            List<C11692q> typeList2 = c11695t.getTypeList();
            C12238m.checkNotNullExpressionValue(typeList2, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(typeList2, 10));
            int i = 0;
            for (Object obj : typeList2) {
                int i2 = i + 1;
                if (i < 0) {
                    C12147n.throwIndexOverflow();
                }
                C11692q c11692qBuild = (C11692q) obj;
                if (i >= firstNullable) {
                    c11692qBuild = c11692qBuild.toBuilder().setNullable(true).build();
                }
                arrayList.add(c11692qBuild);
                i = i2;
            }
            typeList = arrayList;
        }
        C12238m.checkNotNullExpressionValue(typeList, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.f24061a = typeList;
    }

    public final C11692q get(int i) {
        return this.f24061a.get(i);
    }
}
