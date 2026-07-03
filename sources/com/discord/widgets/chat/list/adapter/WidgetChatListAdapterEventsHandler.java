package com.discord.widgets.chat.list.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageClicked;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageCtaClicked;
import com.discord.analytics.generated.events.TrackWelcomeCtaClicked;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityActionConfirmation;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.Message;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.sticker.StickerType;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.user.CoreUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.guilds.PublicGuildUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p500io.NetworkUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetPublicAnnouncementProfileSheet;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUrlUtils;
import com.discord.widgets.stickers.WidgetGuildStickerSheet;
import com.discord.widgets.stickers.WidgetStickerSheet;
import com.discord.widgets.stickers.WidgetUnknownStickerSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetStartCallSheet;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p643a.C12645l2;
import p637j0.p642l.p643a.C12666r;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler implements WidgetChatListAdapter.EventHandler {
    private final AnalyticsUtils.Tracker analyticsTracker;
    private final ChannelSelector channelSelector;
    private final StoreChannels channelStore;
    private final AppFlexInputViewModel flexInputViewModel;
    private final AppFragment host;
    private final MessageManager messageManager;
    private final StoreChat storeChat;
    private final StoreEmoji storeEmoji;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreUser storeUser;
    private final UserReactionHandler userReactionHandler;

    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class UserReactionHandler {
        private static final long REQUEST_RATE_LIMIT_MILLIS = 250;
        private final Function1<MessageReactionUpdate, Unit> commitReactionAdd;
        private final Function1<MessageReactionUpdate, Unit> commitReactionRemove;
        private final AppFragment host;
        private final Subject<UpdateRequest, UpdateRequest> requestStream;
        private final StoreEmoji storeEmoji;
        private final StoreMessages storeMessages;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$1 */
        /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
        public static final /* synthetic */ class C79911 extends C12236k implements Function1<UpdateRequest, Unit> {
            public C79911(UserReactionHandler userReactionHandler) {
                super(1, userReactionHandler, UserReactionHandler.class, "requestReactionUpdate", "requestReactionUpdate(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateRequest updateRequest) {
                invoke2(updateRequest);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateRequest updateRequest) {
                C12238m.checkNotNullParameter(updateRequest, "p1");
                ((UserReactionHandler) this.receiver).requestReactionUpdate(updateRequest);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
        public static final /* data */ class UpdateRequest {
            private final long channelId;
            private final long messageId;
            private final MessageReaction reaction;
            private final long userId;

            public UpdateRequest(long j, long j2, long j3, MessageReaction messageReaction) {
                C12238m.checkNotNullParameter(messageReaction, "reaction");
                this.userId = j;
                this.channelId = j2;
                this.messageId = j3;
                this.reaction = messageReaction;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final MessageReaction getReaction() {
                return this.reaction;
            }

            public final UpdateRequest copy(long userId, long channelId, long messageId, MessageReaction reaction) {
                C12238m.checkNotNullParameter(reaction, "reaction");
                return new UpdateRequest(userId, channelId, messageId, reaction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateRequest)) {
                    return false;
                }
                UpdateRequest updateRequest = (UpdateRequest) other;
                return this.userId == updateRequest.userId && this.channelId == updateRequest.channelId && this.messageId == updateRequest.messageId && C12238m.areEqual(this.reaction, updateRequest.reaction);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final MessageReaction getReaction() {
                return this.reaction;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                int iM3a = (C0002b.m3a(this.messageId) + ((C0002b.m3a(this.channelId) + (C0002b.m3a(this.userId) * 31)) * 31)) * 31;
                MessageReaction messageReaction = this.reaction;
                return iM3a + (messageReaction != null ? messageReaction.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("UpdateRequest(userId=");
                sbM833U.append(this.userId);
                sbM833U.append(", channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", messageId=");
                sbM833U.append(this.messageId);
                sbM833U.append(", reaction=");
                sbM833U.append(this.reaction);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        public UserReactionHandler(AppFragment appFragment, StoreMessages storeMessages, StoreEmoji storeEmoji) {
            C12238m.checkNotNullParameter(appFragment, "host");
            C12238m.checkNotNullParameter(storeMessages, "storeMessages");
            C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
            this.host = appFragment;
            this.storeMessages = storeMessages;
            this.storeEmoji = storeEmoji;
            PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
            C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
            this.requestStream = publishSubjectM11133k0;
            this.commitReactionAdd = new C7993x67322e18(this);
            this.commitReactionRemove = new C7994x36f98ea7(this);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(publishSubjectM11133k0);
            Observable observableM11074h0 = Observable.m11074h0(new C12666r(publishSubjectM11133k0.f27640j, new C12645l2(REQUEST_RATE_LIMIT_MILLIS, timeUnit, C12781a.m10873a())));
            C12238m.checkNotNullExpressionValue(observableM11074h0, "requestStream\n          …S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(observableM11074h0, (Class<?>) appFragment.getClass(), (58 & 2) != 0 ? null : appFragment.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79911(this));
        }

        private final void requestReactionUpdate(UpdateRequest updateRequest) {
            String name;
            long userId = updateRequest.getUserId();
            long channelId = updateRequest.getChannelId();
            long messageId = updateRequest.getMessageId();
            MessageReaction reaction = updateRequest.getReaction();
            MessageReactionUpdate messageReactionUpdate = new MessageReactionUpdate(userId, channelId, messageId, reaction.getEmoji());
            if (reaction.getEmoji().m8118e()) {
                name = reaction.getEmoji().getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + reaction.getEmoji().getId();
            } else {
                name = reaction.getEmoji().getName();
                if (name == null) {
                    name = "";
                }
            }
            Observable<Void> observableRemoveSelfReaction = reaction.getMe() ? RestAPI.INSTANCE.getApi().removeSelfReaction(channelId, messageId, name) : RestAPI.INSTANCE.getApi().addReaction(channelId, messageId, name);
            Function1<MessageReactionUpdate, Unit> function1 = reaction.getMe() ? this.commitReactionRemove : this.commitReactionAdd;
            Function1<MessageReactionUpdate, Unit> function2 = reaction.getMe() ? this.commitReactionAdd : this.commitReactionRemove;
            function1.invoke(messageReactionUpdate);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableRemoveSelfReaction, false, 1, null), this.host, null, 2, null), (Class<?>) this.host.getClass(), (58 & 2) != 0 ? null : this.host.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C7996x99eadd9(function2, messageReactionUpdate)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C7995x99eadd8(this, reaction));
        }

        public final void addNewReaction(Emoji emoji, long channelId, long messageId) {
            C12238m.checkNotNullParameter(emoji, "emoji");
            RestAPI api = RestAPI.INSTANCE.getApi();
            String reactionKey = emoji.getReactionKey();
            C12238m.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(channelId, messageId, reactionKey), false, 1, null), this.host, null, 2, null), (Class<?>) this.host.getClass(), (58 & 2) != 0 ? null : this.host.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C7992x9e32298b.INSTANCE);
        }

        public final void toggleReaction(long userId, long channelId, long messageId, MessageReaction reaction) {
            C12238m.checkNotNullParameter(reaction, "reaction");
            this.requestStream.onNext(new UpdateRequest(userId, channelId, messageId, reaction));
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WidgetChatListAdapterItemCallMessage.CallStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetChatListAdapterItemCallMessage.CallStatus.ACTIVE_JOINED.ordinal()] = 1;
            iArr[WidgetChatListAdapterItemCallMessage.CallStatus.ACTIVE_UNJOINED.ordinal()] = 2;
            StickerType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[StickerType.STANDARD.ordinal()] = 1;
            iArr2[StickerType.GUILD.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onCallMessageClicked$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C79971 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $voiceChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79971(long j) {
            super(0);
            this.$voiceChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, WidgetChatListAdapterEventsHandler.this.getContext(), this.$voiceChannelId, true, null, null, 24, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C79981 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79981(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EmojiPickerNavigator.launchBottomSheet$default(WidgetChatListAdapterEventsHandler.this.getFragmentManager(), new EmojiPickerListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler.onQuickAddReactionClicked.1.1
                @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
                public void onEmojiPicked(Emoji emoji) {
                    C12238m.checkNotNullParameter(emoji, "emoji");
                    UserReactionHandler userReactionHandler = WidgetChatListAdapterEventsHandler.this.userReactionHandler;
                    C79981 c79981 = C79981.this;
                    userReactionHandler.addNewReaction(emoji, c79981.$channelId, c79981.$messageId);
                }
            }, EmojiPickerContextType.Chat.INSTANCE, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C79991 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $fileName;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ WeakReference $weakContext;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<String, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Context context = (Context) C79991.this.$weakContext.get();
                if (context != null) {
                    C0876m.m170h(context, C1107b.m210b(context, C5419R.string.download_file_complete, new Object[]{str}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 0, null, 12);
                }
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Throwable, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                C12238m.checkNotNullParameter(th, "error");
                AppLog.m8358i("Could not download attachment due to:  \n" + th);
                Context context = (Context) C79991.this.$weakContext.get();
                if (context != null) {
                    C0876m.m170h((Context) C79991.this.$weakContext.get(), context.getString(C5419R.string.download_failed), 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79991(Uri uri, String str, WeakReference weakReference) {
            super(0);
            this.$uri = uri;
            this.$fileName = str;
            this.$weakContext = weakReference;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            NetworkUtils.downloadFile(WidgetChatListAdapterEventsHandler.this.getContext(), this.$uri, this.$fileName, null, new AnonymousClass1(), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onReactionClicked$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80001 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ long $myUserId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80001(long j, long j2, long j3, MessageReaction messageReaction) {
            super(0);
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
            WidgetChatListAdapterEventsHandler.this.userReactionHandler.toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onReactionLongClicked$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80011 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80011(long j, long j2, MessageReaction messageReaction) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetManageReactions.INSTANCE.create(this.$channelId, this.$messageId, WidgetChatListAdapterEventsHandler.this.getContext(), this.$reaction);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80021 extends AbstractC12240o implements Function1<Message, Unit> {
        public static final C80021 INSTANCE = new C80021();

        public C80021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            C12238m.checkNotNullParameter(message, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onShareButtonClick$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80031 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ long $guildEventId;
        public final /* synthetic */ WeakReference $weakFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80031(WeakReference weakReference, Channel channel, long j) {
            super(1);
            this.$weakFragment = weakReference;
            this.$channel = channel;
            this.$guildEventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            AppFragment appFragment = (AppFragment) this.$weakFragment.get();
            if (appFragment != null) {
                ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(appFragment, "fragment");
                Channel channel2 = this.$channel;
                channelInviteLaunchUtils.inviteToChannel(appFragment, channel2 != null ? channel2 : channel, GuildScheduledEventUtilities.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : Long.valueOf(this.$guildEventId), (24 & 16) != 0 ? null : null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80041 extends AbstractC12240o implements Function1<BaseSticker, Unit> {
        public final /* synthetic */ com.discord.models.message.Message $message;
        public final /* synthetic */ BaseSticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80041(BaseSticker baseSticker, com.discord.models.message.Message message) {
            super(1);
            this.$sticker = baseSticker;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BaseSticker baseSticker) {
            invoke2(baseSticker);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BaseSticker baseSticker) {
            if (baseSticker == null) {
                baseSticker = this.$sticker;
            }
            if (baseSticker instanceof StickerPartial) {
                return;
            }
            Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
            Sticker sticker = (Sticker) baseSticker;
            int iOrdinal = sticker.getType().ordinal();
            if (iOrdinal == 1) {
                WidgetStickerSheet.INSTANCE.show(WidgetChatListAdapterEventsHandler.this.getFragmentManager(), sticker, this.$message.getChannelId());
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                WidgetGuildStickerSheet.INSTANCE.show(WidgetChatListAdapterEventsHandler.this.getFragmentManager(), sticker);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80052 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ BaseSticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80052(BaseSticker baseSticker) {
            super(1);
            this.$sticker = baseSticker;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetUnknownStickerSheet.Companion companion = WidgetUnknownStickerSheet.INSTANCE;
            FragmentManager fragmentManager = WidgetChatListAdapterEventsHandler.this.getFragmentManager();
            BaseSticker baseSticker = this.$sticker;
            Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.StickerPartial");
            companion.show(fragmentManager, (StickerPartial) baseSticker);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80063 extends AbstractC12240o implements Function1<Sticker, Unit> {
        public final /* synthetic */ C80041 $handleFullStickerClicked$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80063(C80041 c80041) {
            super(1);
            this.$handleFullStickerClicked$1 = c80041;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            this.$handleFullStickerClicked$1.invoke2((BaseSticker) sticker);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onUserActivityAction$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class C80071 extends AbstractC12240o implements Function1<ActivityActionConfirmation, Unit> {
        public final /* synthetic */ Application $application;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80071(Application application) {
            super(1);
            this.$application = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityActionConfirmation activityActionConfirmation) {
            invoke2(activityActionConfirmation);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ActivityActionConfirmation activityActionConfirmation) {
            C12238m.checkNotNullParameter(activityActionConfirmation, "<name for destructuring parameter 0>");
            try {
                Intent intentJoin = IntentUtils.RouteBuilders.SDK.join(this.$application.m7563a(), this.$application.getId(), activityActionConfirmation.getSecret());
                intentJoin.addFlags(268435456);
                WidgetChatListAdapterEventsHandler.this.getContext().startActivity(intentJoin);
            } catch (ActivityNotFoundException unused) {
                C0876m.m170h(WidgetChatListAdapterEventsHandler.this.getContext(), C1107b.m210b(WidgetChatListAdapterEventsHandler.this.getContext(), C5419R.string.user_activity_not_detected, new Object[]{this.$application.getName()}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 0, null, 12);
                String str = (String) C12163u.firstOrNull((List) this.$application.m7566d());
                if (str != null) {
                    UriHandler.directToPlayStore$default(WidgetChatListAdapterEventsHandler.this.getContext(), str, null, 4, null);
                }
            }
        }
    }

    public WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, UserReactionHandler userReactionHandler, StoreChannels storeChannels, AnalyticsUtils.Tracker tracker) {
        C12238m.checkNotNullParameter(appFragment, "host");
        C12238m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        C12238m.checkNotNullParameter(storeChat, "storeChat");
        C12238m.checkNotNullParameter(storeMessages, "storeMessages");
        C12238m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
        C12238m.checkNotNullParameter(messageManager, "messageManager");
        C12238m.checkNotNullParameter(channelSelector, "channelSelector");
        C12238m.checkNotNullParameter(userReactionHandler, "userReactionHandler");
        C12238m.checkNotNullParameter(storeChannels, "channelStore");
        C12238m.checkNotNullParameter(tracker, "analyticsTracker");
        this.host = appFragment;
        this.flexInputViewModel = appFlexInputViewModel;
        this.storeChat = storeChat;
        this.storeMessages = storeMessages;
        this.storePendingReplies = storePendingReplies;
        this.storeUser = storeUser;
        this.storeEmoji = storeEmoji;
        this.messageManager = messageManager;
        this.channelSelector = channelSelector;
        this.userReactionHandler = userReactionHandler;
        this.channelStore = storeChannels;
        this.analyticsTracker = tracker;
    }

    private final Context getContext() {
        return this.host.requireContext();
    }

    private final FragmentManager getFragmentManager() {
        FragmentManager parentFragmentManager = this.host.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "host.parentFragmentManager");
        return parentFragmentManager;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
        C12238m.checkNotNullParameter(componentSendData, "componentSendData");
        StoreStream.INSTANCE.getInteractions().sendComponentInteraction(applicationId, guildId, channelId, messageId, componentIndex, componentSendData, messageFlags);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
        C12238m.checkNotNullParameter(callStatus, "callStatus");
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0) {
            C1460d.m473S1(this.host, null, new C79971(voiceChannelId), 1, null);
        } else if (iOrdinal != 1) {
            WidgetStartCallSheet.INSTANCE.show(voiceChannelId, getFragmentManager());
        } else {
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, getContext(), voiceChannelId, false, null, null, 28, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        WidgetApplicationCommandBottomSheet.Companion companion = WidgetApplicationCommandBottomSheet.INSTANCE;
        FragmentManager childFragmentManager = this.host.getChildFragmentManager();
        C12238m.checkNotNullExpressionValue(childFragmentManager, "host.childFragmentManager");
        companion.show(childFragmentManager, interactionId, messageId, channelId, guildId, interactionUserId, applicationId, messageNonce);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onDismissClicked(com.discord.models.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        this.storeMessages.deleteMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onDismissLocalMessageClicked(com.discord.models.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        String nonce = message.getNonce();
        if (nonce != null) {
            this.storeMessages.deleteLocalMessage(message.getChannelId(), nonce);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
        C12238m.checkNotNullParameter(interactionState, "interactionState");
        this.storeChat.setInteractionState(interactionState);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onListClicked() {
        AppFragment.hideKeyboard$default(this.host, null, 1, null);
        this.flexInputViewModel.hideExpressionTray();
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorAvatarClicked(com.discord.models.message.Message message, long guildId) {
        C12238m.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message) || message.isCrosspost()) {
            onMessageAuthorNameClicked(message, guildId);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorLongClicked(com.discord.models.message.Message message, Long guildId) {
        C12238m.checkNotNullParameter(message, "message");
        if (message.isWebhook()) {
            C0876m.m169g(getContext(), C5419R.string.user_profile_failure_to_open_message, 0, null, 8);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), guildId, null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorNameClicked(com.discord.models.message.Message message, long guildId) {
        C12238m.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message)) {
            WidgetPublicAnnouncementProfileSheet.INSTANCE.show(getFragmentManager());
            return;
        }
        if (!message.isCrosspost() || message.getMessageReference() == null) {
            StoreChat storeChat = this.storeChat;
            User author = message.getAuthor();
            C12238m.checkNotNull(author);
            storeChat.appendMention(new CoreUser(author), guildId);
            return;
        }
        MessageReference messageReference = message.getMessageReference();
        Long channelId = messageReference != null ? messageReference.getChannelId() : null;
        MessageReference messageReference2 = message.getMessageReference();
        Long guildId2 = messageReference2 != null ? messageReference2.getGuildId() : null;
        if (guildId2 == null || channelId == null) {
            return;
        }
        WidgetGuildProfileSheet.INSTANCE.show(getFragmentManager(), false, guildId2.longValue(), (8 & 8) != 0 ? 0L : channelId.longValue(), (8 & 16) != 0 ? false : false);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageBlockedGroupClicked(com.discord.models.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        this.storeChat.toggleBlockedMessageGroup(message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageClicked(com.discord.models.message.Message message, boolean isThreadStarterMessage) {
        C12238m.checkNotNullParameter(message, "message");
        if (isThreadStarterMessage) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageLongClicked(com.discord.models.message.Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(formattedMessage, "formattedMessage");
        if (isThreadStarterMessage) {
            return;
        }
        WidgetChatListActions.INSTANCE.showForChat(getFragmentManager(), message.getChannelId(), message.getId(), formattedMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onOldestMessageId(long channelId, long oldestMessageId) {
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onOpenPinsClicked(com.discord.models.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        WidgetChannelPinnedMessages.INSTANCE.show(getContext(), message.getChannelId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, new C79981(channelId, messageId));
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public boolean onQuickDownloadClicked(Uri uri, String fileName) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(fileName, "fileName");
        this.host.requestMediaDownload(new C79991(uri, fileName, new WeakReference(getContext())));
        return true;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
        C12238m.checkNotNullParameter(reaction, "reaction");
        if (canAddReactions) {
            MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, new C80001(myUserId, channelId, messageId, reaction));
        } else {
            C0876m.m169g(getContext(), C5419R.string.archived_thread_reactions_disabled_toast, 0, null, 8);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
        C12238m.checkNotNullParameter(reaction, "reaction");
        MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, new C80011(channelId, messageId, reaction));
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReportIssueWithAutoMod(Context context, com.discord.models.message.Message message) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(message, "message");
        WidgetReportIssueWithAutoMod.INSTANCE.launch(context, message.getChannelId(), message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onRoleSubscriptionPurchaseTierClick(long roleSubscriptionListingId, long guildId, long userId, long channelId, long messageId) {
        WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(getContext(), guildId, "Role Subscriptions Tab");
        AnalyticsUtils.Tracker tracker = this.analyticsTracker;
        TrackRoleSubscriptionPurchaseSystemMessageClicked trackRoleSubscriptionPurchaseSystemMessageClicked = new TrackRoleSubscriptionPurchaseSystemMessageClicked(Long.valueOf(messageId), Long.valueOf(roleSubscriptionListingId));
        trackRoleSubscriptionPurchaseSystemMessageClicked.m7513f(new TrackChannel(Long.valueOf(channelId), null, null, null, null, null, 62));
        trackRoleSubscriptionPurchaseSystemMessageClicked.mo7508c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        trackRoleSubscriptionPurchaseSystemMessageClicked.m7512e(new TrackBase(null, null, null, null, null, Long.valueOf(userId), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33, -1, 2047));
        tracker.track(trackRoleSubscriptionPurchaseSystemMessageClicked);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onSendGreetMessageClicked(long channelId, int channelType, Sticker sticker) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        AnalyticsTracker.INSTANCE.getTracker().track("dm_empty_action", C12136h0.mutableMapOf(C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId)), C12116o.m10073to("channel_type", Integer.valueOf(channelType)), C12116o.m10073to("source", "Wave"), C12116o.m10073to("type", "Send wave")));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().sendGreetMessage(channelId, new RestAPIParams.GreetMessage(C12145m.listOf(Long.valueOf(sticker.getId())))), false, 1, null), this.host, null, 2, null), (Class<?>) this.host.getClass(), (58 & 2) != 0 ? null : this.host.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C80021.INSTANCE);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment) {
        Channel channel;
        C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        C12238m.checkNotNullParameter(weakContext, "weakContext");
        C12238m.checkNotNullParameter(weakFragment, "weakFragment");
        long guildId = guildScheduledEvent.getGuildId();
        long id2 = guildScheduledEvent.getId();
        Long channelId = guildScheduledEvent.getChannelId();
        boolean zCanShareEvent = GuildScheduledEventUtilities.INSTANCE.canShareEvent(channelId, guildId, (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : null, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null);
        if (channelId != null) {
            channel = this.channelStore.getChannel(channelId.longValue());
        } else {
            channel = null;
        }
        if (zCanShareEvent) {
            Observable<Channel> observableM11119z = StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId).m11119z();
            C12238m.checkNotNullExpressionValue(observableM11119z, "StoreStream.getChannels(…ildId)\n          .first()");
            ObservableExtensionsKt.appSubscribe(observableM11119z, (Class<?>) WidgetChatListAdapterEventsHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80031(weakFragment, channel, id2));
        } else {
            Context context = weakContext.get();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, id2);
                C12238m.checkNotNullExpressionValue(context, "context");
                C0876m.m165c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onStickerClicked(com.discord.models.message.Message message, BaseSticker sticker) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(sticker, "sticker");
        C80041 c80041 = new C80041(sticker, message);
        this.flexInputViewModel.hideKeyboard();
        if (sticker instanceof Sticker) {
            c80041.invoke2(sticker);
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StickerUtils.INSTANCE.getGuildOrStandardSticker(sticker.getId(), true), this.host, null, 2, null), (Class<?>) WidgetChatListAdapterEventsHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C80052(sticker)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80063(c80041));
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onSystemMessageCtaClicked(com.discord.models.message.Message message, Channel channel, BaseSticker sticker) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(sticker, "sticker");
        this.storePendingReplies.onCreatePendingReply(channel, message, true, true);
        MessageManager messageManager = this.messageManager;
        messageManager.sendMessage((510 & 1) != 0 ? "" : null, (510 & 2) != 0 ? null : null, (510 & 4) != 0 ? null : null, (510 & 8) != 0 ? null : null, (510 & 16) != 0 ? C12147n.emptyList() : C12145m.listOf(sticker), (510 & 32) != 0, (510 & 64) != 0 ? null : null, (510 & 128) == 0 ? null : null, (510 & 256) != 0 ? messageManager.defaultMessageResultHandler : null);
        Integer type = message.getType();
        if (type != null && type.intValue() == 7) {
            AnalyticsUtils.Tracker tracker = this.analyticsTracker;
            Boolean bool = Boolean.TRUE;
            String strValueOf = String.valueOf(sticker.getId());
            User author = message.getAuthor();
            tracker.track(new TrackWelcomeCtaClicked(bool, strValueOf, author != null ? Long.valueOf(author.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId())));
            return;
        }
        if (type != null && type.intValue() == 25) {
            AnalyticsUtils.Tracker tracker2 = this.analyticsTracker;
            String strValueOf2 = String.valueOf(sticker.getId());
            User author2 = message.getAuthor();
            TrackRoleSubscriptionPurchaseSystemMessageCtaClicked trackRoleSubscriptionPurchaseSystemMessageCtaClicked = new TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long.valueOf(message.getId()), strValueOf2, author2 != null ? Long.valueOf(author2.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId()));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.mo7508c(new TrackGuild(Long.valueOf(channel.getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.m7514e(new TrackChannel(Long.valueOf(channel.getId()), null, null, null, null, null, 62));
            tracker2.track(trackRoleSubscriptionPurchaseSystemMessageCtaClicked);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onThreadClicked(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        this.channelSelector.selectChannel(channel, Long.valueOf(channel.getParentId()), SelectedChannelAnalyticsLocation.EMBED);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onThreadLongClicked(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        WidgetChannelsListItemThreadActions.INSTANCE.show(getFragmentManager(), channel.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUrlLongClicked(String url) {
        C12238m.checkNotNullParameter(url, "url");
        WidgetUrlActions.INSTANCE.launch(getFragmentManager(), url);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
        C12238m.checkNotNullParameter(actionType, "actionType");
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(application, "application");
        Long applicationId = activity.getApplicationId();
        String sessionId = activity.getSessionId();
        if (applicationId == null || sessionId == null || actionType != MessageActivityType.JOIN) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userActivityActionJoin(authorId, applicationId.longValue(), sessionId, Long.valueOf(channelId), Long.valueOf(messageId)), false, 1, null), this.host, null, 2, null), (Class<?>) WidgetChatListAdapterEventsHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80071(application));
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUserMentionClicked(long userId, long channelId, long guildId) {
        WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, userId, Long.valueOf(channelId), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, UserReactionHandler userReactionHandler, StoreChannels storeChannels, AnalyticsUtils.Tracker tracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChat chat = (i & 4) != 0 ? StoreStream.INSTANCE.getChat() : storeChat;
        StoreMessages messages = (i & 8) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        StorePendingReplies pendingReplies = (i & 16) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreEmoji emojis = (i & 64) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        this(appFragment, appFlexInputViewModel, chat, messages, pendingReplies, users, emojis, (i & 128) != 0 ? new MessageManager(appFragment.requireContext(), null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 256) != 0 ? ChannelSelector.INSTANCE.getInstance() : channelSelector, (i & 512) != 0 ? new UserReactionHandler(appFragment, messages, emojis) : userReactionHandler, (i & 1024) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2048) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : tracker);
    }
}
