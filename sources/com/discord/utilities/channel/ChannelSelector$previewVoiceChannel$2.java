package com.discord.utilities.channel;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$previewVoiceChannel$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WeakReference $fragmentManagerRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$previewVoiceChannel$2(WeakReference weakReference, long j) {
        super(1);
        this.$fragmentManagerRef = weakReference;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        FragmentManager fragmentManager = (FragmentManager) this.$fragmentManagerRef.get();
        if (fragmentManager != null) {
            m.checkNotNullExpressionValue(fragmentManager, "fragmentManagerRef.get() ?: return@appSubscribe");
            StoreStream.Companion.getGuildSelected().set(channel.getGuildId());
            WidgetVoiceBottomSheet.Companion.show(fragmentManager, this.$channelId, true, WidgetVoiceBottomSheet$FeatureContext.HOME);
        }
    }
}
