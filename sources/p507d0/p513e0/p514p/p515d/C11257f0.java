package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Method;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11301a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11303c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11455o0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11431j;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11434m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11437p;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11440s;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11492d0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11632z;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.C11512c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.C11515f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.C11516g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.InterfaceC11561a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11579l;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11660u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11675h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11706e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11789g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11865j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11857b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.f0 */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11257f0 {

    /* JADX INFO: renamed from: a */
    public static final C11712a f22357a;

    /* JADX INFO: renamed from: b */
    public static final C11257f0 f22358b = new C11257f0();

    static {
        C11712a c11712a = C11712a.topLevel(new C11713b("java.lang.Void"));
        C12238m.checkNotNullExpressionValue(c11712a, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        f22357a = c11712a;
    }

    /* JADX INFO: renamed from: a */
    public final EnumC11289i m9338a(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        EnumC11840d enumC11840d = EnumC11840d.get(cls.getSimpleName());
        C12238m.checkNotNullExpressionValue(enumC11840d, "JvmPrimitiveType.get(simpleName)");
        return enumC11840d.getPrimitiveType();
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC11252d.e m9339b(InterfaceC11472x interfaceC11472x) {
        String jvmMethodNameIfSpecial = C11492d0.getJvmMethodNameIfSpecial(interfaceC11472x);
        if (jvmMethodNameIfSpecial == null) {
            if (interfaceC11472x instanceof InterfaceC11455o0) {
                String strAsString = C11836a.getPropertyIfAccessor(interfaceC11472x).getName().asString();
                C12238m.checkNotNullExpressionValue(strAsString, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = C11632z.getterName(strAsString);
            } else if (interfaceC11472x instanceof InterfaceC11457p0) {
                String strAsString2 = C11836a.getPropertyIfAccessor(interfaceC11472x).getName().asString();
                C12238m.checkNotNullExpressionValue(strAsString2, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = C11632z.setterName(strAsString2);
            } else {
                jvmMethodNameIfSpecial = interfaceC11472x.getName().asString();
                C12238m.checkNotNullExpressionValue(jvmMethodNameIfSpecial, "descriptor.name.asString()");
            }
        }
        return new AbstractC11252d.e(new AbstractC11672e.b(jvmMethodNameIfSpecial, C11660u.computeJvmDescriptor$default(interfaceC11472x, false, false, 1, null)));
    }

    public final C11712a mapJvmClassToKotlinClassId(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            C12238m.checkNotNullExpressionValue(componentType, "klass.componentType");
            EnumC11289i enumC11289iM9338a = m9338a(componentType);
            if (enumC11289iM9338a != null) {
                return new C11712a(C11291k.f22499l, enumC11289iM9338a.getArrayTypeName());
            }
            C11712a c11712a = C11712a.topLevel(C11291k.a.f22544h.toSafe());
            C12238m.checkNotNullExpressionValue(c11712a, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return c11712a;
        }
        if (C12238m.areEqual(cls, Void.TYPE)) {
            return f22357a;
        }
        EnumC11289i enumC11289iM9338a2 = m9338a(cls);
        if (enumC11289iM9338a2 != null) {
            return new C11712a(C11291k.f22499l, enumC11289iM9338a2.getTypeName());
        }
        C11712a classId = C11423b.getClassId(cls);
        if (!classId.isLocal()) {
            C11303c c11303c = C11303c.f22614a;
            C11713b c11713bAsSingleFqName = classId.asSingleFqName();
            C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName, "classId.asSingleFqName()");
            C11712a c11712aMapJavaToKotlin = c11303c.mapJavaToKotlin(c11713bAsSingleFqName);
            if (c11712aMapJavaToKotlin != null) {
                return c11712aMapJavaToKotlin;
            }
        }
        return classId;
    }

    public final AbstractC11254e mapPropertySignature(InterfaceC11453n0 interfaceC11453n0) {
        C12238m.checkNotNullParameter(interfaceC11453n0, "possiblyOverriddenProperty");
        InterfaceC11321b interfaceC11321bUnwrapFakeOverride = C11787e.unwrapFakeOverride(interfaceC11453n0);
        C12238m.checkNotNullExpressionValue(interfaceC11321bUnwrapFakeOverride, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        InterfaceC11453n0 original = ((InterfaceC11453n0) interfaceC11321bUnwrapFakeOverride).getOriginal();
        C12238m.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (original instanceof C11865j) {
            C11865j c11865j = (C11865j) original;
            C11689n proto = c11865j.getProto();
            AbstractC11727g.f<C11689n, C11667a.d> fVar = C11667a.f23654d;
            C12238m.checkNotNullExpressionValue(fVar, "JvmProtoBuf.propertySignature");
            C11667a.d dVar = (C11667a.d) C11706e.getExtensionOrNull(proto, fVar);
            if (dVar != null) {
                return new AbstractC11254e.c(original, proto, dVar, c11865j.getNameResolver(), c11865j.getTypeTable());
            }
        } else if (original instanceof C11516g) {
            InterfaceC11467u0 source = ((C11516g) original).getSource();
            if (!(source instanceof InterfaceC11561a)) {
                source = null;
            }
            InterfaceC11561a interfaceC11561a = (InterfaceC11561a) source;
            InterfaceC11579l javaElement = interfaceC11561a != null ? interfaceC11561a.getJavaElement() : null;
            if (javaElement instanceof C11437p) {
                return new AbstractC11254e.a(((C11437p) javaElement).getMember());
            }
            if (!(javaElement instanceof C11440s)) {
                throw new C11247a0("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')');
            }
            Method member = ((C11440s) javaElement).getMember();
            InterfaceC11457p0 setter = original.getSetter();
            InterfaceC11467u0 source2 = setter != null ? setter.getSource() : null;
            if (!(source2 instanceof InterfaceC11561a)) {
                source2 = null;
            }
            InterfaceC11561a interfaceC11561a2 = (InterfaceC11561a) source2;
            InterfaceC11579l javaElement2 = interfaceC11561a2 != null ? interfaceC11561a2.getJavaElement() : null;
            if (!(javaElement2 instanceof C11440s)) {
                javaElement2 = null;
            }
            C11440s c11440s = (C11440s) javaElement2;
            return new AbstractC11254e.b(member, c11440s != null ? c11440s.getMember() : null);
        }
        InterfaceC11455o0 getter = original.getGetter();
        C12238m.checkNotNull(getter);
        AbstractC11252d.e eVarM9339b = m9339b(getter);
        InterfaceC11457p0 setter2 = original.getSetter();
        return new AbstractC11254e.d(eVarM9339b, setter2 != null ? m9339b(setter2) : null);
    }

    public final AbstractC11252d mapSignature(InterfaceC11472x interfaceC11472x) {
        Method member;
        AbstractC11672e.b jvmConstructorSignature;
        AbstractC11672e.b jvmMethodSignature;
        C12238m.checkNotNullParameter(interfaceC11472x, "possiblySubstitutedFunction");
        InterfaceC11321b interfaceC11321bUnwrapFakeOverride = C11787e.unwrapFakeOverride(interfaceC11472x);
        C12238m.checkNotNullExpressionValue(interfaceC11321bUnwrapFakeOverride, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        InterfaceC11472x original = ((InterfaceC11472x) interfaceC11321bUnwrapFakeOverride).getOriginal();
        C12238m.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof InterfaceC11857b) {
            InterfaceC11857b interfaceC11857b = (InterfaceC11857b) original;
            InterfaceC11734n proto = interfaceC11857b.getProto();
            if ((proto instanceof C11684i) && (jvmMethodSignature = C11675h.f23720a.getJvmMethodSignature((C11684i) proto, interfaceC11857b.getNameResolver(), interfaceC11857b.getTypeTable())) != null) {
                return new AbstractC11252d.e(jvmMethodSignature);
            }
            if (!(proto instanceof C11679d) || (jvmConstructorSignature = C11675h.f23720a.getJvmConstructorSignature((C11679d) proto, interfaceC11857b.getNameResolver(), interfaceC11857b.getTypeTable())) == null) {
                return m9339b(original);
            }
            InterfaceC11450m containingDeclaration = interfaceC11472x.getContainingDeclaration();
            C12238m.checkNotNullExpressionValue(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
            return C11789g.isInlineClass(containingDeclaration) ? new AbstractC11252d.e(jvmConstructorSignature) : new AbstractC11252d.d(jvmConstructorSignature);
        }
        if (original instanceof C11515f) {
            InterfaceC11467u0 source = ((C11515f) original).getSource();
            if (!(source instanceof InterfaceC11561a)) {
                source = null;
            }
            InterfaceC11561a interfaceC11561a = (InterfaceC11561a) source;
            InterfaceC11579l javaElement = interfaceC11561a != null ? interfaceC11561a.getJavaElement() : null;
            C11440s c11440s = (C11440s) (javaElement instanceof C11440s ? javaElement : null);
            if (c11440s != null && (member = c11440s.getMember()) != null) {
                return new AbstractC11252d.c(member);
            }
            throw new C11247a0("Incorrect resolution sequence for Java method " + original);
        }
        if (!(original instanceof C11512c)) {
            boolean z2 = true;
            if (!C11786d.isEnumValueOfMethod(original) && !C11786d.isEnumValuesMethod(original) && (!C12238m.areEqual(original.getName(), C11301a.f22610e.getCLONE_NAME()) || !original.getValueParameters().isEmpty())) {
                z2 = false;
            }
            if (z2) {
                return m9339b(original);
            }
            throw new C11247a0("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
        InterfaceC11467u0 source2 = ((C11512c) original).getSource();
        if (!(source2 instanceof InterfaceC11561a)) {
            source2 = null;
        }
        InterfaceC11561a interfaceC11561a2 = (InterfaceC11561a) source2;
        InterfaceC11579l javaElement2 = interfaceC11561a2 != null ? interfaceC11561a2.getJavaElement() : null;
        if (javaElement2 instanceof C11434m) {
            return new AbstractC11252d.b(((C11434m) javaElement2).getMember());
        }
        if (javaElement2 instanceof C11431j) {
            C11431j c11431j = (C11431j) javaElement2;
            if (c11431j.isAnnotationType()) {
                return new AbstractC11252d.a(c11431j.getElement());
            }
        }
        throw new C11247a0("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + ')');
    }
}
