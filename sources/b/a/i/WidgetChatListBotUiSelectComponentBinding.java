package b.a.i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: renamed from: b.a.i.b5, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListBotUiSelectComponentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListBotUiSelectComponentBinding implements ViewBinding {

    @NonNull
    public final SelectComponentView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f86b;

    @NonNull
    public final TypingDots c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final MaterialTextView e;

    @NonNull
    public final FlexboxLayout f;

    public WidgetChatListBotUiSelectComponentBinding(@NonNull SelectComponentView selectComponentView, @NonNull ImageView imageView, @NonNull TypingDots typingDots, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView, @NonNull FlexboxLayout flexboxLayout) {
        this.a = selectComponentView;
        this.f86b = imageView;
        this.c = typingDots;
        this.d = simpleDraweeView;
        this.e = materialTextView;
        this.f = flexboxLayout;
    }

    @NonNull
    public static WidgetChatListBotUiSelectComponentBinding a(@NonNull View view) {
        int i = R.id.select_component_chevron;
        ImageView imageView = (ImageView) view.findViewById(R.id.select_component_chevron);
        if (imageView != null) {
            i = R.id.select_component_loading;
            TypingDots typingDots = (TypingDots) view.findViewById(R.id.select_component_loading);
            if (typingDots != null) {
                i = R.id.select_component_selection_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.select_component_selection_icon);
                if (simpleDraweeView != null) {
                    i = R.id.select_component_selection_text;
                    MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.select_component_selection_text);
                    if (materialTextView != null) {
                        i = R.id.select_component_selections_root;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R.id.select_component_selections_root);
                        if (flexboxLayout != null) {
                            return new WidgetChatListBotUiSelectComponentBinding((SelectComponentView) view, imageView, typingDots, simpleDraweeView, materialTextView, flexboxLayout);
                        }
                    }
                }
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
