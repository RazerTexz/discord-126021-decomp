package com.discord.widgets.status;

import a0.a.a.b;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.media.AudioAttributesCompat;
import b.a.d.AppToast;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.app.AppFragment;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetForumPostStatusViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AppFragment appFragment;
    private boolean followRequestInProgress;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreMessages storeMessages;
    private final StorePermissions storePermissions;
    private final StoreThreadMessages storeThreadMessages;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUser storeUser;
    private final WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler;

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetForumPostStatusViewModel widgetForumPostStatusViewModel = WidgetForumPostStatusViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            widgetForumPostStatusViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStoreState(final StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, final StoreThreadsJoined storeThreadsJoined, final StoreForumPostMessages storeForumPostMessages, final StoreThreadMessages storeThreadMessages, final StorePermissions storePermissions, final StoreEmoji storeEmoji) {
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
            Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
            Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
            Intrinsics3.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
            Intrinsics3.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
            Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
            Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
            Observable<StoreState> observableY = ForumUtils.observeSelectedPostChannel$default(ForumUtils.INSTANCE, storeChannels, storeChannelsSelected, null, null, 12, null).Y(new Func1<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetForumPostStatusViewModel.StoreState> call(final Channel channel) {
                    return channel == null ? new ScalarSynchronousObservable(WidgetForumPostStatusViewModel.StoreState.Invalid.INSTANCE) : Observable.g(storeUser.observeMeId(), storeThreadsJoined.observeJoinedThread(channel.getId()), storeForumPostMessages.observeForumPostFirstMessage(channel.getParentId(), channel.getId(), true), storeThreadMessages.observeThreadCountAndLatestMessage(channel.getId()), storePermissions.observePermissionsForChannel(channel.getId()), new Func5<Long, StoreThreadsJoined.JoinedThread, Message, StoreThreadMessages.ThreadState, Long, WidgetForumPostStatusViewModel.StoreState.Loaded>() { // from class: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1.1
                        @Override // rx.functions.Func5
                        public final WidgetForumPostStatusViewModel.StoreState.Loaded call(Long l, StoreThreadsJoined.JoinedThread joinedThread, Message message, StoreThreadMessages.ThreadState threadState, Long l2) {
                            boolean zCan = PermissionUtils.can(64L, l2);
                            ForumUtils forumUtils = ForumUtils.INSTANCE;
                            MessageReaction placeholderMessageReaction = forumUtils.getPlaceholderMessageReaction(storeEmoji);
                            MessageReaction messageReactionMostCommonReaction = message != null ? forumUtils.mostCommonReaction(message, storeEmoji) : null;
                            boolean z2 = messageReactionMostCommonReaction != null && forumUtils.isDefaultPostReaction(messageReactionMostCommonReaction, storeEmoji);
                            Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
                            long jLongValue = l.longValue();
                            long id2 = channel.getId();
                            long guildId = channel.getGuildId();
                            boolean zJ = ChannelUtils.j(channel);
                            boolean z3 = joinedThread != null;
                            Long lValueOf = message != null ? Long.valueOf(message.getId()) : null;
                            if (messageReactionMostCommonReaction != null) {
                                placeholderMessageReaction = messageReactionMostCommonReaction;
                            }
                            return new WidgetForumPostStatusViewModel.StoreState.Loaded(jLongValue, id2, guildId, lValueOf, z3, zJ, threadState != null ? Integer.valueOf(threadState.getCount()) : null, zCan, z2, placeholderMessageReaction);
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "ForumUtils.observeSelect…      }\n        }\n      }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final long channelId;
            private final long guildId;
            private final boolean hasAddReactionPermission;
            private final boolean isArchivedThread;
            private final boolean isDefaultReaction;
            private final boolean isFollowedThread;
            private final Integer messageCount;
            private final Long messageId;
            private final MessageReaction mostCommonReaction;
            private final long myUserId;

            public Loaded(long j, long j2, long j3, Long l, boolean z2, boolean z3, Integer num, boolean z4, boolean z5, MessageReaction messageReaction) {
                super(null);
                this.myUserId = j;
                this.channelId = j2;
                this.guildId = j3;
                this.messageId = l;
                this.isFollowedThread = z2;
                this.isArchivedThread = z3;
                this.messageCount = num;
                this.hasAddReactionPermission = z4;
                this.isDefaultReaction = z5;
                this.mostCommonReaction = messageReaction;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final MessageReaction getMostCommonReaction() {
                return this.mostCommonReaction;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Long getMessageId() {
                return this.messageId;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getIsFollowedThread() {
                return this.isFollowedThread;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsArchivedThread() {
                return this.isArchivedThread;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Integer getMessageCount() {
                return this.messageCount;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getIsDefaultReaction() {
                return this.isDefaultReaction;
            }

            public final Loaded copy(long myUserId, long channelId, long guildId, Long messageId, boolean isFollowedThread, boolean isArchivedThread, Integer messageCount, boolean hasAddReactionPermission, boolean isDefaultReaction, MessageReaction mostCommonReaction) {
                return new Loaded(myUserId, channelId, guildId, messageId, isFollowedThread, isArchivedThread, messageCount, hasAddReactionPermission, isDefaultReaction, mostCommonReaction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.myUserId == loaded.myUserId && this.channelId == loaded.channelId && this.guildId == loaded.guildId && Intrinsics3.areEqual(this.messageId, loaded.messageId) && this.isFollowedThread == loaded.isFollowedThread && this.isArchivedThread == loaded.isArchivedThread && Intrinsics3.areEqual(this.messageCount, loaded.messageCount) && this.hasAddReactionPermission == loaded.hasAddReactionPermission && this.isDefaultReaction == loaded.isDefaultReaction && Intrinsics3.areEqual(this.mostCommonReaction, loaded.mostCommonReaction);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            public final Integer getMessageCount() {
                return this.messageCount;
            }

            public final Long getMessageId() {
                return this.messageId;
            }

            public final MessageReaction getMostCommonReaction() {
                return this.mostCommonReaction;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10, types: [int] */
            /* JADX WARN: Type inference failed for: r1v15, types: [int] */
            /* JADX WARN: Type inference failed for: r1v18 */
            /* JADX WARN: Type inference failed for: r1v20 */
            /* JADX WARN: Type inference failed for: r1v21 */
            /* JADX WARN: Type inference failed for: r1v23 */
            /* JADX WARN: Type inference failed for: r1v24 */
            /* JADX WARN: Type inference failed for: r1v25 */
            /* JADX WARN: Type inference failed for: r1v8, types: [int] */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                int iA = (b.a(this.guildId) + ((b.a(this.channelId) + (b.a(this.myUserId) * 31)) * 31)) * 31;
                Long l = this.messageId;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                boolean z2 = this.isFollowedThread;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.isArchivedThread;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                Integer num = this.messageCount;
                int iHashCode2 = (i2 + (num != null ? num.hashCode() : 0)) * 31;
                boolean z4 = this.hasAddReactionPermission;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (iHashCode2 + r3) * 31;
                boolean z5 = this.isDefaultReaction;
                int i4 = (i3 + (z5 ? 1 : z5)) * 31;
                MessageReaction messageReaction = this.mostCommonReaction;
                return i4 + (messageReaction != null ? messageReaction.hashCode() : 0);
            }

            public final boolean isArchivedThread() {
                return this.isArchivedThread;
            }

            public final boolean isDefaultReaction() {
                return this.isDefaultReaction;
            }

            public final boolean isFollowedThread() {
                return this.isFollowedThread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", isFollowedThread=");
                sbU.append(this.isFollowedThread);
                sbU.append(", isArchivedThread=");
                sbU.append(this.isArchivedThread);
                sbU.append(", messageCount=");
                sbU.append(this.messageCount);
                sbU.append(", hasAddReactionPermission=");
                sbU.append(this.hasAddReactionPermission);
                sbU.append(", isDefaultReaction=");
                sbU.append(this.isDefaultReaction);
                sbU.append(", mostCommonReaction=");
                sbU.append(this.mostCommonReaction);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final long channelId;
            private final boolean followRequestInProgress;
            private final long guildId;
            private final boolean hasAddReactionPermission;
            private final boolean isArchivedThread;
            private final boolean isDefaultReaction;
            private final boolean isFollowedThread;
            private final int messageCount;
            private final Long messageId;
            private final long myUserId;
            private final MessageReaction reaction;

            public Valid(long j, long j2, long j3, boolean z2, boolean z3, Long l, MessageReaction messageReaction, boolean z4, int i, boolean z5, boolean z6) {
                super(null);
                this.myUserId = j;
                this.channelId = j2;
                this.guildId = j3;
                this.isFollowedThread = z2;
                this.isArchivedThread = z3;
                this.messageId = l;
                this.reaction = messageReaction;
                this.isDefaultReaction = z4;
                this.messageCount = i;
                this.hasAddReactionPermission = z5;
                this.followRequestInProgress = z6;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, long j, long j2, long j3, boolean z2, boolean z3, Long l, MessageReaction messageReaction, boolean z4, int i, boolean z5, boolean z6, int i2, Object obj) {
                return valid.copy((i2 & 1) != 0 ? valid.myUserId : j, (i2 & 2) != 0 ? valid.channelId : j2, (i2 & 4) != 0 ? valid.guildId : j3, (i2 & 8) != 0 ? valid.isFollowedThread : z2, (i2 & 16) != 0 ? valid.isArchivedThread : z3, (i2 & 32) != 0 ? valid.messageId : l, (i2 & 64) != 0 ? valid.reaction : messageReaction, (i2 & 128) != 0 ? valid.isDefaultReaction : z4, (i2 & 256) != 0 ? valid.messageCount : i, (i2 & 512) != 0 ? valid.hasAddReactionPermission : z5, (i2 & 1024) != 0 ? valid.followRequestInProgress : z6);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final boolean getFollowRequestInProgress() {
                return this.followRequestInProgress;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsFollowedThread() {
                return this.isFollowedThread;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getIsArchivedThread() {
                return this.isArchivedThread;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final Long getMessageId() {
                return this.messageId;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final MessageReaction getReaction() {
                return this.reaction;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsDefaultReaction() {
                return this.isDefaultReaction;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final int getMessageCount() {
                return this.messageCount;
            }

            public final Valid copy(long myUserId, long channelId, long guildId, boolean isFollowedThread, boolean isArchivedThread, Long messageId, MessageReaction reaction, boolean isDefaultReaction, int messageCount, boolean hasAddReactionPermission, boolean followRequestInProgress) {
                return new Valid(myUserId, channelId, guildId, isFollowedThread, isArchivedThread, messageId, reaction, isDefaultReaction, messageCount, hasAddReactionPermission, followRequestInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return this.myUserId == valid.myUserId && this.channelId == valid.channelId && this.guildId == valid.guildId && this.isFollowedThread == valid.isFollowedThread && this.isArchivedThread == valid.isArchivedThread && Intrinsics3.areEqual(this.messageId, valid.messageId) && Intrinsics3.areEqual(this.reaction, valid.reaction) && this.isDefaultReaction == valid.isDefaultReaction && this.messageCount == valid.messageCount && this.hasAddReactionPermission == valid.hasAddReactionPermission && this.followRequestInProgress == valid.followRequestInProgress;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getFollowRequestInProgress() {
                return this.followRequestInProgress;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            public final int getMessageCount() {
                return this.messageCount;
            }

            public final Long getMessageId() {
                return this.messageId;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final MessageReaction getReaction() {
                return this.reaction;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r0v18, types: [int] */
            /* JADX WARN: Type inference failed for: r0v20, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v13, types: [int] */
            /* JADX WARN: Type inference failed for: r1v16, types: [int] */
            /* JADX WARN: Type inference failed for: r1v18 */
            /* JADX WARN: Type inference failed for: r1v19 */
            /* JADX WARN: Type inference failed for: r1v21 */
            /* JADX WARN: Type inference failed for: r1v22 */
            /* JADX WARN: Type inference failed for: r1v23 */
            /* JADX WARN: Type inference failed for: r1v24 */
            /* JADX WARN: Type inference failed for: r1v25 */
            /* JADX WARN: Type inference failed for: r1v26 */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                int iA = (b.a(this.guildId) + ((b.a(this.channelId) + (b.a(this.myUserId) * 31)) * 31)) * 31;
                boolean z2 = this.isFollowedThread;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iA + r1) * 31;
                boolean z3 = this.isArchivedThread;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                Long l = this.messageId;
                int iHashCode = (i2 + (l != null ? l.hashCode() : 0)) * 31;
                MessageReaction messageReaction = this.reaction;
                int iHashCode2 = (iHashCode + (messageReaction != null ? messageReaction.hashCode() : 0)) * 31;
                boolean z4 = this.isDefaultReaction;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (((iHashCode2 + r3) * 31) + this.messageCount) * 31;
                boolean z5 = this.hasAddReactionPermission;
                ?? r4 = z5;
                if (z5) {
                    r4 = 1;
                }
                int i4 = (i3 + r4) * 31;
                boolean z6 = this.followRequestInProgress;
                return i4 + (z6 ? 1 : z6);
            }

            public final boolean isArchivedThread() {
                return this.isArchivedThread;
            }

            public final boolean isDefaultReaction() {
                return this.isDefaultReaction;
            }

            public final boolean isFollowedThread() {
                return this.isFollowedThread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", isFollowedThread=");
                sbU.append(this.isFollowedThread);
                sbU.append(", isArchivedThread=");
                sbU.append(this.isArchivedThread);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", reaction=");
                sbU.append(this.reaction);
                sbU.append(", isDefaultReaction=");
                sbU.append(this.isDefaultReaction);
                sbU.append(", messageCount=");
                sbU.append(this.messageCount);
                sbU.append(", hasAddReactionPermission=");
                sbU.append(this.hasAddReactionPermission);
                sbU.append(", followRequestInProgress=");
                return outline.O(sbU, this.followRequestInProgress, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$doPress$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isArchivedThread;
        public final /* synthetic */ Function0 $onFullMembership;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, Context context, Function0 function0) {
            super(0);
            this.$isArchivedThread = z2;
            this.$context = context;
            this.$onFullMembership = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$isArchivedThread) {
                AppToast.g(this.$context, R.string.thread_archived, 0, null, 12);
            } else {
                this.$onFullMembership.invoke();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onFollowPress$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isFollowedThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, long j, boolean z2) {
            super(0);
            this.$context = context;
            this.$channelId = j;
            this.$isFollowedThread = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.this.toggleFollowPost(this.$context, this.$channelId, this.$isFollowedThread);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onReactionLongPress$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Context context, MessageReaction messageReaction) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$context = context;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetManageReactions.INSTANCE.create(this.$channelId, this.$messageId, this.$context, this.$reaction);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onReactionPress$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $hasAddReactionPermission;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ long $myUserId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, long j, long j2, long j3, MessageReaction messageReaction) {
            super(0);
            this.$hasAddReactionPermission = z2;
            this.$myUserId = j;
            this.$channelId = j2;
            this.$messageId = j3;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$hasAddReactionPermission) {
                WidgetForumPostStatusViewModel.this.userReactionHandler.toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.this.followRequestInProgress = false;
            WidgetForumPostStatusViewModel.this.updateViewState(ViewState.Valid.copy$default(this.$viewState, 0L, 0L, 0L, false, false, null, null, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.this.followRequestInProgress = false;
            WidgetForumPostStatusViewModel.this.updateViewState(ViewState.Valid.copy$default(this.$viewState, 0L, 0L, 0L, false, false, null, null, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetForumPostStatusViewModel(AppFragment appFragment, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreMessages storeMessages, StoreEmoji storeEmoji, StorePermissions storePermissions, WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreChannelsSelected channelsSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreThreadsJoined threadsJoined = (i & 16) != 0 ? StoreStream.INSTANCE.getThreadsJoined() : storeThreadsJoined;
        StoreForumPostMessages forumPostMessages = (i & 32) != 0 ? StoreStream.INSTANCE.getForumPostMessages() : storeForumPostMessages;
        StoreThreadMessages threadMessages = (i & 64) != 0 ? StoreStream.INSTANCE.getThreadMessages() : storeThreadMessages;
        StoreMessages messages = (i & 128) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        StoreEmoji emojis = (i & 256) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StorePermissions permissions = (i & 512) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(appFragment, users, channels, channelsSelected, threadsJoined, forumPostMessages, threadMessages, messages, emojis, permissions, (i & 1024) != 0 ? new WidgetChatListAdapterEventsHandler.UserReactionHandler(appFragment, messages, emojis) : userReactionHandler, (i & 2048) != 0 ? INSTANCE.observeStoreState(users, channels, channelsSelected, threadsJoined, forumPostMessages, threadMessages, permissions, emojis) : observable);
    }

    private final void doPress(Context context, FragmentManager fragmentManager, long guildId, boolean isArchivedThread, Function0<Unit> onFullMembership) {
        MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(context, fragmentManager, guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.AnonymousClass1.INSTANCE : null, new AnonymousClass1(isArchivedThread, context, onFullMembership));
    }

    private final void toggleFollowPost(Context context, long channelId, boolean isFollowedThread) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || this.followRequestInProgress) {
            return;
        }
        this.followRequestInProgress = true;
        updateViewState(ViewState.Valid.copy$default(valid, 0L, 0L, 0L, false, false, null, null, false, 0, false, true, AudioAttributesCompat.FLAG_ALL, null));
        if (isFollowedThread) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channelId, "Forum Split View Toolbar"), false, 1, null), this, null, 2, null), (Class<?>) WidgetForumPostStatusViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass1(valid)), AnonymousClass2.INSTANCE);
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(channelId, "Forum Split View Toolbar", new RestAPIParams.EmptyBody()), false, 1, null), this, null, 2, null), (Class<?>) WidgetForumPostStatusViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass3(valid)), AnonymousClass4.INSTANCE);
        }
    }

    public final void handleStoreState(StoreState storeState) {
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        if (!(storeState instanceof StoreState.Loaded)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Loaded loaded = (StoreState.Loaded) storeState;
        long myUserId = loaded.getMyUserId();
        long channelId = loaded.getChannelId();
        long guildId = loaded.getGuildId();
        boolean zIsFollowedThread = loaded.isFollowedThread();
        boolean zIsArchivedThread = loaded.isArchivedThread();
        Long messageId = loaded.getMessageId();
        MessageReaction mostCommonReaction = loaded.getMostCommonReaction();
        boolean zIsDefaultReaction = loaded.isDefaultReaction();
        Integer messageCount = loaded.getMessageCount();
        int iIntValue = messageCount != null ? messageCount.intValue() : 0;
        boolean hasAddReactionPermission = loaded.getHasAddReactionPermission();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        updateViewState(new ViewState.Valid(myUserId, channelId, guildId, zIsFollowedThread, zIsArchivedThread, messageId, mostCommonReaction, zIsDefaultReaction, iIntValue, hasAddReactionPermission, valid != null ? valid.getFollowRequestInProgress() : false));
    }

    public final void onFollowPress(Context context, FragmentManager fragmentManager, long guildId, long channelId, boolean isArchivedThread, boolean isFollowedThread) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        doPress(context, fragmentManager, guildId, isArchivedThread, new AnonymousClass1(context, channelId, isFollowedThread));
    }

    public final void onReactionLongPress(Context context, FragmentManager fragmentManager, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new AnonymousClass1(channelId, messageId, context, reaction));
    }

    public final void onReactionPress(Context context, FragmentManager fragmentManager, long myUserId, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction, boolean hasAddReactionPermission) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new AnonymousClass1(hasAddReactionPermission, myUserId, channelId, messageId, reaction));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel(AppFragment appFragment, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreMessages storeMessages, StoreEmoji storeEmoji, StorePermissions storePermissions, WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(appFragment, "appFragment");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        Intrinsics3.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        Intrinsics3.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(userReactionHandler, "userReactionHandler");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.appFragment = appFragment;
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeThreadsJoined = storeThreadsJoined;
        this.storeForumPostMessages = storeForumPostMessages;
        this.storeThreadMessages = storeThreadMessages;
        this.storeMessages = storeMessages;
        this.storeEmoji = storeEmoji;
        this.storePermissions = storePermissions;
        this.userReactionHandler = userReactionHandler;
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) WidgetForumPostStatusViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
