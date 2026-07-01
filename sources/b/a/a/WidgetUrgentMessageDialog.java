package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.WidgetUrgentMessageDialogViewModel3;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.WidgetUrgentMessageDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.t, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetUrgentMessageDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0)};

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
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetUrgentMessageDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, WidgetUrgentMessageDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetUrgentMessageDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.view_dialog_confirmation_confirm;
            LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.view_dialog_confirmation_confirm);
            if (loadingButton != null) {
                i = R.id.view_dialog_confirmation_header;
                TextView textView = (TextView) view2.findViewById(R.id.view_dialog_confirmation_header);
                if (textView != null) {
                    i = R.id.view_dialog_confirmation_text;
                    TextView textView2 = (TextView) view2.findViewById(R.id.view_dialog_confirmation_text);
                    if (textView2 != null) {
                        return new WidgetUrgentMessageDialogBinding((LinearLayout) view2, loadingButton, textView, textView2);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.t$c */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final class c extends Lambda implements Function1<WidgetUrgentMessageDialogViewModel3.d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetUrgentMessageDialogViewModel3.d dVar) {
            WidgetUrgentMessageDialogViewModel3.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "viewState");
            WidgetUrgentMessageDialog widgetUrgentMessageDialog = WidgetUrgentMessageDialog.this;
            KProperty[] kPropertyArr = WidgetUrgentMessageDialog.j;
            TextView textView = widgetUrgentMessageDialog.g().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
            textView.setText(widgetUrgentMessageDialog.getString(R.string.system_dm_urgent_message_modal_header));
            TextView textView2 = widgetUrgentMessageDialog.g().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
            textView2.setText(widgetUrgentMessageDialog.getString(R.string.system_dm_urgent_message_modal_body));
            widgetUrgentMessageDialog.g().f108b.setText(widgetUrgentMessageDialog.getString(R.string.okay));
            widgetUrgentMessageDialog.g().f108b.setIsLoading(dVar2.f50b);
            widgetUrgentMessageDialog.g().f108b.setOnClickListener(new WidgetUrgentMessageDialog2(widgetUrgentMessageDialog));
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.t$d */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final class d extends Lambda implements Function1<WidgetUrgentMessageDialogViewModel3.b, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetUrgentMessageDialogViewModel3.b bVar) {
            WidgetUrgentMessageDialogViewModel3.b bVar2 = bVar;
            Intrinsics3.checkNotNullParameter(bVar2, "event");
            WidgetUrgentMessageDialog widgetUrgentMessageDialog = WidgetUrgentMessageDialog.this;
            KProperty[] kPropertyArr = WidgetUrgentMessageDialog.j;
            Objects.requireNonNull(widgetUrgentMessageDialog);
            if (Intrinsics3.areEqual(bVar2, WidgetUrgentMessageDialogViewModel3.b.a.a)) {
                widgetUrgentMessageDialog.dismiss();
            } else {
                if (!Intrinsics3.areEqual(bVar2, WidgetUrgentMessageDialogViewModel3.b.C0014b.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                AppToast.g(widgetUrgentMessageDialog.getContext(), R.string.internal_server_error, 0, null, 12);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.t$e */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
    public static final class e extends Lambda implements Function0<WidgetUrgentMessageDialogViewModel3> {
        public static final e j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public WidgetUrgentMessageDialogViewModel3 invoke() {
            return new WidgetUrgentMessageDialogViewModel3(null, null, null, 7);
        }
    }

    public WidgetUrgentMessageDialog() {
        super(R.layout.widget_urgent_message_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
        e eVar = e.j;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUrgentMessageDialogViewModel3.class), new defpackage.k(1, appViewModelDelegates3), new AppViewModelDelegates5(eVar));
    }

    public final WidgetUrgentMessageDialogBinding g() {
        return (WidgetUrgentMessageDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    public final WidgetUrgentMessageDialogViewModel3 h() {
        return (WidgetUrgentMessageDialogViewModel3) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreStream.INSTANCE.getNotices().markDialogSeen("URGENT_MESSAGE_DIALOG");
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(h().observeViewState(), this, null, 2, null), (Class<?>) WidgetUrgentMessageDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new c());
        PublishSubject<WidgetUrgentMessageDialogViewModel3.b> publishSubject = h().k;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(publishSubject, this, null, 2, null), (Class<?>) WidgetUrgentMessageDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new d());
    }
}
