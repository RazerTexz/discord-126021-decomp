package p007b.p008a.p009a.p016g;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C1036q5;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.g.a */
/* JADX INFO: compiled from: WidgetMaskedLinksDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0830a extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f368j = {C1643a.m846d0(C0830a.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.g.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f371j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f372k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ Object f373l;

        public a(int i, Object obj, Object obj2) {
            this.f371j = i;
            this.f372k = obj;
            this.f373l = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f371j;
            if (i == 0) {
                C0830a c0830a = (C0830a) this.f372k;
                C12238m.checkNotNullExpressionValue(view, "v");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "v.context");
                String str = (String) this.f373l;
                KProperty[] kPropertyArr = C0830a.f368j;
                c0830a.m133h(context, str);
                return;
            }
            if (i != 1) {
                throw null;
            }
            C0830a c0830a2 = (C0830a) this.f372k;
            C12238m.checkNotNullExpressionValue(view, "v");
            Context context2 = view.getContext();
            C12238m.checkNotNullExpressionValue(context2, "v.context");
            String str2 = (String) this.f373l;
            KProperty[] kPropertyArr2 = C0830a.f368j;
            Objects.requireNonNull(c0830a2);
            StoreStream.INSTANCE.getMaskedLinks().trustDomain(str2);
            c0830a2.m133h(context2, str2);
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
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C1036q5> {

        /* JADX INFO: renamed from: j */
        public static final c f374j = new c();

        public c() {
            super(1, C1036q5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1036q5 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.masked_links_body_text;
            TextView textView = (TextView) view2.findViewById(C5419R.id.masked_links_body_text);
            if (textView != null) {
                i = C5419R.id.masked_links_cancel;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.masked_links_cancel);
                if (materialButton != null) {
                    i = C5419R.id.masked_links_confirm;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.masked_links_confirm);
                    if (materialButton2 != null) {
                        i = C5419R.id.masked_links_trust_domain;
                        TextView textView2 = (TextView) view2.findViewById(C5419R.id.masked_links_trust_domain);
                        if (textView2 != null) {
                            i = C5419R.id.view_dialog_confirmation_header;
                            TextView textView3 = (TextView) view2.findViewById(C5419R.id.view_dialog_confirmation_header);
                            if (textView3 != null) {
                                return new C1036q5((LinearLayout) view2, textView, materialButton, materialButton2, textView2, textView3);
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
            C0830a.this.dismiss();
        }
    }

    public C0830a() {
        super(C5419R.layout.widget_masked_links_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f374j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C1036q5 m132g() {
        return (C1036q5) this.binding.getValue((Fragment) this, f368j[0]);
    }

    /* JADX INFO: renamed from: h */
    public final void m133h(Context context, String url) {
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("WIDGET_SPOOPY_LINKS_DIALOG_URL")) == null) {
            string = "";
        }
        C12238m.checkNotNullExpressionValue(string, "arguments?.getString(DIALOG_URL) ?: \"\"");
        try {
            punyCodeASCIIUrl = StringUtilsKt.toPunyCodeASCIIUrl(string);
        } catch (Exception unused) {
            dismiss();
            punyCodeASCIIUrl = Unit.f27425a;
        }
        TextView textView = m132g().f1161b;
        C12238m.checkNotNullExpressionValue(textView, "binding.maskedLinksBodyText");
        C1107b.m221m(textView, C5419R.string.masked_link_body, new Object[]{punyCodeASCIIUrl}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        m132g().f1162c.setOnClickListener(new d());
        m132g().f1163d.setOnClickListener(new a(0, this, string));
        m132g().f1164e.setOnClickListener(new a(1, this, string));
    }
}
