package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11578k;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.m */
/* JADX INFO: compiled from: ReflectJavaConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11434m extends AbstractC11439r implements InterfaceC11578k {

    /* JADX INFO: renamed from: a */
    public final Constructor<?> f23057a;

    public C11434m(Constructor<?> constructor) {
        C12238m.checkNotNullParameter(constructor, "member");
        this.f23057a = constructor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11439r
    public Constructor<?> getMember() {
        return this.f23057a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z
    public List<C11445x> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        C12238m.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new C11445x(typeVariable));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11578k
    public List<InterfaceC11565a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        C12238m.checkNotNullExpressionValue(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return C12147n.emptyList();
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) C12139j.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException(C12238m.stringPlus("Illegal generic signature: ", getMember()));
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            C12238m.checkNotNullExpressionValue(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) C12139j.copyOfRange(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        C12238m.checkNotNullExpressionValue(genericParameterTypes, "realTypes");
        C12238m.checkNotNullExpressionValue(parameterAnnotations, "realAnnotations");
        return m9436a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }
}
