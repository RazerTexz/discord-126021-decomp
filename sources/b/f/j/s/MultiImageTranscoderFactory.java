package b.f.j.s;

import b.f.i.ImageFormat;
import b.f.j.e.NativeCodeSetup;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: b.f.j.s.e, reason: use source file name */
/* JADX INFO: compiled from: MultiImageTranscoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultiImageTranscoderFactory implements ImageTranscoderFactory {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageTranscoderFactory f644b;
    public final Integer c;
    public final boolean d;

    public MultiImageTranscoderFactory(int i, boolean z2, ImageTranscoderFactory imageTranscoderFactory, Integer num, boolean z3) {
        this.a = i;
        this.f644b = imageTranscoderFactory;
        this.c = num;
        this.d = z3;
    }

    public final ImageTranscoder a(ImageFormat imageFormat, boolean z2) {
        int i = this.a;
        boolean z3 = this.d;
        try {
            Class<?> cls = Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory");
            Class<?> cls2 = Boolean.TYPE;
            return ((ImageTranscoderFactory) cls.getConstructor(Integer.TYPE, cls2, cls2).newInstance(Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(z3))).createImageTranscoder(imageFormat, z2);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        }
    }

    @Override // b.f.j.s.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z2) {
        ImageTranscoderFactory imageTranscoderFactory = this.f644b;
        ImageTranscoder imageTranscoderA = null;
        ImageTranscoder imageTranscoderCreateImageTranscoder = imageTranscoderFactory == null ? null : imageTranscoderFactory.createImageTranscoder(imageFormat, z2);
        if (imageTranscoderCreateImageTranscoder == null) {
            Integer num = this.c;
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    imageTranscoderA = a(imageFormat, z2);
                } else {
                    if (iIntValue != 1) {
                        throw new IllegalArgumentException("Invalid ImageTranscoderType");
                    }
                    imageTranscoderA = new SimpleImageTranscoder(z2, this.a);
                }
            }
            imageTranscoderCreateImageTranscoder = imageTranscoderA;
        }
        if (imageTranscoderCreateImageTranscoder == null && NativeCodeSetup.a) {
            imageTranscoderCreateImageTranscoder = a(imageFormat, z2);
        }
        return imageTranscoderCreateImageTranscoder == null ? new SimpleImageTranscoder(z2, this.a) : imageTranscoderCreateImageTranscoder;
    }
}
