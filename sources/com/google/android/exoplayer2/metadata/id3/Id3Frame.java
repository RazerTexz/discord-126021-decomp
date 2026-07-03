package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p279z2.C3155a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* JADX INFO: renamed from: j */
    public final String f19989j;

    public Id3Frame(String str) {
        this.f19989j = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: n */
    public /* synthetic */ void mo8878n(C2835p1.b bVar) {
        C3155a.m3894c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return C3155a.m3892a(this);
    }

    public String toString() {
        return this.f19989j;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: y */
    public /* synthetic */ C2811j1 mo8880y() {
        return C3155a.m3893b(this);
    }
}
