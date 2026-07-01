package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Calendar;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDate, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventPickerDateTime2 implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int dayOfMonth;
    private final int month;
    private final int year;

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDate$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GuildScheduledEventPickerDateTime2 now() {
            Calendar calendar = Calendar.getInstance();
            return new GuildScheduledEventPickerDateTime2(calendar.get(1), calendar.get(2), calendar.get(5));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildScheduledEventPickerDateTime2(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
    }

    public static /* synthetic */ GuildScheduledEventPickerDateTime2 copy$default(GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildScheduledEventPickerDateTime2.year;
        }
        if ((i4 & 2) != 0) {
            i2 = guildScheduledEventPickerDateTime2.month;
        }
        if ((i4 & 4) != 0) {
            i3 = guildScheduledEventPickerDateTime2.dayOfMonth;
        }
        return guildScheduledEventPickerDateTime2.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final GuildScheduledEventPickerDateTime2 copy(int year, int month, int dayOfMonth) {
        return new GuildScheduledEventPickerDateTime2(year, month, dayOfMonth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventPickerDateTime2)) {
            return false;
        }
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = (GuildScheduledEventPickerDateTime2) other;
        return this.year == guildScheduledEventPickerDateTime2.year && this.month == guildScheduledEventPickerDateTime2.month && this.dayOfMonth == guildScheduledEventPickerDateTime2.dayOfMonth;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.dayOfMonth;
    }

    public final long toMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.year, this.month, this.dayOfMonth, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…, dayOfMonth, 0, 0)\n    }");
        return calendar.getTimeInMillis();
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventPickerDate(year=");
        sbU.append(this.year);
        sbU.append(", month=");
        sbU.append(this.month);
        sbU.append(", dayOfMonth=");
        return outline.B(sbU, this.dayOfMonth, ")");
    }
}
