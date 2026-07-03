package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.s0 */
/* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12004s0 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.s0$a */
    /* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class a implements InterfaceC12004s0 {

        /* JADX INFO: renamed from: a */
        public static final a f24876a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12004s0
        public void boundsViolationInSubstitution(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, AbstractC11913c0 abstractC11913c2, InterfaceC11477z0 interfaceC11477z0) {
            C12238m.checkNotNullParameter(abstractC11913c0, "bound");
            C12238m.checkNotNullParameter(abstractC11913c1, "unsubstitutedArgument");
            C12238m.checkNotNullParameter(abstractC11913c2, "argument");
            C12238m.checkNotNullParameter(interfaceC11477z0, "typeParameter");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12004s0
        public void conflictingProjection(InterfaceC11475y0 interfaceC11475y0, InterfaceC11477z0 interfaceC11477z0, AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(interfaceC11475y0, "typeAlias");
            C12238m.checkNotNullParameter(abstractC11913c0, "substitutedArgument");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12004s0
        public void recursiveTypeAlias(InterfaceC11475y0 interfaceC11475y0) {
            C12238m.checkNotNullParameter(interfaceC11475y0, "typeAlias");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12004s0
        public void repeatedAnnotation(InterfaceC11340c interfaceC11340c) {
            C12238m.checkNotNullParameter(interfaceC11340c, "annotation");
        }
    }

    void boundsViolationInSubstitution(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, AbstractC11913c0 abstractC11913c2, InterfaceC11477z0 interfaceC11477z0);

    void conflictingProjection(InterfaceC11475y0 interfaceC11475y0, InterfaceC11477z0 interfaceC11477z0, AbstractC11913c0 abstractC11913c0);

    void recursiveTypeAlias(InterfaceC11475y0 interfaceC11475y0);

    void repeatedAnnotation(InterfaceC11340c interfaceC11340c);
}
