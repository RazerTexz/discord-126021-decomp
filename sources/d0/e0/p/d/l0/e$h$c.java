package d0.e0.p.d.l0;

import d0.z.d.c0;
import d0.z.d.m;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$h$c extends e$h implements c {
    public final Object g;

    /* JADX WARN: Illegal instructions before constructor call */
    public e$h$c(Method method, Object obj) {
        Object objCopyOfRange;
        m.checkNotNullParameter(method, "method");
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        m.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
        if (genericParameterTypes.length <= 1) {
            objCopyOfRange = new Type[0];
        } else {
            objCopyOfRange = d0.t.j.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
            Objects.requireNonNull(objCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
        }
        super(method, false, (Type[]) objCopyOfRange, (DefaultConstructorMarker) null);
        this.g = obj;
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        c0 c0Var = new c0(2);
        c0Var.add(this.g);
        c0Var.addSpread(objArr);
        return b(null, c0Var.toArray(new Object[c0Var.size()]));
    }
}
