package com.google.android.material.datepicker;

import android.os.Bundle;
import androidx.annotation.NonNull;
import b.i.a.g.d.l;

/* JADX INFO: loaded from: classes3.dex */
public final class CalendarConstraints$Builder {
    private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
    private long end;
    private Long openAt;
    private long start;
    private CalendarConstraints$DateValidator validator;
    public static final long DEFAULT_START = l.a(Month.g(1900, 0).o);
    public static final long DEFAULT_END = l.a(Month.g(2100, 11).o);

    public CalendarConstraints$Builder() {
        this.start = DEFAULT_START;
        this.end = DEFAULT_END;
        this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
    }

    @NonNull
    public CalendarConstraints build() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
        Month monthH = Month.h(this.start);
        Month monthH2 = Month.h(this.end);
        CalendarConstraints$DateValidator calendarConstraints$DateValidator = (CalendarConstraints$DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
        Long l = this.openAt;
        return new CalendarConstraints(monthH, monthH2, calendarConstraints$DateValidator, l == null ? null : Month.h(l.longValue()), null);
    }

    @NonNull
    public CalendarConstraints$Builder setEnd(long j) {
        this.end = j;
        return this;
    }

    @NonNull
    public CalendarConstraints$Builder setOpenAt(long j) {
        this.openAt = Long.valueOf(j);
        return this;
    }

    @NonNull
    public CalendarConstraints$Builder setStart(long j) {
        this.start = j;
        return this;
    }

    @NonNull
    public CalendarConstraints$Builder setValidator(@NonNull CalendarConstraints$DateValidator calendarConstraints$DateValidator) {
        this.validator = calendarConstraints$DateValidator;
        return this;
    }

    public CalendarConstraints$Builder(@NonNull CalendarConstraints calendarConstraints) {
        this.start = DEFAULT_START;
        this.end = DEFAULT_END;
        this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        this.start = CalendarConstraints.access$100(calendarConstraints).o;
        this.end = CalendarConstraints.access$200(calendarConstraints).o;
        this.openAt = Long.valueOf(CalendarConstraints.access$300(calendarConstraints).o);
        this.validator = CalendarConstraints.access$400(calendarConstraints);
    }
}
