package com.discord.widgets.voice.fullscreen;

import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$ViewState$Valid$menuItems$2 extends o implements Function0<Set<? extends WidgetCallFullscreenViewModel$MenuItem>> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$ViewState$Valid$menuItems$2(WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        super(0);
        this.this$0 = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends WidgetCallFullscreenViewModel$MenuItem> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends WidgetCallFullscreenViewModel$MenuItem> invoke2() {
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = this.this$0;
        return WidgetCallFullscreenViewModel$ViewState$Valid.access$computeMenuItems(widgetCallFullscreenViewModel$ViewState$Valid, PermissionUtils.can(16L, widgetCallFullscreenViewModel$ViewState$Valid.getCallModel().getChannelPermissions()), this.this$0.getCallModel().isConnected(), ChannelUtils.D(this.this$0.getCallModel().getChannel()), this.this$0.getCallModel().getSelectedVideoDevice(), this.this$0.getCallModel().getVideoDevices(), this.this$0.isTextInVoiceEnabled());
    }
}
