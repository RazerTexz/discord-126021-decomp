package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new C10743a();

    /* JADX INFO: renamed from: j */
    public final long f20022j;

    /* JADX INFO: renamed from: k */
    public final boolean f20023k;

    /* JADX INFO: renamed from: l */
    public final boolean f20024l;

    /* JADX INFO: renamed from: m */
    public final boolean f20025m;

    /* JADX INFO: renamed from: n */
    public final boolean f20026n;

    /* JADX INFO: renamed from: o */
    public final long f20027o;

    /* JADX INFO: renamed from: p */
    public final long f20028p;

    /* JADX INFO: renamed from: q */
    public final List<C10744b> f20029q;

    /* JADX INFO: renamed from: r */
    public final boolean f20030r;

    /* JADX INFO: renamed from: s */
    public final long f20031s;

    /* JADX INFO: renamed from: t */
    public final int f20032t;

    /* JADX INFO: renamed from: u */
    public final int f20033u;

    /* JADX INFO: renamed from: v */
    public final int f20034v;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand$a */
    public class C10743a implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    }

    public SpliceInsertCommand(long j, boolean z2, boolean z3, boolean z4, boolean z5, long j2, long j3, List<C10744b> list, boolean z6, long j4, int i, int i2, int i3) {
        this.f20022j = j;
        this.f20023k = z2;
        this.f20024l = z3;
        this.f20025m = z4;
        this.f20026n = z5;
        this.f20027o = j2;
        this.f20028p = j3;
        this.f20029q = Collections.unmodifiableList(list);
        this.f20030r = z6;
        this.f20031s = j4;
        this.f20032t = i;
        this.f20033u = i2;
        this.f20034v = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f20022j);
        parcel.writeByte(this.f20023k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f20024l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f20025m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f20026n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f20027o);
        parcel.writeLong(this.f20028p);
        int size = this.f20029q.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            C10744b c10744b = this.f20029q.get(i2);
            parcel.writeInt(c10744b.f20035a);
            parcel.writeLong(c10744b.f20036b);
            parcel.writeLong(c10744b.f20037c);
        }
        parcel.writeByte(this.f20030r ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f20031s);
        parcel.writeInt(this.f20032t);
        parcel.writeInt(this.f20033u);
        parcel.writeInt(this.f20034v);
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand$b */
    public static final class C10744b {

        /* JADX INFO: renamed from: a */
        public final int f20035a;

        /* JADX INFO: renamed from: b */
        public final long f20036b;

        /* JADX INFO: renamed from: c */
        public final long f20037c;

        public C10744b(int i, long j, long j2) {
            this.f20035a = i;
            this.f20036b = j;
            this.f20037c = j2;
        }

        public C10744b(int i, long j, long j2, C10743a c10743a) {
            this.f20035a = i;
            this.f20036b = j;
            this.f20037c = j2;
        }
    }

    public SpliceInsertCommand(Parcel parcel, C10743a c10743a) {
        this.f20022j = parcel.readLong();
        this.f20023k = parcel.readByte() == 1;
        this.f20024l = parcel.readByte() == 1;
        this.f20025m = parcel.readByte() == 1;
        this.f20026n = parcel.readByte() == 1;
        this.f20027o = parcel.readLong();
        this.f20028p = parcel.readLong();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new C10744b(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.f20029q = Collections.unmodifiableList(arrayList);
        this.f20030r = parcel.readByte() == 1;
        this.f20031s = parcel.readLong();
        this.f20032t = parcel.readInt();
        this.f20033u = parcel.readInt();
        this.f20034v = parcel.readInt();
    }
}
