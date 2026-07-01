package b.a.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.i.h5;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(s.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0)};
    public static final s$a k = new s$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function1<? super String, Unit> onValidPasswordEntered;

    public s() {
        super(R$layout.widget_enable_two_factor_password_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, s$b.j, null, 2, null);
        this.onValidPasswordEntered = s$c.j;
    }

    public final h5 g() {
        return (h5) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        g().c.setIsLoading(false);
        g().c.setOnClickListener(new s$d(this, view));
        g().f129b.setOnClickListener(new s$e(this));
    }
}
