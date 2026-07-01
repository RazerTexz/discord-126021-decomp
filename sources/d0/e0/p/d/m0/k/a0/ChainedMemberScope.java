package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.o.n.scopeUtils;
import d0.e0.p.d.m0.p.SmartList;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.t.Sets5;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.b, reason: use source file name */
/* JADX INFO: compiled from: ChainedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ChainedMemberScope implements MemberScope3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3451b = new a(null);
    public final String c;
    public final MemberScope3[] d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.b$a */
    /* JADX INFO: compiled from: ChainedMemberScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final MemberScope3 create(String str, Iterable<? extends MemberScope3> iterable) {
            Intrinsics3.checkNotNullParameter(str, "debugName");
            Intrinsics3.checkNotNullParameter(iterable, "scopes");
            SmartList smartList = new SmartList();
            for (MemberScope3 memberScope3 : iterable) {
                if (memberScope3 != MemberScope3.b.f3461b) {
                    if (memberScope3 instanceof ChainedMemberScope) {
                        MutableCollections.addAll(smartList, ((ChainedMemberScope) memberScope3).d);
                    } else {
                        smartList.add(memberScope3);
                    }
                }
            }
            return createOrSingle$descriptors(str, smartList);
        }

        public final MemberScope3 createOrSingle$descriptors(String str, List<? extends MemberScope3> list) {
            Intrinsics3.checkNotNullParameter(str, "debugName");
            Intrinsics3.checkNotNullParameter(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return MemberScope3.b.f3461b;
            }
            if (size == 1) {
                return list.get(0);
            }
            Object[] array = list.toArray(new MemberScope3[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new ChainedMemberScope(str, (MemberScope3[]) array, null);
        }
    }

    public ChainedMemberScope(String str, MemberScope3[] memberScope3Arr, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = str;
        this.d = memberScope3Arr;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return MemberScope4.flatMapClassifierNamesOrNull(_Arrays.asIterable(this.d));
    }

    @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        MemberScope3[] memberScope3Arr = this.d;
        int length = memberScope3Arr.length;
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            ClassifierDescriptor contributedClassifier = memberScope3.getContributedClassifier(name, lookupLocation2);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        MemberScope3[] memberScope3Arr = this.d;
        int length = memberScope3Arr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScope3Arr[0].getContributedDescriptors(memberScope2, function1);
        }
        Collection<DeclarationDescriptor> collectionConcat = null;
        int length2 = memberScope3Arr.length;
        while (i < length2) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedDescriptors(memberScope2, function1));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        MemberScope3[] memberScope3Arr = this.d;
        int length = memberScope3Arr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScope3Arr[0].getContributedFunctions(name, lookupLocation2);
        }
        Collection<SimpleFunctionDescriptor> collectionConcat = null;
        int length2 = memberScope3Arr.length;
        while (i < length2) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedFunctions(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        MemberScope3[] memberScope3Arr = this.d;
        int length = memberScope3Arr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScope3Arr[0].getContributedVariables(name, lookupLocation2);
        }
        Collection<PropertyDescriptor> collectionConcat = null;
        int length2 = memberScope3Arr.length;
        while (i < length2) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedVariables(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getFunctionNames() {
        MemberScope3[] memberScope3Arr = this.d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3Arr) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getVariableNames() {
        MemberScope3[] memberScope3Arr = this.d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3Arr) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.c;
    }
}
