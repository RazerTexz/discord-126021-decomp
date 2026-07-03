package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildScheduledEventLocationSelectBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventLocationSelect$binding$2 extends C12236k implements Function1<View, WidgetGuildScheduledEventLocationSelectBinding> {
    public static final WidgetGuildScheduledEventLocationSelect$binding$2 INSTANCE = new WidgetGuildScheduledEventLocationSelect$binding$2();

    public WidgetGuildScheduledEventLocationSelect$binding$2() {
        super(1, WidgetGuildScheduledEventLocationSelectBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildScheduledEventLocationSelectBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channel_location_input;
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.channel_location_input);
        if (textInputEditText != null) {
            i = C5419R.id.channel_location_layout;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.channel_location_layout);
            if (textInputLayout != null) {
                i = C5419R.id.close_button;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.close_button);
                if (imageView != null) {
                    i = C5419R.id.external_divider;
                    View viewFindViewById = view.findViewById(C5419R.id.external_divider);
                    if (viewFindViewById != null) {
                        i = C5419R.id.external_location_input;
                        TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(C5419R.id.external_location_input);
                        if (textInputEditText2 != null) {
                            i = C5419R.id.external_location_layout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C5419R.id.external_location_layout);
                            if (textInputLayout2 != null) {
                                i = C5419R.id.external_option;
                                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.external_option);
                                if (checkedSetting != null) {
                                    i = C5419R.id.guild_scheduled_event_settings_scroll_view;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(C5419R.id.guild_scheduled_event_settings_scroll_view);
                                    if (nestedScrollView != null) {
                                        i = C5419R.id.location_header;
                                        TextView textView = (TextView) view.findViewById(C5419R.id.location_header);
                                        if (textView != null) {
                                            i = C5419R.id.location_options;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.location_options);
                                            if (linearLayout != null) {
                                                i = C5419R.id.next_button;
                                                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.next_button);
                                                if (materialButton != null) {
                                                    i = C5419R.id.stage_channel_option;
                                                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.stage_channel_option);
                                                    if (checkedSetting2 != null) {
                                                        i = C5419R.id.step_text;
                                                        TextView textView2 = (TextView) view.findViewById(C5419R.id.step_text);
                                                        if (textView2 != null) {
                                                            i = C5419R.id.title_view;
                                                            ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.title_view);
                                                            if (screenTitleView != null) {
                                                                i = C5419R.id.toolbar;
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.toolbar);
                                                                if (constraintLayout != null) {
                                                                    i = C5419R.id.voice_channel_divider;
                                                                    View viewFindViewById2 = view.findViewById(C5419R.id.voice_channel_divider);
                                                                    if (viewFindViewById2 != null) {
                                                                        i = C5419R.id.voice_channel_option;
                                                                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.voice_channel_option);
                                                                        if (checkedSetting3 != null) {
                                                                            return new WidgetGuildScheduledEventLocationSelectBinding((ConstraintLayout) view, textInputEditText, textInputLayout, imageView, viewFindViewById, textInputEditText2, textInputLayout2, checkedSetting, nestedScrollView, textView, linearLayout, materialButton, checkedSetting2, textView2, screenTitleView, constraintLayout, viewFindViewById2, checkedSetting3);
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
