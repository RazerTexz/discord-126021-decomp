package com.discord.widgets.voice.fullscreen;

import com.discord.views.calls.VideoCallParticipantView$ParticipantData;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$1 extends o implements Function1<List<? extends VideoCallParticipantView$ParticipantData>, Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$1(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(1);
        this.this$0 = widgetCallFullscreenViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends VideoCallParticipantView$ParticipantData> list) {
        invoke2((List<VideoCallParticipantView$ParticipantData>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<VideoCallParticipantView$ParticipantData> list) {
        WidgetCallFullscreenViewModel widgetCallFullscreenViewModel = this.this$0;
        m.checkNotNullExpressionValue(list, "it");
        WidgetCallFullscreenViewModel.access$setOffScreenVideoParticipants(widgetCallFullscreenViewModel, list);
    }
}
