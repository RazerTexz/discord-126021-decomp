package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetOutboundPromoTermsBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetOutboundPromoTerms$binding$2 extends k implements Function1<View, WidgetOutboundPromoTermsBinding> {
    public static final WidgetOutboundPromoTerms$binding$2 INSTANCE = new WidgetOutboundPromoTerms$binding$2();

    public WidgetOutboundPromoTerms$binding$2() {
        super(1, WidgetOutboundPromoTermsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetOutboundPromoTermsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetOutboundPromoTermsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.promoTermsClose;
        TextView textView = (TextView) view.findViewById(R$id.promoTermsClose);
        if (textView != null) {
            i = R$id.promoTermsContent;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.promoTermsContent);
            if (linkifiedTextView != null) {
                return new WidgetOutboundPromoTermsBinding((LinearLayout) view, textView, linkifiedTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
