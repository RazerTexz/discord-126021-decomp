package p007b.p225i.p226a.p242c.p278y2;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p265v2.C2959g;

/* JADX INFO: renamed from: b.i.a.c.y2.u */
/* JADX INFO: compiled from: MediaCodecInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3149u {

    /* JADX INFO: renamed from: a */
    public final String f9112a;

    /* JADX INFO: renamed from: b */
    public final String f9113b;

    /* JADX INFO: renamed from: c */
    public final String f9114c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f9115d;

    /* JADX INFO: renamed from: e */
    public final boolean f9116e;

    /* JADX INFO: renamed from: f */
    public final boolean f9117f;

    /* JADX INFO: renamed from: g */
    public final boolean f9118g;

    @VisibleForTesting
    public C3149u(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Objects.requireNonNull(str);
        this.f9112a = str;
        this.f9113b = str2;
        this.f9114c = str3;
        this.f9115d = codecCapabilities;
        this.f9116e = z5;
        this.f9117f = z7;
        this.f9118g = C2753t.m3052j(str2);
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: a */
    public static Point m3862a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C2738e0.m2998f(i, widthAlignment) * widthAlignment, C2738e0.m2998f(i2, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: b */
    public static boolean m3863b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointM3862a = m3862a(videoCapabilities, i, i2);
        int i3 = pointM3862a.x;
        int i4 = pointM3862a.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0062  */
    /* JADX WARN: Code duplicated, block: B:49:0x007b  */
    /* JADX INFO: renamed from: i */
    public static C3149u m3864i(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (z5 || codecCapabilities == null) {
            z7 = false;
        } else {
            int i = C2738e0.f6708a;
            if (i >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                if (i <= 22) {
                    String str4 = C2738e0.f6711d;
                    if (("ODROID-XU3".equals(str4) || "Nexus 10".equals(str4)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else {
                    z10 = false;
                }
                if (z10) {
                    z7 = false;
                } else {
                    z7 = true;
                }
            } else {
                z7 = false;
            }
        }
        if (codecCapabilities == null) {
            z8 = false;
        } else {
            if (C2738e0.f6708a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z8 = true;
            } else {
                z8 = false;
            }
        }
        if (!z6) {
            if (codecCapabilities != null) {
                z9 = C2738e0.f6708a >= 21 && codecCapabilities.isFeatureSupported("secure-playback");
            }
        }
        return new C3149u(str, str2, str3, codecCapabilities, z2, z3, z4, z7, z8, z9);
    }

    /* JADX INFO: renamed from: c */
    public C2959g m3865c(C2811j1 c2811j1, C2811j1 c2811j2) {
        boolean z2 = false;
        int i = !C2738e0.m2993a(c2811j1.f7155w, c2811j2.f7155w) ? 8 : 0;
        if (this.f9118g) {
            if (c2811j1.f7131E != c2811j2.f7131E) {
                i |= 1024;
            }
            if (!this.f9116e && (c2811j1.f7128B != c2811j2.f7128B || c2811j1.f7129C != c2811j2.f7129C)) {
                i |= 512;
            }
            if (!C2738e0.m2993a(c2811j1.f7135I, c2811j2.f7135I)) {
                i |= 2048;
            }
            String str = this.f9112a;
            if (C2738e0.f6711d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str)) {
                z2 = true;
            }
            if (z2 && !c2811j1.m3276c(c2811j2)) {
                i |= 2;
            }
            if (i == 0) {
                return new C2959g(this.f9112a, c2811j1, c2811j2, c2811j1.m3276c(c2811j2) ? 3 : 2, 0);
            }
        } else {
            if (c2811j1.f7136J != c2811j2.f7136J) {
                i |= 4096;
            }
            if (c2811j1.f7137K != c2811j2.f7137K) {
                i |= 8192;
            }
            if (c2811j1.f7138L != c2811j2.f7138L) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.f9113b)) {
                Pair<Integer, Integer> pairM8864c = MediaCodecUtil.m8864c(c2811j1);
                Pair<Integer, Integer> pairM8864c2 = MediaCodecUtil.m8864c(c2811j2);
                if (pairM8864c != null && pairM8864c2 != null) {
                    int iIntValue = ((Integer) pairM8864c.first).intValue();
                    int iIntValue2 = ((Integer) pairM8864c2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new C2959g(this.f9112a, c2811j1, c2811j2, 3, 0);
                    }
                }
            }
            if (!c2811j1.m3276c(c2811j2)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.f9113b)) {
                i |= 2;
            }
            if (i == 0) {
                return new C2959g(this.f9112a, c2811j1, c2811j2, 1, 0);
            }
        }
        return new C2959g(this.f9112a, c2811j1, c2811j2, 0, i);
    }

    /* JADX INFO: renamed from: d */
    public MediaCodecInfo.CodecProfileLevel[] m3866d() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9115d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: e */
    public boolean m3867e(C2811j1 c2811j1) throws MediaCodecUtil.DecoderQueryException {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        String strM3045c;
        int i2;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str = c2811j1.f7152t;
        int i3 = 16;
        if (str == null || this.f9113b == null || (strM3045c = C2753t.m3045c(str)) == null) {
            z2 = true;
        } else {
            if (this.f9113b.equals(strM3045c)) {
                Pair<Integer, Integer> pairM8864c = MediaCodecUtil.m8864c(c2811j1);
                if (pairM8864c != null) {
                    int iIntValue = ((Integer) pairM8864c.first).intValue();
                    int iIntValue2 = ((Integer) pairM8864c.second).intValue();
                    if (this.f9118g || iIntValue == 42) {
                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrM3866d = m3866d();
                        if (C2738e0.f6708a <= 23 && "video/x-vnd.on2.vp9".equals(this.f9113b) && codecProfileLevelArrM3866d.length == 0) {
                            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9115d;
                            int iIntValue3 = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                            if (iIntValue3 >= 180000000) {
                                i2 = 1024;
                            } else if (iIntValue3 >= 120000000) {
                                i2 = 512;
                            } else if (iIntValue3 >= 60000000) {
                                i2 = 256;
                            } else if (iIntValue3 >= 30000000) {
                                i2 = 128;
                            } else if (iIntValue3 >= 18000000) {
                                i2 = 64;
                            } else if (iIntValue3 >= 12000000) {
                                i2 = 32;
                            } else if (iIntValue3 >= 7200000) {
                                i2 = 16;
                            } else if (iIntValue3 >= 3600000) {
                                i2 = 8;
                            } else if (iIntValue3 >= 1800000) {
                                i2 = 4;
                            } else {
                                i2 = iIntValue3 >= 800000 ? 2 : 1;
                            }
                            MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                            codecProfileLevel.profile = 1;
                            codecProfileLevel.level = i2;
                            codecProfileLevelArrM3866d = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                        }
                        int length = codecProfileLevelArrM3866d.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = codecProfileLevelArrM3866d[i4];
                                if (codecProfileLevel2.profile != iIntValue || codecProfileLevel2.level < iIntValue2) {
                                    i4++;
                                }
                            } else {
                                String str2 = c2811j1.f7152t;
                                m3870h(C1643a.m861l(strM3045c.length() + C1643a.m841b(str2, 22), "codec.profileLevel, ", str2, ", ", strM3045c));
                            }
                        }
                    }
                }
                z2 = true;
            } else {
                String str3 = c2811j1.f7152t;
                m3870h(C1643a.m861l(strM3045c.length() + C1643a.m841b(str3, 13), "codec.mime ", str3, ", ", strM3045c));
            }
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.f9118g) {
            int i5 = c2811j1.f7128B;
            if (i5 <= 0 || (i = c2811j1.f7129C) <= 0) {
                return true;
            }
            if (C2738e0.f6708a >= 21) {
                return m3869g(i5, i, c2811j1.f7130D);
            }
            boolean z5 = i5 * i <= MediaCodecUtil.m8870i();
            if (!z5) {
                m3870h(C1643a.m853h(40, "legacyFrameSize, ", c2811j1.f7128B, "x", c2811j1.f7129C));
            }
            return z5;
        }
        int i6 = C2738e0.f6708a;
        if (i6 >= 21) {
            int i7 = c2811j1.f7137K;
            if (i7 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.f9115d;
                if (codecCapabilities2 == null) {
                    m3870h("sampleRate.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        m3870h("sampleRate.aCaps");
                    } else {
                        if (audioCapabilities.isSampleRateSupported(i7)) {
                            z4 = true;
                        } else {
                            StringBuilder sb = new StringBuilder(31);
                            sb.append("sampleRate.support, ");
                            sb.append(i7);
                            m3870h(sb.toString());
                        }
                        if (!z4) {
                            return false;
                        }
                    }
                }
                z4 = false;
                if (!z4) {
                    return false;
                }
            }
            int i8 = c2811j1.f7136J;
            if (i8 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities3 = this.f9115d;
                if (codecCapabilities3 == null) {
                    m3870h("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities3.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        m3870h("channelCount.aCaps");
                    } else {
                        String str4 = this.f9112a;
                        String str5 = this.f9113b;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i6 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str5) && !"audio/3gpp".equals(str5) && !"audio/amr-wb".equals(str5) && !"audio/mp4a-latm".equals(str5) && !"audio/vorbis".equals(str5) && !"audio/opus".equals(str5) && !"audio/raw".equals(str5) && !"audio/flac".equals(str5) && !"audio/g711-alaw".equals(str5) && !"audio/g711-mlaw".equals(str5) && !"audio/gsm".equals(str5))) {
                            if ("audio/ac3".equals(str5)) {
                                i3 = 6;
                            } else if (!"audio/eac3".equals(str5)) {
                                i3 = 30;
                            }
                            StringBuilder sb2 = new StringBuilder(C1643a.m841b(str4, 59));
                            sb2.append("AssumedMaxChannelAdjustment: ");
                            sb2.append(str4);
                            sb2.append(", [");
                            sb2.append(maxInputChannelCount);
                            sb2.append(" to ");
                            sb2.append(i3);
                            sb2.append("]");
                            Log.w("MediaCodecInfo", sb2.toString());
                            maxInputChannelCount = i3;
                        }
                        if (maxInputChannelCount < i8) {
                            StringBuilder sb3 = new StringBuilder(33);
                            sb3.append("channelCount.support, ");
                            sb3.append(i8);
                            m3870h(sb3.toString());
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            return false;
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3868f(C2811j1 c2811j1) {
        if (this.f9118g) {
            return this.f9116e;
        }
        Pair<Integer, Integer> pairM8864c = MediaCodecUtil.m8864c(c2811j1);
        return pairM8864c != null && ((Integer) pairM8864c.first).intValue() == 42;
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: g */
    public boolean m3869g(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9115d;
        if (codecCapabilities == null) {
            m3870h("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m3870h("sizeAndRate.vCaps");
            return false;
        }
        if (!m3863b(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                if ((("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.f9112a) && "mcv5a".equals(C2738e0.f6709b)) ? false : true) && m3863b(videoCapabilities, i2, i, d)) {
                    StringBuilder sb = new StringBuilder(69);
                    sb.append("sizeAndRate.rotated, ");
                    sb.append(i);
                    sb.append("x");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(d);
                    String string = sb.toString();
                    String str = this.f9112a;
                    String str2 = this.f9113b;
                    String str3 = C2738e0.f6712e;
                    StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, C1643a.m841b(string, 25)))), "AssumedSupport [", string, "] [", str);
                    C1643a.m876s0(sbM831S, ", ", str2, "] [", str3);
                    sbM831S.append("]");
                    Log.d("MediaCodecInfo", sbM831S.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.support, ");
            sb2.append(i);
            sb2.append("x");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(d);
            m3870h(sb2.toString());
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: h */
    public final void m3870h(String str) {
        String str2 = this.f9112a;
        String str3 = this.f9113b;
        String str4 = C2738e0.f6712e;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str4, C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, 20)))), "NoSupport [", str, "] [", str2);
        C1643a.m876s0(sbM831S, ", ", str3, "] [", str4);
        sbM831S.append("]");
        Log.d("MediaCodecInfo", sbM831S.toString());
    }

    public String toString() {
        return this.f9112a;
    }
}
