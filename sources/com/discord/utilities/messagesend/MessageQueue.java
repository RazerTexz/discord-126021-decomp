package com.discord.utilities.messagesend;

import android.content.ContentResolver;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.message.Message;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long DEFAULT_MESSAGE_TIMEOUT_MS = 3600000;

    @Deprecated
    private static final long DEFAULT_NETWORK_INITIAL_FAILURE_RETRY_MS = 5000;

    @Deprecated
    private static final long DEFAULT_RETRY_MS = 100;
    private final Clock clock;
    private final ContentResolver contentResolver;
    private final ExecutorService executorService;
    private InflightRequest inFlightRequest;
    private boolean isDraining;
    private final Backoff networkBackoff;
    private final ArrayDeque<MessageQueue3> queue;
    private Subscription retrySubscription;

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class DrainListener {
        private AtomicBoolean isCompleted;
        private final Function1<MessageQueue4, Unit> onCompleted;

        /* JADX WARN: Multi-variable type inference failed */
        public DrainListener(Function1<? super MessageQueue4, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "onCompleted");
            this.onCompleted = function1;
            this.isCompleted = new AtomicBoolean(false);
        }

        public final synchronized void complete(MessageQueue4 result) {
            Intrinsics3.checkNotNullParameter(result, "result");
            if (!this.isCompleted.getAndSet(true)) {
                this.onCompleted.invoke(result);
            }
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class InflightRequest {
        private final MessageQueue3 baseRequest;
        private final DrainListener drainListener;
        private final Subscription networkSubscription;

        public InflightRequest(MessageQueue3 messageQueue3, Subscription subscription, DrainListener drainListener) {
            Intrinsics3.checkNotNullParameter(messageQueue3, "baseRequest");
            Intrinsics3.checkNotNullParameter(subscription, "networkSubscription");
            Intrinsics3.checkNotNullParameter(drainListener, "drainListener");
            this.baseRequest = messageQueue3;
            this.networkSubscription = subscription;
            this.drainListener = drainListener;
        }

        public final MessageQueue3 getBaseRequest() {
            return this.baseRequest;
        }

        public final DrainListener getDrainListener() {
            return this.drainListener;
        }

        public final Subscription getNetworkSubscription() {
            return this.networkSubscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$2, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            MessageQueue.this.handleSuccess(message, this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$3, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.handleError$default(MessageQueue.this, error, this.$drainListener, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$4, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.Edit $editRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(MessageQueue3.Edit edit, DrainListener drainListener) {
            super(1);
            this.$editRequest = edit;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.this.inFlightRequest = new InflightRequest(this.$editRequest, subscription, this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$3, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            MessageQueue messageQueue = MessageQueue.this;
            Intrinsics3.checkNotNullExpressionValue(message, "resultMessage");
            messageQueue.handleSuccess(message, this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$4, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ com.discord.models.message.Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DrainListener drainListener, com.discord.models.message.Message message) {
            super(1);
            this.$drainListener = drainListener;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.this.handleError(error, this.$drainListener, this.$message);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$5, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.Send $request;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(MessageQueue3.Send send, DrainListener drainListener) {
            super(1);
            this.$request = send;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.this.inFlightRequest = new InflightRequest(this.$request, subscription, this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$3, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(MessageQueue3.SendApplicationCommand sendApplicationCommand, DrainListener drainListener) {
            super(1);
            this.$sendApplicationCommandRequest = sendApplicationCommand;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            MessageQueue.this.handleSuccess(this.$sendApplicationCommandRequest.getMessage(), this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$4, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.handleError$default(MessageQueue.this, error, this.$drainListener, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$5, reason: invalid class name */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(MessageQueue3.SendApplicationCommand sendApplicationCommand, DrainListener drainListener) {
            super(1);
            this.$sendApplicationCommandRequest = sendApplicationCommand;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.this.inFlightRequest = new InflightRequest(this.$sendApplicationCommandRequest, subscription, this.$drainListener);
        }
    }

    public MessageQueue(ContentResolver contentResolver, ExecutorService executorService, Clock clock) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(executorService, "executorService");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.contentResolver = contentResolver;
        this.executorService = executorService;
        this.clock = clock;
        this.queue = new ArrayDeque<>();
        this.networkBackoff = new Backoff(5000L, DEFAULT_MESSAGE_TIMEOUT_MS, 0, false, null, 28, null);
    }

    private final void doEdit(MessageQueue3.Edit editRequest, DrainListener drainListener) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long channelId = editRequest.getChannelId();
        long messageId = editRequest.getMessageId();
        String content = editRequest.getContent();
        MessageAllowedMentions allowedMentions = editRequest.getAllowedMentions();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(api.editMessage(channelId, messageId, new RestAPIParams.Message(content, null, null, null, null, null, allowedMentions != null ? RestAPIParams.Message.AllowedMentions.INSTANCE.create(allowedMentions) : null, null, null, 444, null)), false), (Class<?>) MessageQueue.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass4(editRequest, drainListener)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(drainListener)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(drainListener));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:52:0x0100  */
    private final void doSend(final MessageQueue3.Send request, DrainListener drainListener) {
        RestAPIParams.Message.Activity activity;
        RestAPIParams.Message.MessageReference messageReference;
        ArrayList arrayList;
        ArrayList arrayList2;
        CaptchaHelper.CaptchaPayload captchaPayload;
        String captchaKey;
        String sessionId;
        MessageQueue4.ValidationError validationErrorValidateMessage = request.validateMessage();
        if (validationErrorValidateMessage != null) {
            drainListener.complete(validationErrorValidateMessage);
            return;
        }
        final com.discord.models.message.Message message = request.getMessage();
        boolean z2 = message.getNonce() != null;
        MessageActivity activity2 = message.getActivity();
        if (activity2 != null) {
            Activity activity3 = request.getActivity();
            activity = (activity3 == null || (sessionId = activity3.getSessionId()) == null) ? null : new RestAPIParams.Message.Activity(activity2.getType(), activity2.getPartyId(), sessionId);
        } else {
            activity = null;
        }
        MessageReference messageReference2 = message.getMessageReference();
        if (messageReference2 != null) {
            Long guildId = messageReference2.getGuildId();
            Long channelId = messageReference2.getChannelId();
            Intrinsics3.checkNotNull(channelId);
            messageReference = new RestAPIParams.Message.MessageReference(guildId, channelId.longValue(), messageReference2.getMessageId());
        } else {
            messageReference = null;
        }
        MessageAllowedMentions allowedMentions = message.getAllowedMentions();
        RestAPIParams.Message.AllowedMentions allowedMentionsCreate = allowedMentions != null ? RestAPIParams.Message.AllowedMentions.INSTANCE.create(allowedMentions) : null;
        String content = message.getContent();
        String nonce = message.getNonce();
        Application application = message.getApplication();
        Long lValueOf = application != null ? Long.valueOf(application.getId()) : null;
        List<StickerPartial> stickerItems = message.getStickerItems();
        if (stickerItems == null) {
            List<Sticker> stickers = message.getStickers();
            if (stickers != null) {
                arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(stickers, 10));
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
            CaptchaHelper.CaptchaPayload captchaPayload2 = message.getCaptchaPayload();
            Observable<SendUtils.SendPayload> observableU = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams.Message(content, nonce, lValueOf, activity, arrayList, messageReference, allowedMentionsCreate, captchaKey, captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null), request.getAttachments()).u(new Action1<SendUtils.SendPayload>() { // from class: com.discord.utilities.messagesend.MessageQueue.doSend.1
                @Override // rx.functions.Action1
                public final void call(SendUtils.SendPayload sendPayload) {
                    if (sendPayload instanceof SendUtils.SendPayload.Preprocessing) {
                        request.getOnPreprocessing().invoke(sendPayload);
                    } else if (sendPayload instanceof SendUtils.SendPayload.ReadyToSend) {
                        SendUtils.SendPayload.ReadyToSend readyToSend = (SendUtils.SendPayload.ReadyToSend) sendPayload;
                        if (!readyToSend.getUploads().isEmpty()) {
                            request.getOnProgress().invoke(readyToSend.getUploads());
                        }
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableU, "SendUtils\n        .getSe…  }\n          }\n        }");
            Observable<R> observableG = observableU.y(new Func1<Object, Boolean>() { // from class: com.discord.utilities.messagesend.MessageQueue$doSend$$inlined$filterIs$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // j0.k.Func1
                public final Boolean call(Object obj) {
                    return Boolean.valueOf(obj instanceof SendUtils.SendPayload.ReadyToSend);
                }
            }).G(new Func1<Object, T>() { // from class: com.discord.utilities.messagesend.MessageQueue$doSend$$inlined$filterIs$2
                @Override // j0.k.Func1
                public final T call(Object obj) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.utilities.rest.SendUtils.SendPayload.ReadyToSend");
                    return (T) ((SendUtils.SendPayload.ReadyToSend) obj);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
            Observable observableA = observableG.Z(1).A(new Func1<SendUtils.SendPayload.ReadyToSend, Observable<? extends Message>>() { // from class: com.discord.utilities.messagesend.MessageQueue.doSend.2
                @Override // j0.k.Func1
                public final Observable<? extends Message> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
                    List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
                    ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
                    Iterator<T> it2 = uploads.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((SendUtils.FileUpload) it2.next()).getPart());
                    }
                    if (!(!arrayList3.isEmpty())) {
                        return RestAPI.INSTANCE.getApi().sendMessage(message.getChannelId(), readyToSend.getMessage());
                    }
                    RestAPI api = RestAPI.INSTANCE.getApi();
                    long channelId2 = message.getChannelId();
                    PayloadJSON<RestAPIParams.Message> payloadJSON = new PayloadJSON<>(readyToSend.getMessage());
                    Object[] array = arrayList3.toArray(new MultipartBody.Part[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return api.sendMessage(channelId2, payloadJSON, (MultipartBody.Part[]) array);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…ge)\n          }\n        }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(observableA, z2), (Class<?>) MessageQueue.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass5(request, drainListener)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass4(drainListener, message)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(drainListener));
        }
        arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(stickerItems, 10));
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
        CaptchaHelper.CaptchaPayload captchaPayload3 = message.getCaptchaPayload();
        Observable<SendUtils.SendPayload> observableU2 = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams.Message(content, nonce, lValueOf, activity, arrayList, messageReference, allowedMentionsCreate, captchaKey, captchaPayload3 != null ? captchaPayload3.getCaptchaRqtoken() : null), request.getAttachments()).u(new Action1<SendUtils.SendPayload>() { // from class: com.discord.utilities.messagesend.MessageQueue.doSend.1
            @Override // rx.functions.Action1
            public final void call(SendUtils.SendPayload sendPayload) {
                if (sendPayload instanceof SendUtils.SendPayload.Preprocessing) {
                    request.getOnPreprocessing().invoke(sendPayload);
                } else if (sendPayload instanceof SendUtils.SendPayload.ReadyToSend) {
                    SendUtils.SendPayload.ReadyToSend readyToSend = (SendUtils.SendPayload.ReadyToSend) sendPayload;
                    if (!readyToSend.getUploads().isEmpty()) {
                        request.getOnProgress().invoke(readyToSend.getUploads());
                    }
                }
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU2, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableG2 = observableU2.y(new Func1<Object, Boolean>() { // from class: com.discord.utilities.messagesend.MessageQueue$doSend$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof SendUtils.SendPayload.ReadyToSend);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.utilities.messagesend.MessageQueue$doSend$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.utilities.rest.SendUtils.SendPayload.ReadyToSend");
                return (T) ((SendUtils.SendPayload.ReadyToSend) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG2, "filter { it is T }.map { it as T }");
        Observable observableA2 = observableG2.Z(1).A(new Func1<SendUtils.SendPayload.ReadyToSend, Observable<? extends Message>>() { // from class: com.discord.utilities.messagesend.MessageQueue.doSend.2
            @Override // j0.k.Func1
            public final Observable<? extends Message> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
                List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
                ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
                Iterator<T> it3 = uploads.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(((SendUtils.FileUpload) it3.next()).getPart());
                }
                if (!(!arrayList3.isEmpty())) {
                    return RestAPI.INSTANCE.getApi().sendMessage(message.getChannelId(), readyToSend.getMessage());
                }
                RestAPI api = RestAPI.INSTANCE.getApi();
                long channelId2 = message.getChannelId();
                PayloadJSON<RestAPIParams.Message> payloadJSON = new PayloadJSON<>(readyToSend.getMessage());
                Object[] array = arrayList3.toArray(new MultipartBody.Part[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return api.sendMessage(channelId2, payloadJSON, (MultipartBody.Part[]) array);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA2, "SendUtils\n        .getSe…ge)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(observableA2, z2), (Class<?>) MessageQueue.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass5(request, drainListener)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass4(drainListener, message)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(drainListener));
    }

    private final void doSendApplicationCommand(final MessageQueue3.SendApplicationCommand sendApplicationCommandRequest, DrainListener drainListener) {
        Observable<SendUtils.SendPayload> observableU = SendUtils.INSTANCE.getSendCommandPayload(this.contentResolver, sendApplicationCommandRequest.getApplicationCommandSendData(), sendApplicationCommandRequest.getAttachments()).u(new Action1<SendUtils.SendPayload>() { // from class: com.discord.utilities.messagesend.MessageQueue.doSendApplicationCommand.1
            @Override // rx.functions.Action1
            public final void call(SendUtils.SendPayload sendPayload) {
                if (sendPayload instanceof SendUtils.SendPayload.Preprocessing) {
                    sendApplicationCommandRequest.getOnPreprocessing().invoke(sendPayload);
                } else if (sendPayload instanceof SendUtils.SendPayload.ReadyToSendCommand) {
                    SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand = (SendUtils.SendPayload.ReadyToSendCommand) sendPayload;
                    if (!readyToSendCommand.getUploads().isEmpty()) {
                        sendApplicationCommandRequest.getOnProgress().invoke(readyToSendCommand.getUploads());
                    }
                }
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableG = observableU.y(new Func1<Object, Boolean>() { // from class: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof SendUtils.SendPayload.ReadyToSendCommand);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.utilities.rest.SendUtils.SendPayload.ReadyToSendCommand");
                return (T) ((SendUtils.SendPayload.ReadyToSendCommand) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable observableA = observableG.z().A(new Func1<SendUtils.SendPayload.ReadyToSendCommand, Observable<? extends Void>>() { // from class: com.discord.utilities.messagesend.MessageQueue.doSendApplicationCommand.2
            @Override // j0.k.Func1
            public final Observable<? extends Void> call(SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand) {
                List<SendUtils.FileUpload> uploads = readyToSendCommand.getUploads();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
                Iterator<T> it = uploads.iterator();
                while (it.hasNext()) {
                    arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
                }
                if (!(!arrayList.isEmpty())) {
                    return RestAPI.INSTANCE.getApi().sendApplicationCommand(readyToSendCommand.getCommand().toRestApiParam());
                }
                PayloadJSON<RestAPIParams.ApplicationCommand> payloadJSON = new PayloadJSON<>(readyToSendCommand.getCommand().toRestApiParam());
                RestAPI api = RestAPI.INSTANCE.getApi();
                Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return api.sendApplicationCommand(payloadJSON, (MultipartBody.Part[]) array);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…())\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(observableA, false), (Class<?>) MessageQueue.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass5(sendApplicationCommandRequest, drainListener)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass4(drainListener)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(sendApplicationCommandRequest, drainListener));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008e  */
    /* JADX WARN: Code duplicated, block: B:25:0x009e  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a5  */
    private final void handleError(Error error, DrainListener onDrainListener, com.discord.models.message.Message clientMessage) {
        Error.Response response;
        MessageQueue4 unknownFailure;
        MessageQueue4 autoModBlock;
        Long l;
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getCode() == 20016) {
            Error.Response response3 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
            Long retryAfterMs = response3.getRetryAfterMs();
            l = retryAfterMs != null ? retryAfterMs : 100L;
            Intrinsics3.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            unknownFailure = new MessageQueue4.Slowmode(l.longValue());
        } else if (error.getType() == Error.Type.RATE_LIMITED) {
            Error.Response response4 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response4, "error.response");
            Long retryAfterMs2 = response4.getRetryAfterMs();
            l = retryAfterMs2 != null ? retryAfterMs2 : 100L;
            Intrinsics3.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            unknownFailure = new MessageQueue4.RateLimited(l.longValue());
        } else if (error.getType() == Error.Type.NETWORK) {
            unknownFailure = MessageQueue4.NetworkFailure.INSTANCE;
        } else if (error.getType() == Error.Type.DISCORD_BAD_REQUEST) {
            Error.Response response5 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response5, "error.response");
            if (!response5.getMessages().containsKey(CaptchaHelper.CAPTCHA_KEY) || clientMessage == null) {
                response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 200000) {
                    autoModBlock = new MessageQueue4.AutoModBlock(error, clientMessage);
                } else {
                    unknownFailure = new MessageQueue4.UnknownFailure(error);
                }
            } else {
                autoModBlock = new MessageQueue4.CaptchaRequired(error, clientMessage.getChannelId(), clientMessage.getNonce());
            }
            unknownFailure = autoModBlock;
        } else {
            response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() == 200000) {
                autoModBlock = new MessageQueue4.AutoModBlock(error, clientMessage);
                unknownFailure = autoModBlock;
            } else {
                unknownFailure = new MessageQueue4.UnknownFailure(error);
            }
        }
        onDrainListener.complete(unknownFailure);
    }

    public static /* synthetic */ void handleError$default(MessageQueue messageQueue, Error error, DrainListener drainListener, com.discord.models.message.Message message, int i, Object obj) {
        if ((i & 4) != 0) {
            message = null;
        }
        messageQueue.handleError(error, drainListener, message);
    }

    private final void handleSuccess(Message message, DrainListener drainListener) {
        drainListener.complete(new MessageQueue4.Success(message));
    }

    private final void onDrainingCompleted() {
        this.isDraining = false;
        this.inFlightRequest = null;
    }

    private final void processNextRequest() {
        MessageQueue3 messageQueue3Remove;
        if (this.queue.isEmpty() || this.retrySubscription != null || this.networkBackoff.getIsPending() || this.isDraining || (messageQueue3Remove = this.queue.remove()) == null) {
            return;
        }
        if (this.clock.currentTimeMillis() - messageQueue3Remove.getAttemptTimestamp() > DEFAULT_MESSAGE_TIMEOUT_MS) {
            messageQueue3Remove.getOnCompleted().invoke(MessageQueue4.Timeout.INSTANCE, Boolean.valueOf(this.queue.isEmpty()));
            this.networkBackoff.succeed();
            processNextRequest();
            return;
        }
        this.isDraining = true;
        DrainListener drainListener = new DrainListener(new MessageQueue2(this, messageQueue3Remove));
        if (messageQueue3Remove instanceof MessageQueue3.Send) {
            doSend((MessageQueue3.Send) messageQueue3Remove, drainListener);
        } else if (messageQueue3Remove instanceof MessageQueue3.Edit) {
            doEdit((MessageQueue3.Edit) messageQueue3Remove, drainListener);
        } else if (messageQueue3Remove instanceof MessageQueue3.SendApplicationCommand) {
            doSendApplicationCommand((MessageQueue3.SendApplicationCommand) messageQueue3Remove, drainListener);
        }
    }

    public final void cancel(final String requestId) {
        Intrinsics3.checkNotNullParameter(requestId, "requestId");
        this.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue.cancel.1
            @Override // java.lang.Runnable
            public final void run() {
                Object next;
                InflightRequest inflightRequest = MessageQueue.this.inFlightRequest;
                if (inflightRequest != null && Intrinsics3.areEqual(inflightRequest.getBaseRequest().getRequestId(), requestId)) {
                    inflightRequest.getNetworkSubscription().unsubscribe();
                    inflightRequest.getDrainListener().complete(MessageQueue4.UserCancelled.INSTANCE);
                    return;
                }
                Iterator it = MessageQueue.this.queue.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics3.areEqual(((MessageQueue3) next).getRequestId(), requestId));
                MessageQueue3 messageQueue3 = (MessageQueue3) next;
                if (messageQueue3 != null) {
                    MessageQueue.this.queue.remove(messageQueue3);
                    messageQueue3.getOnCompleted().invoke(MessageQueue4.UserCancelled.INSTANCE, Boolean.valueOf(MessageQueue.this.queue.isEmpty()));
                }
            }
        });
    }

    public final void enqueue(final MessageQueue3 request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        this.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue.enqueue.1
            @Override // java.lang.Runnable
            public final void run() {
                MessageQueue.this.queue.add(request);
                MessageQueue.this.processNextRequest();
            }
        });
    }

    public final void handleConnected() {
        this.executorService.submit(new Runnable() { // from class: com.discord.utilities.messagesend.MessageQueue.handleConnected.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MessageQueue.this.networkBackoff.getIsPending()) {
                    MessageQueue.this.networkBackoff.cancel();
                    MessageQueue.this.processNextRequest();
                }
            }
        });
    }
}
