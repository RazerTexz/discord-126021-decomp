package com.discord.widgets.friends;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetFriendsAddByIdBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsAddById$binding$2 extends C12236k implements Function1<View, WidgetFriendsAddByIdBinding> {
    public static final WidgetFriendsAddById$binding$2 INSTANCE = new WidgetFriendsAddById$binding$2();

    public WidgetFriendsAddById$binding$2() {
        super(1, WidgetFriendsAddByIdBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFriendsAddByIdBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.friend_add_username_indicator;
        TextView textView = (TextView) view.findViewById(C5419R.id.friend_add_username_indicator);
        if (textView != null) {
            i = C5419R.id.friends_add_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.friends_add_container);
            if (linearLayout != null) {
                i = C5419R.id.friends_add_send;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.friends_add_send);
                if (materialButton != null) {
                    i = C5419R.id.friends_add_text_edit_wrap;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.friends_add_text_edit_wrap);
                    if (textInputLayout != null) {
                        return new WidgetFriendsAddByIdBinding((NestedScrollView) view, textView, linearLayout, materialButton, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
