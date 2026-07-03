package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.c */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11555c extends AbstractC12240o implements Function0<AbstractC11913c0> {
    public final /* synthetic */ C11553a $attr;
    public final /* synthetic */ InterfaceC12008u0 $constructor;
    public final /* synthetic */ InterfaceC11477z0 $parameter;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.c$a */
    /* JADX INFO: compiled from: JavaTypeResolver.kt */
    public static final class a extends AbstractC12240o implements Function0<AbstractC11913c0> {
        public final /* synthetic */ InterfaceC12008u0 $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC12008u0 interfaceC12008u0) {
            super(0);
            this.$constructor = interfaceC12008u0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11913c0 invoke() {
            InterfaceC11352h declarationDescriptor = this.$constructor.getDeclarationDescriptor();
            C12238m.checkNotNull(declarationDescriptor);
            AbstractC11934j0 defaultType = declarationDescriptor.getDefaultType();
            C12238m.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return C11992a.replaceArgumentsWithStarProjections(defaultType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11555c(InterfaceC11477z0 interfaceC11477z0, C11553a c11553a, InterfaceC12008u0 interfaceC12008u0) {
        super(0);
        this.$parameter = interfaceC11477z0;
        this.$attr = c11553a;
        this.$constructor = interfaceC12008u0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AbstractC11913c0 invoke() {
        InterfaceC11477z0 interfaceC11477z0 = this.$parameter;
        C12238m.checkNotNullExpressionValue(interfaceC11477z0, "parameter");
        return C11557e.getErasedUpperBound(interfaceC11477z0, this.$attr.getUpperBoundOfTypeParameter(), new a(this.$constructor));
    }
}
