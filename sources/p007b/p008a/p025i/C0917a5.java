package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: renamed from: b.a.i.a5 */
/* JADX INFO: compiled from: WidgetChatListBotUiActionRowComponentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0917a5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ActionRowComponentView f679a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FlexboxLayout f680b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1005m2 f681c;

    public C0917a5(@NonNull ActionRowComponentView actionRowComponentView, @NonNull FlexboxLayout flexboxLayout, @NonNull C1005m2 c1005m2) {
        this.f679a = actionRowComponentView;
        this.f680b = flexboxLayout;
        this.f681c = c1005m2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C0917a5 m195a(@NonNull View view) {
        int i = C5419R.id.action_row_component_view_group;
        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(C5419R.id.action_row_component_view_group);
        if (flexboxLayout != null) {
            i = C5419R.id.action_row_component_view_group_error_row;
            View viewFindViewById = view.findViewById(C5419R.id.action_row_component_view_group_error_row);
            if (viewFindViewById != null) {
                int i2 = C5419R.id.view_interaction_failed_label_icon;
                ImageView imageView = (ImageView) viewFindViewById.findViewById(C5419R.id.view_interaction_failed_label_icon);
                if (imageView != null) {
                    i2 = C5419R.id.view_interaction_failed_label_message;
                    TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.view_interaction_failed_label_message);
                    if (textView != null) {
                        return new C0917a5((ActionRowComponentView) view, flexboxLayout, new C1005m2((ConstraintLayout) viewFindViewById, imageView, textView));
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
        return this.f679a;
    }
}
