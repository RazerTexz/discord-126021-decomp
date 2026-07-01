package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ReflectJavaClassifierType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends w implements d0.e0.p.d.m0.e.a.k0.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3294b;
    public final d0.e0.p.d.m0.e.a.k0.i c;

    public l(Type type) {
        d0.e0.p.d.m0.e.a.k0.i jVar;
        d0.z.d.m.checkNotNullParameter(type, "reflectType");
        this.f3294b = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof Class) {
            jVar = new j((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            jVar = new x((TypeVariable) reflectType);
        } else {
            if (!(reflectType instanceof ParameterizedType)) {
                StringBuilder sbU = b.d.b.a.a.U("Not a classifier type (");
                sbU.append(reflectType.getClass());
                sbU.append("): ");
                sbU.append(reflectType);
                throw new IllegalStateException(sbU.toString());
            }
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            jVar = new j((Class) rawType);
        }
        this.c = jVar;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.w, d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.j
    public d0.e0.p.d.m0.e.a.k0.i getClassifier() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.j
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException(d0.z.d.m.stringPlus("Type not found: ", getReflectType()));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.j
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.w
    public Type getReflectType() {
        return this.f3294b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.j
    public List<d0.e0.p.d.m0.e.a.k0.x> getTypeArguments() {
        List<Type> parameterizedTypeArguments = b.getParameterizedTypeArguments(getReflectType());
        w$a w_a = w.a;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        Iterator<T> it = parameterizedTypeArguments.iterator();
        while (it.hasNext()) {
            arrayList.add(w_a.create((Type) it.next()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.j
    public boolean isRaw() {
        Type reflectType = getReflectType();
        if (!(reflectType instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) reflectType).getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }
}
