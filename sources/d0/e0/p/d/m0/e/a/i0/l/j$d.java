package d0.e0.p.d.m0.e.a.i0.l;

import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$d extends d0.z.d.o implements Function0<Set<? extends String>> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g $c;
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$d(d0.e0.p.d.m0.e.a.i0.g gVar, j jVar) {
        super(0);
        this.$c = gVar;
        this.this$0 = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends String> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends String> invoke2() {
        return this.$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.o.getFqName());
    }
}
