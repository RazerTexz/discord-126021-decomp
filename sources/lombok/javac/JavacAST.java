package lombok.javac;

import com.sun.tools.javac.code.Source;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.Log;
import com.sun.tools.javac.util.Name;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import lombok.core.AST;
import lombok.core.CleanupRegistry;
import lombok.core.CleanupTask;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacAST.SCL.lombok */
public class JavacAST extends AST<JavacAST, JavacNode, JCTree> {
    private final CleanupRegistry cleanup;
    private final JavacElements elements;
    private final JavacTreeMaker treeMaker;
    private final Symtab symtab;
    private final JavacTypes javacTypes;
    private final Log log;
    private final ErrorLog errorLogger;
    private final Context context;
    private URI memoizedAbsoluteFileLocation;
    private static Field JCTRY_RESOURCES_FIELD;
    private static Field JCANNOTATEDTYPE_ANNOTATIONS;
    private static Field JCANNOTATEDTYPE_UNDERLYINGTYPE;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$javax$tools$Diagnostic$Kind;
    private static final URI NOT_CALCULATED_MARKER = URI.create("https://projectlombok.org/not/calculated");
    private static boolean JCTRY_RESOURCES_FIELD_INITIALIZED = false;
    private static boolean JCANNOTATEDTYPE_FIELDS_INITIALIZED = false;
    private static final ConcurrentMap<Class<?>, Method> getBodyMethods = new ConcurrentHashMap();

    @Override // lombok.core.AST
    protected /* bridge */ /* synthetic */ void setElementInASTCollection(Field field, Object obj, List list, Collection collection, int i, JCTree jCTree) throws IllegalAccessException {
        setElementInASTCollection2(field, obj, (List<Collection<?>>) list, (Collection<?>) collection, i, jCTree);
    }

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

    static /* synthetic */ int[] $SWITCH_TABLE$javax$tools$Diagnostic$Kind() {
        int[] iArr = $SWITCH_TABLE$javax$tools$Diagnostic$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Diagnostic.Kind.values().length];
        try {
            iArr2[Diagnostic.Kind.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Diagnostic.Kind.MANDATORY_WARNING.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Diagnostic.Kind.NOTE.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Diagnostic.Kind.OTHER.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Diagnostic.Kind.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$javax$tools$Diagnostic$Kind = iArr2;
        return iArr2;
    }

    public JavacAST(Messager messager, Context context, JCTree.JCCompilationUnit top, CleanupRegistry cleanup) {
        super(sourceName(top), PackageName.getPackageName(top), new JavacImportList(top), statementTypes());
        this.memoizedAbsoluteFileLocation = NOT_CALCULATED_MARKER;
        setTop(buildCompilationUnit(top));
        this.context = context;
        this.log = Log.instance(context);
        this.errorLogger = ErrorLog.create(messager, this.log);
        this.elements = JavacElements.instance(context);
        this.treeMaker = new JavacTreeMaker(TreeMaker.instance(context));
        this.symtab = Symtab.instance(context);
        this.javacTypes = JavacTypes.instance(context);
        this.cleanup = cleanup;
        clearChanged();
    }

    @Override // lombok.core.AST
    public URI getAbsoluteFileLocation() {
        if (this.memoizedAbsoluteFileLocation == NOT_CALCULATED_MARKER) {
            this.memoizedAbsoluteFileLocation = getAbsoluteFileLocation(top().get());
        }
        return this.memoizedAbsoluteFileLocation;
    }

    public static URI getAbsoluteFileLocation(JCTree.JCCompilationUnit cu) {
        try {
            return cu.sourcefile.toUri();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String sourceName(JCTree.JCCompilationUnit cu) {
        if (cu.sourcefile == null) {
            return null;
        }
        return cu.sourcefile.toString();
    }

    public Context getContext() {
        return this.context;
    }

    public void traverse(JavacASTVisitor visitor) {
        top().traverse(visitor);
    }

    void traverseChildren(JavacASTVisitor visitor, JavacNode node) {
        for (JavacNode child : node.down()) {
            child.traverse(visitor);
        }
    }

    @Override // lombok.core.AST
    public int getSourceVersion() {
        try {
            String nm = Source.instance(this.context).name();
            int underscoreIdx = nm.indexOf(95);
            return underscoreIdx > -1 ? Integer.parseInt(nm.substring(underscoreIdx + 1)) : Integer.parseInt(nm);
        } catch (Exception unused) {
            return 6;
        }
    }

    @Override // lombok.core.AST
    public int getLatestJavaSpecSupported() {
        return Javac.getJavaCompilerVersion();
    }

    public void cleanupTask(String key, JCTree target, CleanupTask task) {
        this.cleanup.registerTask(key, target, task);
    }

    public Name toName(String name) {
        return this.elements.getName(name);
    }

    public JavacTreeMaker getTreeMaker() {
        this.treeMaker.at(-1);
        return this.treeMaker;
    }

    public Symtab getSymbolTable() {
        return this.symtab;
    }

    public JavacTypes getTypesUtil() {
        return this.javacTypes;
    }

    @Override // lombok.core.AST
    protected JavacNode buildTree(JCTree node, AST.Kind kind) {
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[kind.ordinal()]) {
            case 1:
                return buildCompilationUnit((JCTree.JCCompilationUnit) node);
            case 2:
                return buildType((JCTree.JCClassDecl) node);
            case 3:
                return buildField((JCTree.JCVariableDecl) node);
            case 4:
                return buildInitializer((JCTree.JCBlock) node);
            case 5:
                return buildMethod((JCTree.JCMethodDecl) node);
            case 6:
                return buildAnnotation((JCTree.JCAnnotation) node, false);
            case 7:
                return buildLocalVar((JCTree.JCVariableDecl) node, kind);
            case 8:
                return buildLocalVar((JCTree.JCVariableDecl) node, kind);
            case 9:
                return buildStatementOrExpression(node);
            case 10:
                return buildTypeUse(node);
            default:
                throw new AssertionError("Did not expect: " + kind);
        }
    }

    private JavacNode buildCompilationUnit(JCTree.JCCompilationUnit top) {
        List<JavacNode> childNodes = new ArrayList<>();
        for (JCTree s2 : top.defs) {
            if (s2 instanceof JCTree.JCClassDecl) {
                addIfNotNull(childNodes, buildType((JCTree.JCClassDecl) s2));
            }
        }
        return new JavacNode(this, top, childNodes, AST.Kind.COMPILATION_UNIT);
    }

    private JavacNode buildType(JCTree.JCClassDecl type) {
        if (setAndGetAsHandled(type)) {
            return null;
        }
        List<JavacNode> childNodes = new ArrayList<>();
        for (JCTree.JCAnnotation annotation : type.mods.annotations) {
            addIfNotNull(childNodes, buildAnnotation(annotation, false));
        }
        for (JCTree def : type.defs) {
            if (def instanceof JCTree.JCMethodDecl) {
                addIfNotNull(childNodes, buildMethod((JCTree.JCMethodDecl) def));
            } else if (def instanceof JCTree.JCClassDecl) {
                addIfNotNull(childNodes, buildType((JCTree.JCClassDecl) def));
            } else if (def instanceof JCTree.JCVariableDecl) {
                addIfNotNull(childNodes, buildField((JCTree.JCVariableDecl) def));
            } else if (def instanceof JCTree.JCBlock) {
                addIfNotNull(childNodes, buildInitializer((JCTree.JCBlock) def));
            }
        }
        return putInMap(new JavacNode(this, type, childNodes, AST.Kind.TYPE));
    }

    private JavacNode buildField(JCTree.JCVariableDecl field) {
        if (setAndGetAsHandled(field)) {
            return null;
        }
        List<JavacNode> childNodes = new ArrayList<>();
        for (JCTree.JCAnnotation annotation : field.mods.annotations) {
            addIfNotNull(childNodes, buildAnnotation(annotation, true));
        }
        addIfNotNull(childNodes, buildTypeUse(field.vartype));
        addIfNotNull(childNodes, buildExpression(field.init));
        return putInMap(new JavacNode(this, field, childNodes, AST.Kind.FIELD));
    }

    private JavacNode buildLocalVar(JCTree.JCVariableDecl local, AST.Kind kind) {
        if (setAndGetAsHandled(local)) {
            return null;
        }
        List<JavacNode> childNodes = new ArrayList<>();
        for (JCTree.JCAnnotation annotation : local.mods.annotations) {
            addIfNotNull(childNodes, buildAnnotation(annotation, true));
        }
        addIfNotNull(childNodes, buildTypeUse(local.vartype));
        addIfNotNull(childNodes, buildExpression(local.init));
        return putInMap(new JavacNode(this, local, childNodes, kind));
    }

    private JavacNode buildTypeUse(JCTree typeUse) {
        if (setAndGetAsHandled(typeUse) || typeUse == null) {
            return null;
        }
        if (typeUse.getClass().getName().equals("com.sun.tools.javac.tree.JCTree$JCAnnotatedType")) {
            initJcAnnotatedType(typeUse.getClass());
            Collection<?> anns = (Collection) Permit.permissiveReadField(Collection.class, JCANNOTATEDTYPE_ANNOTATIONS, typeUse);
            JCTree.JCExpression underlying = (JCTree.JCExpression) Permit.permissiveReadField(JCTree.JCExpression.class, JCANNOTATEDTYPE_UNDERLYINGTYPE, typeUse);
            List<JavacNode> childNodes = new ArrayList<>();
            if (anns != null) {
                for (Object annotation : anns) {
                    if (annotation instanceof JCTree.JCAnnotation) {
                        addIfNotNull(childNodes, buildAnnotation((JCTree.JCAnnotation) annotation, true));
                    }
                }
            }
            addIfNotNull(childNodes, buildTypeUse(underlying));
            return putInMap(new JavacNode(this, typeUse, childNodes, AST.Kind.TYPE_USE));
        }
        if (typeUse instanceof JCTree.JCWildcard) {
            JCTree inner = ((JCTree.JCWildcard) typeUse).inner;
            List<JavacNode> childNodes2 = inner == null ? Collections.emptyList() : new ArrayList<>();
            if (inner != null) {
                addIfNotNull(childNodes2, buildTypeUse(inner));
            }
            return putInMap(new JavacNode(this, typeUse, childNodes2, AST.Kind.TYPE_USE));
        }
        if (typeUse instanceof JCTree.JCArrayTypeTree) {
            JCTree.JCExpression jCExpression = ((JCTree.JCArrayTypeTree) typeUse).elemtype;
            List<JavacNode> childNodes3 = jCExpression == null ? Collections.emptyList() : new ArrayList<>();
            if (jCExpression != null) {
                addIfNotNull(childNodes3, buildTypeUse(jCExpression));
            }
            return putInMap(new JavacNode(this, typeUse, childNodes3, AST.Kind.TYPE_USE));
        }
        if (typeUse instanceof JCTree.JCFieldAccess) {
            JCTree.JCExpression jCExpression2 = ((JCTree.JCFieldAccess) typeUse).selected;
            List<JavacNode> childNodes4 = jCExpression2 == null ? Collections.emptyList() : new ArrayList<>();
            if (jCExpression2 != null) {
                addIfNotNull(childNodes4, buildTypeUse(jCExpression2));
            }
            return putInMap(new JavacNode(this, typeUse, childNodes4, AST.Kind.TYPE_USE));
        }
        if (typeUse instanceof JCTree.JCIdent) {
            return putInMap(new JavacNode(this, typeUse, Collections.emptyList(), AST.Kind.TYPE_USE));
        }
        return null;
    }

    private static List<JCTree> getResourcesForTryNode(JCTree.JCTry tryNode) {
        if (!JCTRY_RESOURCES_FIELD_INITIALIZED) {
            JCTRY_RESOURCES_FIELD = Permit.permissiveGetField(JCTree.JCTry.class, "resources");
            JCTRY_RESOURCES_FIELD_INITIALIZED = true;
        }
        if (JCTRY_RESOURCES_FIELD == null) {
            return Collections.emptyList();
        }
        Object rv = null;
        try {
            rv = JCTRY_RESOURCES_FIELD.get(tryNode);
        } catch (Exception unused) {
        }
        return rv instanceof List ? (List) rv : Collections.emptyList();
    }

    private static void initJcAnnotatedType(Class<?> context) {
        if (JCANNOTATEDTYPE_FIELDS_INITIALIZED) {
            return;
        }
        JCANNOTATEDTYPE_ANNOTATIONS = Permit.permissiveGetField(context, "annotations");
        JCANNOTATEDTYPE_UNDERLYINGTYPE = Permit.permissiveGetField(context, "underlyingType");
        JCANNOTATEDTYPE_FIELDS_INITIALIZED = true;
    }

    private JavacNode buildTry(JCTree.JCTry tryNode) {
        if (setAndGetAsHandled(tryNode)) {
            return null;
        }
        List<JavacNode> childNodes = new ArrayList<>();
        for (JCTree varDecl : getResourcesForTryNode(tryNode)) {
            if (varDecl instanceof JCTree.JCVariableDecl) {
                addIfNotNull(childNodes, buildLocalVar((JCTree.JCVariableDecl) varDecl, AST.Kind.LOCAL));
            }
        }
        addIfNotNull(childNodes, buildStatement(tryNode.body));
        for (JCTree.JCCatch jcc : tryNode.catchers) {
            addIfNotNull(childNodes, buildTree((JCTree) jcc, AST.Kind.STATEMENT));
        }
        addIfNotNull(childNodes, buildStatement(tryNode.finalizer));
        return putInMap(new JavacNode(this, tryNode, childNodes, AST.Kind.STATEMENT));
    }

    private JavacNode buildInitializer(JCTree.JCBlock initializer) {
        if (setAndGetAsHandled(initializer)) {
            return null;
        }
        List<JavacNode> childNodes = new ArrayList<>();
        for (JCTree.JCStatement statement : initializer.stats) {
            addIfNotNull(childNodes, buildStatement(statement));
        }
        return putInMap(new JavacNode(this, initializer, childNodes, AST.Kind.INITIALIZER));
    }

    private JavacNode buildMethod(JCTree.JCMethodDecl method) {
        if (setAndGetAsHandled(method)) {
            return null;
        }
        List<JavacNode> childNodes = new ArrayList<>();
        for (JCTree.JCAnnotation annotation : method.mods.annotations) {
            addIfNotNull(childNodes, buildAnnotation(annotation, false));
        }
        for (JCTree.JCVariableDecl param : method.params) {
            addIfNotNull(childNodes, buildLocalVar(param, AST.Kind.ARGUMENT));
        }
        if (method.body != null && method.body.stats != null) {
            for (JCTree.JCStatement statement : method.body.stats) {
                addIfNotNull(childNodes, buildStatement(statement));
            }
        }
        return putInMap(new JavacNode(this, method, childNodes, AST.Kind.METHOD));
    }

    private JavacNode buildAnnotation(JCTree.JCAnnotation annotation, boolean varDecl) {
        boolean handled = setAndGetAsHandled(annotation);
        if (!varDecl && handled) {
            return null;
        }
        return putInMap(new JavacNode(this, annotation, null, AST.Kind.ANNOTATION));
    }

    private JavacNode buildExpression(JCTree.JCExpression expression) {
        return buildStatementOrExpression(expression);
    }

    private JavacNode buildStatement(JCTree.JCStatement statement) {
        return buildStatementOrExpression(statement);
    }

    private JavacNode buildStatementOrExpression(JCTree statement) {
        if (statement == null || (statement instanceof JCTree.JCAnnotation)) {
            return null;
        }
        if (statement instanceof JCTree.JCClassDecl) {
            return buildType((JCTree.JCClassDecl) statement);
        }
        if (statement instanceof JCTree.JCVariableDecl) {
            return buildLocalVar((JCTree.JCVariableDecl) statement, AST.Kind.LOCAL);
        }
        if (statement instanceof JCTree.JCTry) {
            return buildTry((JCTree.JCTry) statement);
        }
        if (statement.getClass().getName().equals("com.sun.tools.javac.tree.JCTree$JCLambda")) {
            return buildLambda(statement);
        }
        if (setAndGetAsHandled(statement)) {
            return null;
        }
        return drill(statement);
    }

    private JavacNode buildLambda(JCTree jcTree) {
        return buildStatementOrExpression(getBody(jcTree));
    }

    private JCTree getBody(JCTree jcTree) {
        try {
            return (JCTree) getBodyMethod(jcTree.getClass()).invoke(jcTree, new Object[0]);
        } catch (Exception e) {
            throw Javac.sneakyThrow(e);
        }
    }

    private Method getBodyMethod(Class<?> c) {
        Method m = getBodyMethods.get(c);
        if (m != null) {
            return m;
        }
        try {
            getBodyMethods.putIfAbsent(c, Permit.getMethod(c, "getBody", new Class[0]));
            return getBodyMethods.get(c);
        } catch (NoSuchMethodException e) {
            throw Javac.sneakyThrow(e);
        }
    }

    private JavacNode drill(JCTree statement) {
        try {
            List<JavacNode> childNodes = new ArrayList<>();
            for (AST.FieldAccess fa : fieldsOf(statement.getClass())) {
                childNodes.addAll(buildWithField(JavacNode.class, statement, fa));
            }
            return putInMap(new JavacNode(this, statement, childNodes, AST.Kind.STATEMENT));
        } catch (OutOfMemoryError oome) {
            String msg = oome.getMessage();
            if (msg == null) {
                msg = "(no original message)";
            }
            OutOfMemoryError newError = new OutOfMemoryError(String.valueOf(getFileName()) + "@pos" + statement.getPreferredPosition() + ": " + msg);
            throw newError;
        }
    }

    private static Collection<Class<? extends JCTree>> statementTypes() {
        Collection<Class<? extends JCTree>> collection = new ArrayList<>(3);
        collection.add(JCTree.JCStatement.class);
        collection.add(JCTree.JCExpression.class);
        collection.add(JCTree.JCCatch.class);
        return collection;
    }

    private static void addIfNotNull(Collection<JavacNode> nodes, JavacNode node) {
        if (node != null) {
            nodes.add(node);
        }
    }

    void removeDeferredErrors(JavacNode node) {
        JCDiagnostic.DiagnosticPosition pos = node.get().pos();
        JCTree.JCCompilationUnit top = top().get();
        removeFromDeferredDiagnostics(pos.getStartPosition(), Javac.getEndPosition(pos, top));
    }

    void printMessage(Diagnostic.Kind kind, String message, JavacNode node, JCDiagnostic.DiagnosticPosition pos, boolean attemptToRemoveErrorsInRange) {
        JavaFileObject oldSource = null;
        JCTree astObject = node == null ? null : node.get();
        JCTree.JCCompilationUnit top = top().get();
        JavaFileObject newSource = top.sourcefile;
        if (newSource != null) {
            oldSource = this.log.useSource(newSource);
            if (pos == null) {
                pos = astObject.pos();
            }
        }
        if (pos != null && node != null && attemptToRemoveErrorsInRange) {
            removeFromDeferredDiagnostics(pos.getStartPosition(), node.getEndPosition(pos));
        }
        try {
            switch ($SWITCH_TABLE$javax$tools$Diagnostic$Kind()[kind.ordinal()]) {
                case 1:
                    this.errorLogger.error(pos, message);
                    break;
                case 2:
                    this.errorLogger.warning(pos, message);
                    break;
                case 3:
                    this.errorLogger.mandatoryWarning(pos, message);
                    break;
                case 4:
                default:
                    this.errorLogger.note(pos, message);
                    break;
            }
        } finally {
            if (newSource != null) {
                this.log.useSource(oldSource);
            }
        }
    }

    public void removeFromDeferredDiagnostics(int startPos, int endPos) {
        JCTree.JCCompilationUnit self = top().get();
        new CompilerMessageSuppressor(getContext()).removeAllBetween(self.sourcefile, startPos, endPos);
    }

    /* JADX INFO: renamed from: setElementInASTCollection, reason: avoid collision after fix types in other method */
    protected void setElementInASTCollection2(Field field, Object refField, List<Collection<?>> chain, Collection<?> collection, int idx, JCTree newN) throws IllegalAccessException {
        com.sun.tools.javac.util.List<?> list = setElementInConsList(chain, collection, ((List) collection).get(idx), newN);
        field.set(refField, list);
    }

    private com.sun.tools.javac.util.List<?> setElementInConsList(List<Collection<?>> chain, Collection<?> current, Object oldO, Object newO) {
        com.sun.tools.javac.util.List<?> oldL = (com.sun.tools.javac.util.List) current;
        com.sun.tools.javac.util.List<?> newL = replaceInConsList(oldL, oldO, newO);
        if (chain.isEmpty()) {
            return newL;
        }
        List<Collection<?>> reducedChain = new ArrayList<>(chain);
        Collection<?> newCurrent = reducedChain.remove(reducedChain.size() - 1);
        return setElementInConsList(reducedChain, newCurrent, oldL, newL);
    }

    private com.sun.tools.javac.util.List<?> replaceInConsList(com.sun.tools.javac.util.List<?> oldL, Object oldO, Object newO) {
        boolean repl = false;
        Object[] a = oldL.toArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == oldO) {
                a[i] = newO;
                repl = true;
            }
        }
        return repl ? com.sun.tools.javac.util.List.from(a) : oldL;
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacAST$ErrorLog.SCL.lombok */
    static abstract class ErrorLog {
        final Log log;
        private final Messager messager;
        private final Field errorCount;
        private final Field warningCount;

        abstract void error1(JCDiagnostic.DiagnosticPosition diagnosticPosition, String str);

        abstract void warning1(JCDiagnostic.DiagnosticPosition diagnosticPosition, String str);

        abstract void mandatoryWarning1(JCDiagnostic.DiagnosticPosition diagnosticPosition, String str);

        abstract void note(JCDiagnostic.DiagnosticPosition diagnosticPosition, String str);

        private ErrorLog(Log log, Messager messager, Field errorCount, Field warningCount) {
            this.log = log;
            this.messager = messager;
            this.errorCount = errorCount;
            this.warningCount = warningCount;
        }

        /* synthetic */ ErrorLog(Log log, Messager messager, Field field, Field field2, ErrorLog errorLog) {
            this(log, messager, field, field2);
        }

        final void error(JCDiagnostic.DiagnosticPosition pos, String message) {
            increment(this.errorCount);
            error1(pos, message);
        }

        final void warning(JCDiagnostic.DiagnosticPosition pos, String message) {
            increment(this.warningCount);
            warning1(pos, message);
        }

        final void mandatoryWarning(JCDiagnostic.DiagnosticPosition pos, String message) {
            increment(this.warningCount);
            mandatoryWarning1(pos, message);
        }

        private void increment(Field field) {
            if (field == null) {
                return;
            }
            try {
                int val = ((Number) field.get(this.messager)).intValue();
                field.set(this.messager, Integer.valueOf(val + 1));
            } catch (Throwable unused) {
            }
        }

        static ErrorLog create(Messager messager, Log log) {
            Field errorCount;
            Field warningCount;
            try {
                errorCount = Permit.getField(messager.getClass(), "errorCount");
            } catch (Throwable unused) {
                errorCount = null;
            }
            boolean hasMultipleErrors = false;
            for (Field field : log.getClass().getFields()) {
                if (field.getName().equals("multipleErrors")) {
                    hasMultipleErrors = true;
                    break;
                }
            }
            if (hasMultipleErrors) {
                return new JdkBefore9(log, messager, errorCount, null);
            }
            try {
                warningCount = Permit.getField(messager.getClass(), "warningCount");
            } catch (Throwable unused2) {
                warningCount = null;
            }
            return new Jdk9Plus(log, messager, errorCount, warningCount, null);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacAST$JdkBefore9.SCL.lombok */
    static class JdkBefore9 extends ErrorLog {
        /* synthetic */ JdkBefore9(Log log, Messager messager, Field field, JdkBefore9 jdkBefore9) {
            this(log, messager, field);
        }

        private JdkBefore9(Log log, Messager messager, Field errorCount) {
            super(log, messager, errorCount, null, null);
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void error1(JCDiagnostic.DiagnosticPosition pos, String message) {
            boolean prev = this.log.multipleErrors;
            this.log.multipleErrors = true;
            try {
                this.log.error(pos, "proc.messager", new Object[]{message});
            } finally {
                this.log.multipleErrors = prev;
            }
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void warning1(JCDiagnostic.DiagnosticPosition pos, String message) {
            this.log.warning(pos, "proc.messager", new Object[]{message});
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void mandatoryWarning1(JCDiagnostic.DiagnosticPosition pos, String message) {
            this.log.mandatoryWarning(pos, "proc.messager", new Object[]{message});
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void note(JCDiagnostic.DiagnosticPosition pos, String message) {
            this.log.note(pos, "proc.messager", new Object[]{message});
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacAST$Jdk9Plus.SCL.lombok */
    static class Jdk9Plus extends ErrorLog {
        private static final String PROC_MESSAGER = "proc.messager";
        private Object multiple;
        private Method errorMethod;
        private Method warningMethod;
        private Method mandatoryWarningMethod;
        private Method noteMethod;
        private Method errorKey;
        private Method warningKey;
        private Method noteKey;
        private JCDiagnostic.Factory diags;

        /* synthetic */ Jdk9Plus(Log log, Messager messager, Field field, Field field2, Jdk9Plus jdk9Plus) {
            this(log, messager, field, field2);
        }

        private Jdk9Plus(Log log, Messager messager, Field errorCount, Field warningCount) {
            super(log, messager, errorCount, warningCount, null);
            try {
                Class<?> df = Class.forName("com.sun.tools.javac.util.JCDiagnostic$DiagnosticFlag");
                for (Object constant : df.getEnumConstants()) {
                    if (constant.toString().equals("MULTIPLE")) {
                        this.multiple = constant;
                    }
                }
                Class<?> errorCls = Class.forName("com.sun.tools.javac.util.JCDiagnostic$Error");
                Class<?> warningCls = Class.forName("com.sun.tools.javac.util.JCDiagnostic$Warning");
                Class<?> noteCls = Class.forName("com.sun.tools.javac.util.JCDiagnostic$Note");
                Class<?> lc = log.getClass();
                this.errorMethod = Permit.getMethod(lc, "error", df, JCDiagnostic.DiagnosticPosition.class, errorCls);
                this.warningMethod = Permit.getMethod(lc, "warning", JCDiagnostic.DiagnosticPosition.class, warningCls);
                this.mandatoryWarningMethod = Permit.getMethod(lc, "mandatoryWarning", JCDiagnostic.DiagnosticPosition.class, warningCls);
                this.noteMethod = Permit.getMethod(lc, "note", JCDiagnostic.DiagnosticPosition.class, noteCls);
                Field diagsField = Permit.getField(lc.getSuperclass(), "diags");
                this.diags = (JCDiagnostic.Factory) diagsField.get(log);
                Class<?> dc = this.diags.getClass();
                this.errorKey = Permit.getMethod(dc, "errorKey", String.class, Object[].class);
                this.warningKey = Permit.getMethod(dc, "warningKey", String.class, Object[].class);
                this.noteKey = Permit.getMethod(dc, "noteKey", String.class, Object[].class);
            } catch (Throwable unused) {
            }
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void error1(JCDiagnostic.DiagnosticPosition pos, String message) {
            try {
                Object error = this.errorKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
                this.errorMethod.invoke(this.log, this.multiple, pos, error);
            } catch (Throwable unused) {
            }
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void warning1(JCDiagnostic.DiagnosticPosition pos, String message) {
            try {
                Object warning = this.warningKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
                this.warningMethod.invoke(this.log, pos, warning);
            } catch (Throwable unused) {
            }
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void mandatoryWarning1(JCDiagnostic.DiagnosticPosition pos, String message) {
            try {
                Object warning = this.warningKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
                this.mandatoryWarningMethod.invoke(this.log, pos, warning);
            } catch (Throwable unused) {
            }
        }

        @Override // lombok.javac.JavacAST.ErrorLog
        void note(JCDiagnostic.DiagnosticPosition pos, String message) {
            try {
                Object note = this.noteKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
                this.noteMethod.invoke(this.log, pos, note);
            } catch (Throwable unused) {
            }
        }
    }
}
