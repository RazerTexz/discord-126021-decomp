package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.GuildScheduledEventDateViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDateView extends ConstraintLayout {
    private final GuildScheduledEventDateViewBinding binding;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GuildScheduledEventUtilities2.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities2 = GuildScheduledEventUtilities2.LIVE;
            iArr[guildScheduledEventUtilities2.ordinal()] = 1;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities3 = GuildScheduledEventUtilities2.SOON;
            iArr[guildScheduledEventUtilities3.ordinal()] = 2;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities4 = GuildScheduledEventUtilities2.NOW;
            iArr[guildScheduledEventUtilities4.ordinal()] = 3;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities5 = GuildScheduledEventUtilities2.EXPIRED;
            iArr[guildScheduledEventUtilities5.ordinal()] = 4;
            GuildScheduledEventUtilities2.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildScheduledEventUtilities2.ordinal()] = 1;
            iArr2[guildScheduledEventUtilities3.ordinal()] = 2;
            iArr2[guildScheduledEventUtilities4.ordinal()] = 3;
            iArr2[guildScheduledEventUtilities5.ordinal()] = 4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingA = GuildScheduledEventDateViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventDateViewBindingA, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingA;
    }

    public static /* synthetic */ void configure$default(GuildScheduledEventDateView guildScheduledEventDateView, GuildScheduledEvent guildScheduledEvent, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        guildScheduledEventDateView.configure(guildScheduledEvent, z2);
    }

    private final void configureCompleteTimeString(GuildScheduledEventUtilities2 timing, long startTimeMillis, long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence eventEndingTimeString = GuildScheduledEventUtilities5.getEventEndingTimeString(context, startTimeMillis, endTimeMillis, status);
        if (eventEndingTimeString == null || eventEndingTimeString.length() == 0) {
            configureStartingTimeString(timing, startTimeMillis, entityType, status);
            return;
        }
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        CharSequence eventStartingTimeString = GuildScheduledEventUtilities5.getEventStartingTimeString(context2, startTimeMillis, entityType, status);
        TextView textView = this.binding.c;
        textView.setTextColor(ColorCompat.getThemedColor(textView.getContext(), R.attr.colorHeaderSecondary));
        Context context3 = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context3, "context");
        textView.setText(FormatUtils.b(context3, R.string.start_date_to_end_date_with_color, new Object[]{eventStartingTimeString, eventEndingTimeString}, new GuildScheduledEventDateView2(this, eventStartingTimeString, eventEndingTimeString, timing)));
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEv…      }\n        }\n      }");
    }

    private final void configureFinishedEvent(long startTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        ImageView imageView = this.binding.f2119b;
        imageView.setImageResource(R.drawable.ic_event_20dp);
        ColorCompat2.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), R.attr.colorControlBrandForegroundNew));
        TextView textView = this.binding.c;
        textView.setTextColor(ColorCompat.getThemedColor(textView.getContext(), R.attr.colorHeaderSecondary));
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView.setText(GuildScheduledEventUtilities5.getEventStartingTimeString(context, startTimeMillis, entityType, status));
    }

    private final void configureStartingTimeString(GuildScheduledEventUtilities2 timing, long startTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        TextView textView = this.binding.c;
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView.setText(GuildScheduledEventUtilities5.getEventStartingTimeString(context, startTimeMillis, entityType, status));
        textView.setTextColor(getTextColorViaTiming(timing));
    }

    private final void configureTruncatedDateTime() {
        TextView textView = this.binding.c;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f  */
    private final void configureViaTiming(long startTimeMillis, Long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status) {
        GuildScheduledEventUtilities2 eventTiming = GuildScheduledEventUtilities5.getEventTiming(startTimeMillis, status);
        ImageView imageView = this.binding.f2119b;
        int iOrdinal = eventTiming.ordinal();
        if (iOrdinal == 3 || iOrdinal == 4) {
            imageView.setImageResource(R.drawable.ic_clock_20dp);
            ColorCompat2.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), R.attr.colorControlBrandForegroundNew));
        } else if (iOrdinal == 5) {
            imageView.setImageResource(R.drawable.ic_event_20dp);
            ColorCompat2.tintWithColor(imageView, ColorCompat.getColor(imageView.getContext(), R.color.status_green_600));
        } else if (iOrdinal != 6) {
            imageView.setImageResource(R.drawable.ic_event_20dp);
            ColorCompat2.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), R.attr.colorControlBrandForegroundNew));
        } else {
            imageView.setImageResource(R.drawable.ic_clock_20dp);
            ColorCompat2.tintWithColor(imageView, ColorCompat.getThemedColor(imageView.getContext(), R.attr.colorControlBrandForegroundNew));
        }
        if (endTimeMillis == null) {
            configureStartingTimeString(eventTiming, startTimeMillis, entityType, status);
        } else {
            configureCompleteTimeString(eventTiming, startTimeMillis, endTimeMillis.longValue(), entityType, status);
        }
    }

    private final int getTextColorViaTiming(GuildScheduledEventUtilities2 timing) {
        int iOrdinal = timing.ordinal();
        if (iOrdinal != 3 && iOrdinal != 4) {
            if (iOrdinal == 5) {
                return ColorCompat.getColor(getContext(), R.color.status_green_600);
            }
            if (iOrdinal != 6) {
                return ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderSecondary);
            }
        }
        return ColorCompat.getThemedColor(getContext(), R.attr.colorControlBrandForegroundNew);
    }

    public final void configure(GuildScheduledEvent event, boolean truncateDateTime) {
        Intrinsics3.checkNotNullParameter(event, "event");
        long dateTimeMillis = event.getScheduledStartTime().getDateTimeMillis();
        UtcDateTime scheduledEndTime = event.getScheduledEndTime();
        configure(dateTimeMillis, scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, event.getEntityType(), event.getStatus(), truncateDateTime);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingA = GuildScheduledEventDateViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventDateViewBindingA, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventDateViewBinding guildScheduledEventDateViewBindingA = GuildScheduledEventDateViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventDateViewBindingA, "GuildScheduledEventDateV…rom(context), this, true)");
        this.binding = guildScheduledEventDateViewBindingA;
    }

    public final void configure(long startTimeMillis, Long endTimeMillis, GuildScheduledEventEntityType entityType, GuildScheduledEventStatus status, boolean truncateDateTime) {
        Intrinsics3.checkNotNullParameter(entityType, "entityType");
        Intrinsics3.checkNotNullParameter(status, "status");
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
