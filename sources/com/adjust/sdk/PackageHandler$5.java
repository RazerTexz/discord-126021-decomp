package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class PackageHandler$5 implements Runnable {
    public final /* synthetic */ PackageHandler this$0;

    public PackageHandler$5(PackageHandler packageHandler) {
        this.this$0 = packageHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        PackageHandler.access$400(this.this$0).verbose("Package handler can send", new Object[0]);
        PackageHandler.access$500(this.this$0).set(false);
        this.this$0.sendFirstPackage();
    }
}
