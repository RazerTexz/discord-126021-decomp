package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.GuildEventPromptListViewBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildEventPromptListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildEventPromptListView extends LinearLayout {
    private final GuildEventPromptListViewBinding binding;

    /* JADX INFO: compiled from: GuildEventPromptListView.kt */
    public static final /* data */ class ScheduledEventData {
        private final GuildScheduledEvent guildScheduledEvent;
        private final Function0<Unit> onScheduledEventClick;

        public ScheduledEventData(GuildScheduledEvent guildScheduledEvent, Function0<Unit> function0) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            C12238m.checkNotNullParameter(function0, "onScheduledEventClick");
            this.guildScheduledEvent = guildScheduledEvent;
            this.onScheduledEventClick = function0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScheduledEventData copy$default(ScheduledEventData scheduledEventData, GuildScheduledEvent guildScheduledEvent, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                guildScheduledEvent = scheduledEventData.guildScheduledEvent;
            }
            if ((i & 2) != 0) {
                function0 = scheduledEventData.onScheduledEventClick;
            }
            return scheduledEventData.copy(guildScheduledEvent, function0);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final Function0<Unit> component2() {
            return this.onScheduledEventClick;
        }

        public final ScheduledEventData copy(GuildScheduledEvent guildScheduledEvent, Function0<Unit> onScheduledEventClick) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            C12238m.checkNotNullParameter(onScheduledEventClick, "onScheduledEventClick");
            return new ScheduledEventData(guildScheduledEvent, onScheduledEventClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduledEventData)) {
                return false;
            }
            ScheduledEventData scheduledEventData = (ScheduledEventData) other;
            return C12238m.areEqual(this.guildScheduledEvent, scheduledEventData.guildScheduledEvent) && C12238m.areEqual(this.onScheduledEventClick, scheduledEventData.onScheduledEventClick);
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final Function0<Unit> getOnScheduledEventClick() {
            return this.onScheduledEventClick;
        }

        public int hashCode() {
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.onScheduledEventClick;
            return iHashCode + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ScheduledEventData(guildScheduledEvent=");
            sbM833U.append(this.guildScheduledEvent);
            sbM833U.append(", onScheduledEventClick=");
            sbM833U.append(this.onScheduledEventClick);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingM8384a = GuildEventPromptListViewBinding.m8384a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildEventPromptListViewBindingM8384a, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingM8384a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(GuildEventPromptListView guildEventPromptListView, ScheduledEventData scheduledEventData, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            scheduledEventData = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        guildEventPromptListView.configure(scheduledEventData, function0, function1);
    }

    public final void configure(final ScheduledEventData scheduledEventData, final Function0<Unit> onCreateEventClick, final Function0<Unit> onStartStageClick) {
        GuildEventPromptView guildEventPromptView = this.binding.f15120d;
        guildEventPromptView.setVisibility(onStartStageClick != null ? 0 : 8);
        String string = guildEventPromptView.getContext().getString(C5419R.string.stage_channel_start_title);
        C12238m.checkNotNullExpressionValue(string, "context.getString(R.stri…tage_channel_start_title)");
        String string2 = guildEventPromptView.getContext().getString(C5419R.string.stage_channel_start_subtitle);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_channel_start_subtitle)");
        guildEventPromptView.configure(C5419R.drawable.ic_channel_stage_24dp, C5419R.color.status_green_600, string, string2);
        guildEventPromptView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildEventPromptListView$configure$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0 = onStartStageClick;
                if (function0 != null) {
                }
            }
        });
        GuildEventPromptView guildEventPromptView2 = this.binding.f15118b;
        guildEventPromptView2.setVisibility(onCreateEventClick != null ? 0 : 8);
        String string3 = guildEventPromptView2.getContext().getString(C5419R.string.schedule_event);
        C12238m.checkNotNullExpressionValue(string3, "context.getString(R.string.schedule_event)");
        String string4 = guildEventPromptView2.getContext().getString(C5419R.string.schedule_event_description);
        C12238m.checkNotNullExpressionValue(string4, "context.getString(R.stri…hedule_event_description)");
        guildEventPromptView2.configure(C5419R.drawable.ic_event_20dp, C5419R.color.brand_new_500, string3, string4);
        guildEventPromptView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildEventPromptListView$configure$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0 = onCreateEventClick;
                if (function0 != null) {
                }
            }
        });
        GuildEventPromptView guildEventPromptView3 = this.binding.f15119c;
        guildEventPromptView3.setVisibility(scheduledEventData != null ? 0 : 8);
        if (scheduledEventData != null) {
            GuildScheduledEvent guildScheduledEvent = scheduledEventData.getGuildScheduledEvent();
            String name = guildScheduledEvent.getName();
            Context context = guildEventPromptView3.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            guildEventPromptView3.configure(C5419R.drawable.ic_event_20dp, C5419R.color.status_green_600, name, GuildScheduledEventUtilitiesKt.getEventStartingTimeString(guildScheduledEvent, context));
            guildEventPromptView3.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildEventPromptListView$configure$$inlined$apply$lambda$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    scheduledEventData.getOnScheduledEventClick().invoke();
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingM8384a = GuildEventPromptListViewBinding.m8384a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildEventPromptListViewBindingM8384a, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingM8384a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        GuildEventPromptListViewBinding guildEventPromptListViewBindingM8384a = GuildEventPromptListViewBinding.m8384a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildEventPromptListViewBindingM8384a, "GuildEventPromptListView…rom(context), this, true)");
        this.binding = guildEventPromptListViewBindingM8384a;
    }
}
