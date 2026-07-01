package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceScheduleCommand$c {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2953b;
    public final boolean c;
    public final boolean d;
    public final long e;
    public final List<SpliceScheduleCommand$b> f;
    public final boolean g;
    public final long h;
    public final int i;
    public final int j;
    public final int k;

    public SpliceScheduleCommand$c(long j, boolean z2, boolean z3, boolean z4, List<SpliceScheduleCommand$b> list, long j2, boolean z5, long j3, int i, int i2, int i3) {
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

    public SpliceScheduleCommand$c(Parcel parcel) {
        this.a = parcel.readLong();
        this.f2953b = parcel.readByte() == 1;
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new SpliceScheduleCommand$b(parcel.readInt(), parcel.readLong()));
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
