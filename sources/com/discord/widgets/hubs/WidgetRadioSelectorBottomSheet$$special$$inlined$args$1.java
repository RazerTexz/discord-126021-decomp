package com.discord.widgets.hubs;

import android.os.Bundle;
import b.d.b.a.outline;
import com.discord.app.AppBottomSheet;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet$$special$$inlined$args$1 extends Lambda implements Function0<WidgetRadioSelectorBottomSheet3> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppBottomSheet $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRadioSelectorBottomSheet$$special$$inlined$args$1(AppBottomSheet appBottomSheet, String str) {
        super(0);
        this.$this_args = appBottomSheet;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetRadioSelectorBottomSheet3 invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetRadioSelectorBottomSheet3 widgetRadioSelectorBottomSheet3 = (WidgetRadioSelectorBottomSheet3) (obj instanceof WidgetRadioSelectorBottomSheet3 ? obj : null);
        if (widgetRadioSelectorBottomSheet3 != null) {
            return widgetRadioSelectorBottomSheet3;
        }
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(WidgetRadioSelectorBottomSheet3.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }
}
