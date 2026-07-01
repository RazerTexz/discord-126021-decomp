package d0.e0.p.d.l0;

import d0.t.n;
import d0.z.d.m;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a extends i implements c {
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$a(Method method, Object obj) {
        super(method, n.emptyList(), null);
        m.checkNotNullParameter(method, "unboxMethod");
        this.d = obj;
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        Object obj = this.d;
        m.checkNotNullParameter(objArr, "args");
        return this.f3207b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }
}
