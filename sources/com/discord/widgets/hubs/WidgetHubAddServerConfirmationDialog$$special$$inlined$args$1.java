package com.discord.widgets.hubs;

import android.os.Bundle;
import b.d.b.a.outline;
import com.discord.app.AppDialog;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1 extends Lambda implements Function0<WidgetHubAddServerConfirmationDialog2> {
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
    public final WidgetHubAddServerConfirmationDialog2 invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetHubAddServerConfirmationDialog2 widgetHubAddServerConfirmationDialog2 = (WidgetHubAddServerConfirmationDialog2) (obj instanceof WidgetHubAddServerConfirmationDialog2 ? obj : null);
        if (widgetHubAddServerConfirmationDialog2 != null) {
            return widgetHubAddServerConfirmationDialog2;
        }
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(WidgetHubAddServerConfirmationDialog2.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }
}
