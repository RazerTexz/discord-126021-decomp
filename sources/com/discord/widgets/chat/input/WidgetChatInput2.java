package com.discord.widgets.chat.input;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.WidgetChatInputCommunicationDisabledGuardBinding;
import b.a.i.WidgetChatInputGuardBinding;
import b.a.i.WidgetChatInputMemberVerificationGuardBinding;
import com.discord.R;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.databinding.WidgetChatInputBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput2 extends FunctionReferenceImpl implements Function1<View, WidgetChatInputBinding> {
    public static final WidgetChatInput2 INSTANCE = new WidgetChatInput2();

    public WidgetChatInput2() {
        super(1, WidgetChatInputBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatInputBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChatInputBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.application_commands_root;
        View viewFindViewById = view.findViewById(R.id.application_commands_root);
        if (viewFindViewById != null) {
            int i2 = R.id.chat_input_application_commands_option_description;
            TextView textView = (TextView) viewFindViewById.findViewById(R.id.chat_input_application_commands_option_description);
            if (textView != null) {
                i2 = R.id.chat_input_application_commands_recycler;
                RecyclerView recyclerView = (RecyclerView) viewFindViewById.findViewById(R.id.chat_input_application_commands_recycler);
                if (recyclerView != null) {
                    i2 = R.id.divider;
                    View viewFindViewById2 = viewFindViewById.findViewById(R.id.divider);
                    if (viewFindViewById2 != null) {
                        WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = new WidgetChatInputApplicationCommandsBinding((ConstraintLayout) viewFindViewById, textView, recyclerView, viewFindViewById2);
                        i = R.id.chat_input_categories_recycler;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.chat_input_categories_recycler);
                        if (recyclerView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            i = R.id.chat_input_context_bar;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.chat_input_context_bar);
                            if (relativeLayout != null) {
                                i = R.id.chat_input_context_cancel;
                                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view.findViewById(R.id.chat_input_context_cancel);
                                if (appCompatImageButton != null) {
                                    i = R.id.chat_input_context_description;
                                    TextView textView2 = (TextView) view.findViewById(R.id.chat_input_context_description);
                                    if (textView2 != null) {
                                        i = R.id.chat_input_context_reply_mention_button;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.chat_input_context_reply_mention_button);
                                        if (linearLayout2 != null) {
                                            i = R.id.chat_input_context_reply_mention_button_image;
                                            ImageView imageView = (ImageView) view.findViewById(R.id.chat_input_context_reply_mention_button_image);
                                            if (imageView != null) {
                                                i = R.id.chat_input_context_reply_mention_button_text;
                                                TextView textView3 = (TextView) view.findViewById(R.id.chat_input_context_reply_mention_button_text);
                                                if (textView3 != null) {
                                                    i = R.id.chat_input_emoji_matching_header;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.chat_input_emoji_matching_header);
                                                    if (textView4 != null) {
                                                        i = R.id.chat_input_mentions_recycler;
                                                        RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.chat_input_mentions_recycler);
                                                        if (recyclerView3 != null) {
                                                            i = R.id.chat_input_stickers_container;
                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.chat_input_stickers_container);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.chat_input_stickers_matching_header;
                                                                TextView textView5 = (TextView) view.findViewById(R.id.chat_input_stickers_matching_header);
                                                                if (textView5 != null) {
                                                                    i = R.id.chat_input_stickers_recycler;
                                                                    RecyclerView recyclerView4 = (RecyclerView) view.findViewById(R.id.chat_input_stickers_recycler);
                                                                    if (recyclerView4 != null) {
                                                                        i = R.id.chat_input_widget;
                                                                        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.chat_input_widget);
                                                                        if (fragmentContainerView != null) {
                                                                            i = R.id.chat_input_wrap;
                                                                            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.chat_input_wrap);
                                                                            if (linearLayout4 != null) {
                                                                                i = R.id.guard;
                                                                                View viewFindViewById3 = view.findViewById(R.id.guard);
                                                                                if (viewFindViewById3 != null) {
                                                                                    int i3 = R.id.chat_input_guard_action;
                                                                                    MaterialButton materialButton = (MaterialButton) viewFindViewById3.findViewById(R.id.chat_input_guard_action);
                                                                                    if (materialButton != null) {
                                                                                        i3 = R.id.chat_input_guard_action_secondary;
                                                                                        MaterialButton materialButton2 = (MaterialButton) viewFindViewById3.findViewById(R.id.chat_input_guard_action_secondary);
                                                                                        if (materialButton2 != null) {
                                                                                            i3 = R.id.chat_input_guard_subtext;
                                                                                            TextView textView6 = (TextView) viewFindViewById3.findViewById(R.id.chat_input_guard_subtext);
                                                                                            if (textView6 != null) {
                                                                                                i3 = R.id.chat_input_guard_text;
                                                                                                TextView textView7 = (TextView) viewFindViewById3.findViewById(R.id.chat_input_guard_text);
                                                                                                if (textView7 != null) {
                                                                                                    WidgetChatInputGuardBinding widgetChatInputGuardBinding = new WidgetChatInputGuardBinding((LinearLayout) viewFindViewById3, materialButton, materialButton2, textView6, textView7);
                                                                                                    View viewFindViewById4 = view.findViewById(R.id.guard_communication_disabled);
                                                                                                    if (viewFindViewById4 != null) {
                                                                                                        int i4 = R.id.chat_input_communication_disabled_guard;
                                                                                                        CardView cardView = (CardView) viewFindViewById4.findViewById(R.id.chat_input_communication_disabled_guard);
                                                                                                        if (cardView != null) {
                                                                                                            i4 = R.id.chat_input_communication_disabled_guard_header_text;
                                                                                                            TextView textView8 = (TextView) viewFindViewById4.findViewById(R.id.chat_input_communication_disabled_guard_header_text);
                                                                                                            if (textView8 != null) {
                                                                                                                i4 = R.id.chat_input_communication_disabled_guard_icon;
                                                                                                                ImageView imageView2 = (ImageView) viewFindViewById4.findViewById(R.id.chat_input_communication_disabled_guard_icon);
                                                                                                                if (imageView2 != null) {
                                                                                                                    i4 = R.id.chat_input_communication_disabled_guard_text;
                                                                                                                    TextView textView9 = (TextView) viewFindViewById4.findViewById(R.id.chat_input_communication_disabled_guard_text);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i4 = R.id.chat_input_communication_disabled_guard_timer_text;
                                                                                                                        TextView textView10 = (TextView) viewFindViewById4.findViewById(R.id.chat_input_communication_disabled_guard_timer_text);
                                                                                                                        if (textView10 != null) {
                                                                                                                            WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = new WidgetChatInputCommunicationDisabledGuardBinding((RelativeLayout) viewFindViewById4, cardView, textView8, imageView2, textView9, textView10);
                                                                                                                            View viewFindViewById5 = view.findViewById(R.id.guard_member_verification);
                                                                                                                            if (viewFindViewById5 != null) {
                                                                                                                                int i5 = R.id.chat_input_member_verification_guard;
                                                                                                                                CardView cardView2 = (CardView) viewFindViewById5.findViewById(R.id.chat_input_member_verification_guard);
                                                                                                                                if (cardView2 != null) {
                                                                                                                                    i5 = R.id.chat_input_member_verification_guard_action;
                                                                                                                                    ImageView imageView3 = (ImageView) viewFindViewById5.findViewById(R.id.chat_input_member_verification_guard_action);
                                                                                                                                    if (imageView3 != null) {
                                                                                                                                        i5 = R.id.chat_input_member_verification_guard_button;
                                                                                                                                        MaterialButton materialButton3 = (MaterialButton) viewFindViewById5.findViewById(R.id.chat_input_member_verification_guard_button);
                                                                                                                                        if (materialButton3 != null) {
                                                                                                                                            i5 = R.id.chat_input_member_verification_guard_icon;
                                                                                                                                            ImageView imageView4 = (ImageView) viewFindViewById5.findViewById(R.id.chat_input_member_verification_guard_icon);
                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                i5 = R.id.chat_input_member_verification_guard_text;
                                                                                                                                                TextView textView11 = (TextView) viewFindViewById5.findViewById(R.id.chat_input_member_verification_guard_text);
                                                                                                                                                if (textView11 != null) {
                                                                                                                                                    return new WidgetChatInputBinding(linearLayout, widgetChatInputApplicationCommandsBinding, recyclerView2, linearLayout, relativeLayout, appCompatImageButton, textView2, linearLayout2, imageView, textView3, textView4, recyclerView3, linearLayout3, textView5, recyclerView4, fragmentContainerView, linearLayout4, widgetChatInputGuardBinding, widgetChatInputCommunicationDisabledGuardBinding, new WidgetChatInputMemberVerificationGuardBinding((RelativeLayout) viewFindViewById5, cardView2, imageView3, materialButton3, imageView4, textView11));
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById5.getResources().getResourceName(i5)));
                                                                                                                            }
                                                                                                                            i = R.id.guard_member_verification;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById4.getResources().getResourceName(i4)));
                                                                                                    }
                                                                                                    i = R.id.guard_communication_disabled;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i3)));
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
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
