package com.google.gson.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p408d.p410q.C4916a;

/* JADX INFO: loaded from: classes3.dex */
public class TypeToken<T> {
    public final int hashCode;
    public final Class<? super T> rawType;
    public final Type type;

    public TypeToken() {
        Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
        this.type = superclassTypeParameter;
        this.rawType = (Class<? super T>) C4916a.m6864e(superclassTypeParameter);
        this.hashCode = superclassTypeParameter.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class<?> cls : clsArr) {
            sb.append(cls.getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type.toString());
        sb.append('.');
        return new AssertionError(sb.toString());
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    public static TypeToken<?> getArray(Type type) {
        return new TypeToken<>(new C4916a.a(type));
    }

    public static TypeToken<?> getParameterized(Type type, Type... typeArr) {
        return new TypeToken<>(new C4916a.b(null, type, typeArr));
    }

    public static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C4916a.m6860a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!matches(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C4916a.m6862c(this.type, ((TypeToken) obj).type);
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    public final String toString() {
        return C4916a.m6868i(this.type);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        Type type2 = this.type;
        if (type2 instanceof Class) {
            return this.rawType.isAssignableFrom(C4916a.m6864e(type));
        }
        if (type2 instanceof ParameterizedType) {
            return isAssignableFrom(type, (ParameterizedType) type2, new HashMap());
        }
        if (type2 instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom(C4916a.m6864e(type)) && isAssignableFrom(type, (GenericArrayType) this.type);
        }
        throw buildUnexpectedTypeError(type2, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    public TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type typeM6860a = C4916a.m6860a(type);
        this.type = typeM6860a;
        this.rawType = (Class<? super T>) C4916a.m6864e(typeM6860a);
        this.hashCode = typeM6860a.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, (ParameterizedType) genericComponentType, new HashMap());
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> clsM6864e = C4916a.m6864e(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeParameters = clsM6864e.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                TypeVariable<Class<?>> typeVariable = typeParameters[i];
                while (type2 instanceof TypeVariable) {
                    type2 = map.get(((TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type type3 : clsM6864e.getGenericInterfaces()) {
            if (isAssignableFrom(type3, parameterizedType, new HashMap(map))) {
                return true;
            }
        }
        return isAssignableFrom(clsM6864e.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }
}
