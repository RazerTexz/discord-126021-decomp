package i0;

import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$n extends t<Object> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3757b;

    public t$n(Method method, int i) {
        this.a = method;
        this.f3757b = i;
    }

    @Override // i0.t
    public void a(v vVar, Object obj) {
        if (obj == null) {
            throw c0.l(this.a, this.f3757b, "@Url parameter is null.", new Object[0]);
        }
        Objects.requireNonNull(vVar);
        vVar.e = obj.toString();
    }
}
