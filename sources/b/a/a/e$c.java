package b.a.a;

import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import d0.z.d.a0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$c {
    public e$c(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final e a(FragmentManager fragmentManager, SimpleConfirmationDialogArgs simpleConfirmationDialogArgs, View$OnClickListener view$OnClickListener) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        d0.z.d.m.checkNotNullParameter(simpleConfirmationDialogArgs, "args");
        d0.z.d.m.checkNotNullParameter(view$OnClickListener, "positiveClickListener");
        e eVar = new e();
        eVar.setArguments(d.e2(simpleConfirmationDialogArgs));
        eVar.positiveClickListener = view$OnClickListener;
        eVar.show(fragmentManager, a0.getOrCreateKotlinClass(e.class).toString());
        return eVar;
    }
}
