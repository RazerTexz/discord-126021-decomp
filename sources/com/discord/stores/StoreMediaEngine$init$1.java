package com.discord.stores;

import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLUsageMode;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$init$1 extends o implements Function1<Experiment, Unit> {
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$init$1(StoreMediaEngine storeMediaEngine) {
        super(1);
        this.this$0 = storeMediaEngine;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
        invoke2(experiment);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Experiment experiment) {
        int bucket = experiment.getBucket();
        this.this$0.getMediaEngine().h((bucket == 1 || bucket == 3) ? MediaEngine$OpenSLUsageMode.EXCLUDE_LIST : MediaEngine$OpenSLUsageMode.ALLOW_LIST);
    }
}
