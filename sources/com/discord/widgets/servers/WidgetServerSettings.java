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
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.servers.WidgetServerDeleteDialog;
import com.discord.widgets.servers.WidgetServerSettings;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
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
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Action2;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: compiled from: WidgetServerSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetServerSettings.class, new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId));
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
        private final PermissionsContexts manageGuildContext;

        /* JADX INFO: compiled from: WidgetServerSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableF = Observable.f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptionsSettings(guildId), new Func6<MeUser, Guild, Long, List<? extends Channel>, Map<Long, ? extends Long>, Boolean, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettings$Model$Companion$get$1
                    @Override // rx.functions.Func6
                    public /* bridge */ /* synthetic */ WidgetServerSettings.Model call(MeUser meUser, Guild guild, Long l, List<? extends Channel> list, Map<Long, ? extends Long> map, Boolean bool) {
                        return call2(meUser, guild, l, (List<Channel>) list, (Map<Long, Long>) map, bool);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetServerSettings.Model call2(MeUser meUser, Guild guild, Long l, List<Channel> list, Map<Long, Long> map, Boolean bool) {
                        if (guild == null) {
                            return null;
                        }
                        PermissionsContexts.Companion companion2 = PermissionsContexts.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(list, "categories");
                        boolean z2 = guild.getOwnerId() == meUser.getId();
                        Intrinsics3.checkNotNullExpressionValue(map, "channelPermissions");
                        PermissionsContexts permissionsContextsFrom = companion2.from(list, z2, l, map, guild.getMfaLevel(), meUser.getMfaEnabled());
                        boolean zHasFeature = guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_ENABLED);
                        Intrinsics3.checkNotNullExpressionValue(bool, "canGuildSeeRoleSubscriptionsSettings");
                        return new WidgetServerSettings.Model(guild, permissionsContextsFrom, bool.booleanValue() && permissionsContextsFrom.getCanManageServer(), zHasFeature);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n          .co…            )\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, PermissionsContexts permissionsContexts, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(permissionsContexts, "manageGuildContext");
            this.guild = guild;
            this.manageGuildContext = permissionsContexts;
            this.canManageGuildRoleSubscriptions = z2;
            this.hasGuildRoleSubscriptions = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, PermissionsContexts permissionsContexts, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                permissionsContexts = model.manageGuildContext;
            }
            if ((i & 4) != 0) {
                z2 = model.canManageGuildRoleSubscriptions;
            }
            if ((i & 8) != 0) {
                z3 = model.hasGuildRoleSubscriptions;
            }
            return model.copy(guild, permissionsContexts, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PermissionsContexts getManageGuildContext() {
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

        public final Model copy(Guild guild, PermissionsContexts manageGuildContext, boolean canManageGuildRoleSubscriptions, boolean hasGuildRoleSubscriptions) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(manageGuildContext, "manageGuildContext");
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
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.manageGuildContext, model.manageGuildContext) && this.canManageGuildRoleSubscriptions == model.canManageGuildRoleSubscriptions && this.hasGuildRoleSubscriptions == model.hasGuildRoleSubscriptions;
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

        public final PermissionsContexts getManageGuildContext() {
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
            PermissionsContexts permissionsContexts = this.manageGuildContext;
            int iHashCode2 = (iHashCode + (permissionsContexts != null ? permissionsContexts.hashCode() : 0)) * 31;
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
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", manageGuildContext=");
            sbU.append(this.manageGuildContext);
            sbU.append(", canManageGuildRoleSubscriptions=");
            sbU.append(this.canManageGuildRoleSubscriptions);
            sbU.append(", hasGuildRoleSubscriptions=");
            return outline.O(sbU, this.hasGuildRoleSubscriptions, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettings.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettings widgetServerSettings) {
            super(1, widgetServerSettings, WidgetServerSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettings$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettings) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettings() {
        super(R.layout.widget_server_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettings3.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettings4.INSTANCE, 3);
    }

    private final void configureSectionsVisibility() {
        boolean z2;
        boolean z3;
        boolean z4;
        TextView textView;
        boolean z5 = true;
        List listListOf = Collections2.listOf((Object[]) new TextView[]{getBinding().p, getBinding().m, getBinding().n, getBinding().q, getBinding().r, getBinding().l, getBinding().d});
        List listListOf2 = Collections2.listOf((Object[]) new TextView[]{getBinding().k, getBinding().f2546s, getBinding().j, getBinding().f2545b});
        List listListOf3 = Collections2.listOf((Object[]) new TextView[]{getBinding().h, getBinding().f, getBinding().i, getBinding().g});
        LinearLayout linearLayout = getBinding().u;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionGeneralSettings");
        boolean z6 = listListOf instanceof Collection;
        if (!z6 || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                TextView textView2 = (TextView) it.next();
                Intrinsics3.checkNotNullExpressionValue(textView2, "view");
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
        Intrinsics3.checkNotNullExpressionValue(view, "binding.serverSettingsSectionUserManagementDivider");
        if (!z6 || !listListOf.isEmpty()) {
            Iterator it2 = listListOf.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                TextView textView3 = (TextView) it2.next();
                Intrinsics3.checkNotNullExpressionValue(textView3, "view");
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
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.serverSettingsSectionUserManagement");
        if (!(listListOf2 instanceof Collection) || !listListOf2.isEmpty()) {
            Iterator it3 = listListOf2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z4 = false;
                    break;
                }
                TextView textView4 = (TextView) it3.next();
                Intrinsics3.checkNotNullExpressionValue(textView4, "view");
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
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.serverSettingsSectionServerMonetization");
        if (!(listListOf3 instanceof Collection) || !listListOf3.isEmpty()) {
            Iterator it4 = listListOf3.iterator();
            do {
                if (!it4.hasNext()) {
                    z5 = false;
                    break;
                } else {
                    textView = (TextView) it4.next();
                    Intrinsics3.checkNotNullExpressionValue(textView, "view");
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
        TextView textView = getBinding().A;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsServerName");
        textView.setText(guild.getName());
        SimpleDraweeView simpleDraweeView = getBinding().f2548y;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsServerIcon");
        IconUtils.setIcon$default(simpleDraweeView, forGuild$default, R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        TextView textView2 = getBinding().f2549z;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsServerIconText");
        textView2.setVisibility(forGuild$default == null ? 0 : 8);
        TextView textView3 = getBinding().f2549z;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsServerIconText");
        textView3.setText(guild.getShortName());
        AppFragment.setActionBarOptionsMenu$default(this, model.getManageGuildContext().isOwnerWithRequiredMFALevel() ? R.menu.menu_server_settings : R.menu.menu_empty, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureToolbar.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_server_settings_delete) {
                    return;
                }
                WidgetServerDeleteDialog.Companion companion = WidgetServerDeleteDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetServerSettings.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, guild.getId());
            }
        }, null, 4, null);
    }

    private final void configureUI(final Model model) {
        if (model == null || !model.getManageGuildContext().canManage()) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        configureToolbar(model);
        PermissionsContexts manageGuildContext = model.getManageGuildContext();
        TextView textView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsOptionOverview");
        textView.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.Companion.create$default(WidgetServerSettingsOverview.INSTANCE, outline.x(view, "v", "v.context"), model.getGuild().getId(), false, 4, null);
            }
        });
        TextView textView2 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsOptionModeration");
        textView2.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsModeration.INSTANCE.launch(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView3 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsOptionAuditLog");
        textView3.setVisibility(manageGuildContext.getCanViewAuditLogs() ? 0 : 8);
        getBinding().l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsAuditLog.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId(), model.getGuild().getName());
            }
        });
        TextView textView4 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.serverSettingsOptionChannels");
        textView4.setVisibility(manageGuildContext.getCanManageChannels() ? 0 : 8);
        getBinding().m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsChannels.INSTANCE.show(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView5 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.serverSettingsOptionSecurity");
        textView5.setVisibility(manageGuildContext.isOwnerWithRequiredMFALevel() ? 0 : 8);
        getBinding().q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsSecurity.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView6 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.serverSettingsOptionIntegrations");
        textView6.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsIntegrations.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView7 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.serverSettingsOptionVanityUrl");
        textView7.setVisibility(manageGuildContext.getCanManageServer() && model.getGuild().getFeatures().contains(GuildFeature.VANITY_URL) ? 0 : 8);
        getBinding().r.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsVanityUrl.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        LinearLayout linearLayout = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionCommunity");
        linearLayout.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        TextView textView8 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.serverSettingsCommunityOverviewOption");
        Set<GuildFeature> features = model.getGuild().getFeatures();
        GuildFeature guildFeature = GuildFeature.COMMUNITY;
        textView8.setVisibility(features.contains(guildFeature) ? 0 : 8);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsCommunityOverview.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView9 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.serverSettingsEnableCommunityOption");
        textView9.setVisibility(model.getGuild().getFeatures().contains(guildFeature) ^ true ? 0 : 8);
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsEnableCommunitySteps.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        getBinding().k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsMembers.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView10 = getBinding().f2546s;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.serverSettingsRolesOption");
        textView10.setVisibility(manageGuildContext.getCanManageRoles() ? 0 : 8);
        getBinding().f2546s.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsRoles.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView11 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.serverSettingsInstantInvitesOption");
        textView11.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsInstantInvites.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView12 = getBinding().f2545b;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.serverSettingsBansOption");
        textView12.setVisibility(manageGuildContext.getCanManageBans() ? 0 : 8);
        getBinding().f2545b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsBans.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView13 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView13, "binding.serverSettingsEmojisOption");
        textView13.setVisibility(manageGuildContext.getCanManageEmojisAndStickers() ? 0 : 8);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsEmojis.INSTANCE.create(outline.x(view, "v", "v.context"), model.getGuild().getId());
            }
        });
        TextView textView14 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView14, "binding.serverSettingsGu…oleSubscriptionGetStarted");
        textView14.setVisibility(model.getCanManageGuildRoleSubscriptions() && !model.getHasGuildRoleSubscriptions() ? 0 : 8);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.15
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
        TextView textView15 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView15, "binding.serverSettingsGu…RoleSubscriptionBasicInfo");
        textView15.setVisibility(z2 ? 0 : 8);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsGuildRoleSubscriptions.INSTANCE.launch(WidgetServerSettings.this.requireContext(), model.getGuild().getId());
            }
        });
        TextView textView16 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView16, "binding.serverSettingsGuildRoleSubscriptionTiers");
        textView16.setVisibility(z2 ? 0 : 8);
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsGuildRoleSubscriptionTierList.INSTANCE.launch(WidgetServerSettings.this.requireContext(), model.getGuild().getId());
            }
        });
        TextView textView17 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView17, "binding.serverSettingsGu…dRoleSubscriptionEarnings");
        textView17.setVisibility(z2 ? 0 : 8);
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettings.configureUI.18
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

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.server_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        this.guildId = longExtra;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), (Class<?>) WidgetServerSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
