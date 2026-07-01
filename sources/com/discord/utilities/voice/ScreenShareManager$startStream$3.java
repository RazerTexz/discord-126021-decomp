package com.discord.utilities.voice;

import android.content.Intent;
import com.discord.rtcconnection.RtcConnection$Metadata;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager$startStream$3 extends o implements Function1<RtcConnection$Metadata, Unit> {
    public final /* synthetic */ Intent $intent;
    public final /* synthetic */ ScreenShareManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenShareManager$startStream$3(ScreenShareManager screenShareManager, Intent intent) {
        super(1);
        this.this$0 = screenShareManager;
        this.$intent = intent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RtcConnection$Metadata rtcConnection$Metadata) {
        invoke2(rtcConnection$Metadata);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RtcConnection$Metadata rtcConnection$Metadata) {
        ScreenShareManager.access$handleStartStream(this.this$0, this.$intent);
    }
}
