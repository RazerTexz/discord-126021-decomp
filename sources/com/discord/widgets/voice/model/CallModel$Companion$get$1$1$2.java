package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import j0.k.b;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel$Companion$get$1$1$2<T, R> implements b<Experiment, Integer> {
    public static final CallModel$Companion$get$1$1$2 INSTANCE = new CallModel$Companion$get$1$1$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(Experiment experiment) {
        return call2(experiment);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Experiment experiment) {
        return Integer.valueOf(experiment != null ? experiment.getBucket() : 0);
    }
}
