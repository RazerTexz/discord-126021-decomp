package com.lytefast.flexinput.fragment;

import android.widget.Toast;
import b.b.a.h.a;
import b.b.a.h.a$a;
import b.b.a.h.a$b;
import b.b.a.h.a$c;
import b.b.a.h.a$d;
import b.b.a.h.a$e;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class FlexInputFragment$e extends k implements Function1<a, Unit> {
    public FlexInputFragment$e(FlexInputFragment flexInputFragment) {
        super(1, flexInputFragment, FlexInputFragment.class, "handleEvent", "handleEvent(Lcom/lytefast/flexinput/viewmodel/FlexInputEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(a aVar) {
        a aVar2 = aVar;
        m.checkNotNullParameter(aVar2, "p1");
        FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
        KProperty[] kPropertyArr = FlexInputFragment.j;
        Objects.requireNonNull(flexInputFragment);
        if (aVar2 instanceof a$d) {
            Toast.makeText(flexInputFragment.requireContext(), ((a$d) aVar2).a, 0).show();
        } else if (aVar2 instanceof a$e) {
            Toast.makeText(flexInputFragment.requireContext(), ((a$e) aVar2).a, 0).show();
        } else if (aVar2 instanceof a$c) {
            b.b.a.f.a aVar3 = flexInputFragment.keyboardManager;
            if (aVar3 != null) {
                FlexEditText flexEditText = flexInputFragment.inputEt;
                if (flexEditText == null) {
                    m.throwUninitializedPropertyAccessException("inputEt");
                }
                aVar3.requestDisplay(flexEditText);
            }
        } else if (aVar2 instanceof a$b) {
            b.b.a.f.a aVar4 = flexInputFragment.keyboardManager;
            if (aVar4 != null) {
                aVar4.requestHide();
            }
        } else if (aVar2 instanceof a$a) {
            flexInputFragment.j().q.performClick();
        }
        return Unit.a;
    }
}
