package d0.e0.p.d.m0.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.o, reason: use source file name */
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UnsignedType3 {
    public static final UnsignedType3 a = new UnsignedType3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Name> f3232b;
    public static final HashMap<ClassId, ClassId> c;
    public static final HashMap<ClassId, ClassId> d;
    public static final Set<Name> e;

    static {
        UnsignedType2[] unsignedType2ArrValues = UnsignedType2.values();
        ArrayList arrayList = new ArrayList(4);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList.add(unsignedType2ArrValues[i2].getTypeName());
        }
        f3232b = _Collections.toSet(arrayList);
        UnsignedType[] unsignedTypeArrValues = UnsignedType.values();
        ArrayList arrayList2 = new ArrayList(4);
        for (int i3 = 0; i3 < 4; i3++) {
            arrayList2.add(unsignedTypeArrValues[i3].getTypeName());
        }
        _Collections.toSet(arrayList2);
        c = new HashMap<>();
        d = new HashMap<>();
        Maps6.hashMapOf(Tuples.to(UnsignedType.j, Name.identifier("ubyteArrayOf")), Tuples.to(UnsignedType.k, Name.identifier("ushortArrayOf")), Tuples.to(UnsignedType.l, Name.identifier("uintArrayOf")), Tuples.to(UnsignedType.m, Name.identifier("ulongArrayOf")));
        UnsignedType2[] unsignedType2ArrValues2 = UnsignedType2.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i4 = 0; i4 < 4; i4++) {
            linkedHashSet.add(unsignedType2ArrValues2[i4].getArrayClassId().getShortClassName());
        }
        e = linkedHashSet;
        UnsignedType2[] unsignedType2ArrValues3 = UnsignedType2.values();
        while (i < 4) {
            UnsignedType2 unsignedType2 = unsignedType2ArrValues3[i];
            i++;
            c.put(unsignedType2.getArrayClassId(), unsignedType2.getClassId());
            d.put(unsignedType2.getClassId(), unsignedType2.getArrayClassId());
        }
    }

    public static final boolean isUnsignedType(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor;
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        if (TypeUtils.noExpectedType(kotlinType) || (declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor()) == null) {
            return false;
        }
        return a.isUnsignedClass(declarationDescriptor);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "arrayClassId");
        return c.get(classId);
    }

    public final boolean isShortNameOfUnsignedArray(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return e.contains(name);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && Intrinsics3.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), StandardNames.l) && f3232b.contains(declarationDescriptor.getName());
    }
}
