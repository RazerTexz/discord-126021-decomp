package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class SlowMotionData$a implements Parcelable$Creator<SlowMotionData> {
    @Override // android.os.Parcelable$Creator
    public SlowMotionData createFromParcel(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, SlowMotionData$Segment.class.getClassLoader());
        return new SlowMotionData(arrayList);
    }

    @Override // android.os.Parcelable$Creator
    public SlowMotionData[] newArray(int i) {
        return new SlowMotionData[i];
    }
}
