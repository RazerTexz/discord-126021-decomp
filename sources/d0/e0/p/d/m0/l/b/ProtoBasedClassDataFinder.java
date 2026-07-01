package d0.e0.p.d.m0.l.b;

import d0.d0._Ranges;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.g.ClassId;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.x, reason: use source file name */
/* JADX INFO: compiled from: ProtoBasedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    public final NameResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BinaryVersion f3509b;
    public final Function1<ClassId, SourceElement> c;
    public final Map<ClassId, d0.e0.p.d.m0.f.c> d;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(d0.e0.p.d.m0.f.m mVar, NameResolver nameResolver, BinaryVersion binaryVersion, Function1<? super ClassId, ? extends SourceElement> function1) {
        Intrinsics3.checkNotNullParameter(mVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(function1, "classSource");
        this.a = nameResolver;
        this.f3509b = binaryVersion;
        this.c = function1;
        List<d0.e0.p.d.m0.f.c> class_List = mVar.getClass_List();
        Intrinsics3.checkNotNullExpressionValue(class_List, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(class_List, 10)), 16));
        for (Object obj : class_List) {
            linkedHashMap.put(NameResolverUtil.getClassId(this.a, ((d0.e0.p.d.m0.f.c) obj).getFqName()), obj);
        }
        this.d = linkedHashMap;
    }

    @Override // d0.e0.p.d.m0.l.b.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        d0.e0.p.d.m0.f.c cVar = this.d.get(classId);
        if (cVar == null) {
            return null;
        }
        return new ClassData(this.a, cVar, this.f3509b, this.c.invoke(classId));
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.d.keySet();
    }
}
