package p007b.p008a.p009a;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p025i.C1021o4;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.r */
/* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0841r extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f423j = {C1643a.m846d0(C0841r.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.r$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.r$b */
    /* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C1021o4> {

        /* JADX INFO: renamed from: j */
        public static final b f426j = new b();

        public b() {
            super(1, C1021o4.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1021o4 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.notice_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_body_container);
            if (linearLayout != null) {
                i = C5419R.id.notice_body_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(C5419R.id.notice_body_text);
                if (linkifiedTextView != null) {
                    i = C5419R.id.notice_header;
                    TextView textView = (TextView) view2.findViewById(C5419R.id.notice_header);
                    if (textView != null) {
                        i = C5419R.id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = C5419R.id.notice_ok;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.notice_ok);
                            if (materialButton != null) {
                                return new C1021o4((LinearLayout) view2, linearLayout, linkifiedTextView, textView, linearLayout2, materialButton);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.r$c */
    /* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0841r.this.dismiss();
        }
    }

    public C0841r() {
        super(C5419R.layout.widget_block_russian_purchases_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f426j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C1021o4 m143g() {
        return (C1021o4) this.binding.getValue((Fragment) this, f423j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = m143g().f1115b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        C1107b.m221m(linkifiedTextView, C5419R.string.region_blocked_payments_cta, new Object[]{C0862f.f507a.m149a(4708041338391L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView2 = m143g().f1115b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        m143g().f1116c.setOnClickListener(new c());
    }
}
