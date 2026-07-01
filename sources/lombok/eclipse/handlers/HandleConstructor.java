package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.FloatLiteral;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor.SCL.lombok */
public class HandleConstructor {
    private static final char[][] JAVA_BEANS_CONSTRUCTORPROPERTIES = {"java".toCharArray(), "beans".toCharArray(), "ConstructorProperties".toCharArray()};
    private static final char[] DEFAULT_PREFIX = {'$', 'd', 'e', 'f', 'a', 'u', 'l', 't', '$'};

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$SkipIfConstructorExists.SCL.lombok */
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

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$HandleNoArgsConstructor.SCL.lombok */
    public static class HandleNoArgsConstructor extends EclipseAnnotationHandler<NoArgsConstructor> {
        private static final String NAME = NoArgsConstructor.class.getSimpleName();
        private HandleConstructor handleConstructor = new HandleConstructor();

        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<NoArgsConstructor> annotation, Annotation ast, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.NO_ARGS_CONSTRUCTOR_FLAG_USAGE, "@NoArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
            EclipseNode typeNode = annotationNode.up();
            if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME)) {
                NoArgsConstructor ann = annotation.getInstance();
                AccessLevel level = ann.access();
                String staticName = ann.staticName();
                if (level == AccessLevel.NONE) {
                    return;
                }
                boolean force = ann.force();
                List<Annotation> onConstructor = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@NoArgsConstructor(onConstructor", annotationNode);
                this.handleConstructor.generateConstructor(typeNode, level, Collections.emptyList(), force, staticName, SkipIfConstructorExists.NO, onConstructor, annotationNode);
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$HandleRequiredArgsConstructor.SCL.lombok */
    public static class HandleRequiredArgsConstructor extends EclipseAnnotationHandler<RequiredArgsConstructor> {
        private static final String NAME = RequiredArgsConstructor.class.getSimpleName();
        private HandleConstructor handleConstructor = new HandleConstructor();

        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<RequiredArgsConstructor> annotation, Annotation ast, EclipseNode annotationNode) {
            RequiredArgsConstructor ann;
            AccessLevel level;
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.REQUIRED_ARGS_CONSTRUCTOR_FLAG_USAGE, "@RequiredArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
            EclipseNode typeNode = annotationNode.up();
            if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME) && (level = (ann = annotation.getInstance()).access()) != AccessLevel.NONE) {
                String staticName = ann.staticName();
                if (annotation.isExplicit("suppressConstructorProperties")) {
                    annotationNode.addError("This deprecated feature is no longer supported. Remove it; you can create a lombok.config file with 'lombok.anyConstructor.suppressConstructorProperties = true'.");
                }
                List<Annotation> onConstructor = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@RequiredArgsConstructor(onConstructor", annotationNode);
                this.handleConstructor.generateConstructor(typeNode, level, HandleConstructor.findRequiredFields(typeNode), false, staticName, SkipIfConstructorExists.NO, onConstructor, annotationNode);
            }
        }
    }

    private static List<EclipseNode> findRequiredFields(EclipseNode typeNode) {
        return findFields(typeNode, true);
    }

    private static List<EclipseNode> findFields(EclipseNode typeNode, boolean nullMarked) {
        List<EclipseNode> fields = new ArrayList<>();
        for (EclipseNode child : typeNode.down()) {
            if (child.getKind() == AST.Kind.FIELD) {
                FieldDeclaration fieldDecl = child.get();
                if (EclipseHandlerUtil.filterField(fieldDecl)) {
                    boolean isFinal = (fieldDecl.modifiers & 16) != 0;
                    boolean isNonNull = nullMarked && EclipseHandlerUtil.hasNonNullAnnotations(child);
                    if (isFinal || isNonNull) {
                        if (fieldDecl.initialization == null) {
                            fields.add(child);
                        }
                    }
                }
            }
        }
        return fields;
    }

    static List<EclipseNode> findAllFields(EclipseNode typeNode) {
        return findAllFields(typeNode, false);
    }

    static List<EclipseNode> findAllFields(EclipseNode typeNode, boolean evenFinalInitialized) {
        List<EclipseNode> fields = new ArrayList<>();
        for (EclipseNode child : typeNode.down()) {
            if (child.getKind() == AST.Kind.FIELD) {
                FieldDeclaration fieldDecl = child.get();
                if (EclipseHandlerUtil.filterField(fieldDecl) && (evenFinalInitialized || (fieldDecl.modifiers & 16) == 0 || fieldDecl.initialization == null)) {
                    fields.add(child);
                }
            }
        }
        return fields;
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$HandleAllArgsConstructor.SCL.lombok */
    public static class HandleAllArgsConstructor extends EclipseAnnotationHandler<AllArgsConstructor> {
        private static final String NAME = AllArgsConstructor.class.getSimpleName();
        private HandleConstructor handleConstructor = new HandleConstructor();

        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<AllArgsConstructor> annotation, Annotation ast, EclipseNode annotationNode) {
            AllArgsConstructor ann;
            AccessLevel level;
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.ALL_ARGS_CONSTRUCTOR_FLAG_USAGE, "@AllArgsConstructor", ConfigurationKeys.ANY_CONSTRUCTOR_FLAG_USAGE, "any @xArgsConstructor");
            EclipseNode typeNode = annotationNode.up();
            if (HandleConstructor.checkLegality(typeNode, annotationNode, NAME) && (level = (ann = annotation.getInstance()).access()) != AccessLevel.NONE) {
                String staticName = ann.staticName();
                if (annotation.isExplicit("suppressConstructorProperties")) {
                    annotationNode.addError("This deprecated feature is no longer supported. Remove it; you can create a lombok.config file with 'lombok.anyConstructor.suppressConstructorProperties = true'.");
                }
                List<Annotation> onConstructor = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onConstructor", "@AllArgsConstructor(onConstructor", annotationNode);
                this.handleConstructor.generateConstructor(typeNode, level, HandleConstructor.findAllFields(typeNode), false, staticName, SkipIfConstructorExists.NO, onConstructor, annotationNode);
            }
        }
    }

    static boolean checkLegality(EclipseNode typeNode, EclipseNode errorNode, String name) {
        TypeDeclaration typeDecl = null;
        if (typeNode.get() instanceof TypeDeclaration) {
            typeDecl = (TypeDeclaration) typeNode.get();
        }
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError(String.valueOf(name) + " is only supported on a class or an enum.");
            return false;
        }
        return true;
    }

    public void generateExtraNoArgsConstructor(EclipseNode typeNode, EclipseNode sourceNode) {
        Boolean v;
        if (EclipseHandlerUtil.isDirectDescendantOfObject(typeNode) && (v = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.NO_ARGS_CONSTRUCTOR_EXTRA_PRIVATE)) != null && v.booleanValue()) {
            generate(typeNode, AccessLevel.PRIVATE, Collections.emptyList(), true, null, SkipIfConstructorExists.NO, Collections.emptyList(), sourceNode, true);
        }
    }

    public void generateRequiredArgsConstructor(EclipseNode typeNode, AccessLevel level, String staticName, SkipIfConstructorExists skipIfConstructorExists, List<Annotation> onConstructor, EclipseNode sourceNode) {
        generateConstructor(typeNode, level, findRequiredFields(typeNode), false, staticName, skipIfConstructorExists, onConstructor, sourceNode);
    }

    public void generateAllArgsConstructor(EclipseNode typeNode, AccessLevel level, String staticName, SkipIfConstructorExists skipIfConstructorExists, List<Annotation> onConstructor, EclipseNode sourceNode) {
        generateConstructor(typeNode, level, findAllFields(typeNode), false, staticName, skipIfConstructorExists, onConstructor, sourceNode);
    }

    public void generateConstructor(EclipseNode typeNode, AccessLevel level, List<EclipseNode> fieldsToParam, boolean forceDefaults, String staticName, SkipIfConstructorExists skipIfConstructorExists, List<Annotation> onConstructor, EclipseNode sourceNode) {
        generate(typeNode, level, fieldsToParam, forceDefaults, staticName, skipIfConstructorExists, onConstructor, sourceNode, false);
    }

    public void generate(EclipseNode typeNode, AccessLevel level, List<EclipseNode> fieldsToParam, boolean forceDefaults, String staticName, SkipIfConstructorExists skipIfConstructorExists, List<Annotation> onConstructor, EclipseNode sourceNode, boolean noArgs) {
        ASTNode source = sourceNode.get();
        boolean staticConstrRequired = (staticName == null || staticName.equals("")) ? false : true;
        if (skipIfConstructorExists != SkipIfConstructorExists.NO) {
            for (EclipseNode child : typeNode.down()) {
                if (child.getKind() == AST.Kind.ANNOTATION) {
                    boolean skipGeneration = EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) NoArgsConstructor.class, child) || EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) AllArgsConstructor.class, child) || EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) RequiredArgsConstructor.class, child);
                    if (!skipGeneration && skipIfConstructorExists == SkipIfConstructorExists.YES) {
                        skipGeneration = EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Builder.class, child);
                    }
                    if (skipGeneration) {
                        if (staticConstrRequired) {
                            typeNode.addWarning("Ignoring static constructor name: explicit @XxxArgsConstructor annotation present; its `staticName` parameter will be used.", source.sourceStart, source.sourceEnd);
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
        if (skipIfConstructorExists == SkipIfConstructorExists.NO || EclipseHandlerUtil.constructorExists(typeNode) == EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            ConstructorDeclaration constr = createConstructor(staticConstrRequired ? AccessLevel.PRIVATE : level, typeNode, fieldsToParam, forceDefaults, sourceNode, onConstructor);
            EclipseHandlerUtil.injectMethod(typeNode, constr);
        }
        generateStaticConstructor(staticConstrRequired, typeNode, staticName, level, fieldsToParam, source);
    }

    private void generateStaticConstructor(boolean staticConstrRequired, EclipseNode typeNode, String staticName, AccessLevel level, Collection<EclipseNode> fields, ASTNode source) {
        if (staticConstrRequired) {
            MethodDeclaration staticConstr = createStaticConstructor(level, staticName, typeNode, fields, source);
            EclipseHandlerUtil.injectMethod(typeNode, staticConstr);
        }
    }

    private static boolean noArgsConstructorExists(EclipseNode node) {
        Argument[] arguments;
        EclipseNode node2 = EclipseHandlerUtil.upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = node2.get();
            if (typeDecl.methods != null) {
                for (ConstructorDeclaration constructorDeclaration : typeDecl.methods) {
                    if ((constructorDeclaration instanceof ConstructorDeclaration) && ((arguments = constructorDeclaration.arguments) == null || arguments.length == 0)) {
                        return true;
                    }
                }
            }
        }
        for (EclipseNode child : node2.down()) {
            if (EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) NoArgsConstructor.class, child)) {
                return true;
            }
            if (EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) RequiredArgsConstructor.class, child) && findRequiredFields(node2).isEmpty()) {
                return true;
            }
            if (EclipseHandlerUtil.annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) AllArgsConstructor.class, child) && findAllFields(node2).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static Annotation[] createConstructorProperties(ASTNode source, Collection<EclipseNode> fields) {
        if (fields.isEmpty()) {
            return null;
        }
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        long[] poss = new long[3];
        Arrays.fill(poss, p);
        QualifiedTypeReference constructorPropertiesType = new QualifiedTypeReference(JAVA_BEANS_CONSTRUCTORPROPERTIES, poss);
        EclipseHandlerUtil.setGeneratedBy(constructorPropertiesType, source);
        Annotation singleMemberAnnotation = new SingleMemberAnnotation(constructorPropertiesType, pS);
        ((SingleMemberAnnotation) singleMemberAnnotation).declarationSourceEnd = pE;
        ArrayInitializer fieldNames = new ArrayInitializer();
        fieldNames.sourceStart = pS;
        fieldNames.sourceEnd = pE;
        fieldNames.expressions = new Expression[fields.size()];
        int ctr = 0;
        for (EclipseNode field : fields) {
            char[] fieldName = EclipseHandlerUtil.removePrefixFromField(field);
            fieldNames.expressions[ctr] = new StringLiteral(fieldName, pS, pE, 0);
            EclipseHandlerUtil.setGeneratedBy(fieldNames.expressions[ctr], source);
            ctr++;
        }
        ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = fieldNames;
        EclipseHandlerUtil.setGeneratedBy(singleMemberAnnotation, source);
        EclipseHandlerUtil.setGeneratedBy(((SingleMemberAnnotation) singleMemberAnnotation).memberValue, source);
        return new Annotation[]{singleMemberAnnotation};
    }

    private static final char[] prefixWith(char[] prefix, char[] name) {
        char[] out = new char[prefix.length + name.length];
        System.arraycopy(prefix, 0, out, 0, prefix.length);
        System.arraycopy(name, 0, out, prefix.length, name.length);
        return out;
    }

    public static ConstructorDeclaration createConstructor(AccessLevel level, EclipseNode type, Collection<EclipseNode> fieldsToParam, boolean forceDefaults, EclipseNode sourceNode, List<Annotation> onConstructor) {
        boolean addConstructorProperties;
        Statement nullCheck;
        ASTNode source = sourceNode.get();
        TypeDeclaration typeDeclaration = type.get();
        long p = (((long) source.sourceStart) << 32) | ((long) source.sourceEnd);
        boolean isEnum = (type.get().modifiers & 16384) != 0;
        if (isEnum) {
            level = AccessLevel.PRIVATE;
        }
        List<EclipseNode> fieldsToDefault = fieldsNeedingBuilderDefaults(type, fieldsToParam);
        List<EclipseNode> fieldsToExplicit = forceDefaults ? fieldsNeedingExplicitDefaults(type, fieldsToParam) : Collections.emptyList();
        if (fieldsToParam.isEmpty()) {
            addConstructorProperties = false;
        } else {
            Boolean v = (Boolean) type.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_ADD_CONSTRUCTOR_PROPERTIES);
            addConstructorProperties = v != null ? v.booleanValue() : Boolean.FALSE.equals(type.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_SUPPRESS_CONSTRUCTOR_PROPERTIES));
        }
        ConstructorDeclaration constructor = new ConstructorDeclaration(type.top().get().compilationResult);
        constructor.modifiers = EclipseHandlerUtil.toEclipseModifier(level);
        constructor.selector = typeDeclaration.name;
        constructor.constructorCall = new ExplicitConstructorCall(1);
        constructor.constructorCall.sourceStart = source.sourceStart;
        constructor.constructorCall.sourceEnd = source.sourceEnd;
        constructor.thrownExceptions = null;
        constructor.typeParameters = null;
        constructor.bits |= 8388608;
        int i = source.sourceStart;
        constructor.sourceStart = i;
        constructor.declarationSourceStart = i;
        constructor.bodyStart = i;
        int i2 = source.sourceEnd;
        constructor.sourceEnd = i2;
        constructor.declarationSourceEnd = i2;
        constructor.bodyEnd = i2;
        constructor.arguments = null;
        List<Argument> params = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        List<Statement> nullChecks = new ArrayList<>();
        for (EclipseNode fieldNode : fieldsToParam) {
            FieldDeclaration field = fieldNode.get();
            char[] rawName = field.name;
            char[] fieldName = EclipseHandlerUtil.removePrefixFromField(fieldNode);
            FieldReference thisX = new FieldReference(rawName, p);
            thisX.receiver = new ThisReference((int) (p >> 32), (int) p);
            Assignment assignment = new Assignment(thisX, new SingleNameReference(fieldName, p), (int) p);
            assignment.sourceStart = (int) (p >> 32);
            int i3 = (int) (p >> 32);
            assignment.statementEnd = i3;
            assignment.sourceEnd = i3;
            arrayList.add(assignment);
            long fieldPos = (((long) field.sourceStart) << 32) | ((long) field.sourceEnd);
            Argument parameter = new Argument(fieldName, fieldPos, EclipseHandlerUtil.copyType(field.type, source), 16);
            Annotation[] copyableAnnotations = EclipseHandlerUtil.findCopyableAnnotations(fieldNode);
            if (EclipseHandlerUtil.hasNonNullAnnotations(fieldNode) && (nullCheck = EclipseHandlerUtil.generateNullCheck(parameter, sourceNode, null)) != null) {
                nullChecks.add(nullCheck);
            }
            parameter.annotations = EclipseHandlerUtil.copyAnnotations(source, copyableAnnotations);
            params.add(parameter);
        }
        Iterator<EclipseNode> it = fieldsToExplicit.iterator();
        while (it.hasNext()) {
            FieldDeclaration field2 = it.next().get();
            char[] rawName2 = field2.name;
            FieldReference thisX2 = new FieldReference(rawName2, p);
            int s2 = (int) (p >> 32);
            int e = (int) p;
            thisX2.receiver = new ThisReference(s2, e);
            Expression assignmentExpr = getDefaultExpr(field2.type, s2, e);
            Assignment assignment2 = new Assignment(thisX2, assignmentExpr, (int) p);
            assignment2.sourceStart = (int) (p >> 32);
            int i4 = (int) (p >> 32);
            assignment2.statementEnd = i4;
            assignment2.sourceEnd = i4;
            arrayList.add(assignment2);
        }
        for (EclipseNode fieldNode2 : fieldsToDefault) {
            char[] rawName3 = fieldNode2.get().name;
            FieldReference thisX3 = new FieldReference(rawName3, p);
            thisX3.receiver = new ThisReference((int) (p >> 32), (int) p);
            MessageSend inv = new MessageSend();
            inv.sourceStart = source.sourceStart;
            inv.sourceEnd = source.sourceEnd;
            inv.receiver = new SingleNameReference(type.get().name, 0L);
            inv.selector = prefixWith(DEFAULT_PREFIX, EclipseHandlerUtil.removePrefixFromField(fieldNode2));
            Assignment assignment3 = new Assignment(thisX3, inv, (int) p);
            assignment3.sourceStart = (int) (p >> 32);
            int i5 = (int) (p >> 32);
            assignment3.statementEnd = i5;
            assignment3.sourceEnd = i5;
            arrayList.add(assignment3);
        }
        nullChecks.addAll(arrayList);
        constructor.statements = nullChecks.isEmpty() ? null : (Statement[]) nullChecks.toArray(new Statement[0]);
        constructor.arguments = params.isEmpty() ? null : (Argument[]) params.toArray(new Argument[0]);
        Annotation[] constructorProperties = null;
        if (addConstructorProperties && !isLocalType(type)) {
            constructorProperties = createConstructorProperties(source, fieldsToParam);
        }
        constructor.annotations = EclipseHandlerUtil.copyAnnotations(source, (Annotation[]) onConstructor.toArray(new Annotation[0]), constructorProperties);
        constructor.traverse(new SetGeneratedByVisitor(source), typeDeclaration.scope);
        return constructor;
    }

    private static List<EclipseNode> fieldsNeedingBuilderDefaults(EclipseNode type, Collection<EclipseNode> fieldsToParam) {
        EclipseNode ftp;
        List<EclipseNode> out = new ArrayList<>();
        for (EclipseNode node : type.down()) {
            if (node.getKind() == AST.Kind.FIELD) {
                FieldDeclaration fd = node.get();
                if ((fd.modifiers & 8) == 0) {
                    Iterator<EclipseNode> it = fieldsToParam.iterator();
                    do {
                        if (!it.hasNext()) {
                            if (!EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Builder.Default.class, node)) {
                                break;
                            }
                            out.add(node);
                            break;
                        }
                        ftp = it.next();
                    } while (node != ftp);
                }
            }
        }
        return out;
    }

    private static List<EclipseNode> fieldsNeedingExplicitDefaults(EclipseNode type, Collection<EclipseNode> fieldsToParam) {
        EclipseNode ftp;
        List<EclipseNode> out = new ArrayList<>();
        for (EclipseNode node : type.down()) {
            if (node.getKind() == AST.Kind.FIELD) {
                FieldDeclaration fd = node.get();
                if (fd.initialization == null && (fd.modifiers & 16) != 0 && (fd.modifiers & 8) == 0) {
                    Iterator<EclipseNode> it = fieldsToParam.iterator();
                    do {
                        if (!it.hasNext()) {
                            if (!EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) Builder.Default.class, node)) {
                                out.add(node);
                                break;
                            }
                            break;
                        }
                        ftp = it.next();
                    } while (node != ftp);
                }
            }
        }
        return out;
    }

    private static Expression getDefaultExpr(TypeReference type, int s2, int e) {
        boolean array = type instanceof ArrayTypeReference;
        if (array) {
            return new NullLiteral(s2, e);
        }
        char[] lastToken = type.getLastToken();
        if (Arrays.equals(TypeConstants.BOOLEAN, lastToken)) {
            return new FalseLiteral(s2, e);
        }
        if (Arrays.equals(TypeConstants.CHAR, lastToken)) {
            return new CharLiteral(new char[]{'\'', '\\', '0', '\''}, s2, e);
        }
        if (Arrays.equals(TypeConstants.BYTE, lastToken) || Arrays.equals(TypeConstants.SHORT, lastToken) || Arrays.equals(TypeConstants.INT, lastToken)) {
            return IntLiteral.buildIntLiteral(new char[]{'0'}, s2, e);
        }
        if (Arrays.equals(TypeConstants.LONG, lastToken)) {
            return LongLiteral.buildLongLiteral(new char[]{'0', 'L'}, s2, e);
        }
        if (Arrays.equals(TypeConstants.FLOAT, lastToken)) {
            return new FloatLiteral(new char[]{'0', 'F'}, s2, e);
        }
        return Arrays.equals(TypeConstants.DOUBLE, lastToken) ? new DoubleLiteral(new char[]{'0', 'D'}, s2, e) : new NullLiteral(s2, e);
    }

    public static boolean isLocalType(EclipseNode type) {
        AST.Kind kind = type.up().getKind();
        if (kind == AST.Kind.COMPILATION_UNIT) {
            return false;
        }
        if (kind == AST.Kind.TYPE) {
            return isLocalType(type.up());
        }
        return true;
    }

    public MethodDeclaration createStaticConstructor(AccessLevel level, String name, EclipseNode type, Collection<EclipseNode> fields, ASTNode source) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        MethodDeclaration constructor = new MethodDeclaration(type.top().get().compilationResult);
        constructor.modifiers = EclipseHandlerUtil.toEclipseModifier(level) | 8;
        TypeDeclaration typeDecl = type.get();
        constructor.returnType = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(type, typeDecl.typeParameters, p);
        constructor.annotations = null;
        if (EclipseHandlerUtil.getCheckerFrameworkVersion(type).generateUnique()) {
            int len = constructor.returnType.getTypeName().length;
            constructor.returnType.annotations = new Annotation[len][];
            constructor.returnType.annotations[len - 1] = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__UNIQUE)};
        }
        constructor.selector = name.toCharArray();
        constructor.thrownExceptions = null;
        constructor.typeParameters = EclipseHandlerUtil.copyTypeParams(type.get().typeParameters, source);
        constructor.bits |= 8388608;
        int i = source.sourceStart;
        constructor.sourceStart = i;
        constructor.declarationSourceStart = i;
        constructor.bodyStart = i;
        int i2 = source.sourceEnd;
        constructor.sourceEnd = i2;
        constructor.declarationSourceEnd = i2;
        constructor.bodyEnd = i2;
        List<Argument> params = new ArrayList<>();
        List<Expression> assigns = new ArrayList<>();
        AllocationExpression statement = new AllocationExpression();
        statement.sourceStart = pS;
        statement.sourceEnd = pE;
        statement.type = EclipseHandlerUtil.copyType(constructor.returnType, source);
        for (EclipseNode fieldNode : fields) {
            FieldDeclaration field = fieldNode.get();
            long fieldPos = (((long) field.sourceStart) << 32) | ((long) field.sourceEnd);
            SingleNameReference nameRef = new SingleNameReference(field.name, fieldPos);
            assigns.add(nameRef);
            Argument parameter = new Argument(field.name, fieldPos, EclipseHandlerUtil.copyType(field.type, source), 16);
            parameter.annotations = EclipseHandlerUtil.copyAnnotations(source, EclipseHandlerUtil.findCopyableAnnotations(fieldNode));
            params.add(parameter);
        }
        statement.arguments = assigns.isEmpty() ? null : (Expression[]) assigns.toArray(new Expression[0]);
        constructor.arguments = params.isEmpty() ? null : (Argument[]) params.toArray(new Argument[0]);
        constructor.statements = new Statement[]{new ReturnStatement(statement, (int) (p >> 32), (int) p)};
        EclipseHandlerUtil.createRelevantNonNullAnnotation(type, constructor);
        constructor.traverse(new SetGeneratedByVisitor(source), typeDecl.scope);
        return constructor;
    }
}
