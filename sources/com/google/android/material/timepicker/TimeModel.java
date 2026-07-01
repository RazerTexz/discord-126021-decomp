package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import b.i.a.g.k.MaxInputValidator;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();
    public final MaxInputValidator j;
    public final MaxInputValidator k;
    public final int l;
    public int m;
    public int n;
    public int o;
    public int p;

    public static class a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public TimeModel[] newArray(int i) {
            return new TimeModel[i];
        }
    }

    public TimeModel() {
        this(0, 0, 10, 0);
    }

    public static String a(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public int b() {
        if (this.l == 1) {
            return this.m % 24;
        }
        int i = this.m;
        if (i % 12 == 0) {
            return 12;
        }
        return this.p == 1 ? i - 12 : i;
    }

    public void c(int i) {
        if (this.l == 1) {
            this.m = i;
        } else {
            this.m = (i % 12) + (this.p != 1 ? 0 : 12);
        }
    }

    public void d(int i) {
        if (i != this.p) {
            this.p = i;
            int i2 = this.m;
            if (i2 < 12 && i == 1) {
                this.m = i2 + 12;
            } else {
                if (i2 < 12 || i != 0) {
                    return;
                }
                this.m = i2 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.m == timeModel.m && this.n == timeModel.n && this.l == timeModel.l && this.o == timeModel.o;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.l);
    }

    public TimeModel(int i, int i2, int i3, int i4) {
        this.m = i;
        this.n = i2;
        this.o = i3;
        this.l = i4;
        this.p = i >= 12 ? 1 : 0;
        this.j = new MaxInputValidator(59);
        this.k = new MaxInputValidator(i4 == 1 ? 24 : 12);
    }
}
