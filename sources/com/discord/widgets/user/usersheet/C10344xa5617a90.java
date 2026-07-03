package com.discord.widgets.user.usersheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p009a.C0832i;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1 */
/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10344xa5617a90 extends AbstractC12240o implements Function3<String, Integer, String, Unit> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10344xa5617a90(WidgetUserSheet widgetUserSheet) {
        super(3);
        this.this$0 = widgetUserSheet;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.f27425a;
    }

    public final void invoke(String str, int i, String str2) {
        C12238m.checkNotNullParameter(str, "username");
        C0832i.Companion companion = C0832i.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Objects.requireNonNull(companion);
        C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(str, "username");
        C0832i c0832i = new C0832i();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_USERNAME", str);
        bundle.putInt("ARG_THEMED_PLATFORM_IMAGE_RES", i);
        bundle.putString("ARG_PROFILE_URL", str2);
        c0832i.setArguments(bundle);
        c0832i.show(parentFragmentManager, C0832i.class.getName());
    }
}
