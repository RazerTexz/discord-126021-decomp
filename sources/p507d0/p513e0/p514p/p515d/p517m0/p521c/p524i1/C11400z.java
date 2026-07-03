package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.z */
/* JADX INFO: compiled from: MutableClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11400z extends AbstractC11375h {

    /* JADX INFO: renamed from: r */
    public final EnumC11333f f22998r;

    /* JADX INFO: renamed from: s */
    public final boolean f22999s;

    /* JADX INFO: renamed from: t */
    public EnumC11476z f23000t;

    /* JADX INFO: renamed from: u */
    public AbstractC11466u f23001u;

    /* JADX INFO: renamed from: v */
    public InterfaceC12008u0 f23002v;

    /* JADX INFO: renamed from: w */
    public List<InterfaceC11477z0> f23003w;

    /* JADX INFO: renamed from: x */
    public final Collection<AbstractC11913c0> f23004x;

    /* JADX INFO: renamed from: y */
    public final InterfaceC11905o f23005y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11400z(InterfaceC11450m interfaceC11450m, EnumC11333f enumC11333f, boolean z2, boolean z3, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0, InterfaceC11905o interfaceC11905o) {
        super(interfaceC11905o, interfaceC11450m, c11716e, interfaceC11467u0, z3);
        if (interfaceC11450m == null) {
            m9431a(0);
            throw null;
        }
        if (enumC11333f == null) {
            m9431a(1);
            throw null;
        }
        if (c11716e == null) {
            m9431a(2);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9431a(3);
            throw null;
        }
        if (interfaceC11905o == null) {
            m9431a(4);
            throw null;
        }
        this.f23004x = new ArrayList();
        this.f23005y = interfaceC11905o;
        this.f22998r = enumC11333f;
        this.f22999s = z2;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9431a(int i) {
        String str;
        int i2;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public void createTypeConstructor() {
        this.f23002v = new C11930i(this, this.f23003w, this.f23004x, this.f23005y);
        Iterator<InterfaceC11327d> it = getConstructors().iterator();
        while (it.hasNext()) {
            ((C11373g) it.next()).setReturnType(getDefaultType());
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        InterfaceC11344g empty = InterfaceC11344g.f22735f.getEMPTY();
        if (empty != null) {
            return empty;
        }
        m9431a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11330e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public List<InterfaceC11477z0> getDeclaredTypeParameters() {
        List<InterfaceC11477z0> list = this.f23003w;
        if (list != null) {
            return list;
        }
        m9431a(15);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public EnumC11333f getKind() {
        EnumC11333f enumC11333f = this.f22998r;
        if (enumC11333f != null) {
            return enumC11333f;
        }
        m9431a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public EnumC11476z getModality() {
        EnumC11476z enumC11476z = this.f23000t;
        if (enumC11476z != null) {
            return enumC11476z;
        }
        m9431a(7);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public Collection<InterfaceC11330e> getSealedSubclasses() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9431a(19);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i getStaticScope() {
        InterfaceC11770i.b bVar = InterfaceC11770i.b.f24373b;
        if (bVar != null) {
            return bVar;
        }
        m9431a(18);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public InterfaceC12008u0 getTypeConstructor() {
        InterfaceC12008u0 interfaceC12008u0 = this.f23002v;
        if (interfaceC12008u0 != null) {
            return interfaceC12008u0;
        }
        m9431a(11);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
    public InterfaceC11770i getUnsubstitutedMemberScope(AbstractC11947g abstractC11947g) {
        if (abstractC11947g == null) {
            m9431a(16);
            throw null;
        }
        InterfaceC11770i.b bVar = InterfaceC11770i.b.f24373b;
        if (bVar != null) {
            return bVar;
        }
        m9431a(17);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11327d getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        AbstractC11466u abstractC11466u = this.f23001u;
        if (abstractC11466u != null) {
            return abstractC11466u;
        }
        m9431a(10);
        throw null;
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
        return this.f22999s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isValue() {
        return false;
    }

    public void setModality(EnumC11476z enumC11476z) {
        if (enumC11476z != null) {
            this.f23000t = enumC11476z;
        } else {
            m9431a(6);
            throw null;
        }
    }

    public void setTypeParameterDescriptors(List<InterfaceC11477z0> list) {
        if (list == null) {
            m9431a(14);
            throw null;
        }
        if (this.f23003w == null) {
            this.f23003w = new ArrayList(list);
        } else {
            StringBuilder sbM833U = C1643a.m833U("Type parameters are already set for ");
            sbM833U.append(getName());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    public void setVisibility(AbstractC11466u abstractC11466u) {
        if (abstractC11466u != null) {
            this.f23001u = abstractC11466u;
        } else {
            m9431a(9);
            throw null;
        }
    }

    public String toString() {
        return AbstractC11381k.toString(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public Set<InterfaceC11327d> getConstructors() {
        Set<InterfaceC11327d> setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        m9431a(13);
        throw null;
    }
}
