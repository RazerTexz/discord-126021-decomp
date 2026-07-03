package com.discord.widgets.voice.sheet;

import android.graphics.Bitmap;
import com.discord.utilities.colors.RepresentativeColorsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderUser$onConfigure$1 extends AbstractC12240o implements Function2<Bitmap, String, Unit> {
    public final /* synthetic */ String $colorId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderUser$onConfigure$1(String str) {
        super(2);
        this.$colorId = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, String str) {
        invoke2(bitmap, str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap bitmap, String str) {
        C12238m.checkNotNullParameter(bitmap, "bitmap");
        RepresentativeColorsKt.getUserRepresentativeColors().handleBitmap(this.$colorId, bitmap, str);
    }
}
