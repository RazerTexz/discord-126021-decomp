package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChatListActionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListActions4 extends FunctionReferenceImpl implements Function1<View, WidgetChatListActionsBinding> {
    public static final WidgetChatListActions4 INSTANCE = new WidgetChatListActions4();

    public WidgetChatListActions4() {
        super(1, WidgetChatListActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatListActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChatListActionsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dialog_chat_actions_add_reaction_emojis_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dialog_chat_actions_add_reaction_emojis_list);
        if (recyclerView != null) {
            i = R.id.dialog_chat_actions_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.dialog_chat_actions_container);
            if (linearLayout != null) {
                i = R.id.dialog_chat_actions_copy;
                TextView textView = (TextView) view.findViewById(R.id.dialog_chat_actions_copy);
                if (textView != null) {
                    i = R.id.dialog_chat_actions_copy_id;
                    TextView textView2 = (TextView) view.findViewById(R.id.dialog_chat_actions_copy_id);
                    if (textView2 != null) {
                        i = R.id.dialog_chat_actions_delete;
                        TextView textView3 = (TextView) view.findViewById(R.id.dialog_chat_actions_delete);
                        if (textView3 != null) {
                            i = R.id.dialog_chat_actions_edit;
                            TextView textView4 = (TextView) view.findViewById(R.id.dialog_chat_actions_edit);
                            if (textView4 != null) {
                                i = R.id.dialog_chat_actions_manage_reactions;
                                TextView textView5 = (TextView) view.findViewById(R.id.dialog_chat_actions_manage_reactions);
                                if (textView5 != null) {
                                    i = R.id.dialog_chat_actions_mark_unread;
                                    TextView textView6 = (TextView) view.findViewById(R.id.dialog_chat_actions_mark_unread);
                                    if (textView6 != null) {
                                        i = R.id.dialog_chat_actions_pin;
                                        TextView textView7 = (TextView) view.findViewById(R.id.dialog_chat_actions_pin);
                                        if (textView7 != null) {
                                            i = R.id.dialog_chat_actions_profile;
                                            TextView textView8 = (TextView) view.findViewById(R.id.dialog_chat_actions_profile);
                                            if (textView8 != null) {
                                                i = R.id.dialog_chat_actions_publish;
                                                TextView textView9 = (TextView) view.findViewById(R.id.dialog_chat_actions_publish);
                                                if (textView9 != null) {
                                                    i = R.id.dialog_chat_actions_remove_all_reactions;
                                                    TextView textView10 = (TextView) view.findViewById(R.id.dialog_chat_actions_remove_all_reactions);
                                                    if (textView10 != null) {
                                                        i = R.id.dialog_chat_actions_reply;
                                                        TextView textView11 = (TextView) view.findViewById(R.id.dialog_chat_actions_reply);
                                                        if (textView11 != null) {
                                                            i = R.id.dialog_chat_actions_report;
                                                            TextView textView12 = (TextView) view.findViewById(R.id.dialog_chat_actions_report);
                                                            if (textView12 != null) {
                                                                i = R.id.dialog_chat_actions_resend;
                                                                TextView textView13 = (TextView) view.findViewById(R.id.dialog_chat_actions_resend);
                                                                if (textView13 != null) {
                                                                    i = R.id.dialog_chat_actions_share;
                                                                    TextView textView14 = (TextView) view.findViewById(R.id.dialog_chat_actions_share);
                                                                    if (textView14 != null) {
                                                                        i = R.id.dialog_chat_actions_start_thread;
                                                                        TextView textView15 = (TextView) view.findViewById(R.id.dialog_chat_actions_start_thread);
                                                                        if (textView15 != null) {
                                                                            return new WidgetChatListActionsBinding((NestedScrollView) view, recyclerView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
