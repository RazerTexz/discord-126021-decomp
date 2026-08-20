package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.ManageGuildContext;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions;
import com.discord.widgets.servers.guild_role_subscription.payments.WidgetServerSettingsGuildRoleSubscriptionEarnings;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;
import p658rx.functions.Func6;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: compiled from: WidgetServerSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetServerSettings.class, new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettings.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageGuildRoleSubscriptions;
        private final Guild guild;
        private final boolean hasGuildRoleSubscriptions;
        private final ManageGuildContext manageGuildContext;

        /* JADX INFO: compiled from: WidgetServerSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11071f = Observable.m11071f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptionsSettings(guildId), new Func6<MeUser, Guild, Long, List<? extends Channel>, Map<Long, ? extends Long>, Boolean, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettings$Model$Companion$get$1
                    @Override // p658rx.functions.Func6
                    public /* bridge */ /* synthetic */ WidgetServerSettings.Model call(MeUser meUser, Guild guild, Long l, List<? extends Channel> list, Map<Long, ? extends Long> map, Boolean bool) {
                        return call2(meUser, guild, l, (List<Channel>) list, (Map<Long, Long>) map, bool);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetServerSettings.Model call2(MeUser meUser, Guild guild, Long l, List<Channel> list, Map<Long, Long> map, Boolean bool) {
                        if (guild == null) {
                            return null;
                        }
                        ManageGuildContext.Companion companion2 = ManageGuildContext.INSTANCE;
                        C12238m.checkNotNullExpressionValue(list, "categories");
                        boolean z2 = guild.getOwnerId() == meUser.getId();
                        C12238m.checkNotNullExpressionValue(map, "channelPermissions");
                        ManageGuildContext manageGuildContextFrom = companion2.from(list, z2, l, map, guild.getMfaLevel(), meUser.getMfaEnabled());
                        boolean zHasFeature = guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_ENABLED);
                        C12238m.checkNotNullExpressionValue(bool, "canGuildSeeRoleSubscriptionsSettings");
                        return new WidgetServerSettings.Model(guild, manageGuildContextFrom, bool.booleanValue() && manageGuildContextFrom.getCanManageServer(), zHasFeature);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11071f, "Observable\n          .co…            )\n          }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11071f).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ManageGuildContext manageGuildContext, boolean z2, boolean z3) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
            this.guild = guild;
            this.manageGuildContext = manageGuildContext;
            this.canManageGuildRoleSubscriptions = z2;
            this.hasGuildRoleSubscriptions = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, ManageGuildContext manageGuildContext, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                manageGuildContext = model.manageGuildContext;
            }
            if ((i & 4) != 0) {
                z2 = model.canManageGuildRoleSubscriptions;
            }
            if ((i & 8) != 0) {
                z3 = model.hasGuildRoleSubscriptions;
            }
            return model.copy(guild, manageGuildContext, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ManageGuildContext getManageGuildContext() {
            return this.manageGuildContext;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanManageGuildRoleSubscriptions() {
            return this.canManageGuildRoleSubscriptions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getHasGuildRoleSubscriptions() {
            return this.hasGuildRoleSubscriptions;
        }

        public final Model copy(Guild guild, ManageGuildContext manageGuildContext, boolean canManageGuildRoleSubscriptions, boolean hasGuildRoleSubscriptions) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
            return new Model(guild, manageGuildContext, canManageGuildRoleSubscriptions, hasGuildRoleSubscriptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.manageGuildContext, model.manageGuildContext) && this.canManageGuildRoleSubscriptions == model.canManageGuildRoleSubscriptions && this.hasGuildRoleSubscriptions == model.hasGuildRoleSubscriptions;
        }

        public final boolean getCanManageGuildRoleSubscriptions() {
            return this.canManageGuildRoleSubscriptions;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final boolean getHasGuildRoleSubscriptions() {
            return this.hasGuildRoleSubscriptions;
        }

        public final ManageGuildContext getManageGuildContext() {
            return this.manageGuildContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            ManageGuildContext manageGuildContext = this.manageGuildContext;
            int iHashCode2 = (iHashCode + (manageGuildContext != null ? manageGuildContext.hashCode() : 0)) * 31;
            boolean z2 = this.canManageGuildRoleSubscriptions;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            boolean z3 = this.hasGuildRoleSubscriptions;
            return i + (z3 ? 1 : z3);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", manageGuildContext=");
            sbM833U.append(this.manageGuildContext);
            sbM833U.append(", canManageGuildRoleSubscriptions=");
            sbM833U.append(this.canManageGuildRoleSubscriptions);
            sbM833U.append(", hasGuildRoleSubscriptions=");
            return C1643a.m827O(sbM833U, this.hasGuildRoleSubscriptions, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettings.kt */
    public static final /* synthetic */ class C91891 extends C12236k implements Function1<Model, Unit> {
        public C91891(WidgetServerSettings widgetServerSettings) {
            super(1, widgetServerSettings, WidgetServerSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettings$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettings) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettings() {
        super(C5419R.layout.widget_server_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettings$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettings$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureSectionsVisibility() {
        boolean z2;
        boolean z3;
        boolean z4;
        TextView textView;
        boolean z5 = true;
        List listListOf = C12147n.listOf((Object[]) new TextView[]{getBinding().f17554p, getBinding().f17551m, getBinding().f17552n, getBinding().f17555q, getBinding().f17556r, getBinding().f17550l, getBinding().f17542d});
        List listListOf2 = C12147n.listOf((Object[]) new TextView[]{getBinding().f17549k, getBinding().f17557s, getBinding().f17548j, getBinding().f17540b});
        List listListOf3 = C12147n.listOf((Object[]) new TextView[]{getBinding().f17546h, getBinding().f17544f, getBinding().f17547i, getBinding().f17545g});
        LinearLayout linearLayout = getBinding().f17559u;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionGeneralSettings");
        boolean z6 = listListOf instanceof Collection;
        if (!z6 || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                TextView textView2 = (TextView) it.next();
                C12238m.checkNotNullExpressionValue(textView2, "view");
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
        View view = getBinding().f17562x;
        C12238m.checkNotNullExpressionValue(view, "binding.serverSettingsSectionUserManagementDivider");
        if (!z6 || !listListOf.isEmpty()) {
            Iterator it2 = listListOf.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                TextView textView3 = (TextView) it2.next();
                C12238m.checkNotNullExpressionValue(textView3, "view");
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
        LinearLayout linearLayout2 = getBinding().f17561w;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.serverSettingsSectionUserManagement");
        if (!(listListOf2 instanceof Collection) || !listListOf2.isEmpty()) {
            Iterator it3 = listListOf2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z4 = false;
                    break;
                }
                TextView textView4 = (TextView) it3.next();
                C12238m.checkNotNullExpressionValue(textView4, "view");
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
        LinearLayout linearLayout3 = getBinding().f17560v;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.serverSettingsSectionServerMonetization");
        if (!(listListOf3 instanceof Collection) || !listListOf3.isEmpty()) {
            Iterator it4 = listListOf3.iterator();
            do {
                if (!it4.hasNext()) {
                    z5 = false;
                    break;
                } else {
                    textView = (TextView) it4.next();
                    C12238m.checkNotNullExpressionValue(textView, "view");
                }
            } while (!(textView.getVisibility() == 0));
        } else {
            z5 = false;
            break;
        }
        linearLayout3.setVisibility(z5 ? 0 : 8);
    }

    private final void configureToolbar(Model model) {
        final Guild guild = model.getGuild();
        String forGuild$default = IconUtils.getForGuild$default(guild, null, true, null, 10, null);
        TextView textView = getBinding().f17538A;
        C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsServerName");
        textView.setText(guild.getName());
        SimpleDraweeView simpleDraweeView = getBinding().f17563y;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsServerIcon");
        IconUtils.setIcon$default(simpleDraweeView, forGuild$default, C5419R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        TextView textView2 = getBinding().f17564z;
        C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsServerIconText");
        textView2.setVisibility(forGuild$default == null ? 0 : 8);
        TextView textView3 = getBinding().f17564z;
        C12238m.checkNotNullExpressionValue(textView3, "binding.serverSettingsServerIconText");
        textView3.setText(guild.getShortName());
        AppFragment.setActionBarOptionsMenu$default(this, model.getManageGuildContext().isOwnerWithRequiredMFALevel() ? C5419R.menu.menu_server_settings : C5419R.menu.menu_empty, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureToolbar.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_server_settings_delete) {
                    return;
                }
                WidgetServerDeleteDialog.Companion companion = WidgetServerDeleteDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetServerSettings.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, guild.getId());
            }
        }, null, 4, null);
    }

    private final void configureUI(final Model model) {
        if (model == null || !model.getManageGuildContext().canManage()) {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
                return;
            }
            return;
        }
        configureToolbar(model);
        ManageGuildContext manageGuildContext = model.getManageGuildContext();
        TextView textView = getBinding().f17554p;
        C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsOptionOverview");
        textView.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17554p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.Companion.create$default(WidgetServerSettingsOverview.INSTANCE, C1643a.m885x(view, "v", "v.context"), model.getGuild().getId(), false, 4, null);
            }
        });
        TextView textView2 = getBinding().f17553o;
        C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsOptionModeration");
        textView2.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17553o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsModeration.INSTANCE.launch(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView3 = getBinding().f17550l;
        C12238m.checkNotNullExpressionValue(textView3, "binding.serverSettingsOptionAuditLog");
        textView3.setVisibility(manageGuildContext.getCanViewAuditLogs() ? 0 : 8);
        getBinding().f17550l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsAuditLog.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId(), model.getGuild().getName());
            }
        });
        TextView textView4 = getBinding().f17551m;
        C12238m.checkNotNullExpressionValue(textView4, "binding.serverSettingsOptionChannels");
        textView4.setVisibility(manageGuildContext.getCanManageChannels() ? 0 : 8);
        getBinding().f17551m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsChannels.INSTANCE.show(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView5 = getBinding().f17555q;
        C12238m.checkNotNullExpressionValue(textView5, "binding.serverSettingsOptionSecurity");
        textView5.setVisibility(manageGuildContext.isOwnerWithRequiredMFALevel() ? 0 : 8);
        getBinding().f17555q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsSecurity.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView6 = getBinding().f17552n;
        C12238m.checkNotNullExpressionValue(textView6, "binding.serverSettingsOptionIntegrations");
        textView6.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17552n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsIntegrations.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView7 = getBinding().f17556r;
        C12238m.checkNotNullExpressionValue(textView7, "binding.serverSettingsOptionVanityUrl");
        textView7.setVisibility(manageGuildContext.getCanManageServer() && model.getGuild().getFeatures().contains(GuildFeature.VANITY_URL) ? 0 : 8);
        getBinding().f17556r.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsVanityUrl.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        LinearLayout linearLayout = getBinding().f17558t;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionCommunity");
        linearLayout.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        TextView textView8 = getBinding().f17541c;
        C12238m.checkNotNullExpressionValue(textView8, "binding.serverSettingsCommunityOverviewOption");
        Set<GuildFeature> features = model.getGuild().getFeatures();
        GuildFeature guildFeature = GuildFeature.COMMUNITY;
        textView8.setVisibility(features.contains(guildFeature) ? 0 : 8);
        getBinding().f17541c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsCommunityOverview.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView9 = getBinding().f17543e;
        C12238m.checkNotNullExpressionValue(textView9, "binding.serverSettingsEnableCommunityOption");
        textView9.setVisibility(model.getGuild().getFeatures().contains(guildFeature) ^ true ? 0 : 8);
        getBinding().f17543e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsEnableCommunitySteps.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        getBinding().f17549k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsMembers.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView10 = getBinding().f17557s;
        C12238m.checkNotNullExpressionValue(textView10, "binding.serverSettingsRolesOption");
        textView10.setVisibility(manageGuildContext.getCanManageRoles() ? 0 : 8);
        getBinding().f17557s.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsRoles.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView11 = getBinding().f17548j;
        C12238m.checkNotNullExpressionValue(textView11, "binding.serverSettingsInstantInvitesOption");
        textView11.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17548j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsInstantInvites.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView12 = getBinding().f17540b;
        C12238m.checkNotNullExpressionValue(textView12, "binding.serverSettingsBansOption");
        textView12.setVisibility(manageGuildContext.getCanManageBans() ? 0 : 8);
        getBinding().f17540b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsBans.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView13 = getBinding().f17542d;
        C12238m.checkNotNullExpressionValue(textView13, "binding.serverSettingsEmojisOption");
        textView13.setVisibility(manageGuildContext.getCanManageEmojisAndStickers() ? 0 : 8);
        getBinding().f17542d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsEmojis.INSTANCE.create(C1643a.m885x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView14 = getBinding().f17546h;
        C12238m.checkNotNullExpressionValue(textView14, "binding.serverSettingsGu…oleSubscriptionGetStarted");
        textView14.setVisibility(model.getCanManageGuildRoleSubscriptions() && !model.getHasGuildRoleSubscriptions() ? 0 : 8);
        getBinding().f17546h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                    WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(WidgetServerSettings.this.requireContext(), model.getGuild().getId());
                } else {
                    WidgetServerSettingsCreatorMonetizationOnboarding.INSTANCE.launch(WidgetServerSettings.this.requireContext(), model.getGuild().getId());
                }
            }
        });
        boolean z2 = model.getCanManageGuildRoleSubscriptions() && model.getHasGuildRoleSubscriptions();
        TextView textView15 = getBinding().f17544f;
        C12238m.checkNotNullExpressionValue(textView15, "binding.serverSettingsGu…RoleSubscriptionBasicInfo");
        textView15.setVisibility(z2 ? 0 : 8);
        getBinding().f17544f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsGuildRoleSubscriptions.INSTANCE.launch(WidgetServerSettings.this.requireContext(), model.getGuild().getId());
            }
        });
        TextView textView16 = getBinding().f17547i;
        C12238m.checkNotNullExpressionValue(textView16, "binding.serverSettingsGuildRoleSubscriptionTiers");
        textView16.setVisibility(z2 ? 0 : 8);
        getBinding().f17547i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsGuildRoleSubscriptionTierList.INSTANCE.launch(WidgetServerSettings.this.requireContext(), model.getGuild().getId());
            }
        });
        TextView textView17 = getBinding().f17545g;
        C12238m.checkNotNullExpressionValue(textView17, "binding.serverSettingsGu…dRoleSubscriptionEarnings");
        textView17.setVisibility(z2 ? 0 : 8);
        getBinding().f17545g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsGuildRoleSubscriptionEarnings.INSTANCE.launch(WidgetServerSettings.this.requireContext());
            }
        });
        configureSectionsVisibility();
    }

    private final WidgetServerSettingsBinding getBinding() {
        return (WidgetServerSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.server_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        this.guildId = longExtra;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), (Class<?>) WidgetServerSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91891(this));
    }
}
