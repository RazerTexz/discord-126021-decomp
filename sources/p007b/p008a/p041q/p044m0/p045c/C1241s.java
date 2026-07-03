package p007b.p008a.p041q.p044m0.p045c;

import androidx.annotation.NonNull;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.hammerandchisel.libdiscord.Discord;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.s */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1241s implements Discord.GetVideoInputDevicesCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Function1 f1755a;

    public C1241s(Function1 function1) {
        this.f1755a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetVideoInputDevicesCallback
    public final /* synthetic */ void onDevices(@NonNull VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        C12238m.checkNotNullParameter(videoInputDeviceDescriptionArr, "p0");
        C12238m.checkNotNullExpressionValue(this.f1755a.invoke(videoInputDeviceDescriptionArr), "invoke(...)");
    }
}
