package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.i.k2;
import b.f.g.f.c;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final k2 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int targetImageSize;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int textSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_guild, this);
        int i = R$id.guild_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.guild_avatar);
        if (simpleDraweeView != null) {
            i = R$id.guild_text;
            TextView textView = (TextView) findViewById(R$id.guild_text);
            if (textView != null) {
                k2 k2Var = new k2(this, simpleDraweeView, textView);
                m.checkNotNullExpressionValue(k2Var, "ViewGuildBinding.inflate…ater.from(context), this)");
                this.binding = k2Var;
                this.targetImageSize = -1;
                this.textSize = -1;
                setClipToOutline(true);
                setBackgroundResource(2131231317);
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.GuildView, 0, 0);
                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.GuildView, 0, 0)");
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

    private final void setRoundingParams(c roundingParams) {
        SimpleDraweeView simpleDraweeView = this.binding.f146b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        m.checkNotNullExpressionValue(hierarchy, "binding.guildAvatar.hierarchy");
        hierarchy.s(roundingParams);
    }

    public final void a(String iconUrl, String shortGuildName) {
        boolean z2 = iconUrl != null;
        int i = this.targetImageSize;
        int mediaProxySize = i != -1 ? IconUtils.getMediaProxySize(i) : 0;
        SimpleDraweeView simpleDraweeView = this.binding.f146b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        if (!z2) {
            iconUrl = IconUtils.DEFAULT_ICON_BLURPLE;
        }
        MGImages.setImage$default(simpleDraweeView, iconUrl, mediaProxySize, mediaProxySize, false, null, null, 112, null);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildText");
        textView.setVisibility(true ^ z2 ? 0 : 8);
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.guildText");
        textView2.setText(shortGuildName);
    }

    public final void b() {
        c cVarA = c.a(getResources().getDimensionPixelSize(2131165449));
        m.checkNotNullExpressionValue(cVarA, "RoundingParams.fromCorne…d_icon_radius).toFloat())");
        setRoundingParams(cVarA);
    }
}
