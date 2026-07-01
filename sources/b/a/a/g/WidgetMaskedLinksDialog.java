package b.a.a.g;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.WidgetMaskedLinksDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.g.a, reason: use source file name */
/* JADX INFO: compiled from: WidgetMaskedLinksDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetMaskedLinksDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetMaskedLinksDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.g.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;
        public final /* synthetic */ Object l;

        public a(int i, Object obj, Object obj2) {
            this.j = i;
            this.k = obj;
            this.l = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                WidgetMaskedLinksDialog widgetMaskedLinksDialog = (WidgetMaskedLinksDialog) this.k;
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "v.context");
                String str = (String) this.l;
                KProperty[] kPropertyArr = WidgetMaskedLinksDialog.j;
                widgetMaskedLinksDialog.h(context, str);
                return;
            }
            if (i != 1) {
                throw null;
            }
            WidgetMaskedLinksDialog widgetMaskedLinksDialog2 = (WidgetMaskedLinksDialog) this.k;
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context2 = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "v.context");
            String str2 = (String) this.l;
            KProperty[] kPropertyArr2 = WidgetMaskedLinksDialog.j;
            Objects.requireNonNull(widgetMaskedLinksDialog2);
            StoreStream.INSTANCE.getMaskedLinks().trustDomain(str2);
            widgetMaskedLinksDialog2.h(context2, str2);
        }
    }

    /* JADX INFO: renamed from: b.a.a.g.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetMaskedLinksDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.g.a$c */
    /* JADX INFO: compiled from: WidgetMaskedLinksDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, WidgetMaskedLinksDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, WidgetMaskedLinksDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetMaskedLinksDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.masked_links_body_text;
            TextView textView = (TextView) view2.findViewById(R.id.masked_links_body_text);
            if (textView != null) {
                i = R.id.masked_links_cancel;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.masked_links_cancel);
                if (materialButton != null) {
                    i = R.id.masked_links_confirm;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.masked_links_confirm);
                    if (materialButton2 != null) {
                        i = R.id.masked_links_trust_domain;
                        TextView textView2 = (TextView) view2.findViewById(R.id.masked_links_trust_domain);
                        if (textView2 != null) {
                            i = R.id.view_dialog_confirmation_header;
                            TextView textView3 = (TextView) view2.findViewById(R.id.view_dialog_confirmation_header);
                            if (textView3 != null) {
                                return new WidgetMaskedLinksDialogBinding((LinearLayout) view2, textView, materialButton, materialButton2, textView2, textView3);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.g.a$d */
    /* JADX INFO: compiled from: WidgetMaskedLinksDialog.kt */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMaskedLinksDialog.this.dismiss();
        }
    }

    public WidgetMaskedLinksDialog() {
        super(R.layout.widget_masked_links_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final WidgetMaskedLinksDialogBinding g() {
        return (WidgetMaskedLinksDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    public final void h(Context context, String url) {
        UriHandler.handle$default(UriHandler.INSTANCE, context, url, false, false, null, 28, null);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        Objects.requireNonNull(INSTANCE);
        StoreNotices.markSeen$default(notices, "WIDGET_SPOOPY_LINKS_DIALOG", 0L, 2, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        String string;
        Object punyCodeASCIIUrl;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("WIDGET_SPOOPY_LINKS_DIALOG_URL")) == null) {
            string = "";
        }
        Intrinsics3.checkNotNullExpressionValue(string, "arguments?.getString(DIALOG_URL) ?: \"\"");
        try {
            punyCodeASCIIUrl = StringUtils2.toPunyCodeASCIIUrl(string);
        } catch (Exception unused) {
            dismiss();
            punyCodeASCIIUrl = Unit.a;
        }
        TextView textView = g().f188b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.maskedLinksBodyText");
        FormatUtils.m(textView, R.string.masked_link_body, new Object[]{punyCodeASCIIUrl}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        g().c.setOnClickListener(new d());
        g().d.setOnClickListener(new a(0, this, string));
        g().e.setOnClickListener(new a(1, this, string));
    }
}
