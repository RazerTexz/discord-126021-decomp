package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.a0;
import d0.t.Collections2;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.m, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember2 implements d0.e0.p.d.m0.e.a.k0.k {
    public final Constructor<?> a;

    public ReflectJavaConstructor(Constructor<?> constructor) {
        Intrinsics3.checkNotNullParameter(constructor, "member");
        this.a = constructor;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaMember2
    public Constructor<?> getMember() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.z
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.k
    public List<a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return Collections2.emptyList();
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) _ArraysJvm.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Illegal generic signature: ", getMember()));
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            Intrinsics3.checkNotNullExpressionValue(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) _ArraysJvm.copyOfRange(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "realTypes");
        Intrinsics3.checkNotNullExpressionValue(parameterAnnotations, "realAnnotations");
        return a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }
}
