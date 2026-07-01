package d0.e0.p.d.l0;

import d0.t.m;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$b(Method method) {
        super(method, m.listOf(method.getDeclaringClass()), null);
        d0.z.d.m.checkNotNullParameter(method, "unboxMethod");
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        Object[] objArrCopyOfRange;
        d0.z.d.m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        Object obj = objArr[0];
        e$d e_d = e.a;
        if (objArr.length <= 1) {
            objArrCopyOfRange = new Object[0];
        } else {
            objArrCopyOfRange = d0.t.j.copyOfRange(objArr, 1, objArr.length);
            Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
        }
        d0.z.d.m.checkNotNullParameter(objArrCopyOfRange, "args");
        return this.f3207b.invoke(obj, Arrays.copyOf(objArrCopyOfRange, objArrCopyOfRange.length));
    }
}
