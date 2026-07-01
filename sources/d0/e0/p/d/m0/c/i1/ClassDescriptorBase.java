package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.StorageManager;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.h, reason: use source file name */
/* JADX INFO: compiled from: ClassDescriptorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ClassDescriptorBase extends AbstractClassDescriptor {
    public final DeclarationDescriptor o;
    public final SourceElement p;
    public final boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassDescriptorBase(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, SourceElement sourceElement, boolean z2) {
        super(storageManager, name);
        if (storageManager == null) {
            a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
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
        this.o = declarationDescriptor;
        this.p = sourceElement;
        this.q = z2;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.o;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = this.p;
        if (sourceElement != null) {
            return sourceElement;
        }
        a(5);
        throw null;
    }

    public boolean isExternal() {
        return this.q;
    }
}
