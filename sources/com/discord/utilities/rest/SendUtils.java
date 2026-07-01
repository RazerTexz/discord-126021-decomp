package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$Message;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.error.Error$Type;
import com.discord.utilities.messagesend.MessageResult$CaptchaRequired;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import d0.f0.l;
import d0.f0.q;
import d0.g0.w;
import d0.o;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import rx.Emitter$BackpressureMode;
import rx.Observable;
import s.a.a.n;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils {
    public static final SendUtils INSTANCE = new SendUtils();
    public static final int MAX_MESSAGE_CHARACTER_COUNT = 2000;
    public static final int MAX_MESSAGE_CHARACTER_COUNT_PREMIUM = 4000;

    private SendUtils() {
    }

    private final Observable<SendUtils$FileUpload> getPart(Attachment<?> attachment, ContentResolver contentResolver, String str) {
        return Observable.o(new SendUtils$getPart$1(attachment, str, contentResolver), Emitter$BackpressureMode.BUFFER);
    }

    private final SendUtils$SendPayload$Preprocessing getPreprocessingFromAttachments(ContentResolver contentResolver, List<? extends Attachment<?>> fileAttachments) {
        if (fileAttachments.size() != 1) {
            return new SendUtils$SendPayload$Preprocessing(fileAttachments.size(), null, null);
        }
        Attachment<?> attachment = (Attachment) u.first((List) fileAttachments);
        return new SendUtils$SendPayload$Preprocessing(1, Attachment.Companion.a(attachment), AttachmentUtilsKt.getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName()));
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
        int iLastIndexOf$default = w.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return o.to(str, null);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, iLastIndexOf$default);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iLastIndexOf$default + 1);
        m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return o.to(strSubstring, strSubstring2);
    }

    public final void compressImageAttachments(Context context, List<? extends Attachment<?>> attachments, Function1<? super List<? extends Attachment<?>>, Unit> onCompressed) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attachments, "attachments");
        m.checkNotNullParameter(onCompressed, "onCompressed");
        x0 x0Var = x0.j;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        f.H0(x0Var, n.f3830b, null, new SendUtils$compressImageAttachments$1(attachments, context, onCompressed, null), 2, null);
    }

    public final Observable<SendUtils$SendPayload> getSendCommandPayload(ContentResolver contentResolver, ApplicationCommandLocalSendData apiParamMessage, List<? extends Attachment<?>> attachments) {
        m.checkNotNullParameter(contentResolver, "contentResolver");
        m.checkNotNullParameter(apiParamMessage, "apiParamMessage");
        if (attachments == null) {
            k kVar = new k(new SendUtils$SendPayload$ReadyToSendCommand(apiParamMessage, d0.t.n.emptyList()));
            m.checkNotNullExpressionValue(kVar, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return kVar;
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(attachments);
        ApplicationCommandLocalSendData applicationCommandLocalSendDataCopy$default = ApplicationCommandLocalSendData.copy$default(apiParamMessage, 0L, 0L, null, null, null, null, null, null, StoreApplicationCommandsKt.mapApplicationCommandValues(apiParamMessage.getApplicationCommandsValues(), new SendUtils$getSendCommandPayload$attachmentCorrectedMessage$1(listUniqueifyNames)), null, null, 1791, null);
        if (!(!listUniqueifyNames.isEmpty())) {
            k kVar2 = new k(new SendUtils$SendPayload$ReadyToSendCommand(applicationCommandLocalSendDataCopy$default, d0.t.n.emptyList()));
            m.checkNotNullExpressionValue(kVar2, "Observable.just(SendPayl…tedMessage, emptyList()))");
            return kVar2;
        }
        k kVar3 = new k(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, "files[" + i + ']'));
            i = i2;
        }
        Observable<SendUtils$SendPayload> observableM = Observable.m(kVar3, Observable.l(arrayList).f0().G(new SendUtils$getSendCommandPayload$2(applicationCommandLocalSendDataCopy$default)));
        m.checkNotNullExpressionValue(observableM, "Observable.concat(\n     …)\n              }\n      )");
        return observableM;
    }

    public final Observable<SendUtils$SendPayload> getSendPayload(ContentResolver contentResolver, RestAPIParams$Message apiParamMessage, List<? extends Attachment<?>> attachments) {
        RestAPIParams$Message restAPIParams$MessageCopy$default = apiParamMessage;
        m.checkNotNullParameter(contentResolver, "contentResolver");
        m.checkNotNullParameter(restAPIParams$MessageCopy$default, "apiParamMessage");
        if (attachments == null) {
            k kVar = new k(new SendUtils$SendPayload$ReadyToSend(restAPIParams$MessageCopy$default, d0.t.n.emptyList()));
            m.checkNotNullExpressionValue(kVar, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return kVar;
        }
        List<Attachment<?>> listExtractLinks = AttachmentUtilsKt.extractLinks(attachments, contentResolver);
        String content = apiParamMessage.getContent();
        if (content == null) {
            content = "";
        }
        String strAppendLinks = AttachmentUtilsKt.appendLinks(content, listExtractLinks);
        if (!m.areEqual(strAppendLinks, apiParamMessage.getContent())) {
            restAPIParams$MessageCopy$default = RestAPIParams$Message.copy$default(apiParamMessage, strAppendLinks, null, null, null, null, null, null, null, null, 510, null);
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(u.minus((Iterable) attachments, (Iterable) listExtractLinks));
        if (!(!listUniqueifyNames.isEmpty())) {
            k kVar2 = new k(new SendUtils$SendPayload$ReadyToSend(restAPIParams$MessageCopy$default, d0.t.n.emptyList()));
            m.checkNotNullExpressionValue(kVar2, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return kVar2;
        }
        k kVar3 = new k(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, a.q("file", i)));
            i = i2;
        }
        Observable<SendUtils$SendPayload> observableM = Observable.m(kVar3, Observable.l(arrayList).f0().G(new SendUtils$getSendPayload$2(restAPIParams$MessageCopy$default)));
        m.checkNotNullExpressionValue(observableM, "Observable.concat(\n     …)\n              }\n      )");
        return observableM;
    }

    public final void handleCaptchaRequired(MessageResult$CaptchaRequired messageResult) {
        m.checkNotNullParameter(messageResult, "messageResult");
        WidgetCaptchaBottomSheet.Companion.enqueue("Message Captcha", new SendUtils$handleCaptchaRequired$1(messageResult), new SendUtils$handleCaptchaRequired$2(messageResult), CaptchaErrorBody.Companion.createFromError(messageResult.getError()));
    }

    @MainThread
    public final void handleSendError(Error error, Context context, Function0<Unit> filesTooLargeCallback, Function0<Unit> failedDeliveryToRecipientCallback) {
        m.checkNotNullParameter(error, "error");
        m.checkNotNullParameter(context, "context");
        error.setShowErrorToasts(false);
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        if (abortCodeMessageResId != null) {
            b.a.d.m.g(context, abortCodeMessageResId.intValue(), 0, null, 12);
        } else if (error.getType() == Error$Type.REQUEST_TOO_LARGE) {
            if (filesTooLargeCallback != null) {
                filesTooLargeCallback.invoke();
            }
        } else if (error.getType() != Error$Type.FORBIDDEN_DISCORD) {
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "error.response");
            if (response2.isKnownResponse() || error.getType() == Error$Type.NETWORK) {
                error.setShowErrorToasts(true);
            } else {
                b.a.d.m.g(context, 2131893169, 0, null, 12);
            }
        } else if (failedDeliveryToRecipientCallback != null) {
            failedDeliveryToRecipientCallback.invoke();
        }
        error.showToasts(context);
    }

    @VisibleForTesting
    public final <T> Attachment<T> renamedWithDuplicateCount(Attachment<? extends T> attachment, int i) {
        String str;
        m.checkNotNullParameter(attachment, "$this$renamedWithDuplicateCount");
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
        m.checkNotNullParameter(attachmentParts, "attachmentParts");
        return q.toList(l.sequence(new SendUtils$uniqueifyNames$1(attachmentParts, null)));
    }
}
