package com.discord.utilities.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.p004pm.ShortcutManagerCompat;
import com.adjust.sdk.Constants;
import com.discord.C5419R;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIBuilder;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.logging.Logger;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p008a.p018d.p019m0.C0877a;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p365k.AbstractC4561b;
import p007b.p225i.p361c.p365k.p366c.C4562a;
import p007b.p225i.p361c.p365k.p367d.C4564b;
import p507d0.C12116o;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.EnumC12092i;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils {
    public static final IntentUtils INSTANCE = new IntentUtils();
    private static final Map<Regex, Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata>> pathRouterMap;

    /* JADX INFO: compiled from: IntentUtils.kt */
    public static final class RouteBuilders {
        public static final RouteBuilders INSTANCE = new RouteBuilders();

        /* JADX INFO: compiled from: IntentUtils.kt */
        public static final class SDK {
            public static final SDK INSTANCE = new SDK();

            private SDK() {
            }

            public static final Intent join(String deeplink, long applicationId, String secret) {
                C12238m.checkNotNullParameter(deeplink, Constants.DEEPLINK);
                return new Intent("com.discord.intent.action.SDK", Uri.parse(deeplink).buildUpon().appendPath("join").appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, String.valueOf(applicationId)).appendQueryParameter("secret", secret).build());
            }
        }

        /* JADX INFO: compiled from: IntentUtils.kt */
        public static final class Uris {
            public static final Uris INSTANCE = new Uris();

            private Uris() {
            }

            public final Uri getApp() {
                Uri uri = Uri.parse("discord://app");
                C12238m.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app\")");
                return uri;
            }

            public final Uri getOauth2Authorize() {
                Uri uri = Uri.parse("discord://action/oauth2/authorize");
                C12238m.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://action/oauth2/authorize\")");
                return uri;
            }

            public final Uri getSelectSettingsVoice() {
                Uri uri = Uri.parse("discord://app/settings/voice");
                C12238m.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app/settings/voice\")");
                return uri;
            }
        }

        private RouteBuilders() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Long] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
        public static final Intent selectChannel(long channelId, long guildId, Long messageId) {
            Object objValueOf = (guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId);
            if (messageId == 0) {
                messageId = "";
            }
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + objValueOf + MentionUtilsKt.SLASH_CHAR + channelId + MentionUtilsKt.SLASH_CHAR + messageId));
        }

        public static /* synthetic */ Intent selectChannel$default(long j, long j2, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            if ((i & 4) != 0) {
                l = null;
            }
            return selectChannel(j, j2, l);
        }

        public static final Intent selectExternalEvent(long guildId, Long eventId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/events/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId)) + MentionUtilsKt.SLASH_CHAR + eventId));
        }

        public static final Intent selectGuild(long guildId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId))));
        }

        public static final Intent selectUserProfile(long userId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/users/" + userId));
        }

        public final Intent connectVoice(long voiceChannelId) {
            return new Intent("com.discord.intent.action.CONNECT", Uri.parse("discord://app/connect/" + voiceChannelId));
        }

        public final Intent selectDirectMessage(long userId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/@me/user/" + userId));
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0037  */
        /* JADX WARN: Instruction removed from duplicated block: B:9:0x0037, please report this as an issue */
        public final Intent selectGuildTemplate(String guildTemplateText, String source) {
            Uri uri = Uri.parse(guildTemplateText);
            C12238m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (guildTemplateText != null) {
                    C0877a c0877a = C0877a.f538G;
                    if (C12103t.startsWith$default(guildTemplateText, C0877a.f543e, false, 2, null)) {
                        uri = Uri.parse("https://" + guildTemplateText);
                    } else {
                        uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
                    }
                } else {
                    uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
                }
            }
            Intent data = new Intent().setData(uri);
            C12238m.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0037  */
        /* JADX WARN: Instruction removed from duplicated block: B:9:0x0037, please report this as an issue */
        public final Intent selectInvite(String inviteText, String source) {
            Uri uri = Uri.parse(inviteText);
            C12238m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (inviteText != null) {
                    C0877a c0877a = C0877a.f538G;
                    if (C12103t.startsWith$default(inviteText, C0877a.f542d, false, 2, null)) {
                        uri = Uri.parse("https://" + inviteText);
                    } else {
                        uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
                    }
                } else {
                    uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
                }
            }
            Intent data = new Intent().setData(uri);
            C12238m.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.IntentUtils$consumeExternalRoutingIntent$1 */
    /* JADX INFO: compiled from: IntentUtils.kt */
    public static final class C67831 extends AbstractC12240o implements Function2<Uri, Boolean, Unit> {
        public final /* synthetic */ Intent $intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67831(Intent intent) {
            super(2);
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(Uri uri, boolean z2) {
            C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Map<String, Object> mapBuildTrackingData = NotificationClient.INSTANCE.buildTrackingData(this.$intent);
            Iterator<T> it = mapBuildTrackingData.keySet().iterator();
            while (it.hasNext()) {
                this.$intent.removeExtra((String) it.next());
            }
            AnalyticsTracker.appNotificationClicked(mapBuildTrackingData);
            AppStartAnalyticsTracker.INSTANCE.getInstance().appOpen(uri, z2, !mapBuildTrackingData.isEmpty());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.IntentUtils$consumeRoutingIntent$1 */
    /* JADX INFO: compiled from: IntentUtils.kt */
    public static final class C67841 extends AbstractC12240o implements Function2<Uri, Boolean, Unit> {
        public static final C67841 INSTANCE = new C67841();

        public C67841() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(Uri uri, boolean z2) {
            C12238m.checkNotNullParameter(uri, "<anonymous parameter 0>");
        }
    }

    static {
        C0877a c0877a = C0877a.f538G;
        Regex regex = C0877a.f537F;
        RouteHandlers routeHandlers = RouteHandlers.INSTANCE;
        pathRouterMap = C12136h0.mapOf(C12116o.m10073to(C0877a.f558t, IntentUtils$pathRouterMap$1.INSTANCE), C12116o.m10073to(C0877a.f559u, IntentUtils$pathRouterMap$2.INSTANCE), C12116o.m10073to(regex, new IntentUtils$pathRouterMap$3(routeHandlers)), C12116o.m10073to(C0877a.f560v, new IntentUtils$pathRouterMap$4(routeHandlers)), C12116o.m10073to(C0877a.f562x, new IntentUtils$pathRouterMap$5(routeHandlers)), C12116o.m10073to(C0877a.f563y, new IntentUtils$pathRouterMap$6(routeHandlers)), C12116o.m10073to(C0877a.f564z, new IntentUtils$pathRouterMap$7(routeHandlers)), C12116o.m10073to(C0877a.f532A, new IntentUtils$pathRouterMap$8(routeHandlers)), C12116o.m10073to(C0877a.f557s, new IntentUtils$pathRouterMap$9(routeHandlers)), C12116o.m10073to(C0877a.f561w, new IntentUtils$pathRouterMap$10(routeHandlers)), C12116o.m10073to(C0877a.f534C, new IntentUtils$pathRouterMap$11(routeHandlers)), C12116o.m10073to(C0877a.f535D, new IntentUtils$pathRouterMap$12(routeHandlers)), C12116o.m10073to(C0877a.f536E, new IntentUtils$pathRouterMap$13(routeHandlers)), C12116o.m10073to(C0877a.f533B, new IntentUtils$pathRouterMap$14(routeHandlers)), C12116o.m10073to(C0877a.f551m, new IntentUtils$pathRouterMap$15(routeHandlers)));
    }

    private IntentUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean consumeRoutingIntent$default(IntentUtils intentUtils, Intent intent, Context context, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = C67841.INSTANCE;
        }
        return intentUtils.consumeRoutingIntent(intent, context, function2);
    }

    private final Uri externalize(Uri uri) {
        Uri.Builder builderScheme = uri.buildUpon().scheme(Constants.SCHEME);
        C0877a c0877a = C0877a.f538G;
        return builderScheme.authority(C0877a.f539a).build();
    }

    private final void notifyFirebaseUserActionStatus(Intent intent, boolean isHandledSuccessfully) {
        String stringExtra = intent.getStringExtra("actions.fulfillment.extra.ACTION_TOKEN");
        if (stringExtra != null) {
            C12238m.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(In…A_VOICE_ACTION) ?: return");
            String str = isHandledSuccessfully ? "http://schema.org/CompletedActionStatus" : "http://schema.org/FailedActionStatus";
            C4562a c4562a = new C4562a();
            c4562a.f12169f = stringExtra;
            c4562a.f12167e = str;
            C1460d.m595z(stringExtra, "setActionToken is required before calling build().");
            C1460d.m595z(new String(c4562a.f12167e), "setActionStatus is required before calling build().");
            c4562a.m6344a("actionToken", c4562a.f12169f);
            AbstractC4561b c4564b = null;
            if ((c4562a.f12165c == null ? null : new String(c4562a.f12165c)) == null) {
                c4562a.f12165c = "AssistAction";
                c4562a.m6344a(ModelAuditLogEntry.CHANGE_KEY_NAME, "AssistAction");
            }
            if ((c4562a.f12166d == null ? null : new String(c4562a.f12166d)) == null) {
                String strValueOf = String.valueOf(c4562a.f12169f);
                String strConcat = strValueOf.length() != 0 ? "https://developers.google.com/actions?invocation=".concat(strValueOf) : new String("https://developers.google.com/actions?invocation=");
                Objects.requireNonNull(strConcat, "null reference");
                c4562a.f12166d = strConcat;
                c4562a.m6344a("url", strConcat);
            }
            C1460d.m595z(c4562a.f12165c, "setObject is required before calling build().");
            C1460d.m595z(c4562a.f12166d, "setObject is required before calling build().");
            zza zzaVar = new zza(c4562a.f12164b, c4562a.f12165c, c4562a.f12166d, null, new zzc(true), c4562a.f12167e, c4562a.f12163a);
            synchronized (AbstractC4561b.class) {
                WeakReference<AbstractC4561b> weakReference = AbstractC4561b.f12168a;
                if (weakReference != null) {
                    c4564b = weakReference.get();
                }
                if (c4564b == null) {
                    C4542c c4542cM6327b = C4542c.m6327b();
                    c4542cM6327b.m6330a();
                    c4564b = new C4564b(c4542cM6327b.f12118d);
                    AbstractC4561b.f12168a = new WeakReference<>(c4564b);
                }
            }
            c4564b.mo6345a(zzaVar);
        }
    }

    public static final void performChooserSendIntent(Context context, String str) {
        performChooserSendIntent$default(context, str, null, 4, null);
    }

    public static final void performChooserSendIntent(Context context, String text, CharSequence chooserText) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        C12238m.checkNotNullParameter(chooserText, "chooserText");
        context.startActivity(Intent.createChooser(INSTANCE.sendText(new Intent("android.intent.action.SEND"), text), chooserText));
    }

    public static /* synthetic */ void performChooserSendIntent$default(Context context, String str, CharSequence charSequence, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence = context.getString(C5419R.string.share);
            C12238m.checkNotNullExpressionValue(charSequence, "context.getString(R.string.share)");
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
        C12238m.checkNotNullParameter(intent, "intent");
        C12238m.checkNotNullParameter(context, "context");
        StoreStream.INSTANCE.getDynamicLinkCache().storeLinkIfExists(intent, context);
        return consumeRoutingIntent(intent, context, new C67831(intent));
    }

    public final boolean consumeRoutingIntent(Intent intent, Context context, Function2<? super Uri, ? super Boolean, Unit> callback) {
        MatchResult matchResultMatchEntire;
        RouteHandlers.AnalyticsMetadata unknown;
        C12238m.checkNotNullParameter(intent, "intent");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(callback, "callback");
        Uri data = intent.getData();
        if (data == null) {
            data = Uri.EMPTY;
        }
        C12238m.checkNotNullExpressionValue(data, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        boolean z2 = isDiscordAppUri(data) || isHttpDomainUrl(data);
        callback.invoke(data, Boolean.valueOf(z2));
        if (z2) {
            AppLog appLog = AppLog.f14950g;
            String simpleName = IntentUtils.class.getSimpleName();
            C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            String string = data.toString();
            if (string == null) {
                string = "<null>";
            }
            C12238m.checkNotNullExpressionValue(string, "uri?.toString() ?: \"<null>\"");
            appLog.m8365f(simpleName, string);
            for (Map.Entry<Regex, Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata>> entry : pathRouterMap.entrySet()) {
                Regex key = entry.getKey();
                Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> value = entry.getValue();
                String path = data.getPath();
                if (path != null) {
                    C12238m.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = key.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    try {
                        unknown = value.invoke(data, matchResultMatchEntire, context);
                    } catch (Exception unused) {
                        unknown = RouteHandlers.AnalyticsMetadata.INSTANCE.getUNKNOWN();
                    }
                    intent.setData(Uri.EMPTY);
                    boolean z3 = !C12238m.areEqual(unknown, RouteHandlers.AnalyticsMetadata.INSTANCE.getUNKNOWN());
                    Logger.d$default(AppLog.f14950g, "Intent handler activated for " + data + ", consumed: " + z3, null, 2, null);
                    notifyFirebaseUserActionStatus(intent, z3);
                    StoreStream.INSTANCE.getAnalytics().deepLinkReceived(intent, unknown);
                    return z3;
                }
            }
        }
        notifyFirebaseUserActionStatus(intent, false);
        return false;
    }

    public final Long getDirectShareId(Intent intent) {
        C12238m.checkNotNullParameter(intent, "$this$getDirectShareId");
        String stringExtra = intent.getStringExtra(ShortcutManagerCompat.EXTRA_SHORTCUT_ID);
        if (stringExtra != null) {
            return C12102s.toLongOrNull(stringExtra);
        }
        return null;
    }

    public final boolean isDiscordAppUri(Uri uri) {
        String lowerCase;
        int iHashCode;
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (C12103t.equals(uri.getScheme(), "discord", true)) {
            String host = uri.getHost();
            if (host != null) {
                Locale locale = Locale.ENGLISH;
                C12238m.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                lowerCase = host.toLowerCase(locale);
                C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
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
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Regex regex = new Regex("https?", EnumC12092i.IGNORE_CASE);
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        C12238m.checkNotNullExpressionValue(scheme, "uri.scheme ?: \"\"");
        if (regex.matches(scheme)) {
            return C0877a.f538G.m173a(uri.getHost());
        }
        return false;
    }

    public final Intent toExternalizedSend(Intent intent) {
        Uri uriExternalize;
        C12238m.checkNotNullParameter(intent, "$this$toExternalizedSend");
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
