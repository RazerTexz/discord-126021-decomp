package com.discord.dialogs;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.dialogs.SimpleConfirmationDialogArgs, reason: use source file name */
/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleConfirmationDialog2 implements Parcelable {
    public static final Parcelable.Creator<SimpleConfirmationDialog2> CREATOR = new a();
    public final String j;
    public final String k;
    public final String l;
    public final String m;

    /* JADX INFO: renamed from: com.discord.dialogs.SimpleConfirmationDialogArgs$a */
    public static class a implements Parcelable.Creator<SimpleConfirmationDialog2> {
        @Override // android.os.Parcelable.Creator
        public SimpleConfirmationDialog2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new SimpleConfirmationDialog2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public SimpleConfirmationDialog2[] newArray(int i) {
            return new SimpleConfirmationDialog2[i];
        }
    }

    public SimpleConfirmationDialog2(String str, String str2, String str3, String str4) {
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
        if (!(obj instanceof SimpleConfirmationDialog2)) {
            return false;
        }
        SimpleConfirmationDialog2 simpleConfirmationDialog2 = (SimpleConfirmationDialog2) obj;
        return Intrinsics3.areEqual(this.j, simpleConfirmationDialog2.j) && Intrinsics3.areEqual(this.k, simpleConfirmationDialog2.k) && Intrinsics3.areEqual(this.l, simpleConfirmationDialog2.l) && Intrinsics3.areEqual(this.m, simpleConfirmationDialog2.m);
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
        StringBuilder sbU = outline.U("SimpleConfirmationDialogArgs(title=");
        sbU.append(this.j);
        sbU.append(", description=");
        sbU.append(this.k);
        sbU.append(", positiveButtonText=");
        sbU.append(this.l);
        sbU.append(", negativeButtonText=");
        return outline.J(sbU, this.m, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
    }

    public SimpleConfirmationDialog2() {
        this(null, null, null, null);
    }
}
