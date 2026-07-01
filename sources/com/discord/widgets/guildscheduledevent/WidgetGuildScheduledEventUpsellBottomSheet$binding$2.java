package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildScheduledEventUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventUpsellBottomSheet$binding$2 extends k implements Function1<View, WidgetGuildScheduledEventUpsellBottomSheetBinding> {
    public static final WidgetGuildScheduledEventUpsellBottomSheet$binding$2 INSTANCE = new WidgetGuildScheduledEventUpsellBottomSheet$binding$2();

    public WidgetGuildScheduledEventUpsellBottomSheet$binding$2() {
        super(1, WidgetGuildScheduledEventUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventUpsellBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventUpsellBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131362294;
        MaterialButton materialButton = (MaterialButton) view.findViewById(2131362294);
        if (materialButton != null) {
            i = 2131362803;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(2131362803);
            if (materialButton2 != null) {
                i = R$id.upsell_body;
                TextView textView = (TextView) view.findViewById(R$id.upsell_body);
                if (textView != null) {
                    i = R$id.upsell_header_part_1;
                    TextView textView2 = (TextView) view.findViewById(R$id.upsell_header_part_1);
                    if (textView2 != null) {
                        i = R$id.upsell_header_part_2;
                        TextView textView3 = (TextView) view.findViewById(R$id.upsell_header_part_2);
                        if (textView3 != null) {
                            i = R$id.upsell_image;
                            ImageView imageView = (ImageView) view.findViewById(R$id.upsell_image);
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
