package lombok.javac;

import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.processing.Messager;
import lombok.ConfigurationKeys;
import lombok.core.CleanupRegistry;
import lombok.core.LombokConfiguration;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTransformer.SCL.lombok */
public class JavacTransformer {
    private final HandlerLibrary handlers;
    private final Messager messager;

    public JavacTransformer(Messager messager, Trees trees) {
        this.messager = messager;
        this.handlers = HandlerLibrary.load(messager, trees);
    }

    public SortedSet<Long> getPriorities() {
        return this.handlers.getPriorities();
    }

    public SortedSet<Long> getPrioritiesRequiringResolutionReset() {
        return this.handlers.getPrioritiesRequiringResolutionReset();
    }

    public void transform(long priority, Context context, List<JCTree.JCCompilationUnit> compilationUnits, CleanupRegistry cleanup) {
        for (JCTree.JCCompilationUnit unit : compilationUnits) {
            if (!Boolean.TRUE.equals(LombokConfiguration.read(ConfigurationKeys.LOMBOK_DISABLE, JavacAST.getAbsoluteFileLocation(unit)))) {
                JavacAST ast = new JavacAST(this.messager, context, unit, cleanup);
                ast.traverse(new AnnotationVisitor(priority));
                this.handlers.callASTVisitors(ast, priority);
                if (ast.isChanged()) {
                    LombokOptions.markChanged(context, ast.top().get());
                }
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacTransformer$AnnotationVisitor.SCL.lombok */
    private class AnnotationVisitor extends JavacASTAdapter {
        private final long priority;

        AnnotationVisitor(long priority) {
            this.priority = priority;
        }

        @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
        public void visitAnnotationOnType(JCTree.JCClassDecl type, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
            JCTree.JCCompilationUnit top = annotationNode.top().get();
            JavacTransformer.this.handlers.handleAnnotation(top, annotationNode, annotation, this.priority);
        }

        @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
        public void visitAnnotationOnField(JCTree.JCVariableDecl field, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
            JCTree.JCCompilationUnit top = annotationNode.top().get();
            JavacTransformer.this.handlers.handleAnnotation(top, annotationNode, annotation, this.priority);
        }

        @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
        public void visitAnnotationOnMethod(JCTree.JCMethodDecl method, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
            JCTree.JCCompilationUnit top = annotationNode.top().get();
            JavacTransformer.this.handlers.handleAnnotation(top, annotationNode, annotation, this.priority);
        }

        @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
        public void visitAnnotationOnMethodArgument(JCTree.JCVariableDecl argument, JCTree.JCMethodDecl method, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
            JCTree.JCCompilationUnit top = annotationNode.top().get();
            JavacTransformer.this.handlers.handleAnnotation(top, annotationNode, annotation, this.priority);
        }

        @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
        public void visitAnnotationOnLocal(JCTree.JCVariableDecl local, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
            JCTree.JCCompilationUnit top = annotationNode.top().get();
            JavacTransformer.this.handlers.handleAnnotation(top, annotationNode, annotation, this.priority);
        }

        @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
        public void visitAnnotationOnTypeUse(JCTree typeUse, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
            JCTree.JCCompilationUnit top = annotationNode.top().get();
            JavacTransformer.this.handlers.handleAnnotation(top, annotationNode, annotation, this.priority);
        }
    }
}
