package com.discord.views.phone;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import b.a.i.u2;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneOrEmailInputView extends LinearLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final u2 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public PhoneOrEmailInputView$Mode mode;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public CharSequence email;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public CharSequence phone;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOrEmailInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_phone_or_email_input, this);
        int i = R$id.phone_or_email_country_code_wrap;
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R$id.phone_or_email_country_code_wrap);
        if (textInputLayout != null) {
            i = R$id.phone_or_email_main_input;
            TextInputEditText textInputEditText = (TextInputEditText) findViewById(R$id.phone_or_email_main_input);
            if (textInputEditText != null) {
                i = R$id.phone_or_email_main_input_wrap;
                TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R$id.phone_or_email_main_input_wrap);
                if (textInputLayout2 != null) {
                    u2 u2Var = new u2(this, textInputLayout, textInputEditText, textInputLayout2);
                    m.checkNotNullExpressionValue(u2Var, "ViewPhoneOrEmailInputBin…ater.from(context), this)");
                    this.binding = u2Var;
                    PhoneOrEmailInputView$Mode phoneOrEmailInputView$Mode = PhoneOrEmailInputView$Mode.ADAPTIVE;
                    this.mode = phoneOrEmailInputView$Mode;
                    this.email = "";
                    this.phone = "";
                    setLayoutTransition(new LayoutTransition());
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.PhoneOrEmailInputView, 0, 0);
                        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…neOrEmailInputView, 0, 0)");
                        try {
                            setHint(typedArrayObtainStyledAttributes.getString(1));
                            setMode(PhoneOrEmailInputView$Mode.values()[typedArrayObtainStyledAttributes.getInt(0, phoneOrEmailInputView$Mode.ordinal())]);
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, -1);
                            if (resourceId != -1) {
                                setMainInputNextFocusForwardId(resourceId);
                            }
                            return;
                        } finally {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    }
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final void setMainInputNextFocusForwardId(int id2) {
        TextInputLayout textInputLayout = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        textInputLayout.setNextFocusForwardId(id2);
    }

    public final void a(Fragment fragment, Function0<Unit> onAfterTextChanged) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextInputLayout textInputLayout = this.binding.f210b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, fragment, new PhoneOrEmailInputView$a(onAfterTextChanged));
        TextInputLayout textInputLayout2 = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, fragment, new PhoneOrEmailInputView$b(this, onAfterTextChanged));
    }

    public final void b(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        TextInputLayout textInputLayout = this.binding.f210b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.setOnEditTextClickListener(textInputLayout, new PhoneOrEmailInputView$c(fragment));
        TextInputLayout textInputLayout2 = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, fragment, new PhoneOrEmailInputView$d(this));
        c();
        d();
    }

    public final void c() {
        TextInputLayout textInputLayout = this.binding.f210b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        textInputLayout.setVisibility(e() ? 0 : 8);
    }

    public final void d() {
        if (this.mode.ordinal() != 2) {
            TextInputEditText textInputEditText = this.binding.c;
            m.checkNotNullExpressionValue(textInputEditText, "binding.phoneOrEmailMainInput");
            textInputEditText.setInputType(32);
            if (Build$VERSION.SDK_INT >= 26) {
                this.binding.c.setAutofillHints(new String[]{"emailAddress"});
            }
            TextInputLayout textInputLayout = this.binding.d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
            ViewExtensions.setText(textInputLayout, this.email);
            this.binding.c.setSelection(this.email.length());
            return;
        }
        TextInputEditText textInputEditText2 = this.binding.c;
        m.checkNotNullExpressionValue(textInputEditText2, "binding.phoneOrEmailMainInput");
        textInputEditText2.setInputType(3);
        if (Build$VERSION.SDK_INT >= 26) {
            this.binding.c.setAutofillHints(new String[]{"phone"});
        }
        TextInputLayout textInputLayout2 = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.setText(textInputLayout2, this.phone);
        this.binding.c.setSelection(this.phone.length());
    }

    public final boolean e() {
        int iOrdinal = this.mode.ordinal();
        if (iOrdinal == 1) {
            return false;
        }
        if (iOrdinal == 2) {
            return true;
        }
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        TextInputLayout textInputLayout = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        return phoneUtils.isLikelyToContainPhoneNumber(ViewExtensions.getTextOrEmpty(textInputLayout));
    }

    public final void f() {
        TextInputLayout textInputLayout = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        if (this.mode == PhoneOrEmailInputView$Mode.PHONE || PhoneUtils.INSTANCE.isLikelyToContainPhoneNumber(textOrEmpty)) {
            this.phone = textOrEmpty;
        } else {
            this.email = textOrEmpty;
        }
    }

    public final TextInputEditText getMainEditText() {
        TextInputEditText textInputEditText = this.binding.c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.phoneOrEmailMainInput");
        return textInputEditText;
    }

    public final TextInputLayout getMainTextInputLayout() {
        TextInputLayout textInputLayout = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        return textInputLayout;
    }

    public final String getTextOrEmpty() {
        if (!e()) {
            TextInputLayout textInputLayout = this.binding.d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
            return ViewExtensions.getTextOrEmpty(textInputLayout);
        }
        StringBuilder sb = new StringBuilder();
        TextInputLayout textInputLayout2 = this.binding.f210b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailCountryCodeWrap");
        sb.append(ViewExtensions.getTextOrEmpty(textInputLayout2));
        TextInputLayout textInputLayout3 = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.phoneOrEmailMainInputWrap");
        sb.append(ViewExtensions.getTextOrEmpty(textInputLayout3));
        return sb.toString();
    }

    public final void setCountryCode(PhoneCountryCode countryCode) {
        m.checkNotNullParameter(countryCode, "countryCode");
        TextInputLayout textInputLayout = this.binding.f210b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.setText(textInputLayout, countryCode.getPhoneCountryCode());
    }

    public final void setHint(CharSequence hint) {
        TextInputLayout textInputLayout = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        textInputLayout.setHint(hint);
    }

    public final void setMode(PhoneOrEmailInputView$Mode mode) {
        m.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        c();
        d();
    }

    public final void setText(CharSequence text) {
        TextInputLayout textInputLayout = this.binding.d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.setText(textInputLayout, text);
        f();
    }
}
