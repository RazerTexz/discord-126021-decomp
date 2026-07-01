package com.facebook.imagepipeline.nativecode;

import b.f.d.d.DoNotStrip;
import b.f.i.DefaultImageFormats;
import b.f.i.ImageFormat;
import b.f.j.s.ImageTranscoder;
import b.f.j.s.ImageTranscoderFactory;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeJpegTranscoderFactory implements ImageTranscoderFactory {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2900b;
    public final boolean c;

    @DoNotStrip
    public NativeJpegTranscoderFactory(int i, boolean z2, boolean z3) {
        this.a = i;
        this.f2900b = z2;
        this.c = z3;
    }

    @Override // b.f.j.s.ImageTranscoderFactory
    @DoNotStrip
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z2) {
        if (imageFormat != DefaultImageFormats.a) {
            return null;
        }
        return new NativeJpegTranscoder(z2, this.a, this.f2900b, this.c);
    }
}
