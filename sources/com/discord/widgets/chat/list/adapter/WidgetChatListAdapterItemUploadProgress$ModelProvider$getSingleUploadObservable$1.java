package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils$FileUpload;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1<T, R> implements b<Long, Integer> {
    public final /* synthetic */ SendUtils$FileUpload $upload;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1(SendUtils$FileUpload sendUtils$FileUpload) {
        this.$upload = sendUtils$FileUpload;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        WidgetChatListAdapterItemUploadProgress$ModelProvider widgetChatListAdapterItemUploadProgress$ModelProvider = WidgetChatListAdapterItemUploadProgress$ModelProvider.INSTANCE;
        m.checkNotNullExpressionValue(l, "bytesWritten");
        return Integer.valueOf(WidgetChatListAdapterItemUploadProgress$ModelProvider.access$getPercentage(widgetChatListAdapterItemUploadProgress$ModelProvider, l.longValue(), this.$upload.getContentLength()));
    }
}
