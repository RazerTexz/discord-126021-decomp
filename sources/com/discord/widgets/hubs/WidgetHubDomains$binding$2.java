package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetHubDomainsBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDomains$binding$2 extends k implements Function1<View, WidgetHubDomainsBinding> {
    public static final WidgetHubDomains$binding$2 INSTANCE = new WidgetHubDomains$binding$2();

    public WidgetHubDomains$binding$2() {
        super(1, WidgetHubDomainsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDomainsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubDomainsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDomainsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.hub_domains_section_title;
        TextView textView = (TextView) view.findViewById(R$id.hub_domains_section_title);
        if (textView != null) {
            i = 2131364898;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(2131364898);
            if (recyclerView != null) {
                i = R$id.waitlist_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.waitlist_button);
                if (materialButton != null) {
                    return new WidgetHubDomainsBinding((LinearLayout) view, textView, recyclerView, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
