package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.i.ViewGuildBinding;
import b.f.g.f.RoundingParams;
import com.discord.R;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GuildView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewGuildBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int targetImageSize;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int textSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_guild, this);
        int i = R.id.guild_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.guild_avatar);
        if (simpleDraweeView != null) {
            i = R.id.guild_text;
            TextView textView = (TextView) findViewById(R.id.guild_text);
            if (textView != null) {
                ViewGuildBinding viewGuildBinding = new ViewGuildBinding(this, simpleDraweeView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewGuildBinding, "ViewGuildBinding.inflate…ater.from(context), this)");
                this.binding = viewGuildBinding;
                this.targetImageSize = -1;
                this.textSize = -1;
                setClipToOutline(true);
                setBackgroundResource(R.drawable.drawable_squircle_transparent);
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.GuildView, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.GuildView, 0, 0)");
                    try {
                        this.targetImageSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                        this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable th) {
                        typedArrayObtainStyledAttributes.recycle();
                        throw th;
                    }
                }
                int i2 = this.textSize;
                if (i2 != -1) {
                    textView.setTextSize(0, i2);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final void setRoundingParams(RoundingParams roundingParams) {
        SimpleDraweeView simpleDraweeView = this.binding.f146b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        Intrinsics3.checkNotNullExpressionValue(hierarchy, "binding.guildAvatar.hierarchy");
        hierarchy.s(roundingParams);
    }

    public final void a(String iconUrl, String shortGuildName) {
        boolean z2 = iconUrl != null;
        int i = this.targetImageSize;
        int mediaProxySize = i != -1 ? IconUtils.getMediaProxySize(i) : 0;
        SimpleDraweeView simpleDraweeView = this.binding.f146b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        if (!z2) {
            iconUrl = IconUtils.DEFAULT_ICON_BLURPLE;
        }
        MGImages.setImage$default(simpleDraweeView, iconUrl, mediaProxySize, mediaProxySize, false, null, null, 112, null);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildText");
        textView.setVisibility(true ^ z2 ? 0 : 8);
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildText");
        textView2.setText(shortGuildName);
    }

    public final void b() {
        RoundingParams roundingParamsA = RoundingParams.a(getResources().getDimensionPixelSize(R.dimen.guild_icon_radius));
        Intrinsics3.checkNotNullExpressionValue(roundingParamsA, "RoundingParams.fromCorne…d_icon_radius).toFloat())");
        setRoundingParams(roundingParamsA);
    }
}
