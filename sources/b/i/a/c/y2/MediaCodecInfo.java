package b.i.a.c.y2;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.v2.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.y2.u, reason: use source file name */
/* JADX INFO: compiled from: MediaCodecInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaCodecInfo {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1315b;
    public final String c;

    @Nullable
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    @VisibleForTesting
    public MediaCodecInfo(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Objects.requireNonNull(str);
        this.a = str;
        this.f1315b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.e = z5;
        this.f = z7;
        this.g = MimeTypes.j(str2);
    }

    @RequiresApi(21)
    public static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util2.f(i, widthAlignment) * widthAlignment, Util2.f(i2, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    public static boolean b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointA = a(videoCapabilities, i, i2);
        int i3 = pointA.x;
        int i4 = pointA.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0062  */
    /* JADX WARN: Code duplicated, block: B:49:0x007b  */
    public static MediaCodecInfo i(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (z5 || codecCapabilities == null) {
            z7 = false;
        } else {
            int i = Util2.a;
            if (i >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                if (i <= 22) {
                    String str4 = Util2.d;
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
            if (Util2.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z8 = true;
            } else {
                z8 = false;
            }
        }
        if (!z6) {
            if (codecCapabilities != null) {
                z9 = Util2.a >= 21 && codecCapabilities.isFeatureSupported("secure-playback");
            }
        }
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z2, z3, z4, z7, z8, z9);
    }

    public DecoderReuseEvaluation c(Format2 format2, Format2 format3) {
        boolean z2 = false;
        int i = !Util2.a(format2.w, format3.w) ? 8 : 0;
        if (this.g) {
            if (format2.E != format3.E) {
                i |= 1024;
            }
            if (!this.e && (format2.B != format3.B || format2.C != format3.C)) {
                i |= 512;
            }
            if (!Util2.a(format2.I, format3.I)) {
                i |= 2048;
            }
            String str = this.a;
            if (Util2.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str)) {
                z2 = true;
            }
            if (z2 && !format2.c(format3)) {
                i |= 2;
            }
            if (i == 0) {
                return new DecoderReuseEvaluation(this.a, format2, format3, format2.c(format3) ? 3 : 2, 0);
            }
        } else {
            if (format2.J != format3.J) {
                i |= 4096;
            }
            if (format2.K != format3.K) {
                i |= 8192;
            }
            if (format2.L != format3.L) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.f1315b)) {
                Pair<Integer, Integer> pairC = MediaCodecUtil.c(format2);
                Pair<Integer, Integer> pairC2 = MediaCodecUtil.c(format3);
                if (pairC != null && pairC2 != null) {
                    int iIntValue = ((Integer) pairC.first).intValue();
                    int iIntValue2 = ((Integer) pairC2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new DecoderReuseEvaluation(this.a, format2, format3, 3, 0);
                    }
                }
            }
            if (!format2.c(format3)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.f1315b)) {
                i |= 2;
            }
            if (i == 0) {
                return new DecoderReuseEvaluation(this.a, format2, format3, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.a, format2, format3, 0, i);
    }

    public MediaCodecInfo.CodecProfileLevel[] d() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    public boolean e(Format2 format2) throws MediaCodecUtil.DecoderQueryException {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        String strC;
        int i2;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str = format2.t;
        int i3 = 16;
        if (str == null || this.f1315b == null || (strC = MimeTypes.c(str)) == null) {
            z2 = true;
        } else {
            if (this.f1315b.equals(strC)) {
                Pair<Integer, Integer> pairC = MediaCodecUtil.c(format2);
                if (pairC != null) {
                    int iIntValue = ((Integer) pairC.first).intValue();
                    int iIntValue2 = ((Integer) pairC.second).intValue();
                    if (this.g || iIntValue == 42) {
                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrD = d();
                        if (Util2.a <= 23 && "video/x-vnd.on2.vp9".equals(this.f1315b) && codecProfileLevelArrD.length == 0) {
                            MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
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
                            codecProfileLevelArrD = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                        }
                        int length = codecProfileLevelArrD.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = codecProfileLevelArrD[i4];
                                if (codecProfileLevel2.profile != iIntValue || codecProfileLevel2.level < iIntValue2) {
                                    i4++;
                                }
                            } else {
                                String str2 = format2.t;
                                h(outline.l(strC.length() + outline.b(str2, 22), "codec.profileLevel, ", str2, ", ", strC));
                            }
                        }
                    }
                }
                z2 = true;
            } else {
                String str3 = format2.t;
                h(outline.l(strC.length() + outline.b(str3, 13), "codec.mime ", str3, ", ", strC));
            }
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.g) {
            int i5 = format2.B;
            if (i5 <= 0 || (i = format2.C) <= 0) {
                return true;
            }
            if (Util2.a >= 21) {
                return g(i5, i, format2.D);
            }
            boolean z5 = i5 * i <= MediaCodecUtil.i();
            if (!z5) {
                h(outline.h(40, "legacyFrameSize, ", format2.B, "x", format2.C));
            }
            return z5;
        }
        int i6 = Util2.a;
        if (i6 >= 21) {
            int i7 = format2.K;
            if (i7 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.d;
                if (codecCapabilities2 == null) {
                    h("sampleRate.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        h("sampleRate.aCaps");
                    } else {
                        if (audioCapabilities.isSampleRateSupported(i7)) {
                            z4 = true;
                        } else {
                            StringBuilder sb = new StringBuilder(31);
                            sb.append("sampleRate.support, ");
                            sb.append(i7);
                            h(sb.toString());
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
            int i8 = format2.J;
            if (i8 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities3 = this.d;
                if (codecCapabilities3 == null) {
                    h("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities3.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        h("channelCount.aCaps");
                    } else {
                        String str4 = this.a;
                        String str5 = this.f1315b;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i6 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str5) && !"audio/3gpp".equals(str5) && !"audio/amr-wb".equals(str5) && !"audio/mp4a-latm".equals(str5) && !"audio/vorbis".equals(str5) && !"audio/opus".equals(str5) && !"audio/raw".equals(str5) && !"audio/flac".equals(str5) && !"audio/g711-alaw".equals(str5) && !"audio/g711-mlaw".equals(str5) && !"audio/gsm".equals(str5))) {
                            if ("audio/ac3".equals(str5)) {
                                i3 = 6;
                            } else if (!"audio/eac3".equals(str5)) {
                                i3 = 30;
                            }
                            StringBuilder sb2 = new StringBuilder(outline.b(str4, 59));
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
                            h(sb3.toString());
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

    public boolean f(Format2 format2) {
        if (this.g) {
            return this.e;
        }
        Pair<Integer, Integer> pairC = MediaCodecUtil.c(format2);
        return pairC != null && ((Integer) pairC.first).intValue() == 42;
    }

    @RequiresApi(21)
    public boolean g(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            h("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            h("sizeAndRate.vCaps");
            return false;
        }
        if (!b(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                if ((("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.a) && "mcv5a".equals(Util2.f968b)) ? false : true) && b(videoCapabilities, i2, i, d)) {
                    StringBuilder sb = new StringBuilder(69);
                    sb.append("sizeAndRate.rotated, ");
                    sb.append(i);
                    sb.append("x");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(d);
                    String string = sb.toString();
                    String str = this.a;
                    String str2 = this.f1315b;
                    String str3 = Util2.e;
                    StringBuilder sbS = outline.S(outline.b(str3, outline.b(str2, outline.b(str, outline.b(string, 25)))), "AssumedSupport [", string, "] [", str);
                    outline.s0(sbS, ", ", str2, "] [", str3);
                    sbS.append("]");
                    Log.d("MediaCodecInfo", sbS.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.support, ");
            sb2.append(i);
            sb2.append("x");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(d);
            h(sb2.toString());
            return false;
        }
        return true;
    }

    public final void h(String str) {
        String str2 = this.a;
        String str3 = this.f1315b;
        String str4 = Util2.e;
        StringBuilder sbS = outline.S(outline.b(str4, outline.b(str3, outline.b(str2, outline.b(str, 20)))), "NoSupport [", str, "] [", str2);
        outline.s0(sbS, ", ", str3, "] [", str4);
        sbS.append("]");
        Log.d("MediaCodecInfo", sbS.toString());
    }

    public String toString() {
        return this.a;
    }
}
