package d0.e0.p.d.m0.c.k1.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaType;
import d0.e0.p.d.m0.e.a.k0.javaTypes3;
import d0.e0.p.d.m0.e.a.k0.javaTypes5;
import d0.e0.p.d.m0.g.FqName;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.l, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaClassifierType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClassifierType extends ReflectJavaType implements javaTypes3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3294b;
    public final d0.e0.p.d.m0.e.a.k0.i c;

    public ReflectJavaClassifierType(Type type) {
        d0.e0.p.d.m0.e.a.k0.i reflectJavaClass;
        Intrinsics3.checkNotNullParameter(type, "reflectType");
        this.f3294b = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            reflectJavaClass = new ReflectJavaTypeParameter((TypeVariable) reflectType);
        } else {
            if (!(reflectType instanceof ParameterizedType)) {
                StringBuilder sbU = outline.U("Not a classifier type (");
                sbU.append(reflectType.getClass());
                sbU.append("): ");
                sbU.append(reflectType);
                throw new IllegalStateException(sbU.toString());
            }
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            reflectJavaClass = new ReflectJavaClass((Class) rawType);
        }
        this.c = reflectJavaClass;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaType, d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.e.a.k0.a findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes3
    public d0.e0.p.d.m0.e.a.k0.i getClassifier() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes3
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException(Intrinsics3.stringPlus("Type not found: ", getReflectType()));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes3
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaType
    public Type getReflectType() {
        return this.f3294b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes3
    public List<javaTypes5> getTypeArguments() {
        List<Type> parameterizedTypeArguments = reflectClassUtil.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.a aVar = ReflectJavaType.a;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        Iterator<T> it = parameterizedTypeArguments.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.create((Type) it.next()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes3
    public boolean isRaw() {
        Type reflectType = getReflectType();
        if (!(reflectType instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) reflectType).getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }
}
