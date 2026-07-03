package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetStartCallSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStartCallSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetStartCallSheet$binding$2 extends C12236k implements Function1<View, WidgetStartCallSheetBinding> {
    public static final WidgetStartCallSheet$binding$2 INSTANCE = new WidgetStartCallSheet$binding$2();

    public WidgetStartCallSheet$binding$2() {
        super(1, WidgetStartCallSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStartCallSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStartCallSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.start_call_sheet_video_item;
        TextView textView = (TextView) view.findViewById(C5419R.id.start_call_sheet_video_item);
        if (textView != null) {
            i = C5419R.id.start_call_sheet_voice_item;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.start_call_sheet_voice_item);
            if (textView2 != null) {
                return new WidgetStartCallSheetBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
