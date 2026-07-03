package com.discord.widgets.guildscheduledevent;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$Companion$enqueue$guildScheduledEventDetailsNotice$1 */
/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8857x72336d71 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ long $guildScheduledEventId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8857x72336d71(long j, StoreNotices storeNotices, String str) {
        super(1);
        this.$guildScheduledEventId = j;
        this.$storeNotices = storeNotices;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "appActivity");
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        companion.showForGuild(supportFragmentManager, this.$guildScheduledEventId);
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
