package b.a.q.m0.c;

import androidx.annotation.NonNull;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.hammerandchisel.libdiscord.Discord$GetVideoInputDevicesCallback;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Discord$GetVideoInputDevicesCallback {
    public final /* synthetic */ Function1 a;

    public s(Function1 function1) {
        this.a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$GetVideoInputDevicesCallback
    public final /* synthetic */ void onDevices(@NonNull VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        d0.z.d.m.checkNotNullParameter(videoInputDeviceDescriptionArr, "p0");
        d0.z.d.m.checkNotNullExpressionValue(this.a.invoke(videoInputDeviceDescriptionArr), "invoke(...)");
    }
}
