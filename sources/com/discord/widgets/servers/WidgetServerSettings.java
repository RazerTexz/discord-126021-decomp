package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.permissions.ManageGuildContext;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBinding;", 0)};
    public static final WidgetServerSettings$Companion Companion = new WidgetServerSettings$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final LoggingConfig loggingConfig;

    public WidgetServerSettings() {
        super(R$layout.widget_server_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettings$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettings$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettings widgetServerSettings, WidgetServerSettings$Model widgetServerSettings$Model) {
        widgetServerSettings.configureUI(widgetServerSettings$Model);
    }

    private final void configureSectionsVisibility() {
        boolean z2;
        boolean z3;
        boolean z4;
        TextView textView;
        boolean z5 = true;
        List listListOf = n.listOf((Object[]) new TextView[]{getBinding().p, getBinding().m, getBinding().n, getBinding().q, getBinding().r, getBinding().l, getBinding().d});
        List listListOf2 = n.listOf((Object[]) new TextView[]{getBinding().k, getBinding().f2546s, getBinding().j, getBinding().f2545b});
        List listListOf3 = n.listOf((Object[]) new TextView[]{getBinding().h, getBinding().f, getBinding().i, getBinding().g});
        LinearLayout linearLayout = getBinding().u;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionGeneralSettings");
        boolean z6 = listListOf instanceof Collection;
        if (!z6 || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                TextView textView2 = (TextView) it.next();
                m.checkNotNullExpressionValue(textView2, "view");
                if (textView2.getVisibility() == 0) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        View view = getBinding().f2547x;
        m.checkNotNullExpressionValue(view, "binding.serverSettingsSectionUserManagementDivider");
        if (!z6 || !listListOf.isEmpty()) {
            Iterator it2 = listListOf.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                TextView textView3 = (TextView) it2.next();
                m.checkNotNullExpressionValue(textView3, "view");
                if (textView3.getVisibility() == 0) {
                    z3 = true;
                    break;
                }
            }
        } else {
            z3 = false;
            break;
        }
        view.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout2 = getBinding().w;
        m.checkNotNullExpressionValue(linearLayout2, "binding.serverSettingsSectionUserManagement");
        if (!(listListOf2 instanceof Collection) || !listListOf2.isEmpty()) {
            Iterator it3 = listListOf2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z4 = false;
                    break;
                }
                TextView textView4 = (TextView) it3.next();
                m.checkNotNullExpressionValue(textView4, "view");
                if (textView4.getVisibility() == 0) {
                    z4 = true;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        linearLayout2.setVisibility(z4 ? 0 : 8);
        LinearLayout linearLayout3 = getBinding().v;
        m.checkNotNullExpressionValue(linearLayout3, "binding.serverSettingsSectionServerMonetization");
        if (!(listListOf3 instanceof Collection) || !listListOf3.isEmpty()) {
            Iterator it4 = listListOf3.iterator();
            do {
                if (!it4.hasNext()) {
                    z5 = false;
                    break;
                } else {
                    textView = (TextView) it4.next();
                    m.checkNotNullExpressionValue(textView, "view");
                }
            } while (!(textView.getVisibility() == 0));
        } else {
            z5 = false;
            break;
        }
        linearLayout3.setVisibility(z5 ? 0 : 8);
    }

    private final void configureToolbar(WidgetServerSettings$Model model) {
        Guild guild = model.getGuild();
        String forGuild$default = IconUtils.getForGuild$default(guild, null, true, null, 10, null);
        TextView textView = getBinding().A;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsServerName");
        textView.setText(guild.getName());
        SimpleDraweeView simpleDraweeView = getBinding().f2548y;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsServerIcon");
        IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 2131165293, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        TextView textView2 = getBinding().f2549z;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsServerIconText");
        textView2.setVisibility(forGuild$default == null ? 0 : 8);
        TextView textView3 = getBinding().f2549z;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsServerIconText");
        textView3.setText(guild.getShortName());
        AppFragment.setActionBarOptionsMenu$default(this, model.getManageGuildContext().isOwnerWithRequiredMFALevel() ? R$menu.menu_server_settings : R$menu.menu_empty, new WidgetServerSettings$configureToolbar$1(this, guild), null, 4, null);
    }

    private final void configureUI(WidgetServerSettings$Model model) {
        if (model == null || !model.getManageGuildContext().canManage()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        configureToolbar(model);
        ManageGuildContext manageGuildContext = model.getManageGuildContext();
        TextView textView = getBinding().p;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsOptionOverview");
        textView.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().p.setOnClickListener(new WidgetServerSettings$configureUI$1(model));
        TextView textView2 = getBinding().o;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsOptionModeration");
        textView2.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().o.setOnClickListener(new WidgetServerSettings$configureUI$2(model));
        TextView textView3 = getBinding().l;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsOptionAuditLog");
        textView3.setVisibility(manageGuildContext.getCanViewAuditLogs() ? 0 : 8);
        getBinding().l.setOnClickListener(new WidgetServerSettings$configureUI$3(model));
        TextView textView4 = getBinding().m;
        m.checkNotNullExpressionValue(textView4, "binding.serverSettingsOptionChannels");
        textView4.setVisibility(manageGuildContext.getCanManageChannels() ? 0 : 8);
        getBinding().m.setOnClickListener(new WidgetServerSettings$configureUI$4(model));
        TextView textView5 = getBinding().q;
        m.checkNotNullExpressionValue(textView5, "binding.serverSettingsOptionSecurity");
        textView5.setVisibility(manageGuildContext.isOwnerWithRequiredMFALevel() ? 0 : 8);
        getBinding().q.setOnClickListener(new WidgetServerSettings$configureUI$5(model));
        TextView textView6 = getBinding().n;
        m.checkNotNullExpressionValue(textView6, "binding.serverSettingsOptionIntegrations");
        textView6.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().n.setOnClickListener(new WidgetServerSettings$configureUI$6(model));
        TextView textView7 = getBinding().r;
        m.checkNotNullExpressionValue(textView7, "binding.serverSettingsOptionVanityUrl");
        textView7.setVisibility(manageGuildContext.getCanManageServer() && model.getGuild().getFeatures().contains(GuildFeature.VANITY_URL) ? 0 : 8);
        getBinding().r.setOnClickListener(new WidgetServerSettings$configureUI$7(model));
        LinearLayout linearLayout = getBinding().t;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionCommunity");
        linearLayout.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        TextView textView8 = getBinding().c;
        m.checkNotNullExpressionValue(textView8, "binding.serverSettingsCommunityOverviewOption");
        Set<GuildFeature> features = model.getGuild().getFeatures();
        GuildFeature guildFeature = GuildFeature.COMMUNITY;
        textView8.setVisibility(features.contains(guildFeature) ? 0 : 8);
        getBinding().c.setOnClickListener(new WidgetServerSettings$configureUI$8(model));
        TextView textView9 = getBinding().e;
        m.checkNotNullExpressionValue(textView9, "binding.serverSettingsEnableCommunityOption");
        textView9.setVisibility(model.getGuild().getFeatures().contains(guildFeature) ^ true ? 0 : 8);
        getBinding().e.setOnClickListener(new WidgetServerSettings$configureUI$9(model));
        getBinding().k.setOnClickListener(new WidgetServerSettings$configureUI$10(model));
        TextView textView10 = getBinding().f2546s;
        m.checkNotNullExpressionValue(textView10, "binding.serverSettingsRolesOption");
        textView10.setVisibility(manageGuildContext.getCanManageRoles() ? 0 : 8);
        getBinding().f2546s.setOnClickListener(new WidgetServerSettings$configureUI$11(model));
        TextView textView11 = getBinding().j;
        m.checkNotNullExpressionValue(textView11, "binding.serverSettingsInstantInvitesOption");
        textView11.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().j.setOnClickListener(new WidgetServerSettings$configureUI$12(model));
        TextView textView12 = getBinding().f2545b;
        m.checkNotNullExpressionValue(textView12, "binding.serverSettingsBansOption");
        textView12.setVisibility(manageGuildContext.getCanManageBans() ? 0 : 8);
        getBinding().f2545b.setOnClickListener(new WidgetServerSettings$configureUI$13(model));
        TextView textView13 = getBinding().d;
        m.checkNotNullExpressionValue(textView13, "binding.serverSettingsEmojisOption");
        textView13.setVisibility(manageGuildContext.getCanManageEmojisAndStickers() ? 0 : 8);
        getBinding().d.setOnClickListener(new WidgetServerSettings$configureUI$14(model));
        TextView textView14 = getBinding().h;
        m.checkNotNullExpressionValue(textView14, "binding.serverSettingsGu…oleSubscriptionGetStarted");
        textView14.setVisibility(model.getCanManageGuildRoleSubscriptions() && !model.getHasGuildRoleSubscriptions() ? 0 : 8);
        getBinding().h.setOnClickListener(new WidgetServerSettings$configureUI$15(this, model));
        boolean z2 = model.getCanManageGuildRoleSubscriptions() && model.getHasGuildRoleSubscriptions();
        TextView textView15 = getBinding().f;
        m.checkNotNullExpressionValue(textView15, "binding.serverSettingsGu…RoleSubscriptionBasicInfo");
        textView15.setVisibility(z2 ? 0 : 8);
        getBinding().f.setOnClickListener(new WidgetServerSettings$configureUI$16(this, model));
        TextView textView16 = getBinding().i;
        m.checkNotNullExpressionValue(textView16, "binding.serverSettingsGuildRoleSubscriptionTiers");
        textView16.setVisibility(z2 ? 0 : 8);
        getBinding().i.setOnClickListener(new WidgetServerSettings$configureUI$17(this, model));
        TextView textView17 = getBinding().g;
        m.checkNotNullExpressionValue(textView17, "binding.serverSettingsGu…dRoleSubscriptionEarnings");
        textView17.setVisibility(z2 ? 0 : 8);
        getBinding().g.setOnClickListener(new WidgetServerSettings$configureUI$18(this));
        configureSectionsVisibility();
    }

    private final WidgetServerSettingsBinding getBinding() {
        return (WidgetServerSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131895591);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        this.guildId = longExtra;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettings$Model.Companion.get(longExtra), this, null, 2, null), WidgetServerSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
