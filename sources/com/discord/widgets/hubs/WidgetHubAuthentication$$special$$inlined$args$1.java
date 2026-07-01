package com.discord.widgets.hubs;

import android.os.Bundle;
import android.os.Parcelable;
import b.d.b.a.a;
import com.discord.app.AppFragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication$$special$$inlined$args$1 extends o implements Function0<HubAuthenticationArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthentication$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final HubAuthenticationArgs invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        HubAuthenticationArgs hubAuthenticationArgs = (HubAuthenticationArgs) (obj instanceof HubAuthenticationArgs ? obj : null);
        HubAuthenticationArgs hubAuthenticationArgs2 = hubAuthenticationArgs;
        if (hubAuthenticationArgs == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (hubAuthenticationArgs2 != 0) {
            hubAuthenticationArgs2 = parcelableExtra;
            return hubAuthenticationArgs2;
        }
        hubAuthenticationArgs2 = parcelableExtra;
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(HubAuthenticationArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.hubs.HubAuthenticationArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HubAuthenticationArgs invoke() {
        return invoke();
    }
}
