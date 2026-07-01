package com.discord.widgets.hubs;

import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription7 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDescription.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<LinearLayout, CharSequence, Boolean> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(LinearLayout linearLayout, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(linearLayout, charSequence));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(LinearLayout linearLayout, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(linearLayout, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(charSequence, "errorMessage");
            TextView textView = WidgetHubDescription7.this.this$0.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.categoryError");
            FormatUtils.a(textView, charSequence);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription7(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.descriptionLayout");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.member_verification_form_required_item)};
        LinearLayout linearLayout = this.this$0.getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.categoryLayout");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, textInputLayout, inputValidatorArr), new Input.GenericInput("category", linearLayout, new InputValidator<LinearLayout>() { // from class: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2.1
            @Override // com.discord.utilities.view.validators.InputValidator
            public CharSequence getErrorMessage(LinearLayout view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                if (WidgetHubDescription7.this.this$0.getViewModel().getCategory() != null) {
                    return null;
                }
                return view.getContext().getString(R.string.billing_address_address_error_required);
            }
        }, new AnonymousClass2()));
    }
}
