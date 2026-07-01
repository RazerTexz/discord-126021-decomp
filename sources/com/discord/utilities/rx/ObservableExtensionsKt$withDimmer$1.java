package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.dimmer.DimmerView;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$withDimmer$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ DimmerView $dimmer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableExtensionsKt$withDimmer$1(DimmerView dimmerView) {
        super(1);
        this.$dimmer = dimmerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        DimmerView dimmerView = this.$dimmer;
        if (dimmerView != null) {
            DimmerView.setDimmed$default(dimmerView, z2, false, 2, null);
        }
    }
}
