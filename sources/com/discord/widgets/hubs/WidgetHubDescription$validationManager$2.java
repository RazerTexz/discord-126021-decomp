package com.discord.widgets.hubs;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$2 */
    /* JADX INFO: compiled from: WidgetHubDescription.kt */
    public static final class C90132 extends AbstractC12240o implements Function2<LinearLayout, CharSequence, Boolean> {
        public C90132() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(LinearLayout linearLayout, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(linearLayout, charSequence));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(LinearLayout linearLayout, CharSequence charSequence) {
            C12238m.checkNotNullParameter(linearLayout, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(charSequence, "errorMessage");
            TextView textView = WidgetHubDescription$validationManager$2.this.this$0.getBinding().f17157d;
            C12238m.checkNotNullExpressionValue(textView, "binding.categoryError");
            C1107b.m209a(textView, charSequence);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$validationManager$2(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().f17160g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.descriptionLayout");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.member_verification_form_required_item)};
        LinearLayout linearLayout = this.this$0.getBinding().f17158e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.categoryLayout");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, textInputLayout, inputValidatorArr), new Input.GenericInput("category", linearLayout, new InputValidator<LinearLayout>() { // from class: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2.1
            @Override // com.discord.utilities.view.validators.InputValidator
            public CharSequence getErrorMessage(LinearLayout view) {
                C12238m.checkNotNullParameter(view, "view");
                if (WidgetHubDescription$validationManager$2.this.this$0.getViewModel().getCategory() != null) {
                    return null;
                }
                return view.getContext().getString(C5419R.string.billing_address_address_error_required);
            }
        }, new C90132()));
    }
}
