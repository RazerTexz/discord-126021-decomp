package com.discord.utilities.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import b.a.d.m0.RoutingPatterns;
import b.c.a.a0.AnimatableValueParser;
import b.i.c.FirebaseApp2;
import b.i.c.k.b;
import b.i.c.k.c.a;
import com.adjust.sdk.Constants;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIBuilder;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.logging.Logger;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;
import d0.Tuples;
import d0.g0.Regex5;
import d0.g0.StringNumberConversions;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
                Intrinsics3.checkNotNullParameter(deeplink, Constants.DEEPLINK);
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
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app\")");
                return uri;
            }

            public final Uri getOauth2Authorize() {
                Uri uri = Uri.parse("discord://action/oauth2/authorize");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://action/oauth2/authorize\")");
                return uri;
            }

            public final Uri getSelectSettingsVoice() {
                Uri uri = Uri.parse("discord://app/settings/voice");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app/settings/voice\")");
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
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + objValueOf + MentionUtils.SLASH_CHAR + channelId + MentionUtils.SLASH_CHAR + messageId));
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
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/events/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId)) + MentionUtils.SLASH_CHAR + eventId));
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
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (guildTemplateText != null) {
                    RoutingPatterns routingPatterns = RoutingPatterns.G;
                    if (StringsJVM.startsWith$default(guildTemplateText, RoutingPatterns.e, false, 2, null)) {
                        uri = Uri.parse("https://" + guildTemplateText);
                    } else {
                        uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
                    }
                } else {
                    uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
                }
            }
            Intent data = new Intent().setData(uri);
            Intrinsics3.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0037  */
        /* JADX WARN: Instruction removed from duplicated block: B:9:0x0037, please report this as an issue */
        public final Intent selectInvite(String inviteText, String source) {
            Uri uri = Uri.parse(inviteText);
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (inviteText != null) {
                    RoutingPatterns routingPatterns = RoutingPatterns.G;
                    if (StringsJVM.startsWith$default(inviteText, RoutingPatterns.d, false, 2, null)) {
                        uri = Uri.parse("https://" + inviteText);
                    } else {
                        uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
                    }
                } else {
                    uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
                }
            }
            Intent data = new Intent().setData(uri);
            Intrinsics3.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.IntentUtils$consumeExternalRoutingIntent$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntentUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Uri, Boolean, Unit> {
        public final /* synthetic */ Intent $intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Intent intent) {
            super(2);
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(Uri uri, boolean z2) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Map<String, Object> mapBuildTrackingData = NotificationClient.INSTANCE.buildTrackingData(this.$intent);
            Iterator<T> it = mapBuildTrackingData.keySet().iterator();
            while (it.hasNext()) {
                this.$intent.removeExtra((String) it.next());
            }
            AnalyticsTracker.appNotificationClicked(mapBuildTrackingData);
            AppStartAnalyticsTracker.INSTANCE.getInstance().appOpen(uri, z2, !mapBuildTrackingData.isEmpty());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.IntentUtils$consumeRoutingIntent$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntentUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Uri, Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(Uri uri, boolean z2) {
            Intrinsics3.checkNotNullParameter(uri, "<anonymous parameter 0>");
        }
    }

    static {
        RoutingPatterns routingPatterns = RoutingPatterns.G;
        Regex regex = RoutingPatterns.F;
        RouteHandlers routeHandlers = RouteHandlers.INSTANCE;
        pathRouterMap = Maps6.mapOf(Tuples.to(RoutingPatterns.t, IntentUtils$pathRouterMap$1.INSTANCE), Tuples.to(RoutingPatterns.u, IntentUtils$pathRouterMap$2.INSTANCE), Tuples.to(regex, new IntentUtils$pathRouterMap$3(routeHandlers)), Tuples.to(RoutingPatterns.v, new IntentUtils$pathRouterMap$4(routeHandlers)), Tuples.to(RoutingPatterns.f62x, new IntentUtils$pathRouterMap$5(routeHandlers)), Tuples.to(RoutingPatterns.f63y, new IntentUtils$pathRouterMap$6(routeHandlers)), Tuples.to(RoutingPatterns.f64z, new IntentUtils$pathRouterMap$7(routeHandlers)), Tuples.to(RoutingPatterns.A, new IntentUtils$pathRouterMap$8(routeHandlers)), Tuples.to(RoutingPatterns.f61s, new IntentUtils$pathRouterMap$9(routeHandlers)), Tuples.to(RoutingPatterns.w, new IntentUtils$pathRouterMap$10(routeHandlers)), Tuples.to(RoutingPatterns.C, new IntentUtils$pathRouterMap$11(routeHandlers)), Tuples.to(RoutingPatterns.D, new IntentUtils$pathRouterMap$12(routeHandlers)), Tuples.to(RoutingPatterns.E, new IntentUtils$pathRouterMap$13(routeHandlers)), Tuples.to(RoutingPatterns.B, new IntentUtils$pathRouterMap$14(routeHandlers)), Tuples.to(RoutingPatterns.m, new IntentUtils$pathRouterMap$15(routeHandlers)));
    }

    private IntentUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean consumeRoutingIntent$default(IntentUtils intentUtils, Intent intent, Context context, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = AnonymousClass1.INSTANCE;
        }
        return intentUtils.consumeRoutingIntent(intent, context, function2);
    }

    private final Uri externalize(Uri uri) {
        Uri.Builder builderScheme = uri.buildUpon().scheme(Constants.SCHEME);
        RoutingPatterns routingPatterns = RoutingPatterns.G;
        return builderScheme.authority(RoutingPatterns.a).build();
    }

    private final void notifyFirebaseUserActionStatus(Intent intent, boolean isHandledSuccessfully) {
        String stringExtra = intent.getStringExtra("actions.fulfillment.extra.ACTION_TOKEN");
        if (stringExtra != null) {
            Intrinsics3.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(In…A_VOICE_ACTION) ?: return");
            String str = isHandledSuccessfully ? "http://schema.org/CompletedActionStatus" : "http://schema.org/FailedActionStatus";
            a aVar = new a();
            aVar.f = stringExtra;
            aVar.e = str;
            AnimatableValueParser.z(stringExtra, "setActionToken is required before calling build().");
            AnimatableValueParser.z(new String(aVar.e), "setActionStatus is required before calling build().");
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
            AnimatableValueParser.z(aVar.c, "setObject is required before calling build().");
            AnimatableValueParser.z(aVar.d, "setObject is required before calling build().");
            zza zzaVar = new zza(aVar.f1660b, aVar.c, aVar.d, null, new zzc(true), aVar.e, aVar.a);
            synchronized (b.class) {
                WeakReference<b> weakReference = b.a;
                if (weakReference != null) {
                    bVar = weakReference.get();
                }
                if (bVar == null) {
                    FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
                    firebaseApp2B.a();
                    bVar = new b.i.c.k.d.b(firebaseApp2B.d);
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
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(chooserText, "chooserText");
        context.startActivity(Intent.createChooser(INSTANCE.sendText(new Intent("android.intent.action.SEND"), text), chooserText));
    }

    public static /* synthetic */ void performChooserSendIntent$default(Context context, String str, CharSequence charSequence, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence = context.getString(R.string.share);
            Intrinsics3.checkNotNullExpressionValue(charSequence, "context.getString(R.string.share)");
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
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        StoreStream.INSTANCE.getDynamicLinkCache().storeLinkIfExists(intent, context);
        return consumeRoutingIntent(intent, context, new AnonymousClass1(intent));
    }

    public final boolean consumeRoutingIntent(Intent intent, Context context, Function2<? super Uri, ? super Boolean, Unit> callback) {
        MatchResult matchResultMatchEntire;
        RouteHandlers.AnalyticsMetadata unknown;
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(callback, "callback");
        Uri data = intent.getData();
        if (data == null) {
            data = Uri.EMPTY;
        }
        Intrinsics3.checkNotNullExpressionValue(data, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        boolean z2 = isDiscordAppUri(data) || isHttpDomainUrl(data);
        callback.invoke(data, Boolean.valueOf(z2));
        if (z2) {
            AppLog appLog = AppLog.g;
            String simpleName = IntentUtils.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            String string = data.toString();
            if (string == null) {
                string = "<null>";
            }
            Intrinsics3.checkNotNullExpressionValue(string, "uri?.toString() ?: \"<null>\"");
            appLog.f(simpleName, string);
            for (Map.Entry<Regex, Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata>> entry : pathRouterMap.entrySet()) {
                Regex key = entry.getKey();
                Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> value = entry.getValue();
                String path = data.getPath();
                if (path != null) {
                    Intrinsics3.checkNotNullExpressionValue(path, "it");
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
                    boolean z3 = !Intrinsics3.areEqual(unknown, RouteHandlers.AnalyticsMetadata.INSTANCE.getUNKNOWN());
                    Logger.d$default(AppLog.g, "Intent handler activated for " + data + ", consumed: " + z3, null, 2, null);
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
        Intrinsics3.checkNotNullParameter(intent, "$this$getDirectShareId");
        String stringExtra = intent.getStringExtra(ShortcutManagerCompat.EXTRA_SHORTCUT_ID);
        if (stringExtra != null) {
            return StringNumberConversions.toLongOrNull(stringExtra);
        }
        return null;
    }

    public final boolean isDiscordAppUri(Uri uri) {
        String lowerCase;
        int iHashCode;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (StringsJVM.equals(uri.getScheme(), "discord", true)) {
            String host = uri.getHost();
            if (host != null) {
                Locale locale = Locale.ENGLISH;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                lowerCase = host.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
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
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Regex regex = new Regex("https?", Regex5.IGNORE_CASE);
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        Intrinsics3.checkNotNullExpressionValue(scheme, "uri.scheme ?: \"\"");
        if (regex.matches(scheme)) {
            return RoutingPatterns.G.a(uri.getHost());
        }
        return false;
    }

    public final Intent toExternalizedSend(Intent intent) {
        Uri uriExternalize;
        Intrinsics3.checkNotNullParameter(intent, "$this$toExternalizedSend");
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
