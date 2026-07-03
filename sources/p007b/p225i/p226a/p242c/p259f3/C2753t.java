package p007b.p225i.p226a.p242c.p259f3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.objectweb.asm.Opcodes;
import org.webrtc.MediaStreamTrack;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.f3.t */
/* JADX INFO: compiled from: MimeTypes.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2753t {

    /* JADX INFO: renamed from: a */
    public static final ArrayList<a> f6749a = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    public static final Pattern f6750b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX INFO: renamed from: b.i.a.c.f3.t$a */
    /* JADX INFO: compiled from: MimeTypes.java */
    public static final class a {
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.t$b */
    /* JADX INFO: compiled from: MimeTypes.java */
    @VisibleForTesting
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f6751a;

        /* JADX INFO: renamed from: b */
        public final int f6752b;

        public b(int i, int i2) {
            this.f6751a = i;
            this.f6752b = i2;
        }

        /* JADX INFO: renamed from: a */
        public int m3053a() {
            int i = this.f6752b;
            if (i == 2) {
                return 10;
            }
            if (i == 5) {
                return 11;
            }
            if (i == 29) {
                return 12;
            }
            if (i == 42) {
                return 16;
            }
            if (i != 22) {
                return i != 23 ? 0 : 15;
            }
            return BasicMeasure.EXACTLY;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3043a(@Nullable String str, @Nullable String str2) {
        b bVarM3047e;
        int iM3053a;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/eac3-joc":
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/ac3":
            case "audio/raw":
            case "audio/eac3":
            case "audio/flac":
            case "audio/mpeg":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
                return true;
            case "audio/mp4a-latm":
                return (str2 == null || (bVarM3047e = m3047e(str2)) == null || (iM3053a = bVarM3047e.m3053a()) == 0 || iM3053a == 16) ? false : true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m3044b(String str, @Nullable String str2) {
        b bVarM3047e;
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (bVarM3047e = m3047e(str2)) == null) {
                    return 0;
                }
                return bVarM3047e.m3053a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public static String m3045c(@Nullable String str) {
        b bVarM3047e;
        String strM3046d = null;
        if (str == null) {
            return null;
        }
        String strM4349u1 = C3404f.m4349u1(str.trim());
        if (strM4349u1.startsWith("avc1") || strM4349u1.startsWith("avc3")) {
            return "video/avc";
        }
        if (strM4349u1.startsWith("hev1") || strM4349u1.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (strM4349u1.startsWith("dvav") || strM4349u1.startsWith("dva1") || strM4349u1.startsWith("dvhe") || strM4349u1.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (strM4349u1.startsWith("av01")) {
            return "video/av01";
        }
        if (strM4349u1.startsWith("vp9") || strM4349u1.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (strM4349u1.startsWith("vp8") || strM4349u1.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (strM4349u1.startsWith("mp4a")) {
            if (strM4349u1.startsWith("mp4a.") && (bVarM3047e = m3047e(strM4349u1)) != null) {
                strM3046d = m3046d(bVarM3047e.f6751a);
            }
            return strM3046d == null ? "audio/mp4a-latm" : strM3046d;
        }
        if (strM4349u1.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (strM4349u1.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (strM4349u1.startsWith("ac-3") || strM4349u1.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (strM4349u1.startsWith("ec-3") || strM4349u1.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (strM4349u1.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (strM4349u1.startsWith("ac-4") || strM4349u1.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (strM4349u1.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (strM4349u1.startsWith("dtse")) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (strM4349u1.startsWith("dtsh") || strM4349u1.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (strM4349u1.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (strM4349u1.startsWith("opus")) {
            return "audio/opus";
        }
        if (strM4349u1.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (strM4349u1.startsWith("flac")) {
            return "audio/flac";
        }
        if (strM4349u1.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (strM4349u1.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (strM4349u1.contains("cea708")) {
            return "application/cea-708";
        }
        if (strM4349u1.contains("eia608") || strM4349u1.contains("cea608")) {
            return "application/cea-608";
        }
        int size = f6749a.size();
        for (int i = 0; i < size; i++) {
            Objects.requireNonNull(f6749a.get(i));
            if (strM4349u1.startsWith(null)) {
                break;
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public static String m3046d(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case Opcodes.RET /* 169 */:
                    case Opcodes.IRETURN /* 172 */:
                        return "audio/vnd.dts";
                    case Opcodes.TABLESWITCH /* 170 */:
                    case Opcodes.LOOKUPSWITCH /* 171 */:
                        return "audio/vnd.dts.hd";
                    case Opcodes.LRETURN /* 173 */:
                        return "audio/opus";
                    case Opcodes.FRETURN /* 174 */:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    @Nullable
    @VisibleForTesting
    /* JADX INFO: renamed from: e */
    public static b m3047e(String str) {
        Matcher matcher = f6750b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        Objects.requireNonNull(strGroup);
        String strGroup2 = matcher.group(2);
        try {
            return new b(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public static String m3048f(@Nullable String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    /* JADX INFO: renamed from: g */
    public static int m3049g(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (m3050h(str)) {
            return 1;
        }
        if (m3052j(str)) {
            return 2;
        }
        if (m3051i(str)) {
            return 3;
        }
        if ("image".equals(m3048f(str))) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        int size = f6749a.size();
        for (int i = 0; i < size; i++) {
            Objects.requireNonNull(f6749a.get(i));
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m3050h(@Nullable String str) {
        return MediaStreamTrack.AUDIO_TRACK_KIND.equals(m3048f(str));
    }

    /* JADX INFO: renamed from: i */
    public static boolean m3051i(@Nullable String str) {
        return NotificationCompat.MessagingStyle.Message.KEY_TEXT.equals(m3048f(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    /* JADX INFO: renamed from: j */
    public static boolean m3052j(@Nullable String str) {
        return MediaStreamTrack.VIDEO_TRACK_KIND.equals(m3048f(str));
    }
}
