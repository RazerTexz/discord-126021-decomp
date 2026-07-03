package p007b.p008a.p062y;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import java.io.Serializable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0927c;
import p007b.p008a.p025i.C0935d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.b0 */
/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1322b0 extends AppBottomSheet implements InterfaceC1335i {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f2008j = {C1643a.m846d0(C1322b0.class, "binding", "getBinding()Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0)};

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
        public static final class C13218a extends AbstractC12240o implements Function1<Integer, Unit> {

            /* JADX INFO: renamed from: j */
            public static final C13218a f2012j = new C13218a();

            public C13218a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                num.intValue();
                return Unit.f27425a;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: b */
        public static /* synthetic */ C1322b0 m378b(Companion companion, FragmentManager fragmentManager, String str, List list, boolean z2, Function1 function1, int i) {
            boolean z3 = (i & 8) != 0 ? true : z2;
            if ((i & 16) != 0) {
                function1 = C13218a.f2012j;
            }
            return companion.m379a(fragmentManager, str, list, z3, function1);
        }

        /* JADX INFO: renamed from: a */
        public final C1322b0 m379a(FragmentManager fragmentManager, String str, List<C1324c0> list, boolean z2, Function1<? super Integer, Unit> function1) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(str, "title");
            C12238m.checkNotNullParameter(list, "options");
            C12238m.checkNotNullParameter(function1, "onSelectedListener");
            C1322b0 c1322b0 = new C1322b0();
            c1322b0.setArguments(BundleKt.bundleOf(C12116o.m10073to("simple_bottom_sheet_title", str), C12116o.m10073to("simple_bottom_sheet_options", list), C12116o.m10073to("simple_bottom_sheet_show_dividers", Boolean.valueOf(z2))));
            c1322b0.onSelectedListener = function1;
            c1322b0.show(fragmentManager, C12216a0.getOrCreateKotlinClass(C1322b0.class).toString());
            return c1322b0;
        }
    }

    /* JADX INFO: renamed from: b.a.y.b0$b */
    /* JADX INFO: compiled from: SelectorBottomSheet.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C0927c> {

        /* JADX INFO: renamed from: j */
        public static final b f2013j = new b();

        public b() {
            super(1, C0927c.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0927c invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.widget_simple_bottom_sheet_selector_header;
            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(C5419R.id.widget_simple_bottom_sheet_selector_header);
            if (constraintLayout != null) {
                i = C5419R.id.widget_simple_bottom_sheet_selector_placeholder;
                TextView textView = (TextView) view2.findViewById(C5419R.id.widget_simple_bottom_sheet_selector_placeholder);
                if (textView != null) {
                    i = C5419R.id.widget_simple_bottom_sheet_selector_recycler;
                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(C5419R.id.widget_simple_bottom_sheet_selector_recycler);
                    if (maxHeightRecyclerView != null) {
                        return new C0927c((ConstraintLayout) view2, constraintLayout, textView, maxHeightRecyclerView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.y.b0$c */
    /* JADX INFO: compiled from: SelectorBottomSheet.kt */
    public static final class c extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, C1328e0> {
        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public C1328e0 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            C12238m.checkNotNullParameter(layoutInflater2, "inflater");
            C12238m.checkNotNullParameter(viewGroup2, "parent");
            View viewInflate = layoutInflater2.inflate(C5419R.layout.bottom_sheet_simple_selector_item, viewGroup2, false);
            int i = C5419R.id.select_component_sheet_item_description;
            MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(C5419R.id.select_component_sheet_item_description);
            if (materialTextView != null) {
                i = C5419R.id.select_component_sheet_item_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.select_component_sheet_item_icon);
                if (simpleDraweeView != null) {
                    i = C5419R.id.select_component_sheet_item_title;
                    MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(C5419R.id.select_component_sheet_item_title);
                    if (materialTextView2 != null) {
                        C0935d c0935d = new C0935d((ConstraintLayout) viewInflate, materialTextView, simpleDraweeView, materialTextView2);
                        C12238m.checkNotNullExpressionValue(c0935d, "BottomSheetSimpleSelecto…(inflater, parent, false)");
                        C1322b0 c1322b0 = C1322b0.this;
                        Dialog dialogRequireDialog = c1322b0.requireDialog();
                        C12238m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
                        return new C1328e0(c1322b0, dialogRequireDialog, c0935d);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }

    public C1322b0() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f2013j, null, 2, null);
    }

    @Override // p007b.p008a.p062y.InterfaceC1335i
    /* JADX INFO: renamed from: c */
    public void mo376c(int position) {
        Function1<? super Integer, Unit> function1 = this.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(position));
        }
    }

    /* JADX INFO: renamed from: g */
    public final C0927c m377g() {
        return (C0927c) this.binding.getValue((Fragment) this, f2008j[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.bottom_sheet_simple_selector;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString("simple_bottom_sheet_title");
        Serializable serializable = getArgumentsOrDefault().getSerializable("simple_bottom_sheet_options");
        if (!(serializable instanceof List)) {
            serializable = null;
        }
        List list = (List) serializable;
        boolean z2 = getArgumentsOrDefault().getBoolean("simple_bottom_sheet_show_dividers");
        TextView textView = m377g().f724c;
        C12238m.checkNotNullExpressionValue(textView, "binding.widgetSimpleBottomSheetSelectorPlaceholder");
        textView.setText(string);
        ConstraintLayout constraintLayout = m377g().f723b;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.widgetSimpleBottomSheetSelectorHeader");
        constraintLayout.setVisibility((string == null || string.length() == 0) ^ true ? 0 : 8);
        if (list != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = m377g().f725d;
            C12238m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSimpleBottomSheetSelectorRecycler");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(list, new c()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = m377g().f725d;
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
