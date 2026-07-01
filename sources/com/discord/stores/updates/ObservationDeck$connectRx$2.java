package com.discord.stores.updates;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action0;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck$connectRx$2 implements Action0 {
    public final /* synthetic */ Ref$ObjectRef $observer;
    public final /* synthetic */ ObservationDeck this$0;

    public ObservationDeck$connectRx$2(ObservationDeck observationDeck, Ref$ObjectRef ref$ObjectRef) {
        this.this$0 = observationDeck;
        this.$observer = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Action0
    public final void call() {
        ObservationDeck$Observer observationDeck$Observer = (ObservationDeck$Observer) this.$observer.element;
        if (observationDeck$Observer != null) {
            this.this$0.disconnect(observationDeck$Observer);
        }
    }
}
