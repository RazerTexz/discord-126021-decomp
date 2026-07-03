package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import p007b.p225i.p226a.p341g.p345d.C4401l;

/* JADX INFO: loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new C10878a();

    @NonNull
    private final Month end;
    private final int monthSpan;

    @Nullable
    private Month openAt;

    @NonNull
    private final Month start;

    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CalendarConstraints$a */
    public static class C10878a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, C10878a c10878a) {
        this(month, month2, dateValidator, month3);
    }

    public Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        return month.compareTo(this.end) > 0 ? this.end : month;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @NonNull
    public Month getStart() {
        return this.start;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public boolean isWithinBounds(long j) {
        if (this.start.m9136k(1) <= j) {
            Month month = this.end;
            if (j <= month.m9136k(month.f20988n)) {
                return true;
            }
        }
        return false;
    }

    public void setOpenAt(@Nullable Month month) {
        this.openAt = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.f20984j.compareTo(month3.f20984j) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.f20984j.compareTo(month2.f20984j) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.monthSpan = month.m9139o(month2) + 1;
        this.yearSpan = (month2.f20986l - month.f20986l) + 1;
    }

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        private long end;
        private Long openAt;
        private long start;
        private DateValidator validator;
        public static final long DEFAULT_START = C4401l.m6068a(Month.m9131g(1900, 0).f20989o);
        public static final long DEFAULT_END = C4401l.m6068a(Month.m9131g(2100, 11).f20989o);

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints build() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month monthM9132h = Month.m9132h(this.start);
            Month monthM9132h2 = Month.m9132h(this.end);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long l = this.openAt;
            return new CalendarConstraints(monthM9132h, monthM9132h2, dateValidator, l == null ? null : Month.m9132h(l.longValue()), null);
        }

        @NonNull
        public Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long j) {
            this.openAt = Long.valueOf(j);
            return this;
        }

        @NonNull
        public Builder setStart(long j) {
            this.start = j;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = calendarConstraints.start.f20989o;
            this.end = calendarConstraints.end.f20989o;
            this.openAt = Long.valueOf(calendarConstraints.openAt.f20989o);
            this.validator = calendarConstraints.validator;
        }
    }
}
