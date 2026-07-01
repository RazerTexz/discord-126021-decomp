package com.discord.utilities.device;

import co.discord.media_engine.CameraEnumeratorProvider;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RtcCameraConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RtcCameraConfig$init$1 extends o implements Function1<Experiment, Unit> {
    public static final RtcCameraConfig$init$1 INSTANCE = new RtcCameraConfig$init$1();

    public RtcCameraConfig$init$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
        invoke2(experiment);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Experiment experiment) {
        m.checkNotNullParameter(experiment, "it");
        CameraEnumeratorProvider.INSTANCE.init(ApplicationProvider.INSTANCE.get(), experiment.getBucket() == 1);
    }
}
