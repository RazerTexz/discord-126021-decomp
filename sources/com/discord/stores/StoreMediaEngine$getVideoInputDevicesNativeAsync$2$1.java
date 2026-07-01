package com.discord.stores;

import co.discord.media_engine.VideoInputDeviceDescription;
import d0.k$a;
import d0.w.e;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1 extends k implements Function1<VideoInputDeviceDescription[], Unit> {
    public StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(CancellableContinuation cancellableContinuation) {
        super(1, cancellableContinuation, e.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        invoke2(videoInputDeviceDescriptionArr);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        m.checkNotNullParameter(videoInputDeviceDescriptionArr, "p1");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) this.receiver;
        k$a k_a = d0.k.j;
        cancellableContinuation.resumeWith(d0.k.m97constructorimpl(videoInputDeviceDescriptionArr));
    }
}
