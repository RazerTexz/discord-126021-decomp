package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11295o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11718g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.e */
/* JADX INFO: compiled from: DescriptorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11787e {
    static {
        new C11713b("kotlin.jvm.JvmName");
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9923a(int i) {
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

    public static boolean areInSameModule(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
        if (interfaceC11450m == null) {
            m9923a(14);
            throw null;
        }
        if (interfaceC11450m2 != null) {
            return getContainingModule(interfaceC11450m).equals(getContainingModule(interfaceC11450m2));
        }
        m9923a(15);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public static <D extends InterfaceC11318a> void m9924b(D d, Set<D> set) {
        if (d == null) {
            m9923a(68);
            throw null;
        }
        if (set.contains(d)) {
            return;
        }
        Iterator<? extends InterfaceC11318a> it = d.getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            InterfaceC11318a original = it.next().getOriginal();
            m9924b(original, set);
            set.add(original);
        }
    }

    /* JADX INFO: renamed from: c */
    public static C11713b m9925c(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9923a(5);
            throw null;
        }
        if ((interfaceC11450m instanceof InterfaceC11325c0) || C12005t.isError(interfaceC11450m)) {
            return C11713b.f24079a;
        }
        if (interfaceC11450m instanceof InterfaceC11402j0) {
            return ((InterfaceC11402j0) interfaceC11450m).getFqName();
        }
        if (interfaceC11450m instanceof InterfaceC11331e0) {
            return ((InterfaceC11331e0) interfaceC11450m).getFqName();
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static C11714c m9926d(InterfaceC11450m interfaceC11450m) {
        C11714c c11714cChild = getFqName(interfaceC11450m.getContainingDeclaration()).child(interfaceC11450m.getName());
        if (c11714cChild != null) {
            return c11714cChild;
        }
        m9923a(7);
        throw null;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m9927e(InterfaceC11450m interfaceC11450m, EnumC11333f enumC11333f) {
        return (interfaceC11450m instanceof InterfaceC11330e) && ((InterfaceC11330e) interfaceC11450m).getKind() == enumC11333f;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m9928f(AbstractC11913c0 abstractC11913c0, InterfaceC11450m interfaceC11450m) {
        if (abstractC11913c0 == null) {
            m9923a(28);
            throw null;
        }
        if (interfaceC11450m == null) {
            m9923a(29);
            throw null;
        }
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        InterfaceC11450m original = declarationDescriptor.getOriginal();
        return (original instanceof InterfaceC11352h) && (interfaceC11450m instanceof InterfaceC11352h) && ((InterfaceC11352h) interfaceC11450m).getTypeConstructor().equals(((InterfaceC11352h) original).getTypeConstructor());
    }

    public static <D extends InterfaceC11318a> Set<D> getAllOverriddenDescriptors(D d) {
        if (d == null) {
            m9923a(66);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m9924b(d.getOriginal(), linkedHashSet);
        return linkedHashSet;
    }

    public static InterfaceC11330e getClassDescriptorForType(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 != null) {
            return getClassDescriptorForTypeConstructor(abstractC11913c0.getConstructor());
        }
        m9923a(43);
        throw null;
    }

    public static InterfaceC11330e getClassDescriptorForTypeConstructor(InterfaceC12008u0 interfaceC12008u0) {
        if (interfaceC12008u0 == null) {
            m9923a(44);
            throw null;
        }
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) interfaceC12008u0.getDeclarationDescriptor();
        if (interfaceC11330e != null) {
            return interfaceC11330e;
        }
        m9923a(45);
        throw null;
    }

    public static InterfaceC11325c0 getContainingModule(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9923a(19);
            throw null;
        }
        InterfaceC11325c0 containingModuleOrNull = getContainingModuleOrNull(interfaceC11450m);
        if (containingModuleOrNull != null) {
            return containingModuleOrNull;
        }
        m9923a(20);
        throw null;
    }

    public static InterfaceC11325c0 getContainingModuleOrNull(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m9923a(18);
            throw null;
        }
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return null;
        }
        return getContainingModuleOrNull(declarationDescriptor);
    }

    public static InterfaceC11469v0 getContainingSourceFile(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9923a(77);
            throw null;
        }
        if (interfaceC11450m instanceof InterfaceC11457p0) {
            interfaceC11450m = ((InterfaceC11457p0) interfaceC11450m).getCorrespondingProperty();
        }
        if (!(interfaceC11450m instanceof InterfaceC11456p)) {
            return InterfaceC11469v0.f23100a;
        }
        InterfaceC11469v0 containingFile = ((InterfaceC11456p) interfaceC11450m).getSource().getContainingFile();
        if (containingFile != null) {
            return containingFile;
        }
        m9923a(78);
        throw null;
    }

    public static AbstractC11466u getDefaultConstructorVisibility(InterfaceC11330e interfaceC11330e, boolean z2) {
        if (interfaceC11330e == null) {
            m9923a(46);
            throw null;
        }
        EnumC11333f kind = interfaceC11330e.getKind();
        if (kind == EnumC11333f.ENUM_CLASS || kind.isSingleton()) {
            AbstractC11466u abstractC11466u = C11464t.f23083a;
            if (abstractC11466u != null) {
                return abstractC11466u;
            }
            m9923a(47);
            throw null;
        }
        if (isSealedClass(interfaceC11330e)) {
            if (z2) {
                AbstractC11466u abstractC11466u2 = C11464t.f23086d;
                if (abstractC11466u2 != null) {
                    return abstractC11466u2;
                }
                m9923a(48);
                throw null;
            }
            AbstractC11466u abstractC11466u3 = C11464t.f23083a;
            if (abstractC11466u3 != null) {
                return abstractC11466u3;
            }
            m9923a(49);
            throw null;
        }
        if (isAnonymousObject(interfaceC11330e)) {
            AbstractC11466u abstractC11466u4 = C11464t.f23093k;
            if (abstractC11466u4 != null) {
                return abstractC11466u4;
            }
            m9923a(50);
            throw null;
        }
        AbstractC11466u abstractC11466u5 = C11464t.f23087e;
        if (abstractC11466u5 != null) {
            return abstractC11466u5;
        }
        m9923a(51);
        throw null;
    }

    public static InterfaceC11459q0 getDispatchReceiverParameterIfNeeded(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9923a(0);
            throw null;
        }
        if (interfaceC11450m instanceof InterfaceC11330e) {
            return ((InterfaceC11330e) interfaceC11450m).getThisAsReceiverParameter();
        }
        return null;
    }

    public static C11714c getFqName(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m != null) {
            C11713b c11713bM9925c = m9925c(interfaceC11450m);
            return c11713bM9925c != null ? c11713bM9925c.toUnsafe() : m9926d(interfaceC11450m);
        }
        m9923a(2);
        throw null;
    }

    public static C11713b getFqNameSafe(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9923a(3);
            throw null;
        }
        C11713b c11713bM9925c = m9925c(interfaceC11450m);
        if (c11713bM9925c == null) {
            c11713bM9925c = m9926d(interfaceC11450m).toSafe();
        }
        if (c11713bM9925c != null) {
            return c11713bM9925c;
        }
        m9923a(4);
        throw null;
    }

    public static <D extends InterfaceC11450m> D getParentOfType(InterfaceC11450m interfaceC11450m, Class<D> cls) {
        if (cls != null) {
            return (D) getParentOfType(interfaceC11450m, cls, true);
        }
        m9923a(16);
        throw null;
    }

    public static InterfaceC11330e getSuperClassDescriptor(InterfaceC11330e interfaceC11330e) {
        if (interfaceC11330e == null) {
            m9923a(42);
            throw null;
        }
        Iterator<AbstractC11913c0> it = interfaceC11330e.getTypeConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            InterfaceC11330e classDescriptorForType = getClassDescriptorForType(it.next());
            if (classDescriptorForType.getKind() != EnumC11333f.INTERFACE) {
                return classDescriptorForType;
            }
        }
        return null;
    }

    public static boolean isAnnotationClass(InterfaceC11450m interfaceC11450m) {
        return m9927e(interfaceC11450m, EnumC11333f.ANNOTATION_CLASS);
    }

    public static boolean isAnonymousObject(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m != null) {
            return isClass(interfaceC11450m) && interfaceC11450m.getName().equals(C11718g.f24092a);
        }
        m9923a(32);
        throw null;
    }

    public static boolean isClass(InterfaceC11450m interfaceC11450m) {
        return m9927e(interfaceC11450m, EnumC11333f.CLASS);
    }

    public static boolean isClassOrEnumClass(InterfaceC11450m interfaceC11450m) {
        return isClass(interfaceC11450m) || isEnumClass(interfaceC11450m);
    }

    public static boolean isCompanionObject(InterfaceC11450m interfaceC11450m) {
        return m9927e(interfaceC11450m, EnumC11333f.OBJECT) && ((InterfaceC11330e) interfaceC11450m).isCompanionObject();
    }

    public static boolean isDescriptorWithLocalVisibility(InterfaceC11450m interfaceC11450m) {
        return (interfaceC11450m instanceof InterfaceC11458q) && ((InterfaceC11458q) interfaceC11450m).getVisibility() == C11464t.f23088f;
    }

    public static boolean isDirectSubclass(InterfaceC11330e interfaceC11330e, InterfaceC11330e interfaceC11330e2) {
        if (interfaceC11330e == null) {
            m9923a(24);
            throw null;
        }
        if (interfaceC11330e2 == null) {
            m9923a(25);
            throw null;
        }
        Iterator<AbstractC11913c0> it = interfaceC11330e.getTypeConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            if (m9928f(it.next(), interfaceC11330e2.getOriginal())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnumClass(InterfaceC11450m interfaceC11450m) {
        return m9927e(interfaceC11450m, EnumC11333f.ENUM_CLASS);
    }

    public static boolean isEnumEntry(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m != null) {
            return m9927e(interfaceC11450m, EnumC11333f.ENUM_ENTRY);
        }
        m9923a(34);
        throw null;
    }

    public static boolean isInterface(InterfaceC11450m interfaceC11450m) {
        return m9927e(interfaceC11450m, EnumC11333f.INTERFACE);
    }

    public static boolean isLocal(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9923a(1);
            throw null;
        }
        while (interfaceC11450m != null) {
            if (isAnonymousObject(interfaceC11450m) || isDescriptorWithLocalVisibility(interfaceC11450m)) {
                return true;
            }
            interfaceC11450m = interfaceC11450m.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isSealedClass(InterfaceC11450m interfaceC11450m) {
        return (m9927e(interfaceC11450m, EnumC11333f.CLASS) || m9927e(interfaceC11450m, EnumC11333f.INTERFACE)) && ((InterfaceC11330e) interfaceC11450m).getModality() == EnumC11476z.SEALED;
    }

    public static boolean isSubclass(InterfaceC11330e interfaceC11330e, InterfaceC11330e interfaceC11330e2) {
        if (interfaceC11330e == null) {
            m9923a(26);
            throw null;
        }
        if (interfaceC11330e2 != null) {
            return isSubtypeOfClass(interfaceC11330e.getDefaultType(), interfaceC11330e2.getOriginal());
        }
        m9923a(27);
        throw null;
    }

    public static boolean isSubtypeOfClass(AbstractC11913c0 abstractC11913c0, InterfaceC11450m interfaceC11450m) {
        if (abstractC11913c0 == null) {
            m9923a(30);
            throw null;
        }
        if (interfaceC11450m == null) {
            m9923a(31);
            throw null;
        }
        if (m9928f(abstractC11913c0, interfaceC11450m)) {
            return true;
        }
        Iterator<AbstractC11913c0> it = abstractC11913c0.getConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            if (isSubtypeOfClass(it.next(), interfaceC11450m)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTopLevelDeclaration(InterfaceC11450m interfaceC11450m) {
        return interfaceC11450m != null && (interfaceC11450m.getContainingDeclaration() instanceof InterfaceC11331e0);
    }

    public static boolean shouldRecordInitializerForProperty(InterfaceC11329d1 interfaceC11329d1, AbstractC11913c0 abstractC11913c0) {
        if (interfaceC11329d1 == null) {
            m9923a(61);
            throw null;
        }
        if (abstractC11913c0 == null) {
            m9923a(62);
            throw null;
        }
        if (interfaceC11329d1.isVar() || C11919e0.isError(abstractC11913c0)) {
            return false;
        }
        if (C11920e1.acceptsNullable(abstractC11913c0)) {
            return true;
        }
        AbstractC11288h builtIns = C11836a.getBuiltIns(interfaceC11329d1);
        if (!AbstractC11288h.isPrimitiveType(abstractC11913c0)) {
            InterfaceC11946f interfaceC11946f = InterfaceC11946f.f24806a;
            if (!interfaceC11946f.equalTypes(builtIns.getStringType(), abstractC11913c0) && !interfaceC11946f.equalTypes(builtIns.getNumber().getDefaultType(), abstractC11913c0) && !interfaceC11946f.equalTypes(builtIns.getAnyType(), abstractC11913c0)) {
                C11295o c11295o = C11295o.f22584a;
                if (!C11295o.isUnsignedType(abstractC11913c0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <D extends InterfaceC11321b> D unwrapFakeOverride(D d) {
        if (d == null) {
            m9923a(57);
            throw null;
        }
        while (d.getKind() == InterfaceC11321b.a.FAKE_OVERRIDE) {
            Collection<? extends InterfaceC11321b> overriddenDescriptors = d.getOverriddenDescriptors();
            if (overriddenDescriptors.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d);
            }
            d = (D) overriddenDescriptors.iterator().next();
        }
        return d;
    }

    public static <D extends InterfaceC11458q> D unwrapFakeOverrideToAnyDeclaration(D d) {
        if (d == null) {
            m9923a(59);
            throw null;
        }
        if (d instanceof InterfaceC11321b) {
            return unwrapFakeOverride((InterfaceC11321b) d);
        }
        if (d != null) {
            return d;
        }
        m9923a(60);
        throw null;
    }

    public static <D extends InterfaceC11450m> D getParentOfType(InterfaceC11450m interfaceC11450m, Class<D> cls, boolean z2) {
        if (cls == null) {
            m9923a(17);
            throw null;
        }
        if (interfaceC11450m == null) {
            return null;
        }
        if (z2) {
            interfaceC11450m = (D) interfaceC11450m.getContainingDeclaration();
        }
        while (interfaceC11450m != null) {
            if (cls.isInstance(interfaceC11450m)) {
                return (D) interfaceC11450m;
            }
            interfaceC11450m = (D) interfaceC11450m.getContainingDeclaration();
        }
        return null;
    }

    public static InterfaceC11325c0 getContainingModuleOrNull(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9923a(21);
            throw null;
        }
        while (interfaceC11450m != null) {
            if (interfaceC11450m instanceof InterfaceC11325c0) {
                return (InterfaceC11325c0) interfaceC11450m;
            }
            if (interfaceC11450m instanceof InterfaceC11402j0) {
                return ((InterfaceC11402j0) interfaceC11450m).getModule();
            }
            interfaceC11450m = interfaceC11450m.getContainingDeclaration();
        }
        return null;
    }
}
