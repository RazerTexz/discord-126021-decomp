package b.a.a.a;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.t;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(b.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0)};
    public static final b$b k = new b$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

    public b() {
        super(R$layout.guild_boost_cancel_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b$c.j, null, 2, null);
        b$f b_f = new b$f(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(f.class), new defpackage.k(2, g0Var), new i0(b_f));
        this.slotId = d0.g.lazy(new b$e(this));
    }

    public final t g() {
        return (t) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().g.setOnClickListener(new b$a(0, this));
        g().c.setOnClickListener(new b$a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<f$c> observableR = ((f) this.viewModel.getValue()).observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), b.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b$d(this), 62, (Object) null);
    }
}
