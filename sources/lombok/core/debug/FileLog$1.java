package lombok.core.debug;

/* JADX INFO: loaded from: app.apk:lombok/core/debug/FileLog$1.SCL.lombok */
class FileLog$1 extends Thread {
    FileLog$1() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            FileLog.access$0().close();
        } catch (Throwable unused) {
        }
    }
}
