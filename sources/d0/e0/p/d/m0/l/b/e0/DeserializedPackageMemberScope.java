package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.d.utils;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.w;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.l.b.context6;
import d0.t.MutableCollections;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.i, reason: use source file name */
/* JADX INFO: compiled from: DeserializedPackageMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    public final PackageFragmentDescriptor g;
    public final FqName h;

    public DeserializedPackageMemberScope(PackageFragmentDescriptor packageFragmentDescriptor, d0.e0.p.d.m0.f.l lVar, NameResolver nameResolver, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2, context5 context5Var, Function0<? extends Collection<Name>> function0) {
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "packageDescriptor");
        Intrinsics3.checkNotNullParameter(lVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        Intrinsics3.checkNotNullParameter(function0, "classNames");
        t typeTable = lVar.getTypeTable();
        Intrinsics3.checkNotNullExpressionValue(typeTable, "proto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirement2.a aVar = VersionRequirement2.a;
        w versionRequirementTable = lVar.getVersionRequirementTable();
        Intrinsics3.checkNotNullExpressionValue(versionRequirementTable, "proto.versionRequirementTable");
        context6 context6VarCreateContext = context5Var.createContext(packageFragmentDescriptor, nameResolver, typeTable2, aVar.create(versionRequirementTable), binaryVersion, deserializedContainerSource2);
        List<d0.e0.p.d.m0.f.i> functionList = lVar.getFunctionList();
        Intrinsics3.checkNotNullExpressionValue(functionList, "proto.functionList");
        List<d0.e0.p.d.m0.f.n> propertyList = lVar.getPropertyList();
        Intrinsics3.checkNotNullExpressionValue(propertyList, "proto.propertyList");
        List<r> typeAliasList = lVar.getTypeAliasList();
        Intrinsics3.checkNotNullExpressionValue(typeAliasList, "proto.typeAliasList");
        super(context6VarCreateContext, functionList, propertyList, typeAliasList, function0);
        this.g = packageFragmentDescriptor;
        this.h = packageFragmentDescriptor.getFqName();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
    public void a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
    public ClassId e(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ClassId(this.h, name);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
    public Set<Name> f() {
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
    public Set<Name> g() {
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        return super.getContributedClassifier(name, lookupLocation2);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(MemberScope2 memberScope2, Function1 function1) {
        return getContributedDescriptors(memberScope2, (Function1<? super Name, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
    public Set<Name> h() {
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
    public boolean i(Name name) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (getClassNames$deserialization().contains(name)) {
            return true;
        }
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = this.c.getComponents().getFictitiousClassDescriptorFactories();
        if ((fictitiousClassDescriptorFactories instanceof Collection) && ((Collection) fictitiousClassDescriptorFactories).isEmpty()) {
            z2 = false;
        } else {
            Iterator<ClassDescriptorFactory> it = fictitiousClassDescriptorFactories.iterator();
            while (it.hasNext()) {
                if (it.next().shouldCreateClass(this.h, name)) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public void recordLookup(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        utils.record(this.c.getComponents().getLookupTracker(), lookupLocation2, this.g, name);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public List<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        Collection<DeclarationDescriptor> collectionB = b(memberScope2, function1, LookupLocation3.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = this.c.getComponents().getFictitiousClassDescriptorFactories();
        ArrayList arrayList = new ArrayList();
        Iterator<ClassDescriptorFactory> it = fictitiousClassDescriptorFactories.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList, it.next().getAllContributedClassesIfPossible(this.h));
        }
        return _Collections.plus((Collection) collectionB, (Iterable) arrayList);
    }
}
