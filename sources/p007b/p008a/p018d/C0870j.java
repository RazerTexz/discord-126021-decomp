package p007b.p008a.p018d;

import android.R;
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
import com.discord.stores.StoreNavigation;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.j */
/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0870j {

    /* JADX INFO: renamed from: g */
    public static final C0870j f524g = new C0870j();

    /* JADX INFO: renamed from: a */
    public static final List<InterfaceC11230c<? extends AppFragment>> f518a = C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetAuthLanding.class), C12216a0.getOrCreateKotlinClass(WidgetAuthLogin.class), C12216a0.getOrCreateKotlinClass(WidgetAuthRegisterIdentity.class), C12216a0.getOrCreateKotlinClass(WidgetAuthRegisterAccountInformation.class), C12216a0.getOrCreateKotlinClass(WidgetAuthUndeleteAccount.class), C12216a0.getOrCreateKotlinClass(WidgetAuthCaptcha.class), C12216a0.getOrCreateKotlinClass(WidgetAuthMfa.class), C12216a0.getOrCreateKotlinClass(WidgetAuthBirthday.class), C12216a0.getOrCreateKotlinClass(WidgetAuthAgeGated.class), C12216a0.getOrCreateKotlinClass(WidgetAuthPhoneVerify.class), C12216a0.getOrCreateKotlinClass(WidgetAuthResetPassword.class)});

    /* JADX INFO: renamed from: b */
    public static final List<InterfaceC11230c<WidgetAgeVerify>> f519b = C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetAgeVerify.class));

    /* JADX INFO: renamed from: c */
    public static final List<InterfaceC11230c<? extends WidgetOauth2Authorize>> f520c = C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetOauth2Authorize.class), C12216a0.getOrCreateKotlinClass(WidgetOauth2AuthorizeSamsung.class)});

    /* JADX INFO: renamed from: d */
    public static final List<InterfaceC11230c<? extends AppFragment>> f521d = C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetSettingsAccount.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAccountBackupCodes.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAccountChangePassword.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAccountUsernameEdit.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAccountEmailEdit.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAccountEmailEditConfirm.class), C12216a0.getOrCreateKotlinClass(WidgetUserPasswordVerify.class), C12216a0.getOrCreateKotlinClass(WidgetEnableMFASteps.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAppearance.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsBehavior.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsLanguage.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsMedia.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsPremium.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsNotifications.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsUserConnections.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsVoice.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsPrivacy.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAuthorizedApps.class), C12216a0.getOrCreateKotlinClass(WidgetServerNotifications.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsOverview.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsChannels.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEditMember.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEditRole.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsIntegrations.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsModeration.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsVanityUrl.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsSecurity.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsMembers.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEmojis.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEmojisEdit.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsRoles.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsInstantInvites.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsBans.class), C12216a0.getOrCreateKotlinClass(WidgetChannelSettingsEditPermissions.class), C12216a0.getOrCreateKotlinClass(WidgetChannelSettingsPermissionsOverview.class), C12216a0.getOrCreateKotlinClass(WidgetAuthRegisterIdentity.class), C12216a0.getOrCreateKotlinClass(WidgetAuthRegisterAccountInformation.class), C12216a0.getOrCreateKotlinClass(WidgetAuthBirthday.class), C12216a0.getOrCreateKotlinClass(WidgetAuthAgeGated.class), C12216a0.getOrCreateKotlinClass(WidgetAuthLogin.class), C12216a0.getOrCreateKotlinClass(WidgetAuthPhoneVerify.class), C12216a0.getOrCreateKotlinClass(WidgetAuthResetPassword.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsDeveloper.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsBlockedUsers.class), C12216a0.getOrCreateKotlinClass(WidgetNuxChannelPrompt.class), C12216a0.getOrCreateKotlinClass(WidgetChoosePlan.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverview.class), C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunitySteps.class), C12216a0.getOrCreateKotlinClass(WidgetGuildScheduledEventSettings.class)});

    /* JADX INFO: renamed from: e */
    public static final List<InterfaceC11230c<? extends AppFragment>> f522e = C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetCaptcha.class), C12216a0.getOrCreateKotlinClass(WidgetUserAccountVerify.class), C12216a0.getOrCreateKotlinClass(WidgetUserEmailVerify.class), C12216a0.getOrCreateKotlinClass(WidgetUserEmailUpdate.class), C12216a0.getOrCreateKotlinClass(WidgetUserPhoneManage.class), C12216a0.getOrCreateKotlinClass(WidgetUserPhoneVerify.class), C12216a0.getOrCreateKotlinClass(WidgetUserPasswordVerify.class)});

    /* JADX INFO: renamed from: f */
    public static final List<InterfaceC11230c<WidgetTabsHost>> f523f = C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetTabsHost.class));

    /* JADX INFO: renamed from: b */
    public static final void m154b(Context context, boolean z2, Intent intent) {
        Class cls;
        C12238m.checkNotNullParameter(context, "context");
        if (z2) {
            StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), intent != null ? intent.getBooleanExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", false) : false ? StoreNavigation.PanelAction.OPEN : StoreNavigation.PanelAction.CLOSE, false, 2, null);
            cls = WidgetTabsHost.class;
        } else {
            cls = WidgetAuthLanding.class;
        }
        m156d(context, cls, intent);
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ void m155c(Context context, boolean z2, Intent intent, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            intent = null;
        }
        m154b(context, z2, intent);
    }

    /* JADX INFO: renamed from: d */
    public static final void m156d(Context context, Class<? extends AppComponent> cls, Parcelable parcelable) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(cls, "screen");
        Intent intentM522g2 = null;
        Intent intent = (Intent) (!(parcelable instanceof Intent) ? null : parcelable);
        if (intent != null) {
            intentM522g2 = intent;
        } else if (parcelable != null) {
            intentM522g2 = C1460d.m522g2(parcelable);
        }
        AppLog appLog = AppLog.f14950g;
        String simpleName = context.getClass().getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        String simpleName2 = cls.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName2, "screen.simpleName");
        appLog.m8365f(simpleName, simpleName2);
        Intent intentPutExtra = (intentM522g2 != null ? new Intent(intentM522g2) : new Intent()).setClass(context, AppActivity.class).putExtra("com.discord.intent.extra.EXTRA_SCREEN", cls);
        C12238m.checkNotNullExpressionValue(intentPutExtra, "if (extras != null) {\n  …nts.EXTRA_SCREEN, screen)");
        context.startActivity(intentPutExtra);
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m157e(Context context, Class cls, Parcelable parcelable, int i) {
        int i2 = i & 4;
        m156d(context, cls, null);
    }

    /* JADX INFO: renamed from: g */
    public static void m158g(C0870j c0870j, FragmentManager fragmentManager, Context context, Class cls, int i, boolean z2, String str, Parcelable parcelable, int i2) {
        if ((i2 & 8) != 0) {
            i = R.id.content;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        int i3 = i2 & 32;
        if ((i2 & 64) != 0) {
            parcelable = null;
        }
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(cls, "screen");
        if (fragmentManager == null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        Fragment fragmentInstantiate = Fragment.instantiate(context, cls.getName());
        if (parcelable != null) {
            C12238m.checkNotNullExpressionValue(fragmentInstantiate, "fragment");
            Bundle bundleM514e2 = (Bundle) (!(parcelable instanceof Bundle) ? null : parcelable);
            if (bundleM514e2 == null) {
                bundleM514e2 = C1460d.m514e2(parcelable);
            }
            fragmentInstantiate.setArguments(bundleM514e2);
        }
        C12238m.checkNotNullExpressionValue(fragmentInstantiate, "Fragment.instantiate(con….toBundle()\n      }\n    }");
        fragmentTransactionBeginTransaction.replace(i, fragmentInstantiate, cls.getName());
        if (z2) {
            fragmentTransactionBeginTransaction.addToBackStack(null);
        }
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: renamed from: a */
    public final Intent m159a(Context context, Class<? extends AppComponent> cls, Intent intent) {
        AppLog appLog = AppLog.f14950g;
        String simpleName = context.getClass().getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        String simpleName2 = cls.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName2, "screen.simpleName");
        appLog.m8365f(simpleName, simpleName2);
        Intent intentPutExtra = (intent != null ? new Intent(intent) : new Intent()).setClass(context, AppActivity.class).putExtra("com.discord.intent.extra.EXTRA_SCREEN", cls);
        C12238m.checkNotNullExpressionValue(intentPutExtra, "if (extras != null) {\n  …nts.EXTRA_SCREEN, screen)");
        return intentPutExtra;
    }

    /* JADX INFO: renamed from: f */
    public final void m160f(Context context, ActivityResultLauncher<Intent> activityResultLauncher, Class<? extends AppComponent> cls, Parcelable parcelable) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(activityResultLauncher, "launcher");
        C12238m.checkNotNullParameter(cls, "screen");
        Intent intentM522g2 = null;
        Intent intent = (Intent) (!(parcelable instanceof Intent) ? null : parcelable);
        if (intent != null) {
            intentM522g2 = intent;
        } else if (parcelable != null) {
            intentM522g2 = C1460d.m522g2(parcelable);
        }
        activityResultLauncher.launch(m159a(context, cls, intentM522g2));
    }
}
