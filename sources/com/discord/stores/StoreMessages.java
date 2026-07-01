package com.discord.stores;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.message.LocalAttachment;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreatorsKt;
import com.discord.utilities.messagesend.MessageQueue;
import com.discord.utilities.messagesend.MessageRequest;
import com.discord.utilities.messagesend.MessageRequest$Edit;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.ProcessedMessageContent;
import com.discord.utilities.rest.ProcessedMessageContent$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.lytefast.flexinput.model.Attachment;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.l.a.q;
import j0.l.a.r;
import j0.l.a.x0$a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.objectweb.asm.Opcodes;
import rx.Emitter;
import rx.Emitter$BackpressureMode;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages extends Store {
    private static final long BACKGROUND_SENDING_DELAY_MS = 120000;
    public static final StoreMessages$Companion Companion = new StoreMessages$Companion(null);
    private final Clock clock;
    private Context context;
    private final Dispatcher dispatcher;
    private final StoreMessagesHolder holder;
    private final BehaviorSubject<Boolean> initResendFinished;
    private final StoreLocalMessagesHolder localMessagesHolder;
    private final HashMap<Long, MessageQueue> messageQueues;
    private final ExecutorService queueExecutor;
    private final StoreStream stream;

    public StoreMessages(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.holder = new StoreMessagesHolder();
        this.localMessagesHolder = new StoreLocalMessagesHolder();
        this.queueExecutor = Executors.newSingleThreadExecutor();
        this.messageQueues = new HashMap<>();
        this.initResendFinished = BehaviorSubject.l0(Boolean.FALSE);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreMessages storeMessages) {
        return storeMessages.clock;
    }

    public static final /* synthetic */ Context access$getContext$p(StoreMessages storeMessages) {
        Context context = storeMessages.context;
        if (context == null) {
            m.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessages storeMessages) {
        return storeMessages.dispatcher;
    }

    public static final /* synthetic */ BehaviorSubject access$getInitResendFinished$p(StoreMessages storeMessages) {
        return storeMessages.initResendFinished;
    }

    public static final /* synthetic */ MessageQueue access$getOrCreateMessageQueue(StoreMessages storeMessages, long j) {
        return storeMessages.getOrCreateMessageQueue(j);
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessages storeMessages) {
        return storeMessages.stream;
    }

    public static final /* synthetic */ void access$handleLocalMessageCreate(StoreMessages storeMessages, Message message) {
        storeMessages.handleLocalMessageCreate(message);
    }

    public static final /* synthetic */ void access$handleLocalMessageDelete(StoreMessages storeMessages, Message message) {
        storeMessages.handleLocalMessageDelete(message);
    }

    public static final /* synthetic */ void access$handleSendMessageCaptchaRequired(StoreMessages storeMessages, Message message) {
        storeMessages.handleSendMessageCaptchaRequired(message);
    }

    public static final /* synthetic */ void access$handleSendMessageFailure(StoreMessages storeMessages, Message message) {
        storeMessages.handleSendMessageFailure(message);
    }

    public static final /* synthetic */ void access$handleSendMessageFailureAutoMod(StoreMessages storeMessages, Message message, UtcDateTime utcDateTime) {
        storeMessages.handleSendMessageFailureAutoMod(message, utcDateTime);
    }

    public static final /* synthetic */ void access$handleSendMessageValidationError(StoreMessages storeMessages, Message message, String str) {
        storeMessages.handleSendMessageValidationError(message, str);
    }

    public static final /* synthetic */ void access$setContext$p(StoreMessages storeMessages, Context context) {
        storeMessages.context = context;
    }

    public static final /* synthetic */ void access$trackFailedLocalMessageResolved(StoreMessages storeMessages, Message message, FailedMessageResolutionType failedMessageResolutionType) {
        storeMessages.trackFailedLocalMessageResolved(message, failedMessageResolutionType);
    }

    private final Observable<MessageResult> enqueueRequest(long channelId, Function1<? super Emitter<MessageResult>, ? extends MessageRequest> createRequest) {
        Observable<MessageResult> observableX = Observable.o(new StoreMessages$enqueueRequest$1(this, channelId, createRequest), Emitter$BackpressureMode.ERROR).X(this.dispatcher.getScheduler());
        m.checkNotNullExpressionValue(observableX, "Observable.create<Messag…eOn(dispatcher.scheduler)");
        return observableX;
    }

    @StoreThread
    private final MessageQueue getOrCreateMessageQueue(long channelId) {
        MessageQueue messageQueue = this.messageQueues.get(Long.valueOf(channelId));
        if (messageQueue == null) {
            Context context = this.context;
            if (context == null) {
                m.throwUninitializedPropertyAccessException("context");
            }
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            ExecutorService executorService = this.queueExecutor;
            m.checkNotNullExpressionValue(executorService, "queueExecutor");
            messageQueue = new MessageQueue(contentResolver, executorService, this.clock);
            this.messageQueues.put(Long.valueOf(channelId), messageQueue);
        }
        return messageQueue;
    }

    @StoreThread
    private final void handleInteractionStateUpdate(InteractionStateUpdate interactionUpdate, boolean isFailed, boolean isLoading) {
        Message message;
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().getApplicationCommandLocalSendDataSet$app_productionGoogleRelease().get(interactionUpdate.getNonce());
        if (applicationCommandLocalSendData == null || (message = this.localMessagesHolder.getMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString())) == null) {
            return;
        }
        this.localMessagesHolder.addMessage(LocalMessageCreatorsKt.createLocalApplicationCommandMessage(message, interactionUpdate.getId(), isFailed, isLoading, this.clock));
    }

    public static /* synthetic */ void handleInteractionStateUpdate$default(StoreMessages storeMessages, InteractionStateUpdate interactionStateUpdate, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        storeMessages.handleInteractionStateUpdate(interactionStateUpdate, z2, z3);
    }

    @StoreThread
    private final void handleLocalMessageCreate(Message message) {
        this.localMessagesHolder.addMessage(message);
    }

    @StoreThread
    private final void handleLocalMessageDelete(Message localMessage) {
        this.localMessagesHolder.deleteMessage(localMessage);
    }

    @StoreThread
    private final void handleSendMessageCaptchaRequired(Message localMessage) {
        this.localMessagesHolder.addMessage(Message.copy$default(localMessage, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -131073, Opcodes.LAND, null));
    }

    @StoreThread
    private final void handleSendMessageFailure(Message localMessage) {
        deleteMessage(localMessage);
        String content = localMessage.getContent();
        if (content == null) {
            content = "";
        }
        String str = content;
        long channelId = localMessage.getChannelId();
        User author = localMessage.getAuthor();
        m.checkNotNull(author);
        handleLocalMessageCreate(LocalMessageCreatorsKt.createLocalMessage$default(str, channelId, author, localMessage.getMentions(), true, localMessage.getHasLocalUploads(), localMessage.getApplication(), localMessage.getActivity(), this.clock, localMessage.getLocalAttachments(), localMessage.getLastManualAttemptTimestamp(), localMessage.getInitialAttemptTimestamp(), localMessage.getNumRetries(), localMessage.getStickers(), localMessage.getMessageReference(), localMessage.getAllowedMentions(), null, 65536, null));
    }

    @StoreThread
    private final void handleSendMessageFailureAutoMod(Message localMessage, UtcDateTime editedTimestamp) {
        handleLocalMessageCreate(Message.copy$default(localMessage, 0L, 0L, null, null, null, null, editedTimestamp, null, null, null, null, null, null, null, null, null, null, -8, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -131137, Opcodes.LAND, null));
    }

    public static /* synthetic */ void handleSendMessageFailureAutoMod$default(StoreMessages storeMessages, Message message, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 2) != 0) {
            utcDateTime = null;
        }
        storeMessages.handleSendMessageFailureAutoMod(message, utcDateTime);
    }

    private final void handleSendMessageValidationError(Message localMessage, String errorMessage) {
        Logger.e$default(AppLog.g, "ValidationError", errorMessage, null, null, 12, null);
        deleteMessage(localMessage);
    }

    @StoreThread
    private final void markLocalCaptchaRequiredMessagesFailed() {
        List<Message> flattenedMessages = this.localMessagesHolder.getFlattenedMessages();
        ArrayList<Message> arrayList = new ArrayList();
        for (Object obj : flattenedMessages) {
            Integer type = ((Message) obj).getType();
            if (type != null && type.intValue() == -6) {
                arrayList.add(obj);
            }
        }
        for (Message message : arrayList) {
            markMessageFailed(message.getChannelId(), message.getNonce());
        }
    }

    private final Observable<List<Message>> observeLocalMessagesForChannel(long channelId) {
        Observable<R> observableG = this.localMessagesHolder.getMessagesPublisher().G(new StoreMessages$observeLocalMessagesForChannel$1(channelId));
        m.checkNotNullExpressionValue(observableG, "localMessagesHolder\n    …annelId] ?: emptyList() }");
        Observable<List<Message>> observableS = ObservableExtensionsKt.computationBuffered(observableG).s(StoreMessages$observeLocalMessagesForChannel$2.INSTANCE);
        m.checkNotNullExpressionValue(observableS, "localMessagesHolder\n    …messages1 === messages2 }");
        return observableS;
    }

    private final Observable<List<Message>> observeSyncedMessagesForChannel(long channelId) {
        Observable<R> observableG = this.holder.getMessagesPublisher().G(new StoreMessages$observeSyncedMessagesForChannel$1(channelId));
        m.checkNotNullExpressionValue(observableG, "holder\n          .messag…annelId] ?: emptyList() }");
        Observable<List<Message>> observableS = ObservableExtensionsKt.computationBuffered(observableG).s(StoreMessages$observeSyncedMessagesForChannel$2.INSTANCE);
        m.checkNotNullExpressionValue(observableS, "holder\n          .messag…messages1 === messages2 }");
        return observableS;
    }

    @StoreThread
    private final void resendAllLocalMessages() {
        List<Message> flattenedMessages = this.localMessagesHolder.getFlattenedMessages();
        ArrayList arrayList = new ArrayList();
        for (Object obj : flattenedMessages) {
            Integer type = ((Message) obj).getType();
            if (type != null && type.intValue() == -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(resendMessage$default(this, (Message) it.next(), true, null, 4, null));
        }
        Observable observableH0 = Observable.h0(new r(Observable.h0(new q(arrayList2)).j, x0$a.a));
        m.checkNotNullExpressionValue(observableH0, "Observable\n        .mergeDelayError(observables)");
        ObservableExtensionsKt.appSubscribe$default(observableH0, StoreMessages.class, (Context) null, (Function1) null, (Function1) null, new StoreMessages$resendAllLocalMessages$1(this), (Function0) null, StoreMessages$resendAllLocalMessages$2.INSTANCE, 46, (Object) null);
    }

    public static /* synthetic */ Observable resendMessage$default(StoreMessages storeMessages, Message message, boolean z2, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        return storeMessages.resendMessage(message, z2, captchaHelper$CaptchaPayload);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable sendMessage$default(StoreMessages storeMessages, long j, com.discord.models.user.User user, String str, List list, List list2, List list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long l, Long l2, Integer num, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        return storeMessages.sendMessage(j, user, str, list, list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : messageReference, (i & 128) != 0 ? null : messageAllowedMentions, (i & 256) != 0 ? null : application, (i & 512) != 0 ? null : activity, (i & 1024) != 0 ? null : messageActivity, (i & 2048) != 0 ? null : l, (i & 4096) != 0 ? null : l2, (i & 8192) != 0 ? null : num, (i & 16384) != 0 ? null : captchaHelper$CaptchaPayload);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    private final void trackFailedLocalMessageResolved(Message localMessage, FailedMessageResolutionType failedMessageResolutionType) {
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        Long l;
        boolean z4;
        boolean z5;
        List<LocalAttachment> localAttachments = localMessage.getLocalAttachments();
        if (localAttachments == null) {
            z2 = false;
        } else {
            if (!localAttachments.isEmpty()) {
                Iterator<T> it = localAttachments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z5 = false;
                        break;
                    }
                    LocalAttachment localAttachment = (LocalAttachment) it.next();
                    Context context = this.context;
                    if (context == null) {
                        m.throwUninitializedPropertyAccessException("context");
                    }
                    ContentResolver contentResolver = context.getContentResolver();
                    m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                    if (AttachmentUtilsKt.isImageAttachment(localAttachment, contentResolver)) {
                        z5 = true;
                        break;
                    }
                }
            } else {
                z5 = false;
                break;
            }
            if (z5) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        List<LocalAttachment> localAttachments2 = localMessage.getLocalAttachments();
        if (localAttachments2 == null) {
            z3 = false;
        } else {
            if (!localAttachments2.isEmpty()) {
                Iterator<T> it2 = localAttachments2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z4 = false;
                        break;
                    }
                    LocalAttachment localAttachment2 = (LocalAttachment) it2.next();
                    Context context2 = this.context;
                    if (context2 == null) {
                        m.throwUninitializedPropertyAccessException("context");
                    }
                    ContentResolver contentResolver2 = context2.getContentResolver();
                    m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                    if (AttachmentUtilsKt.isVideoAttachment(localAttachment2, contentResolver2)) {
                        z4 = true;
                        break;
                    }
                }
            } else {
                z4 = false;
                break;
            }
            if (z4) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        List<LocalAttachment> localAttachments3 = localMessage.getLocalAttachments();
        if (localAttachments3 != null) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(localAttachments3, 10));
            Iterator<T> it3 = localAttachments3.iterator();
            while (it3.hasNext()) {
                Uri uri = Uri.parse(((LocalAttachment) it3.next()).getUriString());
                m.checkNotNullExpressionValue(uri, "Uri.parse(localAttachment.uriString)");
                Context context3 = this.context;
                if (context3 == null) {
                    m.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver3 = context3.getContentResolver();
                m.checkNotNullExpressionValue(contentResolver3, "context.contentResolver");
                arrayList.add(Long.valueOf(SendUtilsKt.computeFileSizeBytes(uri, contentResolver3)));
            }
        } else {
            arrayList = null;
        }
        int iLongValue = (arrayList == null || (l = (Long) u.maxOrNull((Iterable) arrayList)) == null) ? 0 : (int) l.longValue();
        int iSumOfLong = arrayList != null ? (int) u.sumOfLong(arrayList) : 0;
        StoreAnalytics analytics = StoreStream.Companion.getAnalytics();
        List<LocalAttachment> localAttachments4 = localMessage.getLocalAttachments();
        int size = localAttachments4 != null ? localAttachments4.size() : 0;
        Long initialAttemptTimestamp = localMessage.getInitialAttemptTimestamp();
        long jLongValue = initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : 0L;
        Integer numRetries = localMessage.getNumRetries();
        analytics.trackFailedMessageResolved(size, iLongValue, iSumOfLong, z2, z3, failedMessageResolutionType, jLongValue, numRetries != null ? numRetries.intValue() : 0, localMessage.getChannelId());
    }

    public final void cancelMessageSend(long channelId, String requestId) {
        m.checkNotNullParameter(requestId, "requestId");
        getOrCreateMessageQueue(channelId).cancel(requestId);
    }

    @StoreThread
    public final void deleteLocalMessage(long channelId, String nonce) {
        m.checkNotNullParameter(nonce, "nonce");
        getOrCreateMessageQueue(channelId).cancel(nonce);
        handleLocalMessageDelete(channelId, nonce);
    }

    public final void deleteMessage(Message message) {
        if (message == null) {
            return;
        }
        long id2 = message.getId();
        long channelId = message.getChannelId();
        if (message.isLocal() || message.isEphemeralMessage()) {
            this.dispatcher.schedule(new StoreMessages$deleteMessage$2(this, message, channelId, id2));
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteMessage(channelId, id2), false, 1, null), (Context) null, "deleteMessage", (Function1) null, StoreMessages$deleteMessage$1.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }
    }

    public final void editMessage(long messageId, long channelId, String content, MessageAllowedMentions allowedMentions) {
        m.checkNotNullParameter(content, "content");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        getOrCreateMessageQueue(channelId).enqueue(new MessageRequest$Edit(channelId, content, messageId, allowedMentions, jCurrentTimeMillis, new StoreMessages$editMessage$1(this, channelId, messageId, content, jCurrentTimeMillis, allowedMentions)));
    }

    public final Observable<Set<Long>> getAllDetached() {
        Observable<Set<Long>> detachedChannelsSubject = this.holder.getDetachedChannelsSubject();
        m.checkNotNullExpressionValue(detachedChannelsSubject, "holder\n          .detachedChannelsSubject");
        return ObservableExtensionsKt.computationLatest(detachedChannelsSubject);
    }

    @StoreThread
    public final Message getMessage(long channelId, long messageId) {
        TreeMap<Long, Message> messagesForChannel = this.holder.getMessagesForChannel(Long.valueOf(channelId));
        if (messagesForChannel != null) {
            return messagesForChannel.get(Long.valueOf(messageId));
        }
        return null;
    }

    public final void handleChannelSelected(long channelId) {
        this.holder.setSelectedChannelId(channelId);
    }

    @StoreThread
    public final void handleConnected(boolean connected) {
        if (!connected) {
            this.holder.invalidate();
            return;
        }
        Collection<MessageQueue> collectionValues = this.messageQueues.values();
        m.checkNotNullExpressionValue(collectionValues, "messageQueues.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((MessageQueue) it.next()).handleConnected();
        }
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.holder.setMyUserId(payload.getMe().getId());
    }

    @StoreThread
    public final void handleInteractionCreate(InteractionStateUpdate interactionUpdate) {
        m.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, false, true, 2, null);
    }

    @StoreThread
    public final void handleInteractionFailure(InteractionStateUpdate interactionUpdate) {
        m.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, true, false, 4, null);
    }

    @StoreThread
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        m.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().getApplicationCommandLocalSendDataSet$app_productionGoogleRelease().get(interactionModalCreate.getNonce());
        if (applicationCommandLocalSendData != null) {
            this.localMessagesHolder.deleteMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString());
        }
    }

    public final void handleMessageCreate(List<com.discord.api.message.Message> messagesList) {
        m.checkNotNullParameter(messagesList, "messagesList");
        for (com.discord.api.message.Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce != null) {
                this.localMessagesHolder.deleteMessage(message.getChannelId(), nonce);
            }
        }
        StoreMessagesHolder storeMessagesHolder = this.holder;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(messagesList, 10));
        Iterator<T> it = messagesList.iterator();
        while (it.hasNext()) {
            arrayList.add(new Message((com.discord.api.message.Message) it.next()));
        }
        storeMessagesHolder.addMessages(arrayList);
    }

    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        m.checkNotNullParameter(messageDelete, "messageDelete");
        long channelId = messageDelete.getChannelId();
        List<Long> messageIds = messageDelete.getMessageIds();
        m.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        handleMessageDelete(channelId, messageIds);
    }

    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        this.holder.updateMessages(message);
    }

    public final void handleMessagesLoaded(StoreMessagesLoader$ChannelChunk chunk) {
        m.checkNotNullParameter(chunk, "chunk");
        this.holder.loadMessageChunks(d0.t.m.listOf(chunk));
    }

    public final void handlePreLogout() {
        this.localMessagesHolder.clearCache();
    }

    public final void handleReactionUpdate(List<MessageReactionUpdate> updates, boolean add) {
        m.checkNotNullParameter(updates, "updates");
        this.holder.updateReactions(updates, add);
    }

    public final void handleReactionsRemoveAll(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        this.holder.removeAllReactions(update);
    }

    public final void handleReactionsRemoveEmoji(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        this.holder.removeEmojiReactions(update);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.context = context;
        this.holder.init(true);
        StoreLocalMessagesHolder.init$default(this.localMessagesHolder, false, 1, null);
        markLocalCaptchaRequiredMessagesFailed();
        resendAllLocalMessages();
    }

    public final void markMessageFailed(long channelId, String nonce) {
        Message message;
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        this.dispatcher.schedule(new StoreMessages$markMessageFailed$1(this, message));
    }

    public final BehaviorSubject<Boolean> observeInitResendFinished() {
        BehaviorSubject<Boolean> behaviorSubject = this.initResendFinished;
        m.checkNotNullExpressionValue(behaviorSubject, "initResendFinished");
        return behaviorSubject;
    }

    public final Observable<Boolean> observeIsDetached(long channelId) {
        Observable<Boolean> observableR = getAllDetached().G(new StoreMessages$observeIsDetached$1(channelId)).r();
        m.checkNotNullExpressionValue(observableR, "allDetached\n          .m…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Message>> observeMessagesForChannel(long channelId) {
        Observable<List<Message>> observableI = Observable.i(observeSyncedMessagesForChannel(channelId), observeLocalMessagesForChannel(channelId), observeIsDetached(channelId), StoreMessages$observeMessagesForChannel$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ges + localMessages\n    }");
        return observableI;
    }

    public final Observable<MessageResult> resendMessage(Message message, boolean isAutoAttempt, CaptchaHelper$CaptchaPayload captchaPayload) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Integer type;
        Integer type2;
        Integer type3;
        m.checkNotNullParameter(message, "message");
        if ((isAutoAttempt && (((type2 = message.getType()) == null || type2.intValue() != -1) && ((type3 = message.getType()) == null || type3.intValue() != -6))) || (!isAutoAttempt && ((type = message.getType()) == null || type.intValue() != -2))) {
            throw new IllegalArgumentException("Incorrect " + isAutoAttempt + " auto attempt and message type " + message.getType());
        }
        this.dispatcher.schedule(new StoreMessages$resendMessage$1(this, message));
        Integer numRetries = message.getNumRetries();
        int iIntValue = numRetries != null ? numRetries.intValue() : 0;
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        m.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        String content = message.getContent();
        if (content == null) {
            content = "";
        }
        List<User> mentions = message.getMentions();
        if (mentions != null) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it = mentions.iterator();
            while (it.hasNext()) {
                arrayList.add(new CoreUser((User) it.next()));
            }
        } else {
            arrayList = null;
        }
        List<LocalAttachment> localAttachments = message.getLocalAttachments();
        if (localAttachments != null) {
            arrayList2 = new ArrayList(o.collectionSizeOrDefault(localAttachments, 10));
            for (LocalAttachment localAttachment : localAttachments) {
                Uri uri = Uri.parse(localAttachment.getUriString());
                long id2 = localAttachment.getId();
                m.checkNotNullExpressionValue(uri, "contentUri");
                arrayList2.add(new Attachment(id2, uri, localAttachment.getDisplayName(), null, false, 16, null));
            }
        } else {
            arrayList2 = null;
        }
        return sendMessage$default(this, channelId, coreUser, content, arrayList, arrayList2, null, message.getMessageReference(), message.getAllowedMentions(), null, null, null, isAutoAttempt ? message.getLastManualAttemptTimestamp() : null, message.getInitialAttemptTimestamp(), Integer.valueOf(iIntValue + 1), captchaPayload, 1824, null);
    }

    public final void resendMessageWithCaptcha(long channelId, String nonce, CaptchaHelper$CaptchaPayload captchaPayload) {
        Message message;
        m.checkNotNullParameter(captchaPayload, "captchaPayload");
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(resendMessage(message, true, captchaPayload)), StoreMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, StoreMessages$resendMessageWithCaptcha$1.INSTANCE, 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.util.List] */
    public final Observable<MessageResult> sendMessage(long channelId, com.discord.models.user.User author, String content, List<? extends com.discord.models.user.User> mentions, List<? extends Attachment<?>> attachments, List<? extends BaseSticker> stickers, MessageReference messageReference, MessageAllowedMentions allowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long lastManualAttemptTimestamp, Long initialAttemptTimestamp, Integer numRetries, CaptchaHelper$CaptchaPayload captchaPayload) {
        List listEmptyList;
        ArrayList arrayList;
        String content2 = content;
        m.checkNotNullParameter(author, "author");
        m.checkNotNullParameter(content2, "content");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = attachments;
        if (!(attachments == 0 || attachments.isEmpty())) {
            ProcessedMessageContent$Companion processedMessageContent$Companion = ProcessedMessageContent.Companion;
            Context context = this.context;
            if (context == null) {
                m.throwUninitializedPropertyAccessException("context");
            }
            ProcessedMessageContent processedMessageContentFromAttachments = processedMessageContent$Companion.fromAttachments(attachments, content2, context);
            List<Attachment<?>> invalidAttachments = processedMessageContentFromAttachments.getInvalidAttachments();
            if (!invalidAttachments.isEmpty()) {
                User userSynthesizeApiUser = UserUtils.INSTANCE.synthesizeApiUser(author);
                Clock clock = this.clock;
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(invalidAttachments, 10));
                Iterator<T> it = invalidAttachments.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AttachmentUtilsKt.toLocalAttachment((Attachment) it.next()));
                }
                this.dispatcher.schedule(new StoreMessages$sendMessage$1(this, LocalMessageCreatorsKt.createInvalidAttachmentsMessage(channelId, userSynthesizeApiUser, clock, arrayList2)));
            }
            ref$ObjectRef.element = processedMessageContentFromAttachments.getValidAttachments();
            content2 = processedMessageContentFromAttachments.getContent();
            List list = (List) ref$ObjectRef.element;
            if (list == null || list.isEmpty()) {
                if (content2.length() == 0) {
                    Observable<MessageResult> observableO = Observable.o(StoreMessages$sendMessage$2.INSTANCE, Emitter$BackpressureMode.ERROR);
                    m.checkNotNullExpressionValue(observableO, "Observable.create({ emit…r.BackpressureMode.ERROR)");
                    return observableO;
                }
            }
        }
        long jLongValue = lastManualAttemptTimestamp != null ? lastManualAttemptTimestamp.longValue() : this.clock.currentTimeMillis();
        User userSynthesizeApiUser2 = UserUtils.INSTANCE.synthesizeApiUser(author);
        if (mentions != null) {
            listEmptyList = new ArrayList(o.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it2 = mentions.iterator();
            while (it2.hasNext()) {
                listEmptyList.add(UserUtils.INSTANCE.synthesizeApiUser((com.discord.models.user.User) it2.next()));
            }
        } else {
            listEmptyList = n.emptyList();
        }
        List list2 = listEmptyList;
        List list3 = (List) ref$ObjectRef.element;
        boolean z2 = !(list3 == null || list3.isEmpty());
        Clock clock2 = this.clock;
        List list4 = (List) ref$ObjectRef.element;
        if (list4 != null) {
            ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(list4, 10));
            Iterator it3 = list4.iterator();
            while (it3.hasNext()) {
                arrayList3.add(AttachmentUtilsKt.toLocalAttachment((Attachment) it3.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        Message messageCreateLocalMessage = LocalMessageCreatorsKt.createLocalMessage(content2, channelId, userSynthesizeApiUser2, list2, false, z2, application, messageActivity, clock2, arrayList, Long.valueOf(jLongValue), Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : this.clock.currentTimeMillis()), Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), stickers, messageReference, allowedMentions, captchaPayload);
        if (messageActivity == null) {
            this.dispatcher.schedule(new StoreMessages$sendMessage$3(this, messageCreateLocalMessage));
        }
        this.dispatcher.schedule(new StoreMessages$sendMessage$4(this));
        return enqueueRequest(channelId, new StoreMessages$sendMessage$createRequest$1(this, messageCreateLocalMessage, ref$ObjectRef, activity, jLongValue));
    }

    @StoreThread
    private final void handleLocalMessageDelete(long channelId, String nonce) {
        this.localMessagesHolder.deleteMessage(channelId, nonce);
    }

    private final void handleMessageDelete(long channelId, List<Long> messageIds) {
        this.holder.deleteMessages(channelId, messageIds);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable sendMessage$default(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return storeMessages.sendMessage(message, applicationCommandLocalSendData, list);
    }

    public final Observable<Message> observeMessagesForChannel(long channelId, long messageId) {
        Observable<Message> observableR = observeMessagesForChannel(channelId).G(new StoreMessages$observeMessagesForChannel$2(messageId)).r();
        m.checkNotNullExpressionValue(observableR, "observeMessagesForChanne…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<MessageResult> sendMessage(Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> attachments) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandLocalSendData");
        this.dispatcher.schedule(new StoreMessages$sendMessage$5(this, message));
        return enqueueRequest(message.getChannelId(), new StoreMessages$sendMessage$createRequest$2(this, message, applicationCommandLocalSendData, attachments));
    }
}
