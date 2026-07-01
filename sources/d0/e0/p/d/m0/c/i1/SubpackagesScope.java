package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageViewDescriptor;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScopeImpl;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.h0, reason: use source file name */
/* JADX INFO: compiled from: SubpackagesScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SubpackagesScope extends MemberScopeImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleDescriptor2 f3266b;
    public final FqName c;

    public SubpackagesScope(ModuleDescriptor2 moduleDescriptor2, FqName fqName) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        this.f3266b = moduleDescriptor2;
        this.c = fqName;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        if (!memberScope2.acceptsKinds(MemberScope2.a.getPACKAGES_MASK())) {
            return Collections2.emptyList();
        }
        if (this.c.isRoot() && memberScope2.getExcludes().contains(MemberScope.b.a)) {
            return Collections2.emptyList();
        }
        Collection<FqName> subPackagesOf = this.f3266b.getSubPackagesOf(this.c, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        Iterator<FqName> it = subPackagesOf.iterator();
        while (it.hasNext()) {
            Name nameShortName = it.next().shortName();
            Intrinsics3.checkNotNullExpressionValue(nameShortName, "subFqName.shortName()");
            if (function1.invoke(nameShortName).booleanValue()) {
                Intrinsics3.checkNotNullParameter(nameShortName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                PackageViewDescriptor packageViewDescriptor = null;
                if (!nameShortName.isSpecial()) {
                    ModuleDescriptor2 moduleDescriptor2 = this.f3266b;
                    FqName fqNameChild = this.c.child(nameShortName);
                    Intrinsics3.checkNotNullExpressionValue(fqNameChild, "fqName.child(name)");
                    PackageViewDescriptor packageViewDescriptor2 = moduleDescriptor2.getPackage(fqNameChild);
                    if (!packageViewDescriptor2.isEmpty()) {
                        packageViewDescriptor = packageViewDescriptor2;
                    }
                }
                collections.addIfNotNull(arrayList, packageViewDescriptor);
            }
        }
        return arrayList;
    }
}
