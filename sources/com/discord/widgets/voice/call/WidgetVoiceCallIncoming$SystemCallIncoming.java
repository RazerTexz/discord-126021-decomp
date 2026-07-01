package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.discord.app.AppActivity;
import com.discord.app.DiscordConnectService;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming$SystemCallIncoming extends WidgetVoiceCallIncoming {
    private AtomicLong cachedChannelId = new AtomicLong(0);

    @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
    public void configureUI(WidgetVoiceCallIncoming$Model model) {
        if ((model != null ? Long.valueOf(model.getChannelId()) : null) != null) {
            this.cachedChannelId.set(model.getChannelId());
        }
        super.configureUI(model);
    }

    @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
    public void onConnect(WidgetVoiceCallIncoming$Model model, boolean useVideo) {
        m.checkNotNullParameter(model, "model");
        NotificationClient.clear$default(NotificationClient.INSTANCE, model.getChannelId(), requireContext(), false, 4, null);
        DiscordConnectService.j.b(requireContext(), model.getChannelId());
        WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, requireContext(), model.getChannelId(), false, null, null, 28, null);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
    public void onDecline(long channelId) {
        super.onDecline(channelId);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
    public void onEmptyCallModel() {
        long j = this.cachedChannelId.get();
        if (j == 0) {
            return;
        }
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
        NotificationClient.clear$default(NotificationClient.INSTANCE, j, requireContext(), false, 4, null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Observable<Long> observableD0 = Observable.d0(15L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable.timer(15, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetVoiceCallIncoming$SystemCallIncoming.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceCallIncoming$SystemCallIncoming$onViewCreated$1(this), 62, (Object) null);
    }
}
