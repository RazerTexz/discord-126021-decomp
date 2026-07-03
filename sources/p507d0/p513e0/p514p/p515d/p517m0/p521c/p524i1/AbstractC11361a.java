package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11768g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11775n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a */
/* JADX INFO: compiled from: AbstractClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11361a extends AbstractC11395u {

    /* JADX INFO: renamed from: k */
    public final C11716e f22801k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC11900j<AbstractC11934j0> f22802l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC11900j<InterfaceC11770i> f22803m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC11900j<InterfaceC11459q0> f22804n;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$a */
    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    public class a implements Function0<AbstractC11934j0> {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractClassDescriptor.java */
        public class C13307a implements Function1<AbstractC11947g, AbstractC11934j0> {
            public C13307a() {
            }

            @Override // kotlin.jvm.functions.Function1
            public AbstractC11934j0 invoke(AbstractC11947g abstractC11947g) {
                InterfaceC11352h interfaceC11352hRefineDescriptor = abstractC11947g.refineDescriptor(AbstractC11361a.this);
                if (interfaceC11352hRefineDescriptor == null) {
                    return AbstractC11361a.this.f22802l.invoke();
                }
                if (interfaceC11352hRefineDescriptor instanceof InterfaceC11475y0) {
                    return C11916d0.computeExpandedType((InterfaceC11475y0) interfaceC11352hRefineDescriptor, C11920e1.getDefaultTypeProjections(interfaceC11352hRefineDescriptor.getTypeConstructor().getParameters()));
                }
                return interfaceC11352hRefineDescriptor instanceof AbstractC11395u ? C11920e1.makeUnsubstitutedType(interfaceC11352hRefineDescriptor.getTypeConstructor().refine(abstractC11947g), ((AbstractC11395u) interfaceC11352hRefineDescriptor).getUnsubstitutedMemberScope(abstractC11947g), this) : interfaceC11352hRefineDescriptor.getDefaultType();
            }
        }

        public a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public AbstractC11934j0 invoke() {
            AbstractC11361a abstractC11361a = AbstractC11361a.this;
            return C11920e1.makeUnsubstitutedType(abstractC11361a, abstractC11361a.getUnsubstitutedMemberScope(), new C13307a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$b */
    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    public class b implements Function0<InterfaceC11770i> {
        public b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public InterfaceC11770i invoke() {
            return new C11768g(AbstractC11361a.this.getUnsubstitutedMemberScope());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$c */
    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    public class c implements Function0<InterfaceC11459q0> {
        public c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public InterfaceC11459q0 invoke() {
            return new C11392r(AbstractC11361a.this);
        }
    }

    public AbstractC11361a(InterfaceC11905o interfaceC11905o, C11716e c11716e) {
        if (interfaceC11905o == null) {
            m9387a(0);
            throw null;
        }
        if (c11716e == null) {
            m9387a(1);
            throw null;
        }
        this.f22801k = c11716e;
        this.f22802l = interfaceC11905o.createLazyValue(new a());
        this.f22803m = interfaceC11905o.createLazyValue(new b());
        this.f22804n = interfaceC11905o.createLazyValue(new c());
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9387a(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 8 || i == 11 || i == 13 || i == 15) {
            objArr[1] = "getMemberScope";
        } else if (i == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 18) {
            objArr[1] = "substitute";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 8 && i != 11 && i != 13 && i != 15 && i != 16 && i != 18 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return interfaceC11454o.visitClassDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public AbstractC11934j0 getDefaultType() {
        AbstractC11934j0 abstractC11934j0Invoke = this.f22802l.invoke();
        if (abstractC11934j0Invoke != null) {
            return abstractC11934j0Invoke;
        }
        m9387a(19);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
    public InterfaceC11770i getMemberScope(AbstractC12018z0 abstractC12018z0, AbstractC11947g abstractC11947g) {
        if (abstractC12018z0 == null) {
            m9387a(9);
            throw null;
        }
        if (abstractC11947g == null) {
            m9387a(10);
            throw null;
        }
        if (!abstractC12018z0.isEmpty()) {
            return new C11775n(getUnsubstitutedMemberScope(abstractC11947g), C11914c1.create(abstractC12018z0));
        }
        InterfaceC11770i unsubstitutedMemberScope = getUnsubstitutedMemberScope(abstractC11947g);
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        m9387a(11);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public C11716e getName() {
        C11716e c11716e = this.f22801k;
        if (c11716e != null) {
            return c11716e;
        }
        m9387a(2);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11330e getOriginal() {
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11459q0 getThisAsReceiverParameter() {
        InterfaceC11459q0 interfaceC11459q0Invoke = this.f22804n.invoke();
        if (interfaceC11459q0Invoke != null) {
            return interfaceC11459q0Invoke;
        }
        m9387a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getUnsubstitutedInnerClassesScope() {
        InterfaceC11770i interfaceC11770iInvoke = this.f22803m.invoke();
        if (interfaceC11770iInvoke != null) {
            return interfaceC11770iInvoke;
        }
        m9387a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getUnsubstitutedMemberScope() {
        InterfaceC11770i unsubstitutedMemberScope = getUnsubstitutedMemberScope(C11836a.getKotlinTypeRefiner(C11787e.getContainingModule(this)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        m9387a(16);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11330e substitute(C11914c1 c11914c1) {
        if (c11914c1 != null) {
            return c11914c1.isEmpty() ? this : new C11394t(this, c11914c1);
        }
        m9387a(17);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getMemberScope(AbstractC12018z0 abstractC12018z0) {
        if (abstractC12018z0 != null) {
            InterfaceC11770i memberScope = getMemberScope(abstractC12018z0, C11836a.getKotlinTypeRefiner(C11787e.getContainingModule(this)));
            if (memberScope != null) {
                return memberScope;
            }
            m9387a(15);
            throw null;
        }
        m9387a(14);
        throw null;
    }
}
