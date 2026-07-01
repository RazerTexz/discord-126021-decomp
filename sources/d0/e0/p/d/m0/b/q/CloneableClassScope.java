package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.GivenFunctionsMemberScope;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.a, reason: use source file name */
/* JADX INFO: compiled from: CloneableClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CloneableClassScope extends GivenFunctionsMemberScope {
    public static final a e = new a(null);
    public static final Name f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.a$a */
    /* JADX INFO: compiled from: CloneableClassScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Name getCLONE_NAME() {
            return CloneableClassScope.f;
        }
    }

    static {
        Name nameIdentifier = Name.identifier("clone");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"clone\")");
        f = nameIdentifier;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloneableClassScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        super(storageManager, classDescriptor);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingClass");
    }

    @Override // d0.e0.p.d.m0.k.a0.GivenFunctionsMemberScope
    public List<FunctionDescriptor> a() {
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplCreate = SimpleFunctionDescriptorImpl.create(this.c, Annotations4.f.getEMPTY(), e.getCLONE_NAME(), CallableMemberDescriptor.a.DECLARATION, SourceElement.a);
        simpleFunctionDescriptorImplCreate.initialize((ReceiverParameterDescriptor) null, this.c.getThisAsReceiverParameter(), Collections2.emptyList(), Collections2.emptyList(), (KotlinType) DescriptorUtils2.getBuiltIns(this.c).getAnyType(), Modality.OPEN, DescriptorVisibilities.c);
        return CollectionsJVM.listOf(simpleFunctionDescriptorImplCreate);
    }
}
