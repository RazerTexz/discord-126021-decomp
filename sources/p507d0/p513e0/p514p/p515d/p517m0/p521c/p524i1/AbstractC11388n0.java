package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11901k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.n0 */
/* JADX INFO: compiled from: VariableDescriptorWithInitializerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11388n0 extends AbstractC11386m0 {

    /* JADX INFO: renamed from: o */
    public final boolean f22907o;

    /* JADX INFO: renamed from: p */
    public InterfaceC11901k<AbstractC11815g<?>> f22908p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11388n0(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, AbstractC11913c0 abstractC11913c0, boolean z2, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11450m, interfaceC11344g, c11716e, abstractC11913c0, interfaceC11467u0);
        if (interfaceC11450m == null) {
            m9418a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9418a(1);
            throw null;
        }
        if (c11716e == null) {
            m9418a(2);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9418a(3);
            throw null;
        }
        this.f22907o = z2;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9418a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1
    public AbstractC11815g<?> getCompileTimeInitializer() {
        InterfaceC11901k<AbstractC11815g<?>> interfaceC11901k = this.f22908p;
        if (interfaceC11901k != null) {
            return interfaceC11901k.invoke();
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1
    public boolean isVar() {
        return this.f22907o;
    }

    public void setCompileTimeInitializer(InterfaceC11901k<AbstractC11815g<?>> interfaceC11901k) {
        if (interfaceC11901k != null) {
            this.f22908p = interfaceC11901k;
        } else {
            m9418a(4);
            throw null;
        }
    }
}
