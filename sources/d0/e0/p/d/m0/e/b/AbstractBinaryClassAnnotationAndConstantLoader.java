package d0.e0.p.d.m0.e.b;

import com.discord.widgets.chat.input.MentionUtils;
import d0.e0.p.d.m0.SpecialJvmAnnotations;
import d0.e0.p.d.m0.b.UnsignedType3;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.MemberSignature;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.ClassMapperLite;
import d0.e0.p.d.m0.f.a0.b.JvmMemberSignature;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.protoTypeTableUtil;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.k.v.b0;
import d0.e0.p.d.m0.k.y.JvmClassName;
import d0.e0.p.d.m0.l.b.AnnotatedCallableKind;
import d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader;
import d0.e0.p.d.m0.l.b.ProtoContainer;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {
    public final KotlinClassFinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final storage3<KotlinJvmBinaryClass, b<A, C>> f3361b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$a */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public enum a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$b */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class b<A, C> {
        public final Map<MemberSignature, List<A>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<MemberSignature, C> f3362b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2) {
            Intrinsics3.checkNotNullParameter(map, "memberAnnotations");
            Intrinsics3.checkNotNullParameter(map2, "propertyConstants");
            this.a = map;
            this.f3362b = map2;
        }

        public final Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.a;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.f3362b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$c */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class c implements KotlinJvmBinaryClass.c {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<A> f3363b;

        public c(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, ArrayList<A> arrayList) {
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
            this.f3363b = arrayList;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.c
        public KotlinJvmBinaryClass.a visitAnnotation(ClassId classId, SourceElement sourceElement) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.a, classId, sourceElement, this.f3363b);
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.c
        public void visitEnd() {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$d */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class d extends Lambda implements Function1<KotlinJvmBinaryClass, b<? extends A, ? extends C>> {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader) {
            super(1);
            this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
        }

        @Override // kotlin.jvm.functions.Function1
        public final b<A, C> invoke(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
            Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationsAndInitializers(this.this$0, kotlinJvmBinaryClass);
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.a = kotlinClassFinder;
        this.f3361b = storageManager.createMemoizedFunction(new d(this));
    }

    public static final KotlinJvmBinaryClass.a access$loadAnnotationIfNotSpecial(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ClassId classId, SourceElement sourceElement, List list) {
        Objects.requireNonNull(abstractBinaryClassAnnotationAndConstantLoader);
        if (SpecialJvmAnnotations.a.getSPECIAL_ANNOTATIONS().contains(classId)) {
            return null;
        }
        return abstractBinaryClassAnnotationAndConstantLoader.h(classId, sourceElement, list);
    }

    public static final b access$loadAnnotationsAndInitializers(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Objects.requireNonNull(abstractBinaryClassAnnotationAndConstantLoader);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        AbstractBinaryClassAnnotationAndConstantLoader2 abstractBinaryClassAnnotationAndConstantLoader2 = new AbstractBinaryClassAnnotationAndConstantLoader2(abstractBinaryClassAnnotationAndConstantLoader, map, map2);
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        kotlinJvmBinaryClass.visitMembers(abstractBinaryClassAnnotationAndConstantLoader2, null);
        return new b(map, map2);
    }

    public static /* synthetic */ List b(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z2, boolean z3, Boolean bool, boolean z4, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.a(protoContainer, memberSignature, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z4);
    }

    public static /* synthetic */ MemberSignature d(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z2, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.c(messageLite, nameResolver, typeTable, annotatedCallableKind, (i & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ MemberSignature f(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, d0.e0.p.d.m0.f.n nVar, NameResolver nameResolver, TypeTable typeTable, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.e(nVar, nameResolver, typeTable, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? true : z4);
    }

    public final List<A> a(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z2, boolean z3, Boolean bool, boolean z4) {
        KotlinJvmBinaryClass kotlinJvmBinaryClassG = g(protoContainer, z2, z3, bool, z4);
        if (kotlinJvmBinaryClassG == null) {
            kotlinJvmBinaryClassG = protoContainer instanceof ProtoContainer.a ? j((ProtoContainer.a) protoContainer) : null;
        }
        if (kotlinJvmBinaryClassG == null) {
            return Collections2.emptyList();
        }
        List<A> list = ((b) ((LockBasedStorageManager.m) this.f3361b).invoke(kotlinJvmBinaryClassG)).getMemberAnnotations().get(memberSignature);
        return list == null ? Collections2.emptyList() : list;
    }

    public final MemberSignature c(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z2) {
        if (messageLite instanceof d0.e0.p.d.m0.f.d) {
            MemberSignature.a aVar = MemberSignature.a;
            JvmMemberSignature.b jvmConstructorSignature = JvmProtoBufUtil.a.getJvmConstructorSignature((d0.e0.p.d.m0.f.d) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return aVar.fromJvmMemberSignature(jvmConstructorSignature);
        }
        if (messageLite instanceof d0.e0.p.d.m0.f.i) {
            MemberSignature.a aVar2 = MemberSignature.a;
            JvmMemberSignature.b jvmMethodSignature = JvmProtoBufUtil.a.getJvmMethodSignature((d0.e0.p.d.m0.f.i) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return aVar2.fromJvmMemberSignature(jvmMethodSignature);
        }
        if (!(messageLite instanceof d0.e0.p.d.m0.f.n)) {
            return null;
        }
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.n, JvmProtoBuf.d> fVar = JvmProtoBuf.d;
        Intrinsics3.checkNotNullExpressionValue(fVar, "propertySignature");
        JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull((GeneratedMessageLite.d) messageLite, fVar);
        if (dVar == null) {
            return null;
        }
        int iOrdinal = annotatedCallableKind.ordinal();
        if (iOrdinal == 1) {
            return e((d0.e0.p.d.m0.f.n) messageLite, nameResolver, typeTable, true, true, z2);
        }
        if (iOrdinal == 2) {
            if (!dVar.hasGetter()) {
                return null;
            }
            MemberSignature.a aVar3 = MemberSignature.a;
            JvmProtoBuf.c getter = dVar.getGetter();
            Intrinsics3.checkNotNullExpressionValue(getter, "signature.getter");
            return aVar3.fromMethod(nameResolver, getter);
        }
        if (iOrdinal != 3 || !dVar.hasSetter()) {
            return null;
        }
        MemberSignature.a aVar4 = MemberSignature.a;
        JvmProtoBuf.c setter = dVar.getSetter();
        Intrinsics3.checkNotNullExpressionValue(setter, "signature.setter");
        return aVar4.fromMethod(nameResolver, setter);
    }

    public final MemberSignature e(d0.e0.p.d.m0.f.n nVar, NameResolver nameResolver, TypeTable typeTable, boolean z2, boolean z3, boolean z4) {
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.n, JvmProtoBuf.d> fVar = JvmProtoBuf.d;
        Intrinsics3.checkNotNullExpressionValue(fVar, "propertySignature");
        JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        if (z2) {
            JvmMemberSignature.a jvmFieldSignature = JvmProtoBufUtil.a.getJvmFieldSignature(nVar, nameResolver, typeTable, z4);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.a.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (!z3 || !dVar.hasSyntheticMethod()) {
            return null;
        }
        MemberSignature.a aVar = MemberSignature.a;
        JvmProtoBuf.c syntheticMethod = dVar.getSyntheticMethod();
        Intrinsics3.checkNotNullExpressionValue(syntheticMethod, "signature.syntheticMethod");
        return aVar.fromMethod(nameResolver, syntheticMethod);
    }

    public final KotlinJvmBinaryClass g(ProtoContainer protoContainer, boolean z2, boolean z3, Boolean bool, boolean z4) {
        ProtoContainer.a outerClass;
        c.EnumC0397c enumC0397c = c.EnumC0397c.INTERFACE;
        if (z2) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
            }
            if (protoContainer instanceof ProtoContainer.a) {
                ProtoContainer.a aVar = (ProtoContainer.a) protoContainer;
                if (aVar.getKind() == enumC0397c) {
                    KotlinClassFinder kotlinClassFinder = this.a;
                    ClassId classIdCreateNestedClassId = aVar.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                    Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                    return KotlinClassFinder2.findKotlinClass(kotlinClassFinder, classIdCreateNestedClassId);
                }
            }
            if (bool.booleanValue() && (protoContainer instanceof ProtoContainer.b)) {
                SourceElement source = protoContainer.getSource();
                JvmPackagePartSource jvmPackagePartSource = source instanceof JvmPackagePartSource ? (JvmPackagePartSource) source : null;
                JvmClassName facadeClassName = jvmPackagePartSource == null ? null : jvmPackagePartSource.getFacadeClassName();
                if (facadeClassName != null) {
                    KotlinClassFinder kotlinClassFinder2 = this.a;
                    String internalName = facadeClassName.getInternalName();
                    Intrinsics3.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                    ClassId classId = ClassId.topLevel(new FqName(StringsJVM.replace$default(internalName, MentionUtils.SLASH_CHAR, '.', false, 4, (Object) null)));
                    Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                    return KotlinClassFinder2.findKotlinClass(kotlinClassFinder2, classId);
                }
            }
        }
        if (z3 && (protoContainer instanceof ProtoContainer.a)) {
            ProtoContainer.a aVar2 = (ProtoContainer.a) protoContainer;
            if (aVar2.getKind() == c.EnumC0397c.COMPANION_OBJECT && (outerClass = aVar2.getOuterClass()) != null && (outerClass.getKind() == c.EnumC0397c.CLASS || outerClass.getKind() == c.EnumC0397c.ENUM_CLASS || (z4 && (outerClass.getKind() == enumC0397c || outerClass.getKind() == c.EnumC0397c.ANNOTATION_CLASS)))) {
                return j(outerClass);
            }
        }
        if (!(protoContainer instanceof ProtoContainer.b) || !(protoContainer.getSource() instanceof JvmPackagePartSource)) {
            return null;
        }
        SourceElement source2 = protoContainer.getSource();
        Objects.requireNonNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source2;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
        return knownJvmBinaryClass == null ? KotlinClassFinder2.findKotlinClass(this.a, jvmPackagePartSource2.getClassId()) : knownJvmBinaryClass;
    }

    public abstract KotlinJvmBinaryClass.a h(ClassId classId, SourceElement sourceElement, List<A> list);

    public final List<A> i(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar, a aVar) {
        Boolean bool = Flags2.f3416z.get(nVar.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_CONST.get(proto.flags)");
        boolean zBooleanValue = bool.booleanValue();
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.a;
        boolean zIsMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(nVar);
        if (aVar == a.PROPERTY) {
            MemberSignature memberSignatureF = f(this, nVar, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            return memberSignatureF == null ? Collections2.emptyList() : b(this, protoContainer, memberSignatureF, true, false, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature memberSignatureF2 = f(this, nVar, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (memberSignatureF2 == null) {
            return Collections2.emptyList();
        }
        return Strings4.contains$default((CharSequence) memberSignatureF2.getSignature(), (CharSequence) "$delegate", false, 2, (Object) null) != (aVar == a.DELEGATE_FIELD) ? Collections2.emptyList() : a(protoContainer, memberSignatureF2, true, true, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion);
    }

    public final KotlinJvmBinaryClass j(ProtoContainer.a aVar) {
        SourceElement source = aVar.getSource();
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) source : null;
        if (kotlinJvmBinarySourceElement == null) {
            return null;
        }
        return kotlinJvmBinarySourceElement.getBinaryClass();
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return i(protoContainer, (d0.e0.p.d.m0.f.n) messageLite, a.PROPERTY);
        }
        MemberSignature memberSignatureD = d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        return memberSignatureD == null ? Collections2.emptyList() : b(this, protoContainer, memberSignatureD, false, false, null, false, 60, null);
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadClassAnnotations(ProtoContainer.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "container");
        KotlinJvmBinaryClass kotlinJvmBinaryClassJ = j(aVar);
        if (kotlinJvmBinaryClassJ == null) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Class for loading annotations is not found: ", aVar.debugFqName()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        c cVar = new c(this, arrayList);
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClassJ, "kotlinClass");
        kotlinJvmBinaryClassJ.loadClassAnnotations(cVar, null);
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.g gVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(gVar, "proto");
        MemberSignature.a aVar = MemberSignature.a;
        String string = protoContainer.getNameResolver().getString(gVar.getName());
        ClassMapperLite classMapperLite = ClassMapperLite.a;
        String strAsString = ((ProtoContainer.a) protoContainer).getClassId().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "container as ProtoContainer.Class).classId.asString()");
        return b(this, protoContainer, aVar.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(strAsString)), false, false, null, false, 60, null);
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        MemberSignature memberSignatureD = d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        return memberSignatureD != null ? b(this, protoContainer, MemberSignature.a.fromMethodSignatureAndParameterIndex(memberSignatureD, 0), false, false, null, false, 60, null) : Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        return i(protoContainer, nVar, a.BACKING_FIELD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar, KotlinType kotlinType) {
        C c2;
        b0 zVar;
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        Intrinsics3.checkNotNullParameter(kotlinType, "expectedType");
        Boolean bool = Flags2.f3416z.get(nVar.getFlags());
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.a;
        KotlinJvmBinaryClass kotlinJvmBinaryClassG = g(protoContainer, true, true, bool, JvmProtoBufUtil.isMovedFromInterfaceCompanion(nVar));
        if (kotlinJvmBinaryClassG == null) {
            kotlinJvmBinaryClassG = protoContainer instanceof ProtoContainer.a ? j((ProtoContainer.a) protoContainer) : null;
        }
        if (kotlinJvmBinaryClassG == null) {
            return null;
        }
        MemberSignature memberSignatureC = c(nVar, protoContainer.getNameResolver(), protoContainer.getTypeTable(), AnnotatedCallableKind.PROPERTY, kotlinJvmBinaryClassG.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.a.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (memberSignatureC == null || (c2 = ((b) ((LockBasedStorageManager.m) this.f3361b).invoke(kotlinJvmBinaryClassG)).getPropertyConstants().get(memberSignatureC)) == 0) {
            return null;
        }
        UnsignedType3 unsignedType3 = UnsignedType3.a;
        if (!UnsignedType3.isUnsignedType(kotlinType)) {
            return c2;
        }
        C c3 = (C) ((d0.e0.p.d.m0.k.v.g) c2);
        Intrinsics3.checkNotNullParameter(c3, "constant");
        if (c3 instanceof d0.e0.p.d.m0.k.v.d) {
            zVar = new d0.e0.p.d.m0.k.v.x(((d0.e0.p.d.m0.k.v.d) c3).getValue().byteValue());
        } else if (c3 instanceof d0.e0.p.d.m0.k.v.v) {
            zVar = new d0.e0.p.d.m0.k.v.a0(((d0.e0.p.d.m0.k.v.v) c3).getValue().shortValue());
        } else if (c3 instanceof d0.e0.p.d.m0.k.v.m) {
            zVar = new d0.e0.p.d.m0.k.v.y(((d0.e0.p.d.m0.k.v.m) c3).getValue().intValue());
        } else {
            if (!(c3 instanceof d0.e0.p.d.m0.k.v.s)) {
                return c3;
            }
            zVar = new d0.e0.p.d.m0.k.v.z(((d0.e0.p.d.m0.k.v.s) c3).getValue().longValue());
        }
        return (C) zVar;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, d0.e0.p.d.m0.f.n nVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        return i(protoContainer, nVar, a.DELEGATE_FIELD);
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadTypeAnnotations(d0.e0.p.d.m0.f.q qVar, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(qVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = qVar.getExtension(JvmProtoBuf.f);
        Intrinsics3.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<d0.e0.p.d.m0.f.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
        for (d0.e0.p.d.m0.f.b bVar : iterable) {
            Intrinsics3.checkNotNullExpressionValue(bVar, "it");
            Intrinsics3.checkNotNullParameter(bVar, "proto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            arrayList.add(((BinaryClassAnnotationAndConstantLoaderImpl) this).e.deserializeAnnotation(bVar, nameResolver));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadTypeParameterAnnotations(d0.e0.p.d.m0.f.s sVar, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(sVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = sVar.getExtension(JvmProtoBuf.h);
        Intrinsics3.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<d0.e0.p.d.m0.f.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
        for (d0.e0.p.d.m0.f.b bVar : iterable) {
            Intrinsics3.checkNotNullExpressionValue(bVar, "it");
            Intrinsics3.checkNotNullParameter(bVar, "proto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            arrayList.add(((BinaryClassAnnotationAndConstantLoaderImpl) this).e.deserializeAnnotation(bVar, nameResolver));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    @Override // d0.e0.p.d.m0.l.b.AnnotationAndConstantLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, d0.e0.p.d.m0.f.u uVar) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        Intrinsics3.checkNotNullParameter(uVar, "proto");
        MemberSignature memberSignatureD = d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        if (memberSignatureD == null) {
            return Collections2.emptyList();
        }
        int i2 = 1;
        if (messageLite instanceof d0.e0.p.d.m0.f.i) {
            if (!protoTypeTableUtil.hasReceiver((d0.e0.p.d.m0.f.i) messageLite)) {
                i2 = 0;
            }
        } else if (messageLite instanceof d0.e0.p.d.m0.f.n) {
            if (!protoTypeTableUtil.hasReceiver((d0.e0.p.d.m0.f.n) messageLite)) {
                i2 = 0;
            }
        } else {
            if (!(messageLite instanceof d0.e0.p.d.m0.f.d)) {
                throw new UnsupportedOperationException(Intrinsics3.stringPlus("Unsupported message: ", messageLite.getClass()));
            }
            ProtoContainer.a aVar = (ProtoContainer.a) protoContainer;
            if (aVar.getKind() == c.EnumC0397c.ENUM_CLASS) {
                i2 = 2;
            } else if (!aVar.isInner()) {
                i2 = 0;
            }
        }
        return b(this, protoContainer, MemberSignature.a.fromMethodSignatureAndParameterIndex(memberSignatureD, i + i2), false, false, null, false, 60, null);
    }
}
