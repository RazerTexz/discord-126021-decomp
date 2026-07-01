package com.discord.widgets.voice.fullscreen;

import com.discord.views.calls.VideoCallParticipantView$StreamFps;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$setUpGridRecycler$4 extends k implements Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> {
    public WidgetCallFullscreen$setUpGridRecycler$4(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(2, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onStreamQualityIndicatorShown", "onStreamQualityIndicatorShown(Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(VideoCallParticipantView$StreamResolution videoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps videoCallParticipantView$StreamFps) {
        invoke2(videoCallParticipantView$StreamResolution, videoCallParticipantView$StreamFps);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoCallParticipantView$StreamResolution videoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps videoCallParticipantView$StreamFps) {
        m.checkNotNullParameter(videoCallParticipantView$StreamResolution, "p1");
        ((WidgetCallFullscreenViewModel) this.receiver).onStreamQualityIndicatorShown(videoCallParticipantView$StreamResolution, videoCallParticipantView$StreamFps);
    }
}
