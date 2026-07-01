package com.discord.widgets.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCaptchaBinding;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetCaptcha extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCaptcha.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCaptchaBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CAPTCHA_ERROR_BODY = "EXTRA_CAPTCHA_ERROR_BODY";
    private static final String RESULT_EXTRA_RQTOKEN = "RESULT_EXTRA_RQTOKEN";
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetCaptcha.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, CaptchaErrorBody captchaErrorBody) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetCaptcha.EXTRA_CAPTCHA_ERROR_BODY, captchaErrorBody);
            AppScreen2.g.f(context, launcher, WidgetCaptcha.class, intent);
        }

        public final void processErrorsForCaptcha(Context context, ActivityResultLauncher<Intent> launcher, List<String> unhandledErrors, Error error) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(unhandledErrors, "unhandledErrors");
            Intrinsics3.checkNotNullParameter(error, "error");
            if (unhandledErrors.remove(CaptchaHelper.CAPTCHA_KEY)) {
                launch(context, launcher, CaptchaErrorBody.INSTANCE.createFromError(error));
                error.setShowErrorToasts(false);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function1<? super CaptchaHelper.CaptchaPayload, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.captcha.WidgetCaptcha$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        Intent data = activityResult.getData();
                        String stringExtra = data != null ? data.getStringExtra("RESULT_EXTRA_TOKEN") : null;
                        Intent data2 = activityResult.getData();
                        String stringExtra2 = data2 != null ? data2.getStringExtra("RESULT_EXTRA_RQTOKEN") : null;
                        if (stringExtra != null) {
                            callback.invoke(new CaptchaHelper.CaptchaPayload(stringExtra, stringExtra2));
                        }
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetCaptcha() {
        super(R.layout.widget_captcha);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCaptcha3.INSTANCE, null, 2, null);
    }

    private final void finishIfCaptchaTokenReceived(Activity activity) {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        String captchaToken = captchaHelper.getCaptchaToken();
        if (captchaToken != null) {
            String captchaRqtoken = captchaHelper.getCaptchaRqtoken();
            captchaHelper.setCaptchaToken(null);
            captchaHelper.setCaptchaRqtoken(null);
            trackTransition$default(this, "submitted", null, 2, null);
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_TOKEN, captchaToken);
            intent.putExtra(RESULT_EXTRA_RQTOKEN, captchaRqtoken);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private final WidgetCaptchaBinding getBinding() {
        return (WidgetCaptchaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackTransition$default(WidgetCaptcha widgetCaptcha, String str, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackTransition");
        }
        if ((i & 2) != 0) {
            list = null;
        }
        widgetCaptcha.trackTransition(str, list);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        finishIfCaptchaTokenReceived(requireAppActivity());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        final CaptchaHelper.CaptchaRequest reCaptcha;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(EXTRA_CAPTCHA_ERROR_BODY);
        if (!(serializableExtra instanceof CaptchaErrorBody)) {
            serializableExtra = null;
        }
        CaptchaErrorBody captchaErrorBody = (CaptchaErrorBody) serializableExtra;
        String captchaSitekey = captchaErrorBody != null ? captchaErrorBody.getCaptchaSitekey() : null;
        CaptchaService captchaService = captchaErrorBody != null ? captchaErrorBody.getCaptchaService() : null;
        String captchaRqdata = captchaErrorBody != null ? captchaErrorBody.getCaptchaRqdata() : null;
        CaptchaHelper.INSTANCE.setCaptchaRqtoken(captchaErrorBody != null ? captchaErrorBody.getCaptchaRqtoken() : null);
        if (captchaSitekey == null || captchaService != CaptchaService.HCAPTCHA) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.ReCaptcha(fragmentActivityRequireActivity);
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.HCaptcha(captchaSitekey, fragmentActivityRequireActivity2, captchaRqdata);
        }
        String string = reCaptcha instanceof CaptchaHelper.CaptchaRequest.HCaptcha ? getString(R.string.verify_by_hcaptcha) : getString(R.string.verify_by_recaptcha);
        Intrinsics3.checkNotNullExpressionValue(string, "when (captchaRequest) {\n…erify_by_recaptcha)\n    }");
        getBinding().d.setTitle(string);
        trackTransition$default(this, "viewed", null, 2, null);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.captcha.WidgetCaptcha.onViewBound.1

            /* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetCaptcha.kt */
            public static final class C02391 extends Lambda implements Function1<String, Unit> {
                public C02391() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    CaptchaHelper.INSTANCE.setCaptchaToken(str);
                    AppActivity appActivity = WidgetCaptcha.this.getAppActivity();
                    if (appActivity != null) {
                        WidgetCaptcha.this.finishIfCaptchaTokenReceived(appActivity);
                    }
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetCaptcha.kt */
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
                    WidgetCaptcha.trackTransition$default(WidgetCaptcha.this, "submitted", null, 2, null);
                    WidgetCaptcha.this.trackTransition("response_error", CollectionsJVM.listOf("captcha"));
                    Throwable throwable = error.getThrowable();
                    if (!(throwable instanceof CaptchaHelper.Failure)) {
                        throwable = null;
                    }
                    CaptchaHelper.Failure failure = (CaptchaHelper.Failure) throwable;
                    if (failure != null) {
                        AppToast.g(WidgetCaptcha.this.getAppActivity(), failure.getErrorStringId(), 0, null, 12);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ObservableExtensionsKt.appSubscribe(CaptchaHelper.INSTANCE.tryShowCaptcha(reCaptcha), (Class<?>) WidgetCaptcha.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C02391());
            }
        });
        getBinding().f2250b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.captcha.WidgetCaptcha.onViewBound.2

            /* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetCaptcha.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FragmentActivity fragmentActivityE = WidgetCaptcha.this.e();
                    if (fragmentActivityE != null) {
                        fragmentActivityE.finish();
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptchaHelper.INSTANCE.showCaptchaHelpDialog(WidgetCaptcha.this.getAppActivity(), new AnonymousClass1());
            }
        });
    }

    public void trackTransition(String action, List<String> details) {
        Intrinsics3.checkNotNullParameter(action, "action");
    }
}
