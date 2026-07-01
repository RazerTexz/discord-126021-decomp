package d0.e0.p.d.m0.e.b;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b<A, C> {
    public final Map<s, List<A>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<s, C> f3362b;

    /* JADX WARN: Multi-variable type inference failed */
    public a$b(Map<s, ? extends List<? extends A>> map, Map<s, ? extends C> map2) {
        d0.z.d.m.checkNotNullParameter(map, "memberAnnotations");
        d0.z.d.m.checkNotNullParameter(map2, "propertyConstants");
        this.a = map;
        this.f3362b = map2;
    }

    public final Map<s, List<A>> getMemberAnnotations() {
        return this.a;
    }

    public final Map<s, C> getPropertyConstants() {
        return this.f3362b;
    }
}
