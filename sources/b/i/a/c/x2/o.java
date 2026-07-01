package b.i.a.c.x2;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: FlacStreamMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1292b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;

    @Nullable
    public final o$a k;

    @Nullable
    public final Metadata l;

    public o(byte[] bArr, int i) {
        b.i.a.c.f3.w wVar = new b.i.a.c.f3.w(bArr);
        wVar.k(i * 8);
        this.a = wVar.g(16);
        this.f1292b = wVar.g(16);
        this.c = wVar.g(24);
        this.d = wVar.g(24);
        int iG = wVar.g(20);
        this.e = iG;
        this.f = h(iG);
        this.g = wVar.g(3) + 1;
        int iG2 = wVar.g(5) + 1;
        this.h = iG2;
        this.i = c(iG2);
        this.j = (e0.L(wVar.g(4)) << 32) | e0.L(wVar.g(32));
        this.k = null;
        this.l = null;
    }

    @Nullable
    public static Metadata a(List<String> list, List<PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrI = e0.I(str, "=");
            if (strArrI.length != 2) {
                String strValueOf = String.valueOf(str);
                Log.w("FlacStreamMetadata", strValueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(strValueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new VorbisComment(strArrI[0], strArrI[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static int c(int i) {
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

    public static int h(int i) {
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

    public o b(@Nullable o$a o_a) {
        return new o(this.a, this.f1292b, this.c, this.d, this.e, this.g, this.h, this.j, o_a, this.l);
    }

    public long d() {
        long j = this.j;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.e);
    }

    public j1 e(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = -128;
        int i = this.d;
        if (i <= 0) {
            i = -1;
        }
        Metadata metadataF = f(metadata);
        j1$b j1_b = new j1$b();
        j1_b.k = "audio/flac";
        j1_b.l = i;
        j1_b.f1023x = this.g;
        j1_b.f1024y = this.e;
        j1_b.m = Collections.singletonList(bArr);
        j1_b.i = metadataF;
        return j1_b.a();
    }

    @Nullable
    public Metadata f(@Nullable Metadata metadata) {
        Metadata metadata2 = this.l;
        if (metadata2 == null) {
            return metadata;
        }
        return metadata == null ? metadata2 : metadata2.a(metadata.j);
    }

    public long g(long j) {
        return e0.i((j * ((long) this.e)) / 1000000, 0L, this.j - 1);
    }

    public o(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @Nullable o$a o_a, @Nullable Metadata metadata) {
        this.a = i;
        this.f1292b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = h(i5);
        this.g = i6;
        this.h = i7;
        this.i = c(i7);
        this.j = j;
        this.k = o_a;
        this.l = metadata;
    }
}
