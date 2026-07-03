package p007b.p008a.p018d.p019m0;

import android.net.Uri;
import com.discord.BuildConfig;
import kotlin.text.Regex;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.EnumC12092i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.m0.a */
/* JADX INFO: compiled from: RoutingPatterns.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0877a {

    /* JADX INFO: renamed from: A */
    public static final Regex f532A;

    /* JADX INFO: renamed from: B */
    public static final Regex f533B;

    /* JADX INFO: renamed from: C */
    public static final Regex f534C;

    /* JADX INFO: renamed from: D */
    public static final Regex f535D;

    /* JADX INFO: renamed from: E */
    public static final Regex f536E;

    /* JADX INFO: renamed from: F */
    public static final Regex f537F;

    /* JADX INFO: renamed from: G */
    public static final C0877a f538G;

    /* JADX INFO: renamed from: a */
    public static final String f539a;

    /* JADX INFO: renamed from: b */
    public static final String f540b;

    /* JADX INFO: renamed from: c */
    public static final String f541c;

    /* JADX INFO: renamed from: d */
    public static final String f542d;

    /* JADX INFO: renamed from: e */
    public static final String f543e;

    /* JADX INFO: renamed from: f */
    public static final String f544f;

    /* JADX INFO: renamed from: g */
    public static final String f545g;

    /* JADX INFO: renamed from: h */
    public static final String f546h;

    /* JADX INFO: renamed from: i */
    public static final String f547i;

    /* JADX INFO: renamed from: j */
    public static final String f548j;

    /* JADX INFO: renamed from: k */
    public static final String f549k;

    /* JADX INFO: renamed from: l */
    public static final Regex f550l;

    /* JADX INFO: renamed from: m */
    public static final Regex f551m;

    /* JADX INFO: renamed from: n */
    public static final Regex f552n;

    /* JADX INFO: renamed from: o */
    public static final Regex f553o;

    /* JADX INFO: renamed from: p */
    public static final Regex f554p;

    /* JADX INFO: renamed from: q */
    public static final Regex f555q;

    /* JADX INFO: renamed from: r */
    public static final Regex f556r;

    /* JADX INFO: renamed from: s */
    public static final Regex f557s;

    /* JADX INFO: renamed from: t */
    public static final Regex f558t;

    /* JADX INFO: renamed from: u */
    public static final Regex f559u;

    /* JADX INFO: renamed from: v */
    public static final Regex f560v;

    /* JADX INFO: renamed from: w */
    public static final Regex f561w;

    /* JADX INFO: renamed from: x */
    public static final Regex f562x;

    /* JADX INFO: renamed from: y */
    public static final Regex f563y;

    /* JADX INFO: renamed from: z */
    public static final Regex f564z;

    static {
        C0877a c0877a = new C0877a();
        f538G = c0877a;
        String strM174b = c0877a.m174b(BuildConfig.HOST);
        f539a = strM174b;
        String strM174b2 = c0877a.m174b(BuildConfig.HOST_ALTERNATE);
        f540b = strM174b2;
        String strM174b3 = c0877a.m174b(BuildConfig.HOST_GIFT);
        f541c = strM174b3;
        String strM174b4 = c0877a.m174b(BuildConfig.HOST_INVITE);
        f542d = strM174b4;
        String strM174b5 = c0877a.m174b(BuildConfig.HOST_GUILD_TEMPLATE);
        f543e = strM174b5;
        String strReplace$default = C12103t.replace$default(strM174b, ".", "\\.", false, 4, (Object) null);
        f544f = strReplace$default;
        String strReplace$default2 = C12103t.replace$default(strM174b2, ".", "\\.", false, 4, (Object) null);
        f545g = strReplace$default2;
        String str = "(?:" + strReplace$default + '|' + strReplace$default2 + ')';
        f546h = str;
        String strReplace$default3 = C12103t.replace$default(strM174b3, ".", "\\.", false, 4, (Object) null);
        f547i = strReplace$default3;
        String strReplace$default4 = C12103t.replace$default(strM174b4, ".", "\\.", false, 4, (Object) null);
        f548j = strReplace$default4;
        String strReplace$default5 = C12103t.replace$default(strM174b5, ".", "\\.", false, 4, (Object) null);
        f549k = strReplace$default5;
        EnumC12092i enumC12092i = EnumC12092i.IGNORE_CASE;
        f550l = new Regex("^(?:ptb|canary|www)." + str + '$', enumC12092i);
        f551m = new Regex("^/(?:(invite|gift|template)/)?([\\w-]+)/?$", enumC12092i);
        f552n = new Regex("^/(?:invite/)?([\\w-]+)/?$", enumC12092i);
        StringBuilder sb = new StringBuilder();
        sb.append("(?:https?://(?:(?:" + str + "/invite)|");
        sb.append("(?:" + strReplace$default4 + "))|");
        sb.append("(?:^" + strReplace$default4 + "))/([\\w-]+)/?");
        sb.append("(?:(?:\\S*[\\?&]event=)([\\w-]+))?");
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder()\n        …\"\")\n          .toString()");
        f553o = new Regex(string, enumC12092i);
        f554p = new Regex("^/(?:template/)?([\\w-]+)/?$", enumC12092i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(?:https?://(?:(?:" + str + "/template)|");
        sb2.append("(?:" + strReplace$default5 + "))|");
        sb2.append("(?:" + strReplace$default5 + "))/([\\w-]+)/?");
        String string2 = sb2.toString();
        C12238m.checkNotNullExpressionValue(string2, "StringBuilder()\n        …?\")\n          .toString()");
        f555q = new Regex(string2, enumC12092i);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(?:https?://)?(?:(?:" + str + "/gifts)|");
        sb3.append("(?:" + strReplace$default3 + "))/([\\w-]+)/?");
        String string3 = sb3.toString();
        C12238m.checkNotNullExpressionValue(string3, "StringBuilder()\n        …?\")\n          .toString()");
        f556r = new Regex(string3, enumC12092i);
        f557s = new Regex("^/connect(?:/(\\d+))?/?$", enumC12092i);
        f558t = new Regex("^/channels/((?:@me)|(?:\\d+))(?:/(\\d+))?(?:/(\\d+))?/?$", enumC12092i);
        f559u = new Regex("^/channels/((?:@me)|(?:\\d+))/([@a-zA-Z_-]+)/?$", enumC12092i);
        f560v = new Regex("^/channels/@me/-1?/?$", enumC12092i);
        f561w = new Regex("^/lurk/(\\d+)(?:/(\\d+))?/?$", enumC12092i);
        f562x = new Regex("^/channels/@me/user/(\\d+)/?$", enumC12092i);
        f563y = new Regex("^/users/(\\d+)/?$", enumC12092i);
        f564z = new Regex("^/settings(/\\w+)*/?$", enumC12092i);
        f532A = new Regex("^/feature(/\\w+)*/?$", enumC12092i);
        f533B = new Regex("^/query(/\\w+)*/?$", enumC12092i);
        f534C = new Regex("^/(?:oauth2|connect)/authorize/?$", enumC12092i);
        f535D = new Regex("^/ra/([\\w-]+)$");
        f536E = new Regex("^/guild/((?:@me)|(?:\\d+))/premiumguild/?$", enumC12092i);
        f537F = new Regex("^/events/(\\d+)/(\\d+)/?$", enumC12092i);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m173a(String str) {
        if (str == null) {
            return false;
        }
        if (C12238m.areEqual(str, f539a) || C12238m.areEqual(str, f540b) || C12238m.areEqual(str, f541c) || C12238m.areEqual(str, f543e) || C12238m.areEqual(str, f542d)) {
            return true;
        }
        return f550l.matches(str);
    }

    /* JADX INFO: renamed from: b */
    public final String m174b(String str) {
        Uri uri = Uri.parse(str);
        C12238m.checkNotNullExpressionValue(uri, "Uri.parse(this)");
        String host = uri.getHost();
        return host != null ? host : "";
    }
}
