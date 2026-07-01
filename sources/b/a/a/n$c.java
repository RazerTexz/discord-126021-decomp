package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n$c extends d0.z.d.k implements Function1<View, b.a.i.l> {
    public static final n$c j = new n$c();

    public n$c() {
        super(1, b.a.i.l.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b.a.i.l invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.dialog_cancel;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.dialog_cancel);
        if (materialButton != null) {
            i = R$id.dialog_selections;
            MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(R$id.dialog_selections);
            if (maxHeightRecyclerView != null) {
                i = R$id.dialog_title;
                TextView textView = (TextView) view2.findViewById(R$id.dialog_title);
                if (textView != null) {
                    return new b.a.i.l((LinearLayout) view2, materialButton, maxHeightRecyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
