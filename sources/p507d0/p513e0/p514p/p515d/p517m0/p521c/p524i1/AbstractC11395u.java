package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.u */
/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11395u implements InterfaceC11330e {

    /* JADX INFO: renamed from: j */
    public static final a f22986j = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.u$a */
    /* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final InterfaceC11770i getRefinedMemberScopeIfPossible$descriptors(InterfaceC11330e interfaceC11330e, AbstractC12018z0 abstractC12018z0, AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(interfaceC11330e, "<this>");
            C12238m.checkNotNullParameter(abstractC12018z0, "typeSubstitution");
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            AbstractC11395u abstractC11395u = interfaceC11330e instanceof AbstractC11395u ? (AbstractC11395u) interfaceC11330e : null;
            if (abstractC11395u != null) {
                return abstractC11395u.getMemberScope(abstractC12018z0, abstractC11947g);
            }
            InterfaceC11770i memberScope = interfaceC11330e.getMemberScope(abstractC12018z0);
            C12238m.checkNotNullExpressionValue(memberScope, "this.getMemberScope(\n                typeSubstitution\n            )");
            return memberScope;
        }

        public final InterfaceC11770i getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(InterfaceC11330e interfaceC11330e, AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(interfaceC11330e, "<this>");
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            AbstractC11395u abstractC11395u = interfaceC11330e instanceof AbstractC11395u ? (AbstractC11395u) interfaceC11330e : null;
            if (abstractC11395u != null) {
                return abstractC11395u.getUnsubstitutedMemberScope(abstractC11947g);
            }
            InterfaceC11770i unsubstitutedMemberScope = interfaceC11330e.getUnsubstitutedMemberScope();
            C12238m.checkNotNullExpressionValue(unsubstitutedMemberScope, "this.unsubstitutedMemberScope");
            return unsubstitutedMemberScope;
        }
    }

    public abstract InterfaceC11770i getMemberScope(AbstractC12018z0 abstractC12018z0, AbstractC11947g abstractC11947g);

    public abstract InterfaceC11770i getUnsubstitutedMemberScope(AbstractC11947g abstractC11947g);
}
