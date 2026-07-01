package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentProvider;
import d0.e0.p.d.m0.c.PackageFragmentProvider2;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.l.b.e0.DeserializedClassDescriptor;
import d0.t.SetsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h, reason: use source file name */
/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassDeserializer {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<ClassId> f3500b = SetsJVM.setOf(ClassId.topLevel(StandardNames.a.d.toSafe()));
    public final context5 c;
    public final Function1<a, ClassDescriptor> d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$a */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class a {
        public final ClassId a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ClassData f3501b;

        public a(ClassId classId, ClassData classData) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            this.a = classId;
            this.f3501b = classData;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics3.areEqual(this.a, ((a) obj).a);
        }

        public final ClassData getClassData() {
            return this.f3501b;
        }

        public final ClassId getClassId() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$b */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.f3500b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$c */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class c extends Lambda implements Function1<a, ClassDescriptor> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ClassDescriptor invoke(a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "key");
            return ClassDeserializer.access$createClass(ClassDeserializer.this, aVar);
        }
    }

    public ClassDeserializer(context5 context5Var) {
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        this.c = context5Var;
        this.d = context5Var.getStorageManager().createMemoizedFunctionWithNullableValues(new c());
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00bf  */
    public static final ClassDescriptor access$createClass(ClassDeserializer classDeserializer, a aVar) {
        Object next;
        context6 context6VarCreateContext;
        boolean z2;
        Objects.requireNonNull(classDeserializer);
        ClassId classId = aVar.getClassId();
        Iterator<ClassDescriptorFactory> it = classDeserializer.c.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            ClassDescriptor classDescriptorCreateClass = it.next().createClass(classId);
            if (classDescriptorCreateClass != null) {
                return classDescriptorCreateClass;
            }
        }
        if (a.getBLACK_LIST().contains(classId)) {
            return null;
        }
        ClassData classData = aVar.getClassData();
        if (classData == null && (classData = classDeserializer.c.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        NameResolver nameResolverComponent1 = classData.component1();
        d0.e0.p.d.m0.f.c cVarComponent2 = classData.component2();
        BinaryVersion binaryVersionComponent3 = classData.component3();
        SourceElement sourceElementComponent4 = classData.component4();
        ClassId outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            ClassDescriptor classDescriptorDeserializeClass$default = deserializeClass$default(classDeserializer, outerClassId, null, 2, null);
            DeserializedClassDescriptor deserializedClassDescriptor = classDescriptorDeserializeClass$default instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) classDescriptorDeserializeClass$default : null;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            Name shortClassName = classId.getShortClassName();
            Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            if (!deserializedClassDescriptor.hasNestedClass$deserialization(shortClassName)) {
                return null;
            }
            context6VarCreateContext = deserializedClassDescriptor.getC();
        } else {
            PackageFragmentProvider packageFragmentProvider = classDeserializer.c.getPackageFragmentProvider();
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            Iterator<T> it2 = PackageFragmentProvider2.packageFragments(packageFragmentProvider, packageFqName).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) next;
                if (packageFragmentDescriptor instanceof DeserializedPackageFragment) {
                    Name shortClassName2 = classId.getShortClassName();
                    Intrinsics3.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
                    if (((DeserializedPackageFragment) packageFragmentDescriptor).hasTopLevelClass(shortClassName2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = true;
                }
            } while (!z2);
            PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) next;
            if (packageFragmentDescriptor2 == null) {
                return null;
            }
            context5 context5Var = classDeserializer.c;
            d0.e0.p.d.m0.f.t typeTable = cVarComponent2.getTypeTable();
            Intrinsics3.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
            TypeTable typeTable2 = new TypeTable(typeTable);
            VersionRequirement2.a aVar2 = VersionRequirement2.a;
            d0.e0.p.d.m0.f.w versionRequirementTable = cVarComponent2.getVersionRequirementTable();
            Intrinsics3.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
            context6VarCreateContext = context5Var.createContext(packageFragmentDescriptor2, nameResolverComponent1, typeTable2, aVar2.create(versionRequirementTable), binaryVersionComponent3, null);
        }
        return new DeserializedClassDescriptor(context6VarCreateContext, cVarComponent2, nameResolverComponent1, binaryVersionComponent3, sourceElementComponent4);
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i, Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        return this.d.invoke(new a(classId, classData));
    }
}
