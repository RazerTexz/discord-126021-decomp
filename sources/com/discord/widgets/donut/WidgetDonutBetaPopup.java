package com.discord.widgets.donut;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDonutBetaPopupBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDonutBetaPopup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetDonutBetaPopup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDonutBetaPopupBinding;", 0)};
    public static final WidgetDonutBetaPopup$Companion Companion = new WidgetDonutBetaPopup$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetDonutBetaPopup() {
        super(R$layout.widget_donut_beta_popup);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDonutBetaPopup$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetDonutBetaPopupBinding getBinding() {
        return (WidgetDonutBetaPopupBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(Context context, String str) {
        Companion.show(context, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f2368b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.donutBetaBody");
        b.n(linkifiedTextView, 2131888591, new Object[]{f.a.a(360003953831L, null)}, null, 4);
        getBinding().e.setOnClickListener(WidgetDonutBetaPopup$onViewBound$1.INSTANCE);
        getBinding().d.setOnClickListener(new WidgetDonutBetaPopup$onViewBound$2(this));
        getBinding().c.setOnClickListener(new WidgetDonutBetaPopup$onViewBound$3(this));
    }
}
