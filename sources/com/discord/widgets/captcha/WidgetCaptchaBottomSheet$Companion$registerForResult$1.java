package com.discord.widgets.captcha;

import android.os.Bundle;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet$Companion$registerForResult$1 extends AbstractC12240o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ AppFragment $fragment;
    public final /* synthetic */ Function2 $onCaptchaPayloadReceived;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptchaBottomSheet$Companion$registerForResult$1(String str, Function2 function2, AppFragment appFragment) {
        super(2);
        this.$requestKey = str;
        this.$onCaptchaPayloadReceived = function2;
        this.$fragment = appFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        C12238m.checkNotNullParameter(str, "resultRequestKey");
        C12238m.checkNotNullParameter(bundle, "bundle");
        if (C12238m.areEqual(this.$requestKey, str)) {
            String string = bundle.getString("INTENT_EXTRA_CAPTCHA_TOKEN", "");
            String string2 = bundle.getString("INTENT_EXTRA_CAPTCHA_RQTOKEN", "");
            if (string == null || !(!C12238m.areEqual(string, ""))) {
                return;
            }
            this.$onCaptchaPayloadReceived.invoke(this.$fragment, new CaptchaHelper.CaptchaPayload(string, string2));
        }
    }
}
