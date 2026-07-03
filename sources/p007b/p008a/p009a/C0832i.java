package p007b.p008a.p009a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C0967h;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.i */
/* JADX INFO: compiled from: ConnectedAccountActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0832i extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f384j = {C1643a.m846d0(C0832i.class, "binding", "getBinding()Lcom/discord/databinding/ConnectedAccountActionsDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.i$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f387j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f388k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ Object f389l;

        public a(int i, Object obj, Object obj2) {
            this.f387j = i;
            this.f388k = obj;
            this.f389l = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f387j;
            if (i == 0) {
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context contextRequireContext = ((C0832i) this.f388k).requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                UriHandler.handle$default(uriHandler, contextRequireContext, (String) this.f389l, false, false, null, 28, null);
                ((C0832i) this.f388k).dismiss();
                return;
            }
            if (i != 1) {
                throw null;
            }
            Context contextRequireContext2 = ((C0832i) this.f388k).requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            String str = (String) this.f389l;
            C12238m.checkNotNullExpressionValue(str, "username");
            C0876m.m163a(contextRequireContext2, str, C5419R.string.copied_text);
            ((C0832i) this.f388k).dismiss();
        }
    }

    /* JADX INFO: renamed from: b.a.a.i$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ConnectedAccountActionsDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.i$c */
    /* JADX INFO: compiled from: ConnectedAccountActionsDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C0967h> {

        /* JADX INFO: renamed from: j */
        public static final c f390j = new c();

        public c() {
            super(1, C0967h.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ConnectedAccountActionsDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0967h invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.connected_account_actions_dialog_copy_username;
            TextView textView = (TextView) view2.findViewById(C5419R.id.connected_account_actions_dialog_copy_username);
            if (textView != null) {
                i = C5419R.id.connected_account_actions_dialog_header;
                TextView textView2 = (TextView) view2.findViewById(C5419R.id.connected_account_actions_dialog_header);
                if (textView2 != null) {
                    i = C5419R.id.connected_account_actions_dialog_open_in_browser;
                    TextView textView3 = (TextView) view2.findViewById(C5419R.id.connected_account_actions_dialog_open_in_browser);
                    if (textView3 != null) {
                        return new C0967h((LinearLayout) view2, textView, textView2, textView3);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public C0832i() {
        super(C5419R.layout.connected_account_actions_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f390j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C0967h m136g() {
        return (C0967h) this.binding.getValue((Fragment) this, f384j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String string = getArgumentsOrDefault().getString("ARG_PROFILE_URL", "");
        String string2 = getArgumentsOrDefault().getString("ARG_USERNAME", "");
        int i = getArgumentsOrDefault().getInt("ARG_THEMED_PLATFORM_IMAGE_RES", 0);
        if (i != 0) {
            TextView textView = m136g().f893c;
            C12238m.checkNotNullExpressionValue(textView, "binding.connectedAccountActionsDialogHeader");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, DrawableCompat.getThemedDrawableRes$default(view, i, 0, 2, (Object) null), 0, 0, 0, 14, null);
        }
        TextView textView2 = m136g().f893c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.connectedAccountActionsDialogHeader");
        textView2.setText(string2);
        TextView textView3 = m136g().f894d;
        C12238m.checkNotNullExpressionValue(textView3, "binding.connectedAccountActionsDialogOpenInBrowser");
        textView3.setVisibility((string == null || string.length() == 0) ^ true ? 0 : 8);
        m136g().f894d.setOnClickListener(new a(0, this, string));
        m136g().f892b.setOnClickListener(new a(1, this, string2));
    }
}
