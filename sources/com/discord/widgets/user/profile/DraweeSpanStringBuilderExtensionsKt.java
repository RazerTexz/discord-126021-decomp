package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import b.f.g.a.a.b;
import b.f.g.a.a.d;
import b.f.g.e.v;
import b.f.g.f.a;
import b.f.g.f.c;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;

/* JADX INFO: compiled from: DraweeSpanStringBuilderExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DraweeSpanStringBuilderExtensionsKt {
    /* JADX WARN: Type inference failed for: r0v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public static final DraweeSpanStringBuilder setAvatar(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, @ColorInt Integer num2, Character ch) {
        m.checkNotNullParameter(draweeSpanStringBuilder, "$this$setAvatar");
        m.checkNotNullParameter(context, "context");
        if (str != null) {
            int length = draweeSpanStringBuilder.length();
            draweeSpanStringBuilder.append("#");
            draweeSpanStringBuilder.append((CharSequence) String.valueOf(ch));
            int iIntValue = num != null ? num.intValue() : DimenUtils.dpToPixels(16);
            ?? A = MGImages.getImageRequest(str, IconUtils.getMediaProxySize(iIntValue), IconUtils.getMediaProxySize(iIntValue), true).a();
            d dVarA = b.a();
            dVarA.h = A;
            dVarA.m = z2;
            c cVar = new c();
            cVar.f523b = true;
            cVar.a = 1;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                m.checkNotNullExpressionValue(cVar, "roundingParams");
                cVar.b(iIntValue2);
            }
            a aVar = new a(context.getResources());
            aVar.f = ContextCompat.getDrawable(context, 2131230953);
            aVar.r = cVar;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            aVar.n = v.l;
            draweeSpanStringBuilder.c(context, aVar.a(), dVarA.a(), length, length, iIntValue, iIntValue, false, 2);
        }
        return draweeSpanStringBuilder;
    }

    public static /* synthetic */ DraweeSpanStringBuilder setAvatar$default(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, Integer num2, Character ch, int i, Object obj) {
        return setAvatar(draweeSpanStringBuilder, context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num, (i & 16) == 0 ? num2 : null, (i & 32) != 0 ? ' ' : ch);
    }
}
