package com.discord.widgets.guilds.create;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetCreationIntentBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreationIntent3 extends FunctionReferenceImpl implements Function1<View, WidgetCreationIntentBinding> {
    public static final WidgetCreationIntent3 INSTANCE = new WidgetCreationIntent3();

    public WidgetCreationIntent3() {
        super(1, WidgetCreationIntentBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreationIntentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetCreationIntentBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.creation_intent_first_option;
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.creation_intent_first_option);
        if (materialCardView != null) {
            i = R.id.creation_intent_first_option_text;
            TextView textView = (TextView) view.findViewById(R.id.creation_intent_first_option_text);
            if (textView != null) {
                i = R.id.creation_intent_second_option;
                MaterialCardView materialCardView2 = (MaterialCardView) view.findViewById(R.id.creation_intent_second_option);
                if (materialCardView2 != null) {
                    i = R.id.creation_intent_second_option_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.creation_intent_second_option_text);
                    if (textView2 != null) {
                        i = R.id.creation_intent_skip_text;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.creation_intent_skip_text);
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
