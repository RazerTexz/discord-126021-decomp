package com.discord.widgets.chat.list.sheet;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetApplicationCommandBottomSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetApplicationCommandBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetApplicationCommandBottomSheetBinding> {
    public static final WidgetApplicationCommandBottomSheet2 INSTANCE = new WidgetApplicationCommandBottomSheet2();

    public WidgetApplicationCommandBottomSheet2() {
        super(1, WidgetApplicationCommandBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetApplicationCommandBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.bottom;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.bottom);
        if (linearLayout != null) {
            i = R.id.command_bottom_sheet_command_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.command_bottom_sheet_command_avatar);
            if (simpleDraweeView != null) {
                i = R.id.command_bottom_sheet_command_content;
                TextView textView = (TextView) view.findViewById(R.id.command_bottom_sheet_command_content);
                if (textView != null) {
                    i = R.id.command_bottom_sheet_command_copy_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.command_bottom_sheet_command_copy_button);
                    if (materialButton != null) {
                        i = R.id.command_bottom_sheet_command_loader;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.command_bottom_sheet_command_loader);
                        if (progressBar != null) {
                            i = R.id.command_bottom_sheet_command_slash_heading;
                            TextView textView2 = (TextView) view.findViewById(R.id.command_bottom_sheet_command_slash_heading);
                            if (textView2 != null) {
                                i = R.id.command_bottom_sheet_command_title;
                                TextView textView3 = (TextView) view.findViewById(R.id.command_bottom_sheet_command_title);
                                if (textView3 != null) {
                                    i = R.id.command_bottom_sheet_command_title_application_name;
                                    TextView textView4 = (TextView) view.findViewById(R.id.command_bottom_sheet_command_title_application_name);
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
