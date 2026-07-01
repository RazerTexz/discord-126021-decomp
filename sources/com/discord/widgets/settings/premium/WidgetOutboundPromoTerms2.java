package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetOutboundPromoTermsBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetOutboundPromoTerms2 extends FunctionReferenceImpl implements Function1<View, WidgetOutboundPromoTermsBinding> {
    public static final WidgetOutboundPromoTerms2 INSTANCE = new WidgetOutboundPromoTerms2();

    public WidgetOutboundPromoTerms2() {
        super(1, WidgetOutboundPromoTermsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetOutboundPromoTermsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.promoTermsClose;
        TextView textView = (TextView) view.findViewById(R.id.promoTermsClose);
        if (textView != null) {
            i = R.id.promoTermsContent;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.promoTermsContent);
            if (linkifiedTextView != null) {
                return new WidgetOutboundPromoTermsBinding((LinearLayout) view, textView, linkifiedTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
