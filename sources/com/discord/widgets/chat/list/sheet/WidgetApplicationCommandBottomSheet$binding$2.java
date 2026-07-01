package com.discord.widgets.chat.list.sheet;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetApplicationCommandBottomSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetApplicationCommandBottomSheet$binding$2 extends k implements Function1<View, WidgetApplicationCommandBottomSheetBinding> {
    public static final WidgetApplicationCommandBottomSheet$binding$2 INSTANCE = new WidgetApplicationCommandBottomSheet$binding$2();

    public WidgetApplicationCommandBottomSheet$binding$2() {
        super(1, WidgetApplicationCommandBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetApplicationCommandBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetApplicationCommandBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131362214;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131362214);
        if (linearLayout != null) {
            i = R$id.command_bottom_sheet_command_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.command_bottom_sheet_command_avatar);
            if (simpleDraweeView != null) {
                i = R$id.command_bottom_sheet_command_content;
                TextView textView = (TextView) view.findViewById(R$id.command_bottom_sheet_command_content);
                if (textView != null) {
                    i = R$id.command_bottom_sheet_command_copy_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.command_bottom_sheet_command_copy_button);
                    if (materialButton != null) {
                        i = R$id.command_bottom_sheet_command_loader;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.command_bottom_sheet_command_loader);
                        if (progressBar != null) {
                            i = R$id.command_bottom_sheet_command_slash_heading;
                            TextView textView2 = (TextView) view.findViewById(R$id.command_bottom_sheet_command_slash_heading);
                            if (textView2 != null) {
                                i = R$id.command_bottom_sheet_command_title;
                                TextView textView3 = (TextView) view.findViewById(R$id.command_bottom_sheet_command_title);
                                if (textView3 != null) {
                                    i = R$id.command_bottom_sheet_command_title_application_name;
                                    TextView textView4 = (TextView) view.findViewById(R$id.command_bottom_sheet_command_title_application_name);
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
