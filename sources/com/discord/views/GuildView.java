package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.C0991k2;
import p007b.p109f.p132g.p143f.C1795c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildView extends FrameLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19071j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0991k2 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int targetImageSize;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int textSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_guild, this);
        int i = C5419R.id.guild_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.guild_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.guild_text;
            TextView textView = (TextView) findViewById(C5419R.id.guild_text);
            if (textView != null) {
                C0991k2 c0991k2 = new C0991k2(this, simpleDraweeView, textView);
                C12238m.checkNotNullExpressionValue(c0991k2, "ViewGuildBinding.inflate…ater.from(context), this)");
                this.binding = c0991k2;
                this.targetImageSize = -1;
                this.textSize = -1;
                setClipToOutline(true);
                setBackgroundResource(C5419R.drawable.drawable_squircle_transparent);
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.GuildView, 0, 0);
                    C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.GuildView, 0, 0)");
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

    private final void setRoundingParams(C1795c roundingParams) {
        SimpleDraweeView simpleDraweeView = this.binding.f999b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        C12238m.checkNotNullExpressionValue(hierarchy, "binding.guildAvatar.hierarchy");
        hierarchy.m8683s(roundingParams);
    }

    /* JADX INFO: renamed from: a */
    public final void m8545a(String iconUrl, String shortGuildName) {
        boolean z2 = iconUrl != null;
        int i = this.targetImageSize;
        int mediaProxySize = i != -1 ? IconUtils.getMediaProxySize(i) : 0;
        SimpleDraweeView simpleDraweeView = this.binding.f999b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        if (!z2) {
            iconUrl = IconUtils.DEFAULT_ICON_BLURPLE;
        }
        MGImages.setImage$default(simpleDraweeView, iconUrl, mediaProxySize, mediaProxySize, false, null, null, 112, null);
        TextView textView = this.binding.f1000c;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildText");
        textView.setVisibility(true ^ z2 ? 0 : 8);
        TextView textView2 = this.binding.f1000c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildText");
        textView2.setText(shortGuildName);
    }

    /* JADX INFO: renamed from: b */
    public final void m8546b() {
        C1795c c1795cM1124a = C1795c.m1124a(getResources().getDimensionPixelSize(C5419R.dimen.guild_icon_radius));
        C12238m.checkNotNullExpressionValue(c1795cM1124a, "RoundingParams.fromCorne…d_icon_radius).toFloat())");
        setRoundingParams(c1795cM1124a);
    }
}
