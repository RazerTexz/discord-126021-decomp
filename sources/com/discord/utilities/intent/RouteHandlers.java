package com.discord.utilities.intent;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.a0.WidgetGiftAcceptDialog;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.StaticChannelRoutes;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guild_role_subscriptions.RoleSubscriptionsLinkingUtil;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.media.WidgetQRScanner;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.Tuples;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KFunction;
import kotlin.text.MatchResult;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers {
    public static final RouteHandlers INSTANCE = new RouteHandlers();

    /* JADX INFO: compiled from: RouteHandlers.kt */
    public static final class AnalyticsMetadata {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final AnalyticsMetadata UNKNOWN = new AnalyticsMetadata(EnvironmentCompat.MEDIA_UNKNOWN, null, null, 6, null);
        private final Long channelId;
        private final Long guildId;
        private final String type;

        /* JADX INFO: compiled from: RouteHandlers.kt */
        public static final class Companion {
            private Companion() {
            }

            public final AnalyticsMetadata getUNKNOWN() {
                return AnalyticsMetadata.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AnalyticsMetadata(String str, Long l, Long l2) {
            Intrinsics3.checkNotNullParameter(str, "type");
            this.type = str;
            this.guildId = l;
            this.channelId = l2;
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final String getType() {
            return this.type;
        }

        public /* synthetic */ AnalyticsMetadata(String str, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StaticChannelRoutes.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[StaticChannelRoutes.ROLE_SUBSCRIPTIONS.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.RouteHandlers$handleQuery$1, reason: invalid class name */
    /* JADX INFO: compiled from: RouteHandlers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public final /* synthetic */ String $query;
        public final /* synthetic */ String $queryMessageText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(1);
            this.$queryMessageText = str;
            this.$query = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "ctx");
            if (this.$queryMessageText.length() > 0) {
                WidgetIncomingShare.INSTANCE.launch(fragmentActivity, this.$queryMessageText, this.$query);
            } else {
                WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "ctx.supportFragmentManager");
                companion.show(supportFragmentManager, this.$query);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.RouteHandlers$selectFeature$1, reason: invalid class name */
    /* JADX INFO: compiled from: RouteHandlers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public final /* synthetic */ Map $settingMap;
        public final /* synthetic */ String $settingsSubPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, String str) {
            super(1);
            this.$settingMap = map;
            this.$settingsSubPath = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "ctx");
            Function1 function1 = (Function1) this.$settingMap.get(this.$settingsSubPath);
            if (function1 == null) {
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.RouteHandlers$voiceConnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: RouteHandlers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $isServicePermissionDeniedRedirect;
        public final /* synthetic */ WeakReference $weakContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WeakReference weakReference, long j, boolean z2) {
            super(1);
            this.$weakContext = weakReference;
            this.$channelId = j;
            this.$isServicePermissionDeniedRedirect = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Context context = (Context) this.$weakContext.get();
            if (context != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "weakContext.get() ?: return@appSubscribe");
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                if (ChannelUtils.B(channel)) {
                    return;
                }
                StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, context, this.$channelId, this.$isServicePermissionDeniedRedirect, null, null, 24, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: RouteHandlers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, KFunction<? extends AnalyticsMetadata>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RouteHandlers.kt */
        public static final /* synthetic */ class C02171 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, AnalyticsMetadata> {
            public C02171(RouteHandlers routeHandlers) {
                super(3, routeHandlers, RouteHandlers.class, "acceptGift", "acceptGift(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
                Intrinsics3.checkNotNullParameter(uri, "p1");
                Intrinsics3.checkNotNullParameter(context, "p3");
                return ((RouteHandlers) this.receiver).acceptGift(uri, matchResult, context);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: RouteHandlers.kt */
        public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, AnalyticsMetadata> {
            public AnonymousClass2(RouteHandlers routeHandlers) {
                super(3, routeHandlers, RouteHandlers.class, "useInvite", "useInvite(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
                Intrinsics3.checkNotNullParameter(uri, "p1");
                Intrinsics3.checkNotNullParameter(context, "p3");
                return ((RouteHandlers) this.receiver).useInvite(uri, matchResult, context);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: RouteHandlers.kt */
        public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, AnalyticsMetadata> {
            public AnonymousClass3(RouteHandlers routeHandlers) {
                super(3, routeHandlers, RouteHandlers.class, "useGuildTemplate", "useGuildTemplate(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
                Intrinsics3.checkNotNullParameter(uri, "p1");
                Intrinsics3.checkNotNullParameter(context, "p3");
                return ((RouteHandlers) this.receiver).useGuildTemplate(uri, matchResult, context);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        
            if (r2.equals("discord.gg") != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        
            if (r2.equals("gift") != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        
            if (r2.equals("discord.new") != false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        
            if (r2.equals("invite") != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        
            if (r2.equals("template") != false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        
            return new com.discord.utilities.intent.RouteHandlers.AnonymousClass1.C02171(com.discord.utilities.intent.RouteHandlers.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        
            return new com.discord.utilities.intent.RouteHandlers.AnonymousClass1.AnonymousClass2(com.discord.utilities.intent.RouteHandlers.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        
            return new com.discord.utilities.intent.RouteHandlers.AnonymousClass1.AnonymousClass3(com.discord.utilities.intent.RouteHandlers.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
        
            if (r2.equals("discord.gift") != false) goto L15;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // kotlin.jvm.functions.Function1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final KFunction<AnalyticsMetadata> invoke(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1321546630:
                        break;
                    case -1183699191:
                        break;
                    case -633644578:
                        break;
                    case 3172656:
                        break;
                    case 533748962:
                        break;
                    case 1831649458:
                        break;
                }
            }
            return null;
        }
    }

    private RouteHandlers() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    private final AnalyticsMetadata acceptGift(Uri uri, MatchResult matchResult, Context context) {
        String str;
        List<String> groupValues;
        String str2 = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues);
        String queryParameter = uri.getQueryParameter("source");
        if (queryParameter != null) {
            Intrinsics3.checkNotNullExpressionValue(queryParameter, "it");
            str = StringsJVM.isBlank(queryParameter) ^ true ? queryParameter : null;
            if (str == null) {
                str = StoreInviteSettings.LOCATION_DEEPLINK;
            }
        } else {
            str = StoreInviteSettings.LOCATION_DEEPLINK;
        }
        Intrinsics3.checkNotNullExpressionValue(str, "uri.getQueryParameter(\"s…ettings.LOCATION_DEEPLINK");
        if (str2 != null && (!StringsJVM.isBlank(str2))) {
            WidgetGiftAcceptDialog.INSTANCE.a(str2, str, 0L);
        }
        return new AnalyticsMetadata("gift", null, null, 6, null);
    }

    private final AnalyticsMetadata useGuildTemplate(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues);
        if (str != null) {
            StoreStream.INSTANCE.getGuildTemplates().setDynamicLinkGuildTemplateCode(str);
        }
        return new AnalyticsMetadata("guild_template", null, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003a  */
    private final AnalyticsMetadata useInvite(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues);
        if (!(!Intrinsics3.areEqual(str, "invite"))) {
            str = null;
        }
        String queryParameter = uri.getQueryParameter("source");
        if (queryParameter != null) {
            Intrinsics3.checkNotNullExpressionValue(queryParameter, "it");
            if (!(!StringsJVM.isBlank(queryParameter))) {
                queryParameter = null;
            }
            if (queryParameter == null) {
                queryParameter = StoreInviteSettings.LOCATION_DEEPLINK;
            }
        } else {
            queryParameter = StoreInviteSettings.LOCATION_DEEPLINK;
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(\"s…        ?: inviteLocation");
        String queryParameter2 = uri.getQueryParameter("event");
        Long snowflake = queryParameter2 != null ? SnowflakeUtils.INSTANCE.toSnowflake(queryParameter2) : null;
        if (str != null) {
            StoreStream.INSTANCE.getInviteSettings().setInviteCode(str, queryParameter, snowflake);
        } else {
            WidgetGuildJoin.INSTANCE.show(context, StoreInviteSettings.LOCATION_DEEPLINK);
        }
        return new AnalyticsMetadata("invite", null, null, 6, null);
    }

    public final AnalyticsMetadata authorize(Uri uri, MatchResult matchResult, Context context) {
        boolean zAreEqual;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 22) {
            zAreEqual = false;
        } else {
            Uri referrer = ((Activity) context).getReferrer();
            zAreEqual = Intrinsics3.areEqual(referrer != null ? referrer.getAuthority() : null, BuildConfig.APPLICATION_ID);
        }
        Uri uriBuild = uri.buildUpon().appendQueryParameter("internal_referrer", String.valueOf(zAreEqual)).build();
        StoreAuthentication authentication = StoreStream.INSTANCE.getAuthentication();
        Intrinsics3.checkNotNullExpressionValue(uriBuild, "oAuthUri");
        authentication.setOAuthUriSubject(uriBuild);
        return new AnalyticsMetadata("oauth2", null, null, 6, null);
    }

    public final AnalyticsMetadata handleQuery(Uri uri, MatchResult matchResult, Context context) {
        String str;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        String queryParameter = uri.getQueryParameter("type");
        String queryParameter2 = uri.getQueryParameter("channelName");
        String str2 = "";
        String str3 = queryParameter2 != null ? queryParameter2 : "";
        Intrinsics3.checkNotNullExpressionValue(str3, "uri.getQueryParameter(\"channelName\") ?: \"\"");
        String queryParameter3 = uri.getQueryParameter("serverName");
        if (queryParameter3 == null) {
            queryParameter3 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter3, "uri.getQueryParameter(\"serverName\") ?: \"\"");
        String queryParameter4 = uri.getQueryParameter("userName");
        if (queryParameter4 == null) {
            queryParameter4 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter4, "uri.getQueryParameter(\"userName\") ?: \"\"");
        String queryParameter5 = uri.getQueryParameter("userNameAlt");
        if (queryParameter5 == null) {
            queryParameter5 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter5, "uri.getQueryParameter(\"userNameAlt\") ?: \"\"");
        String queryParameter6 = uri.getQueryParameter("messageText");
        if (queryParameter6 == null) {
            queryParameter6 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter6, "uri.getQueryParameter(\"messageText\") ?: \"\"");
        if (queryParameter != null) {
            int iHashCode = queryParameter.hashCode();
            if (iHashCode != -905826493) {
                if (iHashCode != 3599307) {
                    if (iHashCode == 738950403 && queryParameter.equals("channel")) {
                        List listSplit$default = Strings4.split$default((CharSequence) str3, new String[]{" in "}, false, 0, 6, (Object) null);
                        String str4 = (String) (Collections2.getLastIndex(listSplit$default) >= 0 ? listSplit$default.get(0) : "");
                        String str5 = (String) (1 <= Collections2.getLastIndex(listSplit$default) ? listSplit$default.get(1) : "");
                        if (str5.length() > 0) {
                            str2 = ' ' + str5;
                        }
                        str = MentionUtils.CHANNELS_CHAR + str4 + str2;
                        StoreStream.INSTANCE.getNavigation().launchNotice("DEEPLINK_QUERY", new AnonymousClass1(queryParameter6, str));
                        return new AnalyticsMetadata("query", null, null, 6, null);
                    }
                } else if (queryParameter.equals("user")) {
                    if (!(queryParameter4.length() > 0)) {
                        queryParameter4 = queryParameter5;
                    }
                    if (queryParameter4.length() == 0) {
                        return AnalyticsMetadata.INSTANCE.getUNKNOWN();
                    }
                    str = MentionUtils.MENTIONS_CHAR + queryParameter4;
                    StoreStream.INSTANCE.getNavigation().launchNotice("DEEPLINK_QUERY", new AnonymousClass1(queryParameter6, str));
                    return new AnalyticsMetadata("query", null, null, 6, null);
                }
            } else if (queryParameter.equals("server")) {
                str = '*' + queryParameter3;
                StoreStream.INSTANCE.getNavigation().launchNotice("DEEPLINK_QUERY", new AnonymousClass1(queryParameter6, str));
                return new AnalyticsMetadata("query", null, null, 6, null);
            }
        }
        return AnalyticsMetadata.INSTANCE.getUNKNOWN();
    }

    public final AnalyticsMetadata navigateToFriendsScreen(Uri uri, MatchResult matchResult, Context context) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        StoreStream.INSTANCE.getTabsNavigation().selectTab(NavigationTab.FRIENDS, true);
        return new AnalyticsMetadata("friends", null, null, 6, null);
    }

    public final AnalyticsMetadata openEventDetails(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long j = 0;
        long j2 = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = groupValues2.get(1)) == null) ? 0L : Long.parseLong(str2);
        if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null && (str = groupValues.get(2)) != null) {
            j = Long.parseLong(str);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Guild guild = companion.getGuilds().getGuild(j2);
        Channel channel = guild == null ? companion.getChannels().getChannel(j2) : null;
        if (guild == null && channel == null) {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.handleInvalidEvent(context);
        } else {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(j);
            if (guild == null) {
                guild = channel != null ? companion.getGuilds().getGuild(channel.getGuildId()) : null;
            }
            if (guild != null) {
                companion.getGuildSelected().set(guild.getId());
            }
        }
        return new AnalyticsMetadata("event", null, null, 6, null);
    }

    public final AnalyticsMetadata remoteAuth(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (((matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues)) != null) {
            WidgetQRScanner.INSTANCE.launch(context, true);
        }
        return new AnalyticsMetadata("remoteAuth", null, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    public final AnalyticsMetadata selectChannel(Context context, Uri uri, MatchResult matchResult) {
        long jLongValue;
        List<String> groupValues;
        String str;
        Long longOrNull;
        List<String> groupValues2;
        String str2;
        Long longOrNull2;
        List<String> groupValues3;
        String str3;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (matchResult == null || (groupValues3 = matchResult.getGroupValues()) == null || (str3 = (String) _Collections.getOrNull(groupValues3, 1)) == null) {
            jLongValue = 0;
        } else {
            Long longOrNull3 = Intrinsics3.areEqual(str3, "@me") ? 0L : StringNumberConversions.toLongOrNull(str3);
            if (longOrNull3 != null) {
                jLongValue = longOrNull3.longValue();
            } else {
                jLongValue = 0;
            }
        }
        long jLongValue2 = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = (String) _Collections.getOrNull(groupValues2, 2)) == null || (longOrNull2 = StringNumberConversions.toLongOrNull(str2)) == null) ? 0L : longOrNull2.longValue();
        long jLongValue3 = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) _Collections.getOrNull(groupValues, 3)) == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreTabsNavigation tabsNavigation = companion.getTabsNavigation();
        if (jLongValue2 == 0 && jLongValue3 == 0 && jLongValue != 0) {
            companion.getGuildSelected().set(jLongValue);
            tabsNavigation.selectHomeTab(StoreNavigation.PanelAction.CLOSE, true);
        } else if (jLongValue3 == 0) {
            if ((companion.getChannels().findChannelById(jLongValue2) == null) && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, jLongValue, null, 2, null)) {
                ChannelSelector.INSTANCE.getInstance().findAndSetThread(context, jLongValue2);
            } else {
                ChannelSelector.INSTANCE.getInstance().findAndSet(context, jLongValue2);
            }
            tabsNavigation.selectHomeTab(StoreNavigation.PanelAction.CLOSE, true);
        } else {
            companion.getMessagesLoader().jumpToMessage(jLongValue2, jLongValue3);
        }
        return new AnalyticsMetadata("channel", Long.valueOf(jLongValue), Long.valueOf(jLongValue2));
    }

    public final AnalyticsMetadata selectDirectMessage(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Long longOrNull;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null && (str = (String) _Collections.last((List) groupValues)) != null && (longOrNull = StringNumberConversions.toLongOrNull(str)) != null) {
            ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(context, longOrNull.longValue());
        }
        return new AnalyticsMetadata("DM", null, null, 6, null);
    }

    public final AnalyticsMetadata selectFeature(Uri uri, MatchResult matchResult, Context context) {
        String str;
        List<String> groupValues;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) _Collections.getOrNull(groupValues, 1)) == null) {
            str = "";
        }
        String str2 = str;
        Map mapMapOf = Maps6.mapOf(Tuples.to("/account", RouteHandlers$selectFeature$settingMap$1.INSTANCE), Tuples.to("/nitro", RouteHandlers$selectFeature$settingMap$2.INSTANCE), Tuples.to("/voice", RouteHandlers$selectFeature$settingMap$3.INSTANCE), Tuples.to("/createServer", RouteHandlers$selectFeature$settingMap$4.INSTANCE), Tuples.to("/quickSwitcher", RouteHandlers$selectFeature$settingMap$5.INSTANCE), Tuples.to("/friends", RouteHandlers$selectFeature$settingMap$6.INSTANCE), Tuples.to("/mentions", RouteHandlers$selectFeature$settingMap$7.INSTANCE), Tuples.to("/settings", RouteHandlers$selectFeature$settingMap$8.INSTANCE), Tuples.to("/contactSync", RouteHandlers$selectFeature$settingMap$9.INSTANCE), Tuples.to("/addFriends", RouteHandlers$selectFeature$settingMap$10.INSTANCE), Tuples.to("/editProfile", RouteHandlers$selectFeature$settingMap$11.INSTANCE), Tuples.to("/voiceChannel", new RouteHandlers$selectFeature$settingMap$12(uri)), Tuples.to("/xboxLinkBeta", RouteHandlers$selectFeature$settingMap$13.INSTANCE));
        StoreStream.INSTANCE.getNavigation().launchNotice(outline.w("ROUTING:", str2), new AnonymousClass1(mapMapOf, str2));
        return mapMapOf.containsKey(str2) ? new AnalyticsMetadata(str2, null, null, 6, null) : AnalyticsMetadata.INSTANCE.getUNKNOWN();
    }

    public final AnalyticsMetadata selectLurk(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long j = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = groupValues2.get(1)) == null) ? 0L : Long.parseLong(str2);
        Long longOrNull = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(2)) == null) ? null : StringNumberConversions.toLongOrNull(str);
        StoreStream.INSTANCE.getLurking().startLurkingAndNavigate(j, longOrNull, context);
        return new AnalyticsMetadata("lurk", Long.valueOf(j), longOrNull);
    }

    public final AnalyticsMetadata selectPremiumGuild(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long j = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(1)) == null) ? 0L : Long.parseLong(str);
        if (j != 0) {
            WidgetGuildBoost.INSTANCE.create(context, j);
        }
        return new AnalyticsMetadata("guild", Long.valueOf(j), null, 4, null);
    }

    public final AnalyticsMetadata selectStaticChannel(Context context, Uri uri, MatchResult matchResult) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        StaticChannelRoutes.WithGuild withGuildExtractStaticRoute = StaticChannelRoutes.INSTANCE.extractStaticRoute(uri);
        if (withGuildExtractStaticRoute == null) {
            return AnalyticsMetadata.INSTANCE.getUNKNOWN();
        }
        StaticChannelRoutes route = withGuildExtractStaticRoute.getRoute();
        long guildId = withGuildExtractStaticRoute.getGuildId();
        if (guildId != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            if (companion.getGuilds().getGuild(guildId) != null) {
                if (route.ordinal() == 0) {
                    RoleSubscriptionsLinkingUtil.INSTANCE.handoffToGuildRoleSubscriptions(context, guildId);
                }
                companion.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, true);
                return new AnalyticsMetadata("channel", Long.valueOf(guildId), null, 4, null);
            }
        }
        return new AnalyticsMetadata("channel", Long.valueOf(guildId), null, 4, null);
    }

    public final AnalyticsMetadata selectUserProfile(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        Long longOrNull = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) _Collections.last((List) groupValues)) == null) ? null : StringNumberConversions.toLongOrNull(str);
        String queryParameter = uri.getQueryParameter("friend_token");
        if (longOrNull != null) {
            WidgetUserSheet.INSTANCE.enqueueNotice(longOrNull.longValue(), queryParameter);
        }
        return new AnalyticsMetadata("profile", null, null, 6, null);
    }

    public final AnalyticsMetadata voiceConnect(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Long longOrNull;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long jLongValue = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(1)) == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("service_denied", false);
        WeakReference weakReference = new WeakReference(context);
        Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(jLongValue).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null)), (Class<?>) RouteHandlers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(weakReference, jLongValue, booleanQueryParameter));
        return new AnalyticsMetadata("voice", null, Long.valueOf(jLongValue), 2, null);
    }

    public final AnalyticsMetadata wildCardMatcher(Uri uri, MatchResult matchResult, Context context) {
        AnalyticsMetadata analyticsMetadata;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        List<String> pathSegments = uri.getPathSegments();
        String str = pathSegments != null ? (String) _Collections.firstOrNull((List) pathSegments) : null;
        String host = uri.getHost();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        KFunction<AnalyticsMetadata> kFunctionInvoke = anonymousClass1.invoke(str);
        if (kFunctionInvoke == null) {
            kFunctionInvoke = anonymousClass1.invoke(host);
        }
        return (kFunctionInvoke == null || (analyticsMetadata = (AnalyticsMetadata) ((Function3) kFunctionInvoke).invoke(uri, matchResult, context)) == null) ? AnalyticsMetadata.INSTANCE.getUNKNOWN() : analyticsMetadata;
    }
}
