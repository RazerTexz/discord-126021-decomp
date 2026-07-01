package com.discord.widgets.channels.list.items;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: ChannelListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ChannelListItem extends MGRecyclerDataPayload {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_ACTIVE_EVENT = 15;
    public static final int TYPE_ADD_SERVER = 18;
    public static final int TYPE_BOTTOM_NAV_SPACE = 11;
    public static final int TYPE_CATEGORY = 8;
    public static final int TYPE_CHANNEL = 0;
    public static final int TYPE_CHANNEL_PRIVATE = 3;
    public static final int TYPE_CHANNEL_STAGE_VOICE = 13;
    public static final int TYPE_CHANNEL_VOICE = 1;
    public static final int TYPE_CHANNEL_VOICE_USER = 2;
    public static final int TYPE_DIRECTORY = 17;
    public static final int TYPE_GUILD_JOIN_REQUEST = 22;
    public static final int TYPE_GUILD_ROLE_SUBSCRIPTIONS_OVERVIEW = 21;
    public static final int TYPE_GUILD_SCHEDULED_EVENTS = 19;
    public static final int TYPE_HEADER = 6;
    public static final int TYPE_HUB_INVITE = 20;
    public static final int TYPE_INVITE = 9;
    public static final int TYPE_MFA_NOTICE = 7;
    public static final int TYPE_STAGE_AUDIENCE_COUNT = 16;
    public static final int TYPE_STAGE_EVENTS_SEPARATOR = 14;
    public static final int TYPE_THREAD = 12;

    /* JADX INFO: compiled from: ChannelListItem.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_ACTIVE_EVENT = 15;
        public static final int TYPE_ADD_SERVER = 18;
        public static final int TYPE_BOTTOM_NAV_SPACE = 11;
        public static final int TYPE_CATEGORY = 8;
        public static final int TYPE_CHANNEL = 0;
        public static final int TYPE_CHANNEL_PRIVATE = 3;
        public static final int TYPE_CHANNEL_STAGE_VOICE = 13;
        public static final int TYPE_CHANNEL_VOICE = 1;
        public static final int TYPE_CHANNEL_VOICE_USER = 2;
        public static final int TYPE_DIRECTORY = 17;
        public static final int TYPE_GUILD_JOIN_REQUEST = 22;
        public static final int TYPE_GUILD_ROLE_SUBSCRIPTIONS_OVERVIEW = 21;
        public static final int TYPE_GUILD_SCHEDULED_EVENTS = 19;
        public static final int TYPE_HEADER = 6;
        public static final int TYPE_HUB_INVITE = 20;
        public static final int TYPE_INVITE = 9;
        public static final int TYPE_MFA_NOTICE = 7;
        public static final int TYPE_STAGE_AUDIENCE_COUNT = 16;
        public static final int TYPE_STAGE_EVENTS_SEPARATOR = 14;
        public static final int TYPE_THREAD = 12;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ChannelListItem.kt */
    public static final class DefaultImpls {
        public static String getKey(ChannelListItem channelListItem) {
            return String.valueOf(channelListItem.getType());
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    String getKey();
}
