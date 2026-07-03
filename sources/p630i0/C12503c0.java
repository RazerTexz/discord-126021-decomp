package p630i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12264b0;
import p615g0.C12388e;

/* JADX INFO: renamed from: i0.c0 */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12503c0 {

    /* JADX INFO: renamed from: a */
    public static final Type[] f26490a = new Type[0];

    /* JADX INFO: renamed from: i0.c0$a */
    /* JADX INFO: compiled from: Utils.java */
    public static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: j */
        public final Type f26491j;

        public a(Type type) {
            this.f26491j = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C12503c0.m10683c(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f26491j;
        }

        public int hashCode() {
            return this.f26491j.hashCode();
        }

        public String toString() {
            return C12503c0.m10696p(this.f26491j) + "[]";
        }
    }

    /* JADX INFO: renamed from: i0.c0$b */
    /* JADX INFO: compiled from: Utils.java */
    public static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: j */
        public final Type f26492j;

        /* JADX INFO: renamed from: k */
        public final Type f26493k;

        /* JADX INFO: renamed from: l */
        public final Type[] f26494l;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                C12503c0.m10682b(type3);
            }
            this.f26492j = type;
            this.f26493k = type2;
            this.f26494l = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C12503c0.m10683c(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f26494l.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f26492j;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f26493k;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.f26494l) ^ this.f26493k.hashCode();
            Type type = this.f26492j;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f26494l;
            if (typeArr.length == 0) {
                return C12503c0.m10696p(this.f26493k);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(C12503c0.m10696p(this.f26493k));
            sb.append("<");
            sb.append(C12503c0.m10696p(this.f26494l[0]));
            for (int i = 1; i < this.f26494l.length; i++) {
                sb.append(", ");
                sb.append(C12503c0.m10696p(this.f26494l[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: i0.c0$c */
    /* JADX INFO: compiled from: Utils.java */
    public static final class c implements WildcardType {

        /* JADX INFO: renamed from: j */
        public final Type f26495j;

        /* JADX INFO: renamed from: k */
        public final Type f26496k;

        public c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                C12503c0.m10682b(typeArr[0]);
                this.f26496k = null;
                this.f26495j = typeArr[0];
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            C12503c0.m10682b(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f26496k = typeArr2[0];
            this.f26495j = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C12503c0.m10683c(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f26496k;
            return type != null ? new Type[]{type} : C12503c0.f26490a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f26495j};
        }

        public int hashCode() {
            Type type = this.f26496k;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f26495j.hashCode() + 31);
        }

        public String toString() {
            if (this.f26496k != null) {
                StringBuilder sbM833U = C1643a.m833U("? super ");
                sbM833U.append(C12503c0.m10696p(this.f26496k));
                return sbM833U.toString();
            }
            if (this.f26495j == Object.class) {
                return "?";
            }
            StringBuilder sbM833U2 = C1643a.m833U("? extends ");
            sbM833U2.append(C12503c0.m10696p(this.f26495j));
            return sbM833U2.toString();
        }
    }

    /* JADX INFO: renamed from: a */
    public static ResponseBody m10681a(ResponseBody responseBody) throws IOException {
        C12388e c12388e = new C12388e();
        responseBody.mo10105c().mo10459k0(c12388e);
        MediaType mediaTypeMo10104b = responseBody.mo10104b();
        long jMo10103a = responseBody.mo10103a();
        C12238m.checkParameterIsNotNull(c12388e, "content");
        C12238m.checkParameterIsNotNull(c12388e, "$this$asResponseBody");
        return new C12264b0(c12388e, mediaTypeMo10104b, jMo10103a);
    }

    /* JADX INFO: renamed from: b */
    public static void m10682b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m10683c(Type type, Type type2) {
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
                return m10683c(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
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
    public static Type m10684d(Type type, Class<?> cls, Class<?> cls2) {
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
                    return m10684d(cls.getGenericInterfaces()[i], interfaces[i], cls2);
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
                    return m10684d(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* JADX INFO: renamed from: e */
    public static Type m10685e(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i >= 0 && i < actualTypeArguments.length) {
            Type type = actualTypeArguments[i];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        StringBuilder sbM834V = C1643a.m834V("Index ", i, " not in range [0,");
        sbM834V.append(actualTypeArguments.length);
        sbM834V.append(") for ");
        sbM834V.append(parameterizedType);
        throw new IllegalArgumentException(sbM834V.toString());
    }

    /* JADX INFO: renamed from: f */
    public static Class<?> m10686f(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m10686f(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m10686f(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    /* JADX INFO: renamed from: g */
    public static Type m10687g(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m10694n(type, cls, m10684d(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: h */
    public static boolean m10688h(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (m10688h(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return m10688h(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    /* JADX INFO: renamed from: i */
    public static boolean m10689i(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public static RuntimeException m10690j(Method method, String str, Object... objArr) {
        return m10691k(method, null, str, objArr);
    }

    /* JADX INFO: renamed from: k */
    public static RuntimeException m10691k(Method method, Throwable th, String str, Object... objArr) {
        StringBuilder sbM836X = C1643a.m836X(String.format(str, objArr), "\n    for method ");
        sbM836X.append(method.getDeclaringClass().getSimpleName());
        sbM836X.append(".");
        sbM836X.append(method.getName());
        return new IllegalArgumentException(sbM836X.toString(), th);
    }

    /* JADX INFO: renamed from: l */
    public static RuntimeException m10692l(Method method, int i, String str, Object... objArr) {
        StringBuilder sbM836X = C1643a.m836X(str, " (parameter #");
        sbM836X.append(i + 1);
        sbM836X.append(")");
        return m10690j(method, sbM836X.toString(), objArr);
    }

    /* JADX INFO: renamed from: m */
    public static RuntimeException m10693m(Method method, Throwable th, int i, String str, Object... objArr) {
        StringBuilder sbM836X = C1643a.m836X(str, " (parameter #");
        sbM836X.append(i + 1);
        sbM836X.append(")");
        return m10691k(method, th, sbM836X.toString(), objArr);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX INFO: renamed from: n */
    public static Type m10694n(Type type, Class<?> cls, Type type2) {
        Type type3;
        WildcardType wildcardType;
        Type type4;
        Type type5 = type2;
        while (true) {
            int i = 0;
            if (!(type5 instanceof TypeVariable)) {
                if (type5 instanceof Class) {
                    Class cls2 = (Class) type5;
                    if (cls2.isArray()) {
                        Class<?> componentType = cls2.getComponentType();
                        Type typeM10694n = m10694n(type, cls, componentType);
                        return componentType == typeM10694n ? cls2 : new a(typeM10694n);
                    }
                }
                if (type5 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type5;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeM10694n2 = m10694n(type, cls, genericComponentType);
                    return genericComponentType == typeM10694n2 ? genericArrayType : new a(typeM10694n2);
                }
                if (type5 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type5;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type typeM10694n3 = m10694n(type, cls, ownerType);
                    boolean z2 = typeM10694n3 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    while (i < length) {
                        Type typeM10694n4 = m10694n(type, cls, actualTypeArguments[i]);
                        if (typeM10694n4 != actualTypeArguments[i]) {
                            if (!z2) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z2 = true;
                            }
                            actualTypeArguments[i] = typeM10694n4;
                        }
                        i++;
                    }
                    return z2 ? new b(typeM10694n3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                }
                if (type5 instanceof WildcardType) {
                    wildcardType = (WildcardType) type5;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type typeM10694n5 = m10694n(type, cls, lowerBounds[0]);
                        if (typeM10694n5 != lowerBounds[0]) {
                            type3 = type5;
                            type3 = wildcardType;
                            return new c(new Type[]{Object.class}, new Type[]{typeM10694n5});
                        }
                    } else if (upperBounds.length == 1) {
                        type3 = type5;
                        type3 = wildcardType;
                        Type typeM10694n6 = m10694n(type, cls, upperBounds[0]);
                        type3 = wildcardType;
                        if (typeM10694n6 != upperBounds[0]) {
                            return new c(new Type[]{typeM10694n6}, f26490a);
                        }
                    }
                }
                type3 = type5;
                type3 = wildcardType;
                type3 = type5;
                type3 = wildcardType;
                type3 = type5;
                return type3;
            }
            TypeVariable typeVariable = (TypeVariable) type5;
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 == null) {
                type4 = typeVariable;
            } else {
                Type typeM10684d = m10684d(type, cls, cls3);
                if (typeM10684d instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    while (true) {
                        if (i >= typeParameters.length) {
                            throw new NoSuchElementException();
                        }
                        if (typeVariable.equals(typeParameters[i])) {
                            type4 = ((ParameterizedType) typeM10684d).getActualTypeArguments()[i];
                            break;
                        }
                        i++;
                    }
                } else {
                    type4 = typeVariable;
                }
            }
            if (type4 == typeVariable) {
                return type4;
            }
            type5 = type4;
        }
    }

    /* JADX INFO: renamed from: o */
    public static void m10695o(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    /* JADX INFO: renamed from: p */
    public static String m10696p(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
