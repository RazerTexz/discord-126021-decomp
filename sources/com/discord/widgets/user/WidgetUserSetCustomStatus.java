package com.discord.widgets.user;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.m;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserSetCustomStatusBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.RadioManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType$Global;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.n;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserSetCustomStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", 0)};
    public static final WidgetUserSetCustomStatus$Companion Companion = new WidgetUserSetCustomStatus$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String currentEmojiUri;
    private RadioManager expirationRadioManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetUserSetCustomStatus() {
        super(R$layout.widget_user_set_custom_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserSetCustomStatus$binding$2.INSTANCE, null, 2, null);
        WidgetUserSetCustomStatus$viewModel$2 widgetUserSetCustomStatus$viewModel$2 = WidgetUserSetCustomStatus$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetUserSetCustomStatusViewModel.class), new WidgetUserSetCustomStatus$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetUserSetCustomStatus$viewModel$2));
    }

    public static final /* synthetic */ WidgetUserSetCustomStatusViewModel access$getViewModel$p(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        return widgetUserSetCustomStatus.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetUserSetCustomStatus widgetUserSetCustomStatus, WidgetUserSetCustomStatusViewModel$Event widgetUserSetCustomStatusViewModel$Event) {
        widgetUserSetCustomStatus.handleEvent(widgetUserSetCustomStatusViewModel$Event);
    }

    public static final /* synthetic */ void access$openEmojiPicker(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        widgetUserSetCustomStatus.openEmojiPicker();
    }

    public static final /* synthetic */ void access$updateView(WidgetUserSetCustomStatus widgetUserSetCustomStatus, WidgetUserSetCustomStatusViewModel$ViewState widgetUserSetCustomStatusViewModel$ViewState) {
        widgetUserSetCustomStatus.updateView(widgetUserSetCustomStatusViewModel$ViewState);
    }

    private final WidgetUserSetCustomStatusBinding getBinding() {
        return (WidgetUserSetCustomStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserSetCustomStatusViewModel getViewModel() {
        return (WidgetUserSetCustomStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetUserSetCustomStatusViewModel$Event event) {
        if (!(event instanceof WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess)) {
            if (event instanceof WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure) {
                m.i(this, ((WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure) event).getFailureMessageStringRes(), 0, 4);
            }
        } else {
            m.i(this, ((WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void openEmojiPicker() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, new WidgetUserSetCustomStatus$openEmojiPicker$1(this), EmojiPickerContextType$Global.INSTANCE, null, 8, null);
    }

    private final void setExpirationOnCheck(MaterialRadioButton materialRadioButton, WidgetUserSetCustomStatusViewModel$FormState$Expiration widgetUserSetCustomStatusViewModel$FormState$Expiration) {
        materialRadioButton.setOnClickListener(new WidgetUserSetCustomStatus$setExpirationOnCheck$1(this, widgetUserSetCustomStatusViewModel$FormState$Expiration));
    }

    private final void updateView(WidgetUserSetCustomStatusViewModel$ViewState viewState) {
        MaterialRadioButton materialRadioButton;
        if (viewState instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded) {
            WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded = (WidgetUserSetCustomStatusViewModel$ViewState$Loaded) viewState;
            WidgetUserSetCustomStatusViewModel$FormState formState = widgetUserSetCustomStatusViewModel$ViewState$Loaded.getFormState();
            if (formState.getEmoji() != null) {
                String imageUri = formState.getEmoji().getImageUri(true, IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(2131165341)), getContext());
                if (!d0.z.d.m.areEqual(imageUri, this.currentEmojiUri)) {
                    SimpleDraweeView simpleDraweeView = getBinding().f2692b;
                    d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.setCustomStatusEmoji");
                    MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
                    this.currentEmojiUri = imageUri;
                }
            } else {
                getBinding().f2692b.setActualImageResource(2131232132);
                this.currentEmojiUri = null;
            }
            TextInputLayout textInputLayout = getBinding().j;
            d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            if (!d0.z.d.m.areEqual(formState.getText(), textOrEmpty)) {
                TextInputLayout textInputLayout2 = getBinding().j;
                d0.z.d.m.checkNotNullExpressionValue(textInputLayout2, "binding.setCustomStatusText");
                ViewExtensions.setText(textInputLayout2, formState.getText());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout3 = getBinding().j;
                    d0.z.d.m.checkNotNullExpressionValue(textInputLayout3, "binding.setCustomStatusText");
                    EditText editText = textInputLayout3.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout4 = getBinding().j;
                    d0.z.d.m.checkNotNullExpressionValue(textInputLayout4, "binding.setCustomStatusText");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout4).length());
                }
            }
            TextInputLayout textInputLayout5 = getBinding().j;
            d0.z.d.m.checkNotNullExpressionValue(textInputLayout5, "binding.setCustomStatusText");
            textInputLayout5.setEndIconVisible(widgetUserSetCustomStatusViewModel$ViewState$Loaded.getShowStatusClear());
            int iOrdinal = formState.getExpiration().ordinal();
            if (iOrdinal == 0) {
                materialRadioButton = getBinding().g;
            } else if (iOrdinal == 1) {
                materialRadioButton = getBinding().e;
            } else if (iOrdinal == 2) {
                materialRadioButton = getBinding().d;
            } else if (iOrdinal == 3) {
                materialRadioButton = getBinding().f;
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                materialRadioButton = getBinding().h;
            }
            d0.z.d.m.checkNotNullExpressionValue(materialRadioButton, "when (formState.expirati…sExpirationTomorrow\n    }");
            RadioManager radioManager = this.expirationRadioManager;
            if (radioManager == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("expirationRadioManager");
            }
            radioManager.a(materialRadioButton);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Window window;
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131888300);
        this.expirationRadioManager = new RadioManager(n.listOf((Object[]) new MaterialRadioButton[]{getBinding().g, getBinding().e, getBinding().d, getBinding().f, getBinding().h}));
        getBinding().c.setOnClickListener(new WidgetUserSetCustomStatus$onViewBound$1(this));
        getBinding().j.setEndIconOnClickListener(new WidgetUserSetCustomStatus$onViewBound$2(this));
        TextInputLayout textInputLayout = getBinding().j;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetUserSetCustomStatus$onViewBound$3(this));
        MaterialRadioButton materialRadioButton = getBinding().g;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton, "binding.setCustomStatusExpirationNever");
        setExpirationOnCheck(materialRadioButton, WidgetUserSetCustomStatusViewModel$FormState$Expiration.NEVER);
        Resources resources = getResources();
        d0.z.d.m.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.custom_status_clear_in_minutes_minutes, 30, 30);
        MaterialRadioButton materialRadioButton2 = getBinding().e;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton2, "binding.setCustomStatusExpiration30Minutes");
        materialRadioButton2.setText(b.k(this, 2131888304, new Object[]{quantityString}, null, 4));
        MaterialRadioButton materialRadioButton3 = getBinding().e;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton3, "binding.setCustomStatusExpiration30Minutes");
        setExpirationOnCheck(materialRadioButton3, WidgetUserSetCustomStatusViewModel$FormState$Expiration.IN_30_MINUTES);
        Resources resources2 = getResources();
        d0.z.d.m.checkNotNullExpressionValue(resources2, "resources");
        CharSequence quantityString2 = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R$plurals.custom_status_clear_in_hours_hours, 1, 1);
        MaterialRadioButton materialRadioButton4 = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton4, "binding.setCustomStatusExpiration1Hour");
        materialRadioButton4.setText(b.k(this, 2131888303, new Object[]{quantityString2}, null, 4));
        MaterialRadioButton materialRadioButton5 = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton5, "binding.setCustomStatusExpiration1Hour");
        setExpirationOnCheck(materialRadioButton5, WidgetUserSetCustomStatusViewModel$FormState$Expiration.IN_1_HOUR);
        Resources resources3 = getResources();
        d0.z.d.m.checkNotNullExpressionValue(resources3, "resources");
        CharSequence quantityString3 = StringResourceUtilsKt.getQuantityString(resources3, requireContext(), R$plurals.custom_status_clear_in_hours_hours, 4, 4);
        MaterialRadioButton materialRadioButton6 = getBinding().f;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton6, "binding.setCustomStatusExpiration4Hours");
        materialRadioButton6.setText(b.k(this, 2131888303, new Object[]{quantityString3}, null, 4));
        MaterialRadioButton materialRadioButton7 = getBinding().f;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton7, "binding.setCustomStatusExpiration4Hours");
        setExpirationOnCheck(materialRadioButton7, WidgetUserSetCustomStatusViewModel$FormState$Expiration.IN_4_HOURS);
        MaterialRadioButton materialRadioButton8 = getBinding().h;
        d0.z.d.m.checkNotNullExpressionValue(materialRadioButton8, "binding.setCustomStatusExpirationTomorrow");
        setExpirationOnCheck(materialRadioButton8, WidgetUserSetCustomStatusViewModel$FormState$Expiration.TOMORROW);
        getBinding().i.setOnClickListener(new WidgetUserSetCustomStatus$onViewBound$4(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserSetCustomStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSetCustomStatus$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetUserSetCustomStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSetCustomStatus$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
