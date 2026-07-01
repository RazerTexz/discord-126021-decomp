package com.discord.widgets.guild_delete_feedback;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildDeleteFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetNavigator$enqueueNotice$showFeedbackNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ long $requestedShowTimestamp;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDeleteFeedbackSheetNavigator$enqueueNotice$showFeedbackNotice$1(long j, long j2, StoreNotices storeNotices, String str) {
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
        m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator = GuildDeleteFeedbackSheetNavigator.INSTANCE;
        if (GuildDeleteFeedbackSheetNavigator.access$getClock$p(guildDeleteFeedbackSheetNavigator).currentTimeMillis() - this.$requestedShowTimestamp < 3000) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            GuildDeleteFeedbackSheetNavigator.access$show(guildDeleteFeedbackSheetNavigator, supportFragmentManager, this.$guildId);
        }
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
