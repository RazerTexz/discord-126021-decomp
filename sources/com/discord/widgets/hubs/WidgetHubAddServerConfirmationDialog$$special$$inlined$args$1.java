package com.discord.widgets.hubs;

import android.os.Bundle;
import b.d.b.a.a;
import com.discord.app.AppDialog;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1 extends o implements Function0<AddServerConfirmationArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppDialog $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1(AppDialog appDialog, String str) {
        super(0);
        this.$this_args = appDialog;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AddServerConfirmationArgs invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        AddServerConfirmationArgs addServerConfirmationArgs = (AddServerConfirmationArgs) (obj instanceof AddServerConfirmationArgs ? obj : null);
        if (addServerConfirmationArgs != null) {
            return addServerConfirmationArgs;
        }
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(AddServerConfirmationArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.hubs.AddServerConfirmationArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AddServerConfirmationArgs invoke() {
        return invoke();
    }
}
