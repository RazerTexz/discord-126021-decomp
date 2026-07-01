package com.discord.stores;

import co.discord.media_engine.VideoInputDeviceDescription;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$getVideoInputDevicesNative$1 extends k implements Function1<VideoInputDeviceDescription[], Unit> {
    public StoreMediaEngine$getVideoInputDevicesNative$1(Function1 function1) {
        super(1, function1, Function1.class, "invoke", "invoke(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        invoke2(videoInputDeviceDescriptionArr);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        m.checkNotNullParameter(videoInputDeviceDescriptionArr, "p1");
        ((Function1) this.receiver).invoke(videoInputDeviceDescriptionArr);
    }
}
