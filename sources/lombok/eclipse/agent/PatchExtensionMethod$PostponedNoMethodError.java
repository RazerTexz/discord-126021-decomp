package lombok.eclipse.agent;

import java.lang.ref.WeakReference;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$PostponedNoMethodError.SCL.lombok */
class PatchExtensionMethod$PostponedNoMethodError implements PatchExtensionMethod$PostponedError {
    private final ProblemReporter problemReporter;
    private final WeakReference<MessageSend> messageSendRef;
    private final TypeBinding recType;
    private final TypeBinding[] params;

    PatchExtensionMethod$PostponedNoMethodError(ProblemReporter problemReporter, MessageSend messageSend, TypeBinding recType, TypeBinding[] params) {
        this.problemReporter = problemReporter;
        this.messageSendRef = new WeakReference<>(messageSend);
        this.recType = recType;
        this.params = params;
    }

    @Override // lombok.eclipse.agent.PatchExtensionMethod$PostponedError
    public void fire() {
        MessageSend messageSend = this.messageSendRef.get();
        if (messageSend != null) {
            this.problemReporter.errorNoMethodFor(messageSend, this.recType, this.params);
        }
    }
}
