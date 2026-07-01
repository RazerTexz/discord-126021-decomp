package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4<T, R> implements b<Long, Integer> {
    public final /* synthetic */ Ref$LongRef $totalContentLength;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4(Ref$LongRef ref$LongRef) {
        this.$totalContentLength = ref$LongRef;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        WidgetChatListAdapterItemUploadProgress$ModelProvider widgetChatListAdapterItemUploadProgress$ModelProvider = WidgetChatListAdapterItemUploadProgress$ModelProvider.INSTANCE;
        m.checkNotNullExpressionValue(l, "totalBytesWritten");
        return Integer.valueOf(WidgetChatListAdapterItemUploadProgress$ModelProvider.access$getPercentage(widgetChatListAdapterItemUploadProgress$ModelProvider, l.longValue(), this.$totalContentLength.element));
    }
}
