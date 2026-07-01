package b.a.a;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.i.WidgetBlockRussianPurchasesDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.r, reason: use source file name */
/* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBlockRussianPurchasesDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetBlockRussianPurchasesDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0)};

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
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetBlockRussianPurchasesDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, WidgetBlockRussianPurchasesDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetBlockRussianPurchasesDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_body_container);
            if (linearLayout != null) {
                i = R.id.notice_body_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R.id.notice_body_text);
                if (linkifiedTextView != null) {
                    i = R.id.notice_header;
                    TextView textView = (TextView) view2.findViewById(R.id.notice_header);
                    if (textView != null) {
                        i = R.id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = R.id.notice_ok;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.notice_ok);
                            if (materialButton != null) {
                                return new WidgetBlockRussianPurchasesDialogBinding((LinearLayout) view2, linearLayout, linkifiedTextView, textView, linearLayout2, materialButton);
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
            WidgetBlockRussianPurchasesDialog.this.dismiss();
        }
    }

    public WidgetBlockRussianPurchasesDialog() {
        super(R.layout.widget_block_russian_purchases_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    public final WidgetBlockRussianPurchasesDialogBinding g() {
        return (WidgetBlockRussianPurchasesDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = g().f175b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        FormatUtils.m(linkifiedTextView, R.string.region_blocked_payments_cta, new Object[]{AppHelpDesk.a.a(4708041338391L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView2 = g().f175b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        g().c.setOnClickListener(new c());
    }
}
