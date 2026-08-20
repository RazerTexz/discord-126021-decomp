package com.discord.widgets.chat.input;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.message.MessageReference;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuildJoinRequest;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtilsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandDataKt;
import com.discord.widgets.forums.ForumPostCreateManager;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final boolean isEmojiAutocompleteUpsellEnabled;
    private final StoreAnalytics storeAnalytics;
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreApplicationCommandFrecency storeApplicationCommandsFrecency;
    private final StoreApplicationInteractions storeApplicationInteractions;
    private final StoreChannels storeChannels;
    private final StoreChat storeChat;
    private final StoreGuilds storeGuilds;
    private final StoreLurking storeLurking;
    private final StoreMessagesLoader storeMessagesLoader;
    private final StorePendingReplies storePendingReplies;
    private final StoreStickers storeStickers;
    private final StoreThreadDraft storeThreadDraft;
    private final StoreUserSettings storeUserSettings;
    private boolean useTimeoutUpdateInterval;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$1 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final /* synthetic */ class C76831 extends C12236k implements Function1<StoreState, Unit> {
        public C76831(ChatInputViewModel chatInputViewModel) {
            super(1, chatInputViewModel, ChatInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((ChatInputViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$2 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final /* synthetic */ class C76842 extends C12236k implements Function1<StoreChat.Event, Unit> {
        public C76842(ChatInputViewModel chatInputViewModel) {
            super(1, chatInputViewModel, ChatInputViewModel.class, "handleStoreChatEvent", "handleStoreChatEvent(Lcom/discord/stores/StoreChat$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((ChatInputViewModel) this.receiver).handleStoreChatEvent(event);
        }
    }

    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final /* data */ class AttachmentContext {
        private final List<Float> attachmentSizes;
        private final ArrayList<Attachment<?>> attachments;
        private final float currentFileSizeMB;
        private final boolean hasGif;
        private final boolean hasImage;
        private final boolean hasVideo;
        private final float maxAttachmentSizeMB;

        public AttachmentContext(ArrayList<Attachment<?>> arrayList, boolean z2, boolean z3, boolean z4, List<Float> list, float f, float f2) {
            C12238m.checkNotNullParameter(arrayList, "attachments");
            C12238m.checkNotNullParameter(list, "attachmentSizes");
            this.attachments = arrayList;
            this.hasImage = z2;
            this.hasVideo = z3;
            this.hasGif = z4;
            this.attachmentSizes = list;
            this.currentFileSizeMB = f;
            this.maxAttachmentSizeMB = f2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AttachmentContext copy$default(AttachmentContext attachmentContext, ArrayList arrayList, boolean z2, boolean z3, boolean z4, List list, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = attachmentContext.attachments;
            }
            if ((i & 2) != 0) {
                z2 = attachmentContext.hasImage;
            }
            boolean z5 = z2;
            if ((i & 4) != 0) {
                z3 = attachmentContext.hasVideo;
            }
            boolean z6 = z3;
            if ((i & 8) != 0) {
                z4 = attachmentContext.hasGif;
            }
            boolean z7 = z4;
            if ((i & 16) != 0) {
                list = attachmentContext.attachmentSizes;
            }
            List list2 = list;
            if ((i & 32) != 0) {
                f = attachmentContext.currentFileSizeMB;
            }
            float f3 = f;
            if ((i & 64) != 0) {
                f2 = attachmentContext.maxAttachmentSizeMB;
            }
            return attachmentContext.copy(arrayList, z5, z6, z7, list2, f3, f2);
        }

        public final ArrayList<Attachment<?>> component1() {
            return this.attachments;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasImage() {
            return this.hasImage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHasVideo() {
            return this.hasVideo;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getHasGif() {
            return this.hasGif;
        }

        public final List<Float> component5() {
            return this.attachmentSizes;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final float getCurrentFileSizeMB() {
            return this.currentFileSizeMB;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final float getMaxAttachmentSizeMB() {
            return this.maxAttachmentSizeMB;
        }

        public final AttachmentContext copy(ArrayList<Attachment<?>> attachments, boolean hasImage, boolean hasVideo, boolean hasGif, List<Float> attachmentSizes, float currentFileSizeMB, float maxAttachmentSizeMB) {
            C12238m.checkNotNullParameter(attachments, "attachments");
            C12238m.checkNotNullParameter(attachmentSizes, "attachmentSizes");
            return new AttachmentContext(attachments, hasImage, hasVideo, hasGif, attachmentSizes, currentFileSizeMB, maxAttachmentSizeMB);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AttachmentContext)) {
                return false;
            }
            AttachmentContext attachmentContext = (AttachmentContext) other;
            return C12238m.areEqual(this.attachments, attachmentContext.attachments) && this.hasImage == attachmentContext.hasImage && this.hasVideo == attachmentContext.hasVideo && this.hasGif == attachmentContext.hasGif && C12238m.areEqual(this.attachmentSizes, attachmentContext.attachmentSizes) && Float.compare(this.currentFileSizeMB, attachmentContext.currentFileSizeMB) == 0 && Float.compare(this.maxAttachmentSizeMB, attachmentContext.maxAttachmentSizeMB) == 0;
        }

        public final List<Float> getAttachmentSizes() {
            return this.attachmentSizes;
        }

        public final ArrayList<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final float getCurrentFileSizeMB() {
            return this.currentFileSizeMB;
        }

        public final boolean getHasGif() {
            return this.hasGif;
        }

        public final boolean getHasImage() {
            return this.hasImage;
        }

        public final boolean getHasVideo() {
            return this.hasVideo;
        }

        public final float getMaxAttachmentSizeMB() {
            return this.maxAttachmentSizeMB;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            ArrayList<Attachment<?>> arrayList = this.attachments;
            int iHashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
            boolean z2 = this.hasImage;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            boolean z3 = this.hasVideo;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            boolean z4 = this.hasGif;
            int i3 = (i2 + (z4 ? 1 : z4)) * 31;
            List<Float> list = this.attachmentSizes;
            return Float.floatToIntBits(this.maxAttachmentSizeMB) + ((Float.floatToIntBits(this.currentFileSizeMB) + ((i3 + (list != null ? list.hashCode() : 0)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("AttachmentContext(attachments=");
            sbM833U.append(this.attachments);
            sbM833U.append(", hasImage=");
            sbM833U.append(this.hasImage);
            sbM833U.append(", hasVideo=");
            sbM833U.append(this.hasVideo);
            sbM833U.append(", hasGif=");
            sbM833U.append(this.hasGif);
            sbM833U.append(", attachmentSizes=");
            sbM833U.append(this.attachmentSizes);
            sbM833U.append(", currentFileSizeMB=");
            sbM833U.append(this.currentFileSizeMB);
            sbM833U.append(", maxAttachmentSizeMB=");
            sbM833U.append(this.maxAttachmentSizeMB);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<Boolean> getIsOnCooldownObservable(long channelId, StoreSlowMode storeSlowMode) {
            return storeSlowMode.observeCooldownSecs(Long.valueOf(channelId), StoreSlowMode.Type.MessageSend.INSTANCE).m11083G(new InterfaceC12589b<Integer, Boolean>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel$Companion$getIsOnCooldownObservable$1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Boolean call(Integer num) {
                    return call(num.intValue());
                }

                public final Boolean call(int i) {
                    return Boolean.valueOf(i > 0);
                }
            }).m11112r();
        }

        private final Observable<StoreState.Loaded.PendingReply> getPendingReplyStateObservable(long channelId, StorePendingReplies storePendingReplies) {
            Observable<StoreState.Loaded.PendingReply> observableM11112r = storePendingReplies.observePendingReply(channelId).m11099Y(new InterfaceC12589b<StorePendingReplies.PendingReply, Observable<? extends StoreState.Loaded.PendingReply>>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel$Companion$getPendingReplyStateObservable$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends ChatInputViewModel.StoreState.Loaded.PendingReply> call(final StorePendingReplies.PendingReply pendingReply) {
                    Observable<R> c12721k;
                    if (pendingReply == null) {
                        return new C12721k(null);
                    }
                    if (pendingReply.getOriginalMessage().isWebhook()) {
                        User author = pendingReply.getOriginalMessage().getAuthor();
                        C12238m.checkNotNull(author);
                        return new C12721k(new ChatInputViewModel.StoreState.Loaded.PendingReply(pendingReply, new CoreUser(author), null));
                    }
                    User author2 = pendingReply.getOriginalMessage().getAuthor();
                    C12238m.checkNotNull(author2);
                    final long id2 = author2.getId();
                    Long guildId = pendingReply.getMessageReference().getGuildId();
                    if (guildId != null) {
                        c12721k = StoreStream.INSTANCE.getGuilds().observeComputed(guildId.longValue()).m11083G(new InterfaceC12589b<Map<Long, ? extends GuildMember>, GuildMember>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
                                return call2((Map<Long, GuildMember>) map);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final GuildMember call2(Map<Long, GuildMember> map) {
                                return map.get(Long.valueOf(id2));
                            }
                        }).m11112r();
                    } else {
                        c12721k = new C12721k(null);
                    }
                    return Observable.m11076j(StoreStream.INSTANCE.getUsers().observeUser(id2), c12721k, new Func2<com.discord.models.user.User, GuildMember, ChatInputViewModel.StoreState.Loaded.PendingReply>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel$Companion$getPendingReplyStateObservable$1.1
                        @Override // p658rx.functions.Func2
                        public final ChatInputViewModel.StoreState.Loaded.PendingReply call(com.discord.models.user.User user, GuildMember guildMember) {
                            return new ChatInputViewModel.StoreState.Loaded.PendingReply(pendingReply, user, guildMember);
                        }
                    });
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "storePendingReplies\n    …  .distinctUntilChanged()");
            return observableM11112r;
        }

        private final Observable<GuildVerificationLevel> getVerificationLevelTriggeredObservable(long guildId, StoreGuilds storeGuilds, StoreUser storeUsers) {
            return GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, guildId, storeGuilds, storeUsers, null, 8, null);
        }

        private final Observable<StoreState> observeStoreState(StoreChannelsSelected storeChannelsSelected, final StoreUser storeUsers, final StoreChat storeChat, final StoreUserRelationships storeUserRelationships, final StorePermissions storePermissions, final StoreLurking storeLurking, final StoreSlowMode storeSlowMode, final StoreGuilds storeGuilds, final StorePendingReplies storePendingReplies, final StoreGuildJoinRequest storeGuildJoinRequest, final StoreThreadDraft storeThreadDraft) {
            Observable observableM11099Y = storeChannelsSelected.observeResolvedSelectedChannel().m11099Y(new InterfaceC12589b<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel$Companion$observeStoreState$1

                /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$Companion$observeStoreState$1$1 */
                /* JADX INFO: compiled from: ChatInputViewModel.kt */
                public static final class C76871 extends AbstractC12240o implements Function13<MeUser, StoreChat.EditingMessage, Integer, Long, GuildVerificationLevel, Boolean, Boolean, Guild, ChatInputViewModel.StoreState.Loaded.PendingReply, GuildMember, GuildJoinRequest, StoreThreadDraft.ThreadDraftState, Boolean, ChatInputViewModel.StoreState.Loaded> {
                    public final /* synthetic */ Channel $channel;
                    public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C76871(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                        super(13);
                        this.$channel = channel;
                        this.$selectedChannel = resolvedSelectedChannel;
                    }

                    @Override // kotlin.jvm.functions.Function13
                    public /* bridge */ /* synthetic */ ChatInputViewModel.StoreState.Loaded invoke(MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, Boolean bool, Boolean bool2, Guild guild, ChatInputViewModel.StoreState.Loaded.PendingReply pendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, Boolean bool3) {
                        return invoke(meUser, editingMessage, num, l, guildVerificationLevel, bool.booleanValue(), bool2, guild, pendingReply, guildMember, guildJoinRequest, threadDraftState, bool3.booleanValue());
                    }

                    public final ChatInputViewModel.StoreState.Loaded invoke(MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, Boolean bool, Guild guild, ChatInputViewModel.StoreState.Loaded.PendingReply pendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z3) {
                        C12238m.checkNotNullParameter(meUser, "me");
                        C12238m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
                        C12238m.checkNotNullParameter(threadDraftState, "threadDraftState");
                        Channel channel = this.$channel;
                        C12238m.checkNotNullExpressionValue(bool, "isOnCooldown");
                        boolean zBooleanValue = bool.booleanValue();
                        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.$selectedChannel;
                        if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                            resolvedSelectedChannel = null;
                        }
                        return new ChatInputViewModel.StoreState.Loaded(channel, meUser, editingMessage, num, l, guildVerificationLevel, z2, zBooleanValue, guild, pendingReply, (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel, guildMember, guildJoinRequest, threadDraftState, z3);
                    }
                }

                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends ChatInputViewModel.StoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
                    if (channelOrParent == null) {
                        return new C12721k(ChatInputViewModel.StoreState.Loading.INSTANCE);
                    }
                    Observable<MeUser> observableObserveMe = storeUsers.observeMe(true);
                    Observable observableComputationBuffered = ObservableExtensionsKt.computationBuffered(storeChat.observeEditingMessage());
                    StoreUserRelationships storeUserRelationships2 = storeUserRelationships;
                    com.discord.models.user.User userM7677a = ChannelUtils.m7677a(channelOrParent);
                    Observable<Integer> observableObserve = storeUserRelationships2.observe(userM7677a != null ? userM7677a.getId() : 0L);
                    Observable<Long> observableObservePermissionsForChannel = storePermissions.observePermissionsForChannel(channelOrParent.getId());
                    ChatInputViewModel.Companion companion = ChatInputViewModel.INSTANCE;
                    Observable verificationLevelTriggeredObservable = companion.getVerificationLevelTriggeredObservable(channelOrParent.getGuildId(), storeGuilds, storeUsers);
                    Observable<Boolean> observableIsLurkingObs = storeLurking.isLurkingObs(channelOrParent.getGuildId());
                    Observable isOnCooldownObservable = companion.getIsOnCooldownObservable(channelOrParent.getId(), storeSlowMode);
                    C12238m.checkNotNullExpressionValue(isOnCooldownObservable, "getIsOnCooldownObservabl…hannel.id, storeSlowMode)");
                    return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMe, observableComputationBuffered, observableObserve, observableObservePermissionsForChannel, verificationLevelTriggeredObservable, observableIsLurkingObs, isOnCooldownObservable, storeGuilds.observeFromChannelId(channelOrParent.getId()), companion.getPendingReplyStateObservable(channelOrParent.getId(), storePendingReplies), storeGuilds.observeComputedMember(channelOrParent.getGuildId(), storeUsers.getMeSnapshot().getId()), storeGuildJoinRequest.observeGuildJoinRequest(channelOrParent.getGuildId()), storeThreadDraft.observeDraftState(), ForumPostCreateManager.INSTANCE.observeIsForumPostCreateInProgress(channelOrParent.getGuildId()), new C76871(channelOrParent, resolvedSelectedChannel));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeChannelsSelected.ob…      }\n        }\n      }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final /* data */ class AppendChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AppendChatText(String str) {
                super(null);
                C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ AppendChatText copy$default(AppendChatText appendChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = appendChatText.text;
                }
                return appendChatText.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final AppendChatText copy(String text) {
                C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new AppendChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AppendChatText) && C12238m.areEqual(this.text, ((AppendChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m822J(C1643a.m833U("AppendChatText(text="), this.text, ")");
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final class CommandInputsInvalid extends Event {
            public static final CommandInputsInvalid INSTANCE = new CommandInputsInvalid();

            private CommandInputsInvalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final class EmptyThreadName extends Event {
            public static final EmptyThreadName INSTANCE = new EmptyThreadName();

            private EmptyThreadName() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final class FailedDeliveryToRecipient extends Event {
            public static final FailedDeliveryToRecipient INSTANCE = new FailedDeliveryToRecipient();

            private FailedDeliveryToRecipient() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final /* data */ class FilesTooLarge extends Event {
            private final List<Attachment<?>> attachments;
            private final float currentFileSizeMB;
            private final boolean hasGif;
            private final boolean hasImage;
            private final boolean hasVideo;
            private final boolean isUserPremium;
            private final float maxAttachmentSizeMB;
            private final int maxFileSizeMB;
            private final Function0<Unit> onResendCompressed;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public FilesTooLarge(int i, float f, float f2, boolean z2, List<? extends Attachment<?>> list, boolean z3, boolean z4, boolean z5, Function0<Unit> function0) {
                super(null);
                C12238m.checkNotNullParameter(list, "attachments");
                this.maxFileSizeMB = i;
                this.currentFileSizeMB = f;
                this.maxAttachmentSizeMB = f2;
                this.isUserPremium = z2;
                this.attachments = list;
                this.hasImage = z3;
                this.hasVideo = z4;
                this.hasGif = z5;
                this.onResendCompressed = function0;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final float getCurrentFileSizeMB() {
                return this.currentFileSizeMB;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final float getMaxAttachmentSizeMB() {
                return this.maxAttachmentSizeMB;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            public final List<Attachment<?>> component5() {
                return this.attachments;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getHasImage() {
                return this.hasImage;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getHasGif() {
                return this.hasGif;
            }

            public final Function0<Unit> component9() {
                return this.onResendCompressed;
            }

            public final FilesTooLarge copy(int maxFileSizeMB, float currentFileSizeMB, float maxAttachmentSizeMB, boolean isUserPremium, List<? extends Attachment<?>> attachments, boolean hasImage, boolean hasVideo, boolean hasGif, Function0<Unit> onResendCompressed) {
                C12238m.checkNotNullParameter(attachments, "attachments");
                return new FilesTooLarge(maxFileSizeMB, currentFileSizeMB, maxAttachmentSizeMB, isUserPremium, attachments, hasImage, hasVideo, hasGif, onResendCompressed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FilesTooLarge)) {
                    return false;
                }
                FilesTooLarge filesTooLarge = (FilesTooLarge) other;
                return this.maxFileSizeMB == filesTooLarge.maxFileSizeMB && Float.compare(this.currentFileSizeMB, filesTooLarge.currentFileSizeMB) == 0 && Float.compare(this.maxAttachmentSizeMB, filesTooLarge.maxAttachmentSizeMB) == 0 && this.isUserPremium == filesTooLarge.isUserPremium && C12238m.areEqual(this.attachments, filesTooLarge.attachments) && this.hasImage == filesTooLarge.hasImage && this.hasVideo == filesTooLarge.hasVideo && this.hasGif == filesTooLarge.hasGif && C12238m.areEqual(this.onResendCompressed, filesTooLarge.onResendCompressed);
            }

            public final List<Attachment<?>> getAttachments() {
                return this.attachments;
            }

            public final float getCurrentFileSizeMB() {
                return this.currentFileSizeMB;
            }

            public final boolean getHasGif() {
                return this.hasGif;
            }

            public final boolean getHasImage() {
                return this.hasImage;
            }

            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            public final float getMaxAttachmentSizeMB() {
                return this.maxAttachmentSizeMB;
            }

            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            public final Function0<Unit> getOnResendCompressed() {
                return this.onResendCompressed;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10, types: [int] */
            /* JADX WARN: Type inference failed for: r1v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v15 */
            /* JADX WARN: Type inference failed for: r1v16 */
            /* JADX WARN: Type inference failed for: r1v18 */
            /* JADX WARN: Type inference failed for: r1v19 */
            /* JADX WARN: Type inference failed for: r1v20 */
            /* JADX WARN: Type inference failed for: r1v21 */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int iFloatToIntBits = (Float.floatToIntBits(this.maxAttachmentSizeMB) + ((Float.floatToIntBits(this.currentFileSizeMB) + (this.maxFileSizeMB * 31)) * 31)) * 31;
                boolean z2 = this.isUserPremium;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iFloatToIntBits + r1) * 31;
                List<Attachment<?>> list = this.attachments;
                int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
                boolean z3 = this.hasImage;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (iHashCode + r2) * 31;
                boolean z4 = this.hasVideo;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.hasGif;
                int i4 = (i3 + (z5 ? 1 : z5)) * 31;
                Function0<Unit> function0 = this.onResendCompressed;
                return i4 + (function0 != null ? function0.hashCode() : 0);
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("FilesTooLarge(maxFileSizeMB=");
                sbM833U.append(this.maxFileSizeMB);
                sbM833U.append(", currentFileSizeMB=");
                sbM833U.append(this.currentFileSizeMB);
                sbM833U.append(", maxAttachmentSizeMB=");
                sbM833U.append(this.maxAttachmentSizeMB);
                sbM833U.append(", isUserPremium=");
                sbM833U.append(this.isUserPremium);
                sbM833U.append(", attachments=");
                sbM833U.append(this.attachments);
                sbM833U.append(", hasImage=");
                sbM833U.append(this.hasImage);
                sbM833U.append(", hasVideo=");
                sbM833U.append(this.hasVideo);
                sbM833U.append(", hasGif=");
                sbM833U.append(this.hasGif);
                sbM833U.append(", onResendCompressed=");
                sbM833U.append(this.onResendCompressed);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final /* data */ class MessageTooLong extends Event {
            private final int currentCharacterCount;
            private final int maxCharacterCount;

            public MessageTooLong(int i, int i2) {
                super(null);
                this.currentCharacterCount = i;
                this.maxCharacterCount = i2;
            }

            public static /* synthetic */ MessageTooLong copy$default(MessageTooLong messageTooLong, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = messageTooLong.currentCharacterCount;
                }
                if ((i3 & 2) != 0) {
                    i2 = messageTooLong.maxCharacterCount;
                }
                return messageTooLong.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCurrentCharacterCount() {
                return this.currentCharacterCount;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getMaxCharacterCount() {
                return this.maxCharacterCount;
            }

            public final MessageTooLong copy(int currentCharacterCount, int maxCharacterCount) {
                return new MessageTooLong(currentCharacterCount, maxCharacterCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MessageTooLong)) {
                    return false;
                }
                MessageTooLong messageTooLong = (MessageTooLong) other;
                return this.currentCharacterCount == messageTooLong.currentCharacterCount && this.maxCharacterCount == messageTooLong.maxCharacterCount;
            }

            public final int getCurrentCharacterCount() {
                return this.currentCharacterCount;
            }

            public final int getMaxCharacterCount() {
                return this.maxCharacterCount;
            }

            public int hashCode() {
                return (this.currentCharacterCount * 31) + this.maxCharacterCount;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("MessageTooLong(currentCharacterCount=");
                sbM833U.append(this.currentCharacterCount);
                sbM833U.append(", maxCharacterCount=");
                return C1643a.m814B(sbM833U, this.maxCharacterCount, ")");
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final /* data */ class SetChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetChatText(String str) {
                super(null);
                C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ SetChatText copy$default(SetChatText setChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setChatText.text;
                }
                return setChatText.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final SetChatText copy(String text) {
                C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new SetChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetChatText) && C12238m.areEqual(this.text, ((SetChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m822J(C1643a.m833U("SetChatText(text="), this.text, ")");
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final /* data */ class ShowPremiumUpsell extends Event {
            private final int bodyResId;
            private final int headerResId;
            private final int page;
            private final boolean showLearnMore;
            private final boolean showOtherPages;

            public /* synthetic */ ShowPremiumUpsell(int i, int i2, int i3, boolean z2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, i3, (i4 & 8) != 0 ? false : z2, (i4 & 16) != 0 ? false : z3);
            }

            public static /* synthetic */ ShowPremiumUpsell copy$default(ShowPremiumUpsell showPremiumUpsell, int i, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = showPremiumUpsell.page;
                }
                if ((i4 & 2) != 0) {
                    i2 = showPremiumUpsell.headerResId;
                }
                int i5 = i2;
                if ((i4 & 4) != 0) {
                    i3 = showPremiumUpsell.bodyResId;
                }
                int i6 = i3;
                if ((i4 & 8) != 0) {
                    z2 = showPremiumUpsell.showOtherPages;
                }
                boolean z4 = z2;
                if ((i4 & 16) != 0) {
                    z3 = showPremiumUpsell.showLearnMore;
                }
                return showPremiumUpsell.copy(i, i5, i6, z4, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getPage() {
                return this.page;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getHeaderResId() {
                return this.headerResId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getBodyResId() {
                return this.bodyResId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getShowOtherPages() {
                return this.showOtherPages;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getShowLearnMore() {
                return this.showLearnMore;
            }

            public final ShowPremiumUpsell copy(int page, @StringRes int headerResId, @StringRes int bodyResId, boolean showOtherPages, boolean showLearnMore) {
                return new ShowPremiumUpsell(page, headerResId, bodyResId, showOtherPages, showLearnMore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowPremiumUpsell)) {
                    return false;
                }
                ShowPremiumUpsell showPremiumUpsell = (ShowPremiumUpsell) other;
                return this.page == showPremiumUpsell.page && this.headerResId == showPremiumUpsell.headerResId && this.bodyResId == showPremiumUpsell.bodyResId && this.showOtherPages == showPremiumUpsell.showOtherPages && this.showLearnMore == showPremiumUpsell.showLearnMore;
            }

            public final int getBodyResId() {
                return this.bodyResId;
            }

            public final int getHeaderResId() {
                return this.headerResId;
            }

            public final int getPage() {
                return this.page;
            }

            public final boolean getShowLearnMore() {
                return this.showLearnMore;
            }

            public final boolean getShowOtherPages() {
                return this.showOtherPages;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int i = ((((this.page * 31) + this.headerResId) * 31) + this.bodyResId) * 31;
                boolean z2 = this.showOtherPages;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i2 = (i + r1) * 31;
                boolean z3 = this.showLearnMore;
                return i2 + (z3 ? 1 : z3);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ShowPremiumUpsell(page=");
                sbM833U.append(this.page);
                sbM833U.append(", headerResId=");
                sbM833U.append(this.headerResId);
                sbM833U.append(", bodyResId=");
                sbM833U.append(this.bodyResId);
                sbM833U.append(", showOtherPages=");
                sbM833U.append(this.showOtherPages);
                sbM833U.append(", showLearnMore=");
                return C1643a.m827O(sbM833U, this.showLearnMore, ")");
            }

            public ShowPremiumUpsell(int i, @StringRes int i2, @StringRes int i3, boolean z2, boolean z3) {
                super(null);
                this.page = i;
                this.headerResId = i2;
                this.bodyResId = i3;
                this.showOtherPages = z2;
                this.showLearnMore = z3;
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final class ThreadDraftClosed extends Event {
            public static final ThreadDraftClosed INSTANCE = new ThreadDraftClosed();

            private ThreadDraftClosed() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final Channel channel;
            private final Long channelPermissions;
            private final StoreChat.EditingMessage editingMessage;
            private final Guild guild;
            private final GuildJoinRequest guildJoinRequest;
            private final boolean isForumPostCreateInProgress;
            private final boolean isLurking;
            private final boolean isOnCooldown;
            private final MeUser me;
            private final GuildMember meGuildMember;
            private final PendingReply pendingReply;
            private final Integer relationshipType;
            private final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft;
            private final StoreThreadDraft.ThreadDraftState threadDraftState;
            private final GuildVerificationLevel verificationLevelTriggered;

            /* JADX INFO: compiled from: ChatInputViewModel.kt */
            public static final /* data */ class PendingReply {
                private final StorePendingReplies.PendingReply pendingReply;
                private final com.discord.models.user.User repliedAuthor;
                private final GuildMember repliedAuthorGuildMember;

                public PendingReply(StorePendingReplies.PendingReply pendingReply, com.discord.models.user.User user, GuildMember guildMember) {
                    C12238m.checkNotNullParameter(pendingReply, "pendingReply");
                    this.pendingReply = pendingReply;
                    this.repliedAuthor = user;
                    this.repliedAuthorGuildMember = guildMember;
                }

                public static /* synthetic */ PendingReply copy$default(PendingReply pendingReply, StorePendingReplies.PendingReply pendingReply2, com.discord.models.user.User user, GuildMember guildMember, int i, Object obj) {
                    if ((i & 1) != 0) {
                        pendingReply2 = pendingReply.pendingReply;
                    }
                    if ((i & 2) != 0) {
                        user = pendingReply.repliedAuthor;
                    }
                    if ((i & 4) != 0) {
                        guildMember = pendingReply.repliedAuthorGuildMember;
                    }
                    return pendingReply.copy(pendingReply2, user, guildMember);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final StorePendingReplies.PendingReply getPendingReply() {
                    return this.pendingReply;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final com.discord.models.user.User getRepliedAuthor() {
                    return this.repliedAuthor;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final GuildMember getRepliedAuthorGuildMember() {
                    return this.repliedAuthorGuildMember;
                }

                public final PendingReply copy(StorePendingReplies.PendingReply pendingReply, com.discord.models.user.User repliedAuthor, GuildMember repliedAuthorGuildMember) {
                    C12238m.checkNotNullParameter(pendingReply, "pendingReply");
                    return new PendingReply(pendingReply, repliedAuthor, repliedAuthorGuildMember);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof PendingReply)) {
                        return false;
                    }
                    PendingReply pendingReply = (PendingReply) other;
                    return C12238m.areEqual(this.pendingReply, pendingReply.pendingReply) && C12238m.areEqual(this.repliedAuthor, pendingReply.repliedAuthor) && C12238m.areEqual(this.repliedAuthorGuildMember, pendingReply.repliedAuthorGuildMember);
                }

                public final StorePendingReplies.PendingReply getPendingReply() {
                    return this.pendingReply;
                }

                public final com.discord.models.user.User getRepliedAuthor() {
                    return this.repliedAuthor;
                }

                public final GuildMember getRepliedAuthorGuildMember() {
                    return this.repliedAuthorGuildMember;
                }

                public int hashCode() {
                    StorePendingReplies.PendingReply pendingReply = this.pendingReply;
                    int iHashCode = (pendingReply != null ? pendingReply.hashCode() : 0) * 31;
                    com.discord.models.user.User user = this.repliedAuthor;
                    int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
                    GuildMember guildMember = this.repliedAuthorGuildMember;
                    return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("PendingReply(pendingReply=");
                    sbM833U.append(this.pendingReply);
                    sbM833U.append(", repliedAuthor=");
                    sbM833U.append(this.repliedAuthor);
                    sbM833U.append(", repliedAuthorGuildMember=");
                    sbM833U.append(this.repliedAuthorGuildMember);
                    sbM833U.append(")");
                    return sbM833U.toString();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, boolean z3, Guild guild, PendingReply pendingReply, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z4) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(meUser, "me");
                C12238m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
                C12238m.checkNotNullParameter(threadDraftState, "threadDraftState");
                this.channel = channel;
                this.me = meUser;
                this.editingMessage = editingMessage;
                this.relationshipType = num;
                this.channelPermissions = l;
                this.verificationLevelTriggered = guildVerificationLevel;
                this.isLurking = z2;
                this.isOnCooldown = z3;
                this.guild = guild;
                this.pendingReply = pendingReply;
                this.selectedThreadDraft = threadDraft;
                this.meGuildMember = guildMember;
                this.guildJoinRequest = guildJoinRequest;
                this.threadDraftState = threadDraftState;
                this.isForumPostCreateInProgress = z4;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final PendingReply getPendingReply() {
                return this.pendingReply;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final GuildJoinRequest getGuildJoinRequest() {
                return this.guildJoinRequest;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final boolean getIsForumPostCreateInProgress() {
                return this.isForumPostCreateInProgress;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Integer getRelationshipType() {
                return this.relationshipType;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsOnCooldown() {
                return this.isOnCooldown;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Loaded copy(Channel channel, MeUser me2, StoreChat.EditingMessage editingMessage, Integer relationshipType, Long channelPermissions, GuildVerificationLevel verificationLevelTriggered, boolean isLurking, boolean isOnCooldown, Guild guild, PendingReply pendingReply, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft, GuildMember meGuildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean isForumPostCreateInProgress) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(me2, "me");
                C12238m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
                C12238m.checkNotNullParameter(threadDraftState, "threadDraftState");
                return new Loaded(channel, me2, editingMessage, relationshipType, channelPermissions, verificationLevelTriggered, isLurking, isOnCooldown, guild, pendingReply, selectedThreadDraft, meGuildMember, guildJoinRequest, threadDraftState, isForumPostCreateInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.channel, loaded.channel) && C12238m.areEqual(this.me, loaded.me) && C12238m.areEqual(this.editingMessage, loaded.editingMessage) && C12238m.areEqual(this.relationshipType, loaded.relationshipType) && C12238m.areEqual(this.channelPermissions, loaded.channelPermissions) && C12238m.areEqual(this.verificationLevelTriggered, loaded.verificationLevelTriggered) && this.isLurking == loaded.isLurking && this.isOnCooldown == loaded.isOnCooldown && C12238m.areEqual(this.guild, loaded.guild) && C12238m.areEqual(this.pendingReply, loaded.pendingReply) && C12238m.areEqual(this.selectedThreadDraft, loaded.selectedThreadDraft) && C12238m.areEqual(this.meGuildMember, loaded.meGuildMember) && C12238m.areEqual(this.guildJoinRequest, loaded.guildJoinRequest) && C12238m.areEqual(this.threadDraftState, loaded.threadDraftState) && this.isForumPostCreateInProgress == loaded.isForumPostCreateInProgress;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final GuildJoinRequest getGuildJoinRequest() {
                return this.guildJoinRequest;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            public final PendingReply getPendingReply() {
                return this.pendingReply;
            }

            public final Integer getRelationshipType() {
                return this.relationshipType;
            }

            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r0v30, types: [int] */
            /* JADX WARN: Type inference failed for: r2v16, types: [int] */
            /* JADX WARN: Type inference failed for: r2v18, types: [int] */
            /* JADX WARN: Type inference failed for: r2v40 */
            /* JADX WARN: Type inference failed for: r2v41 */
            /* JADX WARN: Type inference failed for: r2v47 */
            /* JADX WARN: Type inference failed for: r2v48 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                MeUser meUser = this.me;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                StoreChat.EditingMessage editingMessage = this.editingMessage;
                int iHashCode3 = (iHashCode2 + (editingMessage != null ? editingMessage.hashCode() : 0)) * 31;
                Integer num = this.relationshipType;
                int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
                GuildVerificationLevel guildVerificationLevel = this.verificationLevelTriggered;
                int iHashCode6 = (iHashCode5 + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
                boolean z2 = this.isLurking;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode6 + r2) * 31;
                boolean z3 = this.isOnCooldown;
                ?? r3 = z3;
                if (z3) {
                    r3 = 1;
                }
                int i2 = (i + r3) * 31;
                Guild guild = this.guild;
                int iHashCode7 = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
                PendingReply pendingReply = this.pendingReply;
                int iHashCode8 = (iHashCode7 + (pendingReply != null ? pendingReply.hashCode() : 0)) * 31;
                StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = this.selectedThreadDraft;
                int iHashCode9 = (iHashCode8 + (threadDraft != null ? threadDraft.hashCode() : 0)) * 31;
                GuildMember guildMember = this.meGuildMember;
                int iHashCode10 = (iHashCode9 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                GuildJoinRequest guildJoinRequest = this.guildJoinRequest;
                int iHashCode11 = (iHashCode10 + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0)) * 31;
                StoreThreadDraft.ThreadDraftState threadDraftState = this.threadDraftState;
                int iHashCode12 = (iHashCode11 + (threadDraftState != null ? threadDraftState.hashCode() : 0)) * 31;
                boolean z4 = this.isForumPostCreateInProgress;
                return iHashCode12 + (z4 ? 1 : z4);
            }

            public final boolean isForumPostCreateInProgress() {
                return this.isForumPostCreateInProgress;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public final boolean isOnCooldown() {
                return this.isOnCooldown;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", me=");
                sbM833U.append(this.me);
                sbM833U.append(", editingMessage=");
                sbM833U.append(this.editingMessage);
                sbM833U.append(", relationshipType=");
                sbM833U.append(this.relationshipType);
                sbM833U.append(", channelPermissions=");
                sbM833U.append(this.channelPermissions);
                sbM833U.append(", verificationLevelTriggered=");
                sbM833U.append(this.verificationLevelTriggered);
                sbM833U.append(", isLurking=");
                sbM833U.append(this.isLurking);
                sbM833U.append(", isOnCooldown=");
                sbM833U.append(this.isOnCooldown);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", pendingReply=");
                sbM833U.append(this.pendingReply);
                sbM833U.append(", selectedThreadDraft=");
                sbM833U.append(this.selectedThreadDraft);
                sbM833U.append(", meGuildMember=");
                sbM833U.append(this.meGuildMember);
                sbM833U.append(", guildJoinRequest=");
                sbM833U.append(this.guildJoinRequest);
                sbM833U.append(", threadDraftState=");
                sbM833U.append(this.threadDraftState);
                sbM833U.append(", isForumPostCreateInProgress=");
                return C1643a.m827O(sbM833U, this.isForumPostCreateInProgress, ")");
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final class Loading extends StoreState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean ableToSendMessage;
            private final Channel channel;
            private final long channelId;
            private final StoreChat.EditingMessage editingMessage;
            private final boolean isBlocked;
            private final boolean isCommunicationDisabled;
            private final boolean isEditing;
            private final boolean isInputShowing;
            private final boolean isLurking;
            private final boolean isOnCooldown;
            private final boolean isReplying;
            private final boolean isSystemDM;
            private final boolean isVerificationLevelTriggered;
            private final ApplicationStatus joinRequestStatus;
            private final int maxFileSizeMB;
            private final MeUser me;
            private final GuildMember meGuildMember;
            private final PendingReplyState pendingReplyState;
            private final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft;
            private final boolean shouldBadgeChatInput;
            private final boolean shouldShowFollow;
            private final boolean shouldShowVerificationGate;
            private final boolean showCreateThreadOption;
            private final StoreThreadDraft.ThreadDraftState threadDraftState;
            private final long timeoutLeftMs;
            private final GuildVerificationLevel verificationLevelTriggered;

            /* JADX INFO: compiled from: ChatInputViewModel.kt */
            public static abstract class PendingReplyState {

                /* JADX INFO: compiled from: ChatInputViewModel.kt */
                public static final class Hide extends PendingReplyState {
                    public static final Hide INSTANCE = new Hide();

                    private Hide() {
                        super(null);
                    }
                }

                /* JADX INFO: compiled from: ChatInputViewModel.kt */
                public static final /* data */ class Replying extends PendingReplyState {
                    private final MessageReference messageReference;
                    private final com.discord.models.user.User repliedAuthor;
                    private final GuildMember repliedAuthorGuildMember;
                    private final boolean shouldMention;
                    private final boolean showMentionToggle;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public Replying(MessageReference messageReference, boolean z2, boolean z3, com.discord.models.user.User user, GuildMember guildMember) {
                        super(null);
                        C12238m.checkNotNullParameter(messageReference, "messageReference");
                        C12238m.checkNotNullParameter(user, "repliedAuthor");
                        this.messageReference = messageReference;
                        this.shouldMention = z2;
                        this.showMentionToggle = z3;
                        this.repliedAuthor = user;
                        this.repliedAuthorGuildMember = guildMember;
                    }

                    public static /* synthetic */ Replying copy$default(Replying replying, MessageReference messageReference, boolean z2, boolean z3, com.discord.models.user.User user, GuildMember guildMember, int i, Object obj) {
                        if ((i & 1) != 0) {
                            messageReference = replying.messageReference;
                        }
                        if ((i & 2) != 0) {
                            z2 = replying.shouldMention;
                        }
                        boolean z4 = z2;
                        if ((i & 4) != 0) {
                            z3 = replying.showMentionToggle;
                        }
                        boolean z5 = z3;
                        if ((i & 8) != 0) {
                            user = replying.repliedAuthor;
                        }
                        com.discord.models.user.User user2 = user;
                        if ((i & 16) != 0) {
                            guildMember = replying.repliedAuthorGuildMember;
                        }
                        return replying.copy(messageReference, z4, z5, user2, guildMember);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final MessageReference getMessageReference() {
                        return this.messageReference;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final boolean getShouldMention() {
                        return this.shouldMention;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final boolean getShowMentionToggle() {
                        return this.showMentionToggle;
                    }

                    /* JADX INFO: renamed from: component4, reason: from getter */
                    public final com.discord.models.user.User getRepliedAuthor() {
                        return this.repliedAuthor;
                    }

                    /* JADX INFO: renamed from: component5, reason: from getter */
                    public final GuildMember getRepliedAuthorGuildMember() {
                        return this.repliedAuthorGuildMember;
                    }

                    public final Replying copy(MessageReference messageReference, boolean shouldMention, boolean showMentionToggle, com.discord.models.user.User repliedAuthor, GuildMember repliedAuthorGuildMember) {
                        C12238m.checkNotNullParameter(messageReference, "messageReference");
                        C12238m.checkNotNullParameter(repliedAuthor, "repliedAuthor");
                        return new Replying(messageReference, shouldMention, showMentionToggle, repliedAuthor, repliedAuthorGuildMember);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Replying)) {
                            return false;
                        }
                        Replying replying = (Replying) other;
                        return C12238m.areEqual(this.messageReference, replying.messageReference) && this.shouldMention == replying.shouldMention && this.showMentionToggle == replying.showMentionToggle && C12238m.areEqual(this.repliedAuthor, replying.repliedAuthor) && C12238m.areEqual(this.repliedAuthorGuildMember, replying.repliedAuthorGuildMember);
                    }

                    public final MessageReference getMessageReference() {
                        return this.messageReference;
                    }

                    public final com.discord.models.user.User getRepliedAuthor() {
                        return this.repliedAuthor;
                    }

                    public final GuildMember getRepliedAuthorGuildMember() {
                        return this.repliedAuthorGuildMember;
                    }

                    public final boolean getShouldMention() {
                        return this.shouldMention;
                    }

                    public final boolean getShowMentionToggle() {
                        return this.showMentionToggle;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
                    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
                    /* JADX WARN: Type inference failed for: r2v8 */
                    /* JADX WARN: Type inference failed for: r2v9 */
                    /* JADX WARN: Type inference failed for: r3v0 */
                    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
                    /* JADX WARN: Type inference failed for: r3v2 */
                    public int hashCode() {
                        MessageReference messageReference = this.messageReference;
                        int iHashCode = (messageReference != null ? messageReference.hashCode() : 0) * 31;
                        boolean z2 = this.shouldMention;
                        ?? r2 = z2;
                        if (z2) {
                            r2 = 1;
                        }
                        int i = (iHashCode + r2) * 31;
                        boolean z3 = this.showMentionToggle;
                        int i2 = (i + (z3 ? 1 : z3)) * 31;
                        com.discord.models.user.User user = this.repliedAuthor;
                        int iHashCode2 = (i2 + (user != null ? user.hashCode() : 0)) * 31;
                        GuildMember guildMember = this.repliedAuthorGuildMember;
                        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
                    }

                    public String toString() {
                        StringBuilder sbM833U = C1643a.m833U("Replying(messageReference=");
                        sbM833U.append(this.messageReference);
                        sbM833U.append(", shouldMention=");
                        sbM833U.append(this.shouldMention);
                        sbM833U.append(", showMentionToggle=");
                        sbM833U.append(this.showMentionToggle);
                        sbM833U.append(", repliedAuthor=");
                        sbM833U.append(this.repliedAuthor);
                        sbM833U.append(", repliedAuthorGuildMember=");
                        sbM833U.append(this.repliedAuthorGuildMember);
                        sbM833U.append(")");
                        return sbM833U.toString();
                    }
                }

                private PendingReplyState() {
                }

                public /* synthetic */ PendingReplyState(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, long j, MeUser meUser, GuildMember guildMember, StoreChat.EditingMessage editingMessage, boolean z2, GuildVerificationLevel guildVerificationLevel, boolean z3, boolean z4, boolean z5, int i, boolean z6, PendingReplyState pendingReplyState, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, long j2, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft, boolean z14, ApplicationStatus applicationStatus, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z15) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
                C12238m.checkNotNullParameter(pendingReplyState, "pendingReplyState");
                C12238m.checkNotNullParameter(threadDraftState, "threadDraftState");
                this.channel = channel;
                this.channelId = j;
                this.me = meUser;
                this.meGuildMember = guildMember;
                this.editingMessage = editingMessage;
                this.ableToSendMessage = z2;
                this.verificationLevelTriggered = guildVerificationLevel;
                this.isLurking = z3;
                this.isSystemDM = z4;
                this.isOnCooldown = z5;
                this.maxFileSizeMB = i;
                this.shouldShowFollow = z6;
                this.pendingReplyState = pendingReplyState;
                this.shouldBadgeChatInput = z7;
                this.isBlocked = z8;
                this.isInputShowing = z9;
                this.isVerificationLevelTriggered = z10;
                this.isEditing = z11;
                this.isReplying = z12;
                this.isCommunicationDisabled = z13;
                this.timeoutLeftMs = j2;
                this.selectedThreadDraft = threadDraft;
                this.shouldShowVerificationGate = z14;
                this.joinRequestStatus = applicationStatus;
                this.threadDraftState = threadDraftState;
                this.showCreateThreadOption = z15;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, long j, MeUser meUser, GuildMember guildMember, StoreChat.EditingMessage editingMessage, boolean z2, GuildVerificationLevel guildVerificationLevel, boolean z3, boolean z4, boolean z5, int i, boolean z6, PendingReplyState pendingReplyState, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, long j2, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft, boolean z14, ApplicationStatus applicationStatus, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z15, int i2, Object obj) {
                return loaded.copy((i2 & 1) != 0 ? loaded.channel : channel, (i2 & 2) != 0 ? loaded.channelId : j, (i2 & 4) != 0 ? loaded.me : meUser, (i2 & 8) != 0 ? loaded.meGuildMember : guildMember, (i2 & 16) != 0 ? loaded.editingMessage : editingMessage, (i2 & 32) != 0 ? loaded.ableToSendMessage : z2, (i2 & 64) != 0 ? loaded.verificationLevelTriggered : guildVerificationLevel, (i2 & 128) != 0 ? loaded.isLurking : z3, (i2 & 256) != 0 ? loaded.isSystemDM : z4, (i2 & 512) != 0 ? loaded.isOnCooldown : z5, (i2 & 1024) != 0 ? loaded.maxFileSizeMB : i, (i2 & 2048) != 0 ? loaded.shouldShowFollow : z6, (i2 & 4096) != 0 ? loaded.pendingReplyState : pendingReplyState, (i2 & 8192) != 0 ? loaded.shouldBadgeChatInput : z7, (i2 & 16384) != 0 ? loaded.isBlocked : z8, (i2 & 32768) != 0 ? loaded.isInputShowing : z9, (i2 & 65536) != 0 ? loaded.isVerificationLevelTriggered : z10, (i2 & 131072) != 0 ? loaded.isEditing : z11, (i2 & 262144) != 0 ? loaded.isReplying : z12, (i2 & 524288) != 0 ? loaded.isCommunicationDisabled : z13, (i2 & 1048576) != 0 ? loaded.timeoutLeftMs : j2, (i2 & 2097152) != 0 ? loaded.selectedThreadDraft : threadDraft, (4194304 & i2) != 0 ? loaded.shouldShowVerificationGate : z14, (i2 & 8388608) != 0 ? loaded.joinRequestStatus : applicationStatus, (i2 & 16777216) != 0 ? loaded.threadDraftState : threadDraftState, (i2 & 33554432) != 0 ? loaded.showCreateThreadOption : z15);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final boolean getIsOnCooldown() {
                return this.isOnCooldown;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final boolean getShouldShowFollow() {
                return this.shouldShowFollow;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final PendingReplyState getPendingReplyState() {
                return this.pendingReplyState;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final boolean getShouldBadgeChatInput() {
                return this.shouldBadgeChatInput;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final boolean getIsBlocked() {
                return this.isBlocked;
            }

            /* JADX INFO: renamed from: component16, reason: from getter */
            public final boolean getIsInputShowing() {
                return this.isInputShowing;
            }

            /* JADX INFO: renamed from: component17, reason: from getter */
            public final boolean getIsVerificationLevelTriggered() {
                return this.isVerificationLevelTriggered;
            }

            /* JADX INFO: renamed from: component18, reason: from getter */
            public final boolean getIsEditing() {
                return this.isEditing;
            }

            /* JADX INFO: renamed from: component19, reason: from getter */
            public final boolean getIsReplying() {
                return this.isReplying;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component20, reason: from getter */
            public final boolean getIsCommunicationDisabled() {
                return this.isCommunicationDisabled;
            }

            /* JADX INFO: renamed from: component21, reason: from getter */
            public final long getTimeoutLeftMs() {
                return this.timeoutLeftMs;
            }

            /* JADX INFO: renamed from: component22, reason: from getter */
            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            /* JADX INFO: renamed from: component23, reason: from getter */
            public final boolean getShouldShowVerificationGate() {
                return this.shouldShowVerificationGate;
            }

            /* JADX INFO: renamed from: component24, reason: from getter */
            public final ApplicationStatus getJoinRequestStatus() {
                return this.joinRequestStatus;
            }

            /* JADX INFO: renamed from: component25, reason: from getter */
            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            /* JADX INFO: renamed from: component26, reason: from getter */
            public final boolean getShowCreateThreadOption() {
                return this.showCreateThreadOption;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getAbleToSendMessage() {
                return this.ableToSendMessage;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getIsSystemDM() {
                return this.isSystemDM;
            }

            public final Loaded copy(Channel channel, long channelId, MeUser me2, GuildMember meGuildMember, StoreChat.EditingMessage editingMessage, boolean ableToSendMessage, GuildVerificationLevel verificationLevelTriggered, boolean isLurking, boolean isSystemDM, boolean isOnCooldown, int maxFileSizeMB, boolean shouldShowFollow, PendingReplyState pendingReplyState, boolean shouldBadgeChatInput, boolean isBlocked, boolean isInputShowing, boolean isVerificationLevelTriggered, boolean isEditing, boolean isReplying, boolean isCommunicationDisabled, long timeoutLeftMs, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft, boolean shouldShowVerificationGate, ApplicationStatus joinRequestStatus, StoreThreadDraft.ThreadDraftState threadDraftState, boolean showCreateThreadOption) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
                C12238m.checkNotNullParameter(pendingReplyState, "pendingReplyState");
                C12238m.checkNotNullParameter(threadDraftState, "threadDraftState");
                return new Loaded(channel, channelId, me2, meGuildMember, editingMessage, ableToSendMessage, verificationLevelTriggered, isLurking, isSystemDM, isOnCooldown, maxFileSizeMB, shouldShowFollow, pendingReplyState, shouldBadgeChatInput, isBlocked, isInputShowing, isVerificationLevelTriggered, isEditing, isReplying, isCommunicationDisabled, timeoutLeftMs, selectedThreadDraft, shouldShowVerificationGate, joinRequestStatus, threadDraftState, showCreateThreadOption);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.channel, loaded.channel) && this.channelId == loaded.channelId && C12238m.areEqual(this.me, loaded.me) && C12238m.areEqual(this.meGuildMember, loaded.meGuildMember) && C12238m.areEqual(this.editingMessage, loaded.editingMessage) && this.ableToSendMessage == loaded.ableToSendMessage && C12238m.areEqual(this.verificationLevelTriggered, loaded.verificationLevelTriggered) && this.isLurking == loaded.isLurking && this.isSystemDM == loaded.isSystemDM && this.isOnCooldown == loaded.isOnCooldown && this.maxFileSizeMB == loaded.maxFileSizeMB && this.shouldShowFollow == loaded.shouldShowFollow && C12238m.areEqual(this.pendingReplyState, loaded.pendingReplyState) && this.shouldBadgeChatInput == loaded.shouldBadgeChatInput && this.isBlocked == loaded.isBlocked && this.isInputShowing == loaded.isInputShowing && this.isVerificationLevelTriggered == loaded.isVerificationLevelTriggered && this.isEditing == loaded.isEditing && this.isReplying == loaded.isReplying && this.isCommunicationDisabled == loaded.isCommunicationDisabled && this.timeoutLeftMs == loaded.timeoutLeftMs && C12238m.areEqual(this.selectedThreadDraft, loaded.selectedThreadDraft) && this.shouldShowVerificationGate == loaded.shouldShowVerificationGate && C12238m.areEqual(this.joinRequestStatus, loaded.joinRequestStatus) && C12238m.areEqual(this.threadDraftState, loaded.threadDraftState) && this.showCreateThreadOption == loaded.showCreateThreadOption;
            }

            public final boolean getAbleToSendMessage() {
                return this.ableToSendMessage;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            public final ApplicationStatus getJoinRequestStatus() {
                return this.joinRequestStatus;
            }

            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            public final PendingReplyState getPendingReplyState() {
                return this.pendingReplyState;
            }

            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            public final boolean getShouldBadgeChatInput() {
                return this.shouldBadgeChatInput;
            }

            public final boolean getShouldShowFollow() {
                return this.shouldShowFollow;
            }

            public final boolean getShouldShowVerificationGate() {
                return this.shouldShowVerificationGate;
            }

            public final boolean getShowCreateThreadOption() {
                return this.showCreateThreadOption;
            }

            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            public final long getTimeoutLeftMs() {
                return this.timeoutLeftMs;
            }

            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r0v19, types: [int] */
            /* JADX WARN: Type inference failed for: r0v21, types: [int] */
            /* JADX WARN: Type inference failed for: r0v23, types: [int] */
            /* JADX WARN: Type inference failed for: r0v26, types: [int] */
            /* JADX WARN: Type inference failed for: r0v31, types: [int] */
            /* JADX WARN: Type inference failed for: r0v33, types: [int] */
            /* JADX WARN: Type inference failed for: r0v35, types: [int] */
            /* JADX WARN: Type inference failed for: r0v37, types: [int] */
            /* JADX WARN: Type inference failed for: r0v39, types: [int] */
            /* JADX WARN: Type inference failed for: r0v41, types: [int] */
            /* JADX WARN: Type inference failed for: r0v43, types: [int] */
            /* JADX WARN: Type inference failed for: r0v55, types: [int] */
            /* JADX WARN: Type inference failed for: r0v56 */
            /* JADX WARN: Type inference failed for: r0v57 */
            /* JADX WARN: Type inference failed for: r0v58 */
            /* JADX WARN: Type inference failed for: r0v59 */
            /* JADX WARN: Type inference failed for: r0v60 */
            /* JADX WARN: Type inference failed for: r0v61 */
            /* JADX WARN: Type inference failed for: r0v62 */
            /* JADX WARN: Type inference failed for: r0v64 */
            /* JADX WARN: Type inference failed for: r0v65 */
            /* JADX WARN: Type inference failed for: r0v66 */
            /* JADX WARN: Type inference failed for: r0v67 */
            /* JADX WARN: Type inference failed for: r0v69 */
            /* JADX WARN: Type inference failed for: r0v74 */
            /* JADX WARN: Type inference failed for: r0v75 */
            /* JADX WARN: Type inference failed for: r0v76 */
            /* JADX WARN: Type inference failed for: r0v77 */
            /* JADX WARN: Type inference failed for: r0v78 */
            /* JADX WARN: Type inference failed for: r0v79 */
            /* JADX WARN: Type inference failed for: r0v80 */
            /* JADX WARN: Type inference failed for: r0v81 */
            /* JADX WARN: Type inference failed for: r0v82 */
            /* JADX WARN: Type inference failed for: r0v83 */
            /* JADX WARN: Type inference failed for: r0v84 */
            /* JADX WARN: Type inference failed for: r0v85 */
            /* JADX WARN: Type inference failed for: r2v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v44, types: [int] */
            /* JADX WARN: Type inference failed for: r2v50 */
            /* JADX WARN: Type inference failed for: r2v52 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iM3a = (C0002b.m3a(this.channelId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
                MeUser meUser = this.me;
                int iHashCode = (iM3a + (meUser != null ? meUser.hashCode() : 0)) * 31;
                GuildMember guildMember = this.meGuildMember;
                int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                StoreChat.EditingMessage editingMessage = this.editingMessage;
                int iHashCode3 = (iHashCode2 + (editingMessage != null ? editingMessage.hashCode() : 0)) * 31;
                boolean z2 = this.ableToSendMessage;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = (iHashCode3 + r0) * 31;
                GuildVerificationLevel guildVerificationLevel = this.verificationLevelTriggered;
                int iHashCode4 = (i + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
                boolean z3 = this.isLurking;
                ?? r1 = z3;
                if (z3) {
                    r1 = 1;
                }
                int i2 = (iHashCode4 + r1) * 31;
                boolean z4 = this.isSystemDM;
                ?? r2 = z4;
                if (z4) {
                    r2 = 1;
                }
                int i3 = (i2 + r2) * 31;
                boolean z5 = this.isOnCooldown;
                ?? r3 = z5;
                if (z5) {
                    r3 = 1;
                }
                int i4 = (((i3 + r3) * 31) + this.maxFileSizeMB) * 31;
                boolean z6 = this.shouldShowFollow;
                ?? r4 = z6;
                if (z6) {
                    r4 = 1;
                }
                int i5 = (i4 + r4) * 31;
                PendingReplyState pendingReplyState = this.pendingReplyState;
                int iHashCode5 = (i5 + (pendingReplyState != null ? pendingReplyState.hashCode() : 0)) * 31;
                boolean z7 = this.shouldBadgeChatInput;
                ?? r5 = z7;
                if (z7) {
                    r5 = 1;
                }
                int i6 = (iHashCode5 + r5) * 31;
                boolean z8 = this.isBlocked;
                ?? r6 = z8;
                if (z8) {
                    r6 = 1;
                }
                int i7 = (i6 + r6) * 31;
                boolean z9 = this.isInputShowing;
                ?? r7 = z9;
                if (z9) {
                    r7 = 1;
                }
                int i8 = (i7 + r7) * 31;
                boolean z10 = this.isVerificationLevelTriggered;
                ?? r8 = z10;
                if (z10) {
                    r8 = 1;
                }
                int i9 = (i8 + r8) * 31;
                boolean z11 = this.isEditing;
                ?? r9 = z11;
                if (z11) {
                    r9 = 1;
                }
                int i10 = (i9 + r9) * 31;
                boolean z12 = this.isReplying;
                ?? r10 = z12;
                if (z12) {
                    r10 = 1;
                }
                int i11 = (i10 + r10) * 31;
                boolean z13 = this.isCommunicationDisabled;
                ?? r11 = z13;
                if (z13) {
                    r11 = 1;
                }
                int iM3a2 = (C0002b.m3a(this.timeoutLeftMs) + ((i11 + r11) * 31)) * 31;
                StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = this.selectedThreadDraft;
                int iHashCode6 = (iM3a2 + (threadDraft != null ? threadDraft.hashCode() : 0)) * 31;
                boolean z14 = this.shouldShowVerificationGate;
                ?? r12 = z14;
                if (z14) {
                    r12 = 1;
                }
                int i12 = (iHashCode6 + r12) * 31;
                ApplicationStatus applicationStatus = this.joinRequestStatus;
                int iHashCode7 = (i12 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
                StoreThreadDraft.ThreadDraftState threadDraftState = this.threadDraftState;
                int iHashCode8 = (iHashCode7 + (threadDraftState != null ? threadDraftState.hashCode() : 0)) * 31;
                boolean z15 = this.showCreateThreadOption;
                return iHashCode8 + (z15 ? 1 : z15);
            }

            public final boolean isBlocked() {
                return this.isBlocked;
            }

            public final boolean isCommunicationDisabled() {
                return this.isCommunicationDisabled;
            }

            public final boolean isEditing() {
                return this.isEditing;
            }

            public final boolean isInputShowing() {
                return this.isInputShowing;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public final boolean isOnCooldown() {
                return this.isOnCooldown;
            }

            public final boolean isReplying() {
                return this.isReplying;
            }

            public final boolean isSystemDM() {
                return this.isSystemDM;
            }

            public final boolean isVerificationLevelTriggered() {
                return this.isVerificationLevelTriggered;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", me=");
                sbM833U.append(this.me);
                sbM833U.append(", meGuildMember=");
                sbM833U.append(this.meGuildMember);
                sbM833U.append(", editingMessage=");
                sbM833U.append(this.editingMessage);
                sbM833U.append(", ableToSendMessage=");
                sbM833U.append(this.ableToSendMessage);
                sbM833U.append(", verificationLevelTriggered=");
                sbM833U.append(this.verificationLevelTriggered);
                sbM833U.append(", isLurking=");
                sbM833U.append(this.isLurking);
                sbM833U.append(", isSystemDM=");
                sbM833U.append(this.isSystemDM);
                sbM833U.append(", isOnCooldown=");
                sbM833U.append(this.isOnCooldown);
                sbM833U.append(", maxFileSizeMB=");
                sbM833U.append(this.maxFileSizeMB);
                sbM833U.append(", shouldShowFollow=");
                sbM833U.append(this.shouldShowFollow);
                sbM833U.append(", pendingReplyState=");
                sbM833U.append(this.pendingReplyState);
                sbM833U.append(", shouldBadgeChatInput=");
                sbM833U.append(this.shouldBadgeChatInput);
                sbM833U.append(", isBlocked=");
                sbM833U.append(this.isBlocked);
                sbM833U.append(", isInputShowing=");
                sbM833U.append(this.isInputShowing);
                sbM833U.append(", isVerificationLevelTriggered=");
                sbM833U.append(this.isVerificationLevelTriggered);
                sbM833U.append(", isEditing=");
                sbM833U.append(this.isEditing);
                sbM833U.append(", isReplying=");
                sbM833U.append(this.isReplying);
                sbM833U.append(", isCommunicationDisabled=");
                sbM833U.append(this.isCommunicationDisabled);
                sbM833U.append(", timeoutLeftMs=");
                sbM833U.append(this.timeoutLeftMs);
                sbM833U.append(", selectedThreadDraft=");
                sbM833U.append(this.selectedThreadDraft);
                sbM833U.append(", shouldShowVerificationGate=");
                sbM833U.append(this.shouldShowVerificationGate);
                sbM833U.append(", joinRequestStatus=");
                sbM833U.append(this.joinRequestStatus);
                sbM833U.append(", threadDraftState=");
                sbM833U.append(this.threadDraftState);
                sbM833U.append(", showCreateThreadOption=");
                return C1643a.m827O(sbM833U, this.showCreateThreadOption, ")");
            }
        }

        /* JADX INFO: compiled from: ChatInputViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildVerificationLevel.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildVerificationLevel.LOW.ordinal()] = 1;
            iArr[GuildVerificationLevel.HIGHEST.ordinal()] = 2;
            iArr[GuildVerificationLevel.NONE.ordinal()] = 3;
            iArr[GuildVerificationLevel.MEDIUM.ordinal()] = 4;
            iArr[GuildVerificationLevel.HIGH.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$createAndGotoThread$2 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class C76892 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ ViewState.Loaded $loadedViewState;
        public final /* synthetic */ Function1 $onThreadCreated;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C76892(ViewState.Loaded loaded, Function1 function1) {
            super(1);
            this.$loadedViewState = loaded;
            this.$onThreadCreated = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel != null) {
                StoreStream.INSTANCE.getSlowMode().onThreadCreated(this.$loadedViewState.getChannelId());
                Function1 function1 = this.$onThreadCreated;
                if (function1 != null) {
                    function1.invoke(channel);
                }
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$createAndGotoThread$3 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class C76903 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ ViewState.Loaded $loadedViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C76903(Context context, ViewState.Loaded loaded) {
            super(1);
            this.$context = context;
            this.$loadedViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            ThreadUtils.INSTANCE.handleThreadCreateError(this.$context, error, this.$loadedViewState.getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendCommand$1 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class C76931 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public static final C76931 INSTANCE = new C76931();

        public C76931() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$1 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class C76951 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ Function1 $sendMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C76951(Function1 function1) {
            super(1);
            this.$sendMessage = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "thread");
            this.$sendMessage.invoke(Long.valueOf(channel.getId()));
        }
    }

    public ChatInputViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 32767, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChatInputViewModel(StoreChat storeChat, StoreChannels storeChannels, StoreMessagesLoader storeMessagesLoader, StoreLurking storeLurking, StoreStickers storeStickers, StorePendingReplies storePendingReplies, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreUserSettings storeUserSettings, StoreAnalytics storeAnalytics, StoreThreadDraft storeThreadDraft, StoreGuilds storeGuilds, boolean z2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState;
        StoreChat chat = (i & 1) != 0 ? StoreStream.INSTANCE.getChat() : storeChat;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreMessagesLoader messagesLoader = (i & 4) != 0 ? StoreStream.INSTANCE.getMessagesLoader() : storeMessagesLoader;
        StoreLurking lurking = (i & 8) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking;
        StoreStickers stickers = (i & 16) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        StorePendingReplies pendingReplies = (i & 32) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies;
        StoreApplicationInteractions interactions = (i & 64) != 0 ? StoreStream.INSTANCE.getInteractions() : storeApplicationInteractions;
        StoreApplicationCommands applicationCommands = (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationCommands() : storeApplicationCommands;
        StoreApplicationCommandFrecency applicationComandFrecency = (i & 256) != 0 ? StoreStream.INSTANCE.getApplicationComandFrecency() : storeApplicationCommandFrecency;
        StoreUserSettings userSettings = (i & 512) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreAnalytics analytics = (i & 1024) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreThreadDraft threadDraft = (i & 2048) != 0 ? StoreStream.INSTANCE.getThreadDraft() : storeThreadDraft;
        StoreGuilds guilds = (i & 4096) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        boolean zIsEnabled = (i & 8192) != 0 ? EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled() : z2;
        if ((i & 16384) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState = companion.observeStoreState(companion2.getChannelsSelected(), companion2.getUsers(), chat, companion2.getUserRelationships(), companion2.getPermissions(), lurking, companion2.getSlowMode(), guilds, pendingReplies, companion2.getGuildJoinRequests(), threadDraft);
        } else {
            observableObserveStoreState = observable;
        }
        this(chat, channels, messagesLoader, lurking, stickers, pendingReplies, interactions, applicationCommands, applicationComandFrecency, userSettings, analytics, threadDraft, guilds, zIsEnabled, observableObserveStoreState);
    }

    private final long calculateTimeoutLeftMs(GuildMember guildMember) {
        UtcDateTime communicationDisabledUntil;
        if (guildMember == null || (communicationDisabledUntil = guildMember.getCommunicationDisabledUntil()) == null) {
            return 0L;
        }
        return communicationDisabledUntil.getDateTimeMillis() - ClockFactory.get().currentTimeMillis();
    }

    private final void createAndGotoThread(Context context, Long parentMessageId, String location, ViewState.Loaded loadedViewState, Function1<? super Channel, Unit> onThreadCreated) {
        int i;
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        long channelId = loadedViewState.getChannelId();
        if (ChannelUtils.m7685i(loadedViewState.getChannel())) {
            i = 10;
        } else {
            i = loadedViewState.getThreadDraftState().isPrivate() ? 12 : 11;
        }
        String threadName = loadedViewState.getThreadDraftState().getThreadName();
        if (threadName == null) {
            threadName = "";
        }
        Observable observableM11082A = ObservableExtensionsKt.restSubscribeOn$default(threadUtils.createThread(channelId, parentMessageId, i, threadName, Integer.valueOf(getAutoArchiveDuration()), location), false, 1, null).m11082A(new InterfaceC12589b<Channel, Observable<? extends Channel>>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel.createAndGotoThread.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Channel> call(Channel channel) {
                Observable<R> observableM11083G = ChatInputViewModel.this.storeChannels.observeChannel(channel.getId()).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
                C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
                return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 0L, false, 3, null));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "ThreadUtils.createThread…utationLatest()\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11082A, this, null, 2, null), (Class<?>) ChatInputViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C76903(context, loadedViewState)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76892(loadedViewState, onThreadCreated));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createAndGotoThread$default(ChatInputViewModel chatInputViewModel, Context context, Long l, String str, ViewState.Loaded loaded, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        chatInputViewModel.createAndGotoThread(context, l, str, loaded, function1);
    }

    private final void createForumPostWithMessage(Context context, long channelId, MessageManager messageManager, MessageContent messageContent, MessageManager.AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            ForumPostCreateManager.INSTANCE.createForumPostWithMessage(context, messageManager, channelId, getAutoArchiveDuration(), messageContent.getTextContent(), loaded.getThreadDraftState(), attachmentsRequest, onMessageTooLong, onFilesTooLarge);
        }
    }

    private final int getAutoArchiveDuration() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            return 1440;
        }
        Integer autoArchiveDuration = loaded.getThreadDraftState().getAutoArchiveDuration();
        if (autoArchiveDuration == null) {
            autoArchiveDuration = loaded.getChannel().getDefaultAutoArchiveDuration();
        }
        if (autoArchiveDuration != null) {
            return autoArchiveDuration.intValue();
        }
        return 1440;
    }

    private final void handleStoreChatEvent(StoreChat.Event event) {
        if (event instanceof StoreChat.Event.AppendChatText) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.f27650k.onNext(new Event.AppendChatText(((StoreChat.Event.AppendChatText) event).getText()));
        } else if (event instanceof StoreChat.Event.ReplaceChatText) {
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.f27650k.onNext(new Event.SetChatText(((StoreChat.Event.ReplaceChatText) event).getText()));
        }
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        String string;
        CharSequence content;
        ThreadMetadata threadMetadata;
        if (storeState instanceof StoreState.Loaded) {
            StoreState.Loaded loaded = (StoreState.Loaded) storeState;
            boolean zHasAccessWrite = loaded.getSelectedThreadDraft() == null ? PermissionUtils.INSTANCE.hasAccessWrite(loaded.getChannel(), loaded.getChannelPermissions()) : PermissionUtils.can(Permission.SEND_MESSAGES_IN_THREADS, loaded.getChannelPermissions());
            boolean zIsType = ModelUserRelationship.isType(loaded.getRelationshipType(), 2);
            boolean z3 = (zIsType || !zHasAccessWrite || loaded.isLurking() || (ChannelUtils.m7673H(loaded.getChannel()) && (threadMetadata = loaded.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() && !ThreadUtils.INSTANCE.canUnarchiveThread(loaded.getChannel(), loaded.getChannelPermissions()))) ? false : true;
            boolean z4 = loaded.getSelectedThreadDraft() != null;
            if (loaded.getChannel().getType() != 15) {
                z2 = z3;
            } else {
                z2 = z3 && z4 && !loaded.isForumPostCreateInProgress();
            }
            boolean z5 = loaded.getChannel().getType() == 5 && !z2;
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            int maxFileSizeMB = premiumUtils.getMaxFileSizeMB(loaded.getMe());
            Guild guild = loaded.getGuild();
            int iMax = Math.max(premiumUtils.getGuildMaxFileSizeMB(guild != null ? guild.getPremiumTier() : 0), maxFileSizeMB);
            boolean z6 = loaded.getVerificationLevelTriggered() != GuildVerificationLevel.NONE;
            StoreState.Loaded.PendingReply pendingReply = loaded.getPendingReply();
            ViewState.Loaded.PendingReplyState replying = (pendingReply != null ? pendingReply.getRepliedAuthor() : null) != null ? new ViewState.Loaded.PendingReplyState.Replying(loaded.getPendingReply().getPendingReply().getMessageReference(), loaded.getPendingReply().getPendingReply().getShouldMention(), loaded.getPendingReply().getPendingReply().getShowMentionToggle(), loaded.getPendingReply().getRepliedAuthor(), loaded.getPendingReply().getRepliedAuthorGuildMember()) : ViewState.Loaded.PendingReplyState.Hide.INSTANCE;
            boolean zHasVerificationGate$default = MemberVerificationUtils.hasVerificationGate$default(MemberVerificationUtils.INSTANCE, loaded.getGuild(), null, 2, null);
            boolean z7 = (loaded.getMeGuildMember() == null || loaded.getMeGuildMember().getPending()) ? false : true;
            GuildMember meGuildMember = loaded.getMeGuildMember();
            boolean zIsCommunicationDisabled = meGuildMember != null ? meGuildMember.isCommunicationDisabled() : false;
            boolean z8 = zHasVerificationGate$default && !z7;
            boolean z9 = (ChannelUtils.m7670E(loaded.getChannel()) || loaded.isLurking() || z6 || z5 || z8 || zIsCommunicationDisabled) ? false : true;
            boolean z10 = z2 && loaded.getEditingMessage() != null && loaded.getEditingMessage().getMessage().getChannelId() == loaded.getChannel().getId();
            boolean z11 = replying instanceof ViewState.Loaded.PendingReplyState.Replying;
            boolean zCanCreateThread = ThreadUtils.INSTANCE.canCreateThread(loaded.getChannelPermissions(), loaded.getChannel(), null, loaded.getGuild());
            long jCalculateTimeoutLeftMs = calculateTimeoutLeftMs(loaded.getMeGuildMember());
            Channel channel = loaded.getChannel();
            long id2 = loaded.getChannel().getId();
            MeUser me2 = loaded.getMe();
            GuildMember meGuildMember2 = loaded.getMeGuildMember();
            StoreChat.EditingMessage editingMessage = loaded.getEditingMessage();
            GuildVerificationLevel verificationLevelTriggered = loaded.getVerificationLevelTriggered();
            boolean zIsLurking = loaded.isLurking();
            boolean zM7670E = ChannelUtils.m7670E(loaded.getChannel());
            boolean zIsOnCooldown = loaded.isOnCooldown();
            StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft = loaded.getSelectedThreadDraft();
            GuildJoinRequest guildJoinRequest = loaded.getGuildJoinRequest();
            boolean z12 = zIsCommunicationDisabled;
            ViewState.Loaded loaded2 = new ViewState.Loaded(channel, id2, me2, meGuildMember2, editingMessage, z2, verificationLevelTriggered, zIsLurking, zM7670E, zIsOnCooldown, iMax, z5, replying, false, zIsType, z9, z6, z10, z11, z12, jCalculateTimeoutLeftMs, selectedThreadDraft, z8, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, loaded.getThreadDraftState(), zCanCreateThread);
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.Loaded)) {
                viewState = null;
            }
            ViewState.Loaded loaded3 = (ViewState.Loaded) viewState;
            boolean z13 = !C12238m.areEqual(loaded3 != null ? loaded3.getEditingMessage() : null, loaded2.getEditingMessage());
            ViewState viewState2 = getViewState();
            if (!(viewState2 instanceof ViewState.Loaded)) {
                viewState2 = null;
            }
            ViewState.Loaded loaded4 = (ViewState.Loaded) viewState2;
            boolean z14 = (loaded4 != null ? loaded4.getSelectedThreadDraft() : null) != null && loaded2.getSelectedThreadDraft() == null;
            this.useTimeoutUpdateInterval = z12;
            updateViewState(loaded2);
            if (z13) {
                StoreChat.EditingMessage editingMessage2 = loaded2.getEditingMessage();
                if (editingMessage2 == null || (content = editingMessage2.getContent()) == null || (string = content.toString()) == null) {
                    string = "";
                }
                this.eventSubject.f27650k.onNext(new Event.SetChatText(string));
            }
            if (z14) {
                this.eventSubject.f27650k.onNext(Event.ThreadDraftClosed.INSTANCE);
            }
        }
    }

    public final void deleteEditingMessage() {
        this.storeChat.setEditingMessage(null);
    }

    public final void deletePendingReply() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            this.storePendingReplies.onDeletePendingReply(loaded.getChannelId());
        }
    }

    public final boolean handleEmojiAutocompleteUpsellClicked(Autocompletable item) {
        C12238m.checkNotNullParameter(item, "item");
        if (!this.isEmojiAutocompleteUpsellEnabled || !(item instanceof EmojiUpsellPlaceholder)) {
            return false;
        }
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowPremiumUpsell(1, C5419R.string.autocomplete_emoji_upsell_modal_header, C5419R.string.autocomplete_emoji_upsell_modal_blurb_mobile, false, false, 24, null));
        this.storeAnalytics.emojiAutocompleteUpsellModalViewed();
        return true;
    }

    public final void jumpToMessageReference(MessageReference messageReference) {
        C12238m.checkNotNullParameter(messageReference, "messageReference");
        StoreMessagesLoader storeMessagesLoader = this.storeMessagesLoader;
        Long channelId = messageReference.getChannelId();
        C12238m.checkNotNull(channelId);
        long jLongValue = channelId.longValue();
        Long messageId = messageReference.getMessageId();
        C12238m.checkNotNull(messageId);
        storeMessagesLoader.jumpToMessage(jLongValue, messageId.longValue());
    }

    public final void lurkGuild(Fragment fragment) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreLurking storeLurking = this.storeLurking;
            long guildId = loaded.getChannel().getGuildId();
            Context contextRequireContext = fragment.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
            storeLurking.postJoinGuildAsMember(guildId, contextRequireContext);
        }
    }

    public final Observable<ViewState> observeChatInputViewState() {
        Observable<Long> observableM11061E = Observable.m11061E(0L, 1L, TimeUnit.SECONDS);
        C12238m.checkNotNullExpressionValue(observableM11061E, "Observable.interval(0L, 1L, TimeUnit.SECONDS)");
        Observable<ViewState> observableM11076j = Observable.m11076j(ObservableExtensionsKt.m8518ui(observableM11061E).m11083G(new InterfaceC12589b<Long, Long>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel.observeChatInputViewState.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Long call(Long l) {
                if (ChatInputViewModel.this.useTimeoutUpdateInterval) {
                    return l;
                }
                return 0L;
            }
        }).m11112r(), observeViewState(), new Func2<Long, ViewState, ViewState>() { // from class: com.discord.widgets.chat.input.ChatInputViewModel.observeChatInputViewState.2
            @Override // p658rx.functions.Func2
            public final ViewState call(Long l, ViewState viewState) {
                ViewState.Loaded loaded = (ViewState.Loaded) (!(viewState instanceof ViewState.Loaded) ? null : viewState);
                if (loaded == null) {
                    return viewState;
                }
                if (ChatInputViewModel.this.useTimeoutUpdateInterval) {
                    long jCalculateTimeoutLeftMs = ChatInputViewModel.this.calculateTimeoutLeftMs(loaded.getMeGuildMember());
                    GuildMember meGuildMember = loaded.getMeGuildMember();
                    ViewState.Loaded loadedCopy$default = ViewState.Loaded.copy$default(loaded, null, 0L, null, null, null, false, null, false, false, false, 0, false, null, false, false, false, false, false, false, meGuildMember != null && meGuildMember.isCommunicationDisabled(), jCalculateTimeoutLeftMs, null, false, null, null, false, 65535999, null);
                    if (loaded.getMeGuildMember() != null && loaded.isCommunicationDisabled() && !loadedCopy$default.isCommunicationDisabled()) {
                        ChatInputViewModel.this.storeGuilds.handleGuildMemberCommunicationEnabled(loaded.getMeGuildMember().getGuildId(), loaded.getMeGuildMember().getUserId());
                    }
                    loaded = loadedCopy$default;
                }
                return loaded != null ? loaded : viewState;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…     } ?: viewState\n    }");
        return observableM11076j;
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final void onCommandInputsInvalid() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.CommandInputsInvalid.INSTANCE);
    }

    public final void onCommandUsed(ApplicationCommandData applicationCommandData) {
        C12238m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            this.storeApplicationCommandsFrecency.onCommandUsed(loaded.getChannel().getGuildId() != 0 ? Long.valueOf(loaded.getChannel().getGuildId()) : null, ApplicationCommandDataKt.getCommandId(applicationCommandData));
        }
    }

    public final void sendCommand(Context context, MessageManager messageManager, ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> attachments, boolean autocomplete, boolean compressedImages, Function1<? super Boolean, Unit> onValidationResult) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(messageManager, "messageManager");
        C12238m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        C12238m.checkNotNullParameter(attachments, "attachments");
        C12238m.checkNotNullParameter(onValidationResult, "onValidationResult");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        AttachmentContext attachmentContext = toAttachmentContext(C12163u.toList(attachments.values()), context);
        ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 chatInputViewModel$sendCommand$commandResendCompressedHandler$1 = (compressedImages || !attachmentContext.getHasImage()) ? null : new ChatInputViewModel$sendCommand$commandResendCompressedHandler$1(this, context, attachmentContext, attachments, messageManager, applicationCommandData, autocomplete);
        if (!applicationCommandData.getValidInputs() && !autocomplete) {
            onCommandInputsInvalid();
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        Long lValueOf = loaded.getChannel().getGuildId() != 0 ? Long.valueOf(loaded.getChannel().getGuildId()) : null;
        if (autocomplete) {
            this.storeApplicationCommands.requestApplicationCommandAutocompleteData(lValueOf, loaded.getChannelId(), applicationCommandData);
            onValidationResult.invoke(Boolean.TRUE);
        } else if (chatInputViewModel$sendCommand$commandResendCompressedHandler$1 != null && this.storeUserSettings.getIsAutoImageCompressionEnabled()) {
            chatInputViewModel$sendCommand$commandResendCompressedHandler$1.invoke();
        } else {
            onCommandUsed(applicationCommandData);
            onValidationResult.invoke(Boolean.valueOf(messageManager.sendCommand(loaded.getChannelId(), lValueOf, applicationCommandData.getApplicationCommand().getVersion(), applicationCommandData, new MessageManager.AttachmentsRequest(attachmentContext.getCurrentFileSizeMB(), loaded.getMaxFileSizeMB(), attachmentContext.getAttachments()), ChatInputViewModel$sendCommand$validated$1.INSTANCE, ChatInputViewModel$sendCommand$validated$2.INSTANCE, new ChatInputViewModel$sendCommand$validated$3(this, attachmentContext, chatInputViewModel$sendCommand$commandResendCompressedHandler$1))));
        }
    }

    public final void sendMessage(Context context, MessageManager messageManager, MessageContent messageContent, List<? extends Attachment<?>> attachmentsRaw, boolean compressedImages, Function1<? super Boolean, Unit> onValidationResult) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(messageManager, "messageManager");
        C12238m.checkNotNullParameter(messageContent, "messageContent");
        C12238m.checkNotNullParameter(attachmentsRaw, "attachmentsRaw");
        C12238m.checkNotNullParameter(onValidationResult, "onValidationResult");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        AttachmentContext attachmentContext = toAttachmentContext(attachmentsRaw, context);
        boolean z2 = true;
        boolean z3 = loaded.getSelectedThreadDraft() != null;
        ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 chatInputViewModel$sendMessage$messageResendCompressedHandler$1 = (compressedImages || !attachmentContext.getHasImage()) ? null : new ChatInputViewModel$sendMessage$messageResendCompressedHandler$1(this, context, attachmentContext, messageManager, messageContent, onValidationResult);
        ChatInputViewModel$sendMessage$messageSendResultHandler$1 chatInputViewModel$sendMessage$messageSendResultHandler$1 = new ChatInputViewModel$sendMessage$messageSendResultHandler$1(this, context, loaded, attachmentContext, chatInputViewModel$sendMessage$messageResendCompressedHandler$1, z3);
        ChatInputViewModel$sendMessage$onMessageTooLong$1 chatInputViewModel$sendMessage$onMessageTooLong$1 = new ChatInputViewModel$sendMessage$onMessageTooLong$1(this);
        ChatInputViewModel$sendMessage$onFilesTooLarge$1 chatInputViewModel$sendMessage$onFilesTooLarge$1 = new ChatInputViewModel$sendMessage$onFilesTooLarge$1(this, attachmentContext, chatInputViewModel$sendMessage$messageResendCompressedHandler$1);
        if (chatInputViewModel$sendMessage$messageResendCompressedHandler$1 != null && this.storeUserSettings.getIsAutoImageCompressionEnabled()) {
            chatInputViewModel$sendMessage$messageResendCompressedHandler$1.invoke();
            return;
        }
        MessageManager.AttachmentsRequest attachmentsRequest = new MessageManager.AttachmentsRequest(attachmentContext.getCurrentFileSizeMB(), loaded.getMaxFileSizeMB(), attachmentContext.getAttachments());
        ChatInputViewModel$sendMessage$sendMessage$1 chatInputViewModel$sendMessage$sendMessage$1 = new ChatInputViewModel$sendMessage$sendMessage$1(messageManager, messageContent, attachmentsRequest, chatInputViewModel$sendMessage$messageSendResultHandler$1, chatInputViewModel$sendMessage$onMessageTooLong$1, chatInputViewModel$sendMessage$onFilesTooLarge$1, onValidationResult);
        boolean zM7693q = ChannelUtils.m7693q(loaded.getChannel());
        boolean zCanAccessRedesignedForumChannels$default = ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, loaded.getChannel().getGuildId(), null, 2, null);
        if (loaded.isEditing() && loaded.getEditingMessage() != null) {
            Message message = loaded.getEditingMessage().getMessage();
            long id2 = message.getId();
            long channelId = message.getChannelId();
            String textContent = messageContent.getTextContent();
            String content = message.getContent();
            onValidationResult.invoke(Boolean.valueOf(messageManager.editMessage(id2, channelId, textContent, chatInputViewModel$sendMessage$onMessageTooLong$1, Integer.valueOf(content != null ? content.length() : 0))));
            return;
        }
        if (z3 && zM7693q && zCanAccessRedesignedForumChannels$default) {
            createForumPostWithMessage(context, loaded.getChannelId(), messageManager, messageContent, attachmentsRequest, chatInputViewModel$sendMessage$onMessageTooLong$1, chatInputViewModel$sendMessage$onFilesTooLarge$1);
            return;
        }
        if (!z3) {
            chatInputViewModel$sendMessage$sendMessage$1.invoke(Long.valueOf(loaded.getChannelId()));
            return;
        }
        String threadName = loaded.getThreadDraftState().getThreadName();
        if (threadName != null && threadName.length() != 0) {
            z2 = false;
        }
        if (z2) {
            StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(loaded.getThreadDraftState(), false, null, null, false, true, 15, null));
            return;
        }
        StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft = loaded.getSelectedThreadDraft();
        Long starterMessageId = selectedThreadDraft != null ? selectedThreadDraft.getStarterMessageId() : null;
        StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft2 = loaded.getSelectedThreadDraft();
        createAndGotoThread(context, starterMessageId, selectedThreadDraft2 != null ? selectedThreadDraft2.getThreadStartLocation() : null, loaded, new C76951(chatInputViewModel$sendMessage$sendMessage$1));
    }

    public final void sendSticker(Sticker sticker, MessageManager messageManager) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(messageManager, "messageManager");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !loaded.getAbleToSendMessage()) {
            return;
        }
        this.storeStickers.onStickerUsed(sticker);
        messageManager.sendMessage((510 & 1) != 0 ? "" : null, (510 & 2) != 0 ? null : null, (510 & 4) != 0 ? null : null, (510 & 8) != 0 ? null : null, (510 & 16) != 0 ? C12147n.emptyList() : C12145m.listOf(sticker), (510 & 32) != 0, (510 & 64) != 0 ? null : null, (510 & 128) == 0 ? null : null, (510 & 256) != 0 ? messageManager.defaultMessageResultHandler : null);
    }

    public final AttachmentContext toAttachmentContext(List<? extends Attachment<?>> list, Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        C12238m.checkNotNullParameter(list, "$this$toAttachmentContext");
        C12238m.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList(list);
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                Attachment attachment = (Attachment) it.next();
                C12238m.checkNotNullExpressionValue(attachment, "attachment");
                if (AttachmentUtilsKt.isImage(attachment, context.getContentResolver())) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                Attachment attachment2 = (Attachment) it2.next();
                C12238m.checkNotNullExpressionValue(attachment2, "attachment");
                if (AttachmentUtilsKt.isVideo(attachment2, context.getContentResolver())) {
                    z3 = true;
                    break;
                }
            }
        } else {
            z3 = false;
            break;
        }
        if (!arrayList.isEmpty()) {
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z4 = false;
                    break;
                }
                Attachment attachment3 = (Attachment) it3.next();
                C12238m.checkNotNullExpressionValue(attachment3, "attachment");
                if (AttachmentUtilsKt.isGif(attachment3, context.getContentResolver())) {
                    z4 = true;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            Uri uri = ((Attachment) it4.next()).getUri();
            ContentResolver contentResolver = context.getContentResolver();
            C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            arrayList2.add(Float.valueOf(SendUtilsKt.computeFileSizeMegabytes(uri, contentResolver)));
        }
        float fSumOfFloat = C12163u.sumOfFloat(arrayList2);
        Float fM11488maxOrNull = C12163u.m11488maxOrNull((Iterable<Float>) arrayList2);
        return new AttachmentContext(arrayList, z2, z3, z4, arrayList2, fSumOfFloat, fM11488maxOrNull != null ? fM11488maxOrNull.floatValue() : 0.0f);
    }

    public final void togglePendingReplyShouldMention() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            ViewState.Loaded.PendingReplyState pendingReplyState = loaded.getPendingReplyState();
            ViewState.Loaded.PendingReplyState.Replying replying = (ViewState.Loaded.PendingReplyState.Replying) (pendingReplyState instanceof ViewState.Loaded.PendingReplyState.Replying ? pendingReplyState : null);
            if (replying != null) {
                StorePendingReplies storePendingReplies = this.storePendingReplies;
                Long channelId = replying.getMessageReference().getChannelId();
                C12238m.checkNotNull(channelId);
                storePendingReplies.onSetPendingReplyShouldMention(channelId.longValue(), !replying.getShouldMention());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    public final void verifyAccount(Context context) {
        Unit unit;
        C12238m.checkNotNullParameter(context, "context");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            int iOrdinal = loaded.getVerificationLevelTriggered().ordinal();
            if (iOrdinal == 0) {
                unit = Unit.f27425a;
            } else if (iOrdinal == 1) {
                WidgetUserEmailVerify.INSTANCE.launch(context, WidgetUserAccountVerifyBase.Mode.UNFORCED);
                unit = Unit.f27425a;
            } else if (iOrdinal == 2 || iOrdinal == 3) {
                unit = Unit.f27425a;
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                WidgetUserPhoneManage.INSTANCE.launch(context, WidgetUserAccountVerifyBase.Mode.UNFORCED, WidgetUserPhoneManage.Companion.Source.GUILD_PHONE_REQUIRED);
                unit = Unit.f27425a;
            }
            KotlinExtensionsKt.getExhaustive(unit);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel(StoreChat storeChat, StoreChannels storeChannels, StoreMessagesLoader storeMessagesLoader, StoreLurking storeLurking, StoreStickers storeStickers, StorePendingReplies storePendingReplies, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreUserSettings storeUserSettings, StoreAnalytics storeAnalytics, StoreThreadDraft storeThreadDraft, StoreGuilds storeGuilds, boolean z2, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(storeChat, "storeChat");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeMessagesLoader, "storeMessagesLoader");
        C12238m.checkNotNullParameter(storeLurking, "storeLurking");
        C12238m.checkNotNullParameter(storeStickers, "storeStickers");
        C12238m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        C12238m.checkNotNullParameter(storeApplicationInteractions, "storeApplicationInteractions");
        C12238m.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        C12238m.checkNotNullParameter(storeApplicationCommandFrecency, "storeApplicationCommandsFrecency");
        C12238m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        C12238m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        C12238m.checkNotNullParameter(storeThreadDraft, "storeThreadDraft");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeChat = storeChat;
        this.storeChannels = storeChannels;
        this.storeMessagesLoader = storeMessagesLoader;
        this.storeLurking = storeLurking;
        this.storeStickers = storeStickers;
        this.storePendingReplies = storePendingReplies;
        this.storeApplicationInteractions = storeApplicationInteractions;
        this.storeApplicationCommands = storeApplicationCommands;
        this.storeApplicationCommandsFrecency = storeApplicationCommandFrecency;
        this.storeUserSettings = storeUserSettings;
        this.storeAnalytics = storeAnalytics;
        this.storeThreadDraft = storeThreadDraft;
        this.storeGuilds = storeGuilds;
        this.isEmojiAutocompleteUpsellEnabled = z2;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) ChatInputViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76831(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(storeChat.observeEvents(), this, null, 2, null), (Class<?>) ChatInputViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76842(this));
    }
}
