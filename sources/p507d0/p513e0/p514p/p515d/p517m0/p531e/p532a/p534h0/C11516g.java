package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.Pair;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11401j;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11368d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11370e0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11618x;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11901k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.g */
/* JADX INFO: compiled from: JavaPropertyDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11516g extends C11366c0 implements InterfaceC11511b {

    /* JADX INFO: renamed from: J */
    public final boolean f23270J;

    /* JADX INFO: renamed from: K */
    public final Pair<InterfaceC11318a.a<?>, ?> f23271K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11516g(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, boolean z2, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0, InterfaceC11453n0 interfaceC11453n0, InterfaceC11321b.a aVar, boolean z3, Pair<InterfaceC11318a.a<?>, ?> pair) {
        super(interfaceC11450m, interfaceC11453n0, interfaceC11344g, enumC11476z, abstractC11466u, z2, c11716e, aVar, interfaceC11467u0, false, false, false, false, false, false);
        if (interfaceC11450m == null) {
            m9459a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9459a(1);
            throw null;
        }
        if (enumC11476z == null) {
            m9459a(2);
            throw null;
        }
        if (abstractC11466u == null) {
            m9459a(3);
            throw null;
        }
        if (c11716e == null) {
            m9459a(4);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9459a(5);
            throw null;
        }
        if (aVar == null) {
            m9459a(6);
            throw null;
        }
        this.f23270J = z3;
        this.f23271K = pair;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9459a(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(str2);
        }
    }

    public static C11516g create(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, boolean z2, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0, boolean z3) {
        if (interfaceC11450m == null) {
            m9459a(7);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9459a(8);
            throw null;
        }
        if (enumC11476z == null) {
            m9459a(9);
            throw null;
        }
        if (abstractC11466u == null) {
            m9459a(10);
            throw null;
        }
        if (c11716e == null) {
            m9459a(11);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return new C11516g(interfaceC11450m, interfaceC11344g, enumC11476z, abstractC11466u, z2, c11716e, interfaceC11467u0, null, InterfaceC11321b.a.DECLARATION, z3, null);
        }
        m9459a(12);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0
    /* JADX INFO: renamed from: b */
    public C11366c0 mo9394b(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11453n0 interfaceC11453n0, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11450m == null) {
            m9459a(13);
            throw null;
        }
        if (enumC11476z == null) {
            m9459a(14);
            throw null;
        }
        if (abstractC11466u == null) {
            m9459a(15);
            throw null;
        }
        if (aVar == null) {
            m9459a(16);
            throw null;
        }
        if (c11716e != null) {
            return new C11516g(interfaceC11450m, getAnnotations(), enumC11476z, abstractC11466u, isVar(), c11716e, interfaceC11467u0, interfaceC11453n0, aVar, this.f23270J, this.f23271K);
        }
        m9459a(17);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11511b
    public InterfaceC11511b enhance(AbstractC11913c0 abstractC11913c0, List<C11521l> list, AbstractC11913c0 abstractC11913c1, Pair<InterfaceC11318a.a<?>, ?> pair) {
        C11368d0 c11368d0;
        C11370e0 c11370e0;
        if (list == null) {
            m9459a(19);
            throw null;
        }
        if (abstractC11913c1 == null) {
            m9459a(20);
            throw null;
        }
        InterfaceC11453n0 original = getOriginal() == this ? null : getOriginal();
        C11516g c11516g = new C11516g(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), original, getKind(), this.f23270J, pair);
        C11368d0 getter = getGetter();
        if (getter != null) {
            c11368d0 = c11368d0;
            C11368d0 c11368d1 = new C11368d0(c11516g, getter.getAnnotations(), getter.getModality(), getter.getVisibility(), getter.isDefault(), getter.isExternal(), getter.isInline(), getKind(), original == null ? null : original.getGetter(), getter.getSource());
            c11368d0.setInitialSignatureDescriptor(getter.getInitialSignatureDescriptor());
            c11368d0.initialize(abstractC11913c1);
        } else {
            c11368d0 = null;
        }
        InterfaceC11457p0 setter = getSetter();
        if (setter != null) {
            C11370e0 c11370e1 = new C11370e0(c11516g, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), getKind(), original == null ? null : original.getSetter(), setter.getSource());
            c11370e1.setInitialSignatureDescriptor(c11370e1.getInitialSignatureDescriptor());
            c11370e1.initialize(setter.getValueParameters().get(0));
            c11370e0 = c11370e1;
        } else {
            c11370e0 = null;
        }
        c11516g.initialize(c11368d0, c11370e0, getBackingField(), getDelegateField());
        c11516g.setSetterProjectedOut(isSetterProjectedOut());
        InterfaceC11901k<AbstractC11815g<?>> interfaceC11901k = this.f22908p;
        if (interfaceC11901k != null) {
            c11516g.setCompileTimeInitializer(interfaceC11901k);
        }
        c11516g.setOverriddenDescriptors(getOverriddenDescriptors());
        c11516g.setType(abstractC11913c1, getTypeParameters(), getDispatchReceiverParameter(), abstractC11913c0 == null ? null : C11786d.createExtensionReceiverParameterForCallable(this, abstractC11913c0, InterfaceC11344g.f22735f.getEMPTY()));
        return c11516g;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11386m0, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1
    public boolean isConst() {
        AbstractC11913c0 type = getType();
        return this.f23270J && C11401j.canBeUsedForConstVal(type) && (!C11618x.hasEnhancedNullability(type) || AbstractC11288h.isString(type));
    }
}
