package com.discord.widgets.botuikit;

import android.os.Bundle;
import android.os.Parcelable;
import com.discord.app.AppFragment;
import com.discord.widgets.botuikit.ModalComponent;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$$special$$inlined$args$1 extends AbstractC12240o implements Function0<ModalComponent.Options> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final ModalComponent.Options invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        ModalComponent.Options options = (ModalComponent.Options) (obj instanceof ModalComponent.Options ? obj : null);
        ModalComponent.Options options2 = options;
        if (options == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (options2 != 0) {
            options2 = parcelableExtra;
            return options2;
        }
        options2 = parcelableExtra;
        StringBuilder sbM833U = C1643a.m833U("Missing args for class type ");
        C1643a.m862l0(ModalComponent.Options.class, sbM833U, " + key ");
        throw new IllegalStateException(C1643a.m820H(sbM833U, this.$argsKey, '!'));
    }
}
