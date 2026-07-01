package com.discord.widgets.servers.settings.invites;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsInstantInvitesBinding;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsInstantInvites.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", 0)};
    public static final WidgetServerSettingsInstantInvites$Companion Companion = new WidgetServerSettingsInstantInvites$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_INVITES_LIST = 1;
    private static final int VIEW_INDEX_INVITES_LOADING = 0;
    private static final int VIEW_INDEX_NO_INVITES = 2;
    private WidgetServerSettingsInstantInvites$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private final StoreInstantInvites storeInstantInvites;

    public WidgetServerSettingsInstantInvites() {
        super(R$layout.widget_server_settings_instant_invites);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsInstantInvites$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsInstantInvites$guildId$2(this));
        this.storeInstantInvites = StoreStream.Companion.getInstantInvites();
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsInstantInvites$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites, WidgetServerSettingsInstantInvites$Model widgetServerSettingsInstantInvites$Model) {
        widgetServerSettingsInstantInvites.configureUI(widgetServerSettingsInstantInvites$Model);
    }

    private final void configureUI(WidgetServerSettingsInstantInvites$Model data) throws Exception {
        if (data == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        if (data.getInviteItems() == null) {
            AppViewFlipper appViewFlipper = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (data.getInviteItems().isEmpty()) {
            AppViewFlipper appViewFlipper2 = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper2.setDisplayedChild(2);
        } else {
            AppViewFlipper appViewFlipper3 = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper3.setDisplayedChild(1);
            WidgetServerSettingsInstantInvites$Adapter widgetServerSettingsInstantInvites$Adapter = this.adapter;
            if (widgetServerSettingsInstantInvites$Adapter != null) {
                widgetServerSettingsInstantInvites$Adapter.configure(data.getInviteItems(), new WidgetServerSettingsInstantInvites$configureUI$1(this), WidgetServerSettingsInstantInvites$configureUI$2.INSTANCE);
            }
        }
        setActionBarTitle(2131892087);
        setActionBarSubtitle(data.getGuild().getName());
    }

    private final WidgetServerSettingsInstantInvitesBinding getBinding() {
        return (WidgetServerSettingsInstantInvitesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2575b;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsInstantInvitesRecycler");
        this.adapter = (WidgetServerSettingsInstantInvites$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsInstantInvites$Adapter(recyclerView));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.storeInstantInvites.clearInvites(getGuildId());
        this.storeInstantInvites.fetchGuildInvites(getGuildId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsInstantInvites$Model$Companion.get$default(WidgetServerSettingsInstantInvites$Model.Companion, getGuildId(), null, null, 6, null), this, null, 2, null), WidgetServerSettingsInstantInvites.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsInstantInvites$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
