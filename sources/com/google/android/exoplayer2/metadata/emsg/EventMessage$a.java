package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class EventMessage$a implements Parcelable$Creator<EventMessage> {
    @Override // android.os.Parcelable$Creator
    public EventMessage createFromParcel(Parcel parcel) {
        return new EventMessage(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public EventMessage[] newArray(int i) {
        return new EventMessage[i];
    }
}
