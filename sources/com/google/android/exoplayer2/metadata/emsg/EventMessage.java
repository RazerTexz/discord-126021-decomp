package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p279z2.C3155a;

/* JADX INFO: loaded from: classes3.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR;

    /* JADX INFO: renamed from: j */
    public static final C2811j1 f19939j;

    /* JADX INFO: renamed from: k */
    public static final C2811j1 f19940k;

    /* JADX INFO: renamed from: l */
    public final String f19941l;

    /* JADX INFO: renamed from: m */
    public final String f19942m;

    /* JADX INFO: renamed from: n */
    public final long f19943n;

    /* JADX INFO: renamed from: o */
    public final long f19944o;

    /* JADX INFO: renamed from: p */
    public final byte[] f19945p;

    /* JADX INFO: renamed from: q */
    public int f19946q;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.emsg.EventMessage$a */
    public class C10721a implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }
    }

    static {
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7173k = "application/id3";
        f19939j = bVar.m3277a();
        C2811j1.b bVar2 = new C2811j1.b();
        bVar2.f7173k = "application/x-scte35";
        f19940k = bVar2.m3277a();
        CREATOR = new C10721a();
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.f19941l = str;
        this.f19942m = str2;
        this.f19943n = j;
        this.f19944o = j2;
        this.f19945p = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.f19943n == eventMessage.f19943n && this.f19944o == eventMessage.f19944o && C2738e0.m2993a(this.f19941l, eventMessage.f19941l) && C2738e0.m2993a(this.f19942m, eventMessage.f19942m) && Arrays.equals(this.f19945p, eventMessage.f19945p);
    }

    public int hashCode() {
        if (this.f19946q == 0) {
            String str = this.f19941l;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f19942m;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.f19943n;
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f19944o;
            this.f19946q = Arrays.hashCode(this.f19945p) + ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31);
        }
        return this.f19946q;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: n */
    public /* synthetic */ void mo8878n(C2835p1.b bVar) {
        C3155a.m3894c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    /* JADX INFO: renamed from: o0 */
    public byte[] mo8879o0() {
        if (mo8880y() != null) {
            return this.f19945p;
        }
        return null;
    }

    public String toString() {
        String str = this.f19941l;
        long j = this.f19944o;
        long j2 = this.f19943n;
        String str2 = this.f19942m;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 79);
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j);
        sb.append(", durationMs=");
        sb.append(j2);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19941l);
        parcel.writeString(this.f19942m);
        parcel.writeLong(this.f19943n);
        parcel.writeLong(this.f19944o);
        parcel.writeByteArray(this.f19945p);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    /* JADX INFO: renamed from: y */
    public C2811j1 mo8880y() {
        String str = this.f19941l;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f19940k;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f19939j;
            default:
                return null;
        }
    }

    public EventMessage(Parcel parcel) {
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19941l = string;
        this.f19942m = parcel.readString();
        this.f19943n = parcel.readLong();
        this.f19944o = parcel.readLong();
        this.f19945p = parcel.createByteArray();
    }
}
