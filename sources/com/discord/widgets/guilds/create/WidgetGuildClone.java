package com.discord.widgets.guilds.create;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.role.GuildRole;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Invalid;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$LoadFailed;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Loading;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$None;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Resolved;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.roles.RolesListView;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildClone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildClone extends WidgetGuildCreate {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildClone.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCloneBinding;", 0)};
    public static final WidgetGuildClone$Companion Companion = new WidgetGuildClone$Companion(null);
    private static final String INTENT_GUILD_TEMPLATE_CODE = "guild_template_code";
    private static final int VIEW_INDEX_INVALID_TEMPLATE = 1;
    private static final int VIEW_INDEX_LOADING_TEMPLATE = 0;
    private static final int VIEW_INDEX_READY = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetGuildClone() {
        super(R$layout.widget_guild_clone);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildClone$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetGuildCloneBinding getBinding() {
        return (WidgetGuildCloneBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public void configureUI(WidgetGuildCreateViewModel$ViewState viewState) {
        List<Channel> listEmptyList;
        m.checkNotNullParameter(viewState, "viewState");
        super.configureUI(viewState);
        StoreStream.Companion.getGuildTemplates().clearDynamicLinkGuildTemplateCode();
        if (m.areEqual(viewState, WidgetGuildCreateViewModel$ViewState$Uninitialized.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.guildCreateFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof WidgetGuildCreateViewModel$ViewState$Initialized) {
            WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized = (WidgetGuildCreateViewModel$ViewState$Initialized) viewState;
            StoreGuildTemplates$GuildTemplateState guildTemplate = widgetGuildCreateViewModel$ViewState$Initialized.getGuildTemplate();
            if (m.areEqual(guildTemplate, StoreGuildTemplates$GuildTemplateState$None.INSTANCE) || m.areEqual(guildTemplate, StoreGuildTemplates$GuildTemplateState$Invalid.INSTANCE) || m.areEqual(guildTemplate, StoreGuildTemplates$GuildTemplateState$LoadFailed.INSTANCE)) {
                AppViewFlipper appViewFlipper2 = getBinding().c;
                m.checkNotNullExpressionValue(appViewFlipper2, "binding.guildCreateFlipper");
                appViewFlipper2.setDisplayedChild(1);
                return;
            }
            if (m.areEqual(guildTemplate, StoreGuildTemplates$GuildTemplateState$Loading.INSTANCE)) {
                AppViewFlipper appViewFlipper3 = getBinding().c;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.guildCreateFlipper");
                appViewFlipper3.setDisplayedChild(0);
                return;
            }
            if (guildTemplate instanceof StoreGuildTemplates$GuildTemplateState$Resolved) {
                ModelGuildTemplate guildTemplate2 = ((StoreGuildTemplates$GuildTemplateState$Resolved) widgetGuildCreateViewModel$ViewState$Initialized.getGuildTemplate()).getGuildTemplate();
                Guild serializedSourceGuild = guildTemplate2.getSerializedSourceGuild();
                if (serializedSourceGuild == null) {
                    AppViewFlipper appViewFlipper4 = getBinding().c;
                    m.checkNotNullExpressionValue(appViewFlipper4, "binding.guildCreateFlipper");
                    appViewFlipper4.setDisplayedChild(1);
                    return;
                }
                AppViewFlipper appViewFlipper5 = getBinding().c;
                m.checkNotNullExpressionValue(appViewFlipper5, "binding.guildCreateFlipper");
                appViewFlipper5.setDisplayedChild(2);
                TextView textView = getBinding().g;
                m.checkNotNullExpressionValue(textView, "binding.guildTemplateName");
                int themedColor = ColorCompat.getThemedColor(textView, 2130968990);
                TextView textView2 = getBinding().g;
                m.checkNotNullExpressionValue(textView2, "binding.guildTemplateName");
                ColorCompatKt.setDrawableColor(textView2, themedColor);
                TextView textView3 = getBinding().g;
                m.checkNotNullExpressionValue(textView3, "binding.guildTemplateName");
                textView3.setText(guildTemplate2.getName());
                GuildTemplateChannelsView guildTemplateChannelsView = getBinding().h;
                List<Channel> listG = serializedSourceGuild.g();
                if (listG == null || (listEmptyList = u.sortedWith(listG, new WidgetGuildClone$configureUI$$inlined$sortedBy$1())) == null) {
                    listEmptyList = n.emptyList();
                }
                guildTemplateChannelsView.updateView(listEmptyList);
                List<GuildRole> listG2 = serializedSourceGuild.G();
                if (listG2 == null) {
                    listG2 = n.emptyList();
                }
                List listSortedWith = u.sortedWith(listG2, new WidgetGuildClone$configureUI$$inlined$sortedBy$2());
                ArrayList arrayList = new ArrayList();
                for (Object obj : listSortedWith) {
                    if (!m.areEqual(((GuildRole) obj).getName(), "@everyone")) {
                        arrayList.add(obj);
                    }
                }
                LinearLayout linearLayout = getBinding().j;
                m.checkNotNullExpressionValue(linearLayout, "binding.guildTemplatePreviewRolesLayout");
                linearLayout.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
                RolesListView rolesListView = getBinding().i;
                RolesListView rolesListView2 = getBinding().i;
                m.checkNotNullExpressionValue(rolesListView2, "binding.guildTemplatePreviewRoles");
                rolesListView.updateView(arrayList, ColorCompat.getThemedColor(rolesListView2.getContext(), 2130969978), serializedSourceGuild.getId());
            }
        }
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(2131888245, null, getMostRecentIntent().getStringExtra(INTENT_GUILD_TEMPLATE_CODE), false, getArgs().getAnalyticsLocation(), null, false, null, null, null, 962, null);
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews$Companion guildCreateCloneViews$Companion = GuildCreateCloneViews.Companion;
        WidgetGuildCloneBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        return guildCreateCloneViews$Companion.from(binding);
    }
}
