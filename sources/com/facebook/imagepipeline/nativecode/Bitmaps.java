package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p161j.p178m.C1955a;
import p007b.p109f.p190m.p191n.C2061a;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class Bitmaps {
    static {
        List<String> list = C1955a.f3980a;
        C2061a.m1589c("imagepipeline");
    }

    @InterfaceC1680c
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        C1460d.m527i(Boolean.valueOf(bitmap2.getConfig() == bitmap.getConfig()));
        C1460d.m527i(Boolean.valueOf(bitmap.isMutable()));
        C1460d.m527i(Boolean.valueOf(bitmap.getWidth() == bitmap2.getWidth()));
        C1460d.m527i(Boolean.valueOf(bitmap.getHeight() == bitmap2.getHeight()));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @InterfaceC1680c
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);
}
