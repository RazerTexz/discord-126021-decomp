package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import p007b.p109f.p132g.p133a.p134a.C1731b;
import p007b.p109f.p132g.p133a.p134a.C1733d;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p143f.C1793a;
import p007b.p109f.p132g.p143f.C1795c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DraweeSpanStringBuilderExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DraweeSpanStringBuilderExtensionsKt {
    /* JADX WARN: Type inference failed for: r0v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public static final DraweeSpanStringBuilder setAvatar(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, @ColorInt Integer num2, Character ch) {
        C12238m.checkNotNullParameter(draweeSpanStringBuilder, "$this$setAvatar");
        C12238m.checkNotNullParameter(context, "context");
        if (str != null) {
            int length = draweeSpanStringBuilder.length();
            draweeSpanStringBuilder.append("#");
            draweeSpanStringBuilder.append((CharSequence) String.valueOf(ch));
            int iIntValue = num != null ? num.intValue() : DimenUtils.dpToPixels(16);
            ?? M8724a = MGImages.getImageRequest(str, IconUtils.getMediaProxySize(iIntValue), IconUtils.getMediaProxySize(iIntValue), true).m8724a();
            C1733d c1733dM1037a = C1731b.m1037a();
            c1733dM1037a.f19484h = M8724a;
            c1733dM1037a.f19489m = z2;
            C1795c c1795c = new C1795c();
            c1795c.f3472b = true;
            c1795c.f3471a = 1;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                C12238m.checkNotNullExpressionValue(c1795c, "roundingParams");
                c1795c.m1125b(iIntValue2);
            }
            C1793a c1793a = new C1793a(context.getResources());
            c1793a.f3456f = ContextCompat.getDrawable(context, C5419R.drawable.asset_default_avatar_32dp);
            c1793a.f3468r = c1795c;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
            c1793a.f3464n = C1788v.f3446l;
            draweeSpanStringBuilder.m8686c(context, c1793a.m1122a(), c1733dM1037a.m8667a(), length, length, iIntValue, iIntValue, false, 2);
        }
        return draweeSpanStringBuilder;
    }
}
