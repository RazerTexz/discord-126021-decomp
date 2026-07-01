package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5<T, R> implements b<Integer, WidgetChatListAdapterItemUploadProgress$Model$Many> {
    public final /* synthetic */ Ref$LongRef $totalContentLength;
    public final /* synthetic */ List $uploads;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5(List list, Ref$LongRef ref$LongRef) {
        this.$uploads = list;
        this.$totalContentLength = ref$LongRef;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress$Model$Many call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemUploadProgress$Model$Many call2(Integer num) {
        int size = this.$uploads.size();
        long j = this.$totalContentLength.element;
        m.checkNotNullExpressionValue(num, "overallProgressPercent");
        return new WidgetChatListAdapterItemUploadProgress$Model$Many(size, j, num.intValue());
    }
}
