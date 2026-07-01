package com.discord.widgets.voice.fullscreen;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureBottomControls$10 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureBottomControls$10(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
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
        StageRoles stageRolesM72getStageRolestwRsX0 = this.$viewState.m72getStageRolestwRsX0();
        if (stageRolesM72getStageRolestwRsX0 == null || !StageRoles.m32isModeratorimpl(stageRolesM72getStageRolestwRsX0.m35unboximpl())) {
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).toggleRequestToSpeak();
            return;
        }
        WidgetStageRaisedHandsBottomSheet$Companion widgetStageRaisedHandsBottomSheet$Companion = WidgetStageRaisedHandsBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetStageRaisedHandsBottomSheet$Companion.show(parentFragmentManager, WidgetCallFullscreen.access$getChannelId(this.this$0));
    }
}
