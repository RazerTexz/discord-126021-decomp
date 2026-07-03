package com.discord.widgets.forums;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet$Companion$registerForResult$1 extends AbstractC12240o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function2 $onActionTaken;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumGuidelinesBottomSheet$Companion$registerForResult$1(String str, Function2 function2) {
        super(2);
        this.$requestKey = str;
        this.$onActionTaken = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        C12238m.checkNotNullParameter(str, "resultRequestKey");
        C12238m.checkNotNullParameter(bundle, "bundle");
        if (C12238m.areEqual(this.$requestKey, str)) {
            this.$onActionTaken.invoke(Long.valueOf(bundle.getLong("com.discord.intent.extra.EXTRA_GUILD_ID", 0L)), Long.valueOf(bundle.getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L)));
        }
    }
}
