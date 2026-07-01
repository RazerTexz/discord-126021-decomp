package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StoreChannelsSelected$UserChannelSelection {
    private StoreChannelsSelected$UserChannelSelection() {
    }

    public final long getId() {
        if (this instanceof StoreChannelsSelected$UserChannelSelection$SelectedChannel) {
            return ((StoreChannelsSelected$UserChannelSelection$SelectedChannel) this).getChannelId();
        }
        if (this instanceof StoreChannelsSelected$UserChannelSelection$ThreadDraft) {
            return ((StoreChannelsSelected$UserChannelSelection$ThreadDraft) this).getParentChannelId();
        }
        if (m.areEqual(this, StoreChannelsSelected$UserChannelSelection$Unselected.INSTANCE)) {
            return 0L;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final StoreChannelsSelected$ResolvedSelectedChannel resolveWithChannel(Channel channel) {
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
        m.checkNotNullParameter(channel, "channel");
        if (this instanceof StoreChannelsSelected$UserChannelSelection$Unselected) {
            return StoreChannelsSelected$ResolvedSelectedChannel$Unselected.INSTANCE;
        }
        if (this instanceof StoreChannelsSelected$UserChannelSelection$SelectedChannel) {
            StoreChannelsSelected$UserChannelSelection$SelectedChannel storeChannelsSelected$UserChannelSelection$SelectedChannel = (StoreChannelsSelected$UserChannelSelection$SelectedChannel) this;
            storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = new StoreChannelsSelected$ResolvedSelectedChannel$Channel(channel, storeChannelsSelected$UserChannelSelection$SelectedChannel.getPeekParent(), storeChannelsSelected$UserChannelSelection$SelectedChannel.getAnalyticsLocation());
        } else {
            if (!(this instanceof StoreChannelsSelected$UserChannelSelection$ThreadDraft)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreChannelsSelected$UserChannelSelection$ThreadDraft storeChannelsSelected$UserChannelSelection$ThreadDraft = (StoreChannelsSelected$UserChannelSelection$ThreadDraft) this;
            storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = new StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft(channel, storeChannelsSelected$UserChannelSelection$ThreadDraft.getStarterMessageId(), storeChannelsSelected$UserChannelSelection$ThreadDraft.getLocationThreadStart());
        }
        return storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
    }

    public /* synthetic */ StoreChannelsSelected$UserChannelSelection(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
