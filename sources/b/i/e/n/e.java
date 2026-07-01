package b.i.e.n;

import java.util.List;

/* JADX INFO: compiled from: DecoderResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1835b;
    public final String c;
    public final List<byte[]> d;
    public final String e;
    public Object f;
    public final int g;
    public final int h;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.a = bArr;
        this.f1835b = bArr == null ? 0 : bArr.length * 8;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.g = i2;
        this.h = i;
    }
}
