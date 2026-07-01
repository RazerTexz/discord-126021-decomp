package com.discord.widgets.nux;

import b.a.k.b;
import com.discord.api.channel.Channel;
import com.discord.restapi.RestAPIParams$CreateGuildChannel;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$handleSubmit$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetNuxChannelPrompt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNuxChannelPrompt$handleSubmit$1(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        super(1);
        this.this$0 = widgetNuxChannelPrompt;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        if (channel == null) {
            WidgetNuxChannelPrompt.access$getBinding$p(this.this$0).f2504b.setIsLoading(false);
            return;
        }
        TextInputLayout textInputLayout = WidgetNuxChannelPrompt.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.Companion.getApi().createGuildChannel(this.$guildId, new RestAPIParams$CreateGuildChannel(0, null, textOrEmpty, Long.valueOf(channel.getParentId()), null, b.k(this.this$0, 2131893408, new Object[]{textOrEmpty}, null, 4).toString())), new WidgetNuxChannelPrompt$handleSubmit$1$1(this)), false, 1, null), this.this$0, null, 2, null).k(b.a.d.o.a.g(this.this$0.requireContext(), new WidgetNuxChannelPrompt$handleSubmit$1$2(this), new WidgetNuxChannelPrompt$handleSubmit$1$3(this)));
    }
}
