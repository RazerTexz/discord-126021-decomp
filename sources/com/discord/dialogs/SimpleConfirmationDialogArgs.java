package com.discord.dialogs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleConfirmationDialogArgs implements Parcelable {
    public static final Parcelable$Creator<SimpleConfirmationDialogArgs> CREATOR = new SimpleConfirmationDialogArgs$a();
    public final String j;
    public final String k;
    public final String l;
    public final String m;

    public SimpleConfirmationDialogArgs(String str, String str2, String str3, String str4) {
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = str4;
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
        return m.areEqual(this.j, simpleConfirmationDialogArgs.j) && m.areEqual(this.k, simpleConfirmationDialogArgs.k) && m.areEqual(this.l, simpleConfirmationDialogArgs.l) && m.areEqual(this.m, simpleConfirmationDialogArgs.m);
    }

    public int hashCode() {
        String str = this.j;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.k;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.l;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.m;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SimpleConfirmationDialogArgs(title=");
        sbU.append(this.j);
        sbU.append(", description=");
        sbU.append(this.k);
        sbU.append(", positiveButtonText=");
        sbU.append(this.l);
        sbU.append(", negativeButtonText=");
        return a.J(sbU, this.m, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
    }

    public SimpleConfirmationDialogArgs() {
        this(null, null, null, null);
    }
}
