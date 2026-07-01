package com.discord.app;

import com.discord.widgets.voice.call.WidgetVoiceCallIncoming$SystemCallIncoming;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$IncomingCall extends AppActivity {

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final Class<? extends AppComponent> screen = WidgetVoiceCallIncoming$SystemCallIncoming.class;

    @Override // com.discord.app.AppActivity
    public Class<? extends AppComponent> d() {
        return this.screen;
    }
}
