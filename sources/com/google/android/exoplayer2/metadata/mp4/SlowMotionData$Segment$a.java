package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class SlowMotionData$Segment$a implements Parcelable$Creator<SlowMotionData$Segment> {
    @Override // android.os.Parcelable$Creator
    public SlowMotionData$Segment createFromParcel(Parcel parcel) {
        return new SlowMotionData$Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
    }

    @Override // android.os.Parcelable$Creator
    public SlowMotionData$Segment[] newArray(int i) {
        return new SlowMotionData$Segment[i];
    }
}
