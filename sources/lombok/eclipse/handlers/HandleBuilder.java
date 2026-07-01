package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes;
import lombok.eclipse.handlers.HandleConstructor;
import lombok.experimental.NonFinal;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Receiver;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.UnaryExpression;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleBuilder.SCL.lombok */
@HandlerPriority(-1024)
public class HandleBuilder extends EclipseAnnotationHandler<Builder> {
    private HandleConstructor handleConstructor = new HandleConstructor();
    static final char[] CLEAN_FIELD_NAME = "$lombokUnclean".toCharArray();
    static final char[] CLEAN_METHOD_NAME = "$lombokClean".toCharArray();
    static final String TO_BUILDER_METHOD_NAME_STRING = "toBuilder";
    static final char[] TO_BUILDER_METHOD_NAME = TO_BUILDER_METHOD_NAME_STRING.toCharArray();
    static final char[] DEFAULT_PREFIX = {'$', 'd', 'e', 'f', 'a', 'u', 'l', 't', '$'};
    static final char[] SET_PREFIX = {'$', 's', 'e', 't'};
    static final char[] VALUE_PREFIX = {'$', 'v', 'a', 'l', 'u', 'e'};
    static final char[] BUILDER_TEMP_VAR = {'b', 'u', 'i', 'l', 'd', 'e', 'r'};
    static final AbstractMethodDeclaration[] EMPTY_METHODS = new AbstractMethodDeclaration[0];
    static final String TO_BUILDER_NOT_SUPPORTED = "@Builder(toBuilder=true) is only supported if you return your own type.";
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

    private static final boolean toBoolean(Object expr, boolean defaultValue) {
        if (expr == null) {
            return defaultValue;
        }
        if (expr instanceof FalseLiteral) {
            return false;
        }
        if (expr instanceof TrueLiteral) {
            return true;
        }
        return ((Boolean) expr).booleanValue();
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleBuilder$BuilderJob.SCL.lombok */
    static class BuilderJob {
        CheckerFrameworkVersion checkerFramework;
        EclipseNode parentType;
        String builderMethodName;
        String buildMethodName;
        boolean isStatic;
        TypeParameter[] typeParams;
        TypeParameter[] builderTypeParams;
        ASTNode source;
        EclipseNode sourceNode;
        List<BuilderFieldData> builderFields;
        AccessLevel accessInners;
        AccessLevel accessOuters;
        boolean oldFluent;
        boolean oldChain;
        boolean toBuilder;
        EclipseNode builderType;
        String builderClassName;
        char[] builderClassNameArr;

        BuilderJob() {
        }

        void setBuilderClassName(String builderClassName) {
            this.builderClassName = builderClassName;
            this.builderClassNameArr = builderClassName.toCharArray();
        }

        TypeParameter[] copyTypeParams() {
            return EclipseHandlerUtil.copyTypeParams(this.typeParams, this.source);
        }

        long getPos() {
            return (((long) this.source.sourceStart) << 32) | ((long) this.source.sourceEnd);
        }

        public TypeReference createBuilderTypeReference() {
            return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.builderClassNameArr, !this.isStatic, this.builderTypeParams, getPos());
        }

        public TypeReference createBuilderTypeReferenceForceStatic() {
            return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.builderClassNameArr, false, this.builderTypeParams, getPos());
        }

        public TypeReference createBuilderParentTypeReference() {
            return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.typeParams, getPos());
        }

        public EclipseNode getTopNode() {
            return this.parentType.top();
        }

        void init(AnnotationValues<Builder> annValues, Builder ann, EclipseNode node) {
            this.accessOuters = ann.access();
            if (this.accessOuters == null) {
                this.accessOuters = AccessLevel.PUBLIC;
            }
            if (this.accessOuters == AccessLevel.NONE) {
                this.sourceNode.addError("AccessLevel.NONE is not valid here");
                this.accessOuters = AccessLevel.PUBLIC;
            }
            this.accessInners = this.accessOuters == AccessLevel.PROTECTED ? AccessLevel.PUBLIC : this.accessOuters;
            this.oldFluent = HandleBuilder.toBoolean(annValues.getActualExpression("fluent"), true);
            this.oldChain = HandleBuilder.toBoolean(annValues.getActualExpression("chain"), true);
            this.builderMethodName = ann.builderMethodName();
            this.buildMethodName = ann.buildMethodName();
            setBuilderClassName(fixBuilderClassName(node, ann.builderClassName()));
            this.toBuilder = ann.toBuilder();
            if (this.builderMethodName == null) {
                this.builderMethodName = "builder";
            }
            if (this.buildMethodName == null) {
                this.buildMethodName = "build";
            }
        }

        static String fixBuilderClassName(EclipseNode node, String override) {
            if (override != null && !override.isEmpty()) {
                return override;
            }
            String override2 = (String) node.getAst().readConfiguration(ConfigurationKeys.BUILDER_CLASS_NAME);
            return (override2 == null || override2.isEmpty()) ? "*Builder" : override2;
        }

        MethodDeclaration createNewMethodDeclaration() {
            return new MethodDeclaration(getTopNode().get().compilationResult);
        }

        String replaceBuilderClassName(char[] name) {
            return this.builderClassName.indexOf(42) == -1 ? this.builderClassName : this.builderClassName.replace("*", new String(name));
        }

        String replaceBuilderClassName(String name) {
            return this.builderClassName.replace("*", name);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleBuilder$BuilderFieldData.SCL.lombok */
    static class BuilderFieldData {
        Annotation[] annotations;
        TypeReference type;
        char[] rawName;
        char[] name;
        char[] builderFieldName;
        char[] nameOfDefaultProvider;
        char[] nameOfSetFlag;
        EclipseSingularsRecipes.SingularData singularData;
        Builder.ObtainVia obtainVia;
        EclipseNode obtainViaNode;
        EclipseNode originalFieldNode;
        List<EclipseNode> createdFields = new ArrayList();

        BuilderFieldData() {
        }
    }

    private static boolean equals(String a, char[] b2) {
        if (a.length() != b2.length) {
            return false;
        }
        for (int i = 0; i < b2.length; i++) {
            if (a.charAt(i) != b2[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean equals(String a, char[][] b2) {
        if (a == null || a.isEmpty()) {
            return b2.length == 0;
        }
        String[] aParts = a.split("\\.");
        if (aParts.length != b2.length) {
            return false;
        }
        for (int i = 0; i < b2.length; i++) {
            if (!equals(aParts[i], b2[i])) {
                return false;
            }
        }
        return true;
    }

    private static final char[] prefixWith(char[] prefix, char[] name) {
        char[] out = new char[prefix.length + name.length];
        System.arraycopy(prefix, 0, out, 0, prefix.length);
        System.arraycopy(name, 0, out, prefix.length, name.length);
        return out;
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Builder> annotation, Annotation ast, EclipseNode annotationNode) {
        boolean generateBuilderMethod;
        TypeReference buildMethodReturnType;
        TypeReference[] buildMethodThrownExceptions;
        char[] nameOfBuilderMethod;
        char[] token;
        EclipseSingularsRecipes.EclipseSingularizer singularizer;
        MethodDeclaration md;
        MethodDeclaration cleanMethod;
        MethodDeclaration md2;
        ConstructorDeclaration cd;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.BUILDER_FLAG_USAGE, "@Builder");
        BuilderJob job = new BuilderJob();
        job.sourceNode = annotationNode;
        job.source = ast;
        job.checkerFramework = EclipseHandlerUtil.getCheckerFrameworkVersion(annotationNode);
        job.isStatic = true;
        Builder annInstance = (Builder) annotation.getInstance();
        job.init(annotation, annInstance, annotationNode);
        List<char[]> typeArgsForToBuilder = null;
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
            EclipseNode fillParametersFrom = parent.get() instanceof AbstractMethodDeclaration ? parent : null;
            boolean addCleaning = false;
            List<EclipseNode> nonFinalNonDefaultedFields = null;
            if (parent.get() instanceof TypeDeclaration) {
                job.parentType = parent;
                TypeDeclaration td = parent.get();
                List<EclipseNode> allFields = new ArrayList<>();
                boolean valuePresent = EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Value.class, parent) || EclipseHandlerUtil.hasAnnotation("lombok.experimental.Value", parent);
                for (EclipseNode fieldNode : HandleConstructor.findAllFields(parent, true)) {
                    FieldDeclaration fd = fieldNode.get();
                    EclipseNode isDefault = EclipseHandlerUtil.findAnnotation(Builder.Default.class, fieldNode);
                    boolean isFinal = (fd.modifiers & 16) != 0 || (valuePresent && !EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) NonFinal.class, fieldNode));
                    BuilderFieldData bfd = new BuilderFieldData();
                    bfd.rawName = fieldNode.getName().toCharArray();
                    bfd.name = EclipseHandlerUtil.removePrefixFromField(fieldNode);
                    bfd.builderFieldName = bfd.name;
                    bfd.annotations = EclipseHandlerUtil.copyAnnotations(fd, EclipseHandlerUtil.findCopyableAnnotations(fieldNode));
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
                        bfd.nameOfDefaultProvider = prefixWith(DEFAULT_PREFIX, bfd.name);
                        bfd.nameOfSetFlag = prefixWith(bfd.name, SET_PREFIX);
                        bfd.builderFieldName = prefixWith(bfd.name, VALUE_PREFIX);
                        MethodDeclaration md3 = generateDefaultProvider(bfd.nameOfDefaultProvider, td.typeParameters, fieldNode, ast);
                        if (md3 != null) {
                            EclipseHandlerUtil.injectMethod(parent, md3);
                        }
                    }
                    addObtainVia(bfd, fieldNode);
                    job.builderFields.add(bfd);
                    allFields.add(fieldNode);
                }
                this.handleConstructor.generateConstructor(parent, AccessLevel.PACKAGE, allFields, false, null, HandleConstructor.SkipIfConstructorExists.I_AM_BUILDER, Collections.emptyList(), annotationNode);
                TypeParameter[] typeParameterArr = td.typeParameters;
                job.builderTypeParams = typeParameterArr;
                job.typeParams = typeParameterArr;
                buildMethodReturnType = job.createBuilderParentTypeReference();
                buildMethodThrownExceptions = null;
                nameOfBuilderMethod = null;
                job.setBuilderClassName(job.replaceBuilderClassName(td.name));
                if (!HandlerUtil.checkName("builderClassName", job.builderClassName, annotationNode)) {
                    return;
                }
            } else if (parent.get() instanceof ConstructorDeclaration) {
                ConstructorDeclaration cd2 = parent.get();
                if (cd2.typeParameters != null && cd2.typeParameters.length > 0) {
                    annotationNode.addError("@Builder is not supported on constructors with constructor type parameters.");
                    return;
                }
                job.parentType = parent.up();
                TypeParameter[] typeParameterArr2 = job.parentType.get().typeParameters;
                job.builderTypeParams = typeParameterArr2;
                job.typeParams = typeParameterArr2;
                buildMethodReturnType = job.createBuilderParentTypeReference();
                buildMethodThrownExceptions = cd2.thrownExceptions;
                nameOfBuilderMethod = null;
                job.setBuilderClassName(job.replaceBuilderClassName(cd2.selector));
                if (!HandlerUtil.checkName("builderClassName", job.builderClassName, annotationNode)) {
                    return;
                }
            } else if (parent.get() instanceof MethodDeclaration) {
                MethodDeclaration md4 = parent.get();
                job.parentType = parent.up();
                job.isStatic = md4.isStatic();
                if (job.toBuilder) {
                    char[][] pkg = null;
                    if (md4.returnType.dimensions() > 0) {
                        annotationNode.addError(TO_BUILDER_NOT_SUPPORTED);
                        return;
                    }
                    if (md4.returnType instanceof SingleTypeReference) {
                        token = md4.returnType.token;
                    } else if (md4.returnType instanceof QualifiedTypeReference) {
                        char[][] pkg2 = md4.returnType.tokens;
                        token = pkg2[pkg2.length];
                        char[][] pkg_ = new char[pkg2.length - 1][];
                        System.arraycopy(pkg2, 0, pkg_, 0, pkg_.length);
                        pkg = pkg_;
                    } else {
                        annotationNode.addError(TO_BUILDER_NOT_SUPPORTED);
                        return;
                    }
                    if (pkg != null && !equals(parent.getPackageDeclaration(), pkg)) {
                        annotationNode.addError(TO_BUILDER_NOT_SUPPORTED);
                        return;
                    }
                    if (job.parentType == null || !equals(job.parentType.getName(), token)) {
                        annotationNode.addError(TO_BUILDER_NOT_SUPPORTED);
                        return;
                    }
                    TypeParameter[] tpOnType = job.parentType.get().typeParameters;
                    TypeParameter[] tpOnMethod = md4.typeParameters;
                    TypeReference[][] tpOnRet_ = null;
                    if (md4.returnType instanceof ParameterizedSingleTypeReference) {
                        tpOnRet_ = new TypeReference[][]{md4.returnType.typeArguments};
                    } else if (md4.returnType instanceof ParameterizedQualifiedTypeReference) {
                        tpOnRet_ = md4.returnType.typeArguments;
                    }
                    if (tpOnRet_ != null) {
                        for (int i = 0; i < tpOnRet_.length - 1; i++) {
                            if (tpOnRet_[i] != null && tpOnRet_[i].length > 0) {
                                annotationNode.addError("@Builder(toBuilder=true) is not supported if returning a type with generics applied to an intermediate.");
                                return;
                            }
                        }
                    }
                    TypeReference[] tpOnRet = tpOnRet_ == null ? null : tpOnRet_[tpOnRet_.length - 1];
                    typeArgsForToBuilder = new ArrayList<>();
                    if (tpOnMethod != null) {
                        for (TypeParameter onMethod : tpOnMethod) {
                            int pos = -1;
                            if (tpOnRet != null) {
                                for (int i2 = 0; i2 < tpOnRet.length; i2++) {
                                    if (tpOnRet[i2].getClass() == SingleTypeReference.class && Arrays.equals(((SingleTypeReference) tpOnRet[i2]).token, onMethod.name)) {
                                        pos = i2;
                                    }
                                }
                            }
                            if (pos == -1 || tpOnType == null || tpOnType.length <= pos) {
                                annotationNode.addError("@Builder(toBuilder=true) requires that each type parameter on the static method is part of the typeargs of the return value. Type parameter " + new String(onMethod.name) + " is not part of the return type.");
                                return;
                            }
                            typeArgsForToBuilder.add(tpOnType[pos].name);
                        }
                    }
                }
                TypeParameter[] typeParameterArr3 = md4.typeParameters;
                job.builderTypeParams = typeParameterArr3;
                job.typeParams = typeParameterArr3;
                buildMethodReturnType = EclipseHandlerUtil.copyType(md4.returnType, ast);
                buildMethodThrownExceptions = md4.thrownExceptions;
                nameOfBuilderMethod = md4.selector;
                if (job.builderClassName.indexOf(42) > -1) {
                    char[] token2 = returnTypeToBuilderClassName(annotationNode, md4, job.typeParams);
                    if (token2 == null) {
                        return;
                    }
                    job.setBuilderClassName(job.replaceBuilderClassName(token2));
                    if (!HandlerUtil.checkName("builderClassName", job.builderClassName, annotationNode)) {
                        return;
                    }
                }
            } else {
                annotationNode.addError("@Builder is only supported on types, constructors, and methods.");
                return;
            }
            if (fillParametersFrom != null) {
                for (EclipseNode param : fillParametersFrom.down()) {
                    if (param.getKind() == AST.Kind.ARGUMENT) {
                        BuilderFieldData bfd2 = new BuilderFieldData();
                        Argument arg = param.get();
                        Annotation[] copyableAnnotations = EclipseHandlerUtil.findCopyableAnnotations(param);
                        bfd2.rawName = arg.name;
                        bfd2.name = arg.name;
                        bfd2.builderFieldName = bfd2.name;
                        bfd2.annotations = EclipseHandlerUtil.copyAnnotations(arg, copyableAnnotations);
                        bfd2.type = arg.type;
                        bfd2.singularData = getSingularData(param, ast, annInstance.setterPrefix());
                        bfd2.originalFieldNode = param;
                        addObtainVia(bfd2, param);
                        job.builderFields.add(bfd2);
                    }
                }
            }
            job.builderType = EclipseHandlerUtil.findInnerClass(job.parentType, job.builderClassName);
            if (job.builderType == null) {
                makeBuilderClass(job);
            } else {
                TypeDeclaration builderTypeDeclaration = job.builderType.get();
                if (job.isStatic && (builderTypeDeclaration.modifiers & 8) == 0) {
                    annotationNode.addError("Existing Builder must be a static inner class.");
                    return;
                }
                if (!job.isStatic && (builderTypeDeclaration.modifiers & 8) != 0) {
                    annotationNode.addError("Existing Builder must be a non-static inner class.");
                    return;
                }
                EclipseHandlerUtil.sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(job.builderType, annotationNode);
                for (BuilderFieldData bfd3 : job.builderFields) {
                    EclipseSingularsRecipes.SingularData sd = bfd3.singularData;
                    if (sd != null && (singularizer = sd.getSingularizer()) != null && singularizer.checkForAlreadyExistingNodesAndGenerateError(job.builderType, sd)) {
                        bfd3.singularData = null;
                    }
                }
            }
            for (BuilderFieldData bfd4 : job.builderFields) {
                if (bfd4.singularData != null && bfd4.singularData.getSingularizer() != null && bfd4.singularData.getSingularizer().requiresCleaning()) {
                    addCleaning = true;
                    break;
                }
                if (bfd4.obtainVia != null) {
                    if (bfd4.obtainVia.field().isEmpty() == bfd4.obtainVia.method().isEmpty()) {
                        bfd4.obtainViaNode.addError("The syntax is either @ObtainVia(field = \"fieldName\") or @ObtainVia(method = \"methodName\").");
                        return;
                    } else if (bfd4.obtainVia.method().isEmpty() && bfd4.obtainVia.isStatic()) {
                        bfd4.obtainViaNode.addError("@ObtainVia(isStatic = true) is not valid unless 'method' has been set.");
                        return;
                    }
                }
            }
            generateBuilderFields(job);
            if (addCleaning) {
                FieldDeclaration cleanDecl = new FieldDeclaration(CLEAN_FIELD_NAME, 0, -1);
                cleanDecl.declarationSourceEnd = -1;
                cleanDecl.modifiers = 2;
                cleanDecl.type = TypeReference.baseTypeReference(5, 0);
                cleanDecl.traverse(new SetGeneratedByVisitor(ast), (MethodScope) null);
                EclipseHandlerUtil.injectFieldAndMarkGenerated(job.builderType, cleanDecl);
            }
            if (EclipseHandlerUtil.constructorExists(job.builderType) == EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS && (cd = HandleConstructor.createConstructor(AccessLevel.PACKAGE, job.builderType, Collections.emptyList(), false, annotationNode, Collections.emptyList())) != null) {
                EclipseHandlerUtil.injectMethod(job.builderType, cd);
            }
            Iterator<BuilderFieldData> it = job.builderFields.iterator();
            while (it.hasNext()) {
                makePrefixedSetterMethodsForBuilder(job, it.next(), annInstance.setterPrefix());
            }
            EclipseHandlerUtil.MemberExistsResult methodExists = EclipseHandlerUtil.methodExists(job.buildMethodName, job.builderType, -1);
            if (methodExists == EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK) {
                methodExists = EclipseHandlerUtil.methodExists(job.buildMethodName, job.builderType, 0);
            }
            if (methodExists == EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS && (md2 = generateBuildMethod(job, nameOfBuilderMethod, buildMethodReturnType, buildMethodThrownExceptions, addCleaning)) != null) {
                EclipseHandlerUtil.injectMethod(job.builderType, md2);
            }
            if (EclipseHandlerUtil.methodExists("toString", job.builderType, 0) == EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                List<InclusionExclusionUtils.Included<EclipseNode, ToString.Include>> fieldNodes = new ArrayList<>();
                Iterator<BuilderFieldData> it2 = job.builderFields.iterator();
                while (it2.hasNext()) {
                    for (EclipseNode f : it2.next().createdFields) {
                        fieldNodes.add(new InclusionExclusionUtils.Included<>(f, null, true, false));
                    }
                }
                MethodDeclaration md5 = HandleToString.createToString(job.builderType, fieldNodes, true, false, ast, HandlerUtil.FieldAccess.ALWAYS_FIELD);
                if (md5 != null) {
                    EclipseHandlerUtil.injectMethod(job.builderType, md5);
                }
            }
            if (addCleaning && (cleanMethod = generateCleanMethod(job)) != null) {
                EclipseHandlerUtil.injectMethod(job.builderType, cleanMethod);
            }
            if (generateBuilderMethod && EclipseHandlerUtil.methodExists(job.builderMethodName, job.parentType, -1) != EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                generateBuilderMethod = false;
            }
            if (generateBuilderMethod && (md = generateBuilderMethod(job)) != null) {
                EclipseHandlerUtil.injectMethod(job.parentType, md);
            }
            if (job.toBuilder) {
                switch ($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[EclipseHandlerUtil.methodExists(TO_BUILDER_METHOD_NAME_STRING, job.parentType, 0).ordinal()]) {
                    case 1:
                        TypeParameter[] tps = job.typeParams;
                        if (typeArgsForToBuilder != null) {
                            tps = new TypeParameter[typeArgsForToBuilder.size()];
                            for (int i3 = 0; i3 < tps.length; i3++) {
                                tps[i3] = new TypeParameter();
                                tps[i3].name = typeArgsForToBuilder.get(i3);
                            }
                        }
                        MethodDeclaration md6 = generateToBuilderMethod(job, tps, annInstance.setterPrefix());
                        if (md6 != null) {
                            EclipseHandlerUtil.injectMethod(job.parentType, md6);
                        }
                        break;
                    case 3:
                        annotationNode.addWarning("Not generating toBuilder() as it already exists.");
                        break;
                }
            }
            if (nonFinalNonDefaultedFields != null && generateBuilderMethod) {
                Iterator<EclipseNode> it3 = nonFinalNonDefaultedFields.iterator();
                while (it3.hasNext()) {
                    it3.next().addWarning("@Builder will ignore the initializing expression entirely. If you want the initializing expression to serve as default, add @Builder.Default. If it is not supposed to be settable during building, make the field final.");
                }
            }
        }
    }

    static char[] returnTypeToBuilderClassName(EclipseNode annotationNode, MethodDeclaration md, TypeParameter[] typeParams) {
        char[] token;
        if (md.returnType instanceof QualifiedTypeReference) {
            char[][] tokens = md.returnType.tokens;
            token = tokens[tokens.length - 1];
        } else if (md.returnType instanceof SingleTypeReference) {
            token = md.returnType.token;
            if (!(md.returnType instanceof ParameterizedSingleTypeReference) && typeParams != null) {
                for (TypeParameter tp : typeParams) {
                    if (Arrays.equals(tp.name, token)) {
                        annotationNode.addError("@Builder requires specifying 'builderClassName' if used on methods with a type parameter as return type.");
                        return null;
                    }
                }
            }
        } else {
            annotationNode.addError("Unexpected kind of return type on annotated method. Specify 'builderClassName' to solve this problem.");
            return null;
        }
        if (Character.isLowerCase(token[0])) {
            char[] newToken = new char[token.length];
            System.arraycopy(token, 1, newToken, 1, token.length - 1);
            newToken[0] = Character.toTitleCase(token[0]);
            token = newToken;
        }
        return token;
    }

    private MethodDeclaration generateToBuilderMethod(BuilderJob job, TypeParameter[] typeParameters, String prefix) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = job.getPos();
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = TO_BUILDER_METHOD_NAME;
        out.modifiers = EclipseHandlerUtil.toEclipseModifier(job.accessOuters);
        out.bits |= 8388608;
        out.returnType = job.createBuilderTypeReference();
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len][];
            out.returnType.annotations[len - 1] = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE)};
        }
        Expression allocationExpression = new AllocationExpression();
        ((AllocationExpression) allocationExpression).type = job.createBuilderTypeReference();
        Expression receiver = allocationExpression;
        List<Statement> preStatements = null;
        List<Statement> postStatements = null;
        for (BuilderFieldData bfd : job.builderFields) {
            String setterName = new String(bfd.name);
            String setterPrefix = prefix.isEmpty() ? job.oldFluent ? "" : "set" : prefix;
            if (!setterPrefix.isEmpty()) {
                setterName = HandlerUtil.buildAccessorName(setterPrefix, setterName);
            }
            Expression messageSend = new MessageSend();
            Expression[] tgt = new Expression[bfd.singularData == null ? 1 : 2];
            if (bfd.obtainVia == null || !bfd.obtainVia.field().isEmpty()) {
                char[] fieldName = bfd.obtainVia == null ? bfd.rawName : bfd.obtainVia.field().toCharArray();
                for (int i = 0; i < tgt.length; i++) {
                    FieldReference fr = new FieldReference(fieldName, 0L);
                    fr.receiver = new ThisReference(0, 0);
                    tgt[i] = fr;
                }
            } else {
                String obtainName = bfd.obtainVia.method();
                boolean obtainIsStatic = bfd.obtainVia.isStatic();
                MessageSend obtainExpr = new MessageSend();
                if (obtainIsStatic) {
                    if (typeParameters != null && typeParameters.length > 0) {
                        obtainExpr.typeArguments = new TypeReference[typeParameters.length];
                        for (int j = 0; j < typeParameters.length; j++) {
                            obtainExpr.typeArguments[j] = new SingleTypeReference(typeParameters[j].name, 0L);
                        }
                    }
                    obtainExpr.receiver = EclipseHandlerUtil.generateNameReference(job.parentType, 0L);
                } else {
                    obtainExpr.receiver = new ThisReference(0, 0);
                }
                obtainExpr.selector = obtainName.toCharArray();
                if (obtainIsStatic) {
                    obtainExpr.arguments = new Expression[]{new ThisReference(0, 0)};
                }
                for (int i2 = 0; i2 < tgt.length; i2++) {
                    tgt[i2] = new SingleNameReference(bfd.name, 0L);
                }
                LocalDeclaration ld = new LocalDeclaration(bfd.name, 0, 0);
                ld.modifiers = 16;
                ld.type = EclipseHandlerUtil.copyType(bfd.type, job.source);
                ld.initialization = obtainExpr;
                if (preStatements == null) {
                    preStatements = new ArrayList<>();
                }
                preStatements.add(ld);
            }
            ((MessageSend) messageSend).selector = setterName.toCharArray();
            if (bfd.singularData == null) {
                ((MessageSend) messageSend).arguments = tgt;
                ((MessageSend) messageSend).receiver = receiver;
                receiver = messageSend;
            } else {
                ((MessageSend) messageSend).arguments = new Expression[]{tgt[1]};
                ((MessageSend) messageSend).receiver = new SingleNameReference(BUILDER_TEMP_VAR, p);
                EqualExpression isNotNull = new EqualExpression(tgt[0], new NullLiteral(pS, pE), 29);
                if (postStatements == null) {
                    postStatements = new ArrayList<>();
                }
                postStatements.add(new IfStatement(isNotNull, messageSend, pS, pE));
            }
        }
        int preSs = preStatements == null ? 0 : preStatements.size();
        int postSs = postStatements == null ? 0 : postStatements.size();
        if (postSs > 0) {
            out.statements = new Statement[preSs + postSs + 2];
            for (int i3 = 0; i3 < preSs; i3++) {
                out.statements[i3] = preStatements.get(i3);
            }
            for (int i4 = 0; i4 < postSs; i4++) {
                out.statements[preSs + 1 + i4] = postStatements.get(i4);
            }
            Statement localDeclaration = new LocalDeclaration(BUILDER_TEMP_VAR, pS, pE);
            out.statements[preSs] = localDeclaration;
            ((LocalDeclaration) localDeclaration).modifiers |= 16;
            ((LocalDeclaration) localDeclaration).type = job.createBuilderTypeReference();
            ((LocalDeclaration) localDeclaration).type.sourceStart = pS;
            ((LocalDeclaration) localDeclaration).type.sourceEnd = pE;
            ((LocalDeclaration) localDeclaration).initialization = receiver;
            out.statements[preSs + postSs + 1] = new ReturnStatement(new SingleNameReference(BUILDER_TEMP_VAR, p), pS, pE);
        } else {
            out.statements = new Statement[preSs + 1];
            for (int i5 = 0; i5 < preSs; i5++) {
                out.statements[i5] = preStatements.get(i5);
            }
            out.statements[preSs] = new ReturnStatement(receiver, pS, pE);
        }
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.parentType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.parentType.get().scope);
        return out;
    }

    private MethodDeclaration generateCleanMethod(BuilderJob job) {
        List<Statement> statements = new ArrayList<>();
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendCleaningCode(bfd.singularData, job.builderType, statements);
            }
        }
        FieldReference thisUnclean = new FieldReference(CLEAN_FIELD_NAME, 0L);
        thisUnclean.receiver = new ThisReference(0, 0);
        statements.add(new Assignment(thisUnclean, new FalseLiteral(0, 0), 0));
        MethodDeclaration decl = job.createNewMethodDeclaration();
        decl.selector = CLEAN_METHOD_NAME;
        decl.modifiers = 2;
        decl.bits |= 8388608;
        decl.returnType = TypeReference.baseTypeReference(6, 0);
        decl.statements = (Statement[]) statements.toArray(new Statement[0]);
        decl.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return decl;
    }

    static Receiver generateNotCalledReceiver(BuilderJob job, String setterName) {
        char[][] nameNotCalled = Eclipse.fromQualifiedName(CheckerFrameworkVersion.NAME__NOT_CALLED);
        Annotation singleMemberAnnotation = new SingleMemberAnnotation(new QualifiedTypeReference(nameNotCalled, Eclipse.poss(job.source, nameNotCalled.length)), job.source.sourceStart);
        ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = new StringLiteral(setterName.toCharArray(), 0, 0, 0);
        TypeReference typeReference = job.createBuilderTypeReference();
        int trLen = typeReference.getTypeName().length;
        typeReference.annotations = new Annotation[trLen][];
        typeReference.annotations[trLen - 1] = new Annotation[]{singleMemberAnnotation};
        return new Receiver(new char[]{'t', 'h', 'i', 's'}, 0L, typeReference, (NameReference) null, 0);
    }

    static Receiver generateBuildReceiver(BuilderJob job) {
        if (!job.checkerFramework.generateCalledMethods()) {
            return null;
        }
        List<char[]> mandatories = new ArrayList<>();
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData == null && bfd.nameOfSetFlag == null) {
                mandatories.add(bfd.name);
            }
        }
        if (mandatories.size() == 0) {
            return null;
        }
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        char[][] nameCalled = Eclipse.fromQualifiedName(CheckerFrameworkVersion.NAME__CALLED);
        Annotation singleMemberAnnotation = new SingleMemberAnnotation(new QualifiedTypeReference(nameCalled, Eclipse.poss(job.source, nameCalled.length)), pS);
        if (mandatories.size() == 1) {
            ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = new StringLiteral(mandatories.get(0), 0, 0, 0);
        } else {
            ArrayInitializer arr = new ArrayInitializer();
            arr.sourceStart = pS;
            arr.sourceEnd = pE;
            arr.expressions = new Expression[mandatories.size()];
            for (int i = 0; i < arr.expressions.length; i++) {
                arr.expressions[i] = new StringLiteral(mandatories.get(i), pS, pE, 0);
            }
            ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = arr;
        }
        TypeReference typeReference = job.createBuilderTypeReference();
        int len = typeReference.getTypeName().length;
        typeReference.annotations = new Annotation[len][];
        typeReference.annotations[len - 1] = new Annotation[]{singleMemberAnnotation};
        return new Receiver(new char[]{'t', 'h', 'i', 's'}, 0L, typeReference, (NameReference) null, 0);
    }

    public MethodDeclaration generateBuildMethod(BuilderJob job, char[] staticName, TypeReference returnType, TypeReference[] thrownExceptions, boolean addCleaning) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.bits |= 8388608;
        List<Statement> statements = new ArrayList<>();
        if (addCleaning) {
            FieldReference thisUnclean = new FieldReference(CLEAN_FIELD_NAME, 0L);
            thisUnclean.receiver = new ThisReference(0, 0);
            UnaryExpression unaryExpression = new UnaryExpression(thisUnclean, 11);
            MessageSend invokeClean = new MessageSend();
            invokeClean.selector = CLEAN_METHOD_NAME;
            statements.add(new IfStatement(unaryExpression, invokeClean, 0, 0));
        }
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendBuildCode(bfd.singularData, job.builderType, statements, bfd.builderFieldName, "this");
            }
        }
        List<Expression> args = new ArrayList<>();
        for (BuilderFieldData bfd2 : job.builderFields) {
            if (bfd2.nameOfSetFlag != null) {
                LocalDeclaration ld = new LocalDeclaration(bfd2.builderFieldName, 0, 0);
                ld.type = EclipseHandlerUtil.copyType(bfd2.type);
                FieldReference builderAssign = new FieldReference(bfd2.builderFieldName, 0L);
                builderAssign.receiver = new ThisReference(0, 0);
                ld.initialization = builderAssign;
                statements.add(ld);
                MessageSend inv = new MessageSend();
                inv.sourceStart = job.source.sourceStart;
                inv.sourceEnd = job.source.sourceEnd;
                inv.receiver = new SingleNameReference(job.parentType.get().name, 0L);
                inv.selector = bfd2.nameOfDefaultProvider;
                inv.typeArguments = typeParameterNames(job.builderType.get().typeParameters);
                Assignment defaultAssign = new Assignment(new SingleNameReference(bfd2.builderFieldName, 0L), inv, 0);
                FieldReference thisSet = new FieldReference(bfd2.nameOfSetFlag, 0L);
                thisSet.receiver = new ThisReference(0, 0);
                statements.add(new IfStatement(new UnaryExpression(thisSet, 11), defaultAssign, 0, 0));
            }
            if (bfd2.nameOfSetFlag != null || (bfd2.singularData != null && bfd2.singularData.getSingularizer().shadowedDuringBuild())) {
                args.add(new SingleNameReference(bfd2.builderFieldName, 0L));
            } else {
                FieldReference fr = new FieldReference(bfd2.builderFieldName, 0L);
                fr.receiver = new ThisReference(0, 0);
                args.add(fr);
            }
        }
        if (addCleaning) {
            FieldReference thisUnclean2 = new FieldReference(CLEAN_FIELD_NAME, 0L);
            thisUnclean2.receiver = new ThisReference(0, 0);
            statements.add(new Assignment(thisUnclean2, new TrueLiteral(0, 0), 0));
        }
        out.modifiers = EclipseHandlerUtil.toEclipseModifier(job.accessInners);
        out.selector = job.buildMethodName.toCharArray();
        out.thrownExceptions = EclipseHandlerUtil.copyTypes(thrownExceptions);
        out.bits |= 8388608;
        out.returnType = returnType;
        if (staticName == null) {
            AllocationExpression allocationStatement = new AllocationExpression();
            allocationStatement.type = EclipseHandlerUtil.copyType(out.returnType);
            allocationStatement.arguments = args.isEmpty() ? null : (Expression[]) args.toArray(new Expression[0]);
            statements.add(new ReturnStatement(allocationStatement, 0, 0));
        } else {
            MessageSend invoke = new MessageSend();
            invoke.selector = staticName;
            if (job.isStatic) {
                invoke.receiver = new SingleNameReference(job.builderType.up().getName().toCharArray(), 0L);
            } else {
                invoke.receiver = new QualifiedThisReference(EclipseHandlerUtil.generateTypeReference(job.builderType.up(), 0L), 0, 0);
            }
            invoke.typeArguments = typeParameterNames(job.builderType.get().typeParameters);
            invoke.arguments = args.isEmpty() ? null : (Expression[]) args.toArray(new Expression[0]);
            if ((returnType instanceof SingleTypeReference) && Arrays.equals(TypeConstants.VOID, ((SingleTypeReference) returnType).token)) {
                statements.add(invoke);
            } else {
                statements.add(new ReturnStatement(invoke, 0, 0));
            }
        }
        out.statements = statements.isEmpty() ? null : (Statement[]) statements.toArray(new Statement[0]);
        if (job.checkerFramework.generateSideEffectFree()) {
            out.annotations = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)};
        }
        out.receiver = generateBuildReceiver(job);
        if (staticName == null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(job.builderType, out);
        }
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
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

    public static MethodDeclaration generateDefaultProvider(char[] methodName, TypeParameter[] typeParameters, EclipseNode fieldNode, ASTNode source) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        MethodDeclaration out = new MethodDeclaration(fieldNode.top().get().compilationResult);
        out.typeParameters = EclipseHandlerUtil.copyTypeParams(typeParameters, source);
        out.selector = methodName;
        out.modifiers = 10;
        out.bits |= 8388608;
        FieldDeclaration fd = fieldNode.get();
        out.returnType = EclipseHandlerUtil.copyType(fd.type, source);
        out.statements = new Statement[]{new ReturnStatement(fd.initialization, pS, pE)};
        fd.initialization = null;
        out.traverse(new SetGeneratedByVisitor(source), fieldNode.up().get().scope);
        return out;
    }

    public MethodDeclaration generateBuilderMethod(BuilderJob job) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = job.getPos();
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = job.builderMethodName.toCharArray();
        out.modifiers = EclipseHandlerUtil.toEclipseModifier(job.accessOuters);
        if (job.isStatic) {
            out.modifiers |= 8;
        }
        out.bits |= 8388608;
        out.returnType = job.createBuilderTypeReference();
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len][];
            out.returnType.annotations[len - 1] = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE)};
        }
        out.typeParameters = job.copyTypeParams();
        AllocationExpression invoke = new AllocationExpression();
        if (job.isStatic) {
            invoke.type = job.createBuilderTypeReferenceForceStatic();
            out.statements = new Statement[]{new ReturnStatement(invoke, pS, pE)};
        } else {
            QualifiedAllocationExpression qualifiedInvoke = new QualifiedAllocationExpression();
            qualifiedInvoke.enclosingInstance = new ThisReference(pS, pE);
            if (job.typeParams == null || job.typeParams.length == 0) {
                qualifiedInvoke.type = new SingleTypeReference(job.builderClassNameArr, p);
            } else {
                qualifiedInvoke.type = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(null, job.builderClassNameArr, false, job.typeParams, p);
            }
            out.statements = new Statement[]{new ReturnStatement(qualifiedInvoke, pS, pE)};
        }
        if (job.checkerFramework.generateSideEffectFree()) {
            out.annotations = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)};
        }
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.builderType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.builderType.get().scope);
        return out;
    }

    public void generateBuilderFields(BuilderJob job) {
        List<EclipseNode> existing = new ArrayList<>();
        for (EclipseNode child : job.builderType.down()) {
            if (child.getKind() == AST.Kind.FIELD) {
                existing.add(child);
            }
        }
        for (BuilderFieldData bfd : job.builderFields) {
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

    public void makePrefixedSetterMethodsForBuilder(BuilderJob job, BuilderFieldData bfd, String prefix) {
        boolean deprecate = EclipseHandlerUtil.isFieldDeprecated(bfd.originalFieldNode);
        if (bfd.singularData == null || bfd.singularData.getSingularizer() == null) {
            makePrefixedSetterMethodForBuilder(job, bfd, deprecate, prefix);
        } else {
            bfd.singularData.getSingularizer().generateMethods(job, bfd.singularData, deprecate);
        }
    }

    private void makePrefixedSetterMethodForBuilder(BuilderJob job, BuilderFieldData bfd, boolean deprecate, String prefix) {
        String setterName;
        TypeDeclaration td = (TypeDeclaration) job.builderType.get();
        EclipseNode fieldNode = bfd.createdFields.get(0);
        AbstractMethodDeclaration[] existing = td.methods;
        if (existing == null) {
            existing = EMPTY_METHODS;
        }
        int len = existing.length;
        String setterPrefix = prefix.isEmpty() ? "set" : prefix;
        if (job.oldFluent) {
            setterName = prefix.isEmpty() ? new String(bfd.name) : HandlerUtil.buildAccessorName(setterPrefix, new String(bfd.name));
        } else {
            setterName = HandlerUtil.buildAccessorName(setterPrefix, new String(bfd.name));
        }
        for (int i = 0; i < len; i++) {
            if (existing[i] instanceof MethodDeclaration) {
                char[] existingName = existing[i].selector;
                if (Arrays.equals(setterName.toCharArray(), existingName) && !EclipseHandlerUtil.isTolerate(fieldNode, existing[i])) {
                    return;
                }
            }
        }
        List<Annotation> methodAnnsList = Collections.emptyList();
        Annotation[] methodAnns = EclipseHandlerUtil.findCopyableToSetterAnnotations(bfd.originalFieldNode);
        if (methodAnns != null && methodAnns.length > 0) {
            methodAnnsList = Arrays.asList(methodAnns);
        }
        ASTNode source = job.sourceNode.get();
        MethodDeclaration setter = HandleSetter.createSetter(td, deprecate, fieldNode, setterName, bfd.name, bfd.nameOfSetFlag, job.oldChain, EclipseHandlerUtil.toEclipseModifier(job.accessInners), job.sourceNode, methodAnnsList, bfd.annotations != null ? Arrays.asList(EclipseHandlerUtil.copyAnnotations(source, bfd.annotations)) : Collections.emptyList());
        if (job.checkerFramework.generateCalledMethods()) {
            setter.receiver = generateNotCalledReceiver(job, setterName);
        }
        if (job.sourceNode.up().getKind() == AST.Kind.METHOD) {
            copyJavadocFromParam(bfd.originalFieldNode.up(), setter, td, bfd.name.toString());
        } else {
            EclipseHandlerUtil.copyJavadoc(bfd.originalFieldNode, setter, td, EclipseHandlerUtil.CopyJavadoc.SETTER, true);
        }
        EclipseHandlerUtil.injectMethod(job.builderType, setter);
    }

    private void copyJavadocFromParam(EclipseNode from, MethodDeclaration to, TypeDeclaration type, String param) {
        try {
            CompilationUnitDeclaration cud = from.top().get();
            String methodComment = EclipseHandlerUtil.getDocComment(cud, from.get());
            if (methodComment == null) {
                return;
            }
            Pattern pattern = Pattern.compile("@param " + param + " (\\S|\\s)+?(?=^ ?@)", 10);
            Matcher matcher = pattern.matcher(methodComment);
            if (matcher.find()) {
                String newJavadoc = HandlerUtil.addReturnsThisIfNeeded(matcher.group());
                EclipseHandlerUtil.setDocComment(cud, type, to, newJavadoc);
            }
        } catch (Exception unused) {
        }
    }

    public void makeBuilderClass(BuilderJob job) {
        TypeDeclaration parent = job.parentType.get();
        TypeDeclaration builder = new TypeDeclaration(parent.compilationResult);
        builder.bits |= 8388608;
        builder.modifiers |= EclipseHandlerUtil.toEclipseModifier(job.accessOuters);
        if (job.isStatic) {
            builder.modifiers |= 8;
        }
        builder.typeParameters = job.copyTypeParams();
        builder.name = job.builderClassNameArr;
        builder.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        job.builderType = EclipseHandlerUtil.injectType(job.parentType, builder);
    }

    private void addObtainVia(BuilderFieldData bfd, EclipseNode node) {
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
}
