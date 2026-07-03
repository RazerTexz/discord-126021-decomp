package p007b.p225i.p226a.p242c.p267x2;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;

/* JADX INFO: renamed from: b.i.a.c.x2.o */
/* JADX INFO: compiled from: FlacStreamMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3114o {

    /* JADX INFO: renamed from: a */
    public final int f8970a;

    /* JADX INFO: renamed from: b */
    public final int f8971b;

    /* JADX INFO: renamed from: c */
    public final int f8972c;

    /* JADX INFO: renamed from: d */
    public final int f8973d;

    /* JADX INFO: renamed from: e */
    public final int f8974e;

    /* JADX INFO: renamed from: f */
    public final int f8975f;

    /* JADX INFO: renamed from: g */
    public final int f8976g;

    /* JADX INFO: renamed from: h */
    public final int f8977h;

    /* JADX INFO: renamed from: i */
    public final int f8978i;

    /* JADX INFO: renamed from: j */
    public final long f8979j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final a f8980k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final Metadata f8981l;

    /* JADX INFO: renamed from: b.i.a.c.x2.o$a */
    /* JADX INFO: compiled from: FlacStreamMetadata.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final long[] f8982a;

        /* JADX INFO: renamed from: b */
        public final long[] f8983b;

        public a(long[] jArr, long[] jArr2) {
            this.f8982a = jArr;
            this.f8983b = jArr2;
        }
    }

    public C3114o(byte[] bArr, int i) {
        C2756w c2756w = new C2756w(bArr);
        c2756w.m3071k(i * 8);
        this.f8970a = c2756w.m3067g(16);
        this.f8971b = c2756w.m3067g(16);
        this.f8972c = c2756w.m3067g(24);
        this.f8973d = c2756w.m3067g(24);
        int iM3067g = c2756w.m3067g(20);
        this.f8974e = iM3067g;
        this.f8975f = m3808h(iM3067g);
        this.f8976g = c2756w.m3067g(3) + 1;
        int iM3067g2 = c2756w.m3067g(5) + 1;
        this.f8977h = iM3067g2;
        this.f8978i = m3807c(iM3067g2);
        this.f8979j = (C2738e0.m2991L(c2756w.m3067g(4)) << 32) | C2738e0.m2991L(c2756w.m3067g(32));
        this.f8980k = null;
        this.f8981l = null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static Metadata m3806a(List<String> list, List<PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrM2988I = C2738e0.m2988I(str, "=");
            if (strArrM2988I.length != 2) {
                String strValueOf = String.valueOf(str);
                Log.w("FlacStreamMetadata", strValueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(strValueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new VorbisComment(strArrM2988I[0], strArrM2988I[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    /* JADX INFO: renamed from: c */
    public static int m3807c(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    /* JADX INFO: renamed from: h */
    public static int m3808h(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public C3114o m3809b(@Nullable a aVar) {
        return new C3114o(this.f8970a, this.f8971b, this.f8972c, this.f8973d, this.f8974e, this.f8976g, this.f8977h, this.f8979j, aVar, this.f8981l);
    }

    /* JADX INFO: renamed from: d */
    public long m3810d() {
        long j = this.f8979j;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.f8974e);
    }

    /* JADX INFO: renamed from: e */
    public C2811j1 m3811e(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = -128;
        int i = this.f8973d;
        if (i <= 0) {
            i = -1;
        }
        Metadata metadataM3812f = m3812f(metadata);
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7173k = "audio/flac";
        bVar.f7174l = i;
        bVar.f7186x = this.f8976g;
        bVar.f7187y = this.f8974e;
        bVar.f7175m = Collections.singletonList(bArr);
        bVar.f7171i = metadataM3812f;
        return bVar.m3277a();
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public Metadata m3812f(@Nullable Metadata metadata) {
        Metadata metadata2 = this.f8981l;
        if (metadata2 == null) {
            return metadata;
        }
        return metadata == null ? metadata2 : metadata2.m8877a(metadata.f19936j);
    }

    /* JADX INFO: renamed from: g */
    public long m3813g(long j) {
        return C2738e0.m3001i((j * ((long) this.f8974e)) / 1000000, 0L, this.f8979j - 1);
    }

    public C3114o(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @Nullable a aVar, @Nullable Metadata metadata) {
        this.f8970a = i;
        this.f8971b = i2;
        this.f8972c = i3;
        this.f8973d = i4;
        this.f8974e = i5;
        this.f8975f = m3808h(i5);
        this.f8976g = i6;
        this.f8977h = i7;
        this.f8978i = m3807c(i7);
        this.f8979j = j;
        this.f8980k = aVar;
        this.f8981l = metadata;
    }
}
