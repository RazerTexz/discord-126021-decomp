package com.discord.stores;

import co.discord.media_engine.VideoInputDeviceDescription;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.C12112k;
import p507d0.p584w.C12178e;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1 extends C12236k implements Function1<VideoInputDeviceDescription[], Unit> {
    public StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(CancellableContinuation cancellableContinuation) {
        super(1, cancellableContinuation, C12178e.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        invoke2(videoInputDeviceDescriptionArr);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        C12238m.checkNotNullParameter(videoInputDeviceDescriptionArr, "p1");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) this.receiver;
        C12112k.a aVar = C12112k.f25169j;
        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(videoInputDeviceDescriptionArr));
    }
}
