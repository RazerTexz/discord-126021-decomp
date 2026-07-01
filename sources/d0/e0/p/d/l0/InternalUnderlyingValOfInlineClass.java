package d0.e0.p.d.l0;

import d0.e0.p.d.l0.Caller2;
import d0.e0.p.d.l0.CallerImpl;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.l0.i, reason: use source file name */
/* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class InternalUnderlyingValOfInlineClass implements Caller2<Method> {
    public final Type a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3207b;
    public final List<Type> c;

    /* JADX INFO: renamed from: d0.e0.p.d.l0.i$a */
    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    public static final class a extends InternalUnderlyingValOfInlineClass implements Caller {
        public final Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method method, Object obj) {
            super(method, Collections2.emptyList(), null);
            Intrinsics3.checkNotNullParameter(method, "unboxMethod");
            this.d = obj;
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = this.d;
            Intrinsics3.checkNotNullParameter(objArr, "args");
            return this.f3207b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.i$b */
    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    public static final class b extends InternalUnderlyingValOfInlineClass {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method) {
            super(method, CollectionsJVM.listOf(method.getDeclaringClass()), null);
            Intrinsics3.checkNotNullParameter(method, "unboxMethod");
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) {
            Object[] objArrCopyOfRange;
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = objArr[0];
            CallerImpl.d dVar = CallerImpl.a;
            if (objArr.length <= 1) {
                objArrCopyOfRange = new Object[0];
            } else {
                objArrCopyOfRange = _ArraysJvm.copyOfRange(objArr, 1, objArr.length);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            Intrinsics3.checkNotNullParameter(objArrCopyOfRange, "args");
            return this.f3207b.invoke(obj, Arrays.copyOf(objArrCopyOfRange, objArrCopyOfRange.length));
        }
    }

    public InternalUnderlyingValOfInlineClass(Method method, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3207b = method;
        this.c = list;
        Class<?> returnType = method.getReturnType();
        Intrinsics3.checkNotNullExpressionValue(returnType, "unboxMethod.returnType");
        this.a = returnType;
    }

    public void checkArguments(Object[] objArr) {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        Caller2.a.checkArguments(this, objArr);
    }

    @Override // d0.e0.p.d.l0.Caller2
    /* JADX INFO: renamed from: getMember */
    public final Method mo80getMember() {
        return null;
    }

    @Override // d0.e0.p.d.l0.Caller2
    public final List<Type> getParameterTypes() {
        return this.c;
    }

    @Override // d0.e0.p.d.l0.Caller2
    public final Type getReturnType() {
        return this.a;
    }
}
