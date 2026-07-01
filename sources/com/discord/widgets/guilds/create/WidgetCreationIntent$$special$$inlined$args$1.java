package com.discord.widgets.guilds.create;

import android.os.Bundle;
import android.os.Parcelable;
import b.d.b.a.a;
import com.discord.app.AppFragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent$$special$$inlined$args$1 extends o implements Function0<CreationIntentArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreationIntent$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final CreationIntentArgs invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        CreationIntentArgs creationIntentArgs = (CreationIntentArgs) (obj instanceof CreationIntentArgs ? obj : null);
        CreationIntentArgs creationIntentArgs2 = creationIntentArgs;
        if (creationIntentArgs == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (creationIntentArgs2 != 0) {
            creationIntentArgs2 = parcelableExtra;
            return creationIntentArgs2;
        }
        creationIntentArgs2 = parcelableExtra;
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(CreationIntentArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.guilds.create.CreationIntentArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CreationIntentArgs invoke() {
        return invoke();
    }
}
