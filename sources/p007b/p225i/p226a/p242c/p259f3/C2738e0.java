package p007b.p225i.p226a.p242c.p259f3;

import android.app.UiModeManager;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.f3.e0 */
/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2738e0 {

    /* JADX INFO: renamed from: a */
    public static final int f6708a;

    /* JADX INFO: renamed from: b */
    public static final String f6709b;

    /* JADX INFO: renamed from: c */
    public static final String f6710c;

    /* JADX INFO: renamed from: d */
    public static final String f6711d;

    /* JADX INFO: renamed from: e */
    public static final String f6712e;

    /* JADX INFO: renamed from: f */
    public static final byte[] f6713f;

    /* JADX INFO: renamed from: g */
    public static final Pattern f6714g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public static HashMap<String, String> f6715h;

    /* JADX INFO: renamed from: i */
    public static final String[] f6716i;

    /* JADX INFO: renamed from: j */
    public static final String[] f6717j;

    /* JADX INFO: renamed from: k */
    public static final int[] f6718k;

    /* JADX INFO: renamed from: l */
    public static final int[] f6719l;

    static {
        int i = Build.VERSION.SDK_INT;
        f6708a = i;
        String str = Build.DEVICE;
        f6709b = str;
        String str2 = Build.MANUFACTURER;
        f6710c = str2;
        String str3 = Build.MODEL;
        f6711d = str3;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str2, C1643a.m841b(str3, C1643a.m841b(str, 17))), str, ", ", str3, ", ");
        sbM831S.append(str2);
        sbM831S.append(", ");
        sbM831S.append(i);
        f6712e = sbM831S.toString();
        f6713f = new byte[0];
        Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f6714g = Pattern.compile("%([A-Fa-f0-9]{2})");
        Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f6716i = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", ModelAuditLogEntry.CHANGE_KEY_ID, "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f6717j = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f6718k = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f6719l = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, Opcodes.MONITOREXIT, 202, 205, Opcodes.D2F, Opcodes.DCMPL, 158, 153, Opcodes.F2L, Opcodes.F2I, 130, Opcodes.I2L, Opcodes.JSR, 175, Opcodes.IF_ACMPNE, Opcodes.IF_ICMPLT, 180, Opcodes.PUTSTATIC, Opcodes.INVOKEDYNAMIC, Opcodes.ANEWARRAY, Opcodes.IFNONNULL, Opcodes.CHECKCAST, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, Opcodes.INVOKESPECIAL, Opcodes.ARETURN, Opcodes.INVOKEINTERFACE, Opcodes.ARRAYLENGTH, Opcodes.LOOKUPSWITCH, Opcodes.IRETURN, Opcodes.IF_ACMPEQ, Opcodes.IF_ICMPGE, Opcodes.D2L, Opcodes.L2I, Opcodes.LOR, Opcodes.I2F, Opcodes.I2S, Opcodes.LCMP, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, Opcodes.LUSHR, 122, Opcodes.L2F, Opcodes.D2I, Opcodes.I2D, 128, Opcodes.FCMPL, Opcodes.I2C, 155, 156, Opcodes.RETURN, Opcodes.INVOKEVIRTUAL, Opcodes.ATHROW, Opcodes.INVOKESTATIC, Opcodes.LRETURN, Opcodes.TABLESWITCH, Opcodes.IF_ICMPGT, Opcodes.IF_ICMPLE, 249, 254, 247, 240, 229, 226, 235, 236, Opcodes.INSTANCEOF, Opcodes.IFNULL, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, Opcodes.LAND, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, Opcodes.FRETURN, Opcodes.RET, Opcodes.IF_ICMPNE, Opcodes.GOTO, Opcodes.GETSTATIC, Opcodes.PUTFIELD, Opcodes.NEWARRAY, Opcodes.NEW, 150, Opcodes.I2B, Opcodes.DCMPG, Opcodes.IF_ICMPEQ, Opcodes.L2D, Opcodes.F2D, Opcodes.IINC, Opcodes.LXOR, 222, 217, 208, 215, Opcodes.MONITORENTER, Opcodes.MULTIANEWARRAY, 204, 203, 230, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 232, 239, 250, 253, 244, 243};
    }

    /* JADX INFO: renamed from: A */
    public static boolean m2980A(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    /* JADX INFO: renamed from: B */
    public static long m2981B(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    /* JADX INFO: renamed from: C */
    public static String m2982C(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strM4349u1 = C3404f.m4349u1(str);
        int i = 0;
        String str2 = m2988I(strM4349u1, "-")[0];
        if (f6715h == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            HashMap<String, String> map = new HashMap<>(iSOLanguages.length + f6716i.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        map.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            int i2 = 0;
            while (true) {
                String[] strArr = f6716i;
                if (i2 >= strArr.length) {
                    break;
                }
                map.put(strArr[i2], strArr[i2 + 1]);
                i2 += 2;
            }
            f6715h = map;
        }
        String str4 = f6715h.get(str2);
        if (str4 != null) {
            String strValueOf = String.valueOf(strM4349u1.substring(str2.length()));
            strM4349u1 = strValueOf.length() != 0 ? str4.concat(strValueOf) : new String(str4);
            str2 = str4;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return strM4349u1;
        }
        while (true) {
            String[] strArr2 = f6717j;
            if (i >= strArr2.length) {
                return strM4349u1;
            }
            if (strM4349u1.startsWith(strArr2[i])) {
                String strValueOf2 = String.valueOf(strArr2[i + 1]);
                String strValueOf3 = String.valueOf(strM4349u1.substring(strArr2[i].length()));
                return strValueOf3.length() != 0 ? strValueOf2.concat(strValueOf3) : new String(strValueOf2);
            }
            i += 2;
        }
    }

    /* JADX INFO: renamed from: D */
    public static <T> T[] m2983D(T[] tArr, int i) {
        C1460d.m531j(i <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i);
    }

    /* JADX INFO: renamed from: E */
    public static boolean m2984E(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    /* JADX INFO: renamed from: F */
    public static long m2985F(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return (j2 / j3) * j;
        }
        return (long) (j * (j2 / j3));
    }

    /* JADX INFO: renamed from: G */
    public static void m2986G(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
            return;
        }
        if (j2 >= j || j % j2 != 0) {
            double d = j / j2;
            while (i < jArr.length) {
                jArr[i] = (long) (jArr[i] * d);
                i++;
            }
            return;
        }
        long j4 = j / j2;
        while (i < jArr.length) {
            jArr[i] = jArr[i] * j4;
            i++;
        }
    }

    /* JADX INFO: renamed from: H */
    public static String[] m2987H(String str, String str2) {
        return str.split(str2, -1);
    }

    /* JADX INFO: renamed from: I */
    public static String[] m2988I(String str, String str2) {
        return str.split(str2, 2);
    }

    /* JADX INFO: renamed from: J */
    public static boolean m2989J(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    /* JADX INFO: renamed from: K */
    public static byte[] m2990K(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX INFO: renamed from: L */
    public static long m2991L(int i) {
        return ((long) i) & 4294967295L;
    }

    /* JADX INFO: renamed from: M */
    public static long m2992M(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2993a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX INFO: renamed from: b */
    public static int m2994b(long[] jArr, long j, boolean z2, boolean z3) {
        int i;
        int iBinarySearch = Arrays.binarySearch(jArr, j);
        if (iBinarySearch < 0) {
            i = ~iBinarySearch;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[iBinarySearch] == j);
            i = z2 ? iBinarySearch - 1 : iBinarySearch;
        }
        return z3 ? Math.min(jArr.length - 1, i) : i;
    }

    /* JADX INFO: renamed from: c */
    public static int m2995c(C2751r c2751r, long j, boolean z2, boolean z3) {
        int i;
        int i2 = c2751r.f6747a - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            if (c2751r.m3042b(i4) < j) {
                i3 = i4 + 1;
            } else {
                i2 = i4 - 1;
            }
        }
        if (z2 && (i = i2 + 1) < c2751r.f6747a && c2751r.m3042b(i) == j) {
            return i;
        }
        if (z3 && i2 == -1) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: renamed from: d */
    public static int m2996d(int[] iArr, int i, boolean z2, boolean z3) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(iArr, i);
        if (iBinarySearch < 0) {
            i2 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (iArr[iBinarySearch] == i);
            i2 = z2 ? iBinarySearch + 1 : iBinarySearch;
        }
        return z3 ? Math.max(0, i2) : i2;
    }

    /* JADX INFO: renamed from: e */
    public static int m2997e(long[] jArr, long j, boolean z2, boolean z3) {
        int i;
        int iBinarySearch = Arrays.binarySearch(jArr, j);
        if (iBinarySearch < 0) {
            i = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (jArr[iBinarySearch] == j);
            i = z2 ? iBinarySearch + 1 : iBinarySearch;
        }
        return z3 ? Math.max(0, i) : i;
    }

    /* JADX INFO: renamed from: f */
    public static int m2998f(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    /* JADX INFO: renamed from: g */
    public static float m2999g(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    /* JADX INFO: renamed from: h */
    public static int m3000h(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    /* JADX INFO: renamed from: i */
    public static long m3001i(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    /* JADX INFO: renamed from: j */
    public static Handler m3002j() {
        Looper looperMyLooper = Looper.myLooper();
        C1460d.m438H(looperMyLooper);
        return new Handler(looperMyLooper, null);
    }

    /* JADX INFO: renamed from: k */
    public static String m3003k(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* JADX INFO: renamed from: l */
    public static String m3004l(byte[] bArr) {
        return new String(bArr, C4483c.f11945c);
    }

    /* JADX INFO: renamed from: m */
    public static String m3005m(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, C4483c.f11945c);
    }

    /* JADX INFO: renamed from: n */
    public static int m3006n(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i2 = f6708a;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: o */
    public static Looper m3007o() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    /* JADX INFO: renamed from: p */
    public static int m3008p(int i) {
        if (i == 2 || i == 4) {
            return 6005;
        }
        if (i == 10) {
            return 6004;
        }
        if (i == 7) {
            return 6005;
        }
        if (i == 8) {
            return 6003;
        }
        switch (i) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    /* JADX INFO: renamed from: q */
    public static long m3009q(long j, float f) {
        return f == 1.0f ? j : Math.round(j * ((double) f));
    }

    /* JADX INFO: renamed from: r */
    public static int m3010r(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i != 24) {
            return i != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    /* JADX INFO: renamed from: s */
    public static int m3011s(int i, int i2) {
        if (i != 2) {
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                if (i != 268435456) {
                    if (i == 536870912) {
                        return i2 * 3;
                    }
                    if (i != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i2 * 4;
        }
        return i2 * 2;
    }

    /* JADX INFO: renamed from: t */
    public static int m3012t(int i) {
        if (i == 13) {
            return 1;
        }
        switch (i) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    /* JADX INFO: renamed from: u */
    public static String m3013u(StringBuilder sb, Formatter formatter, long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        String str = j < 0 ? "-" : "";
        long jAbs = (Math.abs(j) + 500) / 1000;
        long j2 = jAbs % 60;
        long j3 = (jAbs / 60) % 60;
        long j4 = jAbs / 3600;
        sb.setLength(0);
        return j4 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j3), Long.valueOf(j2)).toString();
    }

    @Nullable
    /* JADX INFO: renamed from: v */
    public static String m3014v(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            C2750q.m3039b("Util", str.length() != 0 ? "Failed to read system property ".concat(str) : new String("Failed to read system property "), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: w */
    public static byte[] m3015w(String str) {
        return str.getBytes(C4483c.f11945c);
    }

    /* JADX INFO: renamed from: x */
    public static boolean m3016x(C2757x c2757x, C2757x c2757x2, @Nullable Inflater inflater) {
        if (c2757x.m3081a() <= 0) {
            return false;
        }
        if (c2757x2.f6793a.length < c2757x.m3081a()) {
            c2757x2.m3082b(c2757x.m3081a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(c2757x.f6793a, c2757x.f6794b, c2757x.m3081a());
        int iInflate = 0;
        while (true) {
            try {
                byte[] bArr = c2757x2.f6793a;
                iInflate += inflater.inflate(bArr, iInflate, bArr.length - iInflate);
                if (inflater.finished()) {
                    c2757x2.m3078D(iInflate);
                    inflater.reset();
                    return true;
                }
                if (!inflater.needsDictionary() && !inflater.needsInput()) {
                    byte[] bArr2 = c2757x2.f6793a;
                    if (iInflate == bArr2.length) {
                        c2757x2.m3082b(bArr2.length * 2);
                    }
                }
                inflater.reset();
                return false;
            } catch (DataFormatException unused) {
                inflater.reset();
                return false;
            } catch (Throwable th) {
                inflater.reset();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public static boolean m3017y(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    /* JADX INFO: renamed from: z */
    public static boolean m3018z(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }
}
