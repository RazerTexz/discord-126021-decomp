package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import p007b.p225i.p226a.p341g.p345d.C4401l;

/* JADX INFO: loaded from: classes3.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new C10902a();

    /* JADX INFO: renamed from: j */
    @NonNull
    public final Calendar f20984j;

    /* JADX INFO: renamed from: k */
    public final int f20985k;

    /* JADX INFO: renamed from: l */
    public final int f20986l;

    /* JADX INFO: renamed from: m */
    public final int f20987m;

    /* JADX INFO: renamed from: n */
    public final int f20988n;

    /* JADX INFO: renamed from: o */
    public final long f20989o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public String f20990p;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.Month$a */
    public static class C10902a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.m9131g(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month[] newArray(int i) {
            return new Month[i];
        }
    }

    public Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarM6071d = C4401l.m6071d(calendar);
        this.f20984j = calendarM6071d;
        this.f20985k = calendarM6071d.get(2);
        this.f20986l = calendarM6071d.get(1);
        this.f20987m = calendarM6071d.getMaximum(7);
        this.f20988n = calendarM6071d.getActualMaximum(5);
        this.f20989o = calendarM6071d.getTimeInMillis();
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public static Month m9131g(int i, int i2) {
        Calendar calendarM6076i = C4401l.m6076i();
        calendarM6076i.set(1, i);
        calendarM6076i.set(2, i2);
        return new Month(calendarM6076i);
    }

    @NonNull
    /* JADX INFO: renamed from: h */
    public static Month m9132h(long j) {
        Calendar calendarM6076i = C4401l.m6076i();
        calendarM6076i.setTimeInMillis(j);
        return new Month(calendarM6076i);
    }

    @NonNull
    /* JADX INFO: renamed from: i */
    public static Month m9133i() {
        return new Month(C4401l.m6075h());
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
        return this.f20985k == month.f20985k && this.f20986l == month.f20986l;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull Month month) {
        return this.f20984j.compareTo(month.f20984j);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20985k), Integer.valueOf(this.f20986l)});
    }

    /* JADX INFO: renamed from: j */
    public int m9135j() {
        int firstDayOfWeek = this.f20984j.get(7) - this.f20984j.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f20987m : firstDayOfWeek;
    }

    /* JADX INFO: renamed from: k */
    public long m9136k(int i) {
        Calendar calendarM6071d = C4401l.m6071d(this.f20984j);
        calendarM6071d.set(5, i);
        return calendarM6071d.getTimeInMillis();
    }

    @NonNull
    /* JADX INFO: renamed from: l */
    public String m9137l(Context context) {
        if (this.f20990p == null) {
            long timeInMillis = this.f20984j.getTimeInMillis();
            this.f20990p = DateUtils.formatDateTime(context, timeInMillis - ((long) TimeZone.getDefault().getOffset(timeInMillis)), 36);
        }
        return this.f20990p;
    }

    @NonNull
    /* JADX INFO: renamed from: m */
    public Month m9138m(int i) {
        Calendar calendarM6071d = C4401l.m6071d(this.f20984j);
        calendarM6071d.add(2, i);
        return new Month(calendarM6071d);
    }

    /* JADX INFO: renamed from: o */
    public int m9139o(@NonNull Month month) {
        if (!(this.f20984j instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.f20985k - this.f20985k) + ((month.f20986l - this.f20986l) * 12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.f20986l);
        parcel.writeInt(this.f20985k);
    }
}
