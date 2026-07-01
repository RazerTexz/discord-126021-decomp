package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.k1.b.ReflectJavaType;
import d0.e0.p.d.m0.e.a.k0.a0;
import d0.e0.p.d.m0.e.a.k0.annotationArguments;
import d0.e0.p.d.m0.e.a.k0.r;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.s, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaMethod extends ReflectJavaMember2 implements d0.e0.p.d.m0.e.a.k0.r {
    public final Method a;

    public ReflectJavaMethod(Method method) {
        Intrinsics3.checkNotNullParameter(method, "member");
        this.a = method;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public annotationArguments getAnnotationParameterDefaultValue() {
        Object defaultValue = getMember().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return ReflectJavaAnnotationArguments.a.create(defaultValue, null);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public boolean getHasAnnotationParameterDefaultValue() {
        return r.a.getHasAnnotationParameterDefaultValue(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.z
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = getMember().getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public List<a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        Intrinsics3.checkNotNullExpressionValue(parameterAnnotations, "member.parameterAnnotations");
        return a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaMember2
    public Method getMember() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.r
    public ReflectJavaType getReturnType() {
        ReflectJavaType.a aVar = ReflectJavaType.a;
        Type genericReturnType = getMember().getGenericReturnType();
        Intrinsics3.checkNotNullExpressionValue(genericReturnType, "member.genericReturnType");
        return aVar.create(genericReturnType);
    }
}
