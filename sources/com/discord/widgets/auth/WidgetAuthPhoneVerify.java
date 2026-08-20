package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PHONE = "INTENT_EXTRA_PHONE";
    private static final String INTENT_EXTRA_SUBTITLE = "INTENT_EXTRA_SUBTITLE";
    private static final String INTENT_EXTRA_TITLE = "INTENT_EXTRA_TITLE";
    private static final int RESULT_BACK_TO_EMAIL = 2;
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private final LoggingConfig loggingConfig;
    private String phone;

    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String phone, CharSequence title, CharSequence subtitle) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            C12238m.checkNotNullParameter(phone, "phone");
            C12238m.checkNotNullParameter(title, "title");
            C12238m.checkNotNullParameter(subtitle, "subtitle");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_PHONE, phone);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_TITLE, title);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_SUBTITLE, subtitle);
            C0870j.f524g.m160f(context, launcher, WidgetAuthPhoneVerify.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function1<? super Result, Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.auth.WidgetAuthPhoneVerify$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() != -1) {
                        if (activityResult.getResultCode() == 2) {
                            callback.invoke(WidgetAuthPhoneVerify.Result.Cancelled.INSTANCE);
                        }
                    } else {
                        Intent data = activityResult.getData();
                        String stringExtra = data != null ? data.getStringExtra("RESULT_EXTRA_TOKEN") : null;
                        if (stringExtra != null) {
                            callback.invoke(new WidgetAuthPhoneVerify.Result.Token(stringExtra));
                        }
                    }
                }
            });
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ed)\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static abstract class Result {

        /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
        public static final class Cancelled extends Result {
            public static final Cancelled INSTANCE = new Cancelled();

            private Cancelled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
        public static final /* data */ class Token extends Result {
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Token(String str) {
                super(null);
                C12238m.checkNotNullParameter(str, "token");
                this.token = str;
            }

            public static /* synthetic */ Token copy$default(Token token, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = token.token;
                }
                return token.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final Token copy(String token) {
                C12238m.checkNotNullParameter(token, "token");
                return new Token(token);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Token) && C12238m.areEqual(this.token, ((Token) other).token);
                }
                return true;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                String str = this.token;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m822J(C1643a.m833U("Token(token="), this.token, ")");
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$1 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72071 extends AbstractC12240o implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadataReceiver> {
        public static final C72071 INSTANCE = new C72071();

        public C72071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return new TrackNetworkActionUserVerifyPhone();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$2 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72082 extends AbstractC12240o implements Function1<ModelPhoneVerificationToken, Unit> {
        public C72082() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            invoke2(modelPhoneVerificationToken);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            C12238m.checkNotNullParameter(modelPhoneVerificationToken, "it");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.RESULT_EXTRA_TOKEN, modelPhoneVerificationToken.getToken());
            AppActivity appActivity = WidgetAuthPhoneVerify.this.getAppActivity();
            if (appActivity != null) {
                appActivity.setResult(-1, intent);
            }
            AppActivity appActivity2 = WidgetAuthPhoneVerify.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$3 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72093 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72093() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Phone Verification", "response_error", C12145m.listOf(ModelAuditLogEntry.CHANGE_KEY_CODE));
            WidgetAuthPhoneVerify.this.getBinding().f15697c.m8538b();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$1 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72101 extends AbstractC12240o implements Function1<String, Unit> {
        public static final C72101 INSTANCE = new C72101();

        public C72101() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$2 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final /* synthetic */ class C72112 extends C12236k implements Function1<String, Unit> {
        public C72112(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "p1");
            ((WidgetAuthPhoneVerify) this.receiver).evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$3 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72123 extends AbstractC12240o implements Function1<Long, Unit> {
        public C72123() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthPhoneVerify widgetAuthPhoneVerify = WidgetAuthPhoneVerify.this;
            widgetAuthPhoneVerify.evaluateCode(widgetAuthPhoneVerify.getBinding().f15697c.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onResume$1 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72131 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C72131() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetAuthPhoneVerify.this.tryPasteCodeFromClipboard();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72163 extends AbstractC12240o implements Function1<String, Unit> {
        public C72163() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetAuthPhoneVerify.this.evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final /* synthetic */ class C72174 extends C12236k implements Function1<String, Unit> {
        public C72174(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "inputCode", "inputCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "p1");
            ((WidgetAuthPhoneVerify) this.receiver).inputCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$1 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72181 extends AbstractC12240o implements Function1<Void, Unit> {
        public C72181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetAuthPhoneVerify.this.getBinding().f15697c.m8538b();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$2 */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class C72192 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72192() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetAuthPhoneVerify.this.getBinding().f15697c.m8538b();
        }
    }

    public WidgetAuthPhoneVerify() {
        super(C5419R.layout.widget_auth_phone_verify);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthPhoneVerify$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthPhoneVerify$binding$2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    private final void bailoutToEmail() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(2);
        }
        AppTransitionActivity.f14963j = true;
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.overridePendingTransition(C5419R.anim.activity_slide_horizontal_open_in, C5419R.anim.activity_slide_horizontal_close_out);
        }
        AppActivity appActivity3 = getAppActivity();
        if (appActivity3 != null) {
            appActivity3.finish();
        }
    }

    private final void evaluateCode(String code) {
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Phone Verification", "submitted", null, 4, null);
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            C12238m.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(api.phoneVerificationsVerify(new RestAPIParams.VerificationCode(str, code)), C72071.INSTANCE), false, 1, null), this, null, 2, null), getBinding().f15701g, 0L, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72093()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72082());
    }

    private final WidgetAuthPhoneVerifyBinding getBinding() {
        return (WidgetAuthPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void inputCode(String code) {
        if (getView() != null) {
            getBinding().f15697c.setOnCodeEntered(C72101.INSTANCE);
            getBinding().f15697c.setCode(code);
            getBinding().f15697c.setOnCodeEntered(new C72112(this));
            Observable<Long> observableM11068d0 = Observable.m11068d0(500L, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72123());
        }
    }

    private final void resendCode() {
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            C12238m.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.phoneVerificationsResend(new RestAPIParams.VerificationCodeResend(str)), false, 1, null), this, null, 2, null), getBinding().f15701g, 0L, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72192()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72181());
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            C12238m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                C12238m.checkNotNullExpressionValue(charSequenceCoerceToText, "clipData.getItemAt(0).coerceToText(context)");
                String strReplace = new Regex(" ").replace(charSequenceCoerceToText, "");
                if (strReplace.length() == 6 && TextUtils.isDigitsOnly(strReplace)) {
                    inputCode(strReplace);
                }
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        C12238m.checkNotNullParameter(item, "item");
        if (item.getItemId() != C5419R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        C12238m.checkNotNullParameter(menu, "menu");
        C12238m.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(C5419R.menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SmsListener.INSTANCE.stopSmsListener();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        C12721k c12721k = new C12721k(Unit.f27425a);
        C12238m.checkNotNullExpressionValue(c12721k, "Observable\n          .just(Unit)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(c12721k, this, null, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72131());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.phone = stringExtra;
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Phone Verification", "viewed", null, 4, null);
        CharSequence charSequenceExtra = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_TITLE);
        if (charSequenceExtra == null) {
            charSequenceExtra = "";
        }
        C12238m.checkNotNullExpressionValue(charSequenceExtra, "mostRecentIntent.getChar…INTENT_EXTRA_TITLE) ?: \"\"");
        CharSequence charSequenceExtra2 = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_SUBTITLE);
        if (charSequenceExtra2 == null) {
            charSequenceExtra2 = "";
        }
        C12238m.checkNotNullExpressionValue(charSequenceExtra2, "mostRecentIntent.getChar…ENT_EXTRA_SUBTITLE) ?: \"\"");
        if (!C12238m.areEqual(charSequenceExtra, "")) {
            TextView textView = getBinding().f15700f;
            C12238m.checkNotNullExpressionValue(textView, "binding.authPhoneVerifyTitle");
            textView.setText(charSequenceExtra);
        }
        if (!C12238m.areEqual(charSequenceExtra2, "")) {
            TextView textView2 = getBinding().f15699e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.authPhoneVerifySubtitle");
            textView2.setText(charSequenceExtra2);
        }
        getBinding().f15698d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthPhoneVerify.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthPhoneVerify.this.resendCode();
            }
        });
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-06_reg_bailout_to_email_android", true);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            TextView textView3 = getBinding().f15696b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.authPhoneBailout");
            textView3.setVisibility(0);
            getBinding().f15696b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthPhoneVerify.onViewBound.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetAuthPhoneVerify.this.bailoutToEmail();
                }
            });
        }
        getBinding().f15697c.setOnCodeEntered(new C72163());
        registerForContextMenu(getBinding().f15697c);
        SmsListener.INSTANCE.startSmsListener(new C72174(this));
    }
}
