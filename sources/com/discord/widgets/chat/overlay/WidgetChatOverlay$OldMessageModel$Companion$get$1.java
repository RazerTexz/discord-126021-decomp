package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$OldMessageModel$Companion$get$1<T, R> implements b<Long, Observable<? extends WidgetChatOverlay$OldMessageModel>> {
    public static final WidgetChatOverlay$OldMessageModel$Companion$get$1 INSTANCE = new WidgetChatOverlay$OldMessageModel$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatOverlay$OldMessageModel> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatOverlay$OldMessageModel> call2(Long l) {
        Observable observableJ;
        if (l.longValue() <= 0) {
            observableJ = new k(Boolean.FALSE);
        } else {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            StoreMessages messages = storeStream$Companion.getMessages();
            m.checkNotNullExpressionValue(l, "selectedChannelId");
            observableJ = Observable.j(messages.observeIsDetached(l.longValue()), storeStream$Companion.getChat().observeInteractionState().y(new WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1(l)).p(200L, TimeUnit.MILLISECONDS), WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2.INSTANCE);
        }
        return Observable.m(new k(Boolean.FALSE), observableJ).r().G(new WidgetChatOverlay$OldMessageModel$Companion$get$1$1(l));
    }
}
