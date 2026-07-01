package com.discord.widgets.guilds.create;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.role.GuildRole;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.create.GuildCreateCloneViews;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.guilds.create.WidgetGuildCreateViewModel;
import com.discord.widgets.roles.RolesListView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildClone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildClone extends WidgetGuildCreate {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildClone.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCloneBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_GUILD_TEMPLATE_CODE = "guild_template_code";
    private static final int VIEW_INDEX_INVALID_TEMPLATE = 1;
    private static final int VIEW_INDEX_LOADING_TEMPLATE = 0;
    private static final int VIEW_INDEX_READY = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetGuildClone.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.show(context, str, str2);
        }

        public final void show(Context context, String guildTemplateCode, String location) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildCreate.EXTRA_OPTIONS, new WidgetGuildCreate.Options(location, null, false, null, false, 30, null));
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(EXTRA_OPTIONS, options)");
            if (guildTemplateCode != null) {
                intentPutExtra.putExtra(WidgetGuildClone.INTENT_GUILD_TEMPLATE_CODE, guildTemplateCode);
            }
            AppScreen2.d(context, WidgetGuildClone.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetGuildClone() {
        super(R.layout.widget_guild_clone);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildClone2.INSTANCE, null, 2, null);
    }

    private final WidgetGuildCloneBinding getBinding() {
        return (WidgetGuildCloneBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public void configureUI(WidgetGuildCreateViewModel.ViewState viewState) {
        List<Channel> listEmptyList;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.configureUI(viewState);
        StoreStream.INSTANCE.getGuildTemplates().clearDynamicLinkGuildTemplateCode();
        if (Intrinsics3.areEqual(viewState, WidgetGuildCreateViewModel.ViewState.Uninitialized.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildCreateFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof WidgetGuildCreateViewModel.ViewState.Initialized) {
            WidgetGuildCreateViewModel.ViewState.Initialized initialized = (WidgetGuildCreateViewModel.ViewState.Initialized) viewState;
            StoreGuildTemplates.GuildTemplateState guildTemplate = initialized.getGuildTemplate();
            if (Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.None.INSTANCE) || Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.Invalid.INSTANCE) || Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.LoadFailed.INSTANCE)) {
                AppViewFlipper appViewFlipper2 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.guildCreateFlipper");
                appViewFlipper2.setDisplayedChild(1);
                return;
            }
            if (Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.Loading.INSTANCE)) {
                AppViewFlipper appViewFlipper3 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.guildCreateFlipper");
                appViewFlipper3.setDisplayedChild(0);
                return;
            }
            if (guildTemplate instanceof StoreGuildTemplates.GuildTemplateState.Resolved) {
                ModelGuildTemplate guildTemplate2 = ((StoreGuildTemplates.GuildTemplateState.Resolved) initialized.getGuildTemplate()).getGuildTemplate();
                Guild serializedSourceGuild = guildTemplate2.getSerializedSourceGuild();
                if (serializedSourceGuild == null) {
                    AppViewFlipper appViewFlipper4 = getBinding().c;
                    Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.guildCreateFlipper");
                    appViewFlipper4.setDisplayedChild(1);
                    return;
                }
                AppViewFlipper appViewFlipper5 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper5, "binding.guildCreateFlipper");
                appViewFlipper5.setDisplayedChild(2);
                TextView textView = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildTemplateName");
                int themedColor = ColorCompat.getThemedColor(textView, R.attr.colorHeaderSecondary);
                TextView textView2 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildTemplateName");
                ColorCompat2.setDrawableColor(textView2, themedColor);
                TextView textView3 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildTemplateName");
                textView3.setText(guildTemplate2.getName());
                GuildTemplateChannelsView guildTemplateChannelsView = getBinding().h;
                List<Channel> listG = serializedSourceGuild.g();
                if (listG == null || (listEmptyList = _Collections.sortedWith(listG, new Comparator() { // from class: com.discord.widgets.guilds.create.WidgetGuildClone$configureUI$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Channel channel = (Channel) t;
                        Channel channel2 = (Channel) t2;
                        return a.compareValues(Long.valueOf(channel.getParentId() == 0 ? channel.getId() * ((long) 10000) : (channel.getParentId() * ((long) 10000)) + channel.getId()), Long.valueOf(channel2.getParentId() == 0 ? channel2.getId() * ((long) 10000) : (channel2.getParentId() * ((long) 10000)) + channel2.getId()));
                    }
                })) == null) {
                    listEmptyList = Collections2.emptyList();
                }
                guildTemplateChannelsView.updateView(listEmptyList);
                List<GuildRole> listG2 = serializedSourceGuild.G();
                if (listG2 == null) {
                    listG2 = Collections2.emptyList();
                }
                List listSortedWith = _Collections.sortedWith(listG2, new Comparator() { // from class: com.discord.widgets.guilds.create.WidgetGuildClone$configureUI$$inlined$sortedBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return a.compareValues(Long.valueOf(-((GuildRole) t).getId()), Long.valueOf(-((GuildRole) t2).getId()));
                    }
                });
                ArrayList arrayList = new ArrayList();
                for (Object obj : listSortedWith) {
                    if (!Intrinsics3.areEqual(((GuildRole) obj).getName(), "@everyone")) {
                        arrayList.add(obj);
                    }
                }
                LinearLayout linearLayout = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildTemplatePreviewRolesLayout");
                linearLayout.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
                RolesListView rolesListView = getBinding().i;
                RolesListView rolesListView2 = getBinding().i;
                Intrinsics3.checkNotNullExpressionValue(rolesListView2, "binding.guildTemplatePreviewRoles");
                rolesListView.updateView(arrayList, ColorCompat.getThemedColor(rolesListView2.getContext(), R.attr.primary_300), serializedSourceGuild.getId());
            }
        }
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(R.string.create_server_default_server_name_format, null, getMostRecentIntent().getStringExtra(INTENT_GUILD_TEMPLATE_CODE), false, getArgs().getAnalyticsLocation(), null, false, null, null, null, 962, null);
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews.Companion companion = GuildCreateCloneViews.INSTANCE;
        WidgetGuildCloneBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        return companion.from(binding);
    }
}
