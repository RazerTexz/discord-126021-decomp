package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.a0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends r implements d0.e0.p.d.m0.e.a.k0.k {
    public final Constructor<?> a;

    public m(Constructor<?> constructor) {
        d0.z.d.m.checkNotNullParameter(constructor, "member");
        this.a = constructor;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.r
    public Constructor<?> getMember() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.z
    public List<x> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.k
    public List<a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        d0.z.d.m.checkNotNullExpressionValue(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return d0.t.n.emptyList();
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) d0.t.j.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException(d0.z.d.m.stringPlus("Illegal generic signature: ", getMember()));
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            d0.z.d.m.checkNotNullExpressionValue(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) d0.t.j.copyOfRange(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        d0.z.d.m.checkNotNullExpressionValue(genericParameterTypes, "realTypes");
        d0.z.d.m.checkNotNullExpressionValue(parameterAnnotations, "realAnnotations");
        return a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @Override // d0.e0.p.d.m0.c.k1.b.r
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }
}
