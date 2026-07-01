package d0.e0.p.d.m0.l.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.functionTypes;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.FieldDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertyGetterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertySetterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl;
import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.VersionRequirement;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.f.z.protoTypeTableUtil;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.ProtoContainer;
import d0.e0.p.d.m0.l.b.e0.DeserializedAnnotations;
import d0.e0.p.d.m0.l.b.e0.DeserializedAnnotations2;
import d0.e0.p.d.m0.l.b.e0.DeserializedClassDescriptor;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor2;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor4;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor5;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor6;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.u._ComparisonsJvm;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.u, reason: use source file name */
/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MemberDeserializer {
    public final context6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnotationDeserializer f3508b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.u$b */
    /* JADX INFO: compiled from: MemberDeserializer.kt */
    public static final class b extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ AnnotatedCallableKind $kind;
        public final /* synthetic */ MessageLite $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
            super(0);
            this.$proto = messageLite;
            this.$kind = annotatedCallableKind;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AnnotationDescriptor> invoke() {
            List<? extends AnnotationDescriptor> list;
            MemberDeserializer memberDeserializer = MemberDeserializer.this;
            ProtoContainer protoContainerA = memberDeserializer.a(memberDeserializer.a.getContainingDeclaration());
            if (protoContainerA == null) {
                list = null;
            } else {
                list = _Collections.toList(MemberDeserializer.this.a.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(protoContainerA, this.$proto, this.$kind));
            }
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.u$c */
    /* JADX INFO: compiled from: MemberDeserializer.kt */
    public static final class c extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ boolean $isDelegate;
        public final /* synthetic */ d0.e0.p.d.m0.f.n $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z2, d0.e0.p.d.m0.f.n nVar) {
            super(0);
            this.$isDelegate = z2;
            this.$proto = nVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AnnotationDescriptor> invoke() {
            List<? extends AnnotationDescriptor> list;
            MemberDeserializer memberDeserializer = MemberDeserializer.this;
            ProtoContainer protoContainerA = memberDeserializer.a(memberDeserializer.a.getContainingDeclaration());
            if (protoContainerA == null) {
                list = null;
            } else {
                boolean z2 = this.$isDelegate;
                MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                d0.e0.p.d.m0.f.n nVar = this.$proto;
                list = z2 ? _Collections.toList(memberDeserializer2.a.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(protoContainerA, nVar)) : _Collections.toList(memberDeserializer2.a.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(protoContainerA, nVar));
            }
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.u$d */
    /* JADX INFO: compiled from: MemberDeserializer.kt */
    public static final class d extends Lambda implements Function0<d0.e0.p.d.m0.k.v.g<?>> {
        public final /* synthetic */ DeserializedMemberDescriptor4 $property;
        public final /* synthetic */ d0.e0.p.d.m0.f.n $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d0.e0.p.d.m0.f.n nVar, DeserializedMemberDescriptor4 deserializedMemberDescriptor4) {
            super(0);
            this.$proto = nVar;
            this.$property = deserializedMemberDescriptor4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.p.d.m0.k.v.g<?> invoke() {
            MemberDeserializer memberDeserializer = MemberDeserializer.this;
            ProtoContainer protoContainerA = memberDeserializer.a(memberDeserializer.a.getContainingDeclaration());
            Intrinsics3.checkNotNull(protoContainerA);
            AnnotationAndConstantLoader<AnnotationDescriptor, d0.e0.p.d.m0.k.v.g<?>> annotationAndConstantLoader = MemberDeserializer.this.a.getComponents().getAnnotationAndConstantLoader();
            d0.e0.p.d.m0.f.n nVar = this.$proto;
            KotlinType returnType = this.$property.getReturnType();
            Intrinsics3.checkNotNullExpressionValue(returnType, "property.returnType");
            return annotationAndConstantLoader.loadPropertyConstant(protoContainerA, nVar, returnType);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.u$e */
    /* JADX INFO: compiled from: MemberDeserializer.kt */
    public static final class e extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ MessageLite $callable;
        public final /* synthetic */ ProtoContainer $containerOfCallable;
        public final /* synthetic */ int $i;
        public final /* synthetic */ AnnotatedCallableKind $kind;
        public final /* synthetic */ d0.e0.p.d.m0.f.u $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, d0.e0.p.d.m0.f.u uVar) {
            super(0);
            this.$containerOfCallable = protoContainer;
            this.$callable = messageLite;
            this.$kind = annotatedCallableKind;
            this.$i = i;
            this.$proto = uVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AnnotationDescriptor> invoke() {
            return _Collections.toList(MemberDeserializer.this.a.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
        }
    }

    public MemberDeserializer(context6 context6Var) {
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        this.a = context6Var;
        this.f3508b = new AnnotationDeserializer(context6Var.getComponents().getModuleDescriptor(), context6Var.getComponents().getNotFoundClasses());
    }

    public final ProtoContainer a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.b(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.a.getNameResolver(), this.a.getTypeTable(), this.a.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    public final DeserializedMemberDescriptor3.a b(DeserializedMemberDescriptor3 deserializedMemberDescriptor3, TypeDeserializer typeDeserializer) {
        DeserializedMemberDescriptor3.a aVar = DeserializedMemberDescriptor3.a.COMPATIBLE;
        if (!i(deserializedMemberDescriptor3)) {
            return aVar;
        }
        Iterator<T> it = typeDeserializer.getOwnTypeParameters().iterator();
        while (it.hasNext()) {
            ((TypeParameterDescriptor) it.next()).getUpperBounds();
        }
        return typeDeserializer.getExperimentalSuspendFunctionTypeEncountered() ? DeserializedMemberDescriptor3.a.INCOMPATIBLE : aVar;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0124  */
    public final DeserializedMemberDescriptor3.a c(DeserializedMemberDescriptor deserializedMemberDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, Collection<? extends ValueParameterDescriptor> collection, Collection<? extends TypeParameterDescriptor> collection2, KotlinType kotlinType, boolean z2) {
        boolean z3;
        boolean z4;
        DeserializedMemberDescriptor3.a aVar;
        boolean z5;
        DeserializedMemberDescriptor3.a aVar2 = DeserializedMemberDescriptor3.a.NEEDS_WRAPPER;
        DeserializedMemberDescriptor3.a aVar3 = DeserializedMemberDescriptor3.a.INCOMPATIBLE;
        DeserializedMemberDescriptor3.a aVar4 = DeserializedMemberDescriptor3.a.COMPATIBLE;
        if (!i(deserializedMemberDescriptor) || Intrinsics3.areEqual(DescriptorUtils2.fqNameOrNull(deserializedMemberDescriptor), suspendFunctionTypeUtil.a)) {
            return aVar4;
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((ValueParameterDescriptor) it.next()).getType());
        }
        List<KotlinType> listPlus = _Collections.plus((Collection) arrayList, (Iterable) Collections2.listOfNotNull(receiverParameterDescriptor == null ? null : receiverParameterDescriptor.getType()));
        if (Intrinsics3.areEqual(kotlinType != null ? Boolean.valueOf(d(kotlinType)) : null, Boolean.TRUE)) {
            return aVar3;
        }
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it2 = collection2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z4 = false;
                    break;
                }
                List<KotlinType> upperBounds = ((TypeParameterDescriptor) it2.next()).getUpperBounds();
                Intrinsics3.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    Iterator<T> it3 = upperBounds.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z3 = false;
                            break;
                        }
                        KotlinType kotlinType2 = (KotlinType) it3.next();
                        Intrinsics3.checkNotNullExpressionValue(kotlinType2, "it");
                        if (d(kotlinType2)) {
                            z3 = true;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                    break;
                }
                if (z3) {
                    z4 = true;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        if (z4) {
            return aVar3;
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
        for (KotlinType kotlinType3 : listPlus) {
            Intrinsics3.checkNotNullExpressionValue(kotlinType3, "type");
            if (functionTypes.isSuspendFunctionType(kotlinType3) && kotlinType3.getArguments().size() <= 3) {
                List<TypeProjection> arguments = kotlinType3.getArguments();
                if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                    Iterator<T> it4 = arguments.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            z5 = false;
                            break;
                        }
                        KotlinType type = ((TypeProjection) it4.next()).getType();
                        Intrinsics3.checkNotNullExpressionValue(type, "it.type");
                        if (d(type)) {
                            z5 = true;
                            break;
                        }
                    }
                } else {
                    z5 = false;
                    break;
                }
                if (z5) {
                    aVar = aVar3;
                } else {
                    aVar = aVar2;
                }
            } else if (d(kotlinType3)) {
                aVar = aVar3;
            } else {
                aVar = aVar4;
            }
            arrayList2.add(aVar);
        }
        DeserializedMemberDescriptor3.a aVar5 = (DeserializedMemberDescriptor3.a) _Collections.maxOrNull((Iterable) arrayList2);
        if (aVar5 == null) {
            aVar5 = aVar4;
        }
        if (!z2) {
            aVar2 = aVar4;
        }
        return (DeserializedMemberDescriptor3.a) _ComparisonsJvm.maxOf(aVar2, aVar5);
    }

    public final boolean d(KotlinType kotlinType) {
        return TypeUtils2.contains(kotlinType, new PropertyReference1() { // from class: d0.e0.p.d.m0.l.b.u.a
            @Override // d0.e0.KProperty3
            public Object get(Object obj) {
                return Boolean.valueOf(functionTypes.isSuspendFunctionType((KotlinType) obj));
            }

            @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return "isSuspendFunctionType";
            }

            @Override // d0.z.d.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection2.getOrCreateKotlinPackage(functionTypes.class, "deserialization");
            }

            @Override // d0.z.d.CallableReference
            public String getSignature() {
                return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            }
        });
    }

    public final Annotations4 e(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        return !Flags2.f3412b.get(i).booleanValue() ? Annotations4.f.getEMPTY() : new DeserializedAnnotations2(this.a.getStorageManager(), new b(messageLite, annotatedCallableKind));
    }

    public final ReceiverParameterDescriptor f() {
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    public final Annotations4 g(d0.e0.p.d.m0.f.n nVar, boolean z2) {
        return !Flags2.f3412b.get(nVar.getFlags()).booleanValue() ? Annotations4.f.getEMPTY() : new DeserializedAnnotations2(this.a.getStorageManager(), new c(z2, nVar));
    }

    public final List<ValueParameterDescriptor> h(List<d0.e0.p.d.m0.f.u> list, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        CallableDescriptor callableDescriptor = (CallableDescriptor) this.a.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "callableDescriptor.containingDeclaration");
        ProtoContainer protoContainerA = a(containingDeclaration);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            d0.e0.p.d.m0.f.u uVar = (d0.e0.p.d.m0.f.u) obj;
            int flags = uVar.hasFlags() ? uVar.getFlags() : 0;
            Annotations4 empty = (protoContainerA == null || !outline.u0(Flags2.f3412b, flags, "HAS_ANNOTATIONS.get(flags)")) ? Annotations4.f.getEMPTY() : new DeserializedAnnotations2(this.a.getStorageManager(), new e(protoContainerA, messageLite, annotatedCallableKind, i, uVar));
            Name name = NameResolverUtil.getName(this.a.getNameResolver(), uVar.getName());
            KotlinType kotlinTypeType = this.a.getTypeDeserializer().type(protoTypeTableUtil.type(uVar, this.a.getTypeTable()));
            boolean zU0 = outline.u0(Flags2.F, flags, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean zU1 = outline.u0(Flags2.G, flags, "IS_CROSSINLINE.get(flags)");
            boolean zU2 = outline.u0(Flags2.H, flags, "IS_NOINLINE.get(flags)");
            d0.e0.p.d.m0.f.q qVarVarargElementType = protoTypeTableUtil.varargElementType(uVar, this.a.getTypeTable());
            KotlinType kotlinTypeType2 = qVarVarargElementType == null ? null : this.a.getTypeDeserializer().type(qVarVarargElementType);
            SourceElement sourceElement = SourceElement.a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, empty, name, kotlinTypeType, zU0, zU1, zU2, kotlinTypeType2, sourceElement));
            arrayList = arrayList2;
            i = i2;
        }
        return _Collections.toList(arrayList);
    }

    public final boolean i(DeserializedMemberDescriptor3 deserializedMemberDescriptor3) {
        boolean z2;
        if (!this.a.getComponents().getConfiguration().getReleaseCoroutines()) {
            return false;
        }
        List<VersionRequirement> versionRequirements = deserializedMemberDescriptor3.getVersionRequirements();
        if ((versionRequirements instanceof Collection) && versionRequirements.isEmpty()) {
            z2 = true;
        } else {
            for (VersionRequirement versionRequirement : versionRequirements) {
                if (Intrinsics3.areEqual(versionRequirement.getVersion(), new VersionRequirement.b(1, 3, 0, 4, null)) && versionRequirement.getKind() == v.d.LANGUAGE_VERSION) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public final ClassConstructorDescriptor loadConstructor(d0.e0.p.d.m0.f.d dVar, boolean z2) {
        DeserializedMemberDescriptor3.a aVarC;
        TypeDeserializer typeDeserializer;
        Intrinsics3.checkNotNullParameter(dVar, "proto");
        ClassDescriptor classDescriptor = (ClassDescriptor) this.a.getContainingDeclaration();
        int flags = dVar.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedMemberDescriptor2 deserializedMemberDescriptor2 = new DeserializedMemberDescriptor2(classDescriptor, null, e(dVar, flags, annotatedCallableKind), z2, CallableMemberDescriptor.a.DECLARATION, dVar, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource(), null, 1024, null);
        MemberDeserializer memberDeserializer = context6.childContext$default(this.a, deserializedMemberDescriptor2, Collections2.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<d0.e0.p.d.m0.f.u> valueParameterList = dVar.getValueParameterList();
        Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        deserializedMemberDescriptor2.initialize(memberDeserializer.h(valueParameterList, dVar, annotatedCallableKind), ProtoEnumFlagsUtils.descriptorVisibility(ProtoEnumFlags.a, Flags2.c.get(dVar.getFlags())));
        deserializedMemberDescriptor2.setReturnType(classDescriptor.getDefaultType());
        deserializedMemberDescriptor2.setHasStableParameterNames(!Flags2.m.get(dVar.getFlags()).booleanValue());
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        Boolean boolValueOf = null;
        DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) containingDeclaration : null;
        context6 c2 = deserializedClassDescriptor == null ? null : deserializedClassDescriptor.getC();
        if (c2 != null && (typeDeserializer = c2.getTypeDeserializer()) != null) {
            boolValueOf = Boolean.valueOf(typeDeserializer.getExperimentalSuspendFunctionTypeEncountered());
        }
        if (Intrinsics3.areEqual(boolValueOf, Boolean.TRUE) && i(deserializedMemberDescriptor2)) {
            aVarC = DeserializedMemberDescriptor3.a.INCOMPATIBLE;
        } else {
            Collection<? extends ValueParameterDescriptor> valueParameters = deserializedMemberDescriptor2.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Collection<? extends TypeParameterDescriptor> typeParameters = deserializedMemberDescriptor2.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            aVarC = c(deserializedMemberDescriptor2, null, valueParameters, typeParameters, deserializedMemberDescriptor2.getReturnType(), false);
        }
        deserializedMemberDescriptor2.setCoroutinesExperimentalCompatibilityMode$deserialization(aVarC);
        return deserializedMemberDescriptor2;
    }

    public final SimpleFunctionDescriptor loadFunction(d0.e0.p.d.m0.f.i iVar) {
        int flags;
        KotlinType kotlinTypeType;
        Intrinsics3.checkNotNullParameter(iVar, "proto");
        if (iVar.hasFlags()) {
            flags = iVar.getFlags();
        } else {
            int oldFlags = iVar.getOldFlags();
            flags = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        int i = flags;
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations4 annotations4E = e(iVar, i, annotatedCallableKind);
        Annotations4 deserializedAnnotations = protoTypeTableUtil.hasReceiver(iVar) ? new DeserializedAnnotations(this.a.getStorageManager(), new MemberDeserializer2(this, iVar, annotatedCallableKind)) : Annotations4.f.getEMPTY();
        VersionRequirement2 empty = Intrinsics3.areEqual(DescriptorUtils2.getFqNameSafe(this.a.getContainingDeclaration()).child(NameResolverUtil.getName(this.a.getNameResolver(), iVar.getName())), suspendFunctionTypeUtil.a) ? VersionRequirement2.a.getEMPTY() : this.a.getVersionRequirementTable();
        Name name = NameResolverUtil.getName(this.a.getNameResolver(), iVar.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.a;
        DeserializedMemberDescriptor5 deserializedMemberDescriptor5 = new DeserializedMemberDescriptor5(this.a.getContainingDeclaration(), null, annotations4E, name, ProtoEnumFlagsUtils.memberKind(protoEnumFlags, Flags2.n.get(i)), iVar, this.a.getNameResolver(), this.a.getTypeTable(), empty, this.a.getContainerSource(), null, 1024, null);
        context6 context6Var = this.a;
        List<d0.e0.p.d.m0.f.s> typeParameterList = iVar.getTypeParameterList();
        Intrinsics3.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        context6 context6VarChildContext$default = context6.childContext$default(context6Var, deserializedMemberDescriptor5, typeParameterList, null, null, null, null, 60, null);
        d0.e0.p.d.m0.f.q qVarReceiverType = protoTypeTableUtil.receiverType(iVar, this.a.getTypeTable());
        ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = (qVarReceiverType == null || (kotlinTypeType = context6VarChildContext$default.getTypeDeserializer().type(qVarReceiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedMemberDescriptor5, kotlinTypeType, deserializedAnnotations);
        ReceiverParameterDescriptor receiverParameterDescriptorF = f();
        List<TypeParameterDescriptor> ownTypeParameters = context6VarChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = context6VarChildContext$default.getMemberDeserializer();
        List<d0.e0.p.d.m0.f.u> valueParameterList = iVar.getValueParameterList();
        Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> listH = memberDeserializer.h(valueParameterList, iVar, annotatedCallableKind);
        KotlinType kotlinTypeType2 = context6VarChildContext$default.getTypeDeserializer().type(protoTypeTableUtil.returnType(iVar, this.a.getTypeTable()));
        Modality modality = protoEnumFlags.modality(Flags2.d.get(i));
        DescriptorVisibility2 descriptorVisibility2DescriptorVisibility = ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags, Flags2.c.get(i));
        Map<? extends CallableDescriptor.a<?>, ?> mapEmptyMap = Maps6.emptyMap();
        Flags2.b bVar = Flags2.t;
        deserializedMemberDescriptor5.initialize(receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, receiverParameterDescriptorF, ownTypeParameters, listH, kotlinTypeType2, modality, descriptorVisibility2DescriptorVisibility, mapEmptyMap, c(deserializedMemberDescriptor5, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, listH, ownTypeParameters, kotlinTypeType2, outline.u0(bVar, i, "IS_SUSPEND.get(flags)")));
        Boolean bool = Flags2.o.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_OPERATOR.get(flags)");
        deserializedMemberDescriptor5.setOperator(bool.booleanValue());
        Boolean bool2 = Flags2.p.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool2, "IS_INFIX.get(flags)");
        deserializedMemberDescriptor5.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags2.f3413s.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool3, "IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedMemberDescriptor5.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags2.q.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool4, "IS_INLINE.get(flags)");
        deserializedMemberDescriptor5.setInline(bool4.booleanValue());
        Boolean bool5 = Flags2.r.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool5, "IS_TAILREC.get(flags)");
        deserializedMemberDescriptor5.setTailrec(bool5.booleanValue());
        Boolean bool6 = bVar.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool6, "IS_SUSPEND.get(flags)");
        deserializedMemberDescriptor5.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags2.u.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool7, "IS_EXPECT_FUNCTION.get(flags)");
        deserializedMemberDescriptor5.setExpect(bool7.booleanValue());
        deserializedMemberDescriptor5.setHasStableParameterNames(!Flags2.v.get(i).booleanValue());
        Tuples2<CallableDescriptor.a<?>, Object> tuples2DeserializeContractFromFunction = this.a.getComponents().getContractDeserializer().deserializeContractFromFunction(iVar, deserializedMemberDescriptor5, this.a.getTypeTable(), context6VarChildContext$default.getTypeDeserializer());
        if (tuples2DeserializeContractFromFunction != null) {
            deserializedMemberDescriptor5.putInUserDataMap(tuples2DeserializeContractFromFunction.getFirst(), tuples2DeserializeContractFromFunction.getSecond());
        }
        return deserializedMemberDescriptor5;
    }

    public final PropertyDescriptor loadProperty(d0.e0.p.d.m0.f.n nVar) {
        int flags;
        d0.e0.p.d.m0.f.n nVar2;
        AnnotatedCallableKind annotatedCallableKind;
        Annotations4 empty;
        ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable;
        DeserializedMemberDescriptor4 deserializedMemberDescriptor4;
        ProtoEnumFlags protoEnumFlags;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter;
        KotlinType kotlinTypeType;
        AnnotatedCallableKind annotatedCallableKind2 = AnnotatedCallableKind.PROPERTY_GETTER;
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        if (nVar.hasFlags()) {
            flags = nVar.getFlags();
        } else {
            int oldFlags = nVar.getOldFlags();
            flags = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        int i = flags;
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        Annotations4 annotations4E = e(nVar, i, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags2 = ProtoEnumFlags.a;
        Flags2.d<d0.e0.p.d.m0.f.k> dVar = Flags2.d;
        Modality modality = protoEnumFlags2.modality(dVar.get(i));
        Flags2.d<d0.e0.p.d.m0.f.x> dVar2 = Flags2.c;
        DeserializedMemberDescriptor4 deserializedMemberDescriptor5 = new DeserializedMemberDescriptor4(containingDeclaration, null, annotations4E, modality, ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags2, dVar2.get(i)), outline.u0(Flags2.w, i, "IS_VAR.get(flags)"), NameResolverUtil.getName(this.a.getNameResolver(), nVar.getName()), ProtoEnumFlagsUtils.memberKind(protoEnumFlags2, Flags2.n.get(i)), outline.u0(Flags2.A, i, "IS_LATEINIT.get(flags)"), outline.u0(Flags2.f3416z, i, "IS_CONST.get(flags)"), outline.u0(Flags2.C, i, "IS_EXTERNAL_PROPERTY.get(flags)"), outline.u0(Flags2.D, i, "IS_DELEGATED.get(flags)"), outline.u0(Flags2.E, i, "IS_EXPECT_PROPERTY.get(flags)"), nVar, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource());
        context6 context6Var = this.a;
        List<d0.e0.p.d.m0.f.s> typeParameterList = nVar.getTypeParameterList();
        Intrinsics3.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        context6 context6VarChildContext$default = context6.childContext$default(context6Var, deserializedMemberDescriptor5, typeParameterList, null, null, null, null, 60, null);
        boolean zU0 = outline.u0(Flags2.f3414x, i, "HAS_GETTER.get(flags)");
        if (zU0 && protoTypeTableUtil.hasReceiver(nVar)) {
            nVar2 = nVar;
            annotatedCallableKind = annotatedCallableKind2;
            empty = new DeserializedAnnotations(this.a.getStorageManager(), new MemberDeserializer2(this, nVar2, annotatedCallableKind));
        } else {
            nVar2 = nVar;
            annotatedCallableKind = annotatedCallableKind2;
            empty = Annotations4.f.getEMPTY();
        }
        KotlinType kotlinTypeType2 = context6VarChildContext$default.getTypeDeserializer().type(protoTypeTableUtil.returnType(nVar2, this.a.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = context6VarChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor receiverParameterDescriptorF = f();
        d0.e0.p.d.m0.f.q qVarReceiverType = protoTypeTableUtil.receiverType(nVar2, this.a.getTypeTable());
        if (qVarReceiverType == null || (kotlinTypeType = context6VarChildContext$default.getTypeDeserializer().type(qVarReceiverType)) == null) {
            receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = null;
            deserializedMemberDescriptor4 = deserializedMemberDescriptor5;
        } else {
            deserializedMemberDescriptor4 = deserializedMemberDescriptor5;
            receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedMemberDescriptor4, kotlinTypeType, empty);
        }
        deserializedMemberDescriptor4.setType(kotlinTypeType2, ownTypeParameters, receiverParameterDescriptorF, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable);
        int accessorFlags = Flags2.getAccessorFlags(outline.u0(Flags2.f3412b, i, "HAS_ANNOTATIONS.get(flags)"), dVar2.get(i), dVar.get(i), false, false, false);
        if (zU0) {
            int getterFlags = nVar.hasGetterFlags() ? nVar.getGetterFlags() : accessorFlags;
            boolean zU1 = outline.u0(Flags2.I, getterFlags, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean zU2 = outline.u0(Flags2.J, getterFlags, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean zU3 = outline.u0(Flags2.K, getterFlags, "IS_INLINE_ACCESSOR.get(getterFlags)");
            Annotations4 annotations4E2 = e(nVar2, getterFlags, annotatedCallableKind);
            if (zU1) {
                protoEnumFlags = protoEnumFlags2;
                propertyGetterDescriptorImplCreateDefaultGetter = new PropertyGetterDescriptorImpl(deserializedMemberDescriptor4, annotations4E2, protoEnumFlags2.modality(dVar.get(getterFlags)), ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags2, dVar2.get(getterFlags)), !zU1, zU2, zU3, deserializedMemberDescriptor4.getKind(), null, SourceElement.a);
            } else {
                protoEnumFlags = protoEnumFlags2;
                propertyGetterDescriptorImplCreateDefaultGetter = DescriptorFactory.createDefaultGetter(deserializedMemberDescriptor4, annotations4E2);
                Intrinsics3.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateDefaultGetter, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            propertyGetterDescriptorImplCreateDefaultGetter.initialize(deserializedMemberDescriptor4.getReturnType());
            propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateDefaultGetter;
        } else {
            protoEnumFlags = protoEnumFlags2;
            propertyGetterDescriptorImpl = null;
        }
        if (outline.u0(Flags2.f3415y, i, "HAS_SETTER.get(flags)")) {
            if (nVar.hasSetterFlags()) {
                accessorFlags = nVar.getSetterFlags();
            }
            boolean zU4 = outline.u0(Flags2.I, accessorFlags, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean zU5 = outline.u0(Flags2.J, accessorFlags, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean zU6 = outline.u0(Flags2.K, accessorFlags, "IS_INLINE_ACCESSOR.get(setterFlags)");
            AnnotatedCallableKind annotatedCallableKind3 = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations4 annotations4E3 = e(nVar2, accessorFlags, annotatedCallableKind3);
            if (zU4) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedMemberDescriptor4, annotations4E3, protoEnumFlags.modality(dVar.get(accessorFlags)), ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags, dVar2.get(accessorFlags)), !zU4, zU5, zU6, deserializedMemberDescriptor4.getKind(), null, SourceElement.a);
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) _Collections.single((List) context6.childContext$default(context6VarChildContext$default, propertySetterDescriptorImpl2, Collections2.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().h(CollectionsJVM.listOf(nVar.getSetterValueParameter()), nVar2, annotatedCallableKind3)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                PropertySetterDescriptorImpl propertySetterDescriptorImplCreateDefaultSetter = DescriptorFactory.createDefaultSetter(deserializedMemberDescriptor4, annotations4E3, Annotations4.f.getEMPTY());
                Intrinsics3.checkNotNullExpressionValue(propertySetterDescriptorImplCreateDefaultSetter, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
                propertySetterDescriptorImpl = propertySetterDescriptorImplCreateDefaultSetter;
            }
        } else {
            propertySetterDescriptorImpl = null;
        }
        if (outline.u0(Flags2.B, i, "HAS_CONSTANT.get(flags)")) {
            deserializedMemberDescriptor4.setCompileTimeInitializer(this.a.getStorageManager().createNullableLazyValue(new d(nVar2, deserializedMemberDescriptor4)));
        }
        deserializedMemberDescriptor4.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, new FieldDescriptorImpl(g(nVar2, false), deserializedMemberDescriptor4), new FieldDescriptorImpl(g(nVar2, true), deserializedMemberDescriptor4), b(deserializedMemberDescriptor4, context6VarChildContext$default.getTypeDeserializer()));
        return deserializedMemberDescriptor4;
    }

    public final TypeAliasDescriptor loadTypeAlias(d0.e0.p.d.m0.f.r rVar) {
        Intrinsics3.checkNotNullParameter(rVar, "proto");
        Annotations4.a aVar = Annotations4.f;
        List<d0.e0.p.d.m0.f.b> annotationList = rVar.getAnnotationList();
        Intrinsics3.checkNotNullExpressionValue(annotationList, "proto.annotationList");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(annotationList, 10));
        for (d0.e0.p.d.m0.f.b bVar : annotationList) {
            AnnotationDeserializer annotationDeserializer = this.f3508b;
            Intrinsics3.checkNotNullExpressionValue(bVar, "it");
            arrayList.add(annotationDeserializer.deserializeAnnotation(bVar, this.a.getNameResolver()));
        }
        DeserializedMemberDescriptor6 deserializedMemberDescriptor6 = new DeserializedMemberDescriptor6(this.a.getStorageManager(), this.a.getContainingDeclaration(), aVar.create(arrayList), NameResolverUtil.getName(this.a.getNameResolver(), rVar.getName()), ProtoEnumFlagsUtils.descriptorVisibility(ProtoEnumFlags.a, Flags2.c.get(rVar.getFlags())), rVar, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource());
        context6 context6Var = this.a;
        List<d0.e0.p.d.m0.f.s> typeParameterList = rVar.getTypeParameterList();
        Intrinsics3.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        context6 context6VarChildContext$default = context6.childContext$default(context6Var, deserializedMemberDescriptor6, typeParameterList, null, null, null, null, 60, null);
        deserializedMemberDescriptor6.initialize(context6VarChildContext$default.getTypeDeserializer().getOwnTypeParameters(), context6VarChildContext$default.getTypeDeserializer().simpleType(protoTypeTableUtil.underlyingType(rVar, this.a.getTypeTable()), false), context6VarChildContext$default.getTypeDeserializer().simpleType(protoTypeTableUtil.expandedType(rVar, this.a.getTypeTable()), false), b(deserializedMemberDescriptor6, context6VarChildContext$default.getTypeDeserializer()));
        return deserializedMemberDescriptor6;
    }
}
