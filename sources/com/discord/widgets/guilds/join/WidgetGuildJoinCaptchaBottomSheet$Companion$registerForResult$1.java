package com.discord.widgets.guilds.join;

import android.os.Bundle;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet$Companion$registerForResult$1 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ AppFragment $fragment;
    public final /* synthetic */ Function2 $onCaptchaPayloadReceived;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildJoinCaptchaBottomSheet$Companion$registerForResult$1(String str, Function2 function2, AppFragment appFragment) {
        super(2);
        this.$requestKey = str;
        this.$onCaptchaPayloadReceived = function2;
        this.$fragment = appFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(str, "resultRequestKey");
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics3.areEqual(this.$requestKey, str)) {
            String string = bundle.getString("INTENT_EXTRA_CAPTCHA_TOKEN", "");
            String string2 = bundle.getString("INTENT_EXTRA_CAPTCHA_RQTOKEN", "");
            if (string == null || !(!Intrinsics3.areEqual(string, ""))) {
                return;
            }
            this.$onCaptchaPayloadReceived.invoke(this.$fragment, new CaptchaHelper.CaptchaPayload(string, string2));
        }
    }
}
