package com.discord.widgets.guilds.join;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildJoinCaptchaBottomSheetBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String NOTICE_NAME = "guild captcha notice";
    private static final String RESULT_EXTRA_CAPTCHA_RQTOKEN = "INTENT_EXTRA_CAPTCHA_RQTOKEN";
    private static final String RESULT_EXTRA_CAPTCHA_TOKEN = "INTENT_EXTRA_CAPTCHA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: captchaErrorBody$delegate, reason: from kotlin metadata */
    private final Lazy captchaErrorBody;

    /* JADX INFO: renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildJoinCaptchaBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived, CaptchaErrorBody error) {
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            C12238m.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetGuildJoinCaptchaBottomSheet.NOTICE_NAME, null, 0L, 0, false, C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetTabsHost.class)), 0L, false, 0L, new C8719xce82ae71(requestKey, error, onCaptchaPayloadReceived), 150, null));
        }

        public final void registerForResult(AppFragment fragment, String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            C12238m.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetGuildJoinCaptchaBottomSheet$Companion$registerForResult$1(requestKey, onCaptchaPayloadReceived, fragment));
        }

        public final void show(FragmentManager fragmentManager, String requestKey, CaptchaErrorBody error) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet = new WidgetGuildJoinCaptchaBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY", error);
            bundle.putString(WidgetGuildJoinCaptchaBottomSheet.ARG_REQUEST_KEY, requestKey);
            widgetGuildJoinCaptchaBottomSheet.setArguments(bundle);
            widgetGuildJoinCaptchaBottomSheet.show(fragmentManager, WidgetGuildJoinCaptchaBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet$openCaptcha$1 */
    /* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
    public static final class C87211 extends AbstractC12240o implements Function1<String, Unit> {
        public C87211() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            CaptchaHelper.INSTANCE.setCaptchaToken(str);
            AppActivity appActivity = WidgetGuildJoinCaptchaBottomSheet.this.getAppActivity();
            if (appActivity != null) {
                WidgetGuildJoinCaptchaBottomSheet.this.finishIfCaptchaTokenReceived(appActivity);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet$openCaptcha$2 */
    /* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
    public static final class C87222 extends AbstractC12240o implements Function1<Error, Unit> {
        public C87222() {
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
            Throwable throwable = error.getThrowable();
            if (!(throwable instanceof CaptchaHelper.Failure)) {
                throwable = null;
            }
            CaptchaHelper.Failure failure = (CaptchaHelper.Failure) throwable;
            if (failure != null) {
                C0876m.m169g(WidgetGuildJoinCaptchaBottomSheet.this.getAppActivity(), failure.getErrorStringId(), 0, null, 12);
            }
        }
    }

    public WidgetGuildJoinCaptchaBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildJoinCaptchaBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.requestCode = C12083g.lazy(new WidgetGuildJoinCaptchaBottomSheet$requestCode$2(this));
        this.captchaErrorBody = C12083g.lazy(new WidgetGuildJoinCaptchaBottomSheet$captchaErrorBody$2(this));
    }

    private final void configureUI() {
        TextView textView = getBinding().f16857d;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildJoinCaptchaTitle");
        C1107b.m221m(textView, C5419R.string.guild_join_captcha_header, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = getBinding().f16855b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildJoinCaptchaBody");
        C1107b.m221m(textView2, C5419R.string.guild_join_captcha_description, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        MaterialButton materialButton = getBinding().f16856c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildJoinCaptchaButton");
        C1107b.m221m(materialButton, C5419R.string.confirm, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f16856c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildJoinCaptchaBottomSheet.this.openCaptcha();
            }
        });
    }

    private final void finishIfCaptchaTokenReceived(Activity activity) {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        String captchaToken = captchaHelper.getCaptchaToken();
        if (captchaToken != null) {
            String captchaRqtoken = captchaHelper.getCaptchaRqtoken();
            captchaHelper.setCaptchaToken(null);
            captchaHelper.setCaptchaRqtoken(null);
            String requestCode = getRequestCode();
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_EXTRA_CAPTCHA_TOKEN, captchaToken);
            bundle.putString(RESULT_EXTRA_CAPTCHA_RQTOKEN, captchaRqtoken);
            FragmentKt.setFragmentResult(this, requestCode, bundle);
            dismiss();
        }
    }

    private final WidgetGuildJoinCaptchaBottomSheetBinding getBinding() {
        return (WidgetGuildJoinCaptchaBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CaptchaErrorBody getCaptchaErrorBody() {
        return (CaptchaErrorBody) this.captchaErrorBody.getValue();
    }

    private final String getRequestCode() {
        return (String) this.requestCode.getValue();
    }

    private final void openCaptcha() {
        CaptchaHelper.CaptchaRequest reCaptcha;
        String captchaSitekey = getCaptchaErrorBody().getCaptchaSitekey();
        CaptchaService captchaService = getCaptchaErrorBody().getCaptchaService();
        String captchaRqdata = getCaptchaErrorBody().getCaptchaRqdata();
        String captchaRqtoken = getCaptchaErrorBody().getCaptchaRqtoken();
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        captchaHelper.setCaptchaRqtoken(captchaRqtoken);
        if (captchaSitekey == null || captchaService != CaptchaService.HCAPTCHA) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.ReCaptcha(fragmentActivityRequireActivity);
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.HCaptcha(captchaSitekey, fragmentActivityRequireActivity2, captchaRqdata);
        }
        ObservableExtensionsKt.appSubscribe(captchaHelper.tryShowCaptcha(reCaptcha), (Class<?>) WidgetGuildJoinCaptchaBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C87222()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87211());
    }

    public static final void show(FragmentManager fragmentManager, String str, CaptchaErrorBody captchaErrorBody) {
        INSTANCE.show(fragmentManager, str, captchaErrorBody);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_join_captcha_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }
}
