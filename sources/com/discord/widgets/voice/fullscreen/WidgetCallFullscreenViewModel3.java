package com.discord.widgets.voice.fullscreen;

import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import d0.z.d.Lambda;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$ViewState$Valid$menuItems$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel3 extends Lambda implements Function0<Set<? extends WidgetCallFullscreenViewModel.MenuItem>> {
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel3(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        super(0);
        this.this$0 = valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Set<? extends WidgetCallFullscreenViewModel.MenuItem> invoke() {
        WidgetCallFullscreenViewModel.ViewState.Valid valid = this.this$0;
        return valid.computeMenuItems(PermissionUtils.can(16L, valid.getCallModel().getChannelPermissions()), this.this$0.getCallModel().isConnected(), ChannelUtils.D(this.this$0.getCallModel().getChannel()), this.this$0.getCallModel().getSelectedVideoDevice(), this.this$0.getCallModel().getVideoDevices(), this.this$0.isTextInVoiceEnabled());
    }
}
