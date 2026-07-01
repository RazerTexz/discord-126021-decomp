package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();
    public final List<c> j;

    public class a implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    }

    public SpliceScheduleCommand(List<c> list) {
        this.j = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.j.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.j.get(i2);
            parcel.writeLong(cVar.a);
            parcel.writeByte(cVar.f2953b ? (byte) 1 : (byte) 0);
            parcel.writeByte(cVar.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(cVar.d ? (byte) 1 : (byte) 0);
            int size2 = cVar.f.size();
            parcel.writeInt(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar = cVar.f.get(i3);
                parcel.writeInt(bVar.a);
                parcel.writeLong(bVar.f2952b);
            }
            parcel.writeLong(cVar.e);
            parcel.writeByte(cVar.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(cVar.h);
            parcel.writeInt(cVar.i);
            parcel.writeInt(cVar.j);
            parcel.writeInt(cVar.k);
        }
    }

    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2952b;

        public b(int i, long j) {
            this.a = i;
            this.f2952b = j;
        }

        public b(int i, long j, a aVar) {
            this.a = i;
            this.f2952b = j;
        }
    }

    public SpliceScheduleCommand(Parcel parcel, a aVar) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new c(parcel));
        }
        this.j = Collections.unmodifiableList(arrayList);
    }

    public static final class c {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2953b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final List<b> f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        public c(long j, boolean z2, boolean z3, boolean z4, List<b> list, long j2, boolean z5, long j3, int i, int i2, int i3) {
            this.a = j;
            this.f2953b = z2;
            this.c = z3;
            this.d = z4;
            this.f = Collections.unmodifiableList(list);
            this.e = j2;
            this.g = z5;
            this.h = j3;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        public c(Parcel parcel) {
            this.a = parcel.readLong();
            this.f2953b = parcel.readByte() == 1;
            this.c = parcel.readByte() == 1;
            this.d = parcel.readByte() == 1;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new b(parcel.readInt(), parcel.readLong()));
            }
            this.f = Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }
}
