package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;

    @NonNull
    private final InterfaceC10882d operator;

    @NonNull
    private final List<CalendarConstraints.DateValidator> validators;
    private static final InterfaceC10882d ANY_OPERATOR = new C10879a();
    private static final InterfaceC10882d ALL_OPERATOR = new C10880b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new C10881c();

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CompositeDateValidator$a */
    public static class C10879a implements InterfaceC10882d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC10882d
        /* JADX INFO: renamed from: a */
        public boolean mo9129a(@NonNull List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.isValid(j)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC10882d
        public int getId() {
            return 1;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CompositeDateValidator$b */
    public static class C10880b implements InterfaceC10882d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC10882d
        /* JADX INFO: renamed from: a */
        public boolean mo9129a(@NonNull List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.isValid(j)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC10882d
        public int getId() {
            return 2;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CompositeDateValidator$c */
    public static class C10881c implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i = parcel.readInt();
            InterfaceC10882d interfaceC10882d = (i != 2 && i == 1) ? CompositeDateValidator.ANY_OPERATOR : CompositeDateValidator.ALL_OPERATOR;
            return new CompositeDateValidator((List) Preconditions.checkNotNull(arrayList), interfaceC10882d, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public CompositeDateValidator[] newArray(int i) {
            return new CompositeDateValidator[i];
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CompositeDateValidator$d */
    public interface InterfaceC10882d {
        /* JADX INFO: renamed from: a */
        boolean mo9129a(@NonNull List<CalendarConstraints.DateValidator> list, long j);

        int getId();
    }

    public /* synthetic */ CompositeDateValidator(List list, InterfaceC10882d interfaceC10882d, C10879a c10879a) {
        this(list, interfaceC10882d);
    }

    @NonNull
    public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ALL_OPERATOR);
    }

    @NonNull
    public static CalendarConstraints.DateValidator anyOf(@NonNull List<CalendarConstraints.DateValidator> list) {
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

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        return this.operator.mo9129a(this.validators, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> list, InterfaceC10882d interfaceC10882d) {
        this.validators = list;
        this.operator = interfaceC10882d;
    }
}
