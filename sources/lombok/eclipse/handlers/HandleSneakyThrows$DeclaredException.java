package lombok.eclipse.handlers;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSneakyThrows$DeclaredException.SCL.lombok */
class HandleSneakyThrows$DeclaredException {
    final String exceptionName;
    final ASTNode node;

    HandleSneakyThrows$DeclaredException(String exceptionName, ASTNode node) {
        this.exceptionName = exceptionName;
        this.node = node;
    }
}
