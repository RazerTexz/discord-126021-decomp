package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class RequestHandler$1 implements Runnable {
    public final /* synthetic */ RequestHandler this$0;
    public final /* synthetic */ ActivityPackage val$activityPackage;
    public final /* synthetic */ int val$queueSize;

    public RequestHandler$1(RequestHandler requestHandler, ActivityPackage activityPackage, int i) {
        this.this$0 = requestHandler;
        this.val$activityPackage = activityPackage;
        this.val$queueSize = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        RequestHandler.access$000(this.this$0, this.val$activityPackage, this.val$queueSize);
    }
}
