package d0.e0.p.d.m0.n;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 extends z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v0$a f3542b = new v0$a(null);

    public static final z0 create(u0 u0Var, List<? extends w0> list) {
        return f3542b.create(u0Var, list);
    }

    public static final v0 createByConstructorsMap(Map<u0, ? extends w0> map) {
        return f3542b.createByConstructorsMap(map);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public w0 get(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "key");
        return get(c0Var.getConstructor());
    }

    public abstract w0 get(u0 u0Var);
}
