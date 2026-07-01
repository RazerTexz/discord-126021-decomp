package d0.e0.p.d.m0.k;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.j0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.v0;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: DescriptorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    static {
        new d0.e0.p.d.m0.g.b("kotlin.jvm.JvmName");
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 21:
            case 22:
            case 32:
            case 33:
            case 34:
            case 55:
            case 56:
            case 57:
            case 59:
            case 77:
            case 90:
            case 92:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 14:
                objArr[0] = "first";
                break;
            case 15:
                objArr[0] = "second";
                break;
            case 16:
            case 17:
                objArr[0] = "aClass";
                break;
            case 18:
                objArr[0] = "kotlinType";
                break;
            case 23:
                objArr[0] = "declarationDescriptor";
                break;
            case 24:
            case 26:
                objArr[0] = "subClass";
                break;
            case 25:
            case 27:
            case 31:
                objArr[0] = "superClass";
                break;
            case 28:
            case 30:
            case 43:
            case 62:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = "other";
                break;
            case 35:
                objArr[0] = "classKind";
                break;
            case 36:
            case 37:
            case 39:
            case 42:
            case 46:
            case 52:
            case 63:
            case 64:
            case 65:
            case 72:
            case 73:
                objArr[0] = "classDescriptor";
                break;
            case 44:
                objArr[0] = "typeConstructor";
                break;
            case 53:
                objArr[0] = "innerClassName";
                break;
            case 54:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                break;
            case 61:
                objArr[0] = "variable";
                break;
            case 66:
                objArr[0] = "f";
                break;
            case 68:
                objArr[0] = "current";
                break;
            case 69:
                objArr[0] = "result";
                break;
            case 70:
                objArr[0] = "memberDescriptor";
                break;
            case 74:
            case 75:
            case 76:
                objArr[0] = "annotated";
                break;
            case 80:
            case 82:
            case 85:
            case 87:
                objArr[0] = "scope";
                break;
            case 83:
            case 86:
            case 88:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 20:
                objArr[1] = "getContainingModule";
                break;
            case 38:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 40:
            case 41:
                objArr[1] = "getSuperClassType";
                break;
            case 45:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 58:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 67:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 78:
            case 79:
                objArr[1] = "getContainingSourceFile";
                break;
            case 81:
                objArr[1] = "getAllDescriptors";
                break;
            case 84:
                objArr[1] = "getFunctionByName";
                break;
            case 89:
                objArr[1] = "getPropertyByName";
                break;
            case 91:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "isExtension";
                break;
            case 12:
                objArr[2] = "isOverride";
                break;
            case 13:
                objArr[2] = "isStaticDeclaration";
                break;
            case 14:
            case 15:
                objArr[2] = "areInSameModule";
                break;
            case 16:
            case 17:
                objArr[2] = "getParentOfType";
                break;
            case 18:
            case 21:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 19:
                objArr[2] = "getContainingModule";
                break;
            case 22:
                objArr[2] = "getContainingClass";
                break;
            case 23:
                objArr[2] = "isAncestor";
                break;
            case 24:
            case 25:
                objArr[2] = "isDirectSubclass";
                break;
            case 26:
            case 27:
                objArr[2] = "isSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSameClass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 32:
                objArr[2] = "isAnonymousObject";
                break;
            case 33:
                objArr[2] = "isAnonymousFunction";
                break;
            case 34:
                objArr[2] = "isEnumEntry";
                break;
            case 35:
                objArr[2] = "isKindOf";
                break;
            case 36:
                objArr[2] = "hasAbstractMembers";
                break;
            case 37:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 39:
                objArr[2] = "getSuperClassType";
                break;
            case 42:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 43:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 44:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 46:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 52:
            case 53:
            case 54:
                objArr[2] = "getInnerClassByName";
                break;
            case 55:
                objArr[2] = "isStaticNestedClass";
                break;
            case 56:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 57:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 61:
            case 62:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 63:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 64:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 65:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 66:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 68:
            case 69:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 70:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 72:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 73:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 74:
                objArr[2] = "getJvmName";
                break;
            case 75:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 76:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 77:
                objArr[2] = "getContainingSourceFile";
                break;
            case 80:
                objArr[2] = "getAllDescriptors";
                break;
            case 82:
            case 83:
                objArr[2] = "getFunctionByName";
                break;
            case 85:
            case 86:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 87:
            case 88:
                objArr[2] = "getPropertyByName";
                break;
            case 90:
                objArr[2] = "getDirectMember";
                break;
            case 92:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean areInSameModule(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
        if (mVar == null) {
            a(14);
            throw null;
        }
        if (mVar2 != null) {
            return getContainingModule(mVar).equals(getContainingModule(mVar2));
        }
        a(15);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <D extends d0.e0.p.d.m0.c.a> void b(D d, Set<D> set) {
        if (d == null) {
            a(68);
            throw null;
        }
        if (set.contains(d)) {
            return;
        }
        Iterator<? extends d0.e0.p.d.m0.c.a> it = d.getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.a original = it.next().getOriginal();
            b(original, set);
            set.add(original);
        }
    }

    public static d0.e0.p.d.m0.g.b c(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(5);
            throw null;
        }
        if ((mVar instanceof c0) || d0.e0.p.d.m0.n.t.isError(mVar)) {
            return d0.e0.p.d.m0.g.b.a;
        }
        if (mVar instanceof j0) {
            return ((j0) mVar).getFqName();
        }
        if (mVar instanceof e0) {
            return ((e0) mVar).getFqName();
        }
        return null;
    }

    public static d0.e0.p.d.m0.g.c d(d0.e0.p.d.m0.c.m mVar) {
        d0.e0.p.d.m0.g.c cVarChild = getFqName(mVar.getContainingDeclaration()).child(mVar.getName());
        if (cVarChild != null) {
            return cVarChild;
        }
        a(7);
        throw null;
    }

    public static boolean e(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.f fVar) {
        return (mVar instanceof d0.e0.p.d.m0.c.e) && ((d0.e0.p.d.m0.c.e) mVar).getKind() == fVar;
    }

    public static boolean f(d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.c.m mVar) {
        if (c0Var == null) {
            a(28);
            throw null;
        }
        if (mVar == null) {
            a(29);
            throw null;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        d0.e0.p.d.m0.c.m original = declarationDescriptor.getOriginal();
        return (original instanceof d0.e0.p.d.m0.c.h) && (mVar instanceof d0.e0.p.d.m0.c.h) && ((d0.e0.p.d.m0.c.h) mVar).getTypeConstructor().equals(((d0.e0.p.d.m0.c.h) original).getTypeConstructor());
    }

    public static <D extends d0.e0.p.d.m0.c.a> Set<D> getAllOverriddenDescriptors(D d) {
        if (d == null) {
            a(66);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b(d.getOriginal(), linkedHashSet);
        return linkedHashSet;
    }

    public static d0.e0.p.d.m0.c.e getClassDescriptorForType(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var != null) {
            return getClassDescriptorForTypeConstructor(c0Var.getConstructor());
        }
        a(43);
        throw null;
    }

    public static d0.e0.p.d.m0.c.e getClassDescriptorForTypeConstructor(u0 u0Var) {
        if (u0Var == null) {
            a(44);
            throw null;
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) u0Var.getDeclarationDescriptor();
        if (eVar != null) {
            return eVar;
        }
        a(45);
        throw null;
    }

    public static c0 getContainingModule(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(19);
            throw null;
        }
        c0 containingModuleOrNull = getContainingModuleOrNull(mVar);
        if (containingModuleOrNull != null) {
            return containingModuleOrNull;
        }
        a(20);
        throw null;
    }

    public static c0 getContainingModuleOrNull(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var == null) {
            a(18);
            throw null;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return null;
        }
        return getContainingModuleOrNull(declarationDescriptor);
    }

    public static v0 getContainingSourceFile(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(77);
            throw null;
        }
        if (mVar instanceof p0) {
            mVar = ((p0) mVar).getCorrespondingProperty();
        }
        if (!(mVar instanceof d0.e0.p.d.m0.c.p)) {
            return v0.a;
        }
        v0 containingFile = ((d0.e0.p.d.m0.c.p) mVar).getSource().getContainingFile();
        if (containingFile != null) {
            return containingFile;
        }
        a(78);
        throw null;
    }

    public static u getDefaultConstructorVisibility(d0.e0.p.d.m0.c.e eVar, boolean z2) {
        if (eVar == null) {
            a(46);
            throw null;
        }
        d0.e0.p.d.m0.c.f kind = eVar.getKind();
        if (kind == d0.e0.p.d.m0.c.f.ENUM_CLASS || kind.isSingleton()) {
            u uVar = d0.e0.p.d.m0.c.t.a;
            if (uVar != null) {
                return uVar;
            }
            a(47);
            throw null;
        }
        if (isSealedClass(eVar)) {
            if (z2) {
                u uVar2 = d0.e0.p.d.m0.c.t.d;
                if (uVar2 != null) {
                    return uVar2;
                }
                a(48);
                throw null;
            }
            u uVar3 = d0.e0.p.d.m0.c.t.a;
            if (uVar3 != null) {
                return uVar3;
            }
            a(49);
            throw null;
        }
        if (isAnonymousObject(eVar)) {
            u uVar4 = d0.e0.p.d.m0.c.t.k;
            if (uVar4 != null) {
                return uVar4;
            }
            a(50);
            throw null;
        }
        u uVar5 = d0.e0.p.d.m0.c.t.e;
        if (uVar5 != null) {
            return uVar5;
        }
        a(51);
        throw null;
    }

    public static q0 getDispatchReceiverParameterIfNeeded(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (mVar instanceof d0.e0.p.d.m0.c.e) {
            return ((d0.e0.p.d.m0.c.e) mVar).getThisAsReceiverParameter();
        }
        return null;
    }

    public static d0.e0.p.d.m0.g.c getFqName(d0.e0.p.d.m0.c.m mVar) {
        if (mVar != null) {
            d0.e0.p.d.m0.g.b bVarC = c(mVar);
            return bVarC != null ? bVarC.toUnsafe() : d(mVar);
        }
        a(2);
        throw null;
    }

    public static d0.e0.p.d.m0.g.b getFqNameSafe(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(3);
            throw null;
        }
        d0.e0.p.d.m0.g.b bVarC = c(mVar);
        if (bVarC == null) {
            bVarC = d(mVar).toSafe();
        }
        if (bVarC != null) {
            return bVarC;
        }
        a(4);
        throw null;
    }

    public static <D extends d0.e0.p.d.m0.c.m> D getParentOfType(d0.e0.p.d.m0.c.m mVar, Class<D> cls) {
        if (cls != null) {
            return (D) getParentOfType(mVar, cls, true);
        }
        a(16);
        throw null;
    }

    public static d0.e0.p.d.m0.c.e getSuperClassDescriptor(d0.e0.p.d.m0.c.e eVar) {
        if (eVar == null) {
            a(42);
            throw null;
        }
        Iterator<d0.e0.p.d.m0.n.c0> it = eVar.getTypeConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.e classDescriptorForType = getClassDescriptorForType(it.next());
            if (classDescriptorForType.getKind() != d0.e0.p.d.m0.c.f.INTERFACE) {
                return classDescriptorForType;
            }
        }
        return null;
    }

    public static boolean isAnnotationClass(d0.e0.p.d.m0.c.m mVar) {
        return e(mVar, d0.e0.p.d.m0.c.f.ANNOTATION_CLASS);
    }

    public static boolean isAnonymousObject(d0.e0.p.d.m0.c.m mVar) {
        if (mVar != null) {
            return isClass(mVar) && mVar.getName().equals(d0.e0.p.d.m0.g.g.a);
        }
        a(32);
        throw null;
    }

    public static boolean isClass(d0.e0.p.d.m0.c.m mVar) {
        return e(mVar, d0.e0.p.d.m0.c.f.CLASS);
    }

    public static boolean isClassOrEnumClass(d0.e0.p.d.m0.c.m mVar) {
        return isClass(mVar) || isEnumClass(mVar);
    }

    public static boolean isCompanionObject(d0.e0.p.d.m0.c.m mVar) {
        return e(mVar, d0.e0.p.d.m0.c.f.OBJECT) && ((d0.e0.p.d.m0.c.e) mVar).isCompanionObject();
    }

    public static boolean isDescriptorWithLocalVisibility(d0.e0.p.d.m0.c.m mVar) {
        return (mVar instanceof d0.e0.p.d.m0.c.q) && ((d0.e0.p.d.m0.c.q) mVar).getVisibility() == d0.e0.p.d.m0.c.t.f;
    }

    public static boolean isDirectSubclass(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        if (eVar == null) {
            a(24);
            throw null;
        }
        if (eVar2 == null) {
            a(25);
            throw null;
        }
        Iterator<d0.e0.p.d.m0.n.c0> it = eVar.getTypeConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            if (f(it.next(), eVar2.getOriginal())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnumClass(d0.e0.p.d.m0.c.m mVar) {
        return e(mVar, d0.e0.p.d.m0.c.f.ENUM_CLASS);
    }

    public static boolean isEnumEntry(d0.e0.p.d.m0.c.m mVar) {
        if (mVar != null) {
            return e(mVar, d0.e0.p.d.m0.c.f.ENUM_ENTRY);
        }
        a(34);
        throw null;
    }

    public static boolean isInterface(d0.e0.p.d.m0.c.m mVar) {
        return e(mVar, d0.e0.p.d.m0.c.f.INTERFACE);
    }

    public static boolean isLocal(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(1);
            throw null;
        }
        while (mVar != null) {
            if (isAnonymousObject(mVar) || isDescriptorWithLocalVisibility(mVar)) {
                return true;
            }
            mVar = mVar.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isSealedClass(d0.e0.p.d.m0.c.m mVar) {
        return (e(mVar, d0.e0.p.d.m0.c.f.CLASS) || e(mVar, d0.e0.p.d.m0.c.f.INTERFACE)) && ((d0.e0.p.d.m0.c.e) mVar).getModality() == z.SEALED;
    }

    public static boolean isSubclass(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        if (eVar == null) {
            a(26);
            throw null;
        }
        if (eVar2 != null) {
            return isSubtypeOfClass(eVar.getDefaultType(), eVar2.getOriginal());
        }
        a(27);
        throw null;
    }

    public static boolean isSubtypeOfClass(d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.c.m mVar) {
        if (c0Var == null) {
            a(30);
            throw null;
        }
        if (mVar == null) {
            a(31);
            throw null;
        }
        if (f(c0Var, mVar)) {
            return true;
        }
        Iterator<d0.e0.p.d.m0.n.c0> it = c0Var.getConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            if (isSubtypeOfClass(it.next(), mVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTopLevelDeclaration(d0.e0.p.d.m0.c.m mVar) {
        return mVar != null && (mVar.getContainingDeclaration() instanceof e0);
    }

    public static boolean shouldRecordInitializerForProperty(d1 d1Var, d0.e0.p.d.m0.n.c0 c0Var) {
        if (d1Var == null) {
            a(61);
            throw null;
        }
        if (c0Var == null) {
            a(62);
            throw null;
        }
        if (d1Var.isVar() || d0.e0.p.d.m0.n.e0.isError(c0Var)) {
            return false;
        }
        if (e1.acceptsNullable(c0Var)) {
            return true;
        }
        d0.e0.p.d.m0.b.h builtIns = d0.e0.p.d.m0.k.x.a.getBuiltIns(d1Var);
        if (!d0.e0.p.d.m0.b.h.isPrimitiveType(c0Var)) {
            d0.e0.p.d.m0.n.l1.f fVar = d0.e0.p.d.m0.n.l1.f.a;
            if (!fVar.equalTypes(builtIns.getStringType(), c0Var) && !fVar.equalTypes(builtIns.getNumber().getDefaultType(), c0Var) && !fVar.equalTypes(builtIns.getAnyType(), c0Var)) {
                d0.e0.p.d.m0.b.o oVar = d0.e0.p.d.m0.b.o.a;
                if (!d0.e0.p.d.m0.b.o.isUnsignedType(c0Var)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <D extends d0.e0.p.d.m0.c.b> D unwrapFakeOverride(D d) {
        if (d == null) {
            a(57);
            throw null;
        }
        while (d.getKind() == d0.e0.p.d.m0.c.b$a.FAKE_OVERRIDE) {
            Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = d.getOverriddenDescriptors();
            if (overriddenDescriptors.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d);
            }
            d = (D) overriddenDescriptors.iterator().next();
        }
        return d;
    }

    public static <D extends d0.e0.p.d.m0.c.q> D unwrapFakeOverrideToAnyDeclaration(D d) {
        if (d == null) {
            a(59);
            throw null;
        }
        if (d instanceof d0.e0.p.d.m0.c.b) {
            return unwrapFakeOverride((d0.e0.p.d.m0.c.b) d);
        }
        if (d != null) {
            return d;
        }
        a(60);
        throw null;
    }

    public static <D extends d0.e0.p.d.m0.c.m> D getParentOfType(d0.e0.p.d.m0.c.m mVar, Class<D> cls, boolean z2) {
        if (cls == null) {
            a(17);
            throw null;
        }
        if (mVar == null) {
            return null;
        }
        if (z2) {
            mVar = (D) mVar.getContainingDeclaration();
        }
        while (mVar != null) {
            if (cls.isInstance(mVar)) {
                return (D) mVar;
            }
            mVar = (D) mVar.getContainingDeclaration();
        }
        return null;
    }

    public static c0 getContainingModuleOrNull(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(21);
            throw null;
        }
        while (mVar != null) {
            if (mVar instanceof c0) {
                return (c0) mVar;
            }
            if (mVar instanceof j0) {
                return ((j0) mVar).getModule();
            }
            mVar = mVar.getContainingDeclaration();
        }
        return null;
    }
}
