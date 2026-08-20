package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageRequest;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.SendUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Emitter;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$1 extends AbstractC12240o implements Function1<Emitter<MessageResult>, MessageRequest.Send> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ long $attemptTimestamp;
    public final /* synthetic */ Message $localMessage;
    public final /* synthetic */ Ref$ObjectRef $validAttachments;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62451 extends AbstractC12240o implements Function2<MessageResult, Boolean, Unit> {
        public final /* synthetic */ Emitter $emitter;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ boolean $isLastMessage;
            public final /* synthetic */ MessageResult $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(boolean z2, MessageResult messageResult) {
                super(0);
                this.$isLastMessage = z2;
                this.$result = messageResult;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.$isLastMessage) {
                    StoreMessages.INSTANCE.cancelBackgroundSendingWork(StoreMessages.access$getContext$p(StoreMessages$sendMessage$createRequest$1.this.this$0));
                }
                MessageResult messageResult = this.$result;
                if (messageResult instanceof MessageResult.Success) {
                    StoreMessages$sendMessage$createRequest$1.this.this$0.stream.getSlowMode().onMessageSent(((MessageResult.Success) this.$result).getMessage().getChannelId());
                    StoreMessages$sendMessage$createRequest$1.this.this$0.handleMessageCreate(C12145m.listOf(((MessageResult.Success) this.$result).getMessage()));
                    Integer numRetries = StoreMessages$sendMessage$createRequest$1.this.$localMessage.getNumRetries();
                    if ((numRetries != null ? numRetries.intValue() : 0) > 0) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$1 = StoreMessages$sendMessage$createRequest$1.this;
                        storeMessages$sendMessage$createRequest$1.this$0.trackFailedLocalMessageResolved(storeMessages$sendMessage$createRequest$1.$localMessage, FailedMessageResolutionType.RESENT);
                    }
                } else if (messageResult instanceof MessageResult.Slowmode) {
                    StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$2 = StoreMessages$sendMessage$createRequest$1.this;
                    storeMessages$sendMessage$createRequest$2.this$0.handleSendMessageFailure(storeMessages$sendMessage$createRequest$2.$localMessage);
                    StoreMessages$sendMessage$createRequest$1.this.this$0.stream.getSlowMode().onCooldown(StoreMessages$sendMessage$createRequest$1.this.$localMessage.getChannelId(), ((MessageResult.Slowmode) this.$result).getCooldownMs(), StoreSlowMode.Type.MessageSend.INSTANCE);
                } else if (!(messageResult instanceof MessageResult.RateLimited)) {
                    if (messageResult instanceof MessageResult.UserCancelled) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$3 = StoreMessages$sendMessage$createRequest$1.this;
                        storeMessages$sendMessage$createRequest$3.this$0.handleLocalMessageDelete(storeMessages$sendMessage$createRequest$3.$localMessage);
                    } else if (messageResult instanceof MessageResult.CaptchaRequired) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$4 = StoreMessages$sendMessage$createRequest$1.this;
                        storeMessages$sendMessage$createRequest$4.this$0.handleSendMessageCaptchaRequired(storeMessages$sendMessage$createRequest$4.$localMessage);
                    } else if (messageResult instanceof MessageResult.UnknownFailure) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$5 = StoreMessages$sendMessage$createRequest$1.this;
                        storeMessages$sendMessage$createRequest$5.this$0.handleSendMessageFailure(storeMessages$sendMessage$createRequest$5.$localMessage);
                    } else if (messageResult instanceof MessageResult.ValidationError) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$6 = StoreMessages$sendMessage$createRequest$1.this;
                        storeMessages$sendMessage$createRequest$6.this$0.handleSendMessageValidationError(storeMessages$sendMessage$createRequest$6.$localMessage, ((MessageResult.ValidationError) messageResult).getMessage());
                    } else if (!(messageResult instanceof MessageResult.NetworkFailure)) {
                        if (messageResult instanceof MessageResult.Timeout) {
                            StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$7 = StoreMessages$sendMessage$createRequest$1.this;
                            storeMessages$sendMessage$createRequest$7.this$0.handleSendMessageFailure(storeMessages$sendMessage$createRequest$7.$localMessage);
                        } else if (messageResult instanceof MessageResult.AutoModBlock) {
                            StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$8 = StoreMessages$sendMessage$createRequest$1.this;
                            StoreMessages.handleSendMessageFailureAutoMod$default(storeMessages$sendMessage$createRequest$8.this$0, storeMessages$sendMessage$createRequest$8.$localMessage, null, 2, null);
                        }
                    }
                }
                C62451.this.$emitter.onNext(this.$result);
                C62451.this.$emitter.onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62451(Emitter emitter) {
            super(2);
            this.$emitter = emitter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult, Boolean bool) {
            invoke(messageResult, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(MessageResult messageResult, boolean z2) {
            C12238m.checkNotNullParameter(messageResult, "result");
            StoreMessages$sendMessage$createRequest$1.this.this$0.dispatcher.schedule(new AnonymousClass1(z2, messageResult));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$2 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62462 extends AbstractC12240o implements Function1<SendUtils.SendPayload.Preprocessing, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ String $displayName;
            public final /* synthetic */ String $mimeType;
            public final /* synthetic */ int $numFiles;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i, String str, String str2) {
                super(0);
                this.$numFiles = i;
                this.$displayName = str;
                this.$mimeType = str2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageUploads messageUploads = StoreMessages$sendMessage$createRequest$1.this.this$0.stream.getMessageUploads();
                String nonce = StoreMessages$sendMessage$createRequest$1.this.$localMessage.getNonce();
                C12238m.checkNotNull(nonce);
                messageUploads.onPreprocessing(nonce, this.$numFiles, this.$displayName, this.$mimeType);
            }
        }

        public C62462() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SendUtils.SendPayload.Preprocessing preprocessing) {
            invoke2(preprocessing);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendUtils.SendPayload.Preprocessing preprocessing) {
            C12238m.checkNotNullParameter(preprocessing, "<name for destructuring parameter 0>");
            StoreMessages$sendMessage$createRequest$1.this.this$0.dispatcher.schedule(new AnonymousClass1(preprocessing.getNumFiles(), preprocessing.getName(), preprocessing.getMimeType()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$3 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62473 extends AbstractC12240o implements Function1<List<? extends SendUtils.FileUpload>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$uploads = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageUploads messageUploads = StoreMessages$sendMessage$createRequest$1.this.this$0.stream.getMessageUploads();
                String nonce = StoreMessages$sendMessage$createRequest$1.this.$localMessage.getNonce();
                C12238m.checkNotNull(nonce);
                messageUploads.bindUpload(nonce, this.$uploads);
            }
        }

        public C62473() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends SendUtils.FileUpload> list) {
            invoke2((List<SendUtils.FileUpload>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<SendUtils.FileUpload> list) {
            C12238m.checkNotNullParameter(list, "uploads");
            StoreMessages$sendMessage$createRequest$1.this.this$0.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$1(StoreMessages storeMessages, Message message, Ref$ObjectRef ref$ObjectRef, Activity activity, long j) {
        super(1);
        this.this$0 = storeMessages;
        this.$localMessage = message;
        this.$validAttachments = ref$ObjectRef;
        this.$activity = activity;
        this.$attemptTimestamp = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final MessageRequest.Send invoke(Emitter<MessageResult> emitter) {
        C12238m.checkNotNullParameter(emitter, "emitter");
        Message message = this.$localMessage;
        List list = (List) this.$validAttachments.element;
        return new MessageRequest.Send(message, this.$activity, list, new C62451(emitter), new C62462(), new C62473(), this.$attemptTimestamp);
    }
}
