package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreSlowMode$Type$MessageSend;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import d0.z.d.m;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBoundOrOnResume$1<T, R> implements b<WidgetGlobalSearchModel$ItemDataPayload, Observable<? extends WidgetIncomingShare$Model>> {
    public final /* synthetic */ WidgetIncomingShare this$0;

    public WidgetIncomingShare$onViewBoundOrOnResume$1(WidgetIncomingShare widgetIncomingShare) {
        this.this$0 = widgetIncomingShare;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetIncomingShare$Model> call(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        return call2(widgetGlobalSearchModel$ItemDataPayload);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetIncomingShare$Model> call2(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        Channel channel;
        BehaviorSubject behaviorSubjectAccess$getContentPublisher$p = WidgetIncomingShare.access$getContentPublisher$p(this.this$0);
        Observable<R> observableY = WidgetIncomingShare.access$getContentPublisher$p(this.this$0).Y(WidgetIncomingShare$onViewBoundOrOnResume$1$1.INSTANCE);
        BehaviorSubject behaviorSubjectAccess$getCommentPublisher$p = WidgetIncomingShare.access$getCommentPublisher$p(this.this$0);
        m.checkNotNullExpressionValue(behaviorSubjectAccess$getCommentPublisher$p, "commentPublisher");
        Observable observableLeadingEdgeThrottle = ObservableExtensionsKt.leadingEdgeThrottle(behaviorSubjectAccess$getCommentPublisher$p, 500L, TimeUnit.MILLISECONDS);
        WidgetGlobalSearchModel$Companion widgetGlobalSearchModel$Companion = WidgetGlobalSearchModel.Companion;
        BehaviorSubject behaviorSubjectAccess$getSearchQueryPublisher$p = WidgetIncomingShare.access$getSearchQueryPublisher$p(this.this$0);
        m.checkNotNullExpressionValue(behaviorSubjectAccess$getSearchQueryPublisher$p, "searchQueryPublisher");
        Observable forSend$default = WidgetGlobalSearchModel$Companion.getForSend$default(widgetGlobalSearchModel$Companion, behaviorSubjectAccess$getSearchQueryPublisher$p, null, 2, null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.f(behaviorSubjectAccess$getContentPublisher$p, observableY, observableLeadingEdgeThrottle, forSend$default, storeStream$Companion.getSlowMode().observeCooldownSecs((widgetGlobalSearchModel$ItemDataPayload == null || (channel = widgetGlobalSearchModel$ItemDataPayload.getChannel()) == null) ? null : Long.valueOf(channel.getId()), StoreSlowMode$Type$MessageSend.INSTANCE).G(WidgetIncomingShare$onViewBoundOrOnResume$1$2.INSTANCE).r(), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), new WidgetIncomingShare$onViewBoundOrOnResume$1$3(widgetGlobalSearchModel$ItemDataPayload));
    }
}
