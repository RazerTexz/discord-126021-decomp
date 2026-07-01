package lombok.eclipse;

import androidx.recyclerview.widget.RecyclerView;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/TransformEclipseAST$AnnotationVisitor.SCL.lombok */
class TransformEclipseAST$AnnotationVisitor extends EclipseASTAdapter {
    private final long priority;
    private long nextPriority = RecyclerView.FOREVER_NS;

    public TransformEclipseAST$AnnotationVisitor(long priority) {
        this.priority = priority;
    }

    public long getNextPriority() {
        return this.nextPriority;
    }

    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnField(FieldDeclaration field, EclipseNode annotationNode, Annotation annotation) {
        CompilationUnitDeclaration top = annotationNode.top().get();
        this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.access$0().handleAnnotation(top, annotationNode, annotation, this.priority));
    }

    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnMethodArgument(Argument arg, AbstractMethodDeclaration method, EclipseNode annotationNode, Annotation annotation) {
        CompilationUnitDeclaration top = annotationNode.top().get();
        this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.access$0().handleAnnotation(top, annotationNode, annotation, this.priority));
    }

    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnLocal(LocalDeclaration local, EclipseNode annotationNode, Annotation annotation) {
        CompilationUnitDeclaration top = annotationNode.top().get();
        this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.access$0().handleAnnotation(top, annotationNode, annotation, this.priority));
    }

    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnMethod(AbstractMethodDeclaration method, EclipseNode annotationNode, Annotation annotation) {
        CompilationUnitDeclaration top = annotationNode.top().get();
        this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.access$0().handleAnnotation(top, annotationNode, annotation, this.priority));
    }

    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnType(TypeDeclaration type, EclipseNode annotationNode, Annotation annotation) {
        CompilationUnitDeclaration top = annotationNode.top().get();
        this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.access$0().handleAnnotation(top, annotationNode, annotation, this.priority));
    }

    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnTypeUse(TypeReference typeUse, EclipseNode annotationNode, Annotation annotation) {
        CompilationUnitDeclaration top = annotationNode.top().get();
        this.nextPriority = Math.min(this.nextPriority, TransformEclipseAST.access$0().handleAnnotation(top, annotationNode, annotation, this.priority));
    }
}
