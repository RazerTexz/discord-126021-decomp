package com.discord.player;

import android.os.Parcel;
import android.os.Parcelable;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MediaType implements Parcelable {
    VIDEO,
    GIFV;


    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Parcelable.Creator<MediaType>(null) { // from class: com.discord.player.MediaType.a
        @Override // android.os.Parcelable.Creator
        public MediaType createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            C12238m.checkNotNull(string);
            C12238m.checkNotNullExpressionValue(string, "parcel.readString()!!");
            return MediaType.valueOf(string);
        }

        @Override // android.os.Parcelable.Creator
        public MediaType[] newArray(int i) {
            return new MediaType[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
