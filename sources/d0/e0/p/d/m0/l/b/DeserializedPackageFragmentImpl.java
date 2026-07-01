package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolverImpl;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2;
import d0.e0.p.d.m0.l.b.e0.DeserializedPackageMemberScope;
import d0.e0.p.d.m0.m.StorageManager;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o, reason: use source file name */
/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    public final BinaryVersion p;
    public final DeserializedContainerSource2 q;
    public final NameResolverImpl r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ProtoBasedClassDataFinder f3506s;
    public d0.e0.p.d.m0.f.m t;
    public MemberScope3 u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o$a */
    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class a extends Lambda implements Function1<ClassId, SourceElement> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final SourceElement invoke(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "it");
            DeserializedContainerSource2 deserializedContainerSource2 = DeserializedPackageFragmentImpl.this.q;
            if (deserializedContainerSource2 != null) {
                return deserializedContainerSource2;
            }
            SourceElement sourceElement = SourceElement.a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return sourceElement;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o$b */
    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class b extends Lambda implements Function0<Collection<? extends Name>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends Name> invoke() {
            Collection<ClassId> allClassIds = DeserializedPackageFragmentImpl.this.getClassDataFinder().getAllClassIds();
            ArrayList arrayList = new ArrayList();
            for (Object obj : allClassIds) {
                ClassId classId = (ClassId) obj;
                if ((classId.isNestedClass() || ClassDeserializer.a.getBLACK_LIST().contains(classId)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ClassId) it.next()).getShortClassName());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, d0.e0.p.d.m0.f.m mVar, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2) {
        super(fqName, storageManager, moduleDescriptor2);
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(mVar, "proto");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        this.p = binaryVersion;
        this.q = deserializedContainerSource2;
        d0.e0.p.d.m0.f.p strings = mVar.getStrings();
        Intrinsics3.checkNotNullExpressionValue(strings, "proto.strings");
        d0.e0.p.d.m0.f.o qualifiedNames = mVar.getQualifiedNames();
        Intrinsics3.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.r = nameResolverImpl;
        this.f3506s = new ProtoBasedClassDataFinder(mVar, nameResolverImpl, binaryVersion, new a());
        this.t = mVar;
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentDescriptor
    public MemberScope3 getMemberScope() {
        MemberScope3 memberScope3 = this.u;
        if (memberScope3 != null) {
            return memberScope3;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("_memberScope");
        throw null;
    }

    public void initialize(context5 context5Var) {
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        d0.e0.p.d.m0.f.m mVar = this.t;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.t = null;
        d0.e0.p.d.m0.f.l lVar = mVar.getPackage();
        Intrinsics3.checkNotNullExpressionValue(lVar, "proto.`package`");
        this.u = new DeserializedPackageMemberScope(this, lVar, this.r, this.p, this.q, context5Var, new b());
    }

    @Override // d0.e0.p.d.m0.l.b.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.f3506s;
    }
}
