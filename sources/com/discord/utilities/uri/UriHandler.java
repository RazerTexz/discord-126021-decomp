package com.discord.utilities.uri;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.NotificationCompat;
import b.a.a.g.WidgetMaskedLinksDialog;
import b.a.d.AppToast;
import b.a.h.CustomTabs;
import b.a.h.CustomTabsPackages;
import b.a.h.CustomTabsPackages2;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.R;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.LayoutUnhandledUriBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_role_subscriptions.RoleSubscriptionsLinkingUtil;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.media.WidgetMedia;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.user.WidgetUserMentions;
import com.google.android.material.button.MaterialButton;
import d0.e0.KClass;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler {
    private static final String APP_PACKAGE = "com.discord";
    public static final UriHandler INSTANCE = new UriHandler();
    private static final String URL_PLAY_STORE_ALT = "https://play.google.com/store/apps/details";
    private static final String URL_PLAY_STORE_DIRECT = "market://details";

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, String> {
        public final /* synthetic */ String $packageName;
        public final /* synthetic */ String $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(1);
            this.$packageName = str;
            this.$source = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_ID, this.$packageName);
            StringBuilder sbU = outline.U("utm_source=");
            sbU.append(this.$source);
            String string = builderAppendQueryParameter.appendQueryParameter(Constants.REFERRER, sbU.toString()).build().toString();
            Intrinsics3.checkNotNullExpressionValue(string, "Uri.parse(uri).buildUpon…ild()\n        .toString()");
            return string;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$2, reason: invalid class name */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass1 $createFullUriString$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, AnonymousClass1 anonymousClass1) {
            super(0);
            this.$context = context;
            this.$createFullUriString$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UriHandler.handle$default(UriHandler.INSTANCE, this.$context, this.$createFullUriString$1.invoke(UriHandler.URL_PLAY_STORE_ALT), false, false, null, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$1, reason: invalid class name */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ResolveInfo, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(ResolveInfo resolveInfo) {
            return resolveInfo.activityInfo.packageName;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$2, reason: invalid class name */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return !Intrinsics3.areEqual(str, this.$context.getPackageName());
        }
    }

    private UriHandler() {
    }

    public static final void directToPlayStore(Context context) {
        directToPlayStore$default(context, null, null, 6, null);
    }

    public static final void directToPlayStore(Context context, String str) {
        directToPlayStore$default(context, str, null, 4, null);
    }

    public static final void directToPlayStore(Context context, String packageName, String source) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(packageName, "packageName");
        Intrinsics3.checkNotNullParameter(source, "source");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(packageName, source);
        handle$default(INSTANCE, context, anonymousClass1.invoke(URL_PLAY_STORE_DIRECT), false, false, new AnonymousClass2(context, anonymousClass1), 12, null);
    }

    public static /* synthetic */ void directToPlayStore$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "com.discord";
        }
        if ((i & 4) != 0) {
            str2 = "discord";
        }
        directToPlayStore(context, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handle$default(UriHandler uriHandler, Context context, String str, boolean z2, boolean z3, Function0 function0, int i, Object obj) {
        boolean z4 = (i & 4) != 0 ? false : z2;
        boolean z5 = (i & 8) != 0 ? false : z3;
        if ((i & 16) != 0) {
            function0 = null;
        }
        uriHandler.handle(context, str, z4, z5, function0);
    }

    public static final void handleOrUntrusted(Context context, String url, String mask) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(url, "url");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (companion.getMaskedLinks().isTrustedDomain(url, mask)) {
            handle$default(INSTANCE, context, url, false, false, null, 28, null);
            return;
        }
        Objects.requireNonNull(WidgetMaskedLinksDialog.k);
        String str = "WIDGET_SPOOPY_LINKS_DIALOG";
        companion.getNotices().requestToShow(new StoreNotices.Notice(str, null, 0L, 0, false, Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetHome.class), Reflection2.getOrCreateKotlinClass(WidgetUserMentions.class), Reflection2.getOrCreateKotlinClass(WidgetSearch.class), Reflection2.getOrCreateKotlinClass(WidgetChannelPinnedMessages.class), Reflection2.getOrCreateKotlinClass(WidgetMedia.class)}), 0L, false, 0L, new UriHandler2(url), Opcodes.I2F, null));
    }

    public static /* synthetic */ void handleOrUntrusted$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        handleOrUntrusted(context, str, str2);
    }

    private final boolean handleUriSpecialCase(Context context, Uri uri) {
        return RoleSubscriptionsLinkingUtil.INSTANCE.tryPerformHandoff(context, uri);
    }

    private final void openUrl(Context context, Uri uri, String url, boolean forceExternal, boolean preventCustomTab, Function0<Unit> onFailure) {
        if (!(!preventCustomTab && StoreStream.INSTANCE.getUserSettings().getIsChromeCustomTabsEnabled())) {
            openUrlExternally(context, uri, url, forceExternal, onFailure);
            return;
        }
        AppTransitionActivity.j = true;
        int themedColor = ColorCompat.getThemedColor(context, R.attr.colorPrimary);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, uri, url, forceExternal, onFailure);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(anonymousClass1, "onFailure");
        String strA = forceExternal ? CustomTabsPackages2.a.a(context, new CustomTabs(context)) : CustomTabsPackages2.a.a(context, CustomTabsPackages.j);
        if (strA == null) {
            anonymousClass1.invoke();
            return;
        }
        CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setNavigationBarColor(themedColor).setToolbarColor(themedColor).setSecondaryToolbarColor(themedColor).build();
        Intrinsics3.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "CustomTabColorSchemePara…Color)\n          .build()");
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setDefaultColorSchemeParams(customTabColorSchemeParamsBuild).setShowTitle(false).setStartAnimations(context, R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out).setExitAnimations(context, R.anim.activity_slide_horizontal_close_in, R.anim.activity_slide_horizontal_close_out).build();
        Intrinsics3.checkNotNullExpressionValue(customTabsIntentBuild, "CustomTabsIntent.Builder…ResId)\n          .build()");
        if (forceExternal) {
            try {
                Intent intent = customTabsIntentBuild.intent;
                Intrinsics3.checkNotNullExpressionValue(intent, "customTabsIntent.intent");
                intent.setPackage(strA);
            } catch (ActivityNotFoundException unused) {
                anonymousClass1.invoke();
                return;
            }
        }
        Intent intent2 = customTabsIntentBuild.intent;
        Intrinsics3.checkNotNullExpressionValue(intent2, "customTabsIntent.intent");
        intent2.setData(uri);
        customTabsIntentBuild.launchUrl(context, uri);
    }

    private final void openUrlExternally(Context context, Uri uri, String url, boolean forceExternal, Function0<Unit> onFailure) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (forceExternal) {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                Intrinsics3.checkNotNullExpressionValue(listQueryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                intent.setPackage((String) _Sequences2.firstOrNull(_Sequences2.filter(_Sequences2.mapNotNull(_Collections.asSequence(listQueryIntentActivities), AnonymousClass1.INSTANCE), new AnonymousClass2(context))));
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if ((onFailure == null || onFailure.invoke() == null) && url != null) {
                INSTANCE.showUnhandledUrlDialog(context, url);
            }
        }
    }

    private final void showUnhandledUrlDialog(Context context, final String url) {
        AnalyticsTracker.INSTANCE.unhandledUrl(url);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_unhandled_uri, (ViewGroup) null, false);
        int i = R.id.unhandled_uri_display;
        TextView textView = (TextView) viewInflate.findViewById(R.id.unhandled_uri_display);
        if (textView != null) {
            i = R.id.unhandled_uri_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.unhandled_uri_okay);
            if (materialButton != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                final LayoutUnhandledUriBinding layoutUnhandledUriBinding = new LayoutUnhandledUriBinding(linearLayout, textView, materialButton);
                Intrinsics3.checkNotNullExpressionValue(layoutUnhandledUriBinding, "LayoutUnhandledUriBindin…utInflater.from(context))");
                final AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(linearLayout).create();
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.unhandledUriDisplay");
                textView.setText(url);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.utilities.uri.UriHandler$showUnhandledUrlDialog$$inlined$apply$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppToast.c(outline.x(view, "v", "v.context"), url, 0, 4);
                    }
                });
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.utilities.uri.UriHandler$showUnhandledUrlDialog$1$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialogCreate.dismiss();
                    }
                });
                alertDialogCreate.show();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void handle(Context context, String url, boolean forceExternal, boolean preventCustomTab, Function0<Unit> onFailure) {
        Uri uri;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (url != null) {
            try {
                uri = Uri.parse(url);
            } catch (Exception unused) {
                uri = null;
            }
            Uri uri2 = uri;
            if (uri2 != null) {
                if (forceExternal || !handleUriSpecialCase(context, uri2)) {
                    openUrl(context, uri2, url, forceExternal, preventCustomTab, onFailure);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$openUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $forceExternal;
        public final /* synthetic */ Function0 $onFailure;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, Uri uri, String str, boolean z2, Function0 function0) {
            super(0);
            this.$context = context;
            this.$uri = uri;
            this.$url = str;
            this.$forceExternal = z2;
            this.$onFailure = function0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppTransitionActivity.j = false;
            UriHandler.INSTANCE.openUrlExternally(this.$context, this.$uri, this.$url, this.$forceExternal, this.$onFailure);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }
    }
}
