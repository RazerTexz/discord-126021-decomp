package p007b.p225i.p408d.p410q;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.d.q.a */
/* JADX INFO: compiled from: $Gson$Types.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4916a {

    /* JADX INFO: renamed from: a */
    public static final Type[] f13111a = new Type[0];

    /* JADX INFO: renamed from: b.i.d.q.a$a */
    /* JADX INFO: compiled from: $Gson$Types.java */
    public static final class a implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public a(Type type) {
            this.componentType = C4916a.m6860a(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C4916a.m6862c(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C4916a.m6868i(this.componentType) + "[]";
        }
    }

    /* JADX INFO: renamed from: b.i.d.q.a$b */
    /* JADX INFO: compiled from: $Gson$Types.java */
    public static final class b implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z2 = true;
                boolean z3 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z3) {
                    z2 = false;
                }
                C3404f.m4355w(z2);
            }
            this.ownerType = type == null ? null : C4916a.m6860a(type);
            this.rawType = C4916a.m6860a(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.typeArguments = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                Objects.requireNonNull(this.typeArguments[i]);
                C4916a.m6861b(this.typeArguments[i]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i] = C4916a.m6860a(typeArr3[i]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C4916a.m6862c(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            Type type = this.ownerType;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return C4916a.m6868i(this.rawType);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(C4916a.m6868i(this.rawType));
            sb.append("<");
            sb.append(C4916a.m6868i(this.typeArguments[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(C4916a.m6868i(this.typeArguments[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: b.i.d.q.a$c */
    /* JADX INFO: compiled from: $Gson$Types.java */
    public static final class c implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public c(Type[] typeArr, Type[] typeArr2) {
            C3404f.m4355w(typeArr2.length <= 1);
            C3404f.m4355w(typeArr.length == 1);
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                C4916a.m6861b(typeArr[0]);
                this.lowerBound = null;
                this.upperBound = C4916a.m6860a(typeArr[0]);
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            C4916a.m6861b(typeArr2[0]);
            C3404f.m4355w(typeArr[0] == Object.class);
            this.lowerBound = C4916a.m6860a(typeArr2[0]);
            this.upperBound = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C4916a.m6862c(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            return type != null ? new Type[]{type} : C4916a.f13111a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                StringBuilder sbM833U = C1643a.m833U("? super ");
                sbM833U.append(C4916a.m6868i(this.lowerBound));
                return sbM833U.toString();
            }
            if (this.upperBound == Object.class) {
                return "?";
            }
            StringBuilder sbM833U2 = C1643a.m833U("? extends ");
            sbM833U2.append(C4916a.m6868i(this.upperBound));
            return sbM833U2.toString();
        }
    }

    /* JADX INFO: renamed from: a */
    public static Type m6860a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(m6860a(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    /* JADX INFO: renamed from: b */
    public static void m6861b(Type type) {
        C3404f.m4355w(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m6862c(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m6862c(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    /* JADX INFO: renamed from: d */
    public static Type m6863d(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return m6863d(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m6863d(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* JADX INFO: renamed from: e */
    public static Class<?> m6864e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C3404f.m4355w(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m6864e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m6864e(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    /* JADX INFO: renamed from: f */
    public static Type m6865f(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        C3404f.m4355w(cls2.isAssignableFrom(cls));
        return m6866g(type, cls, m6863d(type, cls, cls2));
    }

    /* JADX INFO: renamed from: g */
    public static Type m6866g(Type type, Class<?> cls, Type type2) {
        return m6867h(type, cls, type2, new HashSet());
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX INFO: renamed from: h */
    public static Type m6867h(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        Type type3;
        WildcardType wildcardType;
        Type[] lowerBounds;
        TypeVariable typeVariable;
        do {
            int i = 0;
            if (!(type2 instanceof TypeVariable)) {
                if (type2 instanceof Class) {
                    Class cls2 = (Class) type2;
                    if (cls2.isArray()) {
                        Class<?> componentType = cls2.getComponentType();
                        Type typeM6867h = m6867h(type, cls, componentType, collection);
                        return componentType == typeM6867h ? cls2 : new a(typeM6867h);
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeM6867h2 = m6867h(type, cls, genericComponentType, collection);
                    return genericComponentType == typeM6867h2 ? genericArrayType : new a(typeM6867h2);
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type typeM6867h3 = m6867h(type, cls, ownerType, collection);
                    boolean z2 = typeM6867h3 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    while (i < length) {
                        Type typeM6867h4 = m6867h(type, cls, actualTypeArguments[i], collection);
                        if (typeM6867h4 != actualTypeArguments[i]) {
                            if (!z2) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z2 = true;
                            }
                            actualTypeArguments[i] = typeM6867h4;
                        }
                        i++;
                    }
                    return z2 ? new b(typeM6867h3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                }
                if (type2 instanceof WildcardType) {
                    wildcardType = (WildcardType) type2;
                    Type[] lowerBounds2 = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds2.length == 1) {
                        Type typeM6867h5 = m6867h(type, cls, lowerBounds2[0], collection);
                        if (typeM6867h5 != lowerBounds2[0]) {
                            if (typeM6867h5 instanceof WildcardType) {
                                type3 = type2;
                                type3 = wildcardType;
                                lowerBounds = ((WildcardType) typeM6867h5).getLowerBounds();
                            } else {
                                type3 = type2;
                                type3 = wildcardType;
                                lowerBounds = new Type[]{typeM6867h5};
                            }
                            return new c(new Type[]{Object.class}, lowerBounds);
                        }
                    } else if (upperBounds.length == 1) {
                        type3 = type2;
                        type3 = wildcardType;
                        Type typeM6867h6 = m6867h(type, cls, upperBounds[0], collection);
                        type3 = wildcardType;
                        if (typeM6867h6 != upperBounds[0]) {
                            return new c(typeM6867h6 instanceof WildcardType ? ((WildcardType) typeM6867h6).getUpperBounds() : new Type[]{typeM6867h6}, f13111a);
                        }
                    }
                }
                type3 = type2;
                type3 = wildcardType;
                type3 = type2;
                type3 = wildcardType;
                type3 = type2;
                return type3;
            }
            typeVariable = (TypeVariable) type2;
            if (collection.contains(typeVariable)) {
                return type2;
            }
            collection.add(typeVariable);
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 == null) {
                type2 = typeVariable;
            } else {
                Type typeM6863d = m6863d(type, cls, cls3);
                if (typeM6863d instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    int length2 = typeParameters.length;
                    while (true) {
                        if (i >= length2) {
                            throw new NoSuchElementException();
                        }
                        if (typeVariable.equals(typeParameters[i])) {
                            type2 = ((ParameterizedType) typeM6863d).getActualTypeArguments()[i];
                            break;
                        }
                        i++;
                    }
                } else {
                    type2 = typeVariable;
                }
            }
        } while (type2 != typeVariable);
        return type2;
    }

    /* JADX INFO: renamed from: i */
    public static String m6868i(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
