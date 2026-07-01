package com.lytefast.flexinput.fragment;

import android.text.Editable;
import b.i.a.f.e.o.f;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FlexInputFragment$f extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexInputFragment$f(FlexInputFragment flexInputFragment) {
        super(1);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Editable editable) {
        Editable editable2 = editable;
        m.checkNotNullParameter(editable2, "it");
        FlexInputViewModel flexInputViewModel = this.this$0.viewModel;
        if (flexInputViewModel != null) {
            f.P0(flexInputViewModel, editable2.toString(), null, 2, null);
        }
        return Unit.a;
    }
}
