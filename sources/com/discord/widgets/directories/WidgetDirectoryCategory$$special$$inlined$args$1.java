package com.discord.widgets.directories;

import android.os.Bundle;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.app.AppFragment;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryCategory$$special$$inlined$args$1 extends Lambda implements Function0<WidgetDirectoryCategory2> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryCategory$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetDirectoryCategory2 invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetDirectoryCategory2 widgetDirectoryCategory2 = (WidgetDirectoryCategory2) (obj instanceof WidgetDirectoryCategory2 ? obj : null);
        WidgetDirectoryCategory2 widgetDirectoryCategory3 = widgetDirectoryCategory2;
        if (widgetDirectoryCategory2 == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (widgetDirectoryCategory3 != 0) {
            widgetDirectoryCategory3 = parcelableExtra;
            return widgetDirectoryCategory3;
        }
        widgetDirectoryCategory3 = parcelableExtra;
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(WidgetDirectoryCategory2.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }
}
