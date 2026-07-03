package com.discord.widgets.guild_delete_feedback;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator$enqueueNotice$showFeedbackNotice$1 */
/* JADX INFO: compiled from: GuildDeleteFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8419x14d241f4 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ long $requestedShowTimestamp;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8419x14d241f4(long j, long j2, StoreNotices storeNotices, String str) {
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
        C12238m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator = GuildDeleteFeedbackSheetNavigator.INSTANCE;
        if (GuildDeleteFeedbackSheetNavigator.clock.currentTimeMillis() - this.$requestedShowTimestamp < 3000) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            C12238m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            guildDeleteFeedbackSheetNavigator.show(supportFragmentManager, this.$guildId);
        }
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
