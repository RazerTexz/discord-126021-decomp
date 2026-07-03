package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$Companion$registerForResult$1 */
/* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8840x74fb94df extends AbstractC12240o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function0 $onActionTaken;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8840x74fb94df(String str, Function0 function0) {
        super(2);
        this.$requestKey = str;
        this.$onActionTaken = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        C12238m.checkNotNullParameter(str, "resultRequestKey");
        C12238m.checkNotNullParameter(bundle, "<anonymous parameter 1>");
        if (C12238m.areEqual(this.$requestKey, str)) {
            this.$onActionTaken.invoke();
        }
    }
}
