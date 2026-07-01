package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.t.m0;
import d0.t.n0;
import java.util.Collection;

/* JADX INFO: compiled from: JavaToKotlinClassMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final d a = new d();

    public static /* synthetic */ d0.e0.p.d.m0.c.e mapJavaToKotlin$default(d dVar, d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.b.h hVar, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return dVar.mapJavaToKotlin(bVar, hVar, num);
    }

    public final d0.e0.p.d.m0.c.e convertMutableToReadOnly(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "mutable");
        d0.e0.p.d.m0.g.b bVarMutableToReadOnly = c.a.mutableToReadOnly(d0.e0.p.d.m0.k.e.getFqName(eVar));
        if (bVarMutableToReadOnly != null) {
            d0.e0.p.d.m0.c.e builtInClassByFqName = d0.e0.p.d.m0.k.x.a.getBuiltIns(eVar).getBuiltInClassByFqName(bVarMutableToReadOnly);
            d0.z.d.m.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a mutable collection");
    }

    public final d0.e0.p.d.m0.c.e convertReadOnlyToMutable(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "readOnly");
        d0.e0.p.d.m0.g.b onlyToMutable = c.a.readOnlyToMutable(d0.e0.p.d.m0.k.e.getFqName(eVar));
        if (onlyToMutable != null) {
            d0.e0.p.d.m0.c.e builtInClassByFqName = d0.e0.p.d.m0.k.x.a.getBuiltIns(eVar).getBuiltInClassByFqName(onlyToMutable);
            d0.z.d.m.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a read-only collection");
    }

    public final boolean isMutable(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "mutable");
        return c.a.isMutable(d0.e0.p.d.m0.k.e.getFqName(eVar));
    }

    public final boolean isReadOnly(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "readOnly");
        return c.a.isReadOnly(d0.e0.p.d.m0.k.e.getFqName(eVar));
    }

    public final d0.e0.p.d.m0.c.e mapJavaToKotlin(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.b.h hVar, Integer num) {
        d0.e0.p.d.m0.g.a aVarMapJavaToKotlin;
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        if (num == null || !d0.z.d.m.areEqual(bVar, c.a.getFUNCTION_N_FQ_NAME())) {
            aVarMapJavaToKotlin = c.a.mapJavaToKotlin(bVar);
        } else {
            d0.e0.p.d.m0.b.k kVar = d0.e0.p.d.m0.b.k.a;
            aVarMapJavaToKotlin = d0.e0.p.d.m0.b.k.getFunctionClassId(num.intValue());
        }
        if (aVarMapJavaToKotlin != null) {
            return hVar.getBuiltInClassByFqName(aVarMapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    public final Collection<d0.e0.p.d.m0.c.e> mapPlatformClass(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.b.h hVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        d0.e0.p.d.m0.c.e eVarMapJavaToKotlin$default = mapJavaToKotlin$default(this, bVar, hVar, null, 4, null);
        if (eVarMapJavaToKotlin$default == null) {
            return n0.emptySet();
        }
        d0.e0.p.d.m0.g.b onlyToMutable = c.a.readOnlyToMutable(d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(eVarMapJavaToKotlin$default));
        if (onlyToMutable == null) {
            return m0.setOf(eVarMapJavaToKotlin$default);
        }
        d0.e0.p.d.m0.c.e builtInClassByFqName = hVar.getBuiltInClassByFqName(onlyToMutable);
        d0.z.d.m.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        return d0.t.n.listOf((Object[]) new d0.e0.p.d.m0.c.e[]{eVarMapJavaToKotlin$default, builtInClassByFqName});
    }

    public final boolean isMutable(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        d0.e0.p.d.m0.c.e classDescriptor = e1.getClassDescriptor(c0Var);
        return classDescriptor != null && isMutable(classDescriptor);
    }

    public final boolean isReadOnly(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        d0.e0.p.d.m0.c.e classDescriptor = e1.getClassDescriptor(c0Var);
        return classDescriptor != null && isReadOnly(classDescriptor);
    }
}
