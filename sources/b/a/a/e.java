package b.a.a;

import android.view.View$OnClickListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.o1;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(e.class, "binding", "getBinding()Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0)};
    public static final e$c k = new e$c(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy args;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public View$OnClickListener positiveClickListener;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public e() {
        super(R$layout.simple_confirmation_dialog);
        this.args = g.lazy(new e$b(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, e$d.j, null, 2, null);
    }

    public final SimpleConfirmationDialogArgs g() {
        return (SimpleConfirmationDialogArgs) this.args.getValue();
    }

    public final o1 h() {
        return (o1) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        h().d.setOnClickListener(new e$a(0, this));
        h().d.setText(g().l);
        h().c.setOnClickListener(new e$a(1, this));
        MaterialButton materialButton = h().c;
        d0.z.d.m.checkNotNullExpressionValue(materialButton, "binding.simpleConfirmationDialogNegative");
        materialButton.setText(g().m);
        TextView textView = h().e;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.simpleConfirmationDialogTitle");
        b.a(textView, g().j);
        TextView textView2 = h().f172b;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.simpleConfirmationDialogDescription");
        b.a(textView2, g().k);
    }
}
