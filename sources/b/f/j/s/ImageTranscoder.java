package b.f.j.s;

import b.f.i.ImageFormat;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.j.EncodedImage2;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.f.j.s.b, reason: use source file name */
/* JADX INFO: compiled from: ImageTranscoder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ImageTranscoder {
    String a();

    boolean b(EncodedImage2 encodedImage2, RotationOptions rotationOptions, ResizeOptions resizeOptions);

    ImageTranscodeResult c(EncodedImage2 encodedImage2, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws IOException;

    boolean d(ImageFormat imageFormat);
}
