package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class HardwareVideoEncoder$BusyCount {
    private int count;
    private final Object countLock;

    private HardwareVideoEncoder$BusyCount() {
        this.countLock = new Object();
    }

    public void decrement() {
        synchronized (this.countLock) {
            int i = this.count - 1;
            this.count = i;
            if (i == 0) {
                this.countLock.notifyAll();
            }
        }
    }

    public void increment() {
        synchronized (this.countLock) {
            this.count++;
        }
    }

    public void waitForZero() {
        boolean z2;
        synchronized (this.countLock) {
            z2 = false;
            while (this.count > 0) {
                try {
                    this.countLock.wait();
                } catch (InterruptedException e) {
                    Logging.e("HardwareVideoEncoder", "Interrupted while waiting on busy count", e);
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public /* synthetic */ HardwareVideoEncoder$BusyCount(HardwareVideoEncoder$1 hardwareVideoEncoder$1) {
        this();
    }
}
