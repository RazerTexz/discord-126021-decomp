package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding> {
    public static final WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2 INSTANCE = new WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2();

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2() {
        super(1, WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.cancel_event;
        TextView textView = (TextView) view.findViewById(C5419R.id.cancel_event);
        if (textView != null) {
            i = C5419R.id.copy_id;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.copy_id);
            if (textView2 != null) {
                i = C5419R.id.edit_event;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.edit_event);
                if (textView3 != null) {
                    i = C5419R.id.end_event;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.end_event);
                    if (textView4 != null) {
                        i = C5419R.id.interested_toggle;
                        TextView textView5 = (TextView) view.findViewById(C5419R.id.interested_toggle);
                        if (textView5 != null) {
                            i = C5419R.id.report_event;
                            TextView textView6 = (TextView) view.findViewById(C5419R.id.report_event);
                            if (textView6 != null) {
                                i = C5419R.id.start_event;
                                TextView textView7 = (TextView) view.findViewById(C5419R.id.start_event);
                                if (textView7 != null) {
                                    return new WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding((NestedScrollView) view, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
