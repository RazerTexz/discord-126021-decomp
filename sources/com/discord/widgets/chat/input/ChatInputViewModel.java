package com.discord.widgets.chat.input;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.message.MessageReference;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreChat$EditingMessage;
import com.discord.stores.StoreChat$Event;
import com.discord.stores.StoreChat$Event$AppendChatText;
import com.discord.stores.StoreChat$Event$ReplaceChatText;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.MessageManager$AttachmentsRequest;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandDataKt;
import com.discord.widgets.forums.ForumPostCreateManager;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.discord.widgets.user.phone.WidgetUserPhoneManage$Companion$Source;
import com.lytefast.flexinput.model.Attachment;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel extends d0<ChatInputViewModel$ViewState> {
    public static final ChatInputViewModel$Companion Companion = new ChatInputViewModel$Companion(null);
    private final PublishSubject<ChatInputViewModel$Event> eventSubject;
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

    public ChatInputViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 32767, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChatInputViewModel(StoreChat storeChat, StoreChannels storeChannels, StoreMessagesLoader storeMessagesLoader, StoreLurking storeLurking, StoreStickers storeStickers, StorePendingReplies storePendingReplies, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreUserSettings storeUserSettings, StoreAnalytics storeAnalytics, StoreThreadDraft storeThreadDraft, StoreGuilds storeGuilds, boolean z2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        StoreChat chat = (i & 1) != 0 ? StoreStream.Companion.getChat() : storeChat;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreMessagesLoader messagesLoader = (i & 4) != 0 ? StoreStream.Companion.getMessagesLoader() : storeMessagesLoader;
        StoreLurking lurking = (i & 8) != 0 ? StoreStream.Companion.getLurking() : storeLurking;
        StoreStickers stickers = (i & 16) != 0 ? StoreStream.Companion.getStickers() : storeStickers;
        StorePendingReplies pendingReplies = (i & 32) != 0 ? StoreStream.Companion.getPendingReplies() : storePendingReplies;
        StoreApplicationInteractions interactions = (i & 64) != 0 ? StoreStream.Companion.getInteractions() : storeApplicationInteractions;
        StoreApplicationCommands applicationCommands = (i & 128) != 0 ? StoreStream.Companion.getApplicationCommands() : storeApplicationCommands;
        StoreApplicationCommandFrecency applicationComandFrecency = (i & 256) != 0 ? StoreStream.Companion.getApplicationComandFrecency() : storeApplicationCommandFrecency;
        StoreUserSettings userSettings = (i & 512) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings;
        StoreAnalytics analytics = (i & 1024) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics;
        StoreThreadDraft threadDraft = (i & 2048) != 0 ? StoreStream.Companion.getThreadDraft() : storeThreadDraft;
        StoreGuilds guilds = (i & 4096) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        boolean zIsEnabled = (i & 8192) != 0 ? EmojiAutocompletePremiumUpsellFeatureFlag.Companion.getINSTANCE().isEnabled() : z2;
        if ((i & 16384) != 0) {
            ChatInputViewModel$Companion chatInputViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStoreState = ChatInputViewModel$Companion.access$observeStoreState(chatInputViewModel$Companion, storeStream$Companion.getChannelsSelected(), storeStream$Companion.getUsers(), chat, storeStream$Companion.getUserRelationships(), storeStream$Companion.getPermissions(), lurking, storeStream$Companion.getSlowMode(), guilds, pendingReplies, storeStream$Companion.getGuildJoinRequests(), threadDraft);
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(chat, channels, messagesLoader, lurking, stickers, pendingReplies, interactions, applicationCommands, applicationComandFrecency, userSettings, analytics, threadDraft, guilds, zIsEnabled, observableAccess$observeStoreState);
    }

    public static final /* synthetic */ long access$calculateTimeoutLeftMs(ChatInputViewModel chatInputViewModel, GuildMember guildMember) {
        return chatInputViewModel.calculateTimeoutLeftMs(guildMember);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.eventSubject;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.storeGuilds;
    }

    public static final /* synthetic */ StoreThreadDraft access$getStoreThreadDraft$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.storeThreadDraft;
    }

    public static final /* synthetic */ boolean access$getUseTimeoutUpdateInterval$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.useTimeoutUpdateInterval;
    }

    public static final /* synthetic */ void access$handleStoreChatEvent(ChatInputViewModel chatInputViewModel, StoreChat$Event storeChat$Event) {
        chatInputViewModel.handleStoreChatEvent(storeChat$Event);
    }

    public static final /* synthetic */ void access$handleStoreState(ChatInputViewModel chatInputViewModel, ChatInputViewModel$StoreState chatInputViewModel$StoreState) {
        chatInputViewModel.handleStoreState(chatInputViewModel$StoreState);
    }

    public static final /* synthetic */ void access$setUseTimeoutUpdateInterval$p(ChatInputViewModel chatInputViewModel, boolean z2) {
        chatInputViewModel.useTimeoutUpdateInterval = z2;
    }

    private final long calculateTimeoutLeftMs(GuildMember guildMember) {
        UtcDateTime communicationDisabledUntil;
        if (guildMember == null || (communicationDisabledUntil = guildMember.getCommunicationDisabledUntil()) == null) {
            return 0L;
        }
        return communicationDisabledUntil.getDateTimeMillis() - ClockFactory.get().currentTimeMillis();
    }

    private final void createAndGotoThread(Context context, Long parentMessageId, String location, ChatInputViewModel$ViewState$Loaded loadedViewState, Function1<? super Channel, Unit> onThreadCreated) {
        int i;
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        long channelId = loadedViewState.getChannelId();
        if (ChannelUtils.i(loadedViewState.getChannel())) {
            i = 10;
        } else {
            i = loadedViewState.getThreadDraftState().isPrivate() ? 12 : 11;
        }
        String threadName = loadedViewState.getThreadDraftState().getThreadName();
        if (threadName == null) {
            threadName = "";
        }
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(threadUtils.createThread(channelId, parentMessageId, i, threadName, Integer.valueOf(getAutoArchiveDuration()), location), false, 1, null).A(new ChatInputViewModel$createAndGotoThread$1(this));
        m.checkNotNullExpressionValue(observableA, "ThreadUtils.createThread…utationLatest()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableA, this, null, 2, null), ChatInputViewModel.class, (Context) null, (Function1) null, new ChatInputViewModel$createAndGotoThread$3(context, loadedViewState), (Function0) null, (Function0) null, new ChatInputViewModel$createAndGotoThread$2(loadedViewState, onThreadCreated), 54, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createAndGotoThread$default(ChatInputViewModel chatInputViewModel, Context context, Long l, String str, ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        chatInputViewModel.createAndGotoThread(context, l, str, chatInputViewModel$ViewState$Loaded, function1);
    }

    private final void createForumPostWithMessage(Context context, long channelId, MessageManager messageManager, MessageContent messageContent, MessageManager$AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded != null) {
            ForumPostCreateManager.INSTANCE.createForumPostWithMessage(context, messageManager, channelId, getAutoArchiveDuration(), messageContent.getTextContent(), chatInputViewModel$ViewState$Loaded.getThreadDraftState(), attachmentsRequest, onMessageTooLong, onFilesTooLarge);
        }
    }

    private final int getAutoArchiveDuration() {
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded == null) {
            return 1440;
        }
        Integer autoArchiveDuration = chatInputViewModel$ViewState$Loaded.getThreadDraftState().getAutoArchiveDuration();
        if (autoArchiveDuration == null) {
            autoArchiveDuration = chatInputViewModel$ViewState$Loaded.getChannel().getDefaultAutoArchiveDuration();
        }
        if (autoArchiveDuration != null) {
            return autoArchiveDuration.intValue();
        }
        return 1440;
    }

    private final void handleStoreChatEvent(StoreChat$Event event) {
        if (event instanceof StoreChat$Event$AppendChatText) {
            PublishSubject<ChatInputViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new ChatInputViewModel$Event$AppendChatText(((StoreChat$Event$AppendChatText) event).getText()));
        } else if (event instanceof StoreChat$Event$ReplaceChatText) {
            PublishSubject<ChatInputViewModel$Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(new ChatInputViewModel$Event$SetChatText(((StoreChat$Event$ReplaceChatText) event).getText()));
        }
    }

    @MainThread
    private final void handleStoreState(ChatInputViewModel$StoreState storeState) {
        boolean z2;
        String string;
        CharSequence content;
        ThreadMetadata threadMetadata;
        if (storeState instanceof ChatInputViewModel$StoreState$Loaded) {
            ChatInputViewModel$StoreState$Loaded chatInputViewModel$StoreState$Loaded = (ChatInputViewModel$StoreState$Loaded) storeState;
            boolean zHasAccessWrite = chatInputViewModel$StoreState$Loaded.getSelectedThreadDraft() == null ? PermissionUtils.INSTANCE.hasAccessWrite(chatInputViewModel$StoreState$Loaded.getChannel(), chatInputViewModel$StoreState$Loaded.getChannelPermissions()) : PermissionUtils.can(Permission.SEND_MESSAGES_IN_THREADS, chatInputViewModel$StoreState$Loaded.getChannelPermissions());
            boolean zIsType = ModelUserRelationship.isType(chatInputViewModel$StoreState$Loaded.getRelationshipType(), 2);
            boolean z3 = (zIsType || !zHasAccessWrite || chatInputViewModel$StoreState$Loaded.isLurking() || (ChannelUtils.H(chatInputViewModel$StoreState$Loaded.getChannel()) && (threadMetadata = chatInputViewModel$StoreState$Loaded.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() && !ThreadUtils.INSTANCE.canUnarchiveThread(chatInputViewModel$StoreState$Loaded.getChannel(), chatInputViewModel$StoreState$Loaded.getChannelPermissions()))) ? false : true;
            boolean z4 = chatInputViewModel$StoreState$Loaded.getSelectedThreadDraft() != null;
            if (chatInputViewModel$StoreState$Loaded.getChannel().getType() != 15) {
                z2 = z3;
            } else {
                z2 = z3 && z4 && !chatInputViewModel$StoreState$Loaded.isForumPostCreateInProgress();
            }
            boolean z5 = chatInputViewModel$StoreState$Loaded.getChannel().getType() == 5 && !z2;
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            int maxFileSizeMB = premiumUtils.getMaxFileSizeMB(chatInputViewModel$StoreState$Loaded.getMe());
            Guild guild = chatInputViewModel$StoreState$Loaded.getGuild();
            int iMax = Math.max(premiumUtils.getGuildMaxFileSizeMB(guild != null ? guild.getPremiumTier() : 0), maxFileSizeMB);
            boolean z6 = chatInputViewModel$StoreState$Loaded.getVerificationLevelTriggered() != GuildVerificationLevel.NONE;
            ChatInputViewModel$StoreState$Loaded$PendingReply pendingReply = chatInputViewModel$StoreState$Loaded.getPendingReply();
            ChatInputViewModel$ViewState$Loaded$PendingReplyState chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying = (pendingReply != null ? pendingReply.getRepliedAuthor() : null) != null ? new ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying(chatInputViewModel$StoreState$Loaded.getPendingReply().getPendingReply().getMessageReference(), chatInputViewModel$StoreState$Loaded.getPendingReply().getPendingReply().getShouldMention(), chatInputViewModel$StoreState$Loaded.getPendingReply().getPendingReply().getShowMentionToggle(), chatInputViewModel$StoreState$Loaded.getPendingReply().getRepliedAuthor(), chatInputViewModel$StoreState$Loaded.getPendingReply().getRepliedAuthorGuildMember()) : ChatInputViewModel$ViewState$Loaded$PendingReplyState$Hide.INSTANCE;
            boolean zHasVerificationGate$default = MemberVerificationUtils.hasVerificationGate$default(MemberVerificationUtils.INSTANCE, chatInputViewModel$StoreState$Loaded.getGuild(), null, 2, null);
            boolean z7 = (chatInputViewModel$StoreState$Loaded.getMeGuildMember() == null || chatInputViewModel$StoreState$Loaded.getMeGuildMember().getPending()) ? false : true;
            GuildMember meGuildMember = chatInputViewModel$StoreState$Loaded.getMeGuildMember();
            boolean zIsCommunicationDisabled = meGuildMember != null ? meGuildMember.isCommunicationDisabled() : false;
            boolean z8 = zHasVerificationGate$default && !z7;
            boolean z9 = (ChannelUtils.E(chatInputViewModel$StoreState$Loaded.getChannel()) || chatInputViewModel$StoreState$Loaded.isLurking() || z6 || z5 || z8 || zIsCommunicationDisabled) ? false : true;
            boolean z10 = z2 && chatInputViewModel$StoreState$Loaded.getEditingMessage() != null && chatInputViewModel$StoreState$Loaded.getEditingMessage().getMessage().getChannelId() == chatInputViewModel$StoreState$Loaded.getChannel().getId();
            boolean z11 = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying instanceof ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying;
            boolean zCanCreateThread = ThreadUtils.INSTANCE.canCreateThread(chatInputViewModel$StoreState$Loaded.getChannelPermissions(), chatInputViewModel$StoreState$Loaded.getChannel(), null, chatInputViewModel$StoreState$Loaded.getGuild());
            long jCalculateTimeoutLeftMs = calculateTimeoutLeftMs(chatInputViewModel$StoreState$Loaded.getMeGuildMember());
            Channel channel = chatInputViewModel$StoreState$Loaded.getChannel();
            long id2 = chatInputViewModel$StoreState$Loaded.getChannel().getId();
            MeUser me2 = chatInputViewModel$StoreState$Loaded.getMe();
            GuildMember meGuildMember2 = chatInputViewModel$StoreState$Loaded.getMeGuildMember();
            StoreChat$EditingMessage editingMessage = chatInputViewModel$StoreState$Loaded.getEditingMessage();
            GuildVerificationLevel verificationLevelTriggered = chatInputViewModel$StoreState$Loaded.getVerificationLevelTriggered();
            boolean zIsLurking = chatInputViewModel$StoreState$Loaded.isLurking();
            boolean zE = ChannelUtils.E(chatInputViewModel$StoreState$Loaded.getChannel());
            boolean zIsOnCooldown = chatInputViewModel$StoreState$Loaded.isOnCooldown();
            StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft selectedThreadDraft = chatInputViewModel$StoreState$Loaded.getSelectedThreadDraft();
            GuildJoinRequest guildJoinRequest = chatInputViewModel$StoreState$Loaded.getGuildJoinRequest();
            boolean z12 = zIsCommunicationDisabled;
            ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = new ChatInputViewModel$ViewState$Loaded(channel, id2, me2, meGuildMember2, editingMessage, z2, verificationLevelTriggered, zIsLurking, zE, zIsOnCooldown, iMax, z5, chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying, false, zIsType, z9, z6, z10, z11, z12, jCalculateTimeoutLeftMs, selectedThreadDraft, z8, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, chatInputViewModel$StoreState$Loaded.getThreadDraftState(), zCanCreateThread);
            ChatInputViewModel$ViewState viewState = getViewState();
            if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
                viewState = null;
            }
            ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded2 = (ChatInputViewModel$ViewState$Loaded) viewState;
            boolean z13 = !m.areEqual(chatInputViewModel$ViewState$Loaded2 != null ? chatInputViewModel$ViewState$Loaded2.getEditingMessage() : null, chatInputViewModel$ViewState$Loaded.getEditingMessage());
            ChatInputViewModel$ViewState viewState2 = getViewState();
            if (!(viewState2 instanceof ChatInputViewModel$ViewState$Loaded)) {
                viewState2 = null;
            }
            ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded3 = (ChatInputViewModel$ViewState$Loaded) viewState2;
            boolean z14 = (chatInputViewModel$ViewState$Loaded3 != null ? chatInputViewModel$ViewState$Loaded3.getSelectedThreadDraft() : null) != null && chatInputViewModel$ViewState$Loaded.getSelectedThreadDraft() == null;
            this.useTimeoutUpdateInterval = z12;
            updateViewState(chatInputViewModel$ViewState$Loaded);
            if (z13) {
                StoreChat$EditingMessage editingMessage2 = chatInputViewModel$ViewState$Loaded.getEditingMessage();
                if (editingMessage2 == null || (content = editingMessage2.getContent()) == null || (string = content.toString()) == null) {
                    string = "";
                }
                this.eventSubject.k.onNext(new ChatInputViewModel$Event$SetChatText(string));
            }
            if (z14) {
                this.eventSubject.k.onNext(ChatInputViewModel$Event$ThreadDraftClosed.INSTANCE);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendCommand$default(ChatInputViewModel chatInputViewModel, Context context, MessageManager messageManager, ApplicationCommandData applicationCommandData, Map map, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
        chatInputViewModel.sendCommand(context, messageManager, applicationCommandData, map, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? ChatInputViewModel$sendCommand$1.INSTANCE : function1);
    }

    public static /* synthetic */ void sendMessage$default(ChatInputViewModel chatInputViewModel, Context context, MessageManager messageManager, MessageContent messageContent, List list, boolean z2, Function1 function1, int i, Object obj) {
        chatInputViewModel.sendMessage(context, messageManager, messageContent, list, (i & 16) != 0 ? false : z2, function1);
    }

    public final void deleteEditingMessage() {
        this.storeChat.setEditingMessage(null);
    }

    public final void deletePendingReply() {
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded != null) {
            this.storePendingReplies.onDeletePendingReply(chatInputViewModel$ViewState$Loaded.getChannelId());
        }
    }

    public final boolean handleEmojiAutocompleteUpsellClicked(Autocompletable item) {
        m.checkNotNullParameter(item, "item");
        if (!this.isEmojiAutocompleteUpsellEnabled || !(item instanceof EmojiUpsellPlaceholder)) {
            return false;
        }
        PublishSubject<ChatInputViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new ChatInputViewModel$Event$ShowPremiumUpsell(1, 2131886949, 2131886948, false, false, 24, null));
        this.storeAnalytics.emojiAutocompleteUpsellModalViewed();
        return true;
    }

    public final void jumpToMessageReference(MessageReference messageReference) {
        m.checkNotNullParameter(messageReference, "messageReference");
        StoreMessagesLoader storeMessagesLoader = this.storeMessagesLoader;
        Long channelId = messageReference.getChannelId();
        m.checkNotNull(channelId);
        long jLongValue = channelId.longValue();
        Long messageId = messageReference.getMessageId();
        m.checkNotNull(messageId);
        storeMessagesLoader.jumpToMessage(jLongValue, messageId.longValue());
    }

    public final void lurkGuild(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded != null) {
            StoreLurking storeLurking = this.storeLurking;
            long guildId = chatInputViewModel$ViewState$Loaded.getChannel().getGuildId();
            Context contextRequireContext = fragment.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
            storeLurking.postJoinGuildAsMember(guildId, contextRequireContext);
        }
    }

    public final Observable<ChatInputViewModel$ViewState> observeChatInputViewState() {
        Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableE, "Observable.interval(0L, 1L, TimeUnit.SECONDS)");
        Observable<ChatInputViewModel$ViewState> observableJ = Observable.j(ObservableExtensionsKt.ui(observableE).G(new ChatInputViewModel$observeChatInputViewState$1(this)).r(), observeViewState(), new ChatInputViewModel$observeChatInputViewState$2(this));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…     } ?: viewState\n    }");
        return observableJ;
    }

    public final Observable<ChatInputViewModel$Event> observeEvents() {
        return this.eventSubject;
    }

    public final void onCommandInputsInvalid() {
        PublishSubject<ChatInputViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(ChatInputViewModel$Event$CommandInputsInvalid.INSTANCE);
    }

    public final void onCommandUsed(ApplicationCommandData applicationCommandData) {
        m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded != null) {
            this.storeApplicationCommandsFrecency.onCommandUsed(chatInputViewModel$ViewState$Loaded.getChannel().getGuildId() != 0 ? Long.valueOf(chatInputViewModel$ViewState$Loaded.getChannel().getGuildId()) : null, ApplicationCommandDataKt.getCommandId(applicationCommandData));
        }
    }

    public final void sendCommand(Context context, MessageManager messageManager, ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> attachments, boolean autocomplete, boolean compressedImages, Function1<? super Boolean, Unit> onValidationResult) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        m.checkNotNullParameter(attachments, "attachments");
        m.checkNotNullParameter(onValidationResult, "onValidationResult");
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded == null) {
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        ChatInputViewModel$AttachmentContext attachmentContext = toAttachmentContext(u.toList(attachments.values()), context);
        ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 chatInputViewModel$sendCommand$commandResendCompressedHandler$1 = (compressedImages || !attachmentContext.getHasImage()) ? null : new ChatInputViewModel$sendCommand$commandResendCompressedHandler$1(this, context, attachmentContext, attachments, messageManager, applicationCommandData, autocomplete);
        if (!applicationCommandData.getValidInputs() && !autocomplete) {
            onCommandInputsInvalid();
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        Long lValueOf = chatInputViewModel$ViewState$Loaded.getChannel().getGuildId() != 0 ? Long.valueOf(chatInputViewModel$ViewState$Loaded.getChannel().getGuildId()) : null;
        if (autocomplete) {
            this.storeApplicationCommands.requestApplicationCommandAutocompleteData(lValueOf, chatInputViewModel$ViewState$Loaded.getChannelId(), applicationCommandData);
            onValidationResult.invoke(Boolean.TRUE);
        } else if (chatInputViewModel$sendCommand$commandResendCompressedHandler$1 != null && this.storeUserSettings.getIsAutoImageCompressionEnabled()) {
            chatInputViewModel$sendCommand$commandResendCompressedHandler$1.invoke();
        } else {
            onCommandUsed(applicationCommandData);
            onValidationResult.invoke(Boolean.valueOf(messageManager.sendCommand(chatInputViewModel$ViewState$Loaded.getChannelId(), lValueOf, applicationCommandData.getApplicationCommand().getVersion(), applicationCommandData, new MessageManager$AttachmentsRequest(attachmentContext.getCurrentFileSizeMB(), chatInputViewModel$ViewState$Loaded.getMaxFileSizeMB(), attachmentContext.getAttachments()), ChatInputViewModel$sendCommand$validated$1.INSTANCE, ChatInputViewModel$sendCommand$validated$2.INSTANCE, new ChatInputViewModel$sendCommand$validated$3(this, attachmentContext, chatInputViewModel$sendCommand$commandResendCompressedHandler$1))));
        }
    }

    public final void sendMessage(Context context, MessageManager messageManager, MessageContent messageContent, List<? extends Attachment<?>> attachmentsRaw, boolean compressedImages, Function1<? super Boolean, Unit> onValidationResult) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(messageContent, "messageContent");
        m.checkNotNullParameter(attachmentsRaw, "attachmentsRaw");
        m.checkNotNullParameter(onValidationResult, "onValidationResult");
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded == null) {
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        ChatInputViewModel$AttachmentContext attachmentContext = toAttachmentContext(attachmentsRaw, context);
        boolean z2 = true;
        boolean z3 = chatInputViewModel$ViewState$Loaded.getSelectedThreadDraft() != null;
        ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 chatInputViewModel$sendMessage$messageResendCompressedHandler$1 = (compressedImages || !attachmentContext.getHasImage()) ? null : new ChatInputViewModel$sendMessage$messageResendCompressedHandler$1(this, context, attachmentContext, messageManager, messageContent, onValidationResult);
        ChatInputViewModel$sendMessage$messageSendResultHandler$1 chatInputViewModel$sendMessage$messageSendResultHandler$1 = new ChatInputViewModel$sendMessage$messageSendResultHandler$1(this, context, chatInputViewModel$ViewState$Loaded, attachmentContext, chatInputViewModel$sendMessage$messageResendCompressedHandler$1, z3);
        ChatInputViewModel$sendMessage$onMessageTooLong$1 chatInputViewModel$sendMessage$onMessageTooLong$1 = new ChatInputViewModel$sendMessage$onMessageTooLong$1(this);
        ChatInputViewModel$sendMessage$onFilesTooLarge$1 chatInputViewModel$sendMessage$onFilesTooLarge$1 = new ChatInputViewModel$sendMessage$onFilesTooLarge$1(this, attachmentContext, chatInputViewModel$sendMessage$messageResendCompressedHandler$1);
        if (chatInputViewModel$sendMessage$messageResendCompressedHandler$1 != null && this.storeUserSettings.getIsAutoImageCompressionEnabled()) {
            chatInputViewModel$sendMessage$messageResendCompressedHandler$1.invoke();
            return;
        }
        MessageManager$AttachmentsRequest messageManager$AttachmentsRequest = new MessageManager$AttachmentsRequest(attachmentContext.getCurrentFileSizeMB(), chatInputViewModel$ViewState$Loaded.getMaxFileSizeMB(), attachmentContext.getAttachments());
        ChatInputViewModel$sendMessage$sendMessage$1 chatInputViewModel$sendMessage$sendMessage$1 = new ChatInputViewModel$sendMessage$sendMessage$1(messageManager, messageContent, messageManager$AttachmentsRequest, chatInputViewModel$sendMessage$messageSendResultHandler$1, chatInputViewModel$sendMessage$onMessageTooLong$1, chatInputViewModel$sendMessage$onFilesTooLarge$1, onValidationResult);
        boolean zQ = ChannelUtils.q(chatInputViewModel$ViewState$Loaded.getChannel());
        boolean zCanAccessRedesignedForumChannels$default = ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, chatInputViewModel$ViewState$Loaded.getChannel().getGuildId(), null, 2, null);
        if (chatInputViewModel$ViewState$Loaded.isEditing() && chatInputViewModel$ViewState$Loaded.getEditingMessage() != null) {
            Message message = chatInputViewModel$ViewState$Loaded.getEditingMessage().getMessage();
            long id2 = message.getId();
            long channelId = message.getChannelId();
            String textContent = messageContent.getTextContent();
            String content = message.getContent();
            onValidationResult.invoke(Boolean.valueOf(messageManager.editMessage(id2, channelId, textContent, chatInputViewModel$sendMessage$onMessageTooLong$1, Integer.valueOf(content != null ? content.length() : 0))));
            return;
        }
        if (z3 && zQ && zCanAccessRedesignedForumChannels$default) {
            createForumPostWithMessage(context, chatInputViewModel$ViewState$Loaded.getChannelId(), messageManager, messageContent, messageManager$AttachmentsRequest, chatInputViewModel$sendMessage$onMessageTooLong$1, chatInputViewModel$sendMessage$onFilesTooLarge$1);
            return;
        }
        if (!z3) {
            chatInputViewModel$sendMessage$sendMessage$1.invoke(Long.valueOf(chatInputViewModel$ViewState$Loaded.getChannelId()));
            return;
        }
        String threadName = chatInputViewModel$ViewState$Loaded.getThreadDraftState().getThreadName();
        if (threadName != null && threadName.length() != 0) {
            z2 = false;
        }
        if (z2) {
            StoreStream.Companion.getThreadDraft().setDraftState(StoreThreadDraft$ThreadDraftState.copy$default(chatInputViewModel$ViewState$Loaded.getThreadDraftState(), false, null, null, false, true, 15, null));
            return;
        }
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft selectedThreadDraft = chatInputViewModel$ViewState$Loaded.getSelectedThreadDraft();
        Long starterMessageId = selectedThreadDraft != null ? selectedThreadDraft.getStarterMessageId() : null;
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft selectedThreadDraft2 = chatInputViewModel$ViewState$Loaded.getSelectedThreadDraft();
        createAndGotoThread(context, starterMessageId, selectedThreadDraft2 != null ? selectedThreadDraft2.getThreadStartLocation() : null, chatInputViewModel$ViewState$Loaded, new ChatInputViewModel$sendMessage$1(chatInputViewModel$sendMessage$sendMessage$1));
    }

    public final void sendSticker(Sticker sticker, MessageManager messageManager) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(messageManager, "messageManager");
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded == null || !chatInputViewModel$ViewState$Loaded.getAbleToSendMessage()) {
            return;
        }
        this.storeStickers.onStickerUsed(sticker);
        MessageManager.sendMessage$default(messageManager, null, null, null, null, d0.t.m.listOf(sticker), false, null, null, null, 495, null);
    }

    public final ChatInputViewModel$AttachmentContext toAttachmentContext(List<? extends Attachment<?>> list, Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        m.checkNotNullParameter(list, "$this$toAttachmentContext");
        m.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList(list);
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                Attachment attachment = (Attachment) it.next();
                m.checkNotNullExpressionValue(attachment, "attachment");
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
                m.checkNotNullExpressionValue(attachment2, "attachment");
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
                m.checkNotNullExpressionValue(attachment3, "attachment");
                if (AttachmentUtilsKt.isGif(attachment3, context.getContentResolver())) {
                    z4 = true;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            Uri uri = ((Attachment) it4.next()).getUri();
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            arrayList2.add(Float.valueOf(SendUtilsKt.computeFileSizeMegabytes(uri, contentResolver)));
        }
        float fSumOfFloat = u.sumOfFloat(arrayList2);
        Float fM111maxOrNull = u.m111maxOrNull((Iterable<Float>) arrayList2);
        return new ChatInputViewModel$AttachmentContext(arrayList, z2, z3, z4, arrayList2, fSumOfFloat, fM111maxOrNull != null ? fM111maxOrNull.floatValue() : 0.0f);
    }

    public final void togglePendingReplyShouldMention() {
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded != null) {
            ChatInputViewModel$ViewState$Loaded$PendingReplyState pendingReplyState = chatInputViewModel$ViewState$Loaded.getPendingReplyState();
            ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying = (ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying) (pendingReplyState instanceof ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying ? pendingReplyState : null);
            if (chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying != null) {
                StorePendingReplies storePendingReplies = this.storePendingReplies;
                Long channelId = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.getMessageReference().getChannelId();
                m.checkNotNull(channelId);
                storePendingReplies.onSetPendingReplyShouldMention(channelId.longValue(), !chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.getShouldMention());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    public final void verifyAccount(Context context) {
        Unit unit;
        m.checkNotNullParameter(context, "context");
        ChatInputViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ChatInputViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) viewState;
        if (chatInputViewModel$ViewState$Loaded != null) {
            int iOrdinal = chatInputViewModel$ViewState$Loaded.getVerificationLevelTriggered().ordinal();
            if (iOrdinal == 0) {
                unit = Unit.a;
            } else if (iOrdinal == 1) {
                WidgetUserEmailVerify.Companion.launch(context, WidgetUserAccountVerifyBase$Mode.UNFORCED);
                unit = Unit.a;
            } else if (iOrdinal == 2 || iOrdinal == 3) {
                unit = Unit.a;
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                WidgetUserPhoneManage.Companion.launch(context, WidgetUserAccountVerifyBase$Mode.UNFORCED, WidgetUserPhoneManage$Companion$Source.GUILD_PHONE_REQUIRED);
                unit = Unit.a;
            }
            KotlinExtensionsKt.getExhaustive(unit);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel(StoreChat storeChat, StoreChannels storeChannels, StoreMessagesLoader storeMessagesLoader, StoreLurking storeLurking, StoreStickers storeStickers, StorePendingReplies storePendingReplies, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreUserSettings storeUserSettings, StoreAnalytics storeAnalytics, StoreThreadDraft storeThreadDraft, StoreGuilds storeGuilds, boolean z2, Observable<ChatInputViewModel$StoreState> observable) {
        super(ChatInputViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storeChat, "storeChat");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeMessagesLoader, "storeMessagesLoader");
        m.checkNotNullParameter(storeLurking, "storeLurking");
        m.checkNotNullParameter(storeStickers, "storeStickers");
        m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        m.checkNotNullParameter(storeApplicationInteractions, "storeApplicationInteractions");
        m.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        m.checkNotNullParameter(storeApplicationCommandFrecency, "storeApplicationCommandsFrecency");
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeThreadDraft, "storeThreadDraft");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observable, "storeStateObservable");
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
        PublishSubject<ChatInputViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ChatInputViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChatInputViewModel$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeChat.observeEvents(), this, null, 2, null), ChatInputViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChatInputViewModel$2(this), 62, (Object) null);
    }
}
