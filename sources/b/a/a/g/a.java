package b.a.a.g;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.q5;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetMaskedLinksDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0)};
    public static final a$b k = new a$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public a() {
        super(R$layout.widget_masked_links_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, a$c.j, null, 2, null);
    }

    public final q5 g() {
        return (q5) this.binding.getValue((Fragment) this, j[0]);
    }

    public final void h(Context context, String url) {
        UriHandler.handle$default(UriHandler.INSTANCE, context, url, false, false, null, 28, null);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StoreNotices notices = StoreStream.Companion.getNotices();
        Objects.requireNonNull(k);
        StoreNotices.markSeen$default(notices, "WIDGET_SPOOPY_LINKS_DIALOG", 0L, 2, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        String string;
        Object punyCodeASCIIUrl;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("WIDGET_SPOOPY_LINKS_DIALOG_URL")) == null) {
            string = "";
        }
        m.checkNotNullExpressionValue(string, "arguments?.getString(DIALOG_URL) ?: \"\"");
        try {
            punyCodeASCIIUrl = StringUtilsKt.toPunyCodeASCIIUrl(string);
        } catch (Exception unused) {
            dismiss();
            punyCodeASCIIUrl = Unit.a;
        }
        TextView textView = g().f188b;
        m.checkNotNullExpressionValue(textView, "binding.maskedLinksBodyText");
        b.n(textView, 2131892738, new Object[]{punyCodeASCIIUrl}, null, 4);
        g().c.setOnClickListener(new a$d(this));
        g().d.setOnClickListener(new a$a(0, this, string));
        g().e.setOnClickListener(new a$a(1, this, string));
    }
}
