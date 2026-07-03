package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: renamed from: b.a.i.b5 */
/* JADX INFO: compiled from: WidgetChatListBotUiSelectComponentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0925b5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final SelectComponentView f713a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f714b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TypingDots f715c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f716d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialTextView f717e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FlexboxLayout f718f;

    public C0925b5(@NonNull SelectComponentView selectComponentView, @NonNull ImageView imageView, @NonNull TypingDots typingDots, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView, @NonNull FlexboxLayout flexboxLayout) {
        this.f713a = selectComponentView;
        this.f714b = imageView;
        this.f715c = typingDots;
        this.f716d = simpleDraweeView;
        this.f717e = materialTextView;
        this.f718f = flexboxLayout;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C0925b5 m197a(@NonNull View view) {
        int i = C5419R.id.select_component_chevron;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.select_component_chevron);
        if (imageView != null) {
            i = C5419R.id.select_component_loading;
            TypingDots typingDots = (TypingDots) view.findViewById(C5419R.id.select_component_loading);
            if (typingDots != null) {
                i = C5419R.id.select_component_selection_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.select_component_selection_icon);
                if (simpleDraweeView != null) {
                    i = C5419R.id.select_component_selection_text;
                    MaterialTextView materialTextView = (MaterialTextView) view.findViewById(C5419R.id.select_component_selection_text);
                    if (materialTextView != null) {
                        i = C5419R.id.select_component_selections_root;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(C5419R.id.select_component_selections_root);
                        if (flexboxLayout != null) {
                            return new C0925b5((SelectComponentView) view, imageView, typingDots, simpleDraweeView, materialTextView, flexboxLayout);
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
        return this.f713a;
    }
}
