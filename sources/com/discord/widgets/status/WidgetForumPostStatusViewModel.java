package com.discord.widgets.status;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.media.AudioAttributesCompat;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetForumPostStatusViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func5;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel extends AbstractC0859d0<ViewState> {

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

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100901 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C100901() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetForumPostStatusViewModel widgetForumPostStatusViewModel = WidgetForumPostStatusViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            widgetForumPostStatusViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStoreState(final StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, final StoreThreadsJoined storeThreadsJoined, final StoreForumPostMessages storeForumPostMessages, final StoreThreadMessages storeThreadMessages, final StorePermissions storePermissions, final StoreEmoji storeEmoji) {
            C12238m.checkNotNullParameter(storeUser, "storeUser");
            C12238m.checkNotNullParameter(storeChannels, "storeChannels");
            C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
            C12238m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
            C12238m.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
            C12238m.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
            C12238m.checkNotNullParameter(storePermissions, "storePermissions");
            C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
            Observable<StoreState> observableM11099Y = ForumUtils.observeSelectedPostChannel$default(ForumUtils.INSTANCE, storeChannels, storeChannelsSelected, null, null, 12, null).m11099Y(new InterfaceC12589b<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetForumPostStatusViewModel.StoreState> call(final Channel channel) {
                    return channel == null ? new C12721k(WidgetForumPostStatusViewModel.StoreState.Invalid.INSTANCE) : Observable.m11072g(storeUser.observeMeId(), storeThreadsJoined.observeJoinedThread(channel.getId()), storeForumPostMessages.observeForumPostFirstMessage(channel.getParentId(), channel.getId(), true), storeThreadMessages.observeThreadCountAndLatestMessage(channel.getId()), storePermissions.observePermissionsForChannel(channel.getId()), new Func5<Long, StoreThreadsJoined.JoinedThread, Message, StoreThreadMessages.ThreadState, Long, WidgetForumPostStatusViewModel.StoreState.Loaded>() { // from class: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Func5
                        public final WidgetForumPostStatusViewModel.StoreState.Loaded call(Long l, StoreThreadsJoined.JoinedThread joinedThread, Message message, StoreThreadMessages.ThreadState threadState, Long l2) {
                            boolean zCan = PermissionUtils.can(64L, l2);
                            ForumUtils forumUtils = ForumUtils.INSTANCE;
                            MessageReaction placeholderMessageReaction = forumUtils.getPlaceholderMessageReaction(storeEmoji);
                            MessageReaction messageReactionMostCommonReaction = message != null ? forumUtils.mostCommonReaction(message, storeEmoji) : null;
                            boolean z2 = messageReactionMostCommonReaction != null && forumUtils.isDefaultPostReaction(messageReactionMostCommonReaction, storeEmoji);
                            C12238m.checkNotNullExpressionValue(l, "myUserId");
                            long jLongValue = l.longValue();
                            long id2 = channel.getId();
                            long guildId = channel.getGuildId();
                            boolean zM7686j = ChannelUtils.m7686j(channel);
                            boolean z3 = joinedThread != null;
                            Long lValueOf = message != null ? Long.valueOf(message.getId()) : null;
                            if (messageReactionMostCommonReaction != null) {
                                placeholderMessageReaction = messageReactionMostCommonReaction;
                            }
                            return new WidgetForumPostStatusViewModel.StoreState.Loaded(jLongValue, id2, guildId, lValueOf, z3, zM7686j, threadState != null ? Integer.valueOf(threadState.getCount()) : null, zCan, z2, placeholderMessageReaction);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "ForumUtils.observeSelect…      }\n        }\n      }");
            return observableM11099Y;
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
                return this.myUserId == loaded.myUserId && this.channelId == loaded.channelId && this.guildId == loaded.guildId && C12238m.areEqual(this.messageId, loaded.messageId) && this.isFollowedThread == loaded.isFollowedThread && this.isArchivedThread == loaded.isArchivedThread && C12238m.areEqual(this.messageCount, loaded.messageCount) && this.hasAddReactionPermission == loaded.hasAddReactionPermission && this.isDefaultReaction == loaded.isDefaultReaction && C12238m.areEqual(this.mostCommonReaction, loaded.mostCommonReaction);
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
                int iM3a = (C0002b.m3a(this.guildId) + ((C0002b.m3a(this.channelId) + (C0002b.m3a(this.myUserId) * 31)) * 31)) * 31;
                Long l = this.messageId;
                int iHashCode = (iM3a + (l != null ? l.hashCode() : 0)) * 31;
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
                StringBuilder sbM833U = C1643a.m833U("Loaded(myUserId=");
                sbM833U.append(this.myUserId);
                sbM833U.append(", channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", messageId=");
                sbM833U.append(this.messageId);
                sbM833U.append(", isFollowedThread=");
                sbM833U.append(this.isFollowedThread);
                sbM833U.append(", isArchivedThread=");
                sbM833U.append(this.isArchivedThread);
                sbM833U.append(", messageCount=");
                sbM833U.append(this.messageCount);
                sbM833U.append(", hasAddReactionPermission=");
                sbM833U.append(this.hasAddReactionPermission);
                sbM833U.append(", isDefaultReaction=");
                sbM833U.append(this.isDefaultReaction);
                sbM833U.append(", mostCommonReaction=");
                sbM833U.append(this.mostCommonReaction);
                sbM833U.append(")");
                return sbM833U.toString();
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
                return this.myUserId == valid.myUserId && this.channelId == valid.channelId && this.guildId == valid.guildId && this.isFollowedThread == valid.isFollowedThread && this.isArchivedThread == valid.isArchivedThread && C12238m.areEqual(this.messageId, valid.messageId) && C12238m.areEqual(this.reaction, valid.reaction) && this.isDefaultReaction == valid.isDefaultReaction && this.messageCount == valid.messageCount && this.hasAddReactionPermission == valid.hasAddReactionPermission && this.followRequestInProgress == valid.followRequestInProgress;
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
                int iM3a = (C0002b.m3a(this.guildId) + ((C0002b.m3a(this.channelId) + (C0002b.m3a(this.myUserId) * 31)) * 31)) * 31;
                boolean z2 = this.isFollowedThread;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iM3a + r1) * 31;
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
                StringBuilder sbM833U = C1643a.m833U("Valid(myUserId=");
                sbM833U.append(this.myUserId);
                sbM833U.append(", channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", isFollowedThread=");
                sbM833U.append(this.isFollowedThread);
                sbM833U.append(", isArchivedThread=");
                sbM833U.append(this.isArchivedThread);
                sbM833U.append(", messageId=");
                sbM833U.append(this.messageId);
                sbM833U.append(", reaction=");
                sbM833U.append(this.reaction);
                sbM833U.append(", isDefaultReaction=");
                sbM833U.append(this.isDefaultReaction);
                sbM833U.append(", messageCount=");
                sbM833U.append(this.messageCount);
                sbM833U.append(", hasAddReactionPermission=");
                sbM833U.append(this.hasAddReactionPermission);
                sbM833U.append(", followRequestInProgress=");
                return C1643a.m827O(sbM833U, this.followRequestInProgress, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$doPress$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100921 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isArchivedThread;
        public final /* synthetic */ Function0 $onFullMembership;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100921(boolean z2, Context context, Function0 function0) {
            super(0);
            this.$isArchivedThread = z2;
            this.$context = context;
            this.$onFullMembership = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$isArchivedThread) {
                C0876m.m169g(this.$context, C5419R.string.thread_archived, 0, null, 12);
            } else {
                this.$onFullMembership.invoke();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onFollowPress$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100931 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isFollowedThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100931(Context context, long j, boolean z2) {
            super(0);
            this.$context = context;
            this.$channelId = j;
            this.$isFollowedThread = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.this.toggleFollowPost(this.$context, this.$channelId, this.$isFollowedThread);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onReactionLongPress$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100941 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100941(long j, long j2, Context context, MessageReaction messageReaction) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$context = context;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetManageReactions.INSTANCE.create(this.$channelId, this.$messageId, this.$context, this.$reaction);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onReactionPress$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100951 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $hasAddReactionPermission;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ long $myUserId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100951(boolean z2, long j, long j2, long j3, MessageReaction messageReaction) {
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
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$hasAddReactionPermission) {
                WidgetForumPostStatusViewModel.this.userReactionHandler.toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100961 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100961(ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.this.followRequestInProgress = false;
            WidgetForumPostStatusViewModel.this.updateViewState(ViewState.Valid.copy$default(this.$viewState, 0L, 0L, 0L, false, false, null, null, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$2 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100972 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C100972 INSTANCE = new C100972();

        public C100972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$3 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100983 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100983(ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.this.followRequestInProgress = false;
            WidgetForumPostStatusViewModel.this.updateViewState(ViewState.Valid.copy$default(this.$viewState, 0L, 0L, 0L, false, false, null, null, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$4 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100994 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C100994 INSTANCE = new C100994();

        public C100994() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
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
        MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(context, fragmentManager, guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, new C100921(isArchivedThread, context, onFullMembership));
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
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channelId, "Forum Split View Toolbar"), false, 1, null), this, null, 2, null), (Class<?>) WidgetForumPostStatusViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : new C100961(valid)), C100972.INSTANCE);
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(channelId, "Forum Split View Toolbar", new RestAPIParams.EmptyBody()), false, 1, null), this, null, 2, null), (Class<?>) WidgetForumPostStatusViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : new C100983(valid)), C100994.INSTANCE);
        }
    }

    public final void handleStoreState(StoreState storeState) {
        C12238m.checkNotNullParameter(storeState, "storeState");
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
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        doPress(context, fragmentManager, guildId, isArchivedThread, new C100931(context, channelId, isFollowedThread));
    }

    public final void onReactionLongPress(Context context, FragmentManager fragmentManager, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new C100941(channelId, messageId, context, reaction));
    }

    public final void onReactionPress(Context context, FragmentManager fragmentManager, long myUserId, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction, boolean hasAddReactionPermission) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new C100951(hasAddReactionPermission, myUserId, channelId, messageId, reaction));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel(AppFragment appFragment, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreMessages storeMessages, StoreEmoji storeEmoji, StorePermissions storePermissions, WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(appFragment, "appFragment");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        C12238m.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        C12238m.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        C12238m.checkNotNullParameter(storeMessages, "storeMessages");
        C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(userReactionHandler, "userReactionHandler");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
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
        Observable observableM11112r = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetForumPostStatusViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100901());
    }
}
