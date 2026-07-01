package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$onViewBoundOrOnResume$5<T1, T2, T3, R> implements Func3<Boolean, FlexInputState, StoreChannelsSelected$ResolvedSelectedChannel, WidgetChatOverlay$StickerAutocompleteState> {
    public static final WidgetChatOverlay$onViewBoundOrOnResume$5 INSTANCE = new WidgetChatOverlay$onViewBoundOrOnResume$5();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChatOverlay$StickerAutocompleteState call(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(bool, flexInputState, storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatOverlay$StickerAutocompleteState call2(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        Channel parentChannel;
        if (!(storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft)) {
            storeChannelsSelected$ResolvedSelectedChannel = null;
        }
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = (StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) storeChannelsSelected$ResolvedSelectedChannel;
        m.checkNotNullExpressionValue(bool, "autocompleteVisible");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(flexInputState, "flexInputState");
        return new WidgetChatOverlay$StickerAutocompleteState(zBooleanValue, flexInputState, (storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft == null || (parentChannel = storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.getParentChannel()) == null || !ChannelUtils.q(parentChannel)) ? false : true);
    }
}
