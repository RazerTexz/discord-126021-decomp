package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.LazyJVM;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.Substitutable;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.ResolutionScope;
import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor4;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.p.collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.n, reason: use source file name */
/* JADX INFO: compiled from: SubstitutingScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SubstitutingScope implements MemberScope3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemberScope3 f3463b;
    public final TypeSubstitutor2 c;
    public Map<DeclarationDescriptor, DeclarationDescriptor> d;
    public final Lazy e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.n$a */
    /* JADX INFO: compiled from: SubstitutingScope.kt */
    public static final class a extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends DeclarationDescriptor> invoke() {
            SubstitutingScope substitutingScope = SubstitutingScope.this;
            return substitutingScope.a(ResolutionScope.a.getContributedDescriptors$default(substitutingScope.f3463b, null, null, 3, null));
        }
    }

    public SubstitutingScope(MemberScope3 memberScope3, TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(memberScope3, "workerScope");
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "givenSubstitutor");
        this.f3463b = memberScope3;
        TypeSubstitution5 substitution = typeSubstitutor2.getSubstitution();
        Intrinsics3.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.c = CapturedTypeConstructor4.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        this.e = LazyJVM.lazy(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends DeclarationDescriptor> Collection<D> a(Collection<? extends D> collection) {
        if (this.c.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetNewLinkedHashSetWithExpectedSize = collections.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetNewLinkedHashSetWithExpectedSize.add(b((DeclarationDescriptor) it.next()));
        }
        return linkedHashSetNewLinkedHashSetWithExpectedSize;
    }

    public final <D extends DeclarationDescriptor> D b(D d) {
        if (this.c.isEmpty()) {
            return d;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.d;
        Intrinsics3.checkNotNull(map);
        DeclarationDescriptor declarationDescriptorSubstitute = map.get(d);
        if (declarationDescriptorSubstitute == null) {
            if (!(d instanceof Substitutable)) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Unknown descriptor in scope: ", d).toString());
            }
            declarationDescriptorSubstitute = ((Substitutable) d).substitute(this.c);
            if (declarationDescriptorSubstitute == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
            }
            map.put(d, declarationDescriptorSubstitute);
        }
        return (D) declarationDescriptorSubstitute;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return this.f3463b.getClassifierNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ClassifierDescriptor contributedClassifier = this.f3463b.getContributedClassifier(name, lookupLocation2);
        if (contributedClassifier == null) {
            return null;
        }
        return (ClassifierDescriptor) b(contributedClassifier);
    }

    @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.e.getValue();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return a(this.f3463b.getContributedFunctions(name, lookupLocation2));
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return a(this.f3463b.getContributedVariables(name, lookupLocation2));
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getFunctionNames() {
        return this.f3463b.getFunctionNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getVariableNames() {
        return this.f3463b.getVariableNames();
    }
}
