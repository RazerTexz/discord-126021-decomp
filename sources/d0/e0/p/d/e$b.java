package d0.e0.p.d;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends e {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3194b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$b(Method method, Method method2) {
        super(null);
        d0.z.d.m.checkNotNullParameter(method, "getterMethod");
        this.a = method;
        this.f3194b = method2;
    }

    @Override // d0.e0.p.d.e
    public String asString() {
        return h0.access$getSignature$p(this.a);
    }

    public final Method getGetterMethod() {
        return this.a;
    }

    public final Method getSetterMethod() {
        return this.f3194b;
    }
}
