package b.a.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(h.class, "binding", "getBinding()Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0)};
    public static final h$b k = new h$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    public h() {
        super(R$layout.allow_accessibility_detection_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, h$c.j, null, 2, null);
        h$d h_d = h$d.j;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(p.class), new defpackage.k(0, g0Var), new i0(h_d));
    }

    public static final void g(h hVar, boolean z2) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(((p) hVar.viewModel.getValue()).j.setIsAccessibilityDetectionAllowed(z2), false, 1, null), p.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, q.j, 62, (Object) null);
        hVar.dismiss();
    }

    public final b.a.i.a h() {
        return (b.a.i.a) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        h().c.setOnClickListener(new h$a(0, this));
        h().d.setOnClickListener(new h$a(1, this));
        TextView textView = h().f72b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.accessibilityDetectionBodyText");
        b.n(textView, 2131886142, new Object[]{f.a.a(360035966492L, null)}, null, 4);
    }
}
