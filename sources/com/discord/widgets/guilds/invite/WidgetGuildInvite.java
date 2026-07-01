package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildInvitePageBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInviteSettings$InviteCode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInvite.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInvitePageBinding;", 0)};
    public static final WidgetGuildInvite$Companion Companion = new WidgetGuildInvite$Companion(null);
    private static final String EXTRA_CODE = "EXTRA_CODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StoreInviteSettings$InviteCode inviteCode;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildInvite() {
        super(R$layout.widget_guild_invite_page);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInvite$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInvite$viewModel$2 widgetGuildInvite$viewModel$2 = new WidgetGuildInvite$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildInviteViewModel.class), new WidgetGuildInvite$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInvite$viewModel$2));
        this.inviteCode = (StoreInviteSettings$InviteCode) getMostRecentIntent().getParcelableExtra(EXTRA_CODE);
    }

    public static final /* synthetic */ void access$configureUIFailure(WidgetGuildInvite widgetGuildInvite, Error error) {
        widgetGuildInvite.configureUIFailure(error);
    }

    private final void configureLoadedUI(GuildInviteViewModel$ViewState$Loaded viewState) {
        boolean z2;
        GuildScheduledEventModel model;
        ModelInvite invite = viewState.getInvite();
        getBinding().d.configureUI(invite, new WidgetGuildInvite$configureLoadedUI$onAcceptClick$1(this, invite));
        GuildScheduledEventItemView guildScheduledEventItemView = getBinding().c;
        m.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.guildInviteEventInfo");
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        if (guildScheduledEvent == null || (model = GuildScheduledEventModelKt.toModel(guildScheduledEvent)) == null) {
            z2 = false;
        } else {
            getBinding().c.configureAsPreview(model, invite.getChannel(), GuildScheduledEventUtilitiesKt.getCreatorUserGuildMember$default(model, (StoreGuilds) null, (StoreUser) null, 3, (Object) null));
            z2 = true;
        }
        guildScheduledEventItemView.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f2416b;
        m.checkNotNullExpressionValue(materialButton, "binding.guildInviteCancel");
        materialButton.setVisibility(8);
    }

    private final void configureUIFailure(Error e) {
        MaterialButton materialButton = getBinding().f2416b;
        m.checkNotNullExpressionValue(materialButton, "binding.guildInviteCancel");
        materialButton.setVisibility(0);
        getBinding().d.configureUIFailure(e);
        trackAndConsumeDynamicLinkCache(null);
    }

    private final WidgetGuildInvitePageBinding getBinding() {
        return (WidgetGuildInvitePageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildInviteViewModel getViewModel() {
        return (GuildInviteViewModel) this.viewModel.getValue();
    }

    private final void trackAndConsumeDynamicLinkCache(ModelInvite invite) {
        String source;
        String inviteCode;
        String source2;
        StoreStream.Companion.getInviteSettings().clearInviteCode();
        if (getViewModel().getInviteResolved()) {
            return;
        }
        getViewModel().setInviteResolved(true);
        String str = "";
        if (invite == null) {
            StoreInviteSettings$InviteCode storeInviteSettings$InviteCode = this.inviteCode;
            String str2 = (storeInviteSettings$InviteCode == null || (inviteCode = storeInviteSettings$InviteCode.getInviteCode()) == null) ? "" : inviteCode;
            StoreInviteSettings$InviteCode storeInviteSettings$InviteCode2 = this.inviteCode;
            AnalyticsTracker.inviteResolveFailed$default(str2, (storeInviteSettings$InviteCode2 == null || (source = storeInviteSettings$InviteCode2.getSource()) == null) ? "" : source, null, null, 12, null);
            return;
        }
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        StoreInviteSettings$InviteCode storeInviteSettings$InviteCode3 = this.inviteCode;
        if (storeInviteSettings$InviteCode3 != null && (source2 = storeInviteSettings$InviteCode3.getSource()) != null) {
            str = source2;
        }
        analyticsTracker.inviteResolved(invite, str);
    }

    public final void configureUI(GuildInviteViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (viewState instanceof GuildInviteViewModel$ViewState$Invalid) {
            configureUIFailure(null);
        } else if (viewState instanceof GuildInviteViewModel$ViewState$Loaded) {
            GuildInviteViewModel$ViewState$Loaded guildInviteViewModel$ViewState$Loaded = (GuildInviteViewModel$ViewState$Loaded) viewState;
            trackAndConsumeDynamicLinkCache(guildInviteViewModel$ViewState$Loaded.getInvite());
            configureLoadedUI(guildInviteViewModel$ViewState$Loaded);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        StoreInviteSettings$InviteCode storeInviteSettings$InviteCode = this.inviteCode;
        analyticsTracker.impressionInviteAccept(storeInviteSettings$InviteCode != null ? storeInviteSettings$InviteCode.getInviteCode() : null);
        getBinding().f2416b.setOnClickListener(new WidgetGuildInvite$onViewBound$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getViewModel().fetchInviteIfNotLoaded();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildInvite.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInvite$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
