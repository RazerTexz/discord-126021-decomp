package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildInvitePageBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.invite.GuildInviteViewModel;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildInvite.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInvitePageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CODE = "EXTRA_CODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StoreInviteSettings.InviteCode inviteCode;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, StoreInviteSettings.InviteCode inviteCode) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(inviteCode, "inviteCode");
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildInvite.EXTRA_CODE, inviteCode);
            C0870j.m156d(context, WidgetGuildInvite.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    public static final class C86491 extends AbstractC12240o implements Function1<GuildInviteViewModel.ViewState, Unit> {
        public C86491() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetGuildInvite.this.configureUI(viewState);
        }
    }

    public WidgetGuildInvite() {
        super(C5419R.layout.widget_guild_invite_page);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInvite$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInvite$viewModel$2 widgetGuildInvite$viewModel$2 = new WidgetGuildInvite$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildInviteViewModel.class), new WidgetGuildInvite$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildInvite$viewModel$2));
        this.inviteCode = (StoreInviteSettings.InviteCode) getMostRecentIntent().getParcelableExtra(EXTRA_CODE);
    }

    private final void configureLoadedUI(GuildInviteViewModel.ViewState.Loaded viewState) {
        boolean z2;
        GuildScheduledEventModel model;
        ModelInvite invite = viewState.getInvite();
        getBinding().f16797d.configureUI(invite, new WidgetGuildInvite$configureLoadedUI$onAcceptClick$1(this, invite));
        GuildScheduledEventItemView guildScheduledEventItemView = getBinding().f16796c;
        C12238m.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.guildInviteEventInfo");
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        if (guildScheduledEvent == null || (model = GuildScheduledEventModelKt.toModel(guildScheduledEvent)) == null) {
            z2 = false;
        } else {
            getBinding().f16796c.configureAsPreview(model, invite.getChannel(), GuildScheduledEventUtilitiesKt.getCreatorUserGuildMember$default(model, (StoreGuilds) null, (StoreUser) null, 3, (Object) null));
            z2 = true;
        }
        guildScheduledEventItemView.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f16795b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildInviteCancel");
        materialButton.setVisibility(8);
    }

    private final void configureUIFailure(Error e) {
        MaterialButton materialButton = getBinding().f16795b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildInviteCancel");
        materialButton.setVisibility(0);
        getBinding().f16797d.configureUIFailure(e);
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
        StoreStream.INSTANCE.getInviteSettings().clearInviteCode();
        if (getViewModel().getInviteResolved()) {
            return;
        }
        getViewModel().setInviteResolved(true);
        String str = "";
        if (invite == null) {
            StoreInviteSettings.InviteCode inviteCode2 = this.inviteCode;
            String str2 = (inviteCode2 == null || (inviteCode = inviteCode2.getInviteCode()) == null) ? "" : inviteCode;
            StoreInviteSettings.InviteCode inviteCode3 = this.inviteCode;
            AnalyticsTracker.inviteResolveFailed$default(str2, (inviteCode3 == null || (source = inviteCode3.getSource()) == null) ? "" : source, null, null, 12, null);
            return;
        }
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        StoreInviteSettings.InviteCode inviteCode4 = this.inviteCode;
        if (inviteCode4 != null && (source2 = inviteCode4.getSource()) != null) {
            str = source2;
        }
        analyticsTracker.inviteResolved(invite, str);
    }

    public final void configureUI(GuildInviteViewModel.ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        if (viewState instanceof GuildInviteViewModel.ViewState.Invalid) {
            configureUIFailure(null);
        } else if (viewState instanceof GuildInviteViewModel.ViewState.Loaded) {
            GuildInviteViewModel.ViewState.Loaded loaded = (GuildInviteViewModel.ViewState.Loaded) viewState;
            trackAndConsumeDynamicLinkCache(loaded.getInvite());
            configureLoadedUI(loaded);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
        analyticsTracker.impressionInviteAccept(inviteCode != null ? inviteCode.getInviteCode() : null);
        getBinding().f16795b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInvite.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Exception {
                AppActivity appActivity = WidgetGuildInvite.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.onBackPressed();
                }
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getViewModel().fetchInviteIfNotLoaded();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildInvite.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86491());
    }
}
