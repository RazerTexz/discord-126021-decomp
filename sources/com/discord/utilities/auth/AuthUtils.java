package com.discord.utilities.auth;

import android.annotation.SuppressLint;
import android.util.Patterns;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p507d0.p510c0.C11217d;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AuthUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuthUtils {
    public static final String AUTHY_PACKAGE = "com.authy.authy";
    public static final String GOOGLE_AUTHENTICATOR_PACKAGE = "com.google.android.apps.authenticator2";
    public static final AuthUtils INSTANCE = new AuthUtils();
    private static final int MAX_PASSWORD_LENGTH = 128;
    private static final int MIN_PASSWORD_LENGTH = 6;
    public static final String URL_AUTHY = "https://play.google.com/store/apps/details?id=com.authy.authy";
    public static final String URL_GOOGLE_AUTHENTICATOR = "https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2";
    private static final String URL_PLAY_STORE = "https://play.google.com/store/apps/details";

    /* JADX INFO: renamed from: com.discord.utilities.auth.AuthUtils$createEmailInputValidator$1 */
    /* JADX INFO: compiled from: AuthUtils.kt */
    public static final class C66961 extends AbstractC12240o implements Function1<String, Boolean> {
        public static final C66961 INSTANCE = new C66961();

        public C66961() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
            return AuthUtils.INSTANCE.isValidEmail(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auth.AuthUtils$createPasswordInputValidator$1 */
    /* JADX INFO: compiled from: AuthUtils.kt */
    public static final class C66971 extends AbstractC12240o implements Function1<String, Boolean> {
        public static final C66971 INSTANCE = new C66971();

        public C66971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
            return AuthUtils.INSTANCE.isValidPasswordLength(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auth.AuthUtils$createPhoneInputValidator$1 */
    /* JADX INFO: compiled from: AuthUtils.kt */
    public static final class C66981 extends AbstractC12240o implements Function1<String, Boolean> {
        public static final C66981 INSTANCE = new C66981();

        public C66981() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
            return PhoneUtils.INSTANCE.isValidPhoneFragment(str);
        }
    }

    private AuthUtils() {
    }

    private final boolean isValidEmail(String email) {
        return (email.length() > 0) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public final InputValidator<TextInputLayout> createDiscriminatorInputValidator(@StringRes final int invalidFormatResId, @StringRes final int invalidValueResId) {
        return new InputValidator<TextInputLayout>() { // from class: com.discord.utilities.auth.AuthUtils.createDiscriminatorInputValidator.1
            @Override // com.discord.utilities.view.validators.InputValidator
            public CharSequence getErrorMessage(TextInputLayout view) {
                C12238m.checkNotNullParameter(view, "view");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(view);
                Integer intOrNull = C12102s.toIntOrNull(textOrEmpty);
                if (intOrNull == null || textOrEmpty.length() != 4) {
                    return C1107b.m212d(view, invalidFormatResId, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
                }
                if (intOrNull.intValue() <= 0) {
                    return C1107b.m212d(view, invalidValueResId, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
                }
                return null;
            }
        };
    }

    public final BasicTextInputValidator createEmailInputValidator(@StringRes int messageResId) {
        return new BasicTextInputValidator(messageResId, C66961.INSTANCE);
    }

    public final ValidationManager createEmailValidationManager(TextInputLayout emailInput) {
        C12238m.checkNotNullParameter(emailInput, "emailInput");
        return new ValidationManager(new Input.TextInputLayoutInput(NotificationCompat.CATEGORY_EMAIL, emailInput, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.email_required), createEmailInputValidator(C5419R.string.email_invalid)));
    }

    public final BasicTextInputValidator createPasswordInputValidator(@StringRes int messageResId) {
        return new BasicTextInputValidator(messageResId, C66971.INSTANCE);
    }

    public final BasicTextInputValidator createPhoneInputValidator(@StringRes int messageResId) {
        return new BasicTextInputValidator(messageResId, C66981.INSTANCE);
    }

    @SuppressLint({"DefaultLocale"})
    public final String encodeTotpSecret(String secret) {
        C12238m.checkNotNullParameter(secret, "secret");
        String strReplace$default = C12103t.replace$default(secret, " ", "", false, 4, (Object) null);
        Objects.requireNonNull(strReplace$default, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strReplace$default.toUpperCase();
        C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        Objects.requireNonNull(upperCase, "null cannot be cast to non-null type kotlin.CharSequence");
        return C12106w.trim(upperCase).toString();
    }

    @SuppressLint({"DefaultLocale"})
    public final String generateNewTotpKey() throws UnsupportedEncodingException {
        String strEncode = URLEncoder.encode(StringUtilsKt.encodeToBase32String(C11217d.Random(ClockFactory.get().currentTimeMillis()).nextBytes(10)), "utf-8");
        C12238m.checkNotNullExpressionValue(strEncode, "URLEncoder\n        .enco…oBase32String(), \"utf-8\")");
        String strReplace$default = C12103t.replace$default(strEncode, "=", "", false, 4, (Object) null);
        Objects.requireNonNull(strReplace$default, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strReplace$default.toLowerCase();
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        Objects.requireNonNull(lowerCase, "null cannot be cast to non-null type kotlin.CharSequence");
        StringBuilder sb = new StringBuilder(C12106w.trim(lowerCase).toString());
        Iterator it = C12147n.listOf((Object[]) new Integer[]{12, 8, 4}).iterator();
        while (it.hasNext()) {
            sb.insert(((Number) it.next()).intValue(), " ");
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    public final boolean isValidPasswordLength(String password) {
        C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        int length = password.length();
        return 6 <= length && 128 >= length;
    }
}
