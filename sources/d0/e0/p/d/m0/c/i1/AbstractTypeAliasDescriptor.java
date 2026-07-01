package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.d, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AbstractTypeAliasDescriptor extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
    public final /* synthetic */ AbstractTypeAliasDescriptor2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor(AbstractTypeAliasDescriptor2 abstractTypeAliasDescriptor2) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor classifierDescriptorRefineDescriptor = kotlinTypeRefiner.refineDescriptor(this.this$0);
        if (classifierDescriptorRefineDescriptor == null) {
            return null;
        }
        return classifierDescriptorRefineDescriptor.getDefaultType();
    }
}
