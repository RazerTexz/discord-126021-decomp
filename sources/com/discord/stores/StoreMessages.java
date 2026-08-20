package com.discord.stores;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.message.LocalAttachment;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.attachment.MessageAttachment;
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
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreatorsKt;
import com.discord.utilities.messagesend.MessageQueue;
import com.discord.utilities.messagesend.MessageRequest;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.ProcessedMessageContent;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtilsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.workers.BackgroundMessageSendWorker;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.objectweb.asm.Opcodes;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12662q;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p643a.C12685x0;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages extends Store {
    private static final long BACKGROUND_SENDING_DELAY_MS = 120000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private Context context;
    private final Dispatcher dispatcher;
    private final StoreMessagesHolder holder;
    private final BehaviorSubject<Boolean> initResendFinished;
    private final StoreLocalMessagesHolder localMessagesHolder;
    private final HashMap<Long, MessageQueue> messageQueues;
    private final ExecutorService queueExecutor;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Operation cancelBackgroundSendingWork(Context context) {
            Operation operationCancelUniqueWork = WorkManager.getInstance(context).cancelUniqueWork("BACKGROUND_MESSAGE_SENDING");
            C12238m.checkNotNullExpressionValue(operationCancelUniqueWork, "WorkManager.getInstance(…dWorker.UNIQUE_WORK_NAME)");
            return operationCancelUniqueWork;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$deleteMessage$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62241 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C62241 INSTANCE = new C62241();

        public C62241() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$deleteMessage$2 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62252 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62252(Message message, long j, long j2) {
            super(0);
            this.$message = message;
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
            if (this.$message.isLocal()) {
                String nonce = this.$message.getNonce();
                if (nonce != null) {
                    StoreMessages.this.getOrCreateMessageQueue(this.$channelId).cancel(nonce);
                }
                StoreMessages.this.handleLocalMessageDelete(this.$message);
                Integer type = this.$message.getType();
                if (type != null && type.intValue() == -2) {
                    StoreMessages.this.trackFailedLocalMessageResolved(this.$message, FailedMessageResolutionType.DELETED);
                }
            } else if (this.$message.isEphemeralMessage()) {
                StoreMessages.this.handleMessageDelete(new ModelMessageDelete(this.$channelId, this.$messageId));
            }
            StoreMessages.this.stream.handleLocalMessageDelete(this.$message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$editMessage$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62261 extends AbstractC12240o implements Function2<MessageResult, Boolean, Unit> {
        public final /* synthetic */ MessageAllowedMentions $allowedMentions;
        public final /* synthetic */ long $attemptTimestamp;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $content;
        public final /* synthetic */ long $messageId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$editMessage$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ MessageResult $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MessageResult messageResult) {
                super(0);
                this.$result = messageResult;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Message messageCreateLocalMessage;
                User author;
                if (this.$result instanceof MessageResult.AutoModBlock) {
                    C62261 c62261 = C62261.this;
                    Message message = StoreMessages.this.getMessage(c62261.$channelId, c62261.$messageId);
                    if (message == null || (author = message.getAuthor()) == null) {
                        messageCreateLocalMessage = null;
                    } else {
                        C62261 c62262 = C62261.this;
                        String str = c62262.$content;
                        long j = c62262.$channelId;
                        List<User> mentions = message.getMentions();
                        List<MessageAttachment> attachments = message.getAttachments();
                        boolean z2 = true ^ (attachments == null || attachments.isEmpty());
                        Application application = message.getApplication();
                        MessageActivity activity = message.getActivity();
                        Clock clock = StoreMessages.this.clock;
                        List listEmptyList = C12147n.emptyList();
                        Long lValueOf = Long.valueOf(C62261.this.$attemptTimestamp);
                        Long initialAttemptTimestamp = message.getInitialAttemptTimestamp();
                        Long lValueOf2 = Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : C62261.this.$attemptTimestamp);
                        Integer numRetries = message.getNumRetries();
                        messageCreateLocalMessage = LocalMessageCreatorsKt.createLocalMessage(str, j, author, mentions, false, z2, application, activity, clock, listEmptyList, lValueOf, lValueOf2, Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), message.getStickers(), message.getMessageReference(), C62261.this.$allowedMentions, (65536 & 65536) != 0 ? null : null);
                    }
                    if (messageCreateLocalMessage != null) {
                        StoreMessages storeMessages = StoreMessages.this;
                        storeMessages.handleSendMessageFailureAutoMod(messageCreateLocalMessage, new UtcDateTime(storeMessages.clock.currentTimeMillis()));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62261(long j, long j2, String str, long j3, MessageAllowedMentions messageAllowedMentions) {
            super(2);
            this.$channelId = j;
            this.$messageId = j2;
            this.$content = str;
            this.$attemptTimestamp = j3;
            this.$allowedMentions = messageAllowedMentions;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult, Boolean bool) {
            invoke(messageResult, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(MessageResult messageResult, boolean z2) {
            C12238m.checkNotNullParameter(messageResult, "result");
            StoreMessages.this.dispatcher.schedule(new AnonymousClass1(messageResult));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$markMessageFailed$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62281 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62281(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleSendMessageFailure(this.$localMessage);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62361 extends AbstractC12240o implements Function0<Unit> {
        public C62361() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.initResendFinished.onNext(Boolean.TRUE);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$2 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62372 extends AbstractC12240o implements Function1<MessageResult, Unit> {
        public static final C62372 INSTANCE = new C62372();

        public C62372() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
            invoke2(messageResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageResult messageResult) {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendMessage$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62381 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62381(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageDelete(this.$message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendMessageWithCaptcha$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62391 extends AbstractC12240o implements Function1<MessageResult, Unit> {
        public static final C62391 INSTANCE = new C62391();

        public C62391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
            invoke2(messageResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageResult messageResult) {
            C12238m.checkNotNullParameter(messageResult, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62401 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Message $invalidAttachmentsMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62401(Message message) {
            super(0);
            this.$invalidAttachmentsMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageCreate(this.$invalidAttachmentsMessage);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$3 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62423 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62423(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageCreate(this.$localMessage);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$4 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62434 extends AbstractC12240o implements Function0<Unit> {
        public C62434() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            C12238m.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            C12238m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$5 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62445 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62445(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageCreate(this.$message);
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            C12238m.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            C12238m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    public StoreMessages(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.holder = new StoreMessagesHolder();
        this.localMessagesHolder = new StoreLocalMessagesHolder();
        this.queueExecutor = Executors.newSingleThreadExecutor();
        this.messageQueues = new HashMap<>();
        this.initResendFinished = BehaviorSubject.m11130l0(Boolean.FALSE);
    }

    public static final /* synthetic */ Context access$getContext$p(StoreMessages storeMessages) {
        Context context = storeMessages.context;
        if (context == null) {
            C12238m.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    private final Observable<MessageResult> enqueueRequest(final long channelId, final Function1<? super Emitter<MessageResult>, ? extends MessageRequest> createRequest) {
        Observable<MessageResult> observableM11098X = Observable.m11080o(new Action1<Emitter<MessageResult>>() { // from class: com.discord.stores.StoreMessages.enqueueRequest.1
            @Override // p658rx.functions.Action1
            public final void call(Emitter<MessageResult> emitter) {
                MessageQueue orCreateMessageQueue = StoreMessages.this.getOrCreateMessageQueue(channelId);
                Function1 function1 = createRequest;
                C12238m.checkNotNullExpressionValue(emitter, "emitter");
                orCreateMessageQueue.enqueue((MessageRequest) function1.invoke(emitter));
            }
        }, Emitter.BackpressureMode.ERROR).m11098X(this.dispatcher.getScheduler());
        C12238m.checkNotNullExpressionValue(observableM11098X, "Observable.create<Messag…eOn(dispatcher.scheduler)");
        return observableM11098X;
    }

    @StoreThread
    private final MessageQueue getOrCreateMessageQueue(long channelId) {
        MessageQueue messageQueue = this.messageQueues.get(Long.valueOf(channelId));
        if (messageQueue == null) {
            Context context = this.context;
            if (context == null) {
                C12238m.throwUninitializedPropertyAccessException("context");
            }
            ContentResolver contentResolver = context.getContentResolver();
            C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            ExecutorService executorService = this.queueExecutor;
            C12238m.checkNotNullExpressionValue(executorService, "queueExecutor");
            messageQueue = new MessageQueue(contentResolver, executorService, this.clock);
            this.messageQueues.put(Long.valueOf(channelId), messageQueue);
        }
        return messageQueue;
    }

    @StoreThread
    private final void handleInteractionStateUpdate(InteractionStateUpdate interactionUpdate, boolean isFailed, boolean isLoading) {
        Message message;
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().m8506x27c7fac9().get(interactionUpdate.getNonce());
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
        C12238m.checkNotNull(author);
        handleLocalMessageCreate(LocalMessageCreatorsKt.createLocalMessage(str, channelId, author, localMessage.getMentions(), true, localMessage.getHasLocalUploads(), localMessage.getApplication(), localMessage.getActivity(), this.clock, localMessage.getLocalAttachments(), localMessage.getLastManualAttemptTimestamp(), localMessage.getInitialAttemptTimestamp(), localMessage.getNumRetries(), localMessage.getStickers(), localMessage.getMessageReference(), localMessage.getAllowedMentions(), (65536 & 65536) != 0 ? null : null));
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
        Logger.e$default(AppLog.f14950g, "ValidationError", errorMessage, null, null, 12, null);
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

    private final Observable<List<Message>> observeLocalMessagesForChannel(final long channelId) {
        Observable<R> observableM11083G = this.localMessagesHolder.getMessagesPublisher().m11083G(new InterfaceC12589b<Map<Long, ? extends List<? extends Message>>, List<? extends Message>>() { // from class: com.discord.stores.StoreMessages.observeLocalMessagesForChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends Message> call(Map<Long, ? extends List<? extends Message>> map) {
                return call2((Map<Long, ? extends List<Message>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Message> call2(Map<Long, ? extends List<Message>> map) {
                List<Message> list = map.get(Long.valueOf(channelId));
                return list != null ? list : C12147n.emptyList();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "localMessagesHolder\n    …annelId] ?: emptyList() }");
        Observable<List<Message>> observableM11113s = ObservableExtensionsKt.computationBuffered(observableM11083G).m11113s(new Func2<List<? extends Message>, List<? extends Message>, Boolean>() { // from class: com.discord.stores.StoreMessages.observeLocalMessagesForChannel.2
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
                return call2((List<Message>) list, (List<Message>) list2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(List<Message> list, List<Message> list2) {
                return Boolean.valueOf(list == list2);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11113s, "localMessagesHolder\n    …messages1 === messages2 }");
        return observableM11113s;
    }

    private final Observable<List<Message>> observeSyncedMessagesForChannel(final long channelId) {
        Observable<R> observableM11083G = this.holder.getMessagesPublisher().m11083G(new InterfaceC12589b<Map<Long, List<Message>>, List<? extends Message>>() { // from class: com.discord.stores.StoreMessages.observeSyncedMessagesForChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<Message> call(Map<Long, List<Message>> map) {
                List<Message> list = map.get(Long.valueOf(channelId));
                return list != null ? list : C12147n.emptyList();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "holder\n          .messag…annelId] ?: emptyList() }");
        Observable<List<Message>> observableM11113s = ObservableExtensionsKt.computationBuffered(observableM11083G).m11113s(new Func2<List<? extends Message>, List<? extends Message>, Boolean>() { // from class: com.discord.stores.StoreMessages.observeSyncedMessagesForChannel.2
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
                return call2((List<Message>) list, (List<Message>) list2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(List<Message> list, List<Message> list2) {
                return Boolean.valueOf(list == list2);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11113s, "holder\n          .messag…messages1 === messages2 }");
        return observableM11113s;
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
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(resendMessage$default(this, (Message) it.next(), true, null, 4, null));
        }
        Observable observableM11074h0 = Observable.m11074h0(new C12666r(Observable.m11074h0(new C12662q(arrayList2)).f27640j, C12685x0.a.f27082a));
        C12238m.checkNotNullExpressionValue(observableM11074h0, "Observable\n        .mergeDelayError(observables)");
        ObservableExtensionsKt.appSubscribe(observableM11074h0, (Class<?>) StoreMessages.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : new C62361()), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C62372.INSTANCE);
    }

    public static /* synthetic */ Observable resendMessage$default(StoreMessages storeMessages, Message message, boolean z2, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        return storeMessages.resendMessage(message, z2, captchaPayload);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable sendMessage$default(StoreMessages storeMessages, long j, com.discord.models.user.User user, String str, List list, List list2, List list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long l, Long l2, Integer num, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        return storeMessages.sendMessage(j, user, str, list, list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : messageReference, (i & 128) != 0 ? null : messageAllowedMentions, (i & 256) != 0 ? null : application, (i & 512) != 0 ? null : activity, (i & 1024) != 0 ? null : messageActivity, (i & 2048) != 0 ? null : l, (i & 4096) != 0 ? null : l2, (i & 8192) != 0 ? null : num, (i & 16384) != 0 ? null : captchaPayload);
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
                        C12238m.throwUninitializedPropertyAccessException("context");
                    }
                    ContentResolver contentResolver = context.getContentResolver();
                    C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
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
                        C12238m.throwUninitializedPropertyAccessException("context");
                    }
                    ContentResolver contentResolver2 = context2.getContentResolver();
                    C12238m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
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
            arrayList = new ArrayList(C12149o.collectionSizeOrDefault(localAttachments3, 10));
            Iterator<T> it3 = localAttachments3.iterator();
            while (it3.hasNext()) {
                Uri uri = Uri.parse(((LocalAttachment) it3.next()).getUriString());
                C12238m.checkNotNullExpressionValue(uri, "Uri.parse(localAttachment.uriString)");
                Context context3 = this.context;
                if (context3 == null) {
                    C12238m.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver3 = context3.getContentResolver();
                C12238m.checkNotNullExpressionValue(contentResolver3, "context.contentResolver");
                arrayList.add(Long.valueOf(SendUtilsKt.computeFileSizeBytes(uri, contentResolver3)));
            }
        } else {
            arrayList = null;
        }
        int iLongValue = (arrayList == null || (l = (Long) C12163u.maxOrNull((Iterable) arrayList)) == null) ? 0 : (int) l.longValue();
        int iSumOfLong = arrayList != null ? (int) C12163u.sumOfLong(arrayList) : 0;
        StoreAnalytics analytics = StoreStream.INSTANCE.getAnalytics();
        List<LocalAttachment> localAttachments4 = localMessage.getLocalAttachments();
        int size = localAttachments4 != null ? localAttachments4.size() : 0;
        Long initialAttemptTimestamp = localMessage.getInitialAttemptTimestamp();
        long jLongValue = initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : 0L;
        Integer numRetries = localMessage.getNumRetries();
        analytics.trackFailedMessageResolved(size, iLongValue, iSumOfLong, z2, z3, failedMessageResolutionType, jLongValue, numRetries != null ? numRetries.intValue() : 0, localMessage.getChannelId());
    }

    public final void cancelMessageSend(long channelId, String requestId) {
        C12238m.checkNotNullParameter(requestId, "requestId");
        getOrCreateMessageQueue(channelId).cancel(requestId);
    }

    @StoreThread
    public final void deleteLocalMessage(long channelId, String nonce) {
        C12238m.checkNotNullParameter(nonce, "nonce");
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
            this.dispatcher.schedule(new C62252(message, channelId, id2));
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteMessage(channelId, id2), false, 1, null), (117 & 1) != 0 ? null : null, "deleteMessage", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), C62241.INSTANCE, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }
    }

    public final void editMessage(long messageId, long channelId, String content, MessageAllowedMentions allowedMentions) {
        C12238m.checkNotNullParameter(content, "content");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        getOrCreateMessageQueue(channelId).enqueue(new MessageRequest.Edit(channelId, content, messageId, allowedMentions, jCurrentTimeMillis, new C62261(channelId, messageId, content, jCurrentTimeMillis, allowedMentions)));
    }

    public final Observable<Set<Long>> getAllDetached() {
        Observable<Set<Long>> detachedChannelsSubject = this.holder.getDetachedChannelsSubject();
        C12238m.checkNotNullExpressionValue(detachedChannelsSubject, "holder\n          .detachedChannelsSubject");
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
        C12238m.checkNotNullExpressionValue(collectionValues, "messageQueues.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((MessageQueue) it.next()).handleConnected();
        }
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.holder.setMyUserId(payload.getMe().getId());
    }

    @StoreThread
    public final void handleInteractionCreate(InteractionStateUpdate interactionUpdate) {
        C12238m.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, false, true, 2, null);
    }

    @StoreThread
    public final void handleInteractionFailure(InteractionStateUpdate interactionUpdate) {
        C12238m.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, true, false, 4, null);
    }

    @StoreThread
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        C12238m.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().m8506x27c7fac9().get(interactionModalCreate.getNonce());
        if (applicationCommandLocalSendData != null) {
            this.localMessagesHolder.deleteMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString());
        }
    }

    public final void handleMessageCreate(List<com.discord.api.message.Message> messagesList) {
        C12238m.checkNotNullParameter(messagesList, "messagesList");
        for (com.discord.api.message.Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce != null) {
                this.localMessagesHolder.deleteMessage(message.getChannelId(), nonce);
            }
        }
        StoreMessagesHolder storeMessagesHolder = this.holder;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(messagesList, 10));
        Iterator<T> it = messagesList.iterator();
        while (it.hasNext()) {
            arrayList.add(new Message((com.discord.api.message.Message) it.next()));
        }
        storeMessagesHolder.addMessages(arrayList);
    }

    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        C12238m.checkNotNullParameter(messageDelete, "messageDelete");
        long channelId = messageDelete.getChannelId();
        List<Long> messageIds = messageDelete.getMessageIds();
        C12238m.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        handleMessageDelete(channelId, messageIds);
    }

    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        this.holder.updateMessages(message);
    }

    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        C12238m.checkNotNullParameter(chunk, "chunk");
        this.holder.loadMessageChunks(C12145m.listOf(chunk));
    }

    public final void handlePreLogout() {
        this.localMessagesHolder.clearCache();
    }

    public final void handleReactionUpdate(List<MessageReactionUpdate> updates, boolean add) {
        C12238m.checkNotNullParameter(updates, "updates");
        this.holder.updateReactions(updates, add);
    }

    public final void handleReactionsRemoveAll(MessageReactionUpdate update) {
        C12238m.checkNotNullParameter(update, "update");
        this.holder.removeAllReactions(update);
    }

    public final void handleReactionsRemoveEmoji(MessageReactionUpdate update) {
        C12238m.checkNotNullParameter(update, "update");
        this.holder.removeEmojiReactions(update);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
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
        this.dispatcher.schedule(new C62281(message));
    }

    public final BehaviorSubject<Boolean> observeInitResendFinished() {
        BehaviorSubject<Boolean> behaviorSubject = this.initResendFinished;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "initResendFinished");
        return behaviorSubject;
    }

    public final Observable<Boolean> observeIsDetached(final long channelId) {
        Observable<Boolean> observableM11112r = getAllDetached().m11083G(new InterfaceC12589b<Set<? extends Long>, Boolean>() { // from class: com.discord.stores.StoreMessages.observeIsDetached.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set) {
                return Boolean.valueOf(set.contains(Long.valueOf(channelId)));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "allDetached\n          .m…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<List<Message>> observeMessagesForChannel(long channelId) {
        Observable<List<Message>> observableM11075i = Observable.m11075i(observeSyncedMessagesForChannel(channelId), observeLocalMessagesForChannel(channelId), observeIsDetached(channelId), new Func3<List<? extends Message>, List<? extends Message>, Boolean, List<? extends Message>>() { // from class: com.discord.stores.StoreMessages.observeMessagesForChannel.1
            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends Message> list, List<? extends Message> list2, Boolean bool) {
                return call2((List<Message>) list, (List<Message>) list2, bool);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Message> call2(List<Message> list, List<Message> list2, Boolean bool) {
                C12238m.checkNotNullExpressionValue(bool, "isDetached");
                if (bool.booleanValue()) {
                    return list;
                }
                C12238m.checkNotNullExpressionValue(list, "messages");
                C12238m.checkNotNullExpressionValue(list2, "localMessages");
                return C12163u.plus((Collection) list, (Iterable) list2);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…ges + localMessages\n    }");
        return observableM11075i;
    }

    public final Observable<MessageResult> resendMessage(Message message, boolean isAutoAttempt, CaptchaHelper.CaptchaPayload captchaPayload) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Integer type;
        Integer type2;
        Integer type3;
        C12238m.checkNotNullParameter(message, "message");
        if ((isAutoAttempt && (((type2 = message.getType()) == null || type2.intValue() != -1) && ((type3 = message.getType()) == null || type3.intValue() != -6))) || (!isAutoAttempt && ((type = message.getType()) == null || type.intValue() != -2))) {
            throw new IllegalArgumentException("Incorrect " + isAutoAttempt + " auto attempt and message type " + message.getType());
        }
        this.dispatcher.schedule(new C62381(message));
        Integer numRetries = message.getNumRetries();
        int iIntValue = numRetries != null ? numRetries.intValue() : 0;
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        C12238m.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        String content = message.getContent();
        if (content == null) {
            content = "";
        }
        List<User> mentions = message.getMentions();
        if (mentions != null) {
            arrayList = new ArrayList(C12149o.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it = mentions.iterator();
            while (it.hasNext()) {
                arrayList.add(new CoreUser((User) it.next()));
            }
        } else {
            arrayList = null;
        }
        List<LocalAttachment> localAttachments = message.getLocalAttachments();
        if (localAttachments != null) {
            arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(localAttachments, 10));
            for (LocalAttachment localAttachment : localAttachments) {
                Uri uri = Uri.parse(localAttachment.getUriString());
                long id2 = localAttachment.getId();
                C12238m.checkNotNullExpressionValue(uri, "contentUri");
                arrayList2.add(new Attachment(id2, uri, localAttachment.getDisplayName(), null, false, 16, null));
            }
        } else {
            arrayList2 = null;
        }
        return sendMessage$default(this, channelId, coreUser, content, arrayList, arrayList2, null, message.getMessageReference(), message.getAllowedMentions(), null, null, null, isAutoAttempt ? message.getLastManualAttemptTimestamp() : null, message.getInitialAttemptTimestamp(), Integer.valueOf(iIntValue + 1), captchaPayload, 1824, null);
    }

    public final void resendMessageWithCaptcha(long channelId, String nonce, CaptchaHelper.CaptchaPayload captchaPayload) {
        Message message;
        C12238m.checkNotNullParameter(captchaPayload, "captchaPayload");
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(resendMessage(message, true, captchaPayload)), (Class<?>) StoreMessages.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C62391.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.util.List] */
    public final Observable<MessageResult> sendMessage(long channelId, com.discord.models.user.User author, String content, List<? extends com.discord.models.user.User> mentions, List<? extends Attachment<?>> attachments, List<? extends BaseSticker> stickers, MessageReference messageReference, MessageAllowedMentions allowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long lastManualAttemptTimestamp, Long initialAttemptTimestamp, Integer numRetries, CaptchaHelper.CaptchaPayload captchaPayload) {
        List listEmptyList;
        ArrayList arrayList;
        String content2 = content;
        C12238m.checkNotNullParameter(author, "author");
        C12238m.checkNotNullParameter(content2, "content");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = attachments;
        if (!(attachments == 0 || attachments.isEmpty())) {
            ProcessedMessageContent.Companion companion = ProcessedMessageContent.INSTANCE;
            Context context = this.context;
            if (context == null) {
                C12238m.throwUninitializedPropertyAccessException("context");
            }
            ProcessedMessageContent processedMessageContentFromAttachments = companion.fromAttachments(attachments, content2, context);
            List<Attachment<?>> invalidAttachments = processedMessageContentFromAttachments.getInvalidAttachments();
            if (!invalidAttachments.isEmpty()) {
                User userSynthesizeApiUser = UserUtils.INSTANCE.synthesizeApiUser(author);
                Clock clock = this.clock;
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(invalidAttachments, 10));
                Iterator<T> it = invalidAttachments.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AttachmentUtilsKt.toLocalAttachment((Attachment) it.next()));
                }
                this.dispatcher.schedule(new C62401(LocalMessageCreatorsKt.createInvalidAttachmentsMessage(channelId, userSynthesizeApiUser, clock, arrayList2)));
            }
            ref$ObjectRef.element = processedMessageContentFromAttachments.getValidAttachments();
            content2 = processedMessageContentFromAttachments.getContent();
            List list = (List) ref$ObjectRef.element;
            if (list == null || list.isEmpty()) {
                if (content2.length() == 0) {
                    Observable<MessageResult> observableM11080o = Observable.m11080o(new Action1<Emitter<MessageResult>>() { // from class: com.discord.stores.StoreMessages.sendMessage.2
                        @Override // p658rx.functions.Action1
                        public final void call(Emitter<MessageResult> emitter) {
                            emitter.onNext(MessageResult.NoValidContent.INSTANCE);
                            emitter.onCompleted();
                        }
                    }, Emitter.BackpressureMode.ERROR);
                    C12238m.checkNotNullExpressionValue(observableM11080o, "Observable.create({ emit…r.BackpressureMode.ERROR)");
                    return observableM11080o;
                }
            }
        }
        long jLongValue = lastManualAttemptTimestamp != null ? lastManualAttemptTimestamp.longValue() : this.clock.currentTimeMillis();
        User userSynthesizeApiUser2 = UserUtils.INSTANCE.synthesizeApiUser(author);
        if (mentions != null) {
            listEmptyList = new ArrayList(C12149o.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it2 = mentions.iterator();
            while (it2.hasNext()) {
                listEmptyList.add(UserUtils.INSTANCE.synthesizeApiUser((com.discord.models.user.User) it2.next()));
            }
        } else {
            listEmptyList = C12147n.emptyList();
        }
        List list2 = listEmptyList;
        List list3 = (List) ref$ObjectRef.element;
        boolean z2 = !(list3 == null || list3.isEmpty());
        Clock clock2 = this.clock;
        List list4 = (List) ref$ObjectRef.element;
        if (list4 != null) {
            ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(list4, 10));
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
            this.dispatcher.schedule(new C62423(messageCreateLocalMessage));
        }
        this.dispatcher.schedule(new C62434());
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

    public final Observable<Message> observeMessagesForChannel(long channelId, final long messageId) {
        Observable<Message> observableM11112r = observeMessagesForChannel(channelId).m11083G(new InterfaceC12589b<List<? extends Message>, Message>() { // from class: com.discord.stores.StoreMessages.observeMessagesForChannel.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Message call(List<? extends Message> list) {
                return call2((List<Message>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Message call2(List<Message> list) {
                T next;
                C12238m.checkNotNullExpressionValue(list, "messages");
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (((Message) next).getId() == messageId) {
                        return next;
                    }
                }
                next = (T) null;
                return next;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeMessagesForChanne…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<MessageResult> sendMessage(Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> attachments) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandLocalSendData");
        this.dispatcher.schedule(new C62445(message));
        return enqueueRequest(message.getChannelId(), new StoreMessages$sendMessage$createRequest$2(this, message, applicationCommandLocalSendData, attachments));
    }
}
