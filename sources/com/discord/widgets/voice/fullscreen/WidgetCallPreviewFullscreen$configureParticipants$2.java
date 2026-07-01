package com.discord.widgets.voice.fullscreen;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureParticipants$2 extends o implements Function1<StoreVoiceParticipants$VoiceUser, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$configureParticipants$2(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, Channel channel) {
        super(1);
        this.this$0 = widgetCallPreviewFullscreen;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        invoke2(storeVoiceParticipants$VoiceUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "clickedUser");
        WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
        long id2 = storeVoiceParticipants$VoiceUser.getUser().getId();
        Long lValueOf = Long.valueOf(this.$channel.getId());
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
    }
}
