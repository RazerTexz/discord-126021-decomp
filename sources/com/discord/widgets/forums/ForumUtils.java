package com.discord.widgets.forums;

import android.content.Context;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.message.Message;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p027k.C1107b;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: ForumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumUtils {
    public static final ForumUtils INSTANCE = new ForumUtils();
    private static final long ONE_DAY_IN_MILLIS = 86400000;
    private static final long ONE_HOUR_IN_MILLIS = 3600000;
    private static final String PLACEHOLDER_EMOJI_KEY = "heart";
    private static final long THIRTY_DAYS_IN_MILLIS = 2592000000L;

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumUtils$observeCanAccessRedesignedForumChannels$1 */
    /* JADX INFO: compiled from: ForumUtils.kt */
    public static final class C83351 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ StoreExperiments $experimentsStore;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83351(long j, StoreExperiments storeExperiments) {
            super(0);
            this.$guildId = j;
            this.$experimentsStore = storeExperiments;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return ForumUtils.INSTANCE.canAccessRedesignedForumChannels(this.$guildId, this.$experimentsStore);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumUtils$observeCanCreateForumChannels$1 */
    /* JADX INFO: compiled from: ForumUtils.kt */
    public static final class C83361 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ StoreExperiments $experimentsStore;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83361(long j, StoreExperiments storeExperiments) {
            super(0);
            this.$guildId = j;
            this.$experimentsStore = storeExperiments;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return ForumUtils.INSTANCE.canAccessForumChannels(this.$guildId, this.$experimentsStore);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumUtils$observeSelectedPostChannel$1 */
    /* JADX INFO: compiled from: ForumUtils.kt */
    public static final class C83371 extends AbstractC12240o implements Function0<Channel> {
        public final /* synthetic */ StoreChannels $storeChannels;
        public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
        public final /* synthetic */ StoreExperiments $storeExperiments;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83371(StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, StoreChannels storeChannels) {
            super(0);
            this.$storeChannelsSelected = storeChannelsSelected;
            this.$storeExperiments = storeExperiments;
            this.$storeChannels = storeChannels;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel selectedChannel = this.$storeChannelsSelected.getSelectedChannel();
            if (selectedChannel == null) {
                return null;
            }
            boolean zCanAccessRedesignedForumChannels = ForumUtils.INSTANCE.canAccessRedesignedForumChannels(selectedChannel.getGuildId(), this.$storeExperiments);
            Channel channel = this.$storeChannels.getChannel(selectedChannel.getParentId());
            if (zCanAccessRedesignedForumChannels && channel != null && ChannelUtils.m7693q(channel)) {
                return selectedChannel;
            }
            return null;
        }
    }

    private ForumUtils() {
    }

    private final boolean canAccessForumChannels(long guildId, StoreExperiments experimentsStore) {
        Experiment guildExperiment = experimentsStore.getGuildExperiment("2021-07_threads_only_channel", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public static /* synthetic */ boolean canAccessForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        return forumUtils.canAccessForumChannels(j, storeExperiments);
    }

    public static /* synthetic */ boolean canAccessRedesignedForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        return forumUtils.canAccessRedesignedForumChannels(j, storeExperiments);
    }

    private final Comparator<MessageReaction> getMessageReactionComparator(final StoreEmoji storeEmoji) {
        return new Comparator<MessageReaction>() { // from class: com.discord.widgets.forums.ForumUtils.getMessageReactionComparator.1
            @Override // java.util.Comparator
            public final int compare(MessageReaction messageReaction, MessageReaction messageReaction2) {
                if (messageReaction != null && messageReaction2 != null) {
                    int count = messageReaction.getCount();
                    int count2 = messageReaction2.getCount();
                    String placeholderReactionName = ForumUtils.INSTANCE.getPlaceholderReactionName(storeEmoji);
                    String name = messageReaction.getEmoji().getName();
                    String name2 = messageReaction2.getEmoji().getName();
                    String strM8116c = messageReaction.getEmoji().m8116c();
                    String strM8116c2 = messageReaction2.getEmoji().m8116c();
                    if (count2 != count) {
                        return count2 - count;
                    }
                    if (C12238m.areEqual(placeholderReactionName, name)) {
                        return 1;
                    }
                    if (!C12238m.areEqual(placeholderReactionName, name2) && strM8116c2.compareTo(strM8116c) <= 0) {
                        return 1;
                    }
                } else if (messageReaction == null || messageReaction2 != null) {
                    return (messageReaction != null || messageReaction2 == null) ? 0 : 1;
                }
                return -1;
            }
        };
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
            archivedThreadsStore = StoreStream.INSTANCE.getArchivedThreads();
        }
        return forumUtils.maybeLoadAndObserveThreadListing(j, z2, archivedThreadsStore);
    }

    public static /* synthetic */ Observable observeCanAccessRedesignedForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return forumUtils.observeCanAccessRedesignedForumChannels(j, storeExperiments, observationDeck);
    }

    public static /* synthetic */ Observable observeCanCreateForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return forumUtils.observeCanCreateForumChannels(j, storeExperiments, observationDeck);
    }

    public static /* synthetic */ Observable observeSelectedPostChannel$default(ForumUtils forumUtils, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        if ((i & 8) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return forumUtils.observeSelectedPostChannel(storeChannels, storeChannelsSelected, storeExperiments, observationDeck);
    }

    public final boolean canAccessRedesignedForumChannels(long guildId, StoreExperiments experimentsStore) {
        C12238m.checkNotNullParameter(experimentsStore, "experimentsStore");
        Experiment guildExperiment = experimentsStore.getGuildExperiment("2022-03_android_forum_channel_redesign", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public final CharSequence getActiveAgoTimestamp(Context context, Long lastMessageTimestampMs) {
        C12238m.checkNotNullParameter(context, "context");
        if (lastMessageTimestampMs == null) {
            return null;
        }
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - lastMessageTimestampMs.longValue();
        if (jCurrentTimeMillis < 0) {
            return null;
        }
        if (jCurrentTimeMillis < ONE_HOUR_IN_MILLIS) {
            return C1107b.m216h(context, C5419R.string.form_post_active_ago_timestamp_minutes, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getMinutesFromMillis(jCurrentTimeMillis))}, null, 4);
        }
        if (jCurrentTimeMillis < ONE_DAY_IN_MILLIS) {
            return C1107b.m216h(context, C5419R.string.form_post_active_ago_timestamp_hours, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getHoursFromMillis(jCurrentTimeMillis))}, null, 4);
        }
        return jCurrentTimeMillis < 2592000000L ? C1107b.m216h(context, C5419R.string.form_post_active_ago_timestamp_days, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getDaysFromMillis(jCurrentTimeMillis))}, null, 4) : context.getString(C5419R.string.form_post_active_ago_timestamp_more_than_month);
    }

    public final String getMessageCountString(Integer messageCount) {
        if (messageCount == null) {
            return null;
        }
        return messageCount.intValue() < 50 ? String.valueOf(messageCount.intValue()) : "50+";
    }

    public final MessageReaction getPlaceholderMessageReaction(StoreEmoji storeEmoji) {
        C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
        ModelEmojiUnicode modelEmojiUnicode = storeEmoji.getUnicodeEmojisNamesMap().get(PLACEHOLDER_EMOJI_KEY);
        if (modelEmojiUnicode != null) {
            return new MessageReaction(0, new MessageReactionEmoji(null, modelEmojiUnicode.getUniqueId(), false), false);
        }
        return null;
    }

    public final CharSequence getUnreadMessageCountString(Context context, Integer unreadCount) {
        C12238m.checkNotNullParameter(context, "context");
        if (unreadCount == null || unreadCount.intValue() == 0) {
            return null;
        }
        return C1107b.m216h(context, C5419R.string.forum_post_message_count_short_parenthetical, new Object[]{unreadCount.intValue() < 10 ? String.valueOf(unreadCount.intValue()) : "10+"}, null, 4);
    }

    public final boolean isDefaultPostReaction(MessageReaction messageReaction, StoreEmoji storeEmoji) {
        C12238m.checkNotNullParameter(messageReaction, "$this$isDefaultPostReaction");
        C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
        return C12238m.areEqual(messageReaction.getEmoji().getName(), getPlaceholderReactionName(storeEmoji));
    }

    public final Observable<ArchivedThreadsStore.ThreadListingState> maybeLoadAndObserveThreadListing(long channelId, boolean hasActiveThreads, ArchivedThreadsStore storeArchivedThreads) {
        C12238m.checkNotNullParameter(storeArchivedThreads, "storeArchivedThreads");
        return hasActiveThreads ? storeArchivedThreads.observeGuildForumThreadListing(channelId) : storeArchivedThreads.loadAndObserveGuildForumThreadListing(channelId);
    }

    public final MessageReaction mostCommonReaction(Message message, StoreEmoji storeEmoji) {
        List listSortedWith;
        C12238m.checkNotNullParameter(message, "$this$mostCommonReaction");
        C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
        List<MessageReaction> reactions = message.getReactions();
        if (reactions == null || (listSortedWith = C12163u.sortedWith(reactions, getMessageReactionComparator(storeEmoji))) == null) {
            return null;
        }
        return (MessageReaction) C12163u.firstOrNull(listSortedWith);
    }

    public final Observable<Boolean> observeCanAccessRedesignedForumChannels(long guildId, StoreExperiments experimentsStore, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(experimentsStore, "experimentsStore");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{experimentsStore}, false, null, null, new C83351(guildId, experimentsStore), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> observeCanCreateForumChannels(long guildId, StoreExperiments experimentsStore, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(experimentsStore, "experimentsStore");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{experimentsStore}, false, null, null, new C83361(guildId, experimentsStore), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Channel> observeSelectedPostChannel(StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Channel> observableM11112r = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeChannels, storeChannelsSelected, storeExperiments}, false, null, null, new C83371(storeChannelsSelected, storeExperiments, storeChannels), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }
}
