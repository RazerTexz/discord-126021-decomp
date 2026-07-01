package b.q.a.i;

import android.graphics.Bitmap;

/* JADX INFO: renamed from: b.q.a.i.a, reason: use source file name */
/* JADX INFO: compiled from: CropParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public class CropParameters {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1978b;
    public Bitmap.CompressFormat c;
    public int d;
    public String e;
    public String f;
    public ExifInfo g;

    public CropParameters(int i, int i2, Bitmap.CompressFormat compressFormat, int i3, String str, String str2, ExifInfo exifInfo) {
        this.a = i;
        this.f1978b = i2;
        this.c = compressFormat;
        this.d = i3;
        this.e = str;
        this.f = str2;
        this.g = exifInfo;
    }
}
