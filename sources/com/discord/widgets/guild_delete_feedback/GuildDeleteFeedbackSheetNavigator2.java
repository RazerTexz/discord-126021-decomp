package com.discord.widgets.guild_delete_feedback;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator$enqueueNotice$showFeedbackNotice$1, reason: use source file name */
/* JADX INFO: compiled from: GuildDeleteFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetNavigator2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ long $requestedShowTimestamp;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDeleteFeedbackSheetNavigator2(long j, long j2, StoreNotices storeNotices, String str) {
        super(1);
        this.$requestedShowTimestamp = j;
        this.$guildId = j2;
        this.$storeNotices = storeNotices;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator = GuildDeleteFeedbackSheetNavigator.INSTANCE;
        if (GuildDeleteFeedbackSheetNavigator.clock.currentTimeMillis() - this.$requestedShowTimestamp < 3000) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            guildDeleteFeedbackSheetNavigator.show(supportFragmentManager, this.$guildId);
        }
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
