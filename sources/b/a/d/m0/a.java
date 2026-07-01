package b.a.d.m0;

import android.net.Uri;
import com.discord.BuildConfig;
import d0.g0.i;
import d0.g0.t;
import d0.z.d.m;
import kotlin.text.Regex;

/* JADX INFO: compiled from: RoutingPatterns.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final Regex A;
    public static final Regex B;
    public static final Regex C;
    public static final Regex D;
    public static final Regex E;
    public static final Regex F;
    public static final a G;
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
        a aVar = new a();
        G = aVar;
        String strB = aVar.b(BuildConfig.HOST);
        a = strB;
        String strB2 = aVar.b(BuildConfig.HOST_ALTERNATE);
        f60b = strB2;
        String strB3 = aVar.b(BuildConfig.HOST_GIFT);
        c = strB3;
        String strB4 = aVar.b(BuildConfig.HOST_INVITE);
        d = strB4;
        String strB5 = aVar.b(BuildConfig.HOST_GUILD_TEMPLATE);
        e = strB5;
        String strReplace$default = t.replace$default(strB, ".", "\\.", false, 4, (Object) null);
        f = strReplace$default;
        String strReplace$default2 = t.replace$default(strB2, ".", "\\.", false, 4, (Object) null);
        g = strReplace$default2;
        String str = "(?:" + strReplace$default + '|' + strReplace$default2 + ')';
        h = str;
        String strReplace$default3 = t.replace$default(strB3, ".", "\\.", false, 4, (Object) null);
        i = strReplace$default3;
        String strReplace$default4 = t.replace$default(strB4, ".", "\\.", false, 4, (Object) null);
        j = strReplace$default4;
        String strReplace$default5 = t.replace$default(strB5, ".", "\\.", false, 4, (Object) null);
        k = strReplace$default5;
        i iVar = i.IGNORE_CASE;
        l = new Regex("^(?:ptb|canary|www)." + str + '$', iVar);
        m = new Regex("^/(?:(invite|gift|template)/)?([\\w-]+)/?$", iVar);
        n = new Regex("^/(?:invite/)?([\\w-]+)/?$", iVar);
        StringBuilder sb = new StringBuilder();
        sb.append("(?:https?://(?:(?:" + str + "/invite)|");
        sb.append("(?:" + strReplace$default4 + "))|");
        sb.append("(?:^" + strReplace$default4 + "))/([\\w-]+)/?");
        sb.append("(?:(?:\\S*[\\?&]event=)([\\w-]+))?");
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "StringBuilder()\n        …\"\")\n          .toString()");
        o = new Regex(string, iVar);
        p = new Regex("^/(?:template/)?([\\w-]+)/?$", iVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(?:https?://(?:(?:" + str + "/template)|");
        sb2.append("(?:" + strReplace$default5 + "))|");
        sb2.append("(?:" + strReplace$default5 + "))/([\\w-]+)/?");
        String string2 = sb2.toString();
        m.checkNotNullExpressionValue(string2, "StringBuilder()\n        …?\")\n          .toString()");
        q = new Regex(string2, iVar);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(?:https?://)?(?:(?:" + str + "/gifts)|");
        sb3.append("(?:" + strReplace$default3 + "))/([\\w-]+)/?");
        String string3 = sb3.toString();
        m.checkNotNullExpressionValue(string3, "StringBuilder()\n        …?\")\n          .toString()");
        r = new Regex(string3, iVar);
        f61s = new Regex("^/connect(?:/(\\d+))?/?$", iVar);
        t = new Regex("^/channels/((?:@me)|(?:\\d+))(?:/(\\d+))?(?:/(\\d+))?/?$", iVar);
        u = new Regex("^/channels/((?:@me)|(?:\\d+))/([@a-zA-Z_-]+)/?$", iVar);
        v = new Regex("^/channels/@me/-1?/?$", iVar);
        w = new Regex("^/lurk/(\\d+)(?:/(\\d+))?/?$", iVar);
        f62x = new Regex("^/channels/@me/user/(\\d+)/?$", iVar);
        f63y = new Regex("^/users/(\\d+)/?$", iVar);
        f64z = new Regex("^/settings(/\\w+)*/?$", iVar);
        A = new Regex("^/feature(/\\w+)*/?$", iVar);
        B = new Regex("^/query(/\\w+)*/?$", iVar);
        C = new Regex("^/(?:oauth2|connect)/authorize/?$", iVar);
        D = new Regex("^/ra/([\\w-]+)$");
        E = new Regex("^/guild/((?:@me)|(?:\\d+))/premiumguild/?$", iVar);
        F = new Regex("^/events/(\\d+)/(\\d+)/?$", iVar);
    }

    public final boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (m.areEqual(str, a) || m.areEqual(str, f60b) || m.areEqual(str, c) || m.areEqual(str, e) || m.areEqual(str, d)) {
            return true;
        }
        return l.matches(str);
    }

    public final String b(String str) {
        Uri uri = Uri.parse(str);
        m.checkNotNullExpressionValue(uri, "Uri.parse(this)");
        String host = uri.getHost();
        return host != null ? host : "";
    }
}
