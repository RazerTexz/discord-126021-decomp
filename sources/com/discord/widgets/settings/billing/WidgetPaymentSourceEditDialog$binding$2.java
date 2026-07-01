package com.discord.widgets.settings.billing;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.discord.R$id;
import com.discord.databinding.WidgetPaymentSourceEditDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPaymentSourceEditDialog$binding$2 extends k implements Function1<View, WidgetPaymentSourceEditDialogBinding> {
    public static final WidgetPaymentSourceEditDialog$binding$2 INSTANCE = new WidgetPaymentSourceEditDialog$binding$2();

    public WidgetPaymentSourceEditDialog$binding$2() {
        super(1, WidgetPaymentSourceEditDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPaymentSourceEditDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPaymentSourceEditDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361878;
        Toolbar toolbar = (Toolbar) view.findViewById(2131361878);
        if (toolbar != null) {
            i = R$id.dialog_delete;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.dialog_delete);
            if (materialButton != null) {
                i = R$id.dialog_save;
                LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.dialog_save);
                if (loadingButton != null) {
                    i = R$id.payment_source_edit_address1;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.payment_source_edit_address1);
                    if (textInputLayout != null) {
                        i = R$id.payment_source_edit_address2;
                        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R$id.payment_source_edit_address2);
                        if (textInputLayout2 != null) {
                            i = R$id.payment_source_edit_city;
                            TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(R$id.payment_source_edit_city);
                            if (textInputLayout3 != null) {
                                i = R$id.payment_source_edit_country;
                                TextInputLayout textInputLayout4 = (TextInputLayout) view.findViewById(R$id.payment_source_edit_country);
                                if (textInputLayout4 != null) {
                                    i = R$id.payment_source_edit_default;
                                    CheckBox checkBox = (CheckBox) view.findViewById(R$id.payment_source_edit_default);
                                    if (checkBox != null) {
                                        i = R$id.payment_source_edit_error;
                                        TextView textView = (TextView) view.findViewById(R$id.payment_source_edit_error);
                                        if (textView != null) {
                                            i = R$id.payment_source_edit_help;
                                            TextView textView2 = (TextView) view.findViewById(R$id.payment_source_edit_help);
                                            if (textView2 != null) {
                                                i = R$id.payment_source_edit_name;
                                                TextInputLayout textInputLayout5 = (TextInputLayout) view.findViewById(R$id.payment_source_edit_name);
                                                if (textInputLayout5 != null) {
                                                    i = R$id.payment_source_edit_postal_code;
                                                    TextInputLayout textInputLayout6 = (TextInputLayout) view.findViewById(R$id.payment_source_edit_postal_code);
                                                    if (textInputLayout6 != null) {
                                                        i = R$id.payment_source_edit_state;
                                                        TextInputLayout textInputLayout7 = (TextInputLayout) view.findViewById(R$id.payment_source_edit_state);
                                                        if (textInputLayout7 != null) {
                                                            i = R$id.payment_source_summary;
                                                            PaymentSourceView paymentSourceView = (PaymentSourceView) view.findViewById(R$id.payment_source_summary);
                                                            if (paymentSourceView != null) {
                                                                return new WidgetPaymentSourceEditDialogBinding((LinearLayout) view, toolbar, materialButton, loadingButton, textInputLayout, textInputLayout2, textInputLayout3, textInputLayout4, checkBox, textView, textView2, textInputLayout5, textInputLayout6, textInputLayout7, paymentSourceView);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
