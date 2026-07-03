package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildScheduledEventUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventUpsellBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetGuildScheduledEventUpsellBottomSheetBinding> {
    public static final WidgetGuildScheduledEventUpsellBottomSheet$binding$2 INSTANCE = new WidgetGuildScheduledEventUpsellBottomSheet$binding$2();

    public WidgetGuildScheduledEventUpsellBottomSheet$binding$2() {
        super(1, WidgetGuildScheduledEventUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildScheduledEventUpsellBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel_button);
        if (materialButton != null) {
            i = C5419R.id.confirm_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.confirm_button);
            if (materialButton2 != null) {
                i = C5419R.id.upsell_body;
                TextView textView = (TextView) view.findViewById(C5419R.id.upsell_body);
                if (textView != null) {
                    i = C5419R.id.upsell_header_part_1;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.upsell_header_part_1);
                    if (textView2 != null) {
                        i = C5419R.id.upsell_header_part_2;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.upsell_header_part_2);
                        if (textView3 != null) {
                            i = C5419R.id.upsell_image;
                            ImageView imageView = (ImageView) view.findViewById(C5419R.id.upsell_image);
                            if (imageView != null) {
                                return new WidgetGuildScheduledEventUpsellBottomSheetBinding((NestedScrollView) view, materialButton, materialButton2, textView, textView2, textView3, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
