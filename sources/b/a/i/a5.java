package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: compiled from: WidgetChatListBotUiActionRowComponentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class a5 implements ViewBinding {

    @NonNull
    public final ActionRowComponentView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f78b;

    @NonNull
    public final m2 c;

    public a5(@NonNull ActionRowComponentView actionRowComponentView, @NonNull FlexboxLayout flexboxLayout, @NonNull m2 m2Var) {
        this.a = actionRowComponentView;
        this.f78b = flexboxLayout;
        this.c = m2Var;
    }

    @NonNull
    public static a5 a(@NonNull View view) {
        int i = R$id.action_row_component_view_group;
        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R$id.action_row_component_view_group);
        if (flexboxLayout != null) {
            i = R$id.action_row_component_view_group_error_row;
            View viewFindViewById = view.findViewById(R$id.action_row_component_view_group_error_row);
            if (viewFindViewById != null) {
                int i2 = R$id.view_interaction_failed_label_icon;
                ImageView imageView = (ImageView) viewFindViewById.findViewById(R$id.view_interaction_failed_label_icon);
                if (imageView != null) {
                    i2 = R$id.view_interaction_failed_label_message;
                    TextView textView = (TextView) viewFindViewById.findViewById(R$id.view_interaction_failed_label_message);
                    if (textView != null) {
                        return new a5((ActionRowComponentView) view, flexboxLayout, new m2((ConstraintLayout) viewFindViewById, imageView, textView));
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
