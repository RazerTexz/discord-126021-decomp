package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.f1;
import d0.e0.p.d.m0.e.a.k0.c0;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends n implements f, t, d0.e0.p.d.m0.e.a.k0.g {
    public final Class<?> a;

    public j(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        this.a = cls;
    }

    public static final boolean access$isEnumValuesOrValueOf(j jVar, Method method) {
        Objects.requireNonNull(jVar);
        String name = method.getName();
        if (d0.z.d.m.areEqual(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            d0.z.d.m.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (d0.z.d.m.areEqual(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && d0.z.d.m.areEqual(this.a, ((j) obj).a);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return f$a.findAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.f
    public /* bridge */ /* synthetic */ AnnotatedElement getElement() {
        return getElement();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getFields() {
        return getFields();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public d0.e0.p.d.m0.g.b getFqName() {
        d0.e0.p.d.m0.g.b bVarAsSingleFqName = b.getClassId(this.a).asSingleFqName();
        d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "klass.classId.asSingleFqName()");
        return bVarAsSingleFqName;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getInnerClassNames() {
        return getInnerClassNames();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public c0 getLightClassOriginKind() {
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getMethods() {
        return getMethods();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.t
    public int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.t
    public d0.e0.p.d.m0.g.e getName() {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(this.a.getSimpleName());
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(klass.simpleName)");
        return eVarIdentifier;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.g getOuterClass() {
        return getOuterClass();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<d0.e0.p.d.m0.e.a.k0.j> getPermittedTypes() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<d0.e0.p.d.m0.e.a.k0.w> getRecordComponents() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<d0.e0.p.d.m0.e.a.k0.j> getSupertypes() {
        if (d0.z.d.m.areEqual(this.a, Object.class)) {
            return d0.t.n.emptyList();
        }
        d0.z.d.c0 c0Var = new d0.z.d.c0(2);
        Type genericSuperclass = this.a.getGenericSuperclass();
        c0Var.add(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        d0.z.d.m.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        c0Var.addSpread(genericInterfaces);
        List listListOf = d0.t.n.listOf(c0Var.toArray(new Type[c0Var.size()]));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new l((Type) it.next()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.z
    public List<x> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public f1 getVisibility() {
        return t$a.getVisibility(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isAbstract() {
        return t$a.isAbstract(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isAnnotationType() {
        return this.a.isAnnotation();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return f$a.isDeprecatedInJavaDoc(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isEnum() {
        return this.a.isEnum();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isFinal() {
        return t$a.isFinal(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isInterface() {
        return this.a.isInterface();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isRecord() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isSealed() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isStatic() {
        return t$a.isStatic(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b.d.b.a.a.k0(j.class, sb, ": ");
        sb.append(this.a);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return findAnnotation(bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<c> getAnnotations() {
        return f$a.getAnnotations(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<m> getConstructors() {
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        d0.z.d.m.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return d0.f0.q.toList(d0.f0.q.map(d0.f0.q.filterNot(d0.t.k.asSequence(declaredConstructors), j$a.j), j$b.j));
    }

    @Override // d0.e0.p.d.m0.c.k1.b.f
    public Class<?> getElement() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<p> getFields() {
        Field[] declaredFields = this.a.getDeclaredFields();
        d0.z.d.m.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return d0.f0.q.toList(d0.f0.q.map(d0.f0.q.filterNot(d0.t.k.asSequence(declaredFields), j$c.j), j$d.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<d0.e0.p.d.m0.g.e> getInnerClassNames() {
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        d0.z.d.m.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return d0.f0.q.toList(d0.f0.q.mapNotNull(d0.f0.q.filterNot(d0.t.k.asSequence(declaredClasses), j$e.j), j$f.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<s> getMethods() {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return d0.f0.q.toList(d0.f0.q.map(d0.f0.q.filter(d0.t.k.asSequence(declaredMethods), new j$g(this)), j$h.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public j getOuterClass() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new j(declaringClass);
    }
}
