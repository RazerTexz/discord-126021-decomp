package org.webrtc.audio;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioRecord$1 implements ThreadFactory {
    public final /* synthetic */ AtomicInteger val$nextThreadId;

    public WebRtcAudioRecord$1(AtomicInteger atomicInteger) {
        this.val$nextThreadId = atomicInteger;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
        threadNewThread.setName(String.format("WebRtcAudioRecordScheduler-%s-%s", Integer.valueOf(WebRtcAudioRecord.access$1000().getAndIncrement()), Integer.valueOf(this.val$nextThreadId.getAndIncrement())));
        return threadNewThread;
    }
}
