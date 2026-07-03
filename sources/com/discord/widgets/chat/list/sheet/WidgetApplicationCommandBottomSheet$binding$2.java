package com.discord.widgets.chat.list.sheet;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetApplicationCommandBottomSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetApplicationCommandBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetApplicationCommandBottomSheetBinding> {
    public static final WidgetApplicationCommandBottomSheet$binding$2 INSTANCE = new WidgetApplicationCommandBottomSheet$binding$2();

    public WidgetApplicationCommandBottomSheet$binding$2() {
        super(1, WidgetApplicationCommandBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetApplicationCommandBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.bottom;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.bottom);
        if (linearLayout != null) {
            i = C5419R.id.command_bottom_sheet_command_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.command_bottom_sheet_command_avatar);
            if (simpleDraweeView != null) {
                i = C5419R.id.command_bottom_sheet_command_content;
                TextView textView = (TextView) view.findViewById(C5419R.id.command_bottom_sheet_command_content);
                if (textView != null) {
                    i = C5419R.id.command_bottom_sheet_command_copy_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.command_bottom_sheet_command_copy_button);
                    if (materialButton != null) {
                        i = C5419R.id.command_bottom_sheet_command_loader;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.command_bottom_sheet_command_loader);
                        if (progressBar != null) {
                            i = C5419R.id.command_bottom_sheet_command_slash_heading;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.command_bottom_sheet_command_slash_heading);
                            if (textView2 != null) {
                                i = C5419R.id.command_bottom_sheet_command_title;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.command_bottom_sheet_command_title);
                                if (textView3 != null) {
                                    i = C5419R.id.command_bottom_sheet_command_title_application_name;
                                    TextView textView4 = (TextView) view.findViewById(C5419R.id.command_bottom_sheet_command_title_application_name);
                                    if (textView4 != null) {
                                        return new WidgetApplicationCommandBottomSheetBinding((ConstraintLayout) view, linearLayout, simpleDraweeView, textView, materialButton, progressBar, textView2, textView3, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
