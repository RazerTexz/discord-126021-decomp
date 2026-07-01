package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.f.a0.a$d;
import d0.e0.p.d.m0.i.g$f;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    public static final d0.e0.p.d.m0.g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f3198b = new f0();

    static {
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("java.lang.Void"));
        d0.z.d.m.checkNotNullExpressionValue(aVar, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        a = aVar;
    }

    public final d0.e0.p.d.m0.b.i a(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        d0.e0.p.d.m0.k.y.d dVar = d0.e0.p.d.m0.k.y.d.get(cls.getSimpleName());
        d0.z.d.m.checkNotNullExpressionValue(dVar, "JvmPrimitiveType.get(simpleName)");
        return dVar.getPrimitiveType();
    }

    public final d$e b(d0.e0.p.d.m0.c.x xVar) {
        String jvmMethodNameIfSpecial = d0.e0.p.d.m0.e.a.d0.getJvmMethodNameIfSpecial(xVar);
        if (jvmMethodNameIfSpecial == null) {
            if (xVar instanceof o0) {
                String strAsString = d0.e0.p.d.m0.k.x.a.getPropertyIfAccessor(xVar).getName().asString();
                d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = d0.e0.p.d.m0.e.a.z.getterName(strAsString);
            } else if (xVar instanceof p0) {
                String strAsString2 = d0.e0.p.d.m0.k.x.a.getPropertyIfAccessor(xVar).getName().asString();
                d0.z.d.m.checkNotNullExpressionValue(strAsString2, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = d0.e0.p.d.m0.e.a.z.setterName(strAsString2);
            } else {
                jvmMethodNameIfSpecial = xVar.getName().asString();
                d0.z.d.m.checkNotNullExpressionValue(jvmMethodNameIfSpecial, "descriptor.name.asString()");
            }
        }
        return new d$e(new d0.e0.p.d.m0.f.a0.b.e$b(jvmMethodNameIfSpecial, d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(xVar, false, false, 1, null)));
    }

    public final d0.e0.p.d.m0.g.a mapJvmClassToKotlinClassId(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            d0.z.d.m.checkNotNullExpressionValue(componentType, "klass.componentType");
            d0.e0.p.d.m0.b.i iVarA = a(componentType);
            if (iVarA != null) {
                return new d0.e0.p.d.m0.g.a(d0.e0.p.d.m0.b.k.l, iVarA.getArrayTypeName());
            }
            d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.b.k$a.h.toSafe());
            d0.z.d.m.checkNotNullExpressionValue(aVar, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return aVar;
        }
        if (d0.z.d.m.areEqual(cls, Void.TYPE)) {
            return a;
        }
        d0.e0.p.d.m0.b.i iVarA2 = a(cls);
        if (iVarA2 != null) {
            return new d0.e0.p.d.m0.g.a(d0.e0.p.d.m0.b.k.l, iVarA2.getTypeName());
        }
        d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.c.k1.b.b.getClassId(cls);
        if (!classId.isLocal()) {
            d0.e0.p.d.m0.b.q.c cVar = d0.e0.p.d.m0.b.q.c.a;
            d0.e0.p.d.m0.g.b bVarAsSingleFqName = classId.asSingleFqName();
            d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "classId.asSingleFqName()");
            d0.e0.p.d.m0.g.a aVarMapJavaToKotlin = cVar.mapJavaToKotlin(bVarAsSingleFqName);
            if (aVarMapJavaToKotlin != null) {
                return aVarMapJavaToKotlin;
            }
        }
        return classId;
    }

    public final e mapPropertySignature(n0 n0Var) {
        d0.z.d.m.checkNotNullParameter(n0Var, "possiblyOverriddenProperty");
        d0.e0.p.d.m0.c.b bVarUnwrapFakeOverride = d0.e0.p.d.m0.k.e.unwrapFakeOverride(n0Var);
        d0.z.d.m.checkNotNullExpressionValue(bVarUnwrapFakeOverride, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        n0 original = ((n0) bVarUnwrapFakeOverride).getOriginal();
        d0.z.d.m.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (original instanceof d0.e0.p.d.m0.l.b.e0.j) {
            d0.e0.p.d.m0.l.b.e0.j jVar = (d0.e0.p.d.m0.l.b.e0.j) original;
            d0.e0.p.d.m0.f.n proto = jVar.getProto();
            g$f<d0.e0.p.d.m0.f.n, a$d> g_f = d0.e0.p.d.m0.f.a0.a.d;
            d0.z.d.m.checkNotNullExpressionValue(g_f, "JvmProtoBuf.propertySignature");
            a$d a_d = (a$d) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(proto, g_f);
            if (a_d != null) {
                return new e$c(original, proto, a_d, jVar.getNameResolver(), jVar.getTypeTable());
            }
        } else if (original instanceof d0.e0.p.d.m0.e.a.h0.g) {
            u0 source = ((d0.e0.p.d.m0.e.a.h0.g) original).getSource();
            if (!(source instanceof d0.e0.p.d.m0.e.a.j0.a)) {
                source = null;
            }
            d0.e0.p.d.m0.e.a.j0.a aVar = (d0.e0.p.d.m0.e.a.j0.a) source;
            d0.e0.p.d.m0.e.a.k0.l javaElement = aVar != null ? aVar.getJavaElement() : null;
            if (javaElement instanceof d0.e0.p.d.m0.c.k1.b.p) {
                return new e$a(((d0.e0.p.d.m0.c.k1.b.p) javaElement).getMember());
            }
            if (!(javaElement instanceof d0.e0.p.d.m0.c.k1.b.s)) {
                throw new a0("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')');
            }
            Method member = ((d0.e0.p.d.m0.c.k1.b.s) javaElement).getMember();
            p0 setter = original.getSetter();
            u0 source2 = setter != null ? setter.getSource() : null;
            if (!(source2 instanceof d0.e0.p.d.m0.e.a.j0.a)) {
                source2 = null;
            }
            d0.e0.p.d.m0.e.a.j0.a aVar2 = (d0.e0.p.d.m0.e.a.j0.a) source2;
            d0.e0.p.d.m0.e.a.k0.l javaElement2 = aVar2 != null ? aVar2.getJavaElement() : null;
            if (!(javaElement2 instanceof d0.e0.p.d.m0.c.k1.b.s)) {
                javaElement2 = null;
            }
            d0.e0.p.d.m0.c.k1.b.s sVar = (d0.e0.p.d.m0.c.k1.b.s) javaElement2;
            return new e$b(member, sVar != null ? sVar.getMember() : null);
        }
        o0 getter = original.getGetter();
        d0.z.d.m.checkNotNull(getter);
        d$e d_eB = b(getter);
        p0 setter2 = original.getSetter();
        return new e$d(d_eB, setter2 != null ? b(setter2) : null);
    }

    public final d mapSignature(d0.e0.p.d.m0.c.x xVar) {
        Method member;
        d0.e0.p.d.m0.f.a0.b.e$b jvmConstructorSignature;
        d0.e0.p.d.m0.f.a0.b.e$b jvmMethodSignature;
        d0.z.d.m.checkNotNullParameter(xVar, "possiblySubstitutedFunction");
        d0.e0.p.d.m0.c.b bVarUnwrapFakeOverride = d0.e0.p.d.m0.k.e.unwrapFakeOverride(xVar);
        d0.z.d.m.checkNotNullExpressionValue(bVarUnwrapFakeOverride, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        d0.e0.p.d.m0.c.x original = ((d0.e0.p.d.m0.c.x) bVarUnwrapFakeOverride).getOriginal();
        d0.z.d.m.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof d0.e0.p.d.m0.l.b.e0.b) {
            d0.e0.p.d.m0.l.b.e0.b bVar = (d0.e0.p.d.m0.l.b.e0.b) original;
            d0.e0.p.d.m0.i.n proto = bVar.getProto();
            if ((proto instanceof d0.e0.p.d.m0.f.i) && (jvmMethodSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmMethodSignature((d0.e0.p.d.m0.f.i) proto, bVar.getNameResolver(), bVar.getTypeTable())) != null) {
                return new d$e(jvmMethodSignature);
            }
            if (!(proto instanceof d0.e0.p.d.m0.f.d) || (jvmConstructorSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmConstructorSignature((d0.e0.p.d.m0.f.d) proto, bVar.getNameResolver(), bVar.getTypeTable())) == null) {
                return b(original);
            }
            d0.e0.p.d.m0.c.m containingDeclaration = xVar.getContainingDeclaration();
            d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
            return d0.e0.p.d.m0.k.g.isInlineClass(containingDeclaration) ? new d$e(jvmConstructorSignature) : new d$d(jvmConstructorSignature);
        }
        if (original instanceof d0.e0.p.d.m0.e.a.h0.f) {
            u0 source = ((d0.e0.p.d.m0.e.a.h0.f) original).getSource();
            if (!(source instanceof d0.e0.p.d.m0.e.a.j0.a)) {
                source = null;
            }
            d0.e0.p.d.m0.e.a.j0.a aVar = (d0.e0.p.d.m0.e.a.j0.a) source;
            d0.e0.p.d.m0.e.a.k0.l javaElement = aVar != null ? aVar.getJavaElement() : null;
            d0.e0.p.d.m0.c.k1.b.s sVar = (d0.e0.p.d.m0.c.k1.b.s) (javaElement instanceof d0.e0.p.d.m0.c.k1.b.s ? javaElement : null);
            if (sVar != null && (member = sVar.getMember()) != null) {
                return new d$c(member);
            }
            throw new a0("Incorrect resolution sequence for Java method " + original);
        }
        if (!(original instanceof d0.e0.p.d.m0.e.a.h0.c)) {
            boolean z2 = true;
            if (!d0.e0.p.d.m0.k.d.isEnumValueOfMethod(original) && !d0.e0.p.d.m0.k.d.isEnumValuesMethod(original) && (!d0.z.d.m.areEqual(original.getName(), d0.e0.p.d.m0.b.q.a.e.getCLONE_NAME()) || !original.getValueParameters().isEmpty())) {
                z2 = false;
            }
            if (z2) {
                return b(original);
            }
            throw new a0("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
        u0 source2 = ((d0.e0.p.d.m0.e.a.h0.c) original).getSource();
        if (!(source2 instanceof d0.e0.p.d.m0.e.a.j0.a)) {
            source2 = null;
        }
        d0.e0.p.d.m0.e.a.j0.a aVar2 = (d0.e0.p.d.m0.e.a.j0.a) source2;
        d0.e0.p.d.m0.e.a.k0.l javaElement2 = aVar2 != null ? aVar2.getJavaElement() : null;
        if (javaElement2 instanceof d0.e0.p.d.m0.c.k1.b.m) {
            return new d$b(((d0.e0.p.d.m0.c.k1.b.m) javaElement2).getMember());
        }
        if (javaElement2 instanceof d0.e0.p.d.m0.c.k1.b.j) {
            d0.e0.p.d.m0.c.k1.b.j jVar = (d0.e0.p.d.m0.c.k1.b.j) javaElement2;
            if (jVar.isAnnotationType()) {
                return new d$a(jVar.getElement());
            }
        }
        throw new a0("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + ')');
    }
}
