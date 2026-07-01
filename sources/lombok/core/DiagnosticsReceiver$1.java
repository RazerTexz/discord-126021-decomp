package lombok.core;

/* JADX INFO: loaded from: app.apk:lombok/core/DiagnosticsReceiver$1.SCL.lombok */
class DiagnosticsReceiver$1 implements DiagnosticsReceiver {
    DiagnosticsReceiver$1() {
    }

    @Override // lombok.core.DiagnosticsReceiver
    public void addError(String message) {
        System.err.println("Error: " + message);
    }

    @Override // lombok.core.DiagnosticsReceiver
    public void addWarning(String message) {
        System.out.println("Warning: " + message);
    }
}
