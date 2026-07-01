package com.discord.widgets.channels;

import android.os.Bundle;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$Companion$registerForResult$1 extends o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ boolean $allowNullChannel;
    public final /* synthetic */ Function2 $onChannelSelected;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSelector$Companion$registerForResult$1(String str, boolean z2, Function2 function2) {
        super(2);
        this.$requestKey = str;
        this.$allowNullChannel = z2;
        this.$onChannelSelected = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        m.checkNotNullParameter(str, "resultRequestKey");
        m.checkNotNullParameter(bundle, "bundle");
        if (m.areEqual(this.$requestKey, str)) {
            long j = bundle.getLong("INTENT_EXTRA_CHANNEL_ID", -1L);
            String string = bundle.getString("INTENT_EXTRA_CHANNEL_NAME", "");
            if (this.$allowNullChannel || j > 0) {
                Function2 function2 = this.$onChannelSelected;
                Long lValueOf = Long.valueOf(j);
                m.checkNotNullExpressionValue(string, "channelName");
                function2.invoke(lValueOf, string);
            }
        }
    }
}
