package com.discord.utilities.messagesend;

import android.content.ContentResolver;
import android.content.Context;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams$Message;
import com.discord.restapi.RestAPIParams$Message$Activity;
import com.discord.restapi.RestAPIParams$Message$AllowedMentions;
import com.discord.restapi.RestAPIParams$Message$MessageReference;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.error.Error$Type;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rest.SendUtils$SendPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue {
    private static final MessageQueue$Companion Companion = new MessageQueue$Companion(null);

    @Deprecated
    private static final long DEFAULT_MESSAGE_TIMEOUT_MS = 3600000;

    @Deprecated
    private static final long DEFAULT_NETWORK_INITIAL_FAILURE_RETRY_MS = 5000;

    @Deprecated
    private static final long DEFAULT_RETRY_MS = 100;
    private final Clock clock;
    private final ContentResolver contentResolver;
    private final ExecutorService executorService;
    private MessageQueue$InflightRequest inFlightRequest;
    private boolean isDraining;
    private final Backoff networkBackoff;
    private final ArrayDeque<MessageRequest> queue;
    private Subscription retrySubscription;

    public MessageQueue(ContentResolver contentResolver, ExecutorService executorService, Clock clock) {
        m.checkNotNullParameter(contentResolver, "contentResolver");
        m.checkNotNullParameter(executorService, "executorService");
        m.checkNotNullParameter(clock, "clock");
        this.contentResolver = contentResolver;
        this.executorService = executorService;
        this.clock = clock;
        this.queue = new ArrayDeque<>();
        this.networkBackoff = new Backoff(5000L, DEFAULT_MESSAGE_TIMEOUT_MS, 0, false, null, 28, null);
    }

    public static final /* synthetic */ ExecutorService access$getExecutorService$p(MessageQueue messageQueue) {
        return messageQueue.executorService;
    }

    public static final /* synthetic */ MessageQueue$InflightRequest access$getInFlightRequest$p(MessageQueue messageQueue) {
        return messageQueue.inFlightRequest;
    }

    public static final /* synthetic */ Backoff access$getNetworkBackoff$p(MessageQueue messageQueue) {
        return messageQueue.networkBackoff;
    }

    public static final /* synthetic */ ArrayDeque access$getQueue$p(MessageQueue messageQueue) {
        return messageQueue.queue;
    }

    public static final /* synthetic */ Subscription access$getRetrySubscription$p(MessageQueue messageQueue) {
        return messageQueue.retrySubscription;
    }

    public static final /* synthetic */ void access$handleError(MessageQueue messageQueue, Error error, MessageQueue$DrainListener messageQueue$DrainListener, Message message) {
        messageQueue.handleError(error, messageQueue$DrainListener, message);
    }

    public static final /* synthetic */ void access$handleSuccess(MessageQueue messageQueue, com.discord.api.message.Message message, MessageQueue$DrainListener messageQueue$DrainListener) {
        messageQueue.handleSuccess(message, messageQueue$DrainListener);
    }

    public static final /* synthetic */ void access$onDrainingCompleted(MessageQueue messageQueue) {
        messageQueue.onDrainingCompleted();
    }

    public static final /* synthetic */ void access$processNextRequest(MessageQueue messageQueue) {
        messageQueue.processNextRequest();
    }

    public static final /* synthetic */ void access$setInFlightRequest$p(MessageQueue messageQueue, MessageQueue$InflightRequest messageQueue$InflightRequest) {
        messageQueue.inFlightRequest = messageQueue$InflightRequest;
    }

    public static final /* synthetic */ void access$setRetrySubscription$p(MessageQueue messageQueue, Subscription subscription) {
        messageQueue.retrySubscription = subscription;
    }

    private final void doEdit(MessageRequest$Edit editRequest, MessageQueue$DrainListener drainListener) {
        RestAPI api = RestAPI.Companion.getApi();
        long channelId = editRequest.getChannelId();
        long messageId = editRequest.getMessageId();
        String content = editRequest.getContent();
        MessageAllowedMentions allowedMentions = editRequest.getAllowedMentions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(api.editMessage(channelId, messageId, new RestAPIParams$Message(content, null, null, null, null, null, allowedMentions != null ? RestAPIParams$Message$AllowedMentions.Companion.create(allowedMentions) : null, null, null, 444, null)), false), MessageQueue.class, (Context) null, new MessageQueue$doEdit$4(this, editRequest, drainListener), new MessageQueue$doEdit$3(this, drainListener), (Function0) null, (Function0) null, new MessageQueue$doEdit$2(this, drainListener), 50, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:52:0x0100  */
    private final void doSend(MessageRequest$Send request, MessageQueue$DrainListener drainListener) {
        RestAPIParams$Message$Activity restAPIParams$Message$Activity;
        RestAPIParams$Message$MessageReference restAPIParams$Message$MessageReference;
        ArrayList arrayList;
        ArrayList arrayList2;
        CaptchaHelper$CaptchaPayload captchaPayload;
        String captchaKey;
        String sessionId;
        MessageResult$ValidationError messageResult$ValidationErrorValidateMessage = request.validateMessage();
        if (messageResult$ValidationErrorValidateMessage != null) {
            drainListener.complete(messageResult$ValidationErrorValidateMessage);
            return;
        }
        Message message = request.getMessage();
        boolean z2 = message.getNonce() != null;
        MessageActivity activity = message.getActivity();
        if (activity != null) {
            Activity activity2 = request.getActivity();
            restAPIParams$Message$Activity = (activity2 == null || (sessionId = activity2.getSessionId()) == null) ? null : new RestAPIParams$Message$Activity(activity.getType(), activity.getPartyId(), sessionId);
        } else {
            restAPIParams$Message$Activity = null;
        }
        MessageReference messageReference = message.getMessageReference();
        if (messageReference != null) {
            Long guildId = messageReference.getGuildId();
            Long channelId = messageReference.getChannelId();
            m.checkNotNull(channelId);
            restAPIParams$Message$MessageReference = new RestAPIParams$Message$MessageReference(guildId, channelId.longValue(), messageReference.getMessageId());
        } else {
            restAPIParams$Message$MessageReference = null;
        }
        MessageAllowedMentions allowedMentions = message.getAllowedMentions();
        RestAPIParams$Message$AllowedMentions restAPIParams$Message$AllowedMentionsCreate = allowedMentions != null ? RestAPIParams$Message$AllowedMentions.Companion.create(allowedMentions) : null;
        String content = message.getContent();
        String nonce = message.getNonce();
        Application application = message.getApplication();
        Long lValueOf = application != null ? Long.valueOf(application.getId()) : null;
        List<StickerPartial> stickerItems = message.getStickerItems();
        if (stickerItems == null) {
            List<Sticker> stickers = message.getStickers();
            if (stickers != null) {
                arrayList2 = new ArrayList(o.collectionSizeOrDefault(stickers, 10));
                Iterator<T> it = stickers.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((Sticker) it.next()).getId()));
                }
            } else {
                arrayList = null;
            }
            captchaPayload = message.getCaptchaPayload();
            if (captchaPayload != null) {
                captchaKey = captchaPayload.getCaptchaKey();
            } else {
                captchaKey = null;
            }
            CaptchaHelper$CaptchaPayload captchaPayload2 = message.getCaptchaPayload();
            Observable<SendUtils$SendPayload> observableU = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams$Message(content, nonce, lValueOf, restAPIParams$Message$Activity, arrayList, restAPIParams$Message$MessageReference, restAPIParams$Message$AllowedMentionsCreate, captchaKey, captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null), request.getAttachments()).u(new MessageQueue$doSend$1(request));
            m.checkNotNullExpressionValue(observableU, "SendUtils\n        .getSe…  }\n          }\n        }");
            Observable<R> observableG = observableU.y(MessageQueue$doSend$$inlined$filterIs$1.INSTANCE).G(MessageQueue$doSend$$inlined$filterIs$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
            Observable observableA = observableG.Z(1).A(new MessageQueue$doSend$2(message));
            m.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…ge)\n          }\n        }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(observableA, z2), MessageQueue.class, (Context) null, new MessageQueue$doSend$5(this, request, drainListener), new MessageQueue$doSend$4(this, drainListener, message), (Function0) null, (Function0) null, new MessageQueue$doSend$3(this, drainListener), 50, (Object) null);
        }
        arrayList2 = new ArrayList(o.collectionSizeOrDefault(stickerItems, 10));
        Iterator<T> it2 = stickerItems.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((StickerPartial) it2.next()).getId()));
        }
        arrayList = arrayList2;
        captchaPayload = message.getCaptchaPayload();
        if (captchaPayload != null) {
            captchaKey = captchaPayload.getCaptchaKey();
        } else {
            captchaKey = null;
        }
        CaptchaHelper$CaptchaPayload captchaPayload3 = message.getCaptchaPayload();
        Observable<SendUtils$SendPayload> observableU2 = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams$Message(content, nonce, lValueOf, restAPIParams$Message$Activity, arrayList, restAPIParams$Message$MessageReference, restAPIParams$Message$AllowedMentionsCreate, captchaKey, captchaPayload3 != null ? captchaPayload3.getCaptchaRqtoken() : null), request.getAttachments()).u(new MessageQueue$doSend$1(request));
        m.checkNotNullExpressionValue(observableU2, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableG2 = observableU2.y(MessageQueue$doSend$$inlined$filterIs$1.INSTANCE).G(MessageQueue$doSend$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "filter { it is T }.map { it as T }");
        Observable observableA2 = observableG2.Z(1).A(new MessageQueue$doSend$2(message));
        m.checkNotNullExpressionValue(observableA2, "SendUtils\n        .getSe…ge)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(observableA2, z2), MessageQueue.class, (Context) null, new MessageQueue$doSend$5(this, request, drainListener), new MessageQueue$doSend$4(this, drainListener, message), (Function0) null, (Function0) null, new MessageQueue$doSend$3(this, drainListener), 50, (Object) null);
    }

    private final void doSendApplicationCommand(MessageRequest$SendApplicationCommand sendApplicationCommandRequest, MessageQueue$DrainListener drainListener) {
        Observable<SendUtils$SendPayload> observableU = SendUtils.INSTANCE.getSendCommandPayload(this.contentResolver, sendApplicationCommandRequest.getApplicationCommandSendData(), sendApplicationCommandRequest.getAttachments()).u(new MessageQueue$doSendApplicationCommand$1(sendApplicationCommandRequest));
        m.checkNotNullExpressionValue(observableU, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableG = observableU.y(MessageQueue$doSendApplicationCommand$$inlined$filterIs$1.INSTANCE).G(MessageQueue$doSendApplicationCommand$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable observableA = observableG.z().A(MessageQueue$doSendApplicationCommand$2.INSTANCE);
        m.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…())\n          }\n        }");
        Observable observableRestSubscribeOn = ObservableExtensionsKt.restSubscribeOn(observableA, false);
        MessageQueue$doSendApplicationCommand$3 messageQueue$doSendApplicationCommand$3 = new MessageQueue$doSendApplicationCommand$3(this, sendApplicationCommandRequest, drainListener);
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn, MessageQueue.class, (Context) null, new MessageQueue$doSendApplicationCommand$5(this, sendApplicationCommandRequest, drainListener), new MessageQueue$doSendApplicationCommand$4(this, drainListener), (Function0) null, (Function0) null, messageQueue$doSendApplicationCommand$3, 50, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008e  */
    /* JADX WARN: Code duplicated, block: B:25:0x009e  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a5  */
    private final void handleError(Error error, MessageQueue$DrainListener onDrainListener, Message clientMessage) {
        Error$Response response;
        MessageResult messageResult$UnknownFailure;
        MessageResult messageResult$AutoModBlock;
        Long l;
        Error$Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getCode() == 20016) {
            Error$Response response3 = error.getResponse();
            m.checkNotNullExpressionValue(response3, "error.response");
            Long retryAfterMs = response3.getRetryAfterMs();
            l = retryAfterMs != null ? retryAfterMs : 100L;
            m.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            messageResult$UnknownFailure = new MessageResult$Slowmode(l.longValue());
        } else if (error.getType() == Error$Type.RATE_LIMITED) {
            Error$Response response4 = error.getResponse();
            m.checkNotNullExpressionValue(response4, "error.response");
            Long retryAfterMs2 = response4.getRetryAfterMs();
            l = retryAfterMs2 != null ? retryAfterMs2 : 100L;
            m.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            messageResult$UnknownFailure = new MessageResult$RateLimited(l.longValue());
        } else if (error.getType() == Error$Type.NETWORK) {
            messageResult$UnknownFailure = MessageResult$NetworkFailure.INSTANCE;
        } else if (error.getType() == Error$Type.DISCORD_BAD_REQUEST) {
            Error$Response response5 = error.getResponse();
            m.checkNotNullExpressionValue(response5, "error.response");
            if (!response5.getMessages().containsKey(CaptchaHelper.CAPTCHA_KEY) || clientMessage == null) {
                response = error.getResponse();
                m.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 200000) {
                    messageResult$AutoModBlock = new MessageResult$AutoModBlock(error, clientMessage);
                } else {
                    messageResult$UnknownFailure = new MessageResult$UnknownFailure(error);
                }
            } else {
                messageResult$AutoModBlock = new MessageResult$CaptchaRequired(error, clientMessage.getChannelId(), clientMessage.getNonce());
            }
            messageResult$UnknownFailure = messageResult$AutoModBlock;
        } else {
            response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() == 200000) {
                messageResult$AutoModBlock = new MessageResult$AutoModBlock(error, clientMessage);
                messageResult$UnknownFailure = messageResult$AutoModBlock;
            } else {
                messageResult$UnknownFailure = new MessageResult$UnknownFailure(error);
            }
        }
        onDrainListener.complete(messageResult$UnknownFailure);
    }

    public static /* synthetic */ void handleError$default(MessageQueue messageQueue, Error error, MessageQueue$DrainListener messageQueue$DrainListener, Message message, int i, Object obj) {
        if ((i & 4) != 0) {
            message = null;
        }
        messageQueue.handleError(error, messageQueue$DrainListener, message);
    }

    private final void handleSuccess(com.discord.api.message.Message message, MessageQueue$DrainListener drainListener) {
        drainListener.complete(new MessageResult$Success(message));
    }

    private final void onDrainingCompleted() {
        this.isDraining = false;
        this.inFlightRequest = null;
    }

    private final void processNextRequest() {
        MessageRequest messageRequestRemove;
        if (this.queue.isEmpty() || this.retrySubscription != null || this.networkBackoff.getIsPending() || this.isDraining || (messageRequestRemove = this.queue.remove()) == null) {
            return;
        }
        if (this.clock.currentTimeMillis() - messageRequestRemove.getAttemptTimestamp() > DEFAULT_MESSAGE_TIMEOUT_MS) {
            messageRequestRemove.getOnCompleted().invoke(MessageResult$Timeout.INSTANCE, Boolean.valueOf(this.queue.isEmpty()));
            this.networkBackoff.succeed();
            processNextRequest();
            return;
        }
        this.isDraining = true;
        MessageQueue$DrainListener messageQueue$DrainListener = new MessageQueue$DrainListener(new MessageQueue$processNextRequest$listener$1(this, messageRequestRemove));
        if (messageRequestRemove instanceof MessageRequest$Send) {
            doSend((MessageRequest$Send) messageRequestRemove, messageQueue$DrainListener);
        } else if (messageRequestRemove instanceof MessageRequest$Edit) {
            doEdit((MessageRequest$Edit) messageRequestRemove, messageQueue$DrainListener);
        } else if (messageRequestRemove instanceof MessageRequest$SendApplicationCommand) {
            doSendApplicationCommand((MessageRequest$SendApplicationCommand) messageRequestRemove, messageQueue$DrainListener);
        }
    }

    public final void cancel(String requestId) {
        m.checkNotNullParameter(requestId, "requestId");
        this.executorService.submit(new MessageQueue$cancel$1(this, requestId));
    }

    public final void enqueue(MessageRequest request) {
        m.checkNotNullParameter(request, "request");
        this.executorService.submit(new MessageQueue$enqueue$1(this, request));
    }

    public final void handleConnected() {
        this.executorService.submit(new MessageQueue$handleConnected$1(this));
    }
}
