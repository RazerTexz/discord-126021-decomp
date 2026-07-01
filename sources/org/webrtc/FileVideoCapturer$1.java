package org.webrtc;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
public class FileVideoCapturer$1 extends TimerTask {
    public final /* synthetic */ FileVideoCapturer this$0;

    public FileVideoCapturer$1(FileVideoCapturer fileVideoCapturer) {
        this.this$0 = fileVideoCapturer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.this$0.tick();
    }
}
