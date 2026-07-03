package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new C10745a();

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand$a */
    public class C10745a implements Parcelable.Creator<SpliceNullCommand> {
        @Override // android.os.Parcelable.Creator
        public SpliceNullCommand createFromParcel(Parcel parcel) {
            return new SpliceNullCommand();
        }

        @Override // android.os.Parcelable.Creator
        public SpliceNullCommand[] newArray(int i) {
            return new SpliceNullCommand[i];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
