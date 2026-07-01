package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetStartCallSheetBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStartCallSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetStartCallSheet$binding$2 extends k implements Function1<View, WidgetStartCallSheetBinding> {
    public static final WidgetStartCallSheet$binding$2 INSTANCE = new WidgetStartCallSheet$binding$2();

    public WidgetStartCallSheet$binding$2() {
        super(1, WidgetStartCallSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStartCallSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStartCallSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStartCallSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.start_call_sheet_video_item;
        TextView textView = (TextView) view.findViewById(R$id.start_call_sheet_video_item);
        if (textView != null) {
            i = R$id.start_call_sheet_voice_item;
            TextView textView2 = (TextView) view.findViewById(R$id.start_call_sheet_voice_item);
            if (textView2 != null) {
                return new WidgetStartCallSheetBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
