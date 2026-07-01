package b.a.y;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.BottomSheetSimpleSelectorBinding;
import b.a.i.BottomSheetSimpleSelectorItemBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import d0.Tuples;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.y.b0, reason: use source file name */
/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectorBottomSheet extends AppBottomSheet implements SelectorBottomSheet5 {
    public static final /* synthetic */ KProperty[] j = {outline.d0(SelectorBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onSelectedListener;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.y.b0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SelectorBottomSheet.kt */
    public static final class Companion {

        /* JADX INFO: renamed from: b.a.y.b0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SelectorBottomSheet.kt */
        public static final class C0023a extends Lambda implements Function1<Integer, Unit> {
            public static final C0023a j = new C0023a();

            public C0023a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                num.intValue();
                return Unit.a;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SelectorBottomSheet b(Companion companion, FragmentManager fragmentManager, String str, List list, boolean z2, Function1 function1, int i) {
            boolean z3 = (i & 8) != 0 ? true : z2;
            if ((i & 16) != 0) {
                function1 = C0023a.j;
            }
            return companion.a(fragmentManager, str, list, z3, function1);
        }

        public final SelectorBottomSheet a(FragmentManager fragmentManager, String str, List<SelectorBottomSheet2> list, boolean z2, Function1<? super Integer, Unit> function1) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(str, "title");
            Intrinsics3.checkNotNullParameter(list, "options");
            Intrinsics3.checkNotNullParameter(function1, "onSelectedListener");
            SelectorBottomSheet selectorBottomSheet = new SelectorBottomSheet();
            selectorBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("simple_bottom_sheet_title", str), Tuples.to("simple_bottom_sheet_options", list), Tuples.to("simple_bottom_sheet_show_dividers", Boolean.valueOf(z2))));
            selectorBottomSheet.onSelectedListener = function1;
            selectorBottomSheet.show(fragmentManager, Reflection2.getOrCreateKotlinClass(SelectorBottomSheet.class).toString());
            return selectorBottomSheet;
        }
    }

    /* JADX INFO: renamed from: b.a.y.b0$b */
    /* JADX INFO: compiled from: SelectorBottomSheet.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, BottomSheetSimpleSelectorBinding> {
        public static final b j = new b();

        public b() {
            super(1, BottomSheetSimpleSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public BottomSheetSimpleSelectorBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.widget_simple_bottom_sheet_selector_header;
            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.widget_simple_bottom_sheet_selector_header);
            if (constraintLayout != null) {
                i = R.id.widget_simple_bottom_sheet_selector_placeholder;
                TextView textView = (TextView) view2.findViewById(R.id.widget_simple_bottom_sheet_selector_placeholder);
                if (textView != null) {
                    i = R.id.widget_simple_bottom_sheet_selector_recycler;
                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(R.id.widget_simple_bottom_sheet_selector_recycler);
                    if (maxHeightRecyclerView != null) {
                        return new BottomSheetSimpleSelectorBinding((ConstraintLayout) view2, constraintLayout, textView, maxHeightRecyclerView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.y.b0$c */
    /* JADX INFO: compiled from: SelectorBottomSheet.kt */
    public static final class c extends Lambda implements Function2<LayoutInflater, ViewGroup, SelectorBottomSheet4> {
        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public SelectorBottomSheet4 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            Intrinsics3.checkNotNullParameter(layoutInflater2, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
            View viewInflate = layoutInflater2.inflate(R.layout.bottom_sheet_simple_selector_item, viewGroup2, false);
            int i = R.id.select_component_sheet_item_description;
            MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_description);
            if (materialTextView != null) {
                i = R.id.select_component_sheet_item_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.select_component_sheet_item_icon);
                if (simpleDraweeView != null) {
                    i = R.id.select_component_sheet_item_title;
                    MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_title);
                    if (materialTextView2 != null) {
                        BottomSheetSimpleSelectorItemBinding bottomSheetSimpleSelectorItemBinding = new BottomSheetSimpleSelectorItemBinding((ConstraintLayout) viewInflate, materialTextView, simpleDraweeView, materialTextView2);
                        Intrinsics3.checkNotNullExpressionValue(bottomSheetSimpleSelectorItemBinding, "BottomSheetSimpleSelecto…(inflater, parent, false)");
                        SelectorBottomSheet selectorBottomSheet = SelectorBottomSheet.this;
                        Dialog dialogRequireDialog = selectorBottomSheet.requireDialog();
                        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
                        return new SelectorBottomSheet4(selectorBottomSheet, dialogRequireDialog, bottomSheetSimpleSelectorItemBinding);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }

    public SelectorBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    @Override // b.a.y.SelectorBottomSheet5
    public void c(int position) {
        Function1<? super Integer, Unit> function1 = this.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(position));
        }
    }

    public final BottomSheetSimpleSelectorBinding g() {
        return (BottomSheetSimpleSelectorBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.bottom_sheet_simple_selector;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
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
        Intrinsics3.checkNotNullParameter(view, "view");
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
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetSimpleBottomSheetSelectorPlaceholder");
        textView.setText(string);
        ConstraintLayout constraintLayout = g().f88b;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.widgetSimpleBottomSheetSelectorHeader");
        constraintLayout.setVisibility((string == null || string.length() == 0) ^ true ? 0 : 8);
        if (list != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = g().d;
            Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSimpleBottomSheetSelectorRecycler");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(list, new c()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = g().d;
            RecyclerView.Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            if (z2) {
                SimpleRecyclerAdapter.INSTANCE.addThemedDivider(maxHeightRecyclerView2);
            }
        }
    }
}
