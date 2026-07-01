package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.g.FqName;
import d0.t.Sets5;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.k, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorRenderer5 {
    public static final DescriptorRenderer5 a = new DescriptorRenderer5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<FqName> f3450b = Sets5.setOf((Object[]) new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")});

    public final Set<FqName> getInternalAnnotationsForResolve() {
        return f3450b;
    }
}
