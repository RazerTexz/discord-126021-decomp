package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.b.d;
import b.a.a.b.d$b;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.a.y.c0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetChangeGuildIdentityBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsTracker$PremiumUpsellType;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Source;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChangeGuildIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0)};
    public static final WidgetChangeGuildIdentity$Companion Companion = new WidgetChangeGuildIdentity$Companion(null);
    public static final String USER_GUILD_PROFILE_VIEWED_CACHE_KEY = "USER_GUILD_PROFILE_VIEWED_CACHE_KEY";
    private Function1<? super String, Unit> avatarSelectedResult;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicBoolean discardConfirmed;
    private Function1<? super String, Unit> imageSelectedResult;
    private final MGImages$DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChangeGuildIdentity() {
        super(R$layout.widget_change_guild_identity);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChangeGuildIdentity$binding$2.INSTANCE, null, 2, null);
        this.imageSelectedResult = WidgetChangeGuildIdentity$imageSelectedResult$1.INSTANCE;
        this.avatarSelectedResult = WidgetChangeGuildIdentity$avatarSelectedResult$1.INSTANCE;
        this.imagesChangeDetector = new MGImages$DistinctChangeDetector();
        this.discardConfirmed = new AtomicBoolean(false);
        WidgetChangeGuildIdentity$viewModel$2 widgetChangeGuildIdentity$viewModel$2 = new WidgetChangeGuildIdentity$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChangeGuildIdentityViewModel.class), new WidgetChangeGuildIdentity$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChangeGuildIdentity$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel$ViewState widgetChangeGuildIdentityViewModel$ViewState) {
        widgetChangeGuildIdentity.configureUI(widgetChangeGuildIdentityViewModel$ViewState);
    }

    public static final /* synthetic */ Function1 access$getAvatarSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.avatarSelectedResult;
    }

    public static final /* synthetic */ WidgetChangeGuildIdentityBinding access$getBinding$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.getBinding();
    }

    public static final /* synthetic */ AtomicBoolean access$getDiscardConfirmed$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.discardConfirmed;
    }

    public static final /* synthetic */ Function1 access$getImageSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.imageSelectedResult;
    }

    public static final /* synthetic */ WidgetChangeGuildIdentityViewModel access$getViewModel$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.getViewModel();
    }

    public static final /* synthetic */ boolean access$handleBackPressed(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded) {
        return widgetChangeGuildIdentity.handleBackPressed(widgetChangeGuildIdentityViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ void access$navigateToUpsellModal(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        widgetChangeGuildIdentity.navigateToUpsellModal();
    }

    public static final /* synthetic */ void access$setAvatarSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity, Function1 function1) {
        widgetChangeGuildIdentity.avatarSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setImageSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity, Function1 function1) {
        widgetChangeGuildIdentity.imageSelectedResult = function1;
    }

    public static final /* synthetic */ void access$showToast(WidgetChangeGuildIdentity widgetChangeGuildIdentity, int i) {
        widgetChangeGuildIdentity.showToast(i);
    }

    private final void configureAvatar(WidgetChangeGuildIdentityViewModel$ViewState$Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        IconUtils.setIcon$default(simpleDraweeView, viewState.getDisplayedAvatarURL(), 0, (Function1) null, this.imagesChangeDetector, 12, (Object) null);
        this.avatarSelectedResult = new WidgetChangeGuildIdentity$configureAvatar$1(this);
        List listMutableListOf = n.mutableListOf(new c0(getString(2131887490), null, null, null, null, null, null, 116));
        if (viewState.getDisplayingGuildAvatar()) {
            listMutableListOf.add(new c0(getString(2131887501), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), 2131100382)), null, 84));
        }
        getBinding().e.setOnClickListener(new WidgetChangeGuildIdentity$configureAvatar$2(this, viewState, listMutableListOf));
    }

    private final void configureNickname(WidgetChangeGuildIdentityViewModel$ViewState$Loaded viewState) {
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanChangeNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanChangeNickname() ? getString(2131893215) : getString(2131887499));
        textInputLayout.setPlaceholderText(viewState.getMeUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$1(this, viewState));
        textInputLayout.setEndIconOnClickListener(new WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$2(this, viewState));
        TextInputLayout textInputLayout2 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.setNicknameText");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        if (!m.areEqual(viewState.getCurrentNickname(), textOrEmpty)) {
            ViewExtensions.setText(textInputLayout, viewState.getCurrentNickname());
            if (textOrEmpty.length() == 0) {
                EditText editText = textInputLayout.getEditText();
                Selection.setSelection(editText != null ? editText.getText() : null, ViewExtensions.getTextOrEmpty(textInputLayout).length());
            }
        }
    }

    private final void configureUI(WidgetChangeGuildIdentityViewModel$ViewState viewState) {
        if (viewState instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded) {
            if (!getViewModel().getTrackedModalOpen()) {
                AnalyticsTracker.INSTANCE.openModal("Change Server Identity", new Traits$Source(Traits$Location$Page.GUILD_CHANNEL, getViewModel().getSourceSection(), null, null, null, 28, null));
                getViewModel().setTrackedModalOpen(true);
            }
            WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) viewState;
            configureNickname(widgetChangeGuildIdentityViewModel$ViewState$Loaded);
            configureAvatar(widgetChangeGuildIdentityViewModel$ViewState$Loaded);
            configureUpsell(widgetChangeGuildIdentityViewModel$ViewState$Loaded);
            AppFragment.setOnBackPressed$default(this, new WidgetChangeGuildIdentity$configureUI$1(this, viewState), 0, 2, null);
            DimmerView.setDimmed$default(getBinding().f2252b, widgetChangeGuildIdentityViewModel$ViewState$Loaded.getDimmed(), false, 2, null);
            FloatingActionButton floatingActionButton = getBinding().f;
            m.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
            floatingActionButton.setVisibility(widgetChangeGuildIdentityViewModel$ViewState$Loaded.getShowSaveFab() ? 0 : 8);
        }
    }

    private final void configureUpsell(WidgetChangeGuildIdentityViewModel$ViewState$Loaded viewState) {
        LinearLayout linearLayout = getBinding().h;
        m.checkNotNullExpressionValue(linearLayout, "binding.upsellSection");
        linearLayout.setVisibility(viewState.getShouldUpsell() ? 0 : 8);
        getBinding().c.setOnClickListener(new WidgetChangeGuildIdentity$configureUpsell$1(this));
        if (getViewModel().getTrackedUpsell() || !viewState.getShouldUpsell()) {
            return;
        }
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker$PremiumUpsellType.PerGuildIdentityInline, new Traits$Location(Traits$Location$Page.GUILD_CHANNEL, "Change Per Server Identity Modal", "Nitro upsell button", null, null, 24, null), null, null, 12, null);
        getViewModel().setTrackedUpsell(true);
    }

    private final WidgetChangeGuildIdentityBinding getBinding() {
        return (WidgetChangeGuildIdentityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChangeGuildIdentityViewModel getViewModel() {
        return (WidgetChangeGuildIdentityViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(WidgetChangeGuildIdentityViewModel$ViewState$Loaded viewState) {
        hideKeyboard(getBinding().g);
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(getActivity()));
        m.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
        AlertDialog alertDialogCreate = new AlertDialog$Builder(requireContext()).setView(viewDialogConfirmationBindingB.a).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingB.d.setText(2131888486);
        viewDialogConfirmationBindingB.e.setText(2131888489);
        viewDialogConfirmationBindingB.f2185b.setOnClickListener(new WidgetChangeGuildIdentity$handleBackPressed$1(alertDialogCreate));
        viewDialogConfirmationBindingB.c.setText(2131893499);
        viewDialogConfirmationBindingB.c.setOnClickListener(new WidgetChangeGuildIdentity$handleBackPressed$2(this, alertDialogCreate));
        alertDialogCreate.show();
        return true;
    }

    private final void navigateToUpsellModal() {
        d$b d_b = d.k;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker$PremiumUpsellType analyticsTracker$PremiumUpsellType = AnalyticsTracker$PremiumUpsellType.PerGuildIdentityUpsellModal;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        String string = b.i(resources, 2131890311, new Object[0], null, 4).toString();
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        d_b.a(parentFragmentManager, analyticsTracker$PremiumUpsellType, 2131232503, string, b.i(resources2, 2131890310, new Object[0], null, 4).toString(), Traits$Location$Page.GUILD_CHANNEL, "Change Per Server Identity Modal", "Nitro upsell button");
    }

    private final void showToast(@StringRes int text) {
        b.a.d.m.i(this, text, 0, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Object widgetChangeGuildIdentity$sam$rx_functions_Action1$0;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!t.startsWith$default(mimeType, "image", false, 2, null)) {
            b.a.d.m.g(getContext(), 2131896908, 0, null, 12);
            return;
        }
        if (!m.areEqual(mimeType, "image/gif")) {
            MGImages.requestImageCrop(requireContext(), this, uri, 1.0f, 1.0f, 1024);
            return;
        }
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        if (function1 != null) {
            widgetChangeGuildIdentity$sam$rx_functions_Action1$0 = function1;
            widgetChangeGuildIdentity$sam$rx_functions_Action1$0 = new WidgetChangeGuildIdentity$sam$rx_functions_Action1$0(function1);
        }
        widgetChangeGuildIdentity$sam$rx_functions_Action1$0 = function1;
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChangeGuildIdentity$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        Object widgetChangeGuildIdentity$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetChangeGuildIdentity$sam$rx_functions_Action1$0 = new WidgetChangeGuildIdentity$sam$rx_functions_Action1$0(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChangeGuildIdentity$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        SharedPreferences$Editor sharedPreferences$EditorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean(USER_GUILD_PROFILE_VIEWED_CACHE_KEY, true);
        sharedPreferences$EditorEdit.apply();
        setActionBarTitle(2131887492);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f.setOnClickListener(new WidgetChangeGuildIdentity$onViewBound$2(this, view));
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.setNicknameText");
        showKeyboard(textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChangeGuildIdentity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChangeGuildIdentity$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChangeGuildIdentity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChangeGuildIdentity$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }

    public static final /* synthetic */ void access$showToast(WidgetChangeGuildIdentity widgetChangeGuildIdentity, String str) {
        widgetChangeGuildIdentity.showToast(str);
    }

    private final void showToast(String text) {
        b.a.d.m.j(this, text, 0, 4);
    }
}
