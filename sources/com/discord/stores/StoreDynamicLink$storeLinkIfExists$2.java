package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.a.e.d;
import com.discord.utilities.analytics.AnalyticsTracker;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink$storeLinkIfExists$2<T> implements Action1<StoreDynamicLink$DynamicLinkData> {
    public static final StoreDynamicLink$storeLinkIfExists$2 INSTANCE = new StoreDynamicLink$storeLinkIfExists$2();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData) {
        call2(storeDynamicLink$DynamicLinkData);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData) {
        if (storeDynamicLink$DynamicLinkData != null) {
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            String fingerprint = storeDynamicLink$DynamicLinkData.getFingerprint();
            String attemptId = storeDynamicLink$DynamicLinkData.getAttemptId();
            String inviteCode = storeDynamicLink$DynamicLinkData.getInviteCode();
            String guildTemplateCode = storeDynamicLink$DynamicLinkData.getGuildTemplateCode();
            String authToken = storeDynamicLink$DynamicLinkData.getAuthToken();
            d dVar = d.d;
            analyticsTracker.externalDynamicLinkReceived(fingerprint, attemptId, inviteCode, guildTemplateCode, authToken, d.a);
        }
    }
}
