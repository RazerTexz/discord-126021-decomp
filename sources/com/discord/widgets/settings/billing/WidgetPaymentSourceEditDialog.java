package com.discord.widgets.settings.billing;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.n;
import b.a.a.n$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetPaymentSourceEditDialogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelPaymentSource$ModelPaymentSourcePaypal;
import com.discord.models.domain.PatchPaymentSourceRaw;
import com.discord.models.domain.billing.ModelBillingAddress;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.BasicTextInputValidator$Companion;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog extends AppDialog {
    private static final String ARG_PAYMENT_SOURCE_ID = "ARG_PAYMENT_SOURCE_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: caProvinces$delegate, reason: from kotlin metadata */
    private final Lazy caProvinces;

    /* JADX INFO: renamed from: paymentSourceId$delegate, reason: from kotlin metadata */
    private final Lazy paymentSourceId;

    /* JADX INFO: renamed from: usStates$delegate, reason: from kotlin metadata */
    private final Lazy usStates;
    private ValidationManager validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPaymentSourceEditDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", 0)};
    public static final WidgetPaymentSourceEditDialog$Companion Companion = new WidgetPaymentSourceEditDialog$Companion(null);

    public WidgetPaymentSourceEditDialog() {
        super(R$layout.widget_payment_source_edit_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPaymentSourceEditDialog$binding$2.INSTANCE, null, 2, null);
        this.paymentSourceId = g.lazy(new WidgetPaymentSourceEditDialog$paymentSourceId$2(this));
        WidgetPaymentSourceEditDialog$viewModel$2 widgetPaymentSourceEditDialog$viewModel$2 = WidgetPaymentSourceEditDialog$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsBillingViewModel.class), new WidgetPaymentSourceEditDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetPaymentSourceEditDialog$viewModel$2));
        this.usStates = g.lazy(new WidgetPaymentSourceEditDialog$usStates$2(this));
        this.caProvinces = g.lazy(new WidgetPaymentSourceEditDialog$caProvinces$2(this));
    }

    public static final /* synthetic */ void access$deletePaymentSource(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, ModelPaymentSource modelPaymentSource) {
        widgetPaymentSourceEditDialog.deletePaymentSource(modelPaymentSource);
    }

    public static final /* synthetic */ WidgetPaymentSourceEditDialogBinding access$getBinding$p(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        return widgetPaymentSourceEditDialog.getBinding();
    }

    public static final /* synthetic */ String access$getPaymentSourceId$p(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        return widgetPaymentSourceEditDialog.getPaymentSourceId();
    }

    public static final /* synthetic */ void access$initPaymentSourceInfo(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, PaymentSourceAdapter$PaymentSourceItem paymentSourceAdapter$PaymentSourceItem) {
        widgetPaymentSourceEditDialog.initPaymentSourceInfo(paymentSourceAdapter$PaymentSourceItem);
    }

    public static final /* synthetic */ void access$selectState(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, WidgetPaymentSourceEditDialog$StateEntry[] widgetPaymentSourceEditDialog$StateEntryArr) {
        widgetPaymentSourceEditDialog.selectState(widgetPaymentSourceEditDialog$StateEntryArr);
    }

    public static final /* synthetic */ void access$updatePaymentSource(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, ModelPaymentSource modelPaymentSource) {
        widgetPaymentSourceEditDialog.updatePaymentSource(modelPaymentSource);
    }

    private final void deletePaymentSource(ModelPaymentSource paymentSource) {
        getBinding().d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deletePaymentSource(paymentSource.getId()), false, 1, null), this, null, 2, null), WidgetPaymentSourceEditDialog.class, requireContext(), (Function1) null, new WidgetPaymentSourceEditDialog$deletePaymentSource$2(this), new WidgetPaymentSourceEditDialog$deletePaymentSource$3(this), (Function0) null, new WidgetPaymentSourceEditDialog$deletePaymentSource$1(this), 36, (Object) null);
    }

    private final WidgetPaymentSourceEditDialogBinding getBinding() {
        return (WidgetPaymentSourceEditDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetPaymentSourceEditDialog$StateEntry[] getCaProvinces() {
        return (WidgetPaymentSourceEditDialog$StateEntry[]) this.caProvinces.getValue();
    }

    private static /* synthetic */ void getCaProvinces$annotations() {
    }

    private final String getPaymentSourceId() {
        return (String) this.paymentSourceId.getValue();
    }

    private final WidgetPaymentSourceEditDialog$StateEntry[] getStatesFor(ModelPaymentSource paymentSource) {
        String country = paymentSource.getBillingAddress().getCountry();
        int iHashCode = country.hashCode();
        if (iHashCode != 2142) {
            if (iHashCode == 2718 && country.equals("US")) {
                return getUsStates();
            }
        } else if (country.equals("CA")) {
            return getCaProvinces();
        }
        return new WidgetPaymentSourceEditDialog$StateEntry[0];
    }

    private final WidgetPaymentSourceEditDialog$StateEntry[] getUsStates() {
        return (WidgetPaymentSourceEditDialog$StateEntry[]) this.usStates.getValue();
    }

    private static /* synthetic */ void getUsStates$annotations() {
    }

    private final SettingsBillingViewModel getViewModel() {
        return (SettingsBillingViewModel) this.viewModel.getValue();
    }

    private final void initPaymentSourceInfo(PaymentSourceAdapter$PaymentSourceItem paymentSourceItem) {
        WidgetPaymentSourceEditDialog$StateEntry widgetPaymentSourceEditDialog$StateEntry;
        String state;
        initValidator(paymentSourceItem);
        ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
        boolean isPremium = paymentSourceItem.getIsPremium();
        getBinding().o.bind(paymentSource, isPremium);
        TextView textView = getBinding().k;
        m.checkNotNullExpressionValue(textView, "binding.paymentSourceEditHelp");
        textView.setText(paymentSource instanceof ModelPaymentSource$ModelPaymentSourcePaypal ? b.k(this, 2131893710, new Object[]{"https://www.paypal.com"}, null, 4) : b.k(this, 2131893709, new Object[0], null, 4));
        WidgetPaymentSourceEditDialog$StateEntry[] statesFor = getStatesFor(paymentSource);
        ModelBillingAddress billingAddress = paymentSource.getBillingAddress();
        TextInputLayout textInputLayout = getBinding().l;
        m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        ViewExtensions.setText(textInputLayout, billingAddress.getName());
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        ViewExtensions.setText(textInputLayout2, billingAddress.getLine_1());
        TextInputLayout textInputLayout3 = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress2");
        ViewExtensions.setText(textInputLayout3, billingAddress.getLine_2());
        TextInputLayout textInputLayout4 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditCity");
        ViewExtensions.setText(textInputLayout4, billingAddress.getCity());
        TextInputLayout textInputLayout5 = getBinding().m;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        ViewExtensions.setText(textInputLayout5, billingAddress.getPostalCode());
        TextInputLayout textInputLayout6 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditState");
        m.checkNotNullExpressionValue(statesFor, "states");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                widgetPaymentSourceEditDialog$StateEntry = null;
                break;
            }
            widgetPaymentSourceEditDialog$StateEntry = statesFor[i];
            if (m.areEqual(widgetPaymentSourceEditDialog$StateEntry.getValue(), billingAddress.getState())) {
                break;
            } else {
                i++;
            }
        }
        if (widgetPaymentSourceEditDialog$StateEntry == null || (state = widgetPaymentSourceEditDialog$StateEntry.getLabel()) == null) {
            state = billingAddress.getState();
        }
        ViewExtensions.setText(textInputLayout6, state);
        TextInputLayout textInputLayout7 = getBinding().h;
        m.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
        ViewExtensions.setText(textInputLayout7, billingAddress.getCountry());
        CheckBox checkBox = getBinding().i;
        m.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
        checkBox.setChecked(paymentSource.getDefault());
        getBinding().d.setIsLoading(false);
        if (isPremium) {
            getBinding().c.setOnClickListener(new WidgetPaymentSourceEditDialog$initPaymentSourceInfo$2(this));
            MaterialButton materialButton = getBinding().c;
            m.checkNotNullExpressionValue(materialButton, "binding.dialogDelete");
            materialButton.setAlpha(0.3f);
        } else {
            getBinding().c.setOnClickListener(new WidgetPaymentSourceEditDialog$initPaymentSourceInfo$3(this, paymentSource));
        }
        getBinding().d.setOnClickListener(new WidgetPaymentSourceEditDialog$initPaymentSourceInfo$4(this, paymentSource));
        if (m.areEqual(paymentSource.getBillingAddress().getCountry(), "CA")) {
            TextInputLayout textInputLayout8 = getBinding().n;
            m.checkNotNullExpressionValue(textInputLayout8, "binding.paymentSourceEditState");
            textInputLayout8.setHint(b.k(this, 2131887050, new Object[0], null, 4));
            TextInputLayout textInputLayout9 = getBinding().m;
            m.checkNotNullExpressionValue(textInputLayout9, "binding.paymentSourceEditPostalCode");
            textInputLayout9.setHint(b.k(this, 2131887047, new Object[0], null, 4));
        }
        if (!(statesFor.length == 0)) {
            TextInputLayout textInputLayout10 = getBinding().n;
            m.checkNotNullExpressionValue(textInputLayout10, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditTextClickListener(textInputLayout10, new WidgetPaymentSourceEditDialog$initPaymentSourceInfo$5(this, statesFor));
            TextInputLayout textInputLayout11 = getBinding().n;
            m.checkNotNullExpressionValue(textInputLayout11, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditorActionListener(textInputLayout11, new WidgetPaymentSourceEditDialog$initPaymentSourceInfo$6(this, statesFor));
            return;
        }
        TextInputLayout textInputLayout12 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout12, "binding.paymentSourceEditState");
        EditText editText = textInputLayout12.getEditText();
        if (editText != null) {
            editText.setInputType(1);
        }
        TextInputLayout textInputLayout13 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout13, "binding.paymentSourceEditState");
        EditText editText2 = textInputLayout13.getEditText();
        if (editText2 != null) {
            editText2.setFocusableInTouchMode(true);
        }
    }

    private final void initValidator(PaymentSourceAdapter$PaymentSourceItem paymentSourceItem) {
        ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
        Input[] inputArr = new Input[5];
        TextInputLayout textInputLayout = getBinding().l;
        m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        BasicTextInputValidator$Companion basicTextInputValidator$Companion = BasicTextInputValidator.Companion;
        inputArr[0] = new Input$TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, basicTextInputValidator$Companion.createRequiredInputValidator(2131887046));
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        inputArr[1] = new Input$TextInputLayoutInput("line_1", textInputLayout2, basicTextInputValidator$Companion.createRequiredInputValidator(2131887038));
        TextInputLayout textInputLayout3 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditCity");
        inputArr[2] = new Input$TextInputLayoutInput("city", textInputLayout3, basicTextInputValidator$Companion.createRequiredInputValidator(2131887041));
        TextInputLayout textInputLayout4 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditState");
        InputValidator[] inputValidatorArr = new InputValidator[1];
        inputValidatorArr[0] = basicTextInputValidator$Companion.createRequiredInputValidator(m.areEqual(paymentSource.getBillingAddress().getCountry(), "CA") ? 2131887051 : 2131887054);
        inputArr[3] = new Input$TextInputLayoutInput("state", textInputLayout4, inputValidatorArr);
        TextInputLayout textInputLayout5 = getBinding().m;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        inputArr[4] = new Input$TextInputLayoutInput("postal_code", textInputLayout5, basicTextInputValidator$Companion.createRequiredInputValidator(2131887049));
        this.validationManager = new ValidationManager(inputArr);
    }

    private final void selectState(WidgetPaymentSourceEditDialog$StateEntry[] states) {
        n$a n_a = n.k;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceK = b.k(this, 2131893712, new Object[0], null, 4);
        ArrayList arrayList = new ArrayList(states.length);
        for (WidgetPaymentSourceEditDialog$StateEntry widgetPaymentSourceEditDialog$StateEntry : states) {
            arrayList.add(widgetPaymentSourceEditDialog$StateEntry.getLabel());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        n_a.a(parentFragmentManager, charSequenceK, (CharSequence[]) array, new WidgetPaymentSourceEditDialog$selectState$2(this, states));
        getBinding().m.requestFocus();
    }

    private final void updatePaymentSource(ModelPaymentSource paymentSource) {
        WidgetPaymentSourceEditDialog$StateEntry widgetPaymentSourceEditDialog$StateEntry;
        String value;
        WidgetPaymentSourceEditDialog$Companion widgetPaymentSourceEditDialog$Companion = Companion;
        TextInputLayout textInputLayout = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
        String strAccess$getTextOrEmpty = WidgetPaymentSourceEditDialog$Companion.access$getTextOrEmpty(widgetPaymentSourceEditDialog$Companion, textInputLayout);
        WidgetPaymentSourceEditDialog$StateEntry[] statesFor = getStatesFor(paymentSource);
        m.checkNotNullExpressionValue(statesFor, "getStatesFor(paymentSource)");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                widgetPaymentSourceEditDialog$StateEntry = null;
                break;
            }
            widgetPaymentSourceEditDialog$StateEntry = statesFor[i];
            if (t.equals(widgetPaymentSourceEditDialog$StateEntry.getLabel(), strAccess$getTextOrEmpty, true)) {
                break;
            } else {
                i++;
            }
        }
        String str = (widgetPaymentSourceEditDialog$StateEntry == null || (value = widgetPaymentSourceEditDialog$StateEntry.getValue()) == null) ? strAccess$getTextOrEmpty : value;
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            m.throwUninitializedPropertyAccessException("validationManager");
        }
        if (ValidationManager.validate$default(validationManager, false, 1, null)) {
            WidgetPaymentSourceEditDialog$Companion widgetPaymentSourceEditDialog$Companion2 = Companion;
            TextInputLayout textInputLayout2 = getBinding().l;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditName");
            String strAccess$getTextOrEmpty2 = WidgetPaymentSourceEditDialog$Companion.access$getTextOrEmpty(widgetPaymentSourceEditDialog$Companion2, textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress1");
            String strAccess$getTextOrEmpty3 = WidgetPaymentSourceEditDialog$Companion.access$getTextOrEmpty(widgetPaymentSourceEditDialog$Companion2, textInputLayout3);
            TextInputLayout textInputLayout4 = getBinding().f;
            m.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditAddress2");
            String strAccess$getTextOrEmpty4 = WidgetPaymentSourceEditDialog$Companion.access$getTextOrEmpty(widgetPaymentSourceEditDialog$Companion2, textInputLayout4);
            TextInputLayout textInputLayout5 = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditCity");
            String strAccess$getTextOrEmpty5 = WidgetPaymentSourceEditDialog$Companion.access$getTextOrEmpty(widgetPaymentSourceEditDialog$Companion2, textInputLayout5);
            TextInputLayout textInputLayout6 = getBinding().m;
            m.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditPostalCode");
            String strAccess$getTextOrEmpty6 = WidgetPaymentSourceEditDialog$Companion.access$getTextOrEmpty(widgetPaymentSourceEditDialog$Companion2, textInputLayout6);
            TextInputLayout textInputLayout7 = getBinding().h;
            m.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
            ModelBillingAddress modelBillingAddress = new ModelBillingAddress(strAccess$getTextOrEmpty2, strAccess$getTextOrEmpty3, strAccess$getTextOrEmpty4, strAccess$getTextOrEmpty5, str, WidgetPaymentSourceEditDialog$Companion.access$getTextOrEmpty(widgetPaymentSourceEditDialog$Companion2, textInputLayout7), strAccess$getTextOrEmpty6);
            CheckBox checkBox = getBinding().i;
            m.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
            PatchPaymentSourceRaw patchPaymentSourceRaw = new PatchPaymentSourceRaw(modelBillingAddress, checkBox.isChecked());
            TextView textView = getBinding().j;
            m.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
            textView.setVisibility(8);
            getBinding().d.setIsLoading(true);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updatePaymentSource(paymentSource.getId(), patchPaymentSourceRaw), false, 1, null), this, null, 2, null), WidgetPaymentSourceEditDialog.class, (Context) null, (Function1) null, new WidgetPaymentSourceEditDialog$updatePaymentSource$2(this), new WidgetPaymentSourceEditDialog$updatePaymentSource$3(this), (Function0) null, new WidgetPaymentSourceEditDialog$updatePaymentSource$1(this), 38, (Object) null);
        }
    }

    @MainThread
    public final void handleError(Error error) {
        m.checkNotNullParameter(error, "error");
        TextView textView = getBinding().j;
        m.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        ViewExtensions.setTextAndVisibilityBy(textView, response.getMessage());
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            m.throwUninitializedPropertyAccessException("validationManager");
        }
        Error$Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        Map<String, List<String>> messages = response2.getMessages();
        m.checkNotNullExpressionValue(messages, "error.response.messages");
        validationManager.setErrors(messages);
        Error$Response response3 = error.getResponse();
        m.checkNotNullExpressionValue(response3, "error.response");
        String message = response3.getMessage();
        if (message != null) {
            if (message.length() > 0) {
                b.a.d.m.h(getContext(), message, 0, null, 8);
            }
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        if (!AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            window.getAttributes().windowAnimations = 2131952425;
        }
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$1.INSTANCE).G(WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable observableZ = observableG.G(WidgetPaymentSourceEditDialog$onViewBound$1.INSTANCE).G(new WidgetPaymentSourceEditDialog$onViewBound$2(this)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "viewModel\n        .obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableZ, this, null, 2, null), WidgetPaymentSourceEditDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetPaymentSourceEditDialog$onViewBound$3(this), 62, (Object) null);
        getBinding().f2508b.setNavigationOnClickListener(new WidgetPaymentSourceEditDialog$onViewBound$4(this));
        getBinding().d.setOnClickListener(new WidgetPaymentSourceEditDialog$onViewBound$5(this));
    }
}
