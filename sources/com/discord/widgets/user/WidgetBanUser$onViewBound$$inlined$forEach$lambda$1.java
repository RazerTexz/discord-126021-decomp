package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;

/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBanUser$onViewBound$$inlined$forEach$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ CheckedSetting $radio;
    public final /* synthetic */ WidgetBanUser this$0;

    public WidgetBanUser$onViewBound$$inlined$forEach$lambda$1(CheckedSetting checkedSetting, WidgetBanUser widgetBanUser) {
        this.$radio = checkedSetting;
        this.this$0 = widgetBanUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RadioManager radioManagerAccess$getDeleteHistoryRadioManager$p = WidgetBanUser.access$getDeleteHistoryRadioManager$p(this.this$0);
        if (radioManagerAccess$getDeleteHistoryRadioManager$p != null) {
            radioManagerAccess$getDeleteHistoryRadioManager$p.a(this.$radio);
        }
    }
}
