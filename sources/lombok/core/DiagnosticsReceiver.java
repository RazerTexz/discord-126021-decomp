package lombok.core;

/* JADX INFO: loaded from: app.apk:lombok/core/DiagnosticsReceiver.SCL.lombok */
public interface DiagnosticsReceiver {
    public static final DiagnosticsReceiver CONSOLE = new DiagnosticsReceiver$1();

    void addError(String str);

    void addWarning(String str);
}
