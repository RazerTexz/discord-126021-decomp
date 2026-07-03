package com.discord.widgets.guilds.create;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetCreationIntentBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.card.MaterialCardView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreationIntent$binding$2 extends C12236k implements Function1<View, WidgetCreationIntentBinding> {
    public static final WidgetCreationIntent$binding$2 INSTANCE = new WidgetCreationIntent$binding$2();

    public WidgetCreationIntent$binding$2() {
        super(1, WidgetCreationIntentBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreationIntentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetCreationIntentBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.creation_intent_first_option;
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(C5419R.id.creation_intent_first_option);
        if (materialCardView != null) {
            i = C5419R.id.creation_intent_first_option_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.creation_intent_first_option_text);
            if (textView != null) {
                i = C5419R.id.creation_intent_second_option;
                MaterialCardView materialCardView2 = (MaterialCardView) view.findViewById(C5419R.id.creation_intent_second_option);
                if (materialCardView2 != null) {
                    i = C5419R.id.creation_intent_second_option_text;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.creation_intent_second_option_text);
                    if (textView2 != null) {
                        i = C5419R.id.creation_intent_skip_text;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.creation_intent_skip_text);
                        if (linkifiedTextView != null) {
                            return new WidgetCreationIntentBinding((CoordinatorLayout) view, materialCardView, textView, materialCardView2, textView2, linkifiedTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
