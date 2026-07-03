package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new C10746a();

    /* JADX INFO: renamed from: j */
    public final List<C10748c> f20038j;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$a */
    public class C10746a implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    }

    public SpliceScheduleCommand(List<C10748c> list) {
        this.f20038j = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f20038j.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            C10748c c10748c = this.f20038j.get(i2);
            parcel.writeLong(c10748c.f20041a);
            parcel.writeByte(c10748c.f20042b ? (byte) 1 : (byte) 0);
            parcel.writeByte(c10748c.f20043c ? (byte) 1 : (byte) 0);
            parcel.writeByte(c10748c.f20044d ? (byte) 1 : (byte) 0);
            int size2 = c10748c.f20046f.size();
            parcel.writeInt(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                C10747b c10747b = c10748c.f20046f.get(i3);
                parcel.writeInt(c10747b.f20039a);
                parcel.writeLong(c10747b.f20040b);
            }
            parcel.writeLong(c10748c.f20045e);
            parcel.writeByte(c10748c.f20047g ? (byte) 1 : (byte) 0);
            parcel.writeLong(c10748c.f20048h);
            parcel.writeInt(c10748c.f20049i);
            parcel.writeInt(c10748c.f20050j);
            parcel.writeInt(c10748c.f20051k);
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$b */
    public static final class C10747b {

        /* JADX INFO: renamed from: a */
        public final int f20039a;

        /* JADX INFO: renamed from: b */
        public final long f20040b;

        public C10747b(int i, long j) {
            this.f20039a = i;
            this.f20040b = j;
        }

        public C10747b(int i, long j, C10746a c10746a) {
            this.f20039a = i;
            this.f20040b = j;
        }
    }

    public SpliceScheduleCommand(Parcel parcel, C10746a c10746a) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new C10748c(parcel));
        }
        this.f20038j = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$c */
    public static final class C10748c {

        /* JADX INFO: renamed from: a */
        public final long f20041a;

        /* JADX INFO: renamed from: b */
        public final boolean f20042b;

        /* JADX INFO: renamed from: c */
        public final boolean f20043c;

        /* JADX INFO: renamed from: d */
        public final boolean f20044d;

        /* JADX INFO: renamed from: e */
        public final long f20045e;

        /* JADX INFO: renamed from: f */
        public final List<C10747b> f20046f;

        /* JADX INFO: renamed from: g */
        public final boolean f20047g;

        /* JADX INFO: renamed from: h */
        public final long f20048h;

        /* JADX INFO: renamed from: i */
        public final int f20049i;

        /* JADX INFO: renamed from: j */
        public final int f20050j;

        /* JADX INFO: renamed from: k */
        public final int f20051k;

        public C10748c(long j, boolean z2, boolean z3, boolean z4, List<C10747b> list, long j2, boolean z5, long j3, int i, int i2, int i3) {
            this.f20041a = j;
            this.f20042b = z2;
            this.f20043c = z3;
            this.f20044d = z4;
            this.f20046f = Collections.unmodifiableList(list);
            this.f20045e = j2;
            this.f20047g = z5;
            this.f20048h = j3;
            this.f20049i = i;
            this.f20050j = i2;
            this.f20051k = i3;
        }

        public C10748c(Parcel parcel) {
            this.f20041a = parcel.readLong();
            this.f20042b = parcel.readByte() == 1;
            this.f20043c = parcel.readByte() == 1;
            this.f20044d = parcel.readByte() == 1;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new C10747b(parcel.readInt(), parcel.readLong()));
            }
            this.f20046f = Collections.unmodifiableList(arrayList);
            this.f20045e = parcel.readLong();
            this.f20047g = parcel.readByte() == 1;
            this.f20048h = parcel.readLong();
            this.f20049i = parcel.readInt();
            this.f20050j = parcel.readInt();
            this.f20051k = parcel.readInt();
        }
    }
}
