package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEvent $activeEvent$inlined;
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState$inlined;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1(GuildScheduledEvent guildScheduledEvent, WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        this.$activeEvent$inlined = guildScheduledEvent;
        this.this$0 = widgetCallFullscreen;
        this.$viewState$inlined = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsBottomSheet$Companion widgetGuildScheduledEventDetailsBottomSheet$Companion = WidgetGuildScheduledEventDetailsBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventDetailsBottomSheet$Companion.showForGuild(parentFragmentManager, this.$activeEvent$inlined.getId());
    }
}
