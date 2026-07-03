package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.v */
/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11886v extends AbstractC12240o implements Function0<List<? extends InterfaceC11340c>> {
    public final /* synthetic */ EnumC11846b $kind;
    public final /* synthetic */ InterfaceC11734n $proto;
    public final /* synthetic */ C11885u this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11886v(C11885u c11885u, InterfaceC11734n interfaceC11734n, EnumC11846b enumC11846b) {
        super(0);
        this.this$0 = c11885u;
        this.$proto = interfaceC11734n;
        this.$kind = enumC11846b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends InterfaceC11340c> invoke() {
        List<InterfaceC11340c> listLoadExtensionReceiverParameterAnnotations;
        C11885u c11885u = this.this$0;
        AbstractC11889y abstractC11889yM9968a = c11885u.m9968a(c11885u.f24683a.getContainingDeclaration());
        if (abstractC11889yM9968a == null) {
            listLoadExtensionReceiverParameterAnnotations = null;
        } else {
            listLoadExtensionReceiverParameterAnnotations = this.this$0.f24683a.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(abstractC11889yM9968a, this.$proto, this.$kind);
        }
        return listLoadExtensionReceiverParameterAnnotations != null ? listLoadExtensionReceiverParameterAnnotations : C12147n.emptyList();
    }
}
