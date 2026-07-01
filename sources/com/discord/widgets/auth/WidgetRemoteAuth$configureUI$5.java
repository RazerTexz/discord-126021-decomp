package com.discord.widgets.auth;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth$configureUI$5 implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ WidgetRemoteAuth this$0;

    public WidgetRemoteAuth$configureUI$5(WidgetRemoteAuth widgetRemoteAuth) {
        this.this$0 = widgetRemoteAuth;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetRemoteAuth.access$getViewModel$p(this.this$0).toggleTemporary(!z2);
    }
}
