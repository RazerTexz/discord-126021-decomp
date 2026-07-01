package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$configureUI$9<T> implements Action1<Boolean> {
    public static final WidgetSettingsVoice$configureUI$9 INSTANCE = new WidgetSettingsVoice$configureUI$9();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreStream.Companion.getMediaSettings().toggleEnableVideoHardwareScaling();
    }
}
