package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable$Creator<SpliceInsertCommand> CREATOR = new SpliceInsertCommand$a();
    public final long j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final long o;
    public final long p;
    public final List<SpliceInsertCommand$b> q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f2950s;
    public final int t;
    public final int u;
    public final int v;

    public SpliceInsertCommand(long j, boolean z2, boolean z3, boolean z4, boolean z5, long j2, long j3, List<SpliceInsertCommand$b> list, boolean z6, long j4, int i, int i2, int i3) {
        this.j = j;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
        this.o = j2;
        this.p = j3;
        this.q = Collections.unmodifiableList(list);
        this.r = z6;
        this.f2950s = j4;
        this.t = i;
        this.u = i2;
        this.v = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.j);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
        int size = this.q.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            SpliceInsertCommand$b spliceInsertCommand$b = this.q.get(i2);
            parcel.writeInt(spliceInsertCommand$b.a);
            parcel.writeLong(spliceInsertCommand$b.f2951b);
            parcel.writeLong(spliceInsertCommand$b.c);
        }
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f2950s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
    }

    public SpliceInsertCommand(Parcel parcel, SpliceInsertCommand$a spliceInsertCommand$a) {
        this.j = parcel.readLong();
        this.k = parcel.readByte() == 1;
        this.l = parcel.readByte() == 1;
        this.m = parcel.readByte() == 1;
        this.n = parcel.readByte() == 1;
        this.o = parcel.readLong();
        this.p = parcel.readLong();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new SpliceInsertCommand$b(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.q = Collections.unmodifiableList(arrayList);
        this.r = parcel.readByte() == 1;
        this.f2950s = parcel.readLong();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
    }
}
