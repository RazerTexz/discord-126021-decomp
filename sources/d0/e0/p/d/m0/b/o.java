package d0.e0.p.d.m0.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.t.h0;
import d0.t.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final o a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<d0.e0.p.d.m0.g.e> f3232b;
    public static final HashMap<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.g.a> c;
    public static final HashMap<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.g.a> d;
    public static final Set<d0.e0.p.d.m0.g.e> e;

    static {
        n[] nVarArrValues = n.values();
        ArrayList arrayList = new ArrayList(4);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList.add(nVarArrValues[i2].getTypeName());
        }
        f3232b = u.toSet(arrayList);
        m[] mVarArrValues = m.values();
        ArrayList arrayList2 = new ArrayList(4);
        for (int i3 = 0; i3 < 4; i3++) {
            arrayList2.add(mVarArrValues[i3].getTypeName());
        }
        u.toSet(arrayList2);
        c = new HashMap<>();
        d = new HashMap<>();
        h0.hashMapOf(d0.o.to(m.j, d0.e0.p.d.m0.g.e.identifier("ubyteArrayOf")), d0.o.to(m.k, d0.e0.p.d.m0.g.e.identifier("ushortArrayOf")), d0.o.to(m.l, d0.e0.p.d.m0.g.e.identifier("uintArrayOf")), d0.o.to(m.m, d0.e0.p.d.m0.g.e.identifier("ulongArrayOf")));
        n[] nVarArrValues2 = n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i4 = 0; i4 < 4; i4++) {
            linkedHashSet.add(nVarArrValues2[i4].getArrayClassId().getShortClassName());
        }
        e = linkedHashSet;
        n[] nVarArrValues3 = n.values();
        while (i < 4) {
            n nVar = nVarArrValues3[i];
            i++;
            c.put(nVar.getArrayClassId(), nVar.getClassId());
            d.put(nVar.getClassId(), nVar.getArrayClassId());
        }
    }

    public static final boolean isUnsignedType(c0 c0Var) {
        d0.e0.p.d.m0.c.h declarationDescriptor;
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        if (e1.noExpectedType(c0Var) || (declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor()) == null) {
            return false;
        }
        return a.isUnsignedClass(declarationDescriptor);
    }

    public final d0.e0.p.d.m0.g.a getUnsignedClassIdByArrayClassId(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "arrayClassId");
        return c.get(aVar);
    }

    public final boolean isShortNameOfUnsignedArray(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return e.contains(eVar);
    }

    public final boolean isUnsignedClass(d0.e0.p.d.m0.c.m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "descriptor");
        d0.e0.p.d.m0.c.m containingDeclaration = mVar.getContainingDeclaration();
        return (containingDeclaration instanceof e0) && d0.z.d.m.areEqual(((e0) containingDeclaration).getFqName(), k.l) && f3232b.contains(mVar.getName());
    }
}
