package com.discord.utilities.voice;


/* JADX INFO: compiled from: PerceptualVolumeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PerceptualVolumeUtils {
    public static final PerceptualVolumeUtils INSTANCE = new PerceptualVolumeUtils();
    private static final float VOLUME_BOOST_DYNAMIC_RANGE_DB = 6.0f;
    private static final float VOLUME_DYNAMIC_RANGE_DB = 50.0f;

    private PerceptualVolumeUtils() {
    }

    public static /* synthetic */ float amplitudeToPerceptual$default(PerceptualVolumeUtils perceptualVolumeUtils, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 100.0f;
        }
        return perceptualVolumeUtils.amplitudeToPerceptual(f, f2);
    }

    public static /* synthetic */ float perceptualToAmplitude$default(PerceptualVolumeUtils perceptualVolumeUtils, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 100.0f;
        }
        return perceptualVolumeUtils.perceptualToAmplitude(f, f2);
    }

    public final float amplitudeToPerceptual(float amplitude, float normalizedMax) {
        if (amplitude <= 0.0f) {
            return 0.0f;
        }
        float fLog10 = ((float) Math.log10(amplitude / normalizedMax)) * 20.0f;
        return normalizedMax * (fLog10 > 0.0f ? (fLog10 / VOLUME_BOOST_DYNAMIC_RANGE_DB) + 1.0f : (fLog10 + 50.0f) / 50.0f);
    }

    public final float perceptualToAmplitude(float perceptual, float normalizedMax) {
        if (perceptual <= 0.0f) {
            return 0.0f;
        }
        return normalizedMax * ((float) Math.pow(10.0f, (perceptual > normalizedMax ? ((perceptual - normalizedMax) / normalizedMax) * VOLUME_BOOST_DYNAMIC_RANGE_DB : ((perceptual / normalizedMax) * 50.0f) - 50.0f) / 20.0f));
    }
}
