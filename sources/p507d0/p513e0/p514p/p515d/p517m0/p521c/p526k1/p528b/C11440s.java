package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11444w;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11566b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.s */
/* JADX INFO: compiled from: ReflectJavaMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11440s extends AbstractC11439r implements InterfaceC11585r {

    /* JADX INFO: renamed from: a */
    public final Method f23061a;

    public C11440s(Method method) {
        C12238m.checkNotNullParameter(method, "member");
        this.f23061a = method;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public InterfaceC11566b getAnnotationParameterDefaultValue() {
        Object defaultValue = getMember().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return AbstractC11425d.f23039a.create(defaultValue, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public boolean getHasAnnotationParameterDefaultValue() {
        return InterfaceC11585r.a.getHasAnnotationParameterDefaultValue(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z
    public List<C11445x> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = getMember().getTypeParameters();
        C12238m.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new C11445x(typeVariable));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public List<InterfaceC11565a0> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        C12238m.checkNotNullExpressionValue(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        C12238m.checkNotNullExpressionValue(parameterAnnotations, "member.parameterAnnotations");
        return m9436a(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11439r
    public Method getMember() {
        return this.f23061a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r
    public AbstractC11444w getReturnType() {
        AbstractC11444w.a aVar = AbstractC11444w.f23065a;
        Type genericReturnType = getMember().getGenericReturnType();
        C12238m.checkNotNullExpressionValue(genericReturnType, "member.genericReturnType");
        return aVar.create(genericReturnType);
    }
}
