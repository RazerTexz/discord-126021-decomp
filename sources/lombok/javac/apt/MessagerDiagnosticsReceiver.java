package lombok.javac.apt;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;
import lombok.core.DiagnosticsReceiver;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/apt/MessagerDiagnosticsReceiver.SCL.lombok */
public class MessagerDiagnosticsReceiver implements DiagnosticsReceiver {
    private final Messager messager;

    public MessagerDiagnosticsReceiver(Messager messager) {
        this.messager = messager;
    }

    @Override // lombok.core.DiagnosticsReceiver
    public void addWarning(String message) {
        this.messager.printMessage(Diagnostic.Kind.WARNING, message);
    }

    @Override // lombok.core.DiagnosticsReceiver
    public void addError(String message) {
        this.messager.printMessage(Diagnostic.Kind.ERROR, message);
    }
}
