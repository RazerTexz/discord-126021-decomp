package d0.e0.p.d.m0.k.x;

import d0.e0.p.d.m0.c.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e extends o implements Function1<m, m> {
    public static final a$e j = new a$e();

    public a$e() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ m invoke(m mVar) {
        return invoke2(mVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final m invoke2(m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "it");
        return mVar.getContainingDeclaration();
    }
}
