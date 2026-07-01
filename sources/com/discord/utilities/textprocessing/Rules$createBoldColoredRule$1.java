package com.discord.utilities.textprocessing;

import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.exifinterface.media.ExifInterface;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createBoldColoredRule$1 extends o implements Function0<List<? extends CharacterStyle>> {
    public final /* synthetic */ int $color;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createBoldColoredRule$1(int i) {
        super(0);
        this.$color = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends CharacterStyle> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends CharacterStyle> invoke2() {
        return n.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StyleSpan(1)});
    }
}
