package com.discord.utilities.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri$Builder;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.content.pm.ShortcutManagerCompat;
import b.a.d.m0.a;
import b.c.a.a0.d;
import b.i.c.c;
import b.i.c.k.b;
import com.adjust.sdk.Constants;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIBuilder;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;
import d0.g0.i;
import d0.g0.s;
import d0.g0.t;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils {
    public static final IntentUtils INSTANCE = new IntentUtils();
    private static final Map<Regex, Function3<Uri, MatchResult, Context, RouteHandlers$AnalyticsMetadata>> pathRouterMap;

    static {
        a aVar = a.G;
        Regex regex = a.F;
        RouteHandlers routeHandlers = RouteHandlers.INSTANCE;
        pathRouterMap = h0.mapOf(o.to(a.t, IntentUtils$pathRouterMap$1.INSTANCE), o.to(a.u, IntentUtils$pathRouterMap$2.INSTANCE), o.to(regex, new IntentUtils$pathRouterMap$3(routeHandlers)), o.to(a.v, new IntentUtils$pathRouterMap$4(routeHandlers)), o.to(a.f62x, new IntentUtils$pathRouterMap$5(routeHandlers)), o.to(a.f63y, new IntentUtils$pathRouterMap$6(routeHandlers)), o.to(a.f64z, new IntentUtils$pathRouterMap$7(routeHandlers)), o.to(a.A, new IntentUtils$pathRouterMap$8(routeHandlers)), o.to(a.f61s, new IntentUtils$pathRouterMap$9(routeHandlers)), o.to(a.w, new IntentUtils$pathRouterMap$10(routeHandlers)), o.to(a.C, new IntentUtils$pathRouterMap$11(routeHandlers)), o.to(a.D, new IntentUtils$pathRouterMap$12(routeHandlers)), o.to(a.E, new IntentUtils$pathRouterMap$13(routeHandlers)), o.to(a.B, new IntentUtils$pathRouterMap$14(routeHandlers)), o.to(a.m, new IntentUtils$pathRouterMap$15(routeHandlers)));
    }

    private IntentUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean consumeRoutingIntent$default(IntentUtils intentUtils, Intent intent, Context context, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = IntentUtils$consumeRoutingIntent$1.INSTANCE;
        }
        return intentUtils.consumeRoutingIntent(intent, context, function2);
    }

    private final Uri externalize(Uri uri) {
        Uri$Builder uri$BuilderScheme = uri.buildUpon().scheme(Constants.SCHEME);
        a aVar = a.G;
        return uri$BuilderScheme.authority(a.a).build();
    }

    private final void notifyFirebaseUserActionStatus(Intent intent, boolean isHandledSuccessfully) {
        String stringExtra = intent.getStringExtra("actions.fulfillment.extra.ACTION_TOKEN");
        if (stringExtra != null) {
            m.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(In…A_VOICE_ACTION) ?: return");
            String str = isHandledSuccessfully ? "http://schema.org/CompletedActionStatus" : "http://schema.org/FailedActionStatus";
            b.i.c.k.c.a aVar = new b.i.c.k.c.a();
            aVar.f = stringExtra;
            aVar.e = str;
            d.z(stringExtra, "setActionToken is required before calling build().");
            d.z(new String(aVar.e), "setActionStatus is required before calling build().");
            aVar.a("actionToken", aVar.f);
            b bVar = null;
            if ((aVar.c == null ? null : new String(aVar.c)) == null) {
                aVar.c = "AssistAction";
                aVar.a(ModelAuditLogEntry.CHANGE_KEY_NAME, "AssistAction");
            }
            if ((aVar.d == null ? null : new String(aVar.d)) == null) {
                String strValueOf = String.valueOf(aVar.f);
                String strConcat = strValueOf.length() != 0 ? "https://developers.google.com/actions?invocation=".concat(strValueOf) : new String("https://developers.google.com/actions?invocation=");
                Objects.requireNonNull(strConcat, "null reference");
                aVar.d = strConcat;
                aVar.a("url", strConcat);
            }
            d.z(aVar.c, "setObject is required before calling build().");
            d.z(aVar.d, "setObject is required before calling build().");
            zza zzaVar = new zza(aVar.f1660b, aVar.c, aVar.d, null, new zzc(true), aVar.e, aVar.a);
            synchronized (b.class) {
                WeakReference<b> weakReference = b.a;
                if (weakReference != null) {
                    bVar = weakReference.get();
                }
                if (bVar == null) {
                    c cVarB = c.b();
                    cVarB.a();
                    bVar = new b.i.c.k.d.b(cVarB.d);
                    b.a = new WeakReference<>(bVar);
                }
            }
            bVar.a(zzaVar);
        }
    }

    public static final void performChooserSendIntent(Context context, String str) {
        performChooserSendIntent$default(context, str, null, 4, null);
    }

    public static final void performChooserSendIntent(Context context, String text, CharSequence chooserText) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(chooserText, "chooserText");
        context.startActivity(Intent.createChooser(INSTANCE.sendText(new Intent("android.intent.action.SEND"), text), chooserText));
    }

    public static /* synthetic */ void performChooserSendIntent$default(Context context, String str, CharSequence charSequence, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence = context.getString(2131895641);
            m.checkNotNullExpressionValue(charSequence, "context.getString(R.string.share)");
        }
        performChooserSendIntent(context, str, charSequence);
    }

    private final Intent sendText(Intent intent, String str) {
        intent.setAction("android.intent.action.SEND");
        intent.setType(RestAPIBuilder.CONTENT_TYPE_TEXT);
        if (str == null) {
            str = "";
        }
        intent.putExtra("android.intent.extra.TEXT", str);
        return intent;
    }

    public final boolean consumeExternalRoutingIntent(Intent intent, Context context) {
        m.checkNotNullParameter(intent, "intent");
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getDynamicLinkCache().storeLinkIfExists(intent, context);
        return consumeRoutingIntent(intent, context, new IntentUtils$consumeExternalRoutingIntent$1(intent));
    }

    public final boolean consumeRoutingIntent(Intent intent, Context context, Function2<? super Uri, ? super Boolean, Unit> callback) {
        MatchResult matchResultMatchEntire;
        RouteHandlers$AnalyticsMetadata unknown;
        m.checkNotNullParameter(intent, "intent");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(callback, "callback");
        Uri data = intent.getData();
        if (data == null) {
            data = Uri.EMPTY;
        }
        m.checkNotNullExpressionValue(data, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        boolean z2 = isDiscordAppUri(data) || isHttpDomainUrl(data);
        callback.invoke(data, Boolean.valueOf(z2));
        if (z2) {
            AppLog appLog = AppLog.g;
            String simpleName = IntentUtils.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            String string = data.toString();
            if (string == null) {
                string = "<null>";
            }
            m.checkNotNullExpressionValue(string, "uri?.toString() ?: \"<null>\"");
            appLog.f(simpleName, string);
            for (Map$Entry<Regex, Function3<Uri, MatchResult, Context, RouteHandlers$AnalyticsMetadata>> map$Entry : pathRouterMap.entrySet()) {
                Regex key = map$Entry.getKey();
                Function3<Uri, MatchResult, Context, RouteHandlers$AnalyticsMetadata> value = map$Entry.getValue();
                String path = data.getPath();
                if (path != null) {
                    m.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = key.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    try {
                        unknown = value.invoke(data, matchResultMatchEntire, context);
                    } catch (Exception unused) {
                        unknown = RouteHandlers$AnalyticsMetadata.Companion.getUNKNOWN();
                    }
                    intent.setData(Uri.EMPTY);
                    boolean z3 = !m.areEqual(unknown, RouteHandlers$AnalyticsMetadata.Companion.getUNKNOWN());
                    Logger.d$default(AppLog.g, "Intent handler activated for " + data + ", consumed: " + z3, null, 2, null);
                    notifyFirebaseUserActionStatus(intent, z3);
                    StoreStream.Companion.getAnalytics().deepLinkReceived(intent, unknown);
                    return z3;
                }
            }
        }
        notifyFirebaseUserActionStatus(intent, false);
        return false;
    }

    public final Long getDirectShareId(Intent intent) {
        m.checkNotNullParameter(intent, "$this$getDirectShareId");
        String stringExtra = intent.getStringExtra(ShortcutManagerCompat.EXTRA_SHORTCUT_ID);
        if (stringExtra != null) {
            return s.toLongOrNull(stringExtra);
        }
        return null;
    }

    public final boolean isDiscordAppUri(Uri uri) {
        String lowerCase;
        int iHashCode;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        if (t.equals(uri.getScheme(), "discord", true)) {
            String host = uri.getHost();
            if (host != null) {
                Locale locale = Locale.ENGLISH;
                m.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                lowerCase = host.toLowerCase(locale);
                m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null && ((iHashCode = lowerCase.hashCode()) == -1422950858 ? lowerCase.equals("action") : iHashCode == 96801 && lowerCase.equals("app"))) {
                return true;
            }
        }
        return false;
    }

    public final boolean isHttpDomainUrl(Uri uri) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        Regex regex = new Regex("https?", i.IGNORE_CASE);
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        m.checkNotNullExpressionValue(scheme, "uri.scheme ?: \"\"");
        if (regex.matches(scheme)) {
            return a.G.a(uri.getHost());
        }
        return false;
    }

    public final Intent toExternalizedSend(Intent intent) {
        Uri uriExternalize;
        m.checkNotNullParameter(intent, "$this$toExternalizedSend");
        Uri data = intent.getData();
        if (data == null || (uriExternalize = INSTANCE.externalize(data)) == null) {
            uriExternalize = Uri.EMPTY;
        }
        intent.setData(uriExternalize);
        IntentUtils intentUtils = INSTANCE;
        Uri data2 = intent.getData();
        intentUtils.sendText(intent, data2 != null ? data2.toString() : null);
        return intent;
    }
}
