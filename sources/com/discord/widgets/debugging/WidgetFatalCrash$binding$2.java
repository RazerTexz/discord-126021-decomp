package com.discord.widgets.debugging;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetFatalCrashBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFatalCrash.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFatalCrash$binding$2 extends C12236k implements Function1<View, WidgetFatalCrashBinding> {
    public static final WidgetFatalCrash$binding$2 INSTANCE = new WidgetFatalCrash$binding$2();

    public WidgetFatalCrash$binding$2() {
        super(1, WidgetFatalCrashBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFatalCrashBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFatalCrashBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.fatal_crash_app_version;
        TextView textView = (TextView) view.findViewById(C5419R.id.fatal_crash_app_version);
        if (textView != null) {
            i = C5419R.id.fatal_crash_details;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.fatal_crash_details);
            if (linearLayout != null) {
                i = C5419R.id.fatal_crash_device;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.fatal_crash_device);
                if (textView2 != null) {
                    i = C5419R.id.fatal_crash_os_version;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.fatal_crash_os_version);
                    if (textView3 != null) {
                        i = C5419R.id.fatal_crash_source;
                        TextView textView4 = (TextView) view.findViewById(C5419R.id.fatal_crash_source);
                        if (textView4 != null) {
                            i = C5419R.id.fatal_crash_testers_invite;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.fatal_crash_testers_invite);
                            if (linkifiedTextView != null) {
                                i = C5419R.id.fatal_crash_time;
                                TextView textView5 = (TextView) view.findViewById(C5419R.id.fatal_crash_time);
                                if (textView5 != null) {
                                    return new WidgetFatalCrashBinding((ScrollView) view, textView, linearLayout, textView2, textView3, textView4, linkifiedTextView, textView5);
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
