package com.discord.widgets.user.search;

import kotlin.Unit;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGlobalSearchDismissModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchDismissModel extends AbstractC0859d0<Unit> {
    private final PublishSubject<Unit> dismissEventsSubject;

    public WidgetGlobalSearchDismissModel() {
        super(null, 1, null);
        this.dismissEventsSubject = PublishSubject.m11133k0();
    }

    public final void dismiss() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        publishSubject.f27650k.onNext(Unit.f27425a);
    }

    public final Observable<Unit> getDismissEvents() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "dismissEventsSubject");
        return publishSubject;
    }
}
