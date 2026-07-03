package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.CountingRequestBody;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
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
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.C12116o;
import p507d0.p578f0.AbstractC12072k;
import p507d0.p578f0.C12073l;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12193j;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12185b;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;
import p659s.p660a.C13124k0;
import p659s.p660a.C13163x0;
import p659s.p660a.p661a.C13031n;

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
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(part, "part");
            C12238m.checkNotNullParameter(str2, "mimeType");
            C12238m.checkNotNullParameter(observable, "bytesWrittenObservable");
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
            C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(part, "part");
            C12238m.checkNotNullParameter(mimeType, "mimeType");
            C12238m.checkNotNullParameter(bytesWrittenObservable, "bytesWrittenObservable");
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
            return C12238m.areEqual(this.name, fileUpload.name) && this.contentLength == fileUpload.contentLength && C12238m.areEqual(this.part, fileUpload.part) && C12238m.areEqual(this.mimeType, fileUpload.mimeType) && C12238m.areEqual(this.bytesWrittenObservable, fileUpload.bytesWrittenObservable);
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
            int iM3a = (C0002b.m3a(this.contentLength) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            MultipartBody.Part part = this.part;
            int iHashCode = (iM3a + (part != null ? part.hashCode() : 0)) * 31;
            String str2 = this.mimeType;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Observable<Long> observable = this.bytesWrittenObservable;
            return iHashCode2 + (observable != null ? observable.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("FileUpload(name=");
            sbM833U.append(this.name);
            sbM833U.append(", contentLength=");
            sbM833U.append(this.contentLength);
            sbM833U.append(", part=");
            sbM833U.append(this.part);
            sbM833U.append(", mimeType=");
            sbM833U.append(this.mimeType);
            sbM833U.append(", bytesWrittenObservable=");
            sbM833U.append(this.bytesWrittenObservable);
            sbM833U.append(")");
            return sbM833U.toString();
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
                return this.numFiles == preprocessing.numFiles && C12238m.areEqual(this.name, preprocessing.name) && C12238m.areEqual(this.mimeType, preprocessing.mimeType);
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
                StringBuilder sbM833U = C1643a.m833U("Preprocessing(numFiles=");
                sbM833U.append(this.numFiles);
                sbM833U.append(", name=");
                sbM833U.append(this.name);
                sbM833U.append(", mimeType=");
                return C1643a.m822J(sbM833U, this.mimeType, ")");
            }
        }

        /* JADX INFO: compiled from: SendUtils.kt */
        public static final /* data */ class ReadyToSend extends SendPayload {
            private final RestAPIParams.Message message;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSend(RestAPIParams.Message message, List<FileUpload> list) {
                super(null);
                C12238m.checkNotNullParameter(message, "message");
                C12238m.checkNotNullParameter(list, "uploads");
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
                C12238m.checkNotNullParameter(message, "message");
                C12238m.checkNotNullParameter(uploads, "uploads");
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
                return C12238m.areEqual(this.message, readyToSend.message) && C12238m.areEqual(this.uploads, readyToSend.uploads);
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
                StringBuilder sbM833U = C1643a.m833U("ReadyToSend(message=");
                sbM833U.append(this.message);
                sbM833U.append(", uploads=");
                return C1643a.m824L(sbM833U, this.uploads, ")");
            }
        }

        /* JADX INFO: compiled from: SendUtils.kt */
        public static final /* data */ class ReadyToSendCommand extends SendPayload {
            private final ApplicationCommandLocalSendData command;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSendCommand(ApplicationCommandLocalSendData applicationCommandLocalSendData, List<FileUpload> list) {
                super(null);
                C12238m.checkNotNullParameter(applicationCommandLocalSendData, "command");
                C12238m.checkNotNullParameter(list, "uploads");
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
                C12238m.checkNotNullParameter(command, "command");
                C12238m.checkNotNullParameter(uploads, "uploads");
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
                return C12238m.areEqual(this.command, readyToSendCommand.command) && C12238m.areEqual(this.uploads, readyToSendCommand.uploads);
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
                StringBuilder sbM833U = C1643a.m833U("ReadyToSendCommand(command=");
                sbM833U.append(this.command);
                sbM833U.append(", uploads=");
                return C1643a.m824L(sbM833U, this.uploads, ")");
            }
        }

        private SendPayload() {
        }

        public /* synthetic */ SendPayload(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$compressImageAttachments$1 */
    /* JADX INFO: compiled from: SendUtils.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.rest.SendUtils$compressImageAttachments$1", m10085f = "SendUtils.kt", m10086l = {323}, m10087m = "invokeSuspend")
    public static final class C68611 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachments;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Function1 $onCompressed;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68611(List list, Context context, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$attachments = list;
            this.$context = context;
            this.$onCompressed = function1;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C68611(this.$attachments, this.$context, this.$onCompressed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68611) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
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
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.discord.utilities.rest.SendUtils.C68611.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$1 */
    /* JADX INFO: compiled from: SendUtils.kt */
    public static final class C68651 extends AbstractC12240o implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ MessageResult.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68651(MessageResult.CaptchaRequired captchaRequired) {
            super(2);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            C12238m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(captchaPayload, "captchaPayload");
            StoreStream.INSTANCE.getMessages().resendMessageWithCaptcha(this.$messageResult.getChannelId(), this.$messageResult.getNonce(), captchaPayload);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$2 */
    /* JADX INFO: compiled from: SendUtils.kt */
    public static final class C68662 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ MessageResult.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68662(MessageResult.CaptchaRequired captchaRequired) {
            super(0);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getMessages().markMessageFailed(this.$messageResult.getChannelId(), this.$messageResult.getNonce());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$uniqueifyNames$1 */
    /* JADX INFO: compiled from: SendUtils.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.rest.SendUtils$uniqueifyNames$1", m10085f = "SendUtils.kt", m10086l = {204, 206}, m10087m = "invokeSuspend")
    public static final class C68671 extends AbstractC12193j implements Function2<AbstractC12072k<? super Attachment<? extends Object>>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachmentParts;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68671(List list, Continuation continuation) {
            super(2, continuation);
            this.$attachmentParts = list;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C68671 c68671 = new C68671(this.$attachmentParts, continuation);
            c68671.L$0 = obj;
            return c68671;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AbstractC12072k<? super Attachment<? extends Object>> abstractC12072k, Continuation<? super Unit> continuation) {
            return ((C68671) create(abstractC12072k, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            AbstractC12072k abstractC12072k;
            Map map;
            Iterator it;
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                AbstractC12072k abstractC12072k2 = (AbstractC12072k) this.L$0;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                abstractC12072k = abstractC12072k2;
                map = linkedHashMap;
                it = this.$attachmentParts.iterator();
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                map = (Map) this.L$1;
                abstractC12072k = (AbstractC12072k) this.L$0;
                C12113l.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Attachment attachment = (Attachment) it.next();
                Object objBoxInt = map.get(attachment.getDisplayName());
                if (objBoxInt == null) {
                    objBoxInt = C12185b.boxInt(0);
                }
                int iIntValue = ((Number) objBoxInt).intValue();
                map.put(attachment.getDisplayName(), C12185b.boxInt(iIntValue + 1));
                if (iIntValue == 0) {
                    this.L$0 = abstractC12072k;
                    this.L$1 = map;
                    this.L$2 = it;
                    this.label = 1;
                    if (abstractC12072k.yield(attachment, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Attachment attachmentRenamedWithDuplicateCount = SendUtils.INSTANCE.renamedWithDuplicateCount(attachment, iIntValue);
                    this.L$0 = abstractC12072k;
                    this.L$1 = map;
                    this.L$2 = it;
                    this.label = 2;
                    if (abstractC12072k.yield(attachmentRenamedWithDuplicateCount, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.f27425a;
        }
    }

    private SendUtils() {
    }

    private final Observable<FileUpload> getPart(final Attachment<?> attachment, final ContentResolver contentResolver, final String str) {
        return Observable.m11080o(new Action1<Emitter<FileUpload>>() { // from class: com.discord.utilities.rest.SendUtils.getPart.1

            /* JADX INFO: renamed from: com.discord.utilities.rest.SendUtils$getPart$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: SendUtils.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function3<RequestBody, String, Bitmap.CompressFormat, FileUpload> {
                public AnonymousClass1() {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final FileUpload invoke(RequestBody requestBody, String str, Bitmap.CompressFormat compressFormat) {
                    C12238m.checkNotNullParameter(requestBody, "requestBody");
                    C12238m.checkNotNullParameter(str, "mimeType");
                    CountingRequestBody countingRequestBody = new CountingRequestBody(requestBody, 0);
                    String sanitizedFileName = AttachmentUtilsKt.getSanitizedFileName(Attachment.INSTANCE.m9295a(attachment), compressFormat);
                    return new FileUpload(sanitizedFileName, countingRequestBody.getEstimatedContentLength(), MultipartBody.Part.m10971b(str, sanitizedFileName, countingRequestBody), str, countingRequestBody.getBytesWrittenObservable());
                }
            }

            @Override // p658rx.functions.Action1
            public final void call(Emitter<FileUpload> emitter) {
                emitter.onNext(new AnonymousClass1().invoke((RequestBody) new AttachmentRequestBody(contentResolver, attachment), AttachmentUtilsKt.getMimeType(attachment, contentResolver), (Bitmap.CompressFormat) null));
                emitter.onCompleted();
            }
        }, Emitter.BackpressureMode.BUFFER);
    }

    private final SendPayload.Preprocessing getPreprocessingFromAttachments(ContentResolver contentResolver, List<? extends Attachment<?>> fileAttachments) {
        if (fileAttachments.size() != 1) {
            return new SendPayload.Preprocessing(fileAttachments.size(), null, null);
        }
        Attachment<?> attachment = (Attachment) C12163u.first((List) fileAttachments);
        return new SendPayload.Preprocessing(1, Attachment.INSTANCE.m9295a(attachment), AttachmentUtilsKt.getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName()));
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

    private final Pair<String, String> splitFileExtension(String str) {
        int iLastIndexOf$default = C12106w.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return C12116o.m10073to(str, null);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, iLastIndexOf$default);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iLastIndexOf$default + 1);
        C12238m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return C12116o.m10073to(strSubstring, strSubstring2);
    }

    public final void compressImageAttachments(Context context, List<? extends Attachment<?>> attachments, Function1<? super List<? extends Attachment<?>>, Unit> onCompressed) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attachments, "attachments");
        C12238m.checkNotNullParameter(onCompressed, "onCompressed");
        C13163x0 c13163x0 = C13163x0.f27919j;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C3404f.m4211H0(c13163x0, C13031n.f27700b, null, new C68611(attachments, context, onCompressed, null), 2, null);
    }

    public final Observable<SendPayload> getSendCommandPayload(ContentResolver contentResolver, ApplicationCommandLocalSendData apiParamMessage, List<? extends Attachment<?>> attachments) {
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        C12238m.checkNotNullParameter(apiParamMessage, "apiParamMessage");
        if (attachments == null) {
            C12721k c12721k = new C12721k(new SendPayload.ReadyToSendCommand(apiParamMessage, C12147n.emptyList()));
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return c12721k;
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(attachments);
        final ApplicationCommandLocalSendData applicationCommandLocalSendDataCopy = apiParamMessage.copy((1791 & 1) != 0 ? apiParamMessage.nonce : 0L, (1791 & 2) != 0 ? apiParamMessage.channelId : 0L, (1791 & 4) != 0 ? apiParamMessage.guildId : null, (1791 & 8) != 0 ? apiParamMessage.commandGuildId : null, (1791 & 16) != 0 ? apiParamMessage.application : null, (1791 & 32) != 0 ? apiParamMessage.sessionId : null, (1791 & 64) != 0 ? apiParamMessage.applicationCommandName : null, (1791 & 128) != 0 ? apiParamMessage.applicationCommandId : null, (1791 & 256) != 0 ? apiParamMessage.applicationCommandsValues : StoreApplicationCommandsKt.mapApplicationCommandValues(apiParamMessage.getApplicationCommandsValues(), new SendUtils$getSendCommandPayload$attachmentCorrectedMessage$1(listUniqueifyNames)), (1791 & 512) != 0 ? apiParamMessage.version : null, (1791 & 1024) != 0 ? apiParamMessage.interactionId : null);
        if (!(!listUniqueifyNames.isEmpty())) {
            C12721k c12721k2 = new C12721k(new SendPayload.ReadyToSendCommand(applicationCommandLocalSendDataCopy, C12147n.emptyList()));
            C12238m.checkNotNullExpressionValue(c12721k2, "Observable.just(SendPayl…tedMessage, emptyList()))");
            return c12721k2;
        }
        C12721k c12721k3 = new C12721k(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, "files[" + i + ']'));
            i = i2;
        }
        Observable<SendPayload> observableM11079m = Observable.m11079m(c12721k3, Observable.m11078l(arrayList).m11105f0().m11083G(new InterfaceC12589b<List<FileUpload>, SendPayload.ReadyToSendCommand>() { // from class: com.discord.utilities.rest.SendUtils.getSendCommandPayload.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final SendPayload.ReadyToSendCommand call(List<FileUpload> list) {
                ApplicationCommandLocalSendData applicationCommandLocalSendData = applicationCommandLocalSendDataCopy;
                C12238m.checkNotNullExpressionValue(list, "attachmentParts");
                return new SendPayload.ReadyToSendCommand(applicationCommandLocalSendData, list);
            }
        }));
        C12238m.checkNotNullExpressionValue(observableM11079m, "Observable.concat(\n     …)\n              }\n      )");
        return observableM11079m;
    }

    public final Observable<SendPayload> getSendPayload(ContentResolver contentResolver, RestAPIParams.Message apiParamMessage, List<? extends Attachment<?>> attachments) {
        final RestAPIParams.Message messageCopy = apiParamMessage;
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        C12238m.checkNotNullParameter(messageCopy, "apiParamMessage");
        if (attachments == null) {
            C12721k c12721k = new C12721k(new SendPayload.ReadyToSend(messageCopy, C12147n.emptyList()));
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return c12721k;
        }
        List<Attachment<?>> listExtractLinks = AttachmentUtilsKt.extractLinks(attachments, contentResolver);
        String content = apiParamMessage.getContent();
        if (content == null) {
            content = "";
        }
        String strAppendLinks = AttachmentUtilsKt.appendLinks(content, listExtractLinks);
        if (!C12238m.areEqual(strAppendLinks, apiParamMessage.getContent())) {
            messageCopy = apiParamMessage.copy((510 & 1) != 0 ? apiParamMessage.content : strAppendLinks, (510 & 2) != 0 ? apiParamMessage.nonce : null, (510 & 4) != 0 ? apiParamMessage.applicationId : null, (510 & 8) != 0 ? apiParamMessage.activity : null, (510 & 16) != 0 ? apiParamMessage.stickerIds : null, (510 & 32) != 0 ? apiParamMessage.messageReference : null, (510 & 64) != 0 ? apiParamMessage.allowedMentions : null, (510 & 128) != 0 ? apiParamMessage.captchaKey : null, (510 & 256) != 0 ? apiParamMessage.captchaRqtoken : null);
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(C12163u.minus((Iterable) attachments, (Iterable) listExtractLinks));
        if (!(!listUniqueifyNames.isEmpty())) {
            C12721k c12721k2 = new C12721k(new SendPayload.ReadyToSend(messageCopy, C12147n.emptyList()));
            C12238m.checkNotNullExpressionValue(c12721k2, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return c12721k2;
        }
        C12721k c12721k3 = new C12721k(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, C1643a.m871q("file", i)));
            i = i2;
        }
        Observable<SendPayload> observableM11079m = Observable.m11079m(c12721k3, Observable.m11078l(arrayList).m11105f0().m11083G(new InterfaceC12589b<List<FileUpload>, SendPayload.ReadyToSend>() { // from class: com.discord.utilities.rest.SendUtils.getSendPayload.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final SendPayload.ReadyToSend call(List<FileUpload> list) {
                RestAPIParams.Message message = messageCopy;
                C12238m.checkNotNullExpressionValue(list, "attachmentParts");
                return new SendPayload.ReadyToSend(message, list);
            }
        }));
        C12238m.checkNotNullExpressionValue(observableM11079m, "Observable.concat(\n     …)\n              }\n      )");
        return observableM11079m;
    }

    public final void handleCaptchaRequired(MessageResult.CaptchaRequired messageResult) {
        C12238m.checkNotNullParameter(messageResult, "messageResult");
        WidgetCaptchaBottomSheet.INSTANCE.enqueue("Message Captcha", new C68651(messageResult), new C68662(messageResult), CaptchaErrorBody.INSTANCE.createFromError(messageResult.getError()));
    }

    @MainThread
    public final void handleSendError(Error error, Context context, Function0<Unit> filesTooLargeCallback, Function0<Unit> failedDeliveryToRecipientCallback) {
        C12238m.checkNotNullParameter(error, "error");
        C12238m.checkNotNullParameter(context, "context");
        error.setShowErrorToasts(false);
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        if (abortCodeMessageResId != null) {
            C0876m.m169g(context, abortCodeMessageResId.intValue(), 0, null, 12);
        } else if (error.getType() == Error.Type.REQUEST_TOO_LARGE) {
            if (filesTooLargeCallback != null) {
                filesTooLargeCallback.invoke();
            }
        } else if (error.getType() != Error.Type.FORBIDDEN_DISCORD) {
            Error.Response response2 = error.getResponse();
            C12238m.checkNotNullExpressionValue(response2, "error.response");
            if (response2.isKnownResponse() || error.getType() == Error.Type.NETWORK) {
                error.setShowErrorToasts(true);
            } else {
                C0876m.m169g(context, C5419R.string.network_error_bad_request, 0, null, 12);
            }
        } else if (failedDeliveryToRecipientCallback != null) {
            failedDeliveryToRecipientCallback.invoke();
        }
        error.showToasts(context);
    }

    @VisibleForTesting
    public final <T> Attachment<T> renamedWithDuplicateCount(Attachment<? extends T> attachment, int i) {
        String str;
        C12238m.checkNotNullParameter(attachment, "$this$renamedWithDuplicateCount");
        long id2 = attachment.getId();
        Uri uri = attachment.getUri();
        Pair<String, String> pairSplitFileExtension = splitFileExtension(attachment.getDisplayName());
        String strComponent1 = pairSplitFileExtension.component1();
        String strComponent2 = pairSplitFileExtension.component2();
        if (strComponent2 != null) {
            str = strComponent1 + '-' + i + '.' + strComponent2;
        } else {
            str = strComponent1 + '-' + i;
        }
        return new Attachment<>(id2, uri, str, attachment.getData(), false, 16, null);
    }

    @VisibleForTesting
    public final List<Attachment<?>> uniqueifyNames(List<? extends Attachment<?>> attachmentParts) {
        C12238m.checkNotNullParameter(attachmentParts, "attachmentParts");
        return C12078q.toList(C12073l.sequence(new C68671(attachmentParts, null)));
    }
}
