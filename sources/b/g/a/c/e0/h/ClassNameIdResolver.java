package b.g.a.c.e0.h;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.e0.PolymorphicTypeValidator;
import b.g.a.c.h0.CollectionType;
import b.g.a.c.h0.MapType;
import b.g.a.c.h0.TypeBindings;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: renamed from: b.g.a.c.e0.h.f, reason: use source file name */
/* JADX INFO: compiled from: ClassNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassNameIdResolver extends TypeIdResolverBase {
    public ClassNameIdResolver(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory);
    }

    @Override // b.g.a.c.e0.TypeIdResolver
    public String a(Object obj) {
        return d(obj, obj.getClass(), this.a);
    }

    @Override // b.g.a.c.e0.TypeIdResolver
    public String c(Object obj, Class<?> cls) {
        return d(obj, cls, this.a);
    }

    public String d(Object obj, Class<?> cls, TypeFactory typeFactory) {
        Class<?> declaringClass;
        JavaType javaTypeC;
        JavaType javaTypeC2;
        TypeBindings typeBindings;
        Class<?> declaringClass2;
        TypeBindings typeBindings2;
        Class<?> superclass = (!ClassUtil.q(cls) || cls.isEnum()) ? cls : cls.getSuperclass();
        String name = superclass.getName();
        if (!name.startsWith("java.util.")) {
            return (name.indexOf(36) < 0 || ClassUtil.m(superclass) == null || ClassUtil.m(this.f698b._class) != null) ? name : this.f698b._class.getName();
        }
        if (obj instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) obj;
            if (enumSet.isEmpty()) {
                Field field = ClassUtil.b.a.f728b;
                if (field == null) {
                    throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
                }
                try {
                    declaringClass2 = (Class) field.get(enumSet);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                declaringClass2 = ((Enum) enumSet.iterator().next()).getDeclaringClass();
            }
            JavaType javaTypeC3 = typeFactory.c(null, declaringClass2, TypeFactory.l);
            String[] strArr = TypeBindings.j;
            TypeVariable[] typeParameters = EnumSet.class.getTypeParameters();
            int length = typeParameters == null ? 0 : typeParameters.length;
            if (length == 0) {
                typeBindings2 = TypeBindings.l;
            } else {
                if (length != 1) {
                    StringBuilder sbU = outline.U("Cannot create TypeBindings for class ");
                    sbU.append(EnumSet.class.getName());
                    sbU.append(" with 1 type parameter: class expects ");
                    sbU.append(length);
                    throw new IllegalArgumentException(sbU.toString());
                }
                typeBindings2 = new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaTypeC3}, null);
            }
            CollectionType collectionType = (CollectionType) typeFactory.c(null, EnumSet.class, typeBindings2);
            if (typeBindings2.i()) {
                JavaType javaTypeK = collectionType.i(Collection.class).k();
                if (!javaTypeK.equals(javaTypeC3)) {
                    throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", ClassUtil.u(EnumSet.class), javaTypeC3, javaTypeK));
                }
            }
            return collectionType.K();
        }
        if (!(obj instanceof EnumMap)) {
            return name;
        }
        EnumMap enumMap = (EnumMap) obj;
        if (enumMap.isEmpty()) {
            Field field2 = ClassUtil.b.a.c;
            if (field2 == null) {
                throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
            }
            try {
                declaringClass = (Class) field2.get(enumMap);
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            declaringClass = ((Enum) enumMap.keySet().iterator().next()).getDeclaringClass();
        }
        Objects.requireNonNull(typeFactory);
        if (EnumMap.class == Properties.class) {
            javaTypeC = TypeFactory.f724y;
            javaTypeC2 = javaTypeC;
        } else {
            TypeBindings typeBindings3 = TypeFactory.l;
            javaTypeC = typeFactory.c(null, declaringClass, typeBindings3);
            javaTypeC2 = typeFactory.c(null, Object.class, typeBindings3);
        }
        JavaType[] javaTypeArr = {javaTypeC, javaTypeC2};
        String[] strArr2 = TypeBindings.j;
        TypeVariable[] typeParameters2 = EnumMap.class.getTypeParameters();
        if (typeParameters2 == null || typeParameters2.length == 0) {
            typeBindings = TypeBindings.l;
        } else {
            int length2 = typeParameters2.length;
            String[] strArr3 = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr3[i] = typeParameters2[i].getName();
            }
            if (length2 != 2) {
                StringBuilder sbU2 = outline.U("Cannot create TypeBindings for class ");
                sbU2.append(EnumMap.class.getName());
                sbU2.append(" with ");
                sbU2.append(2);
                sbU2.append(" type parameter");
                sbU2.append("s");
                sbU2.append(": class expects ");
                sbU2.append(length2);
                throw new IllegalArgumentException(sbU2.toString());
            }
            typeBindings = new TypeBindings(strArr3, javaTypeArr, null);
        }
        MapType mapType = (MapType) typeFactory.c(null, EnumMap.class, typeBindings);
        if (typeBindings.i()) {
            JavaType javaTypeI = mapType.i(Map.class);
            JavaType javaTypeO = javaTypeI.o();
            if (!javaTypeO.equals(javaTypeC)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", ClassUtil.u(EnumMap.class), javaTypeC, javaTypeO));
            }
            JavaType javaTypeK2 = javaTypeI.k();
            if (!javaTypeK2.equals(javaTypeC2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", ClassUtil.u(EnumMap.class), javaTypeC2, javaTypeK2));
            }
        }
        return mapType.K();
    }
}
