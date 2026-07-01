package com.discord.utilities.textprocessing.node;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.node.EmojiNode$Companion$from$1, reason: use source file name */
/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiNode2 extends Lambda implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ String $codePoints;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode2(String str) {
        super(3);
        this.$codePoints = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String imageUri = ModelEmojiUnicode.getImageUri(this.$codePoints, context);
        Intrinsics3.checkNotNullExpressionValue(imageUri, "ModelEmojiUnicode.getImageUri(codePoints, context)");
        return imageUri;
    }
}
