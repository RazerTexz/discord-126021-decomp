package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class PackageHandler$6 implements Runnable {
    public final /* synthetic */ PackageHandler this$0;
    public final /* synthetic */ SessionParameters val$sessionParametersCopy;

    public PackageHandler$6(PackageHandler packageHandler, SessionParameters sessionParameters) {
        this.this$0 = packageHandler;
        this.val$sessionParametersCopy = sessionParameters;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.updatePackagesI(this.val$sessionParametersCopy);
    }
}
