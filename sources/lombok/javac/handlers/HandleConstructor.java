package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import javax.lang.model.type.TypeKind;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.LombokNode;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.delombok.LombokOptionsFactory;
import lombok.javac.Javac;
import lombok.javac.JavacAST;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleConstructor.SCL.lombok */
public class HandleConstructor {
    private static /* synthetic */ int[] $SWITCH_TABLE$javax$lang$model$type$TypeKind;

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleConstructor$SkipIfConstructorExists.SCL.lombok */
    public enum SkipIfConstructorExists {
        YES,
        NO,
        I_AM_BUILDER;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static SkipIfConstructorExists[] valuesCustom() {
            SkipIfConstructorExists[] skipIfConstructorExistsArrValuesCustom = values();
            int length = skipIfConstructorExistsArrValuesCustom.length;
            SkipIfConstructorExists[] skipIfConstructorExistsArr = new SkipIfConstructorExists[length];
            System.arraycopy(skipIfConstructorExistsArrValuesCustom, 0, skipIfConstructorExistsArr, 0, length);
            return skipIfConstructorExistsArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$javax$lang$model$type$TypeKind() {
        int[] iArr = $SWITCH_TABLE$javax$lang$model$type$TypeKind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[TypeKind.values().length];
        try {
            iArr2[TypeKind.ARRAY.ordinal()] = 12;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[TypeKind.BOOLEAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[TypeKind.BYTE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[TypeKind.CHAR.ordinal()] = 6;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[TypeKind.DECLARED.ordinal()] = 13;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[TypeKind.DOUBLE.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[TypeKind.ERROR.ordinal()] = 14;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[TypeKind.EXECUTABLE.ordinal()] = 18;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[TypeKind.FLOAT.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[TypeKind.INT.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[TypeKind.LONG.ordinal()] = 5;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[TypeKind.NONE.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[TypeKind.NULL.ordinal()] = 11;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[TypeKind.OTHER.ordinal()] = 19;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[TypeKind.PACKAGE.ordinal()] = 17;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[TypeKind.SHORT.ordinal()] = 3;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[TypeKind.TYPEVAR.ordinal()] = 15;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[TypeKind.VOID.ordinal()] = 9;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[TypeKind.WILDCARD.ordinal()] = 16;
        } catch (NoSuchFieldError unused19) {
        }
        $SWITCH_TABLE$javax$lang$model$type$TypeKind = iArr2;
        return iArr2;
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleConstructor$HandleNoArgsConstructor.SCL.lombok */
    public static class HandleNoArgsConstructor extends JavacAnnotationHandler<NoArgsConstructor> {
        private static final String NAME = NoArgsConstructor.class.getSimpleName();
        private HandleConstructor handleConstructor = new HandleConstructor();

        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<NoArgsConstructor> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.NO_ARGS_CONSTRUCTOR_FLAG_USAGE, "@NoArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
            JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) NoArgsConstructor.class);
            JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
            JavacNode typeNode = annotationNode.up();
            if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME)) {
                List<JCTree.JCAnnotation> onConstructor = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@NoArgsConstructor(onConstructor", annotationNode);
                NoArgsConstructor ann = annotation.getInstance();
                AccessLevel level = ann.access();
                if (level == AccessLevel.NONE) {
                    return;
                }
                String staticName = ann.staticName();
                boolean force = ann.force();
                this.handleConstructor.generateConstructor(typeNode, level, onConstructor, List.nil(), force, staticName, SkipIfConstructorExists.NO, annotationNode);
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleConstructor$HandleRequiredArgsConstructor.SCL.lombok */
    public static class HandleRequiredArgsConstructor extends JavacAnnotationHandler<RequiredArgsConstructor> {
        private static final String NAME = RequiredArgsConstructor.class.getSimpleName();
        private HandleConstructor handleConstructor = new HandleConstructor();

        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<RequiredArgsConstructor> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.REQUIRED_ARGS_CONSTRUCTOR_FLAG_USAGE, "@RequiredArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
            JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) RequiredArgsConstructor.class);
            JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
            JavacNode typeNode = annotationNode.up();
            if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME)) {
                List<JCTree.JCAnnotation> onConstructor = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@RequiredArgsConstructor(onConstructor", annotationNode);
                RequiredArgsConstructor ann = annotation.getInstance();
                AccessLevel level = ann.access();
                if (level == AccessLevel.NONE) {
                    return;
                }
                String staticName = ann.staticName();
                if (annotation.isExplicit("suppressConstructorProperties")) {
                    annotationNode.addError("This deprecated feature is no longer supported. Remove it; you can create a lombok.config file with 'lombok.anyConstructor.suppressConstructorProperties = true'.");
                }
                this.handleConstructor.generateConstructor(typeNode, level, onConstructor, HandleConstructor.findRequiredFields(typeNode), false, staticName, SkipIfConstructorExists.NO, annotationNode);
            }
        }
    }

    public static List<JavacNode> findRequiredFields(JavacNode typeNode) {
        return findFields(typeNode, true);
    }

    public static List<JavacNode> findFinalFields(JavacNode typeNode) {
        return findFields(typeNode, false);
    }

    public static List<JavacNode> findFields(JavacNode typeNode, boolean nullMarked) {
        ListBuffer<JavacNode> fields = new ListBuffer<>();
        for (JavacNode child : typeNode.down()) {
            if (child.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl fieldDecl = child.get();
                if (!fieldDecl.name.toString().startsWith("$")) {
                    long fieldFlags = fieldDecl.mods.flags;
                    if ((fieldFlags & 8) == 0) {
                        boolean isFinal = (fieldFlags & 16) != 0;
                        boolean isNonNull = nullMarked && JavacHandlerUtil.hasNonNullAnnotations(child);
                        if (isFinal || isNonNull) {
                            if (fieldDecl.init == null) {
                                fields.append(child);
                            }
                        }
                    }
                }
            }
        }
        return fields.toList();
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleConstructor$HandleAllArgsConstructor.SCL.lombok */
    public static class HandleAllArgsConstructor extends JavacAnnotationHandler<AllArgsConstructor> {
        private static final String NAME = AllArgsConstructor.class.getSimpleName();
        private HandleConstructor handleConstructor = new HandleConstructor();

        @Override // lombok.javac.JavacAnnotationHandler
        public void handle(AnnotationValues<AllArgsConstructor> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.ALL_ARGS_CONSTRUCTOR_FLAG_USAGE, "@AllArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
            JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) AllArgsConstructor.class);
            JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
            JavacNode typeNode = annotationNode.up();
            if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME)) {
                List<JCTree.JCAnnotation> onConstructor = JavacHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@AllArgsConstructor(onConstructor", annotationNode);
                AllArgsConstructor ann = annotation.getInstance();
                AccessLevel level = ann.access();
                if (level == AccessLevel.NONE) {
                    return;
                }
                String staticName = ann.staticName();
                if (annotation.isExplicit("suppressConstructorProperties")) {
                    annotationNode.addError("This deprecated feature is no longer supported. Remove it; you can create a lombok.config file with 'lombok.anyConstructor.suppressConstructorProperties = true'.");
                }
                this.handleConstructor.generateConstructor(typeNode, level, onConstructor, HandleConstructor.findAllFields(typeNode), false, staticName, SkipIfConstructorExists.NO, annotationNode);
            }
        }
    }

    public static List<JavacNode> findAllFields(JavacNode typeNode) {
        return findAllFields(typeNode, false);
    }

    public static List<JavacNode> findAllFields(JavacNode typeNode, boolean evenFinalInitialized) {
        ListBuffer<JavacNode> fields = new ListBuffer<>();
        for (JavacNode child : typeNode.down()) {
            if (child.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl fieldDecl = child.get();
                if (!fieldDecl.name.toString().startsWith("$")) {
                    long fieldFlags = fieldDecl.mods.flags;
                    if ((fieldFlags & 8) == 0) {
                        boolean isFinal = (fieldFlags & 16) != 0;
                        if (evenFinalInitialized || !isFinal || fieldDecl.init == null) {
                            fields.append(child);
                        }
                    }
                }
            }
        }
        return fields.toList();
    }

    public static boolean checkLegality(JavacNode typeNode, JavacNode errorNode, String name) {
        JCTree.JCClassDecl typeDecl = null;
        if (typeNode.get() instanceof JCTree.JCClassDecl) {
            typeDecl = (JCTree.JCClassDecl) typeNode.get();
        }
        long modifiers = typeDecl == null ? 0L : typeDecl.mods.flags;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError(String.valueOf(name) + " is only supported on a class or an enum.");
            return false;
        }
        return true;
    }

    public void generateExtraNoArgsConstructor(JavacNode typeNode, JavacNode source) {
        Boolean v;
        if (JavacHandlerUtil.isDirectDescendantOfObject(typeNode) && (v = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.NO_ARGS_CONSTRUCTOR_EXTRA_PRIVATE)) != null && v.booleanValue()) {
            generate(typeNode, AccessLevel.PRIVATE, List.nil(), List.nil(), true, null, SkipIfConstructorExists.NO, source, true);
        }
    }

    public void generateRequiredArgsConstructor(JavacNode typeNode, AccessLevel level, String staticName, SkipIfConstructorExists skipIfConstructorExists, JavacNode source) {
        generateConstructor(typeNode, level, List.nil(), findRequiredFields(typeNode), false, staticName, skipIfConstructorExists, source);
    }

    public void generateAllArgsConstructor(JavacNode typeNode, AccessLevel level, String staticName, SkipIfConstructorExists skipIfConstructorExists, JavacNode source) {
        generateConstructor(typeNode, level, List.nil(), findAllFields(typeNode), false, staticName, skipIfConstructorExists, source);
    }

    public void generateConstructor(JavacNode typeNode, AccessLevel level, List<JCTree.JCAnnotation> onConstructor, List<JavacNode> fields, boolean allToDefault, String staticName, SkipIfConstructorExists skipIfConstructorExists, JavacNode source) {
        generate(typeNode, level, onConstructor, fields, allToDefault, staticName, skipIfConstructorExists, source, false);
    }

    private void generate(JavacNode typeNode, AccessLevel level, List<JCTree.JCAnnotation> onConstructor, List<JavacNode> fields, boolean allToDefault, String staticName, SkipIfConstructorExists skipIfConstructorExists, JavacNode source, boolean noArgs) {
        boolean staticConstrRequired = (staticName == null || staticName.equals("")) ? false : true;
        if (skipIfConstructorExists != SkipIfConstructorExists.NO) {
            for (JavacNode child : typeNode.down()) {
                if (child.getKind() == AST.Kind.ANNOTATION) {
                    boolean skipGeneration = JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) NoArgsConstructor.class, child) || JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) AllArgsConstructor.class, child) || JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) RequiredArgsConstructor.class, child);
                    if (!skipGeneration && skipIfConstructorExists == SkipIfConstructorExists.YES) {
                        skipGeneration = JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) Builder.class, child);
                    }
                    if (skipGeneration) {
                        if (staticConstrRequired) {
                            source.addWarning("Ignoring static constructor name: explicit @XxxArgsConstructor annotation present; its `staticName` parameter will be used.");
                            return;
                        }
                        return;
                    }
                }
            }
        }
        if (noArgs && noArgsConstructorExists(typeNode)) {
            return;
        }
        ListBuffer<Type> argTypes = new ListBuffer<>();
        for (JavacNode fieldNode : fields) {
            Type mirror = JavacHandlerUtil.getMirrorForFieldType(fieldNode);
            if (mirror == null) {
                argTypes = null;
                break;
            }
            argTypes.append(mirror);
        }
        List<Type> argTypes_ = argTypes == null ? null : argTypes.toList();
        if (skipIfConstructorExists == SkipIfConstructorExists.NO || JavacHandlerUtil.constructorExists(typeNode) == JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            JCTree.JCMethodDecl constr = createConstructor(staticConstrRequired ? AccessLevel.PRIVATE : level, onConstructor, typeNode, fields, allToDefault, source);
            JavacHandlerUtil.injectMethod(typeNode, constr, argTypes_, Javac.createVoidType(typeNode.getSymbolTable(), Javac.CTC_VOID));
        }
        generateStaticConstructor(staticConstrRequired, typeNode, staticName, level, allToDefault, fields, source, argTypes_);
    }

    private void generateStaticConstructor(boolean staticConstrRequired, JavacNode typeNode, String staticName, AccessLevel level, boolean allToDefault, List<JavacNode> fields, LombokNode<JavacAST, JavacNode, JCTree> source, List<Type> argTypes_) {
        if (staticConstrRequired) {
            Symbol.ClassSymbol sym = typeNode.get().sym;
            Type returnType = sym == null ? null : sym.type;
            JCTree.JCMethodDecl staticConstr = createStaticConstructor(staticName, level, typeNode, allToDefault ? List.nil() : fields, source.get());
            JavacHandlerUtil.injectMethod(typeNode, staticConstr, argTypes_, returnType);
        }
    }

    private static boolean noArgsConstructorExists(JavacNode node) {
        JavacNode node2 = JavacHandlerUtil.upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            for (JCTree.JCMethodDecl jCMethodDecl : node2.get().defs) {
                if (jCMethodDecl instanceof JCTree.JCMethodDecl) {
                    JCTree.JCMethodDecl md = jCMethodDecl;
                    if (md.name.contentEquals("<init>") && md.params.size() == 0) {
                        return true;
                    }
                }
            }
        }
        for (JavacNode child : node2.down()) {
            if (JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) NoArgsConstructor.class, child)) {
                return true;
            }
            if (JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) RequiredArgsConstructor.class, child) && findRequiredFields(node2).isEmpty()) {
                return true;
            }
            if (JavacHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) AllArgsConstructor.class, child) && findAllFields(node2).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void addConstructorProperties(JCTree.JCModifiers mods, JavacNode node, List<JavacNode> fields) {
        if (fields.isEmpty()) {
            return;
        }
        JavacTreeMaker maker = node.getTreeMaker();
        JCTree.JCExpression constructorPropertiesType = JavacHandlerUtil.chainDots(node, "java", "beans", "ConstructorProperties");
        ListBuffer<JCTree.JCExpression> fieldNames = new ListBuffer<>();
        for (JavacNode field : fields) {
            Name fieldName = JavacHandlerUtil.removePrefixFromField(field);
            fieldNames.append(maker.Literal(fieldName.toString()));
        }
        JCTree.JCAnnotation annotation = maker.Annotation(constructorPropertiesType, List.of(maker.NewArray(null, List.nil(), fieldNames.toList())));
        mods.annotations = mods.annotations.append(annotation);
    }

    public static JCTree.JCMethodDecl createConstructor(AccessLevel level, List<JCTree.JCAnnotation> onConstructor, JavacNode typeNode, List<JavacNode> fieldsToParam, boolean forceDefaults, JavacNode source) {
        boolean addConstructorProperties;
        JCTree.JCStatement nullCheck;
        JavacTreeMaker maker = typeNode.getTreeMaker();
        boolean isEnum = (typeNode.get().mods.flags & Permission.EMBED_LINKS) != 0;
        if (isEnum) {
            level = AccessLevel.PRIVATE;
        }
        List<JavacNode> fieldsToDefault = fieldsNeedingBuilderDefaults(typeNode, fieldsToParam);
        List<JavacNode> fieldsToExplicit = forceDefaults ? fieldsNeedingExplicitDefaults(typeNode, fieldsToParam) : List.nil();
        if (fieldsToParam.isEmpty()) {
            addConstructorProperties = false;
        } else {
            Boolean v = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_ADD_CONSTRUCTOR_PROPERTIES);
            addConstructorProperties = v != null ? v.booleanValue() : Boolean.FALSE.equals(typeNode.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_SUPPRESS_CONSTRUCTOR_PROPERTIES));
        }
        ListBuffer<JCTree.JCStatement> nullChecks = new ListBuffer<>();
        ListBuffer<JCTree.JCStatement> assigns = new ListBuffer<>();
        ListBuffer<JCTree.JCVariableDecl> params = new ListBuffer<>();
        for (JavacNode fieldNode : fieldsToParam) {
            JCTree.JCVariableDecl field = fieldNode.get();
            Name fieldName = JavacHandlerUtil.removePrefixFromField(fieldNode);
            Name rawName = field.name;
            List<JCTree.JCAnnotation> copyableAnnotations = JavacHandlerUtil.findCopyableAnnotations(fieldNode);
            long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, typeNode.getContext());
            JCTree.JCExpression pType = JavacHandlerUtil.cloneType(fieldNode.getTreeMaker(), field.vartype, source.get(), source.getContext());
            JCTree.JCVariableDecl param = maker.VarDef(maker.Modifiers(flags, copyableAnnotations), fieldName, pType, null);
            params.append(param);
            if (JavacHandlerUtil.hasNonNullAnnotations(fieldNode) && (nullCheck = JavacHandlerUtil.generateNullCheck(maker, param, source)) != null) {
                nullChecks.append(nullCheck);
            }
            JCTree.JCFieldAccess thisX = maker.Select(maker.Ident(fieldNode.toName("this")), rawName);
            assigns.append(maker.Exec(maker.Assign(thisX, maker.Ident(fieldName))));
        }
        for (JavacNode fieldNode2 : fieldsToExplicit) {
            JCTree.JCVariableDecl field2 = fieldNode2.get();
            Name rawName2 = field2.name;
            JCTree.JCFieldAccess thisX2 = maker.Select(maker.Ident(fieldNode2.toName("this")), rawName2);
            assigns.append(maker.Exec(maker.Assign(thisX2, getDefaultExpr(maker, field2.vartype))));
        }
        for (JavacNode fieldNode3 : fieldsToDefault) {
            Name rawName3 = fieldNode3.get().name;
            Name nameOfDefaultProvider = typeNode.toName("$default$" + JavacHandlerUtil.removePrefixFromField(fieldNode3));
            JCTree.JCFieldAccess thisX3 = maker.Select(maker.Ident(fieldNode3.toName("this")), rawName3);
            assigns.append(maker.Exec(maker.Assign(thisX3, maker.Apply(List.nil(), maker.Select(maker.Ident(typeNode.get().name), nameOfDefaultProvider), List.nil()))));
        }
        JCTree.JCModifiers mods = maker.Modifiers(JavacHandlerUtil.toJavacModifier(level), List.nil());
        if (addConstructorProperties && !isLocalType(typeNode) && LombokOptionsFactory.getDelombokOptions(typeNode.getContext()).getFormatPreferences().generateConstructorProperties()) {
            addConstructorProperties(mods, typeNode, fieldsToParam);
        }
        if (onConstructor != null) {
            mods.annotations = mods.annotations.appendList(JavacHandlerUtil.copyAnnotations(onConstructor));
        }
        return JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, typeNode.toName("<init>"), null, List.nil(), params.toList(), List.nil(), maker.Block(0L, nullChecks.appendList(assigns).toList()), null), source.get(), typeNode.getContext());
    }

    private static List<JavacNode> fieldsNeedingBuilderDefaults(JavacNode typeNode, List<JavacNode> fieldsToParam) {
        JavacNode ftp;
        ListBuffer<JavacNode> out = new ListBuffer<>();
        for (JavacNode node : typeNode.down()) {
            if (node.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl varDecl = node.get();
                if ((varDecl.mods.flags & 8) == 0) {
                    Iterator it = fieldsToParam.iterator();
                    do {
                        if (!it.hasNext()) {
                            if (!JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Builder.Default.class, node)) {
                                break;
                            }
                            out.append(node);
                            break;
                        }
                        ftp = (JavacNode) it.next();
                    } while (node != ftp);
                }
            }
        }
        return out.toList();
    }

    private static List<JavacNode> fieldsNeedingExplicitDefaults(JavacNode typeNode, List<JavacNode> fieldsToParam) {
        JavacNode ftp;
        ListBuffer<JavacNode> out = new ListBuffer<>();
        for (JavacNode node : typeNode.down()) {
            if (node.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl varDecl = node.get();
                if (varDecl.init == null && (varDecl.mods.flags & 16) != 0 && (varDecl.mods.flags & 8) == 0) {
                    Iterator it = fieldsToParam.iterator();
                    do {
                        if (!it.hasNext()) {
                            if (!JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Builder.Default.class, node)) {
                                out.append(node);
                                break;
                            }
                            break;
                        }
                        ftp = (JavacNode) it.next();
                    } while (node != ftp);
                }
            }
        }
        return out.toList();
    }

    private static JCTree.JCExpression getDefaultExpr(JavacTreeMaker maker, JCTree.JCExpression type) {
        if (type instanceof JCTree.JCPrimitiveTypeTree) {
            switch ($SWITCH_TABLE$javax$lang$model$type$TypeKind()[((JCTree.JCPrimitiveTypeTree) type).getPrimitiveTypeKind().ordinal()]) {
                case 1:
                    return maker.Literal(Javac.CTC_BOOLEAN, 0);
                case 2:
                case 3:
                case 4:
                default:
                    return maker.Literal(Javac.CTC_INT, 0);
                case 5:
                    return maker.Literal(Javac.CTC_LONG, 0L);
                case 6:
                    return maker.Literal(Javac.CTC_CHAR, 0);
                case 7:
                    return maker.Literal(Javac.CTC_FLOAT, Float.valueOf(0.0f));
                case 8:
                    return maker.Literal(Javac.CTC_DOUBLE, Double.valueOf(0.0d));
            }
        }
        return maker.Literal(Javac.CTC_BOT, null);
    }

    public static boolean isLocalType(JavacNode type) {
        AST.Kind kind = type.up().getKind();
        if (kind == AST.Kind.COMPILATION_UNIT) {
            return false;
        }
        if (kind == AST.Kind.TYPE) {
            return isLocalType(type.up());
        }
        return true;
    }

    public JCTree.JCMethodDecl createStaticConstructor(String name, AccessLevel level, JavacNode typeNode, List<JavacNode> fields, JCTree source) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree.JCClassDecl type = typeNode.get();
        JCTree.JCModifiers mods = maker.Modifiers(8 | JavacHandlerUtil.toJavacModifier(level));
        ListBuffer<JCTree.JCTypeParameter> typeParams = new ListBuffer<>();
        ListBuffer<JCTree.JCVariableDecl> params = new ListBuffer<>();
        ListBuffer<JCTree.JCExpression> args = new ListBuffer<>();
        if (!type.typarams.isEmpty()) {
            for (JCTree.JCTypeParameter param : type.typarams) {
                typeParams.append(maker.TypeParameter(param.name, param.bounds));
            }
        }
        List<JCTree.JCAnnotation> annsOnReturnType = List.nil();
        if (JavacHandlerUtil.getCheckerFrameworkVersion(typeNode).generateUnique()) {
            annsOnReturnType = List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(typeNode, CheckerFrameworkVersion.NAME__UNIQUE), List.nil()));
        }
        JCTree.JCExpression returnType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, typeNode, type.typarams, annsOnReturnType);
        JCTree.JCExpression constructorType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, typeNode, type.typarams);
        for (JavacNode fieldNode : fields) {
            JCTree.JCVariableDecl field = fieldNode.get();
            Name fieldName = JavacHandlerUtil.removePrefixFromField(fieldNode);
            JCTree.JCExpression pType = JavacHandlerUtil.cloneType(maker, field.vartype, source, typeNode.getContext());
            List<JCTree.JCAnnotation> copyableAnnotations = JavacHandlerUtil.findCopyableAnnotations(fieldNode);
            long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, typeNode.getContext());
            params.append(maker.VarDef(maker.Modifiers(flags, copyableAnnotations), fieldName, pType, null));
            args.append(maker.Ident(fieldName));
        }
        JCTree.JCReturn returnStatement = maker.Return(maker.NewClass(null, List.nil(), constructorType, args.toList(), null));
        JCTree.JCBlock body = maker.Block(0L, List.of(returnStatement));
        JCTree.JCMethodDecl methodDef = maker.MethodDef(mods, typeNode.toName(name), returnType, typeParams.toList(), params.toList(), List.nil(), body, null);
        JavacHandlerUtil.createRelevantNonNullAnnotation(typeNode, methodDef);
        return JavacHandlerUtil.recursiveSetGeneratedBy(methodDef, source, typeNode.getContext());
    }
}
