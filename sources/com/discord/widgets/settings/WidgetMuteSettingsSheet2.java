package com.discord.widgets.settings;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetMuteSettingsSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMuteSettingsSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetMuteSettingsSheetBinding> {
    public static final WidgetMuteSettingsSheet2 INSTANCE = new WidgetMuteSettingsSheet2();

    public WidgetMuteSettingsSheet2() {
        super(1, WidgetMuteSettingsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetMuteSettingsSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_muted_details;
        TextView textView = (TextView) view.findViewById(R.id.channel_muted_details);
        if (textView != null) {
            i = R.id.mute_settings_sheet_mute_options;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mute_settings_sheet_mute_options);
            if (linearLayout != null) {
                i = R.id.notification_settings_button;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.notification_settings_button);
                if (linearLayout2 != null) {
                    i = R.id.notification_settings_button_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.notification_settings_button_container);
                    if (frameLayout != null) {
                        i = R.id.notification_settings_label;
                        TextView textView2 = (TextView) view.findViewById(R.id.notification_settings_label);
                        if (textView2 != null) {
                            i = R.id.notification_settings_overrides_label;
                            TextView textView3 = (TextView) view.findViewById(R.id.notification_settings_overrides_label);
                            if (textView3 != null) {
                                i = R.id.option_always;
                                TextView textView4 = (TextView) view.findViewById(R.id.option_always);
                                if (textView4 != null) {
                                    i = R.id.option_eight_hours;
                                    TextView textView5 = (TextView) view.findViewById(R.id.option_eight_hours);
                                    if (textView5 != null) {
                                        i = R.id.option_fifteen_minutes;
                                        TextView textView6 = (TextView) view.findViewById(R.id.option_fifteen_minutes);
                                        if (textView6 != null) {
                                            i = R.id.option_one_hour;
                                            TextView textView7 = (TextView) view.findViewById(R.id.option_one_hour);
                                            if (textView7 != null) {
                                                i = R.id.option_twenty_four_hours;
                                                TextView textView8 = (TextView) view.findViewById(R.id.option_twenty_four_hours);
                                                if (textView8 != null) {
                                                    i = R.id.subtitle;
                                                    TextView textView9 = (TextView) view.findViewById(R.id.subtitle);
                                                    if (textView9 != null) {
                                                        i = R.id.title;
                                                        TextView textView10 = (TextView) view.findViewById(R.id.title);
                                                        if (textView10 != null) {
                                                            i = R.id.unmute_button;
                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.unmute_button);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.unmute_button_details_label;
                                                                TextView textView11 = (TextView) view.findViewById(R.id.unmute_button_details_label);
                                                                if (textView11 != null) {
                                                                    i = R.id.unmute_button_label;
                                                                    TextView textView12 = (TextView) view.findViewById(R.id.unmute_button_label);
                                                                    if (textView12 != null) {
                                                                        return new WidgetMuteSettingsSheetBinding((NestedScrollView) view, textView, linearLayout, linearLayout2, frameLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, linearLayout3, textView11, textView12);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
