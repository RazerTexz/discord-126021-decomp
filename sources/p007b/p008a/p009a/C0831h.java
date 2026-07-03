package p007b.p008a.p009a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p025i.C0911a;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.h */
/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0831h extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f376j = {C1643a.m846d0(C0831h.class, "binding", "getBinding()Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0)};

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

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f380j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f381k;

        public a(int i, Object obj) {
            this.f380j = i;
            this.f381k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f380j;
            if (i == 0) {
                C0831h.m134g((C0831h) this.f381k, false);
            } else {
                if (i != 1) {
                    throw null;
                }
                C0831h.m134g((C0831h) this.f381k, true);
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
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C0911a> {

        /* JADX INFO: renamed from: j */
        public static final c f382j = new c();

        public c() {
            super(1, C0911a.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0911a invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.accessibility_detection_body_text;
            TextView textView = (TextView) view2.findViewById(C5419R.id.accessibility_detection_body_text);
            if (textView != null) {
                i = C5419R.id.accessibility_detection_disable;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.accessibility_detection_disable);
                if (materialButton != null) {
                    i = C5419R.id.accessibility_detection_enable;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.accessibility_detection_enable);
                    if (materialButton2 != null) {
                        i = C5419R.id.view_dialog_confirmation_header;
                        TextView textView2 = (TextView) view2.findViewById(C5419R.id.view_dialog_confirmation_header);
                        if (textView2 != null) {
                            return new C0911a((LinearLayout) view2, textView, materialButton, materialButton2, textView2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.h$d */
    /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
    public static final class d extends AbstractC12240o implements Function0<C0839p> {

        /* JADX INFO: renamed from: j */
        public static final d f383j = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C0839p invoke() {
            return new C0839p(null, null, 3);
        }
    }

    public C0831h() {
        super(C5419R.layout.allow_accessibility_detection_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f382j, null, 2, null);
        d dVar = d.f383j;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(C0839p.class), new C12788k(0, c0865g0), new C0869i0(dVar));
    }

    /* JADX INFO: renamed from: g */
    public static final void m134g(C0831h c0831h, boolean z2) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(((C0839p) c0831h.viewModel.getValue()).f419j.setIsAccessibilityDetectionAllowed(z2), false, 1, null), (Class<?>) C0839p.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C0840q.f422j);
        c0831h.dismiss();
    }

    /* JADX INFO: renamed from: h */
    public final C0911a m135h() {
        return (C0911a) this.binding.getValue((Fragment) this, f376j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m135h().f656c.setOnClickListener(new a(0, this));
        m135h().f657d.setOnClickListener(new a(1, this));
        TextView textView = m135h().f655b;
        C12238m.checkNotNullExpressionValue(textView, "binding.accessibilityDetectionBodyText");
        C1107b.m221m(textView, C5419R.string.accessibility_detection_modal_body, new Object[]{C0862f.f507a.m149a(360035966492L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }
}
