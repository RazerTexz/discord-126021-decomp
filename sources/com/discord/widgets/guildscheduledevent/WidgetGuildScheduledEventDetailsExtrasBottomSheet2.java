package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventDetailsExtrasBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding> {
    public static final WidgetGuildScheduledEventDetailsExtrasBottomSheet2 INSTANCE = new WidgetGuildScheduledEventDetailsExtrasBottomSheet2();

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet2() {
        super(1, WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.cancel_event;
        TextView textView = (TextView) view.findViewById(R.id.cancel_event);
        if (textView != null) {
            i = R.id.copy_id;
            TextView textView2 = (TextView) view.findViewById(R.id.copy_id);
            if (textView2 != null) {
                i = R.id.edit_event;
                TextView textView3 = (TextView) view.findViewById(R.id.edit_event);
                if (textView3 != null) {
                    i = R.id.end_event;
                    TextView textView4 = (TextView) view.findViewById(R.id.end_event);
                    if (textView4 != null) {
                        i = R.id.interested_toggle;
                        TextView textView5 = (TextView) view.findViewById(R.id.interested_toggle);
                        if (textView5 != null) {
                            i = R.id.report_event;
                            TextView textView6 = (TextView) view.findViewById(R.id.report_event);
                            if (textView6 != null) {
                                i = R.id.start_event;
                                TextView textView7 = (TextView) view.findViewById(R.id.start_event);
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
