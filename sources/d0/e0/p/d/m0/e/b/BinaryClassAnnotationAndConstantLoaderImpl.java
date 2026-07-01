package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptorImpl;
import d0.e0.p.d.m0.e.a.g0.DescriptorResolverUtils;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.v.ClassLiteralValue;
import d0.e0.p.d.m0.k.v.ConstantValueFactory;
import d0.e0.p.d.m0.l.b.AnnotationDeserializer;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.p.collections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c, reason: use source file name */
/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, d0.e0.p.d.m0.k.v.g<?>> {
    public final ModuleDescriptor2 c;
    public final NotFoundClasses d;
    public final AnnotationDeserializer e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a */
    /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    public static final class a implements KotlinJvmBinaryClass.a {
        public final HashMap<Name, d0.e0.p.d.m0.k.v.g<?>> a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClassDescriptor f3373b;
        public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl c;
        public final /* synthetic */ List<AnnotationDescriptor> d;
        public final /* synthetic */ SourceElement e;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class C0389a implements KotlinJvmBinaryClass.a {
            public final /* synthetic */ KotlinJvmBinaryClass.a a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ KotlinJvmBinaryClass.a f3374b;
            public final /* synthetic */ a c;
            public final /* synthetic */ Name d;
            public final /* synthetic */ ArrayList<AnnotationDescriptor> e;

            public C0389a(KotlinJvmBinaryClass.a aVar, a aVar2, Name name, ArrayList<AnnotationDescriptor> arrayList) {
                this.f3374b = aVar;
                this.c = aVar2;
                this.d = name;
                this.e = arrayList;
                this.a = aVar;
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
            public void visit(Name name, Object obj) {
                this.a.visit(name, obj);
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
            public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(classId, "classId");
                return this.a.visitAnnotation(name, classId);
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
            public KotlinJvmBinaryClass.b visitArray(Name name) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return this.a.visitArray(name);
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
            public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
                this.a.visitClassLiteral(name, classLiteralValue);
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
            public void visitEnd() {
                this.f3374b.visitEnd();
                this.c.a.put(this.d, new d0.e0.p.d.m0.k.v.a((AnnotationDescriptor) _Collections.single((List) this.e)));
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
            public void visitEnum(Name name, ClassId classId, Name name2) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(classId, "enumClassId");
                Intrinsics3.checkNotNullParameter(name2, "enumEntryName");
                this.a.visitEnum(name, classId, name2);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a$b */
        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class b implements KotlinJvmBinaryClass.b {
            public final ArrayList<d0.e0.p.d.m0.k.v.g<?>> a = new ArrayList<>();
            public final /* synthetic */ Name c;
            public final /* synthetic */ ClassDescriptor d;

            public b(Name name, ClassDescriptor classDescriptor) {
                this.c = name;
                this.d = classDescriptor;
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
            public void visit(Object obj) {
                this.a.add(a.this.a(this.c, obj));
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
            public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
                Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
                this.a.add(new d0.e0.p.d.m0.k.v.r(classLiteralValue));
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
            public void visitEnd() {
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(this.c, this.d);
                if (annotationParameterByName != null) {
                    HashMap map = a.this.a;
                    Name name = this.c;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.a;
                    List<? extends d0.e0.p.d.m0.k.v.g<?>> listCompact = collections.compact(this.a);
                    KotlinType type = annotationParameterByName.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "parameter.type");
                    map.put(name, constantValueFactory.createArrayValue(listCompact, type));
                }
            }

            @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
            public void visitEnum(ClassId classId, Name name) {
                Intrinsics3.checkNotNullParameter(classId, "enumClassId");
                Intrinsics3.checkNotNullParameter(name, "enumEntryName");
                this.a.add(new d0.e0.p.d.m0.k.v.j(classId, name));
            }
        }

        public a(ClassDescriptor classDescriptor, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, List<AnnotationDescriptor> list, SourceElement sourceElement) {
            this.f3373b = classDescriptor;
            this.c = binaryClassAnnotationAndConstantLoaderImpl;
            this.d = list;
            this.e = sourceElement;
        }

        public final d0.e0.p.d.m0.k.v.g<?> a(Name name, Object obj) {
            d0.e0.p.d.m0.k.v.g<?> gVarCreateConstantValue = ConstantValueFactory.a.createConstantValue(obj);
            return gVarCreateConstantValue == null ? d0.e0.p.d.m0.k.v.k.f3474b.create(Intrinsics3.stringPlus("Unsupported annotation argument: ", name)) : gVarCreateConstantValue;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visit(Name name, Object obj) {
            if (name != null) {
                this.a.put(name, a(name, obj));
            }
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classId, "classId");
            ArrayList arrayList = new ArrayList();
            BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.c;
            SourceElement sourceElement = SourceElement.a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            KotlinJvmBinaryClass.a aVarH = binaryClassAnnotationAndConstantLoaderImpl.h(classId, sourceElement, arrayList);
            Intrinsics3.checkNotNull(aVarH);
            return new C0389a(aVarH, this, name, arrayList);
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.b visitArray(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new b(name, this.f3373b);
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
            this.a.put(name, new d0.e0.p.d.m0.k.v.r(classLiteralValue));
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitEnd() {
            this.d.add(new AnnotationDescriptorImpl(this.f3373b.getDefaultType(), this.a, this.e));
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitEnum(Name name, ClassId classId, Name name2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classId, "enumClassId");
            Intrinsics3.checkNotNullParameter(name2, "enumEntryName");
            this.a.put(name, new d0.e0.p.d.m0.k.v.j(classId, name2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses, StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.c = moduleDescriptor2;
        this.d = notFoundClasses;
        this.e = new AnnotationDeserializer(moduleDescriptor2, notFoundClasses);
    }

    @Override // d0.e0.p.d.m0.e.b.AbstractBinaryClassAnnotationAndConstantLoader
    public KotlinJvmBinaryClass.a h(ClassId classId, SourceElement sourceElement, List<AnnotationDescriptor> list) {
        Intrinsics3.checkNotNullParameter(classId, "annotationClassId");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        Intrinsics3.checkNotNullParameter(list, "result");
        return new a(findClassInModule.findNonGenericClassAcrossDependencies(this.c, classId, this.d), this, list, sourceElement);
    }
}
