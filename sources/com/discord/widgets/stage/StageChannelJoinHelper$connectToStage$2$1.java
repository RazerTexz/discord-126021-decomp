package com.discord.widgets.stage;

import com.discord.app.AppTransitionActivity$Transition;
import com.discord.stores.StoreVoiceChannelSelected$JoinVoiceChannelResult;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$connectToStage$2$1 extends o implements Function1<StoreVoiceChannelSelected$JoinVoiceChannelResult, Unit> {
    public final /* synthetic */ StageChannelJoinHelper$connectToStage$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$connectToStage$2$1(StageChannelJoinHelper$connectToStage$2 stageChannelJoinHelper$connectToStage$2) {
        super(1);
        this.this$0 = stageChannelJoinHelper$connectToStage$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceChannelSelected$JoinVoiceChannelResult storeVoiceChannelSelected$JoinVoiceChannelResult) {
        invoke2(storeVoiceChannelSelected$JoinVoiceChannelResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceChannelSelected$JoinVoiceChannelResult storeVoiceChannelSelected$JoinVoiceChannelResult) {
        m.checkNotNullParameter(storeVoiceChannelSelected$JoinVoiceChannelResult, "it");
        StageChannelJoinHelper$connectToStage$2 stageChannelJoinHelper$connectToStage$2 = this.this$0;
        if (stageChannelJoinHelper$connectToStage$2.$launchFullscreen) {
            WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, stageChannelJoinHelper$connectToStage$2.$context, stageChannelJoinHelper$connectToStage$2.$channelId, true, null, AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
        }
        this.this$0.$onCompleted.invoke();
    }
}
