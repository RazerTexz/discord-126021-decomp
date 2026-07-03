package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11380j0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11867l;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e */
/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11369e extends AbstractC11383l implements InterfaceC11475y0 {

    /* JADX INFO: renamed from: n */
    public final AbstractC11466u f22851n;

    /* JADX INFO: renamed from: o */
    public List<? extends InterfaceC11477z0> f22852o;

    /* JADX INFO: renamed from: p */
    public final b f22853p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e$a */
    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class a extends AbstractC12240o implements Function1<AbstractC11932i1, Boolean> {
        public a() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x002d  */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AbstractC11932i1 abstractC11932i1) {
            boolean z2;
            C12238m.checkNotNullExpressionValue(abstractC11932i1, "type");
            if (!C11919e0.isError(abstractC11932i1)) {
                AbstractC11369e abstractC11369e = AbstractC11369e.this;
                InterfaceC11352h declarationDescriptor = abstractC11932i1.getConstructor().getDeclarationDescriptor();
                z2 = (declarationDescriptor instanceof InterfaceC11477z0) && !C12238m.areEqual(((InterfaceC11477z0) declarationDescriptor).getContainingDeclaration(), abstractC11369e);
            }
            return Boolean.valueOf(z2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e$b */
    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class b implements InterfaceC12008u0 {
        public b() {
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public AbstractC11288h getBuiltIns() {
            return C11836a.getBuiltIns(getDeclarationDescriptor());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public List<InterfaceC11477z0> getParameters() {
            List list = ((C11867l) AbstractC11369e.this).f24621z;
            if (list != null) {
                return list;
            }
            C12238m.throwUninitializedPropertyAccessException("typeConstructorParameters");
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public Collection<AbstractC11913c0> getSupertypes() {
            Collection<AbstractC11913c0> supertypes = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
            C12238m.checkNotNullExpressionValue(supertypes, "declarationDescriptor.underlyingType.constructor.supertypes");
            return supertypes;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public boolean isDenotable() {
            return true;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC12008u0 refine(AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            return this;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("[typealias ");
            sbM833U.append(getDeclarationDescriptor().getName().asString());
            sbM833U.append(']');
            return sbM833U.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC11475y0 getDeclarationDescriptor() {
            return AbstractC11369e.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11369e(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0, AbstractC11466u abstractC11466u) {
        super(interfaceC11450m, interfaceC11344g, c11716e, interfaceC11467u0);
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11467u0, "sourceElement");
        C12238m.checkNotNullParameter(abstractC11466u, "visibilityImpl");
        this.f22851n = abstractC11466u;
        this.f22853p = new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        C12238m.checkNotNullParameter(interfaceC11454o, "visitor");
        return interfaceC11454o.visitTypeAliasDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public List<InterfaceC11477z0> getDeclaredTypeParameters() {
        List list = this.f22852o;
        if (list != null) {
            return list;
        }
        C12238m.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        throw null;
    }

    public final Collection<InterfaceC11378i0> getTypeAliasConstructors() {
        C11867l c11867l = (C11867l) this;
        InterfaceC11330e classDescriptor = c11867l.getClassDescriptor();
        if (classDescriptor == null) {
            return C12147n.emptyList();
        }
        Collection<InterfaceC11327d> constructors = classDescriptor.getConstructors();
        C12238m.checkNotNullExpressionValue(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (InterfaceC11327d interfaceC11327d : constructors) {
            C11380j0.a aVar = C11380j0.f22887M;
            InterfaceC11905o interfaceC11905o = c11867l.f24612q;
            C12238m.checkNotNullExpressionValue(interfaceC11327d, "it");
            InterfaceC11378i0 interfaceC11378i0CreateIfAvailable = aVar.createIfAvailable(interfaceC11905o, this, interfaceC11327d);
            if (interfaceC11378i0CreateIfAvailable != null) {
                arrayList.add(interfaceC11378i0CreateIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public InterfaceC12008u0 getTypeConstructor() {
        return this.f22853p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        return this.f22851n;
    }

    public final void initialize(List<? extends InterfaceC11477z0> list) {
        C12238m.checkNotNullParameter(list, "declaredTypeParameters");
        this.f22852o = list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExternal() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public boolean isInner() {
        return C11920e1.contains(((C11867l) this).getUnderlyingType(), new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k
    public String toString() {
        return C12238m.stringPlus("typealias ", getName().asString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11475y0 getOriginal() {
        return (InterfaceC11475y0) super.getOriginal();
    }
}
