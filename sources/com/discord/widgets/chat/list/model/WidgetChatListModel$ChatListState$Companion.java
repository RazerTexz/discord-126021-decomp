package com.discord.widgets.chat.list.model;

import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$ChatListState$Companion {
    private WidgetChatListModel$ChatListState$Companion() {
    }

    public final Observable<WidgetChatListModel$ChatListState> get(long channelId) {
        Observable observableY = StoreStream.Companion.getMessages().observeIsDetached(channelId).Y(new WidgetChatListModel$ChatListState$Companion$get$1(channelId));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
        return observableY;
    }

    public /* synthetic */ WidgetChatListModel$ChatListState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
