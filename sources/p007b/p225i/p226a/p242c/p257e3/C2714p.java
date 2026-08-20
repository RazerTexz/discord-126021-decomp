package p007b.p225i.p226a.p242c.p257e3;

import android.content.Context;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.api.permission.Permission;
import com.discord.stores.StoreGuildScheduledEvents;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2749p;
import p007b.p225i.p226a.p242c.p259f3.C2755v;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p226a.p242c.p262s2.InterfaceC2871h1;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.AbstractC4525q;

/* JADX INFO: renamed from: b.i.a.c.e3.p */
/* JADX INFO: compiled from: DefaultBandwidthMeter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2714p implements InterfaceC2704f, InterfaceC2680a0 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC4523p<Long> f6569a = AbstractC4523p.m6267v(5400000L, 3300000L, 2000000L, 1300000L, 760000L);

    /* JADX INFO: renamed from: b */
    public static final AbstractC4523p<Long> f6570b = AbstractC4523p.m6267v(1700000L, 820000L, 450000L, 180000L, 130000L);

    /* JADX INFO: renamed from: c */
    public static final AbstractC4523p<Long> f6571c = AbstractC4523p.m6267v(2300000L, 1300000L, 1000000L, 820000L, 570000L);

    /* JADX INFO: renamed from: d */
    public static final AbstractC4523p<Long> f6572d = AbstractC4523p.m6267v(3400000L, 2000000L, 1400000L, 1000000L, 620000L);

    /* JADX INFO: renamed from: e */
    public static final AbstractC4523p<Long> f6573e = AbstractC4523p.m6267v(7500000L, 5200000L, 3700000L, Long.valueOf(StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD), 1100000L);

    /* JADX INFO: renamed from: f */
    public static final AbstractC4523p<Long> f6574f = AbstractC4523p.m6267v(3300000L, 1900000L, 1700000L, 1500000L, 1200000L);

    /* JADX INFO: renamed from: g */
    @Nullable
    public static C2714p f6575g;

    /* JADX INFO: renamed from: h */
    public final AbstractC4525q<Integer, Long> f6576h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC2704f.a.C13224a f6577i = new InterfaceC2704f.a.C13224a();

    /* JADX INFO: renamed from: j */
    public final C2722x f6578j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC2740g f6579k;

    /* JADX INFO: renamed from: l */
    public final boolean f6580l;

    /* JADX INFO: renamed from: m */
    public int f6581m;

    /* JADX INFO: renamed from: n */
    public long f6582n;

    /* JADX INFO: renamed from: o */
    public long f6583o;

    /* JADX INFO: renamed from: p */
    public int f6584p;

    /* JADX INFO: renamed from: q */
    public long f6585q;

    /* JADX INFO: renamed from: r */
    public long f6586r;

    /* JADX INFO: renamed from: s */
    public long f6587s;

    /* JADX INFO: renamed from: t */
    public long f6588t;

    /* JADX INFO: renamed from: b.i.a.c.e3.p$b */
    /* JADX INFO: compiled from: DefaultBandwidthMeter.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        @Nullable
        public final Context f6589a;

        /* JADX INFO: renamed from: b */
        public Map<Integer, Long> f6590b;

        /* JADX INFO: renamed from: c */
        public int f6591c;

        /* JADX INFO: renamed from: d */
        public InterfaceC2740g f6592d;

        /* JADX INFO: renamed from: e */
        public boolean f6593e;

        /* JADX WARN: Code duplicated, block: B:13:0x002e  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public b(Context context) {
            String strM4357w1;
            int[] iArr;
            TelephonyManager telephonyManager;
            this.f6589a = context == null ? null : context.getApplicationContext();
            int i = C2738e0.f6708a;
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                strM4357w1 = C3404f.m4357w1(Locale.getDefault().getCountry());
            } else {
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (TextUtils.isEmpty(networkCountryIso)) {
                    strM4357w1 = C3404f.m4357w1(Locale.getDefault().getCountry());
                } else {
                    strM4357w1 = C3404f.m4357w1(networkCountryIso);
                }
            }
            AbstractC4523p<Long> abstractC4523p = C2714p.f6569a;
            strM4357w1.hashCode();
            byte b2 = -1;
            switch (strM4357w1.hashCode()) {
                case 2083:
                    if (strM4357w1.equals("AD")) {
                        b2 = 0;
                    }
                    break;
                case 2084:
                    if (strM4357w1.equals("AE")) {
                        b2 = 1;
                    }
                    break;
                case 2085:
                    if (strM4357w1.equals("AF")) {
                        b2 = 2;
                    }
                    break;
                case 2086:
                    if (strM4357w1.equals("AG")) {
                        b2 = 3;
                    }
                    break;
                case 2088:
                    if (strM4357w1.equals("AI")) {
                        b2 = 4;
                    }
                    break;
                case 2091:
                    if (strM4357w1.equals("AL")) {
                        b2 = 5;
                    }
                    break;
                case 2092:
                    if (strM4357w1.equals("AM")) {
                        b2 = 6;
                    }
                    break;
                case 2094:
                    if (strM4357w1.equals("AO")) {
                        b2 = 7;
                    }
                    break;
                case 2096:
                    if (strM4357w1.equals("AQ")) {
                        b2 = 8;
                    }
                    break;
                case 2097:
                    if (strM4357w1.equals("AR")) {
                        b2 = 9;
                    }
                    break;
                case 2098:
                    if (strM4357w1.equals("AS")) {
                        b2 = 10;
                    }
                    break;
                case 2099:
                    if (strM4357w1.equals("AT")) {
                        b2 = 11;
                    }
                    break;
                case 2100:
                    if (strM4357w1.equals("AU")) {
                        b2 = 12;
                    }
                    break;
                case 2102:
                    if (strM4357w1.equals("AW")) {
                        b2 = 13;
                    }
                    break;
                case 2103:
                    if (strM4357w1.equals("AX")) {
                        b2 = 14;
                    }
                    break;
                case 2105:
                    if (strM4357w1.equals("AZ")) {
                        b2 = 15;
                    }
                    break;
                case 2111:
                    if (strM4357w1.equals("BA")) {
                        b2 = 16;
                    }
                    break;
                case 2112:
                    if (strM4357w1.equals("BB")) {
                        b2 = 17;
                    }
                    break;
                case 2114:
                    if (strM4357w1.equals("BD")) {
                        b2 = 18;
                    }
                    break;
                case 2115:
                    if (strM4357w1.equals("BE")) {
                        b2 = 19;
                    }
                    break;
                case 2116:
                    if (strM4357w1.equals("BF")) {
                        b2 = 20;
                    }
                    break;
                case 2117:
                    if (strM4357w1.equals("BG")) {
                        b2 = 21;
                    }
                    break;
                case 2118:
                    if (strM4357w1.equals("BH")) {
                        b2 = 22;
                    }
                    break;
                case 2119:
                    if (strM4357w1.equals("BI")) {
                        b2 = 23;
                    }
                    break;
                case 2120:
                    if (strM4357w1.equals("BJ")) {
                        b2 = 24;
                    }
                    break;
                case 2122:
                    if (strM4357w1.equals("BL")) {
                        b2 = 25;
                    }
                    break;
                case 2123:
                    if (strM4357w1.equals("BM")) {
                        b2 = 26;
                    }
                    break;
                case 2124:
                    if (strM4357w1.equals("BN")) {
                        b2 = 27;
                    }
                    break;
                case 2125:
                    if (strM4357w1.equals("BO")) {
                        b2 = 28;
                    }
                    break;
                case 2127:
                    if (strM4357w1.equals("BQ")) {
                        b2 = 29;
                    }
                    break;
                case 2128:
                    if (strM4357w1.equals("BR")) {
                        b2 = 30;
                    }
                    break;
                case 2129:
                    if (strM4357w1.equals("BS")) {
                        b2 = 31;
                    }
                    break;
                case 2130:
                    if (strM4357w1.equals("BT")) {
                        b2 = 32;
                    }
                    break;
                case 2133:
                    if (strM4357w1.equals("BW")) {
                        b2 = 33;
                    }
                    break;
                case 2135:
                    if (strM4357w1.equals("BY")) {
                        b2 = 34;
                    }
                    break;
                case 2136:
                    if (strM4357w1.equals("BZ")) {
                        b2 = 35;
                    }
                    break;
                case 2142:
                    if (strM4357w1.equals("CA")) {
                        b2 = 36;
                    }
                    break;
                case 2145:
                    if (strM4357w1.equals("CD")) {
                        b2 = 37;
                    }
                    break;
                case 2147:
                    if (strM4357w1.equals("CF")) {
                        b2 = 38;
                    }
                    break;
                case 2148:
                    if (strM4357w1.equals("CG")) {
                        b2 = 39;
                    }
                    break;
                case 2149:
                    if (strM4357w1.equals("CH")) {
                        b2 = 40;
                    }
                    break;
                case 2150:
                    if (strM4357w1.equals("CI")) {
                        b2 = 41;
                    }
                    break;
                case 2152:
                    if (strM4357w1.equals("CK")) {
                        b2 = ExifInterface.START_CODE;
                    }
                    break;
                case 2153:
                    if (strM4357w1.equals("CL")) {
                        b2 = 43;
                    }
                    break;
                case 2154:
                    if (strM4357w1.equals("CM")) {
                        b2 = 44;
                    }
                    break;
                case 2155:
                    if (strM4357w1.equals("CN")) {
                        b2 = 45;
                    }
                    break;
                case 2156:
                    if (strM4357w1.equals("CO")) {
                        b2 = 46;
                    }
                    break;
                case 2159:
                    if (strM4357w1.equals("CR")) {
                        b2 = 47;
                    }
                    break;
                case 2162:
                    if (strM4357w1.equals("CU")) {
                        b2 = 48;
                    }
                    break;
                case 2163:
                    if (strM4357w1.equals("CV")) {
                        b2 = 49;
                    }
                    break;
                case 2164:
                    if (strM4357w1.equals("CW")) {
                        b2 = 50;
                    }
                    break;
                case 2165:
                    if (strM4357w1.equals("CX")) {
                        b2 = 51;
                    }
                    break;
                case 2166:
                    if (strM4357w1.equals("CY")) {
                        b2 = 52;
                    }
                    break;
                case 2167:
                    if (strM4357w1.equals("CZ")) {
                        b2 = 53;
                    }
                    break;
                case 2177:
                    if (strM4357w1.equals("DE")) {
                        b2 = 54;
                    }
                    break;
                case 2182:
                    if (strM4357w1.equals("DJ")) {
                        b2 = 55;
                    }
                    break;
                case 2183:
                    if (strM4357w1.equals("DK")) {
                        b2 = 56;
                    }
                    break;
                case 2185:
                    if (strM4357w1.equals("DM")) {
                        b2 = 57;
                    }
                    break;
                case 2187:
                    if (strM4357w1.equals("DO")) {
                        b2 = 58;
                    }
                    break;
                case 2198:
                    if (strM4357w1.equals("DZ")) {
                        b2 = 59;
                    }
                    break;
                case 2206:
                    if (strM4357w1.equals("EC")) {
                        b2 = 60;
                    }
                    break;
                case 2208:
                    if (strM4357w1.equals("EE")) {
                        b2 = 61;
                    }
                    break;
                case 2210:
                    if (strM4357w1.equals("EG")) {
                        b2 = 62;
                    }
                    break;
                case 2221:
                    if (strM4357w1.equals("ER")) {
                        b2 = 63;
                    }
                    break;
                case 2222:
                    if (strM4357w1.equals("ES")) {
                        b2 = 64;
                    }
                    break;
                case 2223:
                    if (strM4357w1.equals("ET")) {
                        b2 = 65;
                    }
                    break;
                case 2243:
                    if (strM4357w1.equals("FI")) {
                        b2 = 66;
                    }
                    break;
                case 2244:
                    if (strM4357w1.equals("FJ")) {
                        b2 = 67;
                    }
                    break;
                case 2245:
                    if (strM4357w1.equals("FK")) {
                        b2 = 68;
                    }
                    break;
                case 2247:
                    if (strM4357w1.equals("FM")) {
                        b2 = 69;
                    }
                    break;
                case 2249:
                    if (strM4357w1.equals("FO")) {
                        b2 = 70;
                    }
                    break;
                case 2252:
                    if (strM4357w1.equals("FR")) {
                        b2 = 71;
                    }
                    break;
                case 2266:
                    if (strM4357w1.equals("GA")) {
                        b2 = 72;
                    }
                    break;
                case 2267:
                    if (strM4357w1.equals("GB")) {
                        b2 = 73;
                    }
                    break;
                case 2269:
                    if (strM4357w1.equals("GD")) {
                        b2 = 74;
                    }
                    break;
                case 2270:
                    if (strM4357w1.equals("GE")) {
                        b2 = 75;
                    }
                    break;
                case 2271:
                    if (strM4357w1.equals("GF")) {
                        b2 = 76;
                    }
                    break;
                case 2272:
                    if (strM4357w1.equals("GG")) {
                        b2 = 77;
                    }
                    break;
                case 2273:
                    if (strM4357w1.equals("GH")) {
                        b2 = 78;
                    }
                    break;
                case 2274:
                    if (strM4357w1.equals("GI")) {
                        b2 = 79;
                    }
                    break;
                case 2277:
                    if (strM4357w1.equals("GL")) {
                        b2 = 80;
                    }
                    break;
                case 2278:
                    if (strM4357w1.equals("GM")) {
                        b2 = 81;
                    }
                    break;
                case 2279:
                    if (strM4357w1.equals("GN")) {
                        b2 = 82;
                    }
                    break;
                case 2281:
                    if (strM4357w1.equals("GP")) {
                        b2 = 83;
                    }
                    break;
                case 2282:
                    if (strM4357w1.equals("GQ")) {
                        b2 = 84;
                    }
                    break;
                case 2283:
                    if (strM4357w1.equals("GR")) {
                        b2 = 85;
                    }
                    break;
                case 2285:
                    if (strM4357w1.equals("GT")) {
                        b2 = 86;
                    }
                    break;
                case 2286:
                    if (strM4357w1.equals("GU")) {
                        b2 = 87;
                    }
                    break;
                case 2288:
                    if (strM4357w1.equals("GW")) {
                        b2 = 88;
                    }
                    break;
                case 2290:
                    if (strM4357w1.equals("GY")) {
                        b2 = 89;
                    }
                    break;
                case 2307:
                    if (strM4357w1.equals("HK")) {
                        b2 = 90;
                    }
                    break;
                case 2310:
                    if (strM4357w1.equals("HN")) {
                        b2 = 91;
                    }
                    break;
                case 2314:
                    if (strM4357w1.equals("HR")) {
                        b2 = 92;
                    }
                    break;
                case 2316:
                    if (strM4357w1.equals("HT")) {
                        b2 = 93;
                    }
                    break;
                case 2317:
                    if (strM4357w1.equals("HU")) {
                        b2 = 94;
                    }
                    break;
                case 2331:
                    if (strM4357w1.equals("ID")) {
                        b2 = 95;
                    }
                    break;
                case 2332:
                    if (strM4357w1.equals("IE")) {
                        b2 = 96;
                    }
                    break;
                case 2339:
                    if (strM4357w1.equals("IL")) {
                        b2 = 97;
                    }
                    break;
                case 2340:
                    if (strM4357w1.equals("IM")) {
                        b2 = 98;
                    }
                    break;
                case 2341:
                    if (strM4357w1.equals("IN")) {
                        b2 = 99;
                    }
                    break;
                case 2342:
                    if (strM4357w1.equals("IO")) {
                        b2 = 100;
                    }
                    break;
                case 2344:
                    if (strM4357w1.equals("IQ")) {
                        b2 = 101;
                    }
                    break;
                case 2345:
                    if (strM4357w1.equals("IR")) {
                        b2 = 102;
                    }
                    break;
                case 2346:
                    if (strM4357w1.equals("IS")) {
                        b2 = 103;
                    }
                    break;
                case 2347:
                    if (strM4357w1.equals("IT")) {
                        b2 = 104;
                    }
                    break;
                case 2363:
                    if (strM4357w1.equals("JE")) {
                        b2 = 105;
                    }
                    break;
                case 2371:
                    if (strM4357w1.equals("JM")) {
                        b2 = 106;
                    }
                    break;
                case 2373:
                    if (strM4357w1.equals("JO")) {
                        b2 = 107;
                    }
                    break;
                case 2374:
                    if (strM4357w1.equals("JP")) {
                        b2 = 108;
                    }
                    break;
                case 2394:
                    if (strM4357w1.equals("KE")) {
                        b2 = 109;
                    }
                    break;
                case 2396:
                    if (strM4357w1.equals("KG")) {
                        b2 = 110;
                    }
                    break;
                case 2397:
                    if (strM4357w1.equals("KH")) {
                        b2 = 111;
                    }
                    break;
                case 2398:
                    if (strM4357w1.equals("KI")) {
                        b2 = 112;
                    }
                    break;
                case 2402:
                    if (strM4357w1.equals("KM")) {
                        b2 = 113;
                    }
                    break;
                case 2405:
                    if (strM4357w1.equals("KP")) {
                        b2 = 114;
                    }
                    break;
                case 2407:
                    if (strM4357w1.equals("KR")) {
                        b2 = 115;
                    }
                    break;
                case 2412:
                    if (strM4357w1.equals("KW")) {
                        b2 = 116;
                    }
                    break;
                case 2414:
                    if (strM4357w1.equals("KY")) {
                        b2 = 117;
                    }
                    break;
                case 2415:
                    if (strM4357w1.equals("KZ")) {
                        b2 = 118;
                    }
                    break;
                case 2421:
                    if (strM4357w1.equals("LA")) {
                        b2 = 119;
                    }
                    break;
                case 2422:
                    if (strM4357w1.equals("LB")) {
                        b2 = 120;
                    }
                    break;
                case 2423:
                    if (strM4357w1.equals("LC")) {
                        b2 = 121;
                    }
                    break;
                case 2429:
                    if (strM4357w1.equals("LI")) {
                        b2 = 122;
                    }
                    break;
                case 2431:
                    if (strM4357w1.equals("LK")) {
                        b2 = 123;
                    }
                    break;
                case 2438:
                    if (strM4357w1.equals("LR")) {
                        b2 = 124;
                    }
                    break;
                case 2439:
                    if (strM4357w1.equals("LS")) {
                        b2 = 125;
                    }
                    break;
                case 2440:
                    if (strM4357w1.equals("LT")) {
                        b2 = 126;
                    }
                    break;
                case 2441:
                    if (strM4357w1.equals("LU")) {
                        b2 = 127;
                    }
                    break;
                case 2442:
                    if (strM4357w1.equals("LV")) {
                        b2 = 128;
                    }
                    break;
                case 2445:
                    if (strM4357w1.equals("LY")) {
                        b2 = 129;
                    }
                    break;
                case 2452:
                    if (strM4357w1.equals("MA")) {
                        b2 = 130;
                    }
                    break;
                case 2454:
                    if (strM4357w1.equals("MC")) {
                        b2 = 131;
                    }
                    break;
                case 2455:
                    if (strM4357w1.equals("MD")) {
                        b2 = 132;
                    }
                    break;
                case 2456:
                    if (strM4357w1.equals("ME")) {
                        b2 = 133;
                    }
                    break;
                case 2457:
                    if (strM4357w1.equals("MF")) {
                        b2 = 134;
                    }
                    break;
                case 2458:
                    if (strM4357w1.equals("MG")) {
                        b2 = 135;
                    }
                    break;
                case 2459:
                    if (strM4357w1.equals("MH")) {
                        b2 = 136;
                    }
                    break;
                case 2462:
                    if (strM4357w1.equals("MK")) {
                        b2 = 137;
                    }
                    break;
                case 2463:
                    if (strM4357w1.equals("ML")) {
                        b2 = 138;
                    }
                    break;
                case 2464:
                    if (strM4357w1.equals("MM")) {
                        b2 = 139;
                    }
                    break;
                case 2465:
                    if (strM4357w1.equals("MN")) {
                        b2 = 140;
                    }
                    break;
                case 2466:
                    if (strM4357w1.equals("MO")) {
                        b2 = 141;
                    }
                    break;
                case 2467:
                    if (strM4357w1.equals("MP")) {
                        b2 = 142;
                    }
                    break;
                case 2468:
                    if (strM4357w1.equals("MQ")) {
                        b2 = 143;
                    }
                    break;
                case 2469:
                    if (strM4357w1.equals("MR")) {
                        b2 = 144;
                    }
                    break;
                case 2470:
                    if (strM4357w1.equals("MS")) {
                        b2 = 145;
                    }
                    break;
                case 2471:
                    if (strM4357w1.equals("MT")) {
                        b2 = 146;
                    }
                    break;
                case 2472:
                    if (strM4357w1.equals("MU")) {
                        b2 = 147;
                    }
                    break;
                case 2473:
                    if (strM4357w1.equals("MV")) {
                        b2 = 148;
                    }
                    break;
                case 2474:
                    if (strM4357w1.equals("MW")) {
                        b2 = 149;
                    }
                    break;
                case 2475:
                    if (strM4357w1.equals("MX")) {
                        b2 = 150;
                    }
                    break;
                case 2476:
                    if (strM4357w1.equals("MY")) {
                        b2 = 151;
                    }
                    break;
                case 2477:
                    if (strM4357w1.equals("MZ")) {
                        b2 = 152;
                    }
                    break;
                case 2483:
                    if (strM4357w1.equals("NA")) {
                        b2 = 153;
                    }
                    break;
                case 2485:
                    if (strM4357w1.equals("NC")) {
                        b2 = 154;
                    }
                    break;
                case 2487:
                    if (strM4357w1.equals("NE")) {
                        b2 = 155;
                    }
                    break;
                case 2489:
                    if (strM4357w1.equals("NG")) {
                        b2 = 156;
                    }
                    break;
                case 2491:
                    if (strM4357w1.equals("NI")) {
                        b2 = 157;
                    }
                    break;
                case 2494:
                    if (strM4357w1.equals("NL")) {
                        b2 = 158;
                    }
                    break;
                case 2497:
                    if (strM4357w1.equals("NO")) {
                        b2 = 159;
                    }
                    break;
                case 2498:
                    if (strM4357w1.equals("NP")) {
                        b2 = 160;
                    }
                    break;
                case 2500:
                    if (strM4357w1.equals("NR")) {
                        b2 = 161;
                    }
                    break;
                case 2503:
                    if (strM4357w1.equals("NU")) {
                        b2 = 162;
                    }
                    break;
                case 2508:
                    if (strM4357w1.equals("NZ")) {
                        b2 = 163;
                    }
                    break;
                case 2526:
                    if (strM4357w1.equals("OM")) {
                        b2 = 164;
                    }
                    break;
                case 2545:
                    if (strM4357w1.equals("PA")) {
                        b2 = 165;
                    }
                    break;
                case 2549:
                    if (strM4357w1.equals("PE")) {
                        b2 = 166;
                    }
                    break;
                case 2550:
                    if (strM4357w1.equals("PF")) {
                        b2 = 167;
                    }
                    break;
                case 2551:
                    if (strM4357w1.equals("PG")) {
                        b2 = 168;
                    }
                    break;
                case 2552:
                    if (strM4357w1.equals("PH")) {
                        b2 = 169;
                    }
                    break;
                case 2555:
                    if (strM4357w1.equals("PK")) {
                        b2 = 170;
                    }
                    break;
                case 2556:
                    if (strM4357w1.equals("PL")) {
                        b2 = 171;
                    }
                    break;
                case 2557:
                    if (strM4357w1.equals("PM")) {
                        b2 = 172;
                    }
                    break;
                case 2562:
                    if (strM4357w1.equals("PR")) {
                        b2 = 173;
                    }
                    break;
                case 2563:
                    if (strM4357w1.equals("PS")) {
                        b2 = 174;
                    }
                    break;
                case 2564:
                    if (strM4357w1.equals("PT")) {
                        b2 = 175;
                    }
                    break;
                case 2567:
                    if (strM4357w1.equals("PW")) {
                        b2 = 176;
                    }
                    break;
                case 2569:
                    if (strM4357w1.equals("PY")) {
                        b2 = 177;
                    }
                    break;
                case 2576:
                    if (strM4357w1.equals("QA")) {
                        b2 = 178;
                    }
                    break;
                case 2611:
                    if (strM4357w1.equals("RE")) {
                        b2 = 179;
                    }
                    break;
                case 2621:
                    if (strM4357w1.equals("RO")) {
                        b2 = 180;
                    }
                    break;
                case 2625:
                    if (strM4357w1.equals("RS")) {
                        b2 = 181;
                    }
                    break;
                case 2627:
                    if (strM4357w1.equals("RU")) {
                        b2 = 182;
                    }
                    break;
                case 2629:
                    if (strM4357w1.equals("RW")) {
                        b2 = 183;
                    }
                    break;
                case 2638:
                    if (strM4357w1.equals("SA")) {
                        b2 = 184;
                    }
                    break;
                case 2639:
                    if (strM4357w1.equals("SB")) {
                        b2 = 185;
                    }
                    break;
                case 2640:
                    if (strM4357w1.equals("SC")) {
                        b2 = 186;
                    }
                    break;
                case 2641:
                    if (strM4357w1.equals("SD")) {
                        b2 = 187;
                    }
                    break;
                case 2642:
                    if (strM4357w1.equals("SE")) {
                        b2 = 188;
                    }
                    break;
                case 2644:
                    if (strM4357w1.equals("SG")) {
                        b2 = 189;
                    }
                    break;
                case 2645:
                    if (strM4357w1.equals("SH")) {
                        b2 = 190;
                    }
                    break;
                case 2646:
                    if (strM4357w1.equals("SI")) {
                        b2 = 191;
                    }
                    break;
                case 2647:
                    if (strM4357w1.equals("SJ")) {
                        b2 = 192;
                    }
                    break;
                case 2648:
                    if (strM4357w1.equals("SK")) {
                        b2 = 193;
                    }
                    break;
                case 2649:
                    if (strM4357w1.equals("SL")) {
                        b2 = 194;
                    }
                    break;
                case 2650:
                    if (strM4357w1.equals("SM")) {
                        b2 = 195;
                    }
                    break;
                case 2651:
                    if (strM4357w1.equals("SN")) {
                        b2 = 196;
                    }
                    break;
                case 2652:
                    if (strM4357w1.equals("SO")) {
                        b2 = 197;
                    }
                    break;
                case 2655:
                    if (strM4357w1.equals("SR")) {
                        b2 = 198;
                    }
                    break;
                case 2656:
                    if (strM4357w1.equals("SS")) {
                        b2 = 199;
                    }
                    break;
                case 2657:
                    if (strM4357w1.equals("ST")) {
                        b2 = 200;
                    }
                    break;
                case 2659:
                    if (strM4357w1.equals("SV")) {
                        b2 = 201;
                    }
                    break;
                case 2661:
                    if (strM4357w1.equals("SX")) {
                        b2 = 202;
                    }
                    break;
                case 2662:
                    if (strM4357w1.equals("SY")) {
                        b2 = 203;
                    }
                    break;
                case 2663:
                    if (strM4357w1.equals("SZ")) {
                        b2 = 204;
                    }
                    break;
                case 2671:
                    if (strM4357w1.equals("TC")) {
                        b2 = 205;
                    }
                    break;
                case 2672:
                    if (strM4357w1.equals("TD")) {
                        b2 = 206;
                    }
                    break;
                case 2675:
                    if (strM4357w1.equals("TG")) {
                        b2 = 207;
                    }
                    break;
                case 2676:
                    if (strM4357w1.equals("TH")) {
                        b2 = 208;
                    }
                    break;
                case 2678:
                    if (strM4357w1.equals("TJ")) {
                        b2 = 209;
                    }
                    break;
                case 2680:
                    if (strM4357w1.equals("TL")) {
                        b2 = 210;
                    }
                    break;
                case 2681:
                    if (strM4357w1.equals("TM")) {
                        b2 = 211;
                    }
                    break;
                case 2682:
                    if (strM4357w1.equals("TN")) {
                        b2 = 212;
                    }
                    break;
                case 2683:
                    if (strM4357w1.equals("TO")) {
                        b2 = 213;
                    }
                    break;
                case 2686:
                    if (strM4357w1.equals("TR")) {
                        b2 = 214;
                    }
                    break;
                case 2688:
                    if (strM4357w1.equals("TT")) {
                        b2 = 215;
                    }
                    break;
                case 2690:
                    if (strM4357w1.equals("TV")) {
                        b2 = 216;
                    }
                    break;
                case 2691:
                    if (strM4357w1.equals("TW")) {
                        b2 = ExifInterface.MARKER_EOI;
                    }
                    break;
                case 2694:
                    if (strM4357w1.equals("TZ")) {
                        b2 = 218;
                    }
                    break;
                case 2700:
                    if (strM4357w1.equals("UA")) {
                        b2 = 219;
                    }
                    break;
                case 2706:
                    if (strM4357w1.equals("UG")) {
                        b2 = 220;
                    }
                    break;
                case 2718:
                    if (strM4357w1.equals("US")) {
                        b2 = 221;
                    }
                    break;
                case 2724:
                    if (strM4357w1.equals("UY")) {
                        b2 = 222;
                    }
                    break;
                case 2725:
                    if (strM4357w1.equals("UZ")) {
                        b2 = 223;
                    }
                    break;
                case 2733:
                    if (strM4357w1.equals("VC")) {
                        b2 = 224;
                    }
                    break;
                case 2735:
                    if (strM4357w1.equals("VE")) {
                        b2 = ExifInterface.MARKER_APP1;
                    }
                    break;
                case 2737:
                    if (strM4357w1.equals("VG")) {
                        b2 = 226;
                    }
                    break;
                case 2739:
                    if (strM4357w1.equals("VI")) {
                        b2 = 227;
                    }
                    break;
                case 2744:
                    if (strM4357w1.equals("VN")) {
                        b2 = 228;
                    }
                    break;
                case 2751:
                    if (strM4357w1.equals("VU")) {
                        b2 = 229;
                    }
                    break;
                case 2767:
                    if (strM4357w1.equals("WF")) {
                        b2 = 230;
                    }
                    break;
                case 2780:
                    if (strM4357w1.equals("WS")) {
                        b2 = 231;
                    }
                    break;
                case 2803:
                    if (strM4357w1.equals("XK")) {
                        b2 = 232;
                    }
                    break;
                case 2828:
                    if (strM4357w1.equals("YE")) {
                        b2 = 233;
                    }
                    break;
                case 2843:
                    if (strM4357w1.equals("YT")) {
                        b2 = 234;
                    }
                    break;
                case 2855:
                    if (strM4357w1.equals("ZA")) {
                        b2 = 235;
                    }
                    break;
                case 2867:
                    if (strM4357w1.equals("ZM")) {
                        b2 = 236;
                    }
                    break;
                case 2877:
                    if (strM4357w1.equals("ZW")) {
                        b2 = 237;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                case 26:
                case 80:
                case 121:
                    iArr = new int[]{1, 2, 0, 0, 2, 2};
                    break;
                case 1:
                    iArr = new int[]{1, 4, 4, 4, 3, 2};
                    break;
                case 2:
                case 93:
                case 155:
                case Opcodes.NEW /* 187 */:
                case 196:
                case 206:
                case HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION /* 225 */:
                case 233:
                    iArr = new int[]{4, 4, 4, 4, 2, 2};
                    break;
                case 3:
                    iArr = new int[]{2, 3, 1, 2, 2, 2};
                    break;
                case 4:
                case 25:
                case 51:
                case 57:
                case 74:
                case Opcodes.I2B /* 145 */:
                case 224:
                    iArr = new int[]{1, 2, 2, 2, 2, 2};
                    break;
                case 5:
                case 16:
                case 117:
                    iArr = new int[]{1, 2, 0, 1, 2, 2};
                    break;
                case 6:
                    iArr = new int[]{2, 3, 2, 4, 2, 2};
                    break;
                case 7:
                case 44:
                    iArr = new int[]{3, 4, 3, 2, 2, 2};
                    break;
                case 8:
                case 63:
                case 100:
                case Opcodes.IF_ICMPGE /* 162 */:
                case Opcodes.ARRAYLENGTH /* 190 */:
                case Opcodes.IFNONNULL /* 199 */:
                case 216:
                    iArr = new int[]{4, 2, 2, 2, 2, 2};
                    break;
                case 9:
                    iArr = new int[]{2, 4, 1, 1, 2, 2};
                    break;
                case 10:
                    iArr = new int[]{2, 2, 2, 3, 2, 2};
                    break;
                case 11:
                case 40:
                case 103:
                case Opcodes.NEWARRAY /* 188 */:
                case Opcodes.INSTANCEOF /* 193 */:
                    iArr = new int[]{0, 0, 0, 0, 0, 2};
                    break;
                case 12:
                    iArr = new int[]{0, 1, 0, 1, 2, 2};
                    break;
                case 13:
                case 87:
                    iArr = new int[]{1, 2, 4, 4, 2, 2};
                    break;
                case 14:
                case 79:
                case 122:
                case Opcodes.D2I /* 142 */:
                case Opcodes.IRETURN /* 172 */:
                case Opcodes.CHECKCAST /* 192 */:
                case Opcodes.MONITOREXIT /* 195 */:
                    iArr = new int[]{0, 2, 2, 2, 2, 2};
                    break;
                case 15:
                case 154:
                    iArr = new int[]{3, 2, 4, 4, 2, 2};
                    break;
                case 17:
                case 70:
                case 77:
                    iArr = new int[]{0, 2, 0, 0, 2, 2};
                    break;
                case 18:
                case Opcodes.DCMPL /* 151 */:
                    iArr = new int[]{2, 1, 3, 3, 2, 2};
                    break;
                case 19:
                    iArr = new int[]{0, 0, 3, 3, 2, 2};
                    break;
                case 20:
                    iArr = new int[]{4, 3, 4, 3, 2, 2};
                    break;
                case 21:
                case 53:
                case Opcodes.ATHROW /* 191 */:
                    iArr = new int[]{0, 0, 0, 0, 1, 2};
                    break;
                case 22:
                    iArr = new int[]{1, 2, 2, 4, 4, 2};
                    break;
                case 23:
                case 59:
                case 203:
                case 210:
                    iArr = new int[]{4, 3, 4, 4, 2, 2};
                    break;
                case 24:
                    iArr = new int[]{4, 4, 3, 4, 2, 2};
                    break;
                case 27:
                    iArr = new int[]{3, 2, 1, 1, 2, 2};
                    break;
                case 28:
                    iArr = new int[]{1, 3, 3, 2, 2, 2};
                    break;
                case 29:
                    iArr = new int[]{1, 2, 2, 0, 2, 2};
                    break;
                case 30:
                case Opcodes.IFNULL /* 198 */:
                    iArr = new int[]{2, 3, 2, 2, 2, 2};
                    break;
                case 31:
                    iArr = new int[]{4, 2, 2, 3, 2, 2};
                    break;
                case 32:
                    iArr = new int[]{3, 1, 3, 2, 2, 2};
                    break;
                case 33:
                case 89:
                    iArr = new int[]{3, 4, 1, 0, 2, 2};
                    break;
                case 34:
                    iArr = new int[]{0, 1, 1, 3, 2, 2};
                    break;
                case 35:
                    iArr = new int[]{2, 4, 2, 2, 2, 2};
                    break;
                case 36:
                    iArr = new int[]{0, 2, 1, 2, 4, 1};
                    break;
                case 37:
                    iArr = new int[]{4, 2, 3, 1, 2, 2};
                    break;
                case 38:
                    iArr = new int[]{4, 2, 3, 2, 2, 2};
                    break;
                case 39:
                case 150:
                    iArr = new int[]{2, 4, 3, 4, 2, 2};
                    break;
                case 41:
                    iArr = new int[]{3, 3, 3, 4, 2, 2};
                    break;
                case 42:
                    iArr = new int[]{2, 2, 2, 1, 2, 2};
                    break;
                case 43:
                case Opcodes.LOOKUPSWITCH /* 171 */:
                case 221:
                    iArr = new int[]{1, 1, 2, 2, 3, 2};
                    break;
                case 45:
                    iArr = new int[]{2, 0, 2, 2, 3, 1};
                    break;
                case 46:
                    iArr = new int[]{2, 2, 4, 2, 2, 2};
                    break;
                case 47:
                    iArr = new int[]{2, 2, 4, 4, 2, 2};
                    break;
                case 48:
                case Opcodes.JSR /* 168 */:
                    iArr = new int[]{4, 4, 3, 2, 2, 2};
                    break;
                case 49:
                    iArr = new int[]{2, 3, 1, 0, 2, 2};
                    break;
                case 50:
                    iArr = new int[]{2, 2, 0, 0, 2, 2};
                    break;
                case 52:
                    iArr = new int[]{1, 0, 0, 0, 1, 2};
                    break;
                case 54:
                    iArr = new int[]{0, 0, 2, 2, 1, 2};
                    break;
                case 55:
                    iArr = new int[]{4, 1, 4, 4, 2, 2};
                    break;
                case 56:
                    iArr = new int[]{0, 0, 1, 0, 0, 2};
                    break;
                case 58:
                case 106:
                    iArr = new int[]{3, 4, 4, 4, 2, 2};
                    break;
                case 60:
                    iArr = new int[]{2, 4, 2, 1, 2, 2};
                    break;
                case 61:
                case 126:
                case 128:
                case Opcodes.I2C /* 146 */:
                    iArr = new int[]{0, 0, 0, 0, 2, 2};
                    break;
                case 62:
                    iArr = new int[]{3, 4, 2, 3, 2, 2};
                    break;
                case 64:
                case 96:
                    iArr = new int[]{0, 1, 1, 1, 2, 2};
                    break;
                case 65:
                    iArr = new int[]{4, 4, 3, 1, 2, 2};
                    break;
                case 66:
                    iArr = new int[]{0, 0, 0, 1, 0, 2};
                    break;
                case 67:
                    iArr = new int[]{3, 1, 3, 3, 2, 2};
                    break;
                case 68:
                case 114:
                case 130:
                case Opcodes.DCMPG /* 152 */:
                case 200:
                    iArr = new int[]{3, 2, 2, 2, 2, 2};
                    break;
                case 69:
                    iArr = new int[]{3, 2, 4, 2, 2, 2};
                    break;
                case 71:
                    iArr = new int[]{1, 1, 2, 1, 1, 1};
                    break;
                case 72:
                    iArr = new int[]{2, 3, 1, 1, 2, 2};
                    break;
                case 73:
                    iArr = new int[]{0, 0, 1, 1, 2, 3};
                    break;
                case 75:
                    iArr = new int[]{1, 1, 1, 3, 2, 2};
                    break;
                case 76:
                case 83:
                case Opcodes.D2L /* 143 */:
                    iArr = new int[]{2, 1, 2, 3, 2, 2};
                    break;
                case 78:
                    iArr = new int[]{3, 2, 3, 2, 2, 2};
                    break;
                case 81:
                case 230:
                    iArr = new int[]{4, 2, 2, 4, 2, 2};
                    break;
                case 82:
                    iArr = new int[]{4, 3, 4, 2, 2, 2};
                    break;
                case 84:
                    iArr = new int[]{4, 2, 3, 4, 2, 2};
                    break;
                case 85:
                case 92:
                case Opcodes.IINC /* 132 */:
                case Opcodes.L2F /* 137 */:
                case Opcodes.PUTFIELD /* 181 */:
                    iArr = new int[]{1, 0, 0, 0, 2, 2};
                    break;
                case 86:
                    iArr = new int[]{2, 3, 2, 1, 2, 2};
                    break;
                case 88:
                case 218:
                    iArr = new int[]{3, 4, 3, 3, 2, 2};
                    break;
                case 90:
                    iArr = new int[]{0, 1, 2, 3, 2, 0};
                    break;
                case 91:
                case Opcodes.TABLESWITCH /* 170 */:
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    iArr = new int[]{3, 2, 3, 3, 2, 2};
                    break;
                case 94:
                    iArr = new int[]{0, 0, 0, 1, 3, 2};
                    break;
                case 95:
                    iArr = new int[]{3, 2, 3, 3, 3, 2};
                    break;
                case 97:
                    iArr = new int[]{1, 1, 2, 3, 4, 2};
                    break;
                case 98:
                    iArr = new int[]{0, 2, 0, 1, 2, 2};
                    break;
                case 99:
                    iArr = new int[]{1, 1, 3, 2, 4, 3};
                    break;
                case 101:
                case 220:
                    iArr = new int[]{3, 3, 3, 3, 2, 2};
                    break;
                case 102:
                    iArr = new int[]{3, 0, 1, 1, 3, 0};
                    break;
                case 104:
                    iArr = new int[]{0, 1, 0, 1, 1, 2};
                    break;
                case 105:
                    iArr = new int[]{3, 2, 1, 2, 2, 2};
                    break;
                case 107:
                case Opcodes.I2L /* 133 */:
                    iArr = new int[]{1, 0, 0, 1, 2, 2};
                    break;
                case 108:
                    iArr = new int[]{0, 1, 0, 1, 1, 1};
                    break;
                case 109:
                    iArr = new int[]{3, 3, 2, 2, 2, 2};
                    break;
                case 110:
                    iArr = new int[]{2, 1, 1, 1, 2, 2};
                    break;
                case 111:
                    iArr = new int[]{1, 1, 4, 2, 2, 2};
                    break;
                case 112:
                case 113:
                case Opcodes.LOR /* 129 */:
                case Opcodes.INVOKEINTERFACE /* 185 */:
                    iArr = new int[]{4, 2, 4, 3, 2, 2};
                    break;
                case 115:
                    iArr = new int[]{0, 0, 1, 3, 4, 4};
                    break;
                case 116:
                    iArr = new int[]{1, 1, 0, 0, 0, 2};
                    break;
                case 118:
                    iArr = new int[]{1, 1, 2, 2, 2, 2};
                    break;
                case 119:
                case 222:
                    iArr = new int[]{2, 2, 1, 2, 2, 2};
                    break;
                case 120:
                    iArr = new int[]{3, 2, 1, 4, 2, 2};
                    break;
                case 123:
                    iArr = new int[]{3, 1, 3, 4, 4, 2};
                    break;
                case 124:
                    iArr = new int[]{3, 4, 4, 3, 2, 2};
                    break;
                case Opcodes.LUSHR /* 125 */:
                    iArr = new int[]{3, 3, 4, 3, 2, 2};
                    break;
                case Opcodes.LAND /* 127 */:
                    iArr = new int[]{1, 0, 2, 2, 2, 2};
                    break;
                case Opcodes.LXOR /* 131 */:
                    iArr = new int[]{0, 2, 2, 0, 2, 2};
                    break;
                case Opcodes.I2F /* 134 */:
                    iArr = new int[]{1, 2, 1, 0, 2, 2};
                    break;
                case Opcodes.I2D /* 135 */:
                    iArr = new int[]{3, 4, 2, 2, 2, 2};
                    break;
                case Opcodes.L2I /* 136 */:
                    iArr = new int[]{3, 2, 2, 4, 2, 2};
                    break;
                case Opcodes.L2D /* 138 */:
                    iArr = new int[]{4, 3, 3, 1, 2, 2};
                    break;
                case Opcodes.F2I /* 139 */:
                    iArr = new int[]{2, 4, 3, 3, 2, 2};
                    break;
                case Opcodes.F2L /* 140 */:
                    iArr = new int[]{2, 0, 1, 2, 2, 2};
                    break;
                case Opcodes.F2D /* 141 */:
                    iArr = new int[]{0, 2, 4, 4, 2, 2};
                    break;
                case Opcodes.D2F /* 144 */:
                    iArr = new int[]{4, 1, 3, 4, 2, 2};
                    break;
                case Opcodes.I2S /* 147 */:
                    iArr = new int[]{3, 1, 1, 2, 2, 2};
                    break;
                case Opcodes.LCMP /* 148 */:
                    iArr = new int[]{3, 4, 1, 4, 2, 2};
                    break;
                case Opcodes.FCMPL /* 149 */:
                    iArr = new int[]{4, 2, 1, 0, 2, 2};
                    break;
                case 153:
                    iArr = new int[]{4, 3, 2, 2, 2, 2};
                    break;
                case 156:
                    iArr = new int[]{3, 4, 1, 1, 2, 2};
                    break;
                case 157:
                    iArr = new int[]{2, 3, 4, 3, 2, 2};
                    break;
                case 158:
                    iArr = new int[]{0, 0, 3, 2, 0, 4};
                    break;
                case Opcodes.IF_ICMPEQ /* 159 */:
                    iArr = new int[]{0, 0, 2, 0, 0, 2};
                    break;
                case Opcodes.IF_ICMPNE /* 160 */:
                    iArr = new int[]{2, 1, 4, 3, 2, 2};
                    break;
                case Opcodes.IF_ICMPLT /* 161 */:
                    iArr = new int[]{3, 2, 2, 0, 2, 2};
                    break;
                case Opcodes.IF_ICMPGT /* 163 */:
                    iArr = new int[]{1, 0, 1, 2, 4, 2};
                    break;
                case Opcodes.IF_ICMPLE /* 164 */:
                    iArr = new int[]{2, 3, 1, 3, 4, 2};
                    break;
                case Opcodes.IF_ACMPEQ /* 165 */:
                    iArr = new int[]{1, 3, 3, 3, 2, 2};
                    break;
                case Opcodes.IF_ACMPNE /* 166 */:
                    iArr = new int[]{2, 3, 4, 4, 4, 2};
                    break;
                case Opcodes.GOTO /* 167 */:
                    iArr = new int[]{2, 3, 3, 1, 2, 2};
                    break;
                case Opcodes.RET /* 169 */:
                    iArr = new int[]{2, 2, 3, 3, 3, 2};
                    break;
                case Opcodes.LRETURN /* 173 */:
                    iArr = new int[]{2, 3, 2, 2, 3, 3};
                    break;
                case Opcodes.FRETURN /* 174 */:
                    iArr = new int[]{3, 4, 1, 2, 2, 2};
                    break;
                case 175:
                    iArr = new int[]{0, 1, 0, 0, 2, 2};
                    break;
                case Opcodes.ARETURN /* 176 */:
                    iArr = new int[]{2, 2, 4, 1, 2, 2};
                    break;
                case Opcodes.RETURN /* 177 */:
                    iArr = new int[]{2, 2, 3, 2, 2, 2};
                    break;
                case Opcodes.GETSTATIC /* 178 */:
                    iArr = new int[]{2, 4, 2, 4, 4, 2};
                    break;
                case Opcodes.PUTSTATIC /* 179 */:
                    iArr = new int[]{1, 1, 1, 2, 2, 2};
                    break;
                case 180:
                    iArr = new int[]{0, 0, 1, 1, 1, 2};
                    break;
                case Opcodes.INVOKEVIRTUAL /* 182 */:
                    iArr = new int[]{0, 0, 0, 1, 2, 2};
                    break;
                case Opcodes.INVOKESPECIAL /* 183 */:
                    iArr = new int[]{3, 4, 3, 0, 2, 2};
                    break;
                case Opcodes.INVOKESTATIC /* 184 */:
                case 212:
                case 226:
                    iArr = new int[]{2, 2, 1, 1, 2, 2};
                    break;
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    iArr = new int[]{4, 3, 0, 2, 2, 2};
                    break;
                case Opcodes.ANEWARRAY /* 189 */:
                    iArr = new int[]{1, 1, 2, 3, 1, 4};
                    break;
                case Opcodes.MONITORENTER /* 194 */:
                    iArr = new int[]{4, 3, 4, 1, 2, 2};
                    break;
                case 201:
                    iArr = new int[]{2, 2, 3, 3, 2, 2};
                    break;
                case 202:
                case 205:
                    iArr = new int[]{2, 2, 1, 0, 2, 2};
                    break;
                case 204:
                    iArr = new int[]{4, 3, 2, 4, 2, 2};
                    break;
                case 207:
                    iArr = new int[]{3, 3, 2, 0, 2, 2};
                    break;
                case 208:
                    iArr = new int[]{0, 3, 2, 3, 3, 0};
                    break;
                case 209:
                    iArr = new int[]{4, 2, 4, 4, 2, 2};
                    break;
                case 211:
                    iArr = new int[]{4, 2, 4, 2, 2, 2};
                    break;
                case 213:
                    iArr = new int[]{4, 2, 3, 3, 2, 2};
                    break;
                case 214:
                    iArr = new int[]{1, 1, 0, 1, 2, 2};
                    break;
                case 215:
                    iArr = new int[]{1, 4, 1, 1, 2, 2};
                    break;
                case 217:
                    iArr = new int[]{0, 0, 0, 0, 0, 0};
                    break;
                case 219:
                    iArr = new int[]{0, 3, 1, 1, 2, 2};
                    break;
                case 223:
                    iArr = new int[]{2, 2, 3, 4, 2, 2};
                    break;
                case 227:
                    iArr = new int[]{1, 2, 1, 3, 2, 2};
                    break;
                case 228:
                    iArr = new int[]{0, 3, 3, 4, 2, 2};
                    break;
                case 229:
                    iArr = new int[]{4, 2, 2, 1, 2, 2};
                    break;
                case 231:
                    iArr = new int[]{3, 1, 2, 1, 2, 2};
                    break;
                case 232:
                    iArr = new int[]{1, 1, 1, 1, 2, 2};
                    break;
                case 234:
                    iArr = new int[]{4, 1, 1, 1, 2, 2};
                    break;
                case 235:
                    iArr = new int[]{3, 3, 1, 1, 1, 2};
                    break;
                case 236:
                    iArr = new int[]{3, 3, 4, 2, 2, 2};
                    break;
                case 237:
                    iArr = new int[]{3, 2, 4, 3, 2, 2};
                    break;
                default:
                    iArr = new int[]{2, 2, 2, 2, 2, 2};
                    break;
            }
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            AbstractC4523p<Long> abstractC4523p2 = C2714p.f6569a;
            map.put(2, abstractC4523p2.get(iArr[0]));
            map.put(3, C2714p.f6570b.get(iArr[1]));
            map.put(4, C2714p.f6571c.get(iArr[2]));
            map.put(5, C2714p.f6572d.get(iArr[3]));
            map.put(10, C2714p.f6573e.get(iArr[4]));
            map.put(9, C2714p.f6574f.get(iArr[5]));
            map.put(7, abstractC4523p2.get(iArr[0]));
            this.f6590b = map;
            this.f6591c = 2000;
            this.f6592d = InterfaceC2740g.f6720a;
            this.f6593e = true;
        }
    }

    public C2714p(Context context, Map map, int i, InterfaceC2740g interfaceC2740g, boolean z2, a aVar) {
        final C2755v c2755v;
        int i2;
        this.f6576h = AbstractC4525q.m6273a(map);
        this.f6578j = new C2722x(i);
        this.f6579k = interfaceC2740g;
        this.f6580l = z2;
        if (context == null) {
            this.f6584p = 0;
            this.f6587s = m2862h(0);
            return;
        }
        synchronized (C2755v.class) {
            if (C2755v.f6782a == null) {
                C2755v.f6782a = new C2755v(context);
            }
            c2755v = C2755v.f6782a;
        }
        synchronized (c2755v.f6785d) {
            i2 = c2755v.f6786e;
        }
        this.f6584p = i2;
        this.f6587s = m2862h(i2);
        final C2755v.b bVar = new C2755v.b() { // from class: b.i.a.c.e3.b
            @Override // p007b.p225i.p226a.p242c.p259f3.C2755v.b
            /* JADX INFO: renamed from: a */
            public final void mo2777a(int i3) {
                C2714p c2714p = this.f6435a;
                synchronized (c2714p) {
                    int i4 = c2714p.f6584p;
                    if (i4 == 0 || c2714p.f6580l) {
                        if (i4 == i3) {
                            return;
                        }
                        c2714p.f6584p = i3;
                        if (i3 != 1 && i3 != 0 && i3 != 8) {
                            c2714p.f6587s = c2714p.m2862h(i3);
                            long jMo2952d = c2714p.f6579k.mo2952d();
                            c2714p.m2863j(c2714p.f6581m > 0 ? (int) (jMo2952d - c2714p.f6582n) : 0, c2714p.f6583o, c2714p.f6587s);
                            c2714p.f6582n = jMo2952d;
                            c2714p.f6583o = 0L;
                            c2714p.f6586r = 0L;
                            c2714p.f6585q = 0L;
                            C2722x c2722x = c2714p.f6578j;
                            c2722x.f6632c.clear();
                            c2722x.f6634e = -1;
                            c2722x.f6635f = 0;
                            c2722x.f6636g = 0;
                        }
                    }
                }
            }
        };
        for (WeakReference<C2755v.b> weakReference : c2755v.f6784c) {
            if (weakReference.get() == null) {
                c2755v.f6784c.remove(weakReference);
            }
        }
        c2755v.f6784c.add(new WeakReference<>(bVar));
        c2755v.f6783b.post(new Runnable() { // from class: b.i.a.c.f3.c
            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                C2755v c2755v2 = c2755v;
                C2755v.b bVar2 = bVar;
                synchronized (c2755v2.f6785d) {
                    i3 = c2755v2.f6786e;
                }
                bVar2.mo2777a(i3);
            }
        });
    }

    /* JADX INFO: renamed from: i */
    public static boolean m2861i(C2712n c2712n, boolean z2) {
        return z2 && !c2712n.m2856c(8);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0
    /* JADX INFO: renamed from: a */
    public synchronized void mo2773a(InterfaceC2710l interfaceC2710l, C2712n c2712n, boolean z2) {
        if (m2861i(c2712n, z2)) {
            C1460d.m426D(this.f6581m > 0);
            long jMo2952d = this.f6579k.mo2952d();
            int i = (int) (jMo2952d - this.f6582n);
            this.f6585q += (long) i;
            long j = this.f6586r;
            long j2 = this.f6583o;
            this.f6586r = j + j2;
            if (i > 0) {
                this.f6578j.m2875a((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.f6585q >= 2000 || this.f6586r >= Permission.VIEW_GUILD_ANALYTICS) {
                    this.f6587s = (long) this.f6578j.m2876b(0.5f);
                }
                m2863j(i, this.f6583o, this.f6587s);
                this.f6582n = jMo2952d;
                this.f6583o = 0L;
            }
            this.f6581m--;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0
    /* JADX INFO: renamed from: b */
    public synchronized void mo2774b(InterfaceC2710l interfaceC2710l, C2712n c2712n, boolean z2) {
        if (m2861i(c2712n, z2)) {
            if (this.f6581m == 0) {
                this.f6582n = this.f6579k.mo2952d();
            }
            this.f6581m++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f
    /* JADX INFO: renamed from: c */
    public InterfaceC2680a0 mo2844c() {
        return this;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f
    /* JADX INFO: renamed from: d */
    public void mo2845d(InterfaceC2704f.a aVar) {
        this.f6577i.m2847a(aVar);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0
    /* JADX INFO: renamed from: e */
    public synchronized void mo2775e(InterfaceC2710l interfaceC2710l, C2712n c2712n, boolean z2, int i) {
        if (m2861i(c2712n, z2)) {
            this.f6583o += (long) i;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f
    /* JADX INFO: renamed from: f */
    public void mo2846f(Handler handler, InterfaceC2704f.a aVar) {
        InterfaceC2704f.a.C13224a c13224a = this.f6577i;
        Objects.requireNonNull(c13224a);
        c13224a.m2847a(aVar);
        c13224a.f6524a.add(new InterfaceC2704f.a.C13224a.C13225a(handler, aVar));
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0
    /* JADX INFO: renamed from: g */
    public void mo2776g(InterfaceC2710l interfaceC2710l, C2712n c2712n, boolean z2) {
    }

    /* JADX INFO: renamed from: h */
    public final long m2862h(int i) {
        Long l = this.f6576h.get(Integer.valueOf(i));
        if (l == null) {
            l = this.f6576h.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    /* JADX INFO: renamed from: j */
    public final void m2863j(final int i, final long j, final long j2) {
        if (i == 0 && j == 0 && j2 == this.f6588t) {
            return;
        }
        this.f6588t = j2;
        for (final InterfaceC2704f.a.C13224a.C13225a c13225a : this.f6577i.f6524a) {
            if (!c13225a.f6527c) {
                c13225a.f6525a.post(new Runnable() { // from class: b.i.a.c.e3.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2530a0.a next;
                        InterfaceC2530a0.a aVar;
                        InterfaceC2530a0.a aVar2;
                        InterfaceC2704f.a.C13224a.C13225a c13225a2 = c13225a;
                        final int i2 = i;
                        final long j3 = j;
                        final long j4 = j2;
                        C2868g1 c2868g1 = (C2868g1) c13225a2.f6526b;
                        C2868g1.a aVar3 = c2868g1.f7550m;
                        if (aVar3.f7557b.isEmpty()) {
                            aVar2 = null;
                        } else {
                            AbstractC4523p<InterfaceC2530a0.a> abstractC4523p = aVar3.f7557b;
                            if (!(abstractC4523p instanceof List)) {
                                Iterator<InterfaceC2530a0.a> it = abstractC4523p.iterator();
                                do {
                                    next = it.next();
                                } while (it.hasNext());
                                aVar = next;
                            } else {
                                if (abstractC4523p.isEmpty()) {
                                    throw new NoSuchElementException();
                                }
                                aVar = abstractC4523p.get(abstractC4523p.size() - 1);
                            }
                            aVar2 = aVar;
                        }
                        final InterfaceC2871h1.a aVarM3384m0 = c2868g1.m3384m0(aVar2);
                        C2749p.a<InterfaceC2871h1> aVar4 = new C2749p.a() { // from class: b.i.a.c.s2.s0
                            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                            public final void invoke(Object obj) {
                                ((InterfaceC2871h1) obj).m3441l0();
                            }
                        };
                        c2868g1.f7551n.put(PointerIconCompat.TYPE_CELL, aVarM3384m0);
                        C2749p<InterfaceC2871h1> c2749p = c2868g1.f7552o;
                        c2749p.m3035b(PointerIconCompat.TYPE_CELL, aVar4);
                        c2749p.m3034a();
                    }
                });
            }
        }
    }
}
