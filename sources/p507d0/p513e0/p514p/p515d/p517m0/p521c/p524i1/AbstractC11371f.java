package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11769h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11776o;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f */
/* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11371f extends AbstractC11383l implements InterfaceC11477z0 {

    /* JADX INFO: renamed from: n */
    public final EnumC11935j1 f22857n;

    /* JADX INFO: renamed from: o */
    public final boolean f22858o;

    /* JADX INFO: renamed from: p */
    public final int f22859p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC11900j<InterfaceC12008u0> f22860q;

    /* JADX INFO: renamed from: r */
    public final InterfaceC11900j<AbstractC11934j0> f22861r;

    /* JADX INFO: renamed from: s */
    public final InterfaceC11905o f22862s;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$a */
    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    public class a implements Function0<InterfaceC12008u0> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ InterfaceC11905o f22863j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ InterfaceC11473x0 f22864k;

        public a(InterfaceC11905o interfaceC11905o, InterfaceC11473x0 interfaceC11473x0) {
            this.f22863j = interfaceC11905o;
            this.f22864k = interfaceC11473x0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public InterfaceC12008u0 invoke() {
            return new c(AbstractC11371f.this, this.f22863j, this.f22864k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$b */
    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    public class b implements Function0<AbstractC11934j0> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C11716e f22866j;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$b$a */
        /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
        public class a implements Function0<InterfaceC11770i> {
            public a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public InterfaceC11770i invoke() {
                StringBuilder sbM833U = C1643a.m833U("Scope for type parameter ");
                sbM833U.append(b.this.f22866j.asString());
                return C11776o.create(sbM833U.toString(), AbstractC11371f.this.getUpperBounds());
            }
        }

        public b(C11716e c11716e) {
            this.f22866j = c11716e;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public AbstractC11934j0 invoke() {
            return C11916d0.simpleTypeWithNonTrivialMemberScope(InterfaceC11344g.f22735f.getEMPTY(), AbstractC11371f.this.getTypeConstructor(), Collections.emptyList(), false, new C11769h(new a()));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$c */
    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    public class c extends AbstractC11924g {

        /* JADX INFO: renamed from: b */
        public final InterfaceC11473x0 f22869b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ AbstractC11371f f22870c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC11371f abstractC11371f, InterfaceC11905o interfaceC11905o, InterfaceC11473x0 interfaceC11473x0) {
            super(interfaceC11905o);
            if (interfaceC11905o == null) {
                m9402g(0);
                throw null;
            }
            this.f22870c = abstractC11371f;
            this.f22869b = interfaceC11473x0;
        }

        /* JADX INFO: renamed from: g */
        public static /* synthetic */ void m9402g(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
        /* JADX INFO: renamed from: a */
        public Collection<AbstractC11913c0> mo9370a() {
            List<AbstractC11913c0> listMo9401d = this.f22870c.mo9401d();
            if (listMo9401d != null) {
                return listMo9401d;
            }
            m9402g(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
        /* JADX INFO: renamed from: b */
        public AbstractC11913c0 mo9403b() {
            return C12005t.createErrorType("Cyclic upper bounds");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
        /* JADX INFO: renamed from: d */
        public InterfaceC11473x0 mo9371d() {
            InterfaceC11473x0 interfaceC11473x0 = this.f22869b;
            if (interfaceC11473x0 != null) {
                return interfaceC11473x0;
            }
            m9402g(5);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
        /* JADX INFO: renamed from: e */
        public List<AbstractC11913c0> mo9404e(List<AbstractC11913c0> list) {
            if (list == null) {
                m9402g(7);
                throw null;
            }
            List<AbstractC11913c0> listMo9399b = this.f22870c.mo9399b(list);
            if (listMo9399b != null) {
                return listMo9399b;
            }
            m9402g(8);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
        /* JADX INFO: renamed from: f */
        public void mo9405f(AbstractC11913c0 abstractC11913c0) {
            if (abstractC11913c0 != null) {
                this.f22870c.mo9400c(abstractC11913c0);
            } else {
                m9402g(6);
                throw null;
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public AbstractC11288h getBuiltIns() {
            AbstractC11288h builtIns = C11836a.getBuiltIns(this.f22870c);
            if (builtIns != null) {
                return builtIns;
            }
            m9402g(4);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g, p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC11352h getDeclarationDescriptor() {
            AbstractC11371f abstractC11371f = this.f22870c;
            if (abstractC11371f != null) {
                return abstractC11371f;
            }
            m9402g(3);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public List<InterfaceC11477z0> getParameters() {
            List<InterfaceC11477z0> listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m9402g(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return this.f22870c.getName().toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11371f(InterfaceC11905o interfaceC11905o, InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, EnumC11935j1 enumC11935j1, boolean z2, int i, InterfaceC11467u0 interfaceC11467u0, InterfaceC11473x0 interfaceC11473x0) {
        super(interfaceC11450m, interfaceC11344g, c11716e, interfaceC11467u0);
        if (interfaceC11905o == null) {
            m9398a(0);
            throw null;
        }
        if (interfaceC11450m == null) {
            m9398a(1);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9398a(2);
            throw null;
        }
        if (c11716e == null) {
            m9398a(3);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9398a(4);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9398a(5);
            throw null;
        }
        if (interfaceC11473x0 == null) {
            m9398a(6);
            throw null;
        }
        this.f22857n = enumC11935j1;
        this.f22858o = z2;
        this.f22859p = i;
        this.f22860q = interfaceC11905o.createLazyValue(new a(interfaceC11905o, interfaceC11473x0));
        this.f22861r = interfaceC11905o.createLazyValue(new b(c11716e));
        this.f22862s = interfaceC11905o;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9398a(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return interfaceC11454o.visitTypeParameterDescriptor(this, d);
    }

    /* JADX INFO: renamed from: b */
    public List<AbstractC11913c0> mo9399b(List<AbstractC11913c0> list) {
        if (list == null) {
            m9398a(12);
            throw null;
        }
        if (list != null) {
            return list;
        }
        m9398a(13);
        throw null;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo9400c(AbstractC11913c0 abstractC11913c0);

    /* JADX INFO: renamed from: d */
    public abstract List<AbstractC11913c0> mo9401d();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public AbstractC11934j0 getDefaultType() {
        AbstractC11934j0 abstractC11934j0Invoke = this.f22861r.invoke();
        if (abstractC11934j0Invoke != null) {
            return abstractC11934j0Invoke;
        }
        m9398a(10);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public int getIndex() {
        return this.f22859p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public InterfaceC11905o getStorageManager() {
        InterfaceC11905o interfaceC11905o = this.f22862s;
        if (interfaceC11905o != null) {
            return interfaceC11905o;
        }
        m9398a(14);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public final InterfaceC12008u0 getTypeConstructor() {
        InterfaceC12008u0 interfaceC12008u0Invoke = this.f22860q.invoke();
        if (interfaceC12008u0Invoke != null) {
            return interfaceC12008u0Invoke;
        }
        m9398a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public List<AbstractC11913c0> getUpperBounds() {
        List<AbstractC11913c0> supertypes = ((c) getTypeConstructor()).getSupertypes();
        if (supertypes != null) {
            return supertypes;
        }
        m9398a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public EnumC11935j1 getVariance() {
        EnumC11935j1 enumC11935j1 = this.f22857n;
        if (enumC11935j1 != null) {
            return enumC11935j1;
        }
        m9398a(7);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public boolean isReified() {
        return this.f22858o;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11477z0 getOriginal() {
        InterfaceC11477z0 interfaceC11477z0 = (InterfaceC11477z0) super.getOriginal();
        if (interfaceC11477z0 != null) {
            return interfaceC11477z0;
        }
        m9398a(11);
        throw null;
    }
}
