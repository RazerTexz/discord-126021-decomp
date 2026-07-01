package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.GuildEventPromptListViewBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildEventPromptListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildEventPromptListView extends LinearLayout {
    private final GuildEventPromptListViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(GuildEventPromptListView guildEventPromptListView, GuildEventPromptListView$ScheduledEventData guildEventPromptListView$ScheduledEventData, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            guildEventPromptListView$ScheduledEventData = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        guildEventPromptListView.configure(guildEventPromptListView$ScheduledEventData, function0, function1);
    }

    public final void configure(GuildEventPromptListView$ScheduledEventData scheduledEventData, Function0<Unit> onCreateEventClick, Function0<Unit> onStartStageClick) {
        GuildEventPromptView guildEventPromptView = this.binding.d;
        guildEventPromptView.setVisibility(onStartStageClick != null ? 0 : 8);
        String string = guildEventPromptView.getContext().getString(2131895801);
        m.checkNotNullExpressionValue(string, "context.getString(R.stri…tage_channel_start_title)");
        String string2 = guildEventPromptView.getContext().getString(2131895800);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_channel_start_subtitle)");
        guildEventPromptView.configure(2131231625, 2131100304, string, string2);
        guildEventPromptView.setOnClickListener(new GuildEventPromptListView$configure$$inlined$apply$lambda$1(onStartStageClick));
        GuildEventPromptView guildEventPromptView2 = this.binding.f2116b;
        guildEventPromptView2.setVisibility(onCreateEventClick != null ? 0 : 8);
        String string3 = guildEventPromptView2.getContext().getString(2131895236);
        m.checkNotNullExpressionValue(string3, "context.getString(R.string.schedule_event)");
        String string4 = guildEventPromptView2.getContext().getString(2131895237);
        m.checkNotNullExpressionValue(string4, "context.getString(R.stri…hedule_event_description)");
        guildEventPromptView2.configure(2131231750, 2131099767, string3, string4);
        guildEventPromptView2.setOnClickListener(new GuildEventPromptListView$configure$$inlined$apply$lambda$2(onCreateEventClick));
        GuildEventPromptView guildEventPromptView3 = this.binding.c;
        guildEventPromptView3.setVisibility(scheduledEventData != null ? 0 : 8);
        if (scheduledEventData != null) {
            GuildScheduledEvent guildScheduledEvent = scheduledEventData.getGuildScheduledEvent();
            String name = guildScheduledEvent.getName();
            Context context = guildEventPromptView3.getContext();
            m.checkNotNullExpressionValue(context, "context");
            guildEventPromptView3.configure(2131231750, 2131100304, name, GuildScheduledEventUtilitiesKt.getEventStartingTimeString(guildScheduledEvent, context));
            guildEventPromptView3.setOnClickListener(new GuildEventPromptListView$configure$$inlined$apply$lambda$3(scheduledEventData));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingA = GuildEventPromptListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildEventPromptListViewBindingA, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingA;
    }
}
