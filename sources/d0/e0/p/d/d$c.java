package d0.e0.p.d;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$c extends d {
    public final Method a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$c(Method method) {
        super(null);
        d0.z.d.m.checkNotNullParameter(method, "method");
        this.a = method;
    }

    @Override // d0.e0.p.d.d
    public String asString() {
        return h0.access$getSignature$p(this.a);
    }

    public final Method getMethod() {
        return this.a;
    }
}
