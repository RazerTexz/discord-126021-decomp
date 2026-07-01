package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.text.TextUtils$TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.GuildScheduledEventDateViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDateView extends ConstraintLayout {
    private final GuildScheduledEventDateViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingA = GuildScheduledEventDateViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildScheduledEventDateViewBindingA, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingA;
    }

    public static final /* synthetic */ int access$getTextColorViaTiming(GuildScheduledEventDateView guildScheduledEventDateView, GuildScheduledEventTiming guildScheduledEventTiming) {
        return guildScheduledEventDateView.getTextColorViaTiming(guildScheduledEventTiming);
    }

    public static /* synthetic */ void configure$default(GuildScheduledEventDateView guildScheduledEventDateView, GuildScheduledEvent guildScheduledEvent, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        guildScheduledEventDateView.configure(guildScheduledEvent, z2);
    }

    private final void configureCompleteTimeString(GuildScheduledEventTiming timing, long startTimeMillis, long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        CharSequence eventEndingTimeString = GuildScheduledEventUtilitiesKt.getEventEndingTimeString(context, startTimeMillis, endTimeMillis, status);
        if (eventEndingTimeString == null || eventEndingTimeString.length() == 0) {
            configureStartingTimeString(timing, startTimeMillis, entityType, status);
            return;
        }
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        CharSequence eventStartingTimeString = GuildScheduledEventUtilitiesKt.getEventStartingTimeString(context2, startTimeMillis, entityType, status);
        TextView textView = this.binding.c;
        textView.setTextColor(ColorCompat.getThemedColor(textView.getContext(), 2130968990));
        Context context3 = textView.getContext();
        m.checkNotNullExpressionValue(context3, "context");
        textView.setText(b.b(context3, 2131895864, new Object[]{eventStartingTimeString, eventEndingTimeString}, new GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1(this, eventStartingTimeString, eventEndingTimeString, timing)));
        m.checkNotNullExpressionValue(textView, "binding.guildScheduledEv…      }\n        }\n      }");
    }

    private final void configureFinishedEvent(long startTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        ImageView imageView = this.binding.f2119b;
        imageView.setImageResource(2131231750);
        ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), 2130968973));
        TextView textView = this.binding.c;
        textView.setTextColor(ColorCompat.getThemedColor(textView.getContext(), 2130968990));
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView.setText(GuildScheduledEventUtilitiesKt.getEventStartingTimeString(context, startTimeMillis, entityType, status));
    }

    private final void configureStartingTimeString(GuildScheduledEventTiming timing, long startTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        TextView textView = this.binding.c;
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView.setText(GuildScheduledEventUtilitiesKt.getEventStartingTimeString(context, startTimeMillis, entityType, status));
        textView.setTextColor(getTextColorViaTiming(timing));
    }

    private final void configureTruncatedDateTime() {
        TextView textView = this.binding.c;
        textView.setEllipsize(TextUtils$TruncateAt.END);
        textView.setMaxLines(1);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f  */
    private final void configureViaTiming(long startTimeMillis, Long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        GuildScheduledEventTiming eventTiming = GuildScheduledEventUtilitiesKt.getEventTiming(startTimeMillis, status);
        ImageView imageView = this.binding.f2119b;
        int iOrdinal = eventTiming.ordinal();
        if (iOrdinal == 3 || iOrdinal == 4) {
            imageView.setImageResource(2131231674);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), 2130968973));
        } else if (iOrdinal == 5) {
            imageView.setImageResource(2131231750);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getColor(imageView.getContext(), 2131100304));
        } else if (iOrdinal != 6) {
            imageView.setImageResource(2131231750);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), 2130968973));
        } else {
            imageView.setImageResource(2131231674);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), 2130968973));
        }
        if (endTimeMillis == null) {
            configureStartingTimeString(eventTiming, startTimeMillis, entityType, status);
        } else {
            configureCompleteTimeString(eventTiming, startTimeMillis, endTimeMillis.longValue(), entityType, status);
        }
    }

    private final int getTextColorViaTiming(GuildScheduledEventTiming timing) {
        int iOrdinal = timing.ordinal();
        if (iOrdinal != 3 && iOrdinal != 4) {
            if (iOrdinal == 5) {
                return ColorCompat.getColor(getContext(), 2131100304);
            }
            if (iOrdinal != 6) {
                return ColorCompat.getThemedColor(getContext(), 2130968990);
            }
        }
        return ColorCompat.getThemedColor(getContext(), 2130968973);
    }

    public final void configure(GuildScheduledEvent event, boolean truncateDateTime) {
        m.checkNotNullParameter(event, "event");
        long dateTimeMillis = event.getScheduledStartTime().getDateTimeMillis();
        UtcDateTime scheduledEndTime = event.getScheduledEndTime();
        configure(dateTimeMillis, scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, event.getEntityType(), event.getStatus(), truncateDateTime);
    }

    public static /* synthetic */ void configure$default(GuildScheduledEventDateView guildScheduledEventDateView, long j, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventStatus guildScheduledEventStatus, boolean z2, int i, Object obj) {
        guildScheduledEventDateView.configure(j, l, guildScheduledEventEntityType, guildScheduledEventStatus, (i & 16) != 0 ? true : z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingA = GuildScheduledEventDateViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildScheduledEventDateViewBindingA, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingA = GuildScheduledEventDateViewBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(guildScheduledEventDateViewBindingA, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingA;
    }

    public final void configure(long startTimeMillis, Long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status, boolean truncateDateTime) {
        m.checkNotNullParameter(entityType, "entityType");
        m.checkNotNullParameter(status, "status");
        Objects.requireNonNull(GuildScheduledEventStatus.Companion);
        if (GuildScheduledEventStatus.access$getDONE$cp().contains(status)) {
            configureFinishedEvent(startTimeMillis, entityType, status);
        } else {
            configureViaTiming(startTimeMillis, endTimeMillis, entityType, status);
        }
        if (truncateDateTime) {
            configureTruncatedDateTime();
        }
    }
}
