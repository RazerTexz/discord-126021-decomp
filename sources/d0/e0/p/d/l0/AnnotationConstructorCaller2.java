package d0.e0.p.d.l0;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.LazyJVM;
import d0.e0.KClass;
import d0.e0.p.d.KotlinReflectionInternalError;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: d0.e0.p.d.l0.b, reason: use source file name */
/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationConstructorCaller2 {

    /* JADX INFO: renamed from: d0.e0.p.d.l0.b$a */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    public static final class a extends Lambda implements Function1<Object, Boolean> {
        public final /* synthetic */ Class $annotationClass;
        public final /* synthetic */ List $methods;
        public final /* synthetic */ Map $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, List list, Map map) {
            super(1);
            this.$annotationClass = cls;
            this.$methods = list;
            this.$values = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Object obj) throws IllegalAccessException, InvocationTargetException {
            boolean zAreEqual;
            boolean z2;
            KClass annotationClass;
            Class javaClass = null;
            Annotation annotation = (Annotation) (!(obj instanceof Annotation) ? null : obj);
            if (annotation != null && (annotationClass = JvmClassMapping.getAnnotationClass(annotation)) != null) {
                javaClass = JvmClassMapping.getJavaClass(annotationClass);
            }
            if (Intrinsics3.areEqual(javaClass, this.$annotationClass)) {
                List<Method> list = this.$methods;
                if ((list instanceof Collection) && list.isEmpty()) {
                    z2 = true;
                } else {
                    for (Method method : list) {
                        Object obj2 = this.$values.get(method.getName());
                        Object objInvoke = method.invoke(obj, new Object[0]);
                        if (obj2 instanceof boolean[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                            zAreEqual = Arrays.equals((boolean[]) obj2, (boolean[]) objInvoke);
                        } else if (obj2 instanceof char[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.CharArray");
                            zAreEqual = Arrays.equals((char[]) obj2, (char[]) objInvoke);
                        } else if (obj2 instanceof byte[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.ByteArray");
                            zAreEqual = Arrays.equals((byte[]) obj2, (byte[]) objInvoke);
                        } else if (obj2 instanceof short[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.ShortArray");
                            zAreEqual = Arrays.equals((short[]) obj2, (short[]) objInvoke);
                        } else if (obj2 instanceof int[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.IntArray");
                            zAreEqual = Arrays.equals((int[]) obj2, (int[]) objInvoke);
                        } else if (obj2 instanceof float[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.FloatArray");
                            zAreEqual = Arrays.equals((float[]) obj2, (float[]) objInvoke);
                        } else if (obj2 instanceof long[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.LongArray");
                            zAreEqual = Arrays.equals((long[]) obj2, (long[]) objInvoke);
                        } else if (obj2 instanceof double[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                            zAreEqual = Arrays.equals((double[]) obj2, (double[]) objInvoke);
                        } else if (obj2 instanceof Object[]) {
                            Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
                            zAreEqual = Arrays.equals((Object[]) obj2, (Object[]) objInvoke);
                        } else {
                            zAreEqual = Intrinsics3.areEqual(obj2, objInvoke);
                        }
                        if (!zAreEqual) {
                            z2 = false;
                        }
                    }
                    z2 = true;
                }
                if (z2) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.b$b */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    public static final class b extends Lambda implements Function0<Integer> {
        public final /* synthetic */ Map $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Map map) {
            super(0);
            this.$values = map;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            int iHashCode;
            int iHashCode2 = 0;
            for (Map.Entry entry : this.$values.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    iHashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    iHashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    iHashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    iHashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    iHashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    iHashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    iHashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    iHashCode = Arrays.hashCode((double[]) value);
                } else {
                    iHashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                }
                iHashCode2 += iHashCode ^ (str.hashCode() * Opcodes.LAND);
            }
            return iHashCode2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.b$c */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    public static final class c implements InvocationHandler {
        public final /* synthetic */ Class a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Lazy f3203b;
        public final /* synthetic */ Lazy c;
        public final /* synthetic */ a d;
        public final /* synthetic */ Map e;

        public c(Class cls, Lazy lazy, KProperty kProperty, Lazy lazy2, KProperty kProperty2, a aVar, Map map) {
            this.a = cls;
            this.f3203b = lazy;
            this.c = lazy2;
            this.d = aVar;
            this.e = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Intrinsics3.checkNotNullExpressionValue(method, "method");
            String name = method.getName();
            if (name != null) {
                int iHashCode = name.hashCode();
                if (iHashCode != -1776922004) {
                    if (iHashCode != 147696667) {
                        if (iHashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals("hashCode")) {
                        return this.c.getValue();
                    }
                } else if (name.equals("toString")) {
                    return this.f3203b.getValue();
                }
            }
            if (Intrinsics3.areEqual(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.d.invoke2(_Arrays.single(objArr)));
            }
            if (this.e.containsKey(name)) {
                return this.e.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            sb.append(_Arrays.toList(objArr));
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.b$d */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    public static final class d extends Lambda implements Function0<String> {
        public final /* synthetic */ Class $annotationClass;
        public final /* synthetic */ Map $values;

        /* JADX INFO: renamed from: d0.e0.p.d.l0.b$d$a */
        /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
        public static final class a extends Lambda implements Function1<Map.Entry<? extends String, ? extends Object>, CharSequence> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, ? extends Object> entry) {
                String string;
                Intrinsics3.checkNotNullParameter(entry, "entry");
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    string = Arrays.toString((boolean[]) value);
                } else if (value instanceof char[]) {
                    string = Arrays.toString((char[]) value);
                } else if (value instanceof byte[]) {
                    string = Arrays.toString((byte[]) value);
                } else if (value instanceof short[]) {
                    string = Arrays.toString((short[]) value);
                } else if (value instanceof int[]) {
                    string = Arrays.toString((int[]) value);
                } else if (value instanceof float[]) {
                    string = Arrays.toString((float[]) value);
                } else if (value instanceof long[]) {
                    string = Arrays.toString((long[]) value);
                } else if (value instanceof double[]) {
                    string = Arrays.toString((double[]) value);
                } else {
                    string = value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString();
                }
                return key + '=' + string;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                return invoke2((Map.Entry<String, ? extends Object>) entry);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Class cls, Map map) {
            super(0);
            this.$annotationClass = cls;
            this.$values = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() throws IOException {
            StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
            sbQ.append(this.$annotationClass.getCanonicalName());
            _Collections.joinTo(this.$values.entrySet(), sbQ, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : a.j);
            String string = sbQ.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    public static final Void access$throwIllegalArgumentType(int i, String str, Class cls) {
        KClass orCreateKotlinClass;
        String qualifiedName;
        if (Intrinsics3.areEqual(cls, Class.class)) {
            orCreateKotlinClass = Reflection2.getOrCreateKotlinClass(KClass.class);
        } else {
            orCreateKotlinClass = (cls.isArray() && Intrinsics3.areEqual(cls.getComponentType(), Class.class)) ? Reflection2.getOrCreateKotlinClass(KClass[].class) : JvmClassMapping.getKotlinClass(cls);
        }
        if (Intrinsics3.areEqual(orCreateKotlinClass.getQualifiedName(), Reflection2.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(orCreateKotlinClass.getQualifiedName());
            sb.append('<');
            Class<?> componentType = JvmClassMapping.getJavaClass(orCreateKotlinClass).getComponentType();
            Intrinsics3.checkNotNullExpressionValue(componentType, "kotlinClass.java.componentType");
            sb.append(JvmClassMapping.getKotlinClass(componentType).getQualifiedName());
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
        if (obj instanceof KClass) {
            obj = JvmClassMapping.getJavaClass((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(JvmClassMapping.getJavaClass(kClass));
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
        Intrinsics3.checkNotNullParameter(cls, "annotationClass");
        Intrinsics3.checkNotNullParameter(map, "values");
        Intrinsics3.checkNotNullParameter(list, "methods");
        a aVar = new a(cls, list, map);
        Lazy lazy = LazyJVM.lazy(new b(map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new c(cls, LazyJVM.lazy(new d(cls, map)), null, lazy, null, aVar, map));
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }
}
