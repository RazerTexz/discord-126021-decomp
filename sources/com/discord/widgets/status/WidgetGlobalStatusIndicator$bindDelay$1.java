package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator$bindDelay$1<T, R> implements b<WidgetGlobalStatusIndicatorViewModel$ViewState, Observable<? extends WidgetGlobalStatusIndicatorViewModel$ViewState>> {
    public final /* synthetic */ Observable $this_bindDelay;

    public WidgetGlobalStatusIndicator$bindDelay$1(Observable observable) {
        this.$this_bindDelay = observable;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGlobalStatusIndicatorViewModel$ViewState> call(WidgetGlobalStatusIndicatorViewModel$ViewState widgetGlobalStatusIndicatorViewModel$ViewState) {
        return call2(widgetGlobalStatusIndicatorViewModel$ViewState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGlobalStatusIndicatorViewModel$ViewState> call2(WidgetGlobalStatusIndicatorViewModel$ViewState widgetGlobalStatusIndicatorViewModel$ViewState) {
        Long lValueOf;
        if (widgetGlobalStatusIndicatorViewModel$ViewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$Offline) {
            lValueOf = Long.valueOf(((WidgetGlobalStatusIndicatorViewModel$ViewState$Offline) widgetGlobalStatusIndicatorViewModel$ViewState).getDelay());
        } else {
            lValueOf = widgetGlobalStatusIndicatorViewModel$ViewState instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting ? Long.valueOf(((WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting) widgetGlobalStatusIndicatorViewModel$ViewState).getDelay()) : null;
        }
        if (lValueOf == null) {
            return this.$this_bindDelay;
        }
        lValueOf.longValue();
        return new k(widgetGlobalStatusIndicatorViewModel$ViewState).q(lValueOf.longValue(), TimeUnit.MILLISECONDS);
    }
}
