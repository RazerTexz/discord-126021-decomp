package com.discord.utilities.intent;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build$VERSION;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.a.a0.c;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guild_role_subscriptions.RoleSubscriptionsLinkingUtil;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.media.WidgetQRScanner;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.g0.s;
import d0.g0.t;
import d0.g0.w;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlin.text.MatchResult;
import rx.Observable;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers {
    public static final RouteHandlers INSTANCE = new RouteHandlers();

    private RouteHandlers() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    private final RouteHandlers$AnalyticsMetadata acceptGift(Uri uri, MatchResult matchResult, Context context) {
        String str;
        List<String> groupValues;
        String str2 = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) u.last((List) groupValues);
        String queryParameter = uri.getQueryParameter("source");
        if (queryParameter != null) {
            m.checkNotNullExpressionValue(queryParameter, "it");
            str = t.isBlank(queryParameter) ^ true ? queryParameter : null;
            if (str == null) {
                str = StoreInviteSettings.LOCATION_DEEPLINK;
            }
        } else {
            str = StoreInviteSettings.LOCATION_DEEPLINK;
        }
        m.checkNotNullExpressionValue(str, "uri.getQueryParameter(\"s…ettings.LOCATION_DEEPLINK");
        if (str2 != null && (!t.isBlank(str2))) {
            c.k.a(str2, str, 0L);
        }
        return new RouteHandlers$AnalyticsMetadata("gift", null, null, 6, null);
    }

    public static final /* synthetic */ RouteHandlers$AnalyticsMetadata access$acceptGift(RouteHandlers routeHandlers, Uri uri, MatchResult matchResult, Context context) {
        return routeHandlers.acceptGift(uri, matchResult, context);
    }

    public static final /* synthetic */ RouteHandlers$AnalyticsMetadata access$useGuildTemplate(RouteHandlers routeHandlers, Uri uri, MatchResult matchResult, Context context) {
        return routeHandlers.useGuildTemplate(uri, matchResult, context);
    }

    public static final /* synthetic */ RouteHandlers$AnalyticsMetadata access$useInvite(RouteHandlers routeHandlers, Uri uri, MatchResult matchResult, Context context) {
        return routeHandlers.useInvite(uri, matchResult, context);
    }

    private final RouteHandlers$AnalyticsMetadata useGuildTemplate(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) u.last((List) groupValues);
        if (str != null) {
            StoreStream.Companion.getGuildTemplates().setDynamicLinkGuildTemplateCode(str);
        }
        return new RouteHandlers$AnalyticsMetadata("guild_template", null, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003a  */
    private final RouteHandlers$AnalyticsMetadata useInvite(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) u.last((List) groupValues);
        if (!(!m.areEqual(str, "invite"))) {
            str = null;
        }
        String queryParameter = uri.getQueryParameter("source");
        if (queryParameter != null) {
            m.checkNotNullExpressionValue(queryParameter, "it");
            if (!(!t.isBlank(queryParameter))) {
                queryParameter = null;
            }
            if (queryParameter == null) {
                queryParameter = StoreInviteSettings.LOCATION_DEEPLINK;
            }
        } else {
            queryParameter = StoreInviteSettings.LOCATION_DEEPLINK;
        }
        m.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(\"s…        ?: inviteLocation");
        String queryParameter2 = uri.getQueryParameter("event");
        Long snowflake = queryParameter2 != null ? SnowflakeUtils.INSTANCE.toSnowflake(queryParameter2) : null;
        if (str != null) {
            StoreStream.Companion.getInviteSettings().setInviteCode(str, queryParameter, snowflake);
        } else {
            WidgetGuildJoin.Companion.show(context, StoreInviteSettings.LOCATION_DEEPLINK);
        }
        return new RouteHandlers$AnalyticsMetadata("invite", null, null, 6, null);
    }

    public final RouteHandlers$AnalyticsMetadata authorize(Uri uri, MatchResult matchResult, Context context) {
        boolean zAreEqual;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        if (!(context instanceof Activity) || Build$VERSION.SDK_INT < 22) {
            zAreEqual = false;
        } else {
            Uri referrer = ((Activity) context).getReferrer();
            zAreEqual = m.areEqual(referrer != null ? referrer.getAuthority() : null, BuildConfig.APPLICATION_ID);
        }
        Uri uriBuild = uri.buildUpon().appendQueryParameter("internal_referrer", String.valueOf(zAreEqual)).build();
        StoreAuthentication authentication = StoreStream.Companion.getAuthentication();
        m.checkNotNullExpressionValue(uriBuild, "oAuthUri");
        authentication.setOAuthUriSubject(uriBuild);
        return new RouteHandlers$AnalyticsMetadata("oauth2", null, null, 6, null);
    }

    public final RouteHandlers$AnalyticsMetadata handleQuery(Uri uri, MatchResult matchResult, Context context) {
        String str;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        String queryParameter = uri.getQueryParameter("type");
        String queryParameter2 = uri.getQueryParameter("channelName");
        String str2 = "";
        String str3 = queryParameter2 != null ? queryParameter2 : "";
        m.checkNotNullExpressionValue(str3, "uri.getQueryParameter(\"channelName\") ?: \"\"");
        String queryParameter3 = uri.getQueryParameter("serverName");
        if (queryParameter3 == null) {
            queryParameter3 = "";
        }
        m.checkNotNullExpressionValue(queryParameter3, "uri.getQueryParameter(\"serverName\") ?: \"\"");
        String queryParameter4 = uri.getQueryParameter("userName");
        if (queryParameter4 == null) {
            queryParameter4 = "";
        }
        m.checkNotNullExpressionValue(queryParameter4, "uri.getQueryParameter(\"userName\") ?: \"\"");
        String queryParameter5 = uri.getQueryParameter("userNameAlt");
        if (queryParameter5 == null) {
            queryParameter5 = "";
        }
        m.checkNotNullExpressionValue(queryParameter5, "uri.getQueryParameter(\"userNameAlt\") ?: \"\"");
        String queryParameter6 = uri.getQueryParameter("messageText");
        if (queryParameter6 == null) {
            queryParameter6 = "";
        }
        m.checkNotNullExpressionValue(queryParameter6, "uri.getQueryParameter(\"messageText\") ?: \"\"");
        if (queryParameter != null) {
            int iHashCode = queryParameter.hashCode();
            if (iHashCode != -905826493) {
                if (iHashCode != 3599307) {
                    if (iHashCode == 738950403 && queryParameter.equals("channel")) {
                        List listSplit$default = w.split$default((CharSequence) str3, new String[]{" in "}, false, 0, 6, (Object) null);
                        String str4 = (String) (n.getLastIndex(listSplit$default) >= 0 ? listSplit$default.get(0) : "");
                        String str5 = (String) (1 <= n.getLastIndex(listSplit$default) ? listSplit$default.get(1) : "");
                        if (str5.length() > 0) {
                            str2 = ' ' + str5;
                        }
                        str = MentionUtilsKt.CHANNELS_CHAR + str4 + str2;
                        StoreStream.Companion.getNavigation().launchNotice("DEEPLINK_QUERY", new RouteHandlers$handleQuery$1(queryParameter6, str));
                        return new RouteHandlers$AnalyticsMetadata("query", null, null, 6, null);
                    }
                } else if (queryParameter.equals("user")) {
                    if (!(queryParameter4.length() > 0)) {
                        queryParameter4 = queryParameter5;
                    }
                    if (queryParameter4.length() == 0) {
                        return RouteHandlers$AnalyticsMetadata.Companion.getUNKNOWN();
                    }
                    str = MentionUtilsKt.MENTIONS_CHAR + queryParameter4;
                    StoreStream.Companion.getNavigation().launchNotice("DEEPLINK_QUERY", new RouteHandlers$handleQuery$1(queryParameter6, str));
                    return new RouteHandlers$AnalyticsMetadata("query", null, null, 6, null);
                }
            } else if (queryParameter.equals("server")) {
                str = '*' + queryParameter3;
                StoreStream.Companion.getNavigation().launchNotice("DEEPLINK_QUERY", new RouteHandlers$handleQuery$1(queryParameter6, str));
                return new RouteHandlers$AnalyticsMetadata("query", null, null, 6, null);
            }
        }
        return RouteHandlers$AnalyticsMetadata.Companion.getUNKNOWN();
    }

    public final RouteHandlers$AnalyticsMetadata navigateToFriendsScreen(Uri uri, MatchResult matchResult, Context context) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        StoreStream.Companion.getTabsNavigation().selectTab(NavigationTab.FRIENDS, true);
        return new RouteHandlers$AnalyticsMetadata("friends", null, null, 6, null);
    }

    public final RouteHandlers$AnalyticsMetadata openEventDetails(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        long j = 0;
        long j2 = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = groupValues2.get(1)) == null) ? 0L : Long.parseLong(str2);
        if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null && (str = groupValues.get(2)) != null) {
            j = Long.parseLong(str);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Guild guild = storeStream$Companion.getGuilds().getGuild(j2);
        Channel channel = guild == null ? storeStream$Companion.getChannels().getChannel(j2) : null;
        if (guild == null && channel == null) {
            WidgetGuildScheduledEventDetailsBottomSheet.Companion.handleInvalidEvent(context);
        } else {
            WidgetGuildScheduledEventDetailsBottomSheet.Companion.enqueue(j);
            if (guild == null) {
                guild = channel != null ? storeStream$Companion.getGuilds().getGuild(channel.getGuildId()) : null;
            }
            if (guild != null) {
                storeStream$Companion.getGuildSelected().set(guild.getId());
            }
        }
        return new RouteHandlers$AnalyticsMetadata("event", null, null, 6, null);
    }

    public final RouteHandlers$AnalyticsMetadata remoteAuth(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        if (((matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) u.last((List) groupValues)) != null) {
            WidgetQRScanner.Companion.launch(context, true);
        }
        return new RouteHandlers$AnalyticsMetadata("remoteAuth", null, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    public final RouteHandlers$AnalyticsMetadata selectChannel(Context context, Uri uri, MatchResult matchResult) {
        long jLongValue;
        List<String> groupValues;
        String str;
        Long longOrNull;
        List<String> groupValues2;
        String str2;
        Long longOrNull2;
        List<String> groupValues3;
        String str3;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        if (matchResult == null || (groupValues3 = matchResult.getGroupValues()) == null || (str3 = (String) u.getOrNull(groupValues3, 1)) == null) {
            jLongValue = 0;
        } else {
            Long longOrNull3 = m.areEqual(str3, "@me") ? 0L : s.toLongOrNull(str3);
            if (longOrNull3 != null) {
                jLongValue = longOrNull3.longValue();
            } else {
                jLongValue = 0;
            }
        }
        long jLongValue2 = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = (String) u.getOrNull(groupValues2, 2)) == null || (longOrNull2 = s.toLongOrNull(str2)) == null) ? 0L : longOrNull2.longValue();
        long jLongValue3 = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) u.getOrNull(groupValues, 3)) == null || (longOrNull = s.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreTabsNavigation tabsNavigation = storeStream$Companion.getTabsNavigation();
        if (jLongValue2 == 0 && jLongValue3 == 0 && jLongValue != 0) {
            storeStream$Companion.getGuildSelected().set(jLongValue);
            tabsNavigation.selectHomeTab(StoreNavigation$PanelAction.CLOSE, true);
        } else if (jLongValue3 == 0) {
            if ((storeStream$Companion.getChannels().findChannelById(jLongValue2) == null) && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, jLongValue, null, 2, null)) {
                ChannelSelector.Companion.getInstance().findAndSetThread(context, jLongValue2);
            } else {
                ChannelSelector.Companion.getInstance().findAndSet(context, jLongValue2);
            }
            tabsNavigation.selectHomeTab(StoreNavigation$PanelAction.CLOSE, true);
        } else {
            storeStream$Companion.getMessagesLoader().jumpToMessage(jLongValue2, jLongValue3);
        }
        return new RouteHandlers$AnalyticsMetadata("channel", Long.valueOf(jLongValue), Long.valueOf(jLongValue2));
    }

    public final RouteHandlers$AnalyticsMetadata selectDirectMessage(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Long longOrNull;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null && (str = (String) u.last((List) groupValues)) != null && (longOrNull = s.toLongOrNull(str)) != null) {
            ChannelSelector.Companion.getInstance().findAndSetDirectMessage(context, longOrNull.longValue());
        }
        return new RouteHandlers$AnalyticsMetadata("DM", null, null, 6, null);
    }

    public final RouteHandlers$AnalyticsMetadata selectFeature(Uri uri, MatchResult matchResult, Context context) {
        String str;
        List<String> groupValues;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        if (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) u.getOrNull(groupValues, 1)) == null) {
            str = "";
        }
        String str2 = str;
        Map mapMapOf = h0.mapOf(o.to("/account", RouteHandlers$selectFeature$settingMap$1.INSTANCE), o.to("/nitro", RouteHandlers$selectFeature$settingMap$2.INSTANCE), o.to("/voice", RouteHandlers$selectFeature$settingMap$3.INSTANCE), o.to("/createServer", RouteHandlers$selectFeature$settingMap$4.INSTANCE), o.to("/quickSwitcher", RouteHandlers$selectFeature$settingMap$5.INSTANCE), o.to("/friends", RouteHandlers$selectFeature$settingMap$6.INSTANCE), o.to("/mentions", RouteHandlers$selectFeature$settingMap$7.INSTANCE), o.to("/settings", RouteHandlers$selectFeature$settingMap$8.INSTANCE), o.to("/contactSync", RouteHandlers$selectFeature$settingMap$9.INSTANCE), o.to("/addFriends", RouteHandlers$selectFeature$settingMap$10.INSTANCE), o.to("/editProfile", RouteHandlers$selectFeature$settingMap$11.INSTANCE), o.to("/voiceChannel", new RouteHandlers$selectFeature$settingMap$12(uri)), o.to("/xboxLinkBeta", RouteHandlers$selectFeature$settingMap$13.INSTANCE));
        StoreStream.Companion.getNavigation().launchNotice(a.w("ROUTING:", str2), new RouteHandlers$selectFeature$1(mapMapOf, str2));
        return mapMapOf.containsKey(str2) ? new RouteHandlers$AnalyticsMetadata(str2, null, null, 6, null) : RouteHandlers$AnalyticsMetadata.Companion.getUNKNOWN();
    }

    public final RouteHandlers$AnalyticsMetadata selectLurk(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        long j = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = groupValues2.get(1)) == null) ? 0L : Long.parseLong(str2);
        Long longOrNull = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(2)) == null) ? null : s.toLongOrNull(str);
        StoreStream.Companion.getLurking().startLurkingAndNavigate(j, longOrNull, context);
        return new RouteHandlers$AnalyticsMetadata("lurk", Long.valueOf(j), longOrNull);
    }

    public final RouteHandlers$AnalyticsMetadata selectPremiumGuild(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        long j = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(1)) == null) ? 0L : Long.parseLong(str);
        if (j != 0) {
            WidgetGuildBoost.Companion.create(context, j);
        }
        return new RouteHandlers$AnalyticsMetadata("guild", Long.valueOf(j), null, 4, null);
    }

    public final RouteHandlers$AnalyticsMetadata selectStaticChannel(Context context, Uri uri, MatchResult matchResult) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        StaticChannelRoutes$WithGuild staticChannelRoutes$WithGuildExtractStaticRoute = StaticChannelRoutes.Companion.extractStaticRoute(uri);
        if (staticChannelRoutes$WithGuildExtractStaticRoute == null) {
            return RouteHandlers$AnalyticsMetadata.Companion.getUNKNOWN();
        }
        StaticChannelRoutes route = staticChannelRoutes$WithGuildExtractStaticRoute.getRoute();
        long guildId = staticChannelRoutes$WithGuildExtractStaticRoute.getGuildId();
        if (guildId != 0) {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            if (storeStream$Companion.getGuilds().getGuild(guildId) != null) {
                if (route.ordinal() == 0) {
                    RoleSubscriptionsLinkingUtil.INSTANCE.handoffToGuildRoleSubscriptions(context, guildId);
                }
                storeStream$Companion.getTabsNavigation().selectHomeTab(StoreNavigation$PanelAction.CLOSE, true);
                return new RouteHandlers$AnalyticsMetadata("channel", Long.valueOf(guildId), null, 4, null);
            }
        }
        return new RouteHandlers$AnalyticsMetadata("channel", Long.valueOf(guildId), null, 4, null);
    }

    public final RouteHandlers$AnalyticsMetadata selectUserProfile(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        Long longOrNull = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) u.last((List) groupValues)) == null) ? null : s.toLongOrNull(str);
        String queryParameter = uri.getQueryParameter("friend_token");
        if (longOrNull != null) {
            WidgetUserSheet.Companion.enqueueNotice(longOrNull.longValue(), queryParameter);
        }
        return new RouteHandlers$AnalyticsMetadata("profile", null, null, 6, null);
    }

    public final RouteHandlers$AnalyticsMetadata voiceConnect(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Long longOrNull;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        long jLongValue = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(1)) == null || (longOrNull = s.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("service_denied", false);
        WeakReference weakReference = new WeakReference(context);
        Observable<R> observableG = StoreStream.Companion.getChannels().observeChannel(jLongValue).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null)), RouteHandlers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new RouteHandlers$voiceConnect$1(weakReference, jLongValue, booleanQueryParameter), 62, (Object) null);
        return new RouteHandlers$AnalyticsMetadata("voice", null, Long.valueOf(jLongValue), 2, null);
    }

    public final RouteHandlers$AnalyticsMetadata wildCardMatcher(Uri uri, MatchResult matchResult, Context context) {
        RouteHandlers$AnalyticsMetadata routeHandlers$AnalyticsMetadata;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        List<String> pathSegments = uri.getPathSegments();
        String str = pathSegments != null ? (String) u.firstOrNull((List) pathSegments) : null;
        String host = uri.getHost();
        RouteHandlers$wildCardMatcher$1 routeHandlers$wildCardMatcher$1 = RouteHandlers$wildCardMatcher$1.INSTANCE;
        KFunction<RouteHandlers$AnalyticsMetadata> kFunctionInvoke2 = routeHandlers$wildCardMatcher$1.invoke2(str);
        if (kFunctionInvoke2 == null) {
            kFunctionInvoke2 = routeHandlers$wildCardMatcher$1.invoke2(host);
        }
        return (kFunctionInvoke2 == null || (routeHandlers$AnalyticsMetadata = (RouteHandlers$AnalyticsMetadata) ((Function3) kFunctionInvoke2).invoke(uri, matchResult, context)) == null) ? RouteHandlers$AnalyticsMetadata.Companion.getUNKNOWN() : routeHandlers$AnalyticsMetadata;
    }
}
