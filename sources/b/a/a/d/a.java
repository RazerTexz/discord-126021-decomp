package b.a.a.d;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.u1;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import defpackage.k;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: UserActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/UserActionsDialogBinding;", 0)};
    public static final a$b k = new a$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final MGImages$DistinctChangeDetector imagesChangeDetector;

    public a() {
        super(R$layout.user_actions_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, a$c.j, null, 2, null);
        a$h a_h = new a$h(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(f.class), new k(4, g0Var), new i0(a_h));
        this.imagesChangeDetector = new MGImages$DistinctChangeDetector();
    }

    public final u1 g() {
        return (u1) this.binding.getValue((Fragment) this, j[0]);
    }

    public final f h() {
        return (f) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().c.setOnClickListener(new a$a(0, this));
        g().e.setOnClickListener(new a$a(1, this));
        g().d.setOnClickListener(new a$a(2, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableG = h().observeViewState().y(a$d.j).G(a$e.j);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new a$f(this), 62, (Object) null);
        PublishSubject<f$b> publishSubject = h().k;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(publishSubject, this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new a$g(this), 62, (Object) null);
    }
}
