package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.C5419R;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.IconRow;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet$adapter$2 extends AbstractC12240o implements Function0<SimpleRecyclerAdapter<RadioSelectorItem, RadioSelectorViewHolder>> {
    public final /* synthetic */ WidgetRadioSelectorBottomSheet this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2$1 */
    /* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
    public static final class C90481 extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, RadioSelectorViewHolder> {

        /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f27425a;
            }

            public final void invoke(int i) {
                Function1<Integer, Unit> onSelected = WidgetRadioSelectorBottomSheet$adapter$2.this.this$0.getOnSelected();
                if (onSelected != null) {
                    onSelected.invoke(Integer.valueOf(i));
                }
                WidgetRadioSelectorBottomSheet$adapter$2.this.this$0.dismiss();
            }
        }

        public C90481() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final RadioSelectorViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            C12238m.checkNotNullParameter(layoutInflater, "inflater");
            C12238m.checkNotNullParameter(viewGroup, "parent");
            View viewInflate = layoutInflater.inflate(C5419R.layout.widget_radio_selector_view_holder, viewGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            IconRow iconRow = (IconRow) viewInflate;
            WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding = new WidgetRadioSelectorViewHolderBinding(iconRow, iconRow);
            C12238m.checkNotNullExpressionValue(widgetRadioSelectorViewHolderBinding, "WidgetRadioSelectorViewH…(inflater, parent, false)");
            return new RadioSelectorViewHolder(widgetRadioSelectorViewHolderBinding, new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRadioSelectorBottomSheet$adapter$2(WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet) {
        super(0);
        this.this$0 = widgetRadioSelectorBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SimpleRecyclerAdapter<RadioSelectorItem, RadioSelectorViewHolder> invoke() {
        return new SimpleRecyclerAdapter<>(this.this$0.getArgs().getItems(), new C90481());
    }
}
