package com.discord.widgets.client;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.databinding.WidgetClientOutdatedBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.client.WidgetClientOutdated$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetClientOutdated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetClientOutdated2 extends FunctionReferenceImpl implements Function1<View, WidgetClientOutdatedBinding> {
    public static final WidgetClientOutdated2 INSTANCE = new WidgetClientOutdated2();

    public WidgetClientOutdated2() {
        super(1, WidgetClientOutdatedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetClientOutdatedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetClientOutdatedBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.client_outdated_anchor_wrap;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.client_outdated_anchor_wrap);
        if (linearLayout != null) {
            i = R.id.client_outdated_update;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.client_outdated_update);
            if (materialButton != null) {
                return new WidgetClientOutdatedBinding((RelativeLayout) view, linearLayout, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
