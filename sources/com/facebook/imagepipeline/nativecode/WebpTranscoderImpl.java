package com.facebook.imagepipeline.nativecode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p007b.p109f.p115d.p119d.InterfaceC1680c;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class WebpTranscoderImpl {
    @InterfaceC1680c
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    @InterfaceC1680c
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;
}
