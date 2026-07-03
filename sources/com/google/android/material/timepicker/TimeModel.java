package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import p007b.p225i.p226a.p341g.p352k.C4449d;

/* JADX INFO: loaded from: classes3.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new C11027a();

    /* JADX INFO: renamed from: j */
    public final C4449d f21220j;

    /* JADX INFO: renamed from: k */
    public final C4449d f21221k;

    /* JADX INFO: renamed from: l */
    public final int f21222l;

    /* JADX INFO: renamed from: m */
    public int f21223m;

    /* JADX INFO: renamed from: n */
    public int f21224n;

    /* JADX INFO: renamed from: o */
    public int f21225o;

    /* JADX INFO: renamed from: p */
    public int f21226p;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.TimeModel$a */
    public static class C11027a implements Parcelable.Creator<TimeModel> {
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

    /* JADX INFO: renamed from: a */
    public static String m9160a(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    /* JADX INFO: renamed from: b */
    public int m9161b() {
        if (this.f21222l == 1) {
            return this.f21223m % 24;
        }
        int i = this.f21223m;
        if (i % 12 == 0) {
            return 12;
        }
        return this.f21226p == 1 ? i - 12 : i;
    }

    /* JADX INFO: renamed from: c */
    public void m9162c(int i) {
        if (this.f21222l == 1) {
            this.f21223m = i;
        } else {
            this.f21223m = (i % 12) + (this.f21226p != 1 ? 0 : 12);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m9163d(int i) {
        if (i != this.f21226p) {
            this.f21226p = i;
            int i2 = this.f21223m;
            if (i2 < 12 && i == 1) {
                this.f21223m = i2 + 12;
            } else {
                if (i2 < 12 || i != 0) {
                    return;
                }
                this.f21223m = i2 - 12;
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
        return this.f21223m == timeModel.f21223m && this.f21224n == timeModel.f21224n && this.f21222l == timeModel.f21222l && this.f21225o == timeModel.f21225o;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f21222l), Integer.valueOf(this.f21223m), Integer.valueOf(this.f21224n), Integer.valueOf(this.f21225o)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f21223m);
        parcel.writeInt(this.f21224n);
        parcel.writeInt(this.f21225o);
        parcel.writeInt(this.f21222l);
    }

    public TimeModel(int i, int i2, int i3, int i4) {
        this.f21223m = i;
        this.f21224n = i2;
        this.f21225o = i3;
        this.f21222l = i4;
        this.f21226p = i >= 12 ? 1 : 0;
        this.f21220j = new C4449d(59);
        this.f21221k = new C4449d(i4 == 1 ? 24 : 12);
    }
}
