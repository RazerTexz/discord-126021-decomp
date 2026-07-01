package com.discord.widgets.chat.input;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel$onGiftButtonClicked$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final AppFlexInputViewModel$onGiftButtonClicked$1 INSTANCE = new AppFlexInputViewModel$onGiftButtonClicked$1();

    public AppFlexInputViewModel$onGiftButtonClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Channel channelFindChannelById = storeStream$Companion.getChannels().findChannelById(storeStream$Companion.getChannelsSelected().getId());
        WidgetSettingsGifting.Companion.launch(fragmentActivity, new Traits$Location((channelFindChannelById == null || channelFindChannelById.getGuildId() != 0) ? Traits$Location$Page.GUILD_CHANNEL : "DM Channel", Traits$Location$Section.CHANNEL_TEXT_AREA, "Button Icon", "gift", null, 16, null));
        StoreNotices.markSeen$default(storeStream$Companion.getNotices(), "CHAT_GIFTING_NOTICE", 0L, 2, null);
        return true;
    }
}
