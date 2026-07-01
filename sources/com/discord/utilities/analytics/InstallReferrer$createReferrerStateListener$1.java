package com.discord.utilities.analytics;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InstallReferrer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InstallReferrer$createReferrerStateListener$1 implements InstallReferrerStateListener {
    public final /* synthetic */ Function1 $onReceivedInstallReferrer;
    public final /* synthetic */ InstallReferrer this$0;

    public InstallReferrer$createReferrerStateListener$1(InstallReferrer installReferrer, Function1 function1) {
        this.this$0 = installReferrer;
        this.$onReceivedInstallReferrer = function1;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerServiceDisconnected() {
        Logger.d$default(InstallReferrer.access$getLogger$p(this.this$0), "Install referrer service disconnected.", null, 2, null);
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerSetupFinished(int responseCode) {
        if (responseCode != 0) {
            InstallReferrer.access$setFetchInstallReferrerFailed(this.this$0, null);
        } else {
            try {
                Function1 function1 = this.$onReceivedInstallReferrer;
                ReferrerDetails installReferrer = InstallReferrer.access$getReferrerClient$p(this.this$0).getInstallReferrer();
                m.checkNotNullExpressionValue(installReferrer, "referrerClient.installReferrer");
                String installReferrer2 = installReferrer.getInstallReferrer();
                m.checkNotNullExpressionValue(installReferrer2, "referrerClient.installReferrer.installReferrer");
                function1.invoke(installReferrer2);
                InstallReferrer.access$setFetchInstallReferrerSuccessful(this.this$0);
            } catch (Exception e) {
                InstallReferrer.access$setFetchInstallReferrerFailed(this.this$0, e);
            }
        }
        try {
            InstallReferrer.access$getReferrerClient$p(this.this$0).endConnection();
        } catch (Exception e2) {
            InstallReferrer.access$getLogger$p(this.this$0).i("Unable to end connection, likely already dead.", e2);
        }
    }
}
