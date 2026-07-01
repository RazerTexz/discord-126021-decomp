package com.discord.widgets.captcha;

import android.os.Bundle;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet$Companion {
    private WidgetCaptchaBottomSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void enqueue$default(WidgetCaptchaBottomSheet$Companion widgetCaptchaBottomSheet$Companion, String str, Function2 function2, Function0 function0, CaptchaErrorBody captchaErrorBody, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        widgetCaptchaBottomSheet$Companion.enqueue(str, function2, function0, captchaErrorBody);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(WidgetCaptchaBottomSheet$Companion widgetCaptchaBottomSheet$Companion, FragmentManager fragmentManager, String str, CaptchaErrorBody captchaErrorBody, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = null;
        }
        widgetCaptchaBottomSheet$Companion.show(fragmentManager, str, captchaErrorBody, function0);
    }

    public final void enqueue(String requestKey, Function2<? super AppFragment, ? super CaptchaHelper$CaptchaPayload, Unit> onCaptchaPayloadReceived, Function0<Unit> onCaptchaAttemptFailed, CaptchaErrorBody error) {
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("captcha notice", null, 0L, 0, false, WidgetCaptchaBottomSheet.access$getResolvableFragments$cp(), 0L, false, 0L, new WidgetCaptchaBottomSheet$Companion$enqueue$captchaNotice$1(requestKey, error, onCaptchaAttemptFailed, onCaptchaPayloadReceived), 150, null));
    }

    public final void registerForResult(AppFragment fragment, String requestKey, Function2<? super AppFragment, ? super CaptchaHelper$CaptchaPayload, Unit> onCaptchaPayloadReceived) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetCaptchaBottomSheet$Companion$registerForResult$1(requestKey, onCaptchaPayloadReceived, fragment));
    }

    public final void show(FragmentManager fragmentManager, String requestKey, CaptchaErrorBody error, Function0<Unit> onCaptchaAttemptFailed) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetCaptchaBottomSheet widgetCaptchaBottomSheet = new WidgetCaptchaBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY", error);
        bundle.putString("INTENT_EXTRA_REQUEST_CODE", requestKey);
        widgetCaptchaBottomSheet.setArguments(bundle);
        WidgetCaptchaBottomSheet.access$setOnCaptchaAttemptFailed$p(widgetCaptchaBottomSheet, onCaptchaAttemptFailed);
        widgetCaptchaBottomSheet.show(fragmentManager, WidgetCaptchaBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetCaptchaBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
