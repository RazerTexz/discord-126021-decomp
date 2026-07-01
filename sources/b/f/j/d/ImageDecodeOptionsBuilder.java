package b.f.j.d;

import android.graphics.Bitmap;
import b.f.j.d.ImageDecodeOptionsBuilder;

/* JADX INFO: renamed from: b.f.j.d.c, reason: use source file name */
/* JADX INFO: compiled from: ImageDecodeOptionsBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder> {
    public Bitmap.Config a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap.Config f565b;

    public ImageDecodeOptionsBuilder() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        this.a = config;
        this.f565b = config;
    }
}
