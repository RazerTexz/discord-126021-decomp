package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.c1;
import java.util.List;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$b {
    public final List<c1> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3337b;

    /* JADX WARN: Multi-variable type inference failed */
    public k$b(List<? extends c1> list, boolean z2) {
        d0.z.d.m.checkNotNullParameter(list, "descriptors");
        this.a = list;
        this.f3337b = z2;
    }

    public final List<c1> getDescriptors() {
        return this.a;
    }

    public final boolean getHasSynthesizedNames() {
        return this.f3337b;
    }
}
