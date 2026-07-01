package d0.e0.p.d.m0.l.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.functionTypes;
import d0.e0.p.d.m0.b.suspendFunctionTypes;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.protoTypeTableUtil;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.e0.DeserializedAnnotations;
import d0.e0.p.d.m0.l.b.e0.DeserializedTypeParameterDescriptor;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.SpecialTypes5;
import d0.e0.p.d.m0.n.StarProjectionImpl;
import d0.e0.p.d.m0.n.StarProjectionImpl2;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c0, reason: use source file name */
/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeDeserializer {
    public final context6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeDeserializer f3483b;
    public final String c;
    public final String d;
    public boolean e;
    public final Function1<Integer, ClassifierDescriptor> f;
    public final Function1<Integer, ClassifierDescriptor> g;
    public final Map<Integer, TypeParameterDescriptor> h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c0$a */
    /* JADX INFO: compiled from: TypeDeserializer.kt */
    public static final class a extends Lambda implements Function1<Integer, ClassifierDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final ClassifierDescriptor invoke(int i) {
            return TypeDeserializer.access$computeClassifierDescriptor(TypeDeserializer.this, i);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c0$b */
    /* JADX INFO: compiled from: TypeDeserializer.kt */
    public static final class b extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ d0.e0.p.d.m0.f.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0.e0.p.d.m0.f.q qVar) {
            super(0);
            this.$proto = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AnnotationDescriptor> invoke() {
            return TypeDeserializer.this.a.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.$proto, TypeDeserializer.this.a.getNameResolver());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c0$c */
    /* JADX INFO: compiled from: TypeDeserializer.kt */
    public static final class c extends Lambda implements Function1<Integer, ClassifierDescriptor> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final ClassifierDescriptor invoke(int i) {
            return TypeDeserializer.access$computeTypeAliasDescriptor(TypeDeserializer.this, i);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c0$d */
    /* JADX INFO: compiled from: TypeDeserializer.kt */
    public /* synthetic */ class d extends FunctionReference implements Function1<ClassId, ClassId> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ClassId.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final ClassId invoke(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "p0");
            return classId.getOuterClassId();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c0$e */
    /* JADX INFO: compiled from: TypeDeserializer.kt */
    public static final class e extends Lambda implements Function1<d0.e0.p.d.m0.f.q, d0.e0.p.d.m0.f.q> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final d0.e0.p.d.m0.f.q invoke(d0.e0.p.d.m0.f.q qVar) {
            Intrinsics3.checkNotNullParameter(qVar, "it");
            return protoTypeTableUtil.outerType(qVar, TypeDeserializer.this.a.getTypeTable());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c0$f */
    /* JADX INFO: compiled from: TypeDeserializer.kt */
    public static final class f extends Lambda implements Function1<d0.e0.p.d.m0.f.q, Integer> {
        public static final f j = new f();

        public f() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(d0.e0.p.d.m0.f.q qVar) {
            Intrinsics3.checkNotNullParameter(qVar, "it");
            return qVar.getArgumentCount();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(d0.e0.p.d.m0.f.q qVar) {
            return Integer.valueOf(invoke2(qVar));
        }
    }

    public TypeDeserializer(context6 context6Var, TypeDeserializer typeDeserializer, List<d0.e0.p.d.m0.f.s> list, String str, String str2, boolean z2) {
        Map<Integer, TypeParameterDescriptor> linkedHashMap;
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        Intrinsics3.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics3.checkNotNullParameter(str, "debugName");
        Intrinsics3.checkNotNullParameter(str2, "containerPresentableName");
        this.a = context6Var;
        this.f3483b = typeDeserializer;
        this.c = str;
        this.d = str2;
        this.e = z2;
        this.f = context6Var.getStorageManager().createMemoizedFunctionWithNullableValues(new a());
        this.g = context6Var.getStorageManager().createMemoizedFunctionWithNullableValues(new c());
        if (list.isEmpty()) {
            linkedHashMap = Maps6.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            for (d0.e0.p.d.m0.f.s sVar : list) {
                linkedHashMap.put(Integer.valueOf(sVar.getId()), new DeserializedTypeParameterDescriptor(this.a, sVar, i));
                i++;
            }
        }
        this.h = linkedHashMap;
    }

    public static final ClassifierDescriptor access$computeClassifierDescriptor(TypeDeserializer typeDeserializer, int i) {
        ClassId classId = NameResolverUtil.getClassId(typeDeserializer.a.getNameResolver(), i);
        return classId.isLocal() ? typeDeserializer.a.getComponents().deserializeClass(classId) : findClassInModule.findClassifierAcrossModuleDependencies(typeDeserializer.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final ClassifierDescriptor access$computeTypeAliasDescriptor(TypeDeserializer typeDeserializer, int i) {
        ClassId classId = NameResolverUtil.getClassId(typeDeserializer.a.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return findClassInModule.findTypeAliasAcrossModuleDependencies(typeDeserializer.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final List<q.b> c(d0.e0.p.d.m0.f.q qVar, TypeDeserializer typeDeserializer) {
        List<q.b> argumentList = qVar.getArgumentList();
        Intrinsics3.checkNotNullExpressionValue(argumentList, "argumentList");
        d0.e0.p.d.m0.f.q qVarOuterType = protoTypeTableUtil.outerType(qVar, typeDeserializer.a.getTypeTable());
        List<q.b> listC = qVarOuterType == null ? null : c(qVarOuterType, typeDeserializer);
        if (listC == null) {
            listC = Collections2.emptyList();
        }
        return _Collections.plus((Collection) argumentList, (Iterable) listC);
    }

    public static final ClassDescriptor d(TypeDeserializer typeDeserializer, d0.e0.p.d.m0.f.q qVar, int i) {
        ClassId classId = NameResolverUtil.getClassId(typeDeserializer.a.getNameResolver(), i);
        List<Integer> mutableList = _Sequences2.toMutableList(_Sequences2.map(d0.f0.n.generateSequence(qVar, typeDeserializer.new e()), f.j));
        int iCount = _Sequences2.count(d0.f0.n.generateSequence(classId, d.j));
        while (mutableList.size() < iCount) {
            mutableList.add(0);
        }
        return typeDeserializer.a.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    public static /* synthetic */ KotlinType4 simpleType$default(TypeDeserializer typeDeserializer, d0.e0.p.d.m0.f.q qVar, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return typeDeserializer.simpleType(qVar, z2);
    }

    public final KotlinType4 a(int i) {
        if (NameResolverUtil.getClassId(this.a.getNameResolver(), i).isLocal()) {
            return this.a.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    public final KotlinType4 b(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtils2.getBuiltIns(kotlinType);
        Annotations4 annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = functionTypes.getReceiverTypeFromFunctionType(kotlinType);
        List listDropLast = _Collections.dropLast(functionTypes.getValueParameterTypesFromFunctionType(kotlinType), 1);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listDropLast, 10));
        Iterator it = listDropLast.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeProjection) it.next()).getType());
        }
        return functionTypes.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    public final TypeConstructor e(int i) {
        TypeParameterDescriptor typeParameterDescriptor = this.h.get(Integer.valueOf(i));
        TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        TypeDeserializer typeDeserializer = this.f3483b;
        if (typeDeserializer == null) {
            return null;
        }
        return typeDeserializer.e(i);
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.e;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return _Collections.toList(this.h.values());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v42, types: [d0.e0.p.d.m0.c.h1.e] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v15, types: [d0.e0.p.d.m0.n.j0] */
    /* JADX WARN: Type inference failed for: r15v16, types: [d0.e0.p.d.m0.n.j0] */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    public final KotlinType4 simpleType(d0.e0.p.d.m0.f.q qVar, boolean z2) {
        TypeConstructor typeConstructorCreateErrorTypeConstructor;
        Object next;
        ?? SimpleType$default;
        int size;
        KotlinType4 kotlinType4WithAbbreviation;
        TypeProjection typeProjectionImpl;
        Intrinsics3.checkNotNullParameter(qVar, "proto");
        Object objSimpleType$default = null;
        KotlinType4 kotlinType4A = qVar.hasClassName() ? a(qVar.getClassName()) : qVar.hasTypeAliasName() ? a(qVar.getTypeAliasName()) : null;
        if (kotlinType4A != null) {
            return kotlinType4A;
        }
        if (qVar.hasClassName()) {
            ClassifierDescriptor classifierDescriptorInvoke = this.f.invoke(Integer.valueOf(qVar.getClassName()));
            if (classifierDescriptorInvoke == null) {
                classifierDescriptorInvoke = d(this, qVar, qVar.getClassName());
            }
            typeConstructorCreateErrorTypeConstructor = classifierDescriptorInvoke.getTypeConstructor();
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
        } else if (qVar.hasTypeParameter()) {
            typeConstructorCreateErrorTypeConstructor = e(qVar.getTypeParameter());
            if (typeConstructorCreateErrorTypeConstructor == null) {
                StringBuilder sbU = outline.U("Unknown type parameter ");
                sbU.append(qVar.getTypeParameter());
                sbU.append(". Please try recompiling module containing \"");
                sbU.append(this.d);
                sbU.append('\"');
                typeConstructorCreateErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor(sbU.toString());
                Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
            }
        } else if (qVar.hasTypeParameterName()) {
            DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
            String string = this.a.getNameResolver().getString(qVar.getTypeParameterName());
            Iterator it = getOwnTypeParameters().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics3.areEqual(((TypeParameterDescriptor) next).getName().asString(), string));
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) next;
            TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
            typeConstructorCreateErrorTypeConstructor = typeConstructor == null ? ErrorUtils.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + containingDeclaration) : typeConstructor;
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
        } else if (qVar.hasTypeAliasName()) {
            ClassifierDescriptor classifierDescriptorInvoke2 = this.g.invoke(Integer.valueOf(qVar.getTypeAliasName()));
            if (classifierDescriptorInvoke2 == null) {
                classifierDescriptorInvoke2 = d(this, qVar, qVar.getTypeAliasName());
            }
            typeConstructorCreateErrorTypeConstructor = classifierDescriptorInvoke2.getTypeConstructor();
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
        } else {
            typeConstructorCreateErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor("Unknown type");
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "createErrorTypeConstructor(\"Unknown type\")");
        }
        if (ErrorUtils.isError(typeConstructorCreateErrorTypeConstructor.getDeclarationDescriptor())) {
            KotlinType4 kotlinType4CreateErrorTypeWithCustomConstructor = ErrorUtils.createErrorTypeWithCustomConstructor(typeConstructorCreateErrorTypeConstructor.toString(), typeConstructorCreateErrorTypeConstructor);
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorTypeWithCustomConstructor, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return kotlinType4CreateErrorTypeWithCustomConstructor;
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.a.getStorageManager(), new b(qVar));
        List<q.b> listC = c(qVar, this);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listC, 10));
        int i = 0;
        for (Object obj : listC) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            q.b bVar = (q.b) obj;
            List<TypeParameterDescriptor> parameters = typeConstructorCreateErrorTypeConstructor.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "constructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) _Collections.getOrNull(parameters, i);
            if (bVar.getProjection() == q.b.c.STAR) {
                typeProjectionImpl = typeParameterDescriptor2 == null ? new StarProjectionImpl(this.a.getComponents().getModuleDescriptor().getBuiltIns()) : new StarProjectionImpl2(typeParameterDescriptor2);
            } else {
                ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.a;
                q.b.c projection = bVar.getProjection();
                Intrinsics3.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
                Variance variance = protoEnumFlags.variance(projection);
                d0.e0.p.d.m0.f.q qVarType = protoTypeTableUtil.type(bVar, this.a.getTypeTable());
                typeProjectionImpl = qVarType == null ? new TypeProjectionImpl(ErrorUtils.createErrorType("No type recorded")) : new TypeProjectionImpl(variance, type(qVarType));
            }
            arrayList.add(typeProjectionImpl);
            i = i2;
        }
        List list = _Collections.toList(arrayList);
        ClassifierDescriptor declarationDescriptor = typeConstructorCreateErrorTypeConstructor.getDeclarationDescriptor();
        boolean z3 = true;
        if (z2 && (declarationDescriptor instanceof TypeAliasDescriptor)) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            KotlinType4 kotlinType4ComputeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) declarationDescriptor, list);
            if (!KotlinType2.isNullable(kotlinType4ComputeExpandedType) && !qVar.getNullable()) {
                z3 = false;
            }
            SimpleType$default = kotlinType4ComputeExpandedType.makeNullableAsSpecified(z3).replaceAnnotations(Annotations4.f.create(_Collections.plus((Iterable) deserializedAnnotations, (Iterable) kotlinType4ComputeExpandedType.getAnnotations())));
        } else {
            Boolean bool = Flags2.a.get(qVar.getFlags());
            Intrinsics3.checkNotNullExpressionValue(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                boolean nullable = qVar.getNullable();
                int size2 = typeConstructorCreateErrorTypeConstructor.getParameters().size() - list.size();
                if (size2 == 0) {
                    KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.a;
                    KotlinType4 kotlinType4SimpleType$default = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructorCreateErrorTypeConstructor, list, nullable, null, 16, null);
                    if (functionTypes.isFunctionType(kotlinType4SimpleType$default)) {
                        boolean releaseCoroutines = this.a.getComponents().getConfiguration().getReleaseCoroutines();
                        TypeProjection typeProjection = (TypeProjection) _Collections.lastOrNull((List) functionTypes.getValueParameterTypesFromFunctionType(kotlinType4SimpleType$default));
                        KotlinType type = typeProjection == null ? null : typeProjection.getType();
                        if (type != null) {
                            ClassifierDescriptor declarationDescriptor2 = type.getConstructor().getDeclarationDescriptor();
                            FqName fqNameSafe = declarationDescriptor2 == null ? null : DescriptorUtils2.getFqNameSafe(declarationDescriptor2);
                            if (type.getArguments().size() == 1 && (suspendFunctionTypes.isContinuation(fqNameSafe, true) || suspendFunctionTypes.isContinuation(fqNameSafe, false))) {
                                KotlinType type2 = ((TypeProjection) _Collections.single((List) type.getArguments())).getType();
                                Intrinsics3.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
                                DeclarationDescriptor containingDeclaration2 = this.a.getContainingDeclaration();
                                if (!(containingDeclaration2 instanceof CallableDescriptor)) {
                                    containingDeclaration2 = null;
                                }
                                CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration2;
                                if (Intrinsics3.areEqual(callableDescriptor != null ? DescriptorUtils2.fqNameOrNull(callableDescriptor) : null, suspendFunctionTypeUtil.a)) {
                                    kotlinType4SimpleType$default = b(kotlinType4SimpleType$default, type2);
                                } else {
                                    if (!this.e && (!releaseCoroutines || !suspendFunctionTypes.isContinuation(fqNameSafe, !releaseCoroutines))) {
                                        z3 = false;
                                    }
                                    this.e = z3;
                                    kotlinType4SimpleType$default = b(kotlinType4SimpleType$default, type2);
                                }
                            }
                            objSimpleType$default = kotlinType4SimpleType$default;
                        }
                    }
                } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
                    KotlinTypeFactory kotlinTypeFactory3 = KotlinTypeFactory.a;
                    TypeConstructor typeConstructor2 = typeConstructorCreateErrorTypeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                    Intrinsics3.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
                    objSimpleType$default = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructor2, list, nullable, null, 16, null);
                }
                if (objSimpleType$default == null) {
                    KotlinType4 kotlinType4CreateErrorTypeWithArguments = ErrorUtils.createErrorTypeWithArguments(Intrinsics3.stringPlus("Bad suspend function in metadata with constructor: ", typeConstructorCreateErrorTypeConstructor), list);
                    Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorTypeWithArguments, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
                    SimpleType$default = kotlinType4CreateErrorTypeWithArguments;
                } else {
                    SimpleType$default = objSimpleType$default;
                }
            } else {
                KotlinTypeFactory kotlinTypeFactory4 = KotlinTypeFactory.a;
                SimpleType$default = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructorCreateErrorTypeConstructor, list, qVar.getNullable(), null, 16, null);
            }
        }
        d0.e0.p.d.m0.f.q qVarAbbreviatedType = protoTypeTableUtil.abbreviatedType(qVar, this.a.getTypeTable());
        ?? r15 = SimpleType$default;
        if (qVarAbbreviatedType != null && (kotlinType4WithAbbreviation = SpecialTypes5.withAbbreviation(SimpleType$default, simpleType(qVarAbbreviatedType, false))) != null) {
            r15 = SimpleType$default;
            r15 = kotlinType4WithAbbreviation;
        }
        r15 = SimpleType$default;
        return qVar.hasClassName() ? this.a.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtil.getClassId(this.a.getNameResolver(), qVar.getClassName()), r15) : r15;
    }

    public String toString() {
        String str = this.c;
        TypeDeserializer typeDeserializer = this.f3483b;
        return Intrinsics3.stringPlus(str, typeDeserializer == null ? "" : Intrinsics3.stringPlus(". Child of ", typeDeserializer.c));
    }

    public final KotlinType type(d0.e0.p.d.m0.f.q qVar) {
        Intrinsics3.checkNotNullParameter(qVar, "proto");
        if (!qVar.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(qVar, true);
        }
        String string = this.a.getNameResolver().getString(qVar.getFlexibleTypeCapabilitiesId());
        KotlinType4 kotlinType4SimpleType$default = simpleType$default(this, qVar, false, 2, null);
        d0.e0.p.d.m0.f.q qVarFlexibleUpperBound = protoTypeTableUtil.flexibleUpperBound(qVar, this.a.getTypeTable());
        Intrinsics3.checkNotNull(qVarFlexibleUpperBound);
        return this.a.getComponents().getFlexibleTypeDeserializer().create(qVar, string, kotlinType4SimpleType$default, simpleType$default(this, qVarFlexibleUpperBound, false, 2, null));
    }

    public /* synthetic */ TypeDeserializer(context6 context6Var, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context6Var, typeDeserializer, list, str, str2, (i & 32) != 0 ? false : z2);
    }
}
