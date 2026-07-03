package com.discord.widgets.hubs.events;

import android.os.Bundle;
import com.discord.app.AppBottomSheet;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$$special$$inlined$args$1 extends AbstractC12240o implements Function0<HubEventsArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppBottomSheet $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage$$special$$inlined$args$1(AppBottomSheet appBottomSheet, String str) {
        super(0);
        this.$this_args = appBottomSheet;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final HubEventsArgs invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        HubEventsArgs hubEventsArgs = (HubEventsArgs) (obj instanceof HubEventsArgs ? obj : null);
        if (hubEventsArgs != null) {
            return hubEventsArgs;
        }
        StringBuilder sbM833U = C1643a.m833U("Missing args for class type ");
        C1643a.m862l0(HubEventsArgs.class, sbM833U, " + key ");
        throw new IllegalStateException(C1643a.m820H(sbM833U, this.$argsKey, '!'));
    }
}
