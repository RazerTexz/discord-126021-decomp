package com.discord.dialogs;

import android.os.Parcel;
import android.os.Parcelable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleConfirmationDialogArgs implements Parcelable {
    public static final Parcelable.Creator<SimpleConfirmationDialogArgs> CREATOR = new C5479a();

    /* JADX INFO: renamed from: j */
    public final String f18504j;

    /* JADX INFO: renamed from: k */
    public final String f18505k;

    /* JADX INFO: renamed from: l */
    public final String f18506l;

    /* JADX INFO: renamed from: m */
    public final String f18507m;

    /* JADX INFO: renamed from: com.discord.dialogs.SimpleConfirmationDialogArgs$a */
    public static class C5479a implements Parcelable.Creator<SimpleConfirmationDialogArgs> {
        @Override // android.os.Parcelable.Creator
        public SimpleConfirmationDialogArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new SimpleConfirmationDialogArgs(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public SimpleConfirmationDialogArgs[] newArray(int i) {
            return new SimpleConfirmationDialogArgs[i];
        }
    }

    public SimpleConfirmationDialogArgs(String str, String str2, String str3, String str4) {
        this.f18504j = str;
        this.f18505k = str2;
        this.f18506l = str3;
        this.f18507m = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleConfirmationDialogArgs)) {
            return false;
        }
        SimpleConfirmationDialogArgs simpleConfirmationDialogArgs = (SimpleConfirmationDialogArgs) obj;
        return C12238m.areEqual(this.f18504j, simpleConfirmationDialogArgs.f18504j) && C12238m.areEqual(this.f18505k, simpleConfirmationDialogArgs.f18505k) && C12238m.areEqual(this.f18506l, simpleConfirmationDialogArgs.f18506l) && C12238m.areEqual(this.f18507m, simpleConfirmationDialogArgs.f18507m);
    }

    public int hashCode() {
        String str = this.f18504j;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f18505k;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18506l;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f18507m;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SimpleConfirmationDialogArgs(title=");
        sbM833U.append(this.f18504j);
        sbM833U.append(", description=");
        sbM833U.append(this.f18505k);
        sbM833U.append(", positiveButtonText=");
        sbM833U.append(this.f18506l);
        sbM833U.append(", negativeButtonText=");
        return C1643a.m822J(sbM833U, this.f18507m, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f18504j);
        parcel.writeString(this.f18505k);
        parcel.writeString(this.f18506l);
        parcel.writeString(this.f18507m);
    }

    public SimpleConfirmationDialogArgs() {
        this(null, null, null, null);
    }
}
