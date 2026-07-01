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

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseASTVisitor.SCL.lombok */
public interface EclipseASTVisitor {
    void visitCompilationUnit(EclipseNode eclipseNode, CompilationUnitDeclaration compilationUnitDeclaration);

    void endVisitCompilationUnit(EclipseNode eclipseNode, CompilationUnitDeclaration compilationUnitDeclaration);

    void visitType(EclipseNode eclipseNode, TypeDeclaration typeDeclaration);

    void visitAnnotationOnType(TypeDeclaration typeDeclaration, EclipseNode eclipseNode, Annotation annotation);

    void endVisitType(EclipseNode eclipseNode, TypeDeclaration typeDeclaration);

    void visitField(EclipseNode eclipseNode, FieldDeclaration fieldDeclaration);

    void visitAnnotationOnField(FieldDeclaration fieldDeclaration, EclipseNode eclipseNode, Annotation annotation);

    void endVisitField(EclipseNode eclipseNode, FieldDeclaration fieldDeclaration);

    void visitInitializer(EclipseNode eclipseNode, Initializer initializer);

    void endVisitInitializer(EclipseNode eclipseNode, Initializer initializer);

    void visitMethod(EclipseNode eclipseNode, AbstractMethodDeclaration abstractMethodDeclaration);

    void visitAnnotationOnMethod(AbstractMethodDeclaration abstractMethodDeclaration, EclipseNode eclipseNode, Annotation annotation);

    void endVisitMethod(EclipseNode eclipseNode, AbstractMethodDeclaration abstractMethodDeclaration);

    void visitMethodArgument(EclipseNode eclipseNode, Argument argument, AbstractMethodDeclaration abstractMethodDeclaration);

    void visitAnnotationOnMethodArgument(Argument argument, AbstractMethodDeclaration abstractMethodDeclaration, EclipseNode eclipseNode, Annotation annotation);

    void endVisitMethodArgument(EclipseNode eclipseNode, Argument argument, AbstractMethodDeclaration abstractMethodDeclaration);

    void visitLocal(EclipseNode eclipseNode, LocalDeclaration localDeclaration);

    void visitAnnotationOnLocal(LocalDeclaration localDeclaration, EclipseNode eclipseNode, Annotation annotation);

    void endVisitLocal(EclipseNode eclipseNode, LocalDeclaration localDeclaration);

    void visitTypeUse(EclipseNode eclipseNode, TypeReference typeReference);

    void visitAnnotationOnTypeUse(TypeReference typeReference, EclipseNode eclipseNode, Annotation annotation);

    void endVisitTypeUse(EclipseNode eclipseNode, TypeReference typeReference);

    void visitStatement(EclipseNode eclipseNode, Statement statement);

    void endVisitStatement(EclipseNode eclipseNode, Statement statement);

    boolean isDeferUntilPostDiet();
}
