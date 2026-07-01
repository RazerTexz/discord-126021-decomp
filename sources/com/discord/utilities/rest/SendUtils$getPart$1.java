package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.graphics.Bitmap$CompressFormat;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import okhttp3.RequestBody;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils$getPart$1<T> implements Action1<Emitter<SendUtils$FileUpload>> {
    public final /* synthetic */ ContentResolver $contentResolver;
    public final /* synthetic */ String $name;
    public final /* synthetic */ Attachment $this_getPart;

    public SendUtils$getPart$1(Attachment attachment, String str, ContentResolver contentResolver) {
        this.$this_getPart = attachment;
        this.$name = str;
        this.$contentResolver = contentResolver;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<SendUtils$FileUpload> emitter) {
        call2(emitter);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<SendUtils$FileUpload> emitter) {
        emitter.onNext(new SendUtils$getPart$1$1(this).invoke2((RequestBody) new AttachmentRequestBody(this.$contentResolver, this.$this_getPart), AttachmentUtilsKt.getMimeType(this.$this_getPart, this.$contentResolver), (Bitmap$CompressFormat) null));
        emitter.onCompleted();
    }
}
