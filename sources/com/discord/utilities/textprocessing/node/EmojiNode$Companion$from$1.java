package com.discord.utilities.textprocessing.node;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiNode$Companion$from$1 extends AbstractC12240o implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ String $codePoints;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode$Companion$from$1(String str) {
        super(3);
        this.$codePoints = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        C12238m.checkNotNullParameter(context, "context");
        String imageUri = ModelEmojiUnicode.getImageUri(this.$codePoints, context);
        C12238m.checkNotNullExpressionValue(imageUri, "ModelEmojiUnicode.getImageUri(codePoints, context)");
        return imageUri;
    }
}
