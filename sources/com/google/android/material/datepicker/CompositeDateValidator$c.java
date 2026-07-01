package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CompositeDateValidator$c implements Parcelable$Creator<CompositeDateValidator> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
        ArrayList arrayList = parcel.readArrayList(CalendarConstraints$DateValidator.class.getClassLoader());
        int i = parcel.readInt();
        CompositeDateValidator$d compositeDateValidator$dAccess$100 = (i != 2 && i == 1) ? CompositeDateValidator.access$100() : CompositeDateValidator.access$000();
        return new CompositeDateValidator((List) Preconditions.checkNotNull(arrayList), compositeDateValidator$dAccess$100, null);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public CompositeDateValidator[] newArray(int i) {
        return new CompositeDateValidator[i];
    }
}
