package b.a.q.m0.c;

import androidx.annotation.NonNull;
import co.discord.media_engine.DeviceDescription4;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Discord.GetVideoInputDevicesCallback {
    public final /* synthetic */ Function1 a;

    public s(Function1 function1) {
        this.a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetVideoInputDevicesCallback
    public final /* synthetic */ void onDevices(@NonNull DeviceDescription4[] deviceDescription4Arr) {
        Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "p0");
        Intrinsics3.checkNotNullExpressionValue(this.a.invoke(deviceDescription4Arr), "invoke(...)");
    }
}
