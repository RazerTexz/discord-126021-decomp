package com.discord.widgets.servers;

import com.discord.models.domain.ModelBan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$configureUI$1 extends o implements Function1<ModelBan, Unit> {
    public final /* synthetic */ WidgetServerSettingsBans$Model $model;
    public final /* synthetic */ WidgetServerSettingsBans this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsBans$configureUI$1(WidgetServerSettingsBans widgetServerSettingsBans, WidgetServerSettingsBans$Model widgetServerSettingsBans$Model) {
        super(1);
        this.this$0 = widgetServerSettingsBans;
        this.$model = widgetServerSettingsBans$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
        invoke2(modelBan);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelBan modelBan) {
        m.checkNotNullParameter(modelBan, "ban");
        WidgetServerSettingsBans.access$showConfirmUnbanDialog(this.this$0, this.$model.getGuildId(), modelBan);
    }
}
