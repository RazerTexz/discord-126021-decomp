package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteShareSheetBinding;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.SearchInputView;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet extends AppBottomSheet {
    private static final String ARG_ANALYTICS_SOURCE = "ARG_ANALYTICS_SOURCE";
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private InviteSuggestionsAdapter adapter;
    private String analyticsSource;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> guildInviteSettingsLauncher;
    private boolean isFixedHeight;
    private final LoggingConfig loggingConfig;
    private boolean restoredSearchQueryFromViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteShareSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareSheetBinding;", 0)};
    public static final WidgetGuildInviteShareSheet$Companion Companion = new WidgetGuildInviteShareSheet$Companion(null);

    public WidgetGuildInviteShareSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShareSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareSheet$viewModel$2 widgetGuildInviteShareSheet$viewModel$2 = new WidgetGuildInviteShareSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildInviteShareSheetViewModel.class), new WidgetGuildInviteShareSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteShareSheet$viewModel$2));
        this.guildInviteSettingsLauncher = WidgetGuildInviteSettings.Companion.registerForResult(this, new WidgetGuildInviteShareSheet$guildInviteSettingsLauncher$1(this));
        this.analyticsSource = "";
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildInviteShareSheet$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ String access$getAnalyticsSource$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.analyticsSource;
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildInviteShareSheetBinding access$getBinding$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getGuildInviteSettingsLauncher$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.guildInviteSettingsLauncher;
    }

    public static final /* synthetic */ GuildInviteShareSheetViewModel access$getViewModel$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        return widgetGuildInviteShareSheet.getViewModel();
    }

    public static final /* synthetic */ void access$setAnalyticsSource$p(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, String str) {
        widgetGuildInviteShareSheet.analyticsSource = str;
    }

    private final void configureEmptyStateUI(GuildInviteShareSheetViewModel$ViewState viewState) {
        if (this.isFixedHeight) {
            this.isFixedHeight = false;
            FrameLayout frameLayout = getBinding().j;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$doOnLayout$1());
            } else {
                ViewGroup$LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams) layoutParams;
                frameLayout$LayoutParams.height = -1;
                frameLayout.setLayoutParams(frameLayout$LayoutParams);
            }
        }
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        AppViewFlipper appViewFlipper = binding.n;
        m.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(0);
        NestedScrollView nestedScrollView = binding.f;
        m.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(true);
        GuildInvite invite = viewState.getInvite();
        ModelInvite$Settings inviteSettings = viewState.getInviteSettings();
        CharSequence inviteSettingsText = null;
        if (invite != null) {
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            TextView textView = binding.d;
            m.checkNotNullExpressionValue(textView, "emptyStateInviteLink");
            textView.setText(invite.toLink());
            TextView textView2 = binding.g;
            m.checkNotNullExpressionValue(textView2, "emptyStateSettingsSubtext");
            if (inviteSettings != null) {
                Context contextRequireContext = requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                inviteSettingsText = GuildInviteUiHelperKt.getInviteSettingsText(contextRequireContext, expirationTimeMs, inviteSettings.getMaxUses());
            }
            textView2.setText(inviteSettingsText);
        } else {
            TextView textView3 = binding.d;
            m.checkNotNullExpressionValue(textView3, "emptyStateInviteLink");
            textView3.setText(getString(2131892565));
            TextView textView4 = binding.g;
            m.checkNotNullExpressionValue(textView4, "emptyStateSettingsSubtext");
            textView4.setText((CharSequence) null);
        }
        binding.d.setOnClickListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$1(invite, this, viewState));
        binding.h.setOnClickListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$2(invite, this, viewState));
        ImageButton imageButton = binding.e;
        m.checkNotNullExpressionValue(imageButton, "emptyStateLinkOptions");
        imageButton.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.e.setOnClickListener(new WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$3(invite, this, viewState));
    }

    private final void configureNormalUI(GuildInviteShareSheetViewModel$ViewState viewState) {
        if (!this.isFixedHeight) {
            this.isFixedHeight = true;
            FrameLayout frameLayout = getBinding().j;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$doOnLayout$1(this));
            } else {
                ViewGroup$LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams) layoutParams;
                Resources resources = getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                frameLayout$LayoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                frameLayout.setLayoutParams(frameLayout$LayoutParams);
                access$getBinding$p(this).m.requestLayout();
            }
        }
        String searchQuery = viewState.getSearchQuery();
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        if (!this.restoredSearchQueryFromViewModel && (!t.isBlank(searchQuery))) {
            this.restoredSearchQueryFromViewModel = true;
            binding.k.setText(searchQuery);
        }
        AppViewFlipper appViewFlipper = binding.n;
        m.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(1);
        NestedScrollView nestedScrollView = binding.f;
        m.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(false);
        if (viewState.getChannel() != null) {
            SearchInputView searchInputView = binding.k;
            Channel channel = viewState.getChannel();
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            searchInputView.setHint(b.k(this, 2131892345, new Object[]{ChannelUtils.e(channel, contextRequireContext, false, 2)}, null, 4));
        } else {
            SearchInputView searchInputView2 = binding.k;
            String string = getString(2131892344);
            m.checkNotNullExpressionValue(string, "getString(R.string.invite_your_friends)");
            searchInputView2.setHint(string);
        }
        GuildInvite invite = viewState.getInvite();
        if (invite != null) {
            CardView cardView = binding.l;
            m.checkNotNullExpressionValue(cardView, "shareButton");
            cardView.setContentDescription(b.k(this, 2131895644, new Object[]{invite}, null, 4));
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            String link = invite.toLink();
            Context contextRequireContext2 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence inviteSettingsText = GuildInviteUiHelperKt.getInviteSettingsText(contextRequireContext2, expirationTimeMs);
            TextView textView = binding.c;
            m.checkNotNullExpressionValue(textView, "copyLinkSubtitle");
            textView.setText(link + ' ' + inviteSettingsText);
            binding.l.setOnClickListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$1(invite, this, searchQuery, viewState));
            binding.f2422b.setOnClickListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$2(invite, this, searchQuery, viewState));
        }
        CardView cardView2 = binding.l;
        m.checkNotNullExpressionValue(cardView2, "shareButton");
        cardView2.setVisibility(invite != null ? 0 : 8);
        FrameLayout frameLayout2 = binding.i;
        m.checkNotNullExpressionValue(frameLayout2, "inviteSettingsButton");
        frameLayout2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.i.setOnClickListener(new WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3(invite, this, searchQuery, viewState));
        InviteSuggestionsAdapter inviteSuggestionsAdapter = this.adapter;
        if (inviteSuggestionsAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter.setOnClick(new WidgetGuildInviteShareSheet$configureNormalUI$3(this));
        InviteSuggestionsAdapter inviteSuggestionsAdapter2 = this.adapter;
        if (inviteSuggestionsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter2.setData(viewState.getInviteSuggestionItems());
    }

    private final WidgetGuildInviteShareSheetBinding getBinding() {
        return (WidgetGuildInviteShareSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildInviteShareSheetViewModel getViewModel() {
        return (GuildInviteShareSheetViewModel) this.viewModel.getValue();
    }

    private final void setUpSearchBar() {
        getBinding().k.a(this, new WidgetGuildInviteShareSheet$setUpSearchBar$1(this));
    }

    public final void configureUI(GuildInviteShareSheetViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (viewState.getHasResults()) {
            configureNormalUI(viewState);
        } else {
            configureEmptyStateUI(viewState);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_invite_share_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildInviteShareSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteShareSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString(ARG_ANALYTICS_SOURCE);
        if (string == null) {
            string = "";
        }
        this.analyticsSource = string;
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView, "binding.suggestionList");
        this.adapter = (InviteSuggestionsAdapter) mGRecyclerAdapter$Companion.configure(new InviteSuggestionsAdapter(recyclerView));
        setUpSearchBar();
    }
}
