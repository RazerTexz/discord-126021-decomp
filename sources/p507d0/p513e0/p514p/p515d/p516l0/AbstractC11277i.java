package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l0.i */
/* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11277i implements InterfaceC11272d<Method> {

    /* JADX INFO: renamed from: a */
    public final Type f22442a;

    /* JADX INFO: renamed from: b */
    public final Method f22443b;

    /* JADX INFO: renamed from: c */
    public final List<Type> f22444c;

    /* JADX INFO: renamed from: d0.e0.p.d.l0.i$a */
    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    public static final class a extends AbstractC11277i implements InterfaceC11271c {

        /* JADX INFO: renamed from: d */
        public final Object f22445d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method method, Object obj) {
            super(method, C12147n.emptyList(), null);
            C12238m.checkNotNullParameter(method, "unboxMethod");
            this.f22445d = obj;
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = this.f22445d;
            C12238m.checkNotNullParameter(objArr, "args");
            return this.f22443b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.i$b */
    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    public static final class b extends AbstractC11277i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method) {
            super(method, C12145m.listOf(method.getDeclaringClass()), null);
            C12238m.checkNotNullParameter(method, "unboxMethod");
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
        public Object call(Object[] objArr) {
            Object[] objArrCopyOfRange;
            C12238m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = objArr[0];
            AbstractC11273e.d dVar = AbstractC11273e.f22423a;
            if (objArr.length <= 1) {
                objArrCopyOfRange = new Object[0];
            } else {
                objArrCopyOfRange = C12139j.copyOfRange(objArr, 1, objArr.length);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            C12238m.checkNotNullParameter(objArrCopyOfRange, "args");
            return this.f22443b.invoke(obj, Arrays.copyOf(objArrCopyOfRange, objArrCopyOfRange.length));
        }
    }

    public AbstractC11277i(Method method, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.f22443b = method;
        this.f22444c = list;
        Class<?> returnType = method.getReturnType();
        C12238m.checkNotNullExpressionValue(returnType, "unboxMethod.returnType");
        this.f22442a = returnType;
    }

    public void checkArguments(Object[] objArr) {
        C12238m.checkNotNullParameter(objArr, "args");
        InterfaceC11272d.a.checkArguments(this, objArr);
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    /* JADX INFO: renamed from: getMember */
    public final Method mo11457getMember() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public final List<Type> getParameterTypes() {
        return this.f22444c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public final Type getReturnType() {
        return this.f22442a;
    }
}
