package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ImageEncoder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ImageEncoder {
    public static /* synthetic */ String encodeBitmapAsJpegDataUrl$default(ImageEncoder imageEncoder, Bitmap bitmap, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 100;
        }
        return imageEncoder.encodeBitmapAsJpegDataUrl(bitmap, i);
    }

    public final String encodeBitmapAsJpegDataUrl(Bitmap bitmap, int jpegQuality) {
        C12238m.checkNotNullParameter(bitmap, "bitmap");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, jpegQuality, byteArrayOutputStream);
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        C12238m.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(jp…eArray(), Base64.NO_WRAP)");
        return C1643a.m828P(new Object[]{"image/jpeg", strEncodeToString}, 2, "data:%s;base64,%s", "java.lang.String.format(format, *args)");
    }

    public final String getBase64EncodedString(InputStream inputStream, int flags) throws IOException {
        C12238m.checkNotNullParameter(inputStream, "inputStream");
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), flags);
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public final String getDataUrl(String mimeType, InputStream inputStream) throws IOException {
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        C12238m.checkNotNullParameter(inputStream, "inputStream");
        return C1643a.m828P(new Object[]{mimeType, getBase64EncodedString(inputStream, 2)}, 2, "data:%s;base64,%s", "java.lang.String.format(format, *args)");
    }
}
