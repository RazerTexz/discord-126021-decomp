package com.discord.widgets.channels.settings;

import com.discord.utilities.icon.IconUtils;
import com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$ViewState$Valid$isDefaultPhoto$2, reason: use source file name */
/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel3 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ ChannelGroupDMSettingsViewModel.ViewState.Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel3(ChannelGroupDMSettingsViewModel.ViewState.Valid valid) {
        super(0);
        this.this$0 = valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.getEditedIconUrl() == null || Intrinsics3.areEqual(this.this$0.getEditedIconUrl(), IconUtils.INSTANCE.getDefaultForGroupDM(this.this$0.getChannelSettings().getChannel().getId()));
    }
}
