package lombok.eclipse;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/EclipseASTAdapter.SCL.lombok */
public abstract class EclipseASTAdapter implements EclipseASTVisitor {
    private final boolean deferUntilPostDiet = getClass().isAnnotationPresent(DeferUntilPostDiet.class);

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitCompilationUnit(EclipseNode top, CompilationUnitDeclaration unit) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitCompilationUnit(EclipseNode top, CompilationUnitDeclaration unit) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitType(EclipseNode typeNode, TypeDeclaration type) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnType(TypeDeclaration type, EclipseNode annotationNode, Annotation annotation) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitType(EclipseNode typeNode, TypeDeclaration type) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitInitializer(EclipseNode initializerNode, Initializer initializer) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitInitializer(EclipseNode initializerNode, Initializer initializer) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitField(EclipseNode fieldNode, FieldDeclaration field) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnField(FieldDeclaration field, EclipseNode annotationNode, Annotation annotation) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitField(EclipseNode fieldNode, FieldDeclaration field) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitMethod(EclipseNode methodNode, AbstractMethodDeclaration method) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnMethod(AbstractMethodDeclaration method, EclipseNode annotationNode, Annotation annotation) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitMethod(EclipseNode methodNode, AbstractMethodDeclaration method) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitMethodArgument(EclipseNode argNode, Argument arg, AbstractMethodDeclaration method) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnMethodArgument(Argument arg, AbstractMethodDeclaration method, EclipseNode annotationNode, Annotation annotation) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitMethodArgument(EclipseNode argNode, Argument arg, AbstractMethodDeclaration method) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitLocal(EclipseNode localNode, LocalDeclaration local) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnLocal(LocalDeclaration local, EclipseNode annotationNode, Annotation annotation) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitLocal(EclipseNode localNode, LocalDeclaration local) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitTypeUse(EclipseNode typeUseNode, TypeReference typeUse) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitAnnotationOnTypeUse(TypeReference typeUse, EclipseNode annotationNode, Annotation annotation) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitTypeUse(EclipseNode typeUseNode, TypeReference typeUse) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void visitStatement(EclipseNode statementNode, Statement statement) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public void endVisitStatement(EclipseNode statementNode, Statement statement) {
    }

    @Override // lombok.eclipse.EclipseASTVisitor
    public boolean isDeferUntilPostDiet() {
        return this.deferUntilPostDiet;
    }
}
