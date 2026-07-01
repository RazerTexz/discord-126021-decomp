package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.storage6;
import d0.e0.p.d.m0.n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.n0, reason: use source file name */
/* JADX INFO: compiled from: VariableDescriptorWithInitializerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    public final boolean o;
    public storage6<d0.e0.p.d.m0.k.v.g<?>> p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, SourceElement sourceElement) {
        super(declarationDescriptor, annotations4, name, kotlinType, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations4 == null) {
            a(1);
            throw null;
        }
        if (name == null) {
            a(2);
            throw null;
        }
        if (sourceElement == null) {
            a(3);
            throw null;
        }
        this.o = z2;
    }

    public static /* synthetic */ void a(int i) {
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

    @Override // d0.e0.p.d.m0.c.VariableDescriptor
    public d0.e0.p.d.m0.k.v.g<?> getCompileTimeInitializer() {
        storage6<d0.e0.p.d.m0.k.v.g<?>> storage6Var = this.p;
        if (storage6Var != null) {
            return storage6Var.invoke();
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.VariableDescriptor
    public boolean isVar() {
        return this.o;
    }

    public void setCompileTimeInitializer(storage6<d0.e0.p.d.m0.k.v.g<?>> storage6Var) {
        if (storage6Var != null) {
            this.p = storage6Var;
        } else {
            a(4);
            throw null;
        }
    }
}
