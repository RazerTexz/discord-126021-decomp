package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.j0;
import b.a.i.k0;
import b.a.i.l0;
import b.a.i.m0;
import b.a.i.n0;
import b.a.i.o0;
import b.a.i.p0;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetContactSyncBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CodeVerificationView;
import com.discord.views.LoadingButton;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetContactSync$binding$2 extends k implements Function1<View, WidgetContactSyncBinding> {
    public static final WidgetContactSync$binding$2 INSTANCE = new WidgetContactSync$binding$2();

    public WidgetContactSync$binding$2() {
        super(1, WidgetContactSyncBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetContactSyncBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetContactSyncBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetContactSyncBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.contact_sync_add_phone;
        View viewFindViewById = view.findViewById(R$id.contact_sync_add_phone);
        if (viewFindViewById != null) {
            int i2 = R$id.contact_sync_add_phone_input;
            PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) viewFindViewById.findViewById(R$id.contact_sync_add_phone_input);
            if (phoneOrEmailInputView != null) {
                i2 = R$id.contact_sync_add_phone_next;
                MaterialButton materialButton = (MaterialButton) viewFindViewById.findViewById(R$id.contact_sync_add_phone_next);
                if (materialButton != null) {
                    i2 = R$id.contact_sync_add_phone_subtitle;
                    TextView textView = (TextView) viewFindViewById.findViewById(R$id.contact_sync_add_phone_subtitle);
                    if (textView != null) {
                        i2 = R$id.contact_sync_add_phone_title;
                        TextView textView2 = (TextView) viewFindViewById.findViewById(R$id.contact_sync_add_phone_title);
                        if (textView2 != null) {
                            j0 j0Var = new j0((ConstraintLayout) viewFindViewById, phoneOrEmailInputView, materialButton, textView, textView2);
                            i = R$id.contact_sync_friend_suggestions;
                            View viewFindViewById2 = view.findViewById(R$id.contact_sync_friend_suggestions);
                            if (viewFindViewById2 != null) {
                                int i3 = R$id.contact_sync_suggestions_list_recycler;
                                RecyclerView recyclerView = (RecyclerView) viewFindViewById2.findViewById(R$id.contact_sync_suggestions_list_recycler);
                                if (recyclerView != null) {
                                    i3 = R$id.contact_sync_suggestions_submit_button;
                                    LoadingButton loadingButton = (LoadingButton) viewFindViewById2.findViewById(R$id.contact_sync_suggestions_submit_button);
                                    if (loadingButton != null) {
                                        i3 = R$id.contact_sync_suggestions_subtitle;
                                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById2.findViewById(R$id.contact_sync_suggestions_subtitle);
                                        if (linkifiedTextView != null) {
                                            i3 = R$id.contact_sync_suggestions_title;
                                            TextView textView3 = (TextView) viewFindViewById2.findViewById(R$id.contact_sync_suggestions_title);
                                            if (textView3 != null) {
                                                m0 m0Var = new m0((ConstraintLayout) viewFindViewById2, recyclerView, loadingButton, linkifiedTextView, textView3);
                                                i = R$id.contact_sync_friend_suggestions_empty;
                                                View viewFindViewById3 = view.findViewById(R$id.contact_sync_friend_suggestions_empty);
                                                if (viewFindViewById3 != null) {
                                                    int i4 = R$id.contact_sync_suggestions_empty_subtitle;
                                                    TextView textView4 = (TextView) viewFindViewById3.findViewById(R$id.contact_sync_suggestions_empty_subtitle);
                                                    if (textView4 != null) {
                                                        i4 = R$id.contact_sync_suggestions_empty_title;
                                                        TextView textView5 = (TextView) viewFindViewById3.findViewById(R$id.contact_sync_suggestions_empty_title);
                                                        if (textView5 != null) {
                                                            i4 = R$id.contact_sync_suggestions_invite_button;
                                                            MaterialButton materialButton2 = (MaterialButton) viewFindViewById3.findViewById(R$id.contact_sync_suggestions_invite_button);
                                                            if (materialButton2 != null) {
                                                                i4 = R$id.contact_sync_suggestions_skip_button;
                                                                MaterialButton materialButton3 = (MaterialButton) viewFindViewById3.findViewById(R$id.contact_sync_suggestions_skip_button);
                                                                if (materialButton3 != null) {
                                                                    n0 n0Var = new n0((ConstraintLayout) viewFindViewById3, textView4, textView5, materialButton2, materialButton3);
                                                                    i = R$id.contact_sync_landing;
                                                                    View viewFindViewById4 = view.findViewById(R$id.contact_sync_landing);
                                                                    if (viewFindViewById4 != null) {
                                                                        int i5 = R$id.contact_sync_landing_cta;
                                                                        LinearLayout linearLayout = (LinearLayout) viewFindViewById4.findViewById(R$id.contact_sync_landing_cta);
                                                                        if (linearLayout != null) {
                                                                            i5 = R$id.contact_sync_landing_needs_permissions;
                                                                            TextView textView6 = (TextView) viewFindViewById4.findViewById(R$id.contact_sync_landing_needs_permissions);
                                                                            if (textView6 != null) {
                                                                                i5 = R$id.contact_sync_landing_next_button;
                                                                                LoadingButton loadingButton2 = (LoadingButton) viewFindViewById4.findViewById(R$id.contact_sync_landing_next_button);
                                                                                if (loadingButton2 != null) {
                                                                                    i5 = R$id.contact_sync_landing_permissions_divider;
                                                                                    View viewFindViewById5 = viewFindViewById4.findViewById(R$id.contact_sync_landing_permissions_divider);
                                                                                    if (viewFindViewById5 != null) {
                                                                                        i5 = R$id.contact_sync_landing_subtitle;
                                                                                        TextView textView7 = (TextView) viewFindViewById4.findViewById(R$id.contact_sync_landing_subtitle);
                                                                                        if (textView7 != null) {
                                                                                            i5 = R$id.contact_sync_landing_title;
                                                                                            TextView textView8 = (TextView) viewFindViewById4.findViewById(R$id.contact_sync_landing_title);
                                                                                            if (textView8 != null) {
                                                                                                i5 = R$id.contact_sync_landing_toggle_info;
                                                                                                View viewFindViewById6 = viewFindViewById4.findViewById(R$id.contact_sync_landing_toggle_info);
                                                                                                if (viewFindViewById6 != null) {
                                                                                                    k0 k0Var = new k0((ConstraintLayout) viewFindViewById4, linearLayout, textView6, loadingButton2, viewFindViewById5, textView7, textView8, o0.a(viewFindViewById6));
                                                                                                    View viewFindViewById7 = view.findViewById(R$id.contact_sync_name);
                                                                                                    if (viewFindViewById7 != null) {
                                                                                                        int i6 = R$id.contact_sync_name_input;
                                                                                                        TextInputEditText textInputEditText = (TextInputEditText) viewFindViewById7.findViewById(R$id.contact_sync_name_input);
                                                                                                        if (textInputEditText != null) {
                                                                                                            i6 = R$id.contact_sync_name_input_wrap;
                                                                                                            TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById7.findViewById(R$id.contact_sync_name_input_wrap);
                                                                                                            if (textInputLayout != null) {
                                                                                                                i6 = R$id.contact_sync_name_next_button;
                                                                                                                LoadingButton loadingButton3 = (LoadingButton) viewFindViewById7.findViewById(R$id.contact_sync_name_next_button);
                                                                                                                if (loadingButton3 != null) {
                                                                                                                    i6 = R$id.contact_sync_name_prefill_hint;
                                                                                                                    TextView textView9 = (TextView) viewFindViewById7.findViewById(R$id.contact_sync_name_prefill_hint);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i6 = R$id.contact_sync_name_subtitle;
                                                                                                                        TextView textView10 = (TextView) viewFindViewById7.findViewById(R$id.contact_sync_name_subtitle);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i6 = R$id.contact_sync_name_title;
                                                                                                                            TextView textView11 = (TextView) viewFindViewById7.findViewById(R$id.contact_sync_name_title);
                                                                                                                            if (textView11 != null) {
                                                                                                                                l0 l0Var = new l0((ConstraintLayout) viewFindViewById7, textInputEditText, textInputLayout, loadingButton3, textView9, textView10, textView11);
                                                                                                                                View viewFindViewById8 = view.findViewById(R$id.contact_sync_verify_phone);
                                                                                                                                if (viewFindViewById8 != null) {
                                                                                                                                    int i7 = R$id.contact_sync_verify_phone_code;
                                                                                                                                    CodeVerificationView codeVerificationView = (CodeVerificationView) viewFindViewById8.findViewById(R$id.contact_sync_verify_phone_code);
                                                                                                                                    if (codeVerificationView != null) {
                                                                                                                                        i7 = R$id.contact_sync_verify_phone_subtitle;
                                                                                                                                        TextView textView12 = (TextView) viewFindViewById8.findViewById(R$id.contact_sync_verify_phone_subtitle);
                                                                                                                                        if (textView12 != null) {
                                                                                                                                            i7 = R$id.contact_sync_verify_phone_title;
                                                                                                                                            TextView textView13 = (TextView) viewFindViewById8.findViewById(R$id.contact_sync_verify_phone_title);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                p0 p0Var = new p0((ConstraintLayout) viewFindViewById8, codeVerificationView, textView12, textView13);
                                                                                                                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.contact_sync_view_flipper);
                                                                                                                                                if (appViewFlipper != null) {
                                                                                                                                                    return new WidgetContactSyncBinding((CoordinatorLayout) view, j0Var, m0Var, n0Var, k0Var, l0Var, p0Var, appViewFlipper);
                                                                                                                                                }
                                                                                                                                                i = R$id.contact_sync_view_flipper;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById8.getResources().getResourceName(i7)));
                                                                                                                                }
                                                                                                                                i = R$id.contact_sync_verify_phone;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById7.getResources().getResourceName(i6)));
                                                                                                    }
                                                                                                    i = R$id.contact_sync_name;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById4.getResources().getResourceName(i5)));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i4)));
                                                }
                                            }
                                        }
                                    }
                                }
                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i3)));
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
