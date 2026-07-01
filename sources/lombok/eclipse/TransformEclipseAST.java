package lombok.eclipse;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import lombok.ConfigurationKeys;
import lombok.core.LombokConfiguration;
import lombok.core.debug.DebugSnapshotStore;
import lombok.core.debug.HistogramTracker;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.patcher.Symbols;
import lombok.permit.Permit;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.parser.Parser;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/TransformEclipseAST.SCL.lombok */
public class TransformEclipseAST {
    private final EclipseAST ast;
    private static final Field astCacheField;
    private static final HandlerLibrary handlers;
    public static boolean disableLombok;
    private static final HistogramTracker lombokTracker;
    private static Map<CompilationUnitDeclaration, State> transformationStates = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/TransformEclipseAST$State.SCL.lombok */
    private enum State {
        DIET,
        FULL;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    static {
        disableLombok = false;
        String v = System.getProperty("lombok.histogram");
        if (v == null) {
            lombokTracker = null;
        } else if (v.toLowerCase().equals("sysout")) {
            lombokTracker = new HistogramTracker("lombok.histogram", System.out);
        } else {
            lombokTracker = new HistogramTracker("lombok.histogram");
        }
        Field f = null;
        HandlerLibrary h = null;
        if (System.getProperty("lombok.disable") != null) {
            disableLombok = true;
            astCacheField = null;
            handlers = null;
            return;
        }
        try {
            h = HandlerLibrary.load();
        } catch (Throwable t) {
            try {
                EclipseHandlerUtil.error(null, "Problem initializing lombok", t);
            } catch (Throwable unused) {
                System.err.println("Problem initializing lombok");
                t.printStackTrace();
            }
            disableLombok = true;
        }
        try {
            f = Permit.getField(CompilationUnitDeclaration.class, "$lombokAST");
        } catch (Throwable unused2) {
        }
        astCacheField = f;
        handlers = h;
    }

    public static void transform_swapped(CompilationUnitDeclaration ast, Parser parser) {
        transform(parser, ast);
    }

    public static EclipseAST getAST(CompilationUnitDeclaration ast, boolean forceRebuild) {
        EclipseAST existing = null;
        if (astCacheField != null) {
            try {
                existing = (EclipseAST) astCacheField.get(ast);
            } catch (Exception unused) {
            }
        }
        if (existing == null) {
            existing = new EclipseAST(ast);
            if (astCacheField != null) {
                try {
                    astCacheField.set(ast, existing);
                } catch (Exception unused2) {
                }
            }
        } else {
            existing.rebuild(forceRebuild);
        }
        return existing;
    }

    public static boolean alreadyTransformed(CompilationUnitDeclaration ast) {
        State state = transformationStates.get(ast);
        if (state == State.FULL) {
            return true;
        }
        if (state == State.DIET) {
            if (!EclipseAST.isComplete(ast)) {
                return true;
            }
            transformationStates.put(ast, State.FULL);
            return false;
        }
        transformationStates.put(ast, State.DIET);
        return false;
    }

    public static void transform(Parser parser, CompilationUnitDeclaration ast) {
        if (disableLombok || Symbols.hasSymbol("lombok.disable") || alreadyTransformed(ast) || Boolean.TRUE.equals(LombokConfiguration.read(ConfigurationKeys.LOMBOK_DISABLE, EclipseAST.getAbsoluteFileLocation(ast)))) {
            return;
        }
        try {
            DebugSnapshotStore.INSTANCE.snapshot(ast, "transform entry", new Object[0]);
            long histoToken = lombokTracker == null ? 0L : lombokTracker.start();
            EclipseAST existing = getAST(ast, false);
            new TransformEclipseAST(existing).go();
            if (lombokTracker != null) {
                lombokTracker.end(histoToken);
            }
            DebugSnapshotStore.INSTANCE.snapshot(ast, "transform exit", new Object[0]);
        } catch (Throwable t) {
            DebugSnapshotStore.INSTANCE.snapshot(ast, "transform error: %s", t.getClass().getSimpleName());
            try {
                String message = "Lombok can't parse this source: " + t.toString();
                EclipseAST.addProblemToCompilationResult(ast.getFileName(), ast.compilationResult, false, message, 0, 0);
                t.printStackTrace();
            } catch (Throwable t2) {
                try {
                    EclipseHandlerUtil.error(ast, "Can't create an error in the problems dialog while adding: " + t.toString(), t2);
                } catch (Throwable unused) {
                    disableLombok = true;
                }
            }
        }
    }

    public TransformEclipseAST(EclipseAST ast) {
        this.ast = ast;
    }

    public void go() {
        long nextPriority = Long.MIN_VALUE;
        for (Long d : handlers.getPriorities()) {
            if (nextPriority <= d.longValue()) {
                AnnotationVisitor visitor = new AnnotationVisitor(d.longValue());
                this.ast.traverse(visitor);
                long nextPriority2 = visitor.getNextPriority();
                nextPriority = Math.min(nextPriority2, handlers.callASTVisitors(this.ast, d.longValue(), this.ast.isCompleteParse()));
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/TransformEclipseAST$AnnotationVisitor.SCL.lombok */
    private static class AnnotationVisitor extends EclipseASTAdapter {
        private final long priority;
        private long nextPriority = RecyclerView.FOREVER_NS;

        public AnnotationVisitor(long priority) {
            this.priority = priority;
        }

        public long getNextPriority() {
            return this.nextPriority;
        }

        @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
        public void visitAnnotationOnField(FieldDeclaration field, EclipseNode annotationNode, Annotation annotation) {
            CompilationUnitDeclaration top = annotationNode.top().get();
            this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.handlers.handleAnnotation(top, annotationNode, annotation, this.priority));
        }

        @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
        public void visitAnnotationOnMethodArgument(Argument arg, AbstractMethodDeclaration method, EclipseNode annotationNode, Annotation annotation) {
            CompilationUnitDeclaration top = annotationNode.top().get();
            this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.handlers.handleAnnotation(top, annotationNode, annotation, this.priority));
        }

        @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
        public void visitAnnotationOnLocal(LocalDeclaration local, EclipseNode annotationNode, Annotation annotation) {
            CompilationUnitDeclaration top = annotationNode.top().get();
            this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.handlers.handleAnnotation(top, annotationNode, annotation, this.priority));
        }

        @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
        public void visitAnnotationOnMethod(AbstractMethodDeclaration method, EclipseNode annotationNode, Annotation annotation) {
            CompilationUnitDeclaration top = annotationNode.top().get();
            this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.handlers.handleAnnotation(top, annotationNode, annotation, this.priority));
        }

        @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
        public void visitAnnotationOnType(TypeDeclaration type, EclipseNode annotationNode, Annotation annotation) {
            CompilationUnitDeclaration top = annotationNode.top().get();
            this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.handlers.handleAnnotation(top, annotationNode, annotation, this.priority));
        }

        @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
        public void visitAnnotationOnTypeUse(TypeReference typeUse, EclipseNode annotationNode, Annotation annotation) {
            CompilationUnitDeclaration top = annotationNode.top().get();
            this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.handlers.handleAnnotation(top, annotationNode, annotation, this.priority));
        }
    }
}
