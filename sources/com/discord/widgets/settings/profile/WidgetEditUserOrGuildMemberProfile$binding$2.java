package com.discord.widgets.settings.profile;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsUserProfileBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEditUserOrGuildMemberProfile$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsUserProfileBinding> {
    public static final WidgetEditUserOrGuildMemberProfile$binding$2 INSTANCE = new WidgetEditUserOrGuildMemberProfile$binding$2();

    public WidgetEditUserOrGuildMemberProfile$binding$2() {
        super(1, WidgetSettingsUserProfileBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsUserProfileBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.bio_editor_card;
        CardView cardView = (CardView) view.findViewById(R.id.bio_editor_card);
        if (cardView != null) {
            i = R.id.bio_editor_text_input_field;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.bio_editor_text_input_field);
            if (textInputEditText != null) {
                i = R.id.bio_editor_text_input_field_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.bio_editor_text_input_field_wrap);
                if (textInputLayout != null) {
                    i = R.id.bio_header;
                    TextView textView = (TextView) view.findViewById(R.id.bio_header);
                    if (textView != null) {
                        i = R.id.bio_help_text;
                        TextView textView2 = (TextView) view.findViewById(R.id.bio_help_text);
                        if (textView2 != null) {
                            i = R.id.bio_preview_card;
                            CardView cardView2 = (CardView) view.findViewById(R.id.bio_preview_card);
                            if (cardView2 != null) {
                                i = R.id.bio_preview_text;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.bio_preview_text);
                                if (linkifiedTextView != null) {
                                    i = R.id.dimmer_view;
                                    DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                                    if (dimmerView != null) {
                                        i = R.id.guild_member_profile_help_text_overall;
                                        TextView textView3 = (TextView) view.findViewById(R.id.guild_member_profile_help_text_overall);
                                        if (textView3 != null) {
                                            i = R.id.guild_profile_explainer_container;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_profile_explainer_container);
                                            if (linearLayout != null) {
                                                i = R.id.nick_container;
                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.nick_container);
                                                if (linearLayout2 != null) {
                                                    i = R.id.nickname_editor_card;
                                                    CardView cardView3 = (CardView) view.findViewById(R.id.nickname_editor_card);
                                                    if (cardView3 != null) {
                                                        i = R.id.nickname_header;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.nickname_header);
                                                        if (textView4 != null) {
                                                            i = R.id.profile_container;
                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.profile_container);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.save_fab;
                                                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.save_fab);
                                                                if (floatingActionButton != null) {
                                                                    i = R.id.set_nickname_text;
                                                                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.set_nickname_text);
                                                                    if (textInputLayout2 != null) {
                                                                        i = R.id.settings_profile_scroll;
                                                                        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.settings_profile_scroll);
                                                                        if (nestedScrollView != null) {
                                                                            i = R.id.user_settings_profile_header_view;
                                                                            UserProfileHeaderView userProfileHeaderView = (UserProfileHeaderView) view.findViewById(R.id.user_settings_profile_header_view);
                                                                            if (userProfileHeaderView != null) {
                                                                                return new WidgetSettingsUserProfileBinding((TouchInterceptingCoordinatorLayout) view, cardView, textInputEditText, textInputLayout, textView, textView2, cardView2, linkifiedTextView, dimmerView, textView3, linearLayout, linearLayout2, cardView3, textView4, linearLayout3, floatingActionButton, textInputLayout2, nestedScrollView, userProfileHeaderView);
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
