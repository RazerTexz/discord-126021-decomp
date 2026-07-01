package d0.e0.p.d.m0.e.a.h0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.a$a;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.i1.c0;
import d0.e0.p.d.m0.c.i1.d0;
import d0.e0.p.d.m0.c.i1.e0;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.e.a.l0.x;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: JavaPropertyDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends c0 implements b {
    public final boolean J;
    public final Pair<a$a<?>, ?> K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(m mVar, d0.e0.p.d.m0.c.g1.g gVar, z zVar, u uVar, boolean z2, d0.e0.p.d.m0.g.e eVar, u0 u0Var, n0 n0Var, b$a b_a, boolean z3, Pair<a$a<?>, ?> pair) {
        super(mVar, n0Var, gVar, zVar, uVar, z2, eVar, b_a, u0Var, false, false, false, false, false, false);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (zVar == null) {
            a(2);
            throw null;
        }
        if (uVar == null) {
            a(3);
            throw null;
        }
        if (eVar == null) {
            a(4);
            throw null;
        }
        if (u0Var == null) {
            a(5);
            throw null;
        }
        if (b_a == null) {
            a(6);
            throw null;
        }
        this.J = z3;
        this.K = pair;
    }

    public static /* synthetic */ void a(int i) {
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

    public static g create(m mVar, d0.e0.p.d.m0.c.g1.g gVar, z zVar, u uVar, boolean z2, d0.e0.p.d.m0.g.e eVar, u0 u0Var, boolean z3) {
        if (mVar == null) {
            a(7);
            throw null;
        }
        if (gVar == null) {
            a(8);
            throw null;
        }
        if (zVar == null) {
            a(9);
            throw null;
        }
        if (uVar == null) {
            a(10);
            throw null;
        }
        if (eVar == null) {
            a(11);
            throw null;
        }
        if (u0Var != null) {
            return new g(mVar, gVar, zVar, uVar, z2, eVar, u0Var, null, b$a.DECLARATION, z3, null);
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.c0
    public c0 b(m mVar, z zVar, u uVar, n0 n0Var, b$a b_a, d0.e0.p.d.m0.g.e eVar, u0 u0Var) {
        if (mVar == null) {
            a(13);
            throw null;
        }
        if (zVar == null) {
            a(14);
            throw null;
        }
        if (uVar == null) {
            a(15);
            throw null;
        }
        if (b_a == null) {
            a(16);
            throw null;
        }
        if (eVar != null) {
            return new g(mVar, getAnnotations(), zVar, uVar, isVar(), eVar, u0Var, n0Var, b_a, this.J, this.K);
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.b
    public b enhance(d0.e0.p.d.m0.n.c0 c0Var, List<l> list, d0.e0.p.d.m0.n.c0 c0Var2, Pair<a$a<?>, ?> pair) {
        d0 d0Var;
        e0 e0Var;
        if (list == null) {
            a(19);
            throw null;
        }
        if (c0Var2 == null) {
            a(20);
            throw null;
        }
        n0 original = getOriginal() == this ? null : getOriginal();
        g gVar = new g(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), original, getKind(), this.J, pair);
        d0 getter = getGetter();
        if (getter != null) {
            d0Var = d0Var;
            d0 d0Var2 = new d0(gVar, getter.getAnnotations(), getter.getModality(), getter.getVisibility(), getter.isDefault(), getter.isExternal(), getter.isInline(), getKind(), original == null ? null : original.getGetter(), getter.getSource());
            d0Var.setInitialSignatureDescriptor(getter.getInitialSignatureDescriptor());
            d0Var.initialize(c0Var2);
        } else {
            d0Var = null;
        }
        p0 setter = getSetter();
        if (setter != null) {
            e0 e0Var2 = new e0(gVar, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), getKind(), original == null ? null : original.getSetter(), setter.getSource());
            e0Var2.setInitialSignatureDescriptor(e0Var2.getInitialSignatureDescriptor());
            e0Var2.initialize(setter.getValueParameters().get(0));
            e0Var = e0Var2;
        } else {
            e0Var = null;
        }
        gVar.initialize(d0Var, e0Var, getBackingField(), getDelegateField());
        gVar.setSetterProjectedOut(isSetterProjectedOut());
        d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.k.v.g<?>> kVar = this.p;
        if (kVar != null) {
            gVar.setCompileTimeInitializer(kVar);
        }
        gVar.setOverriddenDescriptors(getOverriddenDescriptors());
        gVar.setType(c0Var2, getTypeParameters(), getDispatchReceiverParameter(), c0Var == null ? null : d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(this, c0Var, d0.e0.p.d.m0.c.g1.g.f.getEMPTY()));
        return gVar;
    }

    @Override // d0.e0.p.d.m0.c.i1.m0, d0.e0.p.d.m0.c.a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.c0, d0.e0.p.d.m0.c.d1
    public boolean isConst() {
        d0.e0.p.d.m0.n.c0 type = getType();
        return this.J && d0.e0.p.d.m0.c.j.canBeUsedForConstVal(type) && (!x.hasEnhancedNullability(type) || d0.e0.p.d.m0.b.h.isString(type));
    }
}
