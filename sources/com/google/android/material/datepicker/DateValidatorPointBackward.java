package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import b.i.a.g.d.l;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DateValidatorPointBackward implements CalendarConstraints$DateValidator {
    public static final Parcelable$Creator<DateValidatorPointBackward> CREATOR = new DateValidatorPointBackward$a();
    private final long point;

    public /* synthetic */ DateValidatorPointBackward(long j, DateValidatorPointBackward$a dateValidatorPointBackward$a) {
        this(j);
    }

    @NonNull
    public static DateValidatorPointBackward before(long j) {
        return new DateValidatorPointBackward(j);
    }

    @NonNull
    public static DateValidatorPointBackward now() {
        return before(l.h().getTimeInMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.point == ((DateValidatorPointBackward) obj).point;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints$DateValidator
    public boolean isValid(long j) {
        return j <= this.point;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }

    private DateValidatorPointBackward(long j) {
        this.point = j;
    }
}
