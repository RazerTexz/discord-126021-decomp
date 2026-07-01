package lombok.core;

/* JADX INFO: loaded from: app.apk:lombok/core/DiagnosticsReceiver.SCL.lombok */
public interface DiagnosticsReceiver {
    public static final DiagnosticsReceiver CONSOLE = new DiagnosticsReceiver() { // from class: lombok.core.DiagnosticsReceiver.1
        @Override // lombok.core.DiagnosticsReceiver
        public void addError(String message) {
            System.err.println("Error: " + message);
        }

        @Override // lombok.core.DiagnosticsReceiver
        public void addWarning(String message) {
            System.out.println("Warning: " + message);
        }
    };

    void addError(String str);

    void addWarning(String str);
}
