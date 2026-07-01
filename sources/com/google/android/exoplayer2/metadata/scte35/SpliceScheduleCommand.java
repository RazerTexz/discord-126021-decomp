package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable$Creator<SpliceScheduleCommand> CREATOR = new SpliceScheduleCommand$a();
    public final List<SpliceScheduleCommand$c> j;

    public SpliceScheduleCommand(List<SpliceScheduleCommand$c> list) {
        this.j = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.j.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            SpliceScheduleCommand$c spliceScheduleCommand$c = this.j.get(i2);
            parcel.writeLong(spliceScheduleCommand$c.a);
            parcel.writeByte(spliceScheduleCommand$c.f2953b ? (byte) 1 : (byte) 0);
            parcel.writeByte(spliceScheduleCommand$c.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(spliceScheduleCommand$c.d ? (byte) 1 : (byte) 0);
            int size2 = spliceScheduleCommand$c.f.size();
            parcel.writeInt(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                SpliceScheduleCommand$b spliceScheduleCommand$b = spliceScheduleCommand$c.f.get(i3);
                parcel.writeInt(spliceScheduleCommand$b.a);
                parcel.writeLong(spliceScheduleCommand$b.f2952b);
            }
            parcel.writeLong(spliceScheduleCommand$c.e);
            parcel.writeByte(spliceScheduleCommand$c.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(spliceScheduleCommand$c.h);
            parcel.writeInt(spliceScheduleCommand$c.i);
            parcel.writeInt(spliceScheduleCommand$c.j);
            parcel.writeInt(spliceScheduleCommand$c.k);
        }
    }

    public SpliceScheduleCommand(Parcel parcel, SpliceScheduleCommand$a spliceScheduleCommand$a) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new SpliceScheduleCommand$c(parcel));
        }
        this.j = Collections.unmodifiableList(arrayList);
    }
}
