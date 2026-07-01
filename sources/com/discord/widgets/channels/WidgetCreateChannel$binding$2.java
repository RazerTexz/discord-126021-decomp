package com.discord.widgets.channels;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetCreateChannelBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateChannel$binding$2 extends k implements Function1<View, WidgetCreateChannelBinding> {
    public static final WidgetCreateChannel$binding$2 INSTANCE = new WidgetCreateChannel$binding$2();

    public WidgetCreateChannel$binding$2() {
        super(1, WidgetCreateChannelBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateChannelBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCreateChannelBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCreateChannelBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.create_channel_announcements_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.create_channel_announcements_container);
        if (constraintLayout != null) {
            i = R$id.create_channel_announcements_icon;
            ImageView imageView = (ImageView) view.findViewById(R$id.create_channel_announcements_icon);
            if (imageView != null) {
                i = R$id.create_channel_announcements_radio;
                RadioButton radioButton = (RadioButton) view.findViewById(R$id.create_channel_announcements_radio);
                if (radioButton != null) {
                    i = R$id.create_channel_announcements_title;
                    TextView textView = (TextView) view.findViewById(R$id.create_channel_announcements_title);
                    if (textView != null) {
                        i = R$id.create_channel_forum_container;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R$id.create_channel_forum_container);
                        if (constraintLayout2 != null) {
                            i = R$id.create_channel_forum_icon;
                            ImageView imageView2 = (ImageView) view.findViewById(R$id.create_channel_forum_icon);
                            if (imageView2 != null) {
                                i = R$id.create_channel_forum_radio;
                                RadioButton radioButton2 = (RadioButton) view.findViewById(R$id.create_channel_forum_radio);
                                if (radioButton2 != null) {
                                    i = R$id.create_channel_forum_title;
                                    TextView textView2 = (TextView) view.findViewById(R$id.create_channel_forum_title);
                                    if (textView2 != null) {
                                        i = R$id.create_channel_name_layout;
                                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.create_channel_name_layout);
                                        if (textInputLayout != null) {
                                            i = R$id.create_channel_private_container;
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.create_channel_private_container);
                                            if (relativeLayout != null) {
                                                i = R$id.create_channel_private_info;
                                                TextView textView3 = (TextView) view.findViewById(R$id.create_channel_private_info);
                                                if (textView3 != null) {
                                                    i = R$id.create_channel_private_switch;
                                                    SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R$id.create_channel_private_switch);
                                                    if (switchCompat != null) {
                                                        i = R$id.create_channel_private_title;
                                                        TextView textView4 = (TextView) view.findViewById(R$id.create_channel_private_title);
                                                        if (textView4 != null) {
                                                            i = R$id.create_channel_role_access_recycler;
                                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.create_channel_role_access_recycler);
                                                            if (recyclerView != null) {
                                                                i = R$id.create_channel_role_divider;
                                                                View viewFindViewById = view.findViewById(R$id.create_channel_role_divider);
                                                                if (viewFindViewById != null) {
                                                                    i = R$id.create_channel_role_header;
                                                                    TextView textView5 = (TextView) view.findViewById(R$id.create_channel_role_header);
                                                                    if (textView5 != null) {
                                                                        i = R$id.create_channel_stage_container;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R$id.create_channel_stage_container);
                                                                        if (constraintLayout3 != null) {
                                                                            i = R$id.create_channel_stage_icon;
                                                                            ImageView imageView3 = (ImageView) view.findViewById(R$id.create_channel_stage_icon);
                                                                            if (imageView3 != null) {
                                                                                i = R$id.create_channel_stage_radio;
                                                                                RadioButton radioButton3 = (RadioButton) view.findViewById(R$id.create_channel_stage_radio);
                                                                                if (radioButton3 != null) {
                                                                                    i = R$id.create_channel_stage_title;
                                                                                    TextView textView6 = (TextView) view.findViewById(R$id.create_channel_stage_title);
                                                                                    if (textView6 != null) {
                                                                                        i = R$id.create_channel_text_container;
                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R$id.create_channel_text_container);
                                                                                        if (constraintLayout4 != null) {
                                                                                            i = R$id.create_channel_text_icon;
                                                                                            ImageView imageView4 = (ImageView) view.findViewById(R$id.create_channel_text_icon);
                                                                                            if (imageView4 != null) {
                                                                                                i = R$id.create_channel_text_radio;
                                                                                                RadioButton radioButton4 = (RadioButton) view.findViewById(R$id.create_channel_text_radio);
                                                                                                if (radioButton4 != null) {
                                                                                                    i = R$id.create_channel_text_title;
                                                                                                    TextView textView7 = (TextView) view.findViewById(R$id.create_channel_text_title);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R$id.create_channel_type_container;
                                                                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.create_channel_type_container);
                                                                                                        if (linearLayout != null) {
                                                                                                            i = R$id.create_channel_voice_container;
                                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R$id.create_channel_voice_container);
                                                                                                            if (constraintLayout5 != null) {
                                                                                                                i = R$id.create_channel_voice_icon;
                                                                                                                ImageView imageView5 = (ImageView) view.findViewById(R$id.create_channel_voice_icon);
                                                                                                                if (imageView5 != null) {
                                                                                                                    i = R$id.create_channel_voice_radio;
                                                                                                                    RadioButton radioButton5 = (RadioButton) view.findViewById(R$id.create_channel_voice_radio);
                                                                                                                    if (radioButton5 != null) {
                                                                                                                        i = R$id.create_channel_voice_title;
                                                                                                                        TextView textView8 = (TextView) view.findViewById(R$id.create_channel_voice_title);
                                                                                                                        if (textView8 != null) {
                                                                                                                            return new WidgetCreateChannelBinding((CoordinatorLayout) view, constraintLayout, imageView, radioButton, textView, constraintLayout2, imageView2, radioButton2, textView2, textInputLayout, relativeLayout, textView3, switchCompat, textView4, recyclerView, viewFindViewById, textView5, constraintLayout3, imageView3, radioButton3, textView6, constraintLayout4, imageView4, radioButton4, textView7, linearLayout, constraintLayout5, imageView5, radioButton5, textView8);
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
