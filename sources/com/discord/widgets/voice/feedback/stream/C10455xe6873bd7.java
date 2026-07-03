package com.discord.widgets.voice.feedback.stream;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetNavigator$enqueueNotice$showStreamFeedbackSheetNotice$1 */
/* JADX INFO: compiled from: StreamFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10455xe6873bd7 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $mediaSessionId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ long $requestedShowTimestamp;
    public final /* synthetic */ StoreNotices $storeNotices;
    public final /* synthetic */ String $streamKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10455xe6873bd7(long j, String str, String str2, StoreNotices storeNotices, String str3) {
        super(1);
        this.$requestedShowTimestamp = j;
        this.$streamKey = str;
        this.$mediaSessionId = str2;
        this.$storeNotices = storeNotices;
        this.$noticeName = str3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        StreamFeedbackSheetNavigator streamFeedbackSheetNavigator = StreamFeedbackSheetNavigator.INSTANCE;
        if (StreamFeedbackSheetNavigator.clock.currentTimeMillis() - this.$requestedShowTimestamp < 3000) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            C12238m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            streamFeedbackSheetNavigator.show(supportFragmentManager, this.$streamKey, this.$mediaSessionId);
        }
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
