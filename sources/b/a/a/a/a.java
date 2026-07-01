package b.a.a.a;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.u;
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

/* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0)};
    public static final a$b k = new a$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

    public a() {
        super(R$layout.guild_boost_uncancel_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, a$c.j, null, 2, null);
        a$f a_f = new a$f(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(k.class), new defpackage.k(3, g0Var), new i0(a_f));
        this.slotId = d0.g.lazy(new a$e(this));
    }

    public final u g() {
        return (u) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().h.setOnClickListener(new a$a(0, this));
        g().c.setOnClickListener(new a$a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<k$c> observableR = ((k) this.viewModel.getValue()).observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new a$d(this), 62, (Object) null);
    }
}
