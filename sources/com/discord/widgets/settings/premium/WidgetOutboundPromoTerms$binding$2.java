package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetOutboundPromoTermsBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetOutboundPromoTerms$binding$2 extends C12236k implements Function1<View, WidgetOutboundPromoTermsBinding> {
    public static final WidgetOutboundPromoTerms$binding$2 INSTANCE = new WidgetOutboundPromoTerms$binding$2();

    public WidgetOutboundPromoTerms$binding$2() {
        super(1, WidgetOutboundPromoTermsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetOutboundPromoTermsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.promoTermsClose;
        TextView textView = (TextView) view.findViewById(C5419R.id.promoTermsClose);
        if (textView != null) {
            i = C5419R.id.promoTermsContent;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.promoTermsContent);
            if (linkifiedTextView != null) {
                return new WidgetOutboundPromoTermsBinding((LinearLayout) view, textView, linkifiedTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
