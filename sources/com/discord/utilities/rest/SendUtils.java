package com.discord.utilities.rest;

import a0.a.a.b;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppToast;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.CountingRequestBody;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import d0.Result3;
import d0.Tuples;
import d0.f0.SequenceBuilder2;
import d0.f0.SequenceBuilder3;
import d0.f0._Sequences2;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl5;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils {
    public static final SendUtils INSTANCE = new SendUtils();
    public static final int MAX_MESSAGE_CHARACTER_COUNT = 2000;
    public static final int MAX_MESSAGE_CHARACTER_COUNT_PREMIUM = 4000;

    /* JADX INFO: compiled from: SendUtils.kt */
    public static final /* data */ class FileUpload {
        public static final long SIZE_UNKNOWN = -1;
        private final Observable<Long> bytesWrittenObservable;
        private final long contentLength;
        private final String mimeType;
        private final String name;
        private final MultipartBody.Part part;

        public FileUpload(String str, long j, MultipartBody.Part part, String str2, Observable<Long> observable) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(part, "part");
            Intrinsics3.checkNotNullParameter(str2, "mimeType");
            Intrinsics3.checkNotNullParameter(observable, "bytesWrittenObservable");
            this.name = str;
            this.contentLength = j;
            this.part = part;
            this.mimeType = str2;
            this.bytesWrittenObservable = observable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FileUpload copy$default(FileUpload fileUpload, String str, long j, MultipartBody.Part part, String str2, Observable observable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileUpload.name;
            }
            if ((i & 2) != 0) {
                j = fileUpload.contentLength;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                part = fileUpload.part;
            }
            MultipartBody.Part part2 = part;
            if ((i & 8) != 0) {
                str2 = fileUpload.mimeType;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                observable = fileUpload.bytesWrittenObservable;
            }
            return fileUpload.copy(str, j2, part2, str3, observable);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getContentLength() {
            return this.contentLength;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final MultipartBody.Part getPart() {
            return this.part;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public final Observable<Long> component5() {
            return this.bytesWrittenObservable;
        }

        public final FileUpload copy(String name, long contentLength, MultipartBody.Part part, String mimeType, Observable<Long> bytesWrittenObservable) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(part, "part");
            Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
            Intrinsics3.checkNotNullParameter(bytesWrittenObservable, "bytesWrittenObservable");
            return new FileUpload(name, contentLength, part, mimeType, bytesWrittenObservable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileUpload)) {
                return false;
            }
            FileUpload fileUpload = (FileUpload) other;
            return Intrinsics3.areEqual(this.name, fileUpload.name) && this.contentLength == fileUpload.contentLength && Intrinsics3.areEqual(this.part, fileUpload.part) && Intrinsics3.areEqual(this.mimeType, fileUpload.mimeType) && Intrinsics3.areEqual(this.bytesWrittenObservable, fileUpload.bytesWrittenObservable);
        }

        public final Observable<Long> getBytesWrittenObservable() {
            return this.bytesWrittenObservable;
        }

        public final long getContentLength() {
            return this.contentLength;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final String getName() {
            return this.name;
        }

        public final MultipartBody.Part getPart() {
            return this.part;
        }

        public int hashCode() {
            String str = this.name;
            int iA = (b.a(this.contentLength) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            MultipartBody.Part part = this.part;
            int iHashCode = (iA + (part != null ? part.hashCode() : 0)) * 31;
            String str2 = this.mimeType;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Observable<Long> observable = this.bytesWrittenObservable;
            return iHashCode2 + (observable != null ? observable.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("FileUpload(name=");
            sbU.append(this.name);
            sbU.append(", contentLength=");
            sbU.append(this.contentLength);
            sbU.append(", part=");
            sbU.append(this.part);
            sbU.append(", mimeType=");
            sbU.append(this.mimeType);
            sbU.append(", bytesWrittenObservable=");
            sbU.append(this.bytesWrittenObservable);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: SendUtils.kt */
    public static abstract class SendPayload {

        /* JADX INFO: compiled from: SendUtils.kt */
        public static final /* data */ class Preprocessing extends SendPayload {
            private final String mimeType;
            private final String name;
            private final int numFiles;

            public Preprocessing(int i, String str, String str2) {
                super(null);
                this.numFiles = i;
                this.name = str;
                this.mimeType = str2;
            }

            public static /* synthetic */ Preprocessing copy$default(Preprocessing preprocessing, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = preprocessing.numFiles;
                }
                if ((i2 & 2) != 0) {
                    str = preprocessing.name;
                }
                if ((i2 & 4) != 0) {
                    str2 = preprocessing.mimeType;
                }
                return preprocessing.copy(i, str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            public final Preprocessing copy(int numFiles, String name, String mimeType) {
                return new Preprocessing(numFiles, name, mimeType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Preprocessing)) {
                    return false;
                }
                Preprocessing preprocessing = (Preprocessing) other;
                return this.numFiles == preprocessing.numFiles && Intrinsics3.areEqual(this.name, preprocessing.name) && Intrinsics3.areEqual(this.mimeType, preprocessing.mimeType);
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final String getName() {
                return this.name;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public int hashCode() {
                int i = this.numFiles * 31;
                String str = this.name;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mimeType;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Preprocessing(numFiles=");
                sbU.append(this.numFiles);
                sbU.append(", name=");
                sbU.append(this.name);
                sbU.append(", mimeType=");
                return outline.J(sbU, this.mimeType, ")");
            }
        }

        /* JADX INFO: compiled from: SendUtils.kt */
        public static final /* data */ class ReadyToSend extends SendPayload {
            private final RestAPIParams.Message message;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSend(RestAPIParams.Message message, List<FileUpload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.message = message;
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReadyToSend copy$default(ReadyToSend readyToSend, RestAPIParams.Message message, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = readyToSend.message;
                }
                if ((i & 2) != 0) {
                    list = readyToSend.uploads;
                }
                return readyToSend.copy(message, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final RestAPIParams.Message getMessage() {
                return this.message;
            }

            public final List<FileUpload> component2() {
                return this.uploads;
            }

            public final ReadyToSend copy(RestAPIParams.Message message, List<FileUpload> uploads) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new ReadyToSend(message, uploads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReadyToSend)) {
                    return false;
                }
                ReadyToSend readyToSend = (ReadyToSend) other;
                return Intrinsics3.areEqual(this.message, readyToSend.message) && Intrinsics3.areEqual(this.uploads, readyToSend.uploads);
            }

            public final RestAPIParams.Message getMessage() {
                return this.message;
            }

            public final List<FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                RestAPIParams.Message message = this.message;
                int iHashCode = (message != null ? message.hashCode() : 0) * 31;
                List<FileUpload> list = this.uploads;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ReadyToSend(message=");
                sbU.append(this.message);
                sbU.append(", uploads=");
                return outline.L(sbU, this.uploads, ")");
            }
        }

        /* JADX INFO: compiled from: SendUtils.kt */
        public static final /* data */ class ReadyToSendCommand extends SendPayload {
            private final ApplicationCommandLocalSendData command;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSendCommand(ApplicationCommandLocalSendData applicationCommandLocalSendData, List<FileUpload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "command");
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.command = applicationCommandLocalSendData;
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReadyToSendCommand copy$default(ReadyToSendCommand readyToSendCommand, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    applicationCommandLocalSendData = readyToSendCommand.command;
                }
                if ((i & 2) != 0) {
                    list = readyToSendCommand.uploads;
                }
                return readyToSendCommand.copy(applicationCommandLocalSendData, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ApplicationCommandLocalSendData getCommand() {
                return this.command;
            }

            public final List<FileUpload> component2() {
                return this.uploads;
            }

            public final ReadyToSendCommand copy(ApplicationCommandLocalSendData command, List<FileUpload> uploads) {
                Intrinsics3.checkNotNullParameter(command, "command");
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new ReadyToSendCommand(command, uploads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReadyToSendCommand)) {
                    return false;
                }
                ReadyToSendCommand readyToSendCommand = (ReadyToSendCommand) other;
                return Intrinsics3.areEqual(this.command, readyToSendCommand.command) && Intrinsics3.areEqual(this.uploads, readyToSendCommand.uploads);
            }

            public final ApplicationCommandLocalSendData getCommand() {
                return this.command;
            }

            public final List<FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                ApplicationCommandLocalSendData applicationCommandLocalSendData = this.command;
                int iHashCode = (applicationCommandLocalSendData != null ? applicationCommandLocalSendData.hashCode() : 0) * 31;
                List<FileUpload> list = this.uploads;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ReadyToSendCommand(command=");
                sbU.append(this.command);
                sbU.append(", uploads=");
                return outline.L(sbU, this.uploads, ")");
            }
        }

        private SendPayload() {
        }

        public /* synthetic */ SendPayload(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$compressImageAttachments$1, reason: invalid class name */
    /* JADX INFO: compiled from: SendUtils.kt */
    @DebugMetadata(c = "com.discord.utilities.rest.SendUtils$compressImageAttachments$1", f = "SendUtils.kt", l = {323}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachments;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Function1 $onCompressed;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, Context context, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$attachments = list;
            this.$context = context;
            this.$onCompressed = function1;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$attachments, this.$context, this.$onCompressed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x004d  */
        /* JADX WARN: Code duplicated, block: B:16:0x005f  */
        /* JADX WARN: Code duplicated, block: B:28:0x00c5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008c -> B:36:0x0093). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00bc -> B:27:0x00c1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // d0.w.i.a.ContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.discord.utilities.rest.SendUtils.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$1, reason: invalid class name */
    /* JADX INFO: compiled from: SendUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ MessageQueue4.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MessageQueue4.CaptchaRequired captchaRequired) {
            super(2);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
            StoreStream.INSTANCE.getMessages().resendMessageWithCaptcha(this.$messageResult.getChannelId(), this.$messageResult.getNonce(), captchaPayload);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$2, reason: invalid class name */
    /* JADX INFO: compiled from: SendUtils.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MessageQueue4.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MessageQueue4.CaptchaRequired captchaRequired) {
            super(0);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getMessages().markMessageFailed(this.$messageResult.getChannelId(), this.$messageResult.getNonce());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$uniqueifyNames$1, reason: invalid class name */
    /* JADX INFO: compiled from: SendUtils.kt */
    @DebugMetadata(c = "com.discord.utilities.rest.SendUtils$uniqueifyNames$1", f = "SendUtils.kt", l = {204, 206}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super Attachment<? extends Object>>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachmentParts;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, Continuation continuation) {
            super(2, continuation);
            this.$attachmentParts = list;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$attachmentParts, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceBuilder2<? super Attachment<? extends Object>> sequenceBuilder2, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceBuilder2, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceBuilder2 sequenceBuilder2;
            Map map;
            Iterator it;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                SequenceBuilder2 sequenceBuilder3 = (SequenceBuilder2) this.L$0;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                sequenceBuilder2 = sequenceBuilder3;
                map = linkedHashMap;
                it = this.$attachmentParts.iterator();
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                map = (Map) this.L$1;
                sequenceBuilder2 = (SequenceBuilder2) this.L$0;
                Result3.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Attachment attachment = (Attachment) it.next();
                Object objBoxInt = map.get(attachment.getDisplayName());
                if (objBoxInt == null) {
                    objBoxInt = boxing.boxInt(0);
                }
                int iIntValue = ((Number) objBoxInt).intValue();
                map.put(attachment.getDisplayName(), boxing.boxInt(iIntValue + 1));
                if (iIntValue == 0) {
                    this.L$0 = sequenceBuilder2;
                    this.L$1 = map;
                    this.L$2 = it;
                    this.label = 1;
                    if (sequenceBuilder2.yield(attachment, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Attachment attachmentRenamedWithDuplicateCount = SendUtils.INSTANCE.renamedWithDuplicateCount(attachment, iIntValue);
                    this.L$0 = sequenceBuilder2;
                    this.L$1 = map;
                    this.L$2 = it;
                    this.label = 2;
                    if (sequenceBuilder2.yield(attachmentRenamedWithDuplicateCount, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.a;
        }
    }

    private SendUtils() {
    }

    private final Observable<FileUpload> getPart(final Attachment<?> attachment, final ContentResolver contentResolver, final String str) {
        return Observable.o(new Action1<Emitter<FileUpload>>() { // from class: com.discord.utilities.rest.SendUtils.getPart.1

            /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$getPart$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SendUtils.kt */
            public static final class C02221 extends Lambda implements Function3<RequestBody, String, Bitmap.CompressFormat, FileUpload> {
                public C02221() {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final FileUpload invoke(RequestBody requestBody, String str, Bitmap.CompressFormat compressFormat) {
                    Intrinsics3.checkNotNullParameter(requestBody, "requestBody");
                    Intrinsics3.checkNotNullParameter(str, "mimeType");
                    CountingRequestBody countingRequestBody = new CountingRequestBody(requestBody, 0);
                    String sanitizedFileName = AttachmentUtils.getSanitizedFileName(Attachment.INSTANCE.a(attachment), compressFormat);
                    return new FileUpload(sanitizedFileName, countingRequestBody.getEstimatedContentLength(), MultipartBody.Part.b(str, sanitizedFileName, countingRequestBody), str, countingRequestBody.getBytesWrittenObservable());
                }
            }

            @Override // rx.functions.Action1
            public final void call(Emitter<FileUpload> emitter) {
                emitter.onNext(new C02221().invoke((RequestBody) new AttachmentRequestBody(contentResolver, attachment), AttachmentUtils.getMimeType(attachment, contentResolver), (Bitmap.CompressFormat) null));
                emitter.onCompleted();
            }
        }, Emitter.BackpressureMode.BUFFER);
    }

    private final SendPayload.Preprocessing getPreprocessingFromAttachments(ContentResolver contentResolver, List<? extends Attachment<?>> fileAttachments) {
        if (fileAttachments.size() != 1) {
            return new SendPayload.Preprocessing(fileAttachments.size(), null, null);
        }
        Attachment<?> attachment = (Attachment) _Collections.first((List) fileAttachments);
        return new SendPayload.Preprocessing(1, Attachment.INSTANCE.a(attachment), AttachmentUtils.getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleSendError$default(SendUtils sendUtils, Error error, Context context, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        sendUtils.handleSendError(error, context, function0, function1);
    }

    private final Tuples2<String, String> splitFileExtension(String str) {
        int iLastIndexOf$default = Strings4.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return Tuples.to(str, null);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iLastIndexOf$default + 1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return Tuples.to(strSubstring, strSubstring2);
    }

    public final void compressImageAttachments(Context context, List<? extends Attachment<?>> attachments, Function1<? super List<? extends Attachment<?>>, Unit> onCompressed) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attachments, "attachments");
        Intrinsics3.checkNotNullParameter(onCompressed, "onCompressed");
        CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        f.H0(coroutineScope2, MainDispatchers.f3830b, null, new AnonymousClass1(attachments, context, onCompressed, null), 2, null);
    }

    public final Observable<SendPayload> getSendCommandPayload(ContentResolver contentResolver, ApplicationCommandLocalSendData apiParamMessage, List<? extends Attachment<?>> attachments) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(apiParamMessage, "apiParamMessage");
        if (attachments == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new SendPayload.ReadyToSendCommand(apiParamMessage, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return scalarSynchronousObservable;
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(attachments);
        final ApplicationCommandLocalSendData applicationCommandLocalSendDataCopy = apiParamMessage.copy((1791 & 1) != 0 ? apiParamMessage.nonce : 0L, (1791 & 2) != 0 ? apiParamMessage.channelId : 0L, (1791 & 4) != 0 ? apiParamMessage.guildId : null, (1791 & 8) != 0 ? apiParamMessage.commandGuildId : null, (1791 & 16) != 0 ? apiParamMessage.application : null, (1791 & 32) != 0 ? apiParamMessage.sessionId : null, (1791 & 64) != 0 ? apiParamMessage.applicationCommandName : null, (1791 & 128) != 0 ? apiParamMessage.applicationCommandId : null, (1791 & 256) != 0 ? apiParamMessage.applicationCommandsValues : StoreApplicationCommandsKt.mapApplicationCommandValues(apiParamMessage.getApplicationCommandsValues(), new SendUtils4(listUniqueifyNames)), (1791 & 512) != 0 ? apiParamMessage.version : null, (1791 & 1024) != 0 ? apiParamMessage.interactionId : null);
        if (!(!listUniqueifyNames.isEmpty())) {
            ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new SendPayload.ReadyToSendCommand(applicationCommandLocalSendDataCopy, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(SendPayl…tedMessage, emptyList()))");
            return scalarSynchronousObservable2;
        }
        ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, "files[" + i + ']'));
            i = i2;
        }
        Observable<SendPayload> observableM = Observable.m(scalarSynchronousObservable3, Observable.l(arrayList).f0().G(new Func1<List<FileUpload>, SendPayload.ReadyToSendCommand>() { // from class: com.discord.utilities.rest.SendUtils.getSendCommandPayload.2
            @Override // j0.k.Func1
            public final SendPayload.ReadyToSendCommand call(List<FileUpload> list) {
                ApplicationCommandLocalSendData applicationCommandLocalSendData = applicationCommandLocalSendDataCopy;
                Intrinsics3.checkNotNullExpressionValue(list, "attachmentParts");
                return new SendPayload.ReadyToSendCommand(applicationCommandLocalSendData, list);
            }
        }));
        Intrinsics3.checkNotNullExpressionValue(observableM, "Observable.concat(\n     …)\n              }\n      )");
        return observableM;
    }

    public final Observable<SendPayload> getSendPayload(ContentResolver contentResolver, RestAPIParams.Message apiParamMessage, List<? extends Attachment<?>> attachments) {
        final RestAPIParams.Message messageCopy = apiParamMessage;
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(messageCopy, "apiParamMessage");
        if (attachments == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new SendPayload.ReadyToSend(messageCopy, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return scalarSynchronousObservable;
        }
        List<Attachment<?>> listExtractLinks = AttachmentUtils.extractLinks(attachments, contentResolver);
        String content = apiParamMessage.getContent();
        if (content == null) {
            content = "";
        }
        String strAppendLinks = AttachmentUtils.appendLinks(content, listExtractLinks);
        if (!Intrinsics3.areEqual(strAppendLinks, apiParamMessage.getContent())) {
            messageCopy = apiParamMessage.copy((510 & 1) != 0 ? apiParamMessage.content : strAppendLinks, (510 & 2) != 0 ? apiParamMessage.nonce : null, (510 & 4) != 0 ? apiParamMessage.applicationId : null, (510 & 8) != 0 ? apiParamMessage.activity : null, (510 & 16) != 0 ? apiParamMessage.stickerIds : null, (510 & 32) != 0 ? apiParamMessage.messageReference : null, (510 & 64) != 0 ? apiParamMessage.allowedMentions : null, (510 & 128) != 0 ? apiParamMessage.captchaKey : null, (510 & 256) != 0 ? apiParamMessage.captchaRqtoken : null);
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(_Collections.minus((Iterable) attachments, (Iterable) listExtractLinks));
        if (!(!listUniqueifyNames.isEmpty())) {
            ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new SendPayload.ReadyToSend(messageCopy, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return scalarSynchronousObservable2;
        }
        ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, outline.q("file", i)));
            i = i2;
        }
        Observable<SendPayload> observableM = Observable.m(scalarSynchronousObservable3, Observable.l(arrayList).f0().G(new Func1<List<FileUpload>, SendPayload.ReadyToSend>() { // from class: com.discord.utilities.rest.SendUtils.getSendPayload.2
            @Override // j0.k.Func1
            public final SendPayload.ReadyToSend call(List<FileUpload> list) {
                RestAPIParams.Message message = messageCopy;
                Intrinsics3.checkNotNullExpressionValue(list, "attachmentParts");
                return new SendPayload.ReadyToSend(message, list);
            }
        }));
        Intrinsics3.checkNotNullExpressionValue(observableM, "Observable.concat(\n     …)\n              }\n      )");
        return observableM;
    }

    public final void handleCaptchaRequired(MessageQueue4.CaptchaRequired messageResult) {
        Intrinsics3.checkNotNullParameter(messageResult, "messageResult");
        WidgetCaptchaBottomSheet.INSTANCE.enqueue("Message Captcha", new AnonymousClass1(messageResult), new AnonymousClass2(messageResult), CaptchaErrorBody.INSTANCE.createFromError(messageResult.getError()));
    }

    @MainThread
    public final void handleSendError(Error error, Context context, Function0<Unit> filesTooLargeCallback, Function0<Unit> failedDeliveryToRecipientCallback) {
        Intrinsics3.checkNotNullParameter(error, "error");
        Intrinsics3.checkNotNullParameter(context, "context");
        error.setShowErrorToasts(false);
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        if (abortCodeMessageResId != null) {
            AppToast.g(context, abortCodeMessageResId.intValue(), 0, null, 12);
        } else if (error.getType() == Error.Type.REQUEST_TOO_LARGE) {
            if (filesTooLargeCallback != null) {
                filesTooLargeCallback.invoke();
            }
        } else if (error.getType() != Error.Type.FORBIDDEN_DISCORD) {
            Error.Response response2 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
            if (response2.isKnownResponse() || error.getType() == Error.Type.NETWORK) {
                error.setShowErrorToasts(true);
            } else {
                AppToast.g(context, R.string.network_error_bad_request, 0, null, 12);
            }
        } else if (failedDeliveryToRecipientCallback != null) {
            failedDeliveryToRecipientCallback.invoke();
        }
        error.showToasts(context);
    }

    @VisibleForTesting
    public final <T> Attachment<T> renamedWithDuplicateCount(Attachment<? extends T> attachment, int i) {
        String str;
        Intrinsics3.checkNotNullParameter(attachment, "$this$renamedWithDuplicateCount");
        long id2 = attachment.getId();
        Uri uri = attachment.getUri();
        Tuples2<String, String> tuples2SplitFileExtension = splitFileExtension(attachment.getDisplayName());
        String strComponent1 = tuples2SplitFileExtension.component1();
        String strComponent2 = tuples2SplitFileExtension.component2();
        if (strComponent2 != null) {
            str = strComponent1 + '-' + i + '.' + strComponent2;
        } else {
            str = strComponent1 + '-' + i;
        }
        return new Attachment<>(id2, uri, str, attachment.getData(), false, 16, null);
    }

    @VisibleForTesting
    public final List<Attachment<?>> uniqueifyNames(List<? extends Attachment<?>> attachmentParts) {
        Intrinsics3.checkNotNullParameter(attachmentParts, "attachmentParts");
        return _Sequences2.toList(SequenceBuilder3.sequence(new AnonymousClass1(attachmentParts, null)));
    }
}
