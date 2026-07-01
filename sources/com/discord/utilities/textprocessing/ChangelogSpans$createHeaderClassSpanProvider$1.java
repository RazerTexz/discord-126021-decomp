package com.discord.utilities.textprocessing;

import android.content.Context;
import android.text.style.TextAppearanceSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans$createHeaderClassSpanProvider$1 extends o implements Function1<String, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $marginTopPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangelogSpans$createHeaderClassSpanProvider$1(Context context, int i) {
        super(1);
        this.$context = context;
        this.$marginTopPx = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(String str) {
        return invoke2(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String str) {
        m.checkNotNullParameter(str, "className");
        switch (str.hashCode()) {
            case -1269237627:
                if (str.equals("changelogSpecial")) {
                    return new TextAppearanceSpan(this.$context, 2131952041);
                }
                return null;
            case -1044792121:
                if (str.equals("marginTop")) {
                    return new VerticalPaddingSpan(0, this.$marginTopPx);
                }
                return null;
            case -1001078227:
                if (str.equals("progress")) {
                    return new TextAppearanceSpan(this.$context, 2131952039);
                }
                return null;
            case -419685396:
                if (str.equals("improved")) {
                    return new TextAppearanceSpan(this.$context, 2131952038);
                }
                return null;
            case 92659968:
                if (str.equals("added")) {
                    return new TextAppearanceSpan(this.$context, 2131952036);
                }
                return null;
            case 97445748:
                if (str.equals("fixed")) {
                    return new TextAppearanceSpan(this.$context, 2131952037);
                }
                return null;
            default:
                return null;
        }
    }
}
