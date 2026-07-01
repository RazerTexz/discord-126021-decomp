package com.discord.widgets.stickers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits$Location$Page;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet$Companion {
    private WidgetStickerSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, Sticker sticker, long channelId) {
        Channel channelFindChannelById;
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(sticker, "sticker");
        if (sticker.getType() == StickerType.STANDARD && (channelFindChannelById = StoreStream.Companion.getChannels().findChannelById(channelId)) != null) {
            String str = channelFindChannelById.getGuildId() == 0 ? "DM Channel" : Traits$Location$Page.GUILD_CHANNEL;
            WidgetStickerSheet widgetStickerSheet = new WidgetStickerSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            bundle.putString("widget_sticker_sheet_analytics_location", str);
            widgetStickerSheet.setArguments(bundle);
            widgetStickerSheet.show(fragmentManager, WidgetStickerSheet.class.getName());
        }
    }

    public /* synthetic */ WidgetStickerSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
