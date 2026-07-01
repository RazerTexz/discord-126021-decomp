package com.discord.stores.updates;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck$connectRx$1<T> implements Action1<Emitter<Unit>> {
    public final /* synthetic */ Ref$ObjectRef $observer;
    public final /* synthetic */ String $observerName;
    public final /* synthetic */ boolean $updateOnConnect;
    public final /* synthetic */ ObservationDeck$UpdateSource[] $updateSources;
    public final /* synthetic */ ObservationDeck this$0;

    public ObservationDeck$connectRx$1(ObservationDeck observationDeck, Ref$ObjectRef ref$ObjectRef, boolean z2, String str, ObservationDeck$UpdateSource[] observationDeck$UpdateSourceArr) {
        this.this$0 = observationDeck;
        this.$observer = ref$ObjectRef;
        this.$updateOnConnect = z2;
        this.$observerName = str;
        this.$updateSources = observationDeck$UpdateSourceArr;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<Unit> emitter) {
        call2(emitter);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<Unit> emitter) {
        Ref$ObjectRef ref$ObjectRef = this.$observer;
        ObservationDeck observationDeck = this.this$0;
        boolean z2 = this.$updateOnConnect;
        String str = this.$observerName;
        ObservationDeck$connectRx$1$1 observationDeck$connectRx$1$1 = new ObservationDeck$connectRx$1$1(emitter);
        ObservationDeck$UpdateSource[] observationDeck$UpdateSourceArr = this.$updateSources;
        ref$ObjectRef.element = (T) observationDeck.connect((ObservationDeck$UpdateSource[]) Arrays.copyOf(observationDeck$UpdateSourceArr, observationDeck$UpdateSourceArr.length), z2, str, observationDeck$connectRx$1$1);
    }
}
