package com.discord.stores;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Emitter;

/* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2, reason: use source file name */
/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages4 extends Lambda implements Function1<Emitter<MessageQueue4>, MessageQueue3.SendApplicationCommand> {
    public final /* synthetic */ ApplicationCommandLocalSendData $applicationCommandLocalSendData;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<MessageQueue4, Boolean, Unit> {
        public final /* synthetic */ Emitter $emitter;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class C01591 extends Lambda implements Function0<Unit> {
            public C01591() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessages.INSTANCE.cancelBackgroundSendingWork(StoreMessages.access$getContext$p(StoreMessages4.this.this$0));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Emitter emitter) {
            super(2);
            this.$emitter = emitter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4, Boolean bool) {
            invoke(messageQueue4, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(MessageQueue4 messageQueue4, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "messageResult");
            this.$emitter.onNext(messageQueue4);
            this.$emitter.onCompleted();
            if (z2) {
                StoreMessages4.this.this$0.dispatcher.schedule(new C01591());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<SendUtils.SendPayload.Preprocessing, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessages4.this.this$0.stream.getMessageUploads().onPreprocessing(StoreMessages4.this.$applicationCommandLocalSendData.getNonceString(), this.$numFiles, this.$displayName, this.$mimeType);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SendUtils.SendPayload.Preprocessing preprocessing) {
            invoke2(preprocessing);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendUtils.SendPayload.Preprocessing preprocessing) {
            Intrinsics3.checkNotNullParameter(preprocessing, "<name for destructuring parameter 0>");
            StoreMessages4.this.this$0.dispatcher.schedule(new AnonymousClass1(preprocessing.getNumFiles(), preprocessing.getName(), preprocessing.getMimeType()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessages.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends SendUtils.FileUpload>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessages.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$uploads = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessages4.this.this$0.stream.getMessageUploads().bindUpload(StoreMessages4.this.$applicationCommandLocalSendData.getNonceString(), this.$uploads);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends SendUtils.FileUpload> list) {
            invoke2((List<SendUtils.FileUpload>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<SendUtils.FileUpload> list) {
            Intrinsics3.checkNotNullParameter(list, "uploads");
            StoreMessages4.this.this$0.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages4(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list) {
        super(1);
        this.this$0 = storeMessages;
        this.$message = message;
        this.$applicationCommandLocalSendData = applicationCommandLocalSendData;
        this.$attachments = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final MessageQueue3.SendApplicationCommand invoke(Emitter<MessageQueue4> emitter) {
        Intrinsics3.checkNotNullParameter(emitter, "emitter");
        com.discord.api.message.Message messageSynthesizeApiMessage = this.$message.synthesizeApiMessage();
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$applicationCommandLocalSendData;
        UtcDateTime timestamp = this.$message.getTimestamp();
        return new MessageQueue3.SendApplicationCommand(messageSynthesizeApiMessage, applicationCommandLocalSendData, this.$attachments, new AnonymousClass2(), new AnonymousClass3(), new AnonymousClass1(emitter), timestamp != null ? timestamp.getDateTimeMillis() : 0L);
    }
}
