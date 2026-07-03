package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.g */
/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11947g {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.g$a */
    /* JADX INFO: compiled from: KotlinTypeRefiner.kt */
    public static final class a extends AbstractC11947g {

        /* JADX INFO: renamed from: a */
        public static final a f24807a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g
        public InterfaceC11330e findClassAcrossModuleDependencies(C11712a c11712a) {
            C12238m.checkNotNullParameter(c11712a, "classId");
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g
        public <S extends InterfaceC11770i> S getOrPutScopeForClass(InterfaceC11330e interfaceC11330e, Function0<? extends S> function0) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            C12238m.checkNotNullParameter(function0, "compute");
            return function0.invoke();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g
        public boolean isRefinementNeededForModule(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "moduleDescriptor");
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g
        public boolean isRefinementNeededForTypeConstructor(InterfaceC12008u0 interfaceC12008u0) {
            C12238m.checkNotNullParameter(interfaceC12008u0, "typeConstructor");
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g
        public InterfaceC11330e refineDescriptor(InterfaceC11450m interfaceC11450m) {
            C12238m.checkNotNullParameter(interfaceC11450m, "descriptor");
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g
        public Collection<AbstractC11913c0> refineSupertypes(InterfaceC11330e interfaceC11330e) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            Collection<AbstractC11913c0> supertypes = interfaceC11330e.getTypeConstructor().getSupertypes();
            C12238m.checkNotNullExpressionValue(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g
        public AbstractC11913c0 refineType(AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(abstractC11913c0, "type");
            return abstractC11913c0;
        }
    }

    public abstract InterfaceC11330e findClassAcrossModuleDependencies(C11712a c11712a);

    public abstract <S extends InterfaceC11770i> S getOrPutScopeForClass(InterfaceC11330e interfaceC11330e, Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(InterfaceC11325c0 interfaceC11325c0);

    public abstract boolean isRefinementNeededForTypeConstructor(InterfaceC12008u0 interfaceC12008u0);

    public abstract InterfaceC11352h refineDescriptor(InterfaceC11450m interfaceC11450m);

    public abstract Collection<AbstractC11913c0> refineSupertypes(InterfaceC11330e interfaceC11330e);

    public abstract AbstractC11913c0 refineType(AbstractC11913c0 abstractC11913c0);
}
