package b.a.d;

import com.discord.stores.StoreStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h$g extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ boolean $hadPermissions;
    public final /* synthetic */ Function0 $onSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$g(boolean z2, Function0 function0) {
        super(0);
        this.$hadPermissions = z2;
        this.$onSuccess = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (!this.$hadPermissions) {
            StoreStream.Companion.getMediaEngine().handleMicrophonePermissionGranted();
        }
        StoreStream.Companion.getMediaEngine().setAudioInputEnabled(true);
        this.$onSuccess.invoke();
        return Unit.a;
    }
}
