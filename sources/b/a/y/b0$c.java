package b.a.y;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b0$c extends d0.z.d.o implements Function2<LayoutInflater, ViewGroup, e0> {
    public final /* synthetic */ b0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0$c(b0 b0Var) {
        super(2);
        this.this$0 = b0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public e0 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        d0.z.d.m.checkNotNullParameter(layoutInflater2, "inflater");
        d0.z.d.m.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(R$layout.bottom_sheet_simple_selector_item, viewGroup2, false);
        int i = R$id.select_component_sheet_item_description;
        MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(R$id.select_component_sheet_item_description);
        if (materialTextView != null) {
            i = R$id.select_component_sheet_item_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.select_component_sheet_item_icon);
            if (simpleDraweeView != null) {
                i = R$id.select_component_sheet_item_title;
                MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(R$id.select_component_sheet_item_title);
                if (materialTextView2 != null) {
                    b.a.i.d dVar = new b.a.i.d((ConstraintLayout) viewInflate, materialTextView, simpleDraweeView, materialTextView2);
                    d0.z.d.m.checkNotNullExpressionValue(dVar, "BottomSheetSimpleSelecto…(inflater, parent, false)");
                    b0 b0Var = this.this$0;
                    Dialog dialogRequireDialog = b0Var.requireDialog();
                    d0.z.d.m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
                    return new e0(b0Var, dialogRequireDialog, dVar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
