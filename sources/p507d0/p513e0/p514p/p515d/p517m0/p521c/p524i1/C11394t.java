package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11775n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11930i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11990o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.C12163u;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.t */
/* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11394t extends AbstractC11395u {

    /* JADX INFO: renamed from: k */
    public final AbstractC11395u f22980k;

    /* JADX INFO: renamed from: l */
    public final C11914c1 f22981l;

    /* JADX INFO: renamed from: m */
    public C11914c1 f22982m;

    /* JADX INFO: renamed from: n */
    public List<InterfaceC11477z0> f22983n;

    /* JADX INFO: renamed from: o */
    public List<InterfaceC11477z0> f22984o;

    /* JADX INFO: renamed from: p */
    public InterfaceC12008u0 f22985p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.t$a */
    /* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
    public class a implements Function1<InterfaceC11477z0, Boolean> {
        public a(C11394t c11394t) {
        }

        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(InterfaceC11477z0 interfaceC11477z0) {
            return Boolean.valueOf(!interfaceC11477z0.isCapturedFromOuterDeclaration());
        }
    }

    public C11394t(AbstractC11395u abstractC11395u, C11914c1 c11914c1) {
        this.f22980k = abstractC11395u;
        this.f22981l = c11914c1;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005b  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9428a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? 3 : 2];
        if (i == 2) {
            objArr[0] = "typeArguments";
        } else if (i == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i == 6) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 8) {
            objArr[0] = "typeArguments";
        } else if (i == 10) {
            objArr[0] = "typeSubstitution";
        } else if (i == 13) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i != 22) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        } else {
            objArr[0] = "substitutor";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getConstructors";
                break;
            case 18:
                objArr[1] = "getAnnotations";
                break;
            case 19:
                objArr[1] = "getName";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getContainingDeclaration";
                break;
            case 23:
                objArr[1] = "substitute";
                break;
            case 24:
                objArr[1] = "getKind";
                break;
            case 25:
                objArr[1] = "getModality";
                break;
            case 26:
                objArr[1] = "getVisibility";
                break;
            case 27:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 28:
                objArr[1] = "getSource";
                break;
            case 29:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 30:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10) {
            objArr[2] = "getMemberScope";
        } else if (i == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i == 22) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 8 && i != 10 && i != 13 && i != 22) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return interfaceC11454o.visitClassDescriptor(this, d);
    }

    /* JADX INFO: renamed from: b */
    public final C11914c1 m9429b() {
        if (this.f22982m == null) {
            if (this.f22981l.isEmpty()) {
                this.f22982m = this.f22981l;
            } else {
                List<InterfaceC11477z0> parameters = this.f22980k.getTypeConstructor().getParameters();
                this.f22983n = new ArrayList(parameters.size());
                this.f22982m = C11990o.substituteTypeParameters(parameters, this.f22981l.getSubstitution(), this, this.f22983n);
                this.f22984o = C12163u.filter(this.f22983n, new a(this));
            }
        }
        return this.f22982m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        InterfaceC11344g annotations = this.f22980k.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        m9428a(18);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11330e getCompanionObjectDescriptor() {
        return this.f22980k.getCompanionObjectDescriptor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public Collection<InterfaceC11327d> getConstructors() {
        Collection<InterfaceC11327d> constructors = this.f22980k.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (InterfaceC11327d interfaceC11327d : constructors) {
            arrayList.add(((InterfaceC11327d) interfaceC11327d.newCopyBuilder().setOriginal(interfaceC11327d.getOriginal()).setModality(interfaceC11327d.getModality()).setVisibility(interfaceC11327d.getVisibility()).setKind(interfaceC11327d.getKind()).setCopyOverrides(false).build()).substitute(m9429b()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11452n, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11450m getContainingDeclaration() {
        InterfaceC11450m containingDeclaration = this.f22980k.getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        m9428a(21);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public List<InterfaceC11477z0> getDeclaredTypeParameters() {
        m9429b();
        List<InterfaceC11477z0> list = this.f22984o;
        if (list != null) {
            return list;
        }
        m9428a(29);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public AbstractC11934j0 getDefaultType() {
        AbstractC11934j0 abstractC11934j0SimpleTypeWithNonTrivialMemberScope = C11916d0.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), C11920e1.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (abstractC11934j0SimpleTypeWithNonTrivialMemberScope != null) {
            return abstractC11934j0SimpleTypeWithNonTrivialMemberScope;
        }
        m9428a(16);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public EnumC11333f getKind() {
        EnumC11333f kind = this.f22980k.getKind();
        if (kind != null) {
            return kind;
        }
        m9428a(24);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
    public InterfaceC11770i getMemberScope(AbstractC12018z0 abstractC12018z0, AbstractC11947g abstractC11947g) {
        if (abstractC12018z0 == null) {
            m9428a(5);
            throw null;
        }
        if (abstractC11947g == null) {
            m9428a(6);
            throw null;
        }
        InterfaceC11770i memberScope = this.f22980k.getMemberScope(abstractC12018z0, abstractC11947g);
        if (!this.f22981l.isEmpty()) {
            return new C11775n(memberScope, m9429b());
        }
        if (memberScope != null) {
            return memberScope;
        }
        m9428a(7);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public EnumC11476z getModality() {
        EnumC11476z modality = this.f22980k.getModality();
        if (modality != null) {
            return modality;
        }
        m9428a(25);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public C11716e getName() {
        C11716e name = this.f22980k.getName();
        if (name != null) {
            return name;
        }
        m9428a(19);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public Collection<InterfaceC11330e> getSealedSubclasses() {
        Collection<InterfaceC11330e> sealedSubclasses = this.f22980k.getSealedSubclasses();
        if (sealedSubclasses != null) {
            return sealedSubclasses;
        }
        m9428a(30);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p
    public InterfaceC11467u0 getSource() {
        return InterfaceC11467u0.f23099a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getStaticScope() {
        InterfaceC11770i staticScope = this.f22980k.getStaticScope();
        if (staticScope != null) {
            return staticScope;
        }
        m9428a(15);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11459q0 getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public InterfaceC12008u0 getTypeConstructor() {
        InterfaceC12008u0 typeConstructor = this.f22980k.getTypeConstructor();
        if (this.f22981l.isEmpty()) {
            if (typeConstructor != null) {
                return typeConstructor;
            }
            m9428a(0);
            throw null;
        }
        if (this.f22985p == null) {
            C11914c1 c11914c1M9429b = m9429b();
            Collection<AbstractC11913c0> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            Iterator<AbstractC11913c0> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(c11914c1M9429b.substitute(it.next(), EnumC11935j1.INVARIANT));
            }
            this.f22985p = new C11930i(this, this.f22983n, arrayList, C11896f.f24710b);
        }
        InterfaceC12008u0 interfaceC12008u0 = this.f22985p;
        if (interfaceC12008u0 != null) {
            return interfaceC12008u0;
        }
        m9428a(1);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getUnsubstitutedInnerClassesScope() {
        InterfaceC11770i unsubstitutedInnerClassesScope = this.f22980k.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope != null) {
            return unsubstitutedInnerClassesScope;
        }
        m9428a(27);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getUnsubstitutedMemberScope() {
        InterfaceC11770i unsubstitutedMemberScope = getUnsubstitutedMemberScope(C11836a.getKotlinTypeRefiner(C11787e.getContainingModule(this.f22980k)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        m9428a(12);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11327d getUnsubstitutedPrimaryConstructor() {
        return this.f22980k.getUnsubstitutedPrimaryConstructor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        AbstractC11466u visibility = this.f22980k.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        m9428a(26);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isActual() {
        return this.f22980k.isActual();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isCompanionObject() {
        return this.f22980k.isCompanionObject();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isData() {
        return this.f22980k.isData();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExpect() {
        return this.f22980k.isExpect();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExternal() {
        return this.f22980k.isExternal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isFun() {
        return this.f22980k.isFun();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isInline() {
        return this.f22980k.isInline();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public boolean isInner() {
        return this.f22980k.isInner();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isValue() {
        return this.f22980k.isValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
    public InterfaceC11770i getUnsubstitutedMemberScope(AbstractC11947g abstractC11947g) {
        if (abstractC11947g == null) {
            m9428a(13);
            throw null;
        }
        InterfaceC11770i unsubstitutedMemberScope = this.f22980k.getUnsubstitutedMemberScope(abstractC11947g);
        if (!this.f22981l.isEmpty()) {
            return new C11775n(unsubstitutedMemberScope, m9429b());
        }
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        m9428a(14);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11330e substitute(C11914c1 c11914c1) {
        if (c11914c1 != null) {
            return c11914c1.isEmpty() ? this : new C11394t(this, C11914c1.createChainedSubstitutor(c11914c1.getSubstitution(), m9429b().getSubstitution()));
        }
        m9428a(22);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11330e getOriginal() {
        InterfaceC11330e original = this.f22980k.getOriginal();
        if (original != null) {
            return original;
        }
        m9428a(20);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getMemberScope(AbstractC12018z0 abstractC12018z0) {
        if (abstractC12018z0 != null) {
            InterfaceC11770i memberScope = getMemberScope(abstractC12018z0, C11836a.getKotlinTypeRefiner(C11787e.getContainingModule(this)));
            if (memberScope != null) {
                return memberScope;
            }
            m9428a(11);
            throw null;
        }
        m9428a(10);
        throw null;
    }
}
