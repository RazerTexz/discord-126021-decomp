package com.discord.widgets.guilds;

import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel$saveFolder$1 extends o implements Function1<ModelUserSettings, Unit> {
    public final /* synthetic */ WidgetGuildFolderSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettingsViewModel$saveFolder$1(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        super(1);
        this.this$0 = widgetGuildFolderSettingsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
        invoke2(modelUserSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserSettings modelUserSettings) {
        m.checkNotNullParameter(modelUserSettings, "it");
        WidgetGuildFolderSettingsViewModel.access$emitUpdateSuccessEvent(this.this$0);
    }
}
