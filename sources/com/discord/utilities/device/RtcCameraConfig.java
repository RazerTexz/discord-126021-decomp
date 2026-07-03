package com.discord.utilities.device;

import androidx.annotation.AnyThread;
import co.discord.media_engine.CameraEnumeratorProvider;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: RtcCameraConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RtcCameraConfig {
    public static final RtcCameraConfig INSTANCE = new RtcCameraConfig();
    private static final AtomicBoolean initialized = new AtomicBoolean();

    /* JADX INFO: renamed from: com.discord.utilities.device.RtcCameraConfig$init$1 */
    /* JADX INFO: compiled from: RtcCameraConfig.kt */
    public static final class C67411 extends AbstractC12240o implements Function1<Experiment, Unit> {
        public static final C67411 INSTANCE = new C67411();

        public C67411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
            invoke2(experiment);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Experiment experiment) {
            C12238m.checkNotNullParameter(experiment, "it");
            CameraEnumeratorProvider.INSTANCE.init(ApplicationProvider.INSTANCE.get(), experiment.getBucket() == 1);
        }
    }

    private RtcCameraConfig() {
    }

    private final Observable<Experiment> observeExperiment(StoreExperiments storeExperiments) {
        Observable<R> observableM11083G = storeExperiments.observeUserExperiment("2021-02_android_webrtc_camera2", true).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11100Z = observableM11083G.m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "storeExperiments.observe…Null()\n          .take(1)");
        return ObservableExtensionsKt.computationLatest(observableM11100Z);
    }

    @AnyThread
    public final void init() {
        if (initialized.compareAndSet(false, true)) {
            ObservableExtensionsKt.appSubscribe(observeExperiment(StoreStream.INSTANCE.getExperiments()), (Class<?>) RtcCameraConfig.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C67411.INSTANCE);
        }
    }
}
