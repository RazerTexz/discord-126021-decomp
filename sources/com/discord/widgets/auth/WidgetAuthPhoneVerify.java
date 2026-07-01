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
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import d0.t.CollectionsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0)};

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
    private final AppLogger2 loggingConfig;
    private String phone;

    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String phone, CharSequence title, CharSequence subtitle) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(phone, "phone");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_PHONE, phone);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_TITLE, title);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_SUBTITLE, subtitle);
            AppScreen2.g.f(context, launcher, WidgetAuthPhoneVerify.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function1<? super Result, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.auth.WidgetAuthPhoneVerify$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
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
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ed)\n          }\n        }");
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
                Intrinsics3.checkNotNullParameter(str, "token");
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
                Intrinsics3.checkNotNullParameter(token, "token");
                return new Token(token);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Token) && Intrinsics3.areEqual(this.token, ((Token) other).token);
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
                return outline.J(outline.U("Token(token="), this.token, ")");
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return new TrackNetworkActionUserVerifyPhone();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelPhoneVerificationToken, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            invoke2(modelPhoneVerificationToken);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            Intrinsics3.checkNotNullParameter(modelPhoneVerificationToken, "it");
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

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Phone Verification", "response_error", CollectionsJVM.listOf(ModelAuditLogEntry.CHANGE_KEY_CODE));
            WidgetAuthPhoneVerify.this.getBinding().c.b();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((WidgetAuthPhoneVerify) this.receiver).evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthPhoneVerify widgetAuthPhoneVerify = WidgetAuthPhoneVerify.this;
            widgetAuthPhoneVerify.evaluateCode(widgetAuthPhoneVerify.getBinding().c.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetAuthPhoneVerify.this.tryPasteCodeFromClipboard();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetAuthPhoneVerify.this.evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass4(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "inputCode", "inputCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((WidgetAuthPhoneVerify) this.receiver).inputCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
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
        public final void invoke2(Void r1) {
            WidgetAuthPhoneVerify.this.getBinding().c.b();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
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
            WidgetAuthPhoneVerify.this.getBinding().c.b();
        }
    }

    public WidgetAuthPhoneVerify() {
        super(R.layout.widget_auth_phone_verify);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthPhoneVerify4.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthPhoneVerify3.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    private final void bailoutToEmail() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(2);
        }
        AppTransitionActivity.j = true;
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.overridePendingTransition(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_close_out);
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
            Intrinsics3.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(api.phoneVerificationsVerify(new RestAPIParams.VerificationCode(str, code)), AnonymousClass1.INSTANCE), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    private final WidgetAuthPhoneVerifyBinding getBinding() {
        return (WidgetAuthPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void inputCode(String code) {
        if (getView() != null) {
            getBinding().c.setOnCodeEntered(AnonymousClass1.INSTANCE);
            getBinding().c.setCode(code);
            getBinding().c.setOnCodeEntered(new AnonymousClass2(this));
            Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        }
    }

    private final void resendCode() {
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.phoneVerificationsResend(new RestAPIParams.VerificationCodeResend(str)), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                Intrinsics3.checkNotNullExpressionValue(charSequenceCoerceToText, "clipData.getItemAt(0).coerceToText(context)");
                String strReplace = new Regex(" ").replace(charSequenceCoerceToText, "");
                if (strReplace.length() == 6 && TextUtils.isDigitsOnly(strReplace)) {
                    inputCode(strReplace);
                }
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Intrinsics3.checkNotNullParameter(menu, "menu");
        Intrinsics3.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R.menu.menu_code_verification, menu);
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
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.a);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(Unit)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(scalarSynchronousObservable, this, null, 2, null), (Class<?>) WidgetAuthPhoneVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
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
        Intrinsics3.checkNotNullExpressionValue(charSequenceExtra, "mostRecentIntent.getChar…INTENT_EXTRA_TITLE) ?: \"\"");
        CharSequence charSequenceExtra2 = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_SUBTITLE);
        if (charSequenceExtra2 == null) {
            charSequenceExtra2 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(charSequenceExtra2, "mostRecentIntent.getChar…ENT_EXTRA_SUBTITLE) ?: \"\"");
        if (!Intrinsics3.areEqual(charSequenceExtra, "")) {
            TextView textView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.authPhoneVerifyTitle");
            textView.setText(charSequenceExtra);
        }
        if (!Intrinsics3.areEqual(charSequenceExtra2, "")) {
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.authPhoneVerifySubtitle");
            textView2.setText(charSequenceExtra2);
        }
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthPhoneVerify.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthPhoneVerify.this.resendCode();
            }
        });
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-06_reg_bailout_to_email_android", true);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            TextView textView3 = getBinding().f2235b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.authPhoneBailout");
            textView3.setVisibility(0);
            getBinding().f2235b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthPhoneVerify.onViewBound.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetAuthPhoneVerify.this.bailoutToEmail();
                }
            });
        }
        getBinding().c.setOnCodeEntered(new AnonymousClass3());
        registerForContextMenu(getBinding().c);
        SmsListener.INSTANCE.startSmsListener(new AnonymousClass4(this));
    }
}
