package com.discord.widgets.settings.profile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.a.y.c0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsUserProfileBinding;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.file.FileUtilsKt;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderView$Companion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
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
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEditUserOrGuildMemberProfile.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", 0)};
    public static final WidgetEditUserOrGuildMemberProfile$Companion Companion = new WidgetEditUserOrGuildMemberProfile$Companion(null);
    public static final int MAX_AVATAR_SIZE = 1024;
    public static final int MAX_BANNER_FILE_SIZE_MB = 30;
    public static final int MAX_BANNER_IMAGE_SIZE = 1080;
    private final BehaviorSubject<String> avatarRepresentativeColorHexSubject;
    private Function1<? super String, Unit> avatarSelectedResult;
    private Function1<? super String, Unit> bannerSelectedResult;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicBoolean discardConfirmed;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private Function1<? super String, Unit> imageSelectedResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetEditUserOrGuildMemberProfile() {
        super(R$layout.widget_settings_user_profile);
        this.avatarSelectedResult = WidgetEditUserOrGuildMemberProfile$avatarSelectedResult$1.INSTANCE;
        this.bannerSelectedResult = WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1.INSTANCE;
        this.imageSelectedResult = WidgetEditUserOrGuildMemberProfile$imageSelectedResult$1.INSTANCE;
        this.guildId = g.lazy(new WidgetEditUserOrGuildMemberProfile$guildId$2(this));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEditUserOrGuildMemberProfile$binding$2.INSTANCE, null, 2, null);
        WidgetEditUserOrGuildMemberProfile$viewModel$2 widgetEditUserOrGuildMemberProfile$viewModel$2 = new WidgetEditUserOrGuildMemberProfile$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsUserProfileViewModel.class), new WidgetEditUserOrGuildMemberProfile$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetEditUserOrGuildMemberProfile$viewModel$2));
        this.discardConfirmed = new AtomicBoolean(false);
        this.avatarRepresentativeColorHexSubject = BehaviorSubject.k0();
    }

    public static final /* synthetic */ void access$configureUI(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, SettingsUserProfileViewModel$ViewState settingsUserProfileViewModel$ViewState) {
        widgetEditUserOrGuildMemberProfile.configureUI(settingsUserProfileViewModel$ViewState);
    }

    public static final /* synthetic */ BehaviorSubject access$getAvatarRepresentativeColorHexSubject$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.avatarRepresentativeColorHexSubject;
    }

    public static final /* synthetic */ Function1 access$getAvatarSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.avatarSelectedResult;
    }

    public static final /* synthetic */ Function1 access$getBannerSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.bannerSelectedResult;
    }

    public static final /* synthetic */ WidgetSettingsUserProfileBinding access$getBinding$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getBinding();
    }

    public static final /* synthetic */ AtomicBoolean access$getDiscardConfirmed$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.discardConfirmed;
    }

    public static final /* synthetic */ Long access$getGuildId$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getGuildId();
    }

    public static final /* synthetic */ Function1 access$getImageSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.imageSelectedResult;
    }

    public static final /* synthetic */ SettingsUserProfileViewModel access$getViewModel$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getViewModel();
    }

    public static final /* synthetic */ boolean access$handleBackPressed(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded) {
        return widgetEditUserOrGuildMemberProfile.handleBackPressed(settingsUserProfileViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ void access$handleEvent(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, SettingsUserProfileViewModel$Event settingsUserProfileViewModel$Event) {
        widgetEditUserOrGuildMemberProfile.handleEvent(settingsUserProfileViewModel$Event);
    }

    public static final /* synthetic */ void access$setAvatarSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.avatarSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setBannerSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.bannerSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setCurrentBioFromEditor(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        widgetEditUserOrGuildMemberProfile.setCurrentBioFromEditor();
    }

    public static final /* synthetic */ void access$setImageSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.imageSelectedResult = function1;
    }

    private final void configureAvatarSelect(SettingsUserProfileViewModel$ViewState$Loaded viewState) {
        String string;
        this.avatarSelectedResult = new WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$1(this, viewState);
        c0[] c0VarArr = new c0[1];
        if (viewState.getMeMember() != null) {
            string = viewState.getHasAvatarForDisplay() ? getString(2131887490) : getString(2131896678);
        } else {
            string = viewState.getHasAvatarForDisplay() ? getString(2131896860) : getString(2131896980);
        }
        c0VarArr[0] = new c0(string, null, null, null, null, null, null, 116);
        List listMutableListOf = n.mutableListOf(c0VarArr);
        if (viewState.getHasAvatarForDisplay()) {
            listMutableListOf.add(new c0(viewState.getMeMember() != null ? getString(2131887501) : getString(2131896960), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), 2131100382)), null, 84));
        }
        getBinding().o.setOnAvatarEdit(new WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2(this, listMutableListOf));
    }

    private final void configureBannerSelect(SettingsUserProfileViewModel$ViewState$Loaded viewState) {
        this.bannerSelectedResult = new WidgetEditUserOrGuildMemberProfile$configureBannerSelect$1(this);
        getBinding().o.setOnBannerPress(new WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2(this, viewState));
    }

    private final void configureBio(SettingsUserProfileViewModel$ViewState$Loaded viewState) {
        Drawable drawable;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        boolean showBioEditor = viewState.getShowBioEditor();
        CardView cardView = getBinding().f2640b;
        m.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
        boolean z2 = cardView.getVisibility() == 0;
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.bioHelpText");
        textView.setVisibility(viewState.getMeMember() != null ? 0 : 8);
        TextView textView2 = getBinding().e;
        Drawable drawable2 = null;
        textView2.setText(viewState.getMeMember() != null ? b.j(textView2, 2131887494, new Object[0], null, 4) : b.j(textView2, 2131896776, new Object[0], null, 4));
        if (viewState.getMeMember() != null && (drawable = ContextCompat.getDrawable(textView2.getContext(), 2131231969)) != null) {
            TextView textView3 = getBinding().e;
            m.checkNotNullExpressionValue(textView3, "binding.bioHeader");
            DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(textView3, 2130968990));
            drawable2 = drawable;
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(textView2, (Drawable) null, (Drawable) null, drawable2, (Drawable) null, 11, (Object) null);
        CardView cardView2 = getBinding().g;
        m.checkNotNullExpressionValue(cardView2, "binding.bioPreviewCard");
        cardView2.setVisibility(showBioEditor ^ true ? 0 : 8);
        CardView cardView3 = getBinding().f2640b;
        m.checkNotNullExpressionValue(cardView3, "binding.bioEditorCard");
        cardView3.setVisibility(showBioEditor ? 0 : 8);
        if (!showBioEditor) {
            if (bioAst != null) {
                LinkifiedTextView linkifiedTextView = getBinding().h;
                m.checkNotNullExpressionValue(linkifiedTextView, "binding.bioPreviewText");
                Context context = linkifiedTextView.getContext();
                m.checkNotNullExpressionValue(context, "binding.bioPreviewText.context");
                getBinding().h.setDraweeSpanStringBuilder(AstRenderer.render(bioAst, new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1(getViewModel()), null, null, 14328, null)));
                return;
            }
            return;
        }
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.setText(textInputLayout, viewState.getCurrentBio());
        if (z2) {
            return;
        }
        getBinding().d.requestFocus();
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.moveCursorToEnd(textInputLayout2);
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.bioEditorTextInputFieldWrap");
        showKeyboard(textInputLayout3);
    }

    private final void configureFab(SettingsUserProfileViewModel$ViewState$Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().m;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
        floatingActionButton.setVisibility(viewState.getShowSaveFab() ? 0 : 8);
    }

    private final void configureNick(SettingsUserProfileViewModel$ViewState$Loaded viewState) {
        boolean z2 = viewState.getGuild() != null;
        LinearLayout linearLayout = getBinding().l;
        m.checkNotNullExpressionValue(linearLayout, "binding.nickContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanEditNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanEditNickname() ? getString(2131893215) : getString(2131887499));
        textInputLayout.setPlaceholderText(viewState.getUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$1(this, viewState));
        textInputLayout.setEndIconOnClickListener(new WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$2(this, viewState));
        TextInputLayout textInputLayout2 = getBinding().n;
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

    private final void configureUI(SettingsUserProfileViewModel$ViewState viewState) {
        if (viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded) {
            SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
            if (settingsUserProfileViewModel$ViewState$Loaded.getGuild() != null) {
                setActionBarSubtitle(settingsUserProfileViewModel$ViewState$Loaded.getGuild().getName());
            }
            configureNick(settingsUserProfileViewModel$ViewState$Loaded);
            getBinding().k.setVisibility(settingsUserProfileViewModel$ViewState$Loaded.getGuild() != null ? 0 : 8);
            if (settingsUserProfileViewModel$ViewState$Loaded.getGuild() != null) {
                TextView textView = getBinding().j;
                m.checkNotNullExpressionValue(textView, "binding.guildMemberProfileHelpTextOverall");
                textView.setText(b.k(this, 2131887497, new Object[]{settingsUserProfileViewModel$ViewState$Loaded.getGuild().getName()}, null, 4));
            }
            configureBio(settingsUserProfileViewModel$ViewState$Loaded);
            configureAvatarSelect(settingsUserProfileViewModel$ViewState$Loaded);
            configureBannerSelect(settingsUserProfileViewModel$ViewState$Loaded);
            configureFab(settingsUserProfileViewModel$ViewState$Loaded);
            AppFragment.setOnBackPressed$default(this, new WidgetEditUserOrGuildMemberProfile$configureUI$3(this, viewState), 0, 2, null);
        }
    }

    private final WidgetSettingsUserProfileBinding getBinding() {
        return (WidgetSettingsUserProfileBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getGuildId() {
        return (Long) this.guildId.getValue();
    }

    private final SettingsUserProfileViewModel getViewModel() {
        return (SettingsUserProfileViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(SettingsUserProfileViewModel$ViewState$Loaded viewState) {
        if (viewState.isEditingBio()) {
            setCurrentBioFromEditor();
            return true;
        }
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(getActivity()));
        m.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
        AlertDialog alertDialogCreate = new AlertDialog$Builder(requireContext()).setView(viewDialogConfirmationBindingB.a).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingB.d.setText(2131888486);
        viewDialogConfirmationBindingB.e.setText(2131888489);
        viewDialogConfirmationBindingB.f2185b.setOnClickListener(new WidgetEditUserOrGuildMemberProfile$handleBackPressed$1(alertDialogCreate));
        viewDialogConfirmationBindingB.c.setText(2131893499);
        viewDialogConfirmationBindingB.c.setOnClickListener(new WidgetEditUserOrGuildMemberProfile$handleBackPressed$2(this, alertDialogCreate));
        alertDialogCreate.show();
        return true;
    }

    private final void handleEvent(SettingsUserProfileViewModel$Event event) {
        if (m.areEqual(event, SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().i, false, false, 2, null);
        }
    }

    private final void setCurrentBioFromEditor() {
        TextInputEditText textInputEditText = getBinding().c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.bioEditorTextInputField");
        getViewModel().updateBio(String.valueOf(textInputEditText.getText()));
        getViewModel().updateIsEditingBio(false);
        getBinding().d.clearFocus();
        hideKeyboard(getBinding().d);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!t.startsWith$default(mimeType, "image", false, 2, null)) {
            b.a.d.m.g(getContext(), 2131896908, 0, null, 12);
            return;
        }
        if (!m.areEqual(mimeType, "image/gif")) {
            MGImages.requestImageCrop(requireContext(), this, uri, m.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 5.0f : 1.0f, m.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 2.0f : 1.0f, m.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? MAX_BANNER_IMAGE_SIZE : 1024);
            return;
        }
        Long fileSizeBytes = FileUtilsKt.getFileSizeBytes(requireContext(), uri);
        if (fileSizeBytes != null && fileSizeBytes.longValue() >= 31457280) {
            b.a.d.m.h(requireContext(), b.k(this, 2131896907, new Object[]{30}, null, 4), 0, null, 12);
            return;
        }
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        Object widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        Object widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getGuildId() != null) {
            setActionBarTitle(2131887492);
        } else {
            setActionBarTitle(2131896984);
            setActionBarSubtitle(2131896797);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().m.setOnClickListener(new WidgetEditUserOrGuildMemberProfile$onViewBound$1(this, view));
        ((TouchInterceptingCoordinatorLayout) view).setOnInterceptTouchEvent(new WidgetEditUserOrGuildMemberProfile$onViewBound$2(this));
        getBinding().c.setRawInputType(1);
        getBinding().g.setOnClickListener(new WidgetEditUserOrGuildMemberProfile$onViewBound$3(this));
        getBinding().o.setOnAvatarRepresentativeColorUpdated(new WidgetEditUserOrGuildMemberProfile$onViewBound$4(this));
        getBinding().o.setOnBadgeClick(new WidgetEditUserOrGuildMemberProfile$onViewBound$5(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsUserProfileViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetEditUserOrGuildMemberProfile.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$1(this), 62, (Object) null);
        UserProfileHeaderView$Companion userProfileHeaderView$Companion = UserProfileHeaderView.Companion;
        UserProfileHeaderView userProfileHeaderView = getBinding().o;
        m.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        userProfileHeaderView$Companion.bind(userProfileHeaderView, this, getViewModel().observeHeaderViewState());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetEditUserOrGuildMemberProfile.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
