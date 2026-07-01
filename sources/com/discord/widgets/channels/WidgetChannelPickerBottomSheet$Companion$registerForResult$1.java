package com.discord.widgets.channels;

import android.os.Bundle;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet$Companion$registerForResult$1 extends o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function3 $onChannelSelected;
    public final /* synthetic */ Function0 $onCreateChannelSelected;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet$Companion$registerForResult$1(String str, Function0 function0, Function3 function3) {
        super(2);
        this.$requestKey = str;
        this.$onCreateChannelSelected = function0;
        this.$onChannelSelected = function3;
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
            long j = bundle.getLong("RESULT_EXTRA_CHANNEL_ID", -1L);
            String string = bundle.getString("RESULT_EXTRA_CHANNEL_NAME", "");
            int i = bundle.getInt("RESULT_EXTRA_CHANNEL_ICON_RES_ID", -1);
            int iOrdinal = WidgetChannelPickerBottomSheet$SelectionType.Companion.fromInt(bundle.getInt("RESULT_EXTRA_SELECTION_TYPE", WidgetChannelPickerBottomSheet$SelectionType.UNKNOWN.ordinal())).ordinal();
            if (iOrdinal == 1) {
                this.$onCreateChannelSelected.invoke();
                return;
            }
            if (iOrdinal == 2 && j > 0) {
                Function3 function3 = this.$onChannelSelected;
                Long lValueOf = Long.valueOf(j);
                m.checkNotNullExpressionValue(string, "channelName");
                function3.invoke(lValueOf, string, Integer.valueOf(i));
            }
        }
    }
}
