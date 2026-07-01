package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Calendar;

/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventPickerDate implements Serializable {
    public static final GuildScheduledEventPickerDate$Companion Companion = new GuildScheduledEventPickerDate$Companion(null);
    private final int dayOfMonth;
    private final int month;
    private final int year;

    public GuildScheduledEventPickerDate(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
    }

    public static /* synthetic */ GuildScheduledEventPickerDate copy$default(GuildScheduledEventPickerDate guildScheduledEventPickerDate, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildScheduledEventPickerDate.year;
        }
        if ((i4 & 2) != 0) {
            i2 = guildScheduledEventPickerDate.month;
        }
        if ((i4 & 4) != 0) {
            i3 = guildScheduledEventPickerDate.dayOfMonth;
        }
        return guildScheduledEventPickerDate.copy(i, i2, i3);
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

    public final GuildScheduledEventPickerDate copy(int year, int month, int dayOfMonth) {
        return new GuildScheduledEventPickerDate(year, month, dayOfMonth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventPickerDate)) {
            return false;
        }
        GuildScheduledEventPickerDate guildScheduledEventPickerDate = (GuildScheduledEventPickerDate) other;
        return this.year == guildScheduledEventPickerDate.year && this.month == guildScheduledEventPickerDate.month && this.dayOfMonth == guildScheduledEventPickerDate.dayOfMonth;
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
        m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…, dayOfMonth, 0, 0)\n    }");
        return calendar.getTimeInMillis();
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventPickerDate(year=");
        sbU.append(this.year);
        sbU.append(", month=");
        sbU.append(this.month);
        sbU.append(", dayOfMonth=");
        return a.B(sbU, this.dayOfMonth, ")");
    }
}
