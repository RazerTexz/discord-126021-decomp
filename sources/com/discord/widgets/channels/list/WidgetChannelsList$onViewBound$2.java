package com.discord.widgets.channels.list;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$2(WidgetChannelsList widgetChannelsList) {
        super(1);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        int type = channel.getType();
        if (type != 0 && type != 1) {
            if (type == 2) {
                WidgetVoiceChannelSettings.Companion.launch(channel.getId(), this.this$0.requireContext());
                return;
            }
            if (type != 3 && type != 4 && type != 5 && type != 15) {
                switch (type) {
                    case 10:
                    case 11:
                    case 12:
                        WidgetChannelsListItemThreadActions$Companion widgetChannelsListItemThreadActions$Companion = WidgetChannelsListItemThreadActions.Companion;
                        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        widgetChannelsListItemThreadActions$Companion.show(parentFragmentManager, channel.getId());
                        break;
                }
            }
        }
        WidgetChannelsListItemChannelActions$Companion widgetChannelsListItemChannelActions$Companion = WidgetChannelsListItemChannelActions.Companion;
        FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        widgetChannelsListItemChannelActions$Companion.show(parentFragmentManager2, channel.getId());
    }
}
