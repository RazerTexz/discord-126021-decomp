package com.google.android.exoplayer2.metadata.id3;

import b.i.a.c.j1;
import b.i.a.c.p1$b;
import b.i.a.c.z2.a;
import com.google.android.exoplayer2.metadata.Metadata$Entry;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata$Entry {
    public final String j;

    public Id3Frame(String str) {
        this.j = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ void n(p1$b p1_b) {
        a.c(this, p1_b);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ byte[] o0() {
        return a.a(this);
    }

    public String toString() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return a.b(this);
    }
}
