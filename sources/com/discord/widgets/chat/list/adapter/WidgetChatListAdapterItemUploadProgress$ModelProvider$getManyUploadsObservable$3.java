package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Objects;
import rx.functions.FuncN;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3<R> implements FuncN<Long> {
    public static final WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3 INSTANCE = new WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3();

    @Override // rx.functions.FuncN
    public /* bridge */ /* synthetic */ Long call(Object[] objArr) {
        return call(objArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.FuncN
    public final Long call(Object[] objArr) {
        m.checkNotNullExpressionValue(objArr, "bytesWrittenPerUpload");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Long");
            arrayList.add(Long.valueOf(((Long) obj).longValue()));
        }
        return Long.valueOf(u.sumOfLong(arrayList));
    }
}
