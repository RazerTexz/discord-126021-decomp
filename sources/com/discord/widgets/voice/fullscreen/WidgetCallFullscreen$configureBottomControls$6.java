package com.discord.widgets.voice.fullscreen;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet;
import com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureBottomControls$6 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureBottomControls$6(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
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
        WidgetScreenShareNfxSheet$Companion widgetScreenShareNfxSheet$Companion = WidgetScreenShareNfxSheet.Companion;
        if (!widgetScreenShareNfxSheet$Companion.canShow()) {
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).onScreenShareClick();
            return;
        }
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetScreenShareNfxSheet$Companion.show$default(widgetScreenShareNfxSheet$Companion, parentFragmentManager, WidgetCallFullscreen.access$getChannelId(this.this$0), this.$viewState.getCallModel().getChannel().getGuildId(), null, 8, null);
    }
}
