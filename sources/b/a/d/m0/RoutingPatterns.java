package b.a.d.m0;

import android.net.Uri;
import com.discord.BuildConfig;
import d0.g0.Regex5;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.text.Regex;

/* JADX INFO: renamed from: b.a.d.m0.a, reason: use source file name */
/* JADX INFO: compiled from: RoutingPatterns.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RoutingPatterns {
    public static final Regex A;
    public static final Regex B;
    public static final Regex C;
    public static final Regex D;
    public static final Regex E;
    public static final Regex F;
    public static final RoutingPatterns G;
    public static final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f60b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final Regex l;
    public static final Regex m;
    public static final Regex n;
    public static final Regex o;
    public static final Regex p;
    public static final Regex q;
    public static final Regex r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Regex f61s;
    public static final Regex t;
    public static final Regex u;
    public static final Regex v;
    public static final Regex w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Regex f62x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Regex f63y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Regex f64z;

    static {
        RoutingPatterns routingPatterns = new RoutingPatterns();
        G = routingPatterns;
        String strB = routingPatterns.b(BuildConfig.HOST);
        a = strB;
        String strB2 = routingPatterns.b(BuildConfig.HOST_ALTERNATE);
        f60b = strB2;
        String strB3 = routingPatterns.b(BuildConfig.HOST_GIFT);
        c = strB3;
        String strB4 = routingPatterns.b(BuildConfig.HOST_INVITE);
        d = strB4;
        String strB5 = routingPatterns.b(BuildConfig.HOST_GUILD_TEMPLATE);
        e = strB5;
        String strReplace$default = StringsJVM.replace$default(strB, ".", "\\.", false, 4, (Object) null);
        f = strReplace$default;
        String strReplace$default2 = StringsJVM.replace$default(strB2, ".", "\\.", false, 4, (Object) null);
        g = strReplace$default2;
        String str = "(?:" + strReplace$default + '|' + strReplace$default2 + ')';
        h = str;
        String strReplace$default3 = StringsJVM.replace$default(strB3, ".", "\\.", false, 4, (Object) null);
        i = strReplace$default3;
        String strReplace$default4 = StringsJVM.replace$default(strB4, ".", "\\.", false, 4, (Object) null);
        j = strReplace$default4;
        String strReplace$default5 = StringsJVM.replace$default(strB5, ".", "\\.", false, 4, (Object) null);
        k = strReplace$default5;
        Regex5 regex5 = Regex5.IGNORE_CASE;
        l = new Regex("^(?:ptb|canary|www)." + str + '$', regex5);
        m = new Regex("^/(?:(invite|gift|template)/)?([\\w-]+)/?$", regex5);
        n = new Regex("^/(?:invite/)?([\\w-]+)/?$", regex5);
        StringBuilder sb = new StringBuilder();
        sb.append("(?:https?://(?:(?:" + str + "/invite)|");
        sb.append("(?:" + strReplace$default4 + "))|");
        sb.append("(?:^" + strReplace$default4 + "))/([\\w-]+)/?");
        sb.append("(?:(?:\\S*[\\?&]event=)([\\w-]+))?");
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …\"\")\n          .toString()");
        o = new Regex(string, regex5);
        p = new Regex("^/(?:template/)?([\\w-]+)/?$", regex5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(?:https?://(?:(?:" + str + "/template)|");
        sb2.append("(?:" + strReplace$default5 + "))|");
        sb2.append("(?:" + strReplace$default5 + "))/([\\w-]+)/?");
        String string2 = sb2.toString();
        Intrinsics3.checkNotNullExpressionValue(string2, "StringBuilder()\n        …?\")\n          .toString()");
        q = new Regex(string2, regex5);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(?:https?://)?(?:(?:" + str + "/gifts)|");
        sb3.append("(?:" + strReplace$default3 + "))/([\\w-]+)/?");
        String string3 = sb3.toString();
        Intrinsics3.checkNotNullExpressionValue(string3, "StringBuilder()\n        …?\")\n          .toString()");
        r = new Regex(string3, regex5);
        f61s = new Regex("^/connect(?:/(\\d+))?/?$", regex5);
        t = new Regex("^/channels/((?:@me)|(?:\\d+))(?:/(\\d+))?(?:/(\\d+))?/?$", regex5);
        u = new Regex("^/channels/((?:@me)|(?:\\d+))/([@a-zA-Z_-]+)/?$", regex5);
        v = new Regex("^/channels/@me/-1?/?$", regex5);
        w = new Regex("^/lurk/(\\d+)(?:/(\\d+))?/?$", regex5);
        f62x = new Regex("^/channels/@me/user/(\\d+)/?$", regex5);
        f63y = new Regex("^/users/(\\d+)/?$", regex5);
        f64z = new Regex("^/settings(/\\w+)*/?$", regex5);
        A = new Regex("^/feature(/\\w+)*/?$", regex5);
        B = new Regex("^/query(/\\w+)*/?$", regex5);
        C = new Regex("^/(?:oauth2|connect)/authorize/?$", regex5);
        D = new Regex("^/ra/([\\w-]+)$");
        E = new Regex("^/guild/((?:@me)|(?:\\d+))/premiumguild/?$", regex5);
        F = new Regex("^/events/(\\d+)/(\\d+)/?$", regex5);
    }

    public final boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (Intrinsics3.areEqual(str, a) || Intrinsics3.areEqual(str, f60b) || Intrinsics3.areEqual(str, c) || Intrinsics3.areEqual(str, e) || Intrinsics3.areEqual(str, d)) {
            return true;
        }
        return l.matches(str);
    }

    public final String b(String str) {
        Uri uri = Uri.parse(str);
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(this)");
        String host = uri.getHost();
        return host != null ? host : "";
    }
}
