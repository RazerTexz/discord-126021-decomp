package androidx.core.provider;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class RequestExecutor$DefaultThreadFactory$ProcessPriorityThread extends Thread {
    private final int mPriority;

    public RequestExecutor$DefaultThreadFactory$ProcessPriorityThread(Runnable runnable, String str, int i) {
        super(runnable, str);
        this.mPriority = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(this.mPriority);
        super.run();
    }
}
