package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.InclusionExclusionUtils;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes;
import lombok.eclipse.handlers.HandleBuilder;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSuperBuilder.SCL.lombok */
@HandlerPriority(-1024)
public class HandleSuperBuilder extends EclipseAnnotationHandler<SuperBuilder> {
    private static final char[] SELF_METHOD_NAME = "self".toCharArray();
    private static final char[] FILL_VALUES_METHOD_NAME = "$fillValuesFrom".toCharArray();
    private static final char[] FILL_VALUES_STATIC_METHOD_NAME = "$fillValuesFromInstanceIntoBuilder".toCharArray();
    private static final char[] INSTANCE_VARIABLE_NAME = "instance".toCharArray();
    private static final String BUILDER_VARIABLE_NAME_STRING = "b";
    private static final char[] BUILDER_VARIABLE_NAME = BUILDER_VARIABLE_NAME_STRING.toCharArray();
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult() {
        int[] iArr = $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[EclipseHandlerUtil.MemberExistsResult.valuesCustom().length];
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSuperBuilder$SuperBuilderJob.SCL.lombok */
    class SuperBuilderJob extends HandleBuilder.BuilderJob {
        EclipseNode builderAbstractType;
        String builderAbstractClassName;
        char[] builderAbstractClassNameArr;
        EclipseNode builderImplType;
        String builderImplClassName;
        char[] builderImplClassNameArr;
        private TypeParameter[] builderTypeParams_;

        SuperBuilderJob() {
        }

        void init(AnnotationValues<SuperBuilder> annValues, SuperBuilder ann, EclipseNode node) {
            AccessLevel accessLevel = AccessLevel.PUBLIC;
            this.accessInners = accessLevel;
            this.accessOuters = accessLevel;
            this.oldFluent = true;
            this.oldChain = true;
            this.builderMethodName = ann.builderMethodName();
            this.buildMethodName = ann.buildMethodName();
            this.toBuilder = ann.toBuilder();
            if (this.builderMethodName == null) {
                this.builderMethodName = "builder";
            }
            if (this.buildMethodName == null) {
                this.buildMethodName = "build";
            }
            this.builderClassName = fixBuilderClassName(node, "");
        }

        void setBuilderToImpl() {
            this.builderType = this.builderImplType;
            this.builderClassName = this.builderImplClassName;
            this.builderClassNameArr = this.builderImplClassNameArr;
            this.builderTypeParams = this.typeParams;
        }

        void setBuilderToAbstract() {
            this.builderType = this.builderAbstractType;
            this.builderClassName = this.builderAbstractClassName;
            this.builderClassNameArr = this.builderAbstractClassNameArr;
            this.builderTypeParams = this.builderTypeParams_;
        }
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<SuperBuilder> annotation, Annotation ast, EclipseNode annotationNode) {
        boolean generateBuilderMethod;
        EclipseSingularsRecipes.EclipseSingularizer singularizer;
        MethodDeclaration md;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.SUPERBUILDER_FLAG_USAGE, "@SuperBuilder");
        SuperBuilderJob job = new SuperBuilderJob();
        job.sourceNode = annotationNode;
        job.source = ast;
        job.checkerFramework = EclipseHandlerUtil.getCheckerFrameworkVersion(annotationNode);
        job.isStatic = true;
        SuperBuilder annInstance = (SuperBuilder) annotation.getInstance();
        job.init(annotation, annInstance, annotationNode);
        if (job.builderMethodName.isEmpty()) {
            generateBuilderMethod = false;
        } else if (!HandlerUtil.checkName("builderMethodName", job.builderMethodName, annotationNode)) {
            return;
        } else {
            generateBuilderMethod = true;
        }
        if (HandlerUtil.checkName("buildMethodName", job.buildMethodName, annotationNode)) {
            EclipseNode parent = annotationNode.up();
            job.builderFields = new ArrayList();
            boolean addCleaning = false;
            List<EclipseNode> nonFinalNonDefaultedFields = null;
            if (!(parent.get() instanceof TypeDeclaration)) {
                annotationNode.addError("@SuperBuilder is only supported on types.");
                return;
            }
            job.parentType = parent;
            TypeDeclaration td = parent.get();
            List<EclipseNode> allFields = new ArrayList<>();
            boolean valuePresent = EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Value.class, parent) || EclipseHandlerUtil.hasAnnotation("lombok.experimental.Value", parent);
            for (EclipseNode fieldNode : HandleConstructor.findAllFields(parent, true)) {
                FieldDeclaration fd = fieldNode.get();
                EclipseNode isDefault = EclipseHandlerUtil.findAnnotation(Builder.Default.class, fieldNode);
                boolean isFinal = (fd.modifiers & 16) != 0 || (valuePresent && !EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) NonFinal.class, fieldNode));
                Annotation[] copyableAnnotations = EclipseHandlerUtil.findCopyableAnnotations(fieldNode);
                HandleBuilder.BuilderFieldData bfd = new HandleBuilder.BuilderFieldData();
                bfd.rawName = fieldNode.getName().toCharArray();
                bfd.name = EclipseHandlerUtil.removePrefixFromField(fieldNode);
                bfd.builderFieldName = bfd.name;
                bfd.annotations = EclipseHandlerUtil.copyAnnotations(fd, copyableAnnotations);
                bfd.type = fd.type;
                bfd.singularData = getSingularData(fieldNode, ast, annInstance.setterPrefix());
                bfd.originalFieldNode = fieldNode;
                if (bfd.singularData != null && isDefault != null) {
                    isDefault.addError("@Builder.Default and @Singular cannot be mixed.");
                    isDefault = null;
                }
                if (fd.initialization == null && isDefault != null) {
                    isDefault.addWarning("@Builder.Default requires an initializing expression (' = something;').");
                    isDefault = null;
                }
                if (fd.initialization != null && isDefault == null) {
                    if (!isFinal) {
                        if (nonFinalNonDefaultedFields == null) {
                            nonFinalNonDefaultedFields = new ArrayList<>();
                        }
                        nonFinalNonDefaultedFields.add(fieldNode);
                    }
                }
                if (isDefault != null) {
                    bfd.nameOfDefaultProvider = prefixWith(HandleBuilder.DEFAULT_PREFIX, bfd.name);
                    bfd.nameOfSetFlag = prefixWith(bfd.name, HandleBuilder.SET_PREFIX);
                    bfd.builderFieldName = prefixWith(bfd.name, HandleBuilder.VALUE_PREFIX);
                    MethodDeclaration md2 = HandleBuilder.generateDefaultProvider(bfd.nameOfDefaultProvider, td.typeParameters, fieldNode, ast);
                    if (md2 != null) {
                        EclipseHandlerUtil.injectMethod(parent, md2);
                    }
                }
                addObtainVia(bfd, fieldNode);
                job.builderFields.add(bfd);
                allFields.add(fieldNode);
            }
            job.typeParams = td.typeParameters != null ? td.typeParameters : new TypeParameter[0];
            TypeReference buildMethodReturnType = job.createBuilderParentTypeReference();
            Set<String> usedNames = gatherUsedTypeNames(job.typeParams, td);
            String classGenericName = generateNonclashingNameFor("C", usedNames);
            String builderGenericName = generateNonclashingNameFor("B", usedNames);
            TypeParameter[] paddedTypeParameters = new TypeParameter[job.typeParams.length + 2];
            System.arraycopy(job.typeParams, 0, paddedTypeParameters, 0, job.typeParams.length);
            TypeParameter c = new TypeParameter();
            c.name = classGenericName.toCharArray();
            c.type = EclipseHandlerUtil.cloneSelfType(job.parentType, job.source);
            paddedTypeParameters[paddedTypeParameters.length - 2] = c;
            TypeParameter b2 = new TypeParameter();
            b2.name = builderGenericName.toCharArray();
            b2.type = EclipseHandlerUtil.cloneSelfType(job.parentType, job.source);
            paddedTypeParameters[paddedTypeParameters.length - 1] = b2;
            job.builderTypeParams_ = paddedTypeParameters;
            job.builderTypeParams = paddedTypeParameters;
            QualifiedTypeReference qualifiedTypeReference = td.superclass;
            ParameterizedQualifiedTypeReference parameterizedQualifiedTypeReference = null;
            TypeReference[] typeArguments = {new SingleTypeReference(classGenericName.toCharArray(), 0L), new SingleTypeReference(builderGenericName.toCharArray(), 0L)};
            if (qualifiedTypeReference instanceof QualifiedTypeReference) {
                QualifiedTypeReference qualifiedTypeReference2 = qualifiedTypeReference;
                String superclassClassName = String.valueOf(qualifiedTypeReference2.getLastToken());
                String superclassBuilderClassName = job.replaceBuilderClassName(superclassClassName);
                char[][] tokens = (char[][]) Arrays.copyOf(qualifiedTypeReference2.tokens, qualifiedTypeReference2.tokens.length + 1);
                tokens[tokens.length - 1] = superclassBuilderClassName.toCharArray();
                long[] poss = new long[tokens.length];
                Arrays.fill(poss, job.getPos());
                TypeReference[] superclassTypeArgs = getTypeParametersFrom(qualifiedTypeReference);
                TypeReference[][] typeArgsForTokens = new TypeReference[tokens.length][];
                typeArgsForTokens[typeArgsForTokens.length - 1] = mergeTypeReferences(superclassTypeArgs, typeArguments);
                parameterizedQualifiedTypeReference = new ParameterizedQualifiedTypeReference(tokens, typeArgsForTokens, 0, poss);
            } else if (qualifiedTypeReference != null) {
                String superClass = String.valueOf(qualifiedTypeReference.getTypeName()[0]);
                String superclassBuilderClassName2 = String.valueOf(superClass) + "Builder";
                char[][] tokens2 = {superClass.toCharArray(), superclassBuilderClassName2.toCharArray()};
                long[] poss2 = new long[tokens2.length];
                Arrays.fill(poss2, job.getPos());
                TypeReference[] superclassTypeArgs2 = getTypeParametersFrom(qualifiedTypeReference);
                TypeReference[][] typeArgsForTokens2 = new TypeReference[tokens2.length][];
                typeArgsForTokens2[typeArgsForTokens2.length - 1] = mergeTypeReferences(superclassTypeArgs2, typeArguments);
                parameterizedQualifiedTypeReference = new ParameterizedQualifiedTypeReference(tokens2, typeArgsForTokens2, 0, poss2);
            }
            String strReplaceBuilderClassName = job.replaceBuilderClassName(td.name);
            job.builderClassName = strReplaceBuilderClassName;
            job.builderAbstractClassName = strReplaceBuilderClassName;
            char[] charArray = job.builderAbstractClassName.toCharArray();
            job.builderClassNameArr = charArray;
            job.builderAbstractClassNameArr = charArray;
            job.builderImplClassName = String.valueOf(job.builderAbstractClassName) + "Impl";
            job.builderImplClassNameArr = job.builderImplClassName.toCharArray();
            if (!constructorExists(parent, job.builderClassName)) {
                generateBuilderBasedConstructor(job, parameterizedQualifiedTypeReference != null);
            }
            job.builderAbstractType = findInnerClass(parent, job.builderClassName);
            if (job.builderAbstractType == null) {
                job.builderAbstractType = generateBuilderAbstractClass(job, parameterizedQualifiedTypeReference, classGenericName, builderGenericName);
            } else {
                TypeDeclaration builderTypeDeclaration = job.builderAbstractType.get();
                if ((builderTypeDeclaration.modifiers & 1032) == 0) {
                    annotationNode.addError("Existing Builder must be an abstract static inner class.");
                    return;
                }
                EclipseHandlerUtil.sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(job.builderAbstractType, annotationNode);
                for (HandleBuilder.BuilderFieldData bfd2 : job.builderFields) {
                    EclipseSingularsRecipes.SingularData sd = bfd2.singularData;
                    if (sd != null && (singularizer = sd.getSingularizer()) != null && singularizer.checkForAlreadyExistingNodesAndGenerateError(job.builderAbstractType, sd)) {
                        bfd2.singularData = null;
                    }
                }
            }
            for (HandleBuilder.BuilderFieldData bfd3 : job.builderFields) {
                if (bfd3.singularData != null && bfd3.singularData.getSingularizer() != null && bfd3.singularData.getSingularizer().requiresCleaning()) {
                    addCleaning = true;
                    break;
                }
                if (bfd3.obtainVia != null) {
                    if (bfd3.obtainVia.field().isEmpty() == bfd3.obtainVia.method().isEmpty()) {
                        bfd3.obtainViaNode.addError("The syntax is either @ObtainVia(field = \"fieldName\") or @ObtainVia(method = \"methodName\").");
                        return;
                    } else if (bfd3.obtainVia.method().isEmpty() && bfd3.obtainVia.isStatic()) {
                        bfd3.obtainViaNode.addError("@ObtainVia(isStatic = true) is not valid unless 'method' has been set.");
                        return;
                    }
                }
            }
            job.setBuilderToAbstract();
            generateBuilderFields(job);
            if (addCleaning) {
                FieldDeclaration cleanDecl = new FieldDeclaration(HandleBuilder.CLEAN_FIELD_NAME, 0, -1);
                cleanDecl.declarationSourceEnd = -1;
                cleanDecl.modifiers = 2;
                cleanDecl.type = TypeReference.baseTypeReference(5, 0);
                EclipseHandlerUtil.injectFieldAndMarkGenerated(job.builderType, cleanDecl);
            }
            if (job.toBuilder) {
                EclipseHandlerUtil.injectMethod(job.builderType, generateFillValuesMethod(job, parameterizedQualifiedTypeReference != null, builderGenericName, classGenericName));
                EclipseHandlerUtil.injectMethod(job.builderType, generateStaticFillValuesMethod(job, annInstance.setterPrefix()));
            }
            EclipseHandlerUtil.injectMethod(job.builderType, generateAbstractSelfMethod(job, parameterizedQualifiedTypeReference != null, builderGenericName));
            job.setBuilderToAbstract();
            EclipseHandlerUtil.injectMethod(job.builderType, generateAbstractBuildMethod(job, parameterizedQualifiedTypeReference != null, classGenericName));
            Iterator<HandleBuilder.BuilderFieldData> it = job.builderFields.iterator();
            while (it.hasNext()) {
                generateSetterMethodsForBuilder(job, it.next(), builderGenericName, annInstance.setterPrefix());
            }
            if (EclipseHandlerUtil.methodExists("toString", job.builderType, 0) == EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                List<InclusionExclusionUtils.Included<EclipseNode, ToString.Include>> fieldNodes = new ArrayList<>();
                Iterator<HandleBuilder.BuilderFieldData> it2 = job.builderFields.iterator();
                while (it2.hasNext()) {
                    for (EclipseNode f : it2.next().createdFields) {
                        fieldNodes.add(new InclusionExclusionUtils.Included<>(f, null, true, false));
                    }
                }
                MethodDeclaration md3 = HandleToString.createToString(job.builderType, fieldNodes, true, parameterizedQualifiedTypeReference != null, ast, HandlerUtil.FieldAccess.ALWAYS_FIELD);
                if (md3 != null) {
                    EclipseHandlerUtil.injectMethod(job.builderType, md3);
                }
            }
            if (addCleaning) {
                job.setBuilderToAbstract();
                EclipseHandlerUtil.injectMethod(job.builderType, generateCleanMethod(job));
            }
            boolean isAbstract = (td.modifiers & 1024) != 0;
            if (isAbstract) {
                return;
            }
            job.builderImplType = findInnerClass(parent, job.builderImplClassName);
            if (job.builderImplType == null) {
                job.builderImplType = generateBuilderImplClass(job, job.builderImplClassName);
            } else {
                TypeDeclaration builderImplTypeDeclaration = job.builderImplType.get();
                if ((builderImplTypeDeclaration.modifiers & 1024) != 0 || (builderImplTypeDeclaration.modifiers & 8) == 0) {
                    annotationNode.addError("Existing BuilderImpl must be a non-abstract static inner class.");
                    return;
                }
                EclipseHandlerUtil.sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(job.builderImplType, annotationNode);
            }
            job.setBuilderToImpl();
            if (job.toBuilder) {
                switch ($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[EclipseHandlerUtil.methodExists("toBuilder", job.parentType, 0).ordinal()]) {
                    case 1:
                        EclipseHandlerUtil.injectMethod(parent, generateToBuilderMethod(job));
                        break;
                }
            }
            job.setBuilderToImpl();
            EclipseHandlerUtil.injectMethod(job.builderImplType, generateSelfMethod(job));
            if (EclipseHandlerUtil.methodExists(job.buildMethodName, job.builderImplType, -1) == EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                job.setBuilderToImpl();
                EclipseHandlerUtil.injectMethod(job.builderImplType, generateBuildMethod(job, buildMethodReturnType));
            }
            if (generateBuilderMethod && EclipseHandlerUtil.methodExists(job.builderMethodName, parent, -1) != EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                generateBuilderMethod = false;
            }
            if (generateBuilderMethod && (md = generateBuilderMethod(job)) != null) {
                EclipseHandlerUtil.injectMethod(parent, md);
            }
            if (nonFinalNonDefaultedFields != null && generateBuilderMethod) {
                Iterator<EclipseNode> it3 = nonFinalNonDefaultedFields.iterator();
                while (it3.hasNext()) {
                    it3.next().addWarning("@SuperBuilder will ignore the initializing expression entirely. If you want the initializing expression to serve as default, add @Builder.Default. If it is not supposed to be settable during building, make the field final.");
                }
            }
        }
    }

    private EclipseNode generateBuilderAbstractClass(HandleBuilder.BuilderJob job, TypeReference superclassBuilderClass, String classGenericName, String builderGenericName) {
        TypeDeclaration parent = job.parentType.get();
        TypeDeclaration builder = new TypeDeclaration(parent.compilationResult);
        builder.bits |= 8388608;
        builder.modifiers |= 1033;
        builder.name = job.builderClassNameArr;
        builder.typeParameters = (TypeParameter[]) Arrays.copyOf(EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source), job.typeParams.length + 2);
        TypeParameter o = new TypeParameter();
        o.name = classGenericName.toCharArray();
        o.type = EclipseHandlerUtil.cloneSelfType(job.parentType, job.source);
        builder.typeParameters[builder.typeParameters.length - 2] = o;
        TypeParameter o2 = new TypeParameter();
        o2.name = builderGenericName.toCharArray();
        TypeReference[] typerefs = appendBuilderTypeReferences(job.typeParams, classGenericName, builderGenericName);
        o2.type = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, typerefs, 0L);
        builder.typeParameters[builder.typeParameters.length - 1] = o2;
        if (superclassBuilderClass != null) {
            builder.superclass = EclipseHandlerUtil.copyType(superclassBuilderClass, job.source);
        }
        builder.createDefaultConstructor(false, true);
        builder.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return EclipseHandlerUtil.injectType(job.parentType, builder);
    }

    private EclipseNode generateBuilderImplClass(HandleBuilder.BuilderJob job, String builderImplClass) {
        TypeDeclaration parent = job.parentType.get();
        TypeDeclaration builder = new TypeDeclaration(parent.compilationResult);
        builder.bits |= 8388608;
        builder.modifiers |= 26;
        builder.name = builderImplClass.toCharArray();
        if (job.typeParams != null && job.typeParams.length > 0) {
            builder.typeParameters = EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source);
        }
        if (job.builderClassName != null) {
            TypeReference[] typeArgs = new TypeReference[job.typeParams.length + 2];
            for (int i = 0; i < job.typeParams.length; i++) {
                typeArgs[i] = new SingleTypeReference(job.typeParams[i].name, 0L);
            }
            typeArgs[typeArgs.length - 2] = EclipseHandlerUtil.cloneSelfType(job.parentType, job.source);
            typeArgs[typeArgs.length - 1] = createTypeReferenceWithTypeParameters(job.parentType, builderImplClass, job.typeParams);
            builder.superclass = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, typeArgs, 0L);
        }
        builder.createDefaultConstructor(false, true);
        builder.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return EclipseHandlerUtil.injectType(job.parentType, builder);
    }

    private void generateBuilderBasedConstructor(HandleBuilder.BuilderJob job, boolean callBuilderBasedSuperConstructor) {
        SingleNameReference qualifiedNameReference;
        Statement nullCheck;
        TypeDeclaration typeDeclaration = job.parentType.get();
        long p = job.getPos();
        ConstructorDeclaration constructor = new ConstructorDeclaration(job.parentType.top().get().compilationResult);
        constructor.modifiers = EclipseHandlerUtil.toEclipseModifier(AccessLevel.PROTECTED);
        constructor.selector = typeDeclaration.name;
        if (callBuilderBasedSuperConstructor) {
            constructor.constructorCall = new ExplicitConstructorCall(2);
            constructor.constructorCall.arguments = new Expression[]{new SingleNameReference(BUILDER_VARIABLE_NAME, p)};
        } else {
            constructor.constructorCall = new ExplicitConstructorCall(1);
        }
        constructor.constructorCall.sourceStart = job.source.sourceStart;
        constructor.constructorCall.sourceEnd = job.source.sourceEnd;
        constructor.thrownExceptions = null;
        constructor.typeParameters = null;
        constructor.bits |= 8388608;
        int i = job.source.sourceStart;
        constructor.sourceStart = i;
        constructor.declarationSourceStart = i;
        constructor.bodyStart = i;
        int i2 = job.source.sourceEnd;
        constructor.sourceEnd = i2;
        constructor.declarationSourceEnd = i2;
        constructor.bodyEnd = i2;
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        TypeReference builderType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), p);
        constructor.arguments = new Argument[]{new Argument(BUILDER_VARIABLE_NAME, p, builderType, 16)};
        List<Statement> statements = new ArrayList<>();
        for (HandleBuilder.BuilderFieldData fieldNode : job.builderFields) {
            FieldReference fieldInThis = new FieldReference(fieldNode.rawName, p);
            int s2 = (int) (p >> 32);
            int e = (int) p;
            fieldInThis.receiver = new ThisReference(s2, e);
            if (fieldNode.singularData != null && fieldNode.singularData.getSingularizer() != null) {
                fieldNode.singularData.getSingularizer().appendBuildCode(fieldNode.singularData, job.parentType, statements, fieldNode.builderFieldName, BUILDER_VARIABLE_NAME_STRING);
                qualifiedNameReference = new SingleNameReference(fieldNode.builderFieldName, p);
            } else {
                char[][] variableInBuilder = {BUILDER_VARIABLE_NAME, fieldNode.builderFieldName};
                long[] positions = {p, p};
                qualifiedNameReference = new QualifiedNameReference(variableInBuilder, positions, s2, e);
            }
            Assignment assignment = new Assignment(fieldInThis, qualifiedNameReference, (int) p);
            if (fieldNode.nameOfSetFlag != null) {
                char[][] setVariableInBuilder = {BUILDER_VARIABLE_NAME, fieldNode.nameOfSetFlag};
                long[] positions2 = {p, p};
                QualifiedNameReference setVariableInBuilderRef = new QualifiedNameReference(setVariableInBuilder, positions2, s2, e);
                MessageSend defaultMethodCall = new MessageSend();
                defaultMethodCall.sourceStart = job.source.sourceStart;
                defaultMethodCall.sourceEnd = job.source.sourceEnd;
                defaultMethodCall.receiver = EclipseHandlerUtil.generateNameReference(job.parentType, 0L);
                defaultMethodCall.selector = fieldNode.nameOfDefaultProvider;
                defaultMethodCall.typeArguments = typeParameterNames(job.parentType.get().typeParameters);
                IfStatement ifBlockForDefault = new IfStatement(setVariableInBuilderRef, assignment, new Assignment(fieldInThis, defaultMethodCall, (int) p), s2, e);
                statements.add(ifBlockForDefault);
            } else {
                statements.add(assignment);
            }
            if (EclipseHandlerUtil.hasNonNullAnnotations(fieldNode.originalFieldNode) && (nullCheck = EclipseHandlerUtil.generateNullCheck(fieldNode.originalFieldNode.get(), job.sourceNode, null)) != null) {
                statements.add(nullCheck);
            }
        }
        constructor.statements = statements.isEmpty() ? null : (Statement[]) statements.toArray(new Statement[0]);
        constructor.traverse(new SetGeneratedByVisitor(job.source), typeDeclaration.scope);
        EclipseHandlerUtil.injectMethod(job.parentType, constructor);
    }

    private MethodDeclaration generateBuilderMethod(SuperBuilderJob job) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = job.builderMethodName.toCharArray();
        out.modifiers = 9;
        out.bits |= 8388608;
        if (job.typeParams != null && job.typeParams.length > 0) {
            out.typeParameters = EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source);
        }
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        out.returnType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderAbstractClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), p);
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len][];
            out.returnType.annotations[len - 1] = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE)};
        }
        AllocationExpression invoke = new AllocationExpression();
        invoke.type = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(job.parentType, job.builderImplClassNameArr, false, job.typeParams, p);
        out.statements = new Statement[]{new ReturnStatement(invoke, pS, pE)};
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.parentType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.parentType.get().scope);
        return out;
    }

    private MethodDeclaration generateToBuilderMethod(SuperBuilderJob job) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = HandleBuilder.TO_BUILDER_METHOD_NAME;
        out.modifiers = 1;
        out.bits |= 8388608;
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        out.returnType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderAbstractClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), p);
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len][];
            out.returnType.annotations[len - 1] = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE)};
        }
        AllocationExpression newClass = new AllocationExpression();
        newClass.type = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(job.parentType, job.builderImplClassNameArr, false, job.typeParams, p);
        MessageSend invokeFillMethod = new MessageSend();
        invokeFillMethod.receiver = newClass;
        invokeFillMethod.selector = FILL_VALUES_METHOD_NAME;
        invokeFillMethod.arguments = new Expression[]{new ThisReference(0, 0)};
        out.statements = new Statement[]{new ReturnStatement(invokeFillMethod, pS, pE)};
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.parentType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.parentType.get().scope);
        return out;
    }

    private MethodDeclaration generateFillValuesMethod(SuperBuilderJob job, boolean inherited, String builderGenericName, String classGenericName) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = FILL_VALUES_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 4;
        if (inherited) {
            out.annotations = new Annotation[]{EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.parentType.get())};
        }
        out.returnType = new SingleTypeReference(builderGenericName.toCharArray(), 0L);
        out.arguments = new Argument[]{new Argument(INSTANCE_VARIABLE_NAME, 0L, new SingleTypeReference(classGenericName.toCharArray(), 0L), 16)};
        List<Statement> body = new ArrayList<>();
        if (inherited) {
            MessageSend callToSuper = new MessageSend();
            callToSuper.receiver = new SuperReference(0, 0);
            callToSuper.selector = FILL_VALUES_METHOD_NAME;
            callToSuper.arguments = new Expression[]{new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L)};
            body.add(callToSuper);
        }
        MessageSend callStaticFillValuesMethod = new MessageSend();
        callStaticFillValuesMethod.receiver = EclipseHandlerUtil.generateNameReference(job.parentType, job.builderAbstractClassNameArr, 0L);
        callStaticFillValuesMethod.selector = FILL_VALUES_STATIC_METHOD_NAME;
        callStaticFillValuesMethod.arguments = new Expression[]{new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L), new ThisReference(0, 0)};
        body.add(callStaticFillValuesMethod);
        MessageSend returnCall = new MessageSend();
        returnCall.receiver = ThisReference.implicitThis();
        returnCall.selector = SELF_METHOD_NAME;
        body.add(new ReturnStatement(returnCall, 0, 0));
        out.statements = body.isEmpty() ? null : (Statement[]) body.toArray(new Statement[0]);
        return out;
    }

    private MethodDeclaration generateStaticFillValuesMethod(HandleBuilder.BuilderJob job, String setterPrefix) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = FILL_VALUES_STATIC_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 10;
        out.returnType = TypeReference.baseTypeReference(6, 0);
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        TypeReference builderType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), 0L);
        Argument builderArgument = new Argument(BUILDER_VARIABLE_NAME, 0L, builderType, 16);
        TypeReference[] typerefs = null;
        if (job.typeParams.length > 0) {
            typerefs = new TypeReference[job.typeParams.length];
            for (int i = 0; i < job.typeParams.length; i++) {
                typerefs[i] = new SingleTypeReference(job.typeParams[i].name, 0L);
            }
        }
        long p = job.getPos();
        TypeReference parentArgument = typerefs == null ? EclipseHandlerUtil.generateTypeReference(job.parentType, p) : EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, typerefs, p);
        out.arguments = new Argument[]{new Argument(INSTANCE_VARIABLE_NAME, 0L, parentArgument, 16), builderArgument};
        if (job.typeParams.length > 0) {
            out.typeParameters = EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source);
        }
        List<Statement> body = new ArrayList<>();
        for (HandleBuilder.BuilderFieldData bfd : job.builderFields) {
            MessageSend exec = createSetterCallWithInstanceValue(bfd, job.parentType, job.source, setterPrefix);
            body.add(exec);
        }
        out.statements = body.isEmpty() ? null : (Statement[]) body.toArray(new Statement[0]);
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
    }

    private MessageSend createSetterCallWithInstanceValue(HandleBuilder.BuilderFieldData bfd, EclipseNode type, ASTNode source, String setterPrefix) {
        char[] setterName = HandlerUtil.buildAccessorName(setterPrefix, String.valueOf(bfd.name)).toCharArray();
        MessageSend ms = new MessageSend();
        Expression[] tgt = new Expression[bfd.singularData == null ? 1 : 2];
        if (bfd.obtainVia == null || !bfd.obtainVia.field().isEmpty()) {
            char[] fieldName = bfd.obtainVia == null ? bfd.rawName : bfd.obtainVia.field().toCharArray();
            for (int i = 0; i < tgt.length; i++) {
                FieldReference fr = new FieldReference(fieldName, 0L);
                fr.receiver = new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L);
                tgt[i] = fr;
            }
        } else {
            String obtainName = bfd.obtainVia.method();
            boolean obtainIsStatic = bfd.obtainVia.isStatic();
            for (int i2 = 0; i2 < tgt.length; i2++) {
                MessageSend obtainExpr = new MessageSend();
                obtainExpr.receiver = obtainIsStatic ? EclipseHandlerUtil.generateNameReference(type, 0L) : new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L);
                obtainExpr.selector = obtainName.toCharArray();
                if (obtainIsStatic) {
                    obtainExpr.arguments = new Expression[]{new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L)};
                }
                tgt[i2] = obtainExpr;
            }
        }
        if (bfd.singularData == null) {
            ms.arguments = tgt;
        } else {
            EqualExpression equalExpression = new EqualExpression(tgt[0], new NullLiteral(0, 0), 18);
            MessageSend emptyCollection = new MessageSend();
            emptyCollection.receiver = EclipseHandlerUtil.generateQualifiedNameRef(source, bfd.singularData.getSingularizer().getEmptyMakerReceiver(bfd.singularData.getTargetFqn()));
            emptyCollection.selector = bfd.singularData.getSingularizer().getEmptyMakerSelector(bfd.singularData.getTargetFqn());
            ms.arguments = new Expression[]{new ConditionalExpression(equalExpression, emptyCollection, tgt[1])};
        }
        ms.receiver = new SingleNameReference(BUILDER_VARIABLE_NAME, 0L);
        ms.selector = setterName;
        return ms;
    }

    private MethodDeclaration generateAbstractSelfMethod(HandleBuilder.BuilderJob job, boolean override, String builderGenericName) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = SELF_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 16778244;
        MarkerAnnotation markerAnnotationMakeMarkerAnnotation = override ? EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.parentType.get()) : null;
        MarkerAnnotation markerAnnotationGenerateNamedAnnotation = job.checkerFramework.generateReturnsReceiver() ? EclipseHandlerUtil.generateNamedAnnotation(job.parentType.get(), CheckerFrameworkVersion.NAME__RETURNS_RECEIVER) : null;
        MarkerAnnotation markerAnnotationGenerateNamedAnnotation2 = job.checkerFramework.generatePure() ? EclipseHandlerUtil.generateNamedAnnotation(job.parentType.get(), CheckerFrameworkVersion.NAME__PURE) : null;
        if (markerAnnotationMakeMarkerAnnotation != null && markerAnnotationGenerateNamedAnnotation != null && markerAnnotationGenerateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{markerAnnotationMakeMarkerAnnotation, markerAnnotationGenerateNamedAnnotation, markerAnnotationGenerateNamedAnnotation2};
        } else if (markerAnnotationMakeMarkerAnnotation != null && markerAnnotationGenerateNamedAnnotation != null) {
            out.annotations = new Annotation[]{markerAnnotationMakeMarkerAnnotation, markerAnnotationGenerateNamedAnnotation};
        } else if (markerAnnotationMakeMarkerAnnotation != null && markerAnnotationGenerateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{markerAnnotationMakeMarkerAnnotation, markerAnnotationGenerateNamedAnnotation2};
        } else if (markerAnnotationMakeMarkerAnnotation != null) {
            out.annotations = new Annotation[]{markerAnnotationMakeMarkerAnnotation};
        } else if (markerAnnotationGenerateNamedAnnotation != null && markerAnnotationGenerateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{markerAnnotationGenerateNamedAnnotation, markerAnnotationGenerateNamedAnnotation2};
        } else if (markerAnnotationGenerateNamedAnnotation != null) {
            out.annotations = new Annotation[]{markerAnnotationGenerateNamedAnnotation};
        } else if (markerAnnotationGenerateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{markerAnnotationGenerateNamedAnnotation2};
        }
        out.returnType = new SingleTypeReference(builderGenericName.toCharArray(), 0L);
        return out;
    }

    private MethodDeclaration generateSelfMethod(HandleBuilder.BuilderJob job) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = SELF_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 4;
        Annotation overrideAnn = EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.builderType.get());
        MarkerAnnotation markerAnnotationGenerateNamedAnnotation = job.checkerFramework.generateReturnsReceiver() ? EclipseHandlerUtil.generateNamedAnnotation(job.builderType.get(), CheckerFrameworkVersion.NAME__RETURNS_RECEIVER) : null;
        MarkerAnnotation markerAnnotationGenerateNamedAnnotation2 = job.checkerFramework.generatePure() ? EclipseHandlerUtil.generateNamedAnnotation(job.builderType.get(), CheckerFrameworkVersion.NAME__PURE) : null;
        if (markerAnnotationGenerateNamedAnnotation != null && markerAnnotationGenerateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{overrideAnn, markerAnnotationGenerateNamedAnnotation, markerAnnotationGenerateNamedAnnotation2};
        } else if (markerAnnotationGenerateNamedAnnotation != null) {
            out.annotations = new Annotation[]{overrideAnn, markerAnnotationGenerateNamedAnnotation};
        } else if (markerAnnotationGenerateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{overrideAnn, markerAnnotationGenerateNamedAnnotation2};
        } else {
            out.annotations = new Annotation[]{overrideAnn};
        }
        out.returnType = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(job.builderType, job.typeParams, job.getPos());
        out.statements = new Statement[]{new ReturnStatement(new ThisReference(0, 0), 0, 0)};
        return out;
    }

    private MethodDeclaration generateAbstractBuildMethod(HandleBuilder.BuilderJob job, boolean override, String classGenericName) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.bits |= 8388608;
        out.modifiers = 16778241;
        out.selector = job.buildMethodName.toCharArray();
        out.bits |= 8388608;
        out.returnType = new SingleTypeReference(classGenericName.toCharArray(), 0L);
        MarkerAnnotation markerAnnotationMakeMarkerAnnotation = override ? EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.source) : null;
        MarkerAnnotation markerAnnotationGenerateNamedAnnotation = job.checkerFramework.generateSideEffectFree() ? EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE) : null;
        if (markerAnnotationMakeMarkerAnnotation != null && markerAnnotationGenerateNamedAnnotation != null) {
            out.annotations = new Annotation[]{markerAnnotationMakeMarkerAnnotation, markerAnnotationGenerateNamedAnnotation};
        } else if (markerAnnotationMakeMarkerAnnotation != null) {
            out.annotations = new Annotation[]{markerAnnotationMakeMarkerAnnotation};
        } else if (markerAnnotationGenerateNamedAnnotation != null) {
            out.annotations = new Annotation[]{markerAnnotationGenerateNamedAnnotation};
        }
        out.receiver = HandleBuilder.generateBuildReceiver(job);
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
    }

    private MethodDeclaration generateBuildMethod(HandleBuilder.BuilderJob job, TypeReference returnType) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.bits |= 8388608;
        List<Statement> statements = new ArrayList<>();
        out.modifiers = 1;
        out.selector = job.buildMethodName.toCharArray();
        out.bits |= 8388608;
        out.returnType = returnType;
        Annotation overrideAnn = EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.source);
        MarkerAnnotation markerAnnotationGenerateNamedAnnotation = job.checkerFramework.generateSideEffectFree() ? EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE) : null;
        if (markerAnnotationGenerateNamedAnnotation != null) {
            out.annotations = new Annotation[]{overrideAnn, markerAnnotationGenerateNamedAnnotation};
        } else {
            out.annotations = new Annotation[]{overrideAnn};
        }
        AllocationExpression allocationStatement = new AllocationExpression();
        allocationStatement.type = EclipseHandlerUtil.copyType(out.returnType);
        allocationStatement.arguments = new Expression[]{new ThisReference(0, 0)};
        statements.add(new ReturnStatement(allocationStatement, 0, 0));
        out.statements = statements.isEmpty() ? null : (Statement[]) statements.toArray(new Statement[0]);
        out.receiver = HandleBuilder.generateBuildReceiver(job);
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.builderType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
    }

    private MethodDeclaration generateCleanMethod(HandleBuilder.BuilderJob job) {
        List<Statement> statements = new ArrayList<>();
        for (HandleBuilder.BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendCleaningCode(bfd.singularData, job.builderType, statements);
            }
        }
        FieldReference thisUnclean = new FieldReference(HandleBuilder.CLEAN_FIELD_NAME, 0L);
        thisUnclean.receiver = new ThisReference(0, 0);
        statements.add(new Assignment(thisUnclean, new FalseLiteral(0, 0), 0));
        MethodDeclaration decl = job.createNewMethodDeclaration();
        decl.selector = HandleBuilder.CLEAN_METHOD_NAME;
        decl.modifiers = 2;
        decl.bits |= 8388608;
        decl.returnType = TypeReference.baseTypeReference(6, 0);
        decl.statements = (Statement[]) statements.toArray(new Statement[0]);
        decl.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return decl;
    }

    private void generateBuilderFields(HandleBuilder.BuilderJob job) {
        List<EclipseNode> existing = new ArrayList<>();
        for (EclipseNode child : job.builderType.down()) {
            if (child.getKind() == AST.Kind.FIELD) {
                existing.add(child);
            }
        }
        for (HandleBuilder.BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.createdFields.addAll(bfd.singularData.getSingularizer().generateFields(bfd.singularData, job.builderType));
            } else {
                EclipseNode field = null;
                EclipseNode setFlag = null;
                for (EclipseNode exists : existing) {
                    char[] n = exists.get().name;
                    if (Arrays.equals(n, bfd.builderFieldName)) {
                        field = exists;
                    }
                    if (bfd.nameOfSetFlag != null && Arrays.equals(n, bfd.nameOfSetFlag)) {
                        setFlag = exists;
                    }
                }
                if (field == null) {
                    FieldDeclaration fd = new FieldDeclaration(bfd.builderFieldName, 0, 0);
                    fd.bits |= 8388608;
                    fd.modifiers = 2;
                    fd.type = EclipseHandlerUtil.copyType(bfd.type);
                    fd.traverse(new SetGeneratedByVisitor(job.source), (MethodScope) null);
                    field = EclipseHandlerUtil.injectFieldAndMarkGenerated(job.builderType, fd);
                }
                if (setFlag == null && bfd.nameOfSetFlag != null) {
                    FieldDeclaration fd2 = new FieldDeclaration(bfd.nameOfSetFlag, 0, 0);
                    fd2.bits |= 8388608;
                    fd2.modifiers = 2;
                    fd2.type = TypeReference.baseTypeReference(5, 0);
                    fd2.traverse(new SetGeneratedByVisitor(job.source), (MethodScope) null);
                    EclipseHandlerUtil.injectFieldAndMarkGenerated(job.builderType, fd2);
                }
                bfd.createdFields.add(field);
            }
        }
    }

    private void generateSetterMethodsForBuilder(HandleBuilder.BuilderJob job, HandleBuilder.BuilderFieldData bfd, final String builderGenericName, String setterPrefix) {
        boolean deprecate = EclipseHandlerUtil.isFieldDeprecated(bfd.originalFieldNode);
        EclipseSingularsRecipes.TypeReferenceMaker returnTypeMaker = new EclipseSingularsRecipes.TypeReferenceMaker() { // from class: lombok.eclipse.handlers.HandleSuperBuilder.1
            @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.TypeReferenceMaker
            public TypeReference make() {
                return new SingleTypeReference(builderGenericName.toCharArray(), 0L);
            }
        };
        EclipseSingularsRecipes.StatementMaker returnStatementMaker = new EclipseSingularsRecipes.StatementMaker() { // from class: lombok.eclipse.handlers.HandleSuperBuilder.2
            @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.StatementMaker
            /* JADX INFO: renamed from: make, reason: merged with bridge method [inline-methods] */
            public ReturnStatement mo186make() {
                MessageSend returnCall = new MessageSend();
                returnCall.receiver = ThisReference.implicitThis();
                returnCall.selector = HandleSuperBuilder.SELF_METHOD_NAME;
                return new ReturnStatement(returnCall, 0, 0);
            }
        };
        if (bfd.singularData == null || bfd.singularData.getSingularizer() == null) {
            generateSimpleSetterMethodForBuilder(job, deprecate, bfd.createdFields.get(0), bfd.name, bfd.nameOfSetFlag, returnTypeMaker.make(), returnStatementMaker.mo186make(), bfd.annotations, bfd.originalFieldNode, setterPrefix);
        } else {
            bfd.singularData.getSingularizer().generateMethods(job.checkerFramework, bfd.singularData, deprecate, job.builderType, true, returnTypeMaker, returnStatementMaker, AccessLevel.PUBLIC);
        }
    }

    private void generateSimpleSetterMethodForBuilder(HandleBuilder.BuilderJob job, boolean deprecate, EclipseNode fieldNode, char[] paramName, char[] nameOfSetFlag, TypeReference returnType, Statement returnStatement, Annotation[] annosOnParam, EclipseNode originalFieldNode, String setterPrefix) {
        TypeDeclaration td = job.builderType.get();
        AbstractMethodDeclaration[] existing = td.methods;
        if (existing == null) {
            existing = HandleBuilder.EMPTY_METHODS;
        }
        int len = existing.length;
        String setterName = HandlerUtil.buildAccessorName(setterPrefix, new String(paramName));
        for (int i = 0; i < len; i++) {
            if (existing[i] instanceof MethodDeclaration) {
                char[] existingName = existing[i].selector;
                if (Arrays.equals(setterName.toCharArray(), existingName) && !EclipseHandlerUtil.isTolerate(fieldNode, existing[i])) {
                    return;
                }
            }
        }
        List<Annotation> methodAnnsList = Arrays.asList(EclipseHandlerUtil.findCopyableToSetterAnnotations(originalFieldNode));
        if (job.checkerFramework.generateReturnsReceiver()) {
            methodAnnsList = new ArrayList<>(methodAnnsList);
            methodAnnsList.add(EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER));
        }
        MethodDeclaration setter = HandleSetter.createSetter(td, deprecate, fieldNode, setterName, paramName, nameOfSetFlag, returnType, returnStatement, 1, job.sourceNode, methodAnnsList, annosOnParam != null ? Arrays.asList(EclipseHandlerUtil.copyAnnotations(job.source, annosOnParam)) : Collections.emptyList());
        if (job.checkerFramework.generateCalledMethods()) {
            setter.receiver = HandleBuilder.generateNotCalledReceiver(job, setterName);
        }
        EclipseHandlerUtil.injectMethod(job.builderType, setter);
    }

    private void addObtainVia(HandleBuilder.BuilderFieldData bfd, EclipseNode node) {
        for (EclipseNode child : node.down()) {
            if (EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Builder.ObtainVia.class, child)) {
                AnnotationValues<Builder.ObtainVia> ann = EclipseHandlerUtil.createAnnotation(Builder.ObtainVia.class, child);
                bfd.obtainVia = ann.getInstance();
                bfd.obtainViaNode = child;
                return;
            }
        }
    }

    private EclipseSingularsRecipes.SingularData getSingularData(EclipseNode node, ASTNode source, String setterPrefix) {
        String typeName;
        for (EclipseNode child : node.down()) {
            if (EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Singular.class, child)) {
                char[] pluralName = node.getKind() == AST.Kind.FIELD ? EclipseHandlerUtil.removePrefixFromField(node) : node.get().name;
                AnnotationValues<Singular> ann = EclipseHandlerUtil.createAnnotation(Singular.class, child);
                Singular singularInstance = ann.getInstance();
                String explicitSingular = singularInstance.value();
                if (explicitSingular.isEmpty()) {
                    if (Boolean.FALSE.equals(node.getAst().readConfiguration(ConfigurationKeys.SINGULAR_AUTO))) {
                        node.addError("The singular must be specified explicitly (e.g. @Singular(\"task\")) because auto singularization is disabled.");
                        explicitSingular = new String(pluralName);
                    } else {
                        explicitSingular = HandlerUtil.autoSingularize(new String(pluralName));
                        if (explicitSingular == null) {
                            node.addError("Can't singularize this name; please specify the singular explicitly (i.e. @Singular(\"sheep\"))");
                            explicitSingular = new String(pluralName);
                        }
                    }
                }
                char[] singularName = explicitSingular.toCharArray();
                ParameterizedSingleTypeReference parameterizedSingleTypeReference = node.get().type;
                TypeReference[] typeArgs = null;
                if (parameterizedSingleTypeReference instanceof ParameterizedSingleTypeReference) {
                    typeArgs = parameterizedSingleTypeReference.typeArguments;
                    typeName = new String(parameterizedSingleTypeReference.token);
                } else if (parameterizedSingleTypeReference instanceof ParameterizedQualifiedTypeReference) {
                    TypeReference[][] tr = ((ParameterizedQualifiedTypeReference) parameterizedSingleTypeReference).typeArguments;
                    typeArgs = tr != null ? tr[tr.length - 1] : null;
                    char[][] tokens = ((ParameterizedQualifiedTypeReference) parameterizedSingleTypeReference).tokens;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tokens.length; i++) {
                        if (i > 0) {
                            sb.append(".");
                        }
                        sb.append(tokens[i]);
                    }
                    typeName = sb.toString();
                } else {
                    typeName = parameterizedSingleTypeReference.toString();
                }
                String targetFqn = EclipseSingularsRecipes.get().toQualified(typeName);
                EclipseSingularsRecipes.EclipseSingularizer singularizer = EclipseSingularsRecipes.get().getSingularizer(targetFqn);
                if (singularizer == null) {
                    node.addError("Lombok does not know how to create the singular-form builder methods for type '" + typeName + "'; they won't be generated.");
                    return null;
                }
                return new EclipseSingularsRecipes.SingularData(child, singularName, pluralName, typeArgs == null ? Collections.emptyList() : Arrays.asList(typeArgs), targetFqn, singularizer, source, singularInstance.ignoreNullCollections(), setterPrefix.toCharArray());
            }
        }
        return null;
    }

    private Set<String> gatherUsedTypeNames(TypeParameter[] typeParams, TypeDeclaration td) {
        HashSet<String> usedNames = new HashSet<>();
        for (TypeParameter typeParam : typeParams) {
            usedNames.add(typeParam.toString());
        }
        usedNames.add(String.valueOf(td.name));
        if (td.fields != null) {
            for (FieldDeclaration field : td.fields) {
                char[][] typeName = field.type.getTypeName();
                if (typeName.length >= 1) {
                    usedNames.add(String.valueOf(typeName[0]));
                }
            }
        }
        return usedNames;
    }

    private String generateNonclashingNameFor(String classGenericName, Set<String> typeParamStrings) {
        if (!typeParamStrings.contains(classGenericName)) {
            return classGenericName;
        }
        int counter = 2;
        while (typeParamStrings.contains(String.valueOf(classGenericName) + counter)) {
            counter++;
        }
        return String.valueOf(classGenericName) + counter;
    }

    private TypeReference[] appendBuilderTypeReferences(TypeParameter[] typeParams, String classGenericName, String builderGenericName) {
        TypeReference[] typeReferencesToAppend = new TypeReference[2];
        typeReferencesToAppend[typeReferencesToAppend.length - 2] = new SingleTypeReference(classGenericName.toCharArray(), 0L);
        typeReferencesToAppend[typeReferencesToAppend.length - 1] = new SingleTypeReference(builderGenericName.toCharArray(), 0L);
        return mergeToTypeReferences(typeParams, typeReferencesToAppend);
    }

    private TypeReference[] getTypeParametersFrom(TypeReference typeRef) {
        TypeReference[][] typeArgss = null;
        if (typeRef instanceof ParameterizedQualifiedTypeReference) {
            typeArgss = ((ParameterizedQualifiedTypeReference) typeRef).typeArguments;
        } else if (typeRef instanceof ParameterizedSingleTypeReference) {
            typeArgss = new TypeReference[][]{((ParameterizedSingleTypeReference) typeRef).typeArguments};
        }
        TypeReference[] typeArgs = new TypeReference[0];
        if (typeArgss != null && typeArgss.length > 0) {
            typeArgs = typeArgss[typeArgss.length - 1];
        }
        return typeArgs;
    }

    private static TypeReference createTypeReferenceWithTypeParameters(EclipseNode parent, String referenceName, TypeParameter[] typeParams) {
        if (typeParams.length > 0) {
            TypeReference[] typerefs = new TypeReference[typeParams.length];
            for (int i = 0; i < typeParams.length; i++) {
                typerefs[i] = new SingleTypeReference(typeParams[i].name, 0L);
            }
            return EclipseHandlerUtil.generateParameterizedTypeReference(parent, referenceName.toCharArray(), false, typerefs, 0L);
        }
        return EclipseHandlerUtil.generateTypeReference(parent, referenceName.toCharArray(), false, 0L);
    }

    private TypeReference[] mergeToTypeReferences(TypeParameter[] typeParams, TypeReference[] typeReferencesToAppend) {
        TypeReference[] typerefs = new TypeReference[typeParams.length + typeReferencesToAppend.length];
        for (int i = 0; i < typeParams.length; i++) {
            typerefs[i] = new SingleTypeReference(typeParams[i].name, 0L);
        }
        for (int i2 = 0; i2 < typeReferencesToAppend.length; i2++) {
            typerefs[typeParams.length + i2] = typeReferencesToAppend[i2];
        }
        return typerefs;
    }

    private TypeReference[] mergeTypeReferences(TypeReference[] refs1, TypeReference[] refs2) {
        TypeReference[] result = new TypeReference[refs1.length + refs2.length];
        for (int i = 0; i < refs1.length; i++) {
            result[i] = refs1[i];
        }
        for (int i2 = 0; i2 < refs2.length; i2++) {
            result[refs1.length + i2] = refs2[i2];
        }
        return result;
    }

    private TypeReference[] typeParameterNames(TypeParameter[] typeParameters) {
        if (typeParameters == null) {
            return null;
        }
        TypeReference[] trs = new TypeReference[typeParameters.length];
        for (int i = 0; i < trs.length; i++) {
            trs[i] = new SingleTypeReference(typeParameters[i].name, 0L);
        }
        return trs;
    }

    private EclipseNode findInnerClass(EclipseNode parent, String name) {
        char[] c = name.toCharArray();
        for (EclipseNode child : parent.down()) {
            if (child.getKind() == AST.Kind.TYPE) {
                TypeDeclaration td = child.get();
                if (Arrays.equals(td.name, c)) {
                    return child;
                }
            }
        }
        return null;
    }

    private static final char[] prefixWith(char[] prefix, char[] name) {
        char[] out = new char[prefix.length + name.length];
        System.arraycopy(prefix, 0, out, 0, prefix.length);
        System.arraycopy(name, 0, out, prefix.length, name.length);
        return out;
    }

    private boolean constructorExists(EclipseNode type, String builderClassName) {
        if (type != null && (type.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = type.get();
            if (typeDecl.methods != null) {
                for (AbstractMethodDeclaration def : typeDecl.methods) {
                    if ((def instanceof ConstructorDeclaration) && (def.bits & 128) == 0 && def.isConstructor() && !EclipseHandlerUtil.isTolerate(type, def) && def.arguments.length == 1) {
                        char[] typeName = def.arguments[0].type.getLastToken();
                        if (builderClassName.equals(String.valueOf(typeName))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
