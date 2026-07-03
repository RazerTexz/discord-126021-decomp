package com.discord.stores;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageRequest;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.SendUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Emitter;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$2 extends AbstractC12240o implements Function1<Emitter<MessageResult>, MessageRequest.SendApplicationCommand> {
    public final /* synthetic */ ApplicationCommandLocalSendData $applicationCommandLocalSendData;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62481 extends AbstractC12240o implements Function2<MessageResult, Boolean, Unit> {
        public final /* synthetic */ Emitter $emitter;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessages.INSTANCE.cancelBackgroundSendingWork(StoreMessages.access$getContext$p(StoreMessages$sendMessage$createRequest$2.this.this$0));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62481(Emitter emitter) {
            super(2);
            this.$emitter = emitter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult, Boolean bool) {
            invoke(messageResult, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(MessageResult messageResult, boolean z2) {
            C12238m.checkNotNullParameter(messageResult, "messageResult");
            this.$emitter.onNext(messageResult);
            this.$emitter.onCompleted();
            if (z2) {
                StoreMessages$sendMessage$createRequest$2.this.this$0.dispatcher.schedule(new AnonymousClass1());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62492 extends AbstractC12240o implements Function1<SendUtils.SendPayload.Preprocessing, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2$1, reason: invalid class name */
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
                StoreMessages$sendMessage$createRequest$2.this.this$0.stream.getMessageUploads().onPreprocessing(StoreMessages$sendMessage$createRequest$2.this.$applicationCommandLocalSendData.getNonceString(), this.$numFiles, this.$displayName, this.$mimeType);
            }
        }

        public C62492() {
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
            StoreMessages$sendMessage$createRequest$2.this.this$0.dispatcher.schedule(new AnonymousClass1(preprocessing.getNumFiles(), preprocessing.getName(), preprocessing.getMimeType()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3 */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class C62503 extends AbstractC12240o implements Function1<List<? extends SendUtils.FileUpload>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3$1, reason: invalid class name */
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
                StoreMessages$sendMessage$createRequest$2.this.this$0.stream.getMessageUploads().bindUpload(StoreMessages$sendMessage$createRequest$2.this.$applicationCommandLocalSendData.getNonceString(), this.$uploads);
            }
        }

        public C62503() {
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
            StoreMessages$sendMessage$createRequest$2.this.this$0.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$2(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list) {
        super(1);
        this.this$0 = storeMessages;
        this.$message = message;
        this.$applicationCommandLocalSendData = applicationCommandLocalSendData;
        this.$attachments = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final MessageRequest.SendApplicationCommand invoke(Emitter<MessageResult> emitter) {
        C12238m.checkNotNullParameter(emitter, "emitter");
        com.discord.api.message.Message messageSynthesizeApiMessage = this.$message.synthesizeApiMessage();
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$applicationCommandLocalSendData;
        UtcDateTime timestamp = this.$message.getTimestamp();
        return new MessageRequest.SendApplicationCommand(messageSynthesizeApiMessage, applicationCommandLocalSendData, this.$attachments, new C62492(), new C62503(), new C62481(emitter), timestamp != null ? timestamp.getDateTimeMillis() : 0L);
    }
}
