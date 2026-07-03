package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12220c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l0.e */
/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11273e<M extends Member> implements InterfaceC11272d<M> {

    /* JADX INFO: renamed from: a */
    public static final d f22423a = new d(null);

    /* JADX INFO: renamed from: b */
    public final List<Type> f22424b;

    /* JADX INFO: renamed from: c */
    public final M f22425c;

    /* JADX INFO: renamed from: d */
    public final Type f22426d;

    /* JADX INFO: renamed from: e */
    public final Class<?> f22427e;

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$a */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static final class a extends AbstractC11273e<Constructor<?>> implements InterfaceC11271c {

        /* JADX INFO: renamed from: f */
        public final Object f22428f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor<?> constructor, Object obj) {
            Object objCopyOfRange;
            C12238m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            C12238m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            C12238m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 2) {
                objCopyOfRange = new Type[0];
            } else {
                objCopyOfRange = C12139j.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length - 1);
                Objects.requireNonNull(objCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            super(constructor, declaringClass, null, (Type[]) objCopyOfRange, null);
            this.f22428f = obj;
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo11457getMember = mo11457getMember();
            C12220c0 c12220c0 = new C12220c0(3);
            c12220c0.add(this.f22428f);
            c12220c0.addSpread(objArr);
            c12220c0.add(null);
            return constructorMo11457getMember.newInstance(c12220c0.toArray(new Object[c12220c0.size()]));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$b */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static final class b extends AbstractC11273e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Constructor<?> constructor) {
            Object objCopyOfRange;
            C12238m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            C12238m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            C12238m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 1) {
                objCopyOfRange = new Type[0];
            } else {
                objCopyOfRange = C12139j.copyOfRange(genericParameterTypes, 0, genericParameterTypes.length - 1);
                Objects.requireNonNull(objCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            super(constructor, declaringClass, null, (Type[]) objCopyOfRange, null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo11457getMember = mo11457getMember();
            C12220c0 c12220c0 = new C12220c0(2);
            c12220c0.addSpread(objArr);
            c12220c0.add(null);
            return constructorMo11457getMember.newInstance(c12220c0.toArray(new Object[c12220c0.size()]));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$c */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static final class c extends AbstractC11273e<Constructor<?>> implements InterfaceC11271c {

        /* JADX INFO: renamed from: f */
        public final Object f22429f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Constructor<?> constructor, Object obj) {
            C12238m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            C12238m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            C12238m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.f22429f = obj;
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo11457getMember = mo11457getMember();
            C12220c0 c12220c0 = new C12220c0(2);
            c12220c0.add(this.f22429f);
            c12220c0.addSpread(objArr);
            return constructorMo11457getMember.newInstance(c12220c0.toArray(new Object[c12220c0.size()]));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$d */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static final class d {
        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$e */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static final class e extends AbstractC11273e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public e(Constructor<?> constructor) {
            C12238m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            C12238m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Class<?> declaringClass2 = constructor.getDeclaringClass();
            C12238m.checkNotNullExpressionValue(declaringClass2, "klass");
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            C12238m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            return mo11457getMember().newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$f */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static abstract class f extends AbstractC11273e<Field> {

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$f$a */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class a extends f implements InterfaceC11271c {

            /* JADX INFO: renamed from: f */
            public final Object f22430f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                C12238m.checkNotNullParameter(field, "field");
                this.f22430f = obj;
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e.f, p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) {
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return mo11457getMember().get(this.f22430f);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$f$b */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class b extends f implements InterfaceC11271c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                C12238m.checkNotNullParameter(field, "field");
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$f$c */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                C12238m.checkNotNullParameter(field, "field");
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$f$d */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                C12238m.checkNotNullParameter(field, "field");
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e
            public void checkArguments(Object[] objArr) {
                C12238m.checkNotNullParameter(objArr, "args");
                super.checkArguments(objArr);
                m9352a(C12141k.firstOrNull(objArr));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$f$e */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field) {
                super(field, false, null);
                C12238m.checkNotNullParameter(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Field field, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            Type genericType = field.getGenericType();
            C12238m.checkNotNullExpressionValue(genericType, "field.genericType");
            super(field, genericType, z2 ? field.getDeclaringClass() : null, new Type[0], null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            return mo11457getMember().get(getInstanceClass() != null ? C12141k.first(objArr) : null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$g */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static abstract class g extends AbstractC11273e<Field> {

        /* JADX INFO: renamed from: f */
        public final boolean f22431f;

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$g$a */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class a extends g implements InterfaceC11271c {

            /* JADX INFO: renamed from: g */
            public final Object f22432g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z2, Object obj) {
                super(field, z2, false, null);
                C12238m.checkNotNullParameter(field, "field");
                this.f22432g = obj;
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e.g, p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) throws IllegalAccessException {
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                mo11457getMember().set(this.f22432g, C12141k.first(objArr));
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$g$b */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class b extends g implements InterfaceC11271c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z2) {
                super(field, z2, false, null);
                C12238m.checkNotNullParameter(field, "field");
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e.g, p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) throws IllegalAccessException {
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                mo11457getMember().set(null, C12141k.last(objArr));
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$g$c */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z2) {
                super(field, z2, true, null);
                C12238m.checkNotNullParameter(field, "field");
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$g$d */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z2) {
                super(field, z2, true, null);
                C12238m.checkNotNullParameter(field, "field");
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e.g, p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e
            public void checkArguments(Object[] objArr) {
                C12238m.checkNotNullParameter(objArr, "args");
                super.checkArguments(objArr);
                m9352a(C12141k.firstOrNull(objArr));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$g$e */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field, boolean z2) {
                super(field, z2, false, null);
                C12238m.checkNotNullParameter(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public g(Field field, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            Class cls = Void.TYPE;
            C12238m.checkNotNullExpressionValue(cls, "Void.TYPE");
            Class<?> declaringClass = z3 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            C12238m.checkNotNullExpressionValue(genericType, "field.genericType");
            super(field, cls, declaringClass, new Type[]{genericType}, null);
            this.f22431f = z2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) throws IllegalAccessException {
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            mo11457getMember().set(getInstanceClass() != null ? C12141k.first(objArr) : null, C12141k.last(objArr));
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e
        public void checkArguments(Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            super.checkArguments(objArr);
            if (this.f22431f && C12141k.last(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.e$h */
    /* JADX INFO: compiled from: CallerImpl.kt */
    public static abstract class h extends AbstractC11273e<Method> {

        /* JADX INFO: renamed from: f */
        public final boolean f22433f;

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$h$a */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class a extends h implements InterfaceC11271c {

            /* JADX INFO: renamed from: g */
            public final Object f22434g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, (Type[]) null, 4);
                C12238m.checkNotNullParameter(method, "method");
                this.f22434g = obj;
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) {
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return m9353b(this.f22434g, objArr);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$h$b */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class b extends h implements InterfaceC11271c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, (Type[]) null, 4);
                C12238m.checkNotNullParameter(method, "method");
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) {
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return m9353b(null, objArr);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$h$c */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class c extends h implements InterfaceC11271c {

            /* JADX INFO: renamed from: g */
            public final Object f22435g;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(Method method, Object obj) {
                Object objCopyOfRange;
                C12238m.checkNotNullParameter(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                C12238m.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
                boolean z2 = false;
                if (genericParameterTypes.length <= 1) {
                    objCopyOfRange = new Type[0];
                } else {
                    objCopyOfRange = C12139j.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                    Objects.requireNonNull(objCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                super(method, z2, (Type[]) objCopyOfRange, (DefaultConstructorMarker) null);
                this.f22435g = obj;
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) {
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                C12220c0 c12220c0 = new C12220c0(2);
                c12220c0.add(this.f22435g);
                c12220c0.addSpread(objArr);
                return m9353b(null, c12220c0.toArray(new Object[c12220c0.size()]));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$h$d */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Method method) {
                super(method, false, (Type[]) null, 6);
                C12238m.checkNotNullParameter(method, "method");
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) {
                Object[] objArrCopyOfRange;
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    objArrCopyOfRange = new Object[0];
                } else {
                    objArrCopyOfRange = C12139j.copyOfRange(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return m9353b(obj, objArrCopyOfRange);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$h$e */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Method method) {
                super(method, true, (Type[]) null, 4);
                C12238m.checkNotNullParameter(method, "method");
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) {
                Object[] objArrCopyOfRange;
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                m9352a(C12141k.firstOrNull(objArr));
                if (objArr.length <= 1) {
                    objArrCopyOfRange = new Object[0];
                } else {
                    objArrCopyOfRange = C12139j.copyOfRange(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return m9353b(null, objArrCopyOfRange);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.l0.e$h$f */
        /* JADX INFO: compiled from: CallerImpl.kt */
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, false, (Type[]) null, 6);
                C12238m.checkNotNullParameter(method, "method");
            }

            @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
            public Object call(Object[] objArr) {
                C12238m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return m9353b(null, objArr);
            }
        }

        public /* synthetic */ h(Method method, boolean z2, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(method, z2, typeArr);
        }

        /* JADX INFO: renamed from: b */
        public final Object m9353b(Object obj, Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            return this.f22433f ? Unit.f27425a : mo11457getMember().invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ h(Method method, boolean z2, Type[] typeArr, int i) {
            Type[] genericParameterTypes;
            z2 = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z2;
            if ((i & 4) != 0) {
                genericParameterTypes = method.getGenericParameterTypes();
                C12238m.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
            } else {
                genericParameterTypes = null;
            }
            this(method, z2, genericParameterTypes);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public h(Method method, boolean z2, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            C12238m.checkNotNullExpressionValue(genericReturnType, "method.genericReturnType");
            super(method, genericReturnType, z2 ? method.getDeclaringClass() : null, typeArr, null);
            this.f22433f = C12238m.areEqual(getReturnType(), Void.TYPE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002a  */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC11273e(Member member, Type type, Class cls, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
        List<Type> list;
        this.f22425c = member;
        this.f22426d = type;
        this.f22427e = cls;
        if (cls != null) {
            C12220c0 c12220c0 = new C12220c0(2);
            c12220c0.add(cls);
            c12220c0.addSpread(typeArr);
            list = C12147n.listOf(c12220c0.toArray(new Type[c12220c0.size()]));
            list = list == null ? C12141k.toList(typeArr) : list;
        }
        this.f22424b = list;
    }

    /* JADX INFO: renamed from: a */
    public final void m9352a(Object obj) {
        if (obj == null || !this.f22425c.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public void checkArguments(Object[] objArr) {
        C12238m.checkNotNullParameter(objArr, "args");
        InterfaceC11272d.a.checkArguments(this, objArr);
    }

    public final Class<?> getInstanceClass() {
        return this.f22427e;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    /* JADX INFO: renamed from: getMember */
    public final M mo11457getMember() {
        return this.f22425c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public List<Type> getParameterTypes() {
        return this.f22424b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public final Type getReturnType() {
        return this.f22426d;
    }
}
