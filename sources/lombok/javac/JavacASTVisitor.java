package lombok.javac;

import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacASTVisitor.SCL.lombok */
public interface JavacASTVisitor {
    void setTrees(Trees trees);

    void visitCompilationUnit(JavacNode javacNode, JCTree$JCCompilationUnit jCTree$JCCompilationUnit);

    void endVisitCompilationUnit(JavacNode javacNode, JCTree$JCCompilationUnit jCTree$JCCompilationUnit);

    void visitType(JavacNode javacNode, JCTree$JCClassDecl jCTree$JCClassDecl);

    void visitAnnotationOnType(JCTree$JCClassDecl jCTree$JCClassDecl, JavacNode javacNode, JCTree$JCAnnotation jCTree$JCAnnotation);

    void endVisitType(JavacNode javacNode, JCTree$JCClassDecl jCTree$JCClassDecl);

    void visitField(JavacNode javacNode, JCTree$JCVariableDecl jCTree$JCVariableDecl);

    void visitAnnotationOnField(JCTree$JCVariableDecl jCTree$JCVariableDecl, JavacNode javacNode, JCTree$JCAnnotation jCTree$JCAnnotation);

    void endVisitField(JavacNode javacNode, JCTree$JCVariableDecl jCTree$JCVariableDecl);

    void visitInitializer(JavacNode javacNode, JCTree$JCBlock jCTree$JCBlock);

    void endVisitInitializer(JavacNode javacNode, JCTree$JCBlock jCTree$JCBlock);

    void visitMethod(JavacNode javacNode, JCTree$JCMethodDecl jCTree$JCMethodDecl);

    void visitAnnotationOnMethod(JCTree$JCMethodDecl jCTree$JCMethodDecl, JavacNode javacNode, JCTree$JCAnnotation jCTree$JCAnnotation);

    void endVisitMethod(JavacNode javacNode, JCTree$JCMethodDecl jCTree$JCMethodDecl);

    void visitMethodArgument(JavacNode javacNode, JCTree$JCVariableDecl jCTree$JCVariableDecl, JCTree$JCMethodDecl jCTree$JCMethodDecl);

    void visitAnnotationOnMethodArgument(JCTree$JCVariableDecl jCTree$JCVariableDecl, JCTree$JCMethodDecl jCTree$JCMethodDecl, JavacNode javacNode, JCTree$JCAnnotation jCTree$JCAnnotation);

    void endVisitMethodArgument(JavacNode javacNode, JCTree$JCVariableDecl jCTree$JCVariableDecl, JCTree$JCMethodDecl jCTree$JCMethodDecl);

    void visitLocal(JavacNode javacNode, JCTree$JCVariableDecl jCTree$JCVariableDecl);

    void visitAnnotationOnLocal(JCTree$JCVariableDecl jCTree$JCVariableDecl, JavacNode javacNode, JCTree$JCAnnotation jCTree$JCAnnotation);

    void endVisitLocal(JavacNode javacNode, JCTree$JCVariableDecl jCTree$JCVariableDecl);

    void visitTypeUse(JavacNode javacNode, JCTree jCTree);

    void visitAnnotationOnTypeUse(JCTree jCTree, JavacNode javacNode, JCTree$JCAnnotation jCTree$JCAnnotation);

    void endVisitTypeUse(JavacNode javacNode, JCTree jCTree);

    void visitStatement(JavacNode javacNode, JCTree jCTree);

    void endVisitStatement(JavacNode javacNode, JCTree jCTree);
}
