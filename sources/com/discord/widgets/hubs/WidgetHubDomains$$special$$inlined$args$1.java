package com.discord.widgets.hubs;

import android.os.Bundle;
import android.os.Parcelable;
import b.d.b.a.a;
import com.discord.app.AppFragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains$$special$$inlined$args$1 extends o implements Function0<HubDomainArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final HubDomainArgs invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        HubDomainArgs hubDomainArgs = (HubDomainArgs) (obj instanceof HubDomainArgs ? obj : null);
        HubDomainArgs hubDomainArgs2 = hubDomainArgs;
        if (hubDomainArgs == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (hubDomainArgs2 != 0) {
            hubDomainArgs2 = parcelableExtra;
            return hubDomainArgs2;
        }
        hubDomainArgs2 = parcelableExtra;
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(HubDomainArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.hubs.HubDomainArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HubDomainArgs invoke() {
        return invoke();
    }
}
