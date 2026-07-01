package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBoundOrOnResume$1$1<T, R> implements b<WidgetIncomingShare$ContentModel, Observable<? extends ViewEmbedGameInvite$Model>> {
    public static final WidgetIncomingShare$onViewBoundOrOnResume$1$1 INSTANCE = new WidgetIncomingShare$onViewBoundOrOnResume$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ViewEmbedGameInvite$Model> call(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel) {
        return call2(widgetIncomingShare$ContentModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ViewEmbedGameInvite$Model> call2(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel) {
        return ViewEmbedGameInvite$Model.Companion.getForShare(ClockFactory.get(), widgetIncomingShare$ContentModel.getActivityActionUri(), widgetIncomingShare$ContentModel.getActivity());
    }
}
