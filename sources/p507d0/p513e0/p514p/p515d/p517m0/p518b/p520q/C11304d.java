package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.d */
/* JADX INFO: compiled from: JavaToKotlinClassMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11304d {

    /* JADX INFO: renamed from: a */
    public static final C11304d f22630a = new C11304d();

    public static /* synthetic */ InterfaceC11330e mapJavaToKotlin$default(C11304d c11304d, C11713b c11713b, AbstractC11288h abstractC11288h, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return c11304d.mapJavaToKotlin(c11713b, abstractC11288h, num);
    }

    public final InterfaceC11330e convertMutableToReadOnly(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "mutable");
        C11713b c11713bMutableToReadOnly = C11303c.f22614a.mutableToReadOnly(C11787e.getFqName(interfaceC11330e));
        if (c11713bMutableToReadOnly != null) {
            InterfaceC11330e builtInClassByFqName = C11836a.getBuiltIns(interfaceC11330e).getBuiltInClassByFqName(c11713bMutableToReadOnly);
            C12238m.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + interfaceC11330e + " is not a mutable collection");
    }

    public final InterfaceC11330e convertReadOnlyToMutable(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "readOnly");
        C11713b onlyToMutable = C11303c.f22614a.readOnlyToMutable(C11787e.getFqName(interfaceC11330e));
        if (onlyToMutable != null) {
            InterfaceC11330e builtInClassByFqName = C11836a.getBuiltIns(interfaceC11330e).getBuiltInClassByFqName(onlyToMutable);
            C12238m.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + interfaceC11330e + " is not a read-only collection");
    }

    public final boolean isMutable(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "mutable");
        return C11303c.f22614a.isMutable(C11787e.getFqName(interfaceC11330e));
    }

    public final boolean isReadOnly(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "readOnly");
        return C11303c.f22614a.isReadOnly(C11787e.getFqName(interfaceC11330e));
    }

    public final InterfaceC11330e mapJavaToKotlin(C11713b c11713b, AbstractC11288h abstractC11288h, Integer num) {
        C11712a c11712aMapJavaToKotlin;
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        if (num == null || !C12238m.areEqual(c11713b, C11303c.f22614a.getFUNCTION_N_FQ_NAME())) {
            c11712aMapJavaToKotlin = C11303c.f22614a.mapJavaToKotlin(c11713b);
        } else {
            C11291k c11291k = C11291k.f22488a;
            c11712aMapJavaToKotlin = C11291k.getFunctionClassId(num.intValue());
        }
        if (c11712aMapJavaToKotlin != null) {
            return abstractC11288h.getBuiltInClassByFqName(c11712aMapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    public final Collection<InterfaceC11330e> mapPlatformClass(C11713b c11713b, AbstractC11288h abstractC11288h) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        InterfaceC11330e interfaceC11330eMapJavaToKotlin$default = mapJavaToKotlin$default(this, c11713b, abstractC11288h, null, 4, null);
        if (interfaceC11330eMapJavaToKotlin$default == null) {
            return C12148n0.emptySet();
        }
        C11713b onlyToMutable = C11303c.f22614a.readOnlyToMutable(C11836a.getFqNameUnsafe(interfaceC11330eMapJavaToKotlin$default));
        if (onlyToMutable == null) {
            return C12146m0.setOf(interfaceC11330eMapJavaToKotlin$default);
        }
        InterfaceC11330e builtInClassByFqName = abstractC11288h.getBuiltInClassByFqName(onlyToMutable);
        C12238m.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        return C12147n.listOf((Object[]) new InterfaceC11330e[]{interfaceC11330eMapJavaToKotlin$default, builtInClassByFqName});
    }

    public final boolean isMutable(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        InterfaceC11330e classDescriptor = C11920e1.getClassDescriptor(abstractC11913c0);
        return classDescriptor != null && isMutable(classDescriptor);
    }

    public final boolean isReadOnly(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        InterfaceC11330e classDescriptor = C11920e1.getClassDescriptor(abstractC11913c0);
        return classDescriptor != null && isReadOnly(classDescriptor);
    }
}
