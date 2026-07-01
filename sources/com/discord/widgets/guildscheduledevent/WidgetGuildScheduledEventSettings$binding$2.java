package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildScheduledEventSettingsBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventSettings$binding$2 extends k implements Function1<View, WidgetGuildScheduledEventSettingsBinding> {
    public static final WidgetGuildScheduledEventSettings$binding$2 INSTANCE = new WidgetGuildScheduledEventSettings$binding$2();

    public WidgetGuildScheduledEventSettings$binding$2() {
        super(1, WidgetGuildScheduledEventSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventSettingsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventSettingsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.back_button;
        ImageView imageView = (ImageView) view.findViewById(R$id.back_button);
        if (imageView != null) {
            i = R$id.close_button;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.close_button);
            if (imageView2 != null) {
                i = R$id.end_date_header;
                TextView textView = (TextView) view.findViewById(R$id.end_date_header);
                if (textView != null) {
                    i = R$id.end_date_input;
                    TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.end_date_input);
                    if (textInputEditText != null) {
                        i = R$id.end_date_layout;
                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.end_date_layout);
                        if (textInputLayout != null) {
                            i = R$id.end_time_header;
                            TextView textView2 = (TextView) view.findViewById(R$id.end_time_header);
                            if (textView2 != null) {
                                i = R$id.end_time_input;
                                TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(R$id.end_time_input);
                                if (textInputEditText2 != null) {
                                    i = R$id.end_time_layout;
                                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R$id.end_time_layout);
                                    if (textInputLayout2 != null) {
                                        i = R$id.guild_scheduled_event_settings_description_header;
                                        TextView textView3 = (TextView) view.findViewById(R$id.guild_scheduled_event_settings_description_header);
                                        if (textView3 != null) {
                                            i = R$id.guild_scheduled_event_settings_description_input;
                                            TextInputEditText textInputEditText3 = (TextInputEditText) view.findViewById(R$id.guild_scheduled_event_settings_description_input);
                                            if (textInputEditText3 != null) {
                                                i = R$id.guild_scheduled_event_settings_description_input_layout;
                                                TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(R$id.guild_scheduled_event_settings_description_input_layout);
                                                if (textInputLayout3 != null) {
                                                    i = R$id.guild_scheduled_event_settings_next_button;
                                                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.guild_scheduled_event_settings_next_button);
                                                    if (materialButton != null) {
                                                        i = R$id.guild_scheduled_event_settings_scroll_view;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R$id.guild_scheduled_event_settings_scroll_view);
                                                        if (nestedScrollView != null) {
                                                            i = R$id.guild_scheduled_event_settings_start_date_header;
                                                            TextView textView4 = (TextView) view.findViewById(R$id.guild_scheduled_event_settings_start_date_header);
                                                            if (textView4 != null) {
                                                                i = R$id.guild_scheduled_event_settings_start_date_input;
                                                                TextInputEditText textInputEditText4 = (TextInputEditText) view.findViewById(R$id.guild_scheduled_event_settings_start_date_input);
                                                                if (textInputEditText4 != null) {
                                                                    i = R$id.guild_scheduled_event_settings_start_date_input_layout;
                                                                    TextInputLayout textInputLayout4 = (TextInputLayout) view.findViewById(R$id.guild_scheduled_event_settings_start_date_input_layout);
                                                                    if (textInputLayout4 != null) {
                                                                        i = R$id.guild_scheduled_event_settings_start_time_header;
                                                                        TextView textView5 = (TextView) view.findViewById(R$id.guild_scheduled_event_settings_start_time_header);
                                                                        if (textView5 != null) {
                                                                            i = R$id.guild_scheduled_event_settings_start_time_input;
                                                                            TextInputEditText textInputEditText5 = (TextInputEditText) view.findViewById(R$id.guild_scheduled_event_settings_start_time_input);
                                                                            if (textInputEditText5 != null) {
                                                                                i = R$id.guild_scheduled_event_settings_start_time_input_layout;
                                                                                TextInputLayout textInputLayout5 = (TextInputLayout) view.findViewById(R$id.guild_scheduled_event_settings_start_time_input_layout);
                                                                                if (textInputLayout5 != null) {
                                                                                    i = R$id.guild_scheduled_event_settings_step_text;
                                                                                    TextView textView6 = (TextView) view.findViewById(R$id.guild_scheduled_event_settings_step_text);
                                                                                    if (textView6 != null) {
                                                                                        i = R$id.guild_scheduled_event_settings_stv;
                                                                                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.guild_scheduled_event_settings_stv);
                                                                                        if (screenTitleView != null) {
                                                                                            i = R$id.guild_scheduled_event_settings_toolbar;
                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.guild_scheduled_event_settings_toolbar);
                                                                                            if (constraintLayout != null) {
                                                                                                i = R$id.guild_scheduled_event_settings_topic_header;
                                                                                                TextView textView7 = (TextView) view.findViewById(R$id.guild_scheduled_event_settings_topic_header);
                                                                                                if (textView7 != null) {
                                                                                                    i = R$id.guild_scheduled_event_settings_topic_input;
                                                                                                    TextInputEditText textInputEditText6 = (TextInputEditText) view.findViewById(R$id.guild_scheduled_event_settings_topic_input);
                                                                                                    if (textInputEditText6 != null) {
                                                                                                        i = R$id.guild_scheduled_event_settings_topic_layout;
                                                                                                        TextInputLayout textInputLayout6 = (TextInputLayout) view.findViewById(R$id.guild_scheduled_event_settings_topic_layout);
                                                                                                        if (textInputLayout6 != null) {
                                                                                                            i = R$id.guild_scheduled_event_settings_visibility_checkbox;
                                                                                                            MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R$id.guild_scheduled_event_settings_visibility_checkbox);
                                                                                                            if (materialCheckBox != null) {
                                                                                                                i = R$id.guild_scheduled_event_settings_visibility_container;
                                                                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.guild_scheduled_event_settings_visibility_container);
                                                                                                                if (linearLayout != null) {
                                                                                                                    i = R$id.guild_scheduled_event_settings_visibility_container_disabled;
                                                                                                                    View viewFindViewById = view.findViewById(R$id.guild_scheduled_event_settings_visibility_container_disabled);
                                                                                                                    if (viewFindViewById != null) {
                                                                                                                        i = R$id.guild_scheduled_event_settings_visibility_description;
                                                                                                                        TextView textView8 = (TextView) view.findViewById(R$id.guild_scheduled_event_settings_visibility_description);
                                                                                                                        if (textView8 != null) {
                                                                                                                            i = R$id.guild_scheduled_event_settings_visibility_header;
                                                                                                                            TextView textView9 = (TextView) view.findViewById(R$id.guild_scheduled_event_settings_visibility_header);
                                                                                                                            if (textView9 != null) {
                                                                                                                                return new WidgetGuildScheduledEventSettingsBinding((ConstraintLayout) view, imageView, imageView2, textView, textInputEditText, textInputLayout, textView2, textInputEditText2, textInputLayout2, textView3, textInputEditText3, textInputLayout3, materialButton, nestedScrollView, textView4, textInputEditText4, textInputLayout4, textView5, textInputEditText5, textInputLayout5, textView6, screenTitleView, constraintLayout, textView7, textInputEditText6, textInputLayout6, materialCheckBox, linearLayout, viewFindViewById, textView8, textView9);
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
