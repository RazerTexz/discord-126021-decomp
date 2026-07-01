package com.discord.widgets.status;

import com.discord.models.application.Unread;
import com.discord.models.application.Unread$Marker;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import d0.d0.f;
import d0.z.d.m;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus$Model$Companion {
    private WidgetChatStatus$Model$Companion() {
    }

    public static final /* synthetic */ WidgetChatStatus$Model access$createModel(WidgetChatStatus$Model$Companion widgetChatStatus$Model$Companion, boolean z2, Set set, Unread unread) {
        return widgetChatStatus$Model$Companion.createModel(z2, set, unread);
    }

    private final WidgetChatStatus$Model createModel(boolean isUnreadValid, Set<Long> detachedChannels, Unread unread) {
        Unread$Marker marker = unread.getMarker();
        boolean zContains = detachedChannels.contains(Long.valueOf(marker.getChannelId()));
        int count = unread.getCount();
        int i = zContains ? 25 : 50;
        boolean z2 = isUnreadValid && unread.getCount() > 0 && marker.getChannelId() > 0;
        long channelId = marker.getChannelId();
        Long messageId = marker.getMessageId();
        return new WidgetChatStatus$Model(z2, messageId != null ? messageId.longValue() : 0L, channelId, f.coerceIn(count, 0, i), count >= i);
    }

    public final Observable<WidgetChatStatus$Model> get() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(storeStream$Companion.getChannelsSelected().observeId().r().Y(WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1.INSTANCE).r(), storeStream$Companion.getMessages().getAllDetached(), storeStream$Companion.getReadStates().getUnreadMarkerForSelectedChannel(), new WidgetChatStatus$sam$rx_functions_Func3$0(new WidgetChatStatus$Model$Companion$get$1(this)), 500L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…ILLISECONDS\n            )");
        Observable<WidgetChatStatus$Model> observableR = ObservableExtensionsKt.computationLatest(observableCombineLatest).r();
        m.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChatStatus$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
