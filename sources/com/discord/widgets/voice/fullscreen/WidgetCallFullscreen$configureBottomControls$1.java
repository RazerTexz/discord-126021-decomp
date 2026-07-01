package com.discord.widgets.voice.fullscreen;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$Companion;
import com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet;
import com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureBottomControls$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureBottomControls$1(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
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
        GuildScheduledEvent guildScheduledEventToEndForCall$default;
        long jAccess$getChannelId = WidgetCallFullscreen.access$getChannelId(this.this$0);
        if (StageChannelUtils.shouldShowEndStageBottomSheet$default(StageChannelUtils.INSTANCE, jAccess$getChannelId, null, null, null, null, 30, null)) {
            WidgetEndStageBottomSheet$Companion widgetEndStageBottomSheet$Companion = WidgetEndStageBottomSheet.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetEndStageBottomSheet$Companion.show(parentFragmentManager, "END_STAGE_REQUEST_KEY", jAccess$getChannelId);
            return;
        }
        if (!ChannelUtils.J(this.$viewState.getCallModel().getChannel()) || (guildScheduledEventToEndForCall$default = GuildScheduledEventUtilities$Companion.getGuildScheduledEventToEndForCall$default(GuildScheduledEventUtilities.Companion, this.$viewState.getCallModel(), this.$viewState.getChannelPermissions(), null, 4, null)) == null) {
            WidgetCallFullscreen.finishActivity$default(this.this$0, false, this.$viewState.isTextInVoiceEnabled(), 1, null);
            return;
        }
        WidgetEndGuildScheduledEventBottomSheet$Companion widgetEndGuildScheduledEventBottomSheet$Companion = WidgetEndGuildScheduledEventBottomSheet.Companion;
        FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        widgetEndGuildScheduledEventBottomSheet$Companion.show(parentFragmentManager2, "END_EVENT_REQUEST_KEY", guildScheduledEventToEndForCall$default.getGuildId(), guildScheduledEventToEndForCall$default.getId());
    }
}
