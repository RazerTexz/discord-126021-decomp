package com.discord.widgets.user;

import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;
import j0.l.a.r;
import j0.p.a;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$Companion {
    private WidgetUserMentions$Model$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Observable<WidgetUserMentions$Model> get(WidgetUserMentions$Model$MessageLoader messageLoader, NavigationTab selectedTab) {
        m.checkNotNullParameter(messageLoader, "messageLoader");
        m.checkNotNullParameter(selectedTab, "selectedTab");
        Observable<R> observableY = messageLoader.getMentionsLoadingStateSubject().Y(new WidgetUserMentions$Model$Companion$get$1(selectedTab));
        Observable<WidgetUserMentions$Model> observableR = Observable.h0(new r(observableY.j, new LeadingEdgeThrottle(300L, TimeUnit.MILLISECONDS, a.a()))).r();
        m.checkNotNullExpressionValue(observableR, "messageLoader\n          …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetUserMentions$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
