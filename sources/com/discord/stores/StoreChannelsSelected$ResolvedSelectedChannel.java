package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StoreChannelsSelected$ResolvedSelectedChannel {
    private StoreChannelsSelected$ResolvedSelectedChannel() {
    }

    public final Channel getChannelOrParent() {
        if (this instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel) {
            return ((StoreChannelsSelected$ResolvedSelectedChannel$Channel) this).getChannel();
        }
        if (this instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) {
            return ((StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) this).getParentChannel();
        }
        return null;
    }

    public final long getId() {
        if (this instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel) {
            return ((StoreChannelsSelected$ResolvedSelectedChannel$Channel) this).getChannel().getId();
        }
        if (this instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) {
            return -3L;
        }
        if (m.areEqual(this, StoreChannelsSelected$ResolvedSelectedChannel$Unselected.INSTANCE)) {
            return 0L;
        }
        if (m.areEqual(this, StoreChannelsSelected$ResolvedSelectedChannel$Unavailable.INSTANCE)) {
            return -1L;
        }
        if (m.areEqual(this, StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized.INSTANCE)) {
            return -2L;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Channel getMaybeChannel() {
        StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) (!(this instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel) ? null : this);
        if (storeChannelsSelected$ResolvedSelectedChannel$Channel != null) {
            return storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel();
        }
        return null;
    }

    public /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
