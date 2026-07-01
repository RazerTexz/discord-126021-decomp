package com.discord.stores;

import co.discord.media_engine.VideoInputDeviceDescription;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$handleVoiceChannelSelected$1 extends o implements Function1<VideoInputDeviceDescription[], Unit> {
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$handleVoiceChannelSelected$1(StoreMediaEngine storeMediaEngine) {
        super(1);
        this.this$0 = storeMediaEngine;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        invoke2(videoInputDeviceDescriptionArr);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        m.checkNotNullParameter(videoInputDeviceDescriptionArr, "it");
        StoreMediaEngine.handleVideoInputDevices$default(this.this$0, videoInputDeviceDescriptionArr, null, null, 4, null);
    }
}
