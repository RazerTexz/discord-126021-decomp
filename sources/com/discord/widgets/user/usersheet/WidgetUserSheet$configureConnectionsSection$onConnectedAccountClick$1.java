package com.discord.widgets.user.usersheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.a.a.i;
import b.a.a.i$b;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1 extends o implements Function3<String, Integer, String, Unit> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1(WidgetUserSheet widgetUserSheet) {
        super(3);
        this.this$0 = widgetUserSheet;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.a;
    }

    public final void invoke(String str, int i, String str2) {
        m.checkNotNullParameter(str, "username");
        i$b i_b = i.k;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Objects.requireNonNull(i_b);
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(str, "username");
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_USERNAME", str);
        bundle.putInt("ARG_THEMED_PLATFORM_IMAGE_RES", i);
        bundle.putString("ARG_PROFILE_URL", str2);
        iVar.setArguments(bundle);
        iVar.show(parentFragmentManager, i.class.getName());
    }
}
