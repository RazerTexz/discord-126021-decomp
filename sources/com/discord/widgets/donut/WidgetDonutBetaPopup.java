package com.discord.widgets.donut;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDonutBetaPopupBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDonutBetaPopup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetDonutBetaPopup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDonutBetaPopupBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, String source) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("Project Donut Android Beta Required", source, null, 4, null);
            C0870j.m157e(context, WidgetDonutBetaPopup.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetDonutBetaPopup() {
        super(C5419R.layout.widget_donut_beta_popup);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDonutBetaPopup$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetDonutBetaPopupBinding getBinding() {
        return (WidgetDonutBetaPopupBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(Context context, String str) {
        INSTANCE.show(context, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f16486b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.donutBetaBody");
        C1107b.m221m(linkifiedTextView, C5419R.string.donut_get_android_beta_body, new Object[]{C0862f.f507a.m149a(360003953831L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f16489e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.donut.WidgetDonutBetaPopup.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m885x(view2, "it", "it.context"), "https://play.google.com/apps/testing/com.discord", false, false, null, 28, null);
            }
        });
        getBinding().f16488d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.donut.WidgetDonutBetaPopup.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetDonutBetaPopup.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
        getBinding().f16487c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.donut.WidgetDonutBetaPopup.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetDonutBetaPopup.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
    }
}
