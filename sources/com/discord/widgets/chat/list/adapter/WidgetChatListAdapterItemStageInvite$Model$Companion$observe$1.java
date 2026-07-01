package com.discord.widgets.chat.list.adapter;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRequestedStageChannels;
import com.discord.stores.StoreRequestedStageChannels$StageInstanceState;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreUser;
import com.discord.widgets.chat.list.entries.StageInviteEntry;
import com.discord.widgets.stage.StageRoles;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStageInvite$Model$Companion$observe$1 extends o implements Function0<WidgetChatListAdapterItemStageInvite$Model> {
    public final /* synthetic */ StoreAccessibility $accessibilityStore;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ StageInviteEntry $item;
    public final /* synthetic */ StoreRequestedStageChannels $requestedInstanceStore;
    public final /* synthetic */ StoreStageChannels $stageChannelStore;
    public final /* synthetic */ StoreStageInstances $stageInstanceStore;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStageInvite$Model$Companion$observe$1(StoreUser storeUser, StageInviteEntry stageInviteEntry, StoreChannels storeChannels, StoreAccessibility storeAccessibility, StoreStageInstances storeStageInstances, StoreRequestedStageChannels storeRequestedStageChannels, StoreStageChannels storeStageChannels, StoreGuilds storeGuilds) {
        super(0);
        this.$userStore = storeUser;
        this.$item = stageInviteEntry;
        this.$channelStore = storeChannels;
        this.$accessibilityStore = storeAccessibility;
        this.$stageInstanceStore = storeStageInstances;
        this.$requestedInstanceStore = storeRequestedStageChannels;
        this.$stageChannelStore = storeStageChannels;
        this.$guildStore = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemStageInvite$Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:40:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:7:0x003c  */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChatListAdapterItemStageInvite$Model invoke() {
        Channel channel;
        StageInstance stageInstance;
        Map<Long, StageRoles> channelRoles;
        StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState;
        StageInstance stageInstance2;
        List listAccess$speakersFromLocalStore;
        Integer num;
        Integer numValueOf;
        List listEmptyList;
        long id2 = this.$userStore.getMeSnapshot().getId();
        User user = this.$userStore.getUsers().get(Long.valueOf(this.$item.getUserId()));
        Channel channel2 = this.$item.getInvite().getChannel();
        if (channel2 != null) {
            channel = this.$channelStore.getChannel(channel2.getId());
            if (channel == null) {
                channel = this.$item.getInvite().getChannel();
            }
        } else {
            channel = this.$item.getInvite().getChannel();
        }
        Channel channel3 = channel;
        boolean reducedMotionEnabled = this.$accessibilityStore.getReducedMotionEnabled();
        if (channel3 != null) {
            long id3 = channel3.getId();
            StageInstance stageInstanceForChannel = this.$stageInstanceStore.getStageInstanceForChannel(id3);
            if (stageInstanceForChannel == null) {
                stageInstanceForChannel = this.$requestedInstanceStore.getStageInstanceForChannel(id3);
            }
            stageInstance = stageInstanceForChannel;
        } else {
            stageInstance = null;
        }
        if (channel3 != null) {
            channelRoles = this.$stageChannelStore.getChannelRoles(channel3.getId());
        } else {
            channelRoles = null;
        }
        if (channel3 != null) {
            storeRequestedStageChannels$StageInstanceState = this.$requestedInstanceStore.getRequestedInstanceStatesByChannel().get(Long.valueOf(channel3.getId()));
        } else {
            storeRequestedStageChannels$StageInstanceState = null;
        }
        if (channel3 != null) {
            long id4 = channel3.getId();
            WidgetChatListAdapterItemStageInvite$Model$Companion widgetChatListAdapterItemStageInvite$Model$Companion = WidgetChatListAdapterItemStageInvite$Model.Companion;
            stageInstance2 = stageInstance;
            listAccess$speakersFromLocalStore = WidgetChatListAdapterItemStageInvite$Model$Companion.access$speakersFromLocalStore(widgetChatListAdapterItemStageInvite$Model$Companion, this.$guildStore, this.$userStore, this.$stageChannelStore, id4, this.$item.getGuildId());
            if (listAccess$speakersFromLocalStore == null) {
                listAccess$speakersFromLocalStore = WidgetChatListAdapterItemStageInvite$Model$Companion.access$speakersFromRequest(widgetChatListAdapterItemStageInvite$Model$Companion, storeRequestedStageChannels$StageInstanceState);
            }
        } else {
            stageInstance2 = stageInstance;
            listAccess$speakersFromLocalStore = null;
        }
        if (channelRoles == null || listAccess$speakersFromLocalStore == null) {
            if ((storeRequestedStageChannels$StageInstanceState != null ? storeRequestedStageChannels$StageInstanceState.getStageInstance() : null) != null) {
                numValueOf = Integer.valueOf(storeRequestedStageChannels$StageInstanceState.getStageInstance().getParticipantCount() - storeRequestedStageChannels$StageInstanceState.getStageInstance().d().size());
            } else {
                num = null;
            }
            ModelInvite invite = this.$item.getInvite();
            boolean z2 = !reducedMotionEnabled;
            if (listAccess$speakersFromLocalStore != null) {
                listEmptyList = listAccess$speakersFromLocalStore;
            } else {
                listEmptyList = n.emptyList();
            }
            return new WidgetChatListAdapterItemStageInvite$Model(invite, id2, user, channel3, z2, stageInstance2, listEmptyList, num);
        }
        numValueOf = Integer.valueOf(channelRoles.size() - listAccess$speakersFromLocalStore.size());
        num = numValueOf;
        ModelInvite invite2 = this.$item.getInvite();
        boolean z3 = !reducedMotionEnabled;
        if (listAccess$speakersFromLocalStore != null) {
            listEmptyList = listAccess$speakersFromLocalStore;
        } else {
            listEmptyList = n.emptyList();
        }
        return new WidgetChatListAdapterItemStageInvite$Model(invite2, id2, user, channel3, z3, stageInstance2, listEmptyList, num);
    }
}
