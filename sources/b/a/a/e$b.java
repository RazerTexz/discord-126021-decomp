package b.a.a;

import android.os.Bundle;
import b.d.b.a.a;
import com.discord.app.AppDialog;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$b extends d0.z.d.o implements Function0<SimpleConfirmationDialogArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppDialog $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$b(AppDialog appDialog, String str) {
        super(0);
        this.$this_args = appDialog;
        this.$argsKey = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public SimpleConfirmationDialogArgs invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        SimpleConfirmationDialogArgs simpleConfirmationDialogArgs = (SimpleConfirmationDialogArgs) (obj instanceof SimpleConfirmationDialogArgs ? obj : null);
        if (simpleConfirmationDialogArgs != null) {
            return simpleConfirmationDialogArgs;
        }
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(SimpleConfirmationDialogArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }
}
