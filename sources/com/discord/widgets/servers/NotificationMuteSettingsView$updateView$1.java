package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NotificationMuteSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationMuteSettingsView$updateView$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $isMuted;
    public final /* synthetic */ Function0 $onMute;
    public final /* synthetic */ Function0 $onUnmute;

    public NotificationMuteSettingsView$updateView$1(boolean z2, Function0 function0, Function0 function1) {
        this.$isMuted = z2;
        this.$onUnmute = function0;
        this.$onMute = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$isMuted) {
            this.$onUnmute.invoke();
        } else {
            this.$onMute.invoke();
        }
    }
}
