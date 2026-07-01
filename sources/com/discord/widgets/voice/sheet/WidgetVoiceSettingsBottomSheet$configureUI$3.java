package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet$configureUI$3(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetStageStartEventBottomSheet$Companion widgetStageStartEventBottomSheet$Companion = WidgetStageStartEventBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetStageStartEventBottomSheet$Companion.show$default(widgetStageStartEventBottomSheet$Companion, parentFragmentManager, WidgetVoiceSettingsBottomSheet.access$getChannelId$p(this.this$0), null, 4, null);
    }
}
