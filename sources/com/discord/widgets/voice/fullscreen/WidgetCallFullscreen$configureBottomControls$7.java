package com.discord.widgets.voice.fullscreen;

import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureBottomControls$7 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureBottomControls$7(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        super(0);
        this.this$0 = widgetCallFullscreen;
        this.$viewState = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.this$0, this.$viewState.getCallModel().getChannel(), "Voice Call", null, null, 24, null);
    }
}
