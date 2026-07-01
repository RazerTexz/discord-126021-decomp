package com.google.android.exoplayer2.metadata.id3;

import b.i.a.c.Format2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.z2.Metadata2;
import com.google.android.exoplayer2.metadata.Metadata;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata.Entry {
    public final String j;

    public Id3Frame(String str) {
        this.j = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void n(MediaMetadata.b bVar) {
        Metadata2.c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] o0() {
        return Metadata2.a(this);
    }

    public String toString() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format2 y() {
        return Metadata2.b(this);
    }
}
