package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11576i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11591x;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.l */
/* JADX INFO: compiled from: ReflectJavaClassifierType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11433l extends AbstractC11444w implements InterfaceC11577j {

    /* JADX INFO: renamed from: b */
    public final Type f23055b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11576i f23056c;

    public C11433l(Type type) {
        InterfaceC11576i c11431j;
        C12238m.checkNotNullParameter(type, "reflectType");
        this.f23055b = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof Class) {
            c11431j = new C11431j((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            c11431j = new C11445x((TypeVariable) reflectType);
        } else {
            if (!(reflectType instanceof ParameterizedType)) {
                StringBuilder sbM833U = C1643a.m833U("Not a classifier type (");
                sbM833U.append(reflectType.getClass());
                sbM833U.append("): ");
                sbM833U.append(reflectType);
                throw new IllegalStateException(sbM833U.toString());
            }
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            c11431j = new C11431j((Class) rawType);
        }
        this.f23056c = c11431j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11444w, p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public InterfaceC11564a findAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j
    public InterfaceC11576i getClassifier() {
        return this.f23056c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException(C12238m.stringPlus("Type not found: ", getReflectType()));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11444w
    public Type getReflectType() {
        return this.f23055b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j
    public List<InterfaceC11591x> getTypeArguments() {
        List<Type> parameterizedTypeArguments = C11423b.getParameterizedTypeArguments(getReflectType());
        AbstractC11444w.a aVar = AbstractC11444w.f23065a;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        Iterator<T> it = parameterizedTypeArguments.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.create((Type) it.next()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j
    public boolean isRaw() {
        Type reflectType = getReflectType();
        if (!(reflectType instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) reflectType).getTypeParameters();
        C12238m.checkNotNullExpressionValue(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }
}
