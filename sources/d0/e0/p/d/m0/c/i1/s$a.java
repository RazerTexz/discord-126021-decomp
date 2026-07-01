package d0.e0.p.d.m0.c.i1;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$a extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.e0>> {
    public final /* synthetic */ s this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s$a(s sVar) {
        super(0);
        this.this$0 = sVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.e0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.e0> invoke2() {
        return d0.e0.p.d.m0.c.h0.packageFragments(this.this$0.getModule().getPackageFragmentProvider(), this.this$0.getFqName());
    }
}
