package b.a.a;

import android.text.method.LinkMovementMethod;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.i.o4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(r.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0)};
    public static final r$a k = new r$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public r() {
        super(R$layout.widget_block_russian_purchases_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, r$b.j, null, 2, null);
    }

    public final o4 g() {
        return (o4) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = g().f175b;
        d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        b.n(linkifiedTextView, 2131894727, new Object[]{f.a.a(4708041338391L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = g().f175b;
        d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        g().c.setOnClickListener(new r$c(this));
    }
}
