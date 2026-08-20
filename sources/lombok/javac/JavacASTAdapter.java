package lombok.javac;

import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/JavacASTAdapter.SCL.lombok */
public class JavacASTAdapter implements JavacASTVisitor {
    @Override // lombok.javac.JavacASTVisitor
    public void setTrees(Trees trees) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitCompilationUnit(JavacNode top, JCTree.JCCompilationUnit unit) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitCompilationUnit(JavacNode top, JCTree.JCCompilationUnit unit) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitType(JavacNode typeNode, JCTree.JCClassDecl type) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnType(JCTree.JCClassDecl type, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitType(JavacNode typeNode, JCTree.JCClassDecl type) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitField(JavacNode fieldNode, JCTree.JCVariableDecl field) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnField(JCTree.JCVariableDecl field, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitField(JavacNode fieldNode, JCTree.JCVariableDecl field) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitInitializer(JavacNode initializerNode, JCTree.JCBlock initializer) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitInitializer(JavacNode initializerNode, JCTree.JCBlock initializer) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitMethod(JavacNode methodNode, JCTree.JCMethodDecl method) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnMethod(JCTree.JCMethodDecl method, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitMethod(JavacNode methodNode, JCTree.JCMethodDecl method) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitMethodArgument(JavacNode argumentNode, JCTree.JCVariableDecl argument, JCTree.JCMethodDecl method) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnMethodArgument(JCTree.JCVariableDecl argument, JCTree.JCMethodDecl method, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitMethodArgument(JavacNode argumentNode, JCTree.JCVariableDecl argument, JCTree.JCMethodDecl method) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitLocal(JavacNode localNode, JCTree.JCVariableDecl local) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnLocal(JCTree.JCVariableDecl local, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitLocal(JavacNode localNode, JCTree.JCVariableDecl local) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitTypeUse(JavacNode typeUseNode, JCTree typeUse) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitAnnotationOnTypeUse(JCTree typeUse, JavacNode annotationNode, JCTree.JCAnnotation annotation) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitTypeUse(JavacNode typeUseNode, JCTree typeUse) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void visitStatement(JavacNode statementNode, JCTree statement) {
    }

    @Override // lombok.javac.JavacASTVisitor
    public void endVisitStatement(JavacNode statementNode, JCTree statement) {
    }
}
