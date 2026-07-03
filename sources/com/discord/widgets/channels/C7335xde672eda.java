package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel$Companion$observeStoreState$1 */
/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7335xde672eda extends AbstractC12240o implements Function0<WidgetChannelPickerBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $hideAnnouncementChannels;
    public final /* synthetic */ StoreChannels $storeChannels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7335xde672eda(StoreChannels storeChannels, long j, boolean z2) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$guildId = j;
        this.$hideAnnouncementChannels = z2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelPickerBottomSheetViewModel.StoreState invoke() {
        Map<Long, Channel> channelsForGuild = this.$storeChannels.getChannelsForGuild(this.$guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Channel> entry : channelsForGuild.entrySet()) {
            Channel value = entry.getValue();
            boolean z2 = false;
            if (!ChannelUtils.m7687k(value) && (!this.$hideAnnouncementChannels || !ChannelUtils.m7685i(value))) {
                z2 = true;
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new WidgetChannelPickerBottomSheetViewModel.StoreState.Loaded(C12163u.toList(linkedHashMap.values()));
    }
}
