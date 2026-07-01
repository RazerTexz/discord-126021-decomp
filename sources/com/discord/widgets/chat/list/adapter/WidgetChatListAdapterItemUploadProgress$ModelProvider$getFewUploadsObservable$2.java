package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Objects;
import rx.functions.FuncN;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getFewUploadsObservable$2<R> implements FuncN<WidgetChatListAdapterItemUploadProgress$Model$Few> {
    public static final WidgetChatListAdapterItemUploadProgress$ModelProvider$getFewUploadsObservable$2 INSTANCE = new WidgetChatListAdapterItemUploadProgress$ModelProvider$getFewUploadsObservable$2();

    @Override // rx.functions.FuncN
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress$Model$Few call(Object[] objArr) {
        return call(objArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.FuncN
    public final WidgetChatListAdapterItemUploadProgress$Model$Few call(Object[] objArr) {
        m.checkNotNullExpressionValue(objArr, "singles");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress.Model.Single");
            arrayList.add((WidgetChatListAdapterItemUploadProgress$Model$Single) obj);
        }
        return new WidgetChatListAdapterItemUploadProgress$Model$Few(arrayList);
    }
}
