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
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserSetCustomStatusBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.RadioManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserSetCustomStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String currentEmojiUri;
    private RadioManager expirationRadioManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetUserSetCustomStatus.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetUserSetCustomStatusViewModel.FormState.Expiration.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.NEVER.ordinal()] = 1;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_30_MINUTES.ordinal()] = 2;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_1_HOUR.ordinal()] = 3;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_4_HOURS.ordinal()] = 4;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.TOMORROW.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetUserSetCustomStatus.this.getViewModel().setStatusText(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetUserSetCustomStatusViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
            super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetUserSetCustomStatus) this.receiver).updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetUserSetCustomStatusViewModel.Event, Unit> {
        public AnonymousClass2(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
            super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSetCustomStatusViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetUserSetCustomStatus) this.receiver).handleEvent(event);
        }
    }

    public WidgetUserSetCustomStatus() {
        super(R.layout.widget_user_set_custom_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserSetCustomStatus2.INSTANCE, null, 2, null);
        WidgetUserSetCustomStatus3 widgetUserSetCustomStatus3 = WidgetUserSetCustomStatus3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserSetCustomStatusViewModel.class), new WidgetUserSetCustomStatus$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserSetCustomStatus3));
    }

    private final WidgetUserSetCustomStatusBinding getBinding() {
        return (WidgetUserSetCustomStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserSetCustomStatusViewModel getViewModel() {
        return (WidgetUserSetCustomStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetUserSetCustomStatusViewModel.Event event) {
        if (!(event instanceof WidgetUserSetCustomStatusViewModel.Event.SetStatusSuccess)) {
            if (event instanceof WidgetUserSetCustomStatusViewModel.Event.SetStatusFailure) {
                AppToast.i(this, ((WidgetUserSetCustomStatusViewModel.Event.SetStatusFailure) event).getFailureMessageStringRes(), 0, 4);
            }
        } else {
            AppToast.i(this, ((WidgetUserSetCustomStatusViewModel.Event.SetStatusSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.onBackPressed();
            }
        }
    }

    private final void openEmojiPicker() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, new EmojiPickerListener() { // from class: com.discord.widgets.user.WidgetUserSetCustomStatus.openEmojiPicker.1
            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                WidgetUserSetCustomStatus.this.getViewModel().setStatusEmoji(emoji);
            }
        }, EmojiPickerContextType.Global.INSTANCE, null, 8, null);
    }

    private final void setExpirationOnCheck(MaterialRadioButton materialRadioButton, final WidgetUserSetCustomStatusViewModel.FormState.Expiration expiration) {
        materialRadioButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserSetCustomStatus.setExpirationOnCheck.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetUserSetCustomStatus.this.getViewModel().setExpiration(expiration);
            }
        });
    }

    private final void updateView(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
        MaterialRadioButton materialRadioButton;
        if (viewState instanceof WidgetUserSetCustomStatusViewModel.ViewState.Loaded) {
            WidgetUserSetCustomStatusViewModel.ViewState.Loaded loaded = (WidgetUserSetCustomStatusViewModel.ViewState.Loaded) viewState;
            WidgetUserSetCustomStatusViewModel.FormState formState = loaded.getFormState();
            if (formState.getEmoji() != null) {
                String imageUri = formState.getEmoji().getImageUri(true, IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.custom_status_emoji_preview_size)), getContext());
                if (!Intrinsics3.areEqual(imageUri, this.currentEmojiUri)) {
                    SimpleDraweeView simpleDraweeView = getBinding().f2692b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.setCustomStatusEmoji");
                    MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
                    this.currentEmojiUri = imageUri;
                }
            } else {
                getBinding().f2692b.setActualImageResource(R.drawable.ic_smiley_desaturated);
                this.currentEmojiUri = null;
            }
            TextInputLayout textInputLayout = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            if (!Intrinsics3.areEqual(formState.getText(), textOrEmpty)) {
                TextInputLayout textInputLayout2 = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.setCustomStatusText");
                ViewExtensions.setText(textInputLayout2, formState.getText());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout3 = getBinding().j;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.setCustomStatusText");
                    EditText editText = textInputLayout3.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout4 = getBinding().j;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.setCustomStatusText");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout4).length());
                }
            }
            TextInputLayout textInputLayout5 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.setCustomStatusText");
            textInputLayout5.setEndIconVisible(loaded.getShowStatusClear());
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
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "when (formState.expirati…sExpirationTomorrow\n    }");
            RadioManager radioManager = this.expirationRadioManager;
            if (radioManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("expirationRadioManager");
            }
            radioManager.a(materialRadioButton);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Window window;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.custom_status);
        this.expirationRadioManager = new RadioManager(Collections2.listOf((Object[]) new MaterialRadioButton[]{getBinding().g, getBinding().e, getBinding().d, getBinding().f, getBinding().h}));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserSetCustomStatus.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserSetCustomStatus.this.openEmojiPicker();
            }
        });
        getBinding().j.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserSetCustomStatus.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserSetCustomStatus.this.getViewModel().clearStatusTextAndEmoji();
            }
        });
        TextInputLayout textInputLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass3());
        MaterialRadioButton materialRadioButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.setCustomStatusExpirationNever");
        setExpirationOnCheck(materialRadioButton, WidgetUserSetCustomStatusViewModel.FormState.Expiration.NEVER);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.custom_status_clear_in_minutes_minutes, 30, 30);
        MaterialRadioButton materialRadioButton2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.setCustomStatusExpiration30Minutes");
        materialRadioButton2.setText(FormatUtils.e(this, R.string.custom_status_clear_in_minutes, new Object[]{quantityString}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        MaterialRadioButton materialRadioButton3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.setCustomStatusExpiration30Minutes");
        setExpirationOnCheck(materialRadioButton3, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_30_MINUTES);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        CharSequence quantityString2 = StringResourceUtils.getQuantityString(resources2, requireContext(), R.plurals.custom_status_clear_in_hours_hours, 1, 1);
        MaterialRadioButton materialRadioButton4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.setCustomStatusExpiration1Hour");
        materialRadioButton4.setText(FormatUtils.e(this, R.string.custom_status_clear_in_hours, new Object[]{quantityString2}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        MaterialRadioButton materialRadioButton5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton5, "binding.setCustomStatusExpiration1Hour");
        setExpirationOnCheck(materialRadioButton5, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_1_HOUR);
        Resources resources3 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
        CharSequence quantityString3 = StringResourceUtils.getQuantityString(resources3, requireContext(), R.plurals.custom_status_clear_in_hours_hours, 4, 4);
        MaterialRadioButton materialRadioButton6 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton6, "binding.setCustomStatusExpiration4Hours");
        materialRadioButton6.setText(FormatUtils.e(this, R.string.custom_status_clear_in_hours, new Object[]{quantityString3}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        MaterialRadioButton materialRadioButton7 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton7, "binding.setCustomStatusExpiration4Hours");
        setExpirationOnCheck(materialRadioButton7, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_4_HOURS);
        MaterialRadioButton materialRadioButton8 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton8, "binding.setCustomStatusExpirationTomorrow");
        setExpirationOnCheck(materialRadioButton8, WidgetUserSetCustomStatusViewModel.FormState.Expiration.TOMORROW);
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserSetCustomStatus.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserSetCustomStatus.this.getViewModel().saveStatus();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetUserSetCustomStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetUserSetCustomStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
