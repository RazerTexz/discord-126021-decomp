package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.n, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer9 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ JvmBuiltInsCustomizer2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer9(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        super(1);
        this.this$0 = jvmBuiltInsCustomizer2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(callableMemberDescriptor.getKind() == CallableMemberDescriptor.a.DECLARATION && this.this$0.c.isMutable((ClassDescriptor) callableMemberDescriptor.getContainingDeclaration()));
    }
}
