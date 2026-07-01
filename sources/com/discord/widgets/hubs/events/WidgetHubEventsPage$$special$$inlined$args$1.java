package com.discord.widgets.hubs.events;

import android.os.Bundle;
import b.d.b.a.a;
import com.discord.app.AppBottomSheet;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$$special$$inlined$args$1 extends o implements Function0<HubEventsArgs> {
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
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(HubEventsArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.hubs.events.HubEventsArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HubEventsArgs invoke() {
        return invoke();
    }
}
