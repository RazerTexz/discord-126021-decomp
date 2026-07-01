package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$h$a extends e$h implements c {
    public final Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$h$a(Method method, Object obj) {
        super(method, false, (Type[]) null, 4);
        m.checkNotNullParameter(method, "method");
        this.g = obj;
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        return b(this.g, objArr);
    }
}
