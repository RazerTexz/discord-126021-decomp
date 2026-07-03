package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetDisableGuildCommunicationBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDisableGuildCommunication$binding$2 extends C12236k implements Function1<View, WidgetDisableGuildCommunicationBinding> {
    public static final WidgetDisableGuildCommunication$binding$2 INSTANCE = new WidgetDisableGuildCommunication$binding$2();

    public WidgetDisableGuildCommunication$binding$2() {
        super(1, WidgetDisableGuildCommunicationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDisableGuildCommunicationBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.disable_confirm;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.disable_confirm);
        if (materialButton != null) {
            i = C5419R.id.disable_guild_communication_body;
            TextView textView = (TextView) view.findViewById(C5419R.id.disable_guild_communication_body);
            if (textView != null) {
                i = C5419R.id.disable_guild_communication_options;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.disable_guild_communication_options);
                if (linearLayout != null) {
                    i = C5419R.id.disable_guild_communication_reason;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.disable_guild_communication_reason);
                    if (textInputLayout != null) {
                        i = C5419R.id.disable_guild_communication_reason_header;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.disable_guild_communication_reason_header);
                        if (textView2 != null) {
                            i = C5419R.id.disable_guild_communication_subtitle;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.disable_guild_communication_subtitle);
                            if (textView3 != null) {
                                i = C5419R.id.disable_guild_communication_title;
                                TextView textView4 = (TextView) view.findViewById(C5419R.id.disable_guild_communication_title);
                                if (textView4 != null) {
                                    i = C5419R.id.divider;
                                    View viewFindViewById = view.findViewById(C5419R.id.divider);
                                    if (viewFindViewById != null) {
                                        i = C5419R.id.label_duration;
                                        TextView textView5 = (TextView) view.findViewById(C5419R.id.label_duration);
                                        if (textView5 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = C5419R.id.time_unit_10_minutes;
                                            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.time_unit_10_minutes);
                                            if (checkedSetting != null) {
                                                i = C5419R.id.time_unit_1_day;
                                                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.time_unit_1_day);
                                                if (checkedSetting2 != null) {
                                                    i = C5419R.id.time_unit_1_hour;
                                                    CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.time_unit_1_hour);
                                                    if (checkedSetting3 != null) {
                                                        i = C5419R.id.time_unit_1_week;
                                                        CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(C5419R.id.time_unit_1_week);
                                                        if (checkedSetting4 != null) {
                                                            i = C5419R.id.time_unit_5_minutes;
                                                            CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(C5419R.id.time_unit_5_minutes);
                                                            if (checkedSetting5 != null) {
                                                                i = C5419R.id.time_unit_60_seconds;
                                                                CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(C5419R.id.time_unit_60_seconds);
                                                                if (checkedSetting6 != null) {
                                                                    return new WidgetDisableGuildCommunicationBinding(constraintLayout, materialButton, textView, linearLayout, textInputLayout, textView2, textView3, textView4, viewFindViewById, textView5, constraintLayout, checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5, checkedSetting6);
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
