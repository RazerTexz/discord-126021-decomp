package com.discord.utilities;

import android.content.Context;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import d0.y.b;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$2 extends o implements Function1<Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap$CloseableBitmaps>, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareUtils$updateDirectShareTargets$2(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap$CloseableBitmaps> pair) throws IOException {
        invoke2((Pair<? extends List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap$CloseableBitmaps>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<? extends List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap$CloseableBitmaps> pair) throws IOException {
        List<Pair<ChannelShortcutInfo, String>> listComponent1 = pair.component1();
        MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmapsComponent2 = pair.component2();
        try {
            ShareUtils shareUtils = ShareUtils.INSTANCE;
            m.checkNotNullExpressionValue(listComponent1, "channelAndIconUriPairs");
            Context context = this.$context;
            m.checkNotNullExpressionValue(mGImagesBitmap$CloseableBitmapsComponent2, "iconBitmaps");
            ShareUtils.access$updateDynamicShortcuts(shareUtils, listComponent1, context, mGImagesBitmap$CloseableBitmapsComponent2);
            b.closeFinally(mGImagesBitmap$CloseableBitmapsComponent2, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.closeFinally(mGImagesBitmap$CloseableBitmapsComponent2, th);
                throw th2;
            }
        }
    }
}
