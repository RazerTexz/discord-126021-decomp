package com.discord.widgets.channels;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import d0.o;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet$itemClickListener$1 implements WidgetchannelPickerAdapter$OnItemClickListener {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    public WidgetChannelPickerBottomSheet$itemClickListener$1(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // com.discord.widgets.channels.WidgetchannelPickerAdapter$OnItemClickListener
    public void onChannelItemClick(ChannelPickerAdapterItem$ChannelItem channelItem) {
        m.checkNotNullParameter(channelItem, "channelItem");
        String string = WidgetChannelPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
        m.checkNotNullExpressionValue(string, "requestCode");
        FragmentKt.setFragmentResult(widgetChannelPickerBottomSheet, string, BundleKt.bundleOf(o.to("RESULT_EXTRA_CHANNEL_ID", Long.valueOf(channelItem.getChannel().getId())), o.to("RESULT_EXTRA_CHANNEL_NAME", ChannelUtils.c(channelItem.getChannel())), o.to("RESULT_EXTRA_CHANNEL_ICON_RES_ID", Integer.valueOf(GuildChannelIconUtilsKt.guildChannelIcon(channelItem.getChannel()))), o.to("RESULT_EXTRA_SELECTION_TYPE", Integer.valueOf(WidgetChannelPickerBottomSheet$SelectionType.CHANNEL.ordinal()))));
        this.this$0.dismiss();
    }

    @Override // com.discord.widgets.channels.WidgetchannelPickerAdapter$OnItemClickListener
    public void onCreateChannelClick() {
        String string = WidgetChannelPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
        m.checkNotNullExpressionValue(string, "requestCode");
        Bundle bundle = new Bundle();
        bundle.putInt("RESULT_EXTRA_SELECTION_TYPE", WidgetChannelPickerBottomSheet$SelectionType.CREATE_CHANNEL.ordinal());
        FragmentKt.setFragmentResult(widgetChannelPickerBottomSheet, string, bundle);
        this.this$0.dismiss();
    }
}
