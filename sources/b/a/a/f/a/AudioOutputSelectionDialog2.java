package b.a.a.f.a;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.f.a.b, reason: use source file name */
/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioOutputSelectionDialog2 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ AudioOutputSelectionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioOutputSelectionDialog2(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        super(1);
        this.this$0 = audioOutputSelectionDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Long l) {
        this.this$0.requireDialog().cancel();
        return Unit.a;
    }
}
