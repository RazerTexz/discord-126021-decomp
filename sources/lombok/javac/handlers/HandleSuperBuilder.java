package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.source.tree.Tree$Kind;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCAssign;
import com.sun.tools.javac.tree.JCTree$JCBinary;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCConditional;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCExpressionStatement;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import com.sun.tools.javac.tree.JCTree$JCIdent;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree$JCModifiers;
import com.sun.tools.javac.tree.JCTree$JCNewClass;
import com.sun.tools.javac.tree.JCTree$JCPrimitiveTypeTree;
import com.sun.tools.javac.tree.JCTree$JCReturn;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCTypeApply;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.tree.JCTree$JCWildcard;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import javax.lang.model.element.Modifier;
import lombok.AccessLevel;
import lombok.Builder$Default;
import lombok.Builder$ObtainVia;
import lombok.ConfigurationKeys;
import lombok.Singular;
import lombok.ToString$Include;
import lombok.Value;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.HandlerUtil$FieldAccess;
import lombok.core.handlers.InclusionExclusionUtils$Included;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleSuperBuilder.SCL.lombok */
@HandlerPriority(-1024)
public class HandleSuperBuilder extends JavacAnnotationHandler<SuperBuilder> {
    private static final String SELF_METHOD = "self";
    private static final String FILL_VALUES_METHOD_NAME = "$fillValuesFrom";
    private static final String STATIC_FILL_VALUES_METHOD_NAME = "$fillValuesFromInstanceIntoBuilder";
    private static final String INSTANCE_VARIABLE_NAME = "instance";
    private static final String BUILDER_VARIABLE_NAME = "b";
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult() {
        int[] iArr = $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[JavacHandlerUtil$MemberExistsResult.valuesCustom().length];
        try {
            iArr2[JavacHandlerUtil$MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[JavacHandlerUtil$MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[JavacHandlerUtil$MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<SuperBuilder> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        boolean generateBuilderMethod;
        JavacSingularsRecipes$JavacSingularizer singularizer;
        JCTree$JCMethodDecl builderMethod;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.SUPERBUILDER_FLAG_USAGE, "@SuperBuilder");
        HandleSuperBuilder$SuperBuilderJob job = new HandleSuperBuilder$SuperBuilderJob(this);
        job.sourceNode = annotationNode;
        job.source = ast;
        job.checkerFramework = JavacHandlerUtil.getCheckerFrameworkVersion(annotationNode);
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
            JavacNode parent = annotationNode.up();
            job.builderFields = new ArrayList();
            job.typeParams = List.nil();
            List<JCTree$JCExpression> buildMethodThrownExceptions = List.nil();
            List<JCTree$JCExpression> superclassTypeParams = List.nil();
            boolean addCleaning = false;
            if (!(parent.get() instanceof JCTree$JCClassDecl)) {
                annotationNode.addError("@SuperBuilder is only supported on types.");
                return;
            }
            job.parentType = parent;
            JCTree$JCClassDecl td = (JCTree$JCClassDecl) parent.get();
            ListBuffer<JavacNode> allFields = new ListBuffer<>();
            ArrayList<JavacNode> nonFinalNonDefaultedFields = null;
            boolean valuePresent = JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Value.class, parent) || JavacHandlerUtil.hasAnnotation("lombok.experimental.Value", parent);
            for (JavacNode fieldNode : HandleConstructor.findAllFields(parent, true)) {
                JCTree$JCVariableDecl fd = fieldNode.get();
                JavacNode isDefault = JavacHandlerUtil.findAnnotation(Builder$Default.class, fieldNode, true);
                boolean isFinal = (fd.mods.flags & 16) != 0 || (valuePresent && !JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) NonFinal.class, fieldNode));
                HandleBuilder$BuilderFieldData bfd = new HandleBuilder$BuilderFieldData();
                bfd.rawName = fd.name;
                bfd.name = JavacHandlerUtil.removePrefixFromField(fieldNode);
                bfd.builderFieldName = bfd.name;
                bfd.annotations = JavacHandlerUtil.findCopyableAnnotations(fieldNode);
                bfd.type = fd.vartype;
                bfd.singularData = getSingularData(fieldNode, annInstance.setterPrefix());
                bfd.originalFieldNode = fieldNode;
                if (bfd.singularData != null && isDefault != null) {
                    isDefault.addError("@Builder.Default and @Singular cannot be mixed.");
                    isDefault = null;
                }
                if (fd.init == null && isDefault != null) {
                    isDefault.addWarning("@Builder.Default requires an initializing expression (' = something;').");
                    isDefault = null;
                }
                if (fd.init != null && isDefault == null) {
                    if (!isFinal) {
                        if (nonFinalNonDefaultedFields == null) {
                            nonFinalNonDefaultedFields = new ArrayList<>();
                        }
                        nonFinalNonDefaultedFields.add(fieldNode);
                    }
                }
                if (isDefault != null) {
                    bfd.nameOfDefaultProvider = parent.toName("$default$" + bfd.name);
                    bfd.nameOfSetFlag = parent.toName(bfd.name + "$set");
                    bfd.builderFieldName = parent.toName(bfd.name + "$value");
                    JCTree$JCMethodDecl md = HandleBuilder.generateDefaultProvider(bfd.nameOfDefaultProvider, fieldNode, td.typarams);
                    JavacHandlerUtil.recursiveSetGeneratedBy(md, ast, annotationNode.getContext());
                    if (md != null) {
                        JavacHandlerUtil.injectMethod(parent, md);
                    }
                }
                addObtainVia(bfd, fieldNode);
                job.builderFields.add(bfd);
                allFields.append(fieldNode);
            }
            List<JCTree$JCTypeParameter> list = td.typarams;
            job.builderTypeParams = list;
            job.typeParams = list;
            job.builderClassName = job.replaceBuilderClassName(td.name);
            if (HandlerUtil.checkName("builderClassName", job.builderClassName, annotationNode)) {
                HashSet<String> usedNames = gatherUsedTypeNames(job.typeParams, td);
                String classGenericName = generateNonclashingNameFor("C", usedNames);
                String builderGenericName = generateNonclashingNameFor("B", usedNames);
                JavacTreeMaker maker = annotationNode.getTreeMaker();
                JCTree$JCExpression annotatedClass = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, parent, job.typeParams);
                JCTree$JCTypeParameter c = maker.TypeParameter(parent.toName(classGenericName), List.of(annotatedClass));
                ListBuffer<JCTree$JCExpression> typeParamsForBuilder = getTypeParamExpressions(job.typeParams, maker, job.sourceNode.getContext());
                typeParamsForBuilder.add(maker.Ident(parent.toName(classGenericName)));
                typeParamsForBuilder.add(maker.Ident(parent.toName(builderGenericName)));
                JCTree$JCTypeApply typeApply = maker.TypeApply(JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, parent, job.getBuilderClassName(), false, List.nil()), typeParamsForBuilder.toList());
                JCTree$JCTypeParameter d = maker.TypeParameter(parent.toName(builderGenericName), List.of(typeApply));
                if (job.typeParams == null || job.typeParams.isEmpty()) {
                    job.builderTypeParams_ = List.of(c, d);
                } else {
                    job.builderTypeParams_ = job.typeParams.append(c).append(d);
                }
                JCTree extendsClause = Javac.getExtendsClause(td);
                JCTree$JCFieldAccess jCTree$JCFieldAccessChainDots = null;
                if (extendsClause instanceof JCTree$JCTypeApply) {
                    superclassTypeParams = ((JCTree$JCTypeApply) extendsClause).getTypeArguments();
                    extendsClause = ((JCTree$JCTypeApply) extendsClause).getType();
                }
                if (extendsClause instanceof JCTree$JCFieldAccess) {
                    Name superclassName = ((JCTree$JCFieldAccess) extendsClause).getIdentifier();
                    String superclassBuilderClassName = String.valueOf(superclassName.toString()) + "Builder";
                    jCTree$JCFieldAccessChainDots = parent.getTreeMaker().Select((JCTree$JCFieldAccess) extendsClause, parent.toName(superclassBuilderClassName));
                } else if (extendsClause != null) {
                    String superclassBuilderClassName2 = String.valueOf(extendsClause.toString()) + "Builder";
                    jCTree$JCFieldAccessChainDots = JavacHandlerUtil.chainDots(parent, extendsClause.toString(), superclassBuilderClassName2, new String[0]);
                }
                for (HandleBuilder$BuilderFieldData bfd2 : job.builderFields) {
                    if (bfd2.singularData != null && bfd2.singularData.getSingularizer() != null && bfd2.singularData.getSingularizer().requiresCleaning()) {
                        addCleaning = true;
                        break;
                    }
                    if (bfd2.obtainVia != null) {
                        if (bfd2.obtainVia.field().isEmpty() == bfd2.obtainVia.method().isEmpty()) {
                            bfd2.obtainViaNode.addError("The syntax is either @ObtainVia(field = \"fieldName\") or @ObtainVia(method = \"methodName\").");
                            return;
                        } else if (bfd2.obtainVia.method().isEmpty() && bfd2.obtainVia.isStatic()) {
                            bfd2.obtainViaNode.addError("@ObtainVia(isStatic = true) is not valid unless 'method' has been set.");
                            return;
                        }
                    }
                }
                String strReplaceBuilderClassName = job.replaceBuilderClassName(td.name);
                job.builderClassName = strReplaceBuilderClassName;
                job.builderAbstractClassName = strReplaceBuilderClassName;
                job.builderImplClassName = String.valueOf(job.builderAbstractClassName) + "Impl";
                job.builderAbstractType = findInnerClass(parent, job.builderClassName);
                if (job.builderAbstractType == null) {
                    job.builderAbstractType = generateBuilderAbstractClass(job, jCTree$JCFieldAccessChainDots, superclassTypeParams, classGenericName, builderGenericName);
                    JavacHandlerUtil.recursiveSetGeneratedBy(job.builderAbstractType.get(), ast, annotationNode.getContext());
                } else {
                    JCTree$JCClassDecl builderTypeDeclaration = job.builderAbstractType.get();
                    if (!builderTypeDeclaration.getModifiers().getFlags().contains(Modifier.STATIC) || !builderTypeDeclaration.getModifiers().getFlags().contains(Modifier.ABSTRACT)) {
                        annotationNode.addError("Existing Builder must be an abstract static inner class.");
                        return;
                    }
                    JavacHandlerUtil.sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(job.builderAbstractType, annotationNode);
                    for (HandleBuilder$BuilderFieldData bfd3 : job.builderFields) {
                        JavacSingularsRecipes$SingularData sd = bfd3.singularData;
                        if (sd != null && (singularizer = sd.getSingularizer()) != null && singularizer.checkForAlreadyExistingNodesAndGenerateError(job.builderType, sd)) {
                            bfd3.singularData = null;
                        }
                    }
                }
                job.setBuilderToAbstract();
                generateBuilderFields(job.builderType, job.builderFields, ast);
                if (addCleaning) {
                    JCTree$JCVariableDecl uncleanField = maker.VarDef(maker.Modifiers(2L), job.toName("$lombokUnclean"), maker.TypeIdent(Javac.CTC_BOOLEAN), null);
                    JavacHandlerUtil.recursiveSetGeneratedBy(uncleanField, ast, annotationNode.getContext());
                    JavacHandlerUtil.injectFieldAndMarkGenerated(job.builderType, uncleanField);
                }
                if (job.toBuilder) {
                    JCTree$JCMethodDecl fvm = generateFillValuesMethod(job, jCTree$JCFieldAccessChainDots != null, builderGenericName, classGenericName);
                    JavacHandlerUtil.recursiveSetGeneratedBy(fvm, ast, annotationNode.getContext());
                    JavacHandlerUtil.injectMethod(job.builderType, fvm);
                    JCTree$JCMethodDecl sfvm = generateStaticFillValuesMethod(job, annInstance.setterPrefix());
                    JavacHandlerUtil.recursiveSetGeneratedBy(sfvm, ast, annotationNode.getContext());
                    JavacHandlerUtil.injectMethod(job.builderType, sfvm);
                }
                JCTree$JCMethodDecl asm = generateAbstractSelfMethod(job, jCTree$JCFieldAccessChainDots != null, builderGenericName);
                JavacHandlerUtil.recursiveSetGeneratedBy(asm, ast, annotationNode.getContext());
                JavacHandlerUtil.injectMethod(job.builderType, asm);
                JCTree$JCMethodDecl abm = generateAbstractBuildMethod(job, jCTree$JCFieldAccessChainDots != null, classGenericName);
                JavacHandlerUtil.recursiveSetGeneratedBy(abm, ast, annotationNode.getContext());
                JavacHandlerUtil.injectMethod(job.builderType, abm);
                Iterator<HandleBuilder$BuilderFieldData> it = job.builderFields.iterator();
                while (it.hasNext()) {
                    generateSetterMethodsForBuilder(job, it.next(), builderGenericName, annInstance.setterPrefix());
                }
                java.util.List<InclusionExclusionUtils$Included<JavacNode, ToString$Include>> fieldNodes = new ArrayList<>();
                Iterator<HandleBuilder$BuilderFieldData> it2 = job.builderFields.iterator();
                while (it2.hasNext()) {
                    for (JavacNode f : it2.next().createdFields) {
                        fieldNodes.add(new InclusionExclusionUtils$Included<>(f, null, true, false));
                    }
                }
                JCTree$JCMethodDecl toStringMethod = HandleToString.createToString(job.builderType, fieldNodes, true, jCTree$JCFieldAccessChainDots != null, HandlerUtil$FieldAccess.ALWAYS_FIELD, ast);
                if (toStringMethod != null) {
                    JavacHandlerUtil.injectMethod(job.builderType, toStringMethod);
                }
                if (addCleaning) {
                    JCTree$JCMethodDecl md2 = generateCleanMethod(job.builderFields, job.builderType, ast);
                    JavacHandlerUtil.recursiveSetGeneratedBy(md2, ast, annotationNode.getContext());
                    JavacHandlerUtil.injectMethod(job.builderType, md2);
                }
                boolean isAbstract = (td.mods.flags & Permission.VIEW_CHANNEL) != 0;
                if (!isAbstract) {
                    job.builderImplType = findInnerClass(parent, job.builderImplClassName);
                    if (job.builderImplType == null) {
                        job.builderImplType = generateBuilderImplClass(job);
                        JavacHandlerUtil.recursiveSetGeneratedBy(job.builderImplType.get(), ast, annotationNode.getContext());
                    } else {
                        JCTree$JCClassDecl builderImplTypeDeclaration = job.builderImplType.get();
                        if (!builderImplTypeDeclaration.getModifiers().getFlags().contains(Modifier.STATIC) || builderImplTypeDeclaration.getModifiers().getFlags().contains(Modifier.ABSTRACT)) {
                            annotationNode.addError("Existing BuilderImpl must be a non-abstract static inner class.");
                            return;
                        }
                        JavacHandlerUtil.sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(job.builderImplType, annotationNode);
                    }
                    JCTree$JCMethodDecl cd = HandleConstructor.createConstructor(AccessLevel.PRIVATE, List.nil(), job.builderImplType, List.nil(), false, annotationNode);
                    if (cd != null) {
                        JavacHandlerUtil.injectMethod(job.builderImplType, cd);
                    }
                    job.setBuilderToImpl();
                    JCTree$JCMethodDecl selfMethod = generateSelfMethod(job);
                    JavacHandlerUtil.recursiveSetGeneratedBy(selfMethod, ast, annotationNode.getContext());
                    JavacHandlerUtil.injectMethod(job.builderType, selfMethod);
                    if (JavacHandlerUtil.methodExists(job.buildMethodName, job.builderType, -1) == JavacHandlerUtil$MemberExistsResult.NOT_EXISTS) {
                        JCTree$JCMethodDecl buildMethod = generateBuildMethod(job, buildMethodThrownExceptions);
                        JavacHandlerUtil.recursiveSetGeneratedBy(buildMethod, ast, annotationNode.getContext());
                        JavacHandlerUtil.injectMethod(job.builderType, buildMethod);
                    }
                }
                if (!constructorExists(job.parentType, job.builderAbstractClassName)) {
                    job.setBuilderToAbstract();
                    generateBuilderBasedConstructor(job, jCTree$JCFieldAccessChainDots != null);
                }
                if (!isAbstract) {
                    if (generateBuilderMethod && JavacHandlerUtil.methodExists(job.builderMethodName, job.parentType, -1) != JavacHandlerUtil$MemberExistsResult.NOT_EXISTS) {
                        generateBuilderMethod = false;
                    }
                    if (generateBuilderMethod && (builderMethod = generateBuilderMethod(job)) != null) {
                        JavacHandlerUtil.recursiveSetGeneratedBy(builderMethod, ast, annotationNode.getContext());
                        JavacHandlerUtil.injectMethod(job.parentType, builderMethod);
                    }
                    if (job.toBuilder) {
                        switch ($SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult()[JavacHandlerUtil.methodExists("toBuilder", job.parentType, 0).ordinal()]) {
                            case 1:
                                JCTree$JCMethodDecl md3 = generateToBuilderMethod(job);
                                if (md3 != null) {
                                    JavacHandlerUtil.recursiveSetGeneratedBy(md3, ast, annotationNode.getContext());
                                    JavacHandlerUtil.injectMethod(job.parentType, md3);
                                }
                                break;
                        }
                    }
                }
                if (nonFinalNonDefaultedFields != null && generateBuilderMethod) {
                    Iterator<JavacNode> it3 = nonFinalNonDefaultedFields.iterator();
                    while (it3.hasNext()) {
                        it3.next().addWarning("@SuperBuilder will ignore the initializing expression entirely. If you want the initializing expression to serve as default, add @Builder.Default. If it is not supposed to be settable during building, make the field final.");
                    }
                }
            }
        }
    }

    private JavacNode generateBuilderAbstractClass(HandleSuperBuilder$SuperBuilderJob job, JCTree$JCExpression superclassBuilderClass, List<JCTree$JCExpression> superclassTypeParams, String classGenericName, String builderGenericName) {
        JavacTreeMaker maker = job.parentType.getTreeMaker();
        JCTree$JCModifiers mods = maker.Modifiers(1033L);
        ListBuffer<JCTree$JCTypeParameter> allTypeParams = new ListBuffer<>();
        allTypeParams.addAll(JavacHandlerUtil.copyTypeParams(job.sourceNode, job.typeParams));
        JCTree$JCExpression annotatedClass = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.typeParams);
        allTypeParams.add(maker.TypeParameter(job.toName(classGenericName), List.of(annotatedClass)));
        Name builderClassName = job.toName(job.builderClassName);
        ListBuffer<JCTree$JCExpression> typeParamsForBuilder = getTypeParamExpressions(job.typeParams, maker, job.sourceNode.getContext());
        typeParamsForBuilder.add(maker.Ident(job.toName(classGenericName)));
        typeParamsForBuilder.add(maker.Ident(job.toName(builderGenericName)));
        JCTree$JCTypeApply typeApply = maker.TypeApply(JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, builderClassName, false, List.nil()), typeParamsForBuilder.toList());
        allTypeParams.add(maker.TypeParameter(job.toName(builderGenericName), List.of(typeApply)));
        JCTree$JCTypeApply jCTree$JCTypeApplyTypeApply = null;
        if (superclassBuilderClass != null) {
            ListBuffer<JCTree$JCExpression> typeParamsForBuilder2 = getTypeParamExpressions(superclassTypeParams, maker, job.sourceNode.getContext());
            typeParamsForBuilder2.add(maker.Ident(job.toName(classGenericName)));
            typeParamsForBuilder2.add(maker.Ident(job.toName(builderGenericName)));
            jCTree$JCTypeApplyTypeApply = maker.TypeApply(superclassBuilderClass, typeParamsForBuilder2.toList());
        }
        JCTree$JCClassDecl builder = maker.ClassDef(mods, builderClassName, allTypeParams.toList(), jCTree$JCTypeApplyTypeApply, List.nil(), List.nil());
        return JavacHandlerUtil.injectType(job.parentType, builder);
    }

    private JavacNode generateBuilderImplClass(HandleSuperBuilder$SuperBuilderJob job) {
        JavacTreeMaker maker = job.getTreeMaker();
        JCTree$JCModifiers mods = maker.Modifiers(26L);
        JCTree$JCExpression extending = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderAbstractClassName), false, List.nil());
        ListBuffer<JCTree$JCTypeParameter> allTypeParams = new ListBuffer<>();
        allTypeParams.addAll(JavacHandlerUtil.copyTypeParams(job.sourceNode, job.typeParams));
        JCTree$JCExpression annotatedClass = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.typeParams);
        JCTree$JCExpression builderImplClassExpression = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderImplClassName), false, job.typeParams);
        ListBuffer<JCTree$JCExpression> typeParamsForBuilder = getTypeParamExpressions(job.typeParams, maker, job.getContext());
        typeParamsForBuilder.add(annotatedClass);
        typeParamsForBuilder.add(builderImplClassExpression);
        JCTree$JCClassDecl builder = maker.ClassDef(mods, job.toName(job.builderImplClassName), JavacHandlerUtil.copyTypeParams(job.parentType, job.typeParams), maker.TypeApply(extending, typeParamsForBuilder.toList()), List.nil(), List.nil());
        return JavacHandlerUtil.injectType(job.parentType, builder);
    }

    private void generateBuilderBasedConstructor(HandleSuperBuilder$SuperBuilderJob job, boolean callBuilderBasedSuperConstructor) {
        JCTree$JCIdent jCTree$JCIdentSelect;
        JCTree$JCStatement nullCheck;
        JavacTreeMaker maker = job.getTreeMaker();
        AccessLevel level = AccessLevel.PROTECTED;
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        Name builderVariableName = job.toName(BUILDER_VARIABLE_NAME);
        for (HandleBuilder$BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendBuildCode(bfd.singularData, bfd.originalFieldNode, bfd.type, statements, bfd.builderFieldName, BUILDER_VARIABLE_NAME);
                jCTree$JCIdentSelect = maker.Ident(bfd.singularData.getPluralName());
            } else {
                jCTree$JCIdentSelect = maker.Select(maker.Ident(builderVariableName), bfd.builderFieldName);
            }
            JCTree$JCFieldAccess fieldInThis = maker.Select(maker.Ident(job.toName("this")), bfd.rawName);
            JCTree$JCExpressionStatement jCTree$JCExpressionStatementExec = maker.Exec(maker.Assign(fieldInThis, jCTree$JCIdentSelect));
            if (bfd.nameOfSetFlag != null) {
                JCTree$JCFieldAccess setField = maker.Select(maker.Ident(builderVariableName), bfd.nameOfSetFlag);
                JCTree$JCFieldAccess fieldInThis2 = maker.Select(maker.Ident(job.toName("this")), bfd.rawName);
                JCTree$JCExpression parentTypeRef = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, List.nil());
                JCTree$JCAssign assignDefault = maker.Assign(fieldInThis2, maker.Apply(JavacHandlerUtil.typeParameterNames(maker, job.parentType.get().typarams), maker.Select(parentTypeRef, bfd.nameOfDefaultProvider), List.nil()));
                statements.append(maker.If(setField, jCTree$JCExpressionStatementExec, maker.Exec(assignDefault)));
            } else {
                statements.append(jCTree$JCExpressionStatementExec);
            }
            if (JavacHandlerUtil.hasNonNullAnnotations(bfd.originalFieldNode) && (nullCheck = JavacHandlerUtil.generateNullCheck(maker, bfd.originalFieldNode, job.sourceNode)) != null) {
                statements.append(nullCheck);
            }
        }
        List<JCTree$JCAnnotation> annsOnMethod = job.checkerFramework.generateUnique() ? List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(job.parentType, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil())) : List.nil();
        JCTree$JCModifiers mods = maker.Modifiers(JavacHandlerUtil.toJavacModifier(level), annsOnMethod);
        ListBuffer<JCTree$JCVariableDecl> params = new ListBuffer<>();
        long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, job.getContext());
        ListBuffer<JCTree$JCExpression> typeParamsForBuilderParameter = getTypeParamExpressions(job.typeParams, maker, job.getContext());
        JCTree$JCWildcard wildcard = maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
        typeParamsForBuilderParameter.add(wildcard);
        JCTree$JCWildcard wildcard2 = maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
        typeParamsForBuilderParameter.add(wildcard2);
        JCTree$JCTypeApply paramType = maker.TypeApply(JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.getBuilderClassName(), false, List.nil()), typeParamsForBuilderParameter.toList());
        JCTree$JCVariableDecl param = maker.VarDef(maker.Modifiers(flags), builderVariableName, paramType, null);
        params.append(param);
        if (callBuilderBasedSuperConstructor) {
            JCTree$JCMethodInvocation callToSuperConstructor = maker.Apply(List.nil(), maker.Ident(job.toName("super")), List.of(maker.Ident(builderVariableName)));
            statements.prepend(maker.Exec(callToSuperConstructor));
        }
        JCTree$JCMethodDecl constr = JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, job.toName("<init>"), null, List.nil(), params.toList(), List.nil(), maker.Block(0L, statements.toList()), null), job.source, job.getContext());
        JavacHandlerUtil.injectMethod(job.parentType, constr, null, Javac.createVoidType(job.builderType.getSymbolTable(), Javac.CTC_VOID));
    }

    private JCTree$JCMethodDecl generateBuilderMethod(HandleSuperBuilder$SuperBuilderJob job) {
        JavacTreeMaker maker = job.getTreeMaker();
        ListBuffer<JCTree$JCExpression> typeArgs = new ListBuffer<>();
        for (JCTree$JCTypeParameter typeParam : job.typeParams) {
            typeArgs.append(maker.Ident(typeParam.name));
        }
        JCTree$JCBlock body = maker.Block(0L, List.of(maker.Return(maker.NewClass(null, List.nil(), JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderImplClassName), false, job.typeParams), List.nil(), null))));
        int modifiers = 1 | 8;
        ListBuffer<JCTree$JCExpression> typeParameterNames = new ListBuffer<>();
        typeParameterNames.addAll(JavacHandlerUtil.typeParameterNames(maker, job.typeParams));
        JCTree$JCWildcard wildcard = maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
        typeParameterNames.add(wildcard);
        typeParameterNames.add(wildcard);
        JCTree$JCTypeApply returnType = maker.TypeApply(JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderAbstractClassName), false, List.nil()), typeParameterNames.toList());
        List<JCTree$JCAnnotation> annsOnMethod = job.checkerFramework.generateUnique() ? List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(job.parentType, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil())) : List.nil();
        JCTree$JCMethodDecl methodDef = maker.MethodDef(maker.Modifiers(modifiers, annsOnMethod), job.toName(job.builderMethodName), returnType, JavacHandlerUtil.copyTypeParams(job.sourceNode, job.typeParams), List.nil(), List.nil(), body, null);
        JavacHandlerUtil.createRelevantNonNullAnnotation(job.parentType, methodDef);
        return methodDef;
    }

    private JCTree$JCMethodDecl generateToBuilderMethod(HandleSuperBuilder$SuperBuilderJob job) {
        JavacTreeMaker maker = job.getTreeMaker();
        ListBuffer<JCTree$JCExpression> typeArgs = new ListBuffer<>();
        for (JCTree$JCTypeParameter typeParam : job.typeParams) {
            typeArgs.append(maker.Ident(typeParam.name));
        }
        JCTree$JCNewClass jCTree$JCNewClassNewClass = maker.NewClass(null, List.nil(), JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderImplClassName), false, job.typeParams), List.nil(), null);
        List<JCTree$JCExpression> methodArgs = List.of(maker.Ident(job.toName("this")));
        JCTree$JCMethodInvocation invokeFillMethod = maker.Apply(List.nil(), maker.Select(jCTree$JCNewClassNewClass, job.toName(FILL_VALUES_METHOD_NAME)), methodArgs);
        JCTree$JCBlock body = maker.Block(0L, List.of(maker.Return(invokeFillMethod)));
        ListBuffer<JCTree$JCExpression> typeParameterNames = new ListBuffer<>();
        typeParameterNames.addAll(JavacHandlerUtil.typeParameterNames(maker, job.typeParams));
        JCTree$JCWildcard wildcard = maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
        typeParameterNames.add(wildcard);
        typeParameterNames.add(wildcard);
        JCTree$JCTypeApply returnType = maker.TypeApply(JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderAbstractClassName), false, List.nil()), typeParameterNames.toList());
        List<JCTree$JCAnnotation> annsOnMethod = job.checkerFramework.generateUnique() ? List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(job.parentType, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil())) : List.nil();
        JCTree$JCMethodDecl methodDef = maker.MethodDef(maker.Modifiers(1, annsOnMethod), job.toName("toBuilder"), returnType, List.nil(), List.nil(), List.nil(), body, null);
        JavacHandlerUtil.createRelevantNonNullAnnotation(job.parentType, methodDef);
        return methodDef;
    }

    private JCTree$JCMethodDecl generateFillValuesMethod(HandleSuperBuilder$SuperBuilderJob job, boolean inherited, String builderGenericName, String classGenericName) {
        JavacTreeMaker maker = job.getTreeMaker();
        List<JCTree$JCAnnotation> annotations = List.nil();
        if (inherited) {
            JCTree$JCAnnotation overrideAnnotation = maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(job.builderType, "Override"), List.nil());
            annotations = List.of(overrideAnnotation);
        }
        JCTree$JCModifiers modifiers = maker.Modifiers(4L, annotations);
        Name name = job.toName(FILL_VALUES_METHOD_NAME);
        JCTree$JCIdent jCTree$JCIdentIdent = maker.Ident(job.toName(builderGenericName));
        JCTree$JCVariableDecl param = maker.VarDef(maker.Modifiers(8589934608L), job.toName(INSTANCE_VARIABLE_NAME), maker.Ident(job.toName(classGenericName)), null);
        ListBuffer<JCTree$JCStatement> body = new ListBuffer<>();
        if (inherited) {
            JCTree$JCMethodInvocation callToSuper = maker.Apply(List.nil(), maker.Select(maker.Ident(job.toName("super")), name), List.of(maker.Ident(job.toName(INSTANCE_VARIABLE_NAME))));
            body.append(maker.Exec(callToSuper));
        }
        JCTree$JCExpression ref = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.getBuilderClassName(), false, List.nil());
        JCTree$JCMethodInvocation callStaticFillValuesMethod = maker.Apply(List.nil(), maker.Select(ref, job.toName(STATIC_FILL_VALUES_METHOD_NAME)), List.of(maker.Ident(job.toName(INSTANCE_VARIABLE_NAME)), maker.Ident(job.toName("this"))));
        body.append(maker.Exec(callStaticFillValuesMethod));
        JCTree$JCReturn returnStatement = maker.Return(maker.Apply(List.nil(), maker.Ident(job.toName(SELF_METHOD)), List.nil()));
        body.append(returnStatement);
        JCTree$JCBlock bodyBlock = maker.Block(0L, body.toList());
        return maker.MethodDef(modifiers, name, jCTree$JCIdentIdent, List.nil(), List.of(param), List.nil(), bodyBlock, null);
    }

    private JCTree$JCMethodDecl generateStaticFillValuesMethod(HandleSuperBuilder$SuperBuilderJob job, String setterPrefix) {
        JavacTreeMaker maker = job.getTreeMaker();
        List<JCTree$JCAnnotation> annotations = List.nil();
        JCTree$JCModifiers modifiers = maker.Modifiers(10L, annotations);
        Name name = job.toName(STATIC_FILL_VALUES_METHOD_NAME);
        JCTree$JCPrimitiveTypeTree jCTree$JCPrimitiveTypeTreeTypeIdent = maker.TypeIdent(Javac.CTC_VOID);
        JCTree$JCVariableDecl paramInstance = maker.VarDef(maker.Modifiers(8589934608L), job.toName(INSTANCE_VARIABLE_NAME), JavacHandlerUtil.cloneSelfType(job.parentType), null);
        ListBuffer<JCTree$JCExpression> typeParamsForBuilderParameter = getTypeParamExpressions(job.typeParams, maker, job.getContext());
        JCTree$JCWildcard wildcard = maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
        typeParamsForBuilderParameter.add(wildcard);
        JCTree$JCWildcard wildcard2 = maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
        typeParamsForBuilderParameter.add(wildcard2);
        JCTree$JCTypeApply builderType = maker.TypeApply(JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.getBuilderClassName(), false, List.nil()), typeParamsForBuilderParameter.toList());
        JCTree$JCVariableDecl paramBuilder = maker.VarDef(maker.Modifiers(8589934608L), job.toName(BUILDER_VARIABLE_NAME), builderType, null);
        ListBuffer<JCTree$JCStatement> body = new ListBuffer<>();
        for (HandleBuilder$BuilderFieldData bfd : job.builderFields) {
            JCTree$JCExpressionStatement exec = createSetterCallWithInstanceValue(bfd, job.parentType, maker, setterPrefix);
            body.append(exec);
        }
        JCTree$JCBlock bodyBlock = maker.Block(0L, body.toList());
        return maker.MethodDef(modifiers, name, jCTree$JCPrimitiveTypeTreeTypeIdent, JavacHandlerUtil.copyTypeParams(job.builderType, job.typeParams), List.of(paramInstance, paramBuilder), List.nil(), bodyBlock, null);
    }

    private JCTree$JCExpressionStatement createSetterCallWithInstanceValue(HandleBuilder$BuilderFieldData bfd, JavacNode type, JavacTreeMaker maker, String setterPrefix) {
        JCTree$JCConditional jCTree$JCConditionalConditional;
        JCTree$JCConditional[] jCTree$JCConditionalArr = new JCTree$JCExpression[bfd.singularData == null ? 1 : 2];
        if (bfd.obtainVia == null || !bfd.obtainVia.field().isEmpty()) {
            for (int i = 0; i < jCTree$JCConditionalArr.length; i++) {
                jCTree$JCConditionalArr[i] = maker.Select(maker.Ident(type.toName(INSTANCE_VARIABLE_NAME)), bfd.obtainVia == null ? bfd.rawName : type.toName(bfd.obtainVia.field()));
            }
        } else if (bfd.obtainVia.isStatic()) {
            for (int i2 = 0; i2 < jCTree$JCConditionalArr.length; i2++) {
                JCTree$JCExpression typeRef = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, type, List.nil());
                jCTree$JCConditionalArr[i2] = maker.Apply(List.nil(), maker.Select(typeRef, type.toName(bfd.obtainVia.method())), List.of(maker.Ident(type.toName(INSTANCE_VARIABLE_NAME))));
            }
        } else {
            for (int i3 = 0; i3 < jCTree$JCConditionalArr.length; i3++) {
                jCTree$JCConditionalArr[i3] = maker.Apply(List.nil(), maker.Select(maker.Ident(type.toName(INSTANCE_VARIABLE_NAME)), type.toName(bfd.obtainVia.method())), List.nil());
            }
        }
        if (bfd.singularData == null) {
            jCTree$JCConditionalConditional = jCTree$JCConditionalArr[0];
        } else {
            JCTree$JCBinary jCTree$JCBinaryBinary = maker.Binary(Javac.CTC_EQUAL, jCTree$JCConditionalArr[0], maker.Literal(Javac.CTC_BOT, null));
            String emptyMaker = bfd.singularData.getSingularizer().getEmptyMaker(bfd.singularData.getTargetFqn());
            jCTree$JCConditionalConditional = maker.Conditional(jCTree$JCBinaryBinary, maker.Apply(List.nil(), JavacHandlerUtil.chainDots(type, emptyMaker.split("\\.")), List.nil()), jCTree$JCConditionalArr[1]);
        }
        String setterName = HandlerUtil.buildAccessorName(setterPrefix, bfd.name.toString());
        JCTree$JCMethodInvocation apply = maker.Apply(List.nil(), maker.Select(maker.Ident(type.toName(BUILDER_VARIABLE_NAME)), type.toName(setterName)), List.of(jCTree$JCConditionalConditional));
        JCTree$JCExpressionStatement exec = maker.Exec(apply);
        return exec;
    }

    private JCTree$JCMethodDecl generateAbstractSelfMethod(HandleSuperBuilder$SuperBuilderJob job, boolean override, String builderGenericName) {
        JavacTreeMaker maker = job.getTreeMaker();
        List<JCTree$JCAnnotation> annotations = List.nil();
        JCTree$JCAnnotation overrideAnnotation = override ? maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(job.builderType, "Override"), List.nil()) : null;
        JCTree$JCAnnotation rrAnnotation = job.checkerFramework.generateReturnsReceiver() ? maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER), List.nil()) : null;
        JCTree$JCAnnotation sefAnnotation = job.checkerFramework.generatePure() ? maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__PURE), List.nil()) : null;
        if (sefAnnotation != null) {
            annotations = annotations.prepend(sefAnnotation);
        }
        if (rrAnnotation != null) {
            annotations = annotations.prepend(rrAnnotation);
        }
        if (overrideAnnotation != null) {
            annotations = annotations.prepend(overrideAnnotation);
        }
        JCTree$JCModifiers modifiers = maker.Modifiers(1028L, annotations);
        Name name = job.toName(SELF_METHOD);
        return maker.MethodDef(modifiers, name, maker.Ident(job.toName(builderGenericName)), List.nil(), List.nil(), List.nil(), null, null);
    }

    private JCTree$JCMethodDecl generateSelfMethod(HandleSuperBuilder$SuperBuilderJob job) {
        JavacTreeMaker maker = job.getTreeMaker();
        JCTree$JCAnnotation overrideAnnotation = maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(job.builderType, "Override"), List.nil());
        JCTree$JCAnnotation rrAnnotation = job.checkerFramework.generateReturnsReceiver() ? maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER), List.nil()) : null;
        JCTree$JCAnnotation sefAnnotation = job.checkerFramework.generatePure() ? maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__PURE), List.nil()) : null;
        List<JCTree$JCAnnotation> annsOnMethod = List.nil();
        if (sefAnnotation != null) {
            annsOnMethod = annsOnMethod.prepend(sefAnnotation);
        }
        if (rrAnnotation != null) {
            annsOnMethod = annsOnMethod.prepend(rrAnnotation);
        }
        JCTree$JCModifiers modifiers = maker.Modifiers(4L, annsOnMethod.prepend(overrideAnnotation));
        Name name = job.toName(SELF_METHOD);
        JCTree$JCExpression returnType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.builderType.up(), job.getBuilderClassName(), false, job.typeParams);
        JCTree$JCBlock body = maker.Block(0L, List.of(maker.Return(maker.Ident(job.toName("this")))));
        return maker.MethodDef(modifiers, name, returnType, List.nil(), List.nil(), List.nil(), body, null);
    }

    private JCTree$JCMethodDecl generateAbstractBuildMethod(HandleSuperBuilder$SuperBuilderJob job, boolean override, String classGenericName) {
        JCTree$JCMethodDecl methodDef;
        JavacTreeMaker maker = job.getTreeMaker();
        List<JCTree$JCAnnotation> annotations = List.nil();
        if (override) {
            JCTree$JCAnnotation overrideAnnotation = maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(job.builderType, "Override"), List.nil());
            annotations = List.of(overrideAnnotation);
        }
        if (job.checkerFramework.generateSideEffectFree()) {
            annotations = annotations.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil()));
        }
        JCTree$JCModifiers modifiers = maker.Modifiers(1025L, annotations);
        Name name = job.toName(job.buildMethodName);
        JCTree$JCIdent jCTree$JCIdentIdent = maker.Ident(job.toName(classGenericName));
        JCTree$JCVariableDecl recv = HandleBuilder.generateReceiver(job);
        if (recv != null && maker.hasMethodDefWithRecvParam()) {
            methodDef = maker.MethodDefWithRecvParam(modifiers, name, jCTree$JCIdentIdent, List.nil(), recv, List.nil(), List.nil(), null, null);
        } else {
            methodDef = maker.MethodDef(modifiers, name, jCTree$JCIdentIdent, List.nil(), List.nil(), List.nil(), null, null);
        }
        return methodDef;
    }

    private JCTree$JCMethodDecl generateBuildMethod(HandleSuperBuilder$SuperBuilderJob job, List<JCTree$JCExpression> thrownExceptions) {
        JCTree$JCMethodDecl methodDef;
        JavacTreeMaker maker = job.getTreeMaker();
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        List<JCTree$JCExpression> builderArg = List.of(maker.Ident(job.toName("this")));
        statements.append(maker.Return(maker.NewClass(null, List.nil(), JavacHandlerUtil.cloneSelfType(job.parentType), builderArg, null)));
        JCTree$JCBlock body = maker.Block(0L, statements.toList());
        JCTree$JCAnnotation overrideAnnotation = maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(job.builderType, "Override"), List.nil());
        List<JCTree$JCAnnotation> annsOnMethod = List.of(overrideAnnotation);
        if (job.checkerFramework.generateSideEffectFree()) {
            annsOnMethod = annsOnMethod.prepend(maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil()));
        }
        JCTree$JCModifiers modifiers = maker.Modifiers(1L, annsOnMethod);
        JCTree$JCVariableDecl recv = HandleBuilder.generateReceiver(job);
        if (recv != null && maker.hasMethodDefWithRecvParam()) {
            methodDef = maker.MethodDefWithRecvParam(modifiers, job.toName(job.buildMethodName), JavacHandlerUtil.cloneSelfType(job.parentType), List.nil(), recv, List.nil(), thrownExceptions, body, null);
        } else {
            methodDef = maker.MethodDef(modifiers, job.toName(job.buildMethodName), JavacHandlerUtil.cloneSelfType(job.parentType), List.nil(), List.nil(), thrownExceptions, body, null);
        }
        JavacHandlerUtil.createRelevantNonNullAnnotation(job.builderType, methodDef);
        return methodDef;
    }

    private JCTree$JCMethodDecl generateCleanMethod(java.util.List<HandleBuilder$BuilderFieldData> builderFields, JavacNode type, JCTree source) {
        JavacTreeMaker maker = type.getTreeMaker();
        ListBuffer<JCTree$JCStatement> statements = new ListBuffer<>();
        for (HandleBuilder$BuilderFieldData bfd : builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendCleaningCode(bfd.singularData, type, source, statements);
            }
        }
        statements.append(maker.Exec(maker.Assign(maker.Select(maker.Ident(type.toName("this")), type.toName("$lombokUnclean")), maker.Literal(Javac.CTC_BOOLEAN, 0))));
        JCTree$JCBlock body = maker.Block(0L, statements.toList());
        return maker.MethodDef(maker.Modifiers(1L), type.toName("$lombokClean"), maker.Type(Javac.createVoidType(type.getSymbolTable(), Javac.CTC_VOID)), List.nil(), List.nil(), List.nil(), body, null);
    }

    private void generateBuilderFields(JavacNode builderType, java.util.List<HandleBuilder$BuilderFieldData> builderFields, JCTree source) {
        int len = builderFields.size();
        java.util.List<JavacNode> existing = new ArrayList<>();
        for (JavacNode child : builderType.down()) {
            if (child.getKind() == AST$Kind.FIELD) {
                existing.add(child);
            }
        }
        java.util.List<JCTree$JCVariableDecl> generated = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            HandleBuilder$BuilderFieldData bfd = builderFields.get(i);
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.createdFields.addAll(bfd.singularData.getSingularizer().generateFields(bfd.singularData, builderType, source));
            } else {
                JavacNode field = null;
                JavacNode setFlag = null;
                for (JavacNode exists : existing) {
                    Name n = exists.get().name;
                    if (n.equals(bfd.builderFieldName)) {
                        field = exists;
                    }
                    if (n.equals(bfd.nameOfSetFlag)) {
                        setFlag = exists;
                    }
                }
                JavacTreeMaker maker = builderType.getTreeMaker();
                if (field == null) {
                    JCTree$JCModifiers mods = maker.Modifiers(2L);
                    JCTree$JCVariableDecl newField = maker.VarDef(mods, bfd.builderFieldName, JavacHandlerUtil.cloneType(maker, bfd.type, source, builderType.getContext()), null);
                    field = JavacHandlerUtil.injectFieldAndMarkGenerated(builderType, newField);
                    generated.add(newField);
                }
                if (setFlag == null && bfd.nameOfSetFlag != null) {
                    JCTree$JCModifiers mods2 = maker.Modifiers(2L);
                    JCTree$JCVariableDecl newField2 = maker.VarDef(mods2, bfd.nameOfSetFlag, maker.TypeIdent(Javac.CTC_BOOLEAN), null);
                    JavacHandlerUtil.injectFieldAndMarkGenerated(builderType, newField2);
                    generated.add(newField2);
                }
                bfd.createdFields.add(field);
            }
        }
        for (JCTree$JCVariableDecl gen : generated) {
            JavacHandlerUtil.recursiveSetGeneratedBy(gen, source, builderType.getContext());
        }
    }

    private void generateSetterMethodsForBuilder(HandleSuperBuilder$SuperBuilderJob job, HandleBuilder$BuilderFieldData fieldNode, String builderGenericName, String setterPrefix) {
        boolean deprecate = JavacHandlerUtil.isFieldDeprecated(fieldNode.originalFieldNode);
        JavacTreeMaker maker = job.getTreeMaker();
        JavacSingularsRecipes$ExpressionMaker returnTypeMaker = new HandleSuperBuilder$1(this, maker, job, builderGenericName);
        JavacSingularsRecipes$StatementMaker returnStatementMaker = new HandleSuperBuilder$2(this, maker, job);
        if (fieldNode.singularData == null || fieldNode.singularData.getSingularizer() == null) {
            generateSimpleSetterMethodForBuilder(job, deprecate, fieldNode.createdFields.get(0), fieldNode.name, fieldNode.nameOfSetFlag, returnTypeMaker.make(), returnStatementMaker.make(), fieldNode.annotations, fieldNode.originalFieldNode, setterPrefix);
        } else {
            fieldNode.singularData.getSingularizer().generateMethods(job.checkerFramework, fieldNode.singularData, deprecate, job.builderType, job.source, true, returnTypeMaker, returnStatementMaker, AccessLevel.PUBLIC);
        }
    }

    private void generateSimpleSetterMethodForBuilder(HandleSuperBuilder$SuperBuilderJob job, boolean deprecate, JavacNode fieldNode, Name paramName, Name nameOfSetFlag, JCTree$JCExpression returnType, JCTree$JCStatement returnStatement, List<JCTree$JCAnnotation> annosOnParam, JavacNode originalFieldNode, String setterPrefix) {
        String setterName = HandlerUtil.buildAccessorName(setterPrefix, paramName.toString());
        Name setterName_ = job.builderType.toName(setterName);
        for (JavacNode child : job.builderType.down()) {
            if (child.getKind() == AST$Kind.METHOD) {
                JCTree$JCMethodDecl methodDecl = child.get();
                Name existingName = methodDecl.name;
                if (existingName.equals(setterName_) && !JavacHandlerUtil.isTolerate(fieldNode, methodDecl)) {
                    return;
                }
            }
        }
        JavacTreeMaker maker = fieldNode.getTreeMaker();
        List<JCTree$JCAnnotation> methodAnns = JavacHandlerUtil.findCopyableToSetterAnnotations(originalFieldNode);
        JCTree$JCMethodDecl newMethod = null;
        if (job.checkerFramework.generateCalledMethods() && maker.hasMethodDefWithRecvParam()) {
            JCTree$JCAnnotation ncAnno = maker.Annotation(JavacHandlerUtil.genTypeRef(job.sourceNode, CheckerFrameworkVersion.NAME__NOT_CALLED), List.of(maker.Literal(setterName.toString())));
            JCTree$JCClassDecl builderTypeNode = job.builderType.get();
            JCTree$JCExpression selfType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.builderType, builderTypeNode.typarams, List.of(ncAnno));
            JCTree$JCVariableDecl recv = maker.VarDef(maker.Modifiers(0L, List.nil()), job.toName("this"), selfType, null);
            newMethod = HandleSetter.createSetterWithRecv(1L, deprecate, fieldNode, maker, setterName, paramName, nameOfSetFlag, returnType, returnStatement, job.sourceNode, methodAnns, annosOnParam, recv);
        }
        if (newMethod == null) {
            newMethod = HandleSetter.createSetter(1L, deprecate, fieldNode, maker, setterName, paramName, nameOfSetFlag, returnType, returnStatement, job.sourceNode, methodAnns, annosOnParam);
        }
        if (job.checkerFramework.generateReturnsReceiver()) {
            List<JCTree$JCAnnotation> annotations = newMethod.mods.annotations;
            if (annotations == null) {
                annotations = List.nil();
            }
            JCTree$JCAnnotation anno = maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER), List.nil());
            JavacHandlerUtil.recursiveSetGeneratedBy(anno, job.source, job.getContext());
            newMethod.mods.annotations = annotations.prepend(anno);
        }
        JavacHandlerUtil.injectMethod(job.builderType, newMethod);
    }

    private void addObtainVia(HandleBuilder$BuilderFieldData bfd, JavacNode node) {
        for (JavacNode child : node.down()) {
            if (JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) Builder$ObtainVia.class, child)) {
                AnnotationValues<Builder$ObtainVia> ann = JavacHandlerUtil.createAnnotation(Builder$ObtainVia.class, child);
                bfd.obtainVia = ann.getInstance();
                bfd.obtainViaNode = child;
                JavacHandlerUtil.deleteAnnotationIfNeccessary(child, (Class<? extends Annotation>) Builder$ObtainVia.class);
                return;
            }
        }
    }

    private JavacSingularsRecipes$SingularData getSingularData(JavacNode node, String setterPrefix) {
        for (JavacNode child : node.down()) {
            if (JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) Singular.class, child)) {
                Name pluralName = node.getKind() == AST$Kind.FIELD ? JavacHandlerUtil.removePrefixFromField(node) : node.get().name;
                AnnotationValues<Singular> ann = JavacHandlerUtil.createAnnotation(Singular.class, child);
                Singular singularInstance = ann.getInstance();
                JavacHandlerUtil.deleteAnnotationIfNeccessary(child, (Class<? extends Annotation>) Singular.class);
                String explicitSingular = singularInstance.value();
                if (explicitSingular.isEmpty()) {
                    if (Boolean.FALSE.equals(node.getAst().readConfiguration(ConfigurationKeys.SINGULAR_AUTO))) {
                        node.addError("The singular must be specified explicitly (e.g. @Singular(\"task\")) because auto singularization is disabled.");
                        explicitSingular = pluralName.toString();
                    } else {
                        explicitSingular = HandlerUtil.autoSingularize(pluralName.toString());
                        if (explicitSingular == null) {
                            node.addError("Can't singularize this name; please specify the singular explicitly (i.e. @Singular(\"sheep\"))");
                            explicitSingular = pluralName.toString();
                        }
                    }
                }
                Name singularName = node.toName(explicitSingular);
                JCTree$JCExpression type = node.get() instanceof JCTree$JCVariableDecl ? node.get().vartype : null;
                List<JCTree$JCExpression> typeArgs = List.nil();
                if (type instanceof JCTree$JCTypeApply) {
                    typeArgs = ((JCTree$JCTypeApply) type).arguments;
                    type = ((JCTree$JCTypeApply) type).clazz;
                }
                String name = type.toString();
                String targetFqn = JavacSingularsRecipes.get().toQualified(name);
                JavacSingularsRecipes$JavacSingularizer singularizer = JavacSingularsRecipes.get().getSingularizer(targetFqn, node);
                if (singularizer == null) {
                    node.addError("Lombok does not know how to create the singular-form builder methods for type '" + name + "'; they won't be generated.");
                    return null;
                }
                return new JavacSingularsRecipes$SingularData(child, singularName, pluralName, typeArgs, targetFqn, singularizer, singularInstance.ignoreNullCollections(), setterPrefix);
            }
        }
        return null;
    }

    private HashSet<String> gatherUsedTypeNames(List<JCTree$JCTypeParameter> typeParams, JCTree$JCClassDecl td) {
        HashSet<String> usedNames = new HashSet<>();
        for (JCTree$JCTypeParameter typeParam : typeParams) {
            usedNames.add(typeParam.getName().toString());
        }
        usedNames.add(td.name.toString());
        for (JCTree$JCVariableDecl jCTree$JCVariableDecl : td.getMembers()) {
            if (jCTree$JCVariableDecl.getKind() == Tree$Kind.VARIABLE && (jCTree$JCVariableDecl instanceof JCTree$JCVariableDecl)) {
                JCTree$JCIdent type = jCTree$JCVariableDecl.getType();
                if (type instanceof JCTree$JCIdent) {
                    usedNames.add(type.getName().toString());
                }
            }
        }
        return usedNames;
    }

    private String generateNonclashingNameFor(String classGenericName, HashSet<String> typeParamStrings) {
        if (!typeParamStrings.contains(classGenericName)) {
            return classGenericName;
        }
        int counter = 2;
        while (typeParamStrings.contains(String.valueOf(classGenericName) + counter)) {
            counter++;
        }
        return String.valueOf(classGenericName) + counter;
    }

    private JavacNode findInnerClass(JavacNode parent, String name) {
        for (JavacNode child : parent.down()) {
            if (child.getKind() == AST$Kind.TYPE) {
                JCTree$JCClassDecl td = child.get();
                if (td.name.contentEquals(name)) {
                    return child;
                }
            }
        }
        return null;
    }

    private ListBuffer<JCTree$JCExpression> getTypeParamExpressions(List<? extends JCTree> typeParams, JavacTreeMaker maker, Context context) {
        ListBuffer<JCTree$JCExpression> typeParamsForBuilderParameter = new ListBuffer<>();
        Iterator it = typeParams.iterator();
        while (it.hasNext()) {
            JCTree$JCTypeApply jCTree$JCTypeApply = (JCTree) it.next();
            if (jCTree$JCTypeApply instanceof JCTree$JCTypeParameter) {
                typeParamsForBuilderParameter.add(maker.Ident(((JCTree$JCTypeParameter) jCTree$JCTypeApply).getName()));
            } else if (jCTree$JCTypeApply instanceof JCTree$JCIdent) {
                typeParamsForBuilderParameter.add(maker.Ident(((JCTree$JCIdent) jCTree$JCTypeApply).getName()));
            } else if (jCTree$JCTypeApply instanceof JCTree$JCFieldAccess) {
                typeParamsForBuilderParameter.add(copySelect(maker, (JCTree$JCFieldAccess) jCTree$JCTypeApply));
            } else if (jCTree$JCTypeApply instanceof JCTree$JCTypeApply) {
                typeParamsForBuilderParameter.add(JavacHandlerUtil.cloneType(maker, jCTree$JCTypeApply, jCTree$JCTypeApply, context));
            }
        }
        return typeParamsForBuilderParameter;
    }

    private JCTree$JCExpression copySelect(JavacTreeMaker maker, JCTree$JCFieldAccess typeParam) {
        java.util.List<Name> chainNames = new ArrayList<>();
        JCTree$JCFieldAccess expression = typeParam;
        while (expression != null) {
            if (expression instanceof JCTree$JCFieldAccess) {
                chainNames.add(expression.getIdentifier());
                expression = expression.getExpression();
            } else if (expression instanceof JCTree$JCIdent) {
                chainNames.add(((JCTree$JCIdent) expression).getName());
                expression = null;
            }
        }
        Collections.reverse(chainNames);
        JCTree$JCFieldAccess jCTree$JCFieldAccessIdent = null;
        for (Name name : chainNames) {
            if (jCTree$JCFieldAccessIdent == null) {
                jCTree$JCFieldAccessIdent = maker.Ident(name);
            } else {
                jCTree$JCFieldAccessIdent = maker.Select(jCTree$JCFieldAccessIdent, name);
            }
        }
        return jCTree$JCFieldAccessIdent;
    }

    private boolean constructorExists(JavacNode type, String builderClassName) {
        if (type != null && (type.get() instanceof JCTree$JCClassDecl)) {
            for (JCTree$JCMethodDecl jCTree$JCMethodDecl : type.get().defs) {
                if (jCTree$JCMethodDecl instanceof JCTree$JCMethodDecl) {
                    JCTree$JCMethodDecl md = jCTree$JCMethodDecl;
                    String name = md.name.toString();
                    boolean matches = name.equals("<init>");
                    if (!JavacHandlerUtil.isTolerate(type, md) && matches && md.params != null && md.params.length() == 1) {
                        String typeName = ((JCTree$JCVariableDecl) md.params.get(0)).getType().toString();
                        int lastIndexOfDot = typeName.lastIndexOf(46);
                        if (lastIndexOfDot >= 0) {
                            typeName = typeName.substring(lastIndexOfDot + 1);
                        }
                        if ((String.valueOf(builderClassName) + "<?, ?>").equals(typeName)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
}
