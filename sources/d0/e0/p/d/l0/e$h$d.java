package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$h$d extends e$h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$h$d(Method method) {
        super(method, false, (Type[]) null, 6);
        m.checkNotNullParameter(method, "method");
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        Object[] objArrCopyOfRange;
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        Object obj = objArr[0];
        if (objArr.length <= 1) {
            objArrCopyOfRange = new Object[0];
        } else {
            objArrCopyOfRange = d0.t.j.copyOfRange(objArr, 1, objArr.length);
            Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
        }
        return b(obj, objArrCopyOfRange);
    }
}
