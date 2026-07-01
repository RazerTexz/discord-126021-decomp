package com.discord.widgets.voice.feedback.call;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSheetNavigator$enqueueNotice$showCallFeedbackSheetNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Long $callDurationMs;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ String $mediaSessionId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ long $requestedShowTimestamp;
    public final /* synthetic */ String $rtcConnectionId;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallFeedbackSheetNavigator$enqueueNotice$showCallFeedbackSheetNotice$1(long j, long j2, String str, String str2, Long l, StoreNotices storeNotices, String str3) {
        super(1);
        this.$requestedShowTimestamp = j;
        this.$channelId = j2;
        this.$rtcConnectionId = str;
        this.$mediaSessionId = str2;
        this.$callDurationMs = l;
        this.$storeNotices = storeNotices;
        this.$noticeName = str3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        CallFeedbackSheetNavigator callFeedbackSheetNavigator = CallFeedbackSheetNavigator.INSTANCE;
        if (CallFeedbackSheetNavigator.access$getClock$p(callFeedbackSheetNavigator).currentTimeMillis() - this.$requestedShowTimestamp < 3000) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            CallFeedbackSheetNavigator.access$show(callFeedbackSheetNavigator, supportFragmentManager, this.$channelId, this.$rtcConnectionId, this.$mediaSessionId, this.$callDurationMs);
        }
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
