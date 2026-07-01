package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import b.f.g.e.v;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import b.f.g.f.RoundingParams;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: DraweeSpanStringBuilderExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DraweeSpanStringBuilderExtensions {
    /* JADX WARN: Type inference failed for: r0v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public static final DraweeSpanStringBuilder setAvatar(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, @ColorInt Integer num2, Character ch) {
        Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, "$this$setAvatar");
        Intrinsics3.checkNotNullParameter(context, "context");
        if (str != null) {
            int length = draweeSpanStringBuilder.length();
            draweeSpanStringBuilder.append("#");
            draweeSpanStringBuilder.append((CharSequence) String.valueOf(ch));
            int iIntValue = num != null ? num.intValue() : DimenUtils.dpToPixels(16);
            ?? A = MGImages.getImageRequest(str, IconUtils.getMediaProxySize(iIntValue), IconUtils.getMediaProxySize(iIntValue), true).a();
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
            pipelineDraweeControllerBuilderA.h = A;
            pipelineDraweeControllerBuilderA.m = z2;
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.f523b = true;
            roundingParams.a = 1;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                Intrinsics3.checkNotNullExpressionValue(roundingParams, "roundingParams");
                roundingParams.b(iIntValue2);
            }
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
            genericDraweeHierarchyBuilder.f = ContextCompat.getDrawable(context, R.drawable.asset_default_avatar_32dp);
            genericDraweeHierarchyBuilder.r = roundingParams;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            genericDraweeHierarchyBuilder.n = v.l;
            draweeSpanStringBuilder.c(context, genericDraweeHierarchyBuilder.a(), pipelineDraweeControllerBuilderA.a(), length, length, iIntValue, iIntValue, false, 2);
        }
        return draweeSpanStringBuilder;
    }
}
