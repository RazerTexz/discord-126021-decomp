package p007b.p008a.p009a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.C0847x;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C0950e6;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.t */
/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0843t extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f438j = {C1643a.m846d0(C0843t.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: b.a.a.t$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.t$b */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C0950e6> {

        /* JADX INFO: renamed from: j */
        public static final b f442j = new b();

        public b() {
            super(1, C0950e6.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0950e6 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.view_dialog_confirmation_confirm;
            LoadingButton loadingButton = (LoadingButton) view2.findViewById(C5419R.id.view_dialog_confirmation_confirm);
            if (loadingButton != null) {
                i = C5419R.id.view_dialog_confirmation_header;
                TextView textView = (TextView) view2.findViewById(C5419R.id.view_dialog_confirmation_header);
                if (textView != null) {
                    i = C5419R.id.view_dialog_confirmation_text;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.view_dialog_confirmation_text);
                    if (textView2 != null) {
                        return new C0950e6((LinearLayout) view2, loadingButton, textView, textView2);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.t$c */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final class c extends AbstractC12240o implements Function1<C0847x.d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C0847x.d dVar) {
            C0847x.d dVar2 = dVar;
            C12238m.checkNotNullParameter(dVar2, "viewState");
            C0843t c0843t = C0843t.this;
            KProperty[] kPropertyArr = C0843t.f438j;
            TextView textView = c0843t.m145g().f825c;
            C12238m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
            textView.setText(c0843t.getString(C5419R.string.system_dm_urgent_message_modal_header));
            TextView textView2 = c0843t.m145g().f826d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
            textView2.setText(c0843t.getString(C5419R.string.system_dm_urgent_message_modal_body));
            c0843t.m145g().f824b.setText(c0843t.getString(C5419R.string.okay));
            c0843t.m145g().f824b.setIsLoading(dVar2.f453b);
            c0843t.m145g().f824b.setOnClickListener(new ViewOnClickListenerC0844u(c0843t));
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.t$d */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final class d extends AbstractC12240o implements Function1<C0847x.b, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C0847x.b bVar) {
            C0847x.b bVar2 = bVar;
            C12238m.checkNotNullParameter(bVar2, "event");
            C0843t c0843t = C0843t.this;
            KProperty[] kPropertyArr = C0843t.f438j;
            Objects.requireNonNull(c0843t);
            if (C12238m.areEqual(bVar2, C0847x.b.a.f449a)) {
                c0843t.dismiss();
            } else {
                if (!C12238m.areEqual(bVar2, C0847x.b.C13210b.f450a)) {
                    throw new NoWhenBranchMatchedException();
                }
                C0876m.m169g(c0843t.getContext(), C5419R.string.internal_server_error, 0, null, 12);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.t$e */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final class e extends AbstractC12240o implements Function0<C0847x> {

        /* JADX INFO: renamed from: j */
        public static final e f443j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C0847x invoke() {
            return new C0847x(null, null, null, 7);
        }
    }

    public C0843t() {
        super(C5419R.layout.widget_urgent_message_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f442j, null, 2, null);
        e eVar = e.f443j;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(C0847x.class), new C12788k(1, c0865g0), new C0869i0(eVar));
    }

    /* JADX INFO: renamed from: g */
    public final C0950e6 m145g() {
        return (C0950e6) this.binding.getValue((Fragment) this, f438j[0]);
    }

    /* JADX INFO: renamed from: h */
    public final C0847x m146h() {
        return (C0847x) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreStream.INSTANCE.getNotices().markDialogSeen("URGENT_MESSAGE_DIALOG");
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(m146h().observeViewState(), this, null, 2, null), (Class<?>) C0843t.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new c());
        PublishSubject<C0847x.b> publishSubject = m146h().f447k;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(publishSubject, this, null, 2, null), (Class<?>) C0843t.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new d());
    }
}
