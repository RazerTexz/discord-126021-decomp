package com.discord.widgets.guilds.invite;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$Companion$enqueueNoticeForHomeTab$notice$1 */
/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8695x9a7ac400 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ String $source;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8695x9a7ac400(Long l, long j, String str, StoreNotices storeNotices, String str2) {
        super(1);
        this.$channelId = l;
        this.$guildId = j;
        this.$source = str;
        this.$storeNotices = storeNotices;
        this.$noticeName = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        WidgetGuildInviteShareSheet.Companion companion = WidgetGuildInviteShareSheet.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        companion.show(supportFragmentManager, this.$channelId, this.$guildId, this.$source);
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
