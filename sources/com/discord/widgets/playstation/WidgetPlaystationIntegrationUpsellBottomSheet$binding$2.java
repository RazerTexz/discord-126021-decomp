package com.discord.widgets.playstation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetPlaystationUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPlaystationIntegrationUpsellBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetPlaystationUpsellBottomSheetBinding> {
    public static final WidgetPlaystationIntegrationUpsellBottomSheet$binding$2 INSTANCE = new WidgetPlaystationIntegrationUpsellBottomSheet$binding$2();

    public WidgetPlaystationIntegrationUpsellBottomSheet$binding$2() {
        super(1, WidgetPlaystationUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPlaystationUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetPlaystationUpsellBottomSheetBinding invoke(View view) {
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
                    i = C5419R.id.upsell_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.upsell_header);
                    if (textView2 != null) {
                        i = C5419R.id.upsell_image;
                        ImageView imageView = (ImageView) view.findViewById(C5419R.id.upsell_image);
                        if (imageView != null) {
                            return new WidgetPlaystationUpsellBottomSheetBinding((NestedScrollView) view, materialButton, materialButton2, textView, textView2, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
