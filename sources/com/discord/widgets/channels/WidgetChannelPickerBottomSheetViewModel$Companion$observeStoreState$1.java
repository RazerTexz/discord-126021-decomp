package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import d0.t.u;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel$Companion$observeStoreState$1 extends o implements Function0<WidgetChannelPickerBottomSheetViewModel$StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $hideAnnouncementChannels;
    public final /* synthetic */ StoreChannels $storeChannels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel$Companion$observeStoreState$1(StoreChannels storeChannels, long j, boolean z2) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$guildId = j;
        this.$hideAnnouncementChannels = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelPickerBottomSheetViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelPickerBottomSheetViewModel$StoreState invoke() {
        Map<Long, Channel> channelsForGuild = this.$storeChannels.getChannelsForGuild(this.$guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Channel> map$Entry : channelsForGuild.entrySet()) {
            Channel value = map$Entry.getValue();
            boolean z2 = false;
            if (!ChannelUtils.k(value) && (!this.$hideAnnouncementChannels || !ChannelUtils.i(value))) {
                z2 = true;
            }
            if (z2) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return new WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded(u.toList(linkedHashMap.values()));
    }
}
