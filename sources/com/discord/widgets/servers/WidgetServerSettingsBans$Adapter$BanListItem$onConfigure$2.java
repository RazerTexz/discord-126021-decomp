package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelBan;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Adapter$BanListItem$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsBans$Model$BanItem $data;
    public final /* synthetic */ WidgetServerSettingsBans$Adapter$BanListItem this$0;

    public WidgetServerSettingsBans$Adapter$BanListItem$onConfigure$2(WidgetServerSettingsBans$Adapter$BanListItem widgetServerSettingsBans$Adapter$BanListItem, WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem) {
        this.this$0 = widgetServerSettingsBans$Adapter$BanListItem;
        this.$data = widgetServerSettingsBans$Model$BanItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<ModelBan, Unit> onBanSelectedListener;
        ModelBan ban = this.$data.getBan();
        if (ban == null || (onBanSelectedListener = WidgetServerSettingsBans$Adapter$BanListItem.access$getAdapter$p(this.this$0).getOnBanSelectedListener()) == null) {
            return;
        }
        onBanSelectedListener.invoke(ban);
    }
}
