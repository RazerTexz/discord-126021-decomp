package lombok.eclipse;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.Lombok;
import lombok.core.AST;
import lombok.core.LombokImmutableList;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.permit.Permit;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAST.SCL.lombok */
public class EclipseAST extends AST<EclipseAST, EclipseNode, ASTNode> {
    private static volatile boolean skipEclipseWorkspaceBasedFileResolver = false;
    private static final URI NOT_CALCULATED_MARKER = URI.create("https://projectlombok.org/not/calculated");
    private URI memoizedAbsoluteFileLocation;
    private final List<ParseProblem> queuedProblems;
    private final CompilationUnitDeclaration compilationUnitDeclaration;
    private boolean completeParse;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST.Kind.valuesCustom().length];
        try {
            iArr2[AST.Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST.Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST.Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST.Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST.Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST.Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST.Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST.Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST.Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST.Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    public EclipseAST(CompilationUnitDeclaration ast) {
        super(toFileName(ast), packageDeclaration(ast), new EclipseImportList(ast), statementTypes());
        this.memoizedAbsoluteFileLocation = NOT_CALCULATED_MARKER;
        this.queuedProblems = new ArrayList();
        this.compilationUnitDeclaration = ast;
        setTop(buildCompilationUnit(ast));
        this.completeParse = isComplete(ast);
        clearChanged();
    }

    public static URI getAbsoluteFileLocation(CompilationUnitDeclaration ast) {
        return getAbsoluteFileLocation0(ast);
    }

    @Override // lombok.core.AST
    public URI getAbsoluteFileLocation() {
        if (this.memoizedAbsoluteFileLocation != NOT_CALCULATED_MARKER) {
            return this.memoizedAbsoluteFileLocation;
        }
        this.memoizedAbsoluteFileLocation = getAbsoluteFileLocation0(this.compilationUnitDeclaration);
        return this.memoizedAbsoluteFileLocation;
    }

    private static URI getAbsoluteFileLocation0(CompilationUnitDeclaration ast) {
        String fileName = toFileName(ast);
        if (fileName != null && (fileName.startsWith("file:") || fileName.startsWith("sourcecontrol:"))) {
            return URI.create(fileName);
        }
        if (!skipEclipseWorkspaceBasedFileResolver) {
            try {
                try {
                    return EclipseWorkspaceBasedFileResolver.resolve(fileName);
                } catch (IllegalArgumentException e) {
                    EclipseHandlerUtil.warning("Finding 'lombok.config' file failed for '" + fileName + "'", e);
                    return new File(fileName).getAbsoluteFile().toURI();
                }
            } catch (NoClassDefFoundError unused) {
                skipEclipseWorkspaceBasedFileResolver = true;
            }
        }
        try {
            return new File(fileName).getAbsoluteFile().toURI();
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAST$EclipseWorkspaceBasedFileResolver.SCL.lombok */
    private static class EclipseWorkspaceBasedFileResolver {
        private EclipseWorkspaceBasedFileResolver() {
        }

        public static URI resolve(String path) {
            if (path == null || path.indexOf(47, 1) == -1) {
                return null;
            }
            try {
                return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path)).getLocationURI();
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private static String packageDeclaration(CompilationUnitDeclaration cud) {
        ImportReference pkg = cud.currentPackage;
        if (pkg == null) {
            return null;
        }
        return Eclipse.toQualifiedName(pkg.getImportName());
    }

    @Override // lombok.core.AST
    public int getSourceVersion() {
        long sl = this.compilationUnitDeclaration.problemReporter.options.sourceLevel;
        long sl2 = sl >> 16;
        long cl = this.compilationUnitDeclaration.problemReporter.options.complianceLevel >> 16;
        if (sl2 == 0) {
            sl2 = cl;
        }
        if (cl == 0) {
            cl = sl2;
        }
        return Math.min((int) (sl2 - 44), (int) (cl - 44));
    }

    @Override // lombok.core.AST
    public int getLatestJavaSpecSupported() {
        return Eclipse.getEcjCompilerVersion();
    }

    public void traverse(EclipseASTVisitor visitor) {
        top().traverse(visitor);
    }

    void traverseChildren(EclipseASTVisitor visitor, EclipseNode node) {
        LombokImmutableList<EclipseNode> children = node.down();
        int len = children.size();
        for (int i = 0; i < len; i++) {
            children.get(i).traverse(visitor);
        }
    }

    public boolean isCompleteParse() {
        return this.completeParse;
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAST$ParseProblem.SCL.lombok */
    class ParseProblem {
        final boolean isWarning;
        final String message;
        final int sourceStart;
        final int sourceEnd;

        ParseProblem(boolean isWarning, String message, int sourceStart, int sourceEnd) {
            this.isWarning = isWarning;
            this.message = message;
            this.sourceStart = sourceStart;
            this.sourceEnd = sourceEnd;
        }

        void addToCompilationResult() {
            CompilationUnitDeclaration cud = EclipseAST.this.top().get();
            EclipseAST.addProblemToCompilationResult(cud.getFileName(), cud.compilationResult, this.isWarning, this.message, this.sourceStart, this.sourceEnd);
        }
    }

    private void propagateProblems() {
        if (this.queuedProblems.isEmpty()) {
            return;
        }
        CompilationUnitDeclaration cud = top().get();
        if (cud.compilationResult == null) {
            return;
        }
        for (ParseProblem problem : this.queuedProblems) {
            problem.addToCompilationResult();
        }
        this.queuedProblems.clear();
    }

    void addProblem(ParseProblem problem) {
        this.queuedProblems.add(problem);
        propagateProblems();
    }

    public static void addProblemToCompilationResult(char[] fileNameArray, CompilationResult result, boolean isWarning, String message, int sourceStart, int sourceEnd) {
        try {
            EcjReflectionCheck.addProblemToCompilationResult.invoke(null, fileNameArray, result, Boolean.valueOf(isWarning), message, Integer.valueOf(sourceStart), Integer.valueOf(sourceEnd));
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(EcjReflectionCheck.problemAddProblemToCompilationResult);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3);
        }
    }

    public static Annotation[] getTopLevelTypeReferenceAnnotations(TypeReference tr) {
        Annotation[][] annss;
        Method m = EcjReflectionCheck.typeReferenceGetAnnotationsOnDimensions;
        if (m == null) {
            return null;
        }
        try {
            Annotation[][] annss2 = (Annotation[][]) m.invoke(tr, new Object[0]);
            if (annss2 != null) {
                return annss2[0];
            }
        } catch (Throwable unused) {
        }
        try {
            Field f = EcjReflectionCheck.typeReferenceAnnotations;
            if (f == null || (annss = (Annotation[][]) f.get(tr)) == null) {
                return null;
            }
            return annss[annss.length - 1];
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String toFileName(CompilationUnitDeclaration ast) {
        if (ast.compilationResult.fileName == null) {
            return null;
        }
        return new String(ast.compilationResult.fileName);
    }

    public void rebuild(boolean force) {
        propagateProblems();
        if (!this.completeParse || force) {
            boolean changed = isChanged();
            boolean newCompleteParse = isComplete(this.compilationUnitDeclaration);
            if (newCompleteParse || force) {
                top().rebuild();
                this.completeParse = newCompleteParse;
                if (!changed) {
                    clearChanged();
                }
            }
        }
    }

    public static boolean isComplete(CompilationUnitDeclaration unit) {
        return (unit.bits & 16) != 0;
    }

    @Override // lombok.core.AST
    protected EclipseNode buildTree(ASTNode node, AST.Kind kind) {
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[kind.ordinal()]) {
            case 1:
                return buildCompilationUnit((CompilationUnitDeclaration) node);
            case 2:
                return buildType((TypeDeclaration) node);
            case 3:
                return buildField((FieldDeclaration) node);
            case 4:
                return buildInitializer((Initializer) node);
            case 5:
                return buildMethod((AbstractMethodDeclaration) node);
            case 6:
                return buildAnnotation((Annotation) node, false);
            case 7:
                return buildLocal((Argument) node, kind);
            case 8:
                return buildLocal((LocalDeclaration) node, kind);
            case 9:
                return buildStatement((Statement) node);
            case 10:
                return buildTypeUse((TypeReference) node);
            default:
                throw new AssertionError("Did not expect to arrive here: " + kind);
        }
    }

    private EclipseNode buildCompilationUnit(CompilationUnitDeclaration top) {
        if (setAndGetAsHandled(top)) {
            return null;
        }
        List<EclipseNode> children = buildTypes(top.types);
        return putInMap(new EclipseNode(this, top, children, AST.Kind.COMPILATION_UNIT));
    }

    private void addIfNotNull(Collection<EclipseNode> collection, EclipseNode n) {
        if (n != null) {
            collection.add(n);
        }
    }

    private List<EclipseNode> buildTypes(TypeDeclaration[] children) {
        List<EclipseNode> childNodes = new ArrayList<>();
        if (children != null) {
            for (TypeDeclaration type : children) {
                addIfNotNull(childNodes, buildType(type));
            }
        }
        return childNodes;
    }

    private EclipseNode buildType(TypeDeclaration type) {
        if (setAndGetAsHandled(type)) {
            return null;
        }
        List<EclipseNode> childNodes = new ArrayList<>();
        childNodes.addAll(buildFields(type.fields));
        childNodes.addAll(buildTypes(type.memberTypes));
        childNodes.addAll(buildMethods(type.methods));
        childNodes.addAll(buildAnnotations(type.annotations, false));
        return putInMap(new EclipseNode(this, type, childNodes, AST.Kind.TYPE));
    }

    private Collection<EclipseNode> buildFields(FieldDeclaration[] children) {
        List<EclipseNode> childNodes = new ArrayList<>();
        if (children != null) {
            for (FieldDeclaration child : children) {
                addIfNotNull(childNodes, buildField(child));
            }
        }
        return childNodes;
    }

    private static <T> List<T> singleton(T item) {
        List<T> list = new ArrayList<>();
        if (item != null) {
            list.add(item);
        }
        return list;
    }

    private EclipseNode buildField(FieldDeclaration field) {
        if (field instanceof Initializer) {
            return buildInitializer((Initializer) field);
        }
        if (setAndGetAsHandled(field)) {
            return null;
        }
        List<EclipseNode> childNodes = new ArrayList<>();
        addIfNotNull(childNodes, buildTypeUse(field.type));
        addIfNotNull(childNodes, buildStatement(field.initialization));
        childNodes.addAll(buildAnnotations(field.annotations, true));
        return (EclipseNode) putInMap(new EclipseNode(this, field, childNodes, AST.Kind.FIELD));
    }

    private EclipseNode buildInitializer(Initializer initializer) {
        if (setAndGetAsHandled(initializer)) {
            return null;
        }
        return putInMap(new EclipseNode(this, initializer, singleton(buildStatement(initializer.block)), AST.Kind.INITIALIZER));
    }

    private Collection<EclipseNode> buildMethods(AbstractMethodDeclaration[] children) {
        List<EclipseNode> childNodes = new ArrayList<>();
        if (children != null) {
            for (AbstractMethodDeclaration method : children) {
                addIfNotNull(childNodes, buildMethod(method));
            }
        }
        return childNodes;
    }

    private EclipseNode buildMethod(AbstractMethodDeclaration method) {
        if (setAndGetAsHandled(method)) {
            return null;
        }
        List<EclipseNode> childNodes = new ArrayList<>();
        childNodes.addAll(buildArguments(method.arguments));
        if (method instanceof ConstructorDeclaration) {
            ConstructorDeclaration constructor = (ConstructorDeclaration) method;
            addIfNotNull(childNodes, buildStatement(constructor.constructorCall));
        }
        childNodes.addAll(buildStatements(method.statements));
        childNodes.addAll(buildAnnotations(method.annotations, false));
        return (EclipseNode) putInMap(new EclipseNode(this, method, childNodes, AST.Kind.METHOD));
    }

    private Collection<EclipseNode> buildArguments(Argument[] children) {
        List<EclipseNode> childNodes = new ArrayList<>();
        if (children != null) {
            for (Argument argument : children) {
                addIfNotNull(childNodes, buildLocal(argument, AST.Kind.ARGUMENT));
            }
        }
        return childNodes;
    }

    private EclipseNode buildLocal(LocalDeclaration local, AST.Kind kind) {
        if (setAndGetAsHandled(local)) {
            return null;
        }
        List<EclipseNode> childNodes = new ArrayList<>();
        addIfNotNull(childNodes, buildTypeUse(local.type));
        addIfNotNull(childNodes, buildStatement(local.initialization));
        childNodes.addAll(buildAnnotations(local.annotations, true));
        return (EclipseNode) putInMap(new EclipseNode(this, local, childNodes, kind));
    }

    private EclipseNode buildTypeUse(TypeReference tr) {
        TypeReference bound;
        if (setAndGetAsHandled(tr) || tr == null) {
            return null;
        }
        List<EclipseNode> childNodes = new ArrayList<>();
        Annotation[] anns = getTopLevelTypeReferenceAnnotations(tr);
        if (anns != null) {
            for (Annotation ann : anns) {
                addIfNotNull(childNodes, buildAnnotation(ann, false));
            }
        }
        if (tr instanceof ParameterizedQualifiedTypeReference) {
            ParameterizedQualifiedTypeReference pqtr = (ParameterizedQualifiedTypeReference) tr;
            int len = pqtr.tokens.length;
            for (int i = 0; i < len; i++) {
                TypeReference[] typeArgs = pqtr.typeArguments[i];
                if (typeArgs != null) {
                    for (TypeReference tArg : typeArgs) {
                        addIfNotNull(childNodes, buildTypeUse(tArg));
                    }
                }
            }
        } else if (tr instanceof ParameterizedSingleTypeReference) {
            ParameterizedSingleTypeReference pstr = (ParameterizedSingleTypeReference) tr;
            if (pstr.typeArguments != null) {
                for (TypeReference tArg2 : pstr.typeArguments) {
                    addIfNotNull(childNodes, buildTypeUse(tArg2));
                }
            }
        } else if ((tr instanceof Wildcard) && (bound = ((Wildcard) tr).bound) != null) {
            addIfNotNull(childNodes, buildTypeUse(bound));
        }
        return (EclipseNode) putInMap(new EclipseNode(this, tr, childNodes, AST.Kind.TYPE_USE));
    }

    private Collection<EclipseNode> buildAnnotations(Annotation[] annotations, boolean varDecl) {
        List<EclipseNode> elements = new ArrayList<>();
        if (annotations != null) {
            for (Annotation an : annotations) {
                addIfNotNull(elements, buildAnnotation(an, varDecl));
            }
        }
        return elements;
    }

    private EclipseNode buildAnnotation(Annotation annotation, boolean field) {
        if (annotation == null) {
            return null;
        }
        boolean handled = setAndGetAsHandled(annotation);
        if (!field && handled) {
            return null;
        }
        return putInMap(new EclipseNode(this, annotation, null, AST.Kind.ANNOTATION));
    }

    private Collection<EclipseNode> buildStatements(Statement[] children) {
        List<EclipseNode> childNodes = new ArrayList<>();
        if (children != null) {
            for (Statement child : children) {
                addIfNotNull(childNodes, buildStatement(child));
            }
        }
        return childNodes;
    }

    private EclipseNode buildStatement(Statement child) {
        if (child == null) {
            return null;
        }
        if (child instanceof TypeDeclaration) {
            return buildType((TypeDeclaration) child);
        }
        if (child instanceof LocalDeclaration) {
            return buildLocal((LocalDeclaration) child, AST.Kind.LOCAL);
        }
        if (setAndGetAsHandled(child)) {
            return null;
        }
        return drill(child);
    }

    private EclipseNode drill(Statement statement) {
        List<EclipseNode> childNodes = new ArrayList<>();
        for (AST.FieldAccess fa : fieldsOf(statement.getClass())) {
            childNodes.addAll(buildWithField(EclipseNode.class, statement, fa));
        }
        return putInMap(new EclipseNode(this, statement, childNodes, AST.Kind.STATEMENT));
    }

    private static Collection<Class<? extends ASTNode>> statementTypes() {
        return Collections.singleton(Statement.class);
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAST$EcjReflectionCheck.SCL.lombok */
    private static class EcjReflectionCheck {
        private static final String COMPILATIONRESULT_TYPE = "org.eclipse.jdt.internal.compiler.CompilationResult";
        public static final Method addProblemToCompilationResult;
        public static final Throwable problemAddProblemToCompilationResult;
        public static final Method typeReferenceGetAnnotationsOnDimensions;
        public static final Field typeReferenceAnnotations;

        private EcjReflectionCheck() {
        }

        static {
            Method m2;
            Field f;
            Throwable problem_ = null;
            Method m1 = null;
            try {
                m1 = Permit.getMethod(EclipseAstProblemView.class, "addProblemToCompilationResult", char[].class, Class.forName(COMPILATIONRESULT_TYPE), Boolean.TYPE, String.class, Integer.TYPE, Integer.TYPE);
            } catch (Throwable t) {
                problem_ = t;
            }
            try {
                m2 = Permit.getMethod(TypeReference.class, "getAnnotationsOnDimensions", new Class[0]);
            } catch (Throwable unused) {
                m2 = null;
            }
            try {
                f = Permit.getField(TypeReference.class, "annotations");
            } catch (Throwable unused2) {
                f = null;
            }
            addProblemToCompilationResult = m1;
            problemAddProblemToCompilationResult = problem_;
            typeReferenceGetAnnotationsOnDimensions = m2;
            typeReferenceAnnotations = f;
        }
    }
}
