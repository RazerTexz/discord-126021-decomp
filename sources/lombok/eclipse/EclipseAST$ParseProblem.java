package lombok.eclipse;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAST$ParseProblem.SCL.lombok */
class EclipseAST$ParseProblem {
    final boolean isWarning;
    final String message;
    final int sourceStart;
    final int sourceEnd;
    final /* synthetic */ EclipseAST this$0;

    EclipseAST$ParseProblem(EclipseAST eclipseAST, boolean isWarning, String message, int sourceStart, int sourceEnd) {
        this.this$0 = eclipseAST;
        this.isWarning = isWarning;
        this.message = message;
        this.sourceStart = sourceStart;
        this.sourceEnd = sourceEnd;
    }

    void addToCompilationResult() {
        CompilationUnitDeclaration cud = this.this$0.top().get();
        EclipseAST.addProblemToCompilationResult(cud.getFileName(), cud.compilationResult, this.isWarning, this.message, this.sourceStart, this.sourceEnd);
    }
}
