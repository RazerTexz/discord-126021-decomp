package b.i.a.c.x2.g0;

import b.i.a.c.x2.w;
import b.i.a.c.x2.w$a;
import b.i.a.c.x2.x;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: MatroskaExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c {
    public byte[] N;
    public x T;
    public boolean U;
    public w X;
    public int Y;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1196b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public byte[] i;
    public w$a j;
    public byte[] k;
    public DrmInitData l;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = -1;
    public int q = 0;
    public int r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f1197s = 0.0f;
    public float t = 0.0f;
    public float u = 0.0f;
    public byte[] v = null;
    public int w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1198x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1199y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1200z = -1;
    public int A = -1;
    public int B = 1000;
    public int C = 200;
    public float D = -1.0f;
    public float E = -1.0f;
    public float F = -1.0f;
    public float G = -1.0f;
    public float H = -1.0f;
    public float I = -1.0f;
    public float J = -1.0f;
    public float K = -1.0f;
    public float L = -1.0f;
    public float M = -1.0f;
    public int O = 1;
    public int P = -1;
    public int Q = 8000;
    public long R = 0;
    public long S = 0;
    public boolean V = true;
    public String W = "eng";

    public e$c() {
    }

    @EnsuresNonNull({"codecPrivate"})
    public final byte[] a(String str) throws ParserException {
        byte[] bArr = this.k;
        if (bArr != null) {
            return bArr;
        }
        String strValueOf = String.valueOf(str);
        throw ParserException.a(strValueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(strValueOf) : new String("Missing CodecPrivate for codec "), null);
    }

    public e$c(e$a e_a) {
    }
}
