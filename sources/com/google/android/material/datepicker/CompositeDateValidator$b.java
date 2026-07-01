package com.google.android.material.datepicker;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CompositeDateValidator$b implements CompositeDateValidator$d {
    @Override // com.google.android.material.datepicker.CompositeDateValidator$d
    public boolean a(@NonNull List<CalendarConstraints$DateValidator> list, long j) {
        for (CalendarConstraints$DateValidator calendarConstraints$DateValidator : list) {
            if (calendarConstraints$DateValidator != null && !calendarConstraints$DateValidator.isValid(j)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.material.datepicker.CompositeDateValidator$d
    public int getId() {
        return 2;
    }
}
