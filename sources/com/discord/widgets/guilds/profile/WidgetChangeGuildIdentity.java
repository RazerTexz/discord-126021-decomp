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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.C0812d;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1322b0;
import p007b.p008a.p062y.C1324c0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChangeGuildIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0)};

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
            C12238m.checkNotNullParameter(source, "source");
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId).putExtra("com.discord.intent.extra.EXTRA_SOURCE", source);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…nts.EXTRA_SOURCE, source)");
            C0870j.m156d(context, WidgetChangeGuildIdentity.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureAvatar$1 */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
    public static final class C87621 extends AbstractC12240o implements Function1<String, Unit> {
        public C87621() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "dataUrl");
            WidgetChangeGuildIdentity.this.getViewModel().updateAvatar(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
    public static final class C87711 extends AbstractC12240o implements Function1<WidgetChangeGuildIdentityViewModel.ViewState, Unit> {
        public C87711() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetChangeGuildIdentity.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
    public static final class C87722 extends AbstractC12240o implements Function1<WidgetChangeGuildIdentityViewModel.Event, Unit> {
        public C87722() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChangeGuildIdentityViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            boolean z2 = true;
            if (!(event instanceof WidgetChangeGuildIdentityViewModel.Event.MemberUpdateFailed)) {
                if (event instanceof WidgetChangeGuildIdentityViewModel.Event.MemberUpdateSucceeded) {
                    WidgetChangeGuildIdentity.this.showToast(C5419R.string.per_guild_identity_saved);
                    WidgetChangeGuildIdentity.this.discardConfirmed.set(true);
                    FragmentActivity fragmentActivityM95e = WidgetChangeGuildIdentity.this.m95e();
                    if (fragmentActivityM95e != null) {
                        fragmentActivityM95e.onBackPressed();
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
                WidgetChangeGuildIdentity.this.showToast(C5419R.string.change_identity_modal_unknown_error);
            } else {
                WidgetChangeGuildIdentity.this.showToast(memberUpdateFailed.getErrorMessage());
            }
        }
    }

    public WidgetChangeGuildIdentity() {
        super(C5419R.layout.widget_change_guild_identity);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChangeGuildIdentity$binding$2.INSTANCE, null, 2, null);
        this.imageSelectedResult = WidgetChangeGuildIdentity$imageSelectedResult$1.INSTANCE;
        this.avatarSelectedResult = WidgetChangeGuildIdentity$avatarSelectedResult$1.INSTANCE;
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
        this.discardConfirmed = new AtomicBoolean(false);
        WidgetChangeGuildIdentity$viewModel$2 widgetChangeGuildIdentity$viewModel$2 = new WidgetChangeGuildIdentity$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetChangeGuildIdentityViewModel.class), new WidgetChangeGuildIdentity$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetChangeGuildIdentity$viewModel$2));
    }

    private final void configureAvatar(final WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().f15806d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        IconUtils.setIcon$default(simpleDraweeView, viewState.getDisplayedAvatarURL(), 0, (Function1) null, this.imagesChangeDetector, 12, (Object) null);
        this.avatarSelectedResult = new C87621();
        final List listMutableListOf = C12147n.mutableListOf(new C1324c0(getString(C5419R.string.change_guild_member_avatar), null, null, null, null, null, null, 116));
        if (viewState.getDisplayingGuildAvatar()) {
            listMutableListOf.add(new C1324c0(getString(C5419R.string.change_identity_modal_reset_primary_avatar), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_red_500)), null, 84));
        }
        getBinding().f15807e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.configureAvatar.2

            /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureAvatar$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Integer, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.f27425a;
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
                C1322b0.Companion aVar = C1322b0.INSTANCE;
                FragmentManager childFragmentManager = WidgetChangeGuildIdentity.this.getChildFragmentManager();
                C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                aVar.m379a(childFragmentManager, "", listMutableListOf, false, new AnonymousClass1());
            }
        });
    }

    private final void configureNickname(final WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        TextInputLayout textInputLayout = getBinding().f15809g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanChangeNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanChangeNickname() ? getString(C5419R.string.nickname) : getString(C5419R.string.change_identity_modal_change_nickname_disabled));
        textInputLayout.setPlaceholderText(viewState.getMeUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C8764x92024c2b(this, viewState));
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().updateNickname("");
            }
        });
        TextInputLayout textInputLayout2 = getBinding().f15809g;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.setNicknameText");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        if (!C12238m.areEqual(viewState.getCurrentNickname(), textOrEmpty)) {
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
                @Override // p658rx.functions.Func0, java.util.concurrent.Callable
                public final Boolean call() {
                    return Boolean.valueOf(WidgetChangeGuildIdentity.this.handleBackPressed((WidgetChangeGuildIdentityViewModel.ViewState.Loaded) viewState));
                }
            }, 0, 2, null);
            DimmerView.setDimmed$default(getBinding().f15804b, loaded.getDimmed(), false, 2, null);
            FloatingActionButton floatingActionButton = getBinding().f15808f;
            C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
            floatingActionButton.setVisibility(loaded.getShowSaveFab() ? 0 : 8);
        }
    }

    private final void configureUpsell(WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        LinearLayout linearLayout = getBinding().f15810h;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.upsellSection");
        linearLayout.setVisibility(viewState.getShouldUpsell() ? 0 : 8);
        getBinding().f15805c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.configureUpsell.1
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
        hideKeyboard(getBinding().f15809g);
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingM8394b = ViewDialogConfirmationBinding.m8394b(LayoutInflater.from(m95e()));
        C12238m.checkNotNullExpressionValue(viewDialogConfirmationBindingM8394b, "ViewDialogConfirmationBi…tInflater.from(activity))");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewDialogConfirmationBindingM8394b.f15420a).create();
        C12238m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingM8394b.f15423d.setText(C5419R.string.discard_changes);
        viewDialogConfirmationBindingM8394b.f15424e.setText(C5419R.string.discard_changes_description);
        viewDialogConfirmationBindingM8394b.f15421b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.handleBackPressed.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        viewDialogConfirmationBindingM8394b.f15422c.setText(C5419R.string.okay);
        viewDialogConfirmationBindingM8394b.f15422c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.handleBackPressed.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChangeGuildIdentity.this.discardConfirmed.set(true);
                alertDialogCreate.dismiss();
                FragmentActivity fragmentActivityM95e = WidgetChangeGuildIdentity.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.onBackPressed();
                }
            }
        });
        alertDialogCreate.show();
        return true;
    }

    private final void navigateToUpsellModal() {
        C0812d.Companion bVar = C0812d.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.PerGuildIdentityUpsellModal;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        String string = C1107b.m211c(resources, C5419R.string.guild_member_avatar_upsell_title, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null).toString();
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        bVar.m117a(parentFragmentManager, premiumUpsellType, C5419R.drawable.per_guild_identity_modal_image, string, C1107b.m211c(resources2, C5419R.string.guild_member_avatar_upsell_body, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null).toString(), Traits.Location.Page.GUILD_CHANNEL, "Change Per Server Identity Modal", "Nitro upsell button");
    }

    private final void showToast(@StringRes int text) {
        C0876m.m171i(this, text, 0, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Object widgetChangeGuildIdentity$sam$rx_functions_Action1$0;
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!C12103t.startsWith$default(mimeType, "image", false, 2, null)) {
            C0876m.m169g(getContext(), C5419R.string.user_settings_image_upload_filetype_error, 0, null, 12);
            return;
        }
        if (!C12238m.areEqual(mimeType, "image/gif")) {
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
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
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
    public void onViewBound(final View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        SharedPreferences.Editor editorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(USER_GUILD_PROFILE_VIEWED_CACHE_KEY, true);
        editorEdit.apply();
        setActionBarTitle(C5419R.string.change_identity);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f15808f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChangeGuildIdentityViewModel viewModel = WidgetChangeGuildIdentity.this.getViewModel();
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                viewModel.saveMemberChanges(context);
                DimmerView.setDimmed$default(WidgetChangeGuildIdentity.this.getBinding().f15804b, true, false, 2, null);
            }
        });
        TextInputLayout textInputLayout = getBinding().f15809g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.setNicknameText");
        showKeyboard(textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChangeGuildIdentity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87711());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChangeGuildIdentity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87722());
    }

    private final void showToast(String text) {
        C0876m.m172j(this, text, 0, 4);
    }
}
