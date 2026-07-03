package com.discord.widgets.hubs;

import android.os.Bundle;
import android.os.Parcelable;
import com.discord.app.AppFragment;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist$$special$$inlined$args$1 extends AbstractC12240o implements Function0<HubWaitlistArgs> {
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
    public final HubWaitlistArgs invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        HubWaitlistArgs hubWaitlistArgs = (HubWaitlistArgs) (obj instanceof HubWaitlistArgs ? obj : null);
        HubWaitlistArgs hubWaitlistArgs2 = hubWaitlistArgs;
        if (hubWaitlistArgs == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (hubWaitlistArgs2 != 0) {
            hubWaitlistArgs2 = parcelableExtra;
            return hubWaitlistArgs2;
        }
        hubWaitlistArgs2 = parcelableExtra;
        StringBuilder sbM833U = C1643a.m833U("Missing args for class type ");
        C1643a.m862l0(HubWaitlistArgs.class, sbM833U, " + key ");
        throw new IllegalStateException(C1643a.m820H(sbM833U, this.$argsKey, '!'));
    }
}
