package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeDateValidator implements CalendarConstraints$DateValidator {
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;

    @NonNull
    private final CompositeDateValidator$d operator;

    @NonNull
    private final List<CalendarConstraints$DateValidator> validators;
    private static final CompositeDateValidator$d ANY_OPERATOR = new CompositeDateValidator$a();
    private static final CompositeDateValidator$d ALL_OPERATOR = new CompositeDateValidator$b();
    public static final Parcelable$Creator<CompositeDateValidator> CREATOR = new CompositeDateValidator$c();

    public /* synthetic */ CompositeDateValidator(List list, CompositeDateValidator$d compositeDateValidator$d, CompositeDateValidator$a compositeDateValidator$a) {
        this(list, compositeDateValidator$d);
    }

    public static /* synthetic */ CompositeDateValidator$d access$000() {
        return ALL_OPERATOR;
    }

    public static /* synthetic */ CompositeDateValidator$d access$100() {
        return ANY_OPERATOR;
    }

    @NonNull
    public static CalendarConstraints$DateValidator allOf(@NonNull List<CalendarConstraints$DateValidator> list) {
        return new CompositeDateValidator(list, ALL_OPERATOR);
    }

    @NonNull
    public static CalendarConstraints$DateValidator anyOf(@NonNull List<CalendarConstraints$DateValidator> list) {
        return new CompositeDateValidator(list, ANY_OPERATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.validators.equals(compositeDateValidator.validators) && this.operator.getId() == compositeDateValidator.operator.getId();
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints$DateValidator
    public boolean isValid(long j) {
        return this.operator.a(this.validators, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints$DateValidator> list, CompositeDateValidator$d compositeDateValidator$d) {
        this.validators = list;
        this.operator = compositeDateValidator$d;
    }
}
