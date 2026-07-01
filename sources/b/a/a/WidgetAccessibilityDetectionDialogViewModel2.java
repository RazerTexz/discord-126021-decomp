package b.a.a;

import com.discord.models.domain.ModelUserSettings;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.q, reason: use source file name */
/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetAccessibilityDetectionDialogViewModel2 extends Lambda implements Function1<ModelUserSettings, Unit> {
    public static final WidgetAccessibilityDetectionDialogViewModel2 j = new WidgetAccessibilityDetectionDialogViewModel2();

    public WidgetAccessibilityDetectionDialogViewModel2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ModelUserSettings modelUserSettings) {
        Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        return Unit.a;
    }
}
