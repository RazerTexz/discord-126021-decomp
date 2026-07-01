package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.Name;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.g, reason: use source file name */
/* JADX INFO: compiled from: InnerClassesScopeWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemberScope3 f3458b;

    public InnerClassesScopeWrapper(MemberScope3 memberScope3) {
        Intrinsics3.checkNotNullParameter(memberScope3, "workerScope");
        this.f3458b = memberScope3;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return this.f3458b.getClassifierNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ClassifierDescriptor contributedClassifier = this.f3458b.getContributedClassifier(name, lookupLocation2);
        if (contributedClassifier == null) {
            return null;
        }
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        if (contributedClassifier instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) contributedClassifier;
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(MemberScope2 memberScope2, Function1 function1) {
        return getContributedDescriptors(memberScope2, (Function1<? super Name, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getFunctionNames() {
        return this.f3458b.getFunctionNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getVariableNames() {
        return this.f3458b.getVariableNames();
    }

    public String toString() {
        return Intrinsics3.stringPlus("Classes from ", this.f3458b);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public List<ClassifierDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        MemberScope2 memberScope2RestrictedToKindsOrNull = memberScope2.restrictedToKindsOrNull(MemberScope2.a.getCLASSIFIERS_MASK());
        if (memberScope2RestrictedToKindsOrNull == null) {
            return Collections2.emptyList();
        }
        Collection<DeclarationDescriptor> contributedDescriptors = this.f3458b.getContributedDescriptors(memberScope2RestrictedToKindsOrNull, function1);
        ArrayList arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
