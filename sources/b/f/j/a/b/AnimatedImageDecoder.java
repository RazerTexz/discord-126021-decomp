package b.f.j.a.b;

import b.f.j.a.a.AnimatedImage;
import b.f.j.d.ImageDecodeOptions;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.f.j.a.b.c, reason: use source file name */
/* JADX INFO: compiled from: AnimatedImageDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface AnimatedImageDecoder {
    AnimatedImage c(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions);

    AnimatedImage h(long j, int i, ImageDecodeOptions imageDecodeOptions);
}
