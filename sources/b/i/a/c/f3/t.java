package b.i.a.c.f3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.objectweb.asm.Opcodes;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: MimeTypes.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static final ArrayList<t$a> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f976b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean a(@Nullable String str, @Nullable String str2) {
        t$b t_bE;
        int iA;
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
                return (str2 == null || (t_bE = e(str2)) == null || (iA = t_bE.a()) == 0 || iA == 16) ? false : true;
            default:
                return false;
        }
    }

    public static int b(String str, @Nullable String str2) {
        t$b t_bE;
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (t_bE = e(str2)) == null) {
                    return 0;
                }
                return t_bE.a();
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
    public static String c(@Nullable String str) {
        t$b t_bE;
        String strD = null;
        if (str == null) {
            return null;
        }
        String strU1 = b.i.a.f.e.o.f.u1(str.trim());
        if (strU1.startsWith("avc1") || strU1.startsWith("avc3")) {
            return "video/avc";
        }
        if (strU1.startsWith("hev1") || strU1.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (strU1.startsWith("dvav") || strU1.startsWith("dva1") || strU1.startsWith("dvhe") || strU1.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (strU1.startsWith("av01")) {
            return "video/av01";
        }
        if (strU1.startsWith("vp9") || strU1.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (strU1.startsWith("vp8") || strU1.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (strU1.startsWith("mp4a")) {
            if (strU1.startsWith("mp4a.") && (t_bE = e(strU1)) != null) {
                strD = d(t_bE.a);
            }
            return strD == null ? "audio/mp4a-latm" : strD;
        }
        if (strU1.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (strU1.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (strU1.startsWith("ac-3") || strU1.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (strU1.startsWith("ec-3") || strU1.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (strU1.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (strU1.startsWith("ac-4") || strU1.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (strU1.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (strU1.startsWith("dtse")) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (strU1.startsWith("dtsh") || strU1.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (strU1.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (strU1.startsWith("opus")) {
            return "audio/opus";
        }
        if (strU1.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (strU1.startsWith("flac")) {
            return "audio/flac";
        }
        if (strU1.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (strU1.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (strU1.contains("cea708")) {
            return "application/cea-708";
        }
        if (strU1.contains("eia608") || strU1.contains("cea608")) {
            return "application/cea-608";
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Objects.requireNonNull(a.get(i));
            if (strU1.startsWith(null)) {
                break;
            }
        }
        return null;
    }

    @Nullable
    public static String d(int i) {
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
    public static t$b e(String str) {
        Matcher matcher = f976b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        Objects.requireNonNull(strGroup);
        String strGroup2 = matcher.group(2);
        try {
            return new t$b(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String f(@Nullable String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int g(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (h(str)) {
            return 1;
        }
        if (j(str)) {
            return 2;
        }
        if (i(str)) {
            return 3;
        }
        if ("image".equals(f(str))) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Objects.requireNonNull(a.get(i));
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    public static boolean h(@Nullable String str) {
        return MediaStreamTrack.AUDIO_TRACK_KIND.equals(f(str));
    }

    public static boolean i(@Nullable String str) {
        return NotificationCompat$MessagingStyle$Message.KEY_TEXT.equals(f(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean j(@Nullable String str) {
        return MediaStreamTrack.VIDEO_TRACK_KIND.equals(f(str));
    }
}
