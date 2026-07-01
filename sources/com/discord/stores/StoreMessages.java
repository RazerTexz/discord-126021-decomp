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
import com.discord.stores.StoreMessagesLoader;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreators;
import com.discord.utilities.messagesend.MessageQueue;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils3;
import com.discord.utilities.rest.SendUtils5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.workers.BackgroundMessageSendWorker;
import com.lytefast.flexinput.model.Attachment;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeFromIterable;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorMerge;
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
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;

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
            Intrinsics3.checkNotNullExpressionValue(operationCancelUniqueWork, "WorkManager.getInstance(…dWorker.UNIQUE_WORK_NAME)");
            return operationCancelUniqueWork;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$deleteMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$deleteMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Message message, long j, long j2) {
            super(0);
            this.$message = message;
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
                    StoreMessages.this.trackFailedLocalMessageResolved(this.$message, StoreMessages2.DELETED);
                }
            } else if (this.$message.isEphemeralMessage()) {
                StoreMessages.this.handleMessageDelete(new ModelMessageDelete(this.$channelId, this.$messageId));
            }
            StoreMessages.this.stream.handleLocalMessageDelete(this.$message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$editMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<MessageQueue4, Boolean, Unit> {
        public final /* synthetic */ MessageAllowedMentions $allowedMentions;
        public final /* synthetic */ long $attemptTimestamp;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $content;
        public final /* synthetic */ long $messageId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$editMessage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class C01571 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MessageQueue4 $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01571(MessageQueue4 messageQueue4) {
                super(0);
                this.$result = messageQueue4;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Message messageCreateLocalMessage;
                User author;
                if (this.$result instanceof MessageQueue4.AutoModBlock) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    Message message = StoreMessages.this.getMessage(anonymousClass1.$channelId, anonymousClass1.$messageId);
                    if (message == null || (author = message.getAuthor()) == null) {
                        messageCreateLocalMessage = null;
                    } else {
                        AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                        String str = anonymousClass2.$content;
                        long j = anonymousClass2.$channelId;
                        List<User> mentions = message.getMentions();
                        List<MessageAttachment> attachments = message.getAttachments();
                        boolean z2 = true ^ (attachments == null || attachments.isEmpty());
                        Application application = message.getApplication();
                        MessageActivity activity = message.getActivity();
                        Clock clock = StoreMessages.this.clock;
                        List listEmptyList = Collections2.emptyList();
                        Long lValueOf = Long.valueOf(AnonymousClass1.this.$attemptTimestamp);
                        Long initialAttemptTimestamp = message.getInitialAttemptTimestamp();
                        Long lValueOf2 = Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : AnonymousClass1.this.$attemptTimestamp);
                        Integer numRetries = message.getNumRetries();
                        messageCreateLocalMessage = LocalMessageCreators.createLocalMessage(str, j, author, mentions, false, z2, application, activity, clock, listEmptyList, lValueOf, lValueOf2, Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), message.getStickers(), message.getMessageReference(), AnonymousClass1.this.$allowedMentions, (65536 & 65536) != 0 ? null : null);
                    }
                    if (messageCreateLocalMessage != null) {
                        StoreMessages storeMessages = StoreMessages.this;
                        storeMessages.handleSendMessageFailureAutoMod(messageCreateLocalMessage, new UtcDateTime(storeMessages.clock.currentTimeMillis()));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, String str, long j3, MessageAllowedMentions messageAllowedMentions) {
            super(2);
            this.$channelId = j;
            this.$messageId = j2;
            this.$content = str;
            this.$attemptTimestamp = j3;
            this.$allowedMentions = messageAllowedMentions;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4, Boolean bool) {
            invoke(messageQueue4, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(MessageQueue4 messageQueue4, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "result");
            StoreMessages.this.dispatcher.schedule(new C01571(messageQueue4));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$markMessageFailed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleSendMessageFailure(this.$localMessage);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.initResendFinished.onNext(Boolean.TRUE);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<MessageQueue4, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageDelete(this.$message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$resendMessageWithCaptcha$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $invalidAttachmentsMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message) {
            super(0);
            this.$invalidAttachmentsMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageCreate(this.$invalidAttachmentsMessage);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageCreate(this.$localMessage);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            Intrinsics3.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.this.handleLocalMessageCreate(this.$message);
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            Intrinsics3.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    public StoreMessages(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.holder = new StoreMessagesHolder();
        this.localMessagesHolder = new StoreLocalMessagesHolder();
        this.queueExecutor = Executors.newSingleThreadExecutor();
        this.messageQueues = new HashMap<>();
        this.initResendFinished = BehaviorSubject.l0(Boolean.FALSE);
    }

    public static final /* synthetic */ Context access$getContext$p(StoreMessages storeMessages) {
        Context context = storeMessages.context;
        if (context == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    private final Observable<MessageQueue4> enqueueRequest(final long channelId, final Function1<? super Emitter<MessageQueue4>, ? extends MessageQueue3> createRequest) {
        Observable<MessageQueue4> observableX = Observable.o(new Action1<Emitter<MessageQueue4>>() { // from class: com.discord.stores.StoreMessages.enqueueRequest.1
            @Override // rx.functions.Action1
            public final void call(Emitter<MessageQueue4> emitter) {
                MessageQueue orCreateMessageQueue = StoreMessages.this.getOrCreateMessageQueue(channelId);
                Function1 function1 = createRequest;
                Intrinsics3.checkNotNullExpressionValue(emitter, "emitter");
                orCreateMessageQueue.enqueue((MessageQueue3) function1.invoke(emitter));
            }
        }, Emitter.BackpressureMode.ERROR).X(this.dispatcher.getScheduler());
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.create<Messag…eOn(dispatcher.scheduler)");
        return observableX;
    }

    @Store3
    private final MessageQueue getOrCreateMessageQueue(long channelId) {
        MessageQueue messageQueue = this.messageQueues.get(Long.valueOf(channelId));
        if (messageQueue == null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            ExecutorService executorService = this.queueExecutor;
            Intrinsics3.checkNotNullExpressionValue(executorService, "queueExecutor");
            messageQueue = new MessageQueue(contentResolver, executorService, this.clock);
            this.messageQueues.put(Long.valueOf(channelId), messageQueue);
        }
        return messageQueue;
    }

    @Store3
    private final void handleInteractionStateUpdate(InteractionStateUpdate interactionUpdate, boolean isFailed, boolean isLoading) {
        Message message;
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().getApplicationCommandLocalSendDataSet$app_productionGoogleRelease().get(interactionUpdate.getNonce());
        if (applicationCommandLocalSendData == null || (message = this.localMessagesHolder.getMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString())) == null) {
            return;
        }
        this.localMessagesHolder.addMessage(LocalMessageCreators.createLocalApplicationCommandMessage(message, interactionUpdate.getId(), isFailed, isLoading, this.clock));
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

    @Store3
    private final void handleLocalMessageCreate(Message message) {
        this.localMessagesHolder.addMessage(message);
    }

    @Store3
    private final void handleLocalMessageDelete(Message localMessage) {
        this.localMessagesHolder.deleteMessage(localMessage);
    }

    @Store3
    private final void handleSendMessageCaptchaRequired(Message localMessage) {
        this.localMessagesHolder.addMessage(Message.copy$default(localMessage, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -131073, Opcodes.LAND, null));
    }

    @Store3
    private final void handleSendMessageFailure(Message localMessage) {
        deleteMessage(localMessage);
        String content = localMessage.getContent();
        if (content == null) {
            content = "";
        }
        String str = content;
        long channelId = localMessage.getChannelId();
        User author = localMessage.getAuthor();
        Intrinsics3.checkNotNull(author);
        handleLocalMessageCreate(LocalMessageCreators.createLocalMessage(str, channelId, author, localMessage.getMentions(), true, localMessage.getHasLocalUploads(), localMessage.getApplication(), localMessage.getActivity(), this.clock, localMessage.getLocalAttachments(), localMessage.getLastManualAttemptTimestamp(), localMessage.getInitialAttemptTimestamp(), localMessage.getNumRetries(), localMessage.getStickers(), localMessage.getMessageReference(), localMessage.getAllowedMentions(), (65536 & 65536) != 0 ? null : null));
    }

    @Store3
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

    @Store3
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
        Observable<R> observableG = this.localMessagesHolder.getMessagesPublisher().G(new Func1<Map<Long, ? extends List<? extends Message>>, List<? extends Message>>() { // from class: com.discord.stores.StoreMessages.observeLocalMessagesForChannel.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends Message> call(Map<Long, ? extends List<? extends Message>> map) {
                return call2((Map<Long, ? extends List<Message>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Message> call2(Map<Long, ? extends List<Message>> map) {
                List<Message> list = map.get(Long.valueOf(channelId));
                return list != null ? list : Collections2.emptyList();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "localMessagesHolder\n    …annelId] ?: emptyList() }");
        Observable<List<Message>> observableS = ObservableExtensionsKt.computationBuffered(observableG).s(new Func2<List<? extends Message>, List<? extends Message>, Boolean>() { // from class: com.discord.stores.StoreMessages.observeLocalMessagesForChannel.2
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
                return call2((List<Message>) list, (List<Message>) list2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(List<Message> list, List<Message> list2) {
                return Boolean.valueOf(list == list2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableS, "localMessagesHolder\n    …messages1 === messages2 }");
        return observableS;
    }

    private final Observable<List<Message>> observeSyncedMessagesForChannel(final long channelId) {
        Observable<R> observableG = this.holder.getMessagesPublisher().G(new Func1<Map<Long, List<Message>>, List<? extends Message>>() { // from class: com.discord.stores.StoreMessages.observeSyncedMessagesForChannel.1
            @Override // j0.k.Func1
            public final List<Message> call(Map<Long, List<Message>> map) {
                List<Message> list = map.get(Long.valueOf(channelId));
                return list != null ? list : Collections2.emptyList();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "holder\n          .messag…annelId] ?: emptyList() }");
        Observable<List<Message>> observableS = ObservableExtensionsKt.computationBuffered(observableG).s(new Func2<List<? extends Message>, List<? extends Message>, Boolean>() { // from class: com.discord.stores.StoreMessages.observeSyncedMessagesForChannel.2
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
                return call2((List<Message>) list, (List<Message>) list2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(List<Message> list, List<Message> list2) {
                return Boolean.valueOf(list == list2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableS, "holder\n          .messag…messages1 === messages2 }");
        return observableS;
    }

    @Store3
    private final void resendAllLocalMessages() {
        List<Message> flattenedMessages = this.localMessagesHolder.getFlattenedMessages();
        ArrayList arrayList = new ArrayList();
        for (Object obj : flattenedMessages) {
            Integer type = ((Message) obj).getType();
            if (type != null && type.intValue() == -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(resendMessage$default(this, (Message) it.next(), true, null, 4, null));
        }
        Observable observableH0 = Observable.h0(new OnSubscribeLift(Observable.h0(new OnSubscribeFromIterable(arrayList2)).j, OperatorMerge.a.a));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "Observable\n        .mergeDelayError(observables)");
        ObservableExtensionsKt.appSubscribe(observableH0, (Class<?>) StoreMessages.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : new AnonymousClass1()), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass2.INSTANCE);
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
    private final void trackFailedLocalMessageResolved(Message localMessage, StoreMessages2 failedMessageResolutionType) {
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
                        Intrinsics3.throwUninitializedPropertyAccessException("context");
                    }
                    ContentResolver contentResolver = context.getContentResolver();
                    Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                    if (AttachmentUtils.isImageAttachment(localAttachment, contentResolver)) {
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
                        Intrinsics3.throwUninitializedPropertyAccessException("context");
                    }
                    ContentResolver contentResolver2 = context2.getContentResolver();
                    Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                    if (AttachmentUtils.isVideoAttachment(localAttachment2, contentResolver2)) {
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
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(localAttachments3, 10));
            Iterator<T> it3 = localAttachments3.iterator();
            while (it3.hasNext()) {
                Uri uri = Uri.parse(((LocalAttachment) it3.next()).getUriString());
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(localAttachment.uriString)");
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver3 = context3.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver3, "context.contentResolver");
                arrayList.add(Long.valueOf(SendUtils5.computeFileSizeBytes(uri, contentResolver3)));
            }
        } else {
            arrayList = null;
        }
        int iLongValue = (arrayList == null || (l = (Long) _Collections.maxOrNull((Iterable) arrayList)) == null) ? 0 : (int) l.longValue();
        int iSumOfLong = arrayList != null ? (int) _Collections.sumOfLong(arrayList) : 0;
        StoreAnalytics analytics = StoreStream.INSTANCE.getAnalytics();
        List<LocalAttachment> localAttachments4 = localMessage.getLocalAttachments();
        int size = localAttachments4 != null ? localAttachments4.size() : 0;
        Long initialAttemptTimestamp = localMessage.getInitialAttemptTimestamp();
        long jLongValue = initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : 0L;
        Integer numRetries = localMessage.getNumRetries();
        analytics.trackFailedMessageResolved(size, iLongValue, iSumOfLong, z2, z3, failedMessageResolutionType, jLongValue, numRetries != null ? numRetries.intValue() : 0, localMessage.getChannelId());
    }

    public final void cancelMessageSend(long channelId, String requestId) {
        Intrinsics3.checkNotNullParameter(requestId, "requestId");
        getOrCreateMessageQueue(channelId).cancel(requestId);
    }

    @Store3
    public final void deleteLocalMessage(long channelId, String nonce) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
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
            this.dispatcher.schedule(new AnonymousClass2(message, channelId, id2));
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteMessage(channelId, id2), false, 1, null), (117 & 1) != 0 ? null : null, "deleteMessage", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), AnonymousClass1.INSTANCE, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
        }
    }

    public final void editMessage(long messageId, long channelId, String content, MessageAllowedMentions allowedMentions) {
        Intrinsics3.checkNotNullParameter(content, "content");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        getOrCreateMessageQueue(channelId).enqueue(new MessageQueue3.Edit(channelId, content, messageId, allowedMentions, jCurrentTimeMillis, new AnonymousClass1(channelId, messageId, content, jCurrentTimeMillis, allowedMentions)));
    }

    public final Observable<Set<Long>> getAllDetached() {
        Observable<Set<Long>> detachedChannelsSubject = this.holder.getDetachedChannelsSubject();
        Intrinsics3.checkNotNullExpressionValue(detachedChannelsSubject, "holder\n          .detachedChannelsSubject");
        return ObservableExtensionsKt.computationLatest(detachedChannelsSubject);
    }

    @Store3
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

    @Store3
    public final void handleConnected(boolean connected) {
        if (!connected) {
            this.holder.invalidate();
            return;
        }
        Collection<MessageQueue> collectionValues = this.messageQueues.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "messageQueues.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((MessageQueue) it.next()).handleConnected();
        }
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.holder.setMyUserId(payload.getMe().getId());
    }

    @Store3
    public final void handleInteractionCreate(InteractionStateUpdate interactionUpdate) {
        Intrinsics3.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, false, true, 2, null);
    }

    @Store3
    public final void handleInteractionFailure(InteractionStateUpdate interactionUpdate) {
        Intrinsics3.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, true, false, 4, null);
    }

    @Store3
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        Intrinsics3.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().getApplicationCommandLocalSendDataSet$app_productionGoogleRelease().get(interactionModalCreate.getNonce());
        if (applicationCommandLocalSendData != null) {
            this.localMessagesHolder.deleteMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString());
        }
    }

    public final void handleMessageCreate(List<com.discord.api.message.Message> messagesList) {
        Intrinsics3.checkNotNullParameter(messagesList, "messagesList");
        for (com.discord.api.message.Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce != null) {
                this.localMessagesHolder.deleteMessage(message.getChannelId(), nonce);
            }
        }
        StoreMessagesHolder storeMessagesHolder = this.holder;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(messagesList, 10));
        Iterator<T> it = messagesList.iterator();
        while (it.hasNext()) {
            arrayList.add(new Message((com.discord.api.message.Message) it.next()));
        }
        storeMessagesHolder.addMessages(arrayList);
    }

    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        long channelId = messageDelete.getChannelId();
        List<Long> messageIds = messageDelete.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        handleMessageDelete(channelId, messageIds);
    }

    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.holder.updateMessages(message);
    }

    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        this.holder.loadMessageChunks(CollectionsJVM.listOf(chunk));
    }

    public final void handlePreLogout() {
        this.localMessagesHolder.clearCache();
    }

    public final void handleReactionUpdate(List<MessageReactionUpdate> updates, boolean add) {
        Intrinsics3.checkNotNullParameter(updates, "updates");
        this.holder.updateReactions(updates, add);
    }

    public final void handleReactionsRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.holder.removeAllReactions(update);
    }

    public final void handleReactionsRemoveEmoji(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.holder.removeEmojiReactions(update);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
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
        this.dispatcher.schedule(new AnonymousClass1(message));
    }

    public final BehaviorSubject<Boolean> observeInitResendFinished() {
        BehaviorSubject<Boolean> behaviorSubject = this.initResendFinished;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "initResendFinished");
        return behaviorSubject;
    }

    public final Observable<Boolean> observeIsDetached(final long channelId) {
        Observable<Boolean> observableR = getAllDetached().G(new Func1<Set<? extends Long>, Boolean>() { // from class: com.discord.stores.StoreMessages.observeIsDetached.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set) {
                return Boolean.valueOf(set.contains(Long.valueOf(channelId)));
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "allDetached\n          .m…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Message>> observeMessagesForChannel(long channelId) {
        Observable<List<Message>> observableI = Observable.i(observeSyncedMessagesForChannel(channelId), observeLocalMessagesForChannel(channelId), observeIsDetached(channelId), new Func3<List<? extends Message>, List<? extends Message>, Boolean, List<? extends Message>>() { // from class: com.discord.stores.StoreMessages.observeMessagesForChannel.1
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends Message> list, List<? extends Message> list2, Boolean bool) {
                return call2((List<Message>) list, (List<Message>) list2, bool);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Message> call2(List<Message> list, List<Message> list2, Boolean bool) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isDetached");
                if (bool.booleanValue()) {
                    return list;
                }
                Intrinsics3.checkNotNullExpressionValue(list, "messages");
                Intrinsics3.checkNotNullExpressionValue(list2, "localMessages");
                return _Collections.plus((Collection) list, (Iterable) list2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ges + localMessages\n    }");
        return observableI;
    }

    public final Observable<MessageQueue4> resendMessage(Message message, boolean isAutoAttempt, CaptchaHelper.CaptchaPayload captchaPayload) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Integer type;
        Integer type2;
        Integer type3;
        Intrinsics3.checkNotNullParameter(message, "message");
        if ((isAutoAttempt && (((type2 = message.getType()) == null || type2.intValue() != -1) && ((type3 = message.getType()) == null || type3.intValue() != -6))) || (!isAutoAttempt && ((type = message.getType()) == null || type.intValue() != -2))) {
            throw new IllegalArgumentException("Incorrect " + isAutoAttempt + " auto attempt and message type " + message.getType());
        }
        this.dispatcher.schedule(new AnonymousClass1(message));
        Integer numRetries = message.getNumRetries();
        int iIntValue = numRetries != null ? numRetries.intValue() : 0;
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        Intrinsics3.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        String content = message.getContent();
        if (content == null) {
            content = "";
        }
        List<User> mentions = message.getMentions();
        if (mentions != null) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it = mentions.iterator();
            while (it.hasNext()) {
                arrayList.add(new CoreUser((User) it.next()));
            }
        } else {
            arrayList = null;
        }
        List<LocalAttachment> localAttachments = message.getLocalAttachments();
        if (localAttachments != null) {
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(localAttachments, 10));
            for (LocalAttachment localAttachment : localAttachments) {
                Uri uri = Uri.parse(localAttachment.getUriString());
                long id2 = localAttachment.getId();
                Intrinsics3.checkNotNullExpressionValue(uri, "contentUri");
                arrayList2.add(new Attachment(id2, uri, localAttachment.getDisplayName(), null, false, 16, null));
            }
        } else {
            arrayList2 = null;
        }
        return sendMessage$default(this, channelId, coreUser, content, arrayList, arrayList2, null, message.getMessageReference(), message.getAllowedMentions(), null, null, null, isAutoAttempt ? message.getLastManualAttemptTimestamp() : null, message.getInitialAttemptTimestamp(), Integer.valueOf(iIntValue + 1), captchaPayload, 1824, null);
    }

    public final void resendMessageWithCaptcha(long channelId, String nonce, CaptchaHelper.CaptchaPayload captchaPayload) {
        Message message;
        Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(resendMessage(message, true, captchaPayload)), (Class<?>) StoreMessages.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.util.List] */
    public final Observable<MessageQueue4> sendMessage(long channelId, com.discord.models.user.User author, String content, List<? extends com.discord.models.user.User> mentions, List<? extends Attachment<?>> attachments, List<? extends BaseSticker> stickers, MessageReference messageReference, MessageAllowedMentions allowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long lastManualAttemptTimestamp, Long initialAttemptTimestamp, Integer numRetries, CaptchaHelper.CaptchaPayload captchaPayload) {
        List listEmptyList;
        ArrayList arrayList;
        String content2 = content;
        Intrinsics3.checkNotNullParameter(author, "author");
        Intrinsics3.checkNotNullParameter(content2, "content");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = attachments;
        if (!(attachments == 0 || attachments.isEmpty())) {
            SendUtils3.Companion companion = SendUtils3.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            SendUtils3 sendUtils3FromAttachments = companion.fromAttachments(attachments, content2, context);
            List<Attachment<?>> invalidAttachments = sendUtils3FromAttachments.getInvalidAttachments();
            if (!invalidAttachments.isEmpty()) {
                User userSynthesizeApiUser = UserUtils.INSTANCE.synthesizeApiUser(author);
                Clock clock = this.clock;
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(invalidAttachments, 10));
                Iterator<T> it = invalidAttachments.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AttachmentUtils.toLocalAttachment((Attachment) it.next()));
                }
                this.dispatcher.schedule(new AnonymousClass1(LocalMessageCreators.createInvalidAttachmentsMessage(channelId, userSynthesizeApiUser, clock, arrayList2)));
            }
            ref$ObjectRef.element = sendUtils3FromAttachments.getValidAttachments();
            content2 = sendUtils3FromAttachments.getContent();
            List list = (List) ref$ObjectRef.element;
            if (list == null || list.isEmpty()) {
                if (content2.length() == 0) {
                    Observable<MessageQueue4> observableO = Observable.o(new Action1<Emitter<MessageQueue4>>() { // from class: com.discord.stores.StoreMessages.sendMessage.2
                        @Override // rx.functions.Action1
                        public final void call(Emitter<MessageQueue4> emitter) {
                            emitter.onNext(MessageQueue4.NoValidContent.INSTANCE);
                            emitter.onCompleted();
                        }
                    }, Emitter.BackpressureMode.ERROR);
                    Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({ emit…r.BackpressureMode.ERROR)");
                    return observableO;
                }
            }
        }
        long jLongValue = lastManualAttemptTimestamp != null ? lastManualAttemptTimestamp.longValue() : this.clock.currentTimeMillis();
        User userSynthesizeApiUser2 = UserUtils.INSTANCE.synthesizeApiUser(author);
        if (mentions != null) {
            listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it2 = mentions.iterator();
            while (it2.hasNext()) {
                listEmptyList.add(UserUtils.INSTANCE.synthesizeApiUser((com.discord.models.user.User) it2.next()));
            }
        } else {
            listEmptyList = Collections2.emptyList();
        }
        List list2 = listEmptyList;
        List list3 = (List) ref$ObjectRef.element;
        boolean z2 = !(list3 == null || list3.isEmpty());
        Clock clock2 = this.clock;
        List list4 = (List) ref$ObjectRef.element;
        if (list4 != null) {
            ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list4, 10));
            Iterator it3 = list4.iterator();
            while (it3.hasNext()) {
                arrayList3.add(AttachmentUtils.toLocalAttachment((Attachment) it3.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        Message messageCreateLocalMessage = LocalMessageCreators.createLocalMessage(content2, channelId, userSynthesizeApiUser2, list2, false, z2, application, messageActivity, clock2, arrayList, Long.valueOf(jLongValue), Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : this.clock.currentTimeMillis()), Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), stickers, messageReference, allowedMentions, captchaPayload);
        if (messageActivity == null) {
            this.dispatcher.schedule(new AnonymousClass3(messageCreateLocalMessage));
        }
        this.dispatcher.schedule(new AnonymousClass4());
        return enqueueRequest(channelId, new StoreMessages3(this, messageCreateLocalMessage, ref$ObjectRef, activity, jLongValue));
    }

    @Store3
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
        Observable<Message> observableR = observeMessagesForChannel(channelId).G(new Func1<List<? extends Message>, Message>() { // from class: com.discord.stores.StoreMessages.observeMessagesForChannel.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Message call(List<? extends Message> list) {
                return call2((List<Message>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Message call2(List<Message> list) {
                T next;
                Intrinsics3.checkNotNullExpressionValue(list, "messages");
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
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeMessagesForChanne…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<MessageQueue4> sendMessage(Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> attachments) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandLocalSendData");
        this.dispatcher.schedule(new AnonymousClass5(message));
        return enqueueRequest(message.getChannelId(), new StoreMessages4(this, message, applicationCommandLocalSendData, attachments));
    }
}
