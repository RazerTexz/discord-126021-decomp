package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.o */
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11295o {

    /* JADX INFO: renamed from: a */
    public static final C11295o f22584a = new C11295o();

    /* JADX INFO: renamed from: b */
    public static final Set<C11716e> f22585b;

    /* JADX INFO: renamed from: c */
    public static final HashMap<C11712a, C11712a> f22586c;

    /* JADX INFO: renamed from: d */
    public static final HashMap<C11712a, C11712a> f22587d;

    /* JADX INFO: renamed from: e */
    public static final Set<C11716e> f22588e;

    static {
        EnumC11294n[] enumC11294nArrValues = EnumC11294n.values();
        ArrayList arrayList = new ArrayList(4);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList.add(enumC11294nArrValues[i2].getTypeName());
        }
        f22585b = C12163u.toSet(arrayList);
        EnumC11293m[] enumC11293mArrValues = EnumC11293m.values();
        ArrayList arrayList2 = new ArrayList(4);
        for (int i3 = 0; i3 < 4; i3++) {
            arrayList2.add(enumC11293mArrValues[i3].getTypeName());
        }
        C12163u.toSet(arrayList2);
        f22586c = new HashMap<>();
        f22587d = new HashMap<>();
        C12136h0.hashMapOf(C12116o.m10073to(EnumC11293m.f22574j, C11716e.identifier("ubyteArrayOf")), C12116o.m10073to(EnumC11293m.f22575k, C11716e.identifier("ushortArrayOf")), C12116o.m10073to(EnumC11293m.f22576l, C11716e.identifier("uintArrayOf")), C12116o.m10073to(EnumC11293m.f22577m, C11716e.identifier("ulongArrayOf")));
        EnumC11294n[] enumC11294nArrValues2 = EnumC11294n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i4 = 0; i4 < 4; i4++) {
            linkedHashSet.add(enumC11294nArrValues2[i4].getArrayClassId().getShortClassName());
        }
        f22588e = linkedHashSet;
        EnumC11294n[] enumC11294nArrValues3 = EnumC11294n.values();
        while (i < 4) {
            EnumC11294n enumC11294n = enumC11294nArrValues3[i];
            i++;
            f22586c.put(enumC11294n.getArrayClassId(), enumC11294n.getClassId());
            f22587d.put(enumC11294n.getClassId(), enumC11294n.getArrayClassId());
        }
    }

    public static final boolean isUnsignedType(AbstractC11913c0 abstractC11913c0) {
        InterfaceC11352h declarationDescriptor;
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        if (C11920e1.noExpectedType(abstractC11913c0) || (declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor()) == null) {
            return false;
        }
        return f22584a.isUnsignedClass(declarationDescriptor);
    }

    public final C11712a getUnsignedClassIdByArrayClassId(C11712a c11712a) {
        C12238m.checkNotNullParameter(c11712a, "arrayClassId");
        return f22586c.get(c11712a);
    }

    public final boolean isShortNameOfUnsignedArray(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return f22588e.contains(c11716e);
    }

    public final boolean isUnsignedClass(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "descriptor");
        InterfaceC11450m containingDeclaration = interfaceC11450m.getContainingDeclaration();
        return (containingDeclaration instanceof InterfaceC11331e0) && C12238m.areEqual(((InterfaceC11331e0) containingDeclaration).getFqName(), C11291k.f22499l) && f22585b.contains(interfaceC11450m.getName());
    }
}
