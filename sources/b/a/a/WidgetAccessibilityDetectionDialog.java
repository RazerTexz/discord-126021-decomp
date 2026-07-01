package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.AllowAccessibilityDetectionDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.a.h, reason: use source file name */
/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetAccessibilityDetectionDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetAccessibilityDetectionDialog.class, "binding", "getBinding()Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: b.a.a.h$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                WidgetAccessibilityDetectionDialog.g((WidgetAccessibilityDetectionDialog) this.k, false);
            } else {
                if (i != 1) {
                    throw null;
                }
                WidgetAccessibilityDetectionDialog.g((WidgetAccessibilityDetectionDialog) this.k, true);
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.h$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.h$c */
    /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, AllowAccessibilityDetectionDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, AllowAccessibilityDetectionDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public AllowAccessibilityDetectionDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.accessibility_detection_body_text;
            TextView textView = (TextView) view2.findViewById(R.id.accessibility_detection_body_text);
            if (textView != null) {
                i = R.id.accessibility_detection_disable;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.accessibility_detection_disable);
                if (materialButton != null) {
                    i = R.id.accessibility_detection_enable;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.accessibility_detection_enable);
                    if (materialButton2 != null) {
                        i = R.id.view_dialog_confirmation_header;
                        TextView textView2 = (TextView) view2.findViewById(R.id.view_dialog_confirmation_header);
                        if (textView2 != null) {
                            return new AllowAccessibilityDetectionDialogBinding((LinearLayout) view2, textView, materialButton, materialButton2, textView2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.h$d */
    /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
    public static final class d extends Lambda implements Function0<WidgetAccessibilityDetectionDialogViewModel> {
        public static final d j = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public WidgetAccessibilityDetectionDialogViewModel invoke() {
            return new WidgetAccessibilityDetectionDialogViewModel(null, null, 3);
        }
    }

    public WidgetAccessibilityDetectionDialog() {
        super(R.layout.allow_accessibility_detection_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
        d dVar = d.j;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetAccessibilityDetectionDialogViewModel.class), new defpackage.k(0, appViewModelDelegates3), new AppViewModelDelegates5(dVar));
    }

    public static final void g(WidgetAccessibilityDetectionDialog widgetAccessibilityDetectionDialog, boolean z2) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(((WidgetAccessibilityDetectionDialogViewModel) widgetAccessibilityDetectionDialog.viewModel.getValue()).j.setIsAccessibilityDetectionAllowed(z2), false, 1, null), (Class<?>) WidgetAccessibilityDetectionDialogViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), WidgetAccessibilityDetectionDialogViewModel2.j);
        widgetAccessibilityDetectionDialog.dismiss();
    }

    public final AllowAccessibilityDetectionDialogBinding h() {
        return (AllowAccessibilityDetectionDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        h().c.setOnClickListener(new a(0, this));
        h().d.setOnClickListener(new a(1, this));
        TextView textView = h().f72b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.accessibilityDetectionBodyText");
        FormatUtils.m(textView, R.string.accessibility_detection_modal_body, new Object[]{AppHelpDesk.a.a(360035966492L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }
}
