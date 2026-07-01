package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.g.d.l;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable$Creator<Month> CREATOR = new Month$a();

    @NonNull
    public final Calendar j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final long o;

    @Nullable
    public String p;

    public Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = l.d(calendar);
        this.j = calendarD;
        this.k = calendarD.get(2);
        this.l = calendarD.get(1);
        this.m = calendarD.getMaximum(7);
        this.n = calendarD.getActualMaximum(5);
        this.o = calendarD.getTimeInMillis();
    }

    @NonNull
    public static Month g(int i, int i2) {
        Calendar calendarI = l.i();
        calendarI.set(1, i);
        calendarI.set(2, i2);
        return new Month(calendarI);
    }

    @NonNull
    public static Month h(long j) {
        Calendar calendarI = l.i();
        calendarI.setTimeInMillis(j);
        return new Month(calendarI);
    }

    @NonNull
    public static Month i() {
        return new Month(l.h());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull Month month) {
        return f(month);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.k == month.k && this.l == month.l;
    }

    public int f(@NonNull Month month) {
        return this.j.compareTo(month.j);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), Integer.valueOf(this.l)});
    }

    public int j() {
        int firstDayOfWeek = this.j.get(7) - this.j.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.m : firstDayOfWeek;
    }

    public long k(int i) {
        Calendar calendarD = l.d(this.j);
        calendarD.set(5, i);
        return calendarD.getTimeInMillis();
    }

    @NonNull
    public String l(Context context) {
        if (this.p == null) {
            long timeInMillis = this.j.getTimeInMillis();
            this.p = DateUtils.formatDateTime(context, timeInMillis - ((long) TimeZone.getDefault().getOffset(timeInMillis)), 36);
        }
        return this.p;
    }

    @NonNull
    public Month m(int i) {
        Calendar calendarD = l.d(this.j);
        calendarD.add(2, i);
        return new Month(calendarD);
    }

    public int o(@NonNull Month month) {
        if (!(this.j instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.k - this.k) + ((month.l - this.l) * 12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.l);
        parcel.writeInt(this.k);
    }
}
