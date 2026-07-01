package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$configureBottomContent$8 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    public WidgetVoiceBottomSheet$configureBottomContent$8(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requestVideoCallPermissions(new WidgetVoiceBottomSheet$configureBottomContent$8$1(this));
    }
}
