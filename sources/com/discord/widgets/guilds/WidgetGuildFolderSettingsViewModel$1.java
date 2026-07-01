package com.discord.widgets.guilds;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel$1 extends o implements Function1<WidgetGuildFolderSettingsViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetGuildFolderSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettingsViewModel$1(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        super(1);
        this.this$0 = widgetGuildFolderSettingsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel$StoreState widgetGuildFolderSettingsViewModel$StoreState) {
        invoke2(widgetGuildFolderSettingsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildFolderSettingsViewModel$StoreState widgetGuildFolderSettingsViewModel$StoreState) {
        m.checkNotNullParameter(widgetGuildFolderSettingsViewModel$StoreState, "storeState");
        WidgetGuildFolderSettingsViewModel.access$handleStoreState(this.this$0, widgetGuildFolderSettingsViewModel$StoreState);
    }
}
