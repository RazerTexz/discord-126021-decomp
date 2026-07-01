package com.discord.widgets.hubs;

import android.os.Bundle;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.app.AppFragment;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist$$special$$inlined$args$1 extends Lambda implements Function0<WidgetHubWaitlistViewModel2> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlist$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubWaitlistViewModel2 invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetHubWaitlistViewModel2 widgetHubWaitlistViewModel2 = (WidgetHubWaitlistViewModel2) (obj instanceof WidgetHubWaitlistViewModel2 ? obj : null);
        WidgetHubWaitlistViewModel2 widgetHubWaitlistViewModel3 = widgetHubWaitlistViewModel2;
        if (widgetHubWaitlistViewModel2 == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (widgetHubWaitlistViewModel3 != 0) {
            widgetHubWaitlistViewModel3 = parcelableExtra;
            return widgetHubWaitlistViewModel3;
        }
        widgetHubWaitlistViewModel3 = parcelableExtra;
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(WidgetHubWaitlistViewModel2.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }
}
