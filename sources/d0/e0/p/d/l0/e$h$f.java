package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$h$f extends e$h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$h$f(Method method) {
        super(method, false, (Type[]) null, 6);
        m.checkNotNullParameter(method, "method");
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        return b(null, objArr);
    }
}
