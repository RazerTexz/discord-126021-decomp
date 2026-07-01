package com.google.android.material.datepicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialDatePicker$Builder<S> {
    public CalendarConstraints calendarConstraints;
    public final DateSelector<S> dateSelector;
    public int overrideThemeResId = 0;
    public int titleTextResId = 0;
    public CharSequence titleText = null;

    @Nullable
    public S selection = null;
    public int inputMode = 0;

    private MaterialDatePicker$Builder(DateSelector<S> dateSelector) {
        this.dateSelector = dateSelector;
    }

    private Month createDefaultOpenAt() {
        long j = this.calendarConstraints.getStart().o;
        long j2 = this.calendarConstraints.getEnd().o;
        if (!this.dateSelector.getSelectedDays().isEmpty()) {
            long jLongValue = this.dateSelector.getSelectedDays().iterator().next().longValue();
            if (jLongValue >= j && jLongValue <= j2) {
                return Month.h(jLongValue);
            }
        }
        long jThisMonthInUtcMilliseconds = MaterialDatePicker.thisMonthInUtcMilliseconds();
        if (j <= jThisMonthInUtcMilliseconds && jThisMonthInUtcMilliseconds <= j2) {
            j = jThisMonthInUtcMilliseconds;
        }
        return Month.h(j);
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public static <S> MaterialDatePicker$Builder<S> customDatePicker(@NonNull DateSelector<S> dateSelector) {
        return new MaterialDatePicker$Builder<>(dateSelector);
    }

    @NonNull
    public static MaterialDatePicker$Builder<Long> datePicker() {
        return new MaterialDatePicker$Builder<>(new SingleDateSelector());
    }

    @NonNull
    public static MaterialDatePicker$Builder<Pair<Long, Long>> dateRangePicker() {
        return new MaterialDatePicker$Builder<>(new RangeDateSelector());
    }

    @NonNull
    public MaterialDatePicker<S> build() {
        if (this.calendarConstraints == null) {
            this.calendarConstraints = new CalendarConstraints$Builder().build();
        }
        if (this.titleTextResId == 0) {
            this.titleTextResId = this.dateSelector.getDefaultTitleResId();
        }
        S s2 = this.selection;
        if (s2 != null) {
            this.dateSelector.setSelection(s2);
        }
        if (this.calendarConstraints.getOpenAt() == null) {
            this.calendarConstraints.setOpenAt(createDefaultOpenAt());
        }
        return MaterialDatePicker.newInstance(this);
    }

    @NonNull
    public MaterialDatePicker$Builder<S> setCalendarConstraints(CalendarConstraints calendarConstraints) {
        this.calendarConstraints = calendarConstraints;
        return this;
    }

    @NonNull
    public MaterialDatePicker$Builder<S> setInputMode(int i) {
        this.inputMode = i;
        return this;
    }

    @NonNull
    public MaterialDatePicker$Builder<S> setSelection(S s2) {
        this.selection = s2;
        return this;
    }

    @NonNull
    public MaterialDatePicker$Builder<S> setTheme(@StyleRes int i) {
        this.overrideThemeResId = i;
        return this;
    }

    @NonNull
    public MaterialDatePicker$Builder<S> setTitleText(@StringRes int i) {
        this.titleTextResId = i;
        this.titleText = null;
        return this;
    }

    @NonNull
    public MaterialDatePicker$Builder<S> setTitleText(@Nullable CharSequence charSequence) {
        this.titleText = charSequence;
        this.titleTextResId = 0;
        return this;
    }
}
