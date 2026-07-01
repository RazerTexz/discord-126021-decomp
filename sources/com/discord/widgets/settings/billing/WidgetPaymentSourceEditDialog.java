package com.discord.widgets.settings.billing;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.SelectorDialog;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetPaymentSourceEditDialogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelPaymentSource2;
import com.discord.models.domain.billing.ModelBillingAddress;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;
import com.discord.widgets.settings.billing.SettingsBillingViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetPaymentSourceEditDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String getTextOrEmpty(TextInputLayout textInputLayout) {
            Editable text;
            EditText editText = textInputLayout.getEditText();
            String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
            return string != null ? string : "";
        }

        public final void launch(FragmentManager fragmentManager, String paymentSourceId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(paymentSourceId, "paymentSourceId");
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = new WidgetPaymentSourceEditDialog();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetPaymentSourceEditDialog.ARG_PAYMENT_SOURCE_ID, paymentSourceId);
            widgetPaymentSourceEditDialog.setArguments(bundle);
            widgetPaymentSourceEditDialog.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final /* data */ class StateEntry {
        private final String label;
        private final String value;

        public StateEntry(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "label");
            Intrinsics3.checkNotNullParameter(str2, "value");
            this.label = str;
            this.value = str2;
        }

        public static /* synthetic */ StateEntry copy$default(StateEntry stateEntry, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stateEntry.label;
            }
            if ((i & 2) != 0) {
                str2 = stateEntry.value;
            }
            return stateEntry.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final StateEntry copy(String label, String value) {
            Intrinsics3.checkNotNullParameter(label, "label");
            Intrinsics3.checkNotNullParameter(value, "value");
            return new StateEntry(label, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateEntry)) {
                return false;
            }
            StateEntry stateEntry = (StateEntry) other;
            return Intrinsics3.areEqual(this.label, stateEntry.label) && Intrinsics3.areEqual(this.value, stateEntry.value);
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            String str = this.label;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StateEntry(label=");
            sbU.append(this.label);
            sbU.append(", value=");
            return outline.J(sbU, this.value, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.i(WidgetPaymentSourceEditDialog.this, R.string.payment_source_deleted, 0, 4);
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetPaymentSourceEditDialog.this.getBinding().d.setIsLoading(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPaymentSourceEditDialog.this.getBinding().d.setIsLoading(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(StateEntry[] stateEntryArr) {
            super(1);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = WidgetPaymentSourceEditDialog.this;
            StateEntry[] stateEntryArr = this.$states;
            Intrinsics3.checkNotNullExpressionValue(stateEntryArr, "states");
            widgetPaymentSourceEditDialog.selectState(stateEntryArr);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass6 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(StateEntry[] stateEntryArr) {
            super(3);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "<anonymous parameter 0>");
            if (i != 2 && i != 6) {
                return false;
            }
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = WidgetPaymentSourceEditDialog.this;
            StateEntry[] stateEntryArr = this.$states;
            Intrinsics3.checkNotNullExpressionValue(stateEntryArr, "states");
            widgetPaymentSourceEditDialog.selectState(stateEntryArr);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<PaymentSourceAdapter.PaymentSourceItem, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
            invoke2(paymentSourceItem);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
            if (paymentSourceItem == null) {
                WidgetPaymentSourceEditDialog.this.dismiss();
            } else {
                WidgetPaymentSourceEditDialog.this.initPaymentSourceInfo(paymentSourceItem);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$selectState$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StateEntry[] stateEntryArr) {
            super(1);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            TextInputLayout textInputLayout = WidgetPaymentSourceEditDialog.this.getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
            ViewExtensions.setText(textInputLayout, this.$states[i].getLabel());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.i(WidgetPaymentSourceEditDialog.this, R.string.payment_source_edit_saved, 0, 4);
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetPaymentSourceEditDialog.this.handleError(error);
            WidgetPaymentSourceEditDialog.this.getBinding().d.setIsLoading(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPaymentSourceEditDialog.this.getBinding().d.setIsLoading(false);
        }
    }

    public WidgetPaymentSourceEditDialog() {
        super(R.layout.widget_payment_source_edit_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPaymentSourceEditDialog2.INSTANCE, null, 2, null);
        this.paymentSourceId = LazyJVM.lazy(new WidgetPaymentSourceEditDialog4(this));
        WidgetPaymentSourceEditDialog6 widgetPaymentSourceEditDialog6 = WidgetPaymentSourceEditDialog6.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsBillingViewModel.class), new WidgetPaymentSourceEditDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetPaymentSourceEditDialog6));
        this.usStates = LazyJVM.lazy(new WidgetPaymentSourceEditDialog5(this));
        this.caProvinces = LazyJVM.lazy(new WidgetPaymentSourceEditDialog3(this));
    }

    private final void deletePaymentSource(ModelPaymentSource paymentSource) {
        getBinding().d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deletePaymentSource(paymentSource.getId()), false, 1, null), this, null, 2, null), (Class<?>) WidgetPaymentSourceEditDialog.class, (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : new AnonymousClass3()), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final WidgetPaymentSourceEditDialogBinding getBinding() {
        return (WidgetPaymentSourceEditDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StateEntry[] getCaProvinces() {
        return (StateEntry[]) this.caProvinces.getValue();
    }

    private static /* synthetic */ void getCaProvinces$annotations() {
    }

    private final String getPaymentSourceId() {
        return (String) this.paymentSourceId.getValue();
    }

    private final StateEntry[] getStatesFor(ModelPaymentSource paymentSource) {
        String country = paymentSource.getBillingAddress().getCountry();
        int iHashCode = country.hashCode();
        if (iHashCode != 2142) {
            if (iHashCode == 2718 && country.equals("US")) {
                return getUsStates();
            }
        } else if (country.equals("CA")) {
            return getCaProvinces();
        }
        return new StateEntry[0];
    }

    private final StateEntry[] getUsStates() {
        return (StateEntry[]) this.usStates.getValue();
    }

    private static /* synthetic */ void getUsStates$annotations() {
    }

    private final SettingsBillingViewModel getViewModel() {
        return (SettingsBillingViewModel) this.viewModel.getValue();
    }

    private final void initPaymentSourceInfo(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
        StateEntry stateEntry;
        String state;
        initValidator(paymentSourceItem);
        final ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
        boolean isPremium = paymentSourceItem.getIsPremium();
        getBinding().o.bind(paymentSource, isPremium);
        TextView textView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceEditHelp");
        textView.setText(paymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal ? FormatUtils.e(this, R.string.payment_source_edit_help_paypal, new Object[]{"https://www.paypal.com"}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(this, R.string.payment_source_edit_help_card, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        StateEntry[] statesFor = getStatesFor(paymentSource);
        ModelBillingAddress billingAddress = paymentSource.getBillingAddress();
        TextInputLayout textInputLayout = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        ViewExtensions.setText(textInputLayout, billingAddress.getName());
        TextInputLayout textInputLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        ViewExtensions.setText(textInputLayout2, billingAddress.getLine_1());
        TextInputLayout textInputLayout3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress2");
        ViewExtensions.setText(textInputLayout3, billingAddress.getLine_2());
        TextInputLayout textInputLayout4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditCity");
        ViewExtensions.setText(textInputLayout4, billingAddress.getCity());
        TextInputLayout textInputLayout5 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        ViewExtensions.setText(textInputLayout5, billingAddress.getPostalCode());
        TextInputLayout textInputLayout6 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditState");
        Intrinsics3.checkNotNullExpressionValue(statesFor, "states");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stateEntry = null;
                break;
            }
            stateEntry = statesFor[i];
            if (Intrinsics3.areEqual(stateEntry.getValue(), billingAddress.getState())) {
                break;
            } else {
                i++;
            }
        }
        if (stateEntry == null || (state = stateEntry.getLabel()) == null) {
            state = billingAddress.getState();
        }
        ViewExtensions.setText(textInputLayout6, state);
        TextInputLayout textInputLayout7 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
        ViewExtensions.setText(textInputLayout7, billingAddress.getCountry());
        CheckBox checkBox = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
        checkBox.setChecked(paymentSource.getDefault());
        getBinding().d.setIsLoading(false);
        if (isPremium) {
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog.initPaymentSourceInfo.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetPaymentSourceEditDialog.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.e(WidgetPaymentSourceEditDialog.this, R.string.payment_source_delete, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(WidgetPaymentSourceEditDialog.this, R.string.payment_source_delete_disabled_tooltip, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(WidgetPaymentSourceEditDialog.this, R.string.okay, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), "", null, null, null, null, null, null, null, 0, null, 16352, null);
                }
            });
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.dialogDelete");
            materialButton.setAlpha(0.3f);
        } else {
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog.initPaymentSourceInfo.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetPaymentSourceEditDialog.this.deletePaymentSource(paymentSource);
                }
            });
        }
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog.initPaymentSourceInfo.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetPaymentSourceEditDialog.this.updatePaymentSource(paymentSource);
            }
        });
        if (Intrinsics3.areEqual(paymentSource.getBillingAddress().getCountry(), "CA")) {
            TextInputLayout textInputLayout8 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout8, "binding.paymentSourceEditState");
            textInputLayout8.setHint(FormatUtils.e(this, R.string.billing_address_province, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            TextInputLayout textInputLayout9 = getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout9, "binding.paymentSourceEditPostalCode");
            textInputLayout9.setHint(FormatUtils.e(this, R.string.billing_address_postal_code, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        }
        if (!(statesFor.length == 0)) {
            TextInputLayout textInputLayout10 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout10, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditTextClickListener(textInputLayout10, new AnonymousClass5(statesFor));
            TextInputLayout textInputLayout11 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout11, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditorActionListener(textInputLayout11, new AnonymousClass6(statesFor));
            return;
        }
        TextInputLayout textInputLayout12 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout12, "binding.paymentSourceEditState");
        EditText editText = textInputLayout12.getEditText();
        if (editText != null) {
            editText.setInputType(1);
        }
        TextInputLayout textInputLayout13 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout13, "binding.paymentSourceEditState");
        EditText editText2 = textInputLayout13.getEditText();
        if (editText2 != null) {
            editText2.setFocusableInTouchMode(true);
        }
    }

    private final void initValidator(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
        ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
        Input[] inputArr = new Input[5];
        TextInputLayout textInputLayout = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        inputArr[0] = new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, companion.createRequiredInputValidator(R.string.billing_address_name_error_required));
        TextInputLayout textInputLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        inputArr[1] = new Input.TextInputLayoutInput("line_1", textInputLayout2, companion.createRequiredInputValidator(R.string.billing_address_address_error_required));
        TextInputLayout textInputLayout3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditCity");
        inputArr[2] = new Input.TextInputLayoutInput("city", textInputLayout3, companion.createRequiredInputValidator(R.string.billing_address_city_error_required));
        TextInputLayout textInputLayout4 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditState");
        InputValidator[] inputValidatorArr = new InputValidator[1];
        inputValidatorArr[0] = companion.createRequiredInputValidator(Intrinsics3.areEqual(paymentSource.getBillingAddress().getCountry(), "CA") ? R.string.billing_address_province_error_required : R.string.billing_address_state_error_required);
        inputArr[3] = new Input.TextInputLayoutInput("state", textInputLayout4, inputValidatorArr);
        TextInputLayout textInputLayout5 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        inputArr[4] = new Input.TextInputLayoutInput("postal_code", textInputLayout5, companion.createRequiredInputValidator(R.string.billing_address_postal_code_error_required));
        this.validationManager = new ValidationManager(inputArr);
    }

    private final void selectState(StateEntry[] states) {
        SelectorDialog.Companion companion = SelectorDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceE = FormatUtils.e(this, R.string.payment_source_edit_select_state, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        ArrayList arrayList = new ArrayList(states.length);
        for (StateEntry stateEntry : states) {
            arrayList.add(stateEntry.getLabel());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.a(parentFragmentManager, charSequenceE, (CharSequence[]) array, new AnonymousClass2(states));
        getBinding().m.requestFocus();
    }

    private final void updatePaymentSource(ModelPaymentSource paymentSource) {
        StateEntry stateEntry;
        String value;
        Companion companion = INSTANCE;
        TextInputLayout textInputLayout = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
        String textOrEmpty = companion.getTextOrEmpty(textInputLayout);
        StateEntry[] statesFor = getStatesFor(paymentSource);
        Intrinsics3.checkNotNullExpressionValue(statesFor, "getStatesFor(paymentSource)");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stateEntry = null;
                break;
            }
            stateEntry = statesFor[i];
            if (StringsJVM.equals(stateEntry.getLabel(), textOrEmpty, true)) {
                break;
            } else {
                i++;
            }
        }
        String str = (stateEntry == null || (value = stateEntry.getValue()) == null) ? textOrEmpty : value;
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("validationManager");
        }
        if (ValidationManager.validate$default(validationManager, false, 1, null)) {
            Companion companion2 = INSTANCE;
            TextInputLayout textInputLayout2 = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditName");
            String textOrEmpty2 = companion2.getTextOrEmpty(textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress1");
            String textOrEmpty3 = companion2.getTextOrEmpty(textInputLayout3);
            TextInputLayout textInputLayout4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditAddress2");
            String textOrEmpty4 = companion2.getTextOrEmpty(textInputLayout4);
            TextInputLayout textInputLayout5 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditCity");
            String textOrEmpty5 = companion2.getTextOrEmpty(textInputLayout5);
            TextInputLayout textInputLayout6 = getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditPostalCode");
            String textOrEmpty6 = companion2.getTextOrEmpty(textInputLayout6);
            TextInputLayout textInputLayout7 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
            ModelBillingAddress modelBillingAddress = new ModelBillingAddress(textOrEmpty2, textOrEmpty3, textOrEmpty4, textOrEmpty5, str, companion2.getTextOrEmpty(textInputLayout7), textOrEmpty6);
            CheckBox checkBox = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
            ModelPaymentSource2 modelPaymentSource2 = new ModelPaymentSource2(modelBillingAddress, checkBox.isChecked());
            TextView textView = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
            textView.setVisibility(8);
            getBinding().d.setIsLoading(true);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePaymentSource(paymentSource.getId(), modelPaymentSource2), false, 1, null), this, null, 2, null), (Class<?>) WidgetPaymentSourceEditDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : new AnonymousClass3()), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        }
    }

    @MainThread
    public final void handleError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        TextView textView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        ViewExtensions.setTextAndVisibilityBy(textView, response.getMessage());
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("validationManager");
        }
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        Map<String, List<String>> messages = response2.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        validationManager.setErrors(messages);
        Error.Response response3 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
        String message = response3.getMessage();
        if (message != null) {
            if (message.length() > 0) {
                AppToast.h(getContext(), message, 0, null, 8);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<R> observableG = getViewModel().observeViewState().y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof SettingsBillingViewModel.ViewState.Loaded);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.settings.billing.SettingsBillingViewModel.ViewState.Loaded");
                return (T) ((SettingsBillingViewModel.ViewState.Loaded) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable observableZ = observableG.G(new Func1<SettingsBillingViewModel.ViewState.Loaded, List<? extends PaymentSourceAdapter.PaymentSourceItem>>() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog.onViewBound.1
            @Override // j0.k.Func1
            public final List<PaymentSourceAdapter.PaymentSourceItem> call(SettingsBillingViewModel.ViewState.Loaded loaded) {
                List<PaymentSourceAdapter.Item> paymentSourceItems = loaded.getPaymentSourceItems();
                ArrayList arrayList = new ArrayList();
                for (PaymentSourceAdapter.Item item : paymentSourceItems) {
                    if (!(item instanceof PaymentSourceAdapter.PaymentSourceItem)) {
                        item = null;
                    }
                    PaymentSourceAdapter.PaymentSourceItem paymentSourceItem = (PaymentSourceAdapter.PaymentSourceItem) item;
                    if (paymentSourceItem != null) {
                        arrayList.add(paymentSourceItem);
                    }
                }
                return arrayList;
            }
        }).G(new Func1<List<? extends PaymentSourceAdapter.PaymentSourceItem>, PaymentSourceAdapter.PaymentSourceItem>() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog.onViewBound.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ PaymentSourceAdapter.PaymentSourceItem call(List<? extends PaymentSourceAdapter.PaymentSourceItem> list) {
                return call2((List<PaymentSourceAdapter.PaymentSourceItem>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final PaymentSourceAdapter.PaymentSourceItem call2(List<PaymentSourceAdapter.PaymentSourceItem> list) {
                T next;
                Intrinsics3.checkNotNullExpressionValue(list, "paymentSources");
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (Intrinsics3.areEqual(((PaymentSourceAdapter.PaymentSourceItem) next).getPaymentSource().getId(), WidgetPaymentSourceEditDialog.this.getPaymentSourceId())) {
                        return next;
                    }
                }
                next = (T) null;
                return next;
            }
        }).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "viewModel\n        .obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableZ, this, null, 2, null), (Class<?>) WidgetPaymentSourceEditDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        getBinding().f2508b.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetPaymentSourceEditDialog.this.dismiss();
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetPaymentSourceEditDialog.this.dismiss();
            }
        });
    }
}
