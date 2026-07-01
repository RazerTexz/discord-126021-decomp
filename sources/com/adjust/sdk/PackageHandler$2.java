package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class PackageHandler$2 implements Runnable {
    public final /* synthetic */ PackageHandler this$0;
    public final /* synthetic */ ActivityPackage val$activityPackage;

    public PackageHandler$2(PackageHandler packageHandler, ActivityPackage activityPackage) {
        this.this$0 = packageHandler;
        this.val$activityPackage = activityPackage;
    }

    @Override // java.lang.Runnable
    public void run() {
        PackageHandler.access$100(this.this$0, this.val$activityPackage);
    }
}
