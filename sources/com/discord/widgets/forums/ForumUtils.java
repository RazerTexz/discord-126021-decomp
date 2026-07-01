package com.discord.widgets.forums;

import android.content.Context;
import b.a.k.b;
import com.discord.api.channel.Channel;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.message.Message;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.t.u;
import d0.z.d.m;
import java.util.Comparator;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: ForumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumUtils {
    public static final ForumUtils INSTANCE = new ForumUtils();
    private static final long ONE_DAY_IN_MILLIS = 86400000;
    private static final long ONE_HOUR_IN_MILLIS = 3600000;
    private static final String PLACEHOLDER_EMOJI_KEY = "heart";
    private static final long THIRTY_DAYS_IN_MILLIS = 2592000000L;

    private ForumUtils() {
    }

    public static final /* synthetic */ boolean access$canAccessForumChannels(ForumUtils forumUtils, long j, StoreExperiments storeExperiments) {
        return forumUtils.canAccessForumChannels(j, storeExperiments);
    }

    public static final /* synthetic */ String access$getPlaceholderReactionName(ForumUtils forumUtils, StoreEmoji storeEmoji) {
        return forumUtils.getPlaceholderReactionName(storeEmoji);
    }

    private final boolean canAccessForumChannels(long guildId, StoreExperiments experimentsStore) {
        Experiment guildExperiment = experimentsStore.getGuildExperiment("2021-07_threads_only_channel", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public static /* synthetic */ boolean canAccessForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        return forumUtils.canAccessForumChannels(j, storeExperiments);
    }

    public static /* synthetic */ boolean canAccessRedesignedForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        return forumUtils.canAccessRedesignedForumChannels(j, storeExperiments);
    }

    private final Comparator<MessageReaction> getMessageReactionComparator(StoreEmoji storeEmoji) {
        return new ForumUtils$getMessageReactionComparator$1(storeEmoji);
    }

    private final String getPlaceholderReactionName(StoreEmoji storeEmoji) {
        MessageReactionEmoji emoji;
        MessageReaction placeholderMessageReaction = getPlaceholderMessageReaction(storeEmoji);
        if (placeholderMessageReaction == null || (emoji = placeholderMessageReaction.getEmoji()) == null) {
            return null;
        }
        return emoji.getName();
    }

    public static /* synthetic */ Observable maybeLoadAndObserveThreadListing$default(ForumUtils forumUtils, long j, boolean z2, ArchivedThreadsStore archivedThreadsStore, int i, Object obj) {
        if ((i & 4) != 0) {
            archivedThreadsStore = StoreStream.Companion.getArchivedThreads();
        }
        return forumUtils.maybeLoadAndObserveThreadListing(j, z2, archivedThreadsStore);
    }

    public static /* synthetic */ Observable observeCanAccessRedesignedForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return forumUtils.observeCanAccessRedesignedForumChannels(j, storeExperiments, observationDeck);
    }

    public static /* synthetic */ Observable observeCanCreateForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return forumUtils.observeCanCreateForumChannels(j, storeExperiments, observationDeck);
    }

    public static /* synthetic */ Observable observeSelectedPostChannel$default(ForumUtils forumUtils, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 4) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        if ((i & 8) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return forumUtils.observeSelectedPostChannel(storeChannels, storeChannelsSelected, storeExperiments, observationDeck);
    }

    public final boolean canAccessRedesignedForumChannels(long guildId, StoreExperiments experimentsStore) {
        m.checkNotNullParameter(experimentsStore, "experimentsStore");
        Experiment guildExperiment = experimentsStore.getGuildExperiment("2022-03_android_forum_channel_redesign", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public final CharSequence getActiveAgoTimestamp(Context context, Long lastMessageTimestampMs) {
        m.checkNotNullParameter(context, "context");
        if (lastMessageTimestampMs == null) {
            return null;
        }
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - lastMessageTimestampMs.longValue();
        if (jCurrentTimeMillis < 0) {
            return null;
        }
        if (jCurrentTimeMillis < ONE_HOUR_IN_MILLIS) {
            return b.h(context, 2131889304, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getMinutesFromMillis(jCurrentTimeMillis))}, null, 4);
        }
        if (jCurrentTimeMillis < ONE_DAY_IN_MILLIS) {
            return b.h(context, 2131889303, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getHoursFromMillis(jCurrentTimeMillis))}, null, 4);
        }
        return jCurrentTimeMillis < 2592000000L ? b.h(context, 2131889302, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getDaysFromMillis(jCurrentTimeMillis))}, null, 4) : context.getString(2131889305);
    }

    public final String getMessageCountString(Integer messageCount) {
        if (messageCount == null) {
            return null;
        }
        return messageCount.intValue() < 50 ? String.valueOf(messageCount.intValue()) : "50+";
    }

    public final MessageReaction getPlaceholderMessageReaction(StoreEmoji storeEmoji) {
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        ModelEmojiUnicode modelEmojiUnicode = storeEmoji.getUnicodeEmojisNamesMap().get(PLACEHOLDER_EMOJI_KEY);
        if (modelEmojiUnicode != null) {
            return new MessageReaction(0, new MessageReactionEmoji(null, modelEmojiUnicode.getUniqueId(), false), false);
        }
        return null;
    }

    public final CharSequence getUnreadMessageCountString(Context context, Integer unreadCount) {
        m.checkNotNullParameter(context, "context");
        if (unreadCount == null || unreadCount.intValue() == 0) {
            return null;
        }
        return b.h(context, 2131889395, new Object[]{unreadCount.intValue() < 10 ? String.valueOf(unreadCount.intValue()) : "10+"}, null, 4);
    }

    public final boolean isDefaultPostReaction(MessageReaction messageReaction, StoreEmoji storeEmoji) {
        m.checkNotNullParameter(messageReaction, "$this$isDefaultPostReaction");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        return m.areEqual(messageReaction.getEmoji().getName(), getPlaceholderReactionName(storeEmoji));
    }

    public final Observable<ArchivedThreadsStore$ThreadListingState> maybeLoadAndObserveThreadListing(long channelId, boolean hasActiveThreads, ArchivedThreadsStore storeArchivedThreads) {
        m.checkNotNullParameter(storeArchivedThreads, "storeArchivedThreads");
        return hasActiveThreads ? storeArchivedThreads.observeGuildForumThreadListing(channelId) : storeArchivedThreads.loadAndObserveGuildForumThreadListing(channelId);
    }

    public final MessageReaction mostCommonReaction(Message message, StoreEmoji storeEmoji) {
        List listSortedWith;
        m.checkNotNullParameter(message, "$this$mostCommonReaction");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        List<MessageReaction> reactions = message.getReactions();
        if (reactions == null || (listSortedWith = u.sortedWith(reactions, getMessageReactionComparator(storeEmoji))) == null) {
            return null;
        }
        return (MessageReaction) u.firstOrNull(listSortedWith);
    }

    public final Observable<Boolean> observeCanAccessRedesignedForumChannels(long guildId, StoreExperiments experimentsStore, ObservationDeck observationDeck) {
        m.checkNotNullParameter(experimentsStore, "experimentsStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{experimentsStore}, false, null, null, new ForumUtils$observeCanAccessRedesignedForumChannels$1(guildId, experimentsStore), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeCanCreateForumChannels(long guildId, StoreExperiments experimentsStore, ObservationDeck observationDeck) {
        m.checkNotNullParameter(experimentsStore, "experimentsStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{experimentsStore}, false, null, null, new ForumUtils$observeCanCreateForumChannels$1(guildId, experimentsStore), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Channel> observeSelectedPostChannel(StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Channel> observableR = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeChannels, storeChannelsSelected, storeExperiments}, false, null, null, new ForumUtils$observeSelectedPostChannel$1(storeChannelsSelected, storeExperiments, storeChannels), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }
}
