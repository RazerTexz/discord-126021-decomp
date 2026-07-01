package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.b, reason: use source file name */
/* JADX INFO: compiled from: EmptyContainerForLocal.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptyContainerForLocal extends KDeclarationContainerImpl {
    public static final EmptyContainerForLocal m = new EmptyContainerForLocal();

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        j();
        throw null;
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        j();
        throw null;
    }

    @Override // d0.z.d.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        j();
        throw null;
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        return null;
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        j();
        throw null;
    }

    public final Void j() {
        throw new KotlinReflectionInternalError("Introspecting local functions, lambdas, anonymous functions, local variables and typealiases is not yet fully supported in Kotlin reflection");
    }
}
