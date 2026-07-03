package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.GuildScheduledEventDateViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import java.util.Objects;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDateView extends ConstraintLayout {
    private final GuildScheduledEventDateViewBinding binding;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GuildScheduledEventTiming.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            GuildScheduledEventTiming guildScheduledEventTiming = GuildScheduledEventTiming.LIVE;
            iArr[guildScheduledEventTiming.ordinal()] = 1;
            GuildScheduledEventTiming guildScheduledEventTiming2 = GuildScheduledEventTiming.SOON;
            iArr[guildScheduledEventTiming2.ordinal()] = 2;
            GuildScheduledEventTiming guildScheduledEventTiming3 = GuildScheduledEventTiming.NOW;
            iArr[guildScheduledEventTiming3.ordinal()] = 3;
            GuildScheduledEventTiming guildScheduledEventTiming4 = GuildScheduledEventTiming.EXPIRED;
            iArr[guildScheduledEventTiming4.ordinal()] = 4;
            GuildScheduledEventTiming.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildScheduledEventTiming.ordinal()] = 1;
            iArr2[guildScheduledEventTiming2.ordinal()] = 2;
            iArr2[guildScheduledEventTiming3.ordinal()] = 3;
            iArr2[guildScheduledEventTiming4.ordinal()] = 4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingM8387a = GuildScheduledEventDateViewBinding.m8387a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildScheduledEventDateViewBindingM8387a, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingM8387a;
    }

    public static /* synthetic */ void configure$default(GuildScheduledEventDateView guildScheduledEventDateView, GuildScheduledEvent guildScheduledEvent, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        guildScheduledEventDateView.configure(guildScheduledEvent, z2);
    }

    private final void configureCompleteTimeString(GuildScheduledEventTiming timing, long startTimeMillis, long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        CharSequence eventEndingTimeString = GuildScheduledEventUtilitiesKt.getEventEndingTimeString(context, startTimeMillis, endTimeMillis, status);
        if (eventEndingTimeString == null || eventEndingTimeString.length() == 0) {
            configureStartingTimeString(timing, startTimeMillis, entityType, status);
            return;
        }
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        CharSequence eventStartingTimeString = GuildScheduledEventUtilitiesKt.getEventStartingTimeString(context2, startTimeMillis, entityType, status);
        TextView textView = this.binding.f15135c;
        textView.setTextColor(ColorCompat.getThemedColor(textView.getContext(), C5419R.attr.colorHeaderSecondary));
        Context context3 = textView.getContext();
        C12238m.checkNotNullExpressionValue(context3, "context");
        textView.setText(C1107b.m210b(context3, C5419R.string.start_date_to_end_date_with_color, new Object[]{eventStartingTimeString, eventEndingTimeString}, new C8810x1ad7bc4f(this, eventStartingTimeString, eventEndingTimeString, timing)));
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEv…      }\n        }\n      }");
    }

    private final void configureFinishedEvent(long startTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        ImageView imageView = this.binding.f15134b;
        imageView.setImageResource(C5419R.drawable.ic_event_20dp);
        ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), C5419R.attr.colorControlBrandForegroundNew));
        TextView textView = this.binding.f15135c;
        textView.setTextColor(ColorCompat.getThemedColor(textView.getContext(), C5419R.attr.colorHeaderSecondary));
        Context context = textView.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        textView.setText(GuildScheduledEventUtilitiesKt.getEventStartingTimeString(context, startTimeMillis, entityType, status));
    }

    private final void configureStartingTimeString(GuildScheduledEventTiming timing, long startTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        TextView textView = this.binding.f15135c;
        Context context = textView.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        textView.setText(GuildScheduledEventUtilitiesKt.getEventStartingTimeString(context, startTimeMillis, entityType, status));
        textView.setTextColor(getTextColorViaTiming(timing));
    }

    private final void configureTruncatedDateTime() {
        TextView textView = this.binding.f15135c;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f  */
    private final void configureViaTiming(long startTimeMillis, Long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        GuildScheduledEventTiming eventTiming = GuildScheduledEventUtilitiesKt.getEventTiming(startTimeMillis, status);
        ImageView imageView = this.binding.f15134b;
        int iOrdinal = eventTiming.ordinal();
        if (iOrdinal == 3 || iOrdinal == 4) {
            imageView.setImageResource(C5419R.drawable.ic_clock_20dp);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), C5419R.attr.colorControlBrandForegroundNew));
        } else if (iOrdinal == 5) {
            imageView.setImageResource(C5419R.drawable.ic_event_20dp);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getColor(imageView.getContext(), C5419R.color.status_green_600));
        } else if (iOrdinal != 6) {
            imageView.setImageResource(C5419R.drawable.ic_event_20dp);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), C5419R.attr.colorControlBrandForegroundNew));
        } else {
            imageView.setImageResource(C5419R.drawable.ic_clock_20dp);
            ColorCompatKt.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), C5419R.attr.colorControlBrandForegroundNew));
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
                return ColorCompat.getColor(getContext(), C5419R.color.status_green_600);
            }
            if (iOrdinal != 6) {
                return ColorCompat.getThemedColor(getContext(), C5419R.attr.colorHeaderSecondary);
            }
        }
        return ColorCompat.getThemedColor(getContext(), C5419R.attr.colorControlBrandForegroundNew);
    }

    public final void configure(GuildScheduledEvent event, boolean truncateDateTime) {
        C12238m.checkNotNullParameter(event, "event");
        long dateTimeMillis = event.getScheduledStartTime().getDateTimeMillis();
        UtcDateTime scheduledEndTime = event.getScheduledEndTime();
        configure(dateTimeMillis, scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, event.getEntityType(), event.getStatus(), truncateDateTime);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingM8387a = GuildScheduledEventDateViewBinding.m8387a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildScheduledEventDateViewBindingM8387a, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingM8387a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingM8387a = GuildScheduledEventDateViewBinding.m8387a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildScheduledEventDateViewBindingM8387a, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingM8387a;
    }

    public final void configure(long startTimeMillis, Long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status, boolean truncateDateTime) {
        C12238m.checkNotNullParameter(entityType, "entityType");
        C12238m.checkNotNullParameter(status, "status");
        Objects.requireNonNull(GuildScheduledEventStatus.INSTANCE);
        if (GuildScheduledEventStatus.DONE.contains(status)) {
            configureFinishedEvent(startTimeMillis, entityType, status);
        } else {
            configureViaTiming(startTimeMillis, endTimeMillis, entityType, status);
        }
        if (truncateDateTime) {
            configureTruncatedDateTime();
        }
    }
}
