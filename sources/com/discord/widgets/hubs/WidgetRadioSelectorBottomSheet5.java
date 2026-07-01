package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.R;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.IconRow;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet5 extends Lambda implements Function0<SimpleRecyclerAdapter<WidgetRadioSelectorBottomSheet2, WidgetRadioSelectorBottomSheet4>> {
    public final /* synthetic */ WidgetRadioSelectorBottomSheet this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetRadioSelectorBottomSheet4> {

        /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
        public static final class C02991 extends Lambda implements Function1<Integer, Unit> {
            public C02991() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                Function1<Integer, Unit> onSelected = WidgetRadioSelectorBottomSheet5.this.this$0.getOnSelected();
                if (onSelected != null) {
                    onSelected.invoke(Integer.valueOf(i));
                }
                WidgetRadioSelectorBottomSheet5.this.this$0.dismiss();
            }
        }

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final WidgetRadioSelectorBottomSheet4 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(layoutInflater, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            View viewInflate = layoutInflater.inflate(R.layout.widget_radio_selector_view_holder, viewGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            IconRow iconRow = (IconRow) viewInflate;
            WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding = new WidgetRadioSelectorViewHolderBinding(iconRow, iconRow);
            Intrinsics3.checkNotNullExpressionValue(widgetRadioSelectorViewHolderBinding, "WidgetRadioSelectorViewH…(inflater, parent, false)");
            return new WidgetRadioSelectorBottomSheet4(widgetRadioSelectorViewHolderBinding, new C02991());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRadioSelectorBottomSheet5(WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet) {
        super(0);
        this.this$0 = widgetRadioSelectorBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SimpleRecyclerAdapter<WidgetRadioSelectorBottomSheet2, WidgetRadioSelectorBottomSheet4> invoke() {
        return new SimpleRecyclerAdapter<>(this.this$0.getArgs().getItems(), new AnonymousClass1());
    }
}
