package b.a.y;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import java.io.Serializable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends AppBottomSheet implements i {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(b0.class, "binding", "getBinding()Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0)};
    public static final b0$a k = new b0$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onSelectedListener;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public b0() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b0$b.j, null, 2, null);
    }

    @Override // b.a.y.i
    public void c(int position) {
        Function1<? super Integer, Unit> function1 = this.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(position));
        }
    }

    public final b.a.i.c g() {
        return (b.a.i.c) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.bottom_sheet_simple_selector;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        d0.z.d.m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.onSelectedListener = null;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString("simple_bottom_sheet_title");
        Serializable serializable = getArgumentsOrDefault().getSerializable("simple_bottom_sheet_options");
        if (!(serializable instanceof List)) {
            serializable = null;
        }
        List list = (List) serializable;
        boolean z2 = getArgumentsOrDefault().getBoolean("simple_bottom_sheet_show_dividers");
        TextView textView = g().c;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.widgetSimpleBottomSheetSelectorPlaceholder");
        textView.setText(string);
        ConstraintLayout constraintLayout = g().f88b;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.widgetSimpleBottomSheetSelectorHeader");
        constraintLayout.setVisibility((string == null || string.length() == 0) ^ true ? 0 : 8);
        if (list != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = g().d;
            d0.z.d.m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSimpleBottomSheetSelectorRecycler");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(list, new b0$c(this)));
            MaxHeightRecyclerView maxHeightRecyclerView2 = g().d;
            RecyclerView$Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            if (z2) {
                SimpleRecyclerAdapter.Companion.addThemedDivider(maxHeightRecyclerView2);
            }
        }
    }
}
