package com.discord.widgets.guilds.join;

import android.os.Bundle;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.widgets.tabs.WidgetTabsHost;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet$Companion {
    private WidgetGuildJoinCaptchaBottomSheet$Companion() {
    }

    public final void enqueue(String requestKey, Function2<? super AppFragment, ? super CaptchaHelper$CaptchaPayload, Unit> onCaptchaPayloadReceived, CaptchaErrorBody error) {
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("guild captcha notice", null, 0L, 0, false, d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetTabsHost.class)), 0L, false, 0L, new WidgetGuildJoinCaptchaBottomSheet$Companion$enqueue$guildCaptchaNotice$1(requestKey, error, onCaptchaPayloadReceived), 150, null));
    }

    public final void registerForResult(AppFragment fragment, String requestKey, Function2<? super AppFragment, ? super CaptchaHelper$CaptchaPayload, Unit> onCaptchaPayloadReceived) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetGuildJoinCaptchaBottomSheet$Companion$registerForResult$1(requestKey, onCaptchaPayloadReceived, fragment));
    }

    public final void show(FragmentManager fragmentManager, String requestKey, CaptchaErrorBody error) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet = new WidgetGuildJoinCaptchaBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY", error);
        bundle.putString("INTENT_EXTRA_REQUEST_CODE", requestKey);
        widgetGuildJoinCaptchaBottomSheet.setArguments(bundle);
        widgetGuildJoinCaptchaBottomSheet.show(fragmentManager, WidgetGuildJoinCaptchaBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildJoinCaptchaBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
