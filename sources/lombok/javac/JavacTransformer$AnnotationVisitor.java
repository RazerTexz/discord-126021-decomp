package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTransformer$AnnotationVisitor.SCL.lombok */
class JavacTransformer$AnnotationVisitor extends JavacASTAdapter {
    private final long priority;
    final /* synthetic */ JavacTransformer this$0;

    JavacTransformer$AnnotationVisitor(JavacTransformer javacTransformer, long priority) {
        this.this$0 = javacTransformer;
        this.priority = priority;
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitAnnotationOnType(JCTree$JCClassDecl type, JavacNode annotationNode, JCTree$JCAnnotation annotation) {
        JCTree$JCCompilationUnit top = annotationNode.top().get();
        JavacTransformer.access$0(this.this$0).handleAnnotation(top, annotationNode, annotation, this.priority);
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitAnnotationOnField(JCTree$JCVariableDecl field, JavacNode annotationNode, JCTree$JCAnnotation annotation) {
        JCTree$JCCompilationUnit top = annotationNode.top().get();
        JavacTransformer.access$0(this.this$0).handleAnnotation(top, annotationNode, annotation, this.priority);
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitAnnotationOnMethod(JCTree$JCMethodDecl method, JavacNode annotationNode, JCTree$JCAnnotation annotation) {
        JCTree$JCCompilationUnit top = annotationNode.top().get();
        JavacTransformer.access$0(this.this$0).handleAnnotation(top, annotationNode, annotation, this.priority);
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitAnnotationOnMethodArgument(JCTree$JCVariableDecl argument, JCTree$JCMethodDecl method, JavacNode annotationNode, JCTree$JCAnnotation annotation) {
        JCTree$JCCompilationUnit top = annotationNode.top().get();
        JavacTransformer.access$0(this.this$0).handleAnnotation(top, annotationNode, annotation, this.priority);
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitAnnotationOnLocal(JCTree$JCVariableDecl local, JavacNode annotationNode, JCTree$JCAnnotation annotation) {
        JCTree$JCCompilationUnit top = annotationNode.top().get();
        JavacTransformer.access$0(this.this$0).handleAnnotation(top, annotationNode, annotation, this.priority);
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitAnnotationOnTypeUse(JCTree typeUse, JavacNode annotationNode, JCTree$JCAnnotation annotation) {
        JCTree$JCCompilationUnit top = annotationNode.top().get();
        JavacTransformer.access$0(this.this$0).handleAnnotation(top, annotationNode, annotation, this.priority);
    }
}
