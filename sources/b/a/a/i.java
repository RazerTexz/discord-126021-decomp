package b.a.a;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ConnectedAccountActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(i.class, "binding", "getBinding()Lcom/discord/databinding/ConnectedAccountActionsDialogBinding;", 0)};
    public static final i$b k = new i$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public i() {
        super(R$layout.connected_account_actions_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, i$c.j, null, 2, null);
    }

    public final b.a.i.h g() {
        return (b.a.i.h) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String string = getArgumentsOrDefault().getString("ARG_PROFILE_URL", "");
        String string2 = getArgumentsOrDefault().getString("ARG_USERNAME", "");
        int i = getArgumentsOrDefault().getInt("ARG_THEMED_PLATFORM_IMAGE_RES", 0);
        if (i != 0) {
            TextView textView = g().c;
            d0.z.d.m.checkNotNullExpressionValue(textView, "binding.connectedAccountActionsDialogHeader");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, DrawableCompat.getThemedDrawableRes$default(view, i, 0, 2, (Object) null), 0, 0, 0, 14, null);
        }
        TextView textView2 = g().c;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.connectedAccountActionsDialogHeader");
        textView2.setText(string2);
        TextView textView3 = g().d;
        d0.z.d.m.checkNotNullExpressionValue(textView3, "binding.connectedAccountActionsDialogOpenInBrowser");
        textView3.setVisibility((string == null || string.length() == 0) ^ true ? 0 : 8);
        g().d.setOnClickListener(new i$a(0, this, string));
        g().f123b.setOnClickListener(new i$a(1, this, string2));
    }
}
