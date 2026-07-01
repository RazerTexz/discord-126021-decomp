package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMentionNode$render$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ ChannelMentionNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMentionNode$render$1(ChannelMentionNode channelMentionNode, Function1 function1) {
        super(1);
        this.this$0 = channelMentionNode;
        this.$onClick = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        this.$onClick.invoke(Long.valueOf(this.this$0.getChannelId()));
    }
}
