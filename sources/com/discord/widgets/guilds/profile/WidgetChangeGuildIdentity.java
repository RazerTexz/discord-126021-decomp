package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.b.SingleValuePropPremiumUpsellDialog;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.a.y.SelectorBottomSheet;
import b.a.y.SelectorBottomSheet2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetChangeGuildIdentityBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChangeGuildIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String USER_GUILD_PROFILE_VIEWED_CACHE_KEY = "USER_GUILD_PROFILE_VIEWED_CACHE_KEY";
    private Function1<? super String, Unit> avatarSelectedResult;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicBoolean discardConfirmed;
    private Function1<? super String, Unit> imageSelectedResult;
    private final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, String source, Context context) {
            Intrinsics3.checkNotNullParameter(source, "source");
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId).putExtra("com.discord.intent.extra.EXTRA_SOURCE", source);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…nts.EXTRA_SOURCE, source)");
            AppScreen2.d(context, WidgetChangeGuildIdentity.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureAvatar$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            WidgetChangeGuildIdentity.this.getViewModel().updateAvatar(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetChangeGuildIdentityViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetChangeGuildIdentity.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetChangeGuildIdentityViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChangeGuildIdentityViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            boolean z2 = true;
            if (!(event instanceof WidgetChangeGuildIdentityViewModel.Event.MemberUpdateFailed)) {
                if (event instanceof WidgetChangeGuildIdentityViewModel.Event.MemberUpdateSucceeded) {
                    WidgetChangeGuildIdentity.this.showToast(R.string.per_guild_identity_saved);
                    WidgetChangeGuildIdentity.this.discardConfirmed.set(true);
                    FragmentActivity fragmentActivityE = WidgetChangeGuildIdentity.this.e();
                    if (fragmentActivityE != null) {
                        fragmentActivityE.onBackPressed();
                        return;
                    }
                    return;
                }
                return;
            }
            WidgetChangeGuildIdentityViewModel.Event.MemberUpdateFailed memberUpdateFailed = (WidgetChangeGuildIdentityViewModel.Event.MemberUpdateFailed) event;
            String errorMessage = memberUpdateFailed.getErrorMessage();
            if (errorMessage != null && errorMessage.length() != 0) {
                z2 = false;
            }
            if (z2) {
                WidgetChangeGuildIdentity.this.showToast(R.string.change_identity_modal_unknown_error);
            } else {
                WidgetChangeGuildIdentity.this.showToast(memberUpdateFailed.getErrorMessage());
            }
        }
    }

    public WidgetChangeGuildIdentity() {
        super(R.layout.widget_change_guild_identity);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChangeGuildIdentity3.INSTANCE, null, 2, null);
        this.imageSelectedResult = WidgetChangeGuildIdentity6.INSTANCE;
        this.avatarSelectedResult = WidgetChangeGuildIdentity2.INSTANCE;
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
        this.discardConfirmed = new AtomicBoolean(false);
        WidgetChangeGuildIdentity8 widgetChangeGuildIdentity8 = new WidgetChangeGuildIdentity8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChangeGuildIdentityViewModel.class), new WidgetChangeGuildIdentity$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChangeGuildIdentity8));
    }

    private final void configureAvatar(final WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        IconUtils.setIcon$default(simpleDraweeView, viewState.getDisplayedAvatarURL(), 0, (Function1) null, this.imagesChangeDetector, 12, (Object) null);
        this.avatarSelectedResult = new AnonymousClass1();
        final List listMutableListOf = Collections2.mutableListOf(new SelectorBottomSheet2(getString(R.string.change_guild_member_avatar), null, null, null, null, null, null, 116));
        if (viewState.getDisplayingGuildAvatar()) {
            listMutableListOf.add(new SelectorBottomSheet2(getString(R.string.change_identity_modal_reset_primary_avatar), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)), null, 84));
        }
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.configureAvatar.2

            /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureAvatar$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.a;
                }

                public final void invoke(int i) {
                    if (i != 0) {
                        if (i != 1) {
                            return;
                        }
                        WidgetChangeGuildIdentity.this.getViewModel().updateAvatar(null);
                    } else {
                        WidgetChangeGuildIdentity widgetChangeGuildIdentity = WidgetChangeGuildIdentity.this;
                        widgetChangeGuildIdentity.imageSelectedResult = widgetChangeGuildIdentity.avatarSelectedResult;
                        WidgetChangeGuildIdentity.this.openMediaChooser();
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (viewState.getShouldUpsell()) {
                    WidgetChangeGuildIdentity.this.navigateToUpsellModal();
                    return;
                }
                SelectorBottomSheet.Companion aVar = SelectorBottomSheet.INSTANCE;
                FragmentManager childFragmentManager = WidgetChangeGuildIdentity.this.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                aVar.a(childFragmentManager, "", listMutableListOf, false, new AnonymousClass1());
            }
        });
    }

    private final void configureNickname(final WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanChangeNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanChangeNickname() ? getString(R.string.nickname) : getString(R.string.change_identity_modal_change_nickname_disabled));
        textInputLayout.setPlaceholderText(viewState.getMeUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetChangeGuildIdentity4(this, viewState));
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().updateNickname("");
            }
        });
        TextInputLayout textInputLayout2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.setNicknameText");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        if (!Intrinsics3.areEqual(viewState.getCurrentNickname(), textOrEmpty)) {
            ViewExtensions.setText(textInputLayout, viewState.getCurrentNickname());
            if (textOrEmpty.length() == 0) {
                EditText editText = textInputLayout.getEditText();
                Selection.setSelection(editText != null ? editText.getText() : null, ViewExtensions.getTextOrEmpty(textInputLayout).length());
            }
        }
    }

    private final void configureUI(final WidgetChangeGuildIdentityViewModel.ViewState viewState) {
        if (viewState instanceof WidgetChangeGuildIdentityViewModel.ViewState.Loaded) {
            if (!getViewModel().getTrackedModalOpen()) {
                AnalyticsTracker.INSTANCE.openModal("Change Server Identity", new Traits.Source(Traits.Location.Page.GUILD_CHANNEL, getViewModel().getSourceSection(), null, null, null, 28, null));
                getViewModel().setTrackedModalOpen(true);
            }
            WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded = (WidgetChangeGuildIdentityViewModel.ViewState.Loaded) viewState;
            configureNickname(loaded);
            configureAvatar(loaded);
            configureUpsell(loaded);
            AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.configureUI.1
                @Override // rx.functions.Func0, java.util.concurrent.Callable
                public final Boolean call() {
                    return Boolean.valueOf(WidgetChangeGuildIdentity.this.handleBackPressed((WidgetChangeGuildIdentityViewModel.ViewState.Loaded) viewState));
                }
            }, 0, 2, null);
            DimmerView.setDimmed$default(getBinding().f2252b, loaded.getDimmed(), false, 2, null);
            FloatingActionButton floatingActionButton = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
            floatingActionButton.setVisibility(loaded.getShowSaveFab() ? 0 : 8);
        }
    }

    private final void configureUpsell(WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.upsellSection");
        linearLayout.setVisibility(viewState.getShouldUpsell() ? 0 : 8);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.configureUpsell.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChangeGuildIdentity.this.navigateToUpsellModal();
            }
        });
        if (getViewModel().getTrackedUpsell() || !viewState.getShouldUpsell()) {
            return;
        }
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.PerGuildIdentityInline, new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, "Change Per Server Identity Modal", "Nitro upsell button", null, null, 24, null), null, null, 12, null);
        getViewModel().setTrackedUpsell(true);
    }

    private final WidgetChangeGuildIdentityBinding getBinding() {
        return (WidgetChangeGuildIdentityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChangeGuildIdentityViewModel getViewModel() {
        return (WidgetChangeGuildIdentityViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        hideKeyboard(getBinding().g);
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(e()));
        Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewDialogConfirmationBindingB.a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingB.d.setText(R.string.discard_changes);
        viewDialogConfirmationBindingB.e.setText(R.string.discard_changes_description);
        viewDialogConfirmationBindingB.f2185b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.handleBackPressed.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        viewDialogConfirmationBindingB.c.setText(R.string.okay);
        viewDialogConfirmationBindingB.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.handleBackPressed.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChangeGuildIdentity.this.discardConfirmed.set(true);
                alertDialogCreate.dismiss();
                FragmentActivity fragmentActivityE = WidgetChangeGuildIdentity.this.e();
                if (fragmentActivityE != null) {
                    fragmentActivityE.onBackPressed();
                }
            }
        });
        alertDialogCreate.show();
        return true;
    }

    private final void navigateToUpsellModal() {
        SingleValuePropPremiumUpsellDialog.Companion bVar = SingleValuePropPremiumUpsellDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.PerGuildIdentityUpsellModal;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        String string = FormatUtils.c(resources, R.string.guild_member_avatar_upsell_title, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null).toString();
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        bVar.a(parentFragmentManager, premiumUpsellType, R.drawable.per_guild_identity_modal_image, string, FormatUtils.c(resources2, R.string.guild_member_avatar_upsell_body, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null).toString(), Traits.Location.Page.GUILD_CHANNEL, "Change Per Server Identity Modal", "Nitro upsell button");
    }

    private final void showToast(@StringRes int text) {
        AppToast.i(this, text, 0, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Object widgetChangeGuildIdentity7;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!StringsJVM.startsWith$default(mimeType, "image", false, 2, null)) {
            AppToast.g(getContext(), R.string.user_settings_image_upload_filetype_error, 0, null, 12);
            return;
        }
        if (!Intrinsics3.areEqual(mimeType, "image/gif")) {
            MGImages.requestImageCrop(requireContext(), this, uri, 1.0f, 1.0f, 1024);
            return;
        }
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        if (function1 != null) {
            widgetChangeGuildIdentity7 = function1;
            widgetChangeGuildIdentity7 = new WidgetChangeGuildIdentity7(function1);
        }
        widgetChangeGuildIdentity7 = function1;
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChangeGuildIdentity7);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        Object widgetChangeGuildIdentity7 = function1;
        if (function1 != null) {
            widgetChangeGuildIdentity7 = new WidgetChangeGuildIdentity7(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChangeGuildIdentity7);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(final View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        SharedPreferences.Editor editorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(USER_GUILD_PROFILE_VIEWED_CACHE_KEY, true);
        editorEdit.apply();
        setActionBarTitle(R.string.change_identity);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChangeGuildIdentityViewModel viewModel = WidgetChangeGuildIdentity.this.getViewModel();
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                viewModel.saveMemberChanges(context);
                DimmerView.setDimmed$default(WidgetChangeGuildIdentity.this.getBinding().f2252b, true, false, 2, null);
            }
        });
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.setNicknameText");
        showKeyboard(textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChangeGuildIdentity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChangeGuildIdentity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    private final void showToast(String text) {
        AppToast.j(this, text, 0, 4);
    }
}
