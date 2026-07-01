package com.facebook.imagepipeline.nativecode;

import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Closeables;
import b.f.d.d.DoNotStrip;
import b.f.d.d.ImmutableList;
import b.f.i.DefaultImageFormats;
import b.f.i.ImageFormat;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.j.EncodedImage2;
import b.f.j.s.ImageTranscodeResult;
import b.f.j.s.ImageTranscoder;
import b.f.j.s.JpegTranscoderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeJpegTranscoder implements ImageTranscoder {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2899b;
    public boolean c;

    public NativeJpegTranscoder(boolean z2, int i, boolean z3, boolean z4) {
        this.a = z2;
        this.f2899b = i;
        this.c = z3;
        if (z4) {
            AnimatableValueParser.e0();
        }
    }

    @VisibleForTesting
    public static void e(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        AnimatableValueParser.e0();
        AnimatableValueParser.i(Boolean.valueOf(i2 >= 1));
        AnimatableValueParser.i(Boolean.valueOf(i2 <= 16));
        AnimatableValueParser.i(Boolean.valueOf(i3 >= 0));
        AnimatableValueParser.i(Boolean.valueOf(i3 <= 100));
        ImmutableList<Integer> immutableList = JpegTranscoderUtils.a;
        AnimatableValueParser.i(Boolean.valueOf(i >= 0 && i <= 270 && i % 90 == 0));
        AnimatableValueParser.k((i2 == 8 && i == 0) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpeg(inputStream, outputStream, i, i2, i3);
    }

    @VisibleForTesting
    public static void f(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z2;
        AnimatableValueParser.e0();
        AnimatableValueParser.i(Boolean.valueOf(i2 >= 1));
        AnimatableValueParser.i(Boolean.valueOf(i2 <= 16));
        AnimatableValueParser.i(Boolean.valueOf(i3 >= 0));
        AnimatableValueParser.i(Boolean.valueOf(i3 <= 100));
        ImmutableList<Integer> immutableList = JpegTranscoderUtils.a;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z2 = true;
                break;
            default:
                z2 = false;
                break;
        }
        AnimatableValueParser.i(Boolean.valueOf(z2));
        AnimatableValueParser.k((i2 == 8 && i == 1) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpegWithExifOrientation(inputStream, outputStream, i, i2, i3);
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @Override // b.f.j.s.ImageTranscoder
    public String a() {
        return "NativeJpegTranscoder";
    }

    @Override // b.f.j.s.ImageTranscoder
    public boolean b(EncodedImage2 encodedImage2, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.a;
        }
        return JpegTranscoderUtils.c(rotationOptions, resizeOptions, encodedImage2, this.a) < 8;
    }

    @Override // b.f.j.s.ImageTranscoder
    public ImageTranscodeResult c(EncodedImage2 encodedImage2, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.a;
        }
        int iA0 = AnimatableValueParser.a0(rotationOptions, resizeOptions, encodedImage2, this.f2899b);
        try {
            int iC = JpegTranscoderUtils.c(rotationOptions, resizeOptions, encodedImage2, this.a);
            int iMax = Math.max(1, 8 / iA0);
            if (this.c) {
                iC = iMax;
            }
            InputStream inputStreamE = encodedImage2.e();
            ImmutableList<Integer> immutableList = JpegTranscoderUtils.a;
            encodedImage2.x();
            if (immutableList.contains(Integer.valueOf(encodedImage2.n))) {
                int iA = JpegTranscoderUtils.a(rotationOptions, encodedImage2);
                AnimatableValueParser.y(inputStreamE, "Cannot transcode from null input stream!");
                f(inputStreamE, outputStream, iA, iC, num.intValue());
            } else {
                int iB = JpegTranscoderUtils.b(rotationOptions, encodedImage2);
                AnimatableValueParser.y(inputStreamE, "Cannot transcode from null input stream!");
                e(inputStreamE, outputStream, iB, iC, num.intValue());
            }
            Closeables.b(inputStreamE);
            return new ImageTranscodeResult(iA0 != 1 ? 0 : 1);
        } catch (Throwable th) {
            Closeables.b(null);
            throw th;
        }
    }

    @Override // b.f.j.s.ImageTranscoder
    public boolean d(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.a;
    }
}
