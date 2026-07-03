package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.d */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11252d {

    /* JADX INFO: renamed from: d0.e0.p.d.d$a */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class a extends AbstractC11252d {

        /* JADX INFO: renamed from: a */
        public final List<Method> f22327a;

        /* JADX INFO: renamed from: b */
        public final Class<?> f22328b;

        /* JADX INFO: renamed from: d0.e0.p.d.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class C13300a<T> implements Comparator<T> {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Method method = (Method) t;
                C12238m.checkNotNullExpressionValue(method, "it");
                String name = method.getName();
                Method method2 = (Method) t2;
                C12238m.checkNotNullExpressionValue(method2, "it");
                return C12169a.compareValues(name, method2.getName());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.d$a$b */
        /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
        public static final class b extends AbstractC12240o implements Function1<Method, CharSequence> {

            /* JADX INFO: renamed from: j */
            public static final b f22329j = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Method method) {
                C12238m.checkNotNullExpressionValue(method, "it");
                Class<?> returnType = method.getReturnType();
                C12238m.checkNotNullExpressionValue(returnType, "it.returnType");
                return C11423b.getDesc(returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> cls) {
            super(null);
            C12238m.checkNotNullParameter(cls, "jClass");
            this.f22328b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            C12238m.checkNotNullExpressionValue(declaredMethods, "jClass.declaredMethods");
            this.f22327a = C12141k.sortedWith(declaredMethods, new C13300a());
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11252d
        public String asString() {
            return C12163u.joinToString$default(this.f22327a, "", "<init>(", ")V", 0, null, b.f22329j, 24, null);
        }

        public final List<Method> getMethods() {
            return this.f22327a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$b */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class b extends AbstractC11252d {

        /* JADX INFO: renamed from: a */
        public final Constructor<?> f22330a;

        /* JADX INFO: renamed from: d0.e0.p.d.d$b$a */
        /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
        public static final class a extends AbstractC12240o implements Function1<Class<?>, CharSequence> {

            /* JADX INFO: renamed from: j */
            public static final a f22331j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Class<?> cls) {
                C12238m.checkNotNullExpressionValue(cls, "it");
                return C11423b.getDesc(cls);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(null);
            C12238m.checkNotNullParameter(constructor, "constructor");
            this.f22330a = constructor;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11252d
        public String asString() {
            Class<?>[] parameterTypes = this.f22330a.getParameterTypes();
            C12238m.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
            return C12141k.joinToString$default(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, a.f22331j, 24, (Object) null);
        }

        public final Constructor<?> getConstructor() {
            return this.f22330a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$c */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class c extends AbstractC11252d {

        /* JADX INFO: renamed from: a */
        public final Method f22332a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            C12238m.checkNotNullParameter(method, "method");
            this.f22332a = method;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11252d
        public String asString() {
            return C11261h0.access$getSignature$p(this.f22332a);
        }

        public final Method getMethod() {
            return this.f22332a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$d */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class d extends AbstractC11252d {

        /* JADX INFO: renamed from: a */
        public final String f22333a;

        /* JADX INFO: renamed from: b */
        public final AbstractC11672e.b f22334b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC11672e.b bVar) {
            super(null);
            C12238m.checkNotNullParameter(bVar, "signature");
            this.f22334b = bVar;
            this.f22333a = bVar.asString();
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11252d
        public String asString() {
            return this.f22333a;
        }

        public final String getConstructorDesc() {
            return this.f22334b.getDesc();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.d$e */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class e extends AbstractC11252d {

        /* JADX INFO: renamed from: a */
        public final String f22335a;

        /* JADX INFO: renamed from: b */
        public final AbstractC11672e.b f22336b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbstractC11672e.b bVar) {
            super(null);
            C12238m.checkNotNullParameter(bVar, "signature");
            this.f22336b = bVar;
            this.f22335a = bVar.asString();
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11252d
        public String asString() {
            return this.f22335a;
        }

        public final String getMethodDesc() {
            return this.f22336b.getDesc();
        }

        public final String getMethodName() {
            return this.f22336b.getName();
        }
    }

    public AbstractC11252d(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
