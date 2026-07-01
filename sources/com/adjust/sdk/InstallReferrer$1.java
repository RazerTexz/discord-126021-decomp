package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class InstallReferrer$1 implements Runnable {
    public final /* synthetic */ InstallReferrer this$0;

    public InstallReferrer$1(InstallReferrer installReferrer) {
        this.this$0 = installReferrer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.startConnection();
    }
}
