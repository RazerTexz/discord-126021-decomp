package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils$FileUpload;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2<T, R> implements b<Integer, WidgetChatListAdapterItemUploadProgress$Model$Single> {
    public final /* synthetic */ SendUtils$FileUpload $upload;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2(SendUtils$FileUpload sendUtils$FileUpload) {
        this.$upload = sendUtils$FileUpload;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress$Model$Single call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemUploadProgress$Model$Single call2(Integer num) {
        String name = this.$upload.getName();
        String mimeType = this.$upload.getMimeType();
        long contentLength = this.$upload.getContentLength();
        m.checkNotNullExpressionValue(num, "progressPercent");
        return new WidgetChatListAdapterItemUploadProgress$Model$Single(name, mimeType, contentLength, num.intValue());
    }
}
