package com.discord.widgets.user.usersheet;

import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheetViewModelStoreState$observeStoreState$2 extends k implements Function4<User, MeUser, Channel, Channel, WidgetUserSheetViewModelStoreState$BootstrapData> {
    public static final WidgetUserSheetViewModelStoreState$observeStoreState$2 INSTANCE = new WidgetUserSheetViewModelStoreState$observeStoreState$2();

    public WidgetUserSheetViewModelStoreState$observeStoreState$2() {
        super(4, WidgetUserSheetViewModelStoreState$BootstrapData.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ WidgetUserSheetViewModelStoreState$BootstrapData invoke(User user, MeUser meUser, Channel channel, Channel channel2) {
        return invoke2(user, meUser, channel, channel2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserSheetViewModelStoreState$BootstrapData invoke2(User user, MeUser meUser, Channel channel, Channel channel2) {
        m.checkNotNullParameter(meUser, "p2");
        return new WidgetUserSheetViewModelStoreState$BootstrapData(user, meUser, channel, channel2);
    }
}
