package d0.e0.p.d;

import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.f.a0.b.JvmMemberSignature;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.d, reason: use source file name */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RuntimeTypeMapper {

    /* JADX INFO: renamed from: d0.e0.p.d.d$a */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class a extends RuntimeTypeMapper {
        public final List<Method> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f3191b;

        /* JADX INFO: renamed from: d0.e0.p.d.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class C0373a<T> implements Comparator<T> {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Method method = (Method) t;
                Intrinsics3.checkNotNullExpressionValue(method, "it");
                String name = method.getName();
                Method method2 = (Method) t2;
                Intrinsics3.checkNotNullExpressionValue(method2, "it");
                return d0.u.a.compareValues(name, method2.getName());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.d$a$b */
        /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
        public static final class b extends Lambda implements Function1<Method, CharSequence> {
            public static final b j = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Method method) {
                Intrinsics3.checkNotNullExpressionValue(method, "it");
                Class<?> returnType = method.getReturnType();
                Intrinsics3.checkNotNullExpressionValue(returnType, "it.returnType");
                return reflectClassUtil.getDesc(returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> cls) {
            super(null);
            Intrinsics3.checkNotNullParameter(cls, "jClass");
            this.f3191b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics3.checkNotNullExpressionValue(declaredMethods, "jClass.declaredMethods");
            this.a = _Arrays.sortedWith(declaredMethods, new C0373a());
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper
        public String asString() {
            return _Collections.joinToString$default(this.a, "", "<init>(", ")V", 0, null, b.j, 24, null);
        }

        public final List<Method> getMethods() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$b */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class b extends RuntimeTypeMapper {
        public final Constructor<?> a;

        /* JADX INFO: renamed from: d0.e0.p.d.d$b$a */
        /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
        public static final class a extends Lambda implements Function1<Class<?>, CharSequence> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Class<?> cls) {
                Intrinsics3.checkNotNullExpressionValue(cls, "it");
                return reflectClassUtil.getDesc(cls);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(null);
            Intrinsics3.checkNotNullParameter(constructor, "constructor");
            this.a = constructor;
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper
        public String asString() {
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
            return _Arrays.joinToString$default(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, a.j, 24, (Object) null);
        }

        public final Constructor<?> getConstructor() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$c */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class c extends RuntimeTypeMapper {
        public final Method a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            Intrinsics3.checkNotNullParameter(method, "method");
            this.a = method;
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper
        public String asString() {
            return RuntimeTypeMapper5.access$getSignature$p(this.a);
        }

        public final Method getMethod() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$d */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class d extends RuntimeTypeMapper {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JvmMemberSignature.b f3192b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(JvmMemberSignature.b bVar) {
            super(null);
            Intrinsics3.checkNotNullParameter(bVar, "signature");
            this.f3192b = bVar;
            this.a = bVar.asString();
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper
        public String asString() {
            return this.a;
        }

        public final String getConstructorDesc() {
            return this.f3192b.getDesc();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$e */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class e extends RuntimeTypeMapper {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JvmMemberSignature.b f3193b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(JvmMemberSignature.b bVar) {
            super(null);
            Intrinsics3.checkNotNullParameter(bVar, "signature");
            this.f3193b = bVar;
            this.a = bVar.asString();
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper
        public String asString() {
            return this.a;
        }

        public final String getMethodDesc() {
            return this.f3193b.getDesc();
        }

        public final String getMethodName() {
            return this.f3193b.getName();
        }
    }

    public RuntimeTypeMapper(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
