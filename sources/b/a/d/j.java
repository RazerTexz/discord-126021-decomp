package b.a.d;

import android.R$id;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.widgets.auth.WidgetAgeVerify;
import com.discord.widgets.auth.WidgetAuthAgeGated;
import com.discord.widgets.auth.WidgetAuthBirthday;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.discord.widgets.auth.WidgetAuthLanding;
import com.discord.widgets.auth.WidgetAuthLogin;
import com.discord.widgets.auth.WidgetAuthMfa;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import com.discord.widgets.auth.WidgetAuthRegisterAccountInformation;
import com.discord.widgets.auth.WidgetAuthRegisterIdentity;
import com.discord.widgets.auth.WidgetAuthResetPassword;
import com.discord.widgets.auth.WidgetAuthUndeleteAccount;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;
import com.discord.widgets.nux.WidgetNuxChannelPrompt;
import com.discord.widgets.servers.WidgetServerNotifications;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import com.discord.widgets.servers.WidgetServerSettingsEmojisEdit;
import com.discord.widgets.servers.WidgetServerSettingsIntegrations;
import com.discord.widgets.servers.WidgetServerSettingsModeration;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import com.discord.widgets.servers.WidgetServerSettingsRoles;
import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import com.discord.widgets.servers.WidgetServerSettingsVanityUrl;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import com.discord.widgets.settings.WidgetSettingsAppearance;
import com.discord.widgets.settings.WidgetSettingsAuthorizedApps;
import com.discord.widgets.settings.WidgetSettingsBehavior;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsMedia;
import com.discord.widgets.settings.WidgetSettingsNotifications;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit;
import com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm;
import com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsers;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerify;
import com.discord.widgets.user.email.WidgetUserEmailUpdate;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.discord.widgets.user.phone.WidgetUserPhoneVerify;
import java.util.List;

/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final j g = new j();
    public static final List<d0.e0.c<? extends AppFragment>> a = d0.t.n.listOf((Object[]) new d0.e0.c[]{d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthLanding.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthLogin.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthRegisterIdentity.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthRegisterAccountInformation.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthUndeleteAccount.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthCaptcha.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthMfa.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthBirthday.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthAgeGated.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthPhoneVerify.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthResetPassword.class)});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<d0.e0.c<WidgetAgeVerify>> f58b = d0.t.m.listOf(d0.z.d.a0.getOrCreateKotlinClass(WidgetAgeVerify.class));
    public static final List<d0.e0.c<? extends WidgetOauth2Authorize>> c = d0.t.n.listOf((Object[]) new d0.e0.c[]{d0.z.d.a0.getOrCreateKotlinClass(WidgetOauth2Authorize.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetOauth2AuthorizeSamsung.class)});
    public static final List<d0.e0.c<? extends AppFragment>> d = d0.t.n.listOf((Object[]) new d0.e0.c[]{d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAccount.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAccountBackupCodes.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAccountChangePassword.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAccountUsernameEdit.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAccountEmailEdit.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAccountEmailEditConfirm.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetUserPasswordVerify.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetEnableMFASteps.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAppearance.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsBehavior.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsLanguage.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsMedia.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsPremium.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsNotifications.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsUserConnections.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsVoice.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsPrivacy.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsAuthorizedApps.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerNotifications.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsOverview.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsChannels.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsEditMember.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsEditRole.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsIntegrations.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsModeration.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsVanityUrl.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsSecurity.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsMembers.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsEmojis.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsEmojisEdit.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsRoles.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsInstantInvites.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsBans.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetChannelSettingsEditPermissions.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetChannelSettingsPermissionsOverview.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthRegisterIdentity.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthRegisterAccountInformation.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthBirthday.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthAgeGated.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthLogin.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthPhoneVerify.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetAuthResetPassword.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsDeveloper.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetSettingsBlockedUsers.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetNuxChannelPrompt.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetChoosePlan.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverview.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunitySteps.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetGuildScheduledEventSettings.class)});
    public static final List<d0.e0.c<? extends AppFragment>> e = d0.t.n.listOf((Object[]) new d0.e0.c[]{d0.z.d.a0.getOrCreateKotlinClass(WidgetCaptcha.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetUserAccountVerify.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetUserEmailVerify.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetUserEmailUpdate.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetUserPhoneManage.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetUserPhoneVerify.class), d0.z.d.a0.getOrCreateKotlinClass(WidgetUserPasswordVerify.class)});
    public static final List<d0.e0.c<WidgetTabsHost>> f = d0.t.m.listOf(d0.z.d.a0.getOrCreateKotlinClass(WidgetTabsHost.class));

    public static final void b(Context context, boolean z2, Intent intent) {
        Class cls;
        d0.z.d.m.checkNotNullParameter(context, "context");
        if (z2) {
            StoreTabsNavigation.selectHomeTab$default(StoreStream.Companion.getTabsNavigation(), intent != null ? intent.getBooleanExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", false) : false ? StoreNavigation$PanelAction.OPEN : StoreNavigation$PanelAction.CLOSE, false, 2, null);
            cls = WidgetTabsHost.class;
        } else {
            cls = WidgetAuthLanding.class;
        }
        d(context, cls, intent);
    }

    public static /* synthetic */ void c(Context context, boolean z2, Intent intent, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            intent = null;
        }
        b(context, z2, intent);
    }

    public static final void d(Context context, Class<? extends AppComponent> cls, Parcelable parcelable) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(cls, "screen");
        Intent intentG2 = null;
        Intent intent = (Intent) (!(parcelable instanceof Intent) ? null : parcelable);
        if (intent != null) {
            intentG2 = intent;
        } else if (parcelable != null) {
            intentG2 = b.c.a.a0.d.g2(parcelable);
        }
        AppLog appLog = AppLog.g;
        String simpleName = context.getClass().getSimpleName();
        d0.z.d.m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        String simpleName2 = cls.getSimpleName();
        d0.z.d.m.checkNotNullExpressionValue(simpleName2, "screen.simpleName");
        appLog.f(simpleName, simpleName2);
        Intent intentPutExtra = (intentG2 != null ? new Intent(intentG2) : new Intent()).setClass(context, AppActivity.class).putExtra("com.discord.intent.extra.EXTRA_SCREEN", cls);
        d0.z.d.m.checkNotNullExpressionValue(intentPutExtra, "if (extras != null) {\n  …nts.EXTRA_SCREEN, screen)");
        context.startActivity(intentPutExtra);
    }

    public static /* synthetic */ void e(Context context, Class cls, Parcelable parcelable, int i) {
        int i2 = i & 4;
        d(context, cls, null);
    }

    public static void g(j jVar, FragmentManager fragmentManager, Context context, Class cls, int i, boolean z2, String str, Parcelable parcelable, int i2) {
        if ((i2 & 8) != 0) {
            i = R$id.content;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        int i3 = i2 & 32;
        if ((i2 & 64) != 0) {
            parcelable = null;
        }
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(cls, "screen");
        if (fragmentManager == null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        d0.z.d.m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        Fragment fragmentInstantiate = Fragment.instantiate(context, cls.getName());
        if (parcelable != null) {
            d0.z.d.m.checkNotNullExpressionValue(fragmentInstantiate, "fragment");
            Bundle bundleE2 = (Bundle) (!(parcelable instanceof Bundle) ? null : parcelable);
            if (bundleE2 == null) {
                bundleE2 = b.c.a.a0.d.e2(parcelable);
            }
            fragmentInstantiate.setArguments(bundleE2);
        }
        d0.z.d.m.checkNotNullExpressionValue(fragmentInstantiate, "Fragment.instantiate(con….toBundle()\n      }\n    }");
        fragmentTransactionBeginTransaction.replace(i, fragmentInstantiate, cls.getName());
        if (z2) {
            fragmentTransactionBeginTransaction.addToBackStack(null);
        }
        fragmentTransactionBeginTransaction.commit();
    }

    public final Intent a(Context context, Class<? extends AppComponent> cls, Intent intent) {
        AppLog appLog = AppLog.g;
        String simpleName = context.getClass().getSimpleName();
        d0.z.d.m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        String simpleName2 = cls.getSimpleName();
        d0.z.d.m.checkNotNullExpressionValue(simpleName2, "screen.simpleName");
        appLog.f(simpleName, simpleName2);
        Intent intentPutExtra = (intent != null ? new Intent(intent) : new Intent()).setClass(context, AppActivity.class).putExtra("com.discord.intent.extra.EXTRA_SCREEN", cls);
        d0.z.d.m.checkNotNullExpressionValue(intentPutExtra, "if (extras != null) {\n  …nts.EXTRA_SCREEN, screen)");
        return intentPutExtra;
    }

    public final void f(Context context, ActivityResultLauncher<Intent> activityResultLauncher, Class<? extends AppComponent> cls, Parcelable parcelable) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(activityResultLauncher, "launcher");
        d0.z.d.m.checkNotNullParameter(cls, "screen");
        Intent intentG2 = null;
        Intent intent = (Intent) (!(parcelable instanceof Intent) ? null : parcelable);
        if (intent != null) {
            intentG2 = intent;
        } else if (parcelable != null) {
            intentG2 = b.c.a.a0.d.g2(parcelable);
        }
        activityResultLauncher.launch(a(context, cls, intentG2));
    }
}
