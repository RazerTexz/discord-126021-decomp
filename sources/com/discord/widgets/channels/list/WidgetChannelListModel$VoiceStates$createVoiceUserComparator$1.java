package com.discord.widgets.channels.list;

import com.discord.models.member.GuildMember;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import java.util.Comparator;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1<T> implements Comparator<ChannelListItemVoiceUser> {
    public static final WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1 INSTANCE = new WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ChannelListItemVoiceUser channelListItemVoiceUser, ChannelListItemVoiceUser channelListItemVoiceUser2) {
        return compare2(channelListItemVoiceUser, channelListItemVoiceUser2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(ChannelListItemVoiceUser channelListItemVoiceUser, ChannelListItemVoiceUser channelListItemVoiceUser2) {
        if (channelListItemVoiceUser.isApplicationStreaming() && !channelListItemVoiceUser2.isApplicationStreaming()) {
            return -1;
        }
        if (!channelListItemVoiceUser2.isApplicationStreaming() || channelListItemVoiceUser.isApplicationStreaming()) {
            return GuildMember.Companion.compareUserNames(channelListItemVoiceUser.getUser(), channelListItemVoiceUser2.getUser(), channelListItemVoiceUser.getComputed(), channelListItemVoiceUser2.getComputed());
        }
        return 1;
    }
}
