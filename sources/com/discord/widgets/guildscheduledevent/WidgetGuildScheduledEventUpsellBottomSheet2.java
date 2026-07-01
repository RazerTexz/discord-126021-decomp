package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildScheduledEventUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventUpsellBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildScheduledEventUpsellBottomSheetBinding> {
    public static final WidgetGuildScheduledEventUpsellBottomSheet2 INSTANCE = new WidgetGuildScheduledEventUpsellBottomSheet2();

    public WidgetGuildScheduledEventUpsellBottomSheet2() {
        super(1, WidgetGuildScheduledEventUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildScheduledEventUpsellBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel_button);
        if (materialButton != null) {
            i = R.id.confirm_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm_button);
            if (materialButton2 != null) {
                i = R.id.upsell_body;
                TextView textView = (TextView) view.findViewById(R.id.upsell_body);
                if (textView != null) {
                    i = R.id.upsell_header_part_1;
                    TextView textView2 = (TextView) view.findViewById(R.id.upsell_header_part_1);
                    if (textView2 != null) {
                        i = R.id.upsell_header_part_2;
                        TextView textView3 = (TextView) view.findViewById(R.id.upsell_header_part_2);
                        if (textView3 != null) {
                            i = R.id.upsell_image;
                            ImageView imageView = (ImageView) view.findViewById(R.id.upsell_image);
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
