package d0.e0.p.d.l0;

import d0.t.o;
import d0.z.d.a0;
import d0.z.d.m;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final Void access$throwIllegalArgumentType(int i, String str, Class cls) {
        d0.e0.c orCreateKotlinClass;
        String qualifiedName;
        if (m.areEqual(cls, Class.class)) {
            orCreateKotlinClass = a0.getOrCreateKotlinClass(d0.e0.c.class);
        } else {
            orCreateKotlinClass = (cls.isArray() && m.areEqual(cls.getComponentType(), Class.class)) ? a0.getOrCreateKotlinClass(d0.e0.c[].class) : d0.z.a.getKotlinClass(cls);
        }
        if (m.areEqual(orCreateKotlinClass.getQualifiedName(), a0.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(orCreateKotlinClass.getQualifiedName());
            sb.append('<');
            Class<?> componentType = d0.z.a.getJavaClass(orCreateKotlinClass).getComponentType();
            m.checkNotNullExpressionValue(componentType, "kotlinClass.java.componentType");
            sb.append(d0.z.a.getKotlinClass(componentType).getQualifiedName());
            sb.append('>');
            qualifiedName = sb.toString();
        } else {
            qualifiedName = orCreateKotlinClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + qualifiedName);
    }

    public static final Object access$transformKotlinToJvm(Object obj, Class cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof d0.e0.c) {
            obj = d0.z.a.getJavaClass((d0.e0.c) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof d0.e0.c[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                d0.e0.c[] cVarArr = (d0.e0.c[]) obj;
                ArrayList arrayList = new ArrayList(cVarArr.length);
                for (d0.e0.c cVar : cVarArr) {
                    arrayList.add(d0.z.a.getJavaClass(cVar));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    public static final <T> T createAnnotationInstance(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        m.checkNotNullParameter(cls, "annotationClass");
        m.checkNotNullParameter(map, "values");
        m.checkNotNullParameter(list, "methods");
        b$a b_a = new b$a(cls, list, map);
        Lazy lazy = d0.g.lazy(new b$b(map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new b$c(cls, d0.g.lazy(new b$d(cls, map)), null, lazy, null, b_a, map));
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }
}
