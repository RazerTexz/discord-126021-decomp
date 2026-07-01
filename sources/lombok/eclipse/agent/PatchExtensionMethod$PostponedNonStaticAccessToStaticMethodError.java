package lombok.eclipse.agent;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$PostponedNonStaticAccessToStaticMethodError.SCL.lombok */
class PatchExtensionMethod$PostponedNonStaticAccessToStaticMethodError implements PatchExtensionMethod$PostponedError {
    private final ProblemReporter problemReporter;
    private ASTNode location;
    private MethodBinding method;

    PatchExtensionMethod$PostponedNonStaticAccessToStaticMethodError(ProblemReporter problemReporter, ASTNode location, MethodBinding method) {
        this.problemReporter = problemReporter;
        this.location = location;
        this.method = method;
    }

    @Override // lombok.eclipse.agent.PatchExtensionMethod$PostponedError
    public void fire() {
        this.problemReporter.nonStaticAccessToStaticMethod(this.location, this.method);
    }
}
