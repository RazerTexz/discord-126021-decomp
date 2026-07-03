package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11930i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.i */
/* JADX INFO: compiled from: ClassDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11377i extends AbstractC11375h {

    /* JADX INFO: renamed from: r */
    public final EnumC11476z f22880r;

    /* JADX INFO: renamed from: s */
    public final EnumC11333f f22881s;

    /* JADX INFO: renamed from: t */
    public final InterfaceC12008u0 f22882t;

    /* JADX INFO: renamed from: u */
    public InterfaceC11770i f22883u;

    /* JADX INFO: renamed from: v */
    public Set<InterfaceC11327d> f22884v;

    /* JADX INFO: renamed from: w */
    public InterfaceC11327d f22885w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11377i(InterfaceC11450m interfaceC11450m, C11716e c11716e, EnumC11476z enumC11476z, EnumC11333f enumC11333f, Collection<AbstractC11913c0> collection, InterfaceC11467u0 interfaceC11467u0, boolean z2, InterfaceC11905o interfaceC11905o) {
        super(interfaceC11905o, interfaceC11450m, c11716e, interfaceC11467u0, z2);
        if (interfaceC11450m == null) {
            m9411a(0);
            throw null;
        }
        if (c11716e == null) {
            m9411a(1);
            throw null;
        }
        if (enumC11476z == null) {
            m9411a(2);
            throw null;
        }
        if (enumC11333f == null) {
            m9411a(3);
            throw null;
        }
        if (collection == null) {
            m9411a(4);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9411a(5);
            throw null;
        }
        if (interfaceC11905o == null) {
            m9411a(6);
            throw null;
        }
        this.f22880r = enumC11476z;
        this.f22881s = enumC11333f;
        this.f22882t = new C11930i(this, Collections.emptyList(), collection, interfaceC11905o);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9411a(int i) {
        String str;
        int i2;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
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
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        InterfaceC11344g empty = InterfaceC11344g.f22735f.getEMPTY();
        if (empty != null) {
            return empty;
        }
        m9411a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11330e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public Collection<InterfaceC11327d> getConstructors() {
        Set<InterfaceC11327d> set = this.f22884v;
        if (set != null) {
            return set;
        }
        m9411a(11);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public List<InterfaceC11477z0> getDeclaredTypeParameters() {
        List<InterfaceC11477z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9411a(18);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public EnumC11333f getKind() {
        EnumC11333f enumC11333f = this.f22881s;
        if (enumC11333f != null) {
            return enumC11333f;
        }
        m9411a(15);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public EnumC11476z getModality() {
        EnumC11476z enumC11476z = this.f22880r;
        if (enumC11476z != null) {
            return enumC11476z;
        }
        m9411a(16);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public Collection<InterfaceC11330e> getSealedSubclasses() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9411a(19);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getStaticScope() {
        InterfaceC11770i.b bVar = InterfaceC11770i.b.f24373b;
        if (bVar != null) {
            return bVar;
        }
        m9411a(14);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public InterfaceC12008u0 getTypeConstructor() {
        InterfaceC12008u0 interfaceC12008u0 = this.f22882t;
        if (interfaceC12008u0 != null) {
            return interfaceC12008u0;
        }
        m9411a(10);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
    public InterfaceC11770i getUnsubstitutedMemberScope(AbstractC11947g abstractC11947g) {
        if (abstractC11947g == null) {
            m9411a(12);
            throw null;
        }
        InterfaceC11770i interfaceC11770i = this.f22883u;
        if (interfaceC11770i != null) {
            return interfaceC11770i;
        }
        m9411a(13);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11327d getUnsubstitutedPrimaryConstructor() {
        return this.f22885w;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        AbstractC11466u abstractC11466u = C11464t.f23087e;
        if (abstractC11466u != null) {
            return abstractC11466u;
        }
        m9411a(17);
        throw null;
    }

    public final void initialize(InterfaceC11770i interfaceC11770i, Set<InterfaceC11327d> set, InterfaceC11327d interfaceC11327d) {
        if (interfaceC11770i == null) {
            m9411a(7);
            throw null;
        }
        if (set == null) {
            m9411a(8);
            throw null;
        }
        this.f22883u = interfaceC11770i;
        this.f22884v = set;
        this.f22885w = interfaceC11327d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isData() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isFun() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public boolean isInner() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("class ");
        sbM833U.append(getName());
        return sbM833U.toString();
    }
}
