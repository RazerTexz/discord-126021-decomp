package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$observeModel$1<T, R> implements b<NavigationTab, Observable<? extends WidgetUserMentions$Model>> {
    public final /* synthetic */ WidgetUserMentions this$0;

    public WidgetUserMentions$observeModel$1(WidgetUserMentions widgetUserMentions) {
        this.this$0 = widgetUserMentions;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMentions$Model> call(NavigationTab navigationTab) {
        return call2(navigationTab);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMentions$Model> call2(NavigationTab navigationTab) {
        if (navigationTab == NavigationTab.MENTIONS) {
            return WidgetUserMentions$Model.Companion.get(WidgetUserMentions.access$getMentionsLoader$p(this.this$0), navigationTab);
        }
        WidgetUserMentions$Model$Companion widgetUserMentions$Model$Companion = WidgetUserMentions$Model.Companion;
        WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoaderAccess$getMentionsLoader$p = WidgetUserMentions.access$getMentionsLoader$p(this.this$0);
        m.checkNotNullExpressionValue(navigationTab, "selectedTab");
        return widgetUserMentions$Model$Companion.get(widgetUserMentions$Model$MessageLoaderAccess$getMentionsLoader$p, navigationTab).Z(1);
    }
}
