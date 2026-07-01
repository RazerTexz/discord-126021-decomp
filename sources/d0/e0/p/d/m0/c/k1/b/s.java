package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.a0;
import d0.e0.p.d.m0.e.a.k0.r$a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends r implements d0.e0.p.d.m0.e.a.k0.r {
    public final Method a;

    public s(Method method) {
        d0.z.d.m.checkNotNullParameter(method, "member");
        this.a = method;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public d0.e0.p.d.m0.e.a.k0.b getAnnotationParameterDefaultValue() {
        Object defaultValue = getMember().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return d.a.create(defaultValue, null);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public boolean getHasAnnotationParameterDefaultValue() {
        return r$a.getHasAnnotationParameterDefaultValue(this);
    }

    @Override // d0.e0.p.d.m0.c.k1.b.r
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.x getReturnType() {
        return getReturnType();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.z
    public List<x> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = getMember().getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public List<a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        d0.z.d.m.checkNotNullExpressionValue(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        d0.z.d.m.checkNotNullExpressionValue(parameterAnnotations, "member.parameterAnnotations");
        return a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @Override // d0.e0.p.d.m0.c.k1.b.r
    public Method getMember() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public w getReturnType() {
        w$a w_a = w.a;
        Type genericReturnType = getMember().getGenericReturnType();
        d0.z.d.m.checkNotNullExpressionValue(genericReturnType, "member.genericReturnType");
        return w_a.create(genericReturnType);
    }
}
