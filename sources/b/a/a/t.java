package b.a.a;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.e6;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(t.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0)};
    public static final t$a k = new t$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    public t() {
        super(R$layout.widget_urgent_message_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, t$b.j, null, 2, null);
        t$e t_e = t$e.j;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(x.class), new defpackage.k(1, g0Var), new i0(t_e));
    }

    public final e6 g() {
        return (e6) this.binding.getValue((Fragment) this, j[0]);
    }

    public final x h() {
        return (x) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreStream.Companion.getNotices().markDialogSeen("URGENT_MESSAGE_DIALOG");
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(h().observeViewState(), this, null, 2, null), t.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new t$c(this), 62, (Object) null);
        PublishSubject<x$b> publishSubject = h().k;
        d0.z.d.m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(publishSubject, this, null, 2, null), t.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new t$d(this), 62, (Object) null);
    }
}
