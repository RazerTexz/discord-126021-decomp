package com.discord.widgets.user.search;

import b.a.d.d0;
import d0.z.d.m;
import kotlin.Unit;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGlobalSearchDismissModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchDismissModel extends d0<Unit> {
    private final PublishSubject<Unit> dismissEventsSubject;

    public WidgetGlobalSearchDismissModel() {
        super(null, 1, null);
        this.dismissEventsSubject = PublishSubject.k0();
    }

    public final void dismiss() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        publishSubject.k.onNext(Unit.a);
    }

    public final Observable<Unit> getDismissEvents() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        m.checkNotNullExpressionValue(publishSubject, "dismissEventsSubject");
        return publishSubject;
    }
}
